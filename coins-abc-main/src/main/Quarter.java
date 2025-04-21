import java.time.Year;
public class Quarter extends Coin {
    public Quarter() {
        super( 
            "Quarter",
            0.25,
            new CuproNickel()
        );
    }

    public int getCount() {
        return cc.getQuarterCount();
    }

    public void increment() {
        cc.incrementQuarter();
    }

    protected Coin ridge(Coin c) {
        c.setRidgedEdge(true);
        return c;
    }

    protected Coin imprintFront(Coin c) {
        c.setFrontImage("G_Washington");
        c.setFrontMotto("IN GOD WE TRUST");
        c.setYear(Year.now().getValue());
        c.setFrontLabel("LIBERTY");
        return c;
    }

    protected Coin imprintBack(Coin c) {
        c.setBackImage("Eagle");
        c.setBackMotto("E PLURIBUS UNUM");
        c.setValueDescription("QUARTER DOLLAR");
        c.setBackLabel("UNITED STATES OF AMERICA");
        return c;
    }
}
