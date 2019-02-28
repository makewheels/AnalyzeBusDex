package com.tencent.mm.sdk.p046a.p047a;

import com.tencent.mm.p045a.C1044a;

/* renamed from: com.tencent.mm.sdk.a.a.b */
public final class C1048b {
    /* renamed from: a */
    public static byte[] m7506a(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C1044a.m7504c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
