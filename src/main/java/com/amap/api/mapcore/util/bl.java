package com.amap.api.mapcore.util;

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
public final class bl implements Closeable {
    /* renamed from: a */
    static final Pattern f2058a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* renamed from: q */
    private static final OutputStream f2059q = new bn();
    /* renamed from: b */
    final ThreadPoolExecutor f2060b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: c */
    private final File f2061c;
    /* renamed from: d */
    private final File f2062d;
    /* renamed from: e */
    private final File f2063e;
    /* renamed from: f */
    private final File f2064f;
    /* renamed from: g */
    private final int f2065g;
    /* renamed from: h */
    private long f2066h;
    /* renamed from: i */
    private final int f2067i;
    /* renamed from: j */
    private long f2068j = 0;
    /* renamed from: k */
    private Writer f2069k;
    /* renamed from: l */
    private final LinkedHashMap<String, C0370c> f2070l = new LinkedHashMap(0, 0.75f, true);
    /* renamed from: m */
    private int f2071m;
    /* renamed from: n */
    private bo f2072n;
    /* renamed from: o */
    private long f2073o = 0;
    /* renamed from: p */
    private final Callable<Void> f2074p = new bm(this);

    /* compiled from: DiskLruCache */
    /* renamed from: com.amap.api.mapcore.util.bl$a */
    public final class C0368a {
        /* renamed from: a */
        final /* synthetic */ bl f2042a;
        /* renamed from: b */
        private final C0370c f2043b;
        /* renamed from: c */
        private final boolean[] f2044c;
        /* renamed from: d */
        private boolean f2045d;
        /* renamed from: e */
        private boolean f2046e;

        /* compiled from: DiskLruCache */
        /* renamed from: com.amap.api.mapcore.util.bl$a$a */
        private class C0367a extends FilterOutputStream {
            /* renamed from: a */
            final /* synthetic */ C0368a f2041a;

            private C0367a(C0368a c0368a, OutputStream outputStream) {
                this.f2041a = c0368a;
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    this.f2041a.f2045d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    this.f2041a.f2045d = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    this.f2041a.f2045d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    this.f2041a.f2045d = true;
                }
            }
        }

        private C0368a(bl blVar, C0370c c0370c) {
            this.f2042a = blVar;
            this.f2043b = c0370c;
            this.f2044c = c0370c.f2055d ? null : new boolean[blVar.f2067i];
        }

        /* renamed from: a */
        public OutputStream m3229a(int i) throws IOException {
            if (i < 0 || i >= this.f2042a.f2067i) {
                throw new IllegalArgumentException("Expected index " + i + " to " + "be greater than 0 and less than the maximum value count " + "of " + this.f2042a.f2067i);
            }
            OutputStream d;
            synchronized (this.f2042a) {
                File b;
                OutputStream fileOutputStream;
                if (this.f2043b.f2056e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f2043b.f2055d) {
                    this.f2044c[i] = true;
                }
                b = this.f2043b.m3246b(i);
                try {
                    fileOutputStream = new FileOutputStream(b);
                } catch (FileNotFoundException e) {
                    this.f2042a.f2061c.mkdirs();
                    try {
                        fileOutputStream = new FileOutputStream(b);
                    } catch (FileNotFoundException e2) {
                        d = bl.f2059q;
                    }
                }
                d = new C0367a(fileOutputStream);
            }
            return d;
        }

        /* renamed from: a */
        public void m3230a() throws IOException {
            if (this.f2045d) {
                this.f2042a.m3251a(this, false);
                this.f2042a.m3275c(this.f2043b.f2053b);
            } else {
                this.f2042a.m3251a(this, true);
            }
            this.f2046e = true;
        }

