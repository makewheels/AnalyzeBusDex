package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.errors.AssertionFailure;
import com.e4a.runtime.variants.Variant;

@SimpleObject
public class Assertions {
    private Assertions() {
    }

    @SimpleFunction
    public static void AssertTrue(Variant expression) {
        if (!expression.getBoolean()) {
            throw new AssertionFailure();
        }
    }

    @SimpleFunction
    public static void AssertFalse(Variant expression) {
        if (expression.getBoolean()) {
            throw new AssertionFailure();
        }
    }
}
