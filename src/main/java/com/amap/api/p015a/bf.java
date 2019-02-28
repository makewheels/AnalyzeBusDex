package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.amap.api.mapcore2d.MapViewListener;
import com.amap.api.p015a.C0222b.C0217b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.lang.reflect.Field;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p054u.aly.bi_常量类;

/* compiled from: Mediator */
/* renamed from: com.amap.api.a.bf */
class bf {
    /* renamed from: a */
    public C0230e f836a;
    /* renamed from: b */
    public C0229d f837b;
    /* renamed from: c */
    public C0227b f838c;
    /* renamed from: d */
    public C0226a f839d;
    /* renamed from: e */
    public C0228c f840e;
    /* renamed from: f */
    public ab f841f;
    /* renamed from: g */
    public C0222b f842g;
    /* renamed from: h */
    public ba f843h = null;

    /* compiled from: Mediator */
    /* renamed from: com.amap.api.a.bf$a */
    public class C0226a {
        /* renamed from: a */
        public bq<as> f807a = null;
        /* renamed from: b */
        public boolean f808b = false;
        /* renamed from: c */
        public boolean f809c = false;
        /* renamed from: d */
        String f810d = "GridMapV2";
        /* renamed from: e */
        String f811e = "SatelliteMap";
        /* renamed from: f */
        String f812f = "GridTmc";
        /* renamed from: g */
        String f813g = "SateliteTmc";
        /* renamed from: h */
        final /* synthetic */ bf f814h;
        /* renamed from: i */
        private boolean f815i = false;
        /* renamed from: j */
        private boolean f816j = true;
        /* renamed from: k */
        private C0217b f817k = C0217b.DRAW_RETICLE_NEVER;
        /* renamed from: l */
        private int f818l = 0;
        /* renamed from: m */
        private int f819m = 0;
        /* renamed from: n */
        private boolean f820n = false;

        /* compiled from: Mediator */
        /* renamed from: com.amap.api.a.bf$a$1 */
        class C02251 extends cd {
            /* renamed from: a */
            final /* synthetic */ C0226a f806a;

            C02251(C0226a c0226a) {
                this.f806a = c0226a;
            }

            /* renamed from: a */
            public String mo74a(int i, int i2, int i3) {
                return bd.m1300a().m1301b() + "/appmaptile?z=" + i3 + "&x=" + i + "&y=" + i2 + "&lang=zh_cn&size=1&scale=1&style=7";
            }
        }

        public C0226a(bf bfVar, Context context) {
            this.f814h = bfVar;
            if (context != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                int i = (displayMetrics.widthPixels / 256) + 2;
                int i2 = (displayMetrics.heightPixels / 256) + 2;
                this.f818l = (i + (i * i2)) + i2;
                this.f819m = (this.f818l / 8) + 1;
                if (this.f819m == 0) {
                    this.f819m = 1;
                } else if (this.f819m > 5) {
                    this.f819m = 5;
                }
                m1355a(context);
            }
        }

        /* renamed from: a */
        private void m1355a(Context context) {
            if (this.f807a == null) {
                this.f807a = new bq();
            }
            as asVar = new as();
            asVar.f645j = new C02251(this);
            asVar.f636a = this.f810d;
            asVar.f640e = true;
            asVar.f639d = true;
            asVar.f641f = true;
            asVar.f642g = true;
            asVar.f637b = C0269x.f1182c;
            asVar.f638c = C0269x.f1183d;
            m1368a(asVar, context);
        }

