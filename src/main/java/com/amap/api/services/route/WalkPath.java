package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class WalkPath extends Path implements Parcelable {
    public static final Creator<WalkPath> CREATOR = new C0547t();
    /* renamed from: a */
    private List<WalkStep> f3212a;

    public List<WalkStep> getSteps() {
        return this.f3212a;
    }

    public void setSteps(List<WalkStep> list) {
        this.f3212a = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3212a);
    }

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.f3212a = parcel.createTypedArrayList(WalkStep.CREATOR);
    }
}
