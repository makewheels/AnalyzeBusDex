package com.alipay.sdk.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.methods.HttpPost;

/* renamed from: com.alipay.sdk.util.d */
public final class C0143d {
    /* renamed from: a */
    private static ThreadPoolExecutor f429a = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(20));
    /* renamed from: b */
    private static Object f430b = new Object();
    /* renamed from: c */
    private static HttpPost f431c = new HttpPost("https://mclient.alipay.com/sdkErrorlog.do");

    /* renamed from: a */
    public static void m503a(String str) {
        f429a.execute(new C0144e(str));
    }
}
