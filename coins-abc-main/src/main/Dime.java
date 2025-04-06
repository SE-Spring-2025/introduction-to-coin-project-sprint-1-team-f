import java.time.Year;
public class Dime extends Coin {
    public Dime(int year) {
        super( 
            "Dime",
            0.10, 
            "IN GOD WE TRUST", 
            year,
            "E PLURIBUS UNUM", 
            "LIBERTY", 
            "UNITED STATES OF AMERICA", 
            "F_Roosevelt", 
            "Torch_Branches", 
            "ONE DIME", 
            true, 
            new CuproNickel()
        );
    }
    public Dime() {
        this(Year.now().getValue());
    }
}
