package com.e4a.runtime.parameters;

public final class BooleanReferenceParameter extends ReferenceParameter {
    private boolean value;

    public BooleanReferenceParameter(boolean value) {
        set(value);
    }

    public boolean get() {
        return this.value;
    }

    public void set(boolean value) {
        this.value = value;
    }
}
