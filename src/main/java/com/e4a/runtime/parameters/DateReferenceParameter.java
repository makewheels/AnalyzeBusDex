package com.e4a.runtime.parameters;

import java.util.Calendar;

public final class DateReferenceParameter extends ReferenceParameter {
    private Calendar value;

    public DateReferenceParameter(Calendar value) {
        set(value);
    }

    public Calendar get() {
        return this.value;
    }

    public void set(Calendar value) {
        this.value = value;
    }
}
