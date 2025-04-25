import java.time.Year;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CoinTest extends ClassTest{
    private static int currYear;
    
    @BeforeAll
    public static void getCurrYear() {
	currYear = (Year.now().getValue());
    }

    @Test
    public void testConstructors() {
		Coin c;
		//Coin
		try {
			c = new Coin(null, -1.0, null) {
				public int getCount() { return 0; }
				public void increment() {}
				protected Coin ridge(Coin c) { return this; }
				protected Coin imprintFront(Coin c) { return this; }
				protected Coin imprintBack(Coin c) { return this; }
			};
		}
		catch (Exception e) {
			fail("Coin() constructor caused exception: "+e.getMessage());
		}

		//Penny
		try {
			c = new Penny();
		}
		catch (Exception e) {
			fail("Penny() constructor caused exception: "+e.getMessage());
		}

		//Nickel
		try {
			c = new Nickel();
		}
		catch (Exception e) {
			fail("Nickel() constructor caused exception: "+e.getMessage());
		}

		//Dime
		try {
			c = new Dime();
		}
		catch (Exception e) {
			fail("Dime() constructor caused exception: "+e.getMessage());
		}

		//Quarter
		try {
			c = new Quarter();
		}
		catch (Exception e) {
			fail("Quarter() constructor caused exception: "+e.getMessage());
		}

		//HalfDollar
		try {
			c = new HalfDollar();
		}
		catch (Exception e) {
			fail("HalfDollar() constructor caused exception: "+e.getMessage());
		}

		//Dollar
		try {
			c = new Dollar();
		}
		catch (Exception e) {
			fail("Dollar() constructor caused exception: "+e.getMessage());
		}
    }

    @Test
    public void testGetters() {
		assertTrue(testPennyGetters());
		assertTrue(testNickelGetters());
		assertTrue(testDimeGetters());
		assertTrue(testQuarterGetters());
		assertTrue(testHalfDollarGetters());
		assertTrue(testDollarGetters());
    }

	@Test
	public void testSetters() {
		assertTrue(testCoinSetters());
		assertTrue(testConcreteSetters());
	}

    @Test
    public void testToString() {

		Coin c;
		String expectedOutput;

		//Checking Penny
		c = new Penny();
		c = c.manufacture(c);
		expectedOutput =
			"[Penny,0.01,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'A_Lincoln','Lincoln_Memorial','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','ONE CENT',smooth"
			+ ",'Copper']";
		assertEquals(expectedOutput, c.toString());

		//Checking Nickel
		c = new Nickel();
		c = c.manufacture(c);
		expectedOutput =
			"[Nickel,0.05,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'T_Jefferson','Jefferson_Memorial','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','FIVE CENTS',smooth"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());

		//Checking Dime
		c = new Dime();
		c = c.manufacture(c);
		expectedOutput =
			"[Dime,0.10,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'F_Roosevelt','Torch_Branches','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','ONE DIME',ridges"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());

		//Checking Quarter
		c = new Quarter();
		c = c.manufacture(c);
		expectedOutput =
			"[Quarter,0.25,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'G_Washington','Eagle','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','QUARTER DOLLAR',ridges"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());

		//Checking Half Dollar
		c = new HalfDollar();
		c = c.manufacture(c);
		expectedOutput =
			"[HalfDollar,0.50,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'J_Kennedy','Presidential_Seal','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','HALF DOLLAR',ridges"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());

		//Checking Dollar
		c = new Dollar();
		c = c.manufacture(c);
		expectedOutput =
			"[Dollar,1.00,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'S_Anthony','Moon_Eagle','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','ONE DOLLAR',ridges"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());
    }

	@Test
	public void testManufacture() {

		//Checking Penny
		Coin c = new Penny();
		c = c.manufacture(c);
		String expectedOutput = "Copper";
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Dime
		c = new Dime();
		c = c.manufacture(c);
		expectedOutput = "Cupro-Nickel";
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Nickel
		c = new Nickel();
		c = c.manufacture(c);
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Quarter
		c = new Quarter();
		c = c.manufacture(c);
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Half Dollar
		c = new HalfDollar();
		c = c.manufacture(c);
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Dollar
		c = new Dollar();
		c = c.manufacture(c);
		assertEquals(expectedOutput, c.getMetallurgy());
	}

    //---------------------------------------------------------
    // private helper methods
    //---------------------------------------------------------

    private boolean cmpDoubles(double a, double b) {
	return Math.abs(a-b) < 0.00001;
    }
    private boolean testPennyGetters() {
	Coin c = new Penny();
	c = c.manufacture(c);
	
	if (! "Penny".equals(c.getCommonName())) return false;
	if (! cmpDoubles(c.getValue(), 0.01)) return false;
	if (! "IN GOD WE TRUST".equals(c.getFrontMotto())) return false;
	if (! "E PLURIBUS UNUM".equals(c.getBackMotto())) return false;
	if (! "LIBERTY".equals(c.getFrontLabel())) return false;
	if (! "UNITED STATES OF AMERICA".equals(c.getBackLabel())) return false;
	if (! "A_Lincoln".equals(c.getFrontImage())) return false;
	if (! "Lincoln_Memorial".equals(c.getBackImage())) return false;
	if (! "ONE CENT".equals(c.getValueDescription())) return false;
	if (c.getRidgedEdge() != false) return false;
	if (! "Copper".equals(c.getMetallurgy())) return false;
	if (currYear != c.getYear()) return false;
	if (c.getBuffed() != true) return false;
	if (c.getFlipped() != true) return false;
	    
	// make it here then didn't fail!
	return true;
    }
    private boolean testNickelGetters() {
	Coin c = new Nickel();
	c = c.manufacture(c);
	
	if (! "Nickel".equals(c.getCommonName())) return false;
	if (! cmpDoubles(c.getValue(), 0.05)) return false;
	if (! "IN GOD WE TRUST".equals(c.getFrontMotto())) return false;
	if (! "E PLURIBUS UNUM".equals(c.getBackMotto())) return false;
	if (! "LIBERTY".equals(c.getFrontLabel())) return false;
	if (! "UNITED STATES OF AMERICA".equals(c.getBackLabel())) return false;
	if (! "T_Jefferson".equals(c.getFrontImage())) return false;
	if (! "Jefferson_Memorial".equals(c.getBackImage())) return false;
	if (! "FIVE CENTS".equals(c.getValueDescription())) return false;
	if (c.getRidgedEdge() != false) return false;
	if (! "Cupro-Nickel".equals(c.getMetallurgy())) return false;
	if (currYear != c.getYear()) return false;
	if (c.getBuffed() != true) return false;
	if (c.getFlipped() != true) return false;
	
	// make it here then didn't fail!
	return true;
    }
    private boolean testDimeGetters() {
	Coin c = new Dime();
	c = c.manufacture(c);
	
	if (! "Dime".equals(c.getCommonName())) return false;
	if (! cmpDoubles(c.getValue(), 0.10)) return false;
	if (! "IN GOD WE TRUST".equals(c.getFrontMotto())) return false;
	if (! "E PLURIBUS UNUM".equals(c.getBackMotto())) return false;
	if (! "LIBERTY".equals(c.getFrontLabel())) return false;
	if (! "UNITED STATES OF AMERICA".equals(c.getBackLabel())) return false;
	if (! "F_Roosevelt".equals(c.getFrontImage())) return false;
	if (! "Torch_Branches".equals(c.getBackImage())) return false;
	if (! "ONE DIME".equals(c.getValueDescription())) return false;
	if (c.getRidgedEdge() != true) return false;
	if (! "Cupro-Nickel".equals(c.getMetallurgy())) return false;
	if (currYear != c.getYear()) return false;
	if (c.getBuffed() != true) return false;
	if (c.getFlipped() != true) return false;
	
	// make it here then didn't fail!
	return true;
    }
    private boolean testQuarterGetters() {
	Coin c = new Quarter();
	c = c.manufacture(c);
	
	if (! "Quarter".equals(c.getCommonName())) return false;
	if (! cmpDoubles(c.getValue(), 0.25)) return false;
	if (! "IN GOD WE TRUST".equals(c.getFrontMotto())) return false;
	if (! "E PLURIBUS UNUM".equals(c.getBackMotto())) return false;
	if (! "LIBERTY".equals(c.getFrontLabel())) return false;
	if (! "UNITED STATES OF AMERICA".equals(c.getBackLabel())) return false;
	if (! "G_Washington".equals(c.getFrontImage())) return false;
	if (! "Eagle".equals(c.getBackImage())) return false;
	if (! "QUARTER DOLLAR".equals(c.getValueDescription())) return false;
	if (c.getRidgedEdge() != true) return false;
	if (! "Cupro-Nickel".equals(c.getMetallurgy())) return false;
	if (currYear != c.getYear()) return false;
	if (c.getBuffed() != true) return false;
	if (c.getFlipped() != true) return false;
	
	// make it here then didn't fail!
	return true;
    }
    private boolean testHalfDollarGetters() {
	Coin c = new HalfDollar();
	c = c.manufacture(c);
	
	if (! "HalfDollar".equals(c.getCommonName())) return false;
	if (! cmpDoubles(c.getValue(), 0.50)) return false;
	if (! "IN GOD WE TRUST".equals(c.getFrontMotto())) return false;
	if (! "E PLURIBUS UNUM".equals(c.getBackMotto())) return false;
	if (! "LIBERTY".equals(c.getFrontLabel())) return false;
	if (! "UNITED STATES OF AMERICA".equals(c.getBackLabel())) return false;
	if (! "J_Kennedy".equals(c.getFrontImage())) return false;
	if (! "Presidential_Seal".equals(c.getBackImage())) return false;
	if (! "HALF DOLLAR".equals(c.getValueDescription())) return false;
	if (c.getRidgedEdge() != true) return false;
	if (! "Cupro-Nickel".equals(c.getMetallurgy())) return false;
	if (currYear != c.getYear()) return false;
	if (c.getBuffed() != true) return false;
	if (c.getFlipped() != true) return false;
	
	// make it here then didn't fail!
	return true;
    }
    private boolean testDollarGetters() {
	Coin c = new Dollar();
	c = c.manufacture(c);
	
	if (! "Dollar".equals(c.getCommonName())) return false;
	if (! cmpDoubles(c.getValue(), 1.00)) return false;
	if (! "IN GOD WE TRUST".equals(c.getFrontMotto())) return false;
	if (! "E PLURIBUS UNUM".equals(c.getBackMotto())) return false;
	if (! "LIBERTY".equals(c.getFrontLabel())) return false;
	if (! "UNITED STATES OF AMERICA".equals(c.getBackLabel())) return false;
	if (! "S_Anthony".equals(c.getFrontImage())) return false;
	if (! "Moon_Eagle".equals(c.getBackImage())) return false;
	if (! "ONE DOLLAR".equals(c.getValueDescription())) return false;
	if (c.getRidgedEdge() != true) return false;
	if (! "Cupro-Nickel".equals(c.getMetallurgy())) return false;
	if (currYear != c.getYear()) return false;
	if (c.getBuffed() != true) return false;
	if (c.getFlipped() != true) return false;
	
	// make it here then didn't fail!
	return true;
    }
	private boolean testCoinSetters() {
		final String s = "test";
		final double d = -1;
		final int i = -1;

							Coin c = new Coin(null, 0, null) {
								public int getCount() { return 0; }
								public void increment() {}
								protected Coin ridge(Coin c) { return this; }
								protected Coin imprintFront(Coin c) { return this; }
								protected Coin imprintBack(Coin c) { return this; }
							};
		c.setCommonName(s);
		c.setValue(d);
		c.setFrontMotto(s);
		c.setYear(i);
		c.setFrontImage(s);
		c.setBackImage(s);
		c.setBackMotto(s);
		c.setFrontLabel(s);
		c.setBackLabel(s);
		c.setValueDescription(s);
		c.setRidgedEdge(true);
		c.setFlipped(true);
		c.setBuffed(true);

		if (!s.equals(c.getCommonName())) { return false; }
		if (d != c.getValue()) { return false; }
		if (!s.equals(c.getFrontMotto())) { return false; }
		if (i != c.getYear()) { return false; }
		if (!s.equals(c.getFrontImage())) { return false; }
		if (!s.equals(c.getBackImage())) { return false; }
		if (!s.equals(c.getBackMotto())) { return false; }
		if (!s.equals(c.getFrontLabel())) { return false; }
		if (!s.equals(c.getBackLabel())) { return false; }
		if (!s.equals(c.getValueDescription())) { return false; }
		if (!c.getRidgedEdge()) { return false; }
		if (!c.getFlipped()) { return false; }
		if (!c.getBuffed()) { return false; }

		return true;
	}
	private boolean testConcreteSetters() {
		final String s = "test";
		final double d = -1;
		final int i = -1;
		ArrayList<Coin> a = new ArrayList<Coin>();
			a.add(new Penny());
			a.add(new Nickel());
			a.add(new Dime());
			a.add(new Quarter());
			a.add(new HalfDollar());
			a.add(new Dollar());

		for (Coin c : a) {
			c.setCommonName(s);
			c.setValue(d);
			c.setFrontMotto(s);
			c.setYear(i);
			c.setFrontImage(s);
			c.setBackImage(s);
			c.setBackMotto(s);
			c.setFrontLabel(s);
			c.setBackLabel(s);
			c.setValueDescription(s);
			c.setRidgedEdge(true);
			c.setFlipped(true);
			c.setBuffed(true);

			if (!s.equals(c.getCommonName())) { return false; }
			if (d != c.getValue()) { return false; }
			if (!s.equals(c.getFrontMotto())) { return false; }
			if (i != c.getYear()) { return false; }
			if (!s.equals(c.getFrontImage())) { return false; }
			if (!s.equals(c.getBackImage())) { return false; }
			if (!s.equals(c.getBackMotto())) { return false; }
			if (!s.equals(c.getFrontLabel())) { return false; }
			if (!s.equals(c.getBackLabel())) { return false; }
			if (!s.equals(c.getValueDescription())) { return false; }
			if (!c.getRidgedEdge()) { return false; }
			if (!c.getFlipped()) { return false; }
			if (!c.getBuffed()) { return false; }
		}

		return true;
	}
	
}