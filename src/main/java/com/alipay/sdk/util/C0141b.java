package com.alipay.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

/* renamed from: com.alipay.sdk.util.b */
public final class C0141b {
    /* renamed from: a */
    private static final String f424a = "00:00:00:00:00:00";
    /* renamed from: e */
    private static C0141b f425e = null;
    /* renamed from: b */
    private String f426b;
    /* renamed from: c */
    private String f427c;
    /* renamed from: d */
    private String f428d;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C0141b(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0052 in list [B:8:0x004e]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r3.<init>();
        r0 = "phone";	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r4.getSystemService(r0);	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r1 = r0.getDeviceId();	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r3.m494b(r1);	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r0.getSubscriberId();	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        if (r0 == 0) goto L_0x0032;	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
    L_0x0018:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r1.<init>();	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r1.append(r0);	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r1 = "000000000000000";	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r1 = 0;	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r2 = 15;	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r0.substring(r1, r2);	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
    L_0x0032:
        r3.f426b = r0;	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = "wifi";	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r4.getSystemService(r0);	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r0.getConnectionInfo();	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r0.getMacAddress();	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r3.f428d = r0;	 Catch:{ Exception -> 0x0053, all -> 0x0061 }
        r0 = r3.f428d;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0052;
    L_0x004e:
        r0 = "00:00:00:00:00:00";
        r3.f428d = r0;
    L_0x0052:
        return;
    L_0x0053:
        r0 = move-exception;
        r0 = r3.f428d;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0052;
    L_0x005c:
        r0 = "00:00:00:00:00:00";
        r3.f428d = r0;
        goto L_0x0052;
    L_0x0061:
        r0 = move-exception;
        r1 = r3.f428d;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x006e;
    L_0x006a:
        r1 = "00:00:00:00:00:00";
        r3.f428d = r1;
    L_0x006e:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.b.<init>(android.content.Context):void");
    }

    /* renamed from: a */
    public static C0141b m491a(Context context) {
        if (f425e == null) {
            f425e = new C0141b(context);
        }
        return f425e;
    }

    /* renamed from: a */
    private void m492a(String str) {
        if (str != null) {
            str = (str + "000000000000000").substring(0, 15);
        }
        this.f426b = str;
    }

    /* renamed from: b */
    public static C0146g m493b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) ? (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) ? C0146g.NONE : C0146g.WIFI : C0146g.m512a(activeNetworkInfo.getSubtype());
        } catch (Exception e) {
            return C0146g.NONE;
        }
    }

    /* renamed from: b */
    private void m494b(String str) {
        if (str != null) {
            byte[] bytes = str.getBytes();
            int i = 0;
            while (i < bytes.length) {
                if (bytes[i] < (byte) 48 || bytes[i] > (byte) 57) {
                    bytes[i] = (byte) 48;
                }
                i++;
            }
            str = (new String(bytes) + "000000000000000").substring(0, 15);
        }
        this.f427c = str;
    }

    /* renamed from: c */
    public static String m495c(Context context) {
        C0141b a = C0141b.m491a(context);
        String str = a.m498b() + "|";
        Object a2 = a.m497a();
        return (TextUtils.isEmpty(a2) ? str + "000000000000000" : str + a2).substring(0, 8);
    }

    /* renamed from: d */
    private String m496d() {
        String str = m498b() + "|";
        Object a = m497a();
        return TextUtils.isEmpty(a) ? str + "000000000000000" : str + a;
    }

    /* renamed from: a */
    public final String m497a() {
        if (TextUtils.isEmpty(this.f426b)) {
            this.f426b = "000000000000000";
        }
        return this.f426b;
    }

    /* renamed from: b */
    public final String m498b() {
        if (TextUtils.isEmpty(this.f427c)) {
            this.f427c = "000000000000000";
        }
        return this.f427c;
    }

    /* renamed from: c */
    public final String m499c() {
        return this.f428d;
    }
}
