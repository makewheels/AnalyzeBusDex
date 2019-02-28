package com.aps;

import com.aps.C0565g.C0562a;
import com.aps.C0565g.C0564c;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: SimpleDiskCache */
/* renamed from: com.aps.p */
public class C0578p {
    /* renamed from: a */
    private static final List<File> f3541a = new ArrayList();
    /* renamed from: b */
    private C0565g f3542b;
    /* renamed from: c */
    private int f3543c;

    /* compiled from: SimpleDiskCache */
    /* renamed from: com.aps.p$a */
    private static class C0577a extends FilterOutputStream {
        /* renamed from: a */
        private final C0562a f3539a;
        /* renamed from: b */
        private boolean f3540b;

        private C0577a(OutputStream outputStream, C0562a c0562a) {
            super(outputStream);
            this.f3540b = false;
            this.f3539a = c0562a;
        }

        public void close() throws IOException {
            IOException iOException = null;
            try {
                super.close();
            } catch (IOException e) {
                iOException = e;
            }
            if (this.f3540b) {
                this.f3539a.m4486b();
            } else {
                this.f3539a.m4485a();
            }
            if (iOException != null) {
                throw iOException;
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                this.f3540b = true;
                throw e;
            }
        }

        public void write(int i) throws IOException {
            try {
                super.write(i);
            } catch (IOException e) {
                this.f3540b = true;
                throw e;
            }
        }

        public void write(byte[] bArr) throws IOException {
            try {
                super.write(bArr);
            } catch (IOException e) {
                this.f3540b = true;
                throw e;
            }
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                super.write(bArr, i, i2);
            } catch (IOException e) {
                this.f3540b = true;
                throw e;
            }
        }
    }

    private C0578p(File file, int i, long j) throws IOException {
        this.f3543c = i;
        this.f3542b = C0565g.m4504a(file, i, 1, j);
    }

    /* renamed from: a */
    public static synchronized C0578p m4551a(File file, int i, long j) throws IOException {
        C0578p c0578p;
        synchronized (C0578p.class) {
            if (f3541a.contains(file)) {
                throw new IllegalStateException("Cache dir " + file.getAbsolutePath() + " was used before.");
            }
            f3541a.add(file);
            c0578p = new C0578p(file, i, j);
        }
        return c0578p;
    }

    /* renamed from: a */
    public Map<String, Serializable> m4556a(String str) throws IOException {
        C0564c a = this.f3542b.m4524a(m4553b(str));
        if (a == null) {
            return null;
        }
        try {
            Map<String, Serializable> a2 = m4552a(a);
            return a2;
        } finally {
            a.close();
        }
    }

    /* renamed from: a */
    public OutputStream m4555a(String str, Map<String, ? extends Serializable> map) throws IOException {
        C0562a b = this.f3542b.m4526b(m4553b(str));
        try {
            OutputStream objectOutputStream = new ObjectOutputStream(b.m4484a(0));
            objectOutputStream.writeObject(map);
            return new C0577a(objectOutputStream, b);
        } catch (IOException e) {
            b.m4486b();
            throw e;
        }
    }

    /* renamed from: b */
    public void m4557b(String str, Map<String, ? extends Serializable> map) throws IOException {
        OutputStream outputStream = null;
        try {
            outputStream = m4555a(str, map);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    /* renamed from: a */
    private Map<String, Serializable> m4552a(C0564c c0564c) throws IOException {
        Throwable e;
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(c0564c.m4501a(0)));
            try {
                Map<String, Serializable> map = (Map) objectInputStream.readObject();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                return map;
            } catch (ClassNotFoundException e2) {
                e = e2;
                try {
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    e = th;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e;
                }
            }
        } catch (ClassNotFoundException e3) {
            e = e3;
            objectInputStream = null;
            throw new RuntimeException(e);
        } catch (Throwable th2) {
            e = th2;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw e;
        }
    }

    /* renamed from: b */
    private String m4553b(String str) {
        return m4554c(str);
    }

    /* renamed from: c */
    private String m4554c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("UTF-8"));
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError();
        }
    }
}
