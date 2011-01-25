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

    public static double[] twotworange = new double[] {
        -2, -1.9, -1.8, -1.7, -1.6, -1.5,
        -1.4, -1.3, -1.2, -1.1, -1, -0.9,
        -0.8, -0.7, -0.6, -0.5, -0.4, -0.3,
        -0.2, -0.1, 0.1, 0.2, 0.3, 0.4, 0.5,
        0.6, 0.7, 0.8, 0.9, 1, 1.1, 1.2, 1.3,
        1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2
    };

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
                range(-3, 3, 0.05)));

        interps.add(new MatlabInterpolationTest(
                range(-3, 5, 0.1),
                new MathExpression() {
                    public double y(double x) {
                        return x*x*x + x*x;
                    }
                },
                range(-3, 5, 0.05)));

        interps.add(new MatlabInterpolationTest(
                twotworange,
                new MathExpression() {
                    public double y(double x) {
                        return Math.pow(x, -3);
                    }
                },
                range(-0.5, 0.5, 0.01)));

        for(MatlabInterpolationTest interp : interps)
        {
            System.out.println(interp.generateM());
        }
    }
}
