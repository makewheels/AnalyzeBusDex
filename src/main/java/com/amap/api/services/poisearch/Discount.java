package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.C0480e;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Discount implements Parcelable {
    public static final Creator<Discount> CREATOR = new C0516c();
    /* renamed from: a */
    private String f3068a;
    /* renamed from: b */
    private String f3069b;
    /* renamed from: c */
    private Date f3070c;
    /* renamed from: d */
    private Date f3071d;
    /* renamed from: e */
    private int f3072e;
    /* renamed from: f */
    private List<Photo> f3073f = new ArrayList();
    /* renamed from: g */
    private String f3074g;
    /* renamed from: h */
    private String f3075h;

    public String getTitle() {
        return this.f3068a;
    }

    public void setTitle(String str) {
        this.f3068a = str;
    }

    public String getDetail() {
        return this.f3069b;
    }

    public void setDetail(String str) {
        this.f3069b = str;
    }

    public Date getStartTime() {
        if (this.f3070c == null) {
            return null;
        }
        return (Date) this.f3070c.clone();
    }

    public void setStartTime(Date date) {
        if (date == null) {
            this.f3070c = null;
        } else {
            this.f3070c = (Date) date.clone();
        }
    }

    public Date getEndTime() {
        if (this.f3071d == null) {
            return null;
        }
        return (Date) this.f3071d.clone();
    }

    public void setEndTime(Date date) {
        if (date == null) {
            this.f3071d = null;
        } else {
            this.f3071d = (Date) date.clone();
        }
    }

    public int getSoldCount() {
        return this.f3072e;
    }

    public void setSoldCount(int i) {
        this.f3072e = i;
    }

    public List<Photo> getPhotos() {
        return this.f3073f;
    }

    public void addPhotos(Photo photo) {
        this.f3073f.add(photo);
    }

    public void initPhotos(List<Photo> list) {
        if (list != null && list.size() != 0) {
            this.f3073f.clear();
            for (Photo add : list) {
                this.f3073f.add(add);
            }
        }
    }

    public String getUrl() {
        return this.f3074g;
    }

    public void setUrl(String str) {
        this.f3074g = str;
    }

    public String getProvider() {
        return this.f3075h;
    }

    public void setProvider(String str) {
        this.f3075h = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3068a);
        parcel.writeString(this.f3069b);
        parcel.writeString(C0480e.m4016a(this.f3070c));
        parcel.writeString(C0480e.m4016a(this.f3071d));
        parcel.writeInt(this.f3072e);
        parcel.writeTypedList(this.f3073f);
        parcel.writeString(this.f3074g);
        parcel.writeString(this.f3075h);
    }

    public Discount(Parcel parcel) {
        this.f3068a = parcel.readString();
        this.f3069b = parcel.readString();
        this.f3070c = C0480e.m4028e(parcel.readString());
        this.f3071d = C0480e.m4028e(parcel.readString());
        this.f3072e = parcel.readInt();
        this.f3073f = parcel.createTypedArrayList(Photo.CREATOR);
        this.f3074g = parcel.readString();
        this.f3075h = parcel.readString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3068a == null ? 0 : this.f3068a.hashCode()) + (((this.f3070c == null ? 0 : this.f3070c.hashCode()) + (((((this.f3075h == null ? 0 : this.f3075h.hashCode()) + (((this.f3073f == null ? 0 : this.f3073f.hashCode()) + (((this.f3071d == null ? 0 : this.f3071d.hashCode()) + (((this.f3069b == null ? 0 : this.f3069b.hashCode()) + 31) * 31)) * 31)) * 31)) * 31) + this.f3072e) * 31)) * 31)) * 31;
        if (this.f3074g != null) {
            i = this.f3074g.hashCode();
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
        Discount discount = (Discount) obj;
        if (this.f3069b == null) {
            if (discount.f3069b != null) {
                return false;
            }
        } else if (!this.f3069b.equals(discount.f3069b)) {
            return false;
        }
        if (this.f3071d == null) {
            if (discount.f3071d != null) {
                return false;
            }
        } else if (!this.f3071d.equals(discount.f3071d)) {
            return false;
        }
        if (this.f3073f == null) {
            if (discount.f3073f != null) {
                return false;
            }
        } else if (!this.f3073f.equals(discount.f3073f)) {
            return false;
        }
        if (this.f3075h == null) {
            if (discount.f3075h != null) {
                return false;
            }
        } else if (!this.f3075h.equals(discount.f3075h)) {
            return false;
        }
        if (this.f3072e != discount.f3072e) {
            return false;
        }
        if (this.f3070c == null) {
            if (discount.f3070c != null) {
                return false;
            }
        } else if (!this.f3070c.equals(discount.f3070c)) {
            return false;
        }
        if (this.f3068a == null) {
            if (discount.f3068a != null) {
                return false;
            }
        } else if (!this.f3068a.equals(discount.f3068a)) {
            return false;
        }
        if (this.f3074g == null) {
            if (discount.f3074g != null) {
                return false;
            }
            return true;
        } else if (this.f3074g.equals(discount.f3074g)) {
            return true;
        } else {
            return false;
        }
    }
}
