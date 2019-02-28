package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.provider.Settings.System;
import android.util.Log;
import com.iflytek.cloud.speech.SpeechEvent;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.C1146j;
import com.tencent.smtt.utils.C1164z;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p054u.aly.bi_常量类;

class ac {
    /* renamed from: b */
    private static ac f4949b = null;
    /* renamed from: c */
    private static final Lock f4950c = new ReentrantLock();
    /* renamed from: d */
    private static final Lock f4951d = new ReentrantLock();
    /* renamed from: e */
    private static Handler f4952e = null;
    /* renamed from: f */
    private static final Long[][] f4953f;
    /* renamed from: g */
    private static boolean f4954g = false;
    /* renamed from: a */
    int f4955a = 0;

    static {
        r0 = new Long[7][];
        r0[0] = new Long[]{Long.valueOf(25413), Long.valueOf(11460320)};
        r0[1] = new Long[]{Long.valueOf(25436), Long.valueOf(12009376)};
        r0[2] = new Long[]{Long.valueOf(25437), Long.valueOf(11489180)};
        r0[3] = new Long[]{Long.valueOf(25438), Long.valueOf(11489180)};
        r0[4] = new Long[]{Long.valueOf(25439), Long.valueOf(12013472)};
        r0[5] = new Long[]{Long.valueOf(25440), Long.valueOf(11489180)};
        r0[6] = new Long[]{Long.valueOf(25442), Long.valueOf(11489180)};
        f4953f = r0;
    }

    private ac() {
        if (f4952e == null) {
            f4952e = new ad(this, ab.m7705a().getLooper());
        }
    }

    /* renamed from: a */
    static ac m7706a() {
        if (f4949b == null) {
            f4949b = new ac();
        }
        return f4949b;
    }

