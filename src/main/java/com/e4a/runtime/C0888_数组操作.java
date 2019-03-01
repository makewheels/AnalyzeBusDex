package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.variants.Variant;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.数组操作 */
public final class C0888_数组操作 {
    private C0888_数组操作() {
    }

    @SimpleFunction
    /* renamed from: 过滤数组 */
    public static String[] m6774(String[] array, String str, boolean include) {
        if (str == null || array == null) {
            return new String[0];
        }
        Set<String> result = new HashSet();
        for (String a : array) {
            if (a.contains(str) == include) {
                result.add(a);
            }
        }
        return (String[]) result.toArray(new String[result.size()]);
    }

    @SimpleFunction
    /* renamed from: 连接数组成员 */
    public static String m6775(String[] array, String separator) {
        if (separator == null || array == null) {
            return bi_常量类.f6358b_空串;
        }
        StringBuilder sb = new StringBuilder();
        String sep = bi_常量类.f6358b_空串;
        for (String a : array) {
            sb.append(sep).append(a);
            sep = separator;
        }
        return sb.toString();
    }

    @SimpleFunction
    /* renamed from: 取数组下标 */
    public static int m6768(Variant array, int dim) {
        if (dim <= 0) {
            return 0;
        }
        Object arr = array.getArray();
        if (arr == null) {
            return 0;
        }
        while (true) {
            dim--;
            if (dim <= 0) {
                return Array.getLength(arr);
            }
            arr = Array.get(arr, 0);
        }
    }

    @SimpleFunction
    /* renamed from: 取数组成员数 */
    public static int m6769_取数组成员数(Variant array) {
        return C0888_数组操作.m6768(array, 1);
    }

    @SimpleFunction
    /* renamed from: 合并字节数组 */
    public static byte[] m6770(byte[] array1, byte[] array2) {
        if (array1 == null && array2 != null) {
            return array2;
        }
        if (array1 != null && array2 == null) {
            return array1;
        }
        if (array1 == null && array2 == null) {
            return null;
        }
        byte[] array3 = new byte[(array1.length + array2.length)];
        System.arraycopy(array1, 0, array3, 0, array1.length);
        System.arraycopy(array2, 0, array3, array1.length, array2.length);
        return array3;
    }

    @SimpleFunction
    /* renamed from: 合并文本数组 */
    public static String[] m6771(String[] array1, String[] array2) {
        if (array1 == null && array2 != null) {
            return array2;
        }
        if (array1 != null && array2 == null) {
            return array1;
        }
        if (array1 == null && array2 == null) {
            return null;
        }
        String[] array3 = new String[(array1.length + array2.length)];
        System.arraycopy(array1, 0, array3, 0, array1.length);
        System.arraycopy(array2, 0, array3, array1.length, array2.length);
        return array3;
    }

    @SimpleFunction
    /* renamed from: 复制数组 */
    public static void m6772(Variant src, int srcPos, Variant dest, int destPos, int length) {
        if (src != null && dest != null) {
            System.arraycopy(src.getArray(), srcPos, dest.getArray(), destPos, length);
        }
    }

    @SimpleFunction
    /* renamed from: 数组排序 */
    public static int[] m6773(int[] src) {
        if (src == null) {
            return new int[0];
        }
        Arrays.sort(src);
        return src;
    }
}
