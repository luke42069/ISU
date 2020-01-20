
public class Artifact extends Investment{

    
    private int rarity;
    private String name;
    
    public Artifact(int p,String n, int r) {
        super(p,n);
        rarity = r;
    }

    @Override
    public void grow() {
        
        curval=curval^rarity*age;//exponential growth
        
    }
    
    /*public void deteriorate(){//condition go down by at least 0.1%
        condition*=(Math.random()*0.199+0.8);
    }*/

    @Override
    public String getclass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
