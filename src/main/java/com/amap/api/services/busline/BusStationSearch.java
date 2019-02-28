package com.amap.api.services.busline;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C0478c;
import com.amap.api.services.core.C0479d;
import com.amap.api.services.core.C0480e;
import java.util.ArrayList;

public class BusStationSearch {
    /* renamed from: a */
    Handler f2895a = new C0474d(this);
    /* renamed from: b */
    private Context f2896b;
    /* renamed from: c */
    private OnBusStationSearchListener f2897c;
    /* renamed from: d */
    private BusStationQuery f2898d;
    /* renamed from: e */
    private BusStationQuery f2899e;
    /* renamed from: f */
    private ArrayList<BusStationResult> f2900f;
    /* renamed from: g */
    private int f2901g;

    /* renamed from: com.amap.api.services.busline.BusStationSearch$1 */
    class C04701 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BusStationSearch f2894a;

        C04701(BusStationSearch busStationSearch) {
            this.f2894a = busStationSearch;
        }

        public void run() {
            Message message = new Message();
            try {
                BusStationResult searchBusStation = this.f2894a.searchBusStation();
                message.what = 0;
                message.obj = searchBusStation;
            } catch (AMapException e) {
                message.what = e.getErrorCode();
            } finally {
                this.f2894a.f2895a.sendMessage(message);
            }
        }
    }

    public interface OnBusStationSearchListener {
        void onBusStationSearched(BusStationResult busStationResult, int i);
    }

    public BusStationSearch(Context context, BusStationQuery busStationQuery) {
        C0479d.m3999a(context);
        this.f2896b = context.getApplicationContext();
        this.f2898d = busStationQuery;
    }

    public BusStationResult searchBusStation() throws AMapException {
        if (!this.f2898d.weakEquals(this.f2899e)) {
            this.f2899e = this.f2898d.clone();
            this.f2901g = 0;
            if (this.f2900f != null) {
                this.f2900f.clear();
            }
        }
        if (this.f2901g == 0) {
            C0478c c0478c = new C0478c(this.f2898d, C0480e.m4018a(this.f2896b));
            BusStationResult a = BusStationResult.m3979a(c0478c, (ArrayList) c0478c.getData());
            this.f2901g = a.getPageCount();
            m3981a(a);
            return a;
        }
        a = m3983b(this.f2898d.getPageNumber());
        if (a != null) {
            return a;
        }
        c0478c = new C0478c(this.f2898d, C0480e.m4018a(this.f2896b));
        a = BusStationResult.m3979a(c0478c, (ArrayList) c0478c.getData());
        this.f2900f.set(this.f2898d.getPageNumber(), a);
        return a;
    }

    /* renamed from: a */
    private void m3981a(BusStationResult busStationResult) {
        this.f2900f = new ArrayList();
        for (int i = 0; i <= this.f2901g; i++) {
            this.f2900f.add(null);
        }
        if (this.f2901g > 0) {
            this.f2900f.set(this.f2898d.getPageNumber(), busStationResult);
        }
    }

    /* renamed from: a */
    private boolean m3982a(int i) {
        return i <= this.f2901g && i >= 0;
    }

    /* renamed from: b */
    private BusStationResult m3983b(int i) {
        if (m3982a(i)) {
            return (BusStationResult) this.f2900f.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public void setOnBusStationSearchListener(OnBusStationSearchListener onBusStationSearchListener) {
        this.f2897c = onBusStationSearchListener;
    }

    public void searchBusStationAsyn() {
        new Thread(new C04701(this)).start();
    }

    public void setQuery(BusStationQuery busStationQuery) {
        if (!busStationQuery.weakEquals(this.f2898d)) {
            this.f2898d = busStationQuery;
        }
    }

    public BusStationQuery getQuery() {
        return this.f2898d;
    }
}
