package com.e4a.runtime.parameters;

public final class StringReferenceParameter extends ReferenceParameter {
    private String value;

    public StringReferenceParameter(String value) {
        set(value);
    }

    public String get() {
        return this.value;
    }

    public void set(String value) {
        this.value = value;
    }
}
