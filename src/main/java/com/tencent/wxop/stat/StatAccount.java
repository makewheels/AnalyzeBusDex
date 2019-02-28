package com.tencent.wxop.stat;

import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1198q;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class StatAccount {
    public static final int CUSTOM_TYPE = 7;
    public static final int DEFAULT_TYPE = 0;
    public static final int EMAIL_TYPE = 6;
    public static final int PHONE_NUM_TYPE = 5;
    public static final int QQ_NUM_TYPE = 1;
    public static final int QQ_OPENID_TYPE = 3;
    public static final int WECHAT_ID_TYPE = 2;
    public static final int WECHAT_OPENID_TYPE = 4;
    /* renamed from: a */
    private String f5198a = bi_常量类.f6358b_空串;
    /* renamed from: b */
    private int f5199b = 0;
    /* renamed from: c */
    private String f5200c = bi_常量类.f6358b_空串;
    /* renamed from: d */
    private String f5201d = bi_常量类.f6358b_空串;

    public StatAccount(String str) {
        this.f5198a = str;
    }

    public StatAccount(String str, int i) {
        this.f5198a = str;
        this.f5199b = i;
    }

    public String getAccount() {
        return this.f5198a;
    }

    public int getAccountType() {
        return this.f5199b;
    }

    public String getExt() {
        return this.f5200c;
    }

    public String getExt1() {
        return this.f5201d;
    }

    public void setAccount(String str) {
        this.f5198a = str;
    }

    public void setAccountType(int i) {
        this.f5199b = i;
    }

    public void setExt(String str) {
        this.f5200c = str;
    }

    public void setExt1(String str) {
        this.f5201d = str;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        if (C1192k.m8287c(this.f5198a)) {
            try {
                C1198q.m8331a(jSONObject, "a", this.f5198a);
                jSONObject.put("t", this.f5199b);
                C1198q.m8331a(jSONObject, "e", this.f5200c);
                C1198q.m8331a(jSONObject, "e1", this.f5201d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "StatAccount [account=" + this.f5198a + ", accountType=" + this.f5199b + ", ext=" + this.f5200c + ", ext1=" + this.f5201d + "]";
    }
}
