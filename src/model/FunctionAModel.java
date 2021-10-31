package model;

import function_interface.FunctionA;

public class FunctionAModel implements FunctionA {
    private final double y;
    private final double x;

    public FunctionAModel(double x) {
        this.x = x;
        this.y = evaluateExpression(x);
    }

    @Override
    public double evaluateExpression(double x) {
        return 4 * x - 3;
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
