package com.tencent.smtt.utils;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.utils.x */
public class C1160x {
    /* renamed from: e */
    private static C1160x f5178e = null;
    /* renamed from: a */
    public boolean f5179a = false;
    /* renamed from: b */
    private Context f5180b = null;
    /* renamed from: c */
    private File f5181c = null;
    /* renamed from: d */
    private boolean f5182d = false;
    /* renamed from: f */
    private File f5183f = null;

    private C1160x(Context context) {
        this.f5180b = context.getApplicationContext();
        m8069b();
    }

    /* renamed from: a */
    public static synchronized C1160x m8065a() {
        C1160x c1160x;
        synchronized (C1160x.class) {
            c1160x = f5178e;
        }
        return c1160x;
    }

    /* renamed from: a */
    public static synchronized C1160x m8066a(Context context) {
        C1160x c1160x;
        synchronized (C1160x.class) {
            if (f5178e == null) {
                f5178e = new C1160x(context);
            }
            c1160x = f5178e;
        }
        return c1160x;
    }

    /* renamed from: d */
    private File m8067d() {
        File file;
        try {
            if (this.f5181c == null) {
                this.f5181c = new File(this.f5180b.getDir("tbs", 0), "core_private");
                if (this.f5181c == null || !this.f5181c.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.f5181c, "debug.conf");
            if (!(file == null || file.exists())) {
                file.createNewFile();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            file = null;
        }
        return file;
    }

    /* renamed from: a */
    public void m8068a(boolean z) {
        this.f5182d = z;
        m8070c();
    }

    /* renamed from: b */
    public synchronized void m8069b() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            if (this.f5183f == null) {
                this.f5183f = m8067d();
            }
            if (this.f5183f == null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                fileInputStream = new FileInputStream(this.f5183f);
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    String property = properties.getProperty("setting_forceUseSystemWebview", bi_常量类.f6358b);
                    if (!bi_常量类.f6358b.equals(property)) {
                        this.f5179a = Boolean.parseBoolean(property);
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream.close();
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = fileInputStream2;
            fileInputStream.close();
            throw th;
        }
    }

    /* renamed from: c */
    public void m8070c() {
        OutputStream fileOutputStream;
        Throwable th;
        OutputStream outputStream;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        FileInputStream fileInputStream = null;
        try {
            File d = m8067d();
            if (d == null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    fileOutputStream3.close();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            Properties properties;
            fileInputStream = new FileInputStream(d);
            try {
                properties = new Properties();
                properties.load(fileInputStream);
                properties.setProperty("setting_forceUseSystemWebview", Boolean.toString(this.f5179a));
                properties.setProperty("result_systemWebviewForceUsed", Boolean.toString(this.f5182d));
                fileOutputStream = new FileOutputStream(d);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e222) {
                        e222.printStackTrace();
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e32) {
                        e32.printStackTrace();
                    }
                    throw th;
                }
            }
            try {
                properties.store(fileOutputStream, null);
                try {
                    fileInputStream.close();
                } catch (Exception e2222) {
                    e2222.printStackTrace();
                }
                try {
                    fileOutputStream.close();
                } catch (Exception e22222) {
                    e22222.printStackTrace();
                }
            } catch (Throwable th4) {
                th = th4;
                outputStream = fileOutputStream;
                fileInputStream.close();
                fileOutputStream2.close();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            fileInputStream.close();
            fileOutputStream2.close();
            throw th;
        }
    }
}
