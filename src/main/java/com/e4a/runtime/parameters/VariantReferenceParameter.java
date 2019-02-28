package com.e4a.runtime.parameters;

import com.e4a.runtime.variants.Variant;

public final class VariantReferenceParameter extends ReferenceParameter {
    private Variant value;

    public VariantReferenceParameter(Variant value) {
        set(value);
    }

    public Variant get() {
        return this.value;
    }

    public void set(Variant value) {
        this.value = value;
    }
}
