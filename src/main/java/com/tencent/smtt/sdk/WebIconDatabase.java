package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;

@Deprecated
public class WebIconDatabase {
    /* renamed from: a */
    private static WebIconDatabase f4882a;
    /* renamed from: b */
    private android.webkit.WebIconDatabase f4883b = android.webkit.WebIconDatabase.getInstance();

    @Deprecated
    /* renamed from: com.tencent.smtt.sdk.WebIconDatabase$a */
    public interface C1083a {
        /* renamed from: a */
        void m7648a(String str, Bitmap bitmap);
    }

    private WebIconDatabase() {
    }

    /* renamed from: a */
    private static synchronized WebIconDatabase m7649a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            if (f4882a == null) {
                f4882a = new WebIconDatabase();
            }
            webIconDatabase = f4882a;
        }
        return webIconDatabase;
    }

    public static WebIconDatabase getInstance() {
        return m7649a();
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, C1083a c1083a) {
    }

    public void close() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4883b.close();
        } else {
            a.m7852a().m7802k();
        }
    }

    public void open(String str) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4883b.open(str);
        } else {
            a.m7852a().m7782b(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4883b.releaseIconForPageUrl(str);
        } else {
            a.m7852a().m7790d(str);
        }
    }

    public void removeAllIcons() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4883b.removeAllIcons();
        } else {
            a.m7852a().m7801j();
        }
    }

    public void requestIconForPageUrl(String str, C1083a c1083a) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4883b.requestIconForPageUrl(str, new as(this, c1083a));
        } else {
            a.m7852a().m7777a(str, new ar(this, c1083a));
        }
    }

    public void retainIconForPageUrl(String str) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4883b.retainIconForPageUrl(str);
        } else {
            a.m7852a().m7788c(str);
        }
    }
}
