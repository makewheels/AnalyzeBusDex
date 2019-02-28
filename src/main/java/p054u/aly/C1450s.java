package p054u.aly;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* compiled from: ObjectSerializer */
/* renamed from: u.aly.s */
public class C1450s {
    /* renamed from: a */
    public static String m10462a(Serializable serializable) {
        if (serializable == null) {
            return bi_常量类.f6358b_空串;
        }
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return C1450s.m10463a(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static Object m10461a(String str) {
        Object obj = null;
        if (!(str == null || str.length() == 0)) {
            try {
                obj = new ObjectInputStream(new ByteArrayInputStream(C1450s.m10464b(str))).readObject();
            } catch (Exception e) {
            }
        }
        return obj;
    }

    /* renamed from: a */
    public static String m10463a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append((char) (((bArr[i] >> 4) & 15) + 97));
            stringBuffer.append((char) ((bArr[i] & 15) + 97));
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static byte[] m10464b(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length(); i += 2) {
            bArr[i / 2] = (byte) ((str.charAt(i) - 97) << 4);
            int i2 = i / 2;
            bArr[i2] = (byte) ((str.charAt(i + 1) - 97) + bArr[i2]);
        }
        return bArr;
    }
}
