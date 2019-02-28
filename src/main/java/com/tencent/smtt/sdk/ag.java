package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class ag implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ af f4961a;

    ag(af afVar) {
        this.f4961a = afVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".dex");
    }
}
