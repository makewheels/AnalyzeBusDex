package com.alipay.security.mobile.module.p013c;

import android.os.Environment;
import com.alipay.security.mobile.module.p013c.p014a.C0166a;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.security.mobile.module.c.a */
public final class C0167a {
    /* renamed from: a */
    public static String m612a(String str) {
        String str2 = bi_常量类.f6358b;
        try {
            str2 = System.getProperty(str);
        } catch (Throwable th) {
        }
        return C0166a.m610a(str2) ? C0168b.m614a(".SystemConfig" + File.separator + str) : str2;
    }

    /* renamed from: a */
    public static void m613a(String str, String str2) {
        FileWriter fileWriter;
        Throwable th;
        try {
            if (!C0166a.m610a(str2)) {
                System.setProperty(str, str2);
            }
        } catch (Throwable th2) {
        }
        if (C0168b.m615a()) {
            String str3 = ".SystemConfig" + File.separator + str;
            try {
                if (C0168b.m615a()) {
                    File file = new File(Environment.getExternalStorageDirectory(), str3);
                    if (!file.exists()) {
                        file.getParentFile().mkdirs();
                    }
                    File file2 = new File(file.getAbsolutePath());
                    FileWriter fileWriter2 = null;
                    try {
                        fileWriter = new FileWriter(file2, false);
                        try {
                            fileWriter.write(str2);
                            try {
                                fileWriter.close();
                            } catch (IOException e) {
                            }
                        } catch (Exception e2) {
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException e3) {
                                }
                            }
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            fileWriter2 = fileWriter;
                            th = th4;
                            if (fileWriter2 != null) {
                                try {
                                    fileWriter2.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        fileWriter = null;
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileWriter2 != null) {
                            fileWriter2.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
            }
        }
    }
}
