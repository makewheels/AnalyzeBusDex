package com.alipay.security.mobile.module.p010a;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.security.mobile.module.a.c */
public final class C0161c {
    /* renamed from: a */
    private static String f479a = bi_常量类.f6358b;
    /* renamed from: b */
    private static String f480b = bi_常量类.f6358b;
    /* renamed from: c */
    private static String f481c = bi_常量类.f6358b;

    /* renamed from: a */
    public static synchronized void m561a(String str) {
        synchronized (C0161c.class) {
            List arrayList = new ArrayList();
            arrayList.add(str);
            C0161c.m564a(arrayList);
        }
    }

    /* renamed from: a */
    public static synchronized void m562a(String str, String str2, String str3) {
        synchronized (C0161c.class) {
            f479a = str;
            f480b = str2;
            f481c = str3;
        }
    }

    /* renamed from: a */
    public static synchronized void m563a(Throwable th) {
        synchronized (C0161c.class) {
            List arrayList = new ArrayList();
            arrayList.add(C0161c.m565b(th));
            C0161c.m564a(arrayList);
        }
    }

    /* renamed from: a */
    private static synchronized void m564a(List<String> list) {
        synchronized (C0161c.class) {
            if (!(C0159a.m556a(f480b) || C0159a.m556a(f481c))) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(f481c);
                for (String str : list) {
                    stringBuffer.append(", " + str);
                }
                stringBuffer.append("\n");
                try {
                    File file = new File(f479a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(f479a, f480b);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileWriter fileWriter = file2.length() + ((long) stringBuffer.length()) <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                    fileWriter.write(stringBuffer.toString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception e) {
                    e.toString();
                }
            }
        }
    }

    /* renamed from: b */
    public static String m565b(Throwable th) {
        if (th == null) {
            return bi_常量类.f6358b;
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
