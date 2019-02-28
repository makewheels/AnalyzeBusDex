package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import com.e4a.runtime.components.Component;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: BaseMapTile */
/* renamed from: com.amap.api.a.m */
class C0253m {
    /* renamed from: a */
    private static Paint f1052a = null;
    /* renamed from: b */
    private static Bitmap f1053b = null;
    /* renamed from: c */
    private static int f1054c = Color.rgb(222, ErrorCode.COPY_EXCEPTION, ErrorCode.COPY_TMPDIR_ERROR);

    /* compiled from: BaseMapTile */
    /* renamed from: com.amap.api.a.m$1 */
    static class C02511 implements C0250o {
        C02511() {
        }

        /* renamed from: a */
        public void mo256a(Canvas canvas) {
            Paint b = C0253m.m1647b();
            canvas.drawColor(C0253m.m1646a());
            for (int i = 0; i < 235; i += 21) {
                canvas.drawLine((float) i, 0.0f, (float) i, 256.0f, b);
                canvas.drawLine(0.0f, (float) i, 256.0f, (float) i, b);
            }
        }
    }

    /* compiled from: BaseMapTile */
    /* renamed from: com.amap.api.a.m$a */
    static class C0252a implements Cloneable {
        /* renamed from: a */
        public int f1045a = 0;
        /* renamed from: b */
        public final int f1046b;
        /* renamed from: c */
        public final int f1047c;
        /* renamed from: d */
        public final int f1048d;
        /* renamed from: e */
        public final int f1049e;
        /* renamed from: f */
        public PointF f1050f;
        /* renamed from: g */
        public int f1051g = -1;

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            return m1645a();
        }

        public C0252a(int i, int i2, int i3, int i4) {
            this.f1046b = i;
            this.f1047c = i2;
            this.f1048d = i3;
            this.f1049e = i4;
        }

        public C0252a(C0252a c0252a) {
            this.f1046b = c0252a.f1046b;
            this.f1047c = c0252a.f1047c;
            this.f1048d = c0252a.f1048d;
            this.f1049e = c0252a.f1049e;
            this.f1050f = c0252a.f1050f;
            this.f1045a = c0252a.f1045a;
        }

        /* renamed from: a */
        public C0252a m1645a() {
            return new C0252a(this);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0252a)) {
                return false;
            }
            C0252a c0252a = (C0252a) obj;
            if (this.f1046b == c0252a.f1046b && this.f1047c == c0252a.f1047c && this.f1048d == c0252a.f1048d && this.f1049e == c0252a.f1049e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f1046b * 7) + (this.f1047c * 11)) + (this.f1048d * 13)) + this.f1049e;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f1046b);
            stringBuilder.append("-");
            stringBuilder.append(this.f1047c);
            stringBuilder.append("-");
            stringBuilder.append(this.f1048d);
            stringBuilder.append("-");
            stringBuilder.append(this.f1049e);
            return stringBuilder.toString();
        }
    }

    C0253m() {
    }

    /* renamed from: a */
    public static int m1646a() {
        return f1054c;
    }

    /* renamed from: b */
    public static synchronized Paint m1647b() {
        Paint paint;
        synchronized (C0253m.class) {
            if (f1052a == null) {
                f1052a = new Paint();
                f1052a.setColor(Component.f3912);
                f1052a.setAlpha(90);
                f1052a.setPathEffect(new DashPathEffect(new float[]{2.0f, 2.5f}, 1.0f));
            }
            paint = f1052a;
        }
        return paint;
    }

    /* renamed from: c */
    public static synchronized Bitmap m1648c() {
        Bitmap bitmap;
        synchronized (C0253m.class) {
            if (f1053b == null) {
                C0250o c02511 = new C02511();
                C0254n c0254n = new C0254n(Config.ARGB_4444);
                c0254n.m1650a(256, 256);
                c0254n.m1652a(c02511);
                f1053b = c0254n.m1653b();
            }
            bitmap = f1053b;
        }
        return bitmap;
    }
}
