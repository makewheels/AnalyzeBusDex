package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1197p;
import com.tencent.wxop.stat.p053a.C1166e;

class aq {
    /* renamed from: f */
    private static volatile long f5374f = 0;
    /* renamed from: a */
    private C1166e f5375a;
    /* renamed from: b */
    private StatReportStrategy f5376b = null;
    /* renamed from: c */
    private boolean f5377c = false;
    /* renamed from: d */
    private Context f5378d = null;
    /* renamed from: e */
    private long f5379e = System.currentTimeMillis();

    public aq(C1166e c1166e) {
        this.f5375a = c1166e;
        this.f5376b = StatConfig.getStatSendStrategy();
        this.f5377c = c1166e.m8139f();
        this.f5378d = c1166e.m8138e();
    }

    /* renamed from: a */
    private void m8184a(C1179h c1179h) {
        C1204i.m8353b(StatServiceImpl.f5278t).m8354a(this.f5375a, c1179h);
    }

    /* renamed from: b */
    private void m8186b() {
        if (this.f5375a.m8137d() != null && this.f5375a.m8137d().isSendImmediately()) {
            this.f5376b = StatReportStrategy.INSTANT;
        }
        if (StatConfig.f5237j && C1178a.m8165a(StatServiceImpl.f5278t).m8177e()) {
            this.f5376b = StatReportStrategy.INSTANT;
        }
        if (StatConfig.isDebugEnable()) {
            StatServiceImpl.f5275q.m8243i("strategy=" + this.f5376b.name());
        }
        switch (ag.f5352a[this.f5376b.ordinal()]) {
            case 1:
                m8187c();
                return;
            case 2:
                au.m8199a(this.f5378d).m8228a(this.f5375a, null, this.f5377c, false);
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f5275q.m8243i("PERIOD currTime=" + this.f5379e + ",nextPeriodSendTs=" + StatServiceImpl.f5261c + ",difftime=" + (StatServiceImpl.f5261c - this.f5379e));
                }
                if (StatServiceImpl.f5261c == 0) {
                    StatServiceImpl.f5261c = C1197p.m8322a(this.f5378d, "last_period_ts", 0);
                    if (this.f5379e > StatServiceImpl.f5261c) {
                        StatServiceImpl.m8124e(this.f5378d);
                    }
                    long sendPeriodMinutes = this.f5379e + ((long) ((StatConfig.getSendPeriodMinutes() * 60) * 1000));
                    if (StatServiceImpl.f5261c > sendPeriodMinutes) {
                        StatServiceImpl.f5261c = sendPeriodMinutes;
                    }
                    C1200d.m8341a(this.f5378d).m8342a();
                }
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f5275q.m8243i("PERIOD currTime=" + this.f5379e + ",nextPeriodSendTs=" + StatServiceImpl.f5261c + ",difftime=" + (StatServiceImpl.f5261c - this.f5379e));
                }
                if (this.f5379e > StatServiceImpl.f5261c) {
                    StatServiceImpl.m8124e(this.f5378d);
                    return;
                }
                return;
            case 3:
            case 4:
                au.m8199a(this.f5378d).m8228a(this.f5375a, null, this.f5377c, false);
                return;
            case 5:
                au.m8199a(this.f5378d).m8228a(this.f5375a, new ar(this), this.f5377c, true);
                return;
            case 6:
                if (C1178a.m8165a(StatServiceImpl.f5278t).m8175c() == 1) {
                    m8187c();
                    return;
                } else {
                    au.m8199a(this.f5378d).m8228a(this.f5375a, null, this.f5377c, false);
                    return;
                }
            case 7:
                if (C1192k.m8291e(this.f5378d)) {
                    m8184a(new as(this));
                    return;
                }
                return;
            default:
                StatServiceImpl.f5275q.error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
                return;
        }
    }

    /* renamed from: c */
    private void m8187c() {
        if (au.m8213b().f5386a <= 0 || !StatConfig.f5239l) {
            m8184a(new at(this));
            return;
        }
        au.m8213b().m8228a(this.f5375a, null, this.f5377c, true);
        au.m8213b().m8227a(-1);
    }

    /* renamed from: d */
    private boolean m8189d() {
        if (StatConfig.f5235h > 0) {
            if (this.f5379e > StatServiceImpl.f5266h) {
                StatServiceImpl.f5265g.clear();
                StatServiceImpl.f5266h = this.f5379e + StatConfig.f5236i;
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f5275q.m8243i("clear methodsCalledLimitMap, nextLimitCallClearTime=" + StatServiceImpl.f5266h);
                }
            }
            Integer valueOf = Integer.valueOf(this.f5375a.mo1911a().m8151a());
            Integer num = (Integer) StatServiceImpl.f5265g.get(valueOf);
            if (num != null) {
                StatServiceImpl.f5265g.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > StatConfig.f5235h) {
                    if (StatConfig.isDebugEnable()) {
                        StatServiceImpl.f5275q.m8241e("event " + this.f5375a.m8140g() + " was discard, cause of called limit, current:" + num + ", limit:" + StatConfig.f5235h + ", period:" + StatConfig.f5236i + " ms");
                    }
                    return true;
                }
            }
            StatServiceImpl.f5265g.put(valueOf, Integer.valueOf(1));
        }
        return false;
    }

    /* renamed from: a */
    public void m8190a() {
        if (!m8189d()) {
            if (StatConfig.f5240m > 0 && this.f5379e >= f5374f) {
                StatServiceImpl.flushDataToDB(this.f5378d);
                f5374f = this.f5379e + StatConfig.f5241n;
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f5275q.m8243i("nextFlushTime=" + f5374f);
                }
            }
            if (C1178a.m8165a(this.f5378d).m8178f()) {
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f5275q.m8243i("sendFailedCount=" + StatServiceImpl.f5259a);
                }
                if (StatServiceImpl.m8112a()) {
                    au.m8199a(this.f5378d).m8228a(this.f5375a, null, this.f5377c, false);
                    if (this.f5379e - StatServiceImpl.f5260b > 1800000) {
                        StatServiceImpl.m8122d(this.f5378d);
                        return;
                    }
                    return;
                }
                m8186b();
                return;
            }
            au.m8199a(this.f5378d).m8228a(this.f5375a, null, this.f5377c, false);
        }
    }
}
