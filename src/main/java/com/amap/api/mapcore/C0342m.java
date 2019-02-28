package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.MapProjection;

/* compiled from: CompassView */
/* renamed from: com.amap.api.mapcore.m */
class C0342m extends LinearLayout {
    /* renamed from: a */
    Bitmap f1868a;
    /* renamed from: b */
    Bitmap f1869b;
    /* renamed from: c */
    Bitmap f1870c;
    /* renamed from: d */
    ImageView f1871d;
    /* renamed from: e */
    C0313u f1872e;

    /* compiled from: CompassView */
    /* renamed from: com.amap.api.mapcore.m$1 */
    class C03411 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ C0342m f1867a;

        C03411(C0342m c0342m) {
            this.f1867a = c0342m;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (this.f1867a.f1872e.mo338M()) {
                    if (motionEvent.getAction() == 0) {
                        this.f1867a.f1871d.setImageBitmap(this.f1867a.f1869b);
                    } else if (motionEvent.getAction() == 1) {
                        this.f1867a.f1871d.setImageBitmap(this.f1867a.f1868a);
                        CameraPosition l = this.f1867a.f1872e.mo413l();
                        this.f1867a.f1872e.mo391b(C0338k.m2879a(new CameraPosition(l.target, l.zoom, 0.0f, 0.0f)));
                    }
                }
            } catch (Throwable th) {
                az.m3143a(th, "CompassView", "onTouch");
                th.printStackTrace();
            }
            return false;
        }
    }

    /* renamed from: a */
    public void m2930a() {
        try {
            if (this.f1868a != null) {
                this.f1868a.recycle();
            }
            if (this.f1869b != null) {
                this.f1869b.recycle();
            }
            if (this.f1870c != null) {
                this.f1870c.recycle();
            }
            this.f1870c = null;
            this.f1868a = null;
            this.f1869b = null;
        } catch (Throwable th) {
            az.m3143a(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public C0342m(Context context) {
        super(context);
    }

    public C0342m(Context context, am amVar, C0313u c0313u) {
        super(context);
        this.f1872e = c0313u;
        try {
            this.f1870c = C0405u.m3450a(context, "maps_dav_compass_needle_large.png");
            this.f1869b = C0405u.m3451a(this.f1870c, C0344n.f1878a * 0.8f);
            this.f1870c = C0405u.m3451a(this.f1870c, C0344n.f1878a * 0.7f);
            this.f1868a = Bitmap.createBitmap(this.f1869b.getWidth(), this.f1869b.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f1868a);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawBitmap(this.f1870c, ((float) (this.f1869b.getWidth() - this.f1870c.getWidth())) / 2.0f, ((float) (this.f1869b.getHeight() - this.f1870c.getHeight())) / 2.0f, paint);
            this.f1871d = new ImageView(context);
            this.f1871d.setScaleType(ScaleType.MATRIX);
            this.f1871d.setImageBitmap(this.f1868a);
            this.f1871d.setClickable(true);
            m2931b();
            this.f1871d.setOnTouchListener(new C03411(this));
            addView(this.f1871d);
        } catch (Throwable th) {
            az.m3143a(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m2931b() {
        try {
            MapProjection c = this.f1872e.mo395c();
            float mapAngle = c.getMapAngle();
            float cameraHeaderAngle = c.getCameraHeaderAngle();
            Matrix matrix = new Matrix();
            matrix.postRotate(-mapAngle, ((float) this.f1871d.getDrawable().getBounds().width()) / 2.0f, ((float) this.f1871d.getDrawable().getBounds().height()) / 2.0f);
            matrix.postScale(1.0f, (float) Math.cos((((double) cameraHeaderAngle) * 3.141592653589793d) / 180.0d), ((float) this.f1871d.getDrawable().getBounds().width()) / 2.0f, ((float) this.f1871d.getDrawable().getBounds().height()) / 2.0f);
            this.f1871d.setImageMatrix(matrix);
        } catch (Throwable th) {
            az.m3143a(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
