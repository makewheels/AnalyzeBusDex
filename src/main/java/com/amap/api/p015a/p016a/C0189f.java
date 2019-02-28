package com.amap.api.p015a.p016a;

import com.alipay.sdk.cons.C0108a;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p054u.aly.bi_常量类;

/* compiled from: DiskLruCache */
/* renamed from: com.amap.api.a.a.f */
public final class C0189f implements Closeable {
    /* renamed from: a */
    private static final Charset f547a = Charset.forName("UTF-8");
    /* renamed from: b */
    private final File f548b;
    /* renamed from: c */
    private final File f549c;
    /* renamed from: d */
    private final File f550d;
    /* renamed from: e */
    private final int f551e;
    /* renamed from: f */
    private final long f552f;
    /* renamed from: g */
    private final int f553g;
    /* renamed from: h */
    private long f554h = 0;
    /* renamed from: i */
    private Writer f555i;
    /* renamed from: j */
    private final LinkedHashMap<String, C0187b> f556j = new LinkedHashMap(0, 0.75f, true);
    /* renamed from: k */
    private int f557k;
    /* renamed from: l */
    private long f558l = 0;
    /* renamed from: m */
    private final ExecutorService f559m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    /* renamed from: n */
    private final Callable<Void> f560n = new C0190g(this);

    /* compiled from: DiskLruCache */
    /* renamed from: com.amap.api.a.a.f$a */
    public final class C0186a {
        /* renamed from: a */
        final /* synthetic */ C0189f f534a;
        /* renamed from: b */
        private final C0187b f535b;
        /* renamed from: c */
        private boolean f536c;

        /* compiled from: DiskLruCache */
        /* renamed from: com.amap.api.a.a.f$a$a */
        private class C0185a extends FilterOutputStream {
            /* renamed from: a */
            final /* synthetic */ C0186a f533a;

