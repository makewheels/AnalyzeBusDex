package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.collections.C0682;
import com.e4a.runtime.variants.StringVariant;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.MySQL操作 */
public final class C0663MySQL {
    private static final char[] CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final int[] IA = new int[256];
    private static C0880_应用操作类 appm;
    private static boolean connected = false;
    private static String mysql_code = "utf8";
    private static String mysql_database = null;
    private static String mysql_host = null;
    private static String mysql_openapi = null;
    private static String mysql_password = null;
    private static String mysql_username = null;
    private static C0897_网络操作 network;
    private static C0890_文本操作 stringm;

    @SimpleFunction
    /* renamed from: MySQL_连接 */
    public static boolean m5395MySQL_(String PHP地址, String 服务器地址, String 用户名, String 密码, String 数据库名) {
        if (PHP地址.equals("e4a")) {
            mysql_openapi = "http://bbs.e4asoft.com/openapi_unsafe.php";
        } else {
            mysql_openapi = PHP地址;
        }
        mysql_host = 服务器地址;
        mysql_username = 用户名;
        mysql_password = 密码;
        mysql_database = 数据库名;
        String str = C0663MySQL.m5396("Connect");
        if (str == null || str.equals(bi_常量类.f6358b_空串)) {
            connected = false;
            return false;
        } else if (C0890_文本操作.m6821_寻找文本(str, "ConnectSucceeded", 0) != -1) {
            connected = true;
            return true;
        } else {
            connected = false;
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: MySQL_取服务器信息 */
    public static String m5386MySQL_(int 欲取类型) {
        if (欲取类型 < 1 || 欲取类型 > 5 || !connected) {
            return bi_常量类.f6358b_空串;
        }
        String str = C0663MySQL.m5396("Getinfo|*|" + 欲取类型 + bi_常量类.f6358b_空串);
        if (str == null || str.equals(bi_常量类.f6358b_空串)) {
            return bi_常量类.f6358b_空串;
        }
        int i = C0890_文本操作.m6821_寻找文本(str, "Getinfo", 0);
        if (i != -1) {
            return str.substring(i + 7);
        }
        return bi_常量类.f6358b_空串;
    }

    @SimpleFunction
    /* renamed from: MySQL_取客户IP */
    public static String m5384MySQL_IP() {
        if (!connected) {
            return "unknown";
        }
        String str = C0663MySQL.m5396("Getip");
        if (str == null || str.equals(bi_常量类.f6358b_空串)) {
            return "unknown";
        }
        int i = C0890_文本操作.m6821_寻找文本(str, "Getip", 0);
        if (i != -1) {
            return str.substring(i + 5);
        }
        return "unknown";
    }

    @SimpleFunction
    /* renamed from: MySQL_取数据库下所有表 */
    public static String m5385MySQL_() {
        if (!connected) {
            return bi_常量类.f6358b_空串;
        }
        String str1 = C0663MySQL.m5396("STables");
        if (str1 == null || str1.equals(bi_常量类.f6358b_空串)) {
            return bi_常量类.f6358b_空串;
        }
        int i = C0890_文本操作.m6821_寻找文本(str1, "STables", 0);
        if (i != -1) {
            return str1.substring(i + 7);
        }
        return bi_常量类.f6358b_空串;
    }

    @SimpleFunction
    /* renamed from: MySQL_执行语句 */
    public static String m5388MySQL_(String 语句) {
        if (!connected) {
            return "Error";
        }
        String str1 = C0663MySQL.m5396("RQuery|*|" + 语句);
        if (str1 == null || str1.equals(bi_常量类.f6358b_空串)) {
            return "Error";
        }
        int i = C0890_文本操作.m6821_寻找文本(str1, "RQuery", 0);
        if (i != -1) {
            return str1.substring(i + 6);
        }
        return "Error";
    }

    @SimpleFunction
    /* renamed from: MySQL_取记录数 */
    public static int m5387MySQL_(String 表名, String 满足条件) {
        if (!connected) {
            return -1;
        }
        String str1;
        int i;
        if (满足条件 == null || 满足条件.equals(bi_常量类.f6358b_空串)) {
            str1 = C0663MySQL.m5396("GRNumNC|*|" + 表名);
            if (str1 == null || str1.equals(bi_常量类.f6358b_空串)) {
                return -1;
            }
            i = C0890_文本操作.m6821_寻找文本(str1, "GRNumNC", 0);
            if (i != -1) {
                return Integer.parseInt(str1.substring(i + 7));
            }
            return -1;
        }
        str1 = C0663MySQL.m5396("GRNum|*|" + 表名 + "|*|" + 满足条件);
        if (str1 == null || str1.equals(bi_常量类.f6358b_空串)) {
            return -1;
        }
        i = C0890_文本操作.m6821_寻找文本(str1, "GRNum", 0);
        if (i != -1) {
            return Integer.parseInt(str1.substring(i + 5));
        }
        return -1;
    }

    @SimpleFunction
    /* renamed from: MySQL_添加记录 */
    public static boolean m5393MySQL_(String 表名, String 字段名, String 字段值) {
        if (!connected) {
            return false;
        }
        String str = C0663MySQL.m5396("IsData|*|" + 表名 + "|*|" + 字段名 + "|*|" + 字段值);
        if (str == null || str.equals(bi_常量类.f6358b_空串) || C0890_文本操作.m6821_寻找文本(str, "IsData", 0) == -1) {
            return false;
        }
        return true;
    }

    @SimpleFunction
    /* renamed from: MySQL_修改记录 */
    public static boolean m5382MySQL_(String 表名, String 字段更改, String 满足条件) {
        if (!connected) {
            return false;
        }
        String str = C0663MySQL.m5396("CgData|*|" + 表名 + "|*|" + 字段更改 + "|*|" + 满足条件);
        if (str == null || str.equals(bi_常量类.f6358b_空串) || C0890_文本操作.m6821_寻找文本(str, "CgData", 0) == -1) {
            return false;
        }
        return true;
    }

    @SimpleFunction
    /* renamed from: MySQL_删除记录 */
    public static boolean m5383MySQL_(String 表名, String 满足条件) {
        if (!connected) {
            return false;
        }
        String str = C0663MySQL.m5396("CcData|*|" + 表名 + "|*|" + 满足条件);
        if (str == null || str.equals(bi_常量类.f6358b_空串) || C0890_文本操作.m6821_寻找文本(str, "CcData", 0) == -1) {
            return false;
        }
        return true;
    }

    @SimpleFunction
    /* renamed from: MySQL_查询记录 */
    public static String m5391MySQL_(String 表名, String 欲取得字段名, String 满足条件) {
        if (!connected) {
            return bi_常量类.f6358b_空串;
        }
        String str1 = C0663MySQL.m5396("QrData|*|" + 表名 + "|*|" + 欲取得字段名 + "|*|" + 满足条件);
        if (str1 == null || str1.equals(bi_常量类.f6358b_空串)) {
            return bi_常量类.f6358b_空串;
        }
        int i = C0890_文本操作.m6821_寻找文本(str1, "QrData", 0);
        if (i != -1) {
            return str1.substring(i + 6);
        }
        return bi_常量类.f6358b_空串;
    }

    @SimpleFunction
    /* renamed from: MySQL_查询记录2 */
    public static String m5392MySQL_2(String 表名, String 欲取得字段名, String 满足条件, int 开始记录索引, int 结束记录索引) {
        if (!connected) {
            return bi_常量类.f6358b_空串;
        }
        String str1 = C0663MySQL.m5396("QLData|*|" + 表名 + "|*|" + 欲取得字段名 + "|*|" + 满足条件 + "|*|" + 开始记录索引 + "," + 结束记录索引);
        if (str1 == null || str1.equals(bi_常量类.f6358b_空串)) {
            return bi_常量类.f6358b_空串;
        }
        int i = C0890_文本操作.m6821_寻找文本(str1, "QLData", 0);
        if (i != -1) {
            return str1.substring(i + 6);
        }
        return bi_常量类.f6358b_空串;
    }

    @SimpleFunction
    /* renamed from: MySQL_查询最大值 */
    public static int m5390MySQL_(String 表名, String 字段名) {
        if (!connected || 字段名 == null || 字段名.equals(bi_常量类.f6358b_空串)) {
            return -1;
        }
        String str1 = C0663MySQL.m5396("GRMax|*|" + 表名 + "|*|" + 字段名);
        if (str1 == null || str1.equals(bi_常量类.f6358b_空串)) {
            return -1;
        }
        int i = C0890_文本操作.m6821_寻找文本(str1, "GRMax", 0);
        if (i != -1) {
            return Integer.parseInt(str1.substring(i + 5));
        }
        return -1;
    }

    @SimpleFunction
    /* renamed from: MySQL_转到数据库 */
    public static void m5394MySQL_(String 数据库名) {
        mysql_database = 数据库名;
    }

    @SimpleFunction
    /* renamed from: MySQL_断开连接 */
    public static void m5389MySQL_() {
        connected = false;
        mysql_openapi = null;
        mysql_host = null;
        mysql_username = null;
        mysql_password = null;
        mysql_database = null;
        mysql_code = null;
    }

    /* renamed from: 发送数据 */
    private static String m5396(String paramString) {
        C0682 local哈希表 = new C0682();
        local哈希表.m5447("captcha", StringVariant.getStringVariant(C0663MySQL.base64_encode(C0895.m6907("MSDATA" + mysql_host + "|*|" + mysql_username + "|*|" + mysql_password + "|*|" + mysql_database + "|*|" + mysql_code + "|*|" + paramString, "utf8", mysql_code))));
        return C0897_网络操作.m69113(mysql_openapi, local哈希表, mysql_code, 10000);
    }

    private static final String base64_encode(String paramString) {
        try {
            return new String(C0663MySQL.encodeToChar(paramString.getBytes("UTF-8"), false));
        } catch (UnsupportedEncodingException e) {
            return bi_常量类.f6358b_空串;
        }
    }

    private static final char[] encodeToChar(byte[] paramArrayOfByte, boolean paramBoolean) {
        int i = paramArrayOfByte != null ? paramArrayOfByte.length : 0;
        if (i == 0) {
            return new char[0];
        }
        int n;
        int j = (i / 3) * 3;
        int k = (((i - 1) / 3) + 1) << 2;
        int m = k + (paramBoolean ? ((k - 1) / 76) << 1 : 0);
        char[] arrayOfChar = new char[m];
        int i2 = 0;
        int i1 = 0;
        int n2 = 0;
        while (n2 < j) {
            n = n2 + 1;
            n2 = n + 1;
            n = n2 + 1;
            int i3 = (((paramArrayOfByte[n2] & WebView.NORMAL_MODE_ALPHA) << 16) | ((paramArrayOfByte[n] & WebView.NORMAL_MODE_ALPHA) << 8)) | (paramArrayOfByte[n2] & WebView.NORMAL_MODE_ALPHA);
            int i4 = i1 + 1;
            arrayOfChar[i1] = CA[(i3 >>> 18) & 63];
            i1 = i4 + 1;
            arrayOfChar[i4] = CA[(i3 >>> 12) & 63];
            i4 = i1 + 1;
            arrayOfChar[i1] = CA[(i3 >>> 6) & 63];
            i1 = i4 + 1;
            arrayOfChar[i4] = CA[i3 & 63];
            if (paramBoolean) {
                i2++;
                if (i2 == 19 && i1 < m - 2) {
                    i4 = i1 + 1;
                    arrayOfChar[i1] = '\r';
                    i1 = i4 + 1;
                    arrayOfChar[i4] = '\n';
                    i2 = 0;
                    i4 = i1;
                    i1 = i4;
                    n2 = n;
                }
            }
            i4 = i1;
            i1 = i4;
            n2 = n;
        }
        n = i - j;
        if (n > 0) {
            i4 = ((paramArrayOfByte[j] & WebView.NORMAL_MODE_ALPHA) << 10) | (n == 2 ? (paramArrayOfByte[i - 1] & WebView.NORMAL_MODE_ALPHA) << 2 : 0);
            arrayOfChar[m - 4] = CA[i4 >> 12];
            arrayOfChar[m - 3] = CA[(i4 >>> 6) & 63];
            arrayOfChar[m - 2] = n == 2 ? CA[i4 & 63] : '=';
            arrayOfChar[m - 1] = '=';
            return arrayOfChar;
        }
        return arrayOfChar;
    }
}
