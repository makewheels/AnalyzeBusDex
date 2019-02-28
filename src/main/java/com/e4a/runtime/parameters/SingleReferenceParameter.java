package com.e4a.runtime.parameters;

public final class SingleReferenceParameter extends ReferenceParameter {
    private float value;

    public SingleReferenceParameter(float value) {
        set(value);
    }

    public float get() {
        return this.value;
    }

    public void set(float value) {
        this.value = value;
    }
}
