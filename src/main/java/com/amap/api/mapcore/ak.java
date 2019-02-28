package com.amap.api.mapcore;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.mapcore.util.C0399o;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.model.CameraPosition;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: MapFragmentDelegateImp */
public class ak implements C0318y {
    /* renamed from: a */
    public static volatile Context f1476a;
    /* renamed from: b */
    public int f1477b = 0;
    /* renamed from: c */
    private C0313u f1478c;
    /* renamed from: d */
    private AMapOptions f1479d;

    /* renamed from: a */
    public void mo449a(Context context) {
        if (context != null) {
            f1476a = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    public void mo451a(AMapOptions aMapOptions) {
        this.f1479d = aMapOptions;
    }

    /* renamed from: a */
    public C0313u mo446a() throws RemoteException {
        if (this.f1478c == null) {
            if (f1476a == null) {
                throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            }
            int i = f1476a.getResources().getDisplayMetrics().densityDpi;
            if (i <= ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
                C0344n.f1878a = 0.5f;
            } else if (i <= 160) {
                C0344n.f1878a = 0.8f;
            } else if (i <= 240) {
                C0344n.f1878a = 0.87f;
            } else if (i <= ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE) {
                C0344n.f1878a = 1.0f;
            } else if (i <= 480) {
                C0344n.f1878a = 1.5f;
            } else if (i <= 640) {
                C0344n.f1878a = 1.8f;
            } else {
                C0344n.f1878a = 0.9f;
            }
            this.f1478c = new AMapDelegateImpGLSurfaceView(f1476a);
        }
        return this.f1478c;
    }

    /* renamed from: a */
    public void mo448a(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        f1476a = activity.getApplicationContext();
        this.f1479d = aMapOptions;
    }

    /* renamed from: a */
    public void mo450a(Bundle bundle) throws RemoteException {
        C0399o.m3422a("MapFragmentDelegateImp", "onCreate", ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH);
    }

    /* renamed from: a */
    public View mo445a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        if (this.f1478c == null) {
            if (f1476a == null && layoutInflater != null) {
                f1476a = layoutInflater.getContext().getApplicationContext();
            }
            if (f1476a == null) {
                throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            }
            int i = f1476a.getResources().getDisplayMetrics().densityDpi;
            if (i <= ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
                C0344n.f1878a = 0.5f;
            } else if (i <= 160) {
                C0344n.f1878a = 0.6f;
            } else if (i <= 240) {
                C0344n.f1878a = 0.87f;
            } else if (i <= ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE) {
                C0344n.f1878a = 1.0f;
            } else if (i <= 480) {
                C0344n.f1878a = 1.5f;
            } else if (i <= 640) {
                C0344n.f1878a = 1.8f;
            } else {
                C0344n.f1878a = 0.9f;
            }
            this.f1478c = new AMapDelegateImpGLSurfaceView(f1476a);
            this.f1478c.mo407h(this.f1477b);
        }
        try {
            if (this.f1479d == null && bundle != null) {
                byte[] byteArray = bundle.getByteArray("MapOptions");
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(byteArray, 0, byteArray.length);
                obtain.setDataPosition(0);
                this.f1479d = AMapOptions.CREATOR.createFromParcel(obtain);
            }
            m2434b(this.f1479d);
            C0399o.m3422a("MapFragmentDelegateImp", "onCreateView", ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f1478c.mo428x();
    }

    /* renamed from: b */
    void m2434b(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions != null && this.f1478c != null) {
            CameraPosition camera = aMapOptions.getCamera();
            if (camera != null) {
                this.f1478c.mo362a(C0338k.m2882a(camera.target, camera.zoom, camera.bearing, camera.tilt));
            }
            ai u = this.f1478c.mo426u();
            u.mo551h(aMapOptions.getRotateGesturesEnabled().booleanValue());
            u.mo545e(aMapOptions.getScrollGesturesEnabled().booleanValue());
            u.mo549g(aMapOptions.getTiltGesturesEnabled().booleanValue());
            u.mo539b(aMapOptions.getZoomControlsEnabled().booleanValue());
            u.mo547f(aMapOptions.getZoomGesturesEnabled().booleanValue());
            u.mo541c(aMapOptions.getCompassEnabled().booleanValue());
            u.mo536a(aMapOptions.getScaleControlsEnabled().booleanValue());
            u.mo535a(aMapOptions.getLogoPosition());
            this.f1478c.mo388b(aMapOptions.getMapType());
            this.f1478c.setZOrderOnTop(aMapOptions.getZOrderOnTop().booleanValue());
        }
    }

    /* renamed from: b */
    public void mo452b() throws RemoteException {
        if (this.f1478c != null) {
            this.f1478c.onResume();
        }
    }

    /* renamed from: c */
    public void mo454c() throws RemoteException {
        if (this.f1478c != null) {
            this.f1478c.onPause();
        }
    }

    /* renamed from: d */
    public void mo455d() throws RemoteException {
    }

    /* renamed from: e */
    public void mo456e() throws RemoteException {
        if (this.f1478c != null) {
            this.f1478c.mo420p();
            this.f1478c.mo397d();
        }
    }

    /* renamed from: f */
    public void mo457f() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    /* renamed from: b */
    public void mo453b(Bundle bundle) throws RemoteException {
        if (this.f1478c != null) {
            if (this.f1479d == null) {
                this.f1479d = new AMapOptions();
            }
            try {
                Parcel obtain = Parcel.obtain();
                this.f1479d = this.f1479d.camera(mo446a().mo410i(false));
                this.f1479d.writeToParcel(obtain, 0);
                bundle.putByteArray("MapOptions", obtain.marshall());
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: a */
    public void mo447a(int i) {
        this.f1477b = i;
        if (this.f1478c != null) {
            this.f1478c.mo407h(i);
        }
    }
}
