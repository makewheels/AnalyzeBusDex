package com.tencent.p041a.p042a.p043a.p044a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.a.a.a.a.a */
final class C1036a {
    /* renamed from: a */
    static List<String> m7472a(File file) {
        Reader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine.trim());
            } else {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
        }
    }

    /* renamed from: d */
    static File m7473d(String str) {
        File file = new File(str);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                C1036a.m7473d(file.getParentFile().getAbsolutePath());
            }
            file.mkdir();
        }
        return file;
    }
}
