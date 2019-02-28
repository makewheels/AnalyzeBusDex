package com.tencent.smtt.sdk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.sdk.a */
public class C1092a {
    /* renamed from: a */
    public static int f4946a = 600;
    /* renamed from: b */
    private static int f4947b = 0;

    /* renamed from: a */
    public static int m7702a() {
        IOException e;
        Throwable th;
        Throwable th2;
        int i = 0;
        if (f4947b > 0) {
            return f4947b;
        }
        String str = "/proc/meminfo";
        String str2 = bi_常量类.f6358b;
        BufferedReader bufferedReader;
        try {
            int indexOf;
            bufferedReader = new BufferedReader(new FileReader(str), 8192);
            do {
                try {
                    str = bufferedReader.readLine();
                    if (str == null) {
                        break;
                    }
                    indexOf = str.indexOf("MemTotal:");
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
            } while (-1 == indexOf);
            str = str.substring(indexOf + "MemTotal:".length()).trim();
            if (str != null && str.length() != 0 && str.contains("k")) {
                i = Integer.parseInt(str.substring(0, str.indexOf("k")).trim()) / 1024;
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (IOException e4) {
            e3 = e4;
            bufferedReader = null;
            try {
                e3.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
                f4947b = i;
                return f4947b;
            } catch (Throwable th4) {
                th2 = th4;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e322) {
                        e322.printStackTrace();
                    }
                }
                throw th2;
            }
        } catch (Throwable th5) {
            th2 = th5;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th2;
        }
        f4947b = i;
        return f4947b;
    }
}
