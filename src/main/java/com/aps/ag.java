package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

final class ag implements Serializable {
    /* renamed from: a */
    protected int f3322a = 0;
    /* renamed from: b */
    protected int f3323b = 0;
    /* renamed from: c */
    protected short f3324c = (short) 0;
    /* renamed from: d */
    protected short f3325d = (short) 0;
    /* renamed from: e */
    protected int f3326e = 0;
    /* renamed from: f */
    protected byte f3327f = (byte) 0;
    /* renamed from: g */
    private byte f3328g = (byte) 4;

    ag() {
    }

    /* renamed from: a */
    protected final Boolean m4328a(DataOutputStream dataOutputStream) {
        Boolean valueOf = Boolean.valueOf(false);
        try {
            dataOutputStream.writeByte(this.f3328g);
            dataOutputStream.writeInt(this.f3322a);
            dataOutputStream.writeInt(this.f3323b);
            dataOutputStream.writeShort(this.f3324c);
            dataOutputStream.writeShort(this.f3325d);
            dataOutputStream.writeInt(this.f3326e);
            dataOutputStream.writeByte(this.f3327f);
            valueOf = Boolean.valueOf(true);
        } catch (IOException e) {
        }
        return valueOf;
    }
}
