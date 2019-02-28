package com.tencent.wxop.stat.p053a;

import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.c */
public class C1169c {
    /* renamed from: a */
    public String f5299a;
    /* renamed from: b */
    public JSONArray f5300b;
    /* renamed from: c */
    public JSONObject f5301c = null;

    public C1169c(String str, String[] strArr, Properties properties) {
        this.f5299a = str;
        if (properties != null) {
            this.f5301c = new JSONObject(properties);
        } else if (strArr != null) {
            this.f5300b = new JSONArray();
            for (Object put : strArr) {
                this.f5300b.put(put);
            }
        } else {
            this.f5301c = new JSONObject();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1169c)) {
            return false;
        }
        return toString().equals(((C1169c) obj).toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.f5299a).append(",");
        if (this.f5300b != null) {
            stringBuilder.append(this.f5300b.toString());
        }
        if (this.f5301c != null) {
            stringBuilder.append(this.f5301c.toString());
        }
        return stringBuilder.toString();
    }
}
