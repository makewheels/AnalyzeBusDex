package com.amap.api.p015a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.RemoteException;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import com.autonavi.amap.mapcore2d.FPoint;
import java.util.ArrayList;

/* compiled from: IMarkerDelegate */
/* renamed from: com.amap.api.a.aj */
public interface aj {
    /* renamed from: a */
    void mo149a(float f) throws RemoteException;

    /* renamed from: a */
    void mo150a(float f, float f2);

    /* renamed from: a */
    void mo151a(int i) throws RemoteException;

    /* renamed from: a */
    void mo152a(Canvas canvas, af afVar);

    /* renamed from: a */
    void mo153a(BitmapDescriptor bitmapDescriptor);

    /* renamed from: a */
    void mo154a(LatLng latLng);

    /* renamed from: a */
    void mo155a(Object obj);

    /* renamed from: a */
    void mo156a(String str);

    /* renamed from: a */
    void mo157a(ArrayList<BitmapDescriptor> arrayList) throws RemoteException;

    /* renamed from: a */
    void mo158a(boolean z);

    /* renamed from: a */
    boolean mo159a() throws RemoteException;

    /* renamed from: a */
    boolean mo160a(aj ajVar);

    /* renamed from: b */
    Rect mo161b();

    /* renamed from: b */
    void mo162b(LatLng latLng);

    /* renamed from: b */
    void mo163b(String str);

    /* renamed from: b */
    void mo164b(boolean z);

    /* renamed from: c */
    LatLng mo165c();

    /* renamed from: d */
    LatLng mo166d();

    /* renamed from: e */
    String mo167e();

    /* renamed from: f */
    FPoint mo168f();

    /* renamed from: g */
    String mo169g();

    /* renamed from: h */
    String mo170h();

    /* renamed from: i */
    boolean mo171i();

    /* renamed from: j */
    void mo172j();

    /* renamed from: k */
    void mo173k();

    /* renamed from: l */
    boolean mo174l();

    /* renamed from: m */
    boolean mo175m();

    /* renamed from: n */
    void mo176n();

    /* renamed from: o */
    int mo177o();

    /* renamed from: p */
    Object mo178p();

    /* renamed from: q */
    int mo179q();

    /* renamed from: r */
    int mo180r() throws RemoteException;

    /* renamed from: s */
    ArrayList<BitmapDescriptor> mo181s() throws RemoteException;
}
