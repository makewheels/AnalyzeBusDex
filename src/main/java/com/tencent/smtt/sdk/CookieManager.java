package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.utils.C1157u;
import java.util.Map;

public class CookieManager {
    /* renamed from: b */
    private static CookieManager f4778b;
    /* renamed from: a */
    private android.webkit.CookieManager f4779a = android.webkit.CookieManager.getInstance();

    private CookieManager() {
    }

    public static synchronized CookieManager getInstance() {
        CookieManager cookieManager;
        synchronized (CookieManager.class) {
            if (f4778b == null) {
                f4778b = new CookieManager();
            }
            cookieManager = f4778b;
        }
        return cookieManager;
    }

    public boolean acceptCookie() {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? this.f4779a.acceptCookie() : a.m7852a().m7784b();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean booleanValue;
        C1110i a = C1110i.m7845a(false);
        Object invokeStaticMethod;
        if (a != null && a.m7858b()) {
            invokeStaticMethod = a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : true;
        } else if (VERSION.SDK_INT < 21) {
            booleanValue = true;
        } else {
            invokeStaticMethod = C1157u.m8042a(this.f4779a, "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            booleanValue = invokeStaticMethod != null ? ((Boolean) invokeStaticMethod).booleanValue() : false;
        }
        return booleanValue;
    }

    public void flush() {
        C1110i a = C1110i.m7845a(false);
        if (a != null && a.m7858b()) {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (VERSION.SDK_INT >= 21) {
            C1157u.m8042a(this.f4779a, "flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? this.f4779a.getCookie(str) : a.m7852a().m7772a(str);
    }

    public boolean hasCookies() {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? this.f4779a.hasCookies() : a.m7852a().m7795f();
    }

    public void removeAllCookie() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4779a.removeAllCookie();
        } else {
            a.m7852a().m7786c();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        C1110i a = C1110i.m7845a(false);
        if (a != null && a.m7858b()) {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        } else if (VERSION.SDK_INT >= 21) {
            C1157u.m8042a(this.f4779a, "removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        }
    }

    public void removeExpiredCookie() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4779a.removeExpiredCookie();
        } else {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookie() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4779a.removeSessionCookie();
        } else {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        C1110i a = C1110i.m7845a(false);
        if (a != null && a.m7858b()) {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        } else if (VERSION.SDK_INT >= 21) {
            C1157u.m8042a(this.f4779a, "removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4779a.setAcceptCookie(z);
        } else {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        C1110i a = C1110i.m7845a(false);
        if (a != null && a.m7858b()) {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else if (VERSION.SDK_INT >= 21) {
            C1157u.m8042a(this.f4779a, "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public void setCookie(String str, String str2) {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            this.f4779a.setCookie(str, str2);
            return;
        }
        a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
    }

    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        C1110i a = C1110i.m7845a(false);
        if (a != null && a.m7858b()) {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
        } else if (VERSION.SDK_INT >= 21) {
            C1157u.m8042a(this.f4779a, "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
        }
    }

    public void setCookies(Map<String, String[]> map) {
        C1110i a = C1110i.m7845a(false);
        boolean a2 = (a == null || !a.m7858b()) ? false : a.m7852a().m7780a((Map) map);
        if (!a2) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
    }
}
