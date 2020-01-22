
import java.util.ArrayList;


public abstract class Investment implements Comparable{
    protected int price, initval, curval, age, expenses;
    protected double growth;
    protected String name;
    
    public Investment(int p,String n){
        price = p;
        initval=p;
        curval = p;
        age = 0;
        name = n;
    }
    
    public Investment(){
        price = 0;
        initval=0;
        curval = 0;
        age = 0;
        name = "Null Investment";
    }
    
    
    public static void passYear(ArrayList<Investment> x){//remove lottery from owned
        x.forEach((i) -> {
            i.grow();//grow first so values in text area can be relied on for the next year
             if(i instanceof Property){
                ((Property)i).fluctuateMarket();
                ((Property)i).deteriorate();
            }
            else if(i instanceof Vehicle){
                ((Vehicle)i).deteriorate();
            }
        });
        
    }
    
    public abstract void grow();
    
    
    public int compareTo(Object o){
        Investment other = (Investment)o;
        return name.compareTo(other.getName());
    }
    
    public void buy(){
        
    }
    
    public void sell(){
        
    }
    
    public int getValue(){
       return curval;
    }
    
    public String getName(){
        return name;
    }
    
    public int getInitVal(){
        return initval;
    }
    
    public String toString(){
        String x = "\n"+name;
        x+="\nPrice: $"+price;
        x+="\nCurrent yearly growth: "+(growth-100)+"%";
        x+="\nYearly expenses: $"+expenses;
        return x;
    }
    
    
    
    
    
    
}
