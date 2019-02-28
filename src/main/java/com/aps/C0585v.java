package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: com.aps.v */
final class C0585v implements Serializable {
    /* renamed from: a */
    protected short f3554a = (short) 0;
    /* renamed from: b */
    protected int f3555b = 0;
    /* renamed from: c */
    protected byte f3556c = (byte) 0;
    /* renamed from: d */
    protected byte f3557d = (byte) 0;
    /* renamed from: e */
    protected ArrayList f3558e = new ArrayList();
    /* renamed from: f */
    private byte f3559f = (byte) 2;

    C0585v() {
    }

    /* renamed from: a */
    protected final Boolean m4586a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.f3559f);
            dataOutputStream.writeShort(this.f3554a);
            dataOutputStream.writeInt(this.f3555b);
            dataOutputStream.writeByte(this.f3556c);
            dataOutputStream.writeByte(this.f3557d);
            for (byte b = (byte) 0; b < this.f3557d; b++) {
                dataOutputStream.writeShort(((ah) this.f3558e.get(b)).f3329a);
                dataOutputStream.writeInt(((ah) this.f3558e.get(b)).f3330b);
                dataOutputStream.writeByte(((ah) this.f3558e.get(b)).f3331c);
            }
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }
}
