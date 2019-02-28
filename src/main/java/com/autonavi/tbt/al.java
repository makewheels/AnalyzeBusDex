package com.autonavi.tbt;

import com.alipay.sdk.cons.C0108a;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import p054u.aly.bi_常量类;

/* compiled from: DiskLruCache */
public final class al implements Closeable {
    /* renamed from: a */
    static final Pattern f3727a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* renamed from: q */
    private static final OutputStream f3728q = new an();
    /* renamed from: b */
    final ThreadPoolExecutor f3729b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: c */
    private final File f3730c;
    /* renamed from: d */
    private final File f3731d;
    /* renamed from: e */
    private final File f3732e;
    /* renamed from: f */
    private final File f3733f;
    /* renamed from: g */
    private final int f3734g;
    /* renamed from: h */
    private long f3735h;
    /* renamed from: i */
    private final int f3736i;
    /* renamed from: j */
    private long f3737j = 0;
    /* renamed from: k */
    private Writer f3738k;
    /* renamed from: l */
    private final LinkedHashMap<String, C0606c> f3739l = new LinkedHashMap(0, 0.75f, true);
    /* renamed from: m */
    private int f3740m;
    /* renamed from: n */
    private ao f3741n;
    /* renamed from: o */
    private long f3742o = 0;
    /* renamed from: p */
    private final Callable<Void> f3743p = new am(this);

    /* compiled from: DiskLruCache */
    /* renamed from: com.autonavi.tbt.al$a */
    public final class C0604a {
        /* renamed from: a */
        final /* synthetic */ al f3711a;
        /* renamed from: b */
        private final C0606c f3712b;
        /* renamed from: c */
        private final boolean[] f3713c;
        /* renamed from: d */
        private boolean f3714d;
        /* renamed from: e */
        private boolean f3715e;

        /* compiled from: DiskLruCache */
        /* renamed from: com.autonavi.tbt.al$a$a */
        private class C0603a extends FilterOutputStream {
            /* renamed from: a */
            final /* synthetic */ C0604a f3710a;

            private C0603a(C0604a c0604a, OutputStream outputStream) {
                this.f3710a = c0604a;
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    this.f3710a.f3714d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    this.f3710a.f3714d = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    this.f3710a.f3714d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    this.f3710a.f3714d = true;
                }
            }
        }

        private C0604a(al alVar, C0606c c0606c) {
            this.f3711a = alVar;
            this.f3712b = c0606c;
            this.f3713c = c0606c.f3724d ? null : new boolean[alVar.f3736i];
        }

        /* renamed from: a */
        public OutputStream m4714a(int i) throws IOException {
            if (i < 0 || i >= this.f3711a.f3736i) {
                throw new IllegalArgumentException("Expected index " + i + " to " + "be greater than 0 and less than the maximum value count " + "of " + this.f3711a.f3736i);
            }
            OutputStream d;
            synchronized (this.f3711a) {
                OutputStream fileOutputStream;
                if (this.f3712b.f3725e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f3712b.f3724d) {
                    this.f3713c[i] = true;
                }
                r1 = this.f3712b.m4730b(i);
                try {
                    fileOutputStream = new FileOutputStream(r1);
                } catch (FileNotFoundException e) {
                    this.f3711a.f3730c.mkdirs();
                    try {
                        File b;
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        d = al.f3728q;
                    }
                }
                d = new C0603a(fileOutputStream);
            }
            return d;
        }

        /* renamed from: a */
        public void m4715a() throws IOException {
            if (this.f3714d) {
                this.f3711a.m4735a(this, false);
                this.f3711a.m4759c(this.f3712b.f3722b);
            } else {
                this.f3711a.m4735a(this, true);
            }
            this.f3715e = true;
        }

