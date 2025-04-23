import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CounterTest extends ClassTest {

    private CoinObserver co = new CoinObserver() { public void update() { updated = true; } };
    private CoinCounter cc = new CoinCounter();
    private boolean updated;

    @Test
    public void testConstructors() {
        testGetters();
        testSetters();
        testIncrements();
        testSubjectMethods();
    }

    @Test
    public void testGetters() {
        get(0);
    }

    @Test
    public void testSetters() {
        set(-1);
    }

    @Test
    public void testIncrements() {
        int i = 1;

        set(i++);
        
        cc.incrementPenny();
        cc.incrementNickel();
        cc.incrementDime();
        cc.incrementQuarter();
        cc.incrementHalfDollar();
        cc.incrementDollar();

        get(i);
    }

    @Test
    public void testSubjectMethods() {
        CoinObserver temp = new CoinObserver() { public void update() { } };
        cc.addObserver(co);
        cc.addObserver(temp);
        assertTrue(cc.observers.contains(temp));

        cc.removeObserver(temp);
        assertTrue(!cc.observers.contains(temp));

        updated = false;
        cc.notifyObservers();
        assertTrue(updated);
    }

    private void get(int i) {
        assertEquals(i, cc.getPennyCount());
        assertEquals(i, cc.getNickelCount());
        assertEquals(i, cc.getDimeCount());
        assertEquals(i, cc.getQuarterCount());
        assertEquals(i, cc.getHalfDollarCount());
        assertEquals(i, cc.getDollarCount());
    }

    private void set(int i) {
        cc.setPennyCount(i);
        cc.setNickelCount(i);
        cc.setDimeCount(i);
        cc.setQuarterCount(i);
        cc.setHalfDollarCount(i);
        cc.setDollarCount(i);

        assertEquals(i, cc.getPennyCount());
        assertEquals(i, cc.getNickelCount());
        assertEquals(i, cc.getDimeCount());
        assertEquals(i, cc.getQuarterCount());
        assertEquals(i, cc.getHalfDollarCount());
        assertEquals(i, cc.getDollarCount());
    }

}
