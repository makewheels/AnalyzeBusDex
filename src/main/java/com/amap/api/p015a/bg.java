package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.FloatMath;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: MultiTouchGestureDetector */
/* renamed from: com.amap.api.a.bg */
abstract class bg {
    /* renamed from: b */
    static C0222b f844b;
    /* renamed from: k */
    static float f845k = 1.0f;
    /* renamed from: q */
    private static Method f846q;
    /* renamed from: r */
    private static Method f847r;
    /* renamed from: s */
    private static boolean f848s = false;
    /* renamed from: t */
    private static boolean f849t = false;
    /* renamed from: a */
    C0218b f850a;
    /* renamed from: c */
    int f851c = 0;
    /* renamed from: d */
    Matrix f852d = new Matrix();
    /* renamed from: e */
    Matrix f853e = new Matrix();
    /* renamed from: f */
    PointF f854f = new PointF();
    /* renamed from: g */
    PointF f855g = new PointF();
    /* renamed from: h */
    PointF f856h = new PointF();
    /* renamed from: i */
    float f857i = 1.0f;
    /* renamed from: j */
    float f858j = 1.0f;
    /* renamed from: l */
    boolean f859l = false;
    /* renamed from: m */
    boolean f860m = false;
    /* renamed from: n */
    boolean f861n = false;
    /* renamed from: o */
    public int f862o = 0;
    /* renamed from: p */
    public long f863p = 0;

    /* compiled from: MultiTouchGestureDetector */
    /* renamed from: com.amap.api.a.bg$b */
    public interface C0218b {
        /* renamed from: a */
        boolean mo108a(float f, float f2);

        /* renamed from: a */
        boolean mo109a(float f, PointF pointF);

        /* renamed from: a */
        boolean mo110a(Matrix matrix);

        /* renamed from: a */
        boolean mo111a(PointF pointF);

        /* renamed from: b */
        boolean mo119b(Matrix matrix);

        /* renamed from: c */
        boolean mo124c(float f);
    }

    /* compiled from: MultiTouchGestureDetector */
    /* renamed from: com.amap.api.a.bg$a */
    private static class C0232a extends bg {
        /* renamed from: q */
        float f864q;
        /* renamed from: r */
        float f865r;
        /* renamed from: s */
        float f866s;
        /* renamed from: t */
        float f867t;
        /* renamed from: u */
        long f868u;

