package com.alipay.android.phone.mrpc.core.p003a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.p000a.p001a.C0006e;
import java.lang.reflect.Type;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.android.phone.mrpc.core.a.d */
public final class C0019d extends C0016a {
    public C0019d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    /* renamed from: a */
    public final Object mo12a() {
        try {
            String str = new String(this.b);
            new StringBuilder("threadid = ").append(Thread.currentThread().getId()).append("; rpc response:  ").append(str);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("resultStatus");
            if (i == 1000) {
                return this.a == String.class ? jSONObject.optString("result") : C0006e.m18a(jSONObject.optString("result"), this.a);
            } else {
                throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
            }
        } catch (Exception e) {
            throw new RpcException(Integer.valueOf(10), new StringBuilder("response  =").append(new String(this.b)).append(":").append(e).toString() == null ? bi_常量类.f6358b : e.getMessage());
        }
    }
}
