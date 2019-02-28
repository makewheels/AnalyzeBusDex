package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* compiled from: ResourcesUtil */
/* renamed from: com.amap.api.mapcore.util.s */
public class C0402s {
    /* renamed from: a */
    private static boolean f2183a;

    static {
        f2183a = false;
        f2183a = new File("/system/framework/amap.jar").exists();
    }

    /* renamed from: a */
    public static AssetManager m3433a(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (!f2183a) {
            return assets;
        }
        try {
            assets.getClass().getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assets, new Object[]{"/system/framework/amap.jar"});
            return assets;
        } catch (Throwable th) {
            az.m3143a(th, "ResourcesUtil", "getSelfAssets");
            return assets;
        }
    }
}
