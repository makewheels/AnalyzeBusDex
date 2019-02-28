package com.autonavi.tbt;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import p054u.aly.df;

/* compiled from: StrictLineReader */
public class ap implements Closeable {
    /* renamed from: a */
    private final InputStream f3746a;
    /* renamed from: b */
    private final Charset f3747b;
    /* renamed from: c */
    private byte[] f3748c;
    /* renamed from: d */
    private int f3749d;
    /* renamed from: e */
    private int f3750e;

    public ap(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public ap(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(aq.f3751a)) {
            this.f3746a = inputStream;
            this.f3747b = charset;
            this.f3748c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f3746a) {
            if (this.f3748c != null) {
                this.f3748c = null;
                this.f3746a.close();
            }
        }
    }

    /* renamed from: a */
    public String m4763a() throws IOException {
        String str;
        synchronized (this.f3746a) {
            if (this.f3748c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f3749d >= this.f3750e) {
                m4762b();
            }
            int i2 = this.f3749d;
            while (i2 != this.f3750e) {
                if (this.f3748c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f3749d || this.f3748c[i2 - 1] != df.f6527k) ? i2 : i2 - 1;
                    str = new String(this.f3748c, this.f3749d, i3 - this.f3749d, this.f3747b.name());
                    this.f3749d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c06071 = new ByteArrayOutputStream(this, (this.f3750e - this.f3749d) + 80) {
                /* renamed from: a */
                final /* synthetic */ ap f3745a;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != df.f6527k) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, this.f3745a.f3747b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                c06071.write(this.f3748c, this.f3749d, this.f3750e - this.f3749d);
                this.f3750e = -1;
                m4762b();
                i = this.f3749d;
                while (i != this.f3750e) {
                    if (this.f3748c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f3749d) {
                c06071.write(this.f3748c, this.f3749d, i - this.f3749d);
            }
            this.f3749d = i + 1;
            str = c06071.toString();
        }
        return str;
    }

    /* renamed from: b */
    private void m4762b() throws IOException {
        int read = this.f3746a.read(this.f3748c, 0, this.f3748c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f3749d = 0;
        this.f3750e = read;
    }
}
