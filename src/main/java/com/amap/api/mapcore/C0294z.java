package com.amap.api.mapcore;

import android.graphics.Rect;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.FPoint;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: IMarkerDelegate */
/* renamed from: com.amap.api.mapcore.z */
public interface C0294z {
    /* renamed from: A */
    boolean mo269A();

    /* renamed from: B */
    int mo270B();

    /* renamed from: C */
    int mo271C();

    /* renamed from: D */
    int mo272D();

    /* renamed from: E */
    int mo273E();

    /* renamed from: F */
    boolean mo274F();

    /* renamed from: G */
    float mo275G();

    /* renamed from: H */
    boolean mo276H();

    /* renamed from: a */
    void mo277a(float f) throws RemoteException;

    /* renamed from: a */
    void mo278a(float f, float f2) throws RemoteException;

    /* renamed from: a */
    void mo279a(int i) throws RemoteException;

    /* renamed from: a */
    void mo280a(int i, int i2);

    /* renamed from: a */
    void mo281a(BitmapDescriptor bitmapDescriptor) throws RemoteException;

    /* renamed from: a */
    void mo282a(LatLng latLng) throws RemoteException;

    /* renamed from: a */
    void mo283a(Object obj);

    /* renamed from: a */
    void mo284a(String str) throws RemoteException;

    /* renamed from: a */
    void mo285a(ArrayList<BitmapDescriptor> arrayList) throws RemoteException;

    /* renamed from: a */
    void mo286a(GL10 gl10, C0313u c0313u);

    /* renamed from: a */
    void mo287a(boolean z) throws RemoteException;

    /* renamed from: a */
    boolean mo288a(C0294z c0294z) throws RemoteException;

    /* renamed from: b */
    void mo289b(float f);

    /* renamed from: b */
    void mo290b(String str) throws RemoteException;

    /* renamed from: b */
    void mo291b(boolean z) throws RemoteException;

    /* renamed from: b */
    boolean mo292b() throws RemoteException;

    /* renamed from: c */
    void mo293c(boolean z) throws RemoteException;

    /* renamed from: c */
    boolean mo294c();

    /* renamed from: d */
    Rect mo295d();

    /* renamed from: d */
    void mo296d(boolean z) throws RemoteException;

    /* renamed from: e */
    LatLng mo297e() throws RemoteException;

    /* renamed from: f */
    FPoint mo298f();

    /* renamed from: g */
    LatLng mo299g();

    /* renamed from: h */
    String mo300h() throws RemoteException;

    /* renamed from: i */
    String mo301i() throws RemoteException;

    /* renamed from: j */
    String mo302j() throws RemoteException;

    /* renamed from: k */
    boolean mo303k();

    /* renamed from: l */
    void mo304l() throws RemoteException;

    /* renamed from: m */
    void mo305m() throws RemoteException;

    /* renamed from: n */
    boolean mo306n();

    /* renamed from: o */
    boolean mo307o() throws RemoteException;

    /* renamed from: p */
    void mo308p();

    /* renamed from: q */
    int mo309q();

    /* renamed from: r */
    boolean mo310r();

    /* renamed from: s */
    Object mo311s();

    /* renamed from: t */
    boolean mo312t() throws RemoteException;

    /* renamed from: u */
    float mo313u();

    /* renamed from: v */
    int mo314v() throws RemoteException;

    /* renamed from: w */
    ArrayList<BitmapDescriptor> mo315w() throws RemoteException;

    /* renamed from: x */
    boolean mo316x();

    /* renamed from: y */
    void mo317y();

    /* renamed from: z */
    void mo318z() throws RemoteException;
}
