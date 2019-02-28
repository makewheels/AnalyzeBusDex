package com.amap.api.services.busline;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C0478c;
import com.amap.api.services.core.C0479d;
import com.amap.api.services.core.C0480e;
import java.util.ArrayList;

public class BusLineSearch {
    /* renamed from: a */
    Handler f2872a = new C0472b(this);
    /* renamed from: b */
    private Context f2873b;
    /* renamed from: c */
    private OnBusLineSearchListener f2874c;
    /* renamed from: d */
    private BusLineQuery f2875d;
    /* renamed from: e */
    private BusLineQuery f2876e;
    /* renamed from: f */
    private int f2877f;
    /* renamed from: g */
    private ArrayList<BusLineResult> f2878g;

    /* renamed from: com.amap.api.services.busline.BusLineSearch$1 */
    class C04691 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BusLineSearch f2871a;

        C04691(BusLineSearch busLineSearch) {
            this.f2871a = busLineSearch;
        }

        public void run() {
            Message message = new Message();
            try {
                BusLineResult searchBusLine = this.f2871a.searchBusLine();
                message.what = 0;
                message.obj = searchBusLine;
            } catch (AMapException e) {
                message.what = e.getErrorCode();
            } finally {
                this.f2871a.f2872a.sendMessage(message);
            }
        }
    }

    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) {
        C0479d.m3999a(context);
        this.f2873b = context.getApplicationContext();
        this.f2875d = busLineQuery;
        this.f2876e = busLineQuery.clone();
    }

    public BusLineResult searchBusLine() throws AMapException {
        if (!this.f2875d.weakEquals(this.f2876e)) {
            this.f2876e = this.f2875d.clone();
            this.f2877f = 0;
            if (this.f2878g != null) {
                this.f2878g.clear();
            }
        }
        if (this.f2877f == 0) {
            C0478c c0478c = new C0478c(this.f2875d.clone(), C0480e.m4018a(this.f2873b));
            BusLineResult a = BusLineResult.m3971a(c0478c, (ArrayList) c0478c.getData());
            this.f2877f = a.getPageCount();
            m3973a(a);
            return a;
        }
        a = m3975b(this.f2875d.getPageNumber());
        if (a != null) {
            return a;
        }
        c0478c = new C0478c(this.f2875d, C0480e.m4018a(this.f2873b));
        a = BusLineResult.m3971a(c0478c, (ArrayList) c0478c.getData());
        this.f2878g.set(this.f2875d.getPageNumber(), a);
        return a;
    }

    /* renamed from: a */
    private void m3973a(BusLineResult busLineResult) {
        this.f2878g = new ArrayList();
        for (int i = 0; i < this.f2877f; i++) {
            this.f2878g.add(null);
        }
        if (this.f2877f >= 0 && m3974a(this.f2875d.getPageNumber())) {
            this.f2878g.set(this.f2875d.getPageNumber(), busLineResult);
        }
    }

    /* renamed from: a */
    private boolean m3974a(int i) {
        return i < this.f2877f && i >= 0;
    }

    /* renamed from: b */
    private BusLineResult m3975b(int i) {
        if (m3974a(i)) {
            return (BusLineResult) this.f2878g.get(i);
        }
        throw new IllegalArgumentException("page out of range");
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        this.f2874c = onBusLineSearchListener;
    }

    public void searchBusLineAsyn() {
        new Thread(new C04691(this)).start();
    }

    public void setQuery(BusLineQuery busLineQuery) {
        if (!this.f2875d.weakEquals(busLineQuery)) {
            this.f2875d = busLineQuery;
            this.f2876e = busLineQuery.clone();
        }
    }

    public BusLineQuery getQuery() {
        return this.f2875d;
    }
}
