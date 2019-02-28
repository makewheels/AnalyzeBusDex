package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import p054u.aly.df;

/* compiled from: StrictLineReader */
public class bp implements Closeable {
    /* renamed from: a */
    private final InputStream f2077a;
    /* renamed from: b */
    private final Charset f2078b;
    /* renamed from: c */
    private byte[] f2079c;
    /* renamed from: d */
    private int f2080d;
    /* renamed from: e */
    private int f2081e;

    public bp(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public bp(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(bq.f2082a)) {
            this.f2077a = inputStream;
            this.f2078b = charset;
            this.f2079c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f2077a) {
            if (this.f2079c != null) {
                this.f2079c = null;
                this.f2077a.close();
            }
        }
    }

    /* renamed from: a */
    public String m3279a() throws IOException {
        String str;
        synchronized (this.f2077a) {
            if (this.f2079c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f2080d >= this.f2081e) {
                m3278b();
            }
            int i2 = this.f2080d;
            while (i2 != this.f2081e) {
                if (this.f2079c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f2080d || this.f2079c[i2 - 1] != df.f6527k) ? i2 : i2 - 1;
                    str = new String(this.f2079c, this.f2080d, i3 - this.f2080d, this.f2078b.name());
                    this.f2080d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c03711 = new ByteArrayOutputStream(this, (this.f2081e - this.f2080d) + 80) {
                /* renamed from: a */
                final /* synthetic */ bp f2076a;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != df.f6527k) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, this.f2076a.f2078b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                c03711.write(this.f2079c, this.f2080d, this.f2081e - this.f2080d);
                this.f2081e = -1;
                m3278b();
                i = this.f2080d;
                while (i != this.f2081e) {
                    if (this.f2079c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f2080d) {
                c03711.write(this.f2079c, this.f2080d, i - this.f2080d);
            }
            this.f2080d = i + 1;
            str = c03711.toString();
        }
        return str;
    }

    /* renamed from: b */
    private void m3278b() throws IOException {
        int read = this.f2077a.read(this.f2079c, 0, this.f2079c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f2080d = 0;
        this.f2081e = read;
    }
}
