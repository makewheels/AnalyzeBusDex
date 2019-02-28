package com.alipay.sdk.encrypt;

import p054u.aly.bi_常量类;

/* renamed from: com.alipay.sdk.encrypt.a */
public final class C0117a {
    /* renamed from: a */
    private static final int f336a = 128;
    /* renamed from: b */
    private static final int f337b = 64;
    /* renamed from: c */
    private static final int f338c = 24;
    /* renamed from: d */
    private static final int f339d = 8;
    /* renamed from: e */
    private static final int f340e = 16;
    /* renamed from: f */
    private static final int f341f = 4;
    /* renamed from: g */
    private static final int f342g = -128;
    /* renamed from: h */
    private static final char f343h = '=';
    /* renamed from: i */
    private static final byte[] f344i = new byte[f336a];
    /* renamed from: j */
    private static final char[] f345j = new char[64];

    static {
        int i;
        int i2 = 0;
        for (i = 0; i < f336a; i++) {
            f344i[i] = (byte) -1;
        }
        for (i = 90; i >= 65; i--) {
            f344i[i] = (byte) (i - 65);
        }
        for (i = 122; i >= 97; i--) {
            f344i[i] = (byte) ((i - 97) + 26);
        }
        for (i = 57; i >= 48; i--) {
            f344i[i] = (byte) ((i - 48) + 52);
        }
        f344i[43] = (byte) 62;
        f344i[47] = (byte) 63;
        for (i = 0; i <= 25; i++) {
            f345j[i] = (char) (i + 65);
        }
        int i3 = 26;
        i = 0;
        while (i3 <= 51) {
            f345j[i3] = (char) (i + 97);
            i3++;
            i++;
        }
        i = 52;
        while (i <= 61) {
            f345j[i] = (char) (i2 + 48);
            i++;
            i2++;
        }
        f345j[62] = '+';
        f345j[63] = '/';
    }

