package com.autonavi.amap.mapcore;

import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import p054u.aly.bi_常量类;

public class Convert {
    public static int getInt(byte[] bArr, int i) {
        return ((((bArr[i + 3] & WebView.NORMAL_MODE_ALPHA) << 24) + ((bArr[i + 2] & WebView.NORMAL_MODE_ALPHA) << 16)) + ((bArr[i + 1] & WebView.NORMAL_MODE_ALPHA) << 8)) + ((bArr[i + 0] & WebView.NORMAL_MODE_ALPHA) << 0);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & WebView.NORMAL_MODE_ALPHA) << 8) + ((bArr[i + 0] & WebView.NORMAL_MODE_ALPHA) << 0));
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & WebView.NORMAL_MODE_ALPHA) << 8) + ((bArr[i + 0] & WebView.NORMAL_MODE_ALPHA) << 0);
    }

    public static boolean getBit(byte b, int i) {
        if ((((b << (32 - i)) >>> (32 - i)) >>> (i - 1)) > 0) {
            return true;
        }
        return false;
    }

    public static byte[] copyString(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }

    public static byte[] covertBytes(byte b) {
        return new byte[]{b};
    }

    public static byte[] convertInt(int i) {
        return new byte[]{(byte) (i & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 24) & WebView.NORMAL_MODE_ALPHA)};
    }

    public static int getNum(byte b, int i, int i2) {
        return ((b << ((32 - i2) - 1)) >>> ((32 - i2) - 1)) >>> i;
    }

    public static int getNum(short s, int i, int i2) {
        return ((s << (32 - i2)) >>> (32 - i2)) >>> (i - 1);
    }

    public static byte[] convertShort(int i) {
        return new byte[]{(byte) (i & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA)};
    }

    public static void writeInt(byte[] bArr, int i, int i2) {
        System.arraycopy(convertInt(i2), 0, bArr, i, 4);
    }

    public static void writeShort(byte[] bArr, int i, short s) {
        System.arraycopy(convertShort(s), 0, bArr, i, 2);
    }

    public static void moveArray(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        Object obj = new byte[i3];
        System.arraycopy(bArr, i, obj, 0, i3);
        System.arraycopy(obj, 0, bArr2, i2, i3);
    }

    public static String getString(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Throwable th) {
            return bi_常量类.f6358b;
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }

    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(new byte[]{(byte) str.getBytes("UTF-8").length});
            byteArrayOutputStream.write(r1);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[1];
        }
    }

    public static byte[] get2BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(convertShort(bytes.length));
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[1];
        }
    }

    public static double convertDouble(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j += ((long) (bArr[i2 + i] & WebView.NORMAL_MODE_ALPHA)) << (i2 * 8);
        }
        return Double.longBitsToDouble(j);
    }

    public static byte[] getDouble(double d) {
        byte[] bArr = new byte[8];
        String toHexString = Long.toHexString(Double.doubleToLongBits(d));
        for (int i = 0; i < 8; i++) {
            bArr[7 - i] = (byte) Integer.parseInt(toHexString.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }

    public static void convert1bString(byte[] bArr, int i, C0591a c0591a) {
        try {
            c0591a.f3641a = bArr[i];
            c0591a.f3642b = new String(bArr, i + 1, c0591a.f3641a, "UTF-8");
        } catch (Throwable th) {
            th.printStackTrace();
            c0591a.f3641a = 0;
            c0591a.f3642b = bi_常量类.f6358b;
        }
    }

    public static void convert2bString(byte[] bArr, int i, C0591a c0591a) {
        try {
            c0591a.f3641a = getShort(bArr, i);
            c0591a.f3642b = new String(bArr, i + 2, c0591a.f3641a, "UTF-8");
        } catch (Throwable th) {
            th.printStackTrace();
            c0591a.f3641a = 0;
            c0591a.f3642b = bi_常量类.f6358b;
        }
    }

    public static final String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA);
            if (toHexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(toHexString.toUpperCase(Locale.US));
        }
        return stringBuffer.toString();
    }
}
