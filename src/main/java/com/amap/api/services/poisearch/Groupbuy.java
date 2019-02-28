package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.C0480e;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Groupbuy implements Parcelable {
    public static final Creator<Groupbuy> CREATOR = new C0517d();
    /* renamed from: a */
    private String f3076a;
    /* renamed from: b */
    private String f3077b;
    /* renamed from: c */
    private String f3078c;
    /* renamed from: d */
    private Date f3079d;
    /* renamed from: e */
    private Date f3080e;
    /* renamed from: f */
    private int f3081f;
    /* renamed from: g */
    private int f3082g;
    /* renamed from: h */
    private float f3083h;
    /* renamed from: i */
    private float f3084i;
    /* renamed from: j */
    private float f3085j;
    /* renamed from: k */
    private String f3086k;
    /* renamed from: l */
    private String f3087l;
    /* renamed from: m */
    private List<Photo> f3088m = new ArrayList();
    /* renamed from: n */
    private String f3089n;
    /* renamed from: o */
    private String f3090o;

    public String getTypeCode() {
        return this.f3076a;
    }

    public void setTypeCode(String str) {
        this.f3076a = str;
    }

    public String getTypeDes() {
        return this.f3077b;
    }

    public void setTypeDes(String str) {
        this.f3077b = str;
    }

    public String getDetail() {
        return this.f3078c;
    }

    public void setDetail(String str) {
        this.f3078c = str;
    }

    public Date getStartTime() {
        if (this.f3079d == null) {
            return null;
        }
        return (Date) this.f3079d.clone();
    }

    public void setStartTime(Date date) {
        if (date == null) {
            this.f3079d = null;
        } else {
            this.f3079d = (Date) date.clone();
        }
    }

    public Date getEndTime() {
        if (this.f3080e == null) {
            return null;
        }
        return (Date) this.f3080e.clone();
    }

    public void setEndTime(Date date) {
        if (date == null) {
            this.f3080e = null;
        } else {
            this.f3080e = (Date) date.clone();
        }
    }

    public int getCount() {
        return this.f3081f;
    }

    public void setCount(int i) {
        this.f3081f = i;
    }

    public int getSoldCount() {
        return this.f3082g;
    }

    public void setSoldCount(int i) {
        this.f3082g = i;
    }

    public float getOriginalPrice() {
        return this.f3083h;
    }

    public void setOriginalPrice(float f) {
        this.f3083h = f;
    }

    public float getGroupbuyPrice() {
        return this.f3084i;
    }

    public void setGroupbuyPrice(float f) {
        this.f3084i = f;
    }

    public float getDiscount() {
        return this.f3085j;
    }

    public void setDiscount(float f) {
        this.f3085j = f;
    }

    public String getTicketAddress() {
        return this.f3086k;
    }

    public void setTicketAddress(String str) {
        this.f3086k = str;
    }

    public String getTicketTel() {
        return this.f3087l;
    }

    public void setTicketTel(String str) {
        this.f3087l = str;
    }

    public List<Photo> getPhotos() {
        return this.f3088m;
    }

    public void addPhotos(Photo photo) {
        this.f3088m.add(photo);
    }

    public void initPhotos(List<Photo> list) {
        if (list != null && list.size() != 0) {
            this.f3088m.clear();
            for (Photo add : list) {
                this.f3088m.add(add);
            }
        }
    }

    public String getUrl() {
        return this.f3089n;
    }

    public void setUrl(String str) {
        this.f3089n = str;
    }

    public String getProvider() {
        return this.f3090o;
    }

    public void setProvider(String str) {
        this.f3090o = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3076a);
        parcel.writeString(this.f3077b);
        parcel.writeString(this.f3078c);
        parcel.writeString(C0480e.m4016a(this.f3079d));
        parcel.writeString(C0480e.m4016a(this.f3080e));
        parcel.writeInt(this.f3081f);
        parcel.writeInt(this.f3082g);
        parcel.writeFloat(this.f3083h);
        parcel.writeFloat(this.f3084i);
        parcel.writeFloat(this.f3085j);
        parcel.writeString(this.f3086k);
        parcel.writeString(this.f3087l);
        parcel.writeTypedList(this.f3088m);
        parcel.writeString(this.f3089n);
        parcel.writeString(this.f3090o);
    }

    public Groupbuy(Parcel parcel) {
        this.f3076a = parcel.readString();
        this.f3077b = parcel.readString();
        this.f3078c = parcel.readString();
        this.f3079d = C0480e.m4028e(parcel.readString());
        this.f3080e = C0480e.m4028e(parcel.readString());
        this.f3081f = parcel.readInt();
        this.f3082g = parcel.readInt();
        this.f3083h = parcel.readFloat();
        this.f3084i = parcel.readFloat();
        this.f3085j = parcel.readFloat();
        this.f3086k = parcel.readString();
        this.f3087l = parcel.readString();
        this.f3088m = parcel.createTypedArrayList(Photo.CREATOR);
        this.f3089n = parcel.readString();
        this.f3090o = parcel.readString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3077b == null ? 0 : this.f3077b.hashCode()) + (((this.f3076a == null ? 0 : this.f3076a.hashCode()) + (((this.f3087l == null ? 0 : this.f3087l.hashCode()) + (((this.f3086k == null ? 0 : this.f3086k.hashCode()) + (((this.f3079d == null ? 0 : this.f3079d.hashCode()) + (((((this.f3090o == null ? 0 : this.f3090o.hashCode()) + (((this.f3088m == null ? 0 : this.f3088m.hashCode()) + (((((((this.f3080e == null ? 0 : this.f3080e.hashCode()) + (((((this.f3078c == null ? 0 : this.f3078c.hashCode()) + ((this.f3081f + 31) * 31)) * 31) + Float.floatToIntBits(this.f3085j)) * 31)) * 31) + Float.floatToIntBits(this.f3084i)) * 31) + Float.floatToIntBits(this.f3083h)) * 31)) * 31)) * 31) + this.f3082g) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3089n != null) {
            i = this.f3089n.hashCode();
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
        Groupbuy groupbuy = (Groupbuy) obj;
        if (this.f3081f != groupbuy.f3081f) {
            return false;
        }
        if (this.f3078c == null) {
            if (groupbuy.f3078c != null) {
                return false;
            }
        } else if (!this.f3078c.equals(groupbuy.f3078c)) {
            return false;
        }
        if (Float.floatToIntBits(this.f3085j) != Float.floatToIntBits(groupbuy.f3085j)) {
            return false;
        }
        if (this.f3080e == null) {
            if (groupbuy.f3080e != null) {
                return false;
            }
        } else if (!this.f3080e.equals(groupbuy.f3080e)) {
            return false;
        }
        if (Float.floatToIntBits(this.f3084i) != Float.floatToIntBits(groupbuy.f3084i)) {
            return false;
        }
        if (Float.floatToIntBits(this.f3083h) != Float.floatToIntBits(groupbuy.f3083h)) {
            return false;
        }
        if (this.f3088m == null) {
            if (groupbuy.f3088m != null) {
                return false;
            }
        } else if (!this.f3088m.equals(groupbuy.f3088m)) {
            return false;
        }
        if (this.f3090o == null) {
            if (groupbuy.f3090o != null) {
                return false;
            }
        } else if (!this.f3090o.equals(groupbuy.f3090o)) {
            return false;
        }
        if (this.f3082g != groupbuy.f3082g) {
            return false;
        }
        if (this.f3079d == null) {
            if (groupbuy.f3079d != null) {
                return false;
            }
        } else if (!this.f3079d.equals(groupbuy.f3079d)) {
            return false;
        }
        if (this.f3086k == null) {
            if (groupbuy.f3086k != null) {
                return false;
            }
        } else if (!this.f3086k.equals(groupbuy.f3086k)) {
            return false;
        }
        if (this.f3087l == null) {
            if (groupbuy.f3087l != null) {
                return false;
            }
        } else if (!this.f3087l.equals(groupbuy.f3087l)) {
            return false;
        }
        if (this.f3076a == null) {
            if (groupbuy.f3076a != null) {
                return false;
            }
        } else if (!this.f3076a.equals(groupbuy.f3076a)) {
            return false;
        }
        if (this.f3077b == null) {
            if (groupbuy.f3077b != null) {
                return false;
            }
        } else if (!this.f3077b.equals(groupbuy.f3077b)) {
            return false;
        }
        if (this.f3089n == null) {
            if (groupbuy.f3089n != null) {
                return false;
            }
            return true;
        } else if (this.f3089n.equals(groupbuy.f3089n)) {
            return true;
        } else {
            return false;
        }
    }
}
