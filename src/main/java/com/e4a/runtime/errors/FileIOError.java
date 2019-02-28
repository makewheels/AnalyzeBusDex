package com.e4a.runtime.errors;

import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
public final class FileIOError extends RuntimeError {
    public FileIOError(String message) {
        super(message);
    }
}
