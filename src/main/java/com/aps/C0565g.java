package com.aps;

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
/* renamed from: com.aps.g */
public final class C0565g implements Closeable {
    /* renamed from: a */
    static final Pattern f3485a = Pattern.compile("[a-z0-9_-]{1,120}");
    /* renamed from: p */
    private static final OutputStream f3486p = new C0567i();
    /* renamed from: b */
    final ThreadPoolExecutor f3487b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: c */
    private final File f3488c;
    /* renamed from: d */
    private final File f3489d;
    /* renamed from: e */
    private final File f3490e;
    /* renamed from: f */
    private final File f3491f;
    /* renamed from: g */
    private final int f3492g;
    /* renamed from: h */
    private long f3493h;
    /* renamed from: i */
    private final int f3494i;
    /* renamed from: j */
    private long f3495j = 0;
    /* renamed from: k */
    private Writer f3496k;
    /* renamed from: l */
    private final LinkedHashMap<String, C0563b> f3497l = new LinkedHashMap(0, 0.75f, true);
    /* renamed from: m */
    private int f3498m;
    /* renamed from: n */
    private long f3499n = 0;
    /* renamed from: o */
    private final Callable<Void> f3500o = new C0566h(this);

    /* compiled from: DiskLruCache */
    /* renamed from: com.aps.g$a */
    public final class C0562a {
        /* renamed from: a */
        final /* synthetic */ C0565g f3469a;
        /* renamed from: b */
        private final C0563b f3470b;
        /* renamed from: c */
        private final boolean[] f3471c;
        /* renamed from: d */
        private boolean f3472d;
        /* renamed from: e */
        private boolean f3473e;

        /* compiled from: DiskLruCache */
        /* renamed from: com.aps.g$a$a */
        private class C0561a extends FilterOutputStream {
            /* renamed from: a */
            final /* synthetic */ C0562a f3468a;

            private C0561a(C0562a c0562a, OutputStream outputStream) {
                this.f3468a = c0562a;
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    this.f3468a.f3472d = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    this.f3468a.f3472d = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    this.f3468a.f3472d = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    this.f3468a.f3472d = true;
                }
            }
        }

        private C0562a(C0565g c0565g, C0563b c0563b) {
            this.f3469a = c0565g;
            this.f3470b = c0563b;
            this.f3471c = c0563b.f3477d ? null : new boolean[c0565g.f3494i];
        }

        /* renamed from: a */
        public OutputStream m4484a(int i) throws IOException {
            if (i < 0 || i >= this.f3469a.f3494i) {
                throw new IllegalArgumentException("Expected index " + i + " to " + "be greater than 0 and less than the maximum value count " + "of " + this.f3469a.f3494i);
            }
            OutputStream b;
            synchronized (this.f3469a) {
                OutputStream fileOutputStream;
                if (this.f3470b.f3478e != this) {
                    throw new IllegalStateException();
                }
                if (!this.f3470b.f3477d) {
                    this.f3471c[i] = true;
                }
                r1 = this.f3470b.m4500b(i);
                try {
                    fileOutputStream = new FileOutputStream(r1);
                } catch (FileNotFoundException e) {
                    this.f3469a.f3488c.mkdirs();
                    try {
                        File b2;
                        fileOutputStream = new FileOutputStream(b2);
                    } catch (FileNotFoundException e2) {
                        b = C0565g.f3486p;
                    }
                }
                b = new C0561a(fileOutputStream);
            }
            return b;
        }

        /* renamed from: a */
        public void m4485a() throws IOException {
            if (this.f3472d) {
                this.f3469a.m4506a(this, false);
                this.f3469a.m4527c(this.f3470b.f3475b);
            } else {
                this.f3469a.m4506a(this, true);
            }
            this.f3473e = true;
        }

