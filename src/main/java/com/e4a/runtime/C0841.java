package com.e4a.runtime;

import android.content.Context;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
/* renamed from: com.e4a.runtime.上下文操作 */
public final class C0841 {
    public static Context mApplicationContext;

    private C0841() {
    }

    @SimpleFunction
    /* renamed from: 置全局上下文 */
    public static void m6595(Context param) {
        mApplicationContext = param;
    }

    @SimpleFunction
    /* renamed from: 取全局上下文 */
    public static Context m6594() {
        return mApplicationContext;
    }
}
