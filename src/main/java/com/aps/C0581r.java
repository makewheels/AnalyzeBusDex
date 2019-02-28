package com.aps;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import p054u.aly.df;

/* compiled from: StrictLineReader */
/* renamed from: com.aps.r */
class C0581r implements Closeable {
    /* renamed from: a */
    private final InputStream f3546a;
    /* renamed from: b */
    private final Charset f3547b;
    /* renamed from: c */
    private byte[] f3548c;
    /* renamed from: d */
    private int f3549d;
    /* renamed from: e */
    private int f3550e;

    public C0581r(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C0581r(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C0582s.f3551a)) {
            this.f3546a = inputStream;
            this.f3547b = charset;
            this.f3548c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f3546a) {
            if (this.f3548c != null) {
                this.f3548c = null;
                this.f3546a.close();
            }
        }
    }

    /* renamed from: a */
    public String m4566a() throws IOException {
        String str;
        synchronized (this.f3546a) {
            if (this.f3548c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f3549d >= this.f3550e) {
                m4565b();
            }
            int i2 = this.f3549d;
            while (i2 != this.f3550e) {
                if (this.f3548c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f3549d || this.f3548c[i2 - 1] != df.f6527k) ? i2 : i2 - 1;
                    str = new String(this.f3548c, this.f3549d, i3 - this.f3549d, this.f3547b.name());
                    this.f3549d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c05801 = new ByteArrayOutputStream(this, (this.f3550e - this.f3549d) + 80) {
                /* renamed from: a */
                final /* synthetic */ C0581r f3545a;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != df.f6527k) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, this.f3545a.f3547b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                c05801.write(this.f3548c, this.f3549d, this.f3550e - this.f3549d);
                this.f3550e = -1;
                m4565b();
                i = this.f3549d;
                while (i != this.f3550e) {
                    if (this.f3548c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f3549d) {
                c05801.write(this.f3548c, this.f3549d, i - this.f3549d);
            }
            this.f3549d = i + 1;
            str = c05801.toString();
        }
        return str;
    }

    /* renamed from: b */
    private void m4565b() throws IOException {
        int read = this.f3546a.read(this.f3548c, 0, this.f3548c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f3549d = 0;
        this.f3550e = read;
    }
}
