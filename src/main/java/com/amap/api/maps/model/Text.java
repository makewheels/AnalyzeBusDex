package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.RemoteException;
import com.amap.api.mapcore.ag;

public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    /* renamed from: a */
    private ag f2371a;

    public Text(ag agVar) {
        this.f2371a = agVar;
    }

    public void remove() {
        try {
            this.f2371a.mo292b();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void destroy() {
        try {
            if (this.f2371a != null) {
                this.f2371a.mo308p();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getId() {
        try {
            return this.f2371a.mo300h();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            this.f2371a.mo282a(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public LatLng getPosition() {
        try {
            return this.f2371a.mo297e();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setText(String str) {
        try {
            this.f2371a.mo517c(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getText() {
        try {
            return this.f2371a.mo512a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setBackgroundColor(int i) {
        try {
            this.f2371a.mo514b(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getBackgroundColor() {
        try {
            return this.f2371a.mo506I();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFontColor(int i) {
        try {
            this.f2371a.mo516c(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFontColor() {
        try {
            return this.f2371a.mo507J();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFontSize(int i) {
        try {
            this.f2371a.mo518d(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getFontSize() {
        try {
            return this.f2371a.mo508K();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setTypeface(Typeface typeface) {
        try {
            this.f2371a.mo513a(typeface);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Typeface getTypeface() {
        try {
            return this.f2371a.mo509L();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setAlign(int i, int i2) {
        try {
            this.f2371a.mo515b(i, i2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getAlignX() {
        try {
            return this.f2371a.mo510M();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getAlignY() {
        try {
            return this.f2371a.mo511N();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean z) {
        try {
            this.f2371a.mo291b(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.f2371a.mo307o();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Text) {
                return this.f2371a.mo288a(((Text) obj).f2371a);
            }
            return false;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        return this.f2371a.mo309q();
    }

    public void setObject(Object obj) {
        this.f2371a.mo283a(obj);
    }

    public Object getObject() {
        return this.f2371a.mo311s();
    }

    public void setRotate(float f) {
        try {
            this.f2371a.mo277a(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getRotate() {
        return this.f2371a.mo313u();
    }

    public void setZIndex(float f) {
        this.f2371a.mo289b(f);
    }

    public float getZIndex() {
        return this.f2371a.mo275G();
    }
}
