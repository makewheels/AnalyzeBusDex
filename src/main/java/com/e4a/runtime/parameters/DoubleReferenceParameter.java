package com.e4a.runtime.parameters;

public final class DoubleReferenceParameter extends ReferenceParameter {
    private double value;

    public DoubleReferenceParameter(double value) {
        set(value);
    }

    public double get() {
        return this.value;
    }

    public void set(double value) {
        this.value = value;
    }
}
