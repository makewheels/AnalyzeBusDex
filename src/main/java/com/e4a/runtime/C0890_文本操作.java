package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.文本操作 */
public final class C0890_文本操作 {
    private C0890_文本操作() {
    }

    @SimpleFunction
    /* renamed from: 寻找文本 */
    public static int m6821(String str1, String str2, int start) {
        if (start < 0 || start > str1.length() || bi_常量类.f6358b_空串.equals(str1) || bi_常量类.f6358b_空串.equals(str2)) {
            return -1;
        }
        return str1.indexOf(str2, start);
    }

    @SimpleFunction
    /* renamed from: 倒找文本 */
    public static int m6805(String str1, String str2, int start) {
        if (start < 0 || start > str1.length() || bi_常量类.f6358b_空串.equals(str1) || bi_常量类.f6358b_空串.equals(str2)) {
            return -1;
        }
        return str1.lastIndexOf(str2, start);
    }

    @SimpleFunction
    /* renamed from: 到小写 */
    public static String m6811(String str) {
        return str.toLowerCase();
    }

    @SimpleFunction
    /* renamed from: 到大写 */
    public static String m6810(String str) {
        return str.toUpperCase();
    }

    @SimpleFunction
    /* renamed from: 取文本左边 */
    public static String m6816(String str, int len) {
        if (bi_常量类.f6358b_空串.equals(str) || len <= 0) {
            return bi_常量类.f6358b_空串;
        }
        return len <= str.length() ? str.substring(0, len) : str;
    }

    @SimpleFunction
    /* renamed from: 取文本右边 */
    public static String m6815(String str, int len) {
        if (bi_常量类.f6358b_空串.equals(str) || len <= 0) {
            return bi_常量类.f6358b_空串;
        }
        return len <= str.length() ? str.substring(str.length() - len, str.length()) : str;
    }

    @SimpleFunction
    /* renamed from: 取文本中间 */
    public static String m6814_截取子串(String str, int start, int len) {
        if (bi_常量类.f6358b_空串.equals(str) || start < 0 || len <= 0 || start > str.length()) {
            return bi_常量类.f6358b_空串;
        }
        int end = start + len;
        if (end > str.length()) {
            end = str.length();
        }
        return str.substring(start, end);
    }

    @SimpleFunction
    /* renamed from: 取文本长度 */
    public static int m6817_获取字符串长度(String str) {
        return str.length();
    }

    @SimpleFunction
    /* renamed from: 取文本长度2 */
    public static int m68182(String str) {
        return str.getBytes().length;
    }

    @SimpleFunction
    /* renamed from: 删首尾空 */
    public static String m6808_trim删除首尾空格(String str) {
        return str.trim();
    }

    @SimpleFunction
    /* renamed from: 删首空 */
    public static String m6809(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        int i = 0;
        while (i < chars.length && chars[i] == ' ') {
            i++;
            count++;
        }
        String s = str;
        if (count > 0) {
            return new String(chars, count, chars.length - count);
        }
        return s;
    }

    @SimpleFunction
    /* renamed from: 删尾空 */
    public static String m6807(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        int i = chars.length - 1;
        while (i > 0 && chars[i] == ' ') {
            i--;
            count++;
        }
        String s = str;
        if (count > 0) {
            return new String(chars, 0, chars.length - count);
        }
        return s;
    }

    @SimpleFunction
    /* renamed from: 子文本替换 */
    public static String m6819(String str, String find, String replace) {
        if (bi_常量类.f6358b_空串.equals(find) || bi_常量类.f6358b_空串.equals(str)) {
            return bi_常量类.f6358b_空串;
        }
        return str.replaceAll("\\Q" + find + "\\E", replace);
    }

    @SimpleFunction
    /* renamed from: 子文本替换2 */
    public static String m68202(String str, int start, int end, String replace) {
        if (bi_常量类.f6358b_空串.equals(str) || start < 0 || start > str.length() || end < start || end > str.length()) {
            return bi_常量类.f6358b_空串;
        }
        return str.substring(0, start) + replace + str.substring(end + 1);
    }

    @SimpleFunction
    /* renamed from: 文本比较 */
    public static int m6822(String str1, String str2) {
        return str1.compareTo(str2);
    }

    @SimpleFunction
    /* renamed from: 翻转文本 */
    public static String m6823(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    @SimpleFunction
    /* renamed from: 分割文本 */
    public static String[] m6806_分割字符串(String str, String separator) {
        if (bi_常量类.f6358b_空串.equals(separator) || bi_常量类.f6358b_空串.equals(str)) {
            return new String[0];
        }
        if (separator.equals("\n")) {
            str = C0890_文本操作.m6819(str, "\r", bi_常量类.f6358b_空串);
        }
        if (C0890_文本操作.m6815(str, C0890_文本操作.m6817_获取字符串长度(separator)).equals(separator)) {
            return C0890_文本操作.m6812(separator + str, separator, separator);
        }
        return C0890_文本操作.m6812(separator + str + separator, separator, separator);
    }

    @SimpleFunction
    /* renamed from: 取指定文本 */
    public static String[] m6812(String str, String left, String right) {
        if (bi_常量类.f6358b_空串.equals(str) || bi_常量类.f6358b_空串.equals(left) || bi_常量类.f6358b_空串.equals(right)) {
            return new String[0];
        }
        return C0892.m6854(str, "(?<=\\Q" + left + "\\E).*?(?=\\Q" + right + "\\E)");
    }

    @SimpleFunction
    /* renamed from: 取指定文本2 */
    public static String m68132(String str, String left, String right) {
        String[] temp = C0890_文本操作.m6812(str, left, right);
        if (temp.length > 0) {
            return temp[0];
        }
        return bi_常量类.f6358b_空串;
    }
}
