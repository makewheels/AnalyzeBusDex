package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.mapcore.ak;
import com.amap.api.mapcore.util.C0408x;
import p054u.aly.bi_常量类;

public final class MapsInitializer {
    /* renamed from: a */
    private static boolean f2233a = true;
    public static String sdcardDir = bi_常量类.f6358b;

    public static void initialize(Context context) throws RemoteException {
        ak.f1476a = context.getApplicationContext();
    }

    public static void setNetWorkEnable(boolean z) {
        f2233a = z;
    }

    public static boolean getNetWorkEnable() {
        return f2233a;
    }

    public static void setApiKey(String str) {
        if (str != null && str.trim().length() > 0) {
            C0408x.m3499a(str);
        }
    }

    public static String getVersion() {
        return "V2.5.1";
    }
}
