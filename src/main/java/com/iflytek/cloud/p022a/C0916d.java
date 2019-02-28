package com.iflytek.cloud.p022a;

import android.content.Context;
import com.iflytek.cloud.p023b.p024e.C0944c;
import com.iflytek.cloud.p023b.p024e.C0945d;
import com.iflytek.cloud.p023b.p024e.C0948g;
import com.iflytek.cloud.p023b.p024e.C0948g.C0917a;
import java.io.UnsupportedEncodingException;
import org.apache.http.util.EncodingUtils;

/* renamed from: com.iflytek.cloud.a.d */
public class C0916d {
    /* renamed from: a */
    private static C0916d f4376a = null;
    /* renamed from: b */
    private C0948g f4377b;
    /* renamed from: c */
    private C0919f f4378c;

    private C0916d() {
        this.f4377b = null;
        this.f4378c = null;
        this.f4378c = new C0919f();
        m6994b();
    }

    /* renamed from: a */
    public static C0916d m6991a() {
        if (f4376a == null) {
            f4376a = new C0916d();
        }
        return f4376a;
    }

    /* renamed from: b */
    private void m6994b() {
        try {
            byte[] b = C0945d.m7143b(C0945d.m7138a(null) + "links.dat");
            if (b != null) {
                this.f4378c.m7011a(EncodingUtils.getString(C0944c.m7137b(b), "utf-8"));
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: c */
    private synchronized void m6996c() {
        try {
            C0945d.m7142a(C0944c.m7136a(this.f4378c.toString().getBytes("utf-8")), C0945d.m7138a(null) + "links.dat", false, 0);
        } catch (UnsupportedEncodingException e) {
        }
    }

    /* renamed from: a */
    public synchronized void m6997a(Context context) {
        if (this.f4378c.m7012a(context) && this.f4377b == null) {
            try {
                this.f4377b = new C0948g();
                this.f4377b.m7159a(1);
                C0917a c0918e = new C0918e(this, context);
                C0914b c0914b = new C0914b(context);
                c0914b.m6982a("ver", this.f4378c.m7007a());
                this.f4377b.m7161a("http://service.voicecloud.cn/mscAd/ad_version.php", null, C0944c.m7136a(c0914b.m6981a(true).toString().getBytes("utf-8")));
                this.f4377b.m7160a(c0918e);
            } catch (Exception e) {
                this.f4377b = null;
            }
        }
    }

    /* renamed from: a */
    public void m6998a(C0915c c0915c) {
        if (c0915c.m6985a()) {
            c0915c.m6989e();
            if (!c0915c.m6988d()) {
                this.f4378c.m7010a(c0915c);
            }
            m6996c();
        }
    }

    /* renamed from: b */
    public C0915c m6999b(Context context) {
        return this.f4378c.m7013b(context);
    }
}
