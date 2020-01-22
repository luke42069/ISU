
import java.util.ArrayList;


public class Lottery extends Investment{

    protected int jackpot,odds,tickets;
    protected ArrayList<Integer>num1=new ArrayList();
    protected ArrayList<Integer>num2=new ArrayList();
    
    public Lottery(int p,String n) {
        super(p,n);
        tickets=0;
    }

    @Override
    public void grow() {
        curval=0;
        if(winLottery())curval=jackpot;
        tickets=0;
        setJackpot();//new year new jackpot
    }
    
    public void setJackpot(){//also set other variables necessary
        jackpot = (int)(Math.random()*100000000+50000);
        odds = (int)(Math.random()*100000+500);
        for (int i = 0; i <= tickets; i++) {
            num1.add((int)(Math.random()*odds));
            num2.add((int)(Math.random()*odds));//pick numbers randomly, max is odds
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
    
    public boolean setTickets(int t){
        if(t>10000||t<0)return false;
        else tickets = t;
        return true;
    }
    
    
    
    public String toString(){
        String x = "Type: Lottery";
        x+=super.toString();
        x+="\nJackpot: "+jackpot;
        x+="\nOdds: 1 / "+odds;
        x+= "\nTickets: "+tickets;
        return x;
    }

    
    
}
