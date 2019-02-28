package com.amap.api.p015a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.amap.api.p015a.C0269x.C0268a;
import com.amap.api.p015a.p016a.C0204q;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: WaterMarkerView */
/* renamed from: com.amap.api.a.cf */
class cf extends View {
    /* renamed from: a */
    Rect f994a = new Rect();
    /* renamed from: b */
    int f995b = 10;
    /* renamed from: c */
    private Bitmap f996c;
    /* renamed from: d */
    private Bitmap f997d;
    /* renamed from: e */
    private Paint f998e = new Paint();
    /* renamed from: f */
    private boolean f999f = false;
    /* renamed from: g */
    private int f1000g = 0;
    /* renamed from: h */
    private C0222b f1001h;
    /* renamed from: i */
    private int f1002i = 0;

    /* renamed from: a */
    public void m1615a() {
        try {
            if (this.f996c != null) {
                this.f996c.recycle();
            }
            if (this.f997d != null) {
                this.f997d.recycle();
            }
            this.f996c = null;
            this.f997d = null;
            this.f998e = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public cf(Context context, C0222b c0222b) {
        super(context);
        this.f1001h = c0222b;
        AssetManager assets = context.getResources().getAssets();
        try {
            InputStream open;
            if (C0269x.f1184e == C0268a.ALIBABA) {
                open = assets.open("apl.data");
            } else {
                open = assets.open("ap.data");
            }
            this.f996c = BitmapFactory.decodeStream(open);
            this.f996c = C0204q.m795a(this.f996c, C0269x.f1180a);
            open.close();
            if (C0269x.f1184e == C0268a.ALIBABA) {
                open = assets.open("apl1.data");
            } else {
                open = assets.open("ap1.data");
            }
            this.f997d = BitmapFactory.decodeStream(open);
            this.f997d = C0204q.m795a(this.f997d, C0269x.f1180a);
            open.close();
            this.f1000g = this.f997d.getHeight();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f998e.setAntiAlias(true);
        this.f998e.setColor(-16777216);
        this.f998e.setStyle(Style.STROKE);
    }

    /* renamed from: b */
    public Bitmap m1618b() {
        if (this.f999f) {
            return this.f997d;
        }
        return this.f996c;
    }

    /* renamed from: a */
    public void m1617a(boolean z) {
        this.f999f = z;
        invalidate();
    }

    /* renamed from: c */
    public Point m1619c() {
        return new Point(this.f995b, (getHeight() - this.f1000g) - 10);
    }

    /* renamed from: a */
    public void m1616a(int i) {
        this.f1002i = i;
    }

    public void onDraw(Canvas canvas) {
        this.f998e.getTextBounds("V2.3.0", 0, "V2.3.0".length(), this.f994a);
        if (this.f997d != null) {
            int width = (this.f997d.getWidth() + 3) + this.f994a.width();
            if (this.f1002i == 1) {
                this.f995b = (this.f1001h.getWidth() - width) / 2;
            } else if (this.f1002i == 2) {
                this.f995b = (this.f1001h.getWidth() - width) - 10;
            } else {
                this.f995b = 10;
            }
            if (C0269x.f1184e == C0268a.ALIBABA) {
                canvas.drawBitmap(m1618b(), (float) (this.f995b + 15), (float) ((getHeight() - this.f1000g) - 8), this.f998e);
                canvas.drawText("V2.3.0", (float) ((this.f997d.getWidth() + this.f995b) - 4), (float) (getHeight() - 16), this.f998e);
                return;
            }
            canvas.drawBitmap(m1618b(), (float) this.f995b, (float) ((getHeight() - this.f1000g) - 8), this.f998e);
            canvas.drawText("V2.3.0", (float) ((this.f997d.getWidth() + this.f995b) + 3), (float) (getHeight() - 12), this.f998e);
        }
    }
}
