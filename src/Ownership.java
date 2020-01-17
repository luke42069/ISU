
public class Ownership extends Investment{

    private int imp;//impressionability /5, 5 is more likely to accept offer
    private int wbg;//wellbeing /5, 5 is doing good so less likely to accept
    private int smt;//smartness /5, 5 is smarter so company will do better
    
    public Ownership(int p, String n) {
        super(p, n);
    }

    @Override
    public void grow() {
        growth=(int)((Math.random()*25+25)+(20*smt));//grows by smartness% of 100. 5 will always grow, 1 will always shrink
    }
    
    
    public boolean acceptsOffer(int per, int offer){
        
        int pervalue = curval/100*per;//calculate value of percent in question by division of total value
        double score = (imp+5)^2-(wbg^2); //"willingness score" is the sum of wbg square and imp+5 (so imp always>wbg) square
        return offer/pervalue*100+score>130;  //percent offer is of pervalue, plus score, >130 means accept offer -
        
        
        
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
    
}
