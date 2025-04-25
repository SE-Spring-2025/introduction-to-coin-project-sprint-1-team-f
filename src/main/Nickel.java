import java.time.Year;
public class Nickel extends Coin {
    public Nickel(int year) {
        super( 
            "Nickel",
            0.05, 
            "IN GOD WE TRUST", 
            year,
            "E PLURIBUS UNUM", 
            "LIBERTY", 
            "UNITED STATES OF AMERICA", 
            "T_Jefferson", 
            "Jefferson_Memorial", 
            "FIVE CENTS", 
            false, 
            new CuproNickel()
        );
    }
    public Nickel() {
        this(Year.now().getValue());
    }

    public int getCount() {
        return cc.getNickelCount();
    }

    public void increment() {
        cc.incrementNickel();
    }
}
