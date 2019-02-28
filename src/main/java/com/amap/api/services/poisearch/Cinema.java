package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class Cinema implements Parcelable {
    public static final Creator<Cinema> CREATOR = new C0514a();
    /* renamed from: a */
    private boolean f3040a;
    /* renamed from: b */
    private String f3041b;
    /* renamed from: c */
    private String f3042c;
    /* renamed from: d */
    private String f3043d;
    /* renamed from: e */
    private String f3044e;
    /* renamed from: f */
    private String f3045f;
    /* renamed from: g */
    private String f3046g;
    /* renamed from: h */
    private List<Photo> f3047h;

    public boolean isSeatOrdering() {
        return this.f3040a;
    }

    public void setSeatOrdering(boolean z) {
        this.f3040a = z;
    }

    public String getIntro() {
        return this.f3041b;
    }

    public void setIntro(String str) {
        this.f3041b = str;
    }

    public String getRating() {
        return this.f3042c;
    }

    public void setRating(String str) {
        this.f3042c = str;
    }

    public String getDeepsrc() {
        return this.f3043d;
    }

    public void setDeepsrc(String str) {
        this.f3043d = str;
    }

    public String getParking() {
        return this.f3044e;
    }

    public void setParking(String str) {
        this.f3044e = str;
    }

    public String getOpentimeGDF() {
        return this.f3045f;
    }

    public void setOpentimeGDF(String str) {
        this.f3045f = str;
    }

    public String getOpentime() {
        return this.f3046g;
    }

    public void setOpentime(String str) {
        this.f3046g = str;
    }

    public List<Photo> getPhotos() {
        return this.f3047h;
    }

    public void setPhotos(List<Photo> list) {
        this.f3047h = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f3040a});
        parcel.writeString(this.f3041b);
        parcel.writeString(this.f3042c);
        parcel.writeString(this.f3043d);
        parcel.writeString(this.f3044e);
        parcel.writeString(this.f3045f);
        parcel.writeString(this.f3046g);
        parcel.writeTypedList(this.f3047h);
    }

    public Cinema(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f3040a = zArr[0];
        this.f3041b = parcel.readString();
        this.f3042c = parcel.readString();
        this.f3043d = parcel.readString();
        this.f3044e = parcel.readString();
        this.f3045f = parcel.readString();
        this.f3046g = parcel.readString();
        this.f3047h = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3047h == null ? 0 : this.f3047h.hashCode()) + (((this.f3044e == null ? 0 : this.f3044e.hashCode()) + (((this.f3045f == null ? 0 : this.f3045f.hashCode()) + (((this.f3046g == null ? 0 : this.f3046g.hashCode()) + (((this.f3041b == null ? 0 : this.f3041b.hashCode()) + (((this.f3043d == null ? 0 : this.f3043d.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3042c != null) {
            i = this.f3042c.hashCode();
        }
        return (this.f3040a ? 1231 : 1237) + ((hashCode + i) * 31);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cinema cinema = (Cinema) obj;
        if (this.f3043d == null) {
            if (cinema.f3043d != null) {
                return false;
            }
        } else if (!this.f3043d.equals(cinema.f3043d)) {
            return false;
        }
        if (this.f3041b == null) {
            if (cinema.f3041b != null) {
                return false;
            }
        } else if (!this.f3041b.equals(cinema.f3041b)) {
            return false;
        }
        if (this.f3046g == null) {
            if (cinema.f3046g != null) {
                return false;
            }
        } else if (!this.f3046g.equals(cinema.f3046g)) {
            return false;
        }
        if (this.f3045f == null) {
            if (cinema.f3045f != null) {
                return false;
            }
        } else if (!this.f3045f.equals(cinema.f3045f)) {
            return false;
        }
        if (this.f3044e == null) {
            if (cinema.f3044e != null) {
                return false;
            }
        } else if (!this.f3044e.equals(cinema.f3044e)) {
            return false;
        }
        if (this.f3047h == null) {
            if (cinema.f3047h != null) {
                return false;
            }
        } else if (!this.f3047h.equals(cinema.f3047h)) {
            return false;
        }
        if (this.f3042c == null) {
            if (cinema.f3042c != null) {
                return false;
            }
        } else if (!this.f3042c.equals(cinema.f3042c)) {
            return false;
        }
        if (this.f3040a != cinema.f3040a) {
            return false;
        }
        return true;
    }
}
