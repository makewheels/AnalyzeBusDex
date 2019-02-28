package com.amap.api.maps.model;

import com.amap.api.mapcore.ah;

public final class TileOverlay {
    /* renamed from: a */
    private ah f2386a;

    public TileOverlay(ah ahVar) {
        this.f2386a = ahVar;
    }

    public void remove() {
        this.f2386a.mo521a();
    }

    public void clearTileCache() {
        this.f2386a.mo526b();
    }

    public String getId() {
        return this.f2386a.mo528c();
    }

    public void setZIndex(float f) {
        this.f2386a.mo522a(f);
    }

    public float getZIndex() {
        return this.f2386a.mo530d();
    }

    public void setVisible(boolean z) {
        this.f2386a.mo524a(z);
    }

    public boolean isVisible() {
        return this.f2386a.mo531e();
    }

    public boolean equals(Object obj) {
        if (obj instanceof TileOverlay) {
            return this.f2386a.mo525a(((TileOverlay) obj).f2386a);
        }
        return false;
    }

    public int hashCode() {
        return this.f2386a.mo532f();
    }
}
