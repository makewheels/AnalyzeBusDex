package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import java.util.ArrayList;
import java.util.List;

public class PoiItemDetail extends PoiItem implements Parcelable {
    public static final Creator<PoiItemDetail> CREATOR = new C0520g();
    /* renamed from: a */
    private List<Groupbuy> f3106a;
    /* renamed from: b */
    private List<Discount> f3107b;
    /* renamed from: c */
    private Dining f3108c;
    /* renamed from: d */
    private Hotel f3109d;
    /* renamed from: e */
    private Cinema f3110e;
    /* renamed from: f */
    private Scenic f3111f;
    /* renamed from: g */
    private DeepType f3112g;

    public enum DeepType {
        UNKNOWN,
        DINING,
        HOTEL,
        CINEMA,
        SCENIC
    }

    public PoiItemDetail(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
        this.f3106a = new ArrayList();
        this.f3107b = new ArrayList();
    }

    public List<Groupbuy> getGroupbuys() {
        return this.f3106a;
    }

    public void initGroupbuys(List<Groupbuy> list) {
        if (list != null && list.size() != 0) {
            for (Groupbuy add : list) {
                this.f3106a.add(add);
            }
        }
    }

    public void addGroupbuy(Groupbuy groupbuy) {
        this.f3106a.add(groupbuy);
    }

    public List<Discount> getDiscounts() {
        return this.f3107b;
    }

    public void initDiscounts(List<Discount> list) {
        if (list != null && list.size() != 0) {
            this.f3107b.clear();
            for (Discount add : list) {
                this.f3107b.add(add);
            }
        }
    }

    public void addDiscount(Discount discount) {
        this.f3107b.add(discount);
    }

    public DeepType getDeepType() {
        return this.f3112g;
    }

    public void setDeepType(DeepType deepType) {
        this.f3112g = deepType;
    }

    public Dining getDining() {
        return this.f3108c;
    }

    public void setDining(Dining dining) {
        this.f3108c = dining;
    }

    public Hotel getHotel() {
        return this.f3109d;
    }

    public void setHotel(Hotel hotel) {
        this.f3109d = hotel;
    }

    public Cinema getCinema() {
        return this.f3110e;
    }

    public void setCinema(Cinema cinema) {
        this.f3110e = cinema;
    }

    public Scenic getScenic() {
        return this.f3111f;
    }

    public void setScenic(Scenic scenic) {
        this.f3111f = scenic;
    }

    private PoiItemDetail(Parcel parcel) {
        super(parcel);
        this.f3106a = new ArrayList();
        this.f3107b = new ArrayList();
        this.f3106a = parcel.readArrayList(Groupbuy.class.getClassLoader());
        this.f3107b = parcel.readArrayList(Discount.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.f3106a);
        parcel.writeList(this.f3107b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3109d == null ? 0 : this.f3109d.hashCode()) + (((this.f3106a == null ? 0 : this.f3106a.hashCode()) + (((this.f3107b == null ? 0 : this.f3107b.hashCode()) + (((this.f3108c == null ? 0 : this.f3108c.hashCode()) + (((this.f3112g == null ? 0 : this.f3112g.hashCode()) + (((this.f3110e == null ? 0 : this.f3110e.hashCode()) + (super.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3111f != null) {
            i = this.f3111f.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PoiItemDetail poiItemDetail = (PoiItemDetail) obj;
        if (this.f3110e == null) {
            if (poiItemDetail.f3110e != null) {
                return false;
            }
        } else if (!this.f3110e.equals(poiItemDetail.f3110e)) {
            return false;
        }
        if (this.f3112g != poiItemDetail.f3112g) {
            return false;
        }
        if (this.f3108c == null) {
            if (poiItemDetail.f3108c != null) {
                return false;
            }
        } else if (!this.f3108c.equals(poiItemDetail.f3108c)) {
            return false;
        }
        if (this.f3107b == null) {
            if (poiItemDetail.f3107b != null) {
                return false;
            }
        } else if (!this.f3107b.equals(poiItemDetail.f3107b)) {
            return false;
        }
        if (this.f3106a == null) {
            if (poiItemDetail.f3106a != null) {
                return false;
            }
        } else if (!this.f3106a.equals(poiItemDetail.f3106a)) {
            return false;
        }
        if (this.f3109d == null) {
            if (poiItemDetail.f3109d != null) {
                return false;
            }
        } else if (!this.f3109d.equals(poiItemDetail.f3109d)) {
            return false;
        }
        if (this.f3111f == null) {
            if (poiItemDetail.f3111f != null) {
                return false;
            }
            return true;
        } else if (this.f3111f.equals(poiItemDetail.f3111f)) {
            return true;
        } else {
            return false;
        }
    }
}
