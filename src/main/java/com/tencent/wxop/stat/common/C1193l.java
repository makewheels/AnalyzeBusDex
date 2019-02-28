package com.tencent.wxop.stat.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.wxop.stat.common.l */
class C1193l {
    /* renamed from: a */
    static int m8316a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C1194m()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* renamed from: b */
    static int m8317b() {
        int i = 0;
        try {
            String str = bi_常量类.f6358b_空串;
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable e) {
            C1192k.f5490k.m8242e(e);
        }
        return i * 1000;
    }

    /* renamed from: c */
    static int m8318c() {
        int i = 0;
        try {
            String str = bi_常量类.f6358b_空串;
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable th) {
            C1192k.f5490k.m8242e(th);
        }
        return i * 1000;
    }

    /* renamed from: d */
    static String m8319d() {
        int i = 2;
        String[] strArr = new String[]{bi_常量类.f6358b_空串, bi_常量类.f6358b_空串};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            while (i < split.length) {
                strArr[0] = strArr[0] + split[i] + " ";
                i++;
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        return strArr[0];
    }
}
