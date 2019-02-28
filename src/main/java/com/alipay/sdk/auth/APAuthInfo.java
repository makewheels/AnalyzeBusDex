package com.alipay.sdk.auth;

public class APAuthInfo {
    /* renamed from: a */
    private String f199a;
    /* renamed from: b */
    private String f200b;
    /* renamed from: c */
    private String f201c;
    /* renamed from: d */
    private String f202d;

    public APAuthInfo(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    public APAuthInfo(String str, String str2, String str3, String str4) {
        this.f199a = str;
        this.f200b = str2;
        this.f202d = str3;
        this.f201c = str4;
    }

    public String getAppId() {
        return this.f199a;
    }

    public String getPid() {
        return this.f201c;
    }

    public String getProductId() {
        return this.f200b;
    }

    public String getRedirectUri() {
        return this.f202d;
    }
}
