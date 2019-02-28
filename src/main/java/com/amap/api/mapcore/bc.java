package com.amap.api.mapcore;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.opengl.GLES10;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import com.amap.api.mapcore.util.C0405u;
import com.amap.api.mapcore.util.az;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.FPoint;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: TextDelegateImp */
class bc implements ag {
    /* renamed from: a */
    private static int f1634a = 0;
    /* renamed from: A */
    private Runnable f1635A = new bd(this);
    /* renamed from: B */
    private boolean f1636B = false;
    /* renamed from: C */
    private boolean f1637C = false;
    /* renamed from: b */
    private float f1638b = 0.0f;
    /* renamed from: c */
    private float f1639c = 0.0f;
    /* renamed from: d */
    private int f1640d = 4;
    /* renamed from: e */
    private int f1641e = 32;
    /* renamed from: f */
    private FPoint f1642f = new FPoint();
    /* renamed from: g */
    private int f1643g;
    /* renamed from: h */
    private Bitmap f1644h;
    /* renamed from: i */
    private FloatBuffer f1645i = null;
    /* renamed from: j */
    private String f1646j;
    /* renamed from: k */
    private LatLng f1647k;
    /* renamed from: l */
    private float f1648l = 0.5f;
    /* renamed from: m */
    private float f1649m = 1.0f;
    /* renamed from: n */
    private boolean f1650n = true;
    /* renamed from: o */
    private an f1651o;
    /* renamed from: p */
    private FloatBuffer f1652p;
    /* renamed from: q */
    private Object f1653q;
    /* renamed from: r */
    private String f1654r;
    /* renamed from: s */
    private int f1655s;
    /* renamed from: t */
    private int f1656t;
    /* renamed from: u */
    private int f1657u;
    /* renamed from: v */
    private Typeface f1658v;
    /* renamed from: w */
    private float f1659w;
    /* renamed from: x */
    private Rect f1660x = new Rect();
    /* renamed from: y */
    private Paint f1661y = new Paint();
    /* renamed from: z */
    private Handler f1662z = new Handler();

    /* renamed from: d */
    private static String m2662d(String str) {
        f1634a++;
        return str + f1634a;
    }

    /* renamed from: a */
    public void mo277a(float f) {
        this.f1639c = f;
        this.f1638b = (((-f) % 360.0f) + 360.0f) % 360.0f;
        m2654P();
    }

    /* renamed from: x */
    public boolean mo316x() {
        return this.f1636B;
    }

    /* renamed from: y */
    public synchronized void mo317y() {
        if (this.f1636B) {
            try {
                mo292b();
                if (this.f1644h != null) {
                    this.f1644h.recycle();
                    this.f1644h = null;
                }
                if (this.f1652p != null) {
                    this.f1652p.clear();
                    this.f1652p = null;
                }
                if (this.f1645i != null) {
                    this.f1645i.clear();
                    this.f1645i = null;
                }
                this.f1647k = null;
                this.f1653q = null;
            } catch (Throwable th) {
                az.m3143a(th, "TextDelegateImp", "realdestroy");
                th.printStackTrace();
                Log.d("destroy erro", "TextDelegateImp destroy");
            }
        }
    }

    /* renamed from: p */
    public void mo308p() {
        try {
            this.f1636B = true;
            if (!(this.f1651o == null || this.f1651o.f1485a == null)) {
                this.f1651o.f1485a.mo336I();
            }
            this.f1643g = 0;
        } catch (Throwable th) {
            az.m3143a(th, "TextDelegateImp", "destroy");
            th.printStackTrace();
            Log.d("destroy erro", "TextDelegateImp destroy");
        }
    }

    public bc(TextOptions textOptions, an anVar) throws RemoteException {
        this.f1651o = anVar;
        if (textOptions.getPosition() != null) {
            this.f1647k = textOptions.getPosition();
        }
        mo515b(textOptions.getAlignX(), textOptions.getAlignY());
        this.f1650n = textOptions.isVisible();
        this.f1654r = textOptions.getText();
        this.f1655s = textOptions.getBackgroundColor();
        this.f1656t = textOptions.getFontColor();
        this.f1657u = textOptions.getFontSize();
        this.f1653q = textOptions.getObject();
        this.f1659w = textOptions.getZIndex();
        this.f1658v = textOptions.getTypeface();
        this.f1646j = mo300h();
        mo277a(textOptions.getRotate());
        m2653O();
        mo310r();
    }

