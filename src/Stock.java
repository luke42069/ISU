
public class Stock extends Investment{

    private int chance, range;
    
    public Stock(int p, int c,int r,String n) {
        super(p,n);
        name = n;
        chance=c;//chance of growing, 1-4 - 1 is guaranteed growth, 4 means 25% chance
        range = r;//range of growth - smaller the closer chance is to 1
    }

    @Override
    public void grow() {
        if((int)(Math.random()*chance)==chance)
        growth=(int)(Math.random()*range);
        else growth = (int)(Math.random()*-range); 
        curval*=growth;
    }
    
    public String getclass(){
        return "Stock";
    }
    
    
    
    
}
