/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import flanagan.interpolation.CubicSplineFast;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Test
 */
public class IntConstructorTest {
    CubicSplineFast csf;
    CubicSplineFast csf1;
    CubicSplineFast csf2;
    CubicSplineFast csf3;
    CubicSplineFast csf4;
    CubicSplineFast csf5;
    @Test
    public void testIsNull() {
        assertNull(csf);
        assertNull(csf1);
        assertNull(csf2);
        assertNull(csf3);
        assertNull(csf4);
        assertNull(csf5);
    }
    @Test
    public void testIsNotNull() {
        csf = new CubicSplineFast(0);
        assertNotNull(csf);
    }
    @Test (expected = NegativeArraySizeException.class)
    public void test01() {
        csf1 = new CubicSplineFast(-1);
        assertNull(csf1);
    }
    @Test (expected = NegativeArraySizeException.class)
    public void test02() {
        csf2 = new CubicSplineFast(-999);
        assertNull(csf2);
    }
    @Test
    public void test03() {
        csf3 = new CubicSplineFast(3);        
        assertNotNull(csf3);
    }
    @Test
    public void test04() {
        csf4 = new CubicSplineFast(232);        
        assertNotNull(csf4);
    }
    @Test
    public void test05() {
        csf5 = new CubicSplineFast(1298721);  
        assertNotNull(csf5);
    }
}
