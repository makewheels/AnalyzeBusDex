package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import com.amap.api.maps2d.model.TileOverlayOptions;
import com.amap.api.maps2d.model.TileProvider;
import com.amap.api.p015a.p016a.C0181b;
import com.amap.api.p015a.p016a.C0181b.C0180d;
import com.amap.api.p015a.p016a.C0196j.C0195a;
import com.amap.api.p015a.p016a.C0197m;
import com.amap.api.p015a.p016a.C0197m.C0200a;
import com.amap.api.p015a.p016a.C0199k;
import com.amap.api.p015a.p016a.C0202n;
import com.amap.api.p015a.p016a.C0204q;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p054u.aly.bi_常量类;

/* compiled from: TileOverlayDelegateImp */
/* renamed from: com.amap.api.a.bu */
public class bu implements ap {
    /* renamed from: f */
    private static int f936f = 0;
    /* renamed from: a */
    private bv f937a;
    /* renamed from: b */
    private TileProvider f938b;
    /* renamed from: c */
    private Float f939c;
    /* renamed from: d */
    private boolean f940d;
    /* renamed from: e */
    private af f941e;
    /* renamed from: g */
    private int f942g = 256;
    /* renamed from: h */
    private int f943h = 256;
    /* renamed from: i */
    private int f944i = -1;
    /* renamed from: j */
    private C0199k f945j;
    /* renamed from: k */
    private CopyOnWriteArrayList<C0233a> f946k = new CopyOnWriteArrayList();
    /* renamed from: l */
    private boolean f947l = false;
    /* renamed from: m */
    private C0234b f948m = null;
    /* renamed from: n */
    private String f949n = null;
    /* renamed from: o */
    private FloatBuffer f950o = null;

    /* compiled from: TileOverlayDelegateImp */
    /* renamed from: com.amap.api.a.bu$a */
    public class C0233a implements Cloneable {
        /* renamed from: a */
        public final int f924a;
        /* renamed from: b */
        public final int f925b;
        /* renamed from: c */
        public final int f926c;
        /* renamed from: d */
        public final int f927d;
        /* renamed from: e */
        public PointF f928e;
        /* renamed from: f */
        public Bitmap f929f = null;
        /* renamed from: g */
        public C0200a f930g = null;
        /* renamed from: h */
        public int f931h = 0;
        /* renamed from: i */
        final /* synthetic */ bu f932i;

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m1511a();
        }

        public C0233a(bu buVar, int i, int i2, int i3, int i4) {
            this.f932i = buVar;
            this.f924a = i;
            this.f925b = i2;
            this.f926c = i3;
            this.f927d = i4;
        }

        public C0233a(bu buVar, C0233a c0233a) {
            this.f932i = buVar;
            this.f924a = c0233a.f924a;
            this.f925b = c0233a.f925b;
            this.f926c = c0233a.f926c;
            this.f927d = c0233a.f927d;
            this.f928e = c0233a.f928e;
        }

