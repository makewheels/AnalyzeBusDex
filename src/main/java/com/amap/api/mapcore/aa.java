package com.amap.api.mapcore;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: INavigateArrowDelegate */
public interface aa extends ab {
    /* renamed from: a */
    void mo459a(int i) throws RemoteException;

    /* renamed from: a */
    void mo460a(List<LatLng> list) throws RemoteException;

    /* renamed from: b */
    void mo466b(float f) throws RemoteException;

    /* renamed from: b */
    void mo467b(int i) throws RemoteException;

    /* renamed from: h */
    float mo473h() throws RemoteException;

    /* renamed from: i */
    int mo474i() throws RemoteException;

    /* renamed from: l */
    int mo477l() throws RemoteException;

    /* renamed from: m */
    List<LatLng> mo478m() throws RemoteException;
}
