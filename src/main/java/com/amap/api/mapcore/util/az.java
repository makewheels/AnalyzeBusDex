package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import p054u.aly.bi_常量类;

/* compiled from: SDKLogHandler */
public class az implements UncaughtExceptionHandler {
    /* renamed from: a */
    private static az f2000a;
    /* renamed from: e */
    private static ExecutorService f2001e;
    /* renamed from: b */
    private UncaughtExceptionHandler f2002b;
    /* renamed from: c */
    private Context f2003c;
    /* renamed from: d */
    private boolean f2004d = true;

    /* compiled from: SDKLogHandler */
    /* renamed from: com.amap.api.mapcore.util.az$a */
    private static class C0359a implements bs {
        /* renamed from: a */
        private Context f1999a;

        C0359a(Context context) {
            this.f1999a = context;
        }

        /* renamed from: a */
        public void mo595a() {
            try {
                bg.m3218b(this.f1999a);
            } catch (Throwable th) {
                az.m3143a(th, "LogNetListener", "onNetCompleted");
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static synchronized ExecutorService m3140a() {
        ExecutorService executorService;
        synchronized (az.class) {
            try {
                if (f2001e == null || f2001e.isShutdown()) {
                    f2001e = Executors.newSingleThreadExecutor();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            executorService = f2001e;
        }
        return executorService;
    }

    /* renamed from: a */
    public static synchronized az m3139a(Context context, ad adVar) throws C0406v {
        az azVar;
        synchronized (az.class) {
            if (adVar == null) {
                throw new C0406v("sdk info is null");
            } else if (adVar.m3033a() == null || bi_常量类.f6358b.equals(adVar.m3033a())) {
                throw new C0406v("sdk name is invalid");
            } else {
                try {
                    if (f2000a == null) {
                        f2000a = new az(context, adVar);
                    } else {
                        f2000a.f2004d = false;
                    }
                    f2000a.m3141a(context, adVar, f2000a.f2004d);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                azVar = f2000a;
            }
        }
        return azVar;
    }

    /* renamed from: b */
    public static synchronized az m3144b() {
        az azVar;
        synchronized (az.class) {
            azVar = f2000a;
        }
        return azVar;
    }

    /* renamed from: a */
    public static void m3143a(Throwable th, String str, String str2) {
        if (f2000a != null) {
            f2000a.m3142a(th, 1, str, str2);
        }
    }

    /* renamed from: c */
    public static synchronized void m3145c() {
        synchronized (az.class) {
            try {
                if (f2001e != null) {
                    f2001e.shutdown();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(f2000a == null || Thread.getDefaultUncaughtExceptionHandler() != f2000a || f2000a.f2002b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(f2000a.f2002b);
                }
                f2000a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private az(Context context, ad adVar) {
        this.f2003c = context;
        br.m3285a(new C0359a(context));
        m3146d();
    }

    /* renamed from: d */
    private void m3146d() {
        try {
            this.f2002b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.f2002b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f2004d = true;
            } else if (this.f2002b.toString().indexOf("com.amap.api") != -1) {
                this.f2004d = false;
            } else {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f2004d = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            m3142a(th, 0, null, null);
            if (this.f2002b != null) {
                this.f2002b.uncaughtException(thread, th);
            }
        }
    }

    /* renamed from: b */
    public void m3147b(Throwable th, String str, String str2) {
        if (th != null) {
            try {
                m3142a(th, 1, str, str2);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m3142a(Throwable th, int i, String str, String str2) {
        bg.m3217a(this.f2003c, th, i, str, str2);
    }

    /* renamed from: a */
    private void m3141a(final Context context, final ad adVar, final boolean z) {
        try {
            ExecutorService a = m3140a();
            if (a != null && !a.isShutdown()) {
                a.submit(new Runnable(this) {
                    /* renamed from: d */
                    final /* synthetic */ az f1998d;

                    public void run() {
                        try {
                            synchronized (Looper.getMainLooper()) {
                                new ao(context).m3100a(adVar);
                            }
                            if (z) {
                                synchronized (Looper.getMainLooper()) {
                                    ar arVar = new ar(context);
                                    at atVar = new at();
                                    atVar.m3124c(true);
                                    atVar.m3120a(true);
                                    atVar.m3122b(true);
                                    arVar.m3113a(atVar);
                                }
                                bg.m3216a(this.f1998d.f2003c);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (RejectedExecutionException e) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
