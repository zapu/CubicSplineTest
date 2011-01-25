import flanagan.interpolation.CubicSplineFast;
import org.junit.Test;
/**
 *
 * @author Test
 */
public class CalcDerivTest {
    CubicSplineFast csf;
                
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void Test01(){
        double [] x = {0.2};
        double [] y = {0.2};
        csf = new CubicSplineFast(x,y);      
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void Test02(){
        double [] x = {};
        double [] y = {};
        csf = new CubicSplineFast(x,y);      
    }
    @Test
    public void Test03() {
        double [] x = {0.2, 0};
        double [] y = {0, 0.2};
        csf = new CubicSplineFast(x,y);      
    }
    @Test
    public void Test04() {
        double [] x = {0.2, 0.5};
        double [] y = {0.2, 0.5};
        csf = new CubicSplineFast(x,y);      
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void Test05() {
        double [] x = {0, 3, 0.3, 0.3};
        double [] y = {0.3, 0.3, 0.3};
        csf = new CubicSplineFast(x,y);      
    }
    @Test
    public void Test06() {
        double [] x = {3, 0.7, 0.3};
        double [] y = {0.9, 0.3, 0.3, 4, 2.3, 4.2, 5.1};
        csf = new CubicSplineFast(x,y);      
    }
    @Test
    public void Test07() {
        double [] x = {-0.3, 0.3, 0.3};
        double [] y = {0.3, -222, 1/3};
        csf = new CubicSplineFast(x,y);      
    }
    @Test
    public void Test08() {
        double [] x = {0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3};
        double [] y = {0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3, 0.3};
        csf = new CubicSplineFast(x,y);      
    }
    @Test
    public void Test09() {
        double [] x = {1145.4234, 1123.6234, 9124.064, 2234.7735, 31.344, 5232.321312};
        double [] y = {99.23451, 8329.5328, 35.2485, 129843.219438, 5328.123354, 345.2};
        csf = new CubicSplineFast(x,y);      
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void Test10() {
        double [] x = {};
        double [] y = {99.23451, 8329.5328, 35.2485, 129843.219438, 5328.123354, 345.2};
        csf = new CubicSplineFast(x,y);      
    }
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void Test11() {
        double [] x = {1145.4234, 1123.6234, 9124.064, 2234.7735, 31.344, 5232.321312};
        double [] y = {};
        csf = new CubicSplineFast(x,y);      
    }
}