        /* renamed from: a */
        public C0233a m1511a() {
            return new C0233a(this.f932i, this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0233a)) {
                return false;
            }
            C0233a c0233a = (C0233a) obj;
            if (this.f924a == c0233a.f924a && this.f925b == c0233a.f925b && this.f926c == c0233a.f926c && this.f927d == c0233a.f927d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f924a * 7) + (this.f925b * 11)) + (this.f926c * 13)) + this.f927d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f924a);
            stringBuilder.append("-");
            stringBuilder.append(this.f925b);
            stringBuilder.append("-");
            stringBuilder.append(this.f926c);
            stringBuilder.append("-");
            stringBuilder.append(this.f927d);
            return stringBuilder.toString();
        }

        /* renamed from: a */
        public void m1512a(Bitmap bitmap) {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    try {
                        this.f930g = null;
                        this.f929f = C0204q.m796a(bitmap, C0204q.m793a(bitmap.getWidth()), C0204q.m793a(bitmap.getHeight()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        if (this.f931h < 3) {
                            this.f932i.f945j.m761a(true, this);
                            this.f931h++;
                            C0202n.m788a("TileOverlayDelegateImp", "setBitmap Exception: " + this + "retry: " + this.f931h, ErrorCode.NETWORK_NOT_WIFI_ERROR);
                        }
                    }
                    this.f932i.f941e.mo84a().f842g.postInvalidate();
                }
            }
            try {
                if (this.f931h < 3) {
                    this.f932i.f945j.m761a(true, this);
                    this.f931h++;
                    C0202n.m788a("TileOverlayDelegateImp", "setBitmap failed: " + this + "retry: " + this.f931h, ErrorCode.NETWORK_NOT_WIFI_ERROR);
                }
                this.f932i.f941e.mo84a().f842g.postInvalidate();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* renamed from: b */
        public void m1513b() {
            C0197m.m753a(this);
            if (!(this.f929f == null || this.f929f.isRecycled())) {
                this.f929f.recycle();
            }
            this.f929f = null;
            this.f930g = null;
        }
    }

    /* compiled from: TileOverlayDelegateImp */
    /* renamed from: com.amap.api.a.bu$b */
    private class C0234b extends C0181b<af, Void, List<C0233a>> {
        /* renamed from: a */
        final /* synthetic */ bu f933a;
        /* renamed from: e */
        private int f934e;
        /* renamed from: f */
        private boolean f935f;

        public C0234b(bu buVar, boolean z) {
            this.f933a = buVar;
            this.f935f = z;
        }

        /* renamed from: a */
        protected List<C0233a> m1515a(af... afVarArr) {
            int d;
            int i = 0;
            try {
                int c = afVarArr[0].mo121c();
                d = afVarArr[0].mo125d();
                this.f934e = (int) afVarArr[0].mo130f();
                i = c;
            } catch (Exception e) {
                d = 0;
            }
            if (i <= 0 || d <= 0) {
                return null;
            }
            return this.f933a.m1520a(this.f934e, i, d);
        }

        /* renamed from: a */
        protected void m1517a(List<C0233a> list) {
            if (list != null && list.size() > 0) {
                this.f933a.m1523a((List) list, this.f934e, this.f935f);
                list.clear();
            }
        }
    }

    /* renamed from: a */
    private static String m1519a(String str) {
        f936f++;
        return str + f936f;
    }

    public bu(TileOverlayOptions tileOverlayOptions, bv bvVar) {
        this.f937a = bvVar;
        this.f938b = tileOverlayOptions.getTileProvider();
        this.f942g = this.f938b.getTileWidth();
        this.f943h = this.f938b.getTileHeight();
        int a = C0204q.m793a(this.f942g);
        float f = ((float) this.f942g) / ((float) a);
        float a2 = ((float) this.f943h) / ((float) C0204q.m793a(this.f943h));
        if (this.f950o == null) {
            this.f950o = C0204q.m801a(new float[]{0.0f, a2, f, a2, f, 0.0f, 0.0f, 0.0f});
        }
        this.f939c = Float.valueOf(tileOverlayOptions.getZIndex());
        this.f940d = tileOverlayOptions.isVisible();
        this.f949n = mo216c();
        this.f941e = this.f937a.m1536a();
        this.f944i = Integer.valueOf(this.f949n.substring("TileOverlay".length())).intValue();
        C0195a c0195a = new C0195a(this.f937a.getContext(), this.f949n);
        c0195a.m731a(tileOverlayOptions.getMemoryCacheEnabled());
        c0195a.m733b(tileOverlayOptions.getDiskCacheEnabled());
        c0195a.m729a(tileOverlayOptions.getMemCacheSize());
        c0195a.m732b(tileOverlayOptions.getDiskCacheSize());
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (!(diskCacheDir == null || diskCacheDir.equals(bi_常量类.f6358b_空串))) {
            c0195a.m730a(diskCacheDir);
        }
        this.f945j = new C0199k(this.f937a.getContext(), this.f942g, this.f943h);
        this.f945j.m778a(this.f938b);
        this.f945j.m760a(c0195a);
        mo215b(true);
    }

    /* renamed from: a */
    public void mo209a() {
        if (this.f948m != null && this.f948m.m634a() == C0180d.RUNNING) {
            this.f948m.m638a(true);
        }
        Iterator it = this.f946k.iterator();
        while (it.hasNext()) {
            ((C0233a) it.next()).m1513b();
        }
        this.f946k.clear();
        this.f945j.m767g();
        this.f937a.m1541b(this);
    }

    /* renamed from: b */
    public void mo214b() {
        this.f945j.m766f();
    }

    /* renamed from: c */
    public String mo216c() {
        if (this.f949n == null) {
            this.f949n = bu.m1519a("TileOverlay");
        }
        return this.f949n;
    }

    /* renamed from: a */
    public void mo210a(float f) {
        this.f939c = Float.valueOf(f);
        this.f937a.m1542c();
    }

    /* renamed from: d */
    public float mo217d() {
        return this.f939c.floatValue();
    }

    /* renamed from: a */
    public void mo212a(boolean z) {
        this.f940d = z;
        if (z) {
            mo215b(true);
        }
    }

    /* renamed from: e */
    public boolean mo218e() {
        return this.f940d;
    }

    /* renamed from: a */
    public boolean mo213a(ap apVar) {
        if (equals(apVar) || apVar.mo216c().equals(mo216c())) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int mo219f() {
        return super.hashCode();
    }

    /* renamed from: a */
    public void mo211a(Canvas canvas) {
        if (this.f946k != null && this.f946k.size() != 0) {
            Iterator it = this.f946k.iterator();
            while (it.hasNext()) {
                C0233a c0233a = (C0233a) it.next();
                if (c0233a != null) {
                    try {
                        PointF pointF = c0233a.f928e;
                        if (!(c0233a.f929f == null || c0233a.f929f.isRecycled() || pointF == null || c0233a == null || pointF == null)) {
                            canvas.drawBitmap(c0233a.f929f, pointF.x, pointF.y, null);
                        }
                    } catch (Exception e) {
                        C0202n.m788a("TileOverlayDelegateImp", e.toString(), ErrorCode.DOWNLOAD_OVER_FLOW);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private ArrayList<C0233a> m1520a(int i, int i2, int i3) {
        int i4;
        ba b = this.f941e.mo113b();
        ac acVar = b.f761j;
        double d = b.f759h[b.f758g];
        int e = (int) ((acVar.m827e() - b.f754c) / (256.0d * d));
        double d2 = b.f754c + (((double) (e * 256)) * d);
        double d3 = 0.0d;
        int f;
        if (b.f753b == 0) {
            f = (int) ((b.f755d - acVar.m828f()) / (256.0d * d));
            d3 = b.f755d - (((double) (f * 256)) * d);
            i4 = f;
        } else if (b.f753b == 1) {
            f = (int) ((acVar.m828f() - b.f755d) / (256.0d * d));
            d3 = ((double) ((f + 1) * 256)) * d;
            i4 = f;
        } else {
            i4 = 0;
        }
        ac acVar2 = new ac(d3, d2, false);
        PointF a = b.m1286a(acVar2, acVar, b.f763l, d);
        C0233a c0233a = new C0233a(this, e, i4, b.f758g, -1);
        c0233a.f928e = a;
        ArrayList<C0233a> arrayList = new ArrayList();
        arrayList.add(c0233a);
        int i5 = 1;
        while (true) {
            int i6;
            Object obj = null;
            int i7 = e - i5;
            while (i7 <= e + i5) {
                Object obj2;
                i6 = i4 + i5;
                PointF a2 = b.m1285a(i7, i6, e, i4, a, i2, i3);
                if (a2 != null) {
                    if (obj == null) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    C0233a c0233a2 = new C0233a(this, i7, i6, b.f758g, -1);
                    c0233a2.f928e = a2;
                    arrayList.add(c0233a2);
                    obj = obj2;
                }
                i6 = i4 - i5;
                a2 = b.m1285a(i7, i6, e, i4, a, i2, i3);
                if (a2 != null) {
                    if (obj == null) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    c0233a2 = new C0233a(this, i7, i6, b.f758g, -1);
                    c0233a2.f928e = a2;
                    arrayList.add(c0233a2);
                } else {
                    obj2 = obj;
                }
                i7++;
                obj = obj2;
            }
            i6 = (i4 + i5) - 1;
            while (i6 > i4 - i5) {
                i7 = e + i5;
                a2 = b.m1285a(i7, i6, e, i4, a, i2, i3);
                if (a2 != null) {
                    if (obj == null) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    c0233a2 = new C0233a(this, i7, i6, b.f758g, -1);
                    c0233a2.f928e = a2;
                    arrayList.add(c0233a2);
                    obj = obj2;
                }
                i7 = e - i5;
                a2 = b.m1285a(i7, i6, e, i4, a, i2, i3);
                if (a2 != null) {
                    if (obj == null) {
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                    c0233a2 = new C0233a(this, i7, i6, b.f758g, -1);
                    c0233a2.f928e = a2;
                    arrayList.add(c0233a2);
                } else {
                    obj2 = obj;
                }
                i6--;
                obj = obj2;
            }
            if (obj == null) {
                return arrayList;
            }
            i5++;
        }
    }

    /* renamed from: a */
    private boolean m1523a(List<C0233a> list, int i, boolean z) {
        int i2 = 0;
        if (list == null) {
            return false;
        }
        if (this.f946k == null) {
            return false;
        }
        Iterator it = this.f946k.iterator();
        while (it.hasNext()) {
            int i3;
            C0233a c0233a = (C0233a) it.next();
            for (C0233a equals : list) {
                if (c0233a.equals(equals)) {
                    i3 = 1;
                    break;
                }
            }
            i3 = 0;
            if (i3 == 0) {
                c0233a.m1513b();
            }
        }
        this.f946k.clear();
        if (i > ((int) this.f941e.mo134h()) || i < ((int) this.f941e.mo135i())) {
            return false;
        }
        i3 = list.size();
        if (i3 <= 0) {
            return false;
        }
        while (i2 < i3) {
            c0233a = (C0233a) list.get(i2);
            if (c0233a != null) {
                this.f946k.add(c0233a);
                this.f945j.m761a(z, c0233a);
            }
            i2++;
        }
        return true;
    }

    /* renamed from: b */
    public void mo215b(boolean z) {
        if (!this.f947l) {
            if (this.f948m != null && this.f948m.m634a() == C0180d.RUNNING) {
                this.f948m.m638a(true);
            }
            this.f948m = new C0234b(this, z);
            this.f948m.m642c((Object[]) new af[]{this.f941e});
        }
    }
}
