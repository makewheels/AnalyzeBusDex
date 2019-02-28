package com.amap.api.maps2d;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.p015a.aw;
import p054u.aly.bi_常量类;

public final class MapsInitializer {
    /* renamed from: a */
    private static boolean f2564a = true;
    public static String sdcardDir = bi_常量类.f6358b;

    public static void initialize(Context context) throws RemoteException {
        aw.f673a = context.getApplicationContext();
    }

    public static void setNetworkEnable(boolean z) {
        f2564a = z;
    }

    public static boolean getNetworkEnable() {
        return f2564a;
    }
}
