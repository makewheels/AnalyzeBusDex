package com.alipay.apmobilesecuritysdk.p007c;

import com.alipay.security.mobile.module.p010a.C0159a;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* renamed from: com.alipay.apmobilesecuritysdk.c.a */
public final class C0062a {
    /* renamed from: a */
    private String f124a;
    /* renamed from: b */
    private String f125b;
    /* renamed from: c */
    private String f126c;
    /* renamed from: d */
    private String f127d;
    /* renamed from: e */
    private String f128e;
    /* renamed from: f */
    private String f129f;
    /* renamed from: g */
    private String f130g;

    public C0062a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f124a = str;
        this.f125b = str2;
        this.f126c = str3;
        this.f127d = str4;
        this.f128e = str5;
        this.f129f = str6;
        this.f130g = str7;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f124a);
        stringBuffer.append("," + this.f125b);
        stringBuffer.append("," + this.f126c);
        stringBuffer.append("," + this.f127d);
        if (C0159a.m556a(this.f128e) || this.f128e.length() < 20) {
            stringBuffer.append("," + this.f128e);
        } else {
            stringBuffer.append("," + this.f128e.substring(0, 20));
        }
        if (C0159a.m556a(this.f129f) || this.f129f.length() < 20) {
            stringBuffer.append("," + this.f129f);
        } else {
            stringBuffer.append("," + this.f129f.substring(0, 20));
        }
        if (C0159a.m556a(this.f130g) || this.f130g.length() < 20) {
            stringBuffer.append("," + this.f130g);
        } else {
            stringBuffer.append("," + this.f130g.substring(0, 20));
        }
        return stringBuffer.toString();
    }
}