    /* renamed from: O */
    private void m2653O() {
        if (this.f1654r != null && this.f1654r.trim().length() > 0) {
            try {
                this.f1661y.setTypeface(this.f1658v);
                this.f1661y.setSubpixelText(true);
                this.f1661y.setAntiAlias(true);
                this.f1661y.setStrokeWidth(5.0f);
                this.f1661y.setStrokeCap(Cap.ROUND);
                this.f1661y.setTextSize((float) this.f1657u);
                this.f1661y.setTextAlign(Align.CENTER);
                this.f1661y.setColor(this.f1656t);
                FontMetrics fontMetrics = this.f1661y.getFontMetrics();
                int i = (int) (fontMetrics.descent - fontMetrics.ascent);
                int i2 = (int) (((((float) i) - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
                this.f1661y.getTextBounds(this.f1654r, 0, this.f1654r.length(), this.f1660x);
                Bitmap createBitmap = Bitmap.createBitmap(this.f1660x.width() + 6, i, Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                canvas.drawColor(this.f1655s);
                canvas.drawText(this.f1654r, (float) (this.f1660x.centerX() + 3), (float) i2, this.f1661y);
                this.f1644h = createBitmap;
                this.f1652p = C0405u.m3461a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
            } catch (Throwable th) {
                az.m3143a(th, "TextDelegateImp", "initBitmap");
            }
        }
    }

    /* renamed from: b */
    public synchronized boolean mo292b() {
        m2654P();
        this.f1650n = false;
        return this.f1651o.m2459b((C0294z) this);
    }

    /* renamed from: P */
    private void m2654P() {
        if (this.f1651o.f1485a != null) {
            this.f1651o.f1485a.mo401e(false);
        }
    }

    /* renamed from: e */
    public LatLng mo297e() {
        return this.f1647k;
    }

    /* renamed from: h */
    public String mo300h() {
        if (this.f1646j == null) {
            this.f1646j = m2662d("Text");
        }
        return this.f1646j;
    }

    /* renamed from: a */
    public void mo282a(LatLng latLng) {
        this.f1647k = latLng;
        mo310r();
        m2654P();
    }

    /* renamed from: a */
    public void mo284a(String str) {
    }

    /* renamed from: i */
    public String mo301i() {
        return null;
    }

    /* renamed from: b */
    public void mo290b(String str) {
    }

    /* renamed from: j */
    public String mo302j() {
        return null;
    }

    /* renamed from: a */
    public void mo287a(boolean z) {
    }

    /* renamed from: a */
    public synchronized void mo285a(ArrayList<BitmapDescriptor> arrayList) {
    }

    /* renamed from: w */
    public synchronized ArrayList<BitmapDescriptor> mo315w() {
        return null;
    }

    /* renamed from: a */
    public synchronized void mo281a(BitmapDescriptor bitmapDescriptor) {
    }

    /* renamed from: k */
    public boolean mo303k() {
        return false;
    }

    /* renamed from: l */
    public void mo304l() {
    }

    /* renamed from: m */
    public void mo305m() {
    }

    /* renamed from: n */
    public boolean mo306n() {
        return false;
    }

    /* renamed from: b */
    public void mo291b(boolean z) {
        if (this.f1650n != z) {
            this.f1650n = z;
            m2654P();
        }
    }

    /* renamed from: o */
    public boolean mo307o() {
        return this.f1650n;
    }

    /* renamed from: b */
    public void mo289b(float f) {
        this.f1659w = f;
        this.f1651o.m2470i();
    }

    /* renamed from: G */
    public float mo275G() {
        return this.f1659w;
    }

    /* renamed from: a */
    public void mo278a(float f, float f2) {
    }

    /* renamed from: a */
    public boolean mo288a(C0294z c0294z) throws RemoteException {
        if (equals(c0294z) || c0294z.mo300h().equals(mo300h())) {
            return true;
        }
        return false;
    }

    /* renamed from: q */
    public int mo309q() {
        return super.hashCode();
    }

    /* renamed from: r */
    public boolean mo310r() {
        this.f1651o.f1485a.mo352a(this.f1647k.latitude, this.f1647k.longitude, this.f1642f);
        return true;
    }

    /* renamed from: a */
    private void m2659a(C0313u c0313u) throws RemoteException {
        float[] a = C0405u.m3470a(c0313u, 0, this.f1642f, this.f1638b, this.f1644h.getWidth(), this.f1644h.getHeight(), this.f1648l, this.f1649m);
        if (this.f1645i == null) {
            this.f1645i = C0405u.m3461a(a);
        } else {
            this.f1645i = C0405u.m3462a(a, this.f1645i);
        }
        if (this.f1643g != 0) {
            m2657a(this.f1643g, this.f1645i, this.f1652p);
        }
    }

    /* renamed from: a */
    private void m2657a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (i != 0 && floatBuffer != null && floatBuffer2 != null) {
            GLES10.glEnable(3042);
            GLES10.glBlendFunc(1, 771);
            GLES10.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GLES10.glEnable(3553);
            GLES10.glEnableClientState(32884);
            GLES10.glEnableClientState(32888);
            GLES10.glBindTexture(3553, i);
            GLES10.glVertexPointer(3, 5126, 0, floatBuffer);
            GLES10.glTexCoordPointer(2, 5126, 0, floatBuffer2);
            GLES10.glDrawArrays(6, 0, 4);
            GLES10.glDisableClientState(32884);
            GLES10.glDisableClientState(32888);
            GLES10.glDisable(3553);
            GLES10.glDisable(3042);
        }
    }

    /* renamed from: a */
    public void mo286a(GL10 gl10, C0313u c0313u) {
        if (this.f1650n && this.f1647k != null && this.f1644h != null) {
            if (!this.f1637C) {
                try {
                    if (!(this.f1644h == null || this.f1644h.isRecycled())) {
                        if (this.f1643g == 0) {
                            this.f1643g = m2656a(gl10);
                        }
                        C0405u.m3474b(gl10, this.f1643g, this.f1644h, false);
                        this.f1637C = true;
                        this.f1644h.recycle();
                    }
                } catch (Throwable th) {
                    az.m3143a(th, "TextDelegateImp", "loadtexture");
                    th.printStackTrace();
                    return;
                }
            }
            try {
                m2659a(c0313u);
            } catch (Throwable th2) {
                az.m3143a(th2, "TextDelegateImp", "drawMarker");
            }
        }
    }

    /* renamed from: a */
    private int m2656a(GL10 gl10) {
        int F = this.f1651o.f1485a.mo333F();
        if (F != 0) {
            return F;
        }
        int[] iArr = new int[]{0};
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    /* renamed from: c */
    public boolean mo294c() {
        return true;
    }

    /* renamed from: a */
    public void mo279a(int i) {
    }

    /* renamed from: a */
    public void mo283a(Object obj) {
        this.f1653q = obj;
    }

    /* renamed from: s */
    public Object mo311s() {
        return this.f1653q;
    }

    /* renamed from: c */
    public void mo293c(boolean z) {
    }

    /* renamed from: t */
    public boolean mo312t() {
        return false;
    }

    /* renamed from: v */
    public int mo314v() {
        return 0;
    }

    /* renamed from: g */
    public LatLng mo299g() {
        return this.f1647k;
    }

    /* renamed from: z */
    public void mo318z() {
        this.f1651o.m2461c(this);
    }

    /* renamed from: d */
    public void mo296d(boolean z) throws RemoteException {
    }

    /* renamed from: A */
    public boolean mo269A() {
        return false;
    }

    /* renamed from: u */
    public float mo313u() {
        return this.f1639c;
    }

    /* renamed from: B */
    public int mo270B() {
        return 0;
    }

    /* renamed from: C */
    public int mo271C() {
        return 0;
    }

    /* renamed from: a */
    public void mo280a(int i, int i2) {
    }

    /* renamed from: D */
    public int mo272D() {
        return 0;
    }

    /* renamed from: E */
    public int mo273E() {
        return 0;
    }

    /* renamed from: f */
    public FPoint mo298f() {
        return this.f1642f;
    }

    /* renamed from: F */
    public boolean mo274F() {
        return false;
    }

    /* renamed from: d */
    public Rect mo295d() {
        return null;
    }

    /* renamed from: c */
    public void mo517c(String str) throws RemoteException {
        this.f1654r = str;
        m2655Q();
    }

    /* renamed from: a */
    public String mo512a() throws RemoteException {
        return this.f1654r;
    }

    /* renamed from: b */
    public void mo514b(int i) throws RemoteException {
        this.f1655s = i;
        m2655Q();
    }

    /* renamed from: I */
    public int mo506I() throws RemoteException {
        return this.f1655s;
    }

    /* renamed from: c */
    public void mo516c(int i) throws RemoteException {
        this.f1656t = i;
        m2655Q();
    }

    /* renamed from: J */
    public int mo507J() throws RemoteException {
        return this.f1656t;
    }

    /* renamed from: d */
    public void mo518d(int i) throws RemoteException {
        this.f1657u = i;
        m2655Q();
    }

    /* renamed from: K */
    public int mo508K() throws RemoteException {
        return this.f1657u;
    }

    /* renamed from: a */
    public void mo513a(Typeface typeface) throws RemoteException {
        this.f1658v = typeface;
        m2655Q();
    }

    /* renamed from: L */
    public Typeface mo509L() throws RemoteException {
        return this.f1658v;
    }

    /* renamed from: b */
    public void mo515b(int i, int i2) throws RemoteException {
        this.f1640d = i;
        switch (i) {
            case 1:
                this.f1648l = 0.0f;
                break;
            case 2:
                this.f1648l = 1.0f;
                break;
            case 4:
                this.f1648l = 0.5f;
                break;
            default:
                this.f1648l = 0.5f;
                break;
        }
        this.f1641e = i2;
        switch (i2) {
            case 8:
                this.f1649m = 0.0f;
                break;
            case 16:
                this.f1649m = 1.0f;
                break;
            case 32:
                this.f1649m = 0.5f;
                break;
            default:
                this.f1649m = 0.5f;
                break;
        }
        m2654P();
    }

    /* renamed from: M */
    public int mo510M() throws RemoteException {
        return this.f1640d;
    }

    /* renamed from: N */
    public int mo511N() {
        return this.f1641e;
    }

    /* renamed from: Q */
    private void m2655Q() {
        this.f1662z.removeCallbacks(this.f1635A);
        this.f1662z.post(this.f1635A);
    }

    /* renamed from: H */
    public boolean mo276H() {
        LatLngBounds B = this.f1651o.f1485a.mo331B();
        if (this.f1647k == null || B == null) {
            return true;
        }
        return B.contains(this.f1647k);
    }
}
