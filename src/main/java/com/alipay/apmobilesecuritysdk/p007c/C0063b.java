package com.alipay.apmobilesecuritysdk.p007c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.apmobilesecuritysdk.p004a.C0059h;
import com.alipay.security.mobile.module.http.IUpload;
import com.alipay.security.mobile.module.p010a.C0160b;
import com.umeng.analytics.onlineconfig.C1248a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.c.b */
public final class C0063b {
    /* renamed from: a */
    private File f131a = null;
    /* renamed from: b */
    private IUpload f132b = null;

    public C0063b(String str, IUpload iUpload) {
        this.f131a = new File(str);
        this.f132b = iUpload;
    }

    /* renamed from: a */
    private static String m171a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C1248a.f5654a, "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            return bi_常量类.f6358b;
        }
    }

    /* renamed from: a */
    private synchronized void m172a() {
        int i = 0;
        synchronized (this) {
            if (this.f131a != null) {
                if (this.f131a.exists() && this.f131a.isDirectory() && this.f131a.list().length != 0) {
                    int i2;
                    String str;
                    List arrayList = new ArrayList();
                    for (Object add : this.f131a.list()) {
                        arrayList.add(add);
                    }
                    Collections.sort(arrayList);
                    String str2 = (String) arrayList.get(arrayList.size() - 1);
                    int size = arrayList.size();
                    int i3;
                    if (!str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                        i3 = size;
                        str = str2;
                        i2 = i3;
                    } else if (arrayList.size() >= 2) {
                        i3 = size - 1;
                        str = (String) arrayList.get(arrayList.size() - 2);
                        i2 = i3;
                    }
                    size = !this.f132b.logCollect(C0063b.m171a(C0160b.m560a(this.f131a.getAbsolutePath(), str))) ? i2 - 1 : i2;
                    while (i < size) {
                        new File(this.f131a, (String) arrayList.get(i)).delete();
                        i++;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m174a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
        Object obj = (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1) ? 1 : null;
        boolean a = C0059h.m162a(context);
        if (obj != null && a) {
            new Thread(new C0064c(this)).start();
        }
    }
}
