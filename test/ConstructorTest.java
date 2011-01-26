import flanagan.interpolation.CubicSplineFast;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConstructorTest {

    public static final double eps = 100 * Double.MIN_VALUE;

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void test01() {
        double[] x = new double[] { };
        double[] y = new double[] { };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void test02() {
        double[] x = new double[] { 1 };
        double[] y = new double[] { 2 };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }

    @Test
    public void test03() {
        double[] x = new double[] { 1, 3 };
        double[] y = new double[] { 2, 1 };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void test04() {
        double[] x = new double[] { 1, 2, 3, 4 };
        double[] y = new double[] { 2, 1, 3 };
        CubicSplineFast csf = new CubicSplineFast(x, y);
    }
}
