package com.alipay.apmobilesecuritysdk.face;

import android.annotation.SuppressLint;
import android.content.Context;
import com.alipay.apmobilesecuritysdk.p004a.C0052a;
import com.alipay.apmobilesecuritysdk.p009e.C0070b;
import com.alipay.sdk.cons.C0109b;
import com.alipay.security.mobile.module.p010a.C0159a;
import com.taobao.dp.DeviceSecuritySDK;
import com.taobao.dp.client.IInitResultListener;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.LinkedList;
import java.util.Map;
import p054u.aly.bi_常量类;

@SuppressLint({"NewApi"})
public class APSecuritySdk {
    /* renamed from: a */
    private static APSecuritySdk f146a;
    /* renamed from: b */
    private static Object f147b = new Object();
    /* renamed from: c */
    private Context f148c;
    /* renamed from: d */
    private String f149d;
    /* renamed from: e */
    private volatile boolean f150e = false;
    /* renamed from: f */
    private volatile boolean f151f = false;
    /* renamed from: g */
    private Thread f152g;
    /* renamed from: h */
    private LinkedList<RunningTask> f153h = new LinkedList();

    /* renamed from: com.alipay.apmobilesecuritysdk.face.APSecuritySdk$1 */
    class C00711 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ APSecuritySdk f136a;

        C00711(APSecuritySdk aPSecuritySdk) {
            this.f136a = aPSecuritySdk;
        }

