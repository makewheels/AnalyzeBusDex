package com.amap.api.navi;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.tbt.C0615f;

/* compiled from: NaviSetting */
/* renamed from: com.amap.api.navi.f */
public class C0453f {
    /* renamed from: a */
    WakeLock f2710a;
    /* renamed from: b */
    boolean f2711b = true;
    /* renamed from: c */
    private boolean f2712c = true;
    /* renamed from: d */
    private boolean f2713d = true;
    /* renamed from: e */
    private boolean f2714e = true;
    /* renamed from: f */
    private boolean f2715f = false;
    /* renamed from: g */
    private Context f2716g;
    /* renamed from: h */
    private C0457h f2717h;
    /* renamed from: i */
    private PowerManager f2718i;

    C0453f(Context context, C0457h c0457h) {
        try {
            this.f2716g = context;
            this.f2717h = c0457h;
            if (this.f2716g != null) {
                this.f2718i = (PowerManager) this.f2716g.getSystemService("power");
                this.f2710a = this.f2718i.newWakeLock(10, GeocodeSearch.AMAP);
                this.f2710a.setReferenceCounted(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    /* renamed from: a */
    public void m3845a(boolean z) {
        this.f2712c = z;
        if (this.f2717h != null) {
            this.f2717h.m3898c(this.f2712c);
        }
    }

    /* renamed from: b */
    public void m3848b(boolean z) {
        this.f2713d = z;
        if (this.f2717h != null) {
            this.f2717h.m3902d(this.f2713d);
        }
    }

    /* renamed from: c */
    public void m3849c(boolean z) {
        this.f2714e = z;
        if (this.f2717h != null) {
            this.f2717h.m3905e(this.f2714e);
        }
    }

    /* renamed from: d */
    public void m3850d(boolean z) {
        this.f2715f = z;
        try {
            if (this.f2715f) {
                this.f2710a.acquire();
            } else if (this.f2710a.isHeld()) {
                this.f2710a.release();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }

    /* renamed from: e */
    public void m3851e(boolean z) {
        this.f2711b = z;
    }

    /* renamed from: a */
    public boolean m3846a() {
        return this.f2711b;
    }

    /* renamed from: b */
    void m3847b() {
        try {
            if (this.f2710a.isHeld()) {
                this.f2710a.release();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C0615f.m4834a(th);
        }
    }
}
