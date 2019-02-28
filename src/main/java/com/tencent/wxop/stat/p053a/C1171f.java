package com.tencent.wxop.stat.p053a;

import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.wxop.stat.a.f */
public enum C1171f {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(ErrorCode.ERROR_COREVERSION_CHANGED);
    
    /* renamed from: j */
    private int f5316j;

    private C1171f(int i) {
        this.f5316j = i;
    }

    /* renamed from: a */
    public final int m8151a() {
        return this.f5316j;
    }
}