        public void run() {
            while (!this.f136a.f153h.isEmpty()) {
                try {
                    RunningTask runningTask = (RunningTask) this.f136a.f153h.pollFirst();
                    if (runningTask != null) {
                        runningTask.run();
                    }
                } catch (Throwable th) {
                } finally {
                    this.f136a.f152g = null;
                }
            }
        }
    }

    /* renamed from: com.alipay.apmobilesecuritysdk.face.APSecuritySdk$2 */
    class C00722 implements UncaughtExceptionHandler {
        /* renamed from: a */
        final /* synthetic */ APSecuritySdk f137a;

        C00722(APSecuritySdk aPSecuritySdk) {
            this.f137a = aPSecuritySdk;
        }

        public void uncaughtException(Thread thread, Throwable th) {
        }
    }

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    private class RunningTask {
        /* renamed from: a */
        final /* synthetic */ APSecuritySdk f139a;
        /* renamed from: b */
        private int f140b;
        /* renamed from: c */
        private String f141c;
        /* renamed from: d */
        private String f142d;
        /* renamed from: e */
        private String f143e;
        /* renamed from: f */
        private InitResultListener f144f;

        /* renamed from: com.alipay.apmobilesecuritysdk.face.APSecuritySdk$RunningTask$1 */
        class C00731 implements IInitResultListener {
            /* renamed from: a */
            final /* synthetic */ RunningTask f138a;

            C00731(RunningTask runningTask) {
                this.f138a = runningTask;
            }

            public void onInitFinished(String str, int i) {
                this.f138a.f139a.f150e = true;
                if (!C0159a.m556a(str)) {
                    this.f138a.f139a.f149d = str;
                }
            }
        }

        public RunningTask(APSecuritySdk aPSecuritySdk, int i, String str, String str2, String str3, InitResultListener initResultListener) {
            this.f139a = aPSecuritySdk;
            this.f140b = i;
            this.f143e = str3;
            if (C0159a.m556a(str)) {
                this.f141c = APSecuritySdk.getUtdid(aPSecuritySdk.f148c);
            } else {
                this.f141c = str;
            }
            this.f142d = str2;
            this.f144f = initResultListener;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
            r0 = 1;
            r5 = 0;
            r1 = r6.f139a;
            r1 = r1.f151f;
            if (r1 == 0) goto L_0x000b;
        L_0x000a:
            return;
        L_0x000b:
            r1 = r6.f139a;
            r1.f151f = r0;
            r1 = r6.f140b;
            switch(r1) {
                case 1: goto L_0x004d;
                case 2: goto L_0x0052;
                case 3: goto L_0x0057;
                default: goto L_0x0015;
            };
        L_0x0015:
            r1 = "https://mobilegw.alipay.com/mgw.htm";
            com.alipay.apmobilesecuritysdk.p006b.C0061a.f122a = r1;
        L_0x0019:
            r1 = r6.f139a;	 Catch:{ Exception -> 0x00fc }
            r2 = 0;
            r1.f150e = r2;	 Catch:{ Exception -> 0x00fc }
            r1 = r6.f140b;	 Catch:{ Exception -> 0x00fc }
            r2 = 3;
            if (r1 != r2) goto L_0x00ff;
        L_0x0024:
            r1 = r6.f139a;	 Catch:{ Exception -> 0x00fc }
            r1 = r1.f148c;	 Catch:{ Exception -> 0x00fc }
            r1 = com.taobao.dp.DeviceSecuritySDK.getInstance(r1);	 Catch:{ Exception -> 0x00fc }
            r2 = "";
            r3 = 0;
            r4 = new com.alipay.apmobilesecuritysdk.face.APSecuritySdk$RunningTask$1;	 Catch:{ Exception -> 0x00fc }
            r4.<init>(r6);	 Catch:{ Exception -> 0x00fc }
            r1.initAsync(r2, r0, r3, r4);	 Catch:{ Exception -> 0x00fc }
            r0 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        L_0x003b:
            r1 = r6.f139a;	 Catch:{ Exception -> 0x00fc }
            r1 = r1.f150e;	 Catch:{ Exception -> 0x00fc }
            if (r1 != 0) goto L_0x005c;
        L_0x0043:
            if (r0 <= 0) goto L_0x005c;
        L_0x0045:
            r1 = 10;
            java.lang.Thread.sleep(r1);	 Catch:{ Exception -> 0x00fc }
            r0 = r0 + -10;
            goto L_0x003b;
        L_0x004d:
            r1 = "http://mobilegw.stable.alipay.net/mgw.htm";
            com.alipay.apmobilesecuritysdk.p006b.C0061a.f122a = r1;
            goto L_0x0019;
        L_0x0052:
            r1 = "https://mobilegw.alipay.com/mgw.htm";
            com.alipay.apmobilesecuritysdk.p006b.C0061a.f122a = r1;
            goto L_0x0019;
        L_0x0057:
            r1 = "http://mobilegw-1-64.test.alipay.net/mgw.htm";
            com.alipay.apmobilesecuritysdk.p006b.C0061a.f122a = r1;
            goto L_0x0019;
        L_0x005c:
            r0 = r6.f139a;	 Catch:{ Exception -> 0x00fc }
            r0 = r0.f148c;	 Catch:{ Exception -> 0x00fc }
            r0 = com.taobao.dp.DeviceSecuritySDK.getInstance(r0);	 Catch:{ Exception -> 0x00fc }
            r0 = r0.getSecurityToken();	 Catch:{ Exception -> 0x00fc }
            r1 = com.alipay.security.mobile.module.p010a.C0159a.m556a(r0);	 Catch:{ Exception -> 0x00fc }
            if (r1 != 0) goto L_0x0075;
        L_0x0070:
            r1 = r6.f139a;	 Catch:{ Exception -> 0x00fc }
            r1.f149d = r0;	 Catch:{ Exception -> 0x00fc }
        L_0x0075:
            r0 = new java.util.HashMap;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.<init>();	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = "enable";
            r2 = "1";
            r0.put(r1, r2);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = "tid";
            r2 = r6.f142d;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.put(r1, r2);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = "utdid";
            r2 = r6.f141c;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.put(r1, r2);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = "umid";
            r2 = r6.f139a;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r2 = r2.f149d;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.put(r1, r2);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = "userId";
            r2 = r6.f143e;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.put(r1, r2);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r6.f139a;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r1.f148c;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            com.alipay.apmobilesecuritysdk.face.SecureSdk.getApdidToken(r1, r0);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0 = r6.f144f;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            if (r0 == 0) goto L_0x00e6;
        L_0x00ae:
            r0 = new com.alipay.apmobilesecuritysdk.face.APSecuritySdk$TokenResult;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r6.f139a;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.<init>(r1);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r6.f139a;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r1.f148c;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = com.alipay.apmobilesecuritysdk.p004a.C0052a.m139b(r1);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.apdid = r1;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r6.f139a;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r1.f148c;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = com.alipay.apmobilesecuritysdk.p004a.C0052a.m134a(r1);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.apdidToken = r1;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r6.f139a;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r1.f149d;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.umidToken = r1;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r6.f139a;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r1.f148c;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = com.alipay.apmobilesecuritysdk.p009e.C0070b.m185a(r1);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r0.clientKey = r1;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1 = r6.f144f;	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
            r1.onResult(r0);	 Catch:{ Throwable -> 0x00ed, all -> 0x00f5 }
        L_0x00e6:
            r0 = r6.f139a;
            r0.f151f = r5;
            goto L_0x000a;
        L_0x00ed:
            r0 = move-exception;
            r0 = r6.f139a;
            r0.f151f = r5;
            goto L_0x000a;
        L_0x00f5:
            r0 = move-exception;
            r1 = r6.f139a;
            r1.f151f = r5;
            throw r0;
        L_0x00fc:
            r0 = move-exception;
            goto L_0x0075;
        L_0x00ff:
            r0 = r1;
            goto L_0x0024;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.RunningTask.run():void");
        }
    }

    public class TokenResult {
        /* renamed from: a */
        final /* synthetic */ APSecuritySdk f145a;
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult(APSecuritySdk aPSecuritySdk) {
            this.f145a = aPSecuritySdk;
        }
    }

    private APSecuritySdk(Context context) {
        this.f148c = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        APSecuritySdk aPSecuritySdk;
        synchronized (f147b) {
            if (f146a == null) {
                f146a = new APSecuritySdk(context);
            }
            aPSecuritySdk = f146a;
        }
        return aPSecuritySdk;
    }

    public static String getUtdid(Context context) {
        try {
            return (String) Class.forName("com.ta.utdid2.device.UTDevice").getMethod("getUtdid", new Class[]{Context.class}).invoke(null, new Object[]{context});
        } catch (Exception e) {
            return bi_常量类.f6358b;
        }
    }

    public TokenResult getTokenResult() {
        if (C0159a.m556a(this.f149d)) {
            this.f149d = DeviceSecuritySDK.getInstance(this.f148c).getSecurityToken();
        }
        TokenResult tokenResult = new TokenResult(this);
        try {
            tokenResult.apdid = C0052a.m139b(this.f148c);
            tokenResult.apdidToken = C0052a.m134a(this.f148c);
            tokenResult.umidToken = this.f149d;
            tokenResult.clientKey = C0070b.m185a(this.f148c);
        } catch (Throwable th) {
        }
        return tokenResult;
    }

    public void initToken(int i, Map<String, String> map, InitResultListener initResultListener) {
        this.f153h.addLast(new RunningTask(this, i, C0159a.m555a(map, C0109b.f281g, bi_常量类.f6358b), C0159a.m555a(map, C0109b.f277c, bi_常量类.f6358b), C0159a.m555a(map, "userId", bi_常量类.f6358b), initResultListener));
        if (this.f152g == null) {
            this.f152g = new Thread(new C00711(this));
            this.f152g.setUncaughtExceptionHandler(new C00722(this));
            this.f152g.start();
        }
    }
}
