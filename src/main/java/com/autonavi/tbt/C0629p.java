package com.autonavi.tbt;

/* compiled from: SDKInfo */
/* renamed from: com.autonavi.tbt.p */
public class C0629p {
    /* renamed from: a */
    String f3837a;
    /* renamed from: b */
    String f3838b;
    /* renamed from: c */
    String f3839c;
    /* renamed from: d */
    private boolean f3840d;
    /* renamed from: e */
    private String f3841e;
    /* renamed from: f */
    private String[] f3842f;

    /* compiled from: SDKInfo */
    /* renamed from: com.autonavi.tbt.p$a */
    public static class C0628a {
        /* renamed from: a */
        private String f3831a;
        /* renamed from: b */
        private String f3832b;
        /* renamed from: c */
        private String f3833c;
        /* renamed from: d */
        private boolean f3834d = true;
        /* renamed from: e */
        private String f3835e = "standard";
        /* renamed from: f */
        private String[] f3836f = null;

        public C0628a(String str, String str2, String str3) {
            this.f3831a = str2;
            this.f3833c = str3;
            this.f3832b = str;
        }

        /* renamed from: a */
        public C0628a m4935a(boolean z) {
            this.f3834d = z;
            return this;
        }

        /* renamed from: a */
        public C0628a m4934a(String str) {
            this.f3835e = str;
            return this;
        }

        /* renamed from: a */
        public C0628a m4936a(String[] strArr) {
            this.f3836f = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public C0629p m4937a() throws C0618h {
            if (this.f3836f != null) {
                return new C0629p();
            }
            throw new C0618h("sdk packages is null");
        }
    }

    private C0629p(C0628a c0628a) {
        this.f3840d = true;
        this.f3841e = "standard";
        this.f3842f = null;
        this.f3837a = c0628a.f3831a;
        this.f3839c = c0628a.f3832b;
        this.f3838b = c0628a.f3833c;
        this.f3840d = c0628a.f3834d;
        this.f3841e = c0628a.f3835e;
        this.f3842f = c0628a.f3836f;
    }

    /* renamed from: a */
    public String m4938a() {
        return this.f3839c;
    }

    /* renamed from: b */
    public String m4939b() {
        return this.f3837a;
    }

    /* renamed from: c */
    public String m4940c() {
        return this.f3838b;
    }

    /* renamed from: d */
    public String m4941d() {
        return this.f3841e;
    }

    /* renamed from: e */
    public boolean m4942e() {
        return this.f3840d;
    }

    /* renamed from: f */
    public String[] m4943f() {
        return (String[]) this.f3842f.clone();
    }
}
