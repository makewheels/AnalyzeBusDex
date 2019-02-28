package com.amap.api.p015a;

import android.graphics.Canvas;
import android.os.RemoteException;
import android.util.Log;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: GLOverlayLayer */
/* renamed from: com.amap.api.a.ab */
class ab {
    /* renamed from: b */
    private static int f607b = 0;
    /* renamed from: a */
    C0206a f608a = new C0206a(this);
    /* renamed from: c */
    private CopyOnWriteArrayList<ak> f609c = new CopyOnWriteArrayList();

    /* compiled from: GLOverlayLayer */
    /* renamed from: com.amap.api.a.ab$a */
    class C0206a implements Comparator<Object> {
        /* renamed from: a */
        final /* synthetic */ ab f606a;

        C0206a(ab abVar) {
            this.f606a = abVar;
        }

        public int compare(Object obj, Object obj2) {
            ak akVar = (ak) obj;
            ak akVar2 = (ak) obj2;
            if (!(akVar == null || akVar2 == null)) {
                try {
                    if (akVar.mo49d() > akVar2.mo49d()) {
                        return 1;
                    }
                    if (akVar.mo49d() < akVar2.mo49d()) {
                        return -1;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
    }

    ab() {
    }

    /* renamed from: a */
    static String m813a(String str) {
        f607b++;
        return str + f607b;
    }

    /* renamed from: a */
    public void m816a() {
        Iterator it = this.f609c.iterator();
        while (it.hasNext()) {
            ((ak) it.next()).mo58m();
        }
        try {
            it = this.f609c.iterator();
            while (it.hasNext()) {
                ((ak) it.next()).mo58m();
            }
            this.f609c.clear();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("amapApi", "GLOverlayLayer clear erro" + e.getMessage());
        }
    }

    /* renamed from: b */
    public void m819b() {
        try {
            Iterator it = this.f609c.iterator();
            while (it.hasNext()) {
                ((ak) it.next()).mo58m();
            }
            m816a();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("amapApi", "GLOverlayLayer destory erro" + e.getMessage());
        }
    }

    /* renamed from: c */
    private ak m814c(String str) throws RemoteException {
        Iterator it = this.f609c.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            if (akVar != null && akVar.mo47c().equals(str)) {
                return akVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m818a(ak akVar) throws RemoteException {
        m820b(akVar.mo47c());
        this.f609c.add(akVar);
        m815c();
    }

    /* renamed from: b */
    public boolean m820b(String str) throws RemoteException {
        ak c = m814c(str);
        if (c != null) {
            return this.f609c.remove(c);
        }
        return false;
    }

    /* renamed from: c */
    private void m815c() {
        Object[] toArray = this.f609c.toArray();
        Arrays.sort(toArray, this.f608a);
        this.f609c.clear();
        for (Object obj : toArray) {
            this.f609c.add((ak) obj);
        }
    }

    /* renamed from: a */
    public void m817a(Canvas canvas) {
        int size = this.f609c.size();
        Iterator it = this.f609c.iterator();
        while (it.hasNext()) {
            ak akVar = (ak) it.next();
            try {
                if (akVar.mo51e()) {
                    if (size <= 20) {
                        akVar.mo38a(canvas);
                    } else if (akVar.mo43a()) {
                        akVar.mo38a(canvas);
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
