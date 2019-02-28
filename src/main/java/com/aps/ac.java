package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

final class ac implements Serializable {
    /* renamed from: a */
    protected byte f3308a = (byte) 0;
    /* renamed from: b */
    protected ArrayList f3309b = new ArrayList();
    /* renamed from: c */
    private byte f3310c = (byte) 8;

    ac() {
    }

    /* renamed from: a */
    protected final Boolean m4304a(DataOutputStream dataOutputStream) {
        try {
            dataOutputStream.writeByte(this.f3310c);
            dataOutputStream.writeByte(this.f3308a);
            for (byte b = (byte) 0; b < this.f3308a; b++) {
                ad adVar = (ad) this.f3309b.get(b);
                dataOutputStream.write(adVar.f3311a);
                dataOutputStream.writeShort(adVar.f3312b);
                dataOutputStream.write(af.m4315a(adVar.f3313c, adVar.f3313c.length));
            }
            return Boolean.valueOf(true);
        } catch (IOException e) {
            return Boolean.valueOf(false);
        }
    }
}
