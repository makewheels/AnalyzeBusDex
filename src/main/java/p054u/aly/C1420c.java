package p054u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.smtt.sdk.WebView;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: Envelope */
/* renamed from: u.aly.c */
public class C1420c {
    /* renamed from: a */
    private final byte[] f6401a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    /* renamed from: b */
    private String f6402b = "1.0";
    /* renamed from: c */
    private String f6403c = null;
    /* renamed from: d */
    private byte[] f6404d = null;
    /* renamed from: e */
    private byte[] f6405e = null;
    /* renamed from: f */
    private byte[] f6406f = null;
    /* renamed from: g */
    private int f6407g = 0;
    /* renamed from: h */
    private int f6408h = 0;
    /* renamed from: i */
    private int f6409i = 0;
    /* renamed from: j */
    private byte[] f6410j = null;
    /* renamed from: k */
    private byte[] f6411k = null;

    private C1420c(byte[] bArr, String str, byte[] bArr2) throws Exception {
        if (bArr == null || bArr.length == 0) {
            throw new Exception("entity is null or empty");
        }
        this.f6403c = str;
        this.f6409i = bArr.length;
        this.f6410j = bu.m10049a(bArr);
        this.f6408h = (int) (System.currentTimeMillis() / 1000);
        this.f6411k = bArr2;
    }

    /* renamed from: a */
    public void m10101a(String str) {
        this.f6404d = C1420c.m10096b(str);
    }

    /* renamed from: a */
    public String m10099a() {
        return C1420c.m10095b(this.f6404d);
    }

    /* renamed from: a */
    public void m10100a(int i) {
        this.f6407g = i;
    }

    /* renamed from: a */
    public static C1420c m10092a(Context context, String str, byte[] bArr) {
        try {
            String p = bi_常量类.m9991p(context);
            String f = bi_常量类.m9981f(context);
            SharedPreferences a = C1451u.m10465a(context);
            String string = a.getString("signature", null);
            int i = a.getInt("serial", 1);
            C1420c c1420c = new C1420c(bArr, str, (f + p).getBytes());
            c1420c.m10101a(string);
            c1420c.m10100a(i);
            c1420c.m10102b();
            a.edit().putInt("serial", i + 1).putString("signature", c1420c.m10099a()).commit();
            return c1420c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public void m10102b() {
        if (this.f6404d == null) {
            this.f6404d = m10097d();
        }
        this.f6405e = m10094a(this.f6404d, this.f6408h);
        this.f6406f = m10098e();
    }

    /* renamed from: a */
    private byte[] m10094a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        byte[] a = C1420c.m10093a(this.f6411k);
        byte[] a2 = C1420c.m10093a(this.f6410j);
        int length = a.length;
        byte[] bArr2 = new byte[(length * 2)];
        for (i2 = 0; i2 < length; i2++) {
            bArr2[i2 * 2] = a2[i2];
            bArr2[(i2 * 2) + 1] = a[i2];
        }
        for (i2 = 0; i2 < 2; i2++) {
            bArr2[i2] = bArr[i2];
            bArr2[(bArr2.length - i2) - 1] = bArr[(bArr.length - i2) - 1];
        }
        byte[] bArr3 = new byte[]{(byte) (i & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA), (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA), (byte) (i >>> 24)};
        while (i3 < bArr2.length) {
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr3[i3 % 4]);
            i3++;
        }
        return bArr2;
    }

    /* renamed from: d */
    private byte[] m10097d() {
        return m10094a(this.f6401a, (int) (System.currentTimeMillis() / 1000));
    }

    /* renamed from: e */
    private byte[] m10098e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(C1420c.m10095b(this.f6404d));
        stringBuilder.append(this.f6407g);
        stringBuilder.append(this.f6408h);
        stringBuilder.append(this.f6409i);
        stringBuilder.append(C1420c.m10095b(this.f6405e));
        return C1420c.m10093a(stringBuilder.toString().getBytes());
    }

    /* renamed from: c */
    public byte[] m10103c() {
        bz bhVar = new bh();
        bhVar.m9919a(this.f6402b);
        bhVar.m9924b(this.f6403c);
        bhVar.m9931c(C1420c.m10095b(this.f6404d));
        bhVar.m9918a(this.f6407g);
        bhVar.m9930c(this.f6408h);
        bhVar.m9933d(this.f6409i);
        bhVar.m9921a(this.f6410j);
        bhVar.m9934d(C1420c.m10095b(this.f6405e));
        bhVar.m9938e(C1420c.m10095b(this.f6406f));
        try {
            return new ci().m10144a(bhVar);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("version : %s\n", new Object[]{this.f6402b}));
        stringBuilder.append(String.format("address : %s\n", new Object[]{this.f6403c}));
        stringBuilder.append(String.format("signature : %s\n", new Object[]{C1420c.m10095b(this.f6404d)}));
        stringBuilder.append(String.format("serial : %s\n", new Object[]{Integer.valueOf(this.f6407g)}));
        stringBuilder.append(String.format("timestamp : %d\n", new Object[]{Integer.valueOf(this.f6408h)}));
        stringBuilder.append(String.format("length : %d\n", new Object[]{Integer.valueOf(this.f6409i)}));
        stringBuilder.append(String.format("guid : %s\n", new Object[]{C1420c.m10095b(this.f6405e)}));
        stringBuilder.append(String.format("checksum : %s ", new Object[]{C1420c.m10095b(this.f6406f)}));
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static byte[] m10093a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static String m10095b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    /* renamed from: b */
    public static byte[] m10096b(String str) {
        byte[] bArr = null;
        if (str != null) {
            int length = str.length();
            if (length % 2 == 0) {
                bArr = new byte[(length / 2)];
                for (int i = 0; i < length; i += 2) {
                    bArr[i / 2] = (byte) Integer.valueOf(str.substring(i, i + 2), 16).intValue();
                }
            }
        }
        return bArr;
    }
}
