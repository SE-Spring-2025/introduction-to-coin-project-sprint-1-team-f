import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CoinTest {
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
			c = new MockCoin(0.10, 2020);
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
		try {
			c = new Penny(currYear);
		}
		catch (Exception e) {
			fail("Penny(year) constructor caused exception: "+e.getMessage());
		}

		//Nickel
		try {
			c = new Nickel();
		}
		catch (Exception e) {
			fail("Nickel() constructor caused exception: "+e.getMessage());
		}
		try {
			c = new Nickel(currYear);
		}
		catch (Exception e) {
			fail("Nickel(year) constructor caused exception: "+e.getMessage());
		}

		//Dime
		try {
			c = new Dime();
		}
		catch (Exception e) {
			fail("Dime() constructor caused exception: "+e.getMessage());
		}
		try {
			c = new Dime(currYear);
		}
		catch (Exception e) {
			fail("Dime(year) constructor caused exception: "+e.getMessage());
		}

		//Quarter
		try {
			c = new Quarter();
		}
		catch (Exception e) {
			fail("Quarter() constructor caused exception: "+e.getMessage());
		}
		try {
			c = new Quarter(currYear);
		}
		catch (Exception e) {
			fail("Quarter(year) constructor caused exception: "+e.getMessage());
		}

		//HalfDollar
		try {
			c = new HalfDollar();
		}
		catch (Exception e) {
			fail("HalfDollar() constructor caused exception: "+e.getMessage());
		}
		try {
			c = new HalfDollar(currYear);
		}
		catch (Exception e) {
			fail("HalfDollar(year) constructor caused exception: "+e.getMessage());
		}

		//Dollar
		try {
			c = new Dollar();
		}
		catch (Exception e) {
			fail("Dollar() constructor caused exception: "+e.getMessage());
		}
		try {
			c = new Dollar(currYear);
		}
		catch (Exception e) {
			fail("Dollar(year) constructor caused exception: "+e.getMessage());
		}
		assertTrue(true);
    }

    @Test
    public void testGetters() {
	if (! testPenny()) fail("penny getters failed");
	if (! testNickel()) fail("nickel getters failed");
	if (! testDime()) fail("dime getters failed");
	if (! testQuarter()) fail("quarter getters failed");
	if (! testHalfDollar()) fail("half dollar getters failed");
	if (! testDollar()) fail("dollar getters failed");
	
	// make it here then didn't fail!
	assertTrue(true);
    }

    @Test
    public void testToString() {

		Coin c;
		String expectedOutput;

		//Checking Penny
		c = new Penny();
		expectedOutput =
			"[Penny,0.01,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'A_Lincoln','Lincoln_Memorial','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','ONE CENT',smooth"
			+ ",'Copper']";
		assertEquals(expectedOutput, c.toString());
		c = new Penny(currYear);
		assertEquals(expectedOutput, c.toString());

		//Checking Nickel
		c = new Nickel();
		expectedOutput =
			"[Nickel,0.05,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'T_Jefferson','Jefferson_Memorial','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','FIVE CENTS',smooth"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());
		c = new Nickel(currYear);
		assertEquals(expectedOutput, c.toString());

		//Checking Dime
		c = new Dime();
		expectedOutput =
			"[Dime,0.10,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'F_Roosevelt','Torch_Branches','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','ONE DIME',ridges"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());
		c = new Dime(currYear);
		assertEquals(expectedOutput, c.toString());

		//Checking Quarter
		c = new Quarter();
		expectedOutput =
			"[Quarter,0.25,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'G_Washington','Eagle','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','QUARTER DOLLAR',ridges"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());
		c = new Quarter(currYear);
		assertEquals(expectedOutput, c.toString());

		//Checking Half Dollar
		c = new HalfDollar();
		expectedOutput =
			"[HalfDollar,0.50,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'J_Kennedy','Presidential_Seal','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','HALF DOLLAR',ridges"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());
		c = new HalfDollar(currYear);
		assertEquals(expectedOutput, c.toString());

		//Checking Dollar
		c = new Dollar();
		expectedOutput =
			"[Dollar,1.00,"
			+ currYear
			+ ",'IN GOD WE TRUST','E PLURIBUS UNUM'"
			+ ",'S_Anthony','Moon_Eagle','LIBERTY'"
			+ ",'UNITED STATES OF AMERICA','ONE DOLLAR',ridges"
			+ ",'Cupro-Nickel']";
		assertEquals(expectedOutput, c.toString());
		c = new Dollar(currYear);
		assertEquals(expectedOutput, c.toString());
    }

	@Test
	public void testSmelt() {
		//Checking Penny
		Coin c = new Penny();
		String expectedOutput = "Copper";
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Dime
		c = new Dime();
		expectedOutput = "Cupro-Nickel";
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Nickel
		c = new Nickel();
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Quarter
		c = new Quarter();
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Half Dollar
		c = new HalfDollar();
		assertEquals(expectedOutput, c.getMetallurgy());

		//Checking Dollar
		c = new Dollar();
		assertEquals(expectedOutput, c.getMetallurgy());
	}

    //---------------------------------------------------------
    // private helper methods
    //---------------------------------------------------------
    
	class MockCoin extends Coin {
		public MockCoin(double value, int year) {
			super( 
				"Test",
				value,
				"Test", 
				year,
				"Test", 
				"Test", 
				"Test", 
				"Test", 
				"Test", 
				"Test", 
				false, 
				new Copper()
			);
		}
	 }

    private boolean cmpDoubles(double a, double b) {
	return Math.abs(a-b) < 0.00001;
    }
    private boolean testPenny() {
	Coin c = new Penny();
	
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
	    
	// make it here then didn't fail!
	return true;
    }
    private boolean testNickel() {
	Coin c = new Nickel();
	
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
	
	// make it here then didn't fail!
	return true;
    }
    private boolean testDime() {
	Coin c = new Dime();
	
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
	
	// make it here then didn't fail!
	return true;
    }
    private boolean testQuarter() {
	Coin c = new Quarter();
	
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
	
	// make it here then didn't fail!
	return true;
    }
    private boolean testHalfDollar() {
	Coin c = new HalfDollar();
	
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
	
	// make it here then didn't fail!
	return true;
    }
    private boolean testDollar() {
	Coin c = new Dollar();
	
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
	
	// make it here then didn't fail!
	return true;
    }
}
    
