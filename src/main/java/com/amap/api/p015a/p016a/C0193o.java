package com.amap.api.p015a.p016a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: LruCache */
/* renamed from: com.amap.api.a.a.o */
public class C0193o<K, V> {
    /* renamed from: a */
    private final LinkedHashMap<K, V> f562a;
    /* renamed from: b */
    private int f563b;
    /* renamed from: c */
    private int f564c;
    /* renamed from: d */
    private int f565d;
    /* renamed from: e */
    private int f566e;
    /* renamed from: f */
    private int f567f;
    /* renamed from: g */
    private int f568g;
    /* renamed from: h */
    private int f569h;

    public C0193o(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f564c = i;
        this.f562a = new LinkedHashMap(0, 0.75f, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final V m720a(K r5) {
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
        r0 = r4.f562a;	 Catch:{ all -> 0x002a }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r4.f568g;	 Catch:{ all -> 0x002a }
        r1 = r1 + 1;
        r4.f568g = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r4.f569h;	 Catch:{ all -> 0x002a }
        r0 = r0 + 1;
        r4.f569h = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        r1 = r4.m723b(r5);
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
        r0 = r4.f566e;	 Catch:{ all -> 0x0053 }
        r0 = r0 + 1;
        r4.f566e = r0;	 Catch:{ all -> 0x0053 }
        r0 = r4.f562a;	 Catch:{ all -> 0x0053 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r4.f562a;	 Catch:{ all -> 0x0053 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0053 }
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0056;
    L_0x0044:
        r2 = 0;
        r4.mo31a(r2, r5, r1, r0);
        goto L_0x001a;
    L_0x0049:
        r2 = r4.f563b;	 Catch:{ all -> 0x0053 }
        r3 = r4.m718c(r5, r1);	 Catch:{ all -> 0x0053 }
        r2 = r2 + r3;
        r4.f563b = r2;	 Catch:{ all -> 0x0053 }
        goto L_0x0041;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r0 = r4.f564c;
        r4.m717a(r0);
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.a.a.o.a(java.lang.Object):V");
    }

    /* renamed from: b */
    public final V m724b(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f565d++;
            this.f563b += m718c(k, v);
            put = this.f562a.put(k, v);
            if (put != null) {
                this.f563b -= m718c(k, put);
            }
        }
        if (put != null) {
            mo31a(false, k, put, v);
        }
        m717a(this.f564c);
        return put;
    }

    /* renamed from: a */
    private void m717a(int i) {
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                if (this.f563b >= 0 && (!this.f562a.isEmpty() || this.f563b == 0)) {
                    if (this.f563b <= i) {
                        return;
                    }
                    Entry entry = null;
                    for (Entry entry2 : this.f562a.entrySet()) {
                    }
                    if (entry == null) {
                        return;
                    }
                    key = entry.getKey();
                    value = entry.getValue();
                    this.f562a.remove(key);
                    this.f563b -= m718c(key, value);
                    this.f567f++;
                }
            }
            mo31a(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    /* renamed from: a */
    protected void mo31a(boolean z, K k, V v, V v2) {
    }

    /* renamed from: b */
    protected V m723b(K k) {
        return null;
    }

    /* renamed from: c */
    private int m718c(K k, V v) {
        int a = mo30a(k, v);
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* renamed from: a */
    protected int mo30a(K k, V v) {
        return 1;
    }

    /* renamed from: a */
    public final void m721a() {
        m717a(-1);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f568g + this.f569h;
            if (i2 != 0) {
                i = (this.f568g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f564c), Integer.valueOf(this.f568g), Integer.valueOf(this.f569h), Integer.valueOf(i)});
        }
        return format;
    }
}
