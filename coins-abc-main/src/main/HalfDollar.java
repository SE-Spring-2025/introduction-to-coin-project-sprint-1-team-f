import java.time.Year;
public class HalfDollar extends Coin {
    public HalfDollar() {
        super( 
            "HalfDollar",
            0.50,
            new CuproNickel()
        );  
    }

    public int getCount() {
        return cc.getHalfDollarCount();
    }

    public void increment() {
        cc.incrementHalfDollar();
    }

    protected Coin ridge(Coin c) {
        c.setRidgedEdge(true);
        return c;
    }

    protected Coin imprintFront(Coin c) {
        c.setFrontImage("J_Kennedy");
        c.setFrontMotto("IN GOD WE TRUST");
        c.setYear(Year.now().getValue());
        c.setFrontLabel("LIBERTY");
        return c;
    }

    protected Coin imprintBack(Coin c) {
        c.setBackImage("Presidential_Seal");
        c.setBackMotto("E PLURIBUS UNUM");
        c.setValueDescription("HALF DOLLAR");
        c.setBackLabel("UNITED STATES OF AMERICA");
        return c;
    }
}
