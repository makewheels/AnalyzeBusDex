package com.amap.api.p015a;

import android.os.RemoteException;
import com.amap.api.maps2d.model.LatLng;
import java.util.List;

/* compiled from: IPolygonDelegate */
/* renamed from: com.amap.api.a.al */
public interface al extends ak {
    /* renamed from: a */
    void mo185a(int i) throws RemoteException;

    /* renamed from: a */
    void mo186a(List<LatLng> list) throws RemoteException;

    /* renamed from: a */
    boolean mo187a(LatLng latLng) throws RemoteException;

    /* renamed from: b */
    void mo188b(float f) throws RemoteException;

    /* renamed from: b */
    void mo189b(int i) throws RemoteException;

    /* renamed from: g */
    float mo190g() throws RemoteException;

    /* renamed from: h */
    int mo191h() throws RemoteException;

    /* renamed from: i */
    List<LatLng> mo192i() throws RemoteException;

    /* renamed from: j */
    int mo193j() throws RemoteException;
}
