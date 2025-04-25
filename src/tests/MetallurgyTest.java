import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MetallurgyTest {
    
    @Test
    public void testCopper() {
        Copper c = new Copper();
        assertEquals("Copper", c.smelt());
    }

    @Test
    public void testCuproNickel() {
        CuproNickel cn = new CuproNickel();
        assertEquals("Cupro-Nickel", cn.smelt());
    }
}
