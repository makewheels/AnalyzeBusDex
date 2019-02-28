package com.aps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.BitSet;
import p054u.aly.bi_常量类;

public final class bd {
    /* renamed from: a */
    private RandomAccessFile f3412a;
    /* renamed from: b */
    private af f3413b;
    /* renamed from: c */
    private String f3414c = bi_常量类.f6358b_空串;
    /* renamed from: d */
    private File f3415d = null;

    protected bd(af afVar) {
        this.f3413b = afVar;
    }

    /* renamed from: a */
    protected final synchronized void m4425a(long j, byte[] bArr) {
        int i = 0;
        synchronized (this) {
            this.f3415d = this.f3413b.m4324a(j);
            if (this.f3415d != null) {
                try {
                    this.f3412a = new RandomAccessFile(this.f3415d, "rw");
                    byte[] bArr2 = new byte[this.f3413b.m4323a()];
                    int readInt = this.f3412a.read(bArr2) == -1 ? 0 : this.f3412a.readInt();
                    BitSet b = af.m4316b(bArr2);
                    int a = (this.f3413b.m4323a() + 4) + (readInt * 1500);
                    if (readInt < 0 || readInt > (this.f3413b.m4323a() << 3)) {
                        this.f3412a.close();
                        this.f3415d.delete();
                        if (this.f3412a != null) {
                            try {
                                this.f3412a.close();
                            } catch (IOException e) {
                            }
                        }
                    } else {
                        this.f3412a.seek((long) a);
                        byte[] a2 = af.m4314a(bArr);
                        this.f3412a.writeInt(a2.length);
                        this.f3412a.writeLong(j);
                        this.f3412a.write(a2);
                        b.set(readInt, true);
                        this.f3412a.seek(0);
                        this.f3412a.write(af.m4313a(b));
                        readInt++;
                        if (readInt != (this.f3413b.m4323a() << 3)) {
                            i = readInt;
                        }
                        this.f3412a.writeInt(i);
                        if (!this.f3414c.equalsIgnoreCase(this.f3415d.getName())) {
                            this.f3414c = this.f3415d.getName();
                        }
                        this.f3415d.length();
                        if (this.f3412a != null) {
                            try {
                                this.f3412a.close();
                            } catch (IOException e2) {
                            }
                        }
                        this.f3415d = null;
                    }
                } catch (FileNotFoundException e3) {
                    if (this.f3412a != null) {
                        try {
                            this.f3412a.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (IOException e5) {
                    if (this.f3412a != null) {
                        try {
                            this.f3412a.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (Throwable th) {
                    if (this.f3412a != null) {
                        try {
                            this.f3412a.close();
                        } catch (IOException e7) {
                        }
                    }
                }
            }
        }
        return;
    }
}
