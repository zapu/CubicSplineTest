import flanagan.interpolation.CubicSplineFast;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntConstructorTest {

    public static final double eps = 100 * Double.MIN_VALUE;
   
    @Test (expected = NegativeArraySizeException.class)
    public void test01() {
        CubicSplineFast csf = new CubicSplineFast(-1);
        assertNull(csf);
    }

    @Test (expected = NegativeArraySizeException.class)
    public void test02() {
        CubicSplineFast csf = new CubicSplineFast(-999);
        assertNull(csf);
    }

    @Test
    public void test03() {
        CubicSplineFast csf = new CubicSplineFast(3);
        assertNotNull(csf);
    }

    @Test
    public void test04() {
        CubicSplineFast csf = new CubicSplineFast(232);
        assertNotNull(csf);
    }
    
    @Test
    public void test05() {
        CubicSplineFast csf = new CubicSplineFast(1298721);
        assertNotNull(csf);
    }

    @Test
    public void test06(){
        CubicSplineFast cs = new CubicSplineFast(0);
        assertEquals(0, cs.nPoints);
    }

    @Test
    public void test07(){
        CubicSplineFast cs = new CubicSplineFast(10);
        assertEquals(cs.x.length, cs.nPoints);
    }

    @Test
    public void test08(){
        CubicSplineFast cs = new CubicSplineFast(10);
        for(int i=0; i<cs.nPoints; i++){
            assertEquals(cs.x[i], cs.y[i], eps);
        }
    }
}
