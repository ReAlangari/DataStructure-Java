// CSC212 Word Analysis Tool
// Group 10: Reema AlMansour 442200477
//           Reema AlAngari  442200134
// Section 41196



package WordAnalysisADT;



public class Test 
{
    
    public static void main(String[] args) 
    
    {
    	
    	
        WordAnalysisADT  wordADT = new WordAnalysisADT();
        wordADT.readFileAndAnalyse("Input.txt"); 
        
        
        
        System.out.println("***** WORD ANALYSIS ADT TOOL *****\n");
        
        System.out.println("The Output of Operation (1) is: " + wordADT.documentLength());
        
        System.out.println("The Output of Operation (2) is: " + wordADT.uniqueWords());
        
        System.out.println("The Output of Operation (3) is: " + wordADT.totalWord("the"));
        
        System.out.println("The Output of Operation (4) is: " + wordADT.totalWordsForLength(2));
        
        System.out.print("The Output of Operation (5) is: ");
        wordADT.displayUniqueWords();
        
        System.out.println("");
        
        System.out.print("The Output of Operation (6) is: " );
        
        
        LinkedList <WordOccurrence> L = wordADT.occurrences("data");
        
        if (!L.empty())
        {
            L.findFirst();
            while ( ! L.last())
            {
                System.out.print(L.retrieve().toString() + ", ");
                L.findNext();
            }
            System.out.print(L.retrieve().toString()+ ".");
        }
        System.out.println("");
        
        
        System.out.println("The Output of Operation (7) is: " + wordADT.checkAdjacent("the", "data"));
        
        System.out.println("\n***** END OF WORD ANALYSIS *****");
    }
    
}
