import flanagan.interpolation.CubicSplineFast;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConstructorTest {

    public static final double eps = 100 * Double.MIN_VALUE;

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void emptyArray() {
        double[] x = new double[] { };
        double[] y = new double[] { };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void oneElementArray() {
        double[] x = new double[] { 1 };
        double[] y = new double[] { 2 };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }

    @Test
    public void twoElementArray() {
        double[] x = new double[] { 1, 3 };
        double[] y = new double[] { 2, 1 };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }

    @Test
    public void normalArray() {
        double[] x = new double[] { 1, 2, 3, 4, 5 };
        double[] y = new double[] { 2, 1, 2, 1, 0 };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void differenyArrays() {
        double[] x = new double[] { 1, 2, 3, 4 };
        double[] y = new double[] { 2, 1, 3 };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }
}
