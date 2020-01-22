
public class Ownership extends Investment{

    private int imp;//impressionability /5, 5 is more likely to accept offer
    private int wbg;//wellbeing /5, 5 is doing good so less likely to accept
    private int smt;//smartness /5, 5 is smarter so company will do better
    private int stake;//percentage owned
    
    public Ownership(int p, String n, int i,int w,int s) {//p is current value of company
        super(p, n);
        imp = i;
        wbg = w;
        smt = s;
        growth=(int)((Math.random()*25+25)+(20*smt));
    }

    @Override
    public void grow() {
        growth=(Math.random()*.15+.35)/*15% random, 35% guaranteed, rest based on smartness*/+(double)((smt*20)/100);//grows by smartness% of 100. 5 will always grow, 1 will always shrink
        curval*=growth;
    }
    
    public int perValue(int p){
        return (int)(((double)p/100)*(double)curval);//keep as double for as long as possible to preserve accuracy
    }
    
    public int getStake(){
        return stake;
    }
    
    public boolean acceptsOffer(int per, int offer){
        stake=per;
        int pervalue = curval/100*per;//calculate value of percent in question by division of total value
        double score = (Math.pow((imp+5), 2)); //"willingness score" is the sum of wbg square and imp+5 (so imp always>wbg) square 
        System.out.println("Score "+score);
        score-=(Math.pow(wbg, 2));
        System.out.println("Imp "+imp+"   wbg "+wbg);
        
        System.out.println("Score: "+score);
        System.out.println("offer: "+offer);
        System.out.println("pervalue: "+pervalue);
        System.out.println("percent offer of pervalue: "+(double)offer/pervalue*100);
        System.out.println((double)offer/pervalue*100+score);
        return (double)offer/(double)pervalue*100+score>130;  //percent offer is of pervalue, plus score, >130 means accept
        
        
        
        /*TESTING & LOGIC: 
        scenarios: wbg>imp= high offer needed,
        imp>wbg = offer 65% of value needed,
        wbg<3 = offer less than value needed, imp >3 will accept, imp <3 will accept if offer greater than 50%, imp 3 will accept offer greater than 60%
        wbg 3 = offer of value needed, imp >3 will accept 70%, imp <3 will accept 95%, imp 3 will accept 85%
        wbg >3 = offer greater than value needed, imp >3 will accept 90%, imp < 3 will accept >100%, imp 3 will accept 95%
        wbg 5- not interested unless offer>105% of value
        i 1:  w 1 = 35, w 2 = 32, w 3 = 27, w 4 = 20, w 5 = 11
        i 2:  w 1 = 48, w 2 = 45, w 3 = 40, w 4 = 33, w 5 = 24
        i 3:  w 1 = 63, w 2 = 60, w 3 = 55, w 4 = 48, w 5 = 39
        i 4:  w 1 = 80, w 2 = 77, w 3 = 72, w 4 = 65, w 5 = 56
        i 5:  w 1 = 99, w 2 = 96, w 3 = 91, w 4 = 84, w 5 = 75.
        1,5 = 11  
        5, 1 = 99
         */
    }
    
    public String toString(){
        String x = "Type: Company Ownership";
        x+=super.toString();
        x+="\nSmartness: "+smt+" / 5\n";
        x+="Wellbeing: "+wbg+" / 5\n";
        x+="Impressionability: "+imp+" / 5\n";
        return x;
    }
    
}
