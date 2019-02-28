package com.e4a.runtime.helpers;

import java.util.regex.Pattern;

public final class ExprHelpers {
    private ExprHelpers() {
    }

    public static float idiv(float leftOp, float rightOp) {
        return (float) Math.floor((double) (leftOp / rightOp));
    }

    public static double idiv(double leftOp, double rightOp) {
        return Math.floor(leftOp / rightOp);
    }

    public static boolean like(String string, String pattern) {
        return Pattern.matches(pattern, string);
    }

    public static int pow(int leftOp, int rightOp) {
        return (int) Math.pow((double) leftOp, (double) rightOp);
    }

    public static float pow(float leftOp, float rightOp) {
        return (float) Math.pow((double) leftOp, (double) rightOp);
    }
}