        private C0232a() {
            this.f868u = 0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public boolean mo184a(android.view.MotionEvent r9) {
            /*
            r8 = this;
            r5 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
            r4 = 2;
            r2 = 0;
            r0 = 1;
            com.amap.api.p015a.bg.m1413c(r9);
            r1 = com.amap.api.p015a.bg.f848s;
            if (r1 != 0) goto L_0x000f;
        L_0x000e:
            return r2;
        L_0x000f:
            r1 = r9.getAction();
            r1 = r1 & 255;
            switch(r1) {
                case 0: goto L_0x001b;
                case 1: goto L_0x008d;
                case 2: goto L_0x00c7;
                case 3: goto L_0x0018;
                case 4: goto L_0x0018;
                case 5: goto L_0x0041;
                case 6: goto L_0x0099;
                default: goto L_0x0018;
            };
        L_0x0018:
            r0 = r2;
        L_0x0019:
            r2 = r0;
            goto L_0x000e;
        L_0x001b:
            r3 = r9.getEventTime();
            r8.f868u = r3;
            r1 = r9.getX();
            r8.f864q = r1;
            r1 = r9.getY();
            r8.f865r = r1;
            r1 = r8.e;
            r3 = r8.d;
            r1.set(r3);
            r1 = r8.f;
            r3 = r8.f864q;
            r4 = r8.f865r;
            r1.set(r3, r4);
            r8.c = r0;
            r0 = r2;
            goto L_0x0019;
        L_0x0041:
            r1 = r8.o;
            r1 = r1 + 1;
            r8.o = r1;
            r1 = r8.o;
            if (r1 != r0) goto L_0x0018;
        L_0x004b:
            r8.n = r0;
            r1 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            k = r1;
            r1 = r8.m1416c(r9);
            r8.i = r1;
            r1 = r8.i;
            r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1));
            if (r1 <= 0) goto L_0x0018;
        L_0x005d:
            r1 = r8.d;
            r1.reset();
            r1 = r8.e;
            r1.reset();
            r1 = r8.e;
            r3 = r8.d;
            r1.set(r3);
            r1 = r8.g;
            r8.m1415a(r1, r9);
            r8.c = r4;
            r8.l = r0;
            r0 = r8.a;
            r1 = r8.f;
            r0 = r0.mo111a(r1);
            r0 = r0 | r2;
            r1 = r8.g;
            r1 = r1.x;
            r8.f866s = r1;
            r1 = r8.g;
            r1 = r1.y;
            r8.f867t = r1;
            goto L_0x0019;
        L_0x008d:
            r0 = r9.getEventTime();
            r8.p = r0;
            r8.l = r2;
            r8.c = r2;
            r0 = r2;
            goto L_0x0019;
        L_0x0099:
            r1 = r8.o;
            r1 = r1 + -1;
            r8.o = r1;
            r1 = r8.o;
            if (r1 != r0) goto L_0x00a7;
        L_0x00a3:
            r8.n = r0;
            r8.c = r4;
        L_0x00a7:
            r0 = r8.o;
            if (r0 != 0) goto L_0x0018;
        L_0x00ab:
            r0 = r8.g;
            r8.m1415a(r0, r9);
            r8.m = r2;
            r8.n = r2;
            r0 = r8.l;
            if (r0 == 0) goto L_0x0018;
        L_0x00b8:
            r0 = r8.a;
            r1 = r8.j;
            r3 = r8.g;
            r0 = r0.mo109a(r1, r3);
            r0 = r0 | r2;
            r8.c = r2;
            goto L_0x0019;
        L_0x00c7:
            r1 = r8.c;
            if (r1 != r0) goto L_0x011d;
        L_0x00cb:
            r1 = r9.getX();
            r3 = r9.getY();
            r4 = r8.d;
            r5 = r8.e;
            r4.set(r5);
            r4 = r8.d;
            r5 = r9.getX();
            r6 = r8.f;
            r6 = r6.x;
            r5 = r5 - r6;
            r6 = r9.getY();
            r7 = r8.f;
            r7 = r7.y;
            r6 = r6 - r7;
            r4.postTranslate(r5, r6);
            r4 = r8.a;
            r5 = r8.f864q;
            r5 = r1 - r5;
            r6 = r8.f865r;
            r6 = r3 - r6;
            r4 = r4.mo108a(r5, r6);
            r2 = r2 | r4;
            r8.f864q = r1;
            r8.f865r = r3;
            r1 = r8.a;
            r3 = r8.d;
            r1 = r1.mo110a(r3);
            r1 = r1 | r2;
            r2 = r9.getEventTime();
            r4 = r8.f868u;
            r2 = r2 - r4;
            r4 = 30;
            r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r2 < 0) goto L_0x0019;
        L_0x011a:
            r0 = r1;
            goto L_0x0019;
        L_0x011d:
            r1 = r8.c;
            if (r1 != r4) goto L_0x0018;
        L_0x0121:
            r1 = b;	 Catch:{ RemoteException -> 0x01bf }
            r1 = r1.mo142q();	 Catch:{ RemoteException -> 0x01bf }
            r1 = r1.mo251f();	 Catch:{ RemoteException -> 0x01bf }
            if (r1 == 0) goto L_0x000e;
        L_0x012d:
            r1 = b;
            r1.m1183K();
            r3 = r8.m1416c(r9);
            r1 = 0;
            r8.j = r1;
            r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r1 <= 0) goto L_0x0018;
        L_0x013d:
            r1 = r8.i;
            r1 = r3 - r1;
            r1 = java.lang.Math.abs(r1);
            r4 = 1084227584; // 0x40a00000 float:5.0 double:5.356796015E-315;
            r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));
            if (r1 <= 0) goto L_0x0018;
        L_0x014b:
            r1 = r8.d;
            r4 = r8.e;
            r1.set(r4);
            r1 = r8.i;
            r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
            if (r1 <= 0) goto L_0x01c5;
        L_0x0158:
            r1 = r8.i;
            r1 = r3 / r1;
        L_0x015c:
            r8.j = r1;
            r1 = r8.i;
            r1 = r3 / r1;
            k = r1;
            r1 = r8.i;
            r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
            if (r1 >= 0) goto L_0x016f;
        L_0x016a:
            r1 = r8.j;
            r1 = -r1;
            r8.j = r1;
        L_0x016f:
            r1 = r8.h;
            r8.m1415a(r1, r9);
            r1 = r8.a;
            r4 = r8.h;
            r4 = r4.x;
            r5 = r8.f866s;
            r4 = r4 - r5;
            r5 = r8.h;
            r5 = r5.y;
            r6 = r8.f867t;
            r5 = r5 - r6;
            r1 = r1.mo108a(r4, r5);
            r1 = r1 | r2;
            r2 = r8.h;
            r2 = r2.x;
            r8.f866s = r2;
            r2 = r8.h;
            r2 = r2.y;
            r8.f867t = r2;
            r2 = r8.d;
            r4 = r8.i;
            r4 = r3 / r4;
            r5 = r8.i;
            r3 = r3 / r5;
            r5 = r8.g;
            r5 = r5.x;
            r6 = r8.g;
            r6 = r6.y;
            r2.postScale(r4, r3, r5, r6);
            r2 = r8.a;
            r3 = r8.j;
            r2 = r2.mo124c(r3);
            r1 = r1 | r2;
            r2 = r8.a;
            r3 = r8.d;
            r2 = r2.mo119b(r3);
            r1 = r1 | r2;
            r8.m = r0;
            goto L_0x011a;
        L_0x01bf:
            r1 = move-exception;
            r1.printStackTrace();
            goto L_0x012d;
        L_0x01c5:
            r1 = r8.i;
            r1 = r1 / r3;
            goto L_0x015c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.a.bg.a.a(android.view.MotionEvent):boolean");
        }

        /* renamed from: c */
        private float m1416c(MotionEvent motionEvent) {
            float floatValue;
            float f = 0.0f;
            try {
                floatValue = ((Float) bg.f846q.invoke(motionEvent, new Object[]{Integer.valueOf(0)})).floatValue() - ((Float) bg.f846q.invoke(motionEvent, new Object[]{Integer.valueOf(1)})).floatValue();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                floatValue = 0.0f;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                floatValue = 0.0f;
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
                floatValue = 0.0f;
            }
            try {
                f = ((Float) bg.f847r.invoke(motionEvent, new Object[]{Integer.valueOf(0)})).floatValue() - ((Float) bg.f847r.invoke(motionEvent, new Object[]{Integer.valueOf(1)})).floatValue();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (IllegalAccessException e22) {
                e22.printStackTrace();
            } catch (InvocationTargetException e32) {
                e32.printStackTrace();
            }
            return FloatMath.sqrt((floatValue * floatValue) + (f * f));
        }

        /* renamed from: a */
        private void m1415a(PointF pointF, MotionEvent motionEvent) {
            try {
                float floatValue = ((Float) bg.f846q.invoke(motionEvent, new Object[]{Integer.valueOf(1)})).floatValue() + ((Float) bg.f846q.invoke(motionEvent, new Object[]{Integer.valueOf(0)})).floatValue();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
            try {
                floatValue = ((Float) bg.f847r.invoke(motionEvent, new Object[]{Integer.valueOf(1)})).floatValue() + ((Float) bg.f847r.invoke(motionEvent, new Object[]{Integer.valueOf(0)})).floatValue();
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (IllegalAccessException e22) {
                e22.printStackTrace();
            } catch (InvocationTargetException e32) {
                e32.printStackTrace();
            }
            pointF.set(((float) b.getWidth()) / 2.0f, ((float) b.getHeight()) / 2.0f);
        }
    }

    /* renamed from: a */
    public abstract boolean mo184a(MotionEvent motionEvent);

    bg() {
    }

    /* renamed from: a */
    public static bg m1408a(Context context, C0218b c0218b, C0222b c0222b) {
        bg c0232a = new C0232a();
        c0232a.f850a = c0218b;
        f844b = c0222b;
        return c0232a;
    }

    /* renamed from: c */
    private static void m1413c(MotionEvent motionEvent) {
        if (!f849t) {
            f849t = true;
            try {
                f846q = motionEvent.getClass().getMethod("getX", new Class[]{Integer.TYPE});
                f847r = motionEvent.getClass().getMethod("getY", new Class[]{Integer.TYPE});
                if (f846q != null && f847r != null) {
                    f848s = true;
                }
            } catch (Exception e) {
            }
        }
    }
}
