package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

/* renamed from: com.aps.z */
final class C0589z implements Serializable {
    /* renamed from: a */
    protected int f3623a = 0;
    /* renamed from: b */
    protected int f3624b = 0;
    /* renamed from: c */
    protected int f3625c = 0;
    /* renamed from: d */
    protected int f3626d = 0;
    /* renamed from: e */
    protected int f3627e = 0;
    /* renamed from: f */
    protected short f3628f = (short) 0;
    /* renamed from: g */
    protected byte f3629g = (byte) 0;
    /* renamed from: h */
    protected byte f3630h = (byte) 0;
    /* renamed from: i */
    protected long f3631i = 0;
    /* renamed from: j */
    protected long f3632j = 0;
    /* renamed from: k */
    private byte f3633k = (byte) 1;

    C0589z() {
    }

    /* renamed from: a */
    protected final Boolean m4643a(DataOutputStream dataOutputStream) {
        Boolean valueOf = Boolean.valueOf(false);
        if (dataOutputStream != null) {
            try {
                dataOutputStream.writeByte(this.f3633k);
                dataOutputStream.writeInt(this.f3623a);
                dataOutputStream.writeInt(this.f3624b);
                dataOutputStream.writeInt(this.f3625c);
                dataOutputStream.writeInt(this.f3626d);
                dataOutputStream.writeInt(this.f3627e);
                dataOutputStream.writeShort(this.f3628f);
                dataOutputStream.writeByte(this.f3629g);
                dataOutputStream.writeByte(this.f3630h);
                dataOutputStream.writeLong(this.f3631i);
                dataOutputStream.writeLong(this.f3632j);
                valueOf = Boolean.valueOf(true);
            } catch (IOException e) {
            }
        }
        return valueOf;
    }
}
