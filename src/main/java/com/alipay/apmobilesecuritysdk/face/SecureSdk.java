package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.p004a.C0052a;
import java.util.Map;

public class SecureSdk {
    public static synchronized String getApdidToken(Context context, Map<String, String> map) {
        String a;
        synchronized (SecureSdk.class) {
            a = new C0052a(context).m140a((Map) map);
        }
        return a;
    }
}
