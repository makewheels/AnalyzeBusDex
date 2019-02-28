package com.e4a.runtime.parameters;

public final class ByteReferenceParameter extends ReferenceParameter {
    private byte value;

    public ByteReferenceParameter(byte value) {
        set(value);
    }

    public byte get() {
        return this.value;
    }

    public void set(byte value) {
        this.value = value;
    }
}
