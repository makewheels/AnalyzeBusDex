package p054u.aly;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: CrashHandler */
/* renamed from: u.aly.m */
public class C1446m implements UncaughtExceptionHandler {
    /* renamed from: a */
    private UncaughtExceptionHandler f6576a;
    /* renamed from: b */
    private C1242t f6577b;

    public C1446m() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.f6576a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    /* renamed from: a */
    public void m10428a(C1242t c1242t) {
        this.f6577b = c1242t;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m10427a(th);
        if (this.f6576a != null && this.f6576a != Thread.getDefaultUncaughtExceptionHandler()) {
            this.f6576a.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    private void m10427a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f6577b.mo1917a(th);
        } else {
            this.f6577b.mo1917a(null);
        }
    }
}
