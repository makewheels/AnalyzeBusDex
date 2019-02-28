package com.tencent.smtt.sdk.p051a;

import MTT.ThirdAppInfoNew;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.smtt.utils.C1151o;
import com.tencent.smtt.utils.C1159w;
import com.tencent.smtt.utils.TbsLog;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: com.tencent.smtt.sdk.a.c */
final class C1087c extends Thread {
    /* renamed from: a */
    final /* synthetic */ ThirdAppInfoNew f4938a;

    C1087c(String str, ThirdAppInfoNew thirdAppInfoNew) {
        this.f4938a = thirdAppInfoNew;
        super(str);
    }

    public void run() {
        if (VERSION.SDK_INT >= 8) {
            if (C1086b.f4937a == null) {
                try {
                    C1086b.f4937a = "65dRa93L".getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    C1086b.f4937a = null;
                    TbsLog.m7925e("sdkreport", "Post failed -- get POST_DATA_KEY failed!");
                }
            }
            if (C1086b.f4937a == null) {
                TbsLog.m7925e("sdkreport", "Post failed -- POST_DATA_KEY is null!");
                return;
            }
            try {
                JSONObject b;
                String b2 = C1159w.m8056a().m8060b();
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(b2 + C1151o.m8008a().m8011b()).openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                }
                try {
                    b = C1086b.m7690c(this.f4938a);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    b = null;
                }
                if (b == null) {
                    TbsLog.m7925e("sdkreport", "post -- jsonData is null!");
                    return;
                }
                try {
                    byte[] a = C1151o.m8008a().m8010a(b.toString().getBytes("utf-8"));
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(a.length));
                    try {
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(a);
                        outputStream.flush();
                        if (httpURLConnection.getResponseCode() != 200) {
                            TbsLog.m7925e("sdkreport", "Post failed -- not 200");
                        }
                    } catch (Throwable th) {
                        TbsLog.m7925e("sdkreport", "Post failed -- exceptions:" + th.getMessage());
                    }
                } catch (Throwable th2) {
                }
            } catch (IOException e3) {
                TbsLog.m7925e("sdkreport", "Post failed -- IOException:" + e3);
            } catch (AssertionError e4) {
                TbsLog.m7925e("sdkreport", "Post failed -- AssertionError:" + e4);
            } catch (NoClassDefFoundError e5) {
                TbsLog.m7925e("sdkreport", "Post failed -- NoClassDefFoundError:" + e5);
            }
        }
    }
}
