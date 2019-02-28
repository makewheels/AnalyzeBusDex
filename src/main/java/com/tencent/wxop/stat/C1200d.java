package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C1192k;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.wxop.stat.d */
public class C1200d {
    /* renamed from: b */
    private static volatile C1200d f5507b = null;
    /* renamed from: a */
    private Timer f5508a = null;
    /* renamed from: c */
    private Context f5509c = null;

    private C1200d(Context context) {
        this.f5509c = context.getApplicationContext();
        this.f5508a = new Timer(false);
    }

    /* renamed from: a */
    public static C1200d m8341a(Context context) {
        if (f5507b == null) {
            synchronized (C1200d.class) {
                if (f5507b == null) {
                    f5507b = new C1200d(context);
                }
            }
        }
        return f5507b;
    }

    /* renamed from: a */
    public void m8342a() {
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.PERIOD) {
            long sendPeriodMinutes = (long) ((StatConfig.getSendPeriodMinutes() * 60) * 1000);
            if (StatConfig.isDebugEnable()) {
                C1192k.m8283b().m8243i("setupPeriodTimer delay:" + sendPeriodMinutes);
            }
            m8343a(new C1201e(this), sendPeriodMinutes);
        }
    }

    /* renamed from: a */
    public void m8343a(TimerTask timerTask, long j) {
        if (this.f5508a != null) {
            if (StatConfig.isDebugEnable()) {
                C1192k.m8283b().m8243i("setupPeriodTimer schedule delay:" + j);
            }
            this.f5508a.schedule(timerTask, j);
        } else if (StatConfig.isDebugEnable()) {
            C1192k.m8283b().m8245w("setupPeriodTimer schedule timer == null");
        }
    }
}
