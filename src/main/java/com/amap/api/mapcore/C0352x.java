package com.amap.api.mapcore;

import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;

/* compiled from: IGroundOverlayDelegate */
/* renamed from: com.amap.api.mapcore.x */
public interface C0352x extends ab {
    /* renamed from: a */
    void mo572a(float f, float f2) throws RemoteException;

    /* renamed from: a */
    void mo573a(BitmapDescriptor bitmapDescriptor) throws RemoteException;

    /* renamed from: a */
    void mo574a(LatLng latLng) throws RemoteException;

    /* renamed from: a */
    void mo575a(LatLngBounds latLngBounds) throws RemoteException;

    /* renamed from: b */
    void mo576b(float f) throws RemoteException;

    /* renamed from: c */
    void mo577c(float f) throws RemoteException;

    /* renamed from: d */
    void mo578d(float f) throws RemoteException;

    /* renamed from: h */
    LatLng mo579h() throws RemoteException;

    /* renamed from: i */
    float mo580i() throws RemoteException;

    /* renamed from: l */
    float mo581l() throws RemoteException;

    /* renamed from: m */
    LatLngBounds mo582m() throws RemoteException;

    /* renamed from: n */
    float mo583n() throws RemoteException;

    /* renamed from: o */
    float mo584o() throws RemoteException;
}
