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

        list.add(new Object[] { new KnotTestParameter(
            new double[] { 1, 1.8, 2.6, 3.4, 4.2, 5, 5.8 },
            new double[] { 0.6664, 0.5621, 0.8700, 0.9675, 0.6436, 0.5744, 0.8940 }) });

        list.add(new Object[] { new KnotTestParameter(
            new double[] { -2, -1, 0, 1 },
            new double[] { 0.25, 0.5, 1, 2 }) });

        list.add(new Object[] { new KnotTestParameter(
            new double[] { 1, 2, 3, 4, 5 },
            new double[] { 3, -1, -15, -45, -97 }) });

        list.add(new Object[] { new KnotTestParameter(
            new double[] {-3,-2.3,-1.6,-0.9,-0.2,0.5,1.2,1.9,2.6,3.3,4,4.7 },
            new double[] {-0.138309623325406,-0.33103624414123,-0.000852248551416128,-0.302676697465328,
                -0.190827951047524,0.369230131302064,0.122379660668094,0.0989036362724439,
                0.378511179299017,-0.153820396979642,-0.323343853327091,-0.000153467204045813 }) });
        
        return list;
    }

    @Test
    public void testKnot()
    {
        System.out.println();
        CubicSplineFast spline = new CubicSplineFast(param.x, param.y);
        for(int i = 0; i < param.x.length; i++)
        {
            System.out.println(param.x[i] + ": " + param.y[i] + " " + spline.interpolate(param.x[i]));
            assertEquals(param.y[i], spline.interpolate(param.x[i]), 0.001);
        }
    }

}