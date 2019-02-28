package com.amap.api.mapcore.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import org.apache.http.HttpEntity;
import p054u.aly.bi_常量类;

/* compiled from: NetManger */
public class bt {
    /* renamed from: a */
    private static bt f2094a;
    /* renamed from: b */
    private aw f2095b;
    /* renamed from: c */
    private Handler f2096c;

    /* compiled from: NetManger */
    /* renamed from: com.amap.api.mapcore.util.bt$1 */
    class C03721 extends ay {
        /* renamed from: b */
        final /* synthetic */ bu f2091b;
        /* renamed from: c */
        final /* synthetic */ bv f2092c;
        /* renamed from: d */
        final /* synthetic */ bt f2093d;

        /* renamed from: a */
        public void mo606a() {
            try {
                this.f2093d.m3300a(this.f2093d.m3302b(this.f2091b, false), this.f2092c);
            } catch (C0406v e) {
                this.f2093d.m3301a(e, this.f2092c);
            }
        }
    }

    /* compiled from: NetManger */
    /* renamed from: com.amap.api.mapcore.util.bt$a */
    static class C0373a extends Handler {
        private C0373a(Looper looper) {
            super(looper);
            Looper.prepare();
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((by) message.obj).f2100b.m3306a();
                        return;
                    case 1:
                        by byVar = (by) message.obj;
                        byVar.f2100b.m3307a(byVar.f2099a);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static bt m3293a() {
        return m3295a(true, 5);
    }

    /* renamed from: a */
    public static bt m3294a(boolean z) {
        return m3295a(z, 5);
    }

    /* renamed from: a */
    private static synchronized bt m3295a(boolean z, int i) {
        bt btVar;
        synchronized (bt.class) {
            try {
                if (f2094a == null) {
                    f2094a = new bt(z, i);
                } else if (z) {
                    if (f2094a.f2095b == null) {
                        f2094a.f2095b = aw.m3128a(i);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            btVar = f2094a;
        }
        return btVar;
    }

    private bt(boolean z, int i) {
        if (z) {
            try {
                this.f2095b = aw.m3128a(i);
            } catch (Throwable th) {
                az.m3143a(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f2096c = new C0373a(Looper.getMainLooper());
        } else {
            this.f2096c = new C0373a();
        }
    }

    /* renamed from: a */
    public byte[] m3304a(bu buVar) throws C0406v {
        C0406v e;
        try {
            bw a = m3297a(buVar, false);
            if (a != null) {
                return a.f2097a;
            }
            return null;
        } catch (C0406v e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new C0406v("未知的错误");
        }
    }

    /* renamed from: b */
    public byte[] m3305b(bu buVar) throws C0406v {
        C0406v e;
        try {
            bw b = m3302b(buVar, false);
            if (b != null) {
                return b.f2097a;
            }
            return null;
        } catch (C0406v e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new C0406v("未知的错误");
        }
    }

    /* renamed from: a */
    private bw m3297a(bu buVar, boolean z) throws C0406v {
        C0406v e;
        HttpEntity e2 = buVar.mo588e();
        byte[] a_ = buVar.a_();
        try {
            Proxy proxy;
            m3303c(buVar);
            if (buVar.f1933i == null) {
                proxy = null;
            } else {
                proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(buVar.f1933i.getHostName(), buVar.f1933i.getPort()));
            }
            br brVar = new br(buVar.f1931g, buVar.f1932h, proxy, z);
            if (e2 == null && a_ == null) {
                return brVar.m3291b(buVar.mo587d(), buVar.mo585b(), buVar.mo586c());
            }
            if (a_ != null) {
                return brVar.m3289a(buVar.mo587d(), buVar.mo585b(), buVar.mo586c(), a_);
            }
            return brVar.m3288a(buVar.mo587d(), buVar.mo585b(), buVar.mo586c(), e2);
        } catch (C0406v e3) {
            throw e3;
        } catch (Throwable th) {
            th.printStackTrace();
            e3 = new C0406v("未知的错误");
        }
    }

    /* renamed from: b */
    private bw m3302b(bu buVar, boolean z) throws C0406v {
        C0406v e;
        try {
            Proxy proxy;
            m3303c(buVar);
            if (buVar.f1933i == null) {
                proxy = null;
            } else {
                proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(buVar.f1933i.getHostName(), buVar.f1933i.getPort()));
            }
            return new br(buVar.f1931g, buVar.f1932h, proxy, z).m3287a(buVar.mo587d(), buVar.mo585b(), buVar.mo586c());
        } catch (C0406v e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new C0406v("未知的错误");
        }
    }

    /* renamed from: c */
    private void m3303c(bu buVar) throws C0406v {
        if (buVar == null) {
            throw new C0406v("requeust is null");
        } else if (buVar.mo587d() == null || bi_常量类.f6358b_空串.equals(buVar.mo587d())) {
            throw new C0406v("request url is empty");
        }
    }

    /* renamed from: a */
    private void m3301a(C0406v c0406v, bv bvVar) {
        by byVar = new by();
        byVar.f2099a = c0406v;
        byVar.f2100b = bvVar;
        Message obtain = Message.obtain();
        obtain.obj = byVar;
        obtain.what = 1;
        this.f2096c.sendMessage(obtain);
    }

    /* renamed from: a */
    private void m3300a(bw bwVar, bv bvVar) {
        bvVar.m3308a(bwVar.f2098b, bwVar.f2097a);
        by byVar = new by();
        byVar.f2100b = bvVar;
        Message obtain = Message.obtain();
        obtain.obj = byVar;
        obtain.what = 0;
        this.f2096c.sendMessage(obtain);
    }
}
