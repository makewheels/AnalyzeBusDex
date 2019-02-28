package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.转换操作 */
public final class C0899 {
    private C0899() {
    }

    @SimpleFunction
    /* renamed from: 字符转代码 */
    public static int m6948(String str) {
        try {
            return str.charAt(0);
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    @SimpleFunction
    /* renamed from: 代码转字符 */
    public static String m6939(int value) {
        try {
            return Character.toString((char) value);
        } catch (Exception e) {
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 到十六进制 */
    public static String m6941(long v) {
        try {
            String str = Long.toHexString(v);
            if (str.length() < 2) {
                return "0" + str;
            }
            return str;
        } catch (Exception e) {
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 到十进制 */
    public static long m6942(String v) {
        long j = 0;
        try {
            if (!bi_常量类.f6358b.equals(v)) {
                j = Long.valueOf(v, 16).longValue();
            }
        } catch (Exception e) {
        }
        return j;
    }

    @SimpleFunction
    /* renamed from: 到二进制 */
    public static String m6940(int v) {
        try {
            return Integer.toBinaryString(v);
        } catch (Exception e) {
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 文本到二进制 */
    public static String m6960(String str) {
        try {
            char[] strChar = str.toCharArray();
            String result = bi_常量类.f6358b;
            for (char toBinaryString : strChar) {
                result = result + Integer.toBinaryString(toBinaryString) + " ";
            }
            return result;
        } catch (Exception e) {
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 到文本 */
    public static String m6945(double v) {
        try {
            return String.valueOf(v);
        } catch (Exception e) {
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 到数值 */
    public static double m6943(String v) {
        double d = 0.0d;
        try {
            if (!bi_常量类.f6358b.equals(v)) {
                d = Double.parseDouble(v);
            }
        } catch (Exception e) {
        }
        return d;
    }

    @SimpleFunction
    /* renamed from: 字节到文本 */
    public static String m6952(byte[] v, String encoding) {
        try {
            return new String(v, encoding);
        } catch (UnsupportedEncodingException e) {
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 文本到字节 */
    public static byte[] m6961(String v, String encoding) {
        try {
            return v.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            return new byte[0];
        }
    }

    @SimpleFunction
    /* renamed from: 到整数 */
    public static int m6944(String v) {
        int i = 0;
        try {
            if (!bi_常量类.f6358b.equals(v)) {
                i = Integer.parseInt(v);
            }
        } catch (Exception e) {
        }
        return i;
    }

    @SimpleFunction
    /* renamed from: 整数到文本 */
    public static String m6959(int v) {
        try {
            return Integer.toString(v);
        } catch (Exception e) {
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 字节到整数 */
    public static int m6950(byte[] res) {
        try {
            return (((res[0] & WebView.NORMAL_MODE_ALPHA) | ((res[1] << 8) & 65280)) | ((res[2] << 24) >>> 8)) | (res[3] << 24);
        } catch (Exception e) {
            return 0;
        }
    }

    @SimpleFunction
    /* renamed from: 字节到整数2 */
    public static int m69512(byte 字节) {
        return 字节;
    }

    @SimpleFunction
    /* renamed from: 整数到字节 */
    public static byte[] m6957(int res) {
        try {
            return new byte[]{(byte) (res & WebView.NORMAL_MODE_ALPHA), (byte) ((res >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) ((res >> 16) & WebView.NORMAL_MODE_ALPHA), (byte) (res >>> 24)};
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @SimpleFunction
    /* renamed from: 整数到字节2 */
    public static byte m69582(int 整数) {
        return (byte) 整数;
    }

    @SimpleFunction
    /* renamed from: 长整数到字节 */
    public static byte[] m6962(long x) {
        try {
            return new byte[]{(byte) ((int) (x >> 56)), (byte) ((int) (x >> 48)), (byte) ((int) (x >> 40)), (byte) ((int) (x >> 32)), (byte) ((int) (x >> 24)), (byte) ((int) (x >> 16)), (byte) ((int) (x >> 8)), (byte) ((int) (x >> 0))};
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @SimpleFunction
    /* renamed from: 字节到长整数 */
    public static long m6953(byte[] bb) {
        try {
            return ((((((((((long) bb[0]) & 255) << 56) | ((((long) bb[1]) & 255) << 48)) | ((((long) bb[2]) & 255) << 40)) | ((((long) bb[3]) & 255) << 32)) | ((((long) bb[4]) & 255) << 24)) | ((((long) bb[5]) & 255) << 16)) | ((((long) bb[6]) & 255) << 8)) | ((((long) bb[7]) & 255) << null);
        } catch (Exception e) {
            return 0;
        }
    }

    @SimpleFunction
    /* renamed from: 小数到字节 */
    public static byte[] m6955(double a) {
        try {
            long v = Double.doubleToLongBits(a);
            return new byte[]{(byte) ((int) (v >>> 56)), (byte) ((int) (v >>> 48)), (byte) ((int) (v >>> 40)), (byte) ((int) (v >>> 32)), (byte) ((int) (v >>> 24)), (byte) ((int) (v >>> 16)), (byte) ((int) (v >>> 8)), (byte) ((int) (v >>> 0))};
        } catch (Exception e) {
            return new byte[0];
        }
    }

    @SimpleFunction
    /* renamed from: 字节到小数 */
    public static double m6949(byte[] readBuffer) {
        try {
            return Double.longBitsToDouble((((((((((long) readBuffer[0]) << 56) + (((long) (readBuffer[1] & WebView.NORMAL_MODE_ALPHA)) << 48)) + (((long) (readBuffer[2] & WebView.NORMAL_MODE_ALPHA)) << 40)) + (((long) (readBuffer[3] & WebView.NORMAL_MODE_ALPHA)) << 32)) + (((long) (readBuffer[4] & WebView.NORMAL_MODE_ALPHA)) << 24)) + ((long) ((readBuffer[5] & WebView.NORMAL_MODE_ALPHA) << 16))) + ((long) ((readBuffer[6] & WebView.NORMAL_MODE_ALPHA) << 8))) + ((long) ((readBuffer[7] & WebView.NORMAL_MODE_ALPHA) << 0)));
        } catch (Exception e) {
            return 0.0d;
        }
    }

    @SimpleFunction
    /* renamed from: 到长整数 */
    public static long m6946(String v) {
        long j = 0;
        try {
            if (!bi_常量类.f6358b.equals(v)) {
                j = Long.parseLong(v);
            }
        } catch (Exception e) {
        }
        return j;
    }

    @SimpleFunction
    /* renamed from: 长整数到文本 */
    public static String m6963(long v) {
        try {
            return Long.toString(v);
        } catch (Exception e) {
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 数值到金额 */
    public static String m6956(double amount) {
        if (amount > 1.0E18d || amount < -1.0E18d) {
            try {
                return bi_常量类.f6358b;
            } catch (Exception e) {
                return bi_常量类.f6358b;
            }
        }
        String[] chineseDigits = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        boolean negative = false;
        if (amount < 0.0d) {
            negative = true;
            amount *= -1.0d;
        }
        long temp = Math.round(100.0d * amount);
        int numFen = (int) (temp % 10);
        temp /= 10;
        int numJiao = (int) (temp % 10);
        temp /= 10;
        int[] parts = new int[20];
        int numParts = 0;
        int i = 0;
        while (temp != 0) {
            parts[i] = (int) (temp % 10000);
            numParts++;
            temp /= 10000;
            i++;
        }
        boolean beforeWanIsZero = true;
        String chineseStr = bi_常量类.f6358b;
        i = 0;
        while (i < numParts) {
            String partChinese = C0899.partTranslate(parts[i]);
            if (i % 2 == 0) {
                if (bi_常量类.f6358b.equals(partChinese)) {
                    beforeWanIsZero = true;
                } else {
                    beforeWanIsZero = false;
                }
            }
            if (i != 0) {
                if (i % 2 == 0) {
                    chineseStr = "亿" + chineseStr;
                } else if (!bi_常量类.f6358b.equals(partChinese) || beforeWanIsZero) {
                    if (parts[i - 1] < 1000 && parts[i - 1] > 0) {
                        chineseStr = "零" + chineseStr;
                    }
                    chineseStr = "万" + chineseStr;
                } else {
                    chineseStr = "零" + chineseStr;
                }
            }
            chineseStr = partChinese + chineseStr;
            i++;
        }
        if (bi_常量类.f6358b.equals(chineseStr)) {
            chineseStr = chineseDigits[0];
        } else if (negative) {
            chineseStr = "负" + chineseStr;
        }
        chineseStr = chineseStr + "元";
        if (numFen == 0 && numJiao == 0) {
            return chineseStr + "整";
        }
        if (numFen == 0) {
            return chineseStr + chineseDigits[numJiao] + "角";
        }
        if (numJiao == 0) {
            return chineseStr + "零" + chineseDigits[numFen] + "分";
        }
        return chineseStr + chineseDigits[numJiao] + "角" + chineseDigits[numFen] + "分";
    }

    private static String partTranslate(int amountPart) {
        if (amountPart < 0 || amountPart > 10000) {
            return bi_常量类.f6358b;
        }
        String[] chineseDigits = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] units = new String[]{bi_常量类.f6358b, "拾", "佰", "仟"};
        int temp = amountPart;
        int amountStrLength = new Integer(amountPart).toString().length();
        boolean lastIsZero = true;
        String chineseStr = bi_常量类.f6358b;
        for (int i = 0; i < amountStrLength && temp != 0; i++) {
            int digit = temp % 10;
            if (digit == 0) {
                if (!lastIsZero) {
                    chineseStr = "零" + chineseStr;
                }
                lastIsZero = true;
            } else {
                chineseStr = chineseDigits[digit] + units[i] + chineseStr;
                lastIsZero = false;
            }
            temp /= 10;
        }
        return chineseStr;
    }

    private static int parse(char c) {
        if (c >= 'a') {
            return ((c - 97) + 10) & 15;
        }
        if (c >= 'A') {
            return ((c - 65) + 10) & 15;
        }
        return (c - 48) & 15;
    }

    @SimpleFunction
    /* renamed from: 字节集到十六进制 */
    public static String m6954(byte[] b) {
        if (b == null) {
            try {
                return bi_常量类.f6358b;
            } catch (Exception e) {
                return bi_常量类.f6358b;
            }
        } else if (b.length == 0) {
            return bi_常量类.f6358b;
        } else {
            byte[] hex = "0123456789ABCDEF".getBytes();
            byte[] buff = new byte[(b.length * 2)];
            for (int i = 0; i < b.length; i++) {
                buff[i * 2] = hex[(b[i] >> 4) & 15];
                buff[(i * 2) + 1] = hex[b[i] & 15];
            }
            return new String(buff);
        }
    }

    @SimpleFunction
    /* renamed from: 十六进制到字节集 */
    public static byte[] m6947(String hexstr) {
        if (hexstr == null) {
            try {
                return new byte[0];
            } catch (Exception e) {
                return new byte[0];
            }
        } else if (hexstr.equals(bi_常量类.f6358b)) {
            return new byte[0];
        } else {
            byte[] b = new byte[(hexstr.length() / 2)];
            int j = 0;
            for (int i = 0; i < b.length; i++) {
                int j2 = j + 1;
                char c0 = hexstr.charAt(j);
                j = j2 + 1;
                b[i] = (byte) ((C0899.parse(c0) << 4) | C0899.parse(hexstr.charAt(j2)));
            }
            return b;
        }
    }
}
