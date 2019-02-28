package com.amap.api.maps;

import android.os.RemoteException;
import com.amap.api.mapcore.ai;
import com.amap.api.maps.model.RuntimeRemoteException;

public final class UiSettings {
    /* renamed from: a */
    private final ai f2237a;

    UiSettings(ai aiVar) {
        this.f2237a = aiVar;
    }

    public void setScaleControlsEnabled(boolean z) {
        try {
            this.f2237a.mo536a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomControlsEnabled(boolean z) {
        try {
            this.f2237a.mo539b(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setCompassEnabled(boolean z) {
        try {
            this.f2237a.mo541c(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setMyLocationButtonEnabled(boolean z) {
        try {
            this.f2237a.mo543d(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        try {
            this.f2237a.mo545e(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        try {
            this.f2237a.mo547f(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTiltGesturesEnabled(boolean z) {
        try {
            this.f2237a.mo549g(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        try {
            this.f2237a.mo551h(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        try {
            this.f2237a.mo554i(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setLogoPosition(int i) {
        try {
            this.f2237a.mo535a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomPosition(int i) {
        try {
            this.f2237a.mo538b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getZoomPosition() {
        try {
            return this.f2237a.mo555j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScaleControlsEnabled() {
        try {
            return this.f2237a.mo537a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomControlsEnabled() {
        try {
            return this.f2237a.mo540b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isCompassEnabled() {
        try {
            return this.f2237a.mo542c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isMyLocationButtonEnabled() {
        try {
            return this.f2237a.mo544d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isScrollGesturesEnabled() {
        try {
            return this.f2237a.mo546e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.f2237a.mo548f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isTiltGesturesEnabled() {
        try {
            return this.f2237a.mo550g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isRotateGesturesEnabled() {
        try {
            return this.f2237a.mo552h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getLogoPosition() {
        try {
            return this.f2237a.mo553i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
