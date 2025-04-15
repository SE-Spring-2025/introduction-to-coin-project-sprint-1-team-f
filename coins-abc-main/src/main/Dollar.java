import java.time.Year;
public class Dollar extends Coin {
    public Dollar(int year) {
        super( 
            "Dollar",
            1.00, 
            "IN GOD WE TRUST", 
            year,
            "E PLURIBUS UNUM", 
            "LIBERTY", 
            "UNITED STATES OF AMERICA", 
            "S_Anthony", 
            "Moon_Eagle", 
            "ONE DOLLAR", 
            true, 
            new CuproNickel()
        );
    }
    public Dollar() {
        this(Year.now().getValue());
    }

    public int getCount() {
        return cc.getDollarCount();
    }

    public void increment() {
        cc.incrementDollar();
    }
}
