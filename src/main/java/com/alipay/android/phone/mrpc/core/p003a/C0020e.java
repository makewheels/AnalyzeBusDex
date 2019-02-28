package com.alipay.android.phone.mrpc.core.p003a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.p000a.p001a.C0007f;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.android.phone.mrpc.core.a.e */
public final class C0020e extends C0018b {
    /* renamed from: c */
    private int f8c;
    /* renamed from: d */
    private Object f9d;

    public C0020e(int i, String str, Object obj) {
        super(str, obj);
        this.f8c = i;
    }

    /* renamed from: a */
    public final void mo13a(Object obj) {
        this.f9d = obj;
    }

    /* renamed from: a */
    public final byte[] mo14a() {
        try {
            List arrayList = new ArrayList();
            if (this.f9d != null) {
                arrayList.add(new BasicNameValuePair("extParam", C0007f.m19a(this.f9d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.a));
            arrayList.add(new BasicNameValuePair("id", this.f8c));
            new StringBuilder("mParams is:").append(this.b);
            arrayList.add(new BasicNameValuePair("requestData", this.b == null ? "[]" : C0007f.m19a(this.b)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Throwable e) {
            Throwable th = e;
            throw new RpcException(Integer.valueOf(9), new StringBuilder("request  =").append(this.b).append(":").append(th).toString() == null ? bi_常量类.f6358b_空串 : th.getMessage(), th);
        }
    }
}
