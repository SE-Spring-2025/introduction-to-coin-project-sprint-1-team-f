import java.time.Year;
public class HalfDollar extends Coin {
    public HalfDollar(int year) {
        super( 
            "HalfDollar",
            0.50, 
            "IN GOD WE TRUST", 
            year,
            "E PLURIBUS UNUM", 
            "LIBERTY", 
            "UNITED STATES OF AMERICA", 
            "J_Kennedy", 
            "Presidential_Seal", 
            "HALF DOLLAR", 
            true, 
            new CuproNickel()
        );  
    }
    public HalfDollar() {
        this(Year.now().getValue());
    }

    public int getCount() {
        return cc.getHalfDollarCount();
    }

    public void increment() {
        cc.incrementHalfDollar();
    }
}
