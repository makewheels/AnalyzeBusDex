package com.tencent.smtt.sdk;

import android.content.Context;
import java.lang.reflect.Field;

public class CookieSyncManager {
    /* renamed from: a */
    private static android.webkit.CookieSyncManager f4780a;
    /* renamed from: b */
    private static CookieSyncManager f4781b;

    private CookieSyncManager(Context context) {
        C1110i a = C1110i.m7845a(false);
        if (a != null && a.m7858b()) {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
        }
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            f4780a = android.webkit.CookieSyncManager.createInstance(context);
            if (f4781b == null) {
                f4781b = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = f4781b;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (f4781b == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cookieSyncManager = f4781b;
        }
        return cookieSyncManager;
    }

    public void startSync() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            f4780a.startSync();
            try {
                Field declaredField = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
                declaredField.setAccessible(true);
                ((Thread) declaredField.get(f4780a)).setUncaughtExceptionHandler(new C1111j());
                return;
            } catch (Exception e) {
                return;
            }
        }
        a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
    }

    public void stopSync() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            f4780a.stopSync();
        } else {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        C1110i a = C1110i.m7845a(false);
        if (a == null || !a.m7858b()) {
            f4780a.sync();
        } else {
            a.m7852a().m7806o().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
