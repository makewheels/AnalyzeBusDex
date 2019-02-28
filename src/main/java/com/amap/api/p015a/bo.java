package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import p054u.aly.bi_常量类;

/* compiled from: ScaleView */
/* renamed from: com.amap.api.a.bo */
class bo extends View {
    /* renamed from: a */
    private String f912a = bi_常量类.f6358b_空串;
    /* renamed from: b */
    private int f913b = 0;
    /* renamed from: c */
    private C0222b f914c;
    /* renamed from: d */
    private Paint f915d;
    /* renamed from: e */
    private Paint f916e;
    /* renamed from: f */
    private Rect f917f;

    /* renamed from: a */
    public void m1495a() {
        this.f915d = null;
        this.f916e = null;
        this.f917f = null;
        this.f912a = null;
    }

    public bo(Context context, C0222b c0222b) {
        super(context);
        this.f914c = c0222b;
        this.f915d = new Paint();
        this.f917f = new Rect();
        this.f915d.setAntiAlias(true);
        this.f915d.setColor(-16777216);
        this.f915d.setStrokeWidth(2.0f * C0269x.f1180a);
        this.f915d.setStyle(Style.STROKE);
        this.f916e = new Paint();
        this.f916e.setAntiAlias(true);
        this.f916e.setColor(-16777216);
        this.f916e.setTextSize(20.0f * C0269x.f1180a);
    }

    protected void onDraw(Canvas canvas) {
        if (!this.f912a.equals(bi_常量类.f6358b_空串) && this.f913b != 0) {
            int i;
            int i2 = this.f913b;
            try {
                if (i2 > this.f914c.getWidth() / 5) {
                    i2 = this.f914c.getWidth() / 5;
                }
                i = i2;
            } catch (Exception e) {
                e.printStackTrace();
                i = i2;
            }
            Point A = this.f914c.m1173A();
            this.f916e.getTextBounds(this.f912a, 0, this.f912a.length(), this.f917f);
            if (A.x + i > this.f914c.getWidth() - 10) {
                i2 = (this.f914c.getWidth() - 10) - ((this.f917f.width() + i) / 2);
            } else {
                i2 = A.x + ((i - this.f917f.width()) / 2);
            }
            int height = (A.y - this.f917f.height()) + 5;
            canvas.drawText(this.f912a, (float) i2, (float) height, this.f916e);
            int width = i2 - ((i - this.f917f.width()) / 2);
            int height2 = height + (this.f917f.height() - 5);
            canvas.drawLine((float) width, (float) (height2 - 2), (float) width, (float) (height2 + 2), this.f915d);
            canvas.drawLine((float) width, (float) height2, (float) (width + i), (float) height2, this.f915d);
            canvas.drawLine((float) (width + i), (float) (height2 - 2), (float) (width + i), (float) (height2 + 2), this.f915d);
        }
    }

    /* renamed from: a */
    public void m1497a(String str) {
        this.f912a = str;
    }

    /* renamed from: a */
    public void m1496a(int i) {
        this.f913b = i;
    }
}
