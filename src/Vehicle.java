
public class Vehicle extends Investment{

    int condition, repcost,expenses;
    
    public Vehicle(int p, int cond,String n) {
        super(p,n);
        condition=cond;
    }

    @Override
    public void grow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
