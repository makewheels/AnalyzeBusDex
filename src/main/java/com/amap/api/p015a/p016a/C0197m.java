package com.amap.api.p015a.p016a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.amap.api.p015a.bu.C0233a;
import com.amap.api.p015a.p016a.C0196j.C0195a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.lang.ref.WeakReference;

/* compiled from: ImageWorker */
/* renamed from: com.amap.api.a.a.m */
public abstract class C0197m {
    /* renamed from: a */
    private C0196j f586a;
    /* renamed from: b */
    private C0195a f587b;
    /* renamed from: c */
    protected boolean f588c = false;
    /* renamed from: d */
    protected Resources f589d;
    /* renamed from: e */
    private boolean f590e = false;
    /* renamed from: f */
    private final Object f591f = new Object();

    /* compiled from: ImageWorker */
    /* renamed from: com.amap.api.a.a.m$a */
    public class C0200a extends C0181b<Boolean, Void, Bitmap> {
        /* renamed from: a */
        final /* synthetic */ C0197m f595a;
        /* renamed from: e */
        private final WeakReference<C0233a> f596e;

        public C0200a(C0197m c0197m, C0233a c0233a) {
            this.f595a = c0197m;
            this.f596e = new WeakReference(c0233a);
        }

        /* renamed from: a */
        protected Bitmap m780a(Boolean... boolArr) {
            Bitmap bitmap = null;
            C0202n.m788a("ImageWorker", "doInBackground - starting work", ErrorCode.NETWORK_NOT_WIFI_ERROR);
            boolean booleanValue = boolArr[0].booleanValue();
            Object obj = (C0233a) this.f596e.get();
            if (obj == null) {
                return null;
            }
            Bitmap bitmap2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj.f924a);
            stringBuilder.append("-");
            stringBuilder.append(obj.f925b);
            stringBuilder.append("-");
            stringBuilder.append(obj.f926c);
            String stringBuilder2 = stringBuilder.toString();
            synchronized (this.f595a.f591f) {
                while (this.f595a.f588c && !m644d()) {
                    try {
                        this.f595a.f591f.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (!(this.f595a.f586a == null || m644d() || m779e() == null || this.f595a.f590e)) {
                bitmap = this.f595a.f586a.m748b(stringBuilder2);
            }
            if (!booleanValue || bitmap != null || m644d() || m779e() == null || this.f595a.f590e) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = this.f595a.mo32a(obj);
            }
            if (!(bitmap2 == null || this.f595a.f586a == null)) {
                this.f595a.f586a.m747a(stringBuilder2, bitmap2);
            }
            C0202n.m788a("ImageWorker", "doInBackground - finished work", ErrorCode.NETWORK_NOT_WIFI_ERROR);
            return bitmap2;
        }

        /* renamed from: a */
        protected void m782a(Bitmap bitmap) {
            if (m644d() || this.f595a.f590e) {
                bitmap = null;
            }
            C0233a e = m779e();
            if (bitmap != null && !bitmap.isRecycled() && e != null) {
                C0202n.m788a("ImageWorker", "onPostExecute - setting bitmap: " + e.toString(), ErrorCode.NETWORK_NOT_WIFI_ERROR);
                e.m1512a(bitmap);
            }
        }

        /* renamed from: b */
        protected void m784b(Bitmap bitmap) {
            super.mo35b((Object) bitmap);
            synchronized (this.f595a.f591f) {
                this.f595a.f591f.notifyAll();
            }
        }

        /* renamed from: e */
        private C0233a m779e() {
            C0233a c0233a = (C0233a) this.f596e.get();
            return this == C0197m.m756c(c0233a) ? c0233a : null;
        }
    }

    /* compiled from: ImageWorker */
    /* renamed from: com.amap.api.a.a.m$b */
    protected class C0201b extends C0181b<Object, Void, Void> {
        /* renamed from: a */
        final /* synthetic */ C0197m f597a;

        protected C0201b(C0197m c0197m) {
            this.f597a = c0197m;
        }

        /* renamed from: a */
        protected /* synthetic */ Object mo33a(Object[] objArr) {
            return m787d(objArr);
        }

        /* renamed from: d */
        protected Void m787d(Object... objArr) {
            switch (((Integer) objArr[0]).intValue()) {
                case 0:
                    this.f597a.m763c();
                    break;
                case 1:
                    this.f597a.m762b();
                    break;
                case 2:
                    this.f597a.m764d();
                    break;
                case 3:
                    this.f597a.m765e();
                    break;
            }
            return null;
        }
    }

    /* renamed from: a */
    protected abstract Bitmap mo32a(Object obj);

    protected C0197m(Context context) {
        this.f589d = context.getResources();
    }

    /* renamed from: a */
    public void m761a(boolean z, C0233a c0233a) {
        if (c0233a != null) {
            Bitmap bitmap = null;
            if (this.f586a != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c0233a.f924a);
                stringBuilder.append("-");
                stringBuilder.append(c0233a.f925b);
                stringBuilder.append("-");
                stringBuilder.append(c0233a.f926c);
                bitmap = this.f586a.m745a(stringBuilder.toString());
            }
            if (bitmap != null) {
                c0233a.m1512a(bitmap);
                return;
            }
            C0200a c0200a = new C0200a(this, c0233a);
            c0233a.f930g = c0200a;
            c0200a.m635a(C0181b.f512d, (Object[]) new Boolean[]{Boolean.valueOf(z)});
        }
    }

    /* renamed from: a */
    public void m760a(C0195a c0195a) {
        this.f587b = c0195a;
        this.f586a = C0196j.m736a(this.f587b);
        new C0201b(this).m642c(Integer.valueOf(1));
    }

    /* renamed from: a */
    protected C0196j m759a() {
        return this.f586a;
    }

    /* renamed from: a */
    public static void m753a(C0233a c0233a) {
        C0200a c = C0197m.m756c(c0233a);
        if (c != null) {
            c.m638a(true);
            C0202n.m788a("ImageWorker", "cancelWork - cancelled work for " + c0233a, ErrorCode.NETWORK_NOT_WIFI_ERROR);
        }
    }

    /* renamed from: c */
    private static C0200a m756c(C0233a c0233a) {
        if (c0233a != null) {
            return c0233a.f930g;
        }
        return null;
    }

    /* renamed from: b */
    protected void m762b() {
        if (this.f586a != null) {
            this.f586a.m746a();
        }
    }

    /* renamed from: c */
    protected void m763c() {
        if (this.f586a != null) {
            this.f586a.m749b();
        }
    }

    /* renamed from: d */
    protected void m764d() {
        if (this.f586a != null) {
            this.f586a.m750c();
        }
    }

    /* renamed from: e */
    protected void m765e() {
        if (this.f586a != null) {
            this.f586a.m751d();
            this.f586a = null;
        }
    }

    /* renamed from: f */
    public void m766f() {
        new C0201b(this).m642c(Integer.valueOf(0));
    }

    /* renamed from: g */
    public void m767g() {
        new C0201b(this).m642c(Integer.valueOf(3));
    }
}
