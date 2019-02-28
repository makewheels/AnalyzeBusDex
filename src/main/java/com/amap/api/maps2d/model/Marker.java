package com.amap.api.maps2d.model;

import android.os.RemoteException;
import com.amap.api.p015a.aj;
import java.util.ArrayList;

public final class Marker {
    /* renamed from: a */
    aj f2604a;

    public Marker(aj ajVar) {
        this.f2604a = ajVar;
    }

    public void setPeriod(int i) {
        try {
            this.f2604a.mo151a(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getPeriod() {
        try {
            return this.f2604a.mo180r();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.f2604a.mo157a((ArrayList) arrayList);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.f2604a.mo181s();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.f2604a.mo159a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.f2604a != null) {
                this.f2604a.mo176n();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return this.f2604a.mo167e();
    }

    public void setPosition(LatLng latLng) {
        this.f2604a.mo154a(latLng);
    }

    public LatLng getPosition() {
        return this.f2604a.mo165c();
    }

    public void setTitle(String str) {
        this.f2604a.mo156a(str);
    }

    public String getTitle() {
        return this.f2604a.mo169g();
    }

    public void setSnippet(String str) {
        this.f2604a.mo163b(str);
    }

    public String getSnippet() {
        return this.f2604a.mo170h();
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.f2604a.mo153a(bitmapDescriptor);
        }
    }

    public void setAnchor(float f, float f2) {
        this.f2604a.mo150a(f, f2);
    }

    public void setDraggable(boolean z) {
        this.f2604a.mo158a(z);
    }

    public boolean isDraggable() {
        return this.f2604a.mo171i();
    }

    public void showInfoWindow() {
        this.f2604a.mo172j();
    }

    public void hideInfoWindow() {
        this.f2604a.mo173k();
    }

    public boolean isInfoWindowShown() {
        return this.f2604a.mo174l();
    }

    public void setVisible(boolean z) {
        this.f2604a.mo164b(z);
    }

    public boolean isVisible() {
        return this.f2604a.mo175m();
    }

    public void setRotateAngle(float f) {
        try {
            this.f2604a.mo149a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Marker) {
            return this.f2604a.mo160a(((Marker) obj).f2604a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2604a.mo177o();
    }

    public void setObject(Object obj) {
        this.f2604a.mo155a(obj);
    }

    public Object getObject() {
        return this.f2604a.mo178p();
    }
}
