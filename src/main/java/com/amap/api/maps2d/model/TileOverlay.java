package com.amap.api.maps2d.model;

import com.amap.api.p015a.ap;

public final class TileOverlay {
    /* renamed from: a */
    private ap f2644a;

    public TileOverlay(ap apVar) {
        this.f2644a = apVar;
    }

    public void remove() {
        this.f2644a.mo209a();
    }

    public void clearTileCache() {
        this.f2644a.mo214b();
    }

    public String getId() {
        return this.f2644a.mo216c();
    }

    public void setZIndex(float f) {
        this.f2644a.mo210a(f);
    }

    public float getZIndex() {
        return this.f2644a.mo217d();
    }

    public void setVisible(boolean z) {
        this.f2644a.mo212a(z);
    }

    public boolean isVisible() {
        return this.f2644a.mo218e();
    }

    public boolean equals(Object obj) {
        return this.f2644a.mo213a(this.f2644a);
    }

    public int hashCode() {
        return this.f2644a.mo219f();
    }
}
