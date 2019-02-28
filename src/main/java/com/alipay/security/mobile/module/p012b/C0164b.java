package com.alipay.security.mobile.module.p012b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* renamed from: com.alipay.security.mobile.module.b.b */
final class C0164b implements FileFilter {
    /* renamed from: a */
    final /* synthetic */ C0163a f484a;

    C0164b(C0163a c0163a) {
        this.f484a = c0163a;
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
