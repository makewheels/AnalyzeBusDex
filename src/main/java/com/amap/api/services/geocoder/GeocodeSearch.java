package com.amap.api.services.geocoder;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C0479d;
import com.amap.api.services.core.C0480e;
import com.amap.api.services.core.C0484i;
import com.amap.api.services.core.C0495u;
import java.util.List;

public final class GeocodeSearch {
    public static final String AMAP = "autonavi";
    public static final String GPS = "gps";
    /* renamed from: a */
    Handler f2998a = new C0505b(this);
    /* renamed from: b */
    private Context f2999b;
    /* renamed from: c */
    private OnGeocodeSearchListener f3000c;

    public interface OnGeocodeSearchListener {
        void onGeocodeSearched(GeocodeResult geocodeResult, int i);

        void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i);
    }

    public GeocodeSearch(Context context) {
        C0479d.m3999a(context);
        this.f2999b = context.getApplicationContext();
    }

    public RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        return (RegeocodeAddress) new C0495u(regeocodeQuery, C0480e.m4018a(this.f2999b)).getData();
    }

    public List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        return (List) new C0484i(geocodeQuery, C0480e.m4018a(this.f2999b)).getData();
    }

    public void setOnGeocodeSearchListener(OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f3000c = onGeocodeSearchListener;
    }

    public void getFromLocationAsyn(final RegeocodeQuery regeocodeQuery) {
        new Thread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ GeocodeSearch f2995b;

            public void run() {
                Message message = new Message();
                try {
                    message.what = 101;
                    RegeocodeAddress fromLocation = this.f2995b.getFromLocation(regeocodeQuery);
                    message.arg1 = 0;
                    message.obj = new RegeocodeResult(regeocodeQuery, fromLocation);
                } catch (AMapException e) {
                    message.arg1 = e.getErrorCode();
                } finally {
                    this.f2995b.f2998a.sendMessage(message);
                }
            }
        }).start();
    }

    public void getFromLocationNameAsyn(final GeocodeQuery geocodeQuery) {
        new Thread(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ GeocodeSearch f2997b;

            public void run() {
                Message message = new Message();
                try {
                    message.what = 100;
                    List fromLocationName = this.f2997b.getFromLocationName(geocodeQuery);
                    message.arg1 = 0;
                    message.obj = new GeocodeResult(geocodeQuery, fromLocationName);
                } catch (AMapException e) {
                    message.arg1 = e.getErrorCode();
                } finally {
                    this.f2997b.f2998a.sendMessage(message);
                }
            }
        }).start();
    }
}
