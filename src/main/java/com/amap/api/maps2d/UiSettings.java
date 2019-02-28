package com.amap.api.maps2d;

import android.os.RemoteException;
import com.amap.api.maps2d.model.RuntimeRemoteException;
import com.amap.api.p015a.aq;

public final class UiSettings {
    /* renamed from: a */
    private final aq f2568a;

    UiSettings(aq aqVar) {
        this.f2568a = aqVar;
    }

    public void setScaleControlsEnabled(boolean z) {
        try {
            this.f2568a.mo239a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        try {
            this.f2568a.mo242b(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCompassEnabled(boolean z) {
        try {
            this.f2568a.mo244c(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        try {
            this.f2568a.mo246d(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        try {
            this.f2568a.mo248e(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.f2568a.mo250f(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        try {
            this.f2568a.mo253g(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setLogoPosition(int i) {
        try {
            this.f2568a.mo238a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomPosition(int i) {
        try {
            this.f2568a.mo241b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScaleControlsEnabled() {
        try {
            return this.f2568a.mo240a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.f2568a.mo243b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isCompassEnabled() {
        try {
            return this.f2568a.mo245c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.f2568a.mo247d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.f2568a.mo249e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.f2568a.mo251f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getLogoPosition() {
        try {
            return this.f2568a.mo252g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getZoomPosition() {
        try {
            return this.f2568a.mo254h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
