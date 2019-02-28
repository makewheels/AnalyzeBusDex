package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public final class Dining implements Parcelable {
    public static final Creator<Dining> CREATOR = new C0515b();
    /* renamed from: a */
    private boolean f3048a;
    /* renamed from: b */
    private String f3049b;
    /* renamed from: c */
    private String f3050c;
    /* renamed from: d */
    private String f3051d;
    /* renamed from: e */
    private String f3052e;
    /* renamed from: f */
    private String f3053f;
    /* renamed from: g */
    private String f3054g;
    /* renamed from: h */
    private String f3055h;
    /* renamed from: i */
    private String f3056i;
    /* renamed from: j */
    private String f3057j;
    /* renamed from: k */
    private String f3058k;
    /* renamed from: l */
    private String f3059l;
    /* renamed from: m */
    private String f3060m;
    /* renamed from: n */
    private String f3061n;
    /* renamed from: o */
    private String f3062o;
    /* renamed from: p */
    private String f3063p;
    /* renamed from: q */
    private String f3064q;
    /* renamed from: r */
    private String f3065r;
    /* renamed from: s */
    private String f3066s;
    /* renamed from: t */
    private List<Photo> f3067t;

    public boolean isMealOrdering() {
        return this.f3048a;
    }

    public void setMealOrdering(boolean z) {
        this.f3048a = z;
    }

    public String getCuisines() {
        return this.f3049b;
    }

    public void setCuisines(String str) {
        this.f3049b = str;
    }

    public String getTag() {
        return this.f3050c;
    }

    public void setTag(String str) {
        this.f3050c = str;
    }

    public String getIntro() {
        return this.f3051d;
    }

    public void setIntro(String str) {
        this.f3051d = str;
    }

    public String getRating() {
        return this.f3052e;
    }

    public void setRating(String str) {
        this.f3052e = str;
    }

    public String getCpRating() {
        return this.f3053f;
    }

    public void setCpRating(String str) {
        this.f3053f = str;
    }

    public String getDeepsrc() {
        return this.f3054g;
    }

    public void setDeepsrc(String str) {
        this.f3054g = str;
    }

    public String getTasteRating() {
        return this.f3055h;
    }

    public void setTasteRating(String str) {
        this.f3055h = str;
    }

    public String getEnvironmentRating() {
        return this.f3056i;
    }

    public void setEnvironmentRating(String str) {
        this.f3056i = str;
    }

    public String getServiceRating() {
        return this.f3057j;
    }

    public void setServiceRating(String str) {
        this.f3057j = str;
    }

    public String getCost() {
        return this.f3058k;
    }

    public void setCost(String str) {
        this.f3058k = str;
    }

    public String getRecommend() {
        return this.f3059l;
    }

    public void setRecommend(String str) {
        this.f3059l = str;
    }

    public String getAtmosphere() {
        return this.f3060m;
    }

    public void setAtmosphere(String str) {
        this.f3060m = str;
    }

    public String getOrderingWapUrl() {
        return this.f3061n;
    }

    public void setOrderingWapUrl(String str) {
        this.f3061n = str;
    }

    public String getOrderingWebUrl() {
        return this.f3062o;
    }

    public void setOrderingWebUrl(String str) {
        this.f3062o = str;
    }

    public String getOrderinAppUrl() {
        return this.f3063p;
    }

    public void setOrderinAppUrl(String str) {
        this.f3063p = str;
    }

    public String getOpentimeGDF() {
        return this.f3064q;
    }

    public void setOpentimeGDF(String str) {
        this.f3064q = str;
    }

    public String getOpentime() {
        return this.f3065r;
    }

    public void setOpentime(String str) {
        this.f3065r = str;
    }

    public String getAddition() {
        return this.f3066s;
    }

    public void setAddition(String str) {
        this.f3066s = str;
    }

    public List<Photo> getPhotos() {
        return this.f3067t;
    }

    public void setPhotos(List<Photo> list) {
        this.f3067t = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBooleanArray(new boolean[]{this.f3048a});
        parcel.writeString(this.f3049b);
        parcel.writeString(this.f3050c);
        parcel.writeString(this.f3051d);
        parcel.writeString(this.f3052e);
        parcel.writeString(this.f3053f);
        parcel.writeString(this.f3054g);
        parcel.writeString(this.f3055h);
        parcel.writeString(this.f3056i);
        parcel.writeString(this.f3057j);
        parcel.writeString(this.f3058k);
        parcel.writeString(this.f3059l);
        parcel.writeString(this.f3060m);
        parcel.writeString(this.f3061n);
        parcel.writeString(this.f3062o);
        parcel.writeString(this.f3063p);
        parcel.writeString(this.f3064q);
        parcel.writeString(this.f3065r);
        parcel.writeString(this.f3066s);
        parcel.writeTypedList(this.f3067t);
    }

    public Dining(Parcel parcel) {
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f3048a = zArr[0];
        this.f3049b = parcel.readString();
        this.f3050c = parcel.readString();
        this.f3051d = parcel.readString();
        this.f3052e = parcel.readString();
        this.f3053f = parcel.readString();
        this.f3054g = parcel.readString();
        this.f3055h = parcel.readString();
        this.f3056i = parcel.readString();
        this.f3057j = parcel.readString();
        this.f3058k = parcel.readString();
        this.f3059l = parcel.readString();
        this.f3060m = parcel.readString();
        this.f3061n = parcel.readString();
        this.f3062o = parcel.readString();
        this.f3063p = parcel.readString();
        this.f3064q = parcel.readString();
        this.f3065r = parcel.readString();
        this.f3066s = parcel.readString();
        this.f3067t = parcel.createTypedArrayList(Photo.CREATOR);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f3050c == null ? 0 : this.f3050c.hashCode()) + (((this.f3057j == null ? 0 : this.f3057j.hashCode()) + (((this.f3059l == null ? 0 : this.f3059l.hashCode()) + (((this.f3052e == null ? 0 : this.f3052e.hashCode()) + (((this.f3067t == null ? 0 : this.f3067t.hashCode()) + (((this.f3062o == null ? 0 : this.f3062o.hashCode()) + (((this.f3061n == null ? 0 : this.f3061n.hashCode()) + (((this.f3063p == null ? 0 : this.f3063p.hashCode()) + (((this.f3064q == null ? 0 : this.f3064q.hashCode()) + (((this.f3065r == null ? 0 : this.f3065r.hashCode()) + (((this.f3048a ? 1231 : 1237) + (((this.f3051d == null ? 0 : this.f3051d.hashCode()) + (((this.f3056i == null ? 0 : this.f3056i.hashCode()) + (((this.f3054g == null ? 0 : this.f3054g.hashCode()) + (((this.f3049b == null ? 0 : this.f3049b.hashCode()) + (((this.f3053f == null ? 0 : this.f3053f.hashCode()) + (((this.f3058k == null ? 0 : this.f3058k.hashCode()) + (((this.f3060m == null ? 0 : this.f3060m.hashCode()) + (((this.f3066s == null ? 0 : this.f3066s.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.f3055h != null) {
            i = this.f3055h.hashCode();
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
        Dining dining = (Dining) obj;
        if (this.f3066s == null) {
            if (dining.f3066s != null) {
                return false;
            }
        } else if (!this.f3066s.equals(dining.f3066s)) {
            return false;
        }
        if (this.f3060m == null) {
            if (dining.f3060m != null) {
                return false;
            }
        } else if (!this.f3060m.equals(dining.f3060m)) {
            return false;
        }
        if (this.f3058k == null) {
            if (dining.f3058k != null) {
                return false;
            }
        } else if (!this.f3058k.equals(dining.f3058k)) {
            return false;
        }
        if (this.f3053f == null) {
            if (dining.f3053f != null) {
                return false;
            }
        } else if (!this.f3053f.equals(dining.f3053f)) {
            return false;
        }
        if (this.f3049b == null) {
            if (dining.f3049b != null) {
                return false;
            }
        } else if (!this.f3049b.equals(dining.f3049b)) {
            return false;
        }
        if (this.f3054g == null) {
            if (dining.f3054g != null) {
                return false;
            }
        } else if (!this.f3054g.equals(dining.f3054g)) {
            return false;
        }
        if (this.f3056i == null) {
            if (dining.f3056i != null) {
                return false;
            }
        } else if (!this.f3056i.equals(dining.f3056i)) {
            return false;
        }
        if (this.f3051d == null) {
            if (dining.f3051d != null) {
                return false;
            }
        } else if (!this.f3051d.equals(dining.f3051d)) {
            return false;
        }
        if (this.f3048a != dining.f3048a) {
            return false;
        }
        if (this.f3065r == null) {
            if (dining.f3065r != null) {
                return false;
            }
        } else if (!this.f3065r.equals(dining.f3065r)) {
            return false;
        }
        if (this.f3064q == null) {
            if (dining.f3064q != null) {
                return false;
            }
        } else if (!this.f3064q.equals(dining.f3064q)) {
            return false;
        }
        if (this.f3063p == null) {
            if (dining.f3063p != null) {
                return false;
            }
        } else if (!this.f3063p.equals(dining.f3063p)) {
            return false;
        }
        if (this.f3061n == null) {
            if (dining.f3061n != null) {
                return false;
            }
        } else if (!this.f3061n.equals(dining.f3061n)) {
            return false;
        }
        if (this.f3062o == null) {
            if (dining.f3062o != null) {
                return false;
            }
        } else if (!this.f3062o.equals(dining.f3062o)) {
            return false;
        }
        if (this.f3067t == null) {
            if (dining.f3067t != null) {
                return false;
            }
        } else if (!this.f3067t.equals(dining.f3067t)) {
            return false;
        }
        if (this.f3052e == null) {
            if (dining.f3052e != null) {
                return false;
            }
        } else if (!this.f3052e.equals(dining.f3052e)) {
            return false;
        }
        if (this.f3059l == null) {
            if (dining.f3059l != null) {
                return false;
            }
        } else if (!this.f3059l.equals(dining.f3059l)) {
            return false;
        }
        if (this.f3057j == null) {
            if (dining.f3057j != null) {
                return false;
            }
        } else if (!this.f3057j.equals(dining.f3057j)) {
            return false;
        }
        if (this.f3050c == null) {
            if (dining.f3050c != null) {
                return false;
            }
        } else if (!this.f3050c.equals(dining.f3050c)) {
            return false;
        }
        if (this.f3055h == null) {
            if (dining.f3055h != null) {
                return false;
            }
            return true;
        } else if (this.f3055h.equals(dining.f3055h)) {
            return true;
        } else {
            return false;
        }
    }
}
