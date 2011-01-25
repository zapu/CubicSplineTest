import flanagan.interpolation.CubicSplineFast;

import org.junit.Test;
import static org.junit.Assert.*;

public class InterpolateTest
{
    public static final double eps = 100 * Double.MIN_VALUE;


    @Test
    public void interpolate_InOutRangeTest() {
        double[] x = new double[]{185.0e-9, 214.0e-9, 275.0e-9, 361.0e-9, 509.0e-9, 589.0e-9, 656.0e-9};
        double[] y = new double[]{1.57464, 1.53386, 1.49634, 1.47503, 1.4619, 1.4583, 1.4564};

        CubicSplineFast cs = new CubicSplineFast(x, y);

        double yy = cs.interpolate(2.5e-7);
        assertEquals(1.5058693318301968, yy, eps);

        yy=cs.interpolate(100e-9);
        assertEquals(1.6136430500055632, yy, eps);
    }

    @Test(expected=IllegalArgumentException.class)
    public void interpolate_SamePointsTest() {
        double[] x = new double[]{0,1,1};
        double[] y = new double[]{1,2,3};
        CubicSplineFast cs = new CubicSplineFast(x, y);
        double xx = 1;
        double yy = cs.interpolate(xx);
        assertEquals(1.5058693318301968, yy, eps);
    }

    @Test
    public void interpolate_PositiveInfTest() {
        double[] x = new double[]{0, 1, 1, 4};
        double[] y = new double[]{1, 2, 3, Double.POSITIVE_INFINITY};
        CubicSplineFast cs = new CubicSplineFast(x, y);
        double xx = 2;
        double yy = cs.interpolate(xx);
        assertEquals(Double.NaN, yy, eps);
    }
}
