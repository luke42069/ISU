
import java.util.ArrayList;


public class Lottery extends Investment{

    protected int jackpot,odds,tickets;
    protected ArrayList<Integer>num1=new ArrayList();
    protected ArrayList<Integer>num2=new ArrayList();
    
    public Lottery(int p,int t,String n) {
        super(p,n);
        tickets=t;
    }

    @Override
    public void grow() {
        if(winLottery())curval+=jackpot;
    }
    
    public void setJackpot(){//also set other variables necessary
        jackpot = (int)(Math.random()*100000000+50000);
        odds = (int)(Math.random()*100000+500);
        for (int i = 0; i <= tickets; i++) {
            num1.add((int)(Math.random()*odds));
            num2.add((int)(Math.random()*odds));
        }
        
        
    }
    
    public int getJackpot(){
        return jackpot;
    }
    
    public int getOdds(){
        return odds;
    }
    
    public boolean winLottery(){//if numbers picked from the pool (odds) match, you win
        for (int i = 0; i < tickets; i++) {
            if(num1.get(i)-num2.get(i)==0)return true;
        }
        return false;
    }

    
    
}
