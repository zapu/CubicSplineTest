import flanagan.interpolation.CubicSplineFast;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Math.*;

public class ZeroTest
{
    /**
     * Test of zero method, of class CubicSplineFast
     * in case of passing illegal argument.
     */
    @Test
    public void testZero1() {
        System.out.println("zero - n < 3");
        int n = 0;
        try{
            CubicSplineFast result = CubicSplineFast.zero(n);
            fail("Expected exception not thrown!");
        } catch (IllegalArgumentException e) {
            ; //Expected
        }
    }

    /**
     * Test of zero method, of class CubicSplineFast
     * in case of passing legal argument
     * and returning an object with fields of expected size or value.
     */
    @Test
    public void testZero2() {
        System.out.println("zero - n > 3");
        int n = 3;
        try{
            CubicSplineFast result = CubicSplineFast.zero(n);
            assertEquals( n, result.nPoints );
            assertEquals( n, result.x.length );
            assertEquals( n, result.y.length );
            assertEquals( n, result.d2ydx2.length );
            assertEquals( false, result.derivCalculated );
            for( int i = 0; i < n; i++ ){
                assertEquals( 0.0D, result.x[i], 0.001D );
                assertEquals( 0.0D, result.y[i], 0.001D );
                assertEquals( 0.0D, result.d2ydx2[i], 0.001D );
            }
        } catch (IllegalArgumentException e) {
            fail("Unexpected exception thrown!");
        }
    }

}
