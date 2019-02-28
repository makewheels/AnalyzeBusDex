package p054u.aly;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TIOStreamTransport */
/* renamed from: u.aly.dk */
public class dk extends dm {
    /* renamed from: a */
    protected InputStream f6531a = null;
    /* renamed from: b */
    protected OutputStream f6532b = null;

    protected dk() {
    }

    public dk(InputStream inputStream) {
        this.f6531a = inputStream;
    }

    public dk(OutputStream outputStream) {
        this.f6532b = outputStream;
    }

    public dk(InputStream inputStream, OutputStream outputStream) {
        this.f6531a = inputStream;
        this.f6532b = outputStream;
    }

    /* renamed from: a */
    public boolean mo1988a() {
        return true;
    }

    /* renamed from: b */
    public void mo1989b() throws dn {
    }

    /* renamed from: c */
    public void mo1991c() {
        if (this.f6531a != null) {
            try {
                this.f6531a.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f6531a = null;
        }
        if (this.f6532b != null) {
            try {
                this.f6532b.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f6532b = null;
        }
    }

    /* renamed from: a */
    public int mo1987a(byte[] bArr, int i, int i2) throws dn {
        if (this.f6531a == null) {
            throw new dn(1, "Cannot read from null inputStream");
        }
        try {
            int read = this.f6531a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new dn(4);
        } catch (Throwable e) {
            throw new dn(0, e);
        }
    }

    /* renamed from: b */
    public void mo1990b(byte[] bArr, int i, int i2) throws dn {
        if (this.f6532b == null) {
            throw new dn(1, "Cannot write to null outputStream");
        }
        try {
            this.f6532b.write(bArr, i, i2);
        } catch (Throwable e) {
            throw new dn(0, e);
        }
    }

    /* renamed from: d */
    public void mo1992d() throws dn {
        if (this.f6532b == null) {
            throw new dn(1, "Cannot flush null outputStream");
        }
        try {
            this.f6532b.flush();
        } catch (Throwable e) {
            throw new dn(0, e);
        }
    }
}
