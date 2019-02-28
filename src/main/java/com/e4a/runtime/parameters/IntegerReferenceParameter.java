package com.e4a.runtime.parameters;

public final class IntegerReferenceParameter extends ReferenceParameter {
    private int value;

    public IntegerReferenceParameter(int value) {
        set(value);
    }

    public int get() {
        return this.value;
    }

    public void set(int value) {
        this.value = value;
    }
}
