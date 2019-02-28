package com.e4a.runtime.variants;

public final class UninitializedVariant extends Variant {
    private static UninitializedVariant UNINITIALIZED_VARIANT = new UninitializedVariant();

    public static final UninitializedVariant getUninitializedVariant() {
        return UNINITIALIZED_VARIANT;
    }

    private UninitializedVariant() {
        super((byte) 0);
    }
}