        /* renamed from: b */
        public void m3231b() throws IOException {
            this.f2042a.m3251a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.amap.api.mapcore.util.bl$b */
    public final class C0369b implements Closeable {
        /* renamed from: a */
        final /* synthetic */ bl f2047a;
        /* renamed from: b */
        private final String f2048b;
        /* renamed from: c */
        private final long f2049c;
        /* renamed from: d */
        private final InputStream[] f2050d;
        /* renamed from: e */
        private final long[] f2051e;

        private C0369b(bl blVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f2047a = blVar;
            this.f2048b = str;
            this.f2049c = j;
            this.f2050d = inputStreamArr;
            this.f2051e = jArr;
        }

        /* renamed from: a */
        public InputStream m3232a(int i) {
            return this.f2050d[i];
        }

        public void close() {
            for (Closeable a : this.f2050d) {
                bq.m3280a(a);
            }
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.amap.api.mapcore.util.bl$c */
    private final class C0370c {
        /* renamed from: a */
        final /* synthetic */ bl f2052a;
        /* renamed from: b */
        private final String f2053b;
        /* renamed from: c */
        private final long[] f2054c;
        /* renamed from: d */
        private boolean f2055d;
        /* renamed from: e */
        private C0368a f2056e;
        /* renamed from: f */
        private long f2057f;

        private C0370c(bl blVar, String str) {
            this.f2052a = blVar;
            this.f2053b = str;
            this.f2054c = new long[blVar.f2067i];
        }

        /* renamed from: a */
        public String m3245a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f2054c) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        /* renamed from: a */
        private void m3237a(String[] strArr) throws IOException {
            if (strArr.length != this.f2052a.f2067i) {
                throw m3239b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f2054c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m3239b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m3239b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m3244a(int i) {
            return new File(this.f2052a.f2061c, this.f2053b + "." + i);
        }

        /* renamed from: b */
        public File m3246b(int i) {
            return new File(this.f2052a.f2061c, this.f2053b + "." + i + ".tmp");
        }
    }

    /* renamed from: a */
    public void m3270a(bo boVar) {
        this.f2072n = boVar;
    }

    private bl(File file, int i, int i2, long j) {
        this.f2061c = file;
        this.f2065g = i;
        this.f2062d = new File(file, "journal");
        this.f2063e = new File(file, "journal.tmp");
        this.f2064f = new File(file, "journal.bkp");
        this.f2067i = i2;
        this.f2066h = j;
    }

    /* renamed from: a */
    public static bl m3249a(File file, int i, int i2, long j) throws IOException {
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
                    m3254a(file2, file3, false);
                }
            }
            bl blVar = new bl(file, i, i2, j);
            if (blVar.f2062d.exists()) {
                try {
                    blVar.m3261e();
                    blVar.m3264f();
                    blVar.f2069k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(blVar.f2062d, true), bq.f2082a));
                    return blVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    blVar.m3274c();
                }
            }
            file.mkdirs();
            blVar = new bl(file, i, i2, j);
            blVar.m3265g();
            return blVar;
        }
    }

    /* renamed from: e */
    private void m3261e() throws IOException {
        Closeable bpVar = new bp(new FileInputStream(this.f2062d), bq.f2082a);
        int i;
        try {
            String a = bpVar.m3279a();
            String a2 = bpVar.m3279a();
            String a3 = bpVar.m3279a();
            String a4 = bpVar.m3279a();
            String a5 = bpVar.m3279a();
            if ("libcore.io.DiskLruCache".equals(a) && C0108a.f262e.equals(a2) && Integer.toString(this.f2065g).equals(a3) && Integer.toString(this.f2067i).equals(a4) && bi_常量类.f6358b.equals(a5)) {
                i = 0;
                while (true) {
                    m3259d(bpVar.m3279a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f2071m = i - this.f2070l.size();
            bq.m3280a(bpVar);
        } catch (Throwable th) {
            bq.m3280a(bpVar);
        }
    }

    /* renamed from: d */
    private void m3259d(String str) throws IOException {
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
                this.f2070l.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C0370c c0370c = (C0370c) this.f2070l.get(str2);
        if (c0370c == null) {
            c0370c = new C0370c(str2);
            this.f2070l.put(str2, c0370c);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c0370c.f2055d = true;
            c0370c.f2056e = null;
            c0370c.m3237a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c0370c.f2056e = new C0368a(c0370c);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: f */
    private void m3264f() throws IOException {
        m3253a(this.f2063e);
        Iterator it = this.f2070l.values().iterator();
        while (it.hasNext()) {
            C0370c c0370c = (C0370c) it.next();
            int i;
            if (c0370c.f2056e == null) {
                for (i = 0; i < this.f2067i; i++) {
                    this.f2068j += c0370c.f2054c[i];
                }
            } else {
                c0370c.f2056e = null;
                for (i = 0; i < this.f2067i; i++) {
                    m3253a(c0370c.m3244a(i));
                    m3253a(c0370c.m3246b(i));
                }
                it.remove();
            }
        }
    }

    /* renamed from: g */
    private synchronized void m3265g() throws IOException {
        if (this.f2069k != null) {
            this.f2069k.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2063e), bq.f2082a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(C0108a.f262e);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2065g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2067i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C0370c c0370c : this.f2070l.values()) {
                if (c0370c.f2056e != null) {
                    bufferedWriter.write("DIRTY " + c0370c.f2053b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c0370c.f2053b + c0370c.m3245a() + '\n');
                }
            }
            if (this.f2062d.exists()) {
                m3254a(this.f2062d, this.f2064f, true);
            }
            m3254a(this.f2063e, this.f2062d, false);
            this.f2064f.delete();
            this.f2069k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2062d, true), bq.f2082a));
        } finally {
            bufferedWriter.close();
        }
    }

    /* renamed from: a */
    private static void m3253a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m3254a(File file, File file2, boolean z) throws IOException {
        if (z) {
            m3253a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public synchronized C0369b m3269a(String str) throws IOException {
        C0369b c0369b;
        int i;
        m3267i();
        m3262e(str);
        C0370c c0370c = (C0370c) this.f2070l.get(str);
        if (c0370c == null) {
            c0369b = null;
        } else if (c0370c.f2055d) {
            r6 = new InputStream[this.f2067i];
            i = 0;
            while (i < this.f2067i) {
                try {
                    r6[i] = new FileInputStream(c0370c.m3244a(i));
                    i++;
                } catch (FileNotFoundException e) {
                    i = 0;
                    while (i < this.f2067i && r6[i] != null) {
                        InputStream[] inputStreamArr;
                        bq.m3280a(inputStreamArr[i]);
                        i++;
                    }
                    c0369b = null;
                }
            }
            this.f2071m++;
            this.f2069k.append("READ " + str + '\n');
            if (m3266h()) {
                this.f2060b.submit(this.f2074p);
            }
            c0369b = new C0369b(str, c0370c.f2057f, inputStreamArr, c0370c.f2054c);
        } else {
            c0369b = null;
        }
        return c0369b;
    }

    /* renamed from: b */
    public C0368a m3272b(String str) throws IOException {
        return m3248a(str, -1);
    }

    /* renamed from: a */
    private synchronized C0368a m3248a(String str, long j) throws IOException {
        C0368a c0368a;
        m3267i();
        m3262e(str);
        C0370c c0370c = (C0370c) this.f2070l.get(str);
        if (j == -1 || (c0370c != null && c0370c.f2057f == j)) {
            C0370c c0370c2;
            if (c0370c == null) {
                c0370c = new C0370c(str);
                this.f2070l.put(str, c0370c);
                c0370c2 = c0370c;
            } else if (c0370c.f2056e != null) {
                c0368a = null;
            } else {
                c0370c2 = c0370c;
            }
            c0368a = new C0368a(c0370c2);
            c0370c2.f2056e = c0368a;
            this.f2069k.write("DIRTY " + str + '\n');
            this.f2069k.flush();
        } else {
            c0368a = null;
        }
        return c0368a;
    }

    /* renamed from: a */
    private synchronized void m3251a(C0368a c0368a, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            C0370c a = c0368a.f2043b;
            if (a.f2056e != c0368a) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f2055d) {
                    int i2 = 0;
                    while (i2 < this.f2067i) {
                        if (!c0368a.f2044c[i2]) {
                            c0368a.m3231b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.m3246b(i2).exists()) {
                            c0368a.m3231b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f2067i) {
                File b = a.m3246b(i);
                if (!z) {
                    m3253a(b);
                } else if (b.exists()) {
                    File a2 = a.m3244a(i);
                    b.renameTo(a2);
                    long j = a.f2054c[i];
                    long length = a2.length();
                    a.f2054c[i] = length;
                    this.f2068j = (this.f2068j - j) + length;
                }
                i++;
            }
            this.f2071m++;
            a.f2056e = null;
            if ((a.f2055d | z) != 0) {
                a.f2055d = true;
                this.f2069k.write("CLEAN " + a.f2053b + a.m3245a() + '\n');
                if (z) {
                    long j2 = this.f2073o;
                    this.f2073o = 1 + j2;
                    a.f2057f = j2;
                }
            } else {
                this.f2070l.remove(a.f2053b);
                this.f2069k.write("REMOVE " + a.f2053b + '\n');
            }
            this.f2069k.flush();
            if (this.f2068j > this.f2066h || m3266h()) {
                this.f2060b.submit(this.f2074p);
            }
        }
    }

    /* renamed from: h */
    private boolean m3266h() {
        return this.f2071m >= 2000 && this.f2071m >= this.f2070l.size();
    }

    /* renamed from: c */
    public synchronized boolean m3275c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            m3267i();
            m3262e(str);
            C0370c c0370c = (C0370c) this.f2070l.get(str);
            if (c0370c == null || c0370c.f2056e != null) {
                z = false;
            } else {
                while (i < this.f2067i) {
                    File a = c0370c.m3244a(i);
                    if (!a.exists() || a.delete()) {
                        this.f2068j -= c0370c.f2054c[i];
                        c0370c.f2054c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f2071m++;
                this.f2069k.append("REMOVE " + str + '\n');
                this.f2070l.remove(str);
                if (m3266h()) {
                    this.f2060b.submit(this.f2074p);
                }
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean m3271a() {
        return this.f2069k == null;
    }

    /* renamed from: i */
    private void m3267i() {
        if (this.f2069k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: b */
    public synchronized void m3273b() throws IOException {
        m3267i();
        m3268j();
        this.f2069k.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f2069k != null) {
            Iterator it = new ArrayList(this.f2070l.values()).iterator();
            while (it.hasNext()) {
                C0370c c0370c = (C0370c) it.next();
                if (c0370c.f2056e != null) {
                    c0370c.f2056e.m3231b();
                }
            }
            m3268j();
            this.f2069k.close();
            this.f2069k = null;
        }
    }

    /* renamed from: j */
    private void m3268j() throws IOException {
        while (this.f2068j > this.f2066h) {
            String str = (String) ((Entry) this.f2070l.entrySet().iterator().next()).getKey();
            m3275c(str);
            if (this.f2072n != null) {
                this.f2072n.mo599a(str);
            }
        }
    }

    /* renamed from: c */
    public void m3274c() throws IOException {
        close();
        bq.m3281a(this.f2061c);
    }

    /* renamed from: e */
    private void m3262e(String str) {
        if (!f2058a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
