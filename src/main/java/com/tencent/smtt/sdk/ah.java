package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class ah implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ af f4962a;

    ah(af afVar) {
        this.f4962a = afVar;
    }

    public boolean accept(File file) {
        return file.getName().endsWith("tbs.conf");
    }
}
