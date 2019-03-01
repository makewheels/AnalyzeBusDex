package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.加密操作 */
public final class C0843_加密操作 {
    private C0843_加密操作() {
    }

    @SimpleFunction
    /* renamed from: 取MD5值 */
    public static String m6613MD5(byte[] bytes) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(bytes);
            char[] str = new char[(j * 2)];
            int k = 0;
            for (byte byte0 : mdInst.digest()) {
                int i = k + 1;
                str[k] = hexDigits[(byte0 >>> 4) & 15];
                k = i + 1;
                str[i] = hexDigits[byte0 & 15];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: RC4加密 */
    public static String m6609RC4(String data, String key) {
        if (data == null || key == null) {
            return bi_常量类.f6358b_空串;
        }
        try {
            char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            char[] str = new char[(j * 2)];
            int k = 0;
            for (byte byte0 : C0843_加密操作.RC4Base(data.getBytes("GBK"), key)) {
                int i = k + 1;
                str[k] = hexDigits[(byte0 >>> 4) & 15];
                k = i + 1;
                str[i] = hexDigits[byte0 & 15];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: RC4解密 */
    public static String m6611RC4(String data, String key) {
        if (data == null || key == null) {
            return bi_常量类.f6358b_空串;
        }
        try {
            return new String(C0843_加密操作.RC4Base(C0843_加密操作.HexString2Bytes(data), key), "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: RC4加密2 */
    public static byte[] m6610RC42(byte[] data, String key) {
        if (data == null || key == null) {
            return new byte[0];
        }
        try {
            byte[] hexDigits = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70};
            byte[] str = new byte[(j * 2)];
            int k = 0;
            for (byte byte0 : C0843_加密操作.RC4Base(data, key)) {
                int i = k + 1;
                str[k] = hexDigits[(byte0 >>> 4) & 15];
                k = i + 1;
                str[i] = hexDigits[byte0 & 15];
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @SimpleFunction
    /* renamed from: RC4解密2 */
    public static byte[] m6612RC42(byte[] data, String key) {
        int i = 0;
        if (data == null || key == null) {
            return new byte[i];
        }
        try {
            return C0843_加密操作.RC4Base(data, key);
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[i];
        }
    }

    private static byte[] HexString2Bytes(String src) {
        try {
            int size = src.length();
            byte[] bArr = new byte[(size / 2)];
            byte[] tmp = src.getBytes("GBK");
            for (int i = 0; i < size / 2; i++) {
                bArr[i] = C0843_加密操作.uniteBytes(tmp[i * 2], tmp[(i * 2) + 1]);
            }
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    private static byte uniteBytes(byte src0, byte src1) {
        return (byte) (((char) (((char) Byte.decode("0x" + new String(new byte[]{src0})).byteValue()) << 4)) ^ ((char) Byte.decode("0x" + new String(new byte[]{src1})).byteValue()));
    }

    private static byte[] RC4Base(byte[] input, String mKkey) {
        int x = 0;
        int y = 0;
        byte[] key = C0843_加密操作.initKey(mKkey);
        byte[] result = new byte[input.length];
        for (int i = 0; i < input.length; i++) {
            x = (x + 1) & WebView.NORMAL_MODE_ALPHA;
            y = ((key[x] & WebView.NORMAL_MODE_ALPHA) + y) & WebView.NORMAL_MODE_ALPHA;
            byte tmp = key[x];
            key[x] = key[y];
            key[y] = tmp;
            result[i] = (byte) (input[i] ^ key[((key[x] & WebView.NORMAL_MODE_ALPHA) + (key[y] & WebView.NORMAL_MODE_ALPHA)) & WebView.NORMAL_MODE_ALPHA]);
        }
        return result;
    }

    private static byte[] initKey(String aKey) {
        try {
            int i;
            byte[] b_key = aKey.getBytes("GBK");
            byte[] state = new byte[256];
            for (i = 0; i < 256; i++) {
                state[i] = (byte) i;
            }
            int index1 = 0;
            int index2 = 0;
            if (b_key == null || b_key.length == 0) {
                return null;
            }
            for (i = 0; i < 256; i++) {
                index2 = (((b_key[index1] & WebView.NORMAL_MODE_ALPHA) + (state[i] & WebView.NORMAL_MODE_ALPHA)) + index2) & WebView.NORMAL_MODE_ALPHA;
                byte tmp = state[i];
                state[i] = state[index2];
                state[index2] = tmp;
                index1 = (index1 + 1) % b_key.length;
            }
            return state;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SimpleFunction
    /* renamed from: DES加密 */
    public static String m6607DES(String encryptString, String encryptKey) throws Exception {
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8});
            SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes("GBK"), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, key, zeroIv);
            return C0843_加密操作.m6605BASE64(cipher.doFinal(encryptString.getBytes("GBK")));
        } catch (Exception e) {
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: DES解密 */
    public static String m6608DES(String decryptString, String decryptKey) throws Exception {
        try {
            byte[] iv = new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8};
            byte[] byteMi = C0843_加密操作.m6606BASE64(decryptString);
            IvParameterSpec zeroIv = new IvParameterSpec(iv);
            SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes("GBK"), "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, key, zeroIv);
            return new String(cipher.doFinal(byteMi), "GBK");
        } catch (Exception e) {
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: BASE64编码 */
    public static String m6605BASE64(byte[] data) {
        try {
            return Base64.encode(data);
        } catch (Exception e) {
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: BASE64解码 */
    public static byte[] m6606BASE64(String data) {
        try {
            return Base64.decode(data);
        } catch (UnsupportedEncodingException e) {
            return new byte[0];
        }
    }

    @SimpleFunction
    /* renamed from: Authcode加密 */
    public static String m6603Authcode(String source, String key) {
        try {
            return Authcode.Encode(source, key);
        } catch (Exception e) {
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: Authcode解密 */
    public static String m6604Authcode_Authcode解密(String source, String key) {
        try {
            return Authcode.Decode(source, key);
        } catch (Exception e) {
            return bi_常量类.f6358b_空串;
        }
    }
}
