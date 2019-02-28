package com.amap.api.mapcore.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: LruCache */
/* renamed from: com.amap.api.mapcore.util.p */
public class C0389p<K, V> {
    /* renamed from: a */
    private final LinkedHashMap<K, V> f2140a;
    /* renamed from: b */
    private int f2141b;
    /* renamed from: c */
    private int f2142c;
    /* renamed from: d */
    private int f2143d;
    /* renamed from: e */
    private int f2144e;
    /* renamed from: f */
    private int f2145f;
    /* renamed from: g */
    private int f2146g;
    /* renamed from: h */
    private int f2147h;

    public C0389p(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2142c = i;
        this.f2140a = new LinkedHashMap(0, 0.75f, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final V m3345a(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "key == null";
        r0.<init>(r1);
        throw r0;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.f2140a;	 Catch:{ all -> 0x002a }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r4.f2146g;	 Catch:{ all -> 0x002a }
        r1 = r1 + 1;
        r4.f2146g = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r4.f2147h;	 Catch:{ all -> 0x002a }
        r0 = r0 + 1;
        r4.f2147h = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        r1 = r4.m3348b(r5);
        if (r1 != 0) goto L_0x002d;
    L_0x0028:
        r0 = 0;
        goto L_0x001a;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        monitor-enter(r4);
        r0 = r4.f2144e;	 Catch:{ all -> 0x0053 }
        r0 = r0 + 1;
        r4.f2144e = r0;	 Catch:{ all -> 0x0053 }
        r0 = r4.f2140a;	 Catch:{ all -> 0x0053 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r4.f2140a;	 Catch:{ all -> 0x0053 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0053 }
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0056;
    L_0x0044:
        r2 = 0;
        r4.mo612a(r2, r5, r1, r0);
        goto L_0x001a;
    L_0x0049:
        r2 = r4.f2141b;	 Catch:{ all -> 0x0053 }
        r3 = r4.m3343c(r5, r1);	 Catch:{ all -> 0x0053 }
        r2 = r2 + r3;
        r4.f2141b = r2;	 Catch:{ all -> 0x0053 }
        goto L_0x0041;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r0 = r4.f2142c;
        r4.m3342a(r0);
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.p.a(java.lang.Object):V");
    }

    /* renamed from: b */
    public final V m3349b(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f2143d++;
            this.f2141b += m3343c(k, v);
            put = this.f2140a.put(k, v);
            if (put != null) {
                this.f2141b -= m3343c(k, put);
            }
        }
        if (put != null) {
            mo612a(false, k, put, v);
        }
        m3342a(this.f2142c);
        return put;
    }

    /* renamed from: a */
    private void m3342a(int i) {
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                if (this.f2141b >= 0 && this.f2140a.isEmpty() && this.f2141b == 0) {
                }
                if (this.f2141b <= i) {
                    return;
                }
                Entry entry = null;
                for (Entry entry2 : this.f2140a.entrySet()) {
                }
                if (entry == null) {
                    return;
                }
                key = entry.getKey();
                value = entry.getValue();
                this.f2140a.remove(key);
                this.f2141b -= m3343c(key, value);
                this.f2145f++;
            }
            mo612a(true, key, value, null);
        }
    }

    /* renamed from: a */
    protected void mo612a(boolean z, K k, V v, V v2) {
    }

    /* renamed from: b */
    protected V m3348b(K k) {
        return null;
    }

    /* renamed from: c */
    private int m3343c(K k, V v) {
        int a = mo611a(k, v);
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* renamed from: a */
    protected int mo611a(K k, V v) {
        return 1;
    }

    /* renamed from: a */
    public final void m3346a() {
        m3342a(-1);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f2146g + this.f2147h;
            if (i2 != 0) {
                i = (this.f2146g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f2142c), Integer.valueOf(this.f2146g), Integer.valueOf(this.f2147h), Integer.valueOf(i)});
        }
        return format;
    }
}
