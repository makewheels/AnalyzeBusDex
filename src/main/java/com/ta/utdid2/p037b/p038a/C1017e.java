package com.ta.utdid2.p037b.p038a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* compiled from: NetworkUtils */
/* renamed from: com.ta.utdid2.b.a.e */
public final class C1017e {
    /* renamed from: a */
    private static ConnectivityManager f4703a = null;
    /* renamed from: b */
    private static final int[] f4704b = new int[]{4, 7, 2, 1};

    /* renamed from: a */
    public static boolean m7376a(Context context) {
        ConnectivityManager c = C1017e.m7378c(context);
        if (c != null) {
            try {
                NetworkInfo activeNetworkInfo = c.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            } catch (Exception e) {
                Log.e("NetworkUtils", e.toString());
            }
        } else {
            Log.e("NetworkUtils", "connManager is null!");
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m7377b(Context context) {
        ConnectivityManager c = C1017e.m7378c(context);
        if (c != null) {
            try {
                NetworkInfo activeNetworkInfo = c.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    int subtype = activeNetworkInfo.getSubtype();
                    if (C1015c.f4699a) {
                        Log.d("NetworkUtils", "subType:" + subtype + ": name:" + activeNetworkInfo.getSubtypeName());
                    }
                    for (int i : f4704b) {
                        if (i == subtype) {
                            return true;
                        }
                    }
                    return false;
                }
                Log.e("NetworkUtils", "networkInfo is null!");
                return false;
            } catch (Exception e) {
                Log.e("NetworkUtils", e.toString());
                return false;
            }
        }
        Log.e("NetworkUtils", "connManager is null!");
        return false;
    }

    /* renamed from: c */
    private static ConnectivityManager m7378c(Context context) {
        if (context == null) {
            Log.e("NetworkUtils", "context is null!");
            return null;
        }
        if (f4703a == null) {
            f4703a = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return f4703a;
    }
}
