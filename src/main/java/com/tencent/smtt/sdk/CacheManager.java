package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.C1157u;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        C1110i a = C1110i.m7845a(false);
        if (a != null && a.m7858b()) {
            return ((Boolean) a.m7852a().m7771a()).booleanValue();
        }
        Object a2 = C1157u.m8043a("android.webkit.CacheManager", "cacheDisabled");
        return a2 == null ? false : ((Boolean) a2).booleanValue();
    }

    public static InputStream getCacheFile(String str, boolean z) {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? null : a.m7852a().m7770a(str, z);
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        C1110i a = C1110i.m7845a(false);
        if (a != null && a.m7858b()) {
            return a.m7852a().m7792e();
        }
        try {
            return C1157u.m8040a(Class.forName("android.webkit.CacheManager"), "getCacheFile", new Class[]{String.class, Map.class}, str, map);
        } catch (Exception e) {
            return null;
        }
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        C1110i a = C1110i.m7845a(false);
        return (a == null || !a.m7858b()) ? (File) C1157u.m8043a("android.webkit.CacheManager", "getCacheFileBaseDir") : (File) a.m7852a().m7792e();
    }
}
