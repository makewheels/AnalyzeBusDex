package com.tencent.wxop.stat.common;

/* renamed from: com.tencent.wxop.stat.common.g */
public class C1188g {
    /* renamed from: a */
    static final /* synthetic */ boolean f5462a = (!C1188g.class.desiredAssertionStatus());

    private C1188g() {
    }

    /* renamed from: a */
    public static byte[] m8261a(byte[] bArr, int i) {
        return C1188g.m8262a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m8262a(byte[] bArr, int i, int i2, int i3) {
        C1190i c1190i = new C1190i(i3, new byte[((i2 * 3) / 4)]);
        if (!c1190i.m8265a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c1190i.b == c1190i.a.length) {
            return c1190i.a;
        } else {
            Object obj = new byte[c1190i.b];
            System.arraycopy(c1190i.a, 0, obj, 0, c1190i.b);
            return obj;
        }
    }

    /* renamed from: b */
    public static byte[] m8263b(byte[] bArr, int i) {
        return C1188g.m8264b(bArr, 0, bArr.length, i);
    }

    /* renamed from: b */
    public static byte[] m8264b(byte[] bArr, int i, int i2, int i3) {
        C1191j c1191j = new C1191j(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!c1191j.f5474d) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (c1191j.f5475e && i2 > 0) {
            i4 += (c1191j.f5476f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        c1191j.a = new byte[i4];
        c1191j.m8266a(bArr, i, i2, true);
        if (f5462a || c1191j.b == i4) {
            return c1191j.a;
        }
        throw new AssertionError();
    }
}
