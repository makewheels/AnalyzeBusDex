package com.e4a.runtime.parameters;

public final class LongReferenceParameter extends ReferenceParameter {
    private long value;

    public LongReferenceParameter(long value) {
        set(value);
    }

    public long get() {
        return this.value;
    }

    public void set(long value) {
        this.value = value;
    }
}
