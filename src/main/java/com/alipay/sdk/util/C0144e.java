package com.alipay.sdk.util;

import android.util.Log;
import com.alipay.sdk.net.C0123b;
import com.alipay.sdk.net.C0124c;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: com.alipay.sdk.util.e */
final class C0144e implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f432a;

    C0144e(String str) {
        this.f432a = str;
    }

    public final void run() {
        synchronized (C0143d.f430b) {
            List arrayList = new ArrayList(1);
            arrayList.add(new BasicNameValuePair("errorTag", this.f432a));
            try {
                C0143d.f431c.setEntity(new UrlEncodedFormEntity(arrayList));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                C0123b.m382a();
                C0123b.m382a();
                Log.d("Http Post Response:", C0124c.m397a(C0123b.f352b.m395a(C0143d.f431c)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
