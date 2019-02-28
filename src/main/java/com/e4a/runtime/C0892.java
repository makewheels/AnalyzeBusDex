package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.正则表达式 */
public final class C0892 {
    private static Matcher matcher = null;
    private static Pattern pattern = null;

    private C0892() {
    }

    @SimpleFunction
    /* renamed from: 正则匹配 */
    public static String[] m6854(String text, String statement) {
        Matcher mr = Pattern.compile(statement, 40).matcher(text);
        List<String> list = new ArrayList();
        while (mr.find()) {
            list.add(mr.group());
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    @SimpleFunction
    /* renamed from: 创建表达式 */
    public static void m6846(String statement, boolean insensitive, boolean multiline) {
        if (insensitive && multiline) {
            pattern = Pattern.compile(statement, 10);
        } else if (!insensitive && !multiline) {
            pattern = Pattern.compile(statement);
        } else if (insensitive && !multiline) {
            pattern = Pattern.compile(statement, 2);
        } else if (!insensitive && multiline) {
            pattern = Pattern.compile(statement, 8);
        }
    }

    @SimpleFunction
    /* renamed from: 全部分割 */
    public static String[] m6844(String text) {
        if (pattern != null) {
            return pattern.split(text);
        }
        return new String[0];
    }

    @SimpleFunction
    /* renamed from: 开始匹配 */
    public static void m6853(String text) {
        if (pattern != null) {
            matcher = pattern.matcher(text);
        }
    }

    @SimpleFunction
    /* renamed from: 全部替换 */
    public static String m6845(String text) {
        if (matcher != null) {
            return matcher.replaceAll(text);
        }
        return bi_常量类.f6358b_空串;
    }

    @SimpleFunction
    /* renamed from: 匹配下一个 */
    public static boolean m6847() {
        if (matcher != null) {
            return matcher.find();
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 取匹配文本 */
    public static String m6849() {
        if (matcher != null) {
            return matcher.group();
        }
        return bi_常量类.f6358b_空串;
    }

    @SimpleFunction
    /* renamed from: 取匹配开始位置 */
    public static int m6848() {
        if (matcher != null) {
            return matcher.start();
        }
        return 0;
    }

    @SimpleFunction
    /* renamed from: 取匹配结束位置 */
    public static int m6850() {
        if (matcher != null) {
            return matcher.end();
        }
        return 0;
    }

    @SimpleFunction
    /* renamed from: 取子匹配数量 */
    public static int m6851() {
        if (matcher != null) {
            return matcher.groupCount();
        }
        return 0;
    }

    @SimpleFunction
    /* renamed from: 取子匹配文本 */
    public static String m6852(int 索引) {
        if (matcher != null) {
            return matcher.group(索引);
        }
        return bi_常量类.f6358b_空串;
    }
}
