package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.Log;
import com.amap.api.mapcore.util.bl.C0369b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: LogUpDateProcessor */
abstract class bh {
    /* renamed from: a */
    private bl f2012a;

    /* renamed from: a */
    protected abstract String mo596a();

    /* renamed from: a */
    protected abstract boolean mo597a(Context context);

    /* renamed from: b */
    protected abstract int mo598b();

    /* renamed from: a */
    public static bh m3152a(Context context, int i) {
        switch (i) {
            case 0:
                return new bc(context);
            case 1:
                return new be(context);
            case 2:
                return new ba(context);
            default:
                return null;
        }
    }

    protected bh(Context context) {
        try {
            this.f2012a = m3153a(context, mo596a());
        } catch (Throwable th) {
            az.m3143a(th, "LogProcessor", "LogUpDateProcessor");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    void m3164b(android.content.Context r6) {
        /*
        r5 = this;
        r0 = r5.mo597a(r6);	 Catch:{ Throwable -> 0x002e }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r1 = android.os.Looper.getMainLooper();	 Catch:{ Throwable -> 0x002e }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x002e }
        r0 = new com.amap.api.mapcore.util.al;	 Catch:{ all -> 0x002b }
        r0.<init>(r6);	 Catch:{ all -> 0x002b }
        r2 = r5.mo598b();	 Catch:{ all -> 0x002b }
        r5.m3155a(r0, r2);	 Catch:{ all -> 0x002b }
        r2 = 0;
        r3 = r5.mo598b();	 Catch:{ all -> 0x002b }
        r2 = r0.m3085a(r2, r3);	 Catch:{ all -> 0x002b }
        if (r2 == 0) goto L_0x0029;
    L_0x0023:
        r3 = r2.size();	 Catch:{ all -> 0x002b }
        if (r3 != 0) goto L_0x003a;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        throw r0;	 Catch:{ Throwable -> 0x002e }
    L_0x002e:
        r0 = move-exception;
        r1 = "LogProcessor";
        r2 = "processUpdateLog";
        com.amap.api.mapcore.util.az.m3143a(r0, r1, r2);
        r0.printStackTrace();
        goto L_0x0006;
    L_0x003a:
        r3 = r5.m3154a(r2, r6);	 Catch:{ all -> 0x002b }
        if (r3 != 0) goto L_0x0042;
    L_0x0040:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
    L_0x0042:
        r3 = r5.m3158b(r3);	 Catch:{ all -> 0x002b }
        r4 = 1;
        if (r3 != r4) goto L_0x0050;
    L_0x0049:
        r3 = r5.mo598b();	 Catch:{ all -> 0x002b }
        r5.m3156a(r2, r0, r3);	 Catch:{ all -> 0x002b }
    L_0x0050:
        monitor-exit(r1);	 Catch:{ all -> 0x002b }
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bh.b(android.content.Context):void");
    }

    /* renamed from: a */
    private boolean m3157a(String str) {
        boolean z = false;
        if (this.f2012a != null) {
            try {
                z = this.f2012a.m3275c(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return z;
    }

    /* renamed from: a */
    private void m3155a(al alVar, int i) {
        try {
            m3156a(alVar.m3085a(2, i), alVar, i);
        } catch (Throwable th) {
            az.m3143a(th, "LogProcessor", "processDeleteFail");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private int m3158b(String str) {
        int i = 0;
        Log.i("yiyi.qi", str);
        try {
            byte[] a = bt.m3294a(false).m3304a(new bi_常量类(ae.m3042b(str.getBytes())));
            if (a != null) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(a));
                    String str2 = "code";
                    if (jSONObject.has(str2)) {
                        i = jSONObject.getInt(str2);
                    }
                } catch (Throwable e) {
                    az.m3143a(e, "LogProcessor", "processUpdate");
                    e.printStackTrace();
                }
            }
        } catch (Throwable e2) {
            az.m3143a(e2, "LogProcessor", "processUpdate");
            e2.printStackTrace();
        }
        return i;
    }

    /* renamed from: a */
    private void m3156a(List<an> list, al alVar, int i) {
        if (list != null && list.size() > 0) {
            for (an anVar : list) {
                if (m3157a(anVar.m3093b())) {
                    alVar.m3087a(anVar.m3093b(), i);
                } else {
                    anVar.m3091a(2);
                    alVar.m3086a(anVar, anVar.m3090a());
                }
            }
        }
    }

    /* renamed from: c */
    private String m3159c(Context context) {
        String str = null;
        try {
            String a = C0409y.m3503a(context);
            if (!bi_常量类.f6358b.equals(a)) {
                str = C0409y.m3509b(context, a.getBytes("UTF-8"));
            }
        } catch (Throwable e) {
            az.m3143a(e, "LogProcessor", "getPublicInfo");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.m3143a(e2, "LogProcessor", "getPublicInfo");
            e2.printStackTrace();
        }
        return str;
    }

    /* renamed from: a */
    private String m3154a(List<an> list, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"pinfo\":\"").append(m3159c(context)).append("\",\"els\":[");
        Object obj = 1;
        for (an anVar : list) {
            Object obj2;
            String c = m3160c(anVar.m3093b());
            if (c != null) {
                if (bi_常量类.f6358b.equals(c)) {
                    obj2 = obj;
                    obj = obj2;
                } else {
                    String str = c + "||" + anVar.m3097d();
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("{\"log\":\"").append(str).append("\"}");
                }
            }
            obj2 = obj;
            obj = obj2;
        }
        if (obj != null) {
            return null;
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    /* renamed from: c */
    private String m3160c(String str) {
        Throwable e;
        IOException iOException;
        InputStream a;
        Throwable th;
        Object obj;
        String str2 = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            if (this.f2012a == null) {
                if (str2 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e2) {
                        az.m3143a(e2, "LogProcessor", "readLog1");
                        e2.printStackTrace();
                    }
                }
                if (str2 != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        az.m3143a(e, "LogProcessor", "readLog2");
                        iOException.printStackTrace();
                        return str2;
                    }
                }
                return str2;
            }
            C0369b a2 = this.f2012a.m3269a(str);
            if (a2 == null) {
                if (str2 != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e22) {
                        az.m3143a(e22, "LogProcessor", "readLog1");
                        e22.printStackTrace();
                    }
                }
                if (str2 != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        iOException = e4;
                        az.m3143a((Throwable) iOException, "LogProcessor", "readLog2");
                        iOException.printStackTrace();
                        return str2;
                    }
                }
                return str2;
            }
            a = a2.m3232a(0);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = a.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str2 = byteArrayOutputStream.toString("utf-8");
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e5) {
                            az.m3143a(e5, "LogProcessor", "readLog1");
                            e5.printStackTrace();
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e6) {
                            e5 = e6;
                            az.m3143a(e5, "LogProcessor", "readLog2");
                            iOException.printStackTrace();
                            return str2;
                        }
                    }
                } catch (IOException e7) {
                    e5 = e7;
                    try {
                        az.m3143a(e5, "LogProcessor", "readLog");
                        e5.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e52) {
                                az.m3143a(e52, "LogProcessor", "readLog1");
                                e52.printStackTrace();
                            }
                        }
                        if (a != null) {
                            try {
                                a.close();
                            } catch (IOException e8) {
                                e52 = e8;
                                az.m3143a(e52, "LogProcessor", "readLog2");
                                iOException.printStackTrace();
                                return str2;
                            }
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e522) {
                                az.m3143a(e522, "LogProcessor", "readLog1");
                                e522.printStackTrace();
                            }
                        }
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable e5222) {
                                az.m3143a(e5222, "LogProcessor", "readLog2");
                                e5222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    e5222 = th3;
                    az.m3143a(e5222, "LogProcessor", "readLog");
                    e5222.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e52222) {
                            az.m3143a(e52222, "LogProcessor", "readLog1");
                            e52222.printStackTrace();
                        }
                    }
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e9) {
                            e52222 = e9;
                            az.m3143a(e52222, "LogProcessor", "readLog2");
                            iOException.printStackTrace();
                            return str2;
                        }
                    }
                    return str2;
                }
            } catch (IOException e10) {
                e52222 = e10;
                obj = str2;
                az.m3143a(e52222, "LogProcessor", "readLog");
                e52222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (a != null) {
                    a.close();
                }
                return str2;
            } catch (Throwable e522222) {
                obj = str2;
                th = e522222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (a != null) {
                    a.close();
                }
                throw th;
            }
            return str2;
        } catch (IOException e11) {
            e522222 = e11;
            obj = str2;
            Object obj2 = str2;
            az.m3143a(e522222, "LogProcessor", "readLog");
            e522222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (a != null) {
                a.close();
            }
            return str2;
        } catch (Throwable e5222222) {
            byteArrayOutputStream = str2;
            a = str2;
            th = e5222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (a != null) {
                a.close();
            }
            throw th;
        }
    }

    /* renamed from: c */
    void m3165c() {
        if (this.f2012a != null && !this.f2012a.m3271a()) {
            try {
                this.f2012a.close();
            } catch (Throwable e) {
                az.m3143a(e, "LogProcessor", "closeDiskLru");
                e.printStackTrace();
            } catch (Throwable e2) {
                az.m3143a(e2, "LogProcessor", "closeDiskLru");
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private bl m3153a(Context context, String str) {
        bl blVar = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(bg.f2036a);
            stringBuilder.append(str);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                blVar = bl.m3249a(file, 1, 1, 20480);
            }
        } catch (Throwable e) {
            az.m3143a(e, "LogProcessor", "initDiskLru");
            e.printStackTrace();
        } catch (Throwable e2) {
            az.m3143a(e2, "LogProcessor", "initDiskLru");
            e2.printStackTrace();
        }
        return blVar;
    }
}
