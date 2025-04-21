import java.time.Year;
public class Penny extends Coin {
    public Penny() {
        super( 
            "Penny",
            0.01,
            new Copper()
        );
    }

    public int getCount() {
        return cc.getPennyCount();
    }

    public void increment() {
        cc.incrementPenny();
    }

    protected Coin ridge(Coin c) {
        c.setRidgedEdge(false);
        return c;
    }

    protected Coin imprintFront(Coin c) {
        c.setFrontImage("A_Lincoln");
        c.setFrontMotto("IN GOD WE TRUST");
        c.setYear(Year.now().getValue());
        c.setFrontLabel("LIBERTY");
        return c;
    }

    protected Coin imprintBack(Coin c) {
        c.setBackImage("Lincoln_Memorial");
        c.setBackMotto("E PLURIBUS UNUM");
        c.setValueDescription("ONE CENT");
        c.setBackLabel("UNITED STATES OF AMERICA");
        return c;
    }
}
