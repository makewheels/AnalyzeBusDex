package com.amap.api.mapcore;

import android.graphics.Bitmap;
import com.amap.api.mapcore.util.C0323f;
import com.amap.api.mapcore.util.C0323f.C0385d;
import com.amap.api.mapcore.util.C0392j.C0391a;
import com.amap.api.mapcore.util.C0393m;
import com.amap.api.mapcore.util.C0393m.C0396a;
import com.amap.api.mapcore.util.C0395k;
import com.amap.api.mapcore.util.C0399o;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;
import p054u.aly.bi_常量类;

/* compiled from: TileOverlayDelegateImp */
public class be implements ah {
    /* renamed from: f */
    private static int f1691f = 0;
    /* renamed from: a */
    private bf f1692a;
    /* renamed from: b */
    private TileProvider f1693b;
    /* renamed from: c */
    private Float f1694c;
    /* renamed from: d */
    private boolean f1695d;
    /* renamed from: e */
    private C0313u f1696e;
    /* renamed from: g */
    private int f1697g = 256;
    /* renamed from: h */
    private int f1698h = 256;
    /* renamed from: i */
    private int f1699i = -1;
    /* renamed from: j */
    private C0395k f1700j;
    /* renamed from: k */
    private CopyOnWriteArrayList<C0322a> f1701k = new CopyOnWriteArrayList();
    /* renamed from: l */
    private boolean f1702l = false;
    /* renamed from: m */
    private C0324b f1703m = null;
    /* renamed from: n */
    private String f1704n = null;
    /* renamed from: o */
    private FloatBuffer f1705o = null;

    /* compiled from: TileOverlayDelegateImp */
    /* renamed from: com.amap.api.mapcore.be$a */
    public class C0322a implements Cloneable {
        /* renamed from: a */
        public int f1664a;
        /* renamed from: b */
        public int f1665b;
        /* renamed from: c */
        public int f1666c;
        /* renamed from: d */
        public int f1667d;
        /* renamed from: e */
        public IPoint f1668e;
        /* renamed from: f */
        public int f1669f = 0;
        /* renamed from: g */
        public boolean f1670g = false;
        /* renamed from: h */
        public FloatBuffer f1671h = null;
        /* renamed from: i */
        public Bitmap f1672i = null;
        /* renamed from: j */
        public C0396a f1673j = null;
        /* renamed from: k */
        public int f1674k = 0;
        /* renamed from: l */
        final /* synthetic */ be f1675l;

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m2726a();
        }

        public C0322a(be beVar, int i, int i2, int i3, int i4) {
            this.f1675l = beVar;
            this.f1664a = i;
            this.f1665b = i2;
            this.f1666c = i3;
            this.f1667d = i4;
        }

        public C0322a(be beVar, C0322a c0322a) {
            this.f1675l = beVar;
            this.f1664a = c0322a.f1664a;
            this.f1665b = c0322a.f1665b;
            this.f1666c = c0322a.f1666c;
            this.f1667d = c0322a.f1667d;
            this.f1668e = c0322a.f1668e;
            this.f1671h = c0322a.f1671h;
        }

