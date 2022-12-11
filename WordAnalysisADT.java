// CSC212 Word Analysis Tool
// Group 10: Reema AlMansour 442200477
//           Reema AlAngari  442200134
// Section 41196



package WordAnalysisADT;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class WordAnalysisADT 
{
    int n;
    int m ;
    int k = 100;
   
    
    	LinkedList<WordInformation> [] arrayOfDifferentLengths ;
    	WordInformation [] sortedArray;
    	
    	
    	
// Constructor
    	
public WordAnalysisADT()
    {
    }





// Length array
public int Length_Words(String file)
    {
        int max = 0;
       
    try
    {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            String str[] = null;
            
            
            while (line != null)
            {
                str = line.split("[”“?!\",;. ]");  
                for (int i = 0; i < str.length; i++) 
                    if (max < str[i].trim().length())
                        max = str[i].trim().length();
                line = reader.readLine();
            }
            reader.close();
    } 
    
    catch (IOException ex) 
            {
            System.out.println("error");
            }
            max++;
            return max;
    }





// Reading of a text file

    public void readFileAndAnalyse (String f)
    {
               k = Length_Words(f);
               
                arrayOfDifferentLengths =  new LinkedList [k];
                sortedArray = new WordInformation [200];

    try {

                for ( int i = 0 ; i< arrayOfDifferentLengths.length ; i ++)
                    arrayOfDifferentLengths[i] = new LinkedList<WordInformation> ();
                
                BufferedReader reader = new BufferedReader(new FileReader(f));

                int lineNo = 0;
                n =0;
                m =0;
                String line = reader.readLine();
                String str[] = null;
            
                
                while (line != null) 
                {
                    lineNo ++;
                    int position =1;
                    str = line.split("[”“?!\",;. ]");  
                    for (int i = 0; i < str.length; i++) 
                    {
                        boolean linevalue = false;
                        String word = str[i].trim();
                        
                        if (word.contains("\\n"))
                        {
                                 word = word.replace("\\n", "");
                                 linevalue = true;
                        }
                        
                        if (word.equalsIgnoreCase("") != true)   
                         {
                             n++;
                            boolean found = false;
                            
                         
                            if (arrayOfDifferentLengths[word.length()].empty())
                                arrayOfDifferentLengths[word.length()].insert(new WordInformation (word , lineNo, position));
                            else
                            {
                                arrayOfDifferentLengths[word.length()].findFirst();
                                while (! arrayOfDifferentLengths[word.length()].last() && ! found)
                                {
                                    WordInformation data = arrayOfDifferentLengths[word.length()].retrieve();
                                    if (data.word.equalsIgnoreCase(word) == true)
                                    {
                                        data.Add(lineNo, position);
                                        arrayOfDifferentLengths[word.length()].update(data);
                                        found = true;
                                    }
                                    else
                                        arrayOfDifferentLengths[word.length()].findNext();
                                }
                                if ( ! found)
                                {
                                    WordInformation data = arrayOfDifferentLengths[word.length()].retrieve();
                                    if (data.word.equalsIgnoreCase(word) == true)
                                    {
                                        data.Add(lineNo, position);
                                        arrayOfDifferentLengths[word.length()].update(data);
                                        found = true;
                                    }
                                }
                                
                                if (!found )
                                    arrayOfDifferentLengths[word.length()].insert(new WordInformation (word , lineNo, position));
                            }
                           
                            
                            
                            
                            if (!found )
                            {
                                sortedArray[m] = new WordInformation (word , lineNo, position);
                                m++;
                            }
                            else
                            {
                                for ( int x = 0 ; x < m ; x++)
                                    if (sortedArray[x] != null && sortedArray[x].word.equalsIgnoreCase(word) == true)
                                        sortedArray[x].size ++ ;
                            }
                         }
                         position ++ ;
                         if (linevalue)
                         {
                             linevalue =false;
                             lineNo ++ ;
                             position =0 ;
                         }
                    }
                    line = reader.readLine();
                }
                reader.close();
               
                mergesort(0, m-1 );
                
                } 
    catch (IOException ex) 
    {
            System.out.println("error");
     }
       
    
    }
    
    
    
    
    
   // (1) An operation to determine the total number of words in a text file. 
    
public int documentLength  ()
    { 
        return n;
    }
    



    
 // (2) An operation to determine the total number of unique words in a text file.
   
public int uniqueWords  ()
    {
        return m;
    }
    
    


    
 // (3) An operation to determine the total number of occurrences of a particular word.

public int totalWord(String w)
    {
        int count = 0 ;
        if (arrayOfDifferentLengths[w.length()].getsize() > 0)
        {   
            arrayOfDifferentLengths[w.length()].findFirst();
            while (!arrayOfDifferentLengths[w.length()].last())
            {
                if ( arrayOfDifferentLengths[w.length()].retrieve().word.equalsIgnoreCase(w)== true)
                    count = arrayOfDifferentLengths[w.length()].retrieve().size;
                arrayOfDifferentLengths[w.length()].findNext();
            }
            if ( arrayOfDifferentLengths[w.length()].retrieve().word.equalsIgnoreCase(w)== true)
                count = arrayOfDifferentLengths[w.length()].retrieve().size;
        }
        return count;
        
    }
    
    
    


    // (4) An operation to determine the total number of words with a particular length.
     
public int totalWordsForLength (int l)
    {
        return arrayOfDifferentLengths[l].getsize();
    }
    



    
   // (5) An operation to display the unique words and their occurrences.

public void displayUniqueWords  ()
    {
        for ( int i = 0 ; i <m ;  i++)
            System.out.print("(" + sortedArray[i].word +","+sortedArray[i].size +")," );
    }    
    


    

  // (6) An operation to display the locations of the occurrences of a word.
    
public  LinkedList<WordOccurrence> occurrences  (String w)
    {
        
        LinkedList<WordOccurrence> tmp = null;
        
        if ( arrayOfDifferentLengths[w.length()].getsize() > 0)
        {   
            arrayOfDifferentLengths[w.length()].findFirst();
            while (!arrayOfDifferentLengths[w.length()].last())
            {
                if ( arrayOfDifferentLengths[w.length()].retrieve().word.equalsIgnoreCase(w)== true)
                    tmp = arrayOfDifferentLengths[w.length()].retrieve().occList;
                arrayOfDifferentLengths[w.length()].findNext();
            }
            if ( arrayOfDifferentLengths[w.length()].retrieve().word.equalsIgnoreCase(w)== true)
                tmp = arrayOfDifferentLengths[w.length()].retrieve().occList;
        }
        
        return tmp;
    }

    



   // (7) An operation to examine if two words are occurring adjacent to each other in the file. 
    
public boolean checkAdjacent  (String word1, String word2)
   {
	if (word1.equalsIgnoreCase(word2))
    {
       LinkedList<WordOccurrence> w = occurrences(word1);     
       if (w != null  && !w.empty() )
       {
           if (w.getsize() > 1)
           {
                w.findFirst();
                WordOccurrence pos1 = w.retrieve();
                for ( int i = 1; i < w.getsize() ; i++)
                {
                    w.findNext();
                    WordOccurrence pos2 = w.retrieve();
                     if ( pos1.lineNo == pos2.lineNo && (Math.abs(pos2.position - pos1.position) ==1) )
                         return true;
                      pos1=pos2;   
                }
           }
       }
        return false;
    }
	   
	   
           if (( arrayOfDifferentLengths[word1.length()].getsize() ==0) || (arrayOfDifferentLengths[word2.length()].getsize() == 0))
            return false;

        LinkedList<WordOccurrence> W1 = occurrences (word1);
        LinkedList<WordOccurrence> W2 = occurrences (word2);
        
        if ( W1 != null && W2 != null )
        {
            W1.findFirst();
            W2.findFirst();
            
            while ( ! W1.last() && !W2.last())
            {
                    int line1 = W1.retrieve().lineNo;
                    int line2 =W2.retrieve().lineNo;
                    if ( line1 == line2 )
                    {
                        int w_no1 = W1.retrieve().position;
                        int w_no2 =W2.retrieve().position;
                        if (Math.abs(w_no2 - w_no1) == 1)
                            return true;
                        else if (  (w_no2 - w_no1) > 1)
                            W1.findNext();
                        else
                            W2.findNext();
                    }
                    else if ( line1 > line2)
                    {
                        W2.findNext();
                    }
                    else
                    {
                        W1.findNext();
                     }
            }
            
            while ( W1.last() && !W2.last())
            {
                    int line1 = W1.retrieve().lineNo;
                    int line2 =W2.retrieve().lineNo;
                    if ( line1 == line2 )
                    {
                        int w_no1 = W1.retrieve().position;
                        int w_no2 =W2.retrieve().position;
                        if (Math.abs(w_no2 - w_no1) == 1)
                            return true;
                    }
                    W2.findNext();
            }
                    
            while ( !W1.last() && W2.last())
            {
                    int line1 = W1.retrieve().lineNo;
                    int line2 =W2.retrieve().lineNo;
                    if ( line1 == line2 )
                    {
                        int w_no1 = W1.retrieve().position;
                        int w_no2 =W2.retrieve().position;
                        if (Math.abs(w_no2 - w_no1) == 1)
                            return true;
                    }
                    W1.findNext();
            }

            if ( W1.last() && W2.last())
            {
                int line1 = W1.retrieve().lineNo;
                int line2 =W2.retrieve().lineNo;
                if ( line1 == line2 )
                {
                    int w_no1 = W1.retrieve().position;
                    int w_no2 =W2.retrieve().position;
                    if (Math.abs(w_no2 - w_no1) == 1)
                        return true;
                }
            }
        }   
        return false;
     
    }    
 
   
   
   // Merging and Sorting
   
private void mergesort ( int l , int r ) 
    {
        if ( l >= r )
            return;
        int m = ( l + r ) / 2;
        mergesort (l , m ) ;          
        mergesort (m + 1 , r ) ;    
        merge (l , m , r ) ;            
    }

 
private void merge ( int l , int m , int r ) 
    {
        WordInformation [] B = new WordInformation [ r - l + 1];
        int i = l , j = m + 1 , k = 0;
    
        while ( i <= m && j <= r )
        {
            if ( sortedArray[ i ].size >= sortedArray [ j ].size)
                B [ k ++] = sortedArray[ i ++];
            else
                B [ k ++] = sortedArray[ j ++];
        }
        
        if ( i > m )
            while ( j <= r )
                B [ k ++] = sortedArray[ j ++];
        else
            while ( i <= m )
                B [ k ++] = sortedArray[ i ++];
        
        for ( k = 0; k < B . length ; k ++)
            sortedArray[ k + l ] = B [ k ];
    }


    

}