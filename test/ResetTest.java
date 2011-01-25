import flanagan.interpolation.CubicSplineFast;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResetTest
{
    static public final double eps = 0.00000001;

    //Black-box tests
    @Test
    public void resetData_Test(){
        double[] expected_x = new double[]{1, 2, 3};
        double[] expected_y = new double[]{1, 2, 3};
        CubicSplineFast cs = new CubicSplineFast(3);

        cs.resetData(expected_x, expected_y);
        for(int i=0; i<cs.nPoints; i++){
            assertEquals(expected_x[i], cs.x[i], eps);
        }
        for(int i=0; i<cs.nPoints; i++){
            assertEquals(expected_y[i], cs.y[i], eps);
        }
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void resetData_Test2(){
        double[] expected_x = new double[]{1, 2, 3};
        double[] expected_y = new double[]{1, 2, 3};
        CubicSplineFast cs = new CubicSplineFast(10);

        cs.resetData(expected_x, expected_y);
        for(int i=0; i<cs.nPoints; i++){
            assertEquals(expected_x[i], cs.x[i], eps);
        }
        for(int i=0; i<cs.nPoints; i++){
            assertEquals(expected_y[i], cs.y[i], eps);
        }
    }
}
