// CSC212 Word Analysis Tool
// Group 10: Reema AlMansour 442200477
//           Reema AlAngari  442200134
// Section 41196



package WordAnalysisADT;
import java.util.Scanner;



public class Test2 
{
    
    public static void main(String[] args) 
    
    { 	Scanner input = new Scanner (System.in);
    
    boolean x= true;
   
    
    
    	
    	System.out.println("***** WORD ANALYSIS ADT TOOL *****\n");
    	
    	System.out.println("\nEnter file name and extention: ");
    	
    	String file_name = input.next();
    	 
    	 
        WordAnalysisADT  wordADT = new WordAnalysisADT();
        wordADT.readFileAndAnalyse(file_name); 
        
       
        
        System.out.println("The Output of Operation (1) is: " + wordADT.documentLength());
        
        System.out.println("The Output of Operation (2) is: " + wordADT.uniqueWords());
        
        System.out.println("Enter word for Operation (3): ");
        String w = input.next();
        System.out.println("The Output of Operation (3) is: " + wordADT.totalWord(w));
        
        System.out.println("Enter integer for Operation (4): ");
        int i = input.nextInt();
        System.out.println("The Output of Operation (4) is: " + wordADT.totalWordsForLength(i));
        
        System.out.print("The Output of Operation (5) is: ");
        wordADT.displayUniqueWords();
        
        System.out.println("");
        
        System.out.println("Enter word for Operation (6): ");
        String z = input.next();
        
        System.out.print("The Output of Operation (6) is: " );
        
        
        LinkedList <WordOccurrence> list = wordADT.occurrences(z);
        
        if (!list.empty())
        {
        	list.findFirst();
            while (!list.last())
            {
                System.out.print(list.retrieve().toString() + ", ");
                list.findNext();
            }
            System.out.print(list.retrieve().toString()+ ".");
        }
        System.out.println("");
        
        System.out.println("Enter the first word for Operation (7): ");
        String w1 = input.next();
        System.out.println("Enter the second word for Operation (7): ");
        String w2 = input.next();
        System.out.println("The Output of Operation (7) is: " + wordADT.checkAdjacent(w1, w2));
       
    
        
        
        System.out.println("\n***** END OF WORD ANALYSIS *****");
    }
    
}
