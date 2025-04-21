import java.time.Year;
public class Dime extends Coin {
    public Dime() {
        super( 
            "Dime",
            0.10,
            new CuproNickel()
        );
    }

    public int getCount() {
        return cc.getDimeCount();
    }

    public void increment() {
        cc.incrementDime();
    }

    protected Coin ridge(Coin c) {
        c.setRidgedEdge(true);
        return c;
    }

    protected Coin imprintFront(Coin c) {
        c.setFrontImage("F_Roosevelt");
        c.setFrontMotto("IN GOD WE TRUST");
        c.setYear(Year.now().getValue());
        c.setFrontLabel("LIBERTY");
        return c;
    }

    protected Coin imprintBack(Coin c) {
        c.setBackImage("Torch_Branches");
        c.setBackMotto("E PLURIBUS UNUM");
        c.setValueDescription("ONE DIME");
        c.setBackLabel("UNITED STATES OF AMERICA");
        return c;
    }
}