    /* renamed from: a */
    private static int m352a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            char c = cArr[i];
            Object obj = (c == ' ' || c == '\r' || c == '\n' || c == '\t') ? 1 : null;
            if (obj == null) {
                i3 = i2 + 1;
                cArr[i2] = cArr[i];
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    /* renamed from: a */
    public static String m353a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return bi_常量类.f6358b_空串;
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[((i2 != 0 ? i3 + 1 : i3) * 4)];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            length = i + 1;
            byte b = bArr[i];
            int i6 = length + 1;
            byte b2 = bArr[length];
            int i7 = i6 + 1;
            byte b3 = bArr[i6];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            if ((b & f342g) == 0) {
                i6 = (byte) (b >> 2);
            } else {
                byte b6 = (byte) ((b >> 2) ^ 192);
            }
            if ((b2 & f342g) == 0) {
                i = (byte) (b2 >> 4);
            } else {
                b = (byte) ((b2 >> 4) ^ 240);
            }
            length = (b3 & f342g) == 0 ? (byte) (b3 >> 6) : (byte) ((b3 >> 6) ^ 252);
            int i8 = i5 + 1;
            cArr[i5] = f345j[i6];
            i6 = i8 + 1;
            cArr[i8] = f345j[i | (b5 << 4)];
            i5 = i6 + 1;
            cArr[i6] = f345j[length | (b4 << 2)];
            i = i5 + 1;
            cArr[i5] = f345j[b3 & 63];
            i4++;
            i5 = i;
            i = i7;
        }
        byte b7;
        byte b8;
        if (i2 == 8) {
            b7 = bArr[i];
            b8 = (byte) (b7 & 3);
            i = i5 + 1;
            cArr[i5] = f345j[(b7 & f342g) == 0 ? (byte) (b7 >> 2) : (byte) ((b7 >> 2) ^ 192)];
            length = i + 1;
            cArr[i] = f345j[b8 << 4];
            i3 = length + 1;
            cArr[length] = f343h;
            cArr[i3] = f343h;
        } else if (i2 == 16) {
            b7 = bArr[i];
            b = bArr[i + 1];
            b6 = (byte) (b & 15);
            byte b9 = (byte) (b7 & 3);
            if ((b7 & f342g) == 0) {
                i3 = (byte) (b7 >> 2);
            } else {
                b8 = (byte) ((b7 >> 2) ^ 192);
            }
            length = (b & f342g) == 0 ? (byte) (b >> 4) : (byte) ((b >> 4) ^ 240);
            i = i5 + 1;
            cArr[i5] = f345j[i3];
            i3 = i + 1;
            cArr[i] = f345j[length | (b9 << 4)];
            length = i3 + 1;
            cArr[i3] = f345j[b6 << 2];
            cArr[length] = f343h;
        }
        return new String(cArr);
    }

    /* renamed from: a */
    private static boolean m354a(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    /* renamed from: a */
    public static byte[] m355a(String str) {
        if (str == null) {
            return null;
        }
        int i;
        int length;
        int i2;
        int i3;
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            i = 0;
        } else {
            length = toCharArray.length;
            i2 = 0;
            i = 0;
            while (i2 < length) {
                char c = toCharArray[i2];
                i3 = (c == ' ' || c == '\r' || c == '\n' || c == '\t') ? 1 : 0;
                if (i3 == 0) {
                    i3 = i + 1;
                    toCharArray[i] = toCharArray[i2];
                } else {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
        }
        if (i % 4 != 0) {
            return null;
        }
        int i4 = i / 4;
        if (i4 == 0) {
            return new byte[0];
        }
        char c2;
        Object obj = new byte[(i4 * 3)];
        i = 0;
        i2 = 0;
        length = 0;
        while (length < i4 - 1) {
            int i5 = i + 1;
            char c3 = toCharArray[i];
            if (C0117a.m357c(c3)) {
                i = i5 + 1;
                c2 = toCharArray[i5];
                if (C0117a.m357c(c2)) {
                    int i6 = i + 1;
                    char c4 = toCharArray[i];
                    if (C0117a.m357c(c4)) {
                        i = i6 + 1;
                        char c5 = toCharArray[i6];
                        if (C0117a.m357c(c5)) {
                            byte b = f344i[c3];
                            byte b2 = f344i[c2];
                            byte b3 = f344i[c4];
                            byte b4 = f344i[c5];
                            int i7 = i2 + 1;
                            obj[i2] = (byte) ((b << 2) | (b2 >> 4));
                            int i8 = i7 + 1;
                            obj[i7] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i2 = i8 + 1;
                            obj[i8] = (byte) ((b3 << 6) | b4);
                            length++;
                        }
                    }
                }
            }
            return null;
        }
        i4 = i + 1;
        char c6 = toCharArray[i];
        if (C0117a.m357c(c6)) {
            i5 = i4 + 1;
            char c7 = toCharArray[i4];
            if (C0117a.m357c(c7)) {
                b = f344i[c6];
                byte b5 = f344i[c7];
                i = i5 + 1;
                c2 = toCharArray[i5];
                c6 = toCharArray[i];
                if (C0117a.m357c(c2) && C0117a.m357c(c6)) {
                    byte b6 = f344i[c2];
                    byte b7 = f344i[c6];
                    int i9 = i2 + 1;
                    obj[i2] = (byte) ((b << 2) | (b5 >> 4));
                    i2 = i9 + 1;
                    obj[i9] = (byte) (((b5 & 15) << 4) | ((b6 >> 2) & 15));
                    obj[i2] = (byte) (b7 | (b6 << 6));
                    return obj;
                } else if (C0117a.m356b(c2) && C0117a.m356b(c6)) {
                    if ((b5 & 15) != 0) {
                        return null;
                    }
                    r1 = new byte[((length * 3) + 1)];
                    System.arraycopy(obj, 0, r1, 0, length * 3);
                    r1[i2] = (byte) ((b << 2) | (b5 >> 4));
                    return r1;
                } else if (C0117a.m356b(c2) || !C0117a.m356b(c6)) {
                    return null;
                } else {
                    byte b8 = f344i[c2];
                    if ((b8 & 3) != 0) {
                        return null;
                    }
                    r1 = new byte[((length * 3) + 2)];
                    System.arraycopy(obj, 0, r1, 0, length * 3);
                    i3 = i2 + 1;
                    r1[i2] = (byte) ((b << 2) | (b5 >> 4));
                    r1[i3] = (byte) (((b5 & 15) << 4) | ((b8 >> 2) & 15));
                    return r1;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private static boolean m356b(char c) {
        return c == f343h;
    }

    /* renamed from: c */
    private static boolean m357c(char c) {
        return c < '' && f344i[c] != (byte) -1;
    }
}
