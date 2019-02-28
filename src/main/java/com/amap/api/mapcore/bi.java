package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.view.View;
import com.amap.api.mapcore.C0344n.C0343a;
import com.amap.api.mapcore.util.C0402s;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import java.io.InputStream;

/* compiled from: WaterMarkerView */
class bi extends View {
    /* renamed from: a */
    int f1723a = 10;
    /* renamed from: b */
    private Bitmap f1724b;
    /* renamed from: c */
    private Bitmap f1725c;
    /* renamed from: d */
    private Bitmap f1726d;
    /* renamed from: e */
    private Bitmap f1727e;
    /* renamed from: f */
    private Paint f1728f = new Paint();
    /* renamed from: g */
    private boolean f1729g = false;
    /* renamed from: h */
    private int f1730h = 0;
    /* renamed from: i */
    private AMapDelegateImpGLSurfaceView f1731i;
    /* renamed from: j */
    private int f1732j = 0;

    /* renamed from: a */
    public void m2812a() {
        try {
            if (this.f1724b != null) {
                this.f1724b.recycle();
            }
            if (this.f1725c != null) {
                this.f1725c.recycle();
            }
            this.f1724b = null;
            this.f1725c = null;
            if (this.f1726d != null) {
                this.f1726d.recycle();
                this.f1726d = null;
            }
            if (this.f1727e != null) {
                this.f1727e.recycle();
                this.f1727e = null;
            }
            this.f1728f = null;
        } catch (Throwable th) {
            az.m3143a(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public bi(Context context) {
        super(context);
    }

    public bi(Context context, AMapDelegateImpGLSurfaceView aMapDelegateImpGLSurfaceView) {
        super(context);
        this.f1731i = aMapDelegateImpGLSurfaceView;
        try {
            InputStream open;
            if (C0344n.f1881d == C0343a.ALIBABA) {
                open = C0402s.m3433a(context).open("apl.data");
            } else {
                open = C0402s.m3433a(context).open("ap.data");
            }
            this.f1726d = BitmapFactory.decodeStream(open);
            this.f1724b = C0405u.m3451a(this.f1726d, C0344n.f1878a);
            open.close();
            if (C0344n.f1881d == C0343a.ALIBABA) {
                open = C0402s.m3433a(context).open("apl1.data");
            } else {
                open = C0402s.m3433a(context).open("ap1.data");
            }
            this.f1727e = BitmapFactory.decodeStream(open);
            this.f1725c = C0405u.m3451a(this.f1727e, C0344n.f1878a);
            open.close();
            this.f1730h = this.f1725c.getHeight();
        } catch (Throwable th) {
            az.m3143a(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
        this.f1728f.setAntiAlias(true);
        this.f1728f.setColor(-16777216);
        this.f1728f.setStyle(Style.STROKE);
    }

    /* renamed from: b */
    public Bitmap m2815b() {
        if (this.f1729g) {
            return this.f1725c;
        }
        return this.f1724b;
    }

    /* renamed from: a */
    public void m2814a(boolean z) {
        this.f1729g = z;
        if (z) {
            this.f1728f.setColor(-1);
        } else {
            this.f1728f.setColor(-16777216);
        }
        invalidate();
    }

    /* renamed from: c */
    public Point m2816c() {
        return new Point(this.f1723a, (getHeight() - this.f1730h) - 10);
    }

    /* renamed from: a */
    public void m2813a(int i) {
        this.f1732j = i;
    }

    public void onDraw(Canvas canvas) {
        try {
            if (this.f1725c != null) {
                int width = this.f1725c.getWidth();
                if (this.f1732j == 1) {
                    this.f1723a = (this.f1731i.getWidth() - width) / 2;
                } else if (this.f1732j == 2) {
                    this.f1723a = (this.f1731i.getWidth() - width) - 10;
                } else {
                    this.f1723a = 10;
                }
                if (C0344n.f1881d == C0343a.ALIBABA) {
                    canvas.drawBitmap(m2815b(), (float) (this.f1723a + 15), (float) ((getHeight() - this.f1730h) - 8), this.f1728f);
                } else {
                    canvas.drawBitmap(m2815b(), (float) this.f1723a, (float) ((getHeight() - this.f1730h) - 8), this.f1728f);
                }
            }
        } catch (Throwable th) {
            az.m3143a(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }
}
