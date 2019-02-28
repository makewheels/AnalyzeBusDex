package com.amap.api.p015a;

import android.os.RemoteException;
import com.amap.api.maps2d.model.BitmapDescriptor;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;

/* compiled from: IGroundOverlayDelegate */
/* renamed from: com.amap.api.a.ah */
public interface ah extends ak {
    /* renamed from: a */
    void mo37a(float f, float f2) throws RemoteException;

    /* renamed from: a */
    void mo39a(BitmapDescriptor bitmapDescriptor) throws RemoteException;

    /* renamed from: a */
    void mo40a(LatLng latLng) throws RemoteException;

    /* renamed from: a */
    void mo41a(LatLngBounds latLngBounds) throws RemoteException;

    /* renamed from: b */
    void mo46b(float f) throws RemoteException;

    /* renamed from: c */
    void mo48c(float f) throws RemoteException;

    /* renamed from: d */
    void mo50d(float f) throws RemoteException;

    /* renamed from: h */
    LatLng mo53h() throws RemoteException;

    /* renamed from: i */
    float mo54i() throws RemoteException;

    /* renamed from: j */
    float mo55j() throws RemoteException;

    /* renamed from: k */
    LatLngBounds mo56k() throws RemoteException;

    /* renamed from: l */
    float mo57l() throws RemoteException;

    /* renamed from: n */
    float mo59n() throws RemoteException;
}
