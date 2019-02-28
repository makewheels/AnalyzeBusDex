package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;
import java.util.List;

public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Creator<DriveRouteResult> CREATOR = new C0534g();
    /* renamed from: a */
    private List<DrivePath> f3192a;
    /* renamed from: b */
    private DriveRouteQuery f3193b;

    public List<DrivePath> getPaths() {
        return this.f3192a;
    }

    public void setPaths(List<DrivePath> list) {
        this.f3192a = list;
    }

    public DriveRouteQuery getDriveQuery() {
        return this.f3193b;
    }

    public void setDriveQuery(DriveRouteQuery driveRouteQuery) {
        this.f3193b = driveRouteQuery;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f3192a);
        parcel.writeParcelable(this.f3193b, i);
    }

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f3192a = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f3193b = (DriveRouteQuery) parcel.readParcelable(DriveRouteQuery.class.getClassLoader());
    }
}
