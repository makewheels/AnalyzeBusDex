package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* compiled from: TwoFingerGestureDetector */
/* renamed from: com.amap.api.mapcore.util.d */
public abstract class C0374d extends C0354a {
    /* renamed from: h */
    protected float f2102h;
    /* renamed from: i */
    protected float f2103i;
    /* renamed from: j */
    protected float f2104j;
    /* renamed from: k */
    protected float f2105k;
    /* renamed from: l */
    private final float f2106l;
    /* renamed from: m */
    private float f2107m;
    /* renamed from: n */
    private float f2108n;
    /* renamed from: o */
    private float f2109o;
    /* renamed from: p */
    private float f2110p;

    public C0374d(Context context) {
        super(context);
        this.f2106l = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    /* renamed from: b */
    protected void mo607b(MotionEvent motionEvent) {
        super.mo607b(motionEvent);
        if (this.c != null) {
            MotionEvent motionEvent2 = this.c;
            this.f2109o = -1.0f;
            this.f2110p = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1) - y;
            this.f2102h = x2 - x;
            this.f2103i = y2;
            y2 = motionEvent.getX(0);
            x = motionEvent.getY(0);
            x = motionEvent.getY(1) - x;
            this.f2104j = motionEvent.getX(1) - y2;
            this.f2105k = x;
        }
    }

    /* renamed from: c */
    public float m3314c() {
        if (this.f2109o == -1.0f) {
            float f = this.f2104j;
            float f2 = this.f2105k;
            this.f2109o = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }
        return this.f2109o;
    }

    /* renamed from: a */
    protected static float m3311a(MotionEvent motionEvent, int i) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        if (i < motionEvent.getPointerCount()) {
            return rawX + motionEvent.getX(i);
        }
        return 0.0f;
    }

    /* renamed from: b */
    protected static float m3312b(MotionEvent motionEvent, int i) {
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        if (i < motionEvent.getPointerCount()) {
            return rawY + motionEvent.getY(i);
        }
        return 0.0f;
    }

    /* renamed from: d */
    protected boolean m3315d(MotionEvent motionEvent) {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        this.f2107m = ((float) displayMetrics.widthPixels) - this.f2106l;
        this.f2108n = ((float) displayMetrics.heightPixels) - this.f2106l;
        float f = this.f2106l;
        float f2 = this.f2107m;
        float f3 = this.f2108n;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a = C0374d.m3311a(motionEvent, 1);
        float b = C0374d.m3312b(motionEvent, 1);
        boolean z = rawX < f || rawY < f || rawX > f2 || rawY > f3;
        boolean z2;
        if (a < f || b < f || a > f2 || b > f3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || r2) {
            return true;
        }
        return false;
    }
}
