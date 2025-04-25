import java.time.Year;
public class Dollar extends Coin {
    public Dollar() {
        super( 
            "Dollar",
            1.00, 
            new CuproNickel()
        );
    }

    public int getCount() {
        return cc.getDollarCount();
    }

    public void increment() {
        cc.incrementDollar();
    }

    protected Coin ridge(Coin c) {
        c.setRidgedEdge(true);
        return c;
    }

    protected Coin imprintFront(Coin c) {
        c.setFrontImage("S_Anthony");
        c.setFrontMotto("IN GOD WE TRUST");
        c.setYear(Year.now().getValue());
        c.setFrontLabel("LIBERTY");
        return c;
    }

    protected Coin imprintBack(Coin c) {
        c.setBackImage("Moon_Eagle");
        c.setBackMotto("E PLURIBUS UNUM");
        c.setValueDescription("ONE DOLLAR");
        c.setBackLabel("UNITED STATES OF AMERICA");
        return c;
    }
}
