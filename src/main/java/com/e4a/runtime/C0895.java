package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.Component;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.编码转换类 */
public final class C0895 {
    private C0895() {
    }

    @SimpleFunction
    /* renamed from: URL编码 */
    public static String m6905URL(String str, String charset) {
        String str2 = bi_常量类.f6358b_空串;
        try {
            return URLEncoder.encode(str, charset);
        } catch (UnsupportedEncodingException e) {
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: URL解码 */
    public static String m6906URL(String str, String charset) {
        String str2 = bi_常量类.f6358b_空串;
        try {
            return URLDecoder.decode(str, charset);
        } catch (UnsupportedEncodingException e) {
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 编码转换 */
    public static String m6907(String str, String oldCharset, String newCharset) {
        if (str == null) {
            return bi_常量类.f6358b_空串;
        }
        try {
            return new String(str.getBytes(oldCharset), newCharset);
        } catch (UnsupportedEncodingException e) {
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: UCS2解码 */
    public static String m6904UCS2(String theString) {
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        int x = 0;
        while (x < len) {
            int x2 = x + 1;
            char aChar = theString.charAt(x);
            if (aChar == '\\') {
                x = x2 + 1;
                aChar = theString.charAt(x2);
                if (aChar == 'u') {
                    int value = 0;
                    int i = 0;
                    while (i < 4) {
                        x2 = x + 1;
                        aChar = theString.charAt(x);
                        switch (aChar) {
                            case Component.KEYCODE_T /*48*/:
                            case Component.KEYCODE_U /*49*/:
                            case Component.KEYCODE_V /*50*/:
                            case Component.KEYCODE_W /*51*/:
                            case Component.KEYCODE_X /*52*/:
                            case Component.KEYCODE_Y /*53*/:
                            case Component.KEYCODE_Z /*54*/:
                            case Component.KEYCODE_COMMA /*55*/:
                            case Component.KEYCODE_PERIOD /*56*/:
                            case Component.KEYCODE_LEFT_ALT /*57*/:
                                value = ((value << 4) + aChar) - 48;
                                break;
                            case Component.KEYCODE_ENVELOPE /*65*/:
                            case Component.f3899 /*66*/:
                            case Component.KEYCODE_DEL /*67*/:
                            case Component.KEYCODE_GRAVE /*68*/:
                            case Component.KEYCODE_MINUS /*69*/:
                            case Component.KEYCODE_EQUALS /*70*/:
                                value = (((value << 4) + 10) + aChar) - 65;
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (((value << 4) + 10) + aChar) - 97;
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                        i++;
                        x = x2;
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't') {
                        aChar = '\t';
                    } else if (aChar == 'r') {
                        aChar = '\r';
                    } else if (aChar == 'n') {
                        aChar = '\n';
                    } else if (aChar == 'f') {
                        aChar = '\f';
                    }
                    outBuffer.append(aChar);
                }
            } else {
                outBuffer.append(aChar);
                x = x2;
            }
        }
        return outBuffer.toString();
    }

    @SimpleFunction
    /* renamed from: UCS2编码 */
    public static String m6903UCS2(String dataStr) {
        String str = bi_常量类.f6358b_空串;
        for (int i = 0; i < dataStr.length(); i++) {
            String temp = Integer.toHexString(dataStr.charAt(i) & 65535);
            if (temp.length() == 2) {
                temp = "00" + temp;
            }
            str = str + "\\u" + temp;
        }
        return str;
    }
}
