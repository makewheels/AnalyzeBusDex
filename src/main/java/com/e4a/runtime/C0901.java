package com.e4a.runtime;

import android.graphics.Color;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
/* renamed from: com.e4a.runtime.颜色值操作 */
public final class C0901 {
    private C0901() {
    }

    @SimpleFunction
    /* renamed from: 到颜色值 */
    public static int m6968(int a, int r, int g, int b) {
        return Color.argb(a, r, g, b);
    }

    @SimpleFunction
    /* renamed from: 取阿尔法值 */
    public static int m6972(int color) {
        return Color.alpha(color);
    }

    @SimpleFunction
    /* renamed from: 取红色值 */
    public static int m6969(int color) {
        return Color.red(color);
    }

    @SimpleFunction
    /* renamed from: 取绿色值 */
    public static int m6970(int color) {
        return Color.green(color);
    }

    @SimpleFunction
    /* renamed from: 取蓝色值 */
    public static int m6971(int color) {
        return Color.blue(color);
    }
}
