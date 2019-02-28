package com.amap.api.mapcore.util;

import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Encrypt */
public class aa {
    /* renamed from: a */
    private static final char[] f1917a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    /* renamed from: b */
    private static final byte[] f1918b = new byte[128];

    static {
        int i;
        for (i = 0; i < 128; i++) {
            f1918b[i] = (byte) -1;
        }
        for (i = 65; i <= 90; i++) {
            f1918b[i] = (byte) (i - 65);
        }
        for (i = 97; i <= 122; i++) {
            f1918b[i] = (byte) ((i - 97) + 26);
        }
        for (i = 48; i <= 57; i++) {
            f1918b[i] = (byte) ((i - 48) + 52);
        }
        f1918b[43] = (byte) 62;
        f1918b[47] = (byte) 63;
    }

    /* renamed from: a */
    static byte[] m3005a(byte[] bArr, byte[] bArr2) {
        try {
            return m3008b(bArr, bArr2);
        } catch (Throwable e) {
            az.m3143a(e, "Encrypt", "aesEncrypt");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            az.m3143a(e2, "Encrypt", "aesEncrypt");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            az.m3143a(e22, "Encrypt", "aesEncrypt");
            e22.printStackTrace();
            return null;
        } catch (Throwable e222) {
            az.m3143a(e222, "Encrypt", "aesEncrypt");
            e222.printStackTrace();
            return null;
        } catch (Throwable e2222) {
            az.m3143a(e2222, "Encrypt", "aesEncrypt");
            e2222.printStackTrace();
            return null;
        } catch (Throwable e22222) {
            az.m3143a(e22222, "Encrypt", "aesEncrypt");
            e22222.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m3008b(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(1, secretKeySpec);
        return instance.doFinal(bArr2);
    }

    /* renamed from: a */
    static byte[] m3004a(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    /* renamed from: a */
    public static String m3002a(String str) {
        return new String(m3007b(str));
    }

    /* renamed from: b */
    public static byte[] m3007b(String str) {
        int i = 0;
        if (str == null) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                byte b = f1918b[bytes[i]];
                byte b2;
                byte b3;
                byte b4;
                if (i2 >= length || b != (byte) -1) {
                    if (b != (byte) -1) {
                        while (true) {
                            i = i2 + 1;
                            b2 = f1918b[bytes[i2]];
                            if (i >= length || b2 != (byte) -1) {
                                if (b2 == (byte) -1) {
                                    break;
                                }
                                byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                                while (true) {
                                    i2 = i + 1;
                                    b3 = bytes[i];
                                    if (b3 != (byte) 61) {
                                        return byteArrayOutputStream.toByteArray();
                                    }
                                    b = f1918b[b3];
                                    if (i2 >= length || b != (byte) -1) {
                                        if (b == (byte) -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                                        while (true) {
                                            i = i2 + 1;
                                            b4 = bytes[i2];
                                            if (b4 == (byte) 61) {
                                                return byteArrayOutputStream.toByteArray();
                                            }
                                            b4 = f1918b[b4];
                                            if (i >= length || b4 != (byte) -1) {
                                                if (b4 == (byte) -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                            } else {
                                                i2 = i;
                                            }
                                        }
                                        if (b4 == (byte) -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                    } else {
                                        i = i2;
                                    }
                                }
                                if (b == (byte) -1) {
                                    byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                                    while (true) {
                                        i = i2 + 1;
                                        b4 = bytes[i2];
                                        if (b4 == (byte) 61) {
                                            b4 = f1918b[b4];
                                            if (i >= length) {
                                                break;
                                            }
                                            break;
                                        }
                                        return byteArrayOutputStream.toByteArray();
                                        i2 = i;
                                    }
                                    if (b4 == (byte) -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                                } else {
                                    break;
                                }
                            }
                            i2 = i;
                        }
                        if (b2 == (byte) -1) {
                            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
                            while (true) {
                                i2 = i + 1;
                                b3 = bytes[i];
                                if (b3 != (byte) 61) {
                                    b = f1918b[b3];
                                    if (i2 >= length) {
                                        break;
                                    }
                                    break;
                                }
                                return byteArrayOutputStream.toByteArray();
                                i = i2;
                            }
                            if (b == (byte) -1) {
                                break;
                            }
                            byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                            while (true) {
                                i = i2 + 1;
                                b4 = bytes[i2];
                                if (b4 == (byte) 61) {
                                    b4 = f1918b[b4];
                                    if (i >= length) {
                                        break;
                                    }
                                    break;
                                }
                                return byteArrayOutputStream.toByteArray();
                                i2 = i;
                            }
                            if (b4 == (byte) -1) {
                                break;
                            }
                            byteArrayOutputStream.write(b4 | ((b & 3) << 6));
                        } else {
                            break;
                        }
                    }
                    break;
                }
                i = i2;
            }
            if (b != (byte) -1) {
                break;
            }
            while (true) {
                i = i2 + 1;
                b2 = f1918b[bytes[i2]];
                if (i >= length) {
                    break;
                }
                break;
                i2 = i;
            }
            if (b2 == (byte) -1) {
                break;
            }
            byteArrayOutputStream.write((b << 2) | ((b2 & 48) >>> 4));
            while (true) {
                i2 = i + 1;
                b3 = bytes[i];
                if (b3 != (byte) 61) {
                    b = f1918b[b3];
                    if (i2 >= length) {
                        break;
                    }
                    break;
                }
                return byteArrayOutputStream.toByteArray();
                i = i2;
            }
            if (b == (byte) -1) {
                byteArrayOutputStream.write(((b2 & 15) << 4) | ((b & 60) >>> 2));
                while (true) {
                    i = i2 + 1;
                    b4 = bytes[i2];
                    if (b4 == (byte) 61) {
                        b4 = f1918b[b4];
                        if (i >= length) {
                            break;
                        }
                        break;
                    }
                    return byteArrayOutputStream.toByteArray();
                    i2 = i;
                }
                if (b4 == (byte) -1) {
                    break;
                }
                byteArrayOutputStream.write(b4 | ((b & 3) << 6));
            } else {
                break;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: c */
    private static String m3009c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            if (i2 == length) {
                stringBuffer.append(f1917a[i3 >>> 2]);
                stringBuffer.append(f1917a[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            i2 = bArr[i2] & WebView.NORMAL_MODE_ALPHA;
            if (i4 == length) {
                stringBuffer.append(f1917a[i3 >>> 2]);
                stringBuffer.append(f1917a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
                stringBuffer.append(f1917a[(i2 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            i = i4 + 1;
            i4 = bArr[i4] & WebView.NORMAL_MODE_ALPHA;
            stringBuffer.append(f1917a[i3 >>> 2]);
            stringBuffer.append(f1917a[((i3 & 3) << 4) | ((i2 & 240) >>> 4)]);
            stringBuffer.append(f1917a[((i2 & 15) << 2) | ((i4 & 192) >>> 6)]);
            stringBuffer.append(f1917a[i4 & 63]);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m3003a(byte[] bArr) {
        try {
            return m3009c(bArr);
        } catch (Throwable th) {
            az.m3143a(th, "Encrypt", "encodeBase64");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static String m3006b(byte[] bArr) {
        try {
            return m3009c(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
