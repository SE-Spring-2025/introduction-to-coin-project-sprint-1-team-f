import java.time.Year;
public class Nickel extends Coin {
    public Nickel() {
        super( 
            "Nickel",
            0.05, 
            new CuproNickel()
        );
    }

    public int getCount() {
        return cc.getNickelCount();
    }

    public void increment() {
        cc.incrementNickel();
    }

    protected Coin ridge(Coin c) {
        c.setRidgedEdge(false);
        return c;
    }

    protected Coin imprintFront(Coin c) {
        c.setFrontImage("T_Jefferson");
        c.setFrontMotto("IN GOD WE TRUST");
        c.setYear(Year.now().getValue());
        c.setFrontLabel("LIBERTY");
        return c;
    }

    protected Coin imprintBack(Coin c) {
        c.setBackImage("Jefferson_Memorial");
        c.setBackMotto("E PLURIBUS UNUM");
        c.setValueDescription("FIVE CENTS");
        c.setBackLabel("UNITED STATES OF AMERICA");
        return c;
    }
}
