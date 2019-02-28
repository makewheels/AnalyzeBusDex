package com.autonavi.tbt;

import android.content.Context;
import com.alipay.sdk.cons.C0108a;
import com.amap.api.navi.C0457h;
import com.autonavi.tbt.C0629p.C0628a;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: NaviActionTask */
/* renamed from: com.autonavi.tbt.b */
public class C0610b extends C0597a {
    /* renamed from: l */
    String f3777l = null;

    public C0610b(C0457h c0457h, Context context, String str, int i, String str2, int i2, int i3, byte[] bArr, int i4) {
        C0629p a;
        super(c0457h, context, str, i, str2, i2, i3, bArr, i4);
        try {
            a = new C0628a(str2, "1.3.0", "AMAP_SDK_Android_NAVI_1.3.0").m4936a(C0615f.m4836a()).m4937a();
        } catch (C0618h e) {
            e.printStackTrace();
            a = null;
        }
        this.f3777l = C0621k.m4876a(this.i, a, null);
    }

    /* renamed from: a */
    public void mo737a() {
        Map hashMap = new HashMap();
        au c0612c = new C0612c();
        if (this.c == 0) {
            hashMap.clear();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("Connection", "Keep-Alive");
            hashMap.put("User-Agent", "AMAP_SDK_Android_NAVI_1.3.0");
            hashMap.put("X-INFO", this.f3777l);
            hashMap.put("ia", C0108a.f262e);
            hashMap.put("ec", C0108a.f262e);
            hashMap.put("key", C0619i.m4867f(this.i));
            c0612c.m4818a(hashMap);
            c0612c.m4817a(this.b);
            c0612c.m4819a(new ByteArrayEntity(this.g));
            c0612c.m4792a(C0626o.m4923a(this.i));
            try {
                this.h.m4788a(c0612c);
                return;
            } catch (C0618h e) {
                e.printStackTrace();
                return;
            }
        }
        c0612c.m4817a(this.b);
        c0612c.m4792a(C0626o.m4923a(this.i));
        try {
            this.h.m4789b(c0612c);
        } catch (C0618h e2) {
            e2.printStackTrace();
        }
    }
}
