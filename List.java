// CSC212 Word Analysis Tool
// Group 10: Reema AlMansour 442200477
//           Reema AlAngari  442200134
// Section 41196



package WordAnalysisADT;



public interface List<T>
{
    
    public void findFirst();
    
    public void findNext();
    
    public T retrieve();
    
    public void update(T t);
    
    public void insert(T t);
    
    public void remove();
    
    public boolean full();
    
    public boolean empty();
    
    public boolean last();
    
    public int getsize();
}

