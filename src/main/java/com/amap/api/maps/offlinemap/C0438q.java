package com.amap.api.maps.offlinemap;

import com.amap.api.mapcore.util.az;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;

/* compiled from: ZipEncrypt */
/* renamed from: com.amap.api.maps.offlinemap.q */
class C0438q {
    C0438q() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static boolean m3765a(java.util.zip.ZipInputStream r19, java.io.File r20, com.amap.api.maps.offlinemap.C0436o r21, com.amap.api.maps.offlinemap.C0425d r22) throws java.lang.Exception {
        /*
        r5 = java.lang.System.currentTimeMillis();
        r4 = r19.getNextEntry();
        r12 = new java.lang.StringBuffer;
        r12.<init>();
        r2 = 0;
        r16 = r4;
        r17 = r5;
        r4 = r17;
        r6 = r16;
    L_0x0017:
        if (r6 == 0) goto L_0x00ea;
    L_0x0019:
        r7 = r6.getName();
        r8 = r6.isDirectory();
        if (r8 != 0) goto L_0x002c;
    L_0x0023:
        r8 = r12.append(r7);
        r9 = ";";
        r8.append(r9);
    L_0x002c:
        r9 = new java.io.File;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r10 = r20.getAbsolutePath();
        r8 = r8.append(r10);
        r10 = "/";
        r8 = r8.append(r10);
        r7 = r8.append(r7);
        r7 = r7.toString();
        r9.<init>(r7);
        r6 = r6.isDirectory();
        if (r6 == 0) goto L_0x005a;
    L_0x0052:
        r9.mkdirs();
    L_0x0055:
        r6 = r19.getNextEntry();
        goto L_0x0017;
    L_0x005a:
        r9.createNewFile();
        r8 = 0;
        r6 = 0;
        r7 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00c9, all -> 0x00e2 }
        r7.<init>(r9);	 Catch:{ IOException -> 0x00c9, all -> 0x00e2 }
        r8 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r13 = new byte[r8];	 Catch:{ IOException -> 0x010a, all -> 0x0105 }
        r9 = 0;
        r8 = 62;
        r10 = r21.m3733e();	 Catch:{ IOException -> 0x010a, all -> 0x0105 }
        r11 = "000001";
        r10 = r10.equals(r11);	 Catch:{ IOException -> 0x010a, all -> 0x0105 }
        if (r10 == 0) goto L_0x0119;
    L_0x0077:
        r8 = 40;
        r16 = r2;
        r2 = r4;
        r4 = r16;
    L_0x007e:
        r0 = r19;
        r10 = r0.read(r13);	 Catch:{ IOException -> 0x010a, all -> 0x0105 }
        r11 = -1;
        if (r10 == r11) goto L_0x00be;
    L_0x0087:
        r11 = 0;
        r7.write(r13, r11, r10);	 Catch:{ IOException -> 0x010a, all -> 0x0105 }
        r10 = (long) r10;	 Catch:{ IOException -> 0x010a, all -> 0x0105 }
        r10 = r10 + r4;
        r4 = (long) r8;	 Catch:{ IOException -> 0x010a, all -> 0x0105 }
        r4 = r4 * r10;
        r14 = r21.m3743j();	 Catch:{ IOException -> 0x010a, all -> 0x0105 }
        r4 = r4 / r14;
        r4 = (int) r4;
        r5 = 100;
        if (r4 >= r5) goto L_0x00bb;
    L_0x0099:
        if (r4 == r9) goto L_0x00b7;
    L_0x009b:
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x010e, all -> 0x0105 }
        r5 = r5 - r2;
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1));
        if (r5 <= 0) goto L_0x00b7;
    L_0x00a6:
        r0 = r21;
        r0.m3726b(r4);	 Catch:{ IOException -> 0x010e, all -> 0x0105 }
        r2 = 1;
        r0 = r22;
        r1 = r21;
        r0.m3665a(r1, r2, r4);	 Catch:{ IOException -> 0x010e, all -> 0x0105 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x010e, all -> 0x0105 }
    L_0x00b7:
        r9 = r4;
        r6 = r4;
        r4 = r10;
        goto L_0x007e;
    L_0x00bb:
        r4 = 100;
        goto L_0x0099;
    L_0x00be:
        if (r7 == 0) goto L_0x0112;
    L_0x00c0:
        r7.close();
        r16 = r4;
        r4 = r2;
        r2 = r16;
        goto L_0x0055;
    L_0x00c9:
        r2 = move-exception;
        r3 = r6;
        r4 = r8;
    L_0x00cc:
        r5 = "ZipEncrypt";
        r6 = "fileUnZip";
        com.amap.api.mapcore.util.az.m3143a(r2, r5, r6);	 Catch:{ all -> 0x0107 }
        r2 = -1;
        r0 = r22;
        r1 = r21;
        r0.m3665a(r1, r2, r3);	 Catch:{ all -> 0x0107 }
        r2 = 0;
        if (r4 == 0) goto L_0x00e1;
    L_0x00de:
        r4.close();
    L_0x00e1:
        return r2;
    L_0x00e2:
        r2 = move-exception;
        r7 = r8;
    L_0x00e4:
        if (r7 == 0) goto L_0x00e9;
    L_0x00e6:
        r7.close();
    L_0x00e9:
        throw r2;
    L_0x00ea:
        r2 = r12.length();
        r3 = 1;
        if (r2 <= r3) goto L_0x0103;
    L_0x00f1:
        r2 = r12.length();
        r2 = r2 + -1;
        r12.deleteCharAt(r2);
        r2 = r12.toString();
        r0 = r21;
        r0.m3736f(r2);
    L_0x0103:
        r2 = 1;
        goto L_0x00e1;
    L_0x0105:
        r2 = move-exception;
        goto L_0x00e4;
    L_0x0107:
        r2 = move-exception;
        r7 = r4;
        goto L_0x00e4;
    L_0x010a:
        r2 = move-exception;
        r3 = r6;
        r4 = r7;
        goto L_0x00cc;
    L_0x010e:
        r2 = move-exception;
        r3 = r4;
        r4 = r7;
        goto L_0x00cc;
    L_0x0112:
        r16 = r4;
        r4 = r2;
        r2 = r16;
        goto L_0x0055;
    L_0x0119:
        r16 = r2;
        r2 = r4;
        r4 = r16;
        goto L_0x007e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.offlinemap.q.a(java.util.zip.ZipInputStream, java.io.File, com.amap.api.maps.offlinemap.o, com.amap.api.maps.offlinemap.d):boolean");
    }

    /* renamed from: a */
    public static boolean m3764a(String str, String str2, C0436o c0436o, C0425d c0425d) {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        ZipInputStream zipInputStream = null;
        boolean z = false;
        try {
            fileInputStream = new FileInputStream(str2);
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(fileInputStream);
                try {
                    File file = new File(str);
                    file.mkdirs();
                    z = C0438q.m3765a(zipInputStream2, file, c0436o, c0425d);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    if (zipInputStream2 != null) {
                        zipInputStream2.close();
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    zipInputStream = zipInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (zipInputStream != null) {
                        zipInputStream.close();
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                az.m3143a(th, "ZipEncrypt", "unZip");
                th.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (zipInputStream != null) {
                    zipInputStream.close();
                }
                return z;
            }
        } catch (Throwable th5) {
            th2 = th5;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (zipInputStream != null) {
                zipInputStream.close();
            }
            throw th2;
        }
        return z;
    }
}
