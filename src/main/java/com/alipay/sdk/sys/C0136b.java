package com.alipay.sdk.sys;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.C0114d;
import com.ta.utdid2.device.UTDevice;
import java.io.File;
import java.util.Random;

/* renamed from: com.alipay.sdk.sys.b */
public final class C0136b {
    /* renamed from: c */
    private static C0136b f413c;
    /* renamed from: a */
    public Context f414a;
    /* renamed from: b */
    public C0114d f415b;

    private C0136b() {
    }

    /* renamed from: a */
    public static C0136b m459a() {
        if (f413c == null) {
            f413c = new C0136b();
        }
        return f413c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static java.lang.String m460a(java.lang.String[] r6) {
        /*
        r2 = "";
        r0 = 0;
        r1 = new java.lang.ProcessBuilder;	 Catch:{ Exception -> 0x0035, all -> 0x003e }
        r1.<init>(r6);	 Catch:{ Exception -> 0x0035, all -> 0x003e }
        r3 = 0;
        r1.redirectErrorStream(r3);	 Catch:{ Exception -> 0x0035, all -> 0x003e }
        r1 = r1.start();	 Catch:{ Exception -> 0x0035, all -> 0x003e }
        r3 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x004c, all -> 0x004a }
        r0 = r1.getOutputStream();	 Catch:{ Exception -> 0x004c, all -> 0x004a }
        r3.<init>(r0);	 Catch:{ Exception -> 0x004c, all -> 0x004a }
        r0 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x004c, all -> 0x004a }
        r4 = r1.getInputStream();	 Catch:{ Exception -> 0x004c, all -> 0x004a }
        r0.<init>(r4);	 Catch:{ Exception -> 0x004c, all -> 0x004a }
        r0 = r0.readLine();	 Catch:{ Exception -> 0x004c, all -> 0x004a }
        r2 = "exit\n";
        r3.writeBytes(r2);	 Catch:{ Exception -> 0x004f, all -> 0x004a }
        r3.flush();	 Catch:{ Exception -> 0x004f, all -> 0x004a }
        r1.waitFor();	 Catch:{ Exception -> 0x004f, all -> 0x004a }
        r1.destroy();	 Catch:{ Exception -> 0x0046 }
    L_0x0034:
        return r0;
    L_0x0035:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0038:
        r1.destroy();	 Catch:{ Exception -> 0x003c }
        goto L_0x0034;
    L_0x003c:
        r1 = move-exception;
        goto L_0x0034;
    L_0x003e:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x0042:
        r1.destroy();	 Catch:{ Exception -> 0x0048 }
    L_0x0045:
        throw r0;
    L_0x0046:
        r1 = move-exception;
        goto L_0x0034;
    L_0x0048:
        r1 = move-exception;
        goto L_0x0045;
    L_0x004a:
        r0 = move-exception;
        goto L_0x0042;
    L_0x004c:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0038;
    L_0x004f:
        r2 = move-exception;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.sys.b.a(java.lang.String[]):java.lang.String");
    }

    /* renamed from: b */
    public static boolean m461b() {
        String[] strArr = new String[]{"/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < strArr.length) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    String a = C0136b.m460a(new String[]{"ls", "-l", strArr[i] + "su"});
                    return (TextUtils.isEmpty(a) || a.indexOf("root") == a.lastIndexOf("root")) ? false : true;
                } else {
                    i++;
                }
            } catch (Exception e) {
            }
        }
        return false;
    }

    /* renamed from: c */
    private Context m462c() {
        return this.f414a;
    }

    /* renamed from: d */
    private C0114d m463d() {
        return this.f415b;
    }

    /* renamed from: e */
    private static String m464e() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 65.0d))));
                    break;
                case 1:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 97.0d))));
                    break;
                case 2:
                    stringBuilder.append(String.valueOf(new Random().nextInt(10)));
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: f */
    private String m465f() {
        return UTDevice.getUtdid(this.f414a);
    }

    /* renamed from: a */
    public final void m466a(Context context, C0114d c0114d) {
        this.f414a = context.getApplicationContext();
        this.f415b = c0114d;
    }
}
