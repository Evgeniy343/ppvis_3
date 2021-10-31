package model;

import function_interface.Factorial;
import function_interface.FunctionB;

public class FunctionBModel implements FunctionB {
    private final double y;
    private double x;
    private static final double h = 0.1;
    private static final double e = 0.0001;

    public FunctionBModel(double n, double[] a) {
        this.y = evaluateExpression(n, a);
    }


    @Override
    public double evaluateExpression(double n, double[] a) {
        Factorial fact = new FactorialModel();
        double result = 0;
        for (int k = 0; k < n; k++) {
            for (x = a[0]; x < a[1]; x += h) {
                result = result + (fact.factorial(2 * k) + Math.abs(x)) / fact.factorial(Math.pow(k, 2));
            }
        }
        return result;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getX() {
        return x;
    }
}