    /* renamed from: a */
    static FileLock m7707a(Context context, FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            return tryLock.isValid() ? tryLock : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m7708a(int i, String str, Context context) {
        new File(str).delete();
        TbsLog.m7928i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        if (file != null && file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            try {
                properties.load(new FileInputStream(file2));
                OutputStream fileOutputStream = new FileOutputStream(file2);
                properties.setProperty("tbs_local_installation", "true");
                properties.store(fileOutputStream, null);
                TbsLog.m7928i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    /* renamed from: a */
    private void m7709a(android.content.Context r13, android.content.Context r14, int r15) {
        /*
        r12 = this;
        r0 = r12.m7743b(r14);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread start!";
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0043;
    L_0x0014:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 4;
        r0 = r14.getSharedPreferences(r0, r1);
    L_0x001b:
        r1 = "tbs_precheck_disable_version";
        r2 = -1;
        r0 = r0.getInt(r1, r2);
        if (r0 != r15) goto L_0x004b;
    L_0x0024:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "TbsInstaller-copyTbsCoreInThread -- version:";
        r1 = r1.append(r2);
        r1 = r1.append(r15);
        r2 = " is disabled by preload_x5_check!";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.m7925e(r0, r1);
        goto L_0x0006;
    L_0x0043:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 0;
        r0 = r14.getSharedPreferences(r0, r1);
        goto L_0x001b;
    L_0x004b:
        r6 = m7723k(r14);
        if (r6 == 0) goto L_0x0006;
    L_0x0051:
        r7 = m7707a(r14, r6);
        if (r7 == 0) goto L_0x0006;
    L_0x0057:
        r0 = f4951d;
        r0 = r0.tryLock();
        if (r0 == 0) goto L_0x0400;
    L_0x005f:
        r0 = f4950c;
        r0.lock();
        r0 = com.tencent.smtt.sdk.C1131y.m7904a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = r0.m7906a();	 Catch:{ Exception -> 0x0251 }
        r0 = com.tencent.smtt.sdk.C1131y.m7904a(r14);	 Catch:{ Exception -> 0x0251 }
        r0 = r0.m7910b();	 Catch:{ Exception -> 0x0251 }
        if (r1 != r15) goto L_0x0084;
    L_0x0076:
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
    L_0x0080:
        m7712a(r7, r6);
        goto L_0x0006;
    L_0x0084:
        r2 = r12.m7744c(r14);	 Catch:{ Exception -> 0x0251 }
        r3 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0251 }
        r4.<init>();	 Catch:{ Exception -> 0x0251 }
        r5 = "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0251 }
        r4 = r4.append(r2);	 Catch:{ Exception -> 0x0251 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0251 }
        com.tencent.smtt.utils.TbsLog.m7927i(r3, r4);	 Catch:{ Exception -> 0x0251 }
        if (r2 != r15) goto L_0x00ad;
    L_0x00a2:
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
        goto L_0x0080;
    L_0x00ad:
        r3 = com.tencent.smtt.sdk.C1131y.m7904a(r14);	 Catch:{ Exception -> 0x0251 }
        r3 = r3.m7920h();	 Catch:{ Exception -> 0x0251 }
        if (r3 <= 0) goto L_0x00b9;
    L_0x00b7:
        if (r15 > r3) goto L_0x00bd;
    L_0x00b9:
        if (r1 <= 0) goto L_0x00c0;
    L_0x00bb:
        if (r15 <= r1) goto L_0x00c0;
    L_0x00bd:
        r12.m7732t(r14);	 Catch:{ Exception -> 0x0251 }
    L_0x00c0:
        r1 = 3;
        if (r0 != r1) goto L_0x00d8;
    L_0x00c3:
        if (r2 <= 0) goto L_0x00d8;
    L_0x00c5:
        if (r15 > r2) goto L_0x00cc;
    L_0x00c7:
        r1 = 88888888; // 0x54c5638 float:9.60787E-36 double:4.3916946E-316;
        if (r15 != r1) goto L_0x00d8;
    L_0x00cc:
        r0 = -1;
        r12.m7732t(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-copyTbsCoreInThread -- update TBS.....";
        r3 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r1, r2, r3);	 Catch:{ Exception -> 0x0251 }
    L_0x00d8:
        r1 = com.tencent.smtt.utils.C1164z.m8080a();	 Catch:{ Exception -> 0x0251 }
        r3 = 3;
        r5 = r12.m7747f(r13);	 Catch:{ Exception -> 0x0251 }
        r8 = com.tencent.smtt.utils.C1164z.m8081a(r5);	 Catch:{ Exception -> 0x0251 }
        r3 = r3 * r8;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 >= 0) goto L_0x012c;
    L_0x00eb:
        r0 = com.tencent.smtt.utils.C1164z.m8080a();	 Catch:{ Exception -> 0x0251 }
        r2 = 3;
        r4 = r12.m7747f(r13);	 Catch:{ Exception -> 0x0251 }
        r4 = com.tencent.smtt.utils.C1164z.m8081a(r4);	 Catch:{ Exception -> 0x0251 }
        r2 = r2 * r4;
        r4 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ Exception -> 0x0251 }
        r5 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0251 }
        r8.<init>();	 Catch:{ Exception -> 0x0251 }
        r9 = "rom is not enough when copying tbs core! curAvailROM=";
        r8 = r8.append(r9);	 Catch:{ Exception -> 0x0251 }
        r0 = r8.append(r0);	 Catch:{ Exception -> 0x0251 }
        r1 = ",minReqRom=";
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x0251 }
        r0 = r0.append(r2);	 Catch:{ Exception -> 0x0251 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0251 }
        r4.m7601a(r5, r0);	 Catch:{ Exception -> 0x0251 }
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
        goto L_0x0080;
    L_0x012c:
        if (r0 <= 0) goto L_0x013a;
    L_0x012e:
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
        goto L_0x0080;
    L_0x013a:
        if (r0 != 0) goto L_0x0168;
    L_0x013c:
        r0 = com.tencent.smtt.sdk.C1131y.m7904a(r14);	 Catch:{ Exception -> 0x0251 }
        r0 = r0.m7913c();	 Catch:{ Exception -> 0x0251 }
        r1 = 10;
        if (r0 <= r1) goto L_0x015f;
    L_0x0148:
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 211; // 0xd3 float:2.96E-43 double:1.042E-321;
        r2 = "exceed copy retry num!";
        r0.m7601a(r1, r2);	 Catch:{ Exception -> 0x0251 }
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
        goto L_0x0080;
    L_0x015f:
        r1 = com.tencent.smtt.sdk.C1131y.m7904a(r14);	 Catch:{ Exception -> 0x0251 }
        r0 = r0 + 1;
        r1.m7907a(r0);	 Catch:{ Exception -> 0x0251 }
    L_0x0168:
        r0 = r12.m7747f(r13);	 Catch:{ Exception -> 0x0251 }
        r8 = r12.m7750j(r14);	 Catch:{ Exception -> 0x0251 }
        if (r0 == 0) goto L_0x03e5;
    L_0x0172:
        if (r8 == 0) goto L_0x03e5;
    L_0x0174:
        r1 = 1;
        com.tencent.smtt.sdk.QbSdk.setTBSInstallingStatus(r1);	 Catch:{ Exception -> 0x0251 }
        r1 = com.tencent.smtt.sdk.C1131y.m7904a(r14);	 Catch:{ Exception -> 0x0251 }
        r2 = 0;
        r1.m7908a(r15, r2);	 Catch:{ Exception -> 0x0251 }
        r1 = new com.tencent.smtt.utils.y;	 Catch:{ Exception -> 0x0251 }
        r1.<init>();	 Catch:{ Exception -> 0x0251 }
        r1.m8077a(r0);	 Catch:{ Exception -> 0x0251 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0251 }
        r4 = com.tencent.smtt.utils.C1146j.m7990b(r0, r8);	 Catch:{ Exception -> 0x0251 }
        r5 = "TbsInstaller";
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0251 }
        r9.<init>();	 Catch:{ Exception -> 0x0251 }
        r10 = "TbsInstaller-copyTbsCoreInThread time=";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x0251 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0251 }
        r2 = r10 - r2;
        r2 = r9.append(r2);	 Catch:{ Exception -> 0x0251 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0251 }
        com.tencent.smtt.utils.TbsLog.m7927i(r5, r2);	 Catch:{ Exception -> 0x0251 }
        if (r4 == 0) goto L_0x03c6;
    L_0x01b0:
        r1.m8079b(r0);	 Catch:{ Exception -> 0x0251 }
        r0 = r1.m8078a();	 Catch:{ Exception -> 0x0251 }
        if (r0 != 0) goto L_0x01db;
    L_0x01b9:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread copy-verify fail!";
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);	 Catch:{ Exception -> 0x0251 }
        r0 = 1;
        com.tencent.smtt.utils.C1146j.m7977a(r8, r0);	 Catch:{ Exception -> 0x0251 }
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "TbsCopy-Verify fail after copying tbs core!";
        r0.m7601a(r1, r2);	 Catch:{ Exception -> 0x0251 }
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
        goto L_0x0080;
    L_0x01db:
        r4 = 1;
        r5 = 1;
        r3 = 0;
        r2 = 0;
        r0 = new java.io.File;	 Catch:{ Exception -> 0x023d, all -> 0x024a }
        r1 = "1";
        r0.<init>(r8, r1);	 Catch:{ Exception -> 0x023d, all -> 0x024a }
        r1 = new java.util.Properties;	 Catch:{ Exception -> 0x023d, all -> 0x024a }
        r1.<init>();	 Catch:{ Exception -> 0x023d, all -> 0x024a }
        if (r0 == 0) goto L_0x023a;
    L_0x01ed:
        r2 = r0.exists();	 Catch:{ Exception -> 0x041b, all -> 0x024a }
        if (r2 == 0) goto L_0x023a;
    L_0x01f3:
        if (r1 == 0) goto L_0x023a;
    L_0x01f5:
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x041b, all -> 0x024a }
        r2.<init>(r0);	 Catch:{ Exception -> 0x041b, all -> 0x024a }
        r1.load(r2);	 Catch:{ Exception -> 0x041f }
        r0 = r4;
    L_0x01fe:
        if (r2 == 0) goto L_0x0203;
    L_0x0200:
        r2.close();	 Catch:{ IOException -> 0x0411 }
    L_0x0203:
        r2 = r1;
        r4 = r0;
    L_0x0205:
        if (r4 == 0) goto L_0x0422;
    L_0x0207:
        r3 = r8.listFiles();	 Catch:{ Exception -> 0x0251 }
        r0 = 0;
        r1 = r0;
        r0 = r5;
    L_0x020e:
        r5 = r3.length;	 Catch:{ Exception -> 0x0251 }
        if (r1 >= r5) goto L_0x02ce;
    L_0x0211:
        r5 = r3[r1];	 Catch:{ Exception -> 0x0251 }
        r9 = "1";
        r10 = r5.getName();	 Catch:{ Exception -> 0x0251 }
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x0251 }
        if (r9 != 0) goto L_0x0237;
    L_0x021f:
        r9 = r5.getName();	 Catch:{ Exception -> 0x0251 }
        r10 = ".dex";
        r9 = r9.endsWith(r10);	 Catch:{ Exception -> 0x0251 }
        if (r9 != 0) goto L_0x0237;
    L_0x022b:
        r9 = "tbs.conf";
        r10 = r5.getName();	 Catch:{ Exception -> 0x0251 }
        r9 = r9.equals(r10);	 Catch:{ Exception -> 0x0251 }
        if (r9 == 0) goto L_0x026b;
    L_0x0237:
        r1 = r1 + 1;
        goto L_0x020e;
    L_0x023a:
        r0 = 0;
        r2 = r3;
        goto L_0x01fe;
    L_0x023d:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
    L_0x0240:
        r0.printStackTrace();	 Catch:{ all -> 0x0417 }
        if (r2 == 0) goto L_0x0248;
    L_0x0245:
        r2.close();	 Catch:{ IOException -> 0x040b }
    L_0x0248:
        r2 = r1;
        goto L_0x0205;
    L_0x024a:
        r0 = move-exception;
    L_0x024b:
        if (r3 == 0) goto L_0x0250;
    L_0x024d:
        r3.close();	 Catch:{ IOException -> 0x0405 }
    L_0x0250:
        throw r0;	 Catch:{ Exception -> 0x0251 }
    L_0x0251:
        r0 = move-exception;
        r1 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ all -> 0x03b7 }
        r2 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
        r0 = r0.toString();	 Catch:{ all -> 0x03b7 }
        r1.m7601a(r2, r0);	 Catch:{ all -> 0x03b7 }
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
        goto L_0x0080;
    L_0x026b:
        r0 = com.tencent.smtt.utils.C1134a.m7941a(r5);	 Catch:{ Exception -> 0x0251 }
        r9 = r5.getName();	 Catch:{ Exception -> 0x0251 }
        r10 = "";
        r9 = r2.getProperty(r9, r10);	 Catch:{ Exception -> 0x0251 }
        r10 = "";
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x0251 }
        if (r10 != 0) goto L_0x02ab;
    L_0x0281:
        r0 = r0.equals(r9);	 Catch:{ Exception -> 0x0251 }
        if (r0 == 0) goto L_0x02ab;
    L_0x0287:
        r0 = "TbsInstaller";
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0251 }
        r9.<init>();	 Catch:{ Exception -> 0x0251 }
        r10 = "md5_check_success for (";
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x0251 }
        r5 = r5.getName();	 Catch:{ Exception -> 0x0251 }
        r5 = r9.append(r5);	 Catch:{ Exception -> 0x0251 }
        r9 = ")";
        r5 = r5.append(r9);	 Catch:{ Exception -> 0x0251 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0251 }
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r5);	 Catch:{ Exception -> 0x0251 }
        r0 = 1;
        goto L_0x0237;
    L_0x02ab:
        r0 = 0;
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0251 }
        r2.<init>();	 Catch:{ Exception -> 0x0251 }
        r3 = "md5_check_failure for (";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0251 }
        r3 = r5.getName();	 Catch:{ Exception -> 0x0251 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0251 }
        r3 = ")";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0251 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0251 }
        com.tencent.smtt.utils.TbsLog.m7925e(r1, r2);	 Catch:{ Exception -> 0x0251 }
    L_0x02ce:
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0251 }
        r2.<init>();	 Catch:{ Exception -> 0x0251 }
        r3 = "copyTbsCoreInThread - md5_check_success:";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0251 }
        r2 = r2.append(r0);	 Catch:{ Exception -> 0x0251 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0251 }
        com.tencent.smtt.utils.TbsLog.m7927i(r1, r2);	 Catch:{ Exception -> 0x0251 }
        if (r4 == 0) goto L_0x030c;
    L_0x02e8:
        if (r0 != 0) goto L_0x030c;
    L_0x02ea:
        r0 = "TbsInstaller";
        r1 = "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!";
        com.tencent.smtt.utils.TbsLog.m7925e(r0, r1);	 Catch:{ Exception -> 0x0251 }
        r0 = 1;
        com.tencent.smtt.utils.C1146j.m7977a(r8, r0);	 Catch:{ Exception -> 0x0251 }
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "TbsCopy-Verify md5 fail after copying tbs core!";
        r0.m7601a(r1, r2);	 Catch:{ Exception -> 0x0251 }
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
        goto L_0x0080;
    L_0x030c:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread success!";
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);	 Catch:{ Exception -> 0x0251 }
        r1 = com.tencent.smtt.sdk.C1129w.m7873a(r13);	 Catch:{ Exception -> 0x0251 }
        if (r1 == 0) goto L_0x032f;
    L_0x0319:
        r0 = r1.exists();	 Catch:{ Exception -> 0x0251 }
        if (r0 == 0) goto L_0x032f;
    L_0x031f:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0251 }
        r0 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r14);	 Catch:{ Exception -> 0x0251 }
        if (r0 == 0) goto L_0x038e;
    L_0x0327:
        r0 = "x5.oversea.tbs.org";
    L_0x0329:
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x0251 }
        com.tencent.smtt.sdk.C1129w.m7879a(r2, r14);	 Catch:{ Exception -> 0x0251 }
    L_0x032f:
        r0 = com.tencent.smtt.sdk.C1131y.m7904a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 1;
        r0.m7908a(r15, r1);	 Catch:{ Exception -> 0x0251 }
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r2 = "success";
        r0.m7601a(r1, r2);	 Catch:{ Exception -> 0x0251 }
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0251 }
        r1.<init>();	 Catch:{ Exception -> 0x0251 }
        r2 = "TbsInstaller-copyTbsCoreInThread success -- version:";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0251 }
        r1 = r1.append(r15);	 Catch:{ Exception -> 0x0251 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0251 }
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);	 Catch:{ Exception -> 0x0251 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0251 }
        r1 = 11;
        if (r0 < r1) goto L_0x0391;
    L_0x0360:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 4;
        r0 = r14.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x0251 }
    L_0x0367:
        r0 = r0.edit();	 Catch:{ Throwable -> 0x0399 }
        r1 = "tbs_preload_x5_counter";
        r2 = 0;
        r0.putInt(r1, r2);	 Catch:{ Throwable -> 0x0399 }
        r1 = "tbs_preload_x5_recorder";
        r2 = 0;
        r0.putInt(r1, r2);	 Catch:{ Throwable -> 0x0399 }
        r1 = "tbs_preload_x5_version";
        r0.putInt(r1, r15);	 Catch:{ Throwable -> 0x0399 }
        r0.commit();	 Catch:{ Throwable -> 0x0399 }
    L_0x037f:
        com.tencent.smtt.utils.C1164z.m8083a(r14);	 Catch:{ Exception -> 0x0251 }
    L_0x0382:
        r0 = f4950c;
        r0.unlock();
        r0 = f4951d;
        r0.unlock();
        goto L_0x0080;
    L_0x038e:
        r0 = "x5.tbs.org";
        goto L_0x0329;
    L_0x0391:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 0;
        r0 = r14.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x0251 }
        goto L_0x0367;
    L_0x0399:
        r0 = move-exception;
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0251 }
        r2.<init>();	 Catch:{ Exception -> 0x0251 }
        r3 = "Init tbs_preload_x5_counter#2 exception:";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0251 }
        r0 = android.util.Log.getStackTraceString(r0);	 Catch:{ Exception -> 0x0251 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0251 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0251 }
        com.tencent.smtt.utils.TbsLog.m7925e(r1, r0);	 Catch:{ Exception -> 0x0251 }
        goto L_0x037f;
    L_0x03b7:
        r0 = move-exception;
        r1 = f4950c;
        r1.unlock();
        r1 = f4951d;
        r1.unlock();
        m7712a(r7, r6);
        throw r0;
    L_0x03c6:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread fail!";
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);	 Catch:{ Exception -> 0x0251 }
        r0 = com.tencent.smtt.sdk.C1131y.m7904a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 2;
        r0.m7908a(r15, r1);	 Catch:{ Exception -> 0x0251 }
        r0 = 0;
        com.tencent.smtt.utils.C1146j.m7977a(r8, r0);	 Catch:{ Exception -> 0x0251 }
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 212; // 0xd4 float:2.97E-43 double:1.047E-321;
        r2 = "copy fail!";
        r0.m7601a(r1, r2);	 Catch:{ Exception -> 0x0251 }
        goto L_0x0382;
    L_0x03e5:
        if (r0 != 0) goto L_0x03f2;
    L_0x03e7:
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "src-dir is null when copying tbs core!";
        r0.m7601a(r1, r2);	 Catch:{ Exception -> 0x0251 }
    L_0x03f2:
        if (r8 != 0) goto L_0x0382;
    L_0x03f4:
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r14);	 Catch:{ Exception -> 0x0251 }
        r1 = 214; // 0xd6 float:3.0E-43 double:1.057E-321;
        r2 = "dst-dir is null when copying tbs core!";
        r0.m7601a(r1, r2);	 Catch:{ Exception -> 0x0251 }
        goto L_0x0382;
    L_0x0400:
        m7712a(r7, r6);
        goto L_0x0006;
    L_0x0405:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Exception -> 0x0251 }
        goto L_0x0250;
    L_0x040b:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x0251 }
        goto L_0x0248;
    L_0x0411:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ Exception -> 0x0251 }
        goto L_0x0203;
    L_0x0417:
        r0 = move-exception;
        r3 = r2;
        goto L_0x024b;
    L_0x041b:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0240;
    L_0x041f:
        r0 = move-exception;
        goto L_0x0240;
    L_0x0422:
        r0 = r5;
        goto L_0x02ce;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ac.a(android.content.Context, android.content.Context, int):void");
    }

    /* renamed from: a */
    static void m7712a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private boolean m7713a(Context context, File file) {
        File file2;
        boolean z = true;
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-unzipTbs start");
        if (C1146j.m7995c(file)) {
            try {
                file2 = new File(context.getDir("tbs", 0), "core_unzip_tmp");
                if (file2 != null && file2.exists()) {
                    C1146j.m7988b(file2);
                }
            } catch (Throwable th) {
                TbsLog.m7925e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
            }
            file2 = m7749i(context);
            if (file2 == null) {
                TbsLogReport.m7589a(context).m7601a((int) ErrorCode.UNZIP_DIR_ERROR, "tmp unzip dir is null!");
                return false;
            }
            try {
                C1146j.m7978a(file2);
                boolean a = C1146j.m7979a(file, file2);
                if (!a) {
                    C1146j.m7988b(file2);
                    Log.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + file2.exists());
                }
                TbsLog.m7927i("TbsInstaller", "TbsInstaller-unzipTbs done");
                return a;
            } catch (IOException e) {
                TbsLogReport.m7589a(context).m7601a((int) ErrorCode.UNZIP_IO_ERROR, e.toString());
                if (file2 == null || !file2.exists()) {
                    z = false;
                }
                if (z && file2 != null) {
                    C1146j.m7988b(file2);
                    Log.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + file2.exists());
                }
            } catch (Exception e2) {
                TbsLogReport.m7589a(context).m7601a((int) ErrorCode.UNZIP_OTHER_ERROR, e2.toString());
                if (file2 == null || !file2.exists()) {
                    z = false;
                }
                if (z && file2 != null) {
                    C1146j.m7988b(file2);
                    Log.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + file2.exists());
                }
            } catch (Throwable th2) {
                Log.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th2));
            }
        } else {
            TbsLogReport.m7589a(context).m7601a((int) ErrorCode.APK_INVALID, "apk is invalid!");
            return false;
        }
        String str = "TbsInstaller";
        String str2 = "TbsInstaller-unzipTbs done";
        TbsLog.m7927i(str, str2);
        return false;
        str = "TbsInstaller";
        str2 = "TbsInstaller-unzipTbs done";
        TbsLog.m7927i(str, str2);
        return false;
    }

