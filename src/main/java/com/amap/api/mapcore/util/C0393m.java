package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amap.api.mapcore.be.C0322a;
import com.amap.api.mapcore.util.C0392j.C0391a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.lang.ref.WeakReference;

/* compiled from: ImageWorker */
/* renamed from: com.amap.api.mapcore.util.m */
public abstract class C0393m {
    /* renamed from: a */
    private C0392j f2164a;
    /* renamed from: b */
    private C0391a f2165b;
    /* renamed from: c */
    protected boolean f2166c = false;
    /* renamed from: d */
    protected Resources f2167d;
    /* renamed from: e */
    private boolean f2168e = false;
    /* renamed from: f */
    private final Object f2169f = new Object();

    /* compiled from: ImageWorker */
    /* renamed from: com.amap.api.mapcore.util.m$a */
    public class C0396a extends C0323f<Boolean, Void, Bitmap> {
        /* renamed from: a */
        final /* synthetic */ C0393m f2173a;
        /* renamed from: e */
        private final WeakReference<C0322a> f2174e;

        public C0396a(C0393m c0393m, C0322a c0322a) {
            this.f2173a = c0393m;
            this.f2174e = new WeakReference(c0322a);
        }

        /* renamed from: a */
        protected Bitmap m3409a(Boolean... boolArr) {
            Bitmap bitmap = null;
            C0399o.m3422a("ImageWorker", "doInBackground - starting work", ErrorCode.NETWORK_NOT_WIFI_ERROR);
            boolean booleanValue = boolArr[0].booleanValue();
            Object obj = (C0322a) this.f2174e.get();
            if (obj == null) {
                return null;
            }
            Bitmap bitmap2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj.f1664a);
            stringBuilder.append("-");
            stringBuilder.append(obj.f1665b);
            stringBuilder.append("-");
            stringBuilder.append(obj.f1666c);
            String stringBuilder2 = stringBuilder.toString();
            synchronized (this.f2173a.f2169f) {
                while (this.f2173a.f2166c && !m2747d()) {
                    try {
                        this.f2173a.f2169f.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (!(this.f2173a.f2164a == null || m2747d() || m3408e() == null || this.f2173a.f2168e)) {
                bitmap = this.f2173a.f2164a.m3374b(stringBuilder2);
            }
            if (!booleanValue || bitmap != null || m2747d() || m3408e() == null || this.f2173a.f2168e) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = this.f2173a.mo613a(obj);
            }
            if (!(bitmap2 == null || this.f2173a.f2164a == null)) {
                this.f2173a.f2164a.m3373a(stringBuilder2, bitmap2);
            }
            C0399o.m3422a("ImageWorker", "doInBackground - finished work", ErrorCode.NETWORK_NOT_WIFI_ERROR);
            return bitmap2;
        }

        /* renamed from: a */
        protected void m3411a(Bitmap bitmap) {
            if (m2747d() || this.f2173a.f2168e) {
                bitmap = null;
            }
            C0322a e = m3408e();
            if (bitmap != null && !bitmap.isRecycled() && e != null) {
                C0399o.m3422a("ImageWorker", "onPostExecute - setting bitmap: " + e.toString(), ErrorCode.NETWORK_NOT_WIFI_ERROR);
                e.m2727a(bitmap);
            }
        }

        /* renamed from: b */
        protected void m3413b(Bitmap bitmap) {
            super.mo614b((Object) bitmap);
            synchronized (this.f2173a.f2169f) {
                this.f2173a.f2169f.notifyAll();
            }
        }

        /* renamed from: e */
        private C0322a m3408e() {
            C0322a c0322a = (C0322a) this.f2174e.get();
            return this == C0393m.m3382c(c0322a) ? c0322a : null;
        }
    }

    /* compiled from: ImageWorker */
    /* renamed from: com.amap.api.mapcore.util.m$b */
    protected class C0397b extends C0323f<Object, Void, Void> {
        /* renamed from: a */
        final /* synthetic */ C0393m f2175a;

