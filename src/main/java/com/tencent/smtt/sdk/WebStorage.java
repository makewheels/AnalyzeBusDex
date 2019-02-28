package com.tencent.smtt.sdk;

import android.webkit.ValueCallback;
import java.util.Map;

public class WebStorage {
    /* renamed from: a */
    private static WebStorage f4887a;
    /* renamed from: b */
    private android.webkit.WebStorage f4888b = android.webkit.WebStorage.getInstance();

    @Deprecated
    public interface QuotaUpdater {
        void updateQuota(long j);
    }

    /* renamed from: a */
    private static synchronized WebStorage m7650a() {
        WebStorage webStorage;
        synchronized (WebStorage.class) {
            if (f4887a == null) {
                f4887a = new WebStorage();
            }
            webStorage = f4887a;
        }
        return webStorage;
    }

    public static WebStorage getInstance() {
        return m7650a();
    }

    public void deleteAllData() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4888b.deleteAllData();
        } else {
            a.m7852a().m7803l();
        }
    }

    public void deleteOrigin(String str) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4888b.deleteOrigin(str);
        } else {
            a.m7852a().m7794e(str);
        }
    }

    public void getOrigins(ValueCallback<Map> valueCallback) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4888b.getOrigins(valueCallback);
        } else {
            a.m7852a().m7774a((ValueCallback) valueCallback);
        }
    }

    public void getQuotaForOrigin(String str, ValueCallback<Long> valueCallback) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4888b.getQuotaForOrigin(str, valueCallback);
        } else {
            a.m7852a().m7783b(str, valueCallback);
        }
    }

    public void getUsageForOrigin(String str, ValueCallback<Long> valueCallback) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4888b.getUsageForOrigin(str, valueCallback);
        } else {
            a.m7852a().m7776a(str, (ValueCallback) valueCallback);
        }
    }

    @Deprecated
    public void setQuotaForOrigin(String str, long j) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4888b.setQuotaForOrigin(str, j);
        } else {
            a.m7852a().m7775a(str, j);
        }
    }
}
