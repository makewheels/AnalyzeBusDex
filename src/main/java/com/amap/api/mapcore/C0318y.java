package com.amap.api.mapcore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;

/* compiled from: IMapFragmentDelegate */
/* renamed from: com.amap.api.mapcore.y */
public interface C0318y {
    /* renamed from: a */
    View mo445a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    C0313u mo446a() throws RemoteException;

    /* renamed from: a */
    void mo447a(int i);

    /* renamed from: a */
    void mo448a(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo449a(Context context);

    /* renamed from: a */
    void mo450a(Bundle bundle) throws RemoteException;

    /* renamed from: a */
    void mo451a(AMapOptions aMapOptions);

    /* renamed from: b */
    void mo452b() throws RemoteException;

    /* renamed from: b */
    void mo453b(Bundle bundle) throws RemoteException;

    /* renamed from: c */
    void mo454c() throws RemoteException;

    /* renamed from: d */
    void mo455d() throws RemoteException;

    /* renamed from: e */
    void mo456e() throws RemoteException;

    /* renamed from: f */
    void mo457f() throws RemoteException;
}