        protected C0397b(C0393m c0393m) {
            this.f2175a = c0393m;
        }

        /* renamed from: a */
        protected /* synthetic */ Object mo519a(Object[] objArr) {
            return m3416d(objArr);
        }

        /* renamed from: d */
        protected Void m3416d(Object... objArr) {
            switch (((Integer) objArr[0]).intValue()) {
                case 0:
                    this.f2175a.m3391c();
                    break;
                case 1:
                    this.f2175a.m3389b();
                    break;
                case 2:
                    this.f2175a.m3392d();
                    break;
                case 3:
                    this.f2175a.m3393e();
                    break;
            }
            return null;
        }
    }

    /* renamed from: a */
    protected abstract Bitmap mo613a(Object obj);

    protected C0393m(Context context) {
        this.f2167d = context.getResources();
    }

    /* renamed from: a */
    public void m3388a(boolean z, C0322a c0322a) {
        if (c0322a != null) {
            Bitmap bitmap = null;
            if (this.f2164a != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c0322a.f1664a);
                stringBuilder.append("-");
                stringBuilder.append(c0322a.f1665b);
                stringBuilder.append("-");
                stringBuilder.append(c0322a.f1666c);
                bitmap = this.f2164a.m3371a(stringBuilder.toString());
            }
            if (bitmap != null) {
                c0322a.m2727a(bitmap);
                return;
            }
            C0396a c0396a = new C0396a(this, c0322a);
            c0322a.f1673j = c0396a;
            c0396a.m2738a(C0323f.f1679d, (Object[]) new Boolean[]{Boolean.valueOf(z)});
        }
    }

    /* renamed from: a */
    public void m3386a(C0391a c0391a) {
        this.f2165b = c0391a;
        this.f2164a = C0392j.m3361a(this.f2165b);
        new C0397b(this).m2745c(Integer.valueOf(1));
    }

    /* renamed from: a */
    public void m3387a(boolean z) {
        this.f2168e = z;
        m3390b(false);
    }

    /* renamed from: a */
    protected C0392j m3385a() {
        return this.f2164a;
    }

    /* renamed from: a */
    public static void m3379a(C0322a c0322a) {
        C0396a c = C0393m.m3382c(c0322a);
        if (c != null) {
            c.m2741a(true);
            C0399o.m3422a("ImageWorker", "cancelWork - cancelled work for " + c0322a, ErrorCode.NETWORK_NOT_WIFI_ERROR);
        }
    }

    /* renamed from: c */
    private static C0396a m3382c(C0322a c0322a) {
        if (c0322a != null) {
            return c0322a.f1673j;
        }
        return null;
    }

    /* renamed from: b */
    public void m3390b(boolean z) {
        synchronized (this.f2169f) {
            this.f2166c = z;
            if (!this.f2166c) {
                this.f2169f.notifyAll();
            }
        }
    }

    /* renamed from: b */
    protected void m3389b() {
        if (this.f2164a != null) {
            this.f2164a.m3372a();
        }
    }

    /* renamed from: c */
    protected void m3391c() {
        if (this.f2164a != null) {
            this.f2164a.m3375b();
        }
    }

    /* renamed from: d */
    protected void m3392d() {
        if (this.f2164a != null) {
            this.f2164a.m3376c();
        }
    }

    /* renamed from: e */
    protected void m3393e() {
        if (this.f2164a != null) {
            this.f2164a.m3377d();
            this.f2164a = null;
        }
    }

    /* renamed from: f */
    public void m3394f() {
        new C0397b(this).m2745c(Integer.valueOf(0));
    }

    /* renamed from: g */
    public void m3395g() {
        new C0397b(this).m2745c(Integer.valueOf(2));
    }

    /* renamed from: h */
    public void m3396h() {
        new C0397b(this).m2745c(Integer.valueOf(3));
    }
}
