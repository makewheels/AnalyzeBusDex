package com.tencent.smtt.utils;

import com.tencent.smtt.utils.C1146j.C1144a;
import java.io.File;

/* renamed from: com.tencent.smtt.utils.l */
final class C1148l implements C1144a {
    C1148l() {
    }

    /* renamed from: a */
    public boolean mo1910a(File file, File file2) {
        return file.length() == file2.length() && file.lastModified() == file2.lastModified();
    }
}
