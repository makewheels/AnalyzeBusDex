package com.iflytek.cloud.p022a;

import android.content.Context;
import com.iflytek.cloud.p023b.p024e.C0944c;
import com.iflytek.cloud.p023b.p024e.C0948g;
import com.iflytek.cloud.p023b.p024e.C0948g.C0917a;
import org.apache.http.util.EncodingUtils;

/* renamed from: com.iflytek.cloud.a.e */
final class C0918e implements C0917a {
    /* renamed from: a */
    final /* synthetic */ Context f4379a;
    /* renamed from: b */
    final /* synthetic */ C0916d f4380b;

    C0918e(C0916d c0916d, Context context) {
        this.f4380b = c0916d;
        this.f4379a = context;
    }

    /* renamed from: a */
    public void mo1563a(C0948g c0948g, byte[] bArr) {
        if (bArr != null) {
            try {
                String string = EncodingUtils.getString(C0944c.m7137b(bArr), "utf-8");
                if (!C0948g.m7153a(string)) {
                    this.f4380b.f4378c.m7011a(string);
                    this.f4380b.m6996c();
                }
                C0913a.m6973a(this.f4379a).m6978a("ad_last_update", System.currentTimeMillis());
            } catch (Exception e) {
            }
        }
        this.f4380b.f4377b = null;
    }

    /* renamed from: a */
    public void mo1564a(Exception exception) {
        if (exception != null) {
            exception.printStackTrace();
        }
        this.f4380b.f4377b = null;
    }

    /* renamed from: a */
    public void mo1565a(byte[] bArr) {
    }
}
