import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import flanagan.interpolation.CubicSplineFast;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

class KnotTestParameter
{
    public KnotTestParameter(double[] x, double[] y)
    {
        this.x = x;
        this.y = y;
    }

    public double[] x;
    public double[] y;
}

@RunWith(value = Parameterized.class)
public class KnotTest
{
    KnotTestParameter param;

    public KnotTest(KnotTestParameter param)
    {
        this.param = param;
    }

    @Parameters
    public static Collection<Object[]> params()
    {
        List<Object[]> list = new LinkedList<Object[]>();

        list.add(new Object[] { new KnotTestParameter(new double[] { 1, 2, 3 }, new double[] { 5, 5, 5 }) });

        return list;
    }

    @Test
    public void testKnot()
    {
        CubicSplineFast spline = new CubicSplineFast(param.x, param.y);
        for(int i = 0; i < param.x.length; i++)
        {
            assertEquals(param.y[i], spline.interpolate(param.x[i]), 0.000000001);
        }
    }

}