        /* renamed from: a */
        public C0322a m2726a() {
            try {
                C0322a c0322a = (C0322a) super.clone();
                c0322a.f1664a = this.f1664a;
                c0322a.f1665b = this.f1665b;
                c0322a.f1666c = this.f1666c;
                c0322a.f1667d = this.f1667d;
                c0322a.f1668e = (IPoint) this.f1668e.clone();
                c0322a.f1671h = this.f1671h.asReadOnlyBuffer();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new C0322a(this.f1675l, this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0322a)) {
                return false;
            }
            C0322a c0322a = (C0322a) obj;
            if (this.f1664a == c0322a.f1664a && this.f1665b == c0322a.f1665b && this.f1666c == c0322a.f1666c && this.f1667d == c0322a.f1667d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f1664a * 7) + (this.f1665b * 11)) + (this.f1666c * 13)) + this.f1667d;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f1664a);
            stringBuilder.append("-");
            stringBuilder.append(this.f1665b);
            stringBuilder.append("-");
            stringBuilder.append(this.f1666c);
            stringBuilder.append("-");
            stringBuilder.append(this.f1667d);
            return stringBuilder.toString();
        }

        /* renamed from: a */
        public void m2727a(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    this.f1673j = null;
                    this.f1672i = C0405u.m3452a(bitmap, C0405u.m3444a(bitmap.getWidth()), C0405u.m3444a(bitmap.getHeight()));
                    this.f1675l.f1696e.mo401e(false);
                } catch (Throwable th) {
                    az.m3143a(th, "TileOverlayDelegateImp", "setBitmap");
                    th.printStackTrace();
                    if (this.f1674k < 3) {
                        this.f1675l.f1700j.m3388a(true, this);
                        this.f1674k++;
                        C0399o.m3422a("TileOverlayDelegateImp", "setBitmap Throwable: " + this + "retry: " + this.f1674k, ErrorCode.NETWORK_NOT_WIFI_ERROR);
                    }
                }
            } else if (this.f1674k < 3) {
                this.f1675l.f1700j.m3388a(true, this);
                this.f1674k++;
                C0399o.m3422a("TileOverlayDelegateImp", "setBitmap failed: " + this + "retry: " + this.f1674k, ErrorCode.NETWORK_NOT_WIFI_ERROR);
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }

        /* renamed from: b */
        public void m2728b() {
            C0393m.m3379a(this);
            if (this.f1670g) {
                this.f1675l.f1692a.f1708c.add(Integer.valueOf(this.f1669f));
            }
            this.f1670g = false;
            this.f1669f = 0;
            if (!(this.f1672i == null || this.f1672i.isRecycled())) {
                this.f1672i.recycle();
            }
            this.f1672i = null;
            if (this.f1671h != null) {
                this.f1671h.clear();
            }
            this.f1671h = null;
            this.f1673j = null;
        }
    }

    /* compiled from: TileOverlayDelegateImp */
    /* renamed from: com.amap.api.mapcore.be$b */
    private class C0324b extends C0323f<C0313u, Void, List<C0322a>> {
        /* renamed from: a */
        final /* synthetic */ be f1688a;
        /* renamed from: e */
        private int f1689e;
        /* renamed from: f */
        private boolean f1690f;

        public C0324b(be beVar, boolean z) {
            this.f1688a = beVar;
            this.f1690f = z;
        }

        /* renamed from: a */
        protected List<C0322a> m2749a(C0313u... c0313uArr) {
            int i;
            int i2 = 0;
            try {
                int h = c0313uArr[0].mo406h();
                i = c0313uArr[0].mo409i();
                this.f1689e = (int) c0313uArr[0].mo430z();
                i2 = h;
            } catch (Throwable th) {
                i = 0;
            }
            if (i2 <= 0 || i <= 0) {
                return null;
            }
            return this.f1688a.m2754a(this.f1689e, i2, i);
        }

        /* renamed from: a */
        protected void m2751a(List<C0322a> list) {
            if (list != null && list.size() > 0) {
                this.f1688a.m2759a((List) list, this.f1689e, this.f1690f);
                list.clear();
            }
        }
    }

    /* renamed from: a */
    private static String m2753a(String str) {
        f1691f++;
        return str + f1691f;
    }

    public be(TileOverlayOptions tileOverlayOptions, bf bfVar) {
        this.f1692a = bfVar;
        this.f1693b = tileOverlayOptions.getTileProvider();
        this.f1697g = this.f1693b.getTileWidth();
        this.f1698h = this.f1693b.getTileHeight();
        int a = C0405u.m3444a(this.f1697g);
        float f = ((float) this.f1697g) / ((float) a);
        float a2 = ((float) this.f1698h) / ((float) C0405u.m3444a(this.f1698h));
        this.f1705o = C0405u.m3461a(new float[]{0.0f, a2, f, a2, f, 0.0f, 0.0f, 0.0f});
        this.f1694c = Float.valueOf(tileOverlayOptions.getZIndex());
        this.f1695d = tileOverlayOptions.isVisible();
        this.f1704n = mo528c();
        this.f1696e = this.f1692a.m2776a();
        this.f1699i = Integer.valueOf(this.f1704n.substring("TileOverlay".length())).intValue();
        C0391a c0391a = new C0391a(this.f1692a.getContext(), this.f1704n);
        c0391a.m3356a(tileOverlayOptions.getMemoryCacheEnabled());
        c0391a.m3358b(tileOverlayOptions.getDiskCacheEnabled());
        c0391a.m3354a(tileOverlayOptions.getMemCacheSize());
        c0391a.m3357b(tileOverlayOptions.getDiskCacheSize());
        String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
        if (!(diskCacheDir == null || diskCacheDir.equals(bi_常量类.f6358b_空串))) {
            c0391a.m3355a(diskCacheDir);
        }
        this.f1700j = new C0395k(this.f1692a.getContext(), this.f1697g, this.f1698h);
        this.f1700j.m3407a(this.f1693b);
        this.f1700j.m3386a(c0391a);
        mo527b(true);
    }

    /* renamed from: a */
    public void mo521a() {
        if (this.f1703m != null && this.f1703m.m2737a() == C0385d.RUNNING) {
            this.f1703m.m2741a(true);
        }
        Iterator it = this.f1701k.iterator();
        while (it.hasNext()) {
            ((C0322a) it.next()).m2728b();
        }
        this.f1701k.clear();
        this.f1700j.m3396h();
        this.f1692a.m2782b((ah) this);
        this.f1696e.mo401e(false);
    }

    /* renamed from: b */
    public void mo526b() {
        this.f1700j.m3394f();
    }

    /* renamed from: c */
    public String mo528c() {
        if (this.f1704n == null) {
            this.f1704n = m2753a("TileOverlay");
        }
        return this.f1704n;
    }

    /* renamed from: a */
    public void mo522a(float f) {
        this.f1694c = Float.valueOf(f);
        this.f1692a.m2783c();
    }

    /* renamed from: d */
    public float mo530d() {
        return this.f1694c.floatValue();
    }

    /* renamed from: a */
    public void mo524a(boolean z) {
        this.f1695d = z;
        this.f1696e.mo401e(false);
        if (z) {
            mo527b(true);
        }
    }

    /* renamed from: e */
    public boolean mo531e() {
        return this.f1695d;
    }

    /* renamed from: a */
    public boolean mo525a(ah ahVar) {
        if (equals(ahVar) || ahVar.mo528c().equals(mo528c())) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public int mo532f() {
        return super.hashCode();
    }

    /* renamed from: a */
    private boolean m2757a(C0322a c0322a) {
        MapProjection c = this.f1696e.mo395c();
        float f = (float) c0322a.f1666c;
        int i = this.f1697g;
        int i2 = this.f1698h;
        int i3 = c0322a.f1668e.f3639x;
        int i4 = c0322a.f1668e.f3640y + ((1 << (20 - ((int) f))) * i2);
        r6 = new float[12];
        FPoint fPoint = new FPoint();
        c.geo2Map(i3, i4, fPoint);
        FPoint fPoint2 = new FPoint();
        c.geo2Map(((1 << (20 - ((int) f))) * i) + i3, i4, fPoint2);
        FPoint fPoint3 = new FPoint();
        c.geo2Map((i * (1 << (20 - ((int) f)))) + i3, i4 - ((1 << (20 - ((int) f))) * i2), fPoint3);
        FPoint fPoint4 = new FPoint();
        c.geo2Map(i3, i4 - ((1 << (20 - ((int) f))) * i2), fPoint4);
        r6[0] = fPoint.f3637x;
        r6[1] = fPoint.f3638y;
        r6[2] = 0.0f;
        r6[3] = fPoint2.f3637x;
        r6[4] = fPoint2.f3638y;
        r6[5] = 0.0f;
        r6[6] = fPoint3.f3637x;
        r6[7] = fPoint3.f3638y;
        r6[8] = 0.0f;
        r6[9] = fPoint4.f3637x;
        r6[10] = fPoint4.f3638y;
        r6[11] = 0.0f;
        if (c0322a.f1671h == null) {
            c0322a.f1671h = C0405u.m3461a(r6);
        } else {
            c0322a.f1671h = C0405u.m3462a(r6, c0322a.f1671h);
        }
        return true;
    }

    /* renamed from: a */
    private void m2756a(GL10 gl10, int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer != null && floatBuffer2 != null) {
            gl10.glEnable(3042);
            gl10.glTexEnvf(8960, 8704, 8448.0f);
            gl10.glBlendFunc(770, 771);
            gl10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            gl10.glEnable(3553);
            gl10.glEnableClientState(32884);
            gl10.glEnableClientState(32888);
            gl10.glBindTexture(3553, i);
            gl10.glVertexPointer(3, 5126, 0, floatBuffer);
            gl10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            gl10.glDrawArrays(6, 0, 4);
            gl10.glDisableClientState(32884);
            gl10.glDisableClientState(32888);
            gl10.glDisable(3553);
            gl10.glDisable(3042);
        }
    }

    /* renamed from: a */
    public void mo523a(GL10 gl10) {
        if (this.f1701k != null && this.f1701k.size() != 0) {
            Iterator it = this.f1701k.iterator();
            while (it.hasNext()) {
                C0322a c0322a = (C0322a) it.next();
                if (!c0322a.f1670g) {
                    try {
                        IPoint iPoint = c0322a.f1668e;
                        if (!(c0322a.f1672i == null || c0322a.f1672i.isRecycled() || iPoint == null)) {
                            c0322a.f1669f = C0405u.m3447a(gl10, c0322a.f1672i);
                            if (c0322a.f1669f != 0) {
                                c0322a.f1670g = true;
                            }
                            c0322a.f1672i = null;
                        }
                    } catch (Throwable th) {
                        az.m3143a(th, "TileOverlayDelegateImp", "drawTiles");
                        C0399o.m3422a("TileOverlayDelegateImp", th.toString(), ErrorCode.DOWNLOAD_OVER_FLOW);
                    }
                }
                if (c0322a.f1670g) {
                    m2757a(c0322a);
                    m2756a(gl10, c0322a.f1669f, c0322a.f1671h, this.f1705o);
                }
            }
        }
    }

    /* renamed from: a */
    private ArrayList<C0322a> m2754a(int i, int i2, int i3) {
        MapProjection c = this.f1696e.mo395c();
        FPoint fPoint = new FPoint();
        IPoint iPoint = new IPoint();
        IPoint iPoint2 = new IPoint();
        c.win2Map(0, 0, fPoint);
        c.map2Geo(fPoint.f3637x, fPoint.f3638y, iPoint);
        int min = Math.min(Integer.MAX_VALUE, iPoint.f3639x);
        int max = Math.max(0, iPoint.f3639x);
        int min2 = Math.min(Integer.MAX_VALUE, iPoint.f3640y);
        int max2 = Math.max(0, iPoint.f3640y);
        c.win2Map(i2, 0, fPoint);
        c.map2Geo(fPoint.f3637x, fPoint.f3638y, iPoint);
        min = Math.min(min, iPoint.f3639x);
        max = Math.max(max, iPoint.f3639x);
        min2 = Math.min(min2, iPoint.f3640y);
        max2 = Math.max(max2, iPoint.f3640y);
        c.win2Map(0, i3, fPoint);
        c.map2Geo(fPoint.f3637x, fPoint.f3638y, iPoint);
        min = Math.min(min, iPoint.f3639x);
        max = Math.max(max, iPoint.f3639x);
        min2 = Math.min(min2, iPoint.f3640y);
        max2 = Math.max(max2, iPoint.f3640y);
        c.win2Map(i2, i3, fPoint);
        c.map2Geo(fPoint.f3637x, fPoint.f3638y, iPoint);
        min = Math.min(min, iPoint.f3639x);
        int max3 = Math.max(max, iPoint.f3639x);
        max = Math.min(min2, iPoint.f3640y);
        int max4 = Math.max(max2, iPoint.f3640y);
        int i4 = min - ((1 << (20 - i)) * this.f1697g);
        int i5 = max - ((1 << (20 - i)) * this.f1698h);
        c.getGeoCenter(iPoint2);
        max = (iPoint2.f3639x >> (20 - i)) / this.f1697g;
        min2 = (iPoint2.f3640y >> (20 - i)) / this.f1698h;
        int i6 = (max << (20 - i)) * this.f1697g;
        int i7 = (min2 << (20 - i)) * this.f1698h;
        C0322a c0322a = new C0322a(this, max, min2, i, this.f1699i);
        c0322a.f1668e = new IPoint(i6, i7);
        ArrayList<C0322a> arrayList = new ArrayList();
        arrayList.add(c0322a);
        min = 1;
        while (true) {
            Object obj = null;
            for (i6 = max - min; i6 <= max + min; i6++) {
                i7 = min2 + min;
                IPoint iPoint3 = new IPoint((i6 << (20 - i)) * this.f1697g, (i7 << (20 - i)) * this.f1698h);
                if (iPoint3.f3639x < max3 && iPoint3.f3639x > i4 && iPoint3.f3640y < max4 && iPoint3.f3640y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    C0322a c0322a2 = new C0322a(this, i6, i7, i, this.f1699i);
                    c0322a2.f1668e = iPoint3;
                    arrayList.add(c0322a2);
                }
                i7 = min2 - min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.f1697g, (i7 << (20 - i)) * this.f1698h);
                if (iPoint3.f3639x < max3 && iPoint3.f3639x > i4 && iPoint3.f3640y < max4 && iPoint3.f3640y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    c0322a2 = new C0322a(this, i6, i7, i, this.f1699i);
                    c0322a2.f1668e = iPoint3;
                    arrayList.add(c0322a2);
                }
            }
            for (i7 = (min2 + min) - 1; i7 > min2 - min; i7--) {
                i6 = max + min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.f1697g, (i7 << (20 - i)) * this.f1698h);
                if (iPoint3.f3639x < max3 && iPoint3.f3639x > i4 && iPoint3.f3640y < max4 && iPoint3.f3640y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    c0322a2 = new C0322a(this, i6, i7, i, this.f1699i);
                    c0322a2.f1668e = iPoint3;
                    arrayList.add(c0322a2);
                }
                i6 = max - min;
                iPoint3 = new IPoint((i6 << (20 - i)) * this.f1697g, (i7 << (20 - i)) * this.f1698h);
                if (iPoint3.f3639x < max3 && iPoint3.f3639x > i4 && iPoint3.f3640y < max4 && iPoint3.f3640y > i5) {
                    if (obj == null) {
                        obj = 1;
                    }
                    c0322a2 = new C0322a(this, i6, i7, i, this.f1699i);
                    c0322a2.f1668e = iPoint3;
                    arrayList.add(c0322a2);
                }
            }
            if (obj == null) {
                return arrayList;
            }
            min++;
        }
    }

    /* renamed from: a */
    private boolean m2759a(List<C0322a> list, int i, boolean z) {
        int i2 = 0;
        if (list == null) {
            return false;
        }
        if (this.f1701k == null) {
            return false;
        }
        Iterator it = this.f1701k.iterator();
        while (it.hasNext()) {
            int i3;
            C0322a c0322a = (C0322a) it.next();
            for (C0322a c0322a2 : list) {
                if (c0322a.equals(c0322a2) && c0322a.f1670g) {
                    c0322a2.f1670g = c0322a.f1670g;
                    c0322a2.f1669f = c0322a.f1669f;
                    i3 = 1;
                    break;
                }
            }
            i3 = 0;
            if (i3 == 0) {
                c0322a.m2728b();
            }
        }
        this.f1701k.clear();
        if (i > ((int) this.f1696e.mo415m()) || i < ((int) this.f1696e.mo416n())) {
            return false;
        }
        i3 = list.size();
        if (i3 <= 0) {
            return false;
        }
        while (i2 < i3) {
            c0322a = (C0322a) list.get(i2);
            if (c0322a != null) {
                this.f1701k.add(c0322a);
                if (!c0322a.f1670g) {
                    this.f1700j.m3388a(z, c0322a);
                }
            }
            i2++;
        }
        return true;
    }

    /* renamed from: b */
    public void mo527b(boolean z) {
        if (!this.f1702l) {
            if (this.f1703m != null && this.f1703m.m2737a() == C0385d.RUNNING) {
                this.f1703m.m2741a(true);
            }
            this.f1703m = new C0324b(this, z);
            this.f1703m.m2745c((Object[]) new C0313u[]{this.f1696e});
        }
    }

    /* renamed from: g */
    public void mo533g() {
        this.f1700j.m3390b(false);
        this.f1700j.m3387a(true);
        this.f1700j.m3395g();
    }

    /* renamed from: h */
    public void mo534h() {
        this.f1700j.m3387a(false);
    }

    /* renamed from: c */
    public void mo529c(boolean z) {
        if (this.f1702l != z) {
            this.f1702l = z;
            this.f1700j.m3390b(z);
        }
    }
}
