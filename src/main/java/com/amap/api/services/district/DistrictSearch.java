package com.amap.api.services.district;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C0479d;
import com.amap.api.services.core.C0480e;
import com.amap.api.services.core.C0481f;
import java.util.HashMap;

public class DistrictSearch {
    /* renamed from: g */
    private static HashMap<Integer, DistrictResult> f2966g;
    /* renamed from: a */
    Handler f2967a = new C0500c(this);
    /* renamed from: b */
    private Context f2968b;
    /* renamed from: c */
    private DistrictSearchQuery f2969c;
    /* renamed from: d */
    private OnDistrictSearchListener f2970d;
    /* renamed from: e */
    private DistrictSearchQuery f2971e;
    /* renamed from: f */
    private int f2972f;

    /* renamed from: com.amap.api.services.district.DistrictSearch$1 */
    class C04971 extends Thread {
        /* renamed from: a */
        final /* synthetic */ DistrictSearch f2965a;

        C04971(DistrictSearch districtSearch) {
            this.f2965a = districtSearch;
        }

        public void run() {
            Message message = new Message();
            Object districtResult = new DistrictResult();
            districtResult.setQuery(this.f2965a.f2969c);
            try {
                districtResult = this.f2965a.m4124b();
                districtResult.setAMapException(new AMapException());
            } catch (AMapException e) {
                districtResult.setAMapException(e);
            } finally {
                message.obj = districtResult;
                this.f2965a.f2967a.sendMessage(message);
            }
        }
    }

    public interface OnDistrictSearchListener {
        void onDistrictSearched(DistrictResult districtResult);
    }

    public DistrictSearch(Context context) {
        C0479d.m3999a(context);
        this.f2968b = context.getApplicationContext();
    }

    /* renamed from: a */
    private void m4121a(DistrictResult districtResult) {
        f2966g = new HashMap();
        if (this.f2969c != null && districtResult != null && this.f2972f > 0 && this.f2972f > this.f2969c.getPageNum()) {
            f2966g.put(Integer.valueOf(this.f2969c.getPageNum()), districtResult);
        }
    }

    public DistrictSearchQuery getQuery() {
        return this.f2969c;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f2969c = districtSearchQuery;
    }

    /* renamed from: a */
    private boolean m4122a() {
        if (this.f2969c == null) {
            return false;
        }
        return true;
    }

    protected DistrictResult getPageLocal(int i) throws AMapException {
        if (m4123a(i)) {
            return (DistrictResult) f2966g.get(Integer.valueOf(i));
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: a */
    private boolean m4123a(int i) {
        return i < this.f2972f && i >= 0;
    }

    /* renamed from: b */
    private DistrictResult m4124b() throws AMapException {
        DistrictResult districtResult = new DistrictResult();
        if (!m4122a()) {
            this.f2969c = new DistrictSearchQuery();
        }
        districtResult.setQuery(this.f2969c.clone());
        if (!this.f2969c.weakEquals(this.f2971e)) {
            this.f2972f = 0;
            this.f2971e = this.f2969c.clone();
            if (f2966g != null) {
                f2966g.clear();
            }
        }
        if (this.f2972f == 0) {
            districtResult = (DistrictResult) new C0481f(this.f2969c.clone(), C0480e.m4018a(this.f2968b)).getData();
            if (districtResult == null) {
                return null;
            }
            this.f2972f = districtResult.getPageCount();
            m4121a(districtResult);
            return districtResult;
        }
        districtResult = getPageLocal(this.f2969c.getPageNum());
        if (districtResult != null) {
            return districtResult;
        }
        districtResult = (DistrictResult) new C0481f(this.f2969c.clone(), C0480e.m4018a(this.f2968b)).getData();
        if (this.f2969c == null || districtResult == null) {
            return null;
        }
        if (this.f2972f <= 0 || this.f2972f <= this.f2969c.getPageNum()) {
            return districtResult;
        }
        f2966g.put(Integer.valueOf(this.f2969c.getPageNum()), districtResult);
        return districtResult;
    }

    public void searchDistrictAnsy() {
        new C04971(this).start();
    }

    public void setOnDistrictSearchListener(OnDistrictSearchListener onDistrictSearchListener) {
        this.f2970d = onDistrictSearchListener;
    }
}
