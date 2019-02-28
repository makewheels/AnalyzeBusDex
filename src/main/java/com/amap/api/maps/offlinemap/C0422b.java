package com.amap.api.maps.offlinemap;

import com.amap.api.mapcore.util.az;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import p054u.aly.bi_常量类;

/* compiled from: FileAccessI */
/* renamed from: com.amap.api.maps.offlinemap.b */
class C0422b {
    /* renamed from: a */
    RandomAccessFile f2448a;

    public C0422b() throws IOException {
        this(bi_常量类.f6358b_空串, 0);
    }

    public C0422b(String str, long j) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Throwable e) {
                az.m3143a(e, "FileAccessI", "create");
                e.printStackTrace();
            }
        }
        this.f2448a = new RandomAccessFile(str, "rw");
        this.f2448a.seek(j);
    }

    /* renamed from: a */
    public synchronized int m3651a(byte[] bArr, int i, int i2) {
        try {
            this.f2448a.write(bArr, i, i2);
        } catch (Throwable e) {
            az.m3143a(e, "FileAccessI", "write");
            e.printStackTrace();
            i2 = -1;
        }
        return i2;
    }
}
