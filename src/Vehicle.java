
public class Vehicle extends Investment{

    int condition, repcost,expenses;
    
    public Vehicle(int p, int cond,String n) {
        super(p,n);
        condition=cond;
        growth=(double)condition/100;
    }

    @Override
    public void grow() {
        curval*=(double)condition/100;//depreciates more the worse the condition is
    }
    
    public void deteriorate(){
        condition*=(Math.random()*0.199+0.8);
    }
    
    public void repair(){
        condition+=35;
    }
    
    public int getRepcost(){//repair cost per condition point missing
        repcost=(100-condition)*15;//
        return repcost;
    }
    
    public int getExpenses(){
        expenses=getRepcost();
        expenses+=4000;//gas
        return expenses;
    }
    
    public String toString(){
        String x = "Type: Vehicle";
        x += super.toString();
        x+="\nCondition: "+condition+" / 100";
        return x;
    }
    
}
