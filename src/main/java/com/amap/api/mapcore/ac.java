package com.amap.api.mapcore;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: IPolygonDelegate */
public interface ac extends ab {
    /* renamed from: a */
    void mo479a(int i) throws RemoteException;

    /* renamed from: a */
    void mo480a(List<LatLng> list) throws RemoteException;

    /* renamed from: a */
    boolean mo481a(LatLng latLng) throws RemoteException;

    /* renamed from: b */
    void mo482b(float f) throws RemoteException;

    /* renamed from: b */
    void mo483b(int i) throws RemoteException;

    /* renamed from: h */
    float mo484h() throws RemoteException;

    /* renamed from: i */
    int mo485i() throws RemoteException;

    /* renamed from: l */
    List<LatLng> mo486l() throws RemoteException;

    /* renamed from: m */
    int mo487m() throws RemoteException;
}
