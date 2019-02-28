package com.aps;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ae {
    /* renamed from: a */
    protected File f3314a;
    /* renamed from: b */
    protected int[] f3315b;
    /* renamed from: c */
    private ArrayList f3316c;
    /* renamed from: d */
    private boolean f3317d = false;

    protected ae(File file, ArrayList arrayList, int[] iArr) {
        this.f3314a = file;
        this.f3316c = arrayList;
        this.f3315b = iArr;
    }

    /* renamed from: a */
    protected final void m4305a(boolean z) {
        this.f3317d = z;
    }

    /* renamed from: a */
    public byte[] m4306a() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Iterator it = this.f3316c.iterator();
        while (it.hasNext()) {
            byte[] bArr = (byte[]) it.next();
            try {
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            } catch (IOException e) {
            }
        }
        try {
            byteArrayOutputStream.close();
            dataOutputStream.close();
        } catch (IOException e2) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: b */
    protected final boolean m4307b() {
        return this.f3317d;
    }

    /* renamed from: c */
    protected final int m4308c() {
        if (this.f3316c == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f3316c.size(); i2++) {
            i += this.f3316c.get(i2) != null ? ((byte[]) this.f3316c.get(i2)).length : 0;
        }
        return i;
    }
}
