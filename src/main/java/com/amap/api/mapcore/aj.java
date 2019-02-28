package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.LatLng;

/* compiled from: LocationView */
class aj extends LinearLayout {
    /* renamed from: a */
    Bitmap f1467a;
    /* renamed from: b */
    Bitmap f1468b;
    /* renamed from: c */
    Bitmap f1469c;
    /* renamed from: d */
    Bitmap f1470d;
    /* renamed from: e */
    Bitmap f1471e;
    /* renamed from: f */
    Bitmap f1472f;
    /* renamed from: g */
    ImageView f1473g;
    /* renamed from: h */
    C0313u f1474h;
    /* renamed from: i */
    boolean f1475i = false;

    /* compiled from: LocationView */
    /* renamed from: com.amap.api.mapcore.aj$1 */
    class C03171 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ aj f1466a;

        C03171(aj ajVar) {
            this.f1466a = ajVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f1466a.f1475i) {
                if (motionEvent.getAction() == 0) {
                    this.f1466a.f1473g.setImageBitmap(this.f1466a.f1468b);
                } else if (motionEvent.getAction() == 1) {
                    try {
                        this.f1466a.f1473g.setImageBitmap(this.f1466a.f1467a);
                        this.f1466a.f1474h.mo408h(true);
                        Location t = this.f1466a.f1474h.mo425t();
                        if (t != null) {
                            LatLng latLng = new LatLng(t.getLatitude(), t.getLongitude());
                            this.f1466a.f1474h.mo361a(t);
                            this.f1466a.f1474h.mo362a(C0338k.m2881a(latLng, this.f1466a.f1474h.mo430z()));
                        }
                    } catch (Throwable th) {
                        az.m3143a(th, "LocationView", "onTouch");
                        th.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public void m2410a() {
        try {
            if (this.f1467a != null) {
                this.f1467a.recycle();
            }
            if (this.f1468b != null) {
                this.f1468b.recycle();
            }
            if (this.f1468b != null) {
                this.f1469c.recycle();
            }
            this.f1467a = null;
            this.f1468b = null;
            this.f1469c = null;
            if (this.f1470d != null) {
                this.f1470d.recycle();
                this.f1470d = null;
            }
            if (this.f1471e != null) {
                this.f1471e.recycle();
                this.f1471e = null;
            }
            if (this.f1472f != null) {
                this.f1472f.recycle();
                this.f1472f = null;
            }
        } catch (Throwable th) {
            az.m3143a(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public aj(Context context) {
        super(context);
    }

    public aj(Context context, am amVar, C0313u c0313u) {
        super(context);
        this.f1474h = c0313u;
        try {
            this.f1470d = C0405u.m3450a(context, "location_selected.png");
            this.f1467a = C0405u.m3451a(this.f1470d, C0344n.f1878a);
            this.f1471e = C0405u.m3450a(context, "location_pressed.png");
            this.f1468b = C0405u.m3451a(this.f1471e, C0344n.f1878a);
            this.f1472f = C0405u.m3450a(context, "location_unselected.png");
            this.f1469c = C0405u.m3451a(this.f1472f, C0344n.f1878a);
        } catch (Throwable th) {
            az.m3143a(th, "LocationView", "create");
            th.printStackTrace();
        }
        this.f1473g = new ImageView(context);
        this.f1473g.setImageBitmap(this.f1467a);
        this.f1473g.setClickable(true);
        this.f1473g.setPadding(0, 20, 20, 0);
        this.f1473g.setOnTouchListener(new C03171(this));
        addView(this.f1473g);
    }

    /* renamed from: a */
    public void m2411a(boolean z) {
        this.f1475i = z;
        if (z) {
            this.f1473g.setImageBitmap(this.f1467a);
        } else {
            this.f1473g.setImageBitmap(this.f1469c);
        }
        this.f1473g.invalidate();
    }
}
