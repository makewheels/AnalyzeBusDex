package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
public final class Log {
    public static final String MODULE_NAME_RTL = "Simple Runtime Library";
    private static LogFunctions logFunctions;

    private Log() {
    }

    public static void initialize(LogFunctions functions) {
        logFunctions = functions;
    }

    @SimpleFunction
    public static void Error(String moduleName, String message) {
        logFunctions.error(moduleName, message);
    }

    @SimpleFunction
    public static void Warning(String moduleName, String message) {
        logFunctions.warning(moduleName, message);
    }

    @SimpleFunction
    public static void Info(String moduleName, String message) {
        logFunctions.info(moduleName, message);
    }

    @SimpleFunction
    /* renamed from: 输出调试文本 */
    public static void m5381(String message) {
        logFunctions.info("ActivityManager", message);
    }

    @SimpleFunction
    /* renamed from: 调试输出 */
    public static void m5380(String message) {
        logFunctions.info("ActivityManager", message);
    }
}
