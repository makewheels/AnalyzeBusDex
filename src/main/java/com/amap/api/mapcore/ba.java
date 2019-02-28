package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import p054u.aly.bi_常量类;

/* compiled from: ScaleView */
class ba extends View {
    /* renamed from: a */
    private String f1620a = bi_常量类.f6358b_空串;
    /* renamed from: b */
    private int f1621b = 0;
    /* renamed from: c */
    private AMapDelegateImpGLSurfaceView f1622c;
    /* renamed from: d */
    private Paint f1623d;
    /* renamed from: e */
    private Paint f1624e;
    /* renamed from: f */
    private Rect f1625f;

    /* renamed from: a */
    public void m2646a() {
        this.f1623d = null;
        this.f1624e = null;
        this.f1625f = null;
        this.f1620a = null;
    }

    public ba(Context context) {
        super(context);
    }

    public ba(Context context, AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        super(context);
        this.f1622c = aMapDelegateImpGLSurfaceView;
        this.f1623d = new Paint();
        this.f1625f = new Rect();
        this.f1623d.setAntiAlias(true);
        this.f1623d.setColor(-16777216);
        this.f1623d.setStrokeWidth(2.0f * C0344n.f1878a);
        this.f1623d.setStyle(Style.STROKE);
        this.f1624e = new Paint();
        this.f1624e.setAntiAlias(true);
        this.f1624e.setColor(-16777216);
        this.f1624e.setTextSize(20.0f * C0344n.f1878a);
    }

    protected void onDraw(Canvas canvas) {
        if (this.f1620a != null && !this.f1620a.equals(bi_常量类.f6358b_空串) && this.f1621b != 0) {
            Point D = this.f1622c.m2186D();
            if (D != null) {
                this.f1624e.getTextBounds(this.f1620a, 0, this.f1620a.length(), this.f1625f);
                int i = D.x;
                int height = (D.y - this.f1625f.height()) + 5;
                canvas.drawText(this.f1620a, (float) i, (float) height, this.f1624e);
                int height2 = height + (this.f1625f.height() - 5);
                canvas.drawLine((float) i, (float) (height2 - 2), (float) i, (float) (height2 + 2), this.f1623d);
                canvas.drawLine((float) i, (float) height2, (float) (this.f1621b + i), (float) height2, this.f1623d);
                canvas.drawLine((float) (this.f1621b + i), (float) (height2 - 2), (float) (this.f1621b + i), (float) (height2 + 2), this.f1623d);
            }
        }
    }

    /* renamed from: a */
    public void m2648a(String str) {
        this.f1620a = str;
    }

    /* renamed from: a */
    public void m2647a(int i) {
        this.f1621b = i;
    }
}
