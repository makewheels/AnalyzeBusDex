package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class Scenic implements Parcelable {
    public static final Creator<Scenic> CREATOR = new C0522i();
    /* renamed from: a */
    private String f3142a;
    /* renamed from: b */
    private String f3143b;
    /* renamed from: c */
    private String f3144c;
    /* renamed from: d */
    private String f3145d;
    /* renamed from: e */
    private String f3146e;
    /* renamed from: f */
    private String f3147f;
    /* renamed from: g */
    private String f3148g;
    /* renamed from: h */
    private String f3149h;
    /* renamed from: i */
    private String f3150i;
    /* renamed from: j */
    private String f3151j;
    /* renamed from: k */
    private String f3152k;
    /* renamed from: l */
    private String f3153l;
    /* renamed from: m */
    private List<Photo> f3154m;

    public String getIntro() {
        return this.f3142a;
    }

    public void setIntro(String str) {
        this.f3142a = str;
    }

    public String getRating() {
        return this.f3143b;
    }

    public void setRating(String str) {
        this.f3143b = str;
    }

    public String getDeepsrc() {
        return this.f3144c;
    }

    public void setDeepsrc(String str) {
        this.f3144c = str;
    }

    public String getLevel() {
        return this.f3145d;
    }

    public void setLevel(String str) {
        this.f3145d = str;
    }

    public String getPrice() {
        return this.f3146e;
    }

    public void setPrice(String str) {
        this.f3146e = str;
    }

    public String getSeason() {
        return this.f3147f;
    }

    public void setSeason(String str) {
        this.f3147f = str;
    }

    public String getRecommend() {
        return this.f3148g;
    }

    public void setRecommend(String str) {
        this.f3148g = str;
    }

    public String getTheme() {
        return this.f3149h;
    }

    public void setTheme(String str) {
        this.f3149h = str;
    }

    public String getOrderWapUrl() {
        return this.f3150i;
    }

    public void setOrderWapUrl(String str) {
        this.f3150i = str;
    }

    public String getOrderWebUrl() {
        return this.f3151j;
    }

    public void setOrderWebUrl(String str) {
        this.f3151j = str;
    }

    public String getOpentimeGDF() {
        return this.f3152k;
    }

    public void setOpentimeGDF(String str) {
        this.f3152k = str;
    }

    public String getOpentime() {
        return this.f3153l;
    }

    public void setOpentime(String str) {
        this.f3153l = str;
    }

    public List<Photo> getPhotos() {
        return this.f3154m;
    }

    public void setPhotos(List<Photo> list) {
        this.f3154m = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3142a);
        parcel.writeString(this.f3143b);
        parcel.writeString(this.f3144c);
        parcel.writeString(this.f3145d);
        parcel.writeString(this.f3146e);
        parcel.writeString(this.f3147f);
        parcel.writeString(this.f3148g);
        parcel.writeString(this.f3149h);
        parcel.writeString(this.f3150i);
        parcel.writeString(this.f3151j);
        parcel.writeString(this.f3152k);
        parcel.writeString(this.f3153l);
        parcel.writeTypedList(this.f3154m);
    }

    public Scenic(Parcel parcel) {
        this.f3142a = parcel.readString();
        this.f3143b = parcel.readString();
        this.f3144c = parcel.readString();
        this.f3145d = parcel.readString();
        this.f3146e = parcel.readString();
        this.f3147f = parcel.readString();
        this.f3148g = parcel.readString();
        this.f3149h = parcel.readString();
        this.f3150i = parcel.readString();
        this.f3151j = parcel.readString();
        this.f3152k = parcel.readString();
        this.f3153l = parcel.readString();
        this.f3154m = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3147f == null ? 0 : this.f3147f.hashCode()) + (((this.f3148g == null ? 0 : this.f3148g.hashCode()) + (((this.f3143b == null ? 0 : this.f3143b.hashCode()) + (((this.f3146e == null ? 0 : this.f3146e.hashCode()) + (((this.f3154m == null ? 0 : this.f3154m.hashCode()) + (((this.f3151j == null ? 0 : this.f3151j.hashCode()) + (((this.f3150i == null ? 0 : this.f3150i.hashCode()) + (((this.f3152k == null ? 0 : this.f3152k.hashCode()) + (((this.f3153l == null ? 0 : this.f3153l.hashCode()) + (((this.f3145d == null ? 0 : this.f3145d.hashCode()) + (((this.f3142a == null ? 0 : this.f3142a.hashCode()) + (((this.f3144c == null ? 0 : this.f3144c.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3149h != null) {
            i = this.f3149h.hashCode();
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
        Scenic scenic = (Scenic) obj;
        if (this.f3144c == null) {
            if (scenic.f3144c != null) {
                return false;
            }
        } else if (!this.f3144c.equals(scenic.f3144c)) {
            return false;
        }
        if (this.f3142a == null) {
            if (scenic.f3142a != null) {
                return false;
            }
        } else if (!this.f3142a.equals(scenic.f3142a)) {
            return false;
        }
        if (this.f3145d == null) {
            if (scenic.f3145d != null) {
                return false;
            }
        } else if (!this.f3145d.equals(scenic.f3145d)) {
            return false;
        }
        if (this.f3153l == null) {
            if (scenic.f3153l != null) {
                return false;
            }
        } else if (!this.f3153l.equals(scenic.f3153l)) {
            return false;
        }
        if (this.f3152k == null) {
            if (scenic.f3152k != null) {
                return false;
            }
        } else if (!this.f3152k.equals(scenic.f3152k)) {
            return false;
        }
        if (this.f3150i == null) {
            if (scenic.f3150i != null) {
                return false;
            }
        } else if (!this.f3150i.equals(scenic.f3150i)) {
            return false;
        }
        if (this.f3151j == null) {
            if (scenic.f3151j != null) {
                return false;
            }
        } else if (!this.f3151j.equals(scenic.f3151j)) {
            return false;
        }
        if (this.f3154m == null) {
            if (scenic.f3154m != null) {
                return false;
            }
        } else if (!this.f3154m.equals(scenic.f3154m)) {
            return false;
        }
        if (this.f3146e == null) {
            if (scenic.f3146e != null) {
                return false;
            }
        } else if (!this.f3146e.equals(scenic.f3146e)) {
            return false;
        }
        if (this.f3143b == null) {
            if (scenic.f3143b != null) {
                return false;
            }
        } else if (!this.f3143b.equals(scenic.f3143b)) {
            return false;
        }
        if (this.f3148g == null) {
            if (scenic.f3148g != null) {
                return false;
            }
        } else if (!this.f3148g.equals(scenic.f3148g)) {
            return false;
        }
        if (this.f3147f == null) {
            if (scenic.f3147f != null) {
                return false;
            }
        } else if (!this.f3147f.equals(scenic.f3147f)) {
            return false;
        }
        if (this.f3149h == null) {
            if (scenic.f3149h != null) {
                return false;
            }
            return true;
        } else if (this.f3149h.equals(scenic.f3149h)) {
            return true;
        } else {
            return false;
        }
    }
}
