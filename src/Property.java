
public class Property extends Investment {

    private int condition,repcost,expenses;
    private boolean mgmt;
    static int marketflux=1;
    
    public Property(int p, int cond,String n){
        super(p,n);
        condition=cond;
        mgmt=false;
    }
    
    @Override
    public void grow() {
        curval*=growth;
    }
    
    public void deteriorate(){//condition go down by at least 0.1%
        condition*=(Math.random()*0.199+0.8);
    }
    
    public int getExpenses(){//monthly expenses
        expenses=getRepcost();
        if(mgmt)expenses+=2000;
        return expenses;
    }
    
    public void repair(){
        condition+=35;
    }
    
    public void fluctuateMarket(){
        marketflux*=(Math.random()*0.8+0.7);
        growth *=marketflux;
    }
    
    public int getRepcost(){//monthly repair cost
        repcost=(100-condition)*110;//*12
        return repcost;
    }
    
    public String toString(){
        String x = super.toString();
        x+="\nCondition: "+condition+"/100";
        return x;
    }
    
    public String getclass(){
        return "Property";
    }
}
