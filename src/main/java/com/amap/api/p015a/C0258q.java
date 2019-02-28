package com.amap.api.p015a;

import android.content.Context;
import android.os.Environment;
import com.amap.api.maps2d.MapsInitializer;
import com.amap.api.p015a.C0253m.C0252a;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import p054u.aly.bi_常量类;

/* compiled from: CachManager */
/* renamed from: com.amap.api.a.q */
class C0258q {
    /* renamed from: a */
    private Context f1076a;
    /* renamed from: b */
    private C0257p f1077b = null;
    /* renamed from: c */
    private String f1078c = "/sdcard/Amap/RMap";
    /* renamed from: d */
    private final int f1079d = 128;

    public C0258q(Context context, boolean z, as asVar) {
        this.f1076a = context;
        if (asVar != null) {
            if (z) {
                this.f1078c = context.getFilesDir().getPath();
                return;
            }
            boolean z2 = false;
            if (!asVar.f647l.equals(bi_常量类.f6358b_空串)) {
                File file = new File(asVar.f647l);
                z2 = file.exists();
                if (!z2) {
                    z2 = file.mkdirs();
                }
            }
            if (!z2) {
                this.f1078c = C0258q.m1663a(this.f1076a, this.f1078c, asVar);
            }
        }
    }

    /* renamed from: a */
    public static String m1663a(Context context, String str, as asVar) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getFilesDir().getPath();
        }
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals(bi_常量类.f6358b_空串)) {
            File file;
            File file2 = new File(Environment.getExternalStorageDirectory(), "Amap");
            if (!file2.exists()) {
                file2.mkdir();
            }
            file = new File(file2, asVar.f636a);
            if (!file.exists()) {
                file.mkdir();
            }
            return file.toString() + "/";
        }
        file = new File(MapsInitializer.sdcardDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return MapsInitializer.sdcardDir;
    }

    /* renamed from: a */
    private String[] m1666a(int i, int i2, int i3, boolean z) {
        int i4 = i / 128;
        int i5 = i2 / 128;
        int i6 = i4 / 10;
        int i7 = i5 / 10;
        String[] strArr = new String[2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f1078c);
        stringBuilder.append("/");
        stringBuilder.append(i3);
        stringBuilder.append("/");
        stringBuilder.append(i6);
        stringBuilder.append("/");
        stringBuilder.append(i7);
        stringBuilder.append("/");
        if (!z) {
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        stringBuilder.append(i3);
        stringBuilder.append("_");
        stringBuilder.append(i4);
        stringBuilder.append("_");
        stringBuilder.append(i5);
        strArr[0] = stringBuilder.toString() + ".idx";
        strArr[1] = stringBuilder.toString() + ".dat";
        return strArr;
    }

    /* renamed from: a */
    public void m1669a(C0257p c0257p) {
        this.f1077b = c0257p;
    }

    /* renamed from: a */
    private byte[] m1665a(int i) {
        return new byte[]{(byte) (i & WebView.NORMAL_MODE_ALPHA), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((-16777216 & i) >> 24)};
    }

    /* renamed from: a */
    private void m1664a(byte[] bArr) {
        if (bArr != null && bArr.length == 4) {
            byte b = bArr[0];
            bArr[0] = bArr[3];
            bArr[3] = b;
            b = bArr[1];
            bArr[1] = bArr[2];
            bArr[2] = b;
        }
    }

    /* renamed from: b */
    private int m1667b(byte[] bArr) {
        return (((bArr[0] & WebView.NORMAL_MODE_ALPHA) | ((bArr[1] << 8) & 65280)) | ((bArr[2] << 16) & 16711680)) | ((bArr[3] << 24) & -16777216);
    }

    /* renamed from: a */
    private int m1662a(int i, int i2) {
        return ((i % 128) * 128) + (i2 % 128);
    }

    /* renamed from: a */
    public int m1668a(C0252a c0252a) {
        String[] a = m1666a(c0252a.f1046b, c0252a.f1047c, c0252a.f1048d, true);
        if (a == null || a.length != 2 || a[0].equals(bi_常量类.f6358b_空串) || Arrays.equals(a, new String[a.length])) {
            return -1;
        }
        File file = new File(a[0]);
        if (!file.exists()) {
            return -1;
        }
        int a2 = m1662a(c0252a.f1046b, c0252a.f1047c);
        if (a2 < 0) {
            return -1;
        }
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            randomAccessFile = null;
        }
        if (randomAccessFile == null) {
            return -1;
        }
        try {
            randomAccessFile.seek((long) (a2 * 4));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        byte[] bArr = new byte[4];
        try {
            randomAccessFile.read(bArr, 0, 4);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        m1664a(bArr);
        a2 = m1667b(bArr);
        try {
            randomAccessFile.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        if (a2 < 0) {
            return -1;
        }
        File file2 = new File(a[1]);
        if (!file2.exists()) {
            return -1;
        }
        RandomAccessFile randomAccessFile2;
        try {
            randomAccessFile2 = new RandomAccessFile(file2, "r");
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
            randomAccessFile2 = null;
        }
        if (randomAccessFile2 == null) {
            return -1;
        }
        try {
            randomAccessFile2.seek((long) a2);
        } catch (IOException e42) {
            e42.printStackTrace();
        }
        try {
            randomAccessFile2.read(bArr, 0, 4);
        } catch (IOException e422) {
            e422.printStackTrace();
        }
        m1664a(bArr);
        int b = m1667b(bArr);
        if (b <= 0) {
            try {
                randomAccessFile2.close();
                return -1;
            } catch (IOException e4222) {
                e4222.printStackTrace();
                return -1;
            }
        }
        byte[] bArr2 = new byte[b];
        try {
            randomAccessFile2.read(bArr2, 0, b);
        } catch (IOException e22) {
            e22.printStackTrace();
        }
        try {
            randomAccessFile2.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0252a.f1046b);
        stringBuilder.append("-");
        stringBuilder.append(c0252a.f1047c);
        stringBuilder.append("-");
        stringBuilder.append(c0252a.f1048d);
        if (this.f1077b == null) {
            return -1;
        }
        return this.f1077b.m1659a(bArr2, null, true, null, stringBuilder.toString());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public synchronized boolean m1670a(byte[] r12, int r13, int r14, int r15) {
        /*
        r11 = this;
        r3 = 0;
        r1 = 1;
        r4 = 0;
        r0 = 0;
        monitor-enter(r11);
        if (r12 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r11);
        return r0;
    L_0x000a:
        r6 = r12.length;	 Catch:{ all -> 0x00a3 }
        if (r6 <= 0) goto L_0x0008;
    L_0x000d:
        r2 = 0;
        r9 = r11.m1666a(r13, r14, r15, r2);	 Catch:{ all -> 0x00a3 }
        if (r9 == 0) goto L_0x0008;
    L_0x0014:
        r2 = r9.length;	 Catch:{ all -> 0x00a3 }
        r7 = 2;
        if (r2 != r7) goto L_0x0008;
    L_0x0018:
        r2 = 0;
        r2 = r9[r2];	 Catch:{ all -> 0x00a3 }
        r7 = "";
        r2 = r2.equals(r7);	 Catch:{ all -> 0x00a3 }
        if (r2 != 0) goto L_0x0008;
    L_0x0023:
        r2 = r9.length;	 Catch:{ all -> 0x00a3 }
        r2 = new java.lang.String[r2];	 Catch:{ all -> 0x00a3 }
        r2 = java.util.Arrays.equals(r9, r2);	 Catch:{ all -> 0x00a3 }
        if (r2 != 0) goto L_0x0008;
    L_0x002c:
        r7 = new java.io.File;	 Catch:{ all -> 0x00a3 }
        r2 = 1;
        r2 = r9[r2];	 Catch:{ all -> 0x00a3 }
        r7.<init>(r2);	 Catch:{ all -> 0x00a3 }
        r2 = r7.exists();	 Catch:{ all -> 0x00a3 }
        if (r2 != 0) goto L_0x0040;
    L_0x003a:
        r2 = r7.createNewFile();	 Catch:{ IOException -> 0x00a6 }
    L_0x003e:
        if (r2 == 0) goto L_0x0008;
    L_0x0040:
        r2 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x00ac }
        r8 = "rws";
        r2.<init>(r7, r8);	 Catch:{ FileNotFoundException -> 0x00ac }
    L_0x0047:
        if (r2 == 0) goto L_0x0008;
    L_0x0049:
        r10 = r11.m1665a(r6);	 Catch:{ all -> 0x00a3 }
        r11.m1664a(r10);	 Catch:{ all -> 0x00a3 }
        r6 = r2.length();	 Catch:{ IOException -> 0x00b2 }
        r7 = r6;
    L_0x0055:
        r2.seek(r7);	 Catch:{ IOException -> 0x00b8 }
    L_0x0058:
        r2.write(r10);	 Catch:{ IOException -> 0x00bd }
    L_0x005b:
        r2.write(r12);	 Catch:{ IOException -> 0x00c2 }
    L_0x005e:
        r2.close();	 Catch:{ IOException -> 0x00c7 }
    L_0x0061:
        r6 = new java.io.File;	 Catch:{ all -> 0x00a3 }
        r2 = 0;
        r2 = r9[r2];	 Catch:{ all -> 0x00a3 }
        r6.<init>(r2);	 Catch:{ all -> 0x00a3 }
        r2 = r6.exists();	 Catch:{ all -> 0x00a3 }
        if (r2 != 0) goto L_0x0075;
    L_0x006f:
        r2 = r6.createNewFile();	 Catch:{ IOException -> 0x00cc }
    L_0x0073:
        if (r2 == 0) goto L_0x0008;
    L_0x0075:
        r2 = new java.io.RandomAccessFile;	 Catch:{ FileNotFoundException -> 0x00d2 }
        r9 = "rws";
        r2.<init>(r6, r9);	 Catch:{ FileNotFoundException -> 0x00d2 }
        r6 = r2;
    L_0x007d:
        if (r6 == 0) goto L_0x0008;
    L_0x007f:
        r2 = r6.length();	 Catch:{ IOException -> 0x00d8 }
    L_0x0083:
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0092;
    L_0x0087:
        r2 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r2 = new byte[r2];	 Catch:{ all -> 0x00a3 }
        r3 = -1;
        java.util.Arrays.fill(r2, r3);	 Catch:{ all -> 0x00a3 }
        r6.write(r2);	 Catch:{ IOException -> 0x00de }
    L_0x0092:
        r2 = r11.m1662a(r13, r14);	 Catch:{ all -> 0x00a3 }
        if (r2 >= 0) goto L_0x00e3;
    L_0x0098:
        r6.close();	 Catch:{ IOException -> 0x009d }
        goto L_0x0008;
    L_0x009d:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x0008;
    L_0x00a3:
        r0 = move-exception;
        monitor-exit(r11);
        throw r0;
    L_0x00a6:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x00a3 }
        r2 = r0;
        goto L_0x003e;
    L_0x00ac:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x00a3 }
        r2 = r3;
        goto L_0x0047;
    L_0x00b2:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x00a3 }
        r7 = r4;
        goto L_0x0055;
    L_0x00b8:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x0058;
    L_0x00bd:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x005b;
    L_0x00c2:
        r6 = move-exception;
        r6.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x005e;
    L_0x00c7:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x0061;
    L_0x00cc:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x00a3 }
        r2 = r0;
        goto L_0x0073;
    L_0x00d2:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x00a3 }
        r6 = r3;
        goto L_0x007d;
    L_0x00d8:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x00a3 }
        r2 = r4;
        goto L_0x0083;
    L_0x00de:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x0092;
    L_0x00e3:
        r0 = r2 * 4;
        r2 = (long) r0;
        r6.seek(r2);	 Catch:{ IOException -> 0x00fa }
    L_0x00e9:
        r0 = (int) r7;
        r0 = r11.m1665a(r0);	 Catch:{ all -> 0x00a3 }
        r11.m1664a(r0);	 Catch:{ all -> 0x00a3 }
        r6.write(r0);	 Catch:{ IOException -> 0x00ff }
    L_0x00f4:
        r6.close();	 Catch:{ IOException -> 0x0104 }
    L_0x00f7:
        r0 = r1;
        goto L_0x0008;
    L_0x00fa:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x00e9;
    L_0x00ff:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x00f4;
    L_0x0104:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x00f7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.a.q.a(byte[], int, int, int):boolean");
    }
}
