package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class ae implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ ac f4957a;

    ae(ac acVar) {
        this.f4957a = acVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".jar");
    }
}
