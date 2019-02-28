package com.tencent.smtt.utils;

import com.tencent.smtt.utils.C1146j.C1145b;
import java.io.InputStream;
import java.util.zip.ZipEntry;

/* renamed from: com.tencent.smtt.utils.k */
final class C1147k implements C1145b {
    /* renamed from: a */
    final /* synthetic */ String f5142a;

    C1147k(String str) {
        this.f5142a = str;
    }

    /* renamed from: a */
    public boolean mo1909a(InputStream inputStream, ZipEntry zipEntry, String str) {
        try {
            return C1146j.m7992b(inputStream, zipEntry, this.f5142a, str);
        } catch (Throwable e) {
            throw new Exception("copyFileIfChanged Exception", e);
        }
    }
}
