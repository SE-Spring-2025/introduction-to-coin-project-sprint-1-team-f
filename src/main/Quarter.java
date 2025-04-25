import java.time.Year;
public class Quarter extends Coin {
    public Quarter(int year) {
        super( 
            "Quarter",
            0.25, 
            "IN GOD WE TRUST", 
            year,
            "E PLURIBUS UNUM", 
            "LIBERTY", 
            "UNITED STATES OF AMERICA", 
            "G_Washington", 
            "Eagle", 
            "QUARTER DOLLAR", 
            true, 
            new CuproNickel()
        );
    }
    public Quarter() {
        this(Year.now().getValue());
    }

    public int getCount() {
        return cc.getQuarterCount();
    }

    public void increment() {
        cc.incrementQuarter();
    }
}
