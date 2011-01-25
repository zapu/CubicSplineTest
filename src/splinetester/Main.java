package splinetester;

import java.text.DecimalFormat;


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
        MatlabInterpolationTest test1 = new MatlabInterpolationTest();
        test1.setPoints(range(-2, 2, 0.5), new MathExpression() {
            public double y(double x) {
                return x*x + x*x*x;
            }
        });

        test1.setTestPoints(range(-3, 2, 0.05));
        System.out.println(test1.generateM());
    }
}
