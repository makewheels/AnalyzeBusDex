package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.aa;
import java.util.List;

public class NavigateArrow {
    /* renamed from: a */
    private final aa f2334a;

    public NavigateArrow(aa aaVar) {
        this.f2334a = aaVar;
    }

    public void remove() {
        try {
            this.f2334a.mo465b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f2334a.mo468c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.f2334a.mo460a((List) list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.f2334a.mo478m();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setWidth(float f) {
        try {
            this.f2334a.mo466b(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            return this.f2334a.mo473h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTopColor(int i) {
        try {
            this.f2334a.mo459a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getTopColor() {
        try {
            return this.f2334a.mo474i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setSideColor(int i) {
        try {
            this.f2334a.mo467b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getSideColor() {
        try {
            return this.f2334a.mo477l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f2334a.mo458a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f2334a.mo469d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f2334a.mo462a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f2334a.mo470e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NavigateArrow)) {
            return false;
        }
        try {
            return this.f2334a.mo464a(((NavigateArrow) obj).f2334a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f2334a.mo471f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
