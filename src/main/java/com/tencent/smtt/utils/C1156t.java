package com.tencent.smtt.utils;

import android.content.Context;
import android.provider.Settings.System;
import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

/* renamed from: com.tencent.smtt.utils.t */
public class C1156t {
    /* renamed from: a */
    private static C1156t f5160a = null;
    /* renamed from: b */
    private static Context f5161b = null;

    private C1156t() {
    }

    /* renamed from: a */
    public static C1156t m8036a(Context context) {
        f5161b = context.getApplicationContext();
        if (f5160a == null) {
            f5160a = new C1156t();
        }
        return f5160a;
    }

    /* renamed from: b */
    private void m8037b(String str) {
        IOException e;
        Exception e2;
        Throwable th;
        if (C1146j.m7989b()) {
            DataOutputStream dataOutputStream = null;
            try {
                File file = new File(C1146j.m7994c(), "ins.dat");
                if (!file.exists()) {
                    file.createNewFile();
                }
                DataOutputStream dataOutputStream2 = new DataOutputStream(C1146j.m7996d(file));
                try {
                    dataOutputStream2.writeUTF(str);
                    dataOutputStream2.flush();
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e3) {
                            e = e3;
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    dataOutputStream = dataOutputStream2;
                    try {
                        e2.printStackTrace();
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e5) {
                                e = e5;
                                e.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = dataOutputStream2;
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e7) {
                e2 = e7;
                e2.printStackTrace();
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
            }
        }
    }

    /* renamed from: c */
    private void m8038c(String str) {
        try {
            System.putString(f5161b.getContentResolver(), "sys_setting_tbs_qb_installer", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m8039a(String str) {
        if (!TextUtils.isEmpty(str)) {
            m8037b(str);
            m8038c(str);
        }
    }
}
