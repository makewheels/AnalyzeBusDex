package com.amap.api.mapcore;

import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.az;
import com.autonavi.amap.mapcore.VTMCDataCache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLOverlayLayer */
/* renamed from: com.amap.api.mapcore.r */
class C0350r {
    /* renamed from: b */
    private static int f1886b = 0;
    /* renamed from: a */
    C0349a f1887a = new C0349a();
    /* renamed from: c */
    private CopyOnWriteArrayList<ab> f1888c = new CopyOnWriteArrayList(new ArrayList(VTMCDataCache.MAXSIZE));
    /* renamed from: d */
    private Handler f1889d = new Handler();
    /* renamed from: e */
    private Runnable f1890e = new C0351s(this);

    /* compiled from: GLOverlayLayer */
    /* renamed from: com.amap.api.mapcore.r$a */
    static class C0349a implements Comparator<Object>, Serializable {
        C0349a() {
        }

        public int compare(Object obj, Object obj2) {
            ab abVar = (ab) obj;
            ab abVar2 = (ab) obj2;
            if (!(abVar == null || abVar2 == null)) {
                try {
                    if (abVar.mo469d() > abVar2.mo469d()) {
                        return 1;
                    }
                    if (abVar.mo469d() < abVar2.mo469d()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    az.m3143a(th, "GLOverlayLayer", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    C0350r() {
    }

    /* renamed from: a */
    static String m2938a(String str) {
        f1886b++;
        return str + f1886b;
    }

    /* renamed from: a */
    public synchronized void m2942a() {
        try {
            this.f1888c.clear();
            f1886b = 0;
        } catch (Throwable th) {
            az.m3143a(th, "GLOverlayLayer", "clear");
            th.printStackTrace();
            Log.d("amapApi", "GLOverlayLayer clear erro" + th.getMessage());
        }
    }

    /* renamed from: b */
    public synchronized void m2945b() {
        try {
            Iterator it = this.f1888c.iterator();
            while (it.hasNext()) {
                ((ab) it.next()).mo475j();
            }
            m2942a();
        } catch (Throwable th) {
            az.m3143a(th, "GLOverlayLayer", "destory");
            th.printStackTrace();
            Log.d("amapApi", "GLOverlayLayer destory erro" + th.getMessage());
        }
        return;
    }

    /* renamed from: c */
    private synchronized ab m2941c(String str) throws RemoteException {
        ab abVar;
        Iterator it = this.f1888c.iterator();
        while (it.hasNext()) {
            abVar = (ab) it.next();
            if (abVar != null && abVar.mo468c().equals(str)) {
                break;
            }
        }
        abVar = null;
        return abVar;
    }

    /* renamed from: a */
    public synchronized void m2943a(ab abVar) throws RemoteException {
        this.f1888c.add(abVar);
        m2947c();
    }

    /* renamed from: b */
    public synchronized boolean m2946b(String str) throws RemoteException {
        boolean remove;
        ab c = m2941c(str);
        if (c != null) {
            remove = this.f1888c.remove(c);
        } else {
            remove = false;
        }
        return remove;
    }

    /* renamed from: c */
    protected synchronized void m2947c() {
        this.f1889d.removeCallbacks(this.f1890e);
        this.f1889d.postDelayed(this.f1890e, 10);
    }

    /* renamed from: a */
    public void m2944a(GL10 gl10, boolean z, int i) {
        int size = this.f1888c.size();
        Iterator it = this.f1888c.iterator();
        while (it.hasNext()) {
            ab abVar = (ab) it.next();
            try {
                if (abVar.mo470e()) {
                    if (size > 20) {
                        if (abVar.mo463a()) {
                            if (z) {
                                if (abVar.mo469d() <= ((float) i)) {
                                    abVar.mo461a(gl10);
                                }
                            } else if (abVar.mo469d() > ((float) i)) {
                                abVar.mo461a(gl10);
                            }
                        }
                    } else if (z) {
                        if (abVar.mo469d() <= ((float) i)) {
                            abVar.mo461a(gl10);
                        }
                    } else if (abVar.mo469d() > ((float) i)) {
                        abVar.mo461a(gl10);
                    }
                }
            } catch (Throwable e) {
                az.m3143a(e, "GLOverlayLayer", "draw");
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public synchronized void m2948d() {
        Iterator it = this.f1888c.iterator();
        while (it.hasNext()) {
            ab abVar = (ab) it.next();
            if (abVar != null) {
                try {
                    abVar.mo472g();
                } catch (Throwable e) {
                    az.m3143a(e, "GLOverlayLayer", "calMapFPoint");
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: e */
    public boolean m2949e() {
        Iterator it = this.f1888c.iterator();
        while (it.hasNext()) {
            ab abVar = (ab) it.next();
            if (abVar != null && !abVar.mo476k()) {
                return false;
            }
        }
        return true;
    }
}