            private C0185a(C0186a c0186a, OutputStream outputStream) {
                this.f533a = c0186a;
                super(outputStream);
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException e) {
                    this.f533a.f536c = true;
                }
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException e) {
                    this.f533a.f536c = true;
                }
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException e) {
                    this.f533a.f536c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException e) {
                    this.f533a.f536c = true;
                }
            }
        }

        private C0186a(C0189f c0189f, C0187b c0187b) {
            this.f534a = c0189f;
            this.f535b = c0187b;
        }

        /* renamed from: a */
        public OutputStream m661a(int i) throws IOException {
            OutputStream c0185a;
            synchronized (this.f534a) {
                if (this.f535b.f541e != this) {
                    throw new IllegalStateException();
                }
                c0185a = new C0185a(new FileOutputStream(this.f535b.m677b(i)));
            }
            return c0185a;
        }

        /* renamed from: a */
        public void m662a() throws IOException {
            if (this.f536c) {
                this.f534a.m684a(this, false);
                this.f534a.m708c(this.f535b.f538b);
                return;
            }
            this.f534a.m684a(this, true);
        }

        /* renamed from: b */
        public void m663b() throws IOException {
            this.f534a.m684a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.amap.api.a.a.f$b */
    private final class C0187b {
        /* renamed from: a */
        final /* synthetic */ C0189f f537a;
        /* renamed from: b */
        private final String f538b;
        /* renamed from: c */
        private final long[] f539c;
        /* renamed from: d */
        private boolean f540d;
        /* renamed from: e */
        private C0186a f541e;
        /* renamed from: f */
        private long f542f;

        private C0187b(C0189f c0189f, String str) {
            this.f537a = c0189f;
            this.f538b = str;
            this.f539c = new long[c0189f.f553g];
        }

        /* renamed from: a */
        public String m676a() throws IOException {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f539c) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        /* renamed from: a */
        private void m668a(String[] strArr) throws IOException {
            if (strArr.length != this.f537a.f553g) {
                throw m670b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f539c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m670b(strArr);
                }
            }
        }

        /* renamed from: b */
        private IOException m670b(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* renamed from: a */
        public File m675a(int i) {
            return new File(this.f537a.f548b, this.f538b + "." + i);
        }

        /* renamed from: b */
        public File m677b(int i) {
            return new File(this.f537a.f548b, this.f538b + "." + i + ".tmp");
        }
    }

    /* compiled from: DiskLruCache */
    /* renamed from: com.amap.api.a.a.f$c */
    public final class C0188c implements Closeable {
        /* renamed from: a */
        final /* synthetic */ C0189f f543a;
        /* renamed from: b */
        private final String f544b;
        /* renamed from: c */
        private final long f545c;
        /* renamed from: d */
        private final InputStream[] f546d;

        private C0188c(C0189f c0189f, String str, long j, InputStream[] inputStreamArr) {
            this.f543a = c0189f;
            this.f544b = str;
            this.f545c = j;
            this.f546d = inputStreamArr;
        }

        /* renamed from: a */
        public InputStream m678a(int i) {
            return this.f546d[i];
        }

        public void close() {
            for (Closeable a : this.f546d) {
                C0189f.m686a(a);
            }
        }
    }

    /* renamed from: a */
    private static <T> T[] m688a(T[] tArr, int i, int i2) {
        int length = tArr.length;
        if (i > i2) {
            throw new IllegalArgumentException();
        } else if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int i3 = i2 - i;
            int min = Math.min(i3, length - i);
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3);
            System.arraycopy(tArr, i, objArr, 0, min);
            return objArr;
        }
    }

    /* renamed from: a */
    public static String m683a(InputStream inputStream) throws IOException {
        int read;
        StringBuilder stringBuilder = new StringBuilder(80);
        while (true) {
            read = inputStream.read();
            if (read == -1) {
                throw new EOFException();
            } else if (read == 10) {
                break;
            } else {
                stringBuilder.append((char) read);
            }
        }
        read = stringBuilder.length();
        if (read > 0 && stringBuilder.charAt(read - 1) == '\r') {
            stringBuilder.setLength(read - 1);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static void m686a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    public static void m687a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IllegalArgumentException("not a directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                C0189f.m687a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
        file.delete();
    }

    private C0189f(File file, int i, int i2, long j) {
        this.f548b = file;
        this.f551e = i;
        this.f549c = new File(file, "journal");
        this.f550d = new File(file, "journal.tmp");
        this.f553g = i2;
        this.f552f = j;
    }

    /* renamed from: a */
    public static C0189f m681a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            return null;
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        C0189f c0189f = new C0189f(file, i, i2, j);
        if (c0189f.f549c.exists()) {
            try {
                c0189f.m692d();
                c0189f.m696e();
                c0189f.f555i = new BufferedWriter(new FileWriter(c0189f.f549c, true), 8192);
                return c0189f;
            } catch (IOException e) {
                c0189f.m707c();
            }
        }
        file.mkdirs();
        c0189f = new C0189f(file, i, i2, j);
        c0189f.m699f();
        return c0189f;
    }

    /* renamed from: d */
    private void m692d() throws IOException {
        Closeable bufferedInputStream = new BufferedInputStream(new FileInputStream(this.f549c), 8192);
        try {
            String a = C0189f.m683a((InputStream) bufferedInputStream);
            String a2 = C0189f.m683a((InputStream) bufferedInputStream);
            String a3 = C0189f.m683a((InputStream) bufferedInputStream);
            String a4 = C0189f.m683a((InputStream) bufferedInputStream);
            String a5 = C0189f.m683a((InputStream) bufferedInputStream);
            if ("libcore.io.DiskLruCache".equals(a) && C0108a.f262e.equals(a2) && Integer.toString(this.f551e).equals(a3) && Integer.toString(this.f553g).equals(a4) && bi_常量类.f6358b.equals(a5)) {
                while (true) {
                    try {
                        m694d(C0189f.m683a((InputStream) bufferedInputStream));
                    } catch (EOFException e) {
                        C0189f.m686a(bufferedInputStream);
                        return;
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
        } catch (Throwable th) {
            C0189f.m686a(bufferedInputStream);
        }
    }

    /* renamed from: d */
    private void m694d(String str) throws IOException {
        Object[] split = str.split(" ");
        if (split.length < 2) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2 = split[1];
        if (split[0].equals("REMOVE") && split.length == 2) {
            this.f556j.remove(str2);
            return;
        }
        C0187b c0187b;
        C0187b c0187b2 = (C0187b) this.f556j.get(str2);
        if (c0187b2 == null) {
            c0187b2 = new C0187b(str2);
            this.f556j.put(str2, c0187b2);
            c0187b = c0187b2;
        } else {
            c0187b = c0187b2;
        }
        if (split[0].equals("CLEAN") && split.length == this.f553g + 2) {
            c0187b.f540d = true;
            c0187b.f541e = null;
            c0187b.m668a((String[]) C0189f.m688a(split, 2, split.length));
        } else if (split[0].equals("DIRTY") && split.length == 2) {
            c0187b.f541e = new C0186a(c0187b);
        } else if (!split[0].equals("READ") || split.length != 2) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: e */
    private void m696e() throws IOException {
        C0189f.m690b(this.f550d);
        Iterator it = this.f556j.values().iterator();
        while (it.hasNext()) {
            C0187b c0187b = (C0187b) it.next();
            int i;
            if (c0187b.f541e == null) {
                for (i = 0; i < this.f553g; i++) {
                    this.f554h += c0187b.f539c[i];
                }
            } else {
                c0187b.f541e = null;
                for (i = 0; i < this.f553g; i++) {
                    C0189f.m690b(c0187b.m675a(i));
                    C0189f.m690b(c0187b.m677b(i));
                }
                it.remove();
            }
        }
    }

    /* renamed from: f */
    private synchronized void m699f() throws IOException {
        if (this.f555i != null) {
            this.f555i.close();
        }
        Writer bufferedWriter = new BufferedWriter(new FileWriter(this.f550d), 8192);
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write(C0108a.f262e);
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f551e));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.f553g));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (C0187b c0187b : this.f556j.values()) {
            if (c0187b.f541e != null) {
                bufferedWriter.write("DIRTY " + c0187b.f538b + '\n');
            } else {
                bufferedWriter.write("CLEAN " + c0187b.f538b + c0187b.m676a() + '\n');
            }
        }
        bufferedWriter.close();
        this.f550d.renameTo(this.f549c);
        this.f555i = new BufferedWriter(new FileWriter(this.f549c, true), 8192);
    }

    /* renamed from: b */
    private static void m690b(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    /* renamed from: a */
    public synchronized C0188c m703a(String str) throws IOException {
        C0188c c0188c;
        m701h();
        m697e(str);
        C0187b c0187b = (C0187b) this.f556j.get(str);
        if (c0187b == null) {
            c0188c = null;
        } else if (c0187b.f540d) {
            InputStream[] inputStreamArr = new InputStream[this.f553g];
            int i = 0;
            while (i < this.f553g) {
                try {
                    inputStreamArr[i] = new FileInputStream(c0187b.m675a(i));
                    i++;
                } catch (FileNotFoundException e) {
                    c0188c = null;
                }
            }
            this.f557k++;
            this.f555i.append("READ " + str + '\n');
            if (m700g()) {
                this.f559m.submit(this.f560n);
            }
            c0188c = new C0188c(str, c0187b.f542f, inputStreamArr);
        } else {
            c0188c = null;
        }
        return c0188c;
    }

    /* renamed from: b */
    public C0186a m705b(String str) throws IOException {
        return m680a(str, -1);
    }

    /* renamed from: a */
    private synchronized C0186a m680a(String str, long j) throws IOException {
        C0186a c0186a;
        m701h();
        m697e(str);
        C0187b c0187b = (C0187b) this.f556j.get(str);
        if (j == -1 || (c0187b != null && c0187b.f542f == j)) {
            C0187b c0187b2;
            if (c0187b == null) {
                c0187b = new C0187b(str);
                this.f556j.put(str, c0187b);
                c0187b2 = c0187b;
            } else if (c0187b.f541e != null) {
                c0186a = null;
            } else {
                c0187b2 = c0187b;
            }
            c0186a = new C0186a(c0187b2);
            c0187b2.f541e = c0186a;
            this.f555i.write("DIRTY " + str + '\n');
            this.f555i.flush();
        } else {
            c0186a = null;
        }
        return c0186a;
    }

    /* renamed from: a */
    private synchronized void m684a(C0186a c0186a, boolean z) throws IOException {
        int i = 0;
        synchronized (this) {
            C0187b a = c0186a.f535b;
            if (a.f541e != c0186a) {
                throw new IllegalStateException();
            }
            if (z) {
                if (!a.f540d) {
                    int i2 = 0;
                    while (i2 < this.f553g) {
                        if (a.m677b(i2).exists()) {
                            i2++;
                        } else {
                            c0186a.m663b();
                            throw new IllegalStateException("edit didn't create file " + i2);
                        }
                    }
                }
            }
            while (i < this.f553g) {
                File b = a.m677b(i);
                if (!z) {
                    C0189f.m690b(b);
                } else if (b.exists()) {
                    File a2 = a.m675a(i);
                    b.renameTo(a2);
                    long j = a.f539c[i];
                    long length = a2.length();
                    a.f539c[i] = length;
                    this.f554h = (this.f554h - j) + length;
                }
                i++;
            }
            this.f557k++;
            a.f541e = null;
            if ((a.f540d | z) != 0) {
                a.f540d = true;
                this.f555i.write("CLEAN " + a.f538b + a.m676a() + '\n');
                if (z) {
                    long j2 = this.f558l;
                    this.f558l = 1 + j2;
                    a.f542f = j2;
                }
            } else {
                this.f556j.remove(a.f538b);
                this.f555i.write("REMOVE " + a.f538b + '\n');
            }
            if (this.f554h > this.f552f || m700g()) {
                this.f559m.submit(this.f560n);
            }
        }
    }

    /* renamed from: g */
    private boolean m700g() {
        return this.f557k >= 2000 && this.f557k >= this.f556j.size();
    }

    /* renamed from: c */
    public synchronized boolean m708c(String str) throws IOException {
        boolean z;
        int i = 0;
        synchronized (this) {
            m701h();
            m697e(str);
            C0187b c0187b = (C0187b) this.f556j.get(str);
            if (c0187b == null || c0187b.f541e != null) {
                z = false;
            } else {
                while (i < this.f553g) {
                    File a = c0187b.m675a(i);
                    if (a.delete()) {
                        this.f554h -= c0187b.f539c[i];
                        c0187b.f539c[i] = 0;
                        i++;
                    } else {
                        throw new IOException("failed to delete " + a);
                    }
                }
                this.f557k++;
                this.f555i.append("REMOVE " + str + '\n');
                this.f556j.remove(str);
                if (m700g()) {
                    this.f559m.submit(this.f560n);
                }
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean m704a() {
        return this.f555i == null;
    }

    /* renamed from: h */
    private void m701h() {
        if (this.f555i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* renamed from: b */
    public synchronized void m706b() throws IOException {
        m701h();
        m702i();
        this.f555i.flush();
    }

    public synchronized void close() throws IOException {
        if (this.f555i != null) {
            Iterator it = new ArrayList(this.f556j.values()).iterator();
            while (it.hasNext()) {
                C0187b c0187b = (C0187b) it.next();
                if (c0187b.f541e != null) {
                    c0187b.f541e.m663b();
                }
            }
            m702i();
            this.f555i.close();
            this.f555i = null;
        }
    }

    /* renamed from: i */
    private void m702i() throws IOException {
        while (this.f554h > this.f552f) {
            m708c((String) ((Entry) this.f556j.entrySet().iterator().next()).getKey());
        }
    }

    /* renamed from: c */
    public void m707c() throws IOException {
        close();
        C0189f.m687a(this.f548b);
    }

    /* renamed from: e */
    private void m697e(String str) {
        if (str.contains(" ") || str.contains("\n") || str.contains("\r")) {
            throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + str + "\"");
        }
    }
}
