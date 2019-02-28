package com.amap.api.p015a;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.Message;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.autonavi.amap.mapcore.VTMCDataCache;
import java.util.LinkedList;

/* compiled from: MapController */
/* renamed from: com.amap.api.a.av */
public final class av implements OnKeyListener {
    /* renamed from: a */
    private int f667a = 0;
    /* renamed from: b */
    private int f668b = 0;
    /* renamed from: c */
    private bf f669c;
    /* renamed from: d */
    private boolean f670d;
    /* renamed from: e */
    private C0211b f671e;
    /* renamed from: f */
    private C0210a f672f;

    /* compiled from: MapController */
    /* renamed from: com.amap.api.a.av$a */
    class C0210a implements ca {
        /* renamed from: a */
        final /* synthetic */ av f659a;
        /* renamed from: b */
        private bz f660b = null;
        /* renamed from: c */
        private Message f661c = null;
        /* renamed from: d */
        private Runnable f662d = null;

        C0210a(av avVar) {
            this.f659a = avVar;
        }

        /* renamed from: a */
        public void m1069a(ac acVar, Message message, Runnable runnable, int i) {
            this.f659a.f669c.f838c.f821a = true;
            this.f659a.f669c.f843h.f762k = acVar.m829g();
            m1067a();
            this.f660b = m1065a(acVar, i);
            this.f661c = message;
            this.f662d = runnable;
            this.f660b.m1583c();
        }

        /* renamed from: a */
        private bz m1065a(ac acVar, int i) {
            int i2 = VTMCDataCache.MAXSIZE;
            if (i >= VTMCDataCache.MAXSIZE) {
                i2 = i;
            }
            return new bz(i2, 10, this.f659a.f669c.f843h.f761j, acVar, i, this);
        }

        /* renamed from: c */
        private void m1066c() {
            this.f660b = null;
            this.f661c = null;
            this.f662d = null;
        }

        /* renamed from: a */
        public void m1067a() {
            if (this.f660b != null) {
                this.f660b.m1584d();
            }
        }

        /* renamed from: a */
        public void mo60a(ac acVar) {
            if (acVar != null) {
                if (acVar.m826d() == Long.MIN_VALUE || acVar.m825c() == Long.MIN_VALUE) {
                    this.f659a.m1083a(this.f659a.f669c.f843h.m1295b(acVar));
                    return;
                }
                this.f659a.m1083a(acVar);
            }
        }

        /* renamed from: b */
        public void mo61b() {
            if (this.f661c != null) {
                this.f661c.getTarget().sendMessage(this.f661c);
            }
            if (this.f662d != null) {
                this.f662d.run();
            }
            m1066c();
            if (this.f659a.f669c.f838c != null) {
                this.f659a.f669c.f838c.f821a = false;
            }
        }
    }

    /* compiled from: MapController */
    /* renamed from: com.amap.api.a.av$b */
    class C0211b implements AnimationListener {
        /* renamed from: a */
        final /* synthetic */ av f663a;
        /* renamed from: b */
        private LinkedList<Animation> f664b = new LinkedList();
        /* renamed from: c */
        private boolean f665c = false;
        /* renamed from: d */
        private ch f666d = null;

        C0211b(av avVar) {
            this.f663a = avVar;
        }

        /* renamed from: a */
        public void m1073a() {
            this.f664b.clear();
        }

        /* renamed from: a */
        public void m1074a(int i, int i2, int i3, boolean z, boolean z2) {
            if (z) {
                m1072b(i3, i, i2, z2);
            } else {
                m1071a(i3, i, i2, z2);
            }
        }

        /* renamed from: a */
        private void m1071a(int i, int i2, int i3, boolean z) {
            if (this.f666d == null) {
                this.f666d = new ch(this.f663a.f669c.f837b.m1396g(), this);
            }
            this.f666d.f1023j = z;
            this.f666d.f1022i = i;
            this.f666d.m1636a(i, false, (float) i2, (float) i3);
            this.f665c = true;
        }

        /* renamed from: b */
        private void m1072b(int i, int i2, int i3, boolean z) {
            if (this.f666d == null) {
                this.f666d = new ch(this.f663a.f669c.f837b.m1396g(), this);
            }
            this.f666d.f1022i = i;
            this.f666d.f1023j = z;
            if (this.f666d.f1023j) {
                Point point = new Point(i2, i3);
                ac a = this.f663a.f669c.f837b.m1396g().mo144s().mo183a(i2, i3);
                this.f663a.f669c.f843h.f761j = this.f663a.f669c.f843h.m1288a(a);
                this.f663a.f669c.f843h.m1291a(point);
            }
            this.f666d.m1636a(i, true, (float) i2, (float) i3);
            this.f665c = true;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            C0222b g = this.f663a.f669c.f837b.m1396g();
            if (this.f664b.size() == 0) {
                this.f665c = false;
                this.f663a.f669c.f839d.m1363a();
                return;
            }
            g.startAnimation((Animation) this.f664b.remove());
        }
    }

