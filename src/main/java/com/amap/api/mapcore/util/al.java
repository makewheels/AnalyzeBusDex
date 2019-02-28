package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

/* compiled from: LogDBOperation */
public class al {
    /* renamed from: a */
    private aj f1964a;

    public al(Context context) {
        this.f1964a = new aj(context);
    }

    /* renamed from: a */
    private am m3081a(int i) {
        switch (i) {
            case 0:
                return new ah();
            case 1:
                return new ak();
            case 2:
                return new ag();
            default:
                return null;
        }
    }

    /* renamed from: a */
    public void m3087a(String str, int i) {
        try {
            m3084c(str, i);
        } catch (Throwable th) {
            az.m3143a(th, "LogDB", "delLog");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m3089b(String str, int i) {
        try {
            m3084c(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m3084c(String str, int i) {
        this.f1964a.m3077a(am.m3066a(str), m3081a(i));
    }

    /* renamed from: a */
    public void m3086a(an anVar, int i) {
        try {
            aq a = m3081a(i);
            a.mo589a(anVar);
            this.f1964a.m3078b(am.m3066a(anVar.m3093b()), a);
        } catch (Throwable th) {
            az.m3143a(th, "LogDB", "updateLogInfo");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public List<an> m3085a(int i, int i2) {
        List<an> list = null;
        try {
            aq a = m3081a(i2);
            list = this.f1964a.m3079c(am.m3065a(i), a);
        } catch (Throwable th) {
            az.m3143a(th, "LogDB", "ByState");
            th.printStackTrace();
        }
        return list;
    }

    /* renamed from: b */
    public void m3088b(an anVar, int i) {
        try {
            am a = m3081a(i);
            switch (i) {
                case 0:
                    m3082a(anVar, a);
                    return;
                case 1:
                    m3083b(anVar, a);
                    return;
                case 2:
                    m3083b(anVar, a);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    /* renamed from: a */
    private void m3082a(an anVar, am amVar) {
        amVar.m3068a(anVar);
        this.f1964a.m3076a(amVar);
    }

    /* renamed from: b */
    private void m3083b(an anVar, am amVar) {
        String a = am.m3066a(anVar.m3093b());
        List c = this.f1964a.m3079c(a, amVar);
        if (c == null || c.size() == 0) {
            amVar.m3068a(anVar);
            this.f1964a.m3076a(amVar);
            return;
        }
        an anVar2 = (an) c.get(0);
        if (anVar.m3090a() == 0) {
            anVar2.m3094b(anVar2.m3097d() + 1);
        } else {
            anVar2.m3094b(0);
        }
        amVar.m3068a(anVar2);
        this.f1964a.m3078b(a, amVar);
    }
}
