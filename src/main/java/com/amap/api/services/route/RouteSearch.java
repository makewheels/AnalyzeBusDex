package com.amap.api.services.route;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C0477b;
import com.amap.api.services.core.C0479d;
import com.amap.api.services.core.C0480e;
import com.amap.api.services.core.C0482g;
import com.amap.api.services.core.C0496v;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class RouteSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;
    /* renamed from: a */
    Handler f3236a = new C0540m(this);
    /* renamed from: b */
    private OnRouteSearchListener f3237b;
    /* renamed from: c */
    private Context f3238c;

    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Creator<BusRouteQuery> CREATOR = new C0541n();
        /* renamed from: a */
        private FromAndTo f3221a;
        /* renamed from: b */
        private int f3222b;
        /* renamed from: c */
        private String f3223c;
        /* renamed from: d */
        private int f3224d;

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.f3221a = fromAndTo;
            this.f3222b = i;
            this.f3223c = str;
            this.f3224d = i2;
        }

        public FromAndTo getFromAndTo() {
            return this.f3221a;
        }

        public int getMode() {
            return this.f3222b;
        }

        public String getCity() {
            return this.f3223c;
        }

        public int getNightFlag() {
            return this.f3224d;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3221a, i);
            parcel.writeInt(this.f3222b);
            parcel.writeString(this.f3223c);
            parcel.writeInt(this.f3224d);
        }

        public BusRouteQuery(Parcel parcel) {
            this.f3221a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f3222b = parcel.readInt();
            this.f3223c = parcel.readString();
            this.f3224d = parcel.readInt();
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3223c == null ? 0 : this.f3223c.hashCode()) + 31) * 31;
            if (this.f3221a != null) {
                i = this.f3221a.hashCode();
            }
            return ((((hashCode + i) * 31) + this.f3222b) * 31) + this.f3224d;
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
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            if (this.f3223c == null) {
                if (busRouteQuery.f3223c != null) {
                    return false;
                }
            } else if (!this.f3223c.equals(busRouteQuery.f3223c)) {
                return false;
            }
            if (this.f3221a == null) {
                if (busRouteQuery.f3221a != null) {
                    return false;
                }
            } else if (!this.f3221a.equals(busRouteQuery.f3221a)) {
                return false;
            }
            if (this.f3222b != busRouteQuery.f3222b) {
                return false;
            }
            if (this.f3224d != busRouteQuery.f3224d) {
                return false;
            }
            return true;
        }

        public BusRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new BusRouteQuery(this.f3221a, this.f3222b, this.f3223c, this.f3224d);
        }
    }

    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Creator<DriveRouteQuery> CREATOR = new C0542o();
        /* renamed from: a */
        private FromAndTo f3225a;
        /* renamed from: b */
        private int f3226b;
        /* renamed from: c */
        private List<LatLonPoint> f3227c;
        /* renamed from: d */
        private List<List<LatLonPoint>> f3228d;
        /* renamed from: e */
        private String f3229e;

        public DriveRouteQuery(FromAndTo fromAndTo, int i, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f3225a = fromAndTo;
            this.f3226b = i;
            this.f3227c = list;
            this.f3228d = list2;
            this.f3229e = str;
        }

        public FromAndTo getFromAndTo() {
            return this.f3225a;
        }

        public int getMode() {
            return this.f3226b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f3227c;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f3228d;
        }

        public String getAvoidRoad() {
            return this.f3229e;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f3227c == null || this.f3227c.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f3227c.size(); i++) {
                LatLonPoint latLonPoint = (LatLonPoint) this.f3227c.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.f3227c.size() - 1) {
                    stringBuffer.append(";");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasPassPoint() {
            if (C0480e.m4020a(getPassedPointStr())) {
                return false;
            }
            return true;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f3228d == null || this.f3228d.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.f3228d.size(); i++) {
                List list = (List) this.f3228d.get(i);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    LatLonPoint latLonPoint = (LatLonPoint) list.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list.size() - 1) {
                        stringBuffer.append(";");
                    }
                }
                if (i < this.f3228d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidpolygons() {
            if (C0480e.m4020a(getAvoidpolygonsStr())) {
                return false;
            }
            return true;
        }

        public boolean hasAvoidRoad() {
            if (C0480e.m4020a(getAvoidRoad())) {
                return false;
            }
            return true;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3225a, i);
            parcel.writeInt(this.f3226b);
            parcel.writeTypedList(this.f3227c);
            if (this.f3228d == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(this.f3228d.size());
                for (List writeTypedList : this.f3228d) {
                    parcel.writeTypedList(writeTypedList);
                }
            }
            parcel.writeString(this.f3229e);
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f3225a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f3226b = parcel.readInt();
            this.f3227c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.f3228d = null;
            } else {
                this.f3228d = new ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.f3228d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f3229e = parcel.readString();
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.f3225a == null ? 0 : this.f3225a.hashCode()) + (((this.f3228d == null ? 0 : this.f3228d.hashCode()) + (((this.f3229e == null ? 0 : this.f3229e.hashCode()) + 31) * 31)) * 31)) * 31) + this.f3226b) * 31;
            if (this.f3227c != null) {
                i = this.f3227c.hashCode();
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
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            if (this.f3229e == null) {
                if (driveRouteQuery.f3229e != null) {
                    return false;
                }
            } else if (!this.f3229e.equals(driveRouteQuery.f3229e)) {
                return false;
            }
            if (this.f3228d == null) {
                if (driveRouteQuery.f3228d != null) {
                    return false;
                }
            } else if (!this.f3228d.equals(driveRouteQuery.f3228d)) {
                return false;
            }
            if (this.f3225a == null) {
                if (driveRouteQuery.f3225a != null) {
                    return false;
                }
            } else if (!this.f3225a.equals(driveRouteQuery.f3225a)) {
                return false;
            }
            if (this.f3226b != driveRouteQuery.f3226b) {
                return false;
            }
            if (this.f3227c == null) {
                if (driveRouteQuery.f3227c != null) {
                    return false;
                }
                return true;
            } else if (this.f3227c.equals(driveRouteQuery.f3227c)) {
                return true;
            } else {
                return false;
            }
        }

        public DriveRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new DriveRouteQuery(this.f3225a, this.f3226b, this.f3227c, this.f3228d, this.f3229e);
        }
    }

    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Creator<FromAndTo> CREATOR = new C0543p();
        /* renamed from: a */
        private LatLonPoint f3230a;
        /* renamed from: b */
        private LatLonPoint f3231b;
        /* renamed from: c */
        private String f3232c;
        /* renamed from: d */
        private String f3233d;

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f3230a = latLonPoint;
            this.f3231b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f3230a;
        }

        public LatLonPoint getTo() {
            return this.f3231b;
        }

        public String getStartPoiID() {
            return this.f3232c;
        }

        public void setStartPoiID(String str) {
            this.f3232c = str;
        }

        public String getDestinationPoiID() {
            return this.f3233d;
        }

        public void setDestinationPoiID(String str) {
            this.f3233d = str;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3230a, i);
            parcel.writeParcelable(this.f3231b, i);
            parcel.writeString(this.f3232c);
            parcel.writeString(this.f3233d);
        }

        public FromAndTo(Parcel parcel) {
            this.f3230a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f3231b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f3232c = parcel.readString();
            this.f3233d = parcel.readString();
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3232c == null ? 0 : this.f3232c.hashCode()) + (((this.f3230a == null ? 0 : this.f3230a.hashCode()) + (((this.f3233d == null ? 0 : this.f3233d.hashCode()) + 31) * 31)) * 31)) * 31;
            if (this.f3231b != null) {
                i = this.f3231b.hashCode();
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
            FromAndTo fromAndTo = (FromAndTo) obj;
            if (this.f3233d == null) {
                if (fromAndTo.f3233d != null) {
                    return false;
                }
            } else if (!this.f3233d.equals(fromAndTo.f3233d)) {
                return false;
            }
            if (this.f3230a == null) {
                if (fromAndTo.f3230a != null) {
                    return false;
                }
            } else if (!this.f3230a.equals(fromAndTo.f3230a)) {
                return false;
            }
            if (this.f3232c == null) {
                if (fromAndTo.f3232c != null) {
                    return false;
                }
            } else if (!this.f3232c.equals(fromAndTo.f3232c)) {
                return false;
            }
            if (this.f3231b == null) {
                if (fromAndTo.f3231b != null) {
                    return false;
                }
                return true;
            } else if (this.f3231b.equals(fromAndTo.f3231b)) {
                return true;
            } else {
                return false;
            }
        }

        public FromAndTo clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            FromAndTo fromAndTo = new FromAndTo(this.f3230a, this.f3231b);
            fromAndTo.setStartPoiID(this.f3232c);
            fromAndTo.setDestinationPoiID(this.f3233d);
            return fromAndTo;
        }
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i);
    }

    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Creator<WalkRouteQuery> CREATOR = new C0544q();
        /* renamed from: a */
        private FromAndTo f3234a;
        /* renamed from: b */
        private int f3235b;

        public WalkRouteQuery(FromAndTo fromAndTo, int i) {
            this.f3234a = fromAndTo;
            this.f3235b = i;
        }

        public FromAndTo getFromAndTo() {
            return this.f3234a;
        }

        public int getMode() {
            return this.f3235b;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f3234a, i);
            parcel.writeInt(this.f3235b);
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f3234a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f3235b = parcel.readInt();
        }

        public int hashCode() {
            return (((this.f3234a == null ? 0 : this.f3234a.hashCode()) + 31) * 31) + this.f3235b;
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
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            if (this.f3234a == null) {
                if (walkRouteQuery.f3234a != null) {
                    return false;
                }
            } else if (!this.f3234a.equals(walkRouteQuery.f3234a)) {
                return false;
            }
            if (this.f3235b != walkRouteQuery.f3235b) {
                return false;
            }
            return true;
        }

        public WalkRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new WalkRouteQuery(this.f3234a, this.f3235b);
        }
    }

    public RouteSearch(Context context) {
        this.f3238c = context.getApplicationContext();
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        this.f3237b = onRouteSearchListener;
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        C0479d.m3999a(this.f3238c);
        WalkRouteQuery clone = walkRouteQuery.clone();
        WalkRouteResult walkRouteResult = (WalkRouteResult) new C0496v(clone, C0480e.m4018a(this.f3238c)).getData();
        if (walkRouteResult != null) {
            walkRouteResult.setWalkQuery(clone);
        }
        return walkRouteResult;
    }

    public void calculateWalkRouteAsyn(final WalkRouteQuery walkRouteQuery) {
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ RouteSearch f3216b;

            public void run() {
                Message message = new Message();
                message.what = 12;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.f3216b.calculateWalkRoute(walkRouteQuery);
                    bundle.putInt("errorCode", 0);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.f3216b.f3236a.sendMessage(message);
                }
            }
        }.start();
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        C0479d.m3999a(this.f3238c);
        BusRouteQuery clone = busRouteQuery.clone();
        BusRouteResult busRouteResult = (BusRouteResult) new C0477b(clone, C0480e.m4018a(this.f3238c)).getData();
        if (busRouteResult != null) {
            busRouteResult.setBusQuery(clone);
        }
        return busRouteResult;
    }

    public void calculateBusRouteAsyn(final BusRouteQuery busRouteQuery) {
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ RouteSearch f3218b;

            public void run() {
                Message message = new Message();
                message.what = 10;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.f3218b.calculateBusRoute(busRouteQuery);
                    bundle.putInt("errorCode", 0);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.f3218b.f3236a.sendMessage(message);
                }
            }
        }.start();
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        C0479d.m3999a(this.f3238c);
        DriveRouteQuery clone = driveRouteQuery.clone();
        DriveRouteResult driveRouteResult = (DriveRouteResult) new C0482g(clone, C0480e.m4018a(this.f3238c)).getData();
        if (driveRouteResult != null) {
            driveRouteResult.setDriveQuery(clone);
        }
        return driveRouteResult;
    }

    public void calculateDriveRouteAsyn(final DriveRouteQuery driveRouteQuery) {
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ RouteSearch f3220b;

            public void run() {
                Message message = new Message();
                message.what = 11;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.f3220b.calculateDriveRoute(driveRouteQuery);
                    bundle.putInt("errorCode", 0);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.f3220b.f3236a.sendMessage(message);
                }
            }
        }.start();
    }
}