        /* renamed from: b */
        public void m4486b() throws IOException {
            this.f3469a.m4506a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.aps.g$b */
    private final class C0563b {
        /* renamed from: a */
        final /* synthetic */ C0565g f3474a;
        /* renamed from: b */
        private final String f3475b;
        /* renamed from: c */
        private final long[] f3476c;
        /* renamed from: d */
        private boolean f3477d;
        /* renamed from: e */
        private C0562a f3478e;
        /* renamed from: f */
        private long f3479f;

        private C0563b(C0565g c0565g, String str) {
            this.f3474a = c0565g;
            this.f3475b = str;
            this.f3476c = new long[c0565g.f3494i];
        }

        /* renamed from: a */
        public String m4499a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f3476c) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        /* renamed from: a */
        private void m4491a(String[] strArr) throws IOException {
            if (strArr.length != this.f3474a.f3494i) {
                throw m4493b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f3476c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m4493b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m4493b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m4498a(int i) {
            return new File(this.f3474a.f3488c, this.f3475b + "." + i);
        }

        /* renamed from: b */
        public File m4500b(int i) {
            return new File(this.f3474a.f3488c, this.f3475b + "." + i + ".tmp");
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.aps.g$c */
    public final class C0564c implements Closeable {
        /* renamed from: a */
        final /* synthetic */ C0565g f3480a;
        /* renamed from: b */
        private final String f3481b;
        /* renamed from: c */
        private final long f3482c;
        /* renamed from: d */
        private final InputStream[] f3483d;
        /* renamed from: e */
        private final long[] f3484e;

        private C0564c(C0565g c0565g, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.f3480a = c0565g;
            this.f3481b = str;
            this.f3482c = j;
            this.f3483d = inputStreamArr;
            this.f3484e = jArr;
        }

        /* renamed from: a */
        public InputStream m4501a(int i) {
            return this.f3483d[i];
        }

        public void close() {
            for (Closeable a : this.f3483d) {
                C0582s.m4567a(a);
            }
        }
    }

    private C0565g(File file, int i, int i2, long j) {
        this.f3488c = file;
        this.f3492g = i;
        this.f3489d = new File(file, "journal");
        this.f3490e = new File(file, "journal.tmp");
        this.f3491f = new File(file, "journal.bkp");
        this.f3494i = i2;
        this.f3493h = j;
    }

    /* renamed from: a */
    public static C0565g m4504a(File file, int i, int i2, long j) throws IOException {
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
                    C0565g.m4509a(file2, file3, false);
                }
            }
            C0565g c0565g = new C0565g(file, i, i2, j);
            if (c0565g.f3489d.exists()) {
                try {
                    c0565g.m4512c();
                    c0565g.m4514d();
                    c0565g.f3496k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c0565g.f3489d, true), C0582s.f3551a));
                    return c0565g;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    c0565g.m4525a();
                }
            }
            file.mkdirs();
            c0565g = new C0565g(file, i, i2, j);
            c0565g.m4518e();
            return c0565g;
        }
    }

    /* renamed from: c */
    private void m4512c() throws IOException {
        Closeable c0581r = new C0581r(new FileInputStream(this.f3489d), C0582s.f3551a);
        int i;
        try {
            String a = c0581r.m4566a();
            String a2 = c0581r.m4566a();
            String a3 = c0581r.m4566a();
            String a4 = c0581r.m4566a();
            String a5 = c0581r.m4566a();
            if ("libcore.io.DiskLruCache".equals(a) && C0108a.f262e.equals(a2) && Integer.toString(this.f3492g).equals(a3) && Integer.toString(this.f3494i).equals(a4) && bi_常量类.f6358b_空串.equals(a5)) {
                i = 0;
                while (true) {
                    m4516d(c0581r.m4566a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f3498m = i - this.f3497l.size();
            C0582s.m4567a(c0581r);
        } catch (Throwable th) {
            C0582s.m4567a(c0581r);
        }
    }

    /* renamed from: d */
    private void m4516d(String str) throws IOException {
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
                this.f3497l.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C0563b c0563b = (C0563b) this.f3497l.get(str2);
        if (c0563b == null) {
            c0563b = new C0563b(str2);
            this.f3497l.put(str2, c0563b);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c0563b.f3477d = true;
            c0563b.f3478e = null;
            c0563b.m4491a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c0563b.f3478e = new C0562a(c0563b);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: d */
    private void m4514d() throws IOException {
        C0565g.m4508a(this.f3490e);
        Iterator it = this.f3497l.values().iterator();
        while (it.hasNext()) {
            C0563b c0563b = (C0563b) it.next();
            int i;
            if (c0563b.f3478e == null) {
                for (i = 0; i < this.f3494i; i++) {
                    this.f3495j += c0563b.f3476c[i];
                }
            } else {
                c0563b.f3478e = null;
                for (i = 0; i < this.f3494i; i++) {
                    C0565g.m4508a(c0563b.m4498a(i));
                    C0565g.m4508a(c0563b.m4500b(i));
                }
                it.remove();
            }
        }
    }

    /* renamed from: e */
    private synchronized void m4518e() throws IOException {
        if (this.f3496k != null) {
            this.f3496k.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3490e), C0582s.f3551a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write(C0108a.f262e);
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f3492g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f3494i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C0563b c0563b : this.f3497l.values()) {
                if (c0563b.f3478e != null) {
                    bufferedWriter.write("DIRTY " + c0563b.f3475b + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c0563b.f3475b + c0563b.m4499a() + '\n');
                }
            }
            if (this.f3489d.exists()) {
                C0565g.m4509a(this.f3489d, this.f3491f, true);
            }
            C0565g.m4509a(this.f3490e, this.f3489d, false);
            this.f3491f.delete();
            this.f3496k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3489d, true), C0582s.f3551a));
        } finally {
            bufferedWriter.close();
        }
    }

    /* renamed from: a */
    private static void m4508a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    private static void m4509a(File file, File file2, boolean z) throws IOException {
        if (z) {
            C0565g.m4508a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public synchronized C0564c m4524a(String str) throws IOException {
        C0564c c0564c;
        m4522g();
        m4519e(str);
        C0563b c0563b = (C0563b) this.f3497l.get(str);
        if (c0563b == null) {
            c0564c = null;
        } else if (c0563b.f3477d) {
            InputStream[] inputStreamArr = new InputStream[this.f3494i];
            r1 = 0;
            while (r1 < this.f3494i) {
                try {
                    inputStreamArr[r1] = new FileInputStream(c0563b.m4498a(r1));
                    r1++;
                } catch (FileNotFoundException e) {
                    r1 = 0;
                    while (r1 < this.f3494i && inputStreamArr[r1] != null) {
                        C0582s.m4567a(inputStreamArr[r1]);
                        r1++;
                    }
                    c0564c = null;
                }
            }
            this.f3498m++;
            this.f3496k.append("READ " + str + '\n');
            if (m4521f()) {
                this.f3487b.submit(this.f3500o);
            }
            c0564c = new C0564c(str, c0563b.f3479f, inputStreamArr, c0563b.f3476c);
        } else {
            c0564c = null;
        }
        return c0564c;
    }

    /* renamed from: b */
    public C0562a m4526b(String str) throws IOException {
        return m4503a(str, -1);
    }

    /* renamed from: a */
    private synchronized C0562a m4503a(String str, long j) throws IOException {
        C0562a c0562a;
        m4522g();
        m4519e(str);
        C0563b c0563b = (C0563b) this.f3497l.get(str);
        if (j == -1 || (c0563b != null && c0563b.f3479f == j)) {
            C0563b c0563b2;
            if (c0563b == null) {
                c0563b = new C0563b(str);
                this.f3497l.put(str, c0563b);
                c0563b2 = c0563b;
            } else if (c0563b.f3478e != null) {
                c0562a = null;
            } else {
                c0563b2 = c0563b;
            }
            c0562a = new C0562a(c0563b2);
            c0563b2.f3478e = c0562a;
            this.f3496k.write("DIRTY " + str + '\n');
            this.f3496k.flush();
        } else {
            c0562a = null;
        }
        return c0562a;
    }

    /* renamed from: a */
    private synchronized void m4506a(C0562a c0562a, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            C0563b a = c0562a.f3470b;
            if (a.f3478e != c0562a) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f3477d) {
                    int i2 = 0;
                    while (i2 < this.f3494i) {
                        if (!c0562a.f3471c[i2]) {
                            c0562a.m4486b();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i2);
                        } else if (!a.m4500b(i2).exists()) {
                            c0562a.m4486b();
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
            }
            while (i < this.f3494i) {
                File b = a.m4500b(i);
                if (!z) {
                    C0565g.m4508a(b);
                } else if (b.exists()) {
                    File a2 = a.m4498a(i);
                    b.renameTo(a2);
                    long j = a.f3476c[i];
                    long length = a2.length();
                    a.f3476c[i] = length;
                    this.f3495j = (this.f3495j - j) + length;
                }
                i++;
            }
            this.f3498m++;
            a.f3478e = null;
            if ((a.f3477d | z) != 0) {
                a.f3477d = true;
                this.f3496k.write("CLEAN " + a.f3475b + a.m4499a() + '\n');
                if (z) {
                    long j2 = this.f3499n;
                    this.f3499n = 1 + j2;
                    a.f3479f = j2;
                }
            } else {
                this.f3497l.remove(a.f3475b);
                this.f3496k.write("REMOVE " + a.f3475b + '\n');
            }
            this.f3496k.flush();
            if (this.f3495j > this.f3493h || m4521f()) {
                this.f3487b.submit(this.f3500o);
            }
        }
    }

    /* renamed from: f */
    private boolean m4521f() {
        return this.f3498m >= 2000 && this.f3498m >= this.f3497l.size();
    }

    /* renamed from: c */
    public synchronized boolean m4527c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            m4522g();
            m4519e(str);
            C0563b c0563b = (C0563b) this.f3497l.get(str);
            if (c0563b == null || c0563b.f3478e != null) {
                z = false;
            } else {
                while (i < this.f3494i) {
                    File a = c0563b.m4498a(i);
                    if (!a.exists() || a.delete()) {
                        this.f3495j -= c0563b.f3476c[i];
                        c0563b.f3476c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f3498m++;
                this.f3496k.append("REMOVE " + str + '\n');
                this.f3497l.remove(str);
                if (m4521f()) {
                    this.f3487b.submit(this.f3500o);
                }
                z = true;
            }
        }
        return z;
    }

    /* renamed from: g */
    private void m4522g() {
        if (this.f3496k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void close() throws IOException {
        if (this.f3496k != null) {
            Iterator it = new ArrayList(this.f3497l.values()).iterator();
            while (it.hasNext()) {
                C0563b c0563b = (C0563b) it.next();
                if (c0563b.f3478e != null) {
                    c0563b.f3478e.m4486b();
                }
            }
            m4523h();
            this.f3496k.close();
            this.f3496k = null;
        }
    }

    /* renamed from: h */
    private void m4523h() throws IOException {
        while (this.f3495j > this.f3493h) {
            m4527c((String) ((Entry) this.f3497l.entrySet().iterator().next()).getKey());
        }
    }

    /* renamed from: a */
    public void m4525a() throws IOException {
        close();
        C0582s.m4568a(this.f3488c);
    }

    /* renamed from: e */
    private void m4519e(String str) {
        if (!f3485a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
