package com.aps;

import android.text.TextUtils;
import com.alipay.sdk.cons.C0108a;
import java.util.zip.CRC32;
import p054u.aly.bi_常量类;

/* compiled from: Req */
/* renamed from: com.aps.o */
public class C0575o {
    /* renamed from: A */
    public byte[] f3512A = null;
    /* renamed from: a */
    public String f3513a = C0108a.f262e;
    /* renamed from: b */
    public short f3514b = (short) 0;
    /* renamed from: c */
    public String f3515c = null;
    /* renamed from: d */
    public String f3516d = null;
    /* renamed from: e */
    public String f3517e = null;
    /* renamed from: f */
    public String f3518f = null;
    /* renamed from: g */
    public String f3519g = null;
    /* renamed from: h */
    public String f3520h = null;
    /* renamed from: i */
    public String f3521i = null;
    /* renamed from: j */
    public String f3522j = null;
    /* renamed from: k */
    public String f3523k = null;
    /* renamed from: l */
    public String f3524l = null;
    /* renamed from: m */
    public String f3525m = null;
    /* renamed from: n */
    public String f3526n = null;
    /* renamed from: o */
    public String f3527o = null;
    /* renamed from: p */
    public String f3528p = null;
    /* renamed from: q */
    public String f3529q = null;
    /* renamed from: r */
    public String f3530r = null;
    /* renamed from: s */
    public String f3531s = null;
    /* renamed from: t */
    public String f3532t = null;
    /* renamed from: u */
    public String f3533u = null;
    /* renamed from: v */
    public String f3534v = null;
    /* renamed from: w */
    public String f3535w = null;
    /* renamed from: x */
    public String f3536x = null;
    /* renamed from: y */
    public String f3537y = null;
    /* renamed from: z */
    public String f3538z = null;

