package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
/* renamed from: com.e4a.runtime.位运算 */
public final class C0842 {
    private C0842() {
    }

    @SimpleFunction
    /* renamed from: 位与 */
    public static int m6596(int par1, int par2) {
        return par1 & par2;
    }

    @SimpleFunction
    /* renamed from: 位或 */
    public static int m6600(int par1, int par2) {
        return par1 | par2;
    }

    @SimpleFunction
    /* renamed from: 位异或 */
    public static int m6599(int par1, int par2) {
        return par1 ^ par2;
    }

    @SimpleFunction
    /* renamed from: 位非 */
    public static int m6601(int par1) {
        return par1 ^ -1;
    }

    @SimpleFunction
    /* renamed from: 位左移 */
    public static int m6598(int par1, int par2) {
        return par1 << par2;
    }

    @SimpleFunction
    /* renamed from: 位右移 */
    public static int m6597(int par1, int par2) {
        return par1 >> par2;
    }

    @SimpleFunction
    /* renamed from: 无符号位右移 */
    public static int m6602(int par1, int par2) {
        return par1 >>> par2;
    }
}
