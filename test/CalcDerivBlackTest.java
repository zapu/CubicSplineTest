import flanagan.interpolation.CubicSplineFast;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Math.*;

public class CalcDerivBlackTest
{
    /**
     * Test of calcDeriv method, of class CubicSplineFast
     * using function sinus.
     */
    @Test
    public void testCalcDeriv1() {
        double x[] = {0.0D, 0.5*java.lang.Math.PI, java.lang.Math.PI,
                        1.5*java.lang.Math.PI, 2.0*java.lang.Math.PI};
        double y[] = new double[x.length];
        double expectedDeriv[] = new double[x.length];
        for( int i = 0; i < x.length; i++ ) {
            y[i] = java.lang.Math.sin( x[i] );
            expectedDeriv[i] = -y[i];
        }
        CubicSplineFast instance = new CubicSplineFast(x, y);
        instance.calcDeriv();
        assertArrayEquals( expectedDeriv, instance.d2ydx2, 0.001D );
    }

    /**
     * Test of calcDeriv method, of class CubicSplineFast
     * using const function.
     */
    @Test
    public void testCalcDeriv2() {
        double x[] = {-2.0D, -1.0d, 0.0D, 1.0D, 2.0D};
        double y[] = new double[x.length];
        double expectedDeriv[] = new double[x.length];
        for( int i = 0; i < x.length; i++ ) {
            y[i] = 2.0D;
            expectedDeriv[i] = 0.0D;
        }
        CubicSplineFast instance = new CubicSplineFast(x, y);
        instance.calcDeriv();
        assertArrayEquals( expectedDeriv, instance.d2ydx2, 0.001D );
    }

    /**
     * Test of calcDeriv method, of class CubicSplineFast
     * using 1/x^3 function.
     */
    @Test
    public void testCalcDeriv3() {
        double x[] = {-1.0D, -0.8D, -0.6D, -0.4D, -0.2D, -0.1D};
        double y[] = new double[x.length];
        double expectedDeriv[] = new double[x.length];
        for( int i = 0; i < x.length; i++ ) {
            y[i] = java.lang.Math.pow( x[i], -3.0D);
            expectedDeriv[i] = 12*java.lang.Math.pow( x[i], -5.0D); //12x^-5
        }
        CubicSplineFast instance = new CubicSplineFast(x, y);
        instance.calcDeriv();
        for( int i = 0; i< x.length; i++ ) {
            System.out.println( expectedDeriv[i] + " ? " + instance.d2ydx2[i] );
        }
        assertArrayEquals( expectedDeriv, instance.d2ydx2, 0.001D );
    }

    private static void assertArrayEquals(double[] expectedDeriv, double[] d2ydx2, double d)
    {
        for(int i = 0; i < expectedDeriv.length; i++)
        {
            assertEquals(expectedDeriv[i], d2ydx2[i], d);
        }
    }


}