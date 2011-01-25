import flanagan.interpolation.CubicSplineFast;
import org.junit.Test;
import static org.junit.Assert.*;

public class DarrayTest
{
    /**
     * Test of oneDarray method, of class CubicSplineFast
     * in case of returning array of expected size.
     */
    @Test
    public void testOneDarray1() {
        int n = 0;
        int m = 1;
        CubicSplineFast[] result = CubicSplineFast.oneDarray(n, m);
        assertEquals( n, result.length );
    }

    /**
     * Test of oneDarray method, of class CubicSplineFast
     * in case of returning array of expected size.
     */
    @Test
    public void testOneDarray2() {
        int n = 5;
        int m = 3;
        CubicSplineFast[] result = CubicSplineFast.oneDarray(n, m);
        assertEquals( n, result.length );
    }
}
