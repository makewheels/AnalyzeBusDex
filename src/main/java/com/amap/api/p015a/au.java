package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.p015a.p016a.C0204q;

/* compiled from: LocationView */
/* renamed from: com.amap.api.a.au */
class au extends LinearLayout {
    /* renamed from: a */
    Bitmap f653a;
    /* renamed from: b */
    Bitmap f654b;
    /* renamed from: c */
    Bitmap f655c;
    /* renamed from: d */
    ImageView f656d;
    /* renamed from: e */
    af f657e;
    /* renamed from: f */
    boolean f658f = false;

    /* compiled from: LocationView */
    /* renamed from: com.amap.api.a.au$1 */
    class C02081 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ au f651a;

        C02081(au auVar) {
            this.f651a = auVar;
        }

        public void onClick(View view) {
        }
    }

    /* compiled from: LocationView */
    /* renamed from: com.amap.api.a.au$2 */
    class C02092 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ au f652a;

        C02092(au auVar) {
            this.f652a = auVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f652a.f658f) {
                if (motionEvent.getAction() == 0) {
                    this.f652a.f656d.setImageBitmap(this.f652a.f654b);
                } else if (motionEvent.getAction() == 1) {
                    try {
                        this.f652a.f656d.setImageBitmap(this.f652a.f653a);
                        this.f652a.f657e.mo123c(true);
                        Location p = this.f652a.f657e.mo141p();
                        if (p != null) {
                            LatLng latLng = new LatLng(p.getLatitude(), p.getLongitude());
                            this.f652a.f657e.mo90a(p);
                            this.f652a.f657e.mo92a(C0262t.m1692a(latLng, this.f652a.f657e.mo130f()));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public void m1061a() {
        try {
            this.f653a.recycle();
            this.f654b.recycle();
            this.f655c.recycle();
            this.f653a = null;
            this.f654b = null;
            this.f655c = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public au(Context context, ax axVar, af afVar) {
        super(context);
        this.f657e = afVar;
        try {
            this.f653a = C0204q.m797a("location_selected.png");
            this.f654b = C0204q.m797a("location_pressed.png");
            this.f653a = C0204q.m795a(this.f653a, C0269x.f1180a);
            this.f654b = C0204q.m795a(this.f654b, C0269x.f1180a);
            this.f655c = C0204q.m797a("location_unselected.png");
            this.f655c = C0204q.m795a(this.f655c, C0269x.f1180a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f656d = new ImageView(context);
        this.f656d.setImageBitmap(this.f653a);
        this.f656d.setPadding(0, 20, 20, 0);
        this.f656d.setOnClickListener(new C02081(this));
        this.f656d.setOnTouchListener(new C02092(this));
        addView(this.f656d);
    }

    /* renamed from: a */
    public void m1062a(boolean z) {
        this.f658f = z;
        if (z) {
            this.f656d.setImageBitmap(this.f653a);
        } else {
            this.f656d.setImageBitmap(this.f655c);
        }
        this.f656d.invalidate();
    }
}