    /* renamed from: a */
    public byte[] m4550a() {
        Object a;
        Object b;
        m4549b();
        int i = 1024;
        if (this.f3512A != null) {
            i = 1024 + (this.f3512A.length + 1);
        }
        Object obj = new byte[i];
        obj[0] = Byte.parseByte(this.f3513a);
        Object b2 = C0579q.m4562b(this.f3514b);
        System.arraycopy(b2, 0, obj, 1, b2.length);
        int length = b2.length + 1;
        try {
            b2 = this.f3515c.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th) {
            th.printStackTrace();
            C0583t.m4574a(th);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3516d.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th2) {
            th2.printStackTrace();
            C0583t.m4574a(th2);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3527o.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th22) {
            th22.printStackTrace();
            C0583t.m4574a(th22);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3517e.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th222) {
            th222.printStackTrace();
            C0583t.m4574a(th222);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3518f.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th2222) {
            th2222.printStackTrace();
            C0583t.m4574a(th2222);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3519g.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th22222) {
            th22222.printStackTrace();
            C0583t.m4574a(th22222);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3531s.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th222222) {
            th222222.printStackTrace();
            C0583t.m4574a(th222222);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3520h.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th2222222) {
            th2222222.printStackTrace();
            C0583t.m4574a(th2222222);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3528p.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            length += b2.length;
        } catch (Throwable th22222222) {
            th22222222.printStackTrace();
            C0583t.m4574a(th22222222);
            obj[length] = null;
            length++;
        }
        try {
            b2 = this.f3529q.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            i = b2.length + length;
        } catch (Throwable th222222222) {
            th222222222.printStackTrace();
            C0583t.m4574a(th222222222);
            obj[length] = null;
            i = length + 1;
        }
        if (TextUtils.isEmpty(this.f3530r)) {
            obj[i] = null;
            length = i + 1;
        } else {
            a = m4547a(this.f3530r);
            obj[i] = (byte) a.length;
            i++;
            System.arraycopy(a, 0, obj, i, a.length);
            length = a.length + i;
        }
        try {
            b2 = this.f3532t.getBytes("GBK");
            obj[length] = (byte) b2.length;
            length++;
            System.arraycopy(b2, 0, obj, length, b2.length);
            i = b2.length + length;
        } catch (Throwable th2222222222) {
            th2222222222.printStackTrace();
            C0583t.m4574a(th2222222222);
            obj[length] = null;
            i = length + 1;
        }
        obj[i] = Byte.parseByte(this.f3533u);
        i++;
        obj[i] = Byte.parseByte(this.f3522j);
        i++;
        if (this.f3522j.equals(C0108a.f262e) || this.f3522j.equals("2")) {
            a = C0579q.m4559a(Integer.parseInt(this.f3524l));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
        }
        if (this.f3522j.equals(C0108a.f262e) || this.f3522j.equals("2")) {
            a = C0579q.m4559a(Integer.parseInt(this.f3525m));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
        }
        if (this.f3522j.equals(C0108a.f262e) || this.f3522j.equals("2")) {
            a = C0579q.m4563b(this.f3526n);
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
        }
        obj[i] = Byte.parseByte(this.f3534v);
        i++;
        if (this.f3534v.equals(C0108a.f262e)) {
            a = C0579q.m4563b(m4548b("mcc"));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
            a = C0579q.m4563b(m4548b("mnc"));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
            a = C0579q.m4563b(m4548b("lac"));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
            a = C0579q.m4561a(m4548b("cellid"));
            System.arraycopy(a, 0, obj, i, a.length);
            length = a.length + i;
            i = Integer.parseInt(m4548b("signal"));
            if (i > 127) {
                i = 0;
            } else if (i < -128) {
                i = 0;
            }
            obj[length] = (byte) i;
            i = length + 1;
            if (this.f3536x.length() == 0) {
                obj[i] = null;
                i++;
            } else {
                int length2 = this.f3536x.split("\\*").length;
                obj[i] = (byte) length2;
                i++;
                length = 0;
                while (length < length2) {
                    b = C0579q.m4563b(m4546a("lac", length));
                    System.arraycopy(b, 0, obj, i, b.length);
                    i += b.length;
                    b = C0579q.m4561a(m4546a("cellid", length));
                    System.arraycopy(b, 0, obj, i, b.length);
                    int length3 = b.length + i;
                    i = Integer.parseInt(m4546a("signal", length));
                    if (i > 127) {
                        i = 0;
                    } else if (i < -128) {
                        i = 0;
                    }
                    obj[length3] = (byte) i;
                    length++;
                    i = length3 + 1;
                }
            }
        } else if (this.f3534v.equals("2")) {
            a = C0579q.m4563b(m4548b("mcc"));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
            a = C0579q.m4563b(m4548b("sid"));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
            a = C0579q.m4563b(m4548b("nid"));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
            a = C0579q.m4563b(m4548b("bid"));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
            a = C0579q.m4561a(m4548b("lon"));
            System.arraycopy(a, 0, obj, i, a.length);
            i += a.length;
            a = C0579q.m4561a(m4548b("lat"));
            System.arraycopy(a, 0, obj, i, a.length);
            length = a.length + i;
            i = Integer.parseInt(m4548b("signal"));
            if (i > 127) {
                i = 0;
            } else if (i < -128) {
                i = 0;
            }
            obj[length] = (byte) i;
            i = length + 1;
            obj[i] = null;
            i++;
        }
        if (this.f3538z.length() == 0) {
            obj[i] = null;
            i++;
        } else {
            String[] split;
            obj[i] = 1;
            length = i + 1;
            try {
                split = this.f3538z.split(",");
                b2 = m4547a(split[0]);
                System.arraycopy(b2, 0, obj, length, b2.length);
                length += b2.length;
                b2 = split[2].getBytes("GBK");
                obj[length] = (byte) b2.length;
                length++;
                System.arraycopy(b2, 0, obj, length, b2.length);
                length += b2.length;
            } catch (Throwable th22222222222) {
                th22222222222.printStackTrace();
                C0583t.m4574a(th22222222222);
                obj[length] = null;
                i = length + 1;
            }
            i = Integer.parseInt(split[1]);
            if (i > 127) {
                i = 0;
            } else if (i < -128) {
                i = 0;
            }
            obj[length] = Byte.parseByte(String.valueOf(i));
            i = length + 1;
        }
        String[] split2 = this.f3537y.split("\\*");
        if (TextUtils.isEmpty(this.f3537y) || split2.length == 0) {
            obj[i] = null;
            i++;
        } else {
            obj[i] = (byte) split2.length;
            i++;
            length3 = 0;
            while (length3 < split2.length) {
                String[] split3 = split2[length3].split(",");
                a = m4547a(split3[0]);
                System.arraycopy(a, 0, obj, i, a.length);
                length = a.length + i;
                try {
                    b2 = split3[2].getBytes("GBK");
                    obj[length] = (byte) b2.length;
                    length++;
                    System.arraycopy(b2, 0, obj, length, b2.length);
                    i = b2.length + length;
                } catch (Throwable th222222222222) {
                    th222222222222.printStackTrace();
                    C0583t.m4574a(th222222222222);
                    obj[length] = null;
                    i = length + 1;
                }
                length = Integer.parseInt(split3[1]);
                if (length > 127) {
                    length = 0;
                } else if (length < -128) {
                    length = 0;
                }
                obj[i] = Byte.parseByte(String.valueOf(length));
                length3++;
                i++;
            }
        }
        if (this.f3512A != null) {
            length = this.f3512A.length;
        } else {
            length = 0;
        }
        b = C0579q.m4562b(length);
        System.arraycopy(b, 0, obj, i, b.length);
        i += b.length;
        if (length > 0) {
            System.arraycopy(this.f3512A, 0, obj, i, this.f3512A.length);
            i += this.f3512A.length;
        }
        a = new byte[i];
        System.arraycopy(obj, 0, a, 0, i);
        CRC32 crc32 = new CRC32();
        crc32.update(a);
        b = C0579q.m4560a(crc32.getValue());
        obj = new byte[(b.length + i)];
        System.arraycopy(a, 0, obj, 0, i);
        System.arraycopy(b, 0, obj, i, b.length);
        i += b.length;
        return obj;
    }

