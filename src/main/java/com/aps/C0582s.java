package com.aps;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: Util */
/* renamed from: com.aps.s */
final class C0582s {
    /* renamed from: a */
    static final Charset f3551a = Charset.forName("US-ASCII");
    /* renamed from: b */
    static final Charset f3552b = Charset.forName("UTF-8");

    private C0582s() {
    }

    /* renamed from: a */
    static void m4568a(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                C0582s.m4568a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    /* renamed from: a */
    static void m4567a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }
}
