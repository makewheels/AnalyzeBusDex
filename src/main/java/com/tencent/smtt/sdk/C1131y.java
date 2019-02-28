package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.tencent.smtt.sdk.y */
class C1131y {
    /* renamed from: a */
    private static C1131y f5106a = null;
    /* renamed from: b */
    private static Context f5107b = null;

    private C1131y() {
    }

    /* renamed from: a */
    static C1131y m7904a(Context context) {
        f5107b = context.getApplicationContext();
        if (f5106a == null) {
            f5106a = new C1131y();
        }
        return f5106a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: k */
    private java.util.Properties m7905k() {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.m7915d();	 Catch:{ Exception -> 0x0022, all -> 0x0035 }
        r2 = new java.util.Properties;	 Catch:{ Exception -> 0x0022, all -> 0x0035 }
        r2.<init>();	 Catch:{ Exception -> 0x0022, all -> 0x0035 }
        if (r3 == 0) goto L_0x0054;
    L_0x000c:
        if (r2 == 0) goto L_0x0054;
    L_0x000e:
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0049, all -> 0x0035 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0049, all -> 0x0035 }
        r2.load(r0);	 Catch:{ Exception -> 0x004f, all -> 0x0041 }
    L_0x0016:
        if (r0 == 0) goto L_0x001b;
    L_0x0018:
        r0.close();	 Catch:{ IOException -> 0x001d }
    L_0x001b:
        r0 = r2;
    L_0x001c:
        return r0;
    L_0x001d:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001b;
    L_0x0022:
        r0 = move-exception;
        r2 = r1;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x0027:
        r1.printStackTrace();	 Catch:{ all -> 0x0046 }
        if (r2 == 0) goto L_0x001c;
    L_0x002c:
        r2.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x001c;
    L_0x0030:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x001c;
    L_0x0035:
        r0 = move-exception;
    L_0x0036:
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();	 Catch:{ IOException -> 0x003c }
    L_0x003b:
        throw r0;
    L_0x003c:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x003b;
    L_0x0041:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0036;
    L_0x0046:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0036;
    L_0x0049:
        r0 = move-exception;
        r4 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r4;
        goto L_0x0027;
    L_0x004f:
        r1 = move-exception;
        r4 = r2;
        r2 = r0;
        r0 = r4;
        goto L_0x0027;
    L_0x0054:
        r0 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.y.k():java.util.Properties");
    }

    /* renamed from: a */
    int m7906a() {
        Properties k = m7905k();
        return (k == null || k.getProperty("copy_core_ver") == null) ? 0 : Integer.parseInt(k.getProperty("copy_core_ver"));
    }

    /* renamed from: a */
    void m7907a(int i) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            Properties k = m7905k();
            if (k != null) {
                k.setProperty("copy_retry_num", String.valueOf(i));
                File d = m7915d();
                if (d != null) {
                    fileOutputStream = new FileOutputStream(d);
                    try {
                        k.store(fileOutputStream, "update copy retry num!");
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    void m7908a(int i, int i2) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            Properties k = m7905k();
            if (k != null) {
                k.setProperty("copy_core_ver", String.valueOf(i));
                k.setProperty("copy_status", String.valueOf(i2));
                File d = m7915d();
                if (d != null) {
                    fileOutputStream = new FileOutputStream(d);
                    try {
                        k.store(fileOutputStream, "update tbsCore and status for copy!");
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    void m7909a(String str) {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            Properties k = m7905k();
            if (k != null) {
                k.setProperty("install_apk_path", str);
                File d = m7915d();
                if (d != null) {
                    fileOutputStream2 = new FileOutputStream(d);
                    try {
                        k.store(fileOutputStream2, "update tbsapk path!");
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream2 = null;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    int m7910b() {
        Properties k = m7905k();
        return (k == null || k.getProperty("copy_status") == null) ? -1 : Integer.parseInt(k.getProperty("copy_status"));
    }

    /* renamed from: b */
    void m7911b(int i) {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            Properties k = m7905k();
            if (k != null) {
                k.setProperty("dexopt_retry_num", String.valueOf(i));
                File d = m7915d();
                if (d != null) {
                    fileOutputStream2 = new FileOutputStream(d);
                    try {
                        k.store(fileOutputStream2, "update dexopt retry num!");
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream2 = null;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    void m7912b(int i, int i2) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            Properties k = m7905k();
            if (k != null) {
                k.setProperty("install_core_ver", String.valueOf(i));
                k.setProperty("install_status", String.valueOf(i2));
                File d = m7915d();
                if (d != null) {
                    fileOutputStream = new FileOutputStream(d);
                    try {
                        k.store(fileOutputStream, "update coreversion and status!");
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    /* renamed from: c */
    int m7913c() {
        Properties k = m7905k();
        return (k == null || k.getProperty("copy_retry_num") == null) ? 0 : Integer.parseInt(k.getProperty("copy_retry_num"));
    }

    /* renamed from: c */
    void m7914c(int i) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            Properties k = m7905k();
            if (k != null) {
                k.setProperty("unzip_retry_num", String.valueOf(i));
                File d = m7915d();
                if (d != null) {
                    fileOutputStream = new FileOutputStream(d);
                    try {
                        k.store(fileOutputStream, "update unzip retry num!");
                        fileOutputStream2 = fileOutputStream;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    /* renamed from: d */
    File m7915d() {
        ac.m7706a();
        File file = new File(ac.m7722h(f5107b), "tbscoreinstall.txt");
        if (file == null || file.exists()) {
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

    /* renamed from: d */
    void m7916d(int i) {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            Properties k = m7905k();
            if (k != null) {
                k.setProperty("incrupdate_status", String.valueOf(i));
                File d = m7915d();
                if (d != null) {
                    fileOutputStream2 = new FileOutputStream(d);
                    try {
                        k.store(fileOutputStream2, "update coreversion and status!");
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream2 = null;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: e */
    int m7917e() {
        Properties k = m7905k();
        return (k == null || k.getProperty("unzip_retry_num") == null) ? 0 : Integer.parseInt(k.getProperty("unzip_retry_num"));
    }

    /* renamed from: f */
    int m7918f() {
        Properties k = m7905k();
        return (k == null || k.getProperty("dexopt_retry_num") == null) ? 0 : Integer.parseInt(k.getProperty("dexopt_retry_num"));
    }

    /* renamed from: g */
    String m7919g() {
        Properties k = m7905k();
        return (k == null || k.getProperty("install_apk_path") == null) ? null : k.getProperty("install_apk_path");
    }

    /* renamed from: h */
    int m7920h() {
        Properties k = m7905k();
        return (k == null || k.getProperty("install_core_ver") == null) ? 0 : Integer.parseInt(k.getProperty("install_core_ver"));
    }

    /* renamed from: i */
    int m7921i() {
        Properties k = m7905k();
        return (k == null || k.getProperty("install_status") == null) ? -1 : Integer.parseInt(k.getProperty("install_status"));
    }

    /* renamed from: j */
    int m7922j() {
        Properties k = m7905k();
        return (k == null || k.getProperty("incrupdate_status") == null) ? -1 : Integer.parseInt(k.getProperty("incrupdate_status"));
    }
}
