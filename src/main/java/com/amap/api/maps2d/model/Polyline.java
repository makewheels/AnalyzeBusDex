package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.p015a.am;
import java.util.List;

public class Polyline {
    /* renamed from: a */
    private final am f2634a;

    public Polyline(am amVar) {
        this.f2634a = amVar;
    }

    public void remove() {
        try {
            this.f2634a.mo45b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.f2634a.mo47c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.f2634a.mo195a((List) list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<LatLng> getPoints() {
        try {
            return this.f2634a.mo201i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setWidth(float f) {
        try {
            this.f2634a.mo196b(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getWidth() {
        try {
            return this.f2634a.mo199g();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setColor(int i) {
        try {
            this.f2634a.mo194a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getColor() {
        try {
            return this.f2634a.mo200h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float f) {
        try {
            this.f2634a.mo36a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.f2634a.mo49d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f2634a.mo42a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f2634a.mo51e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setGeodesic(boolean z) {
        try {
            if (this.f2634a.mo203k() != z) {
                List points = getPoints();
                this.f2634a.mo198c(z);
                setPoints(points);
            }
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isGeodesic() {
        return this.f2634a.mo203k();
    }

    public void setDottedLine(boolean z) {
        this.f2634a.mo197b(z);
    }

    public boolean isDottedLine() {
        return this.f2634a.mo202j();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.f2634a.mo44a(((Polyline) obj).f2634a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.f2634a.mo52f();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
