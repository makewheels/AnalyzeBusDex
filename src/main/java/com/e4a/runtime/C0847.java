package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.math.BigDecimal;

@SimpleObject
/* renamed from: com.e4a.runtime.大数运算 */
public final class C0847 {
    private C0847() {
    }

    @SimpleFunction
    /* renamed from: 大数相加 */
    public static String m6638(String a, String b) {
        return new BigDecimal(a).add(new BigDecimal(b)).toPlainString();
    }

    @SimpleFunction
    /* renamed from: 大数相减 */
    public static String m6637(String a, String b) {
        return new BigDecimal(a).subtract(new BigDecimal(b)).toPlainString();
    }

    @SimpleFunction
    /* renamed from: 大数相乘 */
    public static String m6636(String a, String b) {
        return new BigDecimal(a).multiply(new BigDecimal(b)).toPlainString();
    }

    @SimpleFunction
    /* renamed from: 大数相除 */
    public static String m6639(String a, String b, int scale) {
        return new BigDecimal(a).divide(new BigDecimal(b), scale, 4).toPlainString();
    }

    @SimpleFunction
    /* renamed from: 大数比较 */
    public static int m6634(String a, String b) {
        return new BigDecimal(a).compareTo(new BigDecimal(b));
    }

    @SimpleFunction
    /* renamed from: 大数求余 */
    public static String m6635(String a, String b) {
        return new BigDecimal(a).remainder(new BigDecimal(b)).toPlainString();
    }

    @SimpleFunction
    /* renamed from: 科学转普通计数 */
    public static String m6640(String a) {
        return new BigDecimal(a).toPlainString();
    }
}