    av(bf bfVar) {
        this.f669c = bfVar;
        this.f670d = false;
        this.f671e = new C0211b(this);
        this.f672f = new C0210a(this);
    }

    /* renamed from: a */
    public int m1079a() {
        return this.f667a;
    }

    /* renamed from: b */
    public int m1086b() {
        return this.f668b;
    }

    /* renamed from: a */
    public void m1080a(int i) {
        this.f667a = i;
    }

    /* renamed from: b */
    public void m1087b(int i) {
        this.f668b = i;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        boolean z = true;
        switch (i) {
            case 19:
                m1090c(0, -10);
                break;
            case 20:
                m1090c(0, 10);
                break;
            case 21:
                m1090c(-10, 0);
                break;
            case 22:
                m1090c(10, 0);
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    /* renamed from: a */
    public void m1083a(ac acVar) {
        this.f669c.f842g.m1183K();
        this.f669c.f837b.m1385a(acVar);
        C0260s.m1682a().m1684b();
    }

    /* renamed from: c */
    public int m1089c(int i) {
        C0222b g = this.f669c.f837b.m1396g();
        g.m1183K();
        int a = g.m1192a(i);
        int i2 = this.f669c.f843h.f758g;
        this.f669c.f837b.m1383a(a);
        try {
            if (this.f669c.f842g.mo142q().mo240a()) {
                this.f669c.f842g.m1184L();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        C0260s.m1682a().m1684b();
        return a;
    }

    /* renamed from: a */
    public void m1081a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            int b = this.f669c.f837b.m1388b();
            int a = this.f669c.f837b.m1382a();
            int e = this.f669c.f837b.m1394e();
            int b2 = this.f669c.f836a.m1405b();
            int a2 = this.f669c.f836a.m1402a();
            if (b2 == 0 && a2 == 0) {
                this.f667a = i;
                this.f668b = i2;
                return;
            }
            float max = Math.max(((float) i) / ((float) a2), ((float) i2) / ((float) b2));
            if (max > 1.0f) {
                a = e - m1075a(max);
                if (a > b) {
                    b = a;
                }
            } else if (((double) max) < 0.5d) {
                b = (m1075a(1.0f / max) + e) - 1;
                if (b >= a) {
                    b = a;
                }
            } else {
                b = e;
            }
            m1089c(b);
        }
    }

    /* renamed from: a */
    private int m1075a(float f) {
        int i = 1;
        int i2 = 0;
        int i3 = 1;
        while (((float) i3) <= f) {
            i3 *= 2;
            i2 = i;
            i++;
        }
        return i2;
    }

    /* renamed from: c */
    public boolean m1091c() {
        return m1093d(1);
    }

    /* renamed from: d */
    boolean m1093d(int i) {
        return m1078a(this.f669c.f837b.m1391c() / 2, this.f669c.f837b.m1393d() / 2, true, false, i);
    }

    /* renamed from: e */
    boolean m1094e(int i) {
        return m1078a(this.f669c.f837b.m1391c() / 2, this.f669c.f837b.m1393d() / 2, false, false, i);
    }

    /* renamed from: d */
    public boolean m1092d() {
        return m1094e(1);
    }

    /* renamed from: b */
    public boolean m1088b(int i, int i2) {
        return m1077a(i, i2, true, true);
    }

    /* renamed from: a */
    public void m1084a(ac acVar, int i) {
        this.f672f.m1069a(acVar, null, null, i);
    }

    /* renamed from: a */
    public void m1085a(boolean z) {
        this.f671e.m1073a();
        this.f672f.m1067a();
    }

    /* renamed from: c */
    public void m1090c(int i, int i2) {
        if (this.f670d) {
            this.f670d = false;
        } else if (i != 0 || i2 != 0) {
            if (C0269x.f1191l) {
                this.f669c.f843h.m1292a(new PointF(0.0f, 0.0f), new PointF((float) i, (float) i2), this.f669c.f837b.m1394e());
            }
            this.f669c.f837b.m1387a(false, false);
        }
    }

    /* renamed from: a */
    public void m1082a(int i, int i2, int i3, boolean z, boolean z2) {
        this.f671e.m1074a(i, i2, i3, z, z2);
    }

    /* renamed from: a */
    private boolean m1078a(int i, int i2, boolean z, boolean z2, int i3) {
        int e;
        this.f669c.f837b.m1396g().m1183K();
        boolean z3 = false;
        if (z) {
            e = this.f669c.f837b.m1394e() + i3;
        } else {
            e = this.f669c.f837b.m1394e() - i3;
        }
        int a = this.f669c.f837b.m1396g().m1192a(e);
        if (a != this.f669c.f837b.m1394e()) {
            m1082a(i, i2, a, z, z2);
            z3 = true;
        }
        try {
            if (this.f669c.f842g.mo142q().mo240a()) {
                this.f669c.f842g.m1184L();
            }
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        return z3;
    }

    /* renamed from: a */
    private boolean m1077a(int i, int i2, boolean z, boolean z2) {
        return m1078a(i, i2, z, z2, 1);
    }
}
