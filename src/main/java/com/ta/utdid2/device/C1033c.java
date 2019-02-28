package com.ta.utdid2.device;

import android.content.Context;
import android.provider.Settings.System;
import com.ta.utdid2.p037b.p038a.C1014b;
import com.ta.utdid2.p037b.p038a.C1016d;
import com.ta.utdid2.p037b.p038a.C1018f;
import com.ta.utdid2.p037b.p038a.C1020h;
import com.ta.utdid2.p039c.p040a.C1026c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: UTUtdid */
/* renamed from: com.ta.utdid2.device.c */
public final class C1033c {
    /* renamed from: b */
    private static final Object f4749b = new Object();
    /* renamed from: c */
    private static C1033c f4750c = null;
    /* renamed from: j */
    private static final String f4751j = (".UTSystemConfig" + File.separator + "Global");
    /* renamed from: a */
    private Context f4752a = null;
    /* renamed from: d */
    private String f4753d = null;
    /* renamed from: e */
    private C1034d f4754e = null;
    /* renamed from: f */
    private String f4755f = "xx_utdid_key";
    /* renamed from: g */
    private String f4756g = "xx_utdid_domain";
    /* renamed from: h */
    private C1026c f4757h = null;
    /* renamed from: i */
    private C1026c f4758i = null;
    /* renamed from: k */
    private Pattern f4759k = Pattern.compile("[^0-9a-zA-Z=/+]+");

    private C1033c(Context context) {
        this.f4752a = context;
        this.f4758i = new C1026c(context, f4751j, "Alvin2");
        this.f4757h = new C1026c(context, ".DataStorage", "ContextData");
        this.f4754e = new C1034d();
        this.f4755f = String.format("K_%d", new Object[]{Integer.valueOf(C1020h.m7384b(this.f4755f))});
        this.f4756g = String.format("D_%d", new Object[]{Integer.valueOf(C1020h.m7384b(this.f4756g))});
    }

    /* renamed from: a */
    public static C1033c m7459a(Context context) {
        if (context != null && f4750c == null) {
            synchronized (f4749b) {
                if (f4750c == null) {
                    C1033c c1033c = new C1033c(context);
                    f4750c = c1033c;
                    if (c1033c.f4758i != null && C1020h.m7383a(c1033c.f4758i.m7409a("UTDID2"))) {
                        String a = c1033c.f4758i.m7409a("UTDID");
                        if (!C1020h.m7383a(a)) {
                            c1033c.m7460a(a);
                        }
                    }
                }
            }
        }
        return f4750c;
    }

    /* renamed from: a */
    private void m7460a(String str) {
        if (m7465e(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && this.f4758i != null) {
                this.f4758i.m7410a("UTDID2", str);
                this.f4758i.m7410a("UTDID", str);
                this.f4758i.m7411a();
            }
        }
    }

    /* renamed from: b */
    private void m7461b(String str) {
        if (str != null && this.f4757h != null && !str.equals(this.f4757h.m7409a(this.f4755f))) {
            this.f4757h.m7410a(this.f4755f, str);
            this.f4757h.m7411a();
        }
    }

    /* renamed from: c */
    private void m7463c(String str) {
        if (this.f4752a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && m7465e(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !m7465e(System.getString(this.f4752a.getContentResolver(), "mqBRboGZkQPcAkyk"))) {
                System.putString(this.f4752a.getContentResolver(), "mqBRboGZkQPcAkyk", str);
            }
        }
    }

    /* renamed from: d */
    private void m7464d(String str) {
        if (this.f4752a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && str != null && !str.equals(System.getString(this.f4752a.getContentResolver(), "dxCRMxhQkdGePGnp"))) {
            System.putString(this.f4752a.getContentResolver(), "dxCRMxhQkdGePGnp", str);
        }
    }

