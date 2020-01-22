
public class Property extends Investment {

    private int condition,repcost,expenses;
    private boolean mgmt;
    
    
    public Property(int p, int cond,String n){
        super(p,n);
        condition=cond;
        mgmt=false;
        growth = cond*1.5;//will initially grow by 150% of condition value; condition determines how much it appreciates
    }
    
    @Override
    public void grow() {
        expenses=0;
        curval*=growth;
    }
    
    public void deteriorate(){//condition go down by at least 0.1% if not managed
        if(!mgmt)condition*=(Math.random()*0.199+0.8);
    }
    
    public int getExpenses(){//monthly expenses
        if(!mgmt)expenses=getRepcost();
        else if(mgmt)expenses+=2000;
        return expenses;
    }
    
    public void repair(){
        condition+=35;
    }
    
    public void fluctuateMarket(){//real estate market is somewhat unpredictable but will not go below 75% (0.75) of growth - max 25% depreciation, max 55% growth
        growth *=(Math.random()*0.8+0.75);
    }
    
    public int getRepcost(){//monthly repair cost
        repcost=(100-condition)*110;//*12
        return repcost;
    }
    
    public String toString(){
        String x = "Type: Property";
        x += super.toString();
        x+="\nCondition: "+condition+"/100";
        x+="\nExpenses: "+expenses;
        return x;
    }
    
    public String getclass(){
        return "Property";
    }
    
    public void setMg(boolean x){
        mgmt=x;
    }
}
