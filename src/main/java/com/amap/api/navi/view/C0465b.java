package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.autonavi.tbt.C0617g;
import com.e4a.runtime.components.Component;
import com.tencent.smtt.sdk.WebView;
import java.util.List;

/* compiled from: CustomTmcView */
/* renamed from: com.amap.api.navi.view.b */
public class C0465b extends View {
    /* renamed from: a */
    int f2796a;
    /* renamed from: b */
    int f2797b;
    /* renamed from: c */
    int f2798c;
    /* renamed from: d */
    Paint f2799d;
    /* renamed from: e */
    Bitmap f2800e;
    /* renamed from: f */
    Bitmap f2801f;
    /* renamed from: g */
    Bitmap f2802g;
    /* renamed from: h */
    private List<AMapTrafficStatus> f2803h;
    /* renamed from: i */
    private int f2804i = 30;
    /* renamed from: j */
    private Bitmap f2805j;
    /* renamed from: k */
    private boolean f2806k = false;
    /* renamed from: l */
    private int f2807l = 0;
    /* renamed from: m */
    private RectF f2808m;
    /* renamed from: n */
    private int f2809n;
    /* renamed from: o */
    private int f2810o;
    /* renamed from: p */
    private int f2811p;
    /* renamed from: q */
    private int f2812q = 0;

    public C0465b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3947e();
    }

    public C0465b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3947e();
    }

    public C0465b(Context context) {
        super(context);
        m3947e();
    }

    /* renamed from: a */
    public Bitmap m3948a() {
        return this.f2800e;
    }

    /* renamed from: e */
    private void m3947e() {
        this.f2805j = BitmapFactory.decodeResource(C0617g.m4842a(), 2130837612);
        this.f2801f = this.f2805j;
        this.f2796a = (this.f2801f.getWidth() * 20) / 100;
        this.f2797b = (this.f2801f.getWidth() * 78) / 100;
        this.f2798c = (int) (((double) this.f2801f.getHeight()) * 0.81d);
        this.f2811p = this.f2801f.getWidth();
        this.f2812q = this.f2801f.getHeight();
        this.f2799d = new Paint();
        if (VERSION.SDK_INT >= 11) {
            this.f2804i = (Math.abs(this.f2798c - this.f2801f.getHeight()) / 4) - ((int) (((double) this.f2798c) * 0.017d));
        } else {
            this.f2804i = (Math.abs(this.f2798c - this.f2801f.getHeight()) / 4) - 3;
        }
        this.f2802g = Bitmap.createScaledBitmap(this.f2801f, this.f2801f.getWidth(), (this.f2801f.getHeight() * 2) / 3, true);
        this.f2800e = this.f2801f;
        this.f2808m = new RectF();
    }

    /* renamed from: a */
    public void m3951a(boolean z) {
        if (z) {
            this.f2800e = this.f2802g;
        } else {
            this.f2800e = this.f2801f;
        }
        this.f2798c = (int) (((double) this.f2800e.getHeight()) * 0.81d);
        this.f2811p = this.f2800e.getWidth();
        this.f2812q = this.f2800e.getHeight();
        if (z) {
            this.f2804i = (Math.abs(this.f2798c - this.f2800e.getHeight()) / 4) - ((int) (((double) this.f2798c) * 0.017d));
        } else if (VERSION.SDK_INT >= 11) {
            this.f2804i = (Math.abs(this.f2798c - this.f2800e.getHeight()) / 4) - ((int) (((double) this.f2798c) * 0.017d));
        } else {
            this.f2804i = (Math.abs(this.f2798c - this.f2800e.getHeight()) / 4) - 4;
        }
        this.f2806k = z;
    }

    /* renamed from: a */
    public void m3950a(List<AMapTrafficStatus> list, int i) {
        this.f2803h = list;
        this.f2807l = i;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f2803h != null) {
            this.f2799d.setStyle(Style.FILL);
            float f = (float) this.f2807l;
            for (int i = 0; i < this.f2803h.size(); i++) {
                AMapTrafficStatus aMapTrafficStatus = (AMapTrafficStatus) this.f2803h.get(i);
                switch (aMapTrafficStatus.getStatus()) {
                    case 1:
                        this.f2799d.setColor(Color.parseColor("#05C300"));
                        break;
                    case 2:
                        this.f2799d.setColor(Color.parseColor("#FFD615"));
                        break;
                    case 3:
                        this.f2799d.setColor(Color.argb(WebView.NORMAL_MODE_ALPHA, WebView.NORMAL_MODE_ALPHA, 93, 91));
                        break;
                    case 4:
                        this.f2799d.setColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 179, 17, 15));
                        break;
                    default:
                        this.f2799d.setColor(Color.argb(WebView.NORMAL_MODE_ALPHA, 26, 166, 239));
                        break;
                }
                if (f - ((float) aMapTrafficStatus.getLength()) > 0.0f) {
                    this.f2808m.set((float) this.f2796a, ((((float) this.f2798c) * (f - ((float) aMapTrafficStatus.getLength()))) / ((float) this.f2807l)) + ((float) this.f2804i), (float) this.f2797b, ((((float) this.f2798c) * f) / ((float) this.f2807l)) + ((float) this.f2804i));
                } else {
                    this.f2808m.set((float) this.f2796a, (float) this.f2804i, (float) this.f2797b, ((((float) this.f2798c) * f) / ((float) this.f2807l)) + ((float) this.f2804i));
                }
                canvas.drawRect(this.f2808m, this.f2799d);
                f -= (float) aMapTrafficStatus.getLength();
            }
            this.f2799d.setColor(Component.f3916);
            canvas.drawBitmap(this.f2800e, 0.0f, 0.0f, null);
        }
    }

    /* renamed from: a */
    public void m3949a(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        this.f2802g = Bitmap.createScaledBitmap(this.f2805j, this.f2805j.getWidth(), (((this.f2805j.getHeight() * 2) / 3) * i2) / i4, true);
        this.f2801f = Bitmap.createScaledBitmap(this.f2805j, this.f2805j.getWidth(), (this.f2805j.getHeight() * i2) / i4, true);
        int i6 = (i5 * i2) / i4;
        m3951a(z);
        if (z) {
            this.f2809n = Math.abs(i - ((int) (((double) this.f2811p) * 1.3d)));
            this.f2810o = ((i2 - (this.f2812q / 2)) * 6) / 10;
            return;
        }
        this.f2809n = Math.abs(i - ((int) (((double) this.f2811p) * 1.3d)));
        this.f2810o = (int) ((((double) i2) - (1.5d * ((double) i6))) - ((double) this.f2812q));
    }

    /* renamed from: b */
    public int m3952b() {
        return this.f2809n;
    }

    /* renamed from: c */
    public int m3953c() {
        return this.f2810o;
    }

    /* renamed from: d */
    public int m3954d() {
        return this.f2812q;
    }
}
