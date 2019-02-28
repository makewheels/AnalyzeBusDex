package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import com.e4a.runtime.components.Component;
import java.io.InputStream;
import java.util.List;
import p054u.aly.bi_常量类;

/* compiled from: BitmapManager */
/* renamed from: com.amap.api.a.p */
class C0257p {
    /* renamed from: a */
    protected final C0256a[] f1068a;
    /* renamed from: b */
    protected final int f1069b;
    /* renamed from: c */
    protected final int f1070c;
    /* renamed from: d */
    protected final C0256a[] f1071d;
    /* renamed from: e */
    Paint f1072e = null;
    /* renamed from: f */
    Path f1073f = null;
    /* renamed from: g */
    private boolean f1074g = false;
    /* renamed from: h */
    private long f1075h = 0;

    /* compiled from: BitmapManager */
    /* renamed from: com.amap.api.a.p$a */
    class C0256a {
        /* renamed from: a */
        Bitmap f1060a = null;
        /* renamed from: b */
        String f1061b = bi_常量类.f6358b_空串;
        /* renamed from: c */
        boolean f1062c = false;
        /* renamed from: d */
        long f1063d = 0;
        /* renamed from: e */
        int f1064e = -1;
        /* renamed from: f */
        long f1065f = 0;
        /* renamed from: g */
        List<by> f1066g = null;
        /* renamed from: h */
        final /* synthetic */ C0257p f1067h;

        public C0256a(C0257p c0257p) {
            this.f1067h = c0257p;
        }
    }

    public C0257p(int i, int i2, boolean z, long j) {
        this.f1069b = i;
        this.f1070c = i2;
        this.f1074g = z;
        this.f1075h = 1000000 * j;
        if (this.f1069b > 0) {
            this.f1068a = new C0256a[this.f1069b];
            this.f1071d = new C0256a[this.f1070c];
            return;
        }
        this.f1068a = null;
        this.f1071d = null;
    }

