package com.umeng.analytics;

import android.content.Context;
import p054u.aly.C1448q;
import p054u.aly.C1453w;
import p054u.aly.bi_常量类;

public class ReportPolicy {
    public static final int BATCH_AT_LAUNCH = 1;
    public static final int BATCH_BY_INTERVAL = 6;
    public static final int BATCH_BY_SIZE = 7;
    public static final int DAILY = 4;
    public static final int REALTIME = 0;
    public static final int WIFIONLY = 5;
    /* renamed from: a */
    static final int f5583a = 2;
    /* renamed from: b */
    static final int f5584b = 3;

    /* renamed from: com.umeng.analytics.ReportPolicy$e */
    public static class C1227e {
        /* renamed from: a */
        public boolean mo1915a(boolean z) {
            return true;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$a */
    public static class C1228a extends C1227e {
        /* renamed from: a */
        public boolean mo1915a(boolean z) {
            return z;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$b */
    public static class C1229b extends C1227e {
        /* renamed from: a */
        private long f5575a = 10000;
        /* renamed from: b */
        private long f5576b;
        /* renamed from: c */
        private C1453w f5577c;

        public C1229b(C1453w c1453w, long j) {
            this.f5577c = c1453w;
            if (j < this.f5575a) {
                j = this.f5575a;
            }
            this.f5576b = j;
        }

        /* renamed from: a */
        public boolean mo1915a(boolean z) {
            if (System.currentTimeMillis() - this.f5577c.f6613c >= this.f5576b) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public long m8362a() {
            return this.f5576b;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$c */
    public static class C1230c extends C1227e {
        /* renamed from: a */
        private final int f5578a;
        /* renamed from: b */
        private C1448q f5579b;

        public C1230c(C1448q c1448q, int i) {
            this.f5578a = i;
            this.f5579b = c1448q;
        }

        /* renamed from: a */
        public boolean mo1915a(boolean z) {
            return this.f5579b.m10448b() > this.f5578a;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$d */
    public static class C1231d extends C1227e {
        /* renamed from: a */
        private long f5580a = C1233a.f5597m;
        /* renamed from: b */
        private C1453w f5581b;

        public C1231d(C1453w c1453w) {
            this.f5581b = c1453w;
        }

        /* renamed from: a */
        public boolean mo1915a(boolean z) {
            if (System.currentTimeMillis() - this.f5581b.f6613c >= this.f5580a) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.umeng.analytics.ReportPolicy$f */
    public static class C1232f extends C1227e {
        /* renamed from: a */
        private Context f5582a = null;

        public C1232f(Context context) {
            this.f5582a = context;
        }

        /* renamed from: a */
        public boolean mo1915a(boolean z) {
            return bi_常量类.m9986k(this.f5582a);
        }
    }
}
