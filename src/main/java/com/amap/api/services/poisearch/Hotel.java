package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class Hotel implements Parcelable {
    public static final Creator<Hotel> CREATOR = new C0518e();
    /* renamed from: a */
    private String f3091a;
    /* renamed from: b */
    private String f3092b;
    /* renamed from: c */
    private String f3093c;
    /* renamed from: d */
    private String f3094d;
    /* renamed from: e */
    private String f3095e;
    /* renamed from: f */
    private String f3096f;
    /* renamed from: g */
    private String f3097g;
    /* renamed from: h */
    private String f3098h;
    /* renamed from: i */
    private String f3099i;
    /* renamed from: j */
    private String f3100j;
    /* renamed from: k */
    private String f3101k;
    /* renamed from: l */
    private List<Photo> f3102l;

    public String getRating() {
        return this.f3091a;
    }

    public void setRating(String str) {
        this.f3091a = str;
    }

    public String getStar() {
        return this.f3092b;
    }

    public void setStar(String str) {
        this.f3092b = str;
    }

    public String getIntro() {
        return this.f3093c;
    }

    public void setIntro(String str) {
        this.f3093c = str;
    }

    public String getLowestPrice() {
        return this.f3094d;
    }

    public void setLowestPrice(String str) {
        this.f3094d = str;
    }

    public String getFaciRating() {
        return this.f3095e;
    }

    public void setFaciRating(String str) {
        this.f3095e = str;
    }

    public String getHealthRating() {
        return this.f3096f;
    }

    public void setHealthRating(String str) {
        this.f3096f = str;
    }

    public String getEnvironmentRating() {
        return this.f3097g;
    }

    public void setEnvironmentRating(String str) {
        this.f3097g = str;
    }

    public String getServiceRating() {
        return this.f3098h;
    }

    public void setServiceRating(String str) {
        this.f3098h = str;
    }

    public String getTraffic() {
        return this.f3099i;
    }

    public void setTraffic(String str) {
        this.f3099i = str;
    }

    public String getAddition() {
        return this.f3100j;
    }

    public void setAddition(String str) {
        this.f3100j = str;
    }

    public String getDeepsrc() {
        return this.f3101k;
    }

    public void setDeepsrc(String str) {
        this.f3101k = str;
    }

    public List<Photo> getPhotos() {
        return this.f3102l;
    }

    public void setPhotos(List<Photo> list) {
        this.f3102l = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3091a);
        parcel.writeString(this.f3092b);
        parcel.writeString(this.f3093c);
        parcel.writeString(this.f3094d);
        parcel.writeString(this.f3095e);
        parcel.writeString(this.f3096f);
        parcel.writeString(this.f3097g);
        parcel.writeString(this.f3098h);
        parcel.writeString(this.f3099i);
        parcel.writeString(this.f3100j);
        parcel.writeString(this.f3101k);
        parcel.writeTypedList(this.f3102l);
    }

    public Hotel(Parcel parcel) {
        this.f3091a = parcel.readString();
        this.f3092b = parcel.readString();
        this.f3093c = parcel.readString();
        this.f3094d = parcel.readString();
        this.f3095e = parcel.readString();
        this.f3096f = parcel.readString();
        this.f3097g = parcel.readString();
        this.f3098h = parcel.readString();
        this.f3099i = parcel.readString();
        this.f3100j = parcel.readString();
        this.f3101k = parcel.readString();
        this.f3102l = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3092b == null ? 0 : this.f3092b.hashCode()) + (((this.f3098h == null ? 0 : this.f3098h.hashCode()) + (((this.f3091a == null ? 0 : this.f3091a.hashCode()) + (((this.f3102l == null ? 0 : this.f3102l.hashCode()) + (((this.f3094d == null ? 0 : this.f3094d.hashCode()) + (((this.f3093c == null ? 0 : this.f3093c.hashCode()) + (((this.f3096f == null ? 0 : this.f3096f.hashCode()) + (((this.f3095e == null ? 0 : this.f3095e.hashCode()) + (((this.f3097g == null ? 0 : this.f3097g.hashCode()) + (((this.f3101k == null ? 0 : this.f3101k.hashCode()) + (((this.f3100j == null ? 0 : this.f3100j.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3099i != null) {
            i = this.f3099i.hashCode();
        }
        return hashCode + i;
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
        Hotel hotel = (Hotel) obj;
        if (this.f3100j == null) {
            if (hotel.f3100j != null) {
                return false;
            }
        } else if (!this.f3100j.equals(hotel.f3100j)) {
            return false;
        }
        if (this.f3101k == null) {
            if (hotel.f3101k != null) {
                return false;
            }
        } else if (!this.f3101k.equals(hotel.f3101k)) {
            return false;
        }
        if (this.f3097g == null) {
            if (hotel.f3097g != null) {
                return false;
            }
        } else if (!this.f3097g.equals(hotel.f3097g)) {
            return false;
        }
        if (this.f3095e == null) {
            if (hotel.f3095e != null) {
                return false;
            }
        } else if (!this.f3095e.equals(hotel.f3095e)) {
            return false;
        }
        if (this.f3096f == null) {
            if (hotel.f3096f != null) {
                return false;
            }
        } else if (!this.f3096f.equals(hotel.f3096f)) {
            return false;
        }
        if (this.f3093c == null) {
            if (hotel.f3093c != null) {
                return false;
            }
        } else if (!this.f3093c.equals(hotel.f3093c)) {
            return false;
        }
        if (this.f3094d == null) {
            if (hotel.f3094d != null) {
                return false;
            }
        } else if (!this.f3094d.equals(hotel.f3094d)) {
            return false;
        }
        if (this.f3102l == null) {
            if (hotel.f3102l != null) {
                return false;
            }
        } else if (!this.f3102l.equals(hotel.f3102l)) {
            return false;
        }
        if (this.f3091a == null) {
            if (hotel.f3091a != null) {
                return false;
            }
        } else if (!this.f3091a.equals(hotel.f3091a)) {
            return false;
        }
        if (this.f3098h == null) {
            if (hotel.f3098h != null) {
                return false;
            }
        } else if (!this.f3098h.equals(hotel.f3098h)) {
            return false;
        }
        if (this.f3092b == null) {
            if (hotel.f3092b != null) {
                return false;
            }
        } else if (!this.f3092b.equals(hotel.f3092b)) {
            return false;
        }
        if (this.f3099i == null) {
            if (hotel.f3099i != null) {
                return false;
            }
            return true;
        } else if (this.f3099i.equals(hotel.f3099i)) {
            return true;
        } else {
            return false;
        }
    }
}
