package com.aps;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

final class aa implements Serializable {
    /* renamed from: a */
    protected byte[] f3296a = new byte[16];
    /* renamed from: b */
    protected byte[] f3297b = new byte[16];
    /* renamed from: c */
    protected byte[] f3298c = new byte[16];
    /* renamed from: d */
    protected short f3299d = (short) 0;
    /* renamed from: e */
    protected short f3300e = (short) 0;
    /* renamed from: f */
    protected byte f3301f = (byte) 0;
    /* renamed from: g */
    protected byte[] f3302g = new byte[16];
    /* renamed from: h */
    protected byte[] f3303h = new byte[32];
    /* renamed from: i */
    protected short f3304i = (short) 0;
    /* renamed from: j */
    protected ArrayList f3305j = new ArrayList();
    /* renamed from: k */
    private byte f3306k = (byte) 4;
    /* renamed from: l */
    private short f3307l = (short) 0;

    aa() {
    }

    /* renamed from: a */
    private Boolean m4301a(DataOutputStream dataOutputStream) {
        Boolean.valueOf(true);
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream2.flush();
            dataOutputStream2.write(this.f3296a);
            dataOutputStream2.write(this.f3297b);
            dataOutputStream2.write(this.f3298c);
            dataOutputStream2.writeShort(this.f3299d);
            dataOutputStream2.writeShort(this.f3300e);
            dataOutputStream2.writeByte(this.f3301f);
            this.f3302g[15] = (byte) 0;
            dataOutputStream2.write(af.m4315a(this.f3302g, this.f3302g.length));
            this.f3303h[31] = (byte) 0;
            dataOutputStream2.write(af.m4315a(this.f3303h, this.f3303h.length));
            dataOutputStream2.writeShort(this.f3304i);
            for (short s = (short) 0; s < this.f3304i; s = (short) (s + 1)) {
                OutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream3 = new DataOutputStream(byteArrayOutputStream2);
                dataOutputStream3.flush();
                C0587x c0587x = (C0587x) this.f3305j.get(s);
                if (!(c0587x.f3567c == null || c0587x.f3567c.m4643a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(c0587x.f3568d == null || c0587x.f3568d.m4586a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(c0587x.f3569e == null || c0587x.f3569e.m4328a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                if (!(c0587x.f3570f == null || c0587x.f3570f.m4304a(dataOutputStream3).booleanValue())) {
                    Boolean.valueOf(false);
                }
                c0587x.f3565a = Integer.valueOf(byteArrayOutputStream2.size() + 4).shortValue();
                dataOutputStream2.writeShort(c0587x.f3565a);
                dataOutputStream2.writeInt(c0587x.f3566b);
                dataOutputStream2.write(byteArrayOutputStream2.toByteArray());
            }
            this.f3307l = Integer.valueOf(byteArrayOutputStream.size()).shortValue();
            dataOutputStream.writeByte(this.f3306k);
            dataOutputStream.writeShort(this.f3307l);
            dataOutputStream.write(byteArrayOutputStream.toByteArray());
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }

    /* renamed from: a */
    protected final byte[] m4302a() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m4301a(new DataOutputStream(byteArrayOutputStream));
        return byteArrayOutputStream.toByteArray();
    }
}
