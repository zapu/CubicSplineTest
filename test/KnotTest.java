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

        list.add(new Object[] { new KnotTestParameter(
                    new double[] { 1, 2, 3 },
                    new double[] { 5, 5, 5 }) });

        list.add(new Object[] { new KnotTestParameter(
                    new double[] { 0.2, 0.5, 0.8, 0.12, 0.15 },
                    new double[] { 0.1987, 0.4794, 0.7174, 0.1197, 0.1494 }) });
        
        return list;
    }

    @Test
    public void testKnot()
    {
        CubicSplineFast spline = new CubicSplineFast(param.x, param.y);
        for(int i = 0; i < param.x.length; i++)
        {
            //System.out.println(param.x[i] + ": " + param.y[i] + " " + spline.interpolate(param.x[i]));
            assertEquals(param.y[i], spline.interpolate(param.x[i]), 0.000001);
        }
    }

}