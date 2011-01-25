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
        /*for( int i = 0; i< x.length; i++ ) {
            System.out.println( expectedDeriv[i] + " ? " + instance.d2ydx2[i] );
        }*/
        assertArrayEquals( expectedDeriv, instance.d2ydx2, 0.001D );
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void calcDeriv_WithOnePointTest() {
        double[] x3 = new double[]{1};
        double[] y3 = new double[]{4};
        new CubicSplineFast(x3, y3);
    }

    @Test
    public void calcDeriv_WithTwoPointsTest() {
        double[] x3 = new double[]{1, 3};
        double[] y3 = new double[]{4, 5};
        new CubicSplineFast(x3, y3);
    }

    @Test
    public void calcDeriv_WithThreePointsTest() {
        double[] x3 = new double[]{1, 3, 5};
        double[] y3 = new double[]{4, 5, 6};
        new CubicSplineFast(x3, y3);
    }

    private static void assertArrayEquals(double[] arrayA, double[] arrayB, double delta)
    {
        assertEquals(arrayA.length, arrayB.length);
        for(int i = 0; i < arrayA.length; i++)
        {
            assertEquals(arrayA[i], arrayB[i], delta);
        }
    }


}