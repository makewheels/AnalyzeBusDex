package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;

/* compiled from: MultiTouchSupport */
/* renamed from: com.amap.api.mapcore.util.b */
public class C0360b {
    /* renamed from: a */
    protected Method f2005a;
    /* renamed from: b */
    protected Method f2006b;
    /* renamed from: c */
    protected Method f2007c;
    /* renamed from: d */
    private boolean f2008d = false;
    /* renamed from: e */
    private final C0303a f2009e;
    /* renamed from: f */
    private long f2010f = 0;
    /* renamed from: g */
    private boolean f2011g = false;

    /* compiled from: MultiTouchSupport */
    /* renamed from: com.amap.api.mapcore.util.b$a */
    public interface C0303a {
        /* renamed from: a */
        void mo325a();

        /* renamed from: a */
        void mo326a(float f, float f2, float f3, float f4, float f5);

        /* renamed from: a */
        boolean mo327a(MotionEvent motionEvent, float f, float f2, float f3, float f4);
    }

    public C0360b(Context context, C0303a c0303a) {
        this.f2009e = c0303a;
        m3148c();
    }

    /* renamed from: a */
    public boolean m3149a() {
        return this.f2011g;
    }

    /* renamed from: b */
    public long m3151b() {
        return this.f2010f;
    }

    /* renamed from: c */
    private void m3148c() {
        try {
            this.f2005a = MotionEvent.class.getMethod("getPointerCount", new Class[0]);
            this.f2006b = MotionEvent.class.getMethod("getX", new Class[]{Integer.TYPE});
            this.f2007c = MotionEvent.class.getMethod("getY", new Class[]{Integer.TYPE});
            this.f2008d = true;
        } catch (Throwable th) {
            this.f2008d = false;
            az.m3143a(th, "MultiTouchSupport", "initMethods");
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean m3150a(MotionEvent motionEvent) {
        if (!this.f2008d) {
            return false;
        }
        int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
        try {
            if (((Integer) this.f2005a.invoke(motionEvent, new Object[0])).intValue() < 2) {
                this.f2010f = 0;
                this.f2011g = false;
                return false;
            }
            Float f = (Float) this.f2006b.invoke(motionEvent, new Object[]{Integer.valueOf(0)});
            Float f2 = (Float) this.f2006b.invoke(motionEvent, new Object[]{Integer.valueOf(1)});
            Float f3 = (Float) this.f2007c.invoke(motionEvent, new Object[]{Integer.valueOf(0)});
            Float f4 = (Float) this.f2007c.invoke(motionEvent, new Object[]{Integer.valueOf(1)});
            float sqrt = (float) Math.sqrt((double) (((f2.floatValue() - f.floatValue()) * (f2.floatValue() - f.floatValue())) + ((f4.floatValue() - f3.floatValue()) * (f4.floatValue() - f3.floatValue()))));
            if (action == 5) {
                this.f2009e.mo326a(sqrt, f.floatValue(), f3.floatValue(), f2.floatValue(), f4.floatValue());
                this.f2011g = true;
                return true;
            } else if (action == 6) {
                this.f2010f = motionEvent.getEventTime();
                if (motionEvent.getPointerCount() == 2 && this.f2010f - motionEvent.getDownTime() < 100) {
                    this.f2009e.mo325a();
                }
                if (this.f2011g) {
                    this.f2011g = false;
                }
                return false;
            } else {
                if (this.f2011g && action == 2) {
                    return this.f2009e.mo327a(motionEvent, f.floatValue(), f3.floatValue(), f2.floatValue(), f4.floatValue());
                }
                return false;
            }
        } catch (Throwable th) {
            az.m3143a(th, "MultiTouchSupport", "onTouchEvent");
            th.printStackTrace();
        }
    }
}
