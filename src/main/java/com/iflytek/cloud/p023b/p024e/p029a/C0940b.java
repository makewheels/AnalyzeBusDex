package com.iflytek.cloud.p023b.p024e.p029a;

import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.C0943b;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.iflytek.cloud.b.e.a.b */
public class C0940b {
    /* renamed from: a */
    private static RandomAccessFile f4475a = null;
    /* renamed from: b */
    private static boolean f4476b = false;
    /* renamed from: c */
    private static Object f4477c = new Object();

    /* renamed from: a */
    public static void m7123a(String str, String str2, String str3) {
        if (f4475a != null) {
            synchronized (f4477c) {
                try {
                    byte[] bytes = C0940b.m7125b(str, str2, str3).getBytes("gb2312");
                    f4475a.write(bytes, 0, bytes.length);
                } catch (IOException e) {
                    C0939a.m7120a(e.toString());
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m7124a() {
        return f4476b;
    }

    /* renamed from: b */
    private static String m7125b(String str, String str2, String str3) {
        String str4 = "[";
        str4 = "]";
        String str5 = "[" + C0943b.m7134b(System.currentTimeMillis()) + "]";
        if (!TextUtils.isEmpty(str3)) {
            str5 = str5 + "[" + str3 + "]";
        }
        return (str5 + "[" + str + "]") + " " + str2 + "\n";
    }
}
