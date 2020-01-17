
public abstract class Investment implements Comparable{
    protected int price, initval, curval, age, growth, expenses;
    protected String name;
    
    public Investment(int p,String n){
        price = p;
        initval=p;
        curval = p;
        age = 0;
        name = n;
    }
    
    
    public abstract void grow();
    public abstract String getclass();
    
    
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
        String x = name;
        x+="\nPrice: $"+price;
        x+="\nCurrent yearly growth: "+growth+"%";
        x+="\nYearly expenses: $"+expenses;
        return x;
    }
    
    
    
    //boolean isOwned, 
    //certain number of investments will always exist, they grow regardless of whether they are owned or not.
    
    
    
}
