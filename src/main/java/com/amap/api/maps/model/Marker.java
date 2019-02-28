package com.amap.api.maps.model;

import android.os.RemoteException;
import com.amap.api.mapcore.C0294z;
import java.util.ArrayList;

public final class Marker {
    /* renamed from: a */
    private C0294z f2305a;

    public Marker(C0294z c0294z) {
        this.f2305a = c0294z;
    }

    public void setPeriod(int i) {
        try {
            this.f2305a.mo279a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getPeriod() {
        try {
            return this.f2305a.mo314v();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.f2305a.mo285a((ArrayList) arrayList);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.f2305a.mo315w();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.f2305a.mo292b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.f2305a != null) {
                this.f2305a.mo308p();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getId() {
        try {
            return this.f2305a.mo300h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPerspective(boolean z) {
        try {
            this.f2305a.mo293c(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isPerspective() {
        try {
            return this.f2305a.mo312t();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f2305a.mo282a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.f2305a.mo297e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTitle(String str) {
        try {
            this.f2305a.mo284a(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getTitle() {
        try {
            return this.f2305a.mo301i();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setSnippet(String str) {
        try {
            this.f2305a.mo290b(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getSnippet() {
        try {
            return this.f2305a.mo302j();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                this.f2305a.mo281a(bitmapDescriptor);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public void setAnchor(float f, float f2) {
        try {
            this.f2305a.mo278a(f, f2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setDraggable(boolean z) {
        try {
            this.f2305a.mo287a(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isDraggable() {
        return this.f2305a.mo303k();
    }

    public void showInfoWindow() {
        try {
            this.f2305a.mo304l();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void hideInfoWindow() {
        try {
            this.f2305a.mo305m();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isInfoWindowShown() {
        return this.f2305a.mo306n();
    }

    public void setVisible(boolean z) {
        try {
            this.f2305a.mo291b(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f2305a.mo307o();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Marker) {
                return this.f2305a.mo288a(((Marker) obj).f2305a);
            }
            return false;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        return this.f2305a.mo309q();
    }

    public void setObject(Object obj) {
        this.f2305a.mo283a(obj);
    }

    public Object getObject() {
        return this.f2305a.mo311s();
    }

    public void setRotateAngle(float f) {
        try {
            this.f2305a.mo277a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getRotateAngle() {
        return this.f2305a.mo313u();
    }

    public void setToTop() {
        try {
            this.f2305a.mo318z();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFlat(boolean z) {
        try {
            this.f2305a.mo296d(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isFlat() {
        return this.f2305a.mo269A();
    }

    public void setPositionByPixels(int i, int i2) {
        this.f2305a.mo280a(i, i2);
    }

    public void setZIndex(float f) {
        this.f2305a.mo289b(f);
    }

    public float getZIndex() {
        return this.f2305a.mo275G();
    }
}
