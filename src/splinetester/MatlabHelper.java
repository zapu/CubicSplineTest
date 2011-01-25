package splinetester;

/**
 *
 * @author zapu
 */
public class MatlabHelper
{
    public static String array(String name, double arr[])
    {
        String expr = name + " = [";
        for(int i = 0; i < arr.length-1; i++)
            expr += arr[i] + ", ";
        expr += arr[arr.length-1] + "];";
        return expr;
    }
}
