package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.p015a.p016a.C0204q;

/* compiled from: CompassView */
/* renamed from: com.amap.api.a.w */
class C0267w extends LinearLayout {
    /* renamed from: a */
    Bitmap f1170a;
    /* renamed from: b */
    Bitmap f1171b;
    /* renamed from: c */
    ImageView f1172c;
    /* renamed from: d */
    ax f1173d;
    /* renamed from: e */
    af f1174e;

    /* compiled from: CompassView */
    /* renamed from: com.amap.api.a.w$1 */
    class C02651 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ C0267w f1168a;

        C02651(C0267w c0267w) {
            this.f1168a = c0267w;
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: CompassView */
    /* renamed from: com.amap.api.a.w$2 */
    class C02662 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C0267w f1169a;

        C02662(C0267w c0267w) {
            this.f1169a = c0267w;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f1169a.f1172c.setImageBitmap(this.f1169a.f1171b);
            } else if (motionEvent.getAction() == 1) {
                try {
                    this.f1169a.f1172c.setImageBitmap(this.f1169a.f1170a);
                    CameraPosition g = this.f1169a.f1174e.mo132g();
                    this.f1169a.f1174e.mo117b(C0262t.m1690a(new CameraPosition(g.target, g.zoom, 0.0f, 0.0f)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public void m1728a() {
        try {
            this.f1170a.recycle();
            this.f1171b.recycle();
            this.f1170a = null;
            this.f1171b = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public C0267w(Context context, ax axVar, af afVar) {
        super(context);
        this.f1173d = axVar;
        this.f1174e = afVar;
        try {
            Bitmap a = C0204q.m797a("maps_dav_compass_needle_large.png");
            this.f1171b = C0204q.m795a(a, C0269x.f1180a * 0.8f);
            a = C0204q.m795a(a, C0269x.f1180a * 0.7f);
            this.f1170a = Bitmap.createBitmap(this.f1171b.getWidth(), this.f1171b.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f1170a);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(a, (float) ((this.f1171b.getWidth() - a.getWidth()) / 2), (float) ((this.f1171b.getHeight() - a.getHeight()) / 2), paint);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f1172c = new ImageView(context);
        this.f1172c.setScaleType(ScaleType.MATRIX);
        this.f1172c.setImageBitmap(this.f1170a);
        this.f1172c.setOnClickListener(new C02651(this));
        this.f1172c.setOnTouchListener(new C02662(this));
        addView(this.f1172c);
    }
}
