package com.amap.api.mapcore.util;

/* compiled from: SDKInfo */
public class ad {
    /* renamed from: a */
    String f1925a;
    /* renamed from: b */
    String f1926b;
    /* renamed from: c */
    String f1927c;
    /* renamed from: d */
    private boolean f1928d;
    /* renamed from: e */
    private String f1929e;
    /* renamed from: f */
    private String[] f1930f;

    /* compiled from: SDKInfo */
    /* renamed from: com.amap.api.mapcore.util.ad$a */
    public static class C0356a {
        /* renamed from: a */
        private String f1919a;
        /* renamed from: b */
        private String f1920b;
        /* renamed from: c */
        private String f1921c;
        /* renamed from: d */
        private boolean f1922d = true;
        /* renamed from: e */
        private String f1923e = "standard";
        /* renamed from: f */
        private String[] f1924f = null;

        public C0356a(String str, String str2, String str3) {
            this.f1919a = str2;
            this.f1921c = str3;
            this.f1920b = str;
        }

        /* renamed from: a */
        public C0356a m3030a(boolean z) {
            this.f1922d = z;
            return this;
        }

        /* renamed from: a */
        public C0356a m3029a(String str) {
            this.f1923e = str;
            return this;
        }

        /* renamed from: a */
        public C0356a m3031a(String[] strArr) {
            this.f1924f = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public ad m3032a() throws C0406v {
            if (this.f1924f != null) {
                return new ad();
            }
            throw new C0406v("sdk packages is null");
        }
    }

    private ad(C0356a c0356a) {
        this.f1928d = true;
        this.f1929e = "standard";
        this.f1930f = null;
        this.f1925a = c0356a.f1919a;
        this.f1927c = c0356a.f1920b;
        this.f1926b = c0356a.f1921c;
        this.f1928d = c0356a.f1922d;
        this.f1929e = c0356a.f1923e;
        this.f1930f = c0356a.f1924f;
    }

    /* renamed from: a */
    public String m3033a() {
        return this.f1927c;
    }

    /* renamed from: b */
    public String m3034b() {
        return this.f1925a;
    }

    /* renamed from: c */
    public String m3035c() {
        return this.f1926b;
    }

    /* renamed from: d */
    public String m3036d() {
        return this.f1929e;
    }

    /* renamed from: e */
    public boolean m3037e() {
        return this.f1928d;
    }

    /* renamed from: f */
    public String[] m3038f() {
        return (String[]) this.f1930f.clone();
    }
}
