package com.e4a.runtime.android;

import android.content.Context;
import android.util.Log;
import com.e4a.runtime.LogFunctions;

public final class LogImpl implements LogFunctions {
    public LogImpl(Context context) {
    }

    public void error(String moduleName, String message) {
        Log.e(moduleName, message);
    }

    public void info(String moduleName, String message) {
        Log.i(moduleName, message);
    }

    public void warning(String moduleName, String message) {
        Log.w(moduleName, message);
    }
}
