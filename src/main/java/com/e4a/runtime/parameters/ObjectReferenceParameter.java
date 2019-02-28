package com.e4a.runtime.parameters;

public class ObjectReferenceParameter<T> extends ReferenceParameter {
    private T value;

    public ObjectReferenceParameter(T value) {
        set(value);
    }

    public T get() {
        return this.value;
    }

    public void set(T value) {
        this.value = value;
    }
}
