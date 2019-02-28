package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class NetworkMonitor {
    /* renamed from: a */
    private long f5193a = 0;
    /* renamed from: b */
    private int f5194b = 0;
    /* renamed from: c */
    private String f5195c = bi_常量类.f6358b_空串;
    /* renamed from: d */
    private int f5196d = 0;
    /* renamed from: e */
    private String f5197e = bi_常量类.f6358b_空串;

    public String getDomain() {
        return this.f5195c;
    }

    public long getMillisecondsConsume() {
        return this.f5193a;
    }

    public int getPort() {
        return this.f5196d;
    }

    public String getRemoteIp() {
        return this.f5197e;
    }

    public int getStatusCode() {
        return this.f5194b;
    }

    public void setDomain(String str) {
        this.f5195c = str;
    }

    public void setMillisecondsConsume(long j) {
        this.f5193a = j;
    }

    public void setPort(int i) {
        this.f5196d = i;
    }

    public void setRemoteIp(String str) {
        this.f5197e = str;
    }

    public void setStatusCode(int i) {
        this.f5194b = i;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f5193a);
            jSONObject.put("st", this.f5194b);
            if (this.f5195c != null) {
                jSONObject.put("dm", this.f5195c);
            }
            jSONObject.put("pt", this.f5196d);
            if (this.f5197e != null) {
                jSONObject.put("rip", this.f5197e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