    /* renamed from: b */
    static File m7714b(Context context, String str) {
        File h = m7722h(context);
        if (h == null) {
            return null;
        }
        File file = new File(h, str);
        if (file != null && file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @TargetApi(11)
    /* renamed from: b */
    private void m7715b(Context context, String str, int i) {
        int i2 = -1;
        if (m7743b(context)) {
            TbsLog.m7928i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            return;
        }
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i);
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if ((VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.m7925e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            return;
        }
        String string;
        String str2 = WebView.TBS_DEBUG_INSTALL_ONLINE + context.getPackageName();
        if (!QbSdk.mTbsDebugInstallOnline) {
            String str3 = null;
            try {
                str3 = System.getString(context.getContentResolver(), str2);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
            if (str3 != null && str3.equals("true")) {
                TbsLog.m7931w("TbsInstaller", "tbs_debug_install_online #2");
                try {
                    Thread.sleep(60000);
                } catch (Exception e2) {
                }
                try {
                    string = System.getString(context.getContentResolver(), str2);
                } catch (SecurityException e3) {
                    e3.printStackTrace();
                    string = str3;
                }
                if (string == null || !string.equals("true")) {
                    TbsLog.m7932w("TbsInstaller", "Installing...Canceled by TbsDebug!", true);
                    return;
                }
                try {
                    System.putString(context.getContentResolver(), str2, "false");
                } catch (SecurityException e32) {
                    e32.printStackTrace();
                }
                TbsLog.m7932w("TbsInstaller", "Installing... Exceptions occurred for TbsDebugInstallOnline!", true);
            }
        }
        if (str == null || str.length() <= 0 || C1164z.m8080a() >= 6 * C1164z.m8082a(str)) {
            FileOutputStream k = m7723k(context);
            if (k != null) {
                FileLock a = m7707a(context, k);
                if (a != null) {
                    boolean tryLock = f4951d.tryLock();
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + tryLock);
                    if (tryLock) {
                        boolean z;
                        f4950c.lock();
                        int a2 = C1131y.m7904a(context).m7906a();
                        int h = C1131y.m7904a(context).m7920h();
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + a2);
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + h);
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i);
                        if ((h > 0 && i > h) || (a2 > 0 && i > a2)) {
                            m7732t(context);
                        }
                        a2 = C1131y.m7904a(context).m7921i();
                        h = m7744c(context);
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + a2);
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + h);
                        if (a2 >= 0 && a2 < 2) {
                            TbsLog.m7928i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                            i2 = a2;
                            z = true;
                        } else if (a2 != 3 || h <= 0 || (i <= h && i != 88888888)) {
                            i2 = a2;
                            z = false;
                        } else {
                            try {
                                m7732t(context);
                                TbsLog.m7928i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                                z = false;
                            } catch (Throwable th) {
                                f4950c.unlock();
                                f4951d.unlock();
                                m7712a(a, k);
                            }
                        }
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + i2);
                        if (i2 < 1) {
                            String str4;
                            TbsLog.m7928i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                            QbSdk.setTBSInstallingStatus(true);
                            if (z) {
                                a2 = C1131y.m7904a(context).m7917e();
                                if (a2 > 10) {
                                    TbsLogReport.m7589a(context).m7601a((int) ErrorCode.EXCEED_UNZIP_RETRY_NUM, "exceed unzip retry num!");
                                    m7731s(context);
                                    QbSdk.setTBSInstallingStatus(false);
                                    f4950c.unlock();
                                    f4951d.unlock();
                                    m7712a(a, k);
                                    return;
                                }
                                C1131y.m7904a(context).m7914c(a2 + 1);
                            }
                            if (str == null) {
                                string = C1131y.m7904a(context).m7919g();
                                if (string == null) {
                                    TbsLogReport.m7589a(context).m7601a((int) ErrorCode.APK_PATH_ERROR, "apk path is null!");
                                    QbSdk.setTBSInstallingStatus(false);
                                    f4950c.unlock();
                                    f4951d.unlock();
                                    m7712a(a, k);
                                    return;
                                }
                                str4 = string;
                            } else {
                                str4 = str;
                            }
                            TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + str4);
                            a2 = m7733a(context, str4);
                            if (a2 == 0) {
                                TbsLogReport.m7589a(context).m7601a((int) ErrorCode.APK_VERSION_ERROR, "apk version is 0!");
                                QbSdk.setTBSInstallingStatus(false);
                                f4950c.unlock();
                                f4951d.unlock();
                                m7712a(a, k);
                                return;
                            }
                            C1131y.m7904a(context).m7909a(str4);
                            C1131y.m7904a(context).m7912b(a2, 0);
                            if (m7713a(context, new File(str4))) {
                                C1131y.m7904a(context).m7912b(a2, 1);
                            } else {
                                TbsLogReport.m7589a(context).m7601a((int) ErrorCode.UNZIP_OTHER_ERROR, "unzipTbsApk failed");
                                QbSdk.setTBSInstallingStatus(false);
                                f4950c.unlock();
                                f4951d.unlock();
                                m7712a(a, k);
                                return;
                            }
                        }
                        a2 = 0;
                        if (i2 < 2) {
                            if (z) {
                                int f = C1131y.m7904a(context).m7918f();
                                if (f > 10) {
                                    TbsLogReport.m7589a(context).m7601a((int) ErrorCode.EXCEED_DEXOPT_RETRY_NUM, "exceed dexopt retry num!");
                                    m7731s(context);
                                    QbSdk.setTBSInstallingStatus(false);
                                    f4950c.unlock();
                                    f4951d.unlock();
                                    m7712a(a, k);
                                    return;
                                }
                                C1131y.m7904a(context).m7911b(f + 1);
                            }
                            if (m7724l(context)) {
                                C1131y.m7904a(context).m7912b(a2, 2);
                                TbsLog.m7928i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                                TbsLog.m7927i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i);
                                Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                edit.putInt("tbs_preload_x5_counter", 0);
                                edit.putInt("tbs_preload_x5_recorder", 0);
                                edit.putInt("tbs_preload_x5_version", i);
                                edit.commit();
                                if (i == 88888888) {
                                    m7708a(i, str, context);
                                }
                                TbsLogReport.m7589a(context).m7601a(C1131y.m7904a(context).m7922j() == 1 ? ErrorCode.INCRUPDATE_INSTALL_SUCCESS : 200, "success");
                            } else {
                                f4950c.unlock();
                                f4951d.unlock();
                                m7712a(a, k);
                                return;
                            }
                        }
                        f4950c.unlock();
                        f4951d.unlock();
                        m7712a(a, k);
                        return;
                    }
                    m7712a(a, k);
                    return;
                }
                return;
            }
            return;
        }
        TbsLogReport.m7589a(context).m7601a((int) ErrorCode.ROM_NOT_ENOUGH, "rom is not enough when installing tbs core! curAvailROM=" + C1164z.m8080a() + ",minReqRom=" + (6 * C1164z.m8082a(str)));
    }

    /* renamed from: b */
    private boolean m7716b(Context context, boolean z) {
        boolean z2 = true;
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
        boolean z3 = false;
        try {
            FileOutputStream k = m7723k(context);
            if (k != null) {
                FileLock a = m7707a(context, k);
                if (a != null) {
                    boolean tryLock = f4950c.tryLock();
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + tryLock);
                    if (tryLock) {
                        int b = C1131y.m7904a(context).m7910b();
                        int c = m7744c(context);
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + b);
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + c);
                        if (b == 1) {
                            if (c == 0) {
                                TbsLog.m7928i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                m7727o(context);
                            } else if (z) {
                                TbsLog.m7928i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                m7727o(context);
                            }
                            f4950c.unlock();
                            z3 = z2;
                        }
                        z2 = false;
                        try {
                            f4950c.unlock();
                            z3 = z2;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            z3 = z2;
                            Throwable th3 = th2;
                            TbsLogReport.m7589a(context).m7601a((int) ErrorCode.COPY_EXCEPTION, th3.toString());
                            QbSdk.m7544a();
                            TbsLog.m7925e("TbsInstaller", "enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th3));
                            return z3;
                        }
                    }
                    m7712a(a, k);
                }
            }
        } catch (Throwable th4) {
            th3 = th4;
            TbsLogReport.m7589a(context).m7601a((int) ErrorCode.COPY_EXCEPTION, th3.toString());
            QbSdk.m7544a();
            TbsLog.m7925e("TbsInstaller", "enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th3));
            return z3;
        }
        return z3;
    }

    /* renamed from: c */
    private Context m7717c(Context context, int i) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i);
        if (i <= 0) {
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int i2 = 0;
        while (i2 < coreProviderAppList.length) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i2]) && m7720d(context, coreProviderAppList[i2])) {
                Context e = m7721e(context, coreProviderAppList[i2]);
                if (e == null) {
                    continue;
                } else if (m7725m(e)) {
                    int c = m7744c(e);
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + c);
                    if (c != 0 && c == i) {
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + coreProviderAppList[i2]);
                        return e;
                    }
                } else {
                    TbsLog.m7925e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + coreProviderAppList[i2] + " illegal signature go on next");
                }
            }
            i2++;
        }
        return null;
    }

    /* renamed from: c */
    private boolean m7718c(Context context, String str) {
        File file = new File(context.getDir("tbs", 0), str);
        if (file == null || !file.exists()) {
            return false;
        }
        File file2 = new File(file, "tbs.conf");
        return file2 != null && file2.exists();
    }

    /* renamed from: c */
    private boolean m7719c(Context context, boolean z) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
        try {
            FileOutputStream k = m7723k(context);
            if (k != null) {
                FileLock a = m7707a(context, k);
                if (a != null) {
                    boolean tryLock = f4950c.tryLock();
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + tryLock);
                    if (tryLock) {
                        int i = C1131y.m7904a(context).m7921i();
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + i);
                        int c = m7744c(context);
                        if (i == 2) {
                            if (c == 0) {
                                TbsLog.m7928i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                m7726n(context);
                            } else if (z) {
                                TbsLog.m7928i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                m7726n(context);
                            }
                        }
                        f4950c.unlock();
                    }
                    m7712a(a, k);
                }
            }
        } catch (Exception e) {
            TbsLog.m7927i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip Exception");
            QbSdk.m7544a();
            e.printStackTrace();
        } catch (Throwable th) {
            f4950c.unlock();
        }
        return false;
    }

    /* renamed from: d */
    private boolean m7720d(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: e */
    private Context m7721e(Context context, String str) {
        try {
            return context.createPackageContext(str, 2);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: h */
    static File m7722h(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        return file != null ? (file.isDirectory() || file.mkdir()) ? file : null : null;
    }

    /* renamed from: k */
    static FileOutputStream m7723k(Context context) {
        File b = m7714b(context, "tbslock.txt");
        if (b != null) {
            try {
                return new FileOutputStream(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: l */
    private boolean m7724l(Context context) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-doTbsDexOpt start");
        try {
            File i = m7749i(context);
            File[] listFiles = i.listFiles(new ae(this));
            int length = listFiles.length;
            if (VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(TbsConfig.APP_DEMO)) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
            for (int i2 = 0; i2 < length; i2++) {
                TbsLog.m7927i("TbsInstaller", "jarFile: " + listFiles[i2].getAbsolutePath());
                DexClassLoader dexClassLoader = new DexClassLoader(listFiles[i2].getAbsolutePath(), i.getAbsolutePath(), null, context.getClassLoader());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            TbsLogReport.m7589a(context).m7601a((int) ErrorCode.DEXOPT_EXCEPTION, e2.toString());
        }
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
        return true;
    }

    /* renamed from: m */
    private boolean m7725m(Context context) {
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (context.getPackageName().equals(TbsConfig.APP_QB)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.mm")) {
                if (!signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QQ)) {
                if (!signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_DEMO)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QZONE)) {
                if (!signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.qqpimsecure") && !signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            TbsLog.m7927i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    /* renamed from: n */
    private void m7726n(Context context) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        try {
            m7728p(context);
            m7729q(context);
            if (!TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.m7628a(context);
            }
            C1131y.m7904a(context).m7911b(0);
            C1131y.m7904a(context).m7914c(0);
            C1131y.m7904a(context).m7912b(0, 3);
            C1131y.m7904a(context).m7909a(bi_常量类.f6358b_空串);
            C1131y.m7904a(context).m7916d(-1);
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(context, m7746e(context), true);
            }
            this.f4955a = 0;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.m7589a(context).m7601a((int) ErrorCode.RENAME_EXCEPTION, "exception when renameing from unzip:" + e.toString());
            TbsLog.m7926e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        }
    }

    /* renamed from: o */
    private void m7727o(Context context) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        try {
            m7728p(context);
            m7730r(context);
            TbsShareManager.m7628a(context);
            C1131y.m7904a(context).m7908a(0, 3);
            this.f4955a = 0;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLogReport.m7589a(context).m7601a((int) ErrorCode.RENAME_EXCEPTION, "exception when renameing from copy:" + e.toString());
        }
    }

    /* renamed from: p */
    private void m7728p(Context context) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--deleteOldCore");
        C1146j.m7977a(m7747f(context), false);
    }

    /* renamed from: q */
    private void m7729q(Context context) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--renameShareDir");
        File i = m7749i(context);
        File f = m7747f(context);
        if (i != null && f != null) {
            i.renameTo(f);
        }
    }

    /* renamed from: r */
    private void m7730r(Context context) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File j = m7750j(context);
        File f = m7747f(context);
        if (j != null && f != null) {
            j.renameTo(f);
        }
    }

    /* renamed from: s */
    private void m7731s(Context context) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File i = m7749i(context);
        if (i != null) {
            C1146j.m7977a(i, false);
        }
        C1131y.m7904a(context).m7912b(0, 5);
        C1131y.m7904a(context).m7916d(-1);
        TbsLog.m7925e("TbsInstaller", "clearNewTbsCore forceSysWebViewInner!");
        QbSdk.m7544a();
    }

    /* renamed from: t */
    private void m7732t(Context context) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        C1131y.m7904a(context).m7911b(0);
        C1131y.m7904a(context).m7914c(0);
        C1131y.m7904a(context).m7912b(0, -1);
        C1131y.m7904a(context).m7909a(bi_常量类.f6358b_空串);
        C1131y.m7904a(context).m7907a(0);
        C1131y.m7904a(context).m7908a(0, -1);
        C1131y.m7904a(context).m7916d(-1);
        C1146j.m7977a(m7749i(context), true);
        C1146j.m7977a(m7750j(context), true);
    }

    /* renamed from: a */
    int m7733a(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        return packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
    }

    /* renamed from: a */
    void m7734a(Context context) {
        int b;
        int i = 0;
        if (!TbsShareManager.isThirdPartyApp(context)) {
            TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
            TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
            StringBuilder append = new StringBuilder().append("TbsInstaller-continueInstallTbsCore currentThreadName=");
            int name = Thread.currentThread().getName();
            TbsLog.m7927i("TbsInstaller", append.append(name).toString());
            FileOutputStream k = m7723k(context);
            if (k != null) {
                FileLock a = m7707a(context, k);
                if (a != null) {
                    int i2;
                    String tryLock = f4950c.tryLock();
                    if (tryLock == true) {
                        try {
                            i2 = C1131y.m7904a(context).m7921i();
                            name = C1131y.m7904a(context).m7920h();
                            tryLock = C1131y.m7904a(context).m7919g();
                            b = C1131y.m7904a(context).m7910b();
                            i = C1131y.m7904a(context).m7906a();
                        } finally {
                            b = f4950c;
                            b.unlock();
                        }
                    } else {
                        tryLock = null;
                        name = 0;
                        i2 = -1;
                        b = -1;
                    }
                    m7712a(a, k);
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + i2);
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + name);
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + tryLock);
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + b);
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + i);
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        m7741b(context, TbsShareManager.m7633c(context));
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("operation", SpeechEvent.EVENT_NETPREF);
                    m7735a(context, bundle);
                    if (i2 > -1 && i2 < 2) {
                        m7736a(context, tryLock, name);
                    }
                    if (b == 0) {
                        m7738a(context, i);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    void m7735a(Context context, Bundle bundle) {
        if (bundle != null && context != null) {
            Object obj = new Object[]{context, bundle};
            Message message = new Message();
            message.what = 3;
            message.obj = obj;
            f4952e.sendMessage(message);
        }
    }

    /* renamed from: a */
    void m7736a(Context context, String str, int i) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i);
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object obj = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        f4952e.sendMessage(message);
    }

    /* renamed from: a */
    void m7737a(Context context, boolean z) {
        boolean z2 = false;
        if (!QbSdk.f4783b) {
            if (VERSION.SDK_INT < 8) {
                TbsLog.m7926e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
                return;
            }
            boolean z3 = m7718c(context, "core_copy_tmp");
            if (m7718c(context, "core_unzip_tmp")) {
                z2 = true;
            }
            if ((z3 && m7716b(context, z)) || (r1 && m7719c(context, z))) {
                TbsLog.m7928i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, SUCCESS!!", true);
            }
        }
    }

    /* renamed from: a */
    boolean m7738a(Context context, int i) {
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i);
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (m7717c(context, i) != null) {
            Object obj = new Object[]{m7717c(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = obj;
            f4952e.sendMessage(message);
            return true;
        }
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        return false;
    }

    /* renamed from: a */
    public synchronized boolean m7739a(Context context, Context context2) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (!f4954g) {
            f4954g = true;
            new af(this, context2, context).start();
        }
        return true;
    }

    /* renamed from: b */
    File m7740b(Context context, Context context2) {
        File file = new File(context2.getDir("tbs", 0), "core_share");
        return file != null ? (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) ? file : null : null;
    }

    /* renamed from: b */
    void m7741b(Context context, int i) {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i > 0) {
            int c = m7744c(context);
            if (c != i) {
                Context d = TbsShareManager.m7634d(context);
                if (d != null) {
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                    TbsLog.m7925e("TbsInstaller", "installTbsCoreForThirdPartyApp forceSysWebViewInner #1");
                    QbSdk.m7544a();
                    m7739a(context, d);
                } else if (c <= 0) {
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                    TbsLog.m7925e("TbsInstaller", "installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
                    QbSdk.m7544a();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    void m7742b(android.content.Context r10, android.os.Bundle r11) {
        /*
        r9 = this;
        r0 = r9.m7743b(r10);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread";
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);
        if (r11 == 0) goto L_0x0006;
    L_0x0010:
        if (r10 == 0) goto L_0x0006;
    L_0x0012:
        r0 = "old_apk_location";
        r0 = r11.getString(r0);
        if (r0 == 0) goto L_0x0061;
    L_0x001a:
        r1 = r0.length();
        if (r1 <= 0) goto L_0x0061;
    L_0x0020:
        r1 = com.tencent.smtt.utils.C1164z.m8080a();
        r3 = 2;
        r5 = com.tencent.smtt.utils.C1164z.m8082a(r0);
        r3 = r3 * r5;
        r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r1 >= 0) goto L_0x0061;
    L_0x002f:
        r1 = com.tencent.smtt.utils.C1164z.m8080a();
        r3 = 2;
        r5 = com.tencent.smtt.utils.C1164z.m8082a(r0);
        r3 = r3 * r5;
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r10);
        r5 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = "rom is not enough when patching tbs core! curAvailROM=";
        r6 = r6.append(r7);
        r1 = r6.append(r1);
        r2 = ",minReqRom=";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r1 = r1.toString();
        r0.m7601a(r5, r1);
        goto L_0x0006;
    L_0x0061:
        r3 = m7723k(r10);
        if (r3 == 0) goto L_0x0006;
    L_0x0067:
        r4 = m7707a(r10, r3);
        if (r4 == 0) goto L_0x0006;
    L_0x006d:
        r0 = f4951d;
        r0 = r0.tryLock();
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = "TbsInstaller-installLocalTesCoreExInThread locked=";
        r2 = r2.append(r5);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.tencent.smtt.utils.TbsLog.m7927i(r1, r2);
        if (r0 == 0) goto L_0x01aa;
    L_0x008d:
        r1 = 0;
        r2 = 2;
        r0 = r9.m7744c(r10);	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        if (r0 <= 0) goto L_0x00a0;
    L_0x0095:
        r0 = com.tencent.smtt.sdk.C1131y.m7904a(r10);	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        r0 = r0.m7922j();	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        r5 = 1;
        if (r0 != r5) goto L_0x00b1;
    L_0x00a0:
        r0 = f4951d;
        r0.unlock();
        m7712a(r4, r3);
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
    L_0x00ac:
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);
        goto L_0x0006;
    L_0x00b1:
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r10);	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        r0 = r0.f4827b;	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        r5 = "tbs_responsecode";
        r6 = 0;
        r0 = r0.getInt(r5, r6);	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        r5 = 1;
        if (r0 == r5) goto L_0x00c4;
    L_0x00c1:
        r5 = 2;
        if (r0 != r5) goto L_0x011e;
    L_0x00c4:
        r0 = 1;
    L_0x00c5:
        if (r0 != 0) goto L_0x00e3;
    L_0x00c7:
        r0 = m7722h(r10);	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        if (r0 == 0) goto L_0x00e3;
    L_0x00cd:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        r6 = "x5.tbs";
        r5.<init>(r0, r6);	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        if (r5 == 0) goto L_0x00e3;
    L_0x00d6:
        r0 = r5.exists();	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        if (r0 == 0) goto L_0x00e3;
    L_0x00dc:
        r1 = com.tencent.smtt.sdk.QbSdk.m7543a(r10, r11);	 Catch:{ Exception -> 0x0127, all -> 0x016c }
        if (r1 != 0) goto L_0x0120;
    L_0x00e2:
        r2 = 1;
    L_0x00e3:
        r0 = f4951d;
        r0.unlock();
        m7712a(r4, r3);
        if (r2 != 0) goto L_0x01e4;
    L_0x00ed:
        r0 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS";
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r2);
        r0 = com.tencent.smtt.sdk.C1131y.m7904a(r10);
        r2 = 0;
        r3 = -1;
        r0.m7912b(r2, r3);
        r0 = com.tencent.smtt.sdk.C1131y.m7904a(r10);
        r2 = 1;
        r0.m7916d(r2);
        r0 = "apk_path";
        r0 = r1.getString(r0);
        r2 = new java.io.File;
        r2.<init>(r0);
        com.tencent.smtt.sdk.C1129w.m7879a(r2, r10);
        r2 = "tbs_core_ver";
        r1 = r1.getInt(r2);
        r9.m7736a(r10, r0, r1);
        goto L_0x0006;
    L_0x011e:
        r0 = 0;
        goto L_0x00c5;
    L_0x0120:
        r0 = "patch_result";
        r2 = r1.getInt(r0);	 Catch:{ Exception -> 0x0127 }
        goto L_0x00e3;
    L_0x0127:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0215 }
        r2 = 1;
        r5 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r10);	 Catch:{ all -> 0x0215 }
        r6 = 218; // 0xda float:3.05E-43 double:1.077E-321;
        r0 = r0.toString();	 Catch:{ all -> 0x0215 }
        r5.m7601a(r6, r0);	 Catch:{ all -> 0x0215 }
        r0 = f4951d;
        r0.unlock();
        m7712a(r4, r3);
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r10);
        r0 = r0.f4826a;
        r1 = "tbs_needdownload";
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.put(r1, r2);
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r10);
        r0.m7572g();
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r10);
        r1 = 217; // 0xd9 float:3.04E-43 double:1.07E-321;
        r2 = "incrUpdate fail!";
    L_0x0167:
        r0.m7601a(r1, r2);
        goto L_0x0006;
    L_0x016c:
        r0 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0170:
        r5 = f4951d;
        r5.unlock();
        m7712a(r4, r3);
        if (r1 != 0) goto L_0x01af;
    L_0x017a:
        r1 = "TbsInstaller";
        r3 = "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS";
        com.tencent.smtt.utils.TbsLog.m7927i(r1, r3);
        r1 = com.tencent.smtt.sdk.C1131y.m7904a(r10);
        r3 = 0;
        r4 = -1;
        r1.m7912b(r3, r4);
        r1 = com.tencent.smtt.sdk.C1131y.m7904a(r10);
        r3 = 1;
        r1.m7916d(r3);
        r1 = "apk_path";
        r1 = r2.getString(r1);
        r3 = new java.io.File;
        r3.<init>(r1);
        com.tencent.smtt.sdk.C1129w.m7879a(r3, r10);
        r3 = "tbs_core_ver";
        r2 = r2.getInt(r3);
        r9.m7736a(r10, r1, r2);
    L_0x01a9:
        throw r0;
    L_0x01aa:
        m7712a(r4, r3);
        goto L_0x0006;
    L_0x01af:
        r2 = 2;
        if (r1 != r2) goto L_0x01ba;
    L_0x01b2:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        com.tencent.smtt.utils.TbsLog.m7927i(r1, r2);
        goto L_0x01a9;
    L_0x01ba:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.m7927i(r1, r2);
        r1 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r10);
        r1 = r1.f4826a;
        r2 = "tbs_needdownload";
        r3 = 1;
        r3 = java.lang.Boolean.valueOf(r3);
        r1.put(r2, r3);
        r1 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r10);
        r1.m7572g();
        r1 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r10);
        r2 = 217; // 0xd9 float:3.04E-43 double:1.07E-321;
        r3 = "incrUpdate fail!";
        r1.m7601a(r2, r3);
        goto L_0x01a9;
    L_0x01e4:
        r0 = 2;
        if (r2 != r0) goto L_0x01ed;
    L_0x01e7:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH";
        goto L_0x00ac;
    L_0x01ed:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL";
        com.tencent.smtt.utils.TbsLog.m7927i(r0, r1);
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r10);
        r0 = r0.f4826a;
        r1 = "tbs_needdownload";
        r2 = 1;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.put(r1, r2);
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r10);
        r0.m7572g();
        r0 = com.tencent.smtt.sdk.TbsLogReport.m7589a(r10);
        r1 = 217; // 0xd9 float:3.04E-43 double:1.07E-321;
        r2 = "incrUpdate fail!";
        goto L_0x0167;
    L_0x0215:
        r0 = move-exception;
        r8 = r2;
        r2 = r1;
        r1 = r8;
        goto L_0x0170;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.ac.b(android.content.Context, android.os.Bundle):void");
    }

    /* renamed from: b */
    boolean m7743b(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        boolean z = false;
        File file = new File(m7747f(context), "tbs.conf");
        if (file != null && file.exists()) {
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    z = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return z;
                    } catch (Throwable th4) {
                        th2 = th4;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th5) {
                th2 = th5;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th2;
            }
        }
        return z;
    }

    /* renamed from: c */
    int m7744c(Context context) {
        String str;
        String str2;
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        int i = 0;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(m7747f(context), "tbs.conf");
            if (file == null || !file.exists()) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e2) {
                        str = "TbsInstaller";
                        str2 = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString();
                        TbsLog.m7927i(str, str2);
                        return i;
                    }
                }
                return i;
            }
            Properties properties = new Properties();
            fileInputStream = new FileInputStream(file);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                str2 = properties.getProperty("tbs_core_version");
                if (str2 == null) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            str = "TbsInstaller";
                            str2 = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22.toString();
                            TbsLog.m7927i(str, str2);
                            return i;
                        }
                    }
                    return i;
                }
                i = Integer.parseInt(str2);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e222) {
                        str = "TbsInstaller";
                        str2 = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e222.toString();
                        TbsLog.m7927i(str, str2);
                        return i;
                    }
                }
                return i;
            } catch (Exception e3) {
                e = e3;
                try {
                    TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2222) {
                            str = "TbsInstaller";
                            str2 = "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2222.toString();
                            TbsLog.m7927i(str, str2);
                            return i;
                        }
                    }
                    return i;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22222) {
                            TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22222.toString());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = fileInputStream2;
            TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return i;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: d */
    boolean m7745d(Context context) {
        File file = new File(m7747f(context), "tbs.conf");
        return file != null && file.exists();
    }

    /* renamed from: e */
    int m7746e(Context context) {
        Exception e;
        Throwable th;
        FileOutputStream k = m7723k(context);
        if (k == null) {
            return -1;
        }
        FileLock a = m7707a(context, k);
        if (a == null) {
            return -1;
        }
        boolean tryLock = f4950c.tryLock();
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer locked=" + tryLock);
        if (tryLock) {
            FileInputStream fileInputStream = null;
            FileInputStream fileInputStream2;
            try {
                File file = new File(m7747f(context), "tbs.conf");
                if (file == null || !file.exists()) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e2.toString());
                        }
                    }
                    f4950c.unlock();
                    m7712a(a, k);
                    return 0;
                }
                Properties properties = new Properties();
                fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e22) {
                                TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e22.toString());
                            }
                        }
                        f4950c.unlock();
                        m7712a(a, k);
                        return 0;
                    }
                    this.f4955a = Integer.parseInt(property);
                    int i = this.f4955a;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e3.toString());
                        }
                    }
                    f4950c.unlock();
                    m7712a(a, k);
                    return i;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e222) {
                                TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e222.toString());
                            }
                        }
                        f4950c.unlock();
                        m7712a(a, k);
                        return 0;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e32) {
                                TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e32.toString());
                            }
                        }
                        f4950c.unlock();
                        m7712a(a, k);
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream2 = fileInputStream;
                TbsLog.m7927i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                f4950c.unlock();
                m7712a(a, k);
                return 0;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                f4950c.unlock();
                m7712a(a, k);
                throw th;
            }
        }
        m7712a(a, k);
        return 0;
    }

    /* renamed from: f */
    File m7747f(Context context) {
        return m7740b(null, context);
    }

    /* renamed from: g */
    File m7748g(Context context) {
        File file = new File(context.getDir("tbs", 0), "share");
        return file != null ? (file.isDirectory() || file.mkdir()) ? file : null : null;
    }

    /* renamed from: i */
    File m7749i(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        return file != null ? (file.isDirectory() || file.mkdir()) ? file : null : null;
    }

    /* renamed from: j */
    File m7750j(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        return file != null ? (file.isDirectory() || file.mkdir()) ? file : null : null;
    }
}
