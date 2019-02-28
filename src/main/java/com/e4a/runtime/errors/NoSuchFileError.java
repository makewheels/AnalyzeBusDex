package com.e4a.runtime.errors;

import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
public final class NoSuchFileError extends RuntimeError {
    public NoSuchFileError(String message) {
        super(message);
    }
}
