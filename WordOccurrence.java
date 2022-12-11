// CSC212 Word Analysis Tool
// Group 10: Reema AlMansour 442200477
//           Reema AlAngari  442200134
// Section 41196



package WordAnalysisADT;



public class WordOccurrence 
{
    public int lineNo;
    public int position;

    
    
    public WordOccurrence() 
    {
        this.lineNo = 0;
        this.position = 0;
    }

    
    public WordOccurrence(int lineNo, int position) 
    {
        this.lineNo = lineNo;
        this.position = position;
    }

    
    public String toString() 
    {
            return "("+lineNo+","+position+")";
    }

}