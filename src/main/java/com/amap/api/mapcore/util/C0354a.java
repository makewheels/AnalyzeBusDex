package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.smtt.sdk.WebView;

/* compiled from: BaseGestureDetector */
/* renamed from: com.amap.api.mapcore.util.a */
public abstract class C0354a {
    /* renamed from: a */
    protected final Context f1910a;
    /* renamed from: b */
    protected boolean f1911b;
    /* renamed from: c */
    protected MotionEvent f1912c;
    /* renamed from: d */
    protected MotionEvent f1913d;
    /* renamed from: e */
    protected float f1914e;
    /* renamed from: f */
    protected float f1915f;
    /* renamed from: g */
    protected long f1916g;

    /* renamed from: a */
    protected abstract void mo609a(int i, MotionEvent motionEvent);

    /* renamed from: b */
    protected abstract void mo610b(int i, MotionEvent motionEvent);

    public C0354a(Context context) {
        this.f1910a = context;
    }

    /* renamed from: a */
    public boolean m2998a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
        if (this.f1911b) {
            mo610b(action, motionEvent);
        } else {
            mo609a(action, motionEvent);
        }
        return true;
    }

    /* renamed from: b */
    protected void mo607b(MotionEvent motionEvent) {
        if (this.f1912c != null) {
            MotionEvent motionEvent2 = this.f1912c;
            if (this.f1913d != null) {
                this.f1913d.recycle();
                this.f1913d = null;
            }
            this.f1913d = MotionEvent.obtain(motionEvent);
            this.f1916g = motionEvent.getEventTime() - motionEvent2.getEventTime();
            this.f1914e = motionEvent.getPressure(m3001c(motionEvent));
            this.f1915f = motionEvent2.getPressure(m3001c(motionEvent2));
        }
    }

    /* renamed from: c */
    public final int m3001c(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    /* renamed from: a */
    protected void mo608a() {
        if (this.f1912c != null) {
            this.f1912c.recycle();
            this.f1912c = null;
        }
        if (this.f1913d != null) {
            this.f1913d.recycle();
            this.f1913d = null;
        }
        this.f1911b = false;
    }
}