    /* renamed from: a */
    private byte[] m4547a(String str) {
        String[] split = str.split(":");
        if (split == null || split.length != 6) {
            String[] strArr = new String[6];
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = "0";
            }
            split = strArr;
        }
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].length() > 2) {
                split[i2] = split[i2].substring(0, 2);
            }
            bArr[i2] = (byte) Integer.parseInt(split[i2], 16);
        }
        return bArr;
    }

    /* renamed from: b */
    private String m4548b(String str) {
        if (!this.f3535w.contains(str + ">")) {
            return "0";
        }
        int indexOf = this.f3535w.indexOf(str + ">");
        return this.f3535w.substring((indexOf + str.length()) + 1, this.f3535w.indexOf("</" + str));
    }

    /* renamed from: a */
    private String m4546a(String str, int i) {
        String[] split = this.f3536x.split("\\*")[i].split(",");
        if (str.equals("lac")) {
            return split[0];
        }
        if (str.equals("cellid")) {
            return split[1];
        }
        if (str.equals("signal")) {
            return split[2];
        }
        return null;
    }

    /* renamed from: b */
    private void m4549b() {
        if (this.f3513a == null) {
            this.f3513a = bi_常量类.f6358b_空串;
        }
        if (this.f3515c == null) {
            this.f3515c = bi_常量类.f6358b_空串;
        }
        if (this.f3516d == null) {
            this.f3516d = bi_常量类.f6358b_空串;
        }
        if (this.f3517e == null) {
            this.f3517e = bi_常量类.f6358b_空串;
        }
        if (this.f3518f == null) {
            this.f3518f = bi_常量类.f6358b_空串;
        }
        if (this.f3519g == null) {
            this.f3519g = bi_常量类.f6358b_空串;
        }
        if (this.f3520h == null) {
            this.f3520h = bi_常量类.f6358b_空串;
        }
        if (this.f3521i == null) {
            this.f3521i = bi_常量类.f6358b_空串;
        }
        if (this.f3522j == null) {
            this.f3522j = "0";
        } else if (!(this.f3522j.equals(C0108a.f262e) || this.f3522j.equals("2"))) {
            this.f3522j = "0";
        }
        if (this.f3523k == null) {
            this.f3523k = "0";
        } else if (!(this.f3523k.equals("0") || this.f3523k.equals(C0108a.f262e))) {
            this.f3523k = "0";
        }
        if (this.f3524l == null) {
            this.f3524l = bi_常量类.f6358b_空串;
        } else {
            this.f3524l = String.valueOf(Double.valueOf(Double.parseDouble(this.f3524l) * 1200000.0d).intValue());
        }
        if (this.f3525m == null) {
            this.f3525m = bi_常量类.f6358b_空串;
        } else {
            this.f3525m = String.valueOf(Double.valueOf(Double.parseDouble(this.f3525m) * 1000000.0d).intValue());
        }
        if (this.f3526n == null) {
            this.f3526n = bi_常量类.f6358b_空串;
        }
        if (this.f3527o == null) {
            this.f3527o = bi_常量类.f6358b_空串;
        }
        if (this.f3528p == null) {
            this.f3528p = bi_常量类.f6358b_空串;
        }
        if (this.f3529q == null) {
            this.f3529q = bi_常量类.f6358b_空串;
        }
        if (this.f3530r == null) {
            this.f3530r = bi_常量类.f6358b_空串;
        }
        if (this.f3531s == null) {
            this.f3531s = bi_常量类.f6358b_空串;
        }
        if (this.f3532t == null) {
            this.f3532t = bi_常量类.f6358b_空串;
        }
        if (this.f3533u == null) {
            this.f3533u = "0";
        } else if (!(this.f3533u.equals(C0108a.f262e) || this.f3533u.equals("2"))) {
            this.f3533u = "0";
        }
        if (this.f3534v == null) {
            this.f3534v = "0";
        } else if (!(this.f3534v.equals(C0108a.f262e) || this.f3534v.equals("2"))) {
            this.f3534v = "0";
        }
        if (this.f3535w == null) {
            this.f3535w = bi_常量类.f6358b_空串;
        }
        if (this.f3536x == null) {
            this.f3536x = bi_常量类.f6358b_空串;
        }
        if (this.f3537y == null) {
            this.f3537y = bi_常量类.f6358b_空串;
        }
        if (this.f3538z == null) {
            this.f3538z = bi_常量类.f6358b_空串;
        }
        if (this.f3512A == null) {
            this.f3512A = new byte[0];
        }
    }
}
