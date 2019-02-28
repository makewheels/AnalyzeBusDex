package com.e4a.runtime.parameters;

public final class ShortReferenceParameter extends ReferenceParameter {
    private short value;

    public ShortReferenceParameter(short value) {
        set(value);
    }

    public short get() {
        return this.value;
    }

    public void set(short value) {
        this.value = value;
    }
}
