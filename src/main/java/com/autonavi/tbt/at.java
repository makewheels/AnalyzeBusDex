package com.autonavi.tbt;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import org.apache.http.HttpEntity;
import p054u.aly.bi_常量类;

/* compiled from: NetManger */
public class at {
    /* renamed from: a */
    private static at f3763a;
    /* renamed from: b */
    private az f3764b;
    /* renamed from: c */
    private Handler f3765c;

    /* compiled from: NetManger */
    /* renamed from: com.autonavi.tbt.at$1 */
    class C06081 extends ba {
        /* renamed from: a */
        final /* synthetic */ au f3760a;
        /* renamed from: b */
        final /* synthetic */ av f3761b;
        /* renamed from: c */
        final /* synthetic */ at f3762c;

        /* renamed from: a */
        public void mo737a() {
            try {
                this.f3762c.m4784a(this.f3762c.m4786b(this.f3760a, false), this.f3761b);
            } catch (C0618h e) {
                this.f3762c.m4785a(e, this.f3761b);
            }
        }
    }

    /* compiled from: NetManger */
    /* renamed from: com.autonavi.tbt.at$a */
    static class C0609a extends Handler {
        private C0609a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((ay) message.obj).f3772b.m4798a();
                        return;
                    case 1:
                        ay ayVar = (ay) message.obj;
                        ayVar.f3772b.m4799a(ayVar.f3771a);
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
    public static at m4777a() {
        return m4779a(true, 5);
    }

    /* renamed from: a */
    public static at m4778a(boolean z) {
        return m4779a(z, 5);
    }

    /* renamed from: a */
    private static synchronized at m4779a(boolean z, int i) {
        at atVar;
        synchronized (at.class) {
            try {
                if (f3763a == null) {
                    f3763a = new at(z, i);
                } else if (z) {
                    if (f3763a.f3764b == null) {
                        f3763a.f3764b = az.m4801a(i);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            atVar = f3763a;
        }
        return atVar;
    }

    private at(boolean z, int i) {
        if (z) {
            try {
                this.f3764b = az.m4801a(i);
            } catch (Throwable th) {
                ae.m4671a(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.f3765c = new C0609a(Looper.getMainLooper());
        } else {
            this.f3765c = new C0609a();
        }
    }

    /* renamed from: a */
    public byte[] m4788a(au auVar) throws C0618h {
        C0618h e;
        try {
            aw a = m4781a(auVar, false);
            if (a != null) {
                return a.f3769a;
            }
            return null;
        } catch (C0618h e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new C0618h("未知的错误");
        }
    }

    /* renamed from: b */
    public byte[] m4789b(au auVar) throws C0618h {
        C0618h e;
        try {
            aw b = m4786b(auVar, false);
            if (b != null) {
                return b.f3769a;
            }
            return null;
        } catch (C0618h e2) {
            throw e2;
        } catch (Throwable th) {
            e2 = new C0618h("未知的错误");
        }
    }

    /* renamed from: a */
    private aw m4781a(au auVar, boolean z) throws C0618h {
        C0618h e;
        HttpEntity d = auVar.mo751d();
        byte[] e2 = auVar.m4797e();
        try {
            Proxy proxy;
            m4787c(auVar);
            if (auVar.f3768g == null) {
                proxy = null;
            } else {
                proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(auVar.f3768g.getHostName(), auVar.f3768g.getPort()));
            }
            ar arVar = new ar(auVar.f3766e, auVar.f3767f, proxy, z);
            if (d == null && e2 == null) {
                return arVar.m4774b(auVar.mo750c(), auVar.mo748a(), auVar.mo749b());
            }
            if (e2 != null) {
                return arVar.m4772a(auVar.mo750c(), auVar.mo748a(), auVar.mo749b(), e2);
            }
            return arVar.m4771a(auVar.mo750c(), auVar.mo748a(), auVar.mo749b(), d);
        } catch (C0618h e3) {
            throw e3;
        } catch (Throwable th) {
            th.printStackTrace();
            e3 = new C0618h("未知的错误");
        }
    }

    /* renamed from: b */
    private aw m4786b(au auVar, boolean z) throws C0618h {
        C0618h e;
        try {
            Proxy proxy;
            m4787c(auVar);
            if (auVar.f3768g == null) {
                proxy = null;
            } else {
                proxy = new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(auVar.f3768g.getHostName(), auVar.f3768g.getPort()));
            }
            return new ar(auVar.f3766e, auVar.f3767f, proxy, z).m4770a(auVar.mo750c(), auVar.mo748a(), auVar.mo749b());
        } catch (C0618h e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new C0618h("未知的错误");
        }
    }

    /* renamed from: c */
    private void m4787c(au auVar) throws C0618h {
        if (auVar == null) {
            throw new C0618h("requeust is null");
        } else if (auVar.mo750c() == null || bi_常量类.f6358b.equals(auVar.mo750c())) {
            throw new C0618h("request url is empty");
        }
    }

    /* renamed from: a */
    private void m4785a(C0618h c0618h, av avVar) {
        ay ayVar = new ay();
        ayVar.f3771a = c0618h;
        ayVar.f3772b = avVar;
        Message obtain = Message.obtain();
        obtain.obj = ayVar;
        obtain.what = 1;
        this.f3765c.sendMessage(obtain);
    }

    /* renamed from: a */
    private void m4784a(aw awVar, av avVar) {
        avVar.m4800a(awVar.f3770b, awVar.f3769a);
        ay ayVar = new ay();
        ayVar.f3772b = avVar;
        Message obtain = Message.obtain();
        obtain.obj = ayVar;
        obtain.what = 0;
        this.f3765c.sendMessage(obtain);
    }
}