        /* renamed from: a */
        boolean m1369a(String str, boolean z) {
            if (str.equals(bi_常量类.f6358b)) {
                return false;
            }
            int size = this.f807a.size();
            for (int i = 0; i < size; i++) {
                as asVar = (as) this.f807a.get(i);
                if (asVar != null && asVar.f636a.equals(str)) {
                    asVar.f641f = z;
                    if (!asVar.f640e) {
                        return true;
                    }
                    if (z) {
                        if (asVar.f637b > asVar.f638c) {
                            this.f814h.f837b.m1389b(asVar.f637b);
                            this.f814h.f837b.m1392c(asVar.f638c);
                        }
                        m1359b(str);
                        this.f814h.f837b.m1387a(false, false);
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: b */
        private void m1359b(String str) {
            if (!str.equals(bi_常量类.f6358b)) {
                int size = this.f807a.size();
                for (int i = 0; i < size; i++) {
                    as asVar = (as) this.f807a.get(i);
                    if (asVar != null && !asVar.f636a.equals(str) && asVar.f640e && asVar.f641f) {
                        asVar.f641f = false;
                    }
                }
            }
        }

        /* renamed from: c */
        private boolean m1361c(String str) {
            if (this.f807a == null) {
                return false;
            }
            int size = this.f807a.size();
            for (int i = 0; i < size; i++) {
                as asVar = (as) this.f807a.get(i);
                if (asVar != null && asVar.f636a.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: a */
        boolean m1368a(as asVar, Context context) {
            if (asVar == null || asVar.f636a.equals(bi_常量类.f6358b) || m1361c(asVar.f636a)) {
                return false;
            }
            boolean add;
            asVar.f650o = new bq();
            asVar.f648m = new C0257p(this.f818l, this.f819m, asVar.f643h, asVar.f644i);
            asVar.f649n = new C0258q(context, this.f814h.f837b.f831d.f724c, asVar);
            asVar.f649n.m1669a(asVar.f648m);
            int size = this.f807a.size();
            if (!asVar.f640e || size == 0) {
                add = this.f807a.add(asVar);
            } else {
                for (int i = size - 1; i >= 0; i--) {
                    as asVar2 = (as) this.f807a.get(i);
                    if (asVar2 != null && asVar2.f640e) {
                        this.f807a.add(i, asVar);
                        add = false;
                        break;
                    }
                }
                add = false;
            }
            m1357b();
            if (asVar.f641f) {
                m1369a(asVar.f636a, true);
            }
            return add;
        }

        /* renamed from: b */
        private void m1357b() {
            int size = this.f807a.size();
            for (int i = 0; i < size; i++) {
                as asVar = (as) this.f807a.get(i);
                if (asVar != null) {
                    asVar.f646k = i;
                }
            }
        }

        /* renamed from: a */
        as m1362a(String str) {
            if (str.equals(bi_常量类.f6358b) || this.f807a == null || this.f807a.size() == 0) {
                return null;
            }
            int size = this.f807a.size();
            for (int i = 0; i < size; i++) {
                as asVar = (as) this.f807a.get(i);
                if (asVar != null && asVar.f636a.equals(str)) {
                    return asVar;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void m1363a() {
            if (this.f814h.f837b != null && this.f814h.f837b.f831d != null) {
                this.f814h.f837b.f831d.postInvalidate();
            }
        }

        /* renamed from: a */
        public void m1365a(boolean z) {
            this.f815i = z;
        }

        /* renamed from: a */
        public void m1364a(Canvas canvas, Matrix matrix, float f, float f2) {
            if (this.f815i) {
                canvas.save();
                canvas.translate(f, f2);
                canvas.concat(matrix);
                m1356a(canvas);
                if (this.f814h.f842g.f729h.m1540b()) {
                    m1358b(canvas);
                }
                this.f814h.f842g.f729h.m1537a(canvas);
                canvas.restore();
                if (!this.f814h.f842g.f729h.m1540b()) {
                    m1358b(canvas);
                }
                if (!(this.f808b || this.f809c)) {
                    m1365a(false);
                    this.f814h.f837b.f831d.mo119b(new Matrix());
                    this.f814h.f837b.f831d.mo124c(1.0f);
                    this.f814h.f837b.f831d.m1181I();
                }
            } else {
                m1356a(canvas);
                m1358b(canvas);
                this.f814h.f842g.f729h.m1537a(canvas);
            }
            this.f814h.f837b.m1397h();
            m1360c(canvas);
        }

        /* renamed from: b */
        public void m1370b(boolean z) {
            this.f816j = z;
        }

        /* renamed from: a */
        private void m1356a(Canvas canvas) {
            int size = this.f807a.size();
            for (int i = 0; i < size; i++) {
                as asVar = (as) this.f807a.get(i);
                if (asVar != null && asVar.f641f) {
                    asVar.m1060a(canvas);
                }
            }
        }

        /* renamed from: b */
        private void m1358b(Canvas canvas) {
            if (this.f816j) {
                this.f814h.f841f.m817a(canvas);
            }
        }

        /* renamed from: c */
        private void m1360c(Canvas canvas) {
            this.f814h.f842g.f730i.m1114a(canvas);
        }

        /* renamed from: a */
        public boolean m1366a(int i, KeyEvent keyEvent) {
            return false;
        }

        /* renamed from: b */
        public boolean m1371b(int i, KeyEvent keyEvent) {
            return false;
        }

        /* renamed from: a */
        public boolean m1367a(MotionEvent motionEvent) {
            return false;
        }

        /* renamed from: b */
        protected boolean m1372b(MotionEvent motionEvent) {
            this.f814h.f836a.mo183a((int) motionEvent.getX(), (int) motionEvent.getY());
            return false;
        }
    }

    /* compiled from: Mediator */
    /* renamed from: com.amap.api.a.bf$b */
    public class C0227b {
        /* renamed from: a */
        public boolean f821a = false;
        /* renamed from: b */
        int f822b = 0;
        /* renamed from: c */
        final /* synthetic */ bf f823c;

        public C0227b(bf bfVar) {
            this.f823c = bfVar;
            m1376d();
        }

        /* renamed from: a */
        public void m1373a() {
            this.f823c.f837b.f828a = false;
            for (int i = 0; i < this.f823c.f840e.f827d.size(); i++) {
                bc bcVar = (bc) this.f823c.f840e.f827d.valueAt(i);
                if (bcVar != null) {
                    bcVar.mo220a();
                }
            }
        }

        /* renamed from: b */
        public void m1374b() {
            for (int i = 0; i < this.f823c.f840e.f827d.size(); i++) {
                bc bcVar = (bc) this.f823c.f840e.f827d.valueAt(i);
                if (bcVar != null) {
                    bcVar.mo222c();
                }
            }
        }

        /* renamed from: c */
        public void m1375c() {
            for (int i = 0; i < this.f823c.f840e.f827d.size(); i++) {
                bc bcVar = (bc) this.f823c.f840e.f827d.valueAt(i);
                if (bcVar != null) {
                    bcVar.mo221b();
                }
            }
        }

        /* renamed from: d */
        public void m1376d() {
            for (int i = 0; i < this.f823c.f840e.f827d.size(); i++) {
                bc bcVar = (bc) this.f823c.f840e.f827d.valueAt(i);
                if (bcVar != null) {
                    bcVar.mo228g();
                }
            }
            this.f823c.f840e.m1378b();
        }
    }

    /* compiled from: Mediator */
    /* renamed from: com.amap.api.a.bf$c */
    public class C0228c {
        /* renamed from: a */
        final /* synthetic */ bf f824a;
        /* renamed from: b */
        private final Context f825b;
        /* renamed from: c */
        private Proxy f826c;
        /* renamed from: d */
        private SparseArray<bc> f827d = new SparseArray();

        public C0228c(bf bfVar, bf bfVar2, Context context) {
            this.f824a = bfVar;
            this.f825b = context;
            this.f827d.put(0, new bw(bfVar2, context));
        }

        /* renamed from: a */
        public Proxy m1380a() {
            return this.f826c;
        }

        /* renamed from: b */
        private void m1378b() {
            this.f826c = C0270y.m1734a(this.f825b);
        }
    }

    /* compiled from: Mediator */
    /* renamed from: com.amap.api.a.bf$d */
    public class C0229d {
        /* renamed from: a */
        public boolean f828a = true;
        /* renamed from: b */
        public ArrayList<MapViewListener> f829b;
        /* renamed from: c */
        final /* synthetic */ bf f830c;
        /* renamed from: d */
        private C0222b f831d;
        /* renamed from: e */
        private ArrayList<ce> f832e;

        public C0229d(bf bfVar, C0222b c0222b) {
            this.f830c = bfVar;
            this.f831d = c0222b;
            this.f832e = new ArrayList();
            this.f829b = new ArrayList();
        }

        /* renamed from: a */
        public void m1383a(int i) {
            if (i != this.f830c.f843h.f758g) {
                this.f830c.f843h.f758g = i;
                this.f830c.f842g.f723b[1] = i;
                this.f830c.f842g.f726e.m1631a((float) i);
            }
            m1387a(false, false);
        }

        /* renamed from: a */
        public void m1384a(int i, int i2) {
            if (i != C0269x.f1188i || i2 != C0269x.f1189j) {
                C0269x.f1188i = i;
                C0269x.f1189j = i2;
                m1387a(true, false);
            }
        }

        /* renamed from: a */
        public void m1385a(ac acVar) {
            if (acVar != null) {
                if (C0269x.f1191l) {
                    this.f830c.f843h.f761j = this.f830c.f843h.m1288a(acVar);
                }
                m1387a(false, false);
            }
        }

        /* renamed from: b */
        public void m1390b(ac acVar) {
            ac f = this.f830c.f837b.m1395f();
            if (acVar != null && !acVar.equals(f)) {
                if (C0269x.f1191l) {
                    this.f830c.f843h.f761j = this.f830c.f843h.m1288a(acVar);
                }
                m1387a(false, true);
            }
        }

        /* renamed from: a */
        public int m1382a() {
            return this.f830c.f843h.f757f;
        }

        /* renamed from: b */
        public void m1389b(int i) {
            if (i > 0) {
                ba baVar = this.f830c.f843h;
                C0269x.f1182c = i;
                baVar.f757f = i;
            }
        }

        /* renamed from: b */
        public int m1388b() {
            return this.f830c.f843h.f756e;
        }

        /* renamed from: c */
        public void m1392c(int i) {
            if (i > 0) {
                ba baVar = this.f830c.f843h;
                C0269x.f1183d = i;
                baVar.f756e = i;
            }
        }

        /* renamed from: c */
        public int m1391c() {
            return C0269x.f1188i;
        }

        /* renamed from: d */
        public int m1393d() {
            return C0269x.f1189j;
        }

        /* renamed from: e */
        public int m1394e() {
            return this.f830c.f843h.f758g;
        }

        /* renamed from: f */
        public ac m1395f() {
            ac b = this.f830c.f843h.m1295b(this.f830c.f843h.f761j);
            if (this.f830c.f838c == null || !this.f830c.f838c.f821a) {
                return b;
            }
            return this.f830c.f843h.f762k;
        }

        /* renamed from: a */
        public void m1386a(ce ceVar) {
            this.f832e.add(ceVar);
        }

        /* renamed from: a */
        public void m1387a(boolean z, boolean z2) {
            Iterator it = this.f832e.iterator();
            while (it.hasNext()) {
                ((ce) it.next()).mo225a(z, z2);
            }
            if (this.f830c.f842g != null && this.f830c.f842g.f729h != null) {
                this.f830c.f842g.f729h.m1539a(true);
                this.f830c.f842g.postInvalidate();
            }
        }

        /* renamed from: g */
        public C0222b m1396g() {
            return this.f831d;
        }

        /* renamed from: h */
        public void m1397h() {
        }
    }

    /* compiled from: Mediator */
    /* renamed from: com.amap.api.a.bf$e */
    public class C0230e implements bl {
        /* renamed from: a */
        final /* synthetic */ bf f833a;
        /* renamed from: b */
        private int f834b = 0;
        /* renamed from: c */
        private HashMap<Float, Float> f835c = new HashMap();

        public C0230e(bf bfVar) {
            this.f833a = bfVar;
        }

        /* renamed from: a */
        public Point mo182a(ac acVar, Point point) {
            int i;
            int e = this.f833a.f837b.m1394e();
            PointF b = this.f833a.f843h.m1293b(acVar, this.f833a.f843h.f761j, this.f833a.f843h.f763l, this.f833a.f843h.f759h[e]);
            bg G = this.f833a.f837b.f831d.m1179G();
            Point point2 = this.f833a.f837b.f831d.mo84a().f843h.f763l;
            float f;
            float f2;
            if (!G.f861n) {
                f = ((float) point2.x) + (ch.f1018h * ((float) (((int) b.x) - point2.x)));
                f2 = (((float) (((int) b.y) - point2.y)) * ch.f1018h) + ((float) point2.y);
                e = (int) f;
                i = (int) f2;
                if (((double) f) >= ((double) e) + 0.5d) {
                    e++;
                }
                if (((double) f2) >= ((double) i) + 0.5d) {
                    i++;
                }
            } else if (G.f860m) {
                f2 = ((bg.f845k * (((float) ((int) b.x)) - G.f855g.x)) + G.f855g.x) + (G.f856h.x - G.f855g.x);
                f = (((((float) ((int) b.y)) - G.f855g.y) * bg.f845k) + G.f855g.y) + (G.f856h.y - G.f855g.y);
                e = (int) f2;
                i = (int) f;
                if (((double) f2) >= ((double) e) + 0.5d) {
                    e++;
                }
                if (((double) f) >= ((double) i) + 0.5d) {
                    i++;
                }
            } else {
                e = (int) b.x;
                i = (int) b.y;
            }
            point2 = new Point(e, i);
            if (point != null) {
                point.x = point2.x;
                point.y = point2.y;
            }
            return point2;
        }

        /* renamed from: a */
        public ac mo183a(int i, int i2) {
            int e = this.f833a.f837b.m1394e();
            return this.f833a.f843h.m1287a(new PointF((float) i, (float) i2), this.f833a.f843h.f761j, this.f833a.f843h.f763l, this.f833a.f843h.f759h[e], this.f833a.f843h.f764m);
        }

        /* renamed from: a */
        public float m1401a(float f) {
            int e = this.f833a.f837b.m1394e();
            if (this.f835c.size() > 30 || e != this.f834b) {
                this.f834b = e;
                this.f835c.clear();
            }
            if (!this.f835c.containsKey(Float.valueOf(f))) {
                float a = this.f833a.f843h.m1284a(mo183a(0, 0), mo183a(0, 10));
                if (a <= 0.0f) {
                    return 0.0f;
                }
                this.f835c.put(Float.valueOf(f), Float.valueOf(10.0f * (f / a)));
            }
            return ((Float) this.f835c.get(Float.valueOf(f))).floatValue();
        }

        /* renamed from: a */
        public int m1402a() {
            return m1400a(false);
        }

        /* renamed from: b */
        public int m1405b() {
            return m1400a(true);
        }

        /* renamed from: a */
        private int m1400a(boolean z) {
            int c = this.f833a.f837b.m1391c();
            ac a = mo183a(0, this.f833a.f837b.m1393d());
            ac a2 = mo183a(c, 0);
            return z ? Math.abs(a.m821a() - a2.m821a()) : Math.abs(a.m823b() - a2.m823b());
        }
    }

    public bf(Context context, C0222b c0222b) {
        this.f842g = c0222b;
        this.f837b = new C0229d(this, c0222b);
        this.f843h = new ba(this.f837b);
        this.f843h.m1290a();
        m1406a(context);
        this.f840e = new C0228c(this, this, context);
        this.f839d = new C0226a(this, context);
        this.f836a = new C0230e(this);
        this.f838c = new C0227b(this);
        this.f841f = new ab();
        this.f837b.m1387a(false, false);
    }

    /* renamed from: a */
    public void m1406a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        DisplayMetrics displayMetrics2 = context.getApplicationContext().getResources().getDisplayMetrics();
        Field field = null;
        try {
            field = displayMetrics2.getClass().getField("densityDpi");
        } catch (SecurityException e) {
        } catch (NoSuchFieldException e2) {
        }
        if (field != null) {
            int i;
            long j = (long) (displayMetrics2.widthPixels * displayMetrics2.heightPixels);
            try {
                i = field.getInt(displayMetrics2);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                i = 160;
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
                i = 160;
            }
            if (i <= ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
                C0269x.f1186g = 1;
                return;
            } else if (i <= 160) {
                C0269x.f1186g = 3;
                return;
            } else if (i <= 240) {
                C0269x.f1186g = 2;
                return;
            } else if (j > 153600) {
                C0269x.f1186g = 2;
                return;
            } else if (j < 153600) {
                C0269x.f1186g = 1;
                return;
            } else {
                C0269x.f1186g = 3;
                return;
            }
        }
        long j2 = (long) (displayMetrics2.widthPixels * displayMetrics2.heightPixels);
        if (j2 > 153600) {
            C0269x.f1186g = 2;
        } else if (j2 < 153600) {
            C0269x.f1186g = 1;
        } else {
            C0269x.f1186g = 3;
        }
    }

    /* renamed from: a */
    public void m1407a(boolean z) {
        this.f839d.m1370b(z);
    }
}
