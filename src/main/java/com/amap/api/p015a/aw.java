package com.amap.api.p015a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.p015a.p016a.C0202n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: MapFragmentDelegateImp */
/* renamed from: com.amap.api.a.aw */
public class aw implements ai {
    /* renamed from: a */
    public static volatile Context f673a;
    /* renamed from: b */
    private af f674b;
    /* renamed from: c */
    private AMapOptions f675c;

    /* renamed from: a */
    public void mo65a(Context context) {
        if (context != null) {
            f673a = context.getApplicationContext();
        }
    }

    /* renamed from: a */
    public void mo67a(AMapOptions aMapOptions) {
        this.f675c = aMapOptions;
    }

    /* renamed from: a */
    public af mo63a() throws RemoteException {
        if (this.f674b == null) {
            if (f673a == null) {
                throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            }
            int i = f673a.getResources().getDisplayMetrics().densityDpi;
            if (i <= ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
                C0269x.f1180a = 0.5f;
            } else if (i <= 160) {
                C0269x.f1180a = 0.8f;
            } else if (i <= 240) {
                C0269x.f1180a = 0.87f;
            } else if (i <= ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE) {
                C0269x.f1180a = 1.0f;
            } else if (i <= 480) {
                C0269x.f1180a = 1.5f;
            } else if (i <= 640) {
                C0269x.f1180a = 1.8f;
            } else {
                C0269x.f1180a = 0.9f;
            }
            this.f674b = new C0222b(f673a);
        }
        return this.f674b;
    }

    /* renamed from: a */
    public void mo64a(Activity activity, AMapOptions aMapOptions, Bundle bundle) throws RemoteException {
        f673a = activity.getApplicationContext();
        this.f675c = aMapOptions;
    }

    /* renamed from: a */
    public void mo66a(Bundle bundle) throws RemoteException {
        C0202n.m788a("MapFragmentDelegateImp", "onCreate", ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH);
    }

    /* renamed from: a */
    public View mo62a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        if (this.f674b == null) {
            if (f673a == null && layoutInflater != null) {
                f673a = layoutInflater.getContext().getApplicationContext();
            }
            if (f673a == null) {
                throw new NullPointerException("Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            }
            int i = f673a.getResources().getDisplayMetrics().densityDpi;
            if (i <= ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR) {
                C0269x.f1180a = 0.5f;
            } else if (i <= 160) {
                C0269x.f1180a = 0.6f;
            } else if (i <= 240) {
                C0269x.f1180a = 0.87f;
            } else if (i <= ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE) {
                C0269x.f1180a = 1.0f;
            } else if (i <= 480) {
                C0269x.f1180a = 1.5f;
            } else if (i <= 640) {
                C0269x.f1180a = 1.8f;
            } else {
                C0269x.f1180a = 0.9f;
            }
            this.f674b = new C0222b(f673a);
        }
        if (this.f675c == null && bundle != null) {
            this.f675c = (AMapOptions) bundle.getParcelable("MapOptions");
        }
        m1103b(this.f675c);
        C0202n.m788a("MapFragmentDelegateImp", "onCreateView", ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH);
        return this.f674b.mo128e();
    }

    /* renamed from: b */
    void m1103b(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions != null && this.f674b != null) {
            CameraPosition camera = aMapOptions.getCamera();
            if (camera != null) {
                this.f674b.mo92a(C0262t.m1693a(camera.target, camera.zoom, camera.bearing, camera.tilt));
            }
            aq q = this.f674b.mo142q();
            q.mo248e(aMapOptions.getScrollGesturesEnabled().booleanValue());
            q.mo242b(aMapOptions.getZoomControlsEnabled().booleanValue());
            q.mo250f(aMapOptions.getZoomGesturesEnabled().booleanValue());
            q.mo244c(aMapOptions.getCompassEnabled().booleanValue());
            q.mo239a(aMapOptions.getScaleControlsEnabled().booleanValue());
            q.mo238a(aMapOptions.getLogoPosition());
            this.f674b.mo116b(aMapOptions.getMapType());
            this.f674b.mo107a(aMapOptions.getZOrderOnTop().booleanValue());
        }
    }

    /* renamed from: b */
    public void mo68b() throws RemoteException {
        if (this.f674b != null) {
            this.f674b.mo147y();
        }
    }

    /* renamed from: c */
    public void mo70c() throws RemoteException {
        if (this.f674b != null) {
            this.f674b.mo148z();
        }
    }

    /* renamed from: d */
    public void mo71d() throws RemoteException {
    }

    /* renamed from: e */
    public void mo72e() throws RemoteException {
        if (mo63a() != null) {
            mo63a().mo137k();
            mo63a().mo145v();
        }
    }

    /* renamed from: f */
    public void mo73f() throws RemoteException {
        Log.d("onLowMemory", "onLowMemory run");
    }

    /* renamed from: b */
    public void mo69b(Bundle bundle) throws RemoteException {
        if (this.f674b != null) {
            if (this.f675c == null) {
                this.f675c = new AMapOptions();
            }
            this.f675c = this.f675c.camera(mo63a().mo132g());
            bundle.putParcelable("MapOptions", this.f675c);
        }
    }
}