        /* renamed from: b */
        public void m4716b() throws IOException {
            this.f3711a.m4735a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.autonavi.tbt.al$b */
    public final class C0605b implements Closeable {
        /* renamed from: a */
        final /* synthetic */ al f3716a;
        /* renamed from: b */
        private final String f3717b;
        /* renamed from: c */
        private final long f3718c;
        /* renamed from: d */
        private final InputStream[] f3719d;
        /* renamed from: e */
        private final long[] f3720e;

        private C0605b(al alVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f3716a = alVar;
            this.f3717b = str;
            this.f3718c = j;
            this.f3719d = inputStreamArr;
            this.f3720e = jArr;
        }

        public void close() {
            for (Closeable a : this.f3719d) {
                aq.m4764a(a);
            }
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.autonavi.tbt.al$c */
    private final class C0606c {
        /* renamed from: a */
        final /* synthetic */ al f3721a;
        /* renamed from: b */
        private final String f3722b;
        /* renamed from: c */
        private final long[] f3723c;
        /* renamed from: d */
        private boolean f3724d;
        /* renamed from: e */
        private C0604a f3725e;
        /* renamed from: f */
        private long f3726f;

        private C0606c(al alVar, String str) {
            this.f3721a = alVar;
            this.f3722b = str;
            this.f3723c = new long[alVar.f3736i];
        }

        /* renamed from: a */
        public String m4729a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f3723c) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        /* renamed from: a */
        private void m4721a(String[] strArr) throws IOException {
            if (strArr.length != this.f3721a.f3736i) {
                throw m4723b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f3723c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m4723b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m4723b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m4728a(int i) {
            return new File(this.f3721a.f3730c, this.f3722b + "." + i);
        }

        /* renamed from: b */
        public File m4730b(int i) {
            return new File(this.f3721a.f3730c, this.f3722b + "." + i + ".tmp");
        }
    }

    /* renamed from: a */
    public void m4754a(ao aoVar) {
        this.f3741n = aoVar;
    }

    private al(File file, int i, int i2, long j) {
        this.f3730c = file;
        this.f3734g = i;
        this.f3731d = new File(file, "journal");
        this.f3732e = new File(file, "journal.tmp");
        this.f3733f = new File(file, "journal.bkp");
        this.f3736i = i2;
        this.f3735h = j;
    }

    /* renamed from: a */
    public static al m4733a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    m4738a(file2, file3, false);
                }
            }
            al alVar = new al(file, i, i2, j);
            if (alVar.f3731d.exists()) {
                try {
                    alVar.m4745e();
                    alVar.m4748f();
                    alVar.f3738k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(alVar.f3731d, true), aq.f3751a));
                    return alVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    alVar.m4758c();
                }
            }
            file.mkdirs();
            alVar = new al(file, i, i2, j);
            alVar.m4749g();
            return alVar;
        }
    }

    /* renamed from: e */
    private void m4745e() throws IOException {
        Closeable apVar = new ap(new FileInputStream(this.f3731d), aq.f3751a);
        int i;
        try {
            String a = apVar.m4763a();
            String a2 = apVar.m4763a();
            String a3 = apVar.m4763a();
            String a4 = apVar.m4763a();
            String a5 = apVar.m4763a();
            if ("libcore.io.DiskLruCache".equals(a) && C0108a.f262e.equals(a2) && Integer.toString(this.f3734g).equals(a3) && Integer.toString(this.f3736i).equals(a4) && bi_常量类.f6358b_空串.equals(a5)) {
                i = 0;
                while (true) {
                    m4743d(apVar.m4763a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f3740m = i - this.f3739l.size();
            aq.m4764a(apVar);
        } catch (Throwable th) {
            aq.m4764a(apVar);
        }
    }

    /* renamed from: d */
    private void m4743d(String str) throws IOException {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f3739l.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C0606c c0606c = (C0606c) this.f3739l.get(str2);
        if (c0606c == null) {
            c0606c = new C0606c(str2);
            this.f3739l.put(str2, c0606c);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c0606c.f3724d = true;
            c0606c.f3725e = null;
            c0606c.m4721a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c0606c.f3725e = new C0604a(c0606c);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: f */
    private void m4748f() throws IOException {
        m4737a(this.f3732e);
        Iterator it = this.f3739l.values().iterator();
        while (it.hasNext()) {
            C0606c c0606c = (C0606c) it.next();
            int i;
            if (c0606c.f3725e == null) {
                for (i = 0; i < this.f3736i; i++) {
                    this.f3737j += c0606c.f3723c[i];
                }
            } else {
                c0606c.f3725e = null;
                for (i = 0; i < this.f3736i; i++) {
                    m4737a(c0606c.m4728a(i));
                    m4737a(c0606c.m4730b(i));
                }
                it.remove();
            }
        }
    }

    /* renamed from: g */
    private synchronized void m4749g() throws IOException {
        if (this.f3738k != null) {
            this.f3738k.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3732e), aq.f3751a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(C0108a.f262e);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f3734g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f3736i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C0606c c0606c : this.f3739l.values()) {
                if (c0606c.f3725e != null) {
                    bufferedWriter.write("DIRTY " + c0606c.f3722b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c0606c.f3722b + c0606c.m4729a() + '\n');
                }
            }
            if (this.f3731d.exists()) {
                m4738a(this.f3731d, this.f3733f, true);
            }
            m4738a(this.f3732e, this.f3731d, false);
            this.f3733f.delete();
            this.f3738k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3731d, true), aq.f3751a));
        } finally {
            bufferedWriter.close();
        }
    }

    /* renamed from: a */
    private static void m4737a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m4738a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m4737a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public synchronized C0605b m4753a(String str) throws IOException {
        C0605b c0605b;
        m4751i();
        m4746e(str);
        C0606c c0606c = (C0606c) this.f3739l.get(str);
        if (c0606c == null) {
            c0605b = null;
        } else if (c0606c.f3724d) {
            r6 = new InputStream[this.f3736i];
            int i = 0;
            while (i < this.f3736i) {
                try {
                    r6[i] = new FileInputStream(c0606c.m4728a(i));
                    i++;
                } catch (FileNotFoundException e) {
                    i = 0;
                    while (i < this.f3736i && r6[i] != null) {
                        InputStream[] inputStreamArr;
                        aq.m4764a(inputStreamArr[i]);
                        i++;
                    }
                    c0605b = null;
                }
            }
            this.f3740m++;
            this.f3738k.append("READ " + str + '\n');
            if (m4750h()) {
                this.f3729b.submit(this.f3743p);
            }
            c0605b = new C0605b(str, c0606c.f3726f, inputStreamArr, c0606c.f3723c);
        } else {
            c0605b = null;
        }
        return c0605b;
    }

    /* renamed from: b */
    public C0604a m4756b(String str) throws IOException {
        return m4732a(str, -1);
    }

    /* renamed from: a */
    private synchronized C0604a m4732a(String str, long j) throws IOException {
        C0604a c0604a;
        m4751i();
        m4746e(str);
        C0606c c0606c = (C0606c) this.f3739l.get(str);
        if (j == -1 || (c0606c != null && c0606c.f3726f == j)) {
            C0606c c0606c2;
            if (c0606c == null) {
                c0606c = new C0606c(str);
                this.f3739l.put(str, c0606c);
                c0606c2 = c0606c;
            } else if (c0606c.f3725e != null) {
                c0604a = null;
            } else {
                c0606c2 = c0606c;
            }
            c0604a = new C0604a(c0606c2);
            c0606c2.f3725e = c0604a;
            this.f3738k.write("DIRTY " + str + '\n');
            this.f3738k.flush();
        } else {
            c0604a = null;
        }
        return c0604a;
    }

    /* renamed from: a */
    private synchronized void m4735a(C0604a c0604a, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            C0606c a = c0604a.f3712b;
            if (a.f3725e != c0604a) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f3724d) {
                    int i2 = 0;
                    while (i2 < this.f3736i) {
                        if (!c0604a.f3713c[i2]) {
                            c0604a.m4716b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.m4730b(i2).exists()) {
                            c0604a.m4716b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f3736i) {
                File b = a.m4730b(i);
                if (!z) {
                    m4737a(b);
                } else if (b.exists()) {
                    File a2 = a.m4728a(i);
                    b.renameTo(a2);
                    long j = a.f3723c[i];
                    long length = a2.length();
                    a.f3723c[i] = length;
                    this.f3737j = (this.f3737j - j) + length;
                }
                i++;
            }
            this.f3740m++;
            a.f3725e = null;
            if ((a.f3724d | z) != 0) {
                a.f3724d = true;
                this.f3738k.write("CLEAN " + a.f3722b + a.m4729a() + '\n');
                if (z) {
                    long j2 = this.f3742o;
                    this.f3742o = 1 + j2;
                    a.f3726f = j2;
                }
            } else {
                this.f3739l.remove(a.f3722b);
                this.f3738k.write("REMOVE " + a.f3722b + '\n');
            }
            this.f3738k.flush();
            if (this.f3737j > this.f3735h || m4750h()) {
                this.f3729b.submit(this.f3743p);
            }
        }
    }

    /* renamed from: h */
    private boolean m4750h() {
        return this.f3740m >= 2000 && this.f3740m >= this.f3739l.size();
    }

    /* renamed from: c */
    public synchronized boolean m4759c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            m4751i();
            m4746e(str);
            C0606c c0606c = (C0606c) this.f3739l.get(str);
            if (c0606c == null || c0606c.f3725e != null) {
                z = false;
            } else {
                while (i < this.f3736i) {
                    File a = c0606c.m4728a(i);
                    if (!a.exists() || a.delete()) {
                        this.f3737j -= c0606c.f3723c[i];
                        c0606c.f3723c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f3740m++;
                this.f3738k.append("REMOVE " + str + '\n');
                this.f3739l.remove(str);
                if (m4750h()) {
                    this.f3729b.submit(this.f3743p);
                }
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m4755a() {
        return this.f3738k == null;
    }

    /* renamed from: i */
    private void m4751i() {
        if (this.f3738k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: b */
    public synchronized void m4757b() throws IOException {
        m4751i();
        m4752j();
        this.f3738k.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f3738k != null) {
            Iterator it = new ArrayList(this.f3739l.values()).iterator();
            while (it.hasNext()) {
                C0606c c0606c = (C0606c) it.next();
                if (c0606c.f3725e != null) {
                    c0606c.f3725e.m4716b();
                }
            }
            m4752j();
            this.f3738k.close();
            this.f3738k = null;
        }
    }

    /* renamed from: j */
    private void m4752j() throws IOException {
        while (this.f3737j > this.f3735h) {
            String str = (String) ((Entry) this.f3739l.entrySet().iterator().next()).getKey();
            m4759c(str);
            if (this.f3741n != null) {
                this.f3741n.mo741a(str);
            }
        }
    }

    /* renamed from: c */
    public void m4758c() throws IOException {
        close();
        aq.m4765a(this.f3730c);
    }

    /* renamed from: e */
    private void m4746e(String str) {
        if (!f3727a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
