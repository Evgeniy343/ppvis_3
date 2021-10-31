package model;

import function_interface.Factorial;

public class FactorialModel implements Factorial {
    @Override
    public double factorial(double fact) {
        if (fact <= 1) {
            return 1;
        } else {
            return fact * factorial(fact - 1);
        }
    }
}
