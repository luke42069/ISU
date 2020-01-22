
public class Stock extends Investment{

    private final int chance, range;
    private int quantity;//number of stocks
    
    public Stock(int p, int c,int r,String n) {
        super(p,n);
        name = n;
        chance=c;//chance of growing, 1-4 - 1 is guaranteed growth, 4 means 25% chance
        range = r;//range of growth - should be smaller the closer chance is to 1
        
        
    }

    public void setQuantity(int q){
        quantity=q;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    @Override
    public void grow() {
        if((int)(Math.random()*chance)==chance)//determine if its growing by testing the chance
        growth=(Math.random()*range);//grow by max of range
        else growth = (Math.random()*-range); //shrink by max of range
        curval*=growth;//multiply by quantity in jframe code
    }
    
    public String toString(){
        String x = "Type: Stock\n";
         x += name;
        x+="\nPrice: $"+price;
        x+="\nChance of Growing: "+chance*25+"%";
        x+="\nRange of Potential Growth/Loss: $"+range;//
        x+="\nQuantity Owned: "+quantity;
        return x;
    }
    
    
    
    
}
