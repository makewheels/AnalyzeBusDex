package com.tencent.smtt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.smtt.utils.y */
public class C1163y {
    /* renamed from: a */
    private C1162b f5190a = null;
    /* renamed from: b */
    private C1162b f5191b = null;

    /* renamed from: com.tencent.smtt.utils.y$a */
    class C1161a {
        /* renamed from: a */
        final /* synthetic */ C1163y f5184a;
        /* renamed from: b */
        private String f5185b;
        /* renamed from: c */
        private long f5186c;
        /* renamed from: d */
        private long f5187d;

        C1161a(C1163y c1163y, String str, long j, long j2) {
            this.f5184a = c1163y;
            this.f5185b = str;
            this.f5186c = j;
            this.f5187d = j2;
        }

        /* renamed from: a */
        long m8071a() {
            return this.f5186c;
        }

        /* renamed from: b */
        long m8072b() {
            return this.f5187d;
        }
    }

    /* renamed from: com.tencent.smtt.utils.y$b */
    class C1162b {
        /* renamed from: a */
        final /* synthetic */ C1163y f5188a;
        /* renamed from: b */
        private Map<String, C1161a> f5189b = new HashMap();

        C1162b(C1163y c1163y, File file) {
            this.f5188a = c1163y;
            this.f5189b.clear();
            m8073a(file);
        }

        /* renamed from: a */
        private void m8073a(File file) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File a : listFiles) {
                    m8073a(a);
                }
            } else if (file.isFile()) {
                m8074a(file.getName(), file.length(), file.lastModified());
            }
        }

        /* renamed from: a */
        private void m8074a(String str, long j, long j2) {
            if (str != null && str.length() > 0 && j > 0 && j2 > 0) {
                C1161a c1161a = new C1161a(this.f5188a, str, j, j2);
                if (!this.f5189b.containsKey(str)) {
                    this.f5189b.put(str, c1161a);
                }
            }
        }

        /* renamed from: a */
        Map<String, C1161a> m8075a() {
            return this.f5189b;
        }
    }

    /* renamed from: a */
    private boolean m8076a(C1162b c1162b, C1162b c1162b2) {
        if (c1162b == null || c1162b.m8075a() == null || c1162b2 == null || c1162b2.m8075a() == null) {
            return false;
        }
        Map a = c1162b.m8075a();
        Map a2 = c1162b2.m8075a();
        for (Entry entry : a.entrySet()) {
            String str = (String) entry.getKey();
            C1161a c1161a = (C1161a) entry.getValue();
            if (!a2.containsKey(str)) {
                return false;
            }
            C1161a c1161a2 = (C1161a) a2.get(str);
            if (c1161a.m8071a() == c1161a2.m8071a()) {
                if (c1161a.m8072b() != c1161a2.m8072b()) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void m8077a(File file) {
        this.f5190a = new C1162b(this, file);
    }

    /* renamed from: a */
    public boolean m8078a() {
        return this.f5191b != null && this.f5190a != null && this.f5191b.m8075a().size() == this.f5190a.m8075a().size() && m8076a(this.f5190a, this.f5191b);
    }

    /* renamed from: b */
    public void m8079b(File file) {
        this.f5191b = new C1162b(this, file);
    }
}
