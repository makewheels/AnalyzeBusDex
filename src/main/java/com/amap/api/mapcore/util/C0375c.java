package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.MotionEvent;

/* compiled from: RotateGestureDetector */
/* renamed from: com.amap.api.mapcore.util.c */
public class C0375c extends C0374d {
    /* renamed from: l */
    private final C0308a f2111l;
    /* renamed from: m */
    private boolean f2112m;

    /* compiled from: RotateGestureDetector */
    /* renamed from: com.amap.api.mapcore.util.c$a */
    public interface C0308a {
        /* renamed from: a */
        boolean mo328a(C0375c c0375c);

        /* renamed from: b */
        boolean mo329b(C0375c c0375c);

        /* renamed from: c */
        void mo330c(C0375c c0375c);
    }

    public C0375c(Context context, C0308a c0308a) {
        super(context);
        this.f2111l = c0308a;
    }

    /* renamed from: a */
    protected void mo609a(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                if (this.f2112m) {
                    this.f2112m = m3315d(motionEvent);
                    if (!this.f2112m) {
                        this.b = this.f2111l.mo329b(this);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                mo608a();
                this.c = MotionEvent.obtain(motionEvent);
                this.g = 0;
                mo607b(motionEvent);
                this.f2112m = m3315d(motionEvent);
                if (!this.f2112m) {
                    this.b = this.f2111l.mo329b(this);
                    return;
                }
                return;
            case 6:
                if (!this.f2112m) {
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    protected void mo610b(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                mo607b(motionEvent);
                if (this.e / this.f > 0.67f && this.f2111l.mo328a(this) && this.c != null) {
                    this.c.recycle();
                    this.c = MotionEvent.obtain(motionEvent);
                    return;
                }
                return;
            case 3:
                if (!this.f2112m) {
                    this.f2111l.mo330c(this);
                }
                mo608a();
                return;
            case 6:
                mo607b(motionEvent);
                if (!this.f2112m) {
                    this.f2111l.mo330c(this);
                }
                mo608a();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    protected void mo608a() {
        super.mo608a();
        this.f2112m = false;
    }

    /* renamed from: b */
    public float m3318b() {
        return (float) (((Math.atan2((double) this.i, (double) this.h) - Math.atan2((double) this.k, (double) this.j)) * 180.0d) / 3.141592653589793d);
    }
}
