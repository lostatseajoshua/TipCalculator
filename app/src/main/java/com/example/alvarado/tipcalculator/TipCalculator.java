package com.example.alvarado.tipcalculator;

/**
 * Created by alvarado on 11/7/16.
 */

public class TipCalculator {
    @org.jetbrains.annotations.Contract(pure = true)
    public static double getPercentageOfNumber(double percent, double number) {
        return (percent / 100) *  number;
    }
}
