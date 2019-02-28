package com.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;

/* compiled from: ZoomControllerView */
class bj extends LinearLayout {
    /* renamed from: a */
    private Bitmap f1735a;
    /* renamed from: b */
    private Bitmap f1736b;
    /* renamed from: c */
    private Bitmap f1737c;
    /* renamed from: d */
    private Bitmap f1738d;
    /* renamed from: e */
    private Bitmap f1739e;
    /* renamed from: f */
    private Bitmap f1740f;
    /* renamed from: g */
    private Bitmap f1741g;
    /* renamed from: h */
    private Bitmap f1742h;
    /* renamed from: i */
    private Bitmap f1743i;
    /* renamed from: j */
    private Bitmap f1744j;
    /* renamed from: k */
    private Bitmap f1745k;
    /* renamed from: l */
    private Bitmap f1746l;
    /* renamed from: m */
    private ImageView f1747m;
    /* renamed from: n */
    private ImageView f1748n;
    /* renamed from: o */
    private C0313u f1749o;

    /* compiled from: ZoomControllerView */
    /* renamed from: com.amap.api.mapcore.bj$1 */
    class C03261 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ bj f1733a;

        C03261(bj bjVar) {
            this.f1733a = bjVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f1733a.f1749o.mo430z() < this.f1733a.f1749o.mo415m() && this.f1733a.f1749o.mo338M()) {
                if (motionEvent.getAction() == 0) {
                    this.f1733a.f1747m.setImageBitmap(this.f1733a.f1739e);
                } else if (motionEvent.getAction() == 1) {
                    this.f1733a.f1747m.setImageBitmap(this.f1733a.f1735a);
                    try {
                        this.f1733a.f1749o.mo391b(C0338k.m2887b());
                    } catch (Throwable e) {
                        az.m3143a(e, "ZoomControllerView", "zoomin ontouch");
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: ZoomControllerView */
    /* renamed from: com.amap.api.mapcore.bj$2 */
    class C03272 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ bj f1734a;

        C03272(bj bjVar) {
            this.f1734a = bjVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f1734a.f1749o.mo430z() > this.f1734a.f1749o.mo416n() && this.f1734a.f1749o.mo338M()) {
                if (motionEvent.getAction() == 0) {
                    this.f1734a.f1748n.setImageBitmap(this.f1734a.f1740f);
                } else if (motionEvent.getAction() == 1) {
                    this.f1734a.f1748n.setImageBitmap(this.f1734a.f1737c);
                    try {
                        this.f1734a.f1749o.mo391b(C0338k.m2889c());
                    } catch (Throwable e) {
                        az.m3143a(e, "ZoomControllerView", "zoomout ontouch");
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public void m2824a() {
        try {
            this.f1735a.recycle();
            this.f1736b.recycle();
            this.f1737c.recycle();
            this.f1738d.recycle();
            this.f1739e.recycle();
            this.f1740f.recycle();
            this.f1735a = null;
            this.f1736b = null;
            this.f1737c = null;
            this.f1738d = null;
            this.f1739e = null;
            this.f1740f = null;
            if (this.f1741g != null) {
                this.f1741g.recycle();
                this.f1741g = null;
            }
            if (this.f1742h != null) {
                this.f1742h.recycle();
                this.f1742h = null;
            }
            if (this.f1743i != null) {
                this.f1743i.recycle();
                this.f1743i = null;
            }
            if (this.f1744j != null) {
                this.f1744j.recycle();
                this.f1741g = null;
            }
            if (this.f1745k != null) {
                this.f1745k.recycle();
                this.f1745k = null;
            }
            if (this.f1746l != null) {
                this.f1746l.recycle();
                this.f1746l = null;
            }
            removeAllViews();
            this.f1747m = null;
            this.f1748n = null;
        } catch (Throwable th) {
            az.m3143a(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public bj(Context context) {
        super(context);
    }

    public bj(Context context, C0313u c0313u) {
        super(context);
        this.f1749o = c0313u;
        try {
            this.f1741g = C0405u.m3450a(context, "zoomin_selected.png");
            this.f1735a = C0405u.m3451a(this.f1741g, C0344n.f1878a);
            this.f1742h = C0405u.m3450a(context, "zoomin_unselected.png");
            this.f1736b = C0405u.m3451a(this.f1742h, C0344n.f1878a);
            this.f1743i = C0405u.m3450a(context, "zoomout_selected.png");
            this.f1737c = C0405u.m3451a(this.f1743i, C0344n.f1878a);
            this.f1744j = C0405u.m3450a(context, "zoomout_unselected.png");
            this.f1738d = C0405u.m3451a(this.f1744j, C0344n.f1878a);
            this.f1745k = C0405u.m3450a(context, "zoomin_pressed.png");
            this.f1739e = C0405u.m3451a(this.f1745k, C0344n.f1878a);
            this.f1746l = C0405u.m3450a(context, "zoomout_pressed.png");
            this.f1740f = C0405u.m3451a(this.f1746l, C0344n.f1878a);
            this.f1747m = new ImageView(context);
            this.f1747m.setImageBitmap(this.f1735a);
            this.f1747m.setClickable(true);
            this.f1748n = new ImageView(context);
            this.f1748n.setImageBitmap(this.f1737c);
            this.f1748n.setClickable(true);
        } catch (Throwable th) {
            az.m3143a(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
        this.f1747m.setOnTouchListener(new C03261(this));
        this.f1748n.setOnTouchListener(new C03272(this));
        this.f1747m.setPadding(0, 0, 20, -2);
        this.f1748n.setPadding(0, 0, 20, 20);
        setOrientation(1);
        addView(this.f1747m);
        addView(this.f1748n);
    }

    /* renamed from: a */
    public void m2825a(float f) {
        if (f < this.f1749o.mo415m() && f > this.f1749o.mo416n()) {
            this.f1747m.setImageBitmap(this.f1735a);
            this.f1748n.setImageBitmap(this.f1737c);
        } else if (f == this.f1749o.mo416n()) {
            this.f1748n.setImageBitmap(this.f1738d);
            this.f1747m.setImageBitmap(this.f1735a);
        } else if (f == this.f1749o.mo415m()) {
            this.f1747m.setImageBitmap(this.f1736b);
            this.f1748n.setImageBitmap(this.f1737c);
        }
    }
}