    /* renamed from: e */
    private boolean m7465e(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 != str.length() || this.f4759k.matcher(str).find()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final synchronized java.lang.String m7466a() {
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = r6.f4753d;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x000a;
    L_0x0006:
        r0 = r6.f4753d;	 Catch:{ all -> 0x0044 }
    L_0x0008:
        monitor-exit(r6);
        return r0;
    L_0x000a:
        r2 = "";
        r0 = r6.f4752a;	 Catch:{ Exception -> 0x0047 }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x0047 }
        r3 = "mqBRboGZkQPcAkyk";
        r0 = android.provider.Settings.System.getString(r0, r3);	 Catch:{ Exception -> 0x0047 }
    L_0x0018:
        r2 = r6.m7465e(r0);	 Catch:{ all -> 0x0044 }
        if (r2 != 0) goto L_0x0008;
    L_0x001e:
        r4 = new com.ta.utdid2.device.e;	 Catch:{ all -> 0x0044 }
        r4.<init>();	 Catch:{ all -> 0x0044 }
        r2 = 0;
        r0 = r6.f4752a;	 Catch:{ all -> 0x0044 }
        r0 = r0.getContentResolver();	 Catch:{ all -> 0x0044 }
        r3 = "dxCRMxhQkdGePGnp";
        r3 = android.provider.Settings.System.getString(r0, r3);	 Catch:{ all -> 0x0044 }
        r0 = com.ta.utdid2.p037b.p038a.C1020h.m7383a(r3);	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x008f;
    L_0x0036:
        r0 = r4.m7471b(r3);	 Catch:{ all -> 0x0044 }
        r5 = r6.m7465e(r0);	 Catch:{ all -> 0x0044 }
        if (r5 == 0) goto L_0x004d;
    L_0x0040:
        r6.m7463c(r0);	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0047:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0044 }
        r0 = r2;
        goto L_0x0018;
    L_0x004d:
        r0 = r4.m7470a(r3);	 Catch:{ all -> 0x0044 }
        r5 = r6.m7465e(r0);	 Catch:{ all -> 0x0044 }
        if (r5 == 0) goto L_0x0135;
    L_0x0057:
        r5 = r6.f4754e;	 Catch:{ all -> 0x0044 }
        r0 = r5.m7467a(r0);	 Catch:{ all -> 0x0044 }
        r5 = com.ta.utdid2.p037b.p038a.C1020h.m7383a(r0);	 Catch:{ all -> 0x0044 }
        if (r5 != 0) goto L_0x0135;
    L_0x0063:
        r6.m7464d(r0);	 Catch:{ all -> 0x0044 }
        r0 = r6.f4752a;	 Catch:{ all -> 0x0044 }
        r0 = r0.getContentResolver();	 Catch:{ all -> 0x0044 }
        r3 = "dxCRMxhQkdGePGnp";
        r0 = android.provider.Settings.System.getString(r0, r3);	 Catch:{ all -> 0x0044 }
    L_0x0072:
        r3 = r6.f4754e;	 Catch:{ all -> 0x0044 }
        r3 = r3.m7469b(r0);	 Catch:{ all -> 0x0044 }
        r5 = r6.m7465e(r3);	 Catch:{ all -> 0x0044 }
        if (r5 == 0) goto L_0x0091;
    L_0x007e:
        r6.f4753d = r3;	 Catch:{ all -> 0x0044 }
        r6.m7460a(r3);	 Catch:{ all -> 0x0044 }
        r6.m7461b(r0);	 Catch:{ all -> 0x0044 }
        r0 = r6.f4753d;	 Catch:{ all -> 0x0044 }
        r6.m7463c(r0);	 Catch:{ all -> 0x0044 }
        r0 = r6.f4753d;	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x008f:
        r0 = 1;
        r2 = r0;
    L_0x0091:
        r0 = r6.f4758i;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x00c6;
    L_0x0095:
        r0 = r6.f4758i;	 Catch:{ all -> 0x0044 }
        r3 = "UTDID2";
        r0 = r0.m7409a(r3);	 Catch:{ all -> 0x0044 }
        r3 = com.ta.utdid2.p037b.p038a.C1020h.m7383a(r0);	 Catch:{ all -> 0x0044 }
        if (r3 != 0) goto L_0x00c6;
    L_0x00a3:
        r3 = r6.f4754e;	 Catch:{ all -> 0x0044 }
        r3 = r3.m7467a(r0);	 Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x00c6;
    L_0x00ab:
        r3 = r6.m7465e(r0);	 Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x00c8;
    L_0x00b1:
        r1 = r6.f4754e;	 Catch:{ all -> 0x0044 }
        r1 = r1.m7467a(r0);	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x00bc;
    L_0x00b9:
        r6.m7464d(r1);	 Catch:{ all -> 0x0044 }
    L_0x00bc:
        r6.m7463c(r0);	 Catch:{ all -> 0x0044 }
        r6.m7461b(r1);	 Catch:{ all -> 0x0044 }
        r6.f4753d = r0;	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x00c6:
        r0 = r1;
        goto L_0x00ab;
    L_0x00c8:
        r0 = r6.f4757h;	 Catch:{ all -> 0x0044 }
        r3 = r6.f4755f;	 Catch:{ all -> 0x0044 }
        r3 = r0.m7409a(r3);	 Catch:{ all -> 0x0044 }
        r0 = com.ta.utdid2.p037b.p038a.C1020h.m7383a(r3);	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0108;
    L_0x00d6:
        r0 = r4.m7470a(r3);	 Catch:{ all -> 0x0044 }
        r4 = r6.m7465e(r0);	 Catch:{ all -> 0x0044 }
        if (r4 != 0) goto L_0x00e6;
    L_0x00e0:
        r0 = r6.f4754e;	 Catch:{ all -> 0x0044 }
        r0 = r0.m7469b(r3);	 Catch:{ all -> 0x0044 }
    L_0x00e6:
        r3 = r6.m7465e(r0);	 Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x0108;
    L_0x00ec:
        r3 = r6.f4754e;	 Catch:{ all -> 0x0044 }
        r3 = r3.m7467a(r0);	 Catch:{ all -> 0x0044 }
        r4 = com.ta.utdid2.p037b.p038a.C1020h.m7383a(r0);	 Catch:{ all -> 0x0044 }
        if (r4 != 0) goto L_0x0108;
    L_0x00f8:
        r6.f4753d = r0;	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x00ff;
    L_0x00fc:
        r6.m7464d(r3);	 Catch:{ all -> 0x0044 }
    L_0x00ff:
        r0 = r6.f4753d;	 Catch:{ all -> 0x0044 }
        r6.m7460a(r0);	 Catch:{ all -> 0x0044 }
        r0 = r6.f4753d;	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x0108:
        r0 = r6.m7462b();	 Catch:{ Exception -> 0x012e }
        if (r0 == 0) goto L_0x0132;
    L_0x010e:
        r3 = 2;
        r3 = com.ta.utdid2.p037b.p038a.C1014b.m7372a(r0, r3);	 Catch:{ Exception -> 0x012e }
        r6.f4753d = r3;	 Catch:{ Exception -> 0x012e }
        r3 = r6.f4753d;	 Catch:{ Exception -> 0x012e }
        r6.m7460a(r3);	 Catch:{ Exception -> 0x012e }
        r3 = r6.f4754e;	 Catch:{ Exception -> 0x012e }
        r0 = r3.m7468a(r0);	 Catch:{ Exception -> 0x012e }
        if (r0 == 0) goto L_0x012a;
    L_0x0122:
        if (r2 == 0) goto L_0x0127;
    L_0x0124:
        r6.m7464d(r0);	 Catch:{ Exception -> 0x012e }
    L_0x0127:
        r6.m7461b(r0);	 Catch:{ Exception -> 0x012e }
    L_0x012a:
        r0 = r6.f4753d;	 Catch:{ Exception -> 0x012e }
        goto L_0x0008;
    L_0x012e:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0044 }
    L_0x0132:
        r0 = r1;
        goto L_0x0008;
    L_0x0135:
        r0 = r3;
        goto L_0x0072;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.device.c.a():java.lang.String");
    }

    /* renamed from: b */
    private final byte[] m7462b() throws Exception {
        String a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a2 = C1016d.m7375a(currentTimeMillis);
        byte[] a3 = C1016d.m7375a(nextInt);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(a3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            a = C1018f.m7380a(this.f4752a);
        } catch (Exception e) {
            a = new Random().nextInt();
        }
        byteArrayOutputStream.write(C1016d.m7375a(C1020h.m7384b(a)), 0, 4);
        a2 = byteArrayOutputStream.toByteArray();
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), instance.getAlgorithm()));
        byteArrayOutputStream.write(C1016d.m7375a(C1020h.m7384b(C1014b.m7372a(instance.doFinal(a2), 2))));
        return byteArrayOutputStream.toByteArray();
    }
}
