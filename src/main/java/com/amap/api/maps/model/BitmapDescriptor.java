package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.C0405u;

public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
    /* renamed from: a */
    int f2247a = 0;
    /* renamed from: b */
    int f2248b = 0;
    /* renamed from: c */
    Bitmap f2249c;

    BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.f2247a = bitmap.getWidth();
            this.f2248b = bitmap.getHeight();
            this.f2249c = m3545a(bitmap, C0405u.m3444a(this.f2247a), C0405u.m3444a(this.f2248b));
            bitmap.recycle();
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.f2247a = i;
        this.f2248b = i2;
        this.f2249c = bitmap;
    }

    public BitmapDescriptor clone() {
        try {
            return new BitmapDescriptor(Bitmap.createBitmap(this.f2249c), this.f2247a, this.f2248b);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Bitmap getBitmap() {
        return this.f2249c;
    }

    public int getWidth() {
        return this.f2247a;
    }

    public int getHeight() {
        return this.f2248b;
    }

    /* renamed from: a */
    private Bitmap m3545a(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.hasAlpha() ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2249c, i);
        parcel.writeInt(this.f2247a);
        parcel.writeInt(this.f2248b);
    }

    public void recycle() {
        if (this.f2249c != null && !this.f2249c.isRecycled()) {
            this.f2249c.recycle();
            this.f2249c = null;
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this.f2249c == null || this.f2249c.isRecycled() || obj == null) {
            return z;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return z;
        }
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) obj;
        if (bitmapDescriptor.f2249c == null || bitmapDescriptor.f2249c.isRecycled() || this.f2247a != bitmapDescriptor.getWidth() || this.f2248b != bitmapDescriptor.getHeight()) {
            return z;
        }
        try {
            return this.f2249c.sameAs(bitmapDescriptor.f2249c);
        } catch (Throwable th) {
            return z;
        }
    }
}
