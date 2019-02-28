package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.p015a.p016a.C0204q;

/* compiled from: ZoomControllerView */
/* renamed from: com.amap.api.a.cg */
class cg extends LinearLayout {
    /* renamed from: a */
    private Bitmap f1007a;
    /* renamed from: b */
    private Bitmap f1008b;
    /* renamed from: c */
    private Bitmap f1009c;
    /* renamed from: d */
    private Bitmap f1010d;
    /* renamed from: e */
    private Bitmap f1011e;
    /* renamed from: f */
    private Bitmap f1012f;
    /* renamed from: g */
    private ImageView f1013g;
    /* renamed from: h */
    private ImageView f1014h;
    /* renamed from: i */
    private av f1015i;
    /* renamed from: j */
    private af f1016j;
    /* renamed from: k */
    private int f1017k = 0;

    /* compiled from: ZoomControllerView */
    /* renamed from: com.amap.api.a.cg$1 */
    class C02391 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ cg f1003a;

        C02391(cg cgVar) {
            this.f1003a = cgVar;
        }

        public void onClick(View view) {
            this.f1003a.f1014h.setImageBitmap(this.f1003a.f1009c);
            if (this.f1003a.f1016j.mo130f() > ((float) (((int) this.f1003a.f1016j.mo134h()) - 2))) {
                this.f1003a.f1013g.setImageBitmap(this.f1003a.f1008b);
            } else {
                this.f1003a.f1013g.setImageBitmap(this.f1003a.f1007a);
            }
            this.f1003a.m1631a(this.f1003a.f1016j.mo130f() + 1.0f);
            this.f1003a.f1015i.m1091c();
        }
    }

    /* compiled from: ZoomControllerView */
    /* renamed from: com.amap.api.a.cg$2 */
    class C02402 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ cg f1004a;

        C02402(cg cgVar) {
            this.f1004a = cgVar;
        }

        public void onClick(View view) {
            this.f1004a.f1013g.setImageBitmap(this.f1004a.f1007a);
            this.f1004a.m1631a(this.f1004a.f1016j.mo130f() - 1.0f);
            if (this.f1004a.f1016j.mo130f() < ((float) (((int) this.f1004a.f1016j.mo135i()) + 2))) {
                this.f1004a.f1014h.setImageBitmap(this.f1004a.f1010d);
            } else {
                this.f1004a.f1014h.setImageBitmap(this.f1004a.f1009c);
            }
            this.f1004a.f1015i.m1092d();
        }
    }

    /* compiled from: ZoomControllerView */
    /* renamed from: com.amap.api.a.cg$3 */
    class C02413 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ cg f1005a;

        C02413(cg cgVar) {
            this.f1005a = cgVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f1005a.f1016j.mo130f() < this.f1005a.f1016j.mo134h()) {
                if (motionEvent.getAction() == 0) {
                    this.f1005a.f1013g.setImageBitmap(this.f1005a.f1011e);
                } else if (motionEvent.getAction() == 1) {
                    this.f1005a.f1013g.setImageBitmap(this.f1005a.f1007a);
                    try {
                        this.f1005a.f1016j.mo117b(C0262t.m1697b());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: ZoomControllerView */
    /* renamed from: com.amap.api.a.cg$4 */
    class C02424 implements OnTouchListener {
        /* renamed from: a */
        final /* synthetic */ cg f1006a;

        C02424(cg cgVar) {
            this.f1006a = cgVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f1006a.f1016j.mo130f() > this.f1006a.f1016j.mo135i()) {
                if (motionEvent.getAction() == 0) {
                    this.f1006a.f1014h.setImageBitmap(this.f1006a.f1012f);
                } else if (motionEvent.getAction() == 1) {
                    this.f1006a.f1014h.setImageBitmap(this.f1006a.f1009c);
                    try {
                        this.f1006a.f1016j.mo117b(C0262t.m1700c());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: a */
    public void m1630a() {
        try {
            this.f1007a.recycle();
            this.f1008b.recycle();
            this.f1009c.recycle();
            this.f1010d.recycle();
            this.f1011e.recycle();
            this.f1012f.recycle();
            this.f1007a = null;
            this.f1008b = null;
            this.f1009c = null;
            this.f1010d = null;
            this.f1011e = null;
            this.f1012f = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public cg(Context context, av avVar, af afVar) {
        super(context);
        setWillNotDraw(false);
        this.f1015i = avVar;
        this.f1016j = afVar;
        try {
            this.f1007a = C0204q.m797a("zoomin_selected.png");
            this.f1007a = C0204q.m795a(this.f1007a, C0269x.f1180a);
            this.f1008b = C0204q.m797a("zoomin_unselected.png");
            this.f1008b = C0204q.m795a(this.f1008b, C0269x.f1180a);
            this.f1009c = C0204q.m797a("zoomout_selected.png");
            this.f1009c = C0204q.m795a(this.f1009c, C0269x.f1180a);
            this.f1010d = C0204q.m797a("zoomout_unselected.png");
            this.f1010d = C0204q.m795a(this.f1010d, C0269x.f1180a);
            this.f1011e = C0204q.m797a("zoomin_pressed.png");
            this.f1012f = C0204q.m797a("zoomout_pressed.png");
            this.f1011e = C0204q.m795a(this.f1011e, C0269x.f1180a);
            this.f1012f = C0204q.m795a(this.f1012f, C0269x.f1180a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f1013g = new ImageView(context);
        this.f1013g.setImageBitmap(this.f1007a);
        this.f1013g.setOnClickListener(new C02391(this));
        this.f1014h = new ImageView(context);
        this.f1014h.setImageBitmap(this.f1009c);
        this.f1014h.setOnClickListener(new C02402(this));
        this.f1013g.setOnTouchListener(new C02413(this));
        this.f1014h.setOnTouchListener(new C02424(this));
        this.f1013g.setPadding(0, 0, 20, -2);
        this.f1014h.setPadding(0, 0, 20, 20);
        setOrientation(1);
        addView(this.f1013g);
        addView(this.f1014h);
    }

    /* renamed from: a */
    public void m1632a(int i) {
        this.f1017k = i;
        removeView(this.f1013g);
        removeView(this.f1014h);
        addView(this.f1013g);
        addView(this.f1014h);
    }

    /* renamed from: b */
    public int m1633b() {
        return this.f1017k;
    }

    /* renamed from: a */
    public void m1631a(float f) {
        if (f < this.f1016j.mo134h() && f > this.f1016j.mo135i()) {
            this.f1013g.setImageBitmap(this.f1007a);
            this.f1014h.setImageBitmap(this.f1009c);
        } else if (f <= this.f1016j.mo135i()) {
            this.f1014h.setImageBitmap(this.f1010d);
            this.f1013g.setImageBitmap(this.f1007a);
        } else if (f >= this.f1016j.mo134h()) {
            this.f1013g.setImageBitmap(this.f1008b);
            this.f1014h.setImageBitmap(this.f1009c);
        }
    }
}