    /* renamed from: a */
    protected int m1658a(String str) {
        if (str.equals(bi_常量类.f6358b_空串)) {
            return -1;
        }
        int i = 0;
        while (i < this.f1069b) {
            if (this.f1068a[i] == null || !this.f1068a[i].f1061b.equals(str)) {
                i++;
            } else if (!this.f1068a[i].f1062c) {
                return -1;
            } else {
                if (!this.f1074g || m1656c() - this.f1068a[i].f1065f <= this.f1075h) {
                    this.f1068a[i].f1063d = m1656c();
                    return i;
                }
                this.f1068a[i].f1062c = false;
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: a */
    protected Bitmap m1660a(int i) {
        if (i < 0 || i >= this.f1069b || this.f1068a[i] == null) {
            return null;
        }
        return this.f1068a[i].f1060a;
    }

    /* renamed from: a */
    protected synchronized int m1659a(byte[] bArr, InputStream inputStream, boolean z, List<by> list, String str) {
        int i = -1;
        synchronized (this) {
            if (!(bArr == null && inputStream == null && list == null)) {
                int b = m1661b();
                if (b < 0) {
                    b = m1657a();
                }
                if (b >= 0 && this.f1068a != null) {
                    if (!(this.f1068a[b] == null || this.f1068a[b].f1060a == null || this.f1068a[b].f1060a.isRecycled())) {
                        this.f1068a[b].f1060a.recycle();
                        this.f1068a[b].f1060a = null;
                    }
                    if (this.f1068a[b].f1066g != null) {
                        this.f1068a[b].f1066g.clear();
                        this.f1068a[b].f1066g = null;
                    }
                    if (z && bArr != null) {
                        try {
                            this.f1068a[b].f1060a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                        } catch (OutOfMemoryError e) {
                        }
                    } else if (inputStream != null) {
                        try {
                            this.f1068a[b].f1060a = BitmapFactory.decodeStream(inputStream);
                        } catch (OutOfMemoryError e2) {
                        }
                    }
                    if (list != null) {
                        this.f1068a[b].f1060a = Bitmap.createBitmap(256, 256, Config.ARGB_4444);
                        m1655a(this.f1068a[b].f1060a, list);
                    }
                    if (!(this.f1068a == null || (this.f1068a[b].f1060a == null && this.f1068a[b].f1066g == null))) {
                        if (this.f1068a[b] != null) {
                            this.f1068a[b].f1062c = true;
                            this.f1068a[b].f1061b = str;
                            this.f1068a[b].f1063d = m1656c();
                            if (this.f1074g) {
                                this.f1068a[b].f1065f = m1656c();
                            }
                        }
                        i = b;
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: c */
    private long m1656c() {
        return System.nanoTime();
    }

    /* renamed from: a */
    protected int m1657a() {
        int i;
        for (i = 0; i < this.f1070c; i++) {
            this.f1071d[i] = null;
        }
        for (int i2 = 0; i2 < this.f1069b; i2++) {
            C0256a c0256a = this.f1068a[i2];
            int i3 = 0;
            while (i3 < this.f1070c) {
                if (this.f1071d[i3] == null) {
                    this.f1071d[i3] = c0256a;
                    break;
                }
                C0256a c0256a2;
                if (this.f1071d[i3].f1063d > c0256a.f1063d) {
                    c0256a2 = this.f1071d[i3];
                    this.f1071d[i3] = c0256a;
                } else {
                    c0256a2 = c0256a;
                }
                i3++;
                c0256a = c0256a2;
            }
        }
        int i4 = -1;
        for (i = 0; i < this.f1070c; i++) {
            if (this.f1071d[i] != null) {
                this.f1071d[i].f1062c = false;
                if (i4 < 0) {
                    i4 = this.f1071d[i].f1064e;
                }
            }
        }
        return i4;
    }

    /* renamed from: b */
    protected int m1661b() {
        int i = -1;
        for (int i2 = 0; i2 < this.f1069b; i2++) {
            if (this.f1068a[i2] == null) {
                this.f1068a[i2] = new C0256a(this);
                this.f1068a[i2].f1064e = i2;
                return i2;
            }
            if (!this.f1068a[i2].f1062c && i < 0) {
                i = i2;
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m1655a(Bitmap bitmap, final List<by> list) {
        C0250o c02551 = new C0250o(this) {
            /* renamed from: b */
            final /* synthetic */ C0257p f1059b;

            /* renamed from: a */
            public void mo256a(Canvas canvas) {
                if (this.f1059b.f1072e == null) {
                    this.f1059b.f1072e = new Paint();
                    this.f1059b.f1072e.setStyle(Style.STROKE);
                    this.f1059b.f1072e.setDither(true);
                    this.f1059b.f1072e.setAntiAlias(true);
                    this.f1059b.f1072e.setStrokeJoin(Join.ROUND);
                    this.f1059b.f1072e.setStrokeCap(Cap.ROUND);
                }
                if (this.f1059b.f1073f == null) {
                    this.f1059b.f1073f = new Path();
                }
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    by byVar = (by) list.get(i);
                    this.f1059b.f1072e.setStrokeWidth(3.0f);
                    int b = byVar.m1576b();
                    if (b == 1) {
                        this.f1059b.f1072e.setColor(Component.f3916);
                    } else if (b == 2) {
                        this.f1059b.f1072e.setColor(Component.f3941);
                    } else if (b == 3) {
                        this.f1059b.f1072e.setColor(Component.f3920);
                    }
                    List a = byVar.m1575a();
                    int size2 = a.size();
                    int i2 = 0;
                    boolean z = true;
                    while (i2 < size2) {
                        boolean z2;
                        PointF pointF = (PointF) a.get(i2);
                        if (z) {
                            this.f1059b.f1073f.moveTo(pointF.x, pointF.y);
                            z2 = false;
                        } else {
                            this.f1059b.f1073f.lineTo(pointF.x, pointF.y);
                            z2 = z;
                        }
                        i2++;
                        z = z2;
                    }
                    canvas.drawPath(this.f1059b.f1073f, this.f1059b.f1072e);
                    this.f1059b.f1073f.reset();
                }
            }
        };
        C0254n c0254n = new C0254n(null);
        c0254n.m1651a(bitmap);
        c0254n.m1652a(c02551);
    }
}
