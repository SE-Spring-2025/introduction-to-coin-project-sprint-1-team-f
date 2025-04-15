import java.time.Year;
public class Penny extends Coin {
    public Penny(int year) {
        super( 
            "Penny",
            0.01,
            "IN GOD WE TRUST", 
            year,
            "E PLURIBUS UNUM", 
            "LIBERTY", 
            "UNITED STATES OF AMERICA", 
            "A_Lincoln", 
            "Lincoln_Memorial", 
            "ONE CENT", 
            false, 
            new Copper()
        );
    }
    public Penny() {
        this(Year.now().getValue());
    }

    public int getCount() {
        return cc.getPennyCount();
    }

    public void increment() {
        cc.incrementPenny();
    }
}
