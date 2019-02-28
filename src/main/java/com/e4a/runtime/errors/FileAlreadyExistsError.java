package com.e4a.runtime.errors;

import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
public final class FileAlreadyExistsError extends RuntimeError {
    public FileAlreadyExistsError(String message) {
        super(message);
    }
}
