package com.tencent.wxop.stat;

/* synthetic */ class ag {
    /* renamed from: a */
    static final /* synthetic */ int[] f5352a = new int[StatReportStrategy.values().length];

    static {
        try {
            f5352a[StatReportStrategy.INSTANT.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5352a[StatReportStrategy.PERIOD.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5352a[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5352a[StatReportStrategy.DEVELOPER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5352a[StatReportStrategy.BATCH.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f5352a[StatReportStrategy.ONLY_WIFI.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f5352a[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
    }
}
