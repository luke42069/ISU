
public class Artifact extends Investment{

    
    private int rarity;
    
    public Artifact(int p,String n, int r) {
        super(p,n);
        rarity = r;//int /5
        
    }

    @Override
    public void grow() {
        
        curval=initval*rarity^(age/10);//exponential growth, multiply by rarity every 10 years
        
    }
    
    public String toString(){
        String x = "Type: Artifact\n";
        x += name;
        x+="\nPrice: $"+price;
        x+="\nCurrent yearly growth: Exponential; increases by factor of "+rarity+" every 10 years";
        x+="\nYearly expenses: $"+expenses;
        return x;
    }
    
    

    
    
    
}
