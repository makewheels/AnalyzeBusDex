package com.tencent.mm.sdk.diffdev.p050a;

import android.util.Log;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.tencent.mm.sdk.diffdev.a.e */
public final class C1069e {
    /* renamed from: b */
    public static byte[] m7541b(String str, int i) {
        byte[] bArr = null;
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        } else {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpGet = new HttpGet(str);
            if (i >= 0) {
                try {
                    HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), i);
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet, Exception ex = " + e.getMessage());
                } catch (IncompatibleClassChangeError e2) {
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet, IncompatibleClassChangeError ex = " + e2.getMessage());
                } catch (Throwable th) {
                    Log.e("MicroMsg.SDK.NetUtil", "httpGet, Throwable ex = " + th.getMessage());
                }
            }
            HttpResponse execute = defaultHttpClient.execute(httpGet);
            if (execute.getStatusLine().getStatusCode() != 200) {
                Log.e("MicroMsg.SDK.NetUtil", "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
            } else {
                bArr = EntityUtils.toByteArray(execute.getEntity());
            }
        }
        return bArr;
    }
}
