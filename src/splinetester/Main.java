package splinetester;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;


public class Main
{
    public static double[] range(double start, double end, double step) {

        double[] out = new double[(int) Math.floor((end - start) / step) + 1];
        for (int i = 0; i < out.length; i++) {
            out[i] = start + step * i;
        }
        return out;
    }

    public static void main(String[] args)
    {
        List<MatlabInterpolationTest> interps = new LinkedList<MatlabInterpolationTest>();

        interps.add(new MatlabInterpolationTest(
                range(-5, 5, 0.1),
                new MathExpression() {
                    public double y(double x) {
                        return Math.sin(x);
                    }
                },
                range(-5, 5, 0.05)));

        interps.add(new MatlabInterpolationTest(
                range(-2, 2, 0.1),
                new MathExpression() {
                    public double y(double x) {
                        return Math.sin(x);
                    }
                },
                range(-0.5, 0.5, 0.3)));

        for(MatlabInterpolationTest interp : interps)
        {
            System.out.println(interp.generateM());
        }
    }
}
