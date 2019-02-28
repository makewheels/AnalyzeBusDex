package com.amap.api.mapcore;

import android.os.RemoteException;
import com.amap.api.maps.model.LatLng;
import java.util.List;

/* compiled from: IPolylineDelegate */
public interface ad extends ab {
    /* renamed from: a */
    LatLng mo488a(LatLng latLng);

    /* renamed from: a */
    void mo489a(int i) throws RemoteException;

    /* renamed from: a */
    void mo490a(List<LatLng> list) throws RemoteException;

    /* renamed from: b */
    void mo491b(float f) throws RemoteException;

    /* renamed from: b */
    void mo492b(boolean z) throws RemoteException;

    /* renamed from: c */
    void mo493c(boolean z);

    /* renamed from: h */
    float mo494h() throws RemoteException;

    /* renamed from: i */
    int mo495i() throws RemoteException;

    /* renamed from: l */
    List<LatLng> mo496l() throws RemoteException;

    /* renamed from: m */
    boolean mo497m();

    /* renamed from: n */
    boolean mo498n();
}
