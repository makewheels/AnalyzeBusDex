package com.amap.api.services.poisearch;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C0479d;
import com.amap.api.services.core.C0480e;
import com.amap.api.services.core.C0492q;
import com.amap.api.services.core.C0493r;
import com.amap.api.services.core.C0494t;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p054u.aly.bi_常量类;

public class PoiSearch {
    /* renamed from: i */
    private static HashMap<Integer, PoiResult> f3133i;
    /* renamed from: a */
    Handler f3134a = new C0521h(this);
    /* renamed from: b */
    private SearchBound f3135b;
    /* renamed from: c */
    private Query f3136c;
    /* renamed from: d */
    private Context f3137d;
    /* renamed from: e */
    private OnPoiSearchListener f3138e;
    /* renamed from: f */
    private Query f3139f;
    /* renamed from: g */
    private SearchBound f3140g;
    /* renamed from: h */
    private int f3141h;

    /* renamed from: com.amap.api.services.poisearch.PoiSearch$1 */
    class C05121 extends Thread {
        /* renamed from: a */
        final /* synthetic */ PoiSearch f3116a;

        C05121(PoiSearch poiSearch) {
            this.f3116a = poiSearch;
        }

        public void run() {
            Message message = new Message();
            message.what = 100;
            Bundle bundle = new Bundle();
            Object obj = null;
            try {
                obj = this.f3116a.searchPOI();
                bundle.putInt("errorCode", 0);
            } catch (AMapException e) {
                bundle.putInt("errorCode", e.getErrorCode());
            } finally {
                message.obj = obj;
                message.setData(bundle);
                this.f3116a.f3134a.sendMessage(message);
            }
        }
    }

    public interface OnPoiSearchListener {
        void onPoiItemDetailSearched(PoiItemDetail poiItemDetail, int i);

        void onPoiSearched(PoiResult poiResult, int i);
    }

    public static class Query implements Cloneable {
        /* renamed from: a */
        private String f3119a;
        /* renamed from: b */
        private String f3120b;
        /* renamed from: c */
        private String f3121c;
        /* renamed from: d */
        private int f3122d;
        /* renamed from: e */
        private int f3123e;
        /* renamed from: f */
        private boolean f3124f;
        /* renamed from: g */
        private boolean f3125g;

        public Query(String str, String str2) {
            this(str, str2, null);
        }

        public Query(String str, String str2, String str3) {
            this.f3122d = 0;
            this.f3123e = 20;
            this.f3119a = str;
            this.f3120b = str2;
            this.f3121c = str3;
        }

        public String getQueryString() {
            return this.f3119a;
        }

        public void setLimitGroupbuy(boolean z) {
            this.f3124f = z;
        }

        public boolean hasGroupBuyLimit() {
            return this.f3124f;
        }

        public void setLimitDiscount(boolean z) {
            this.f3125g = z;
        }

        public boolean hasDiscountLimit() {
            return this.f3125g;
        }

        public String getCategory() {
            if (this.f3120b == null || this.f3120b.equals("00") || this.f3120b.equals("00|")) {
                return m4148a();
            }
            return this.f3120b;
        }

        /* renamed from: a */
        private String m4148a() {
            return bi_常量类.f6358b;
        }

        public String getCity() {
            return this.f3121c;
        }

        public int getPageNum() {
            return this.f3122d;
        }

        public void setPageNum(int i) {
            this.f3122d = i;
        }

        public void setPageSize(int i) {
            this.f3123e = i;
        }

        public int getPageSize() {
            return this.f3123e;
        }

        public boolean queryEquals(Query query) {
            if (query == null) {
                return false;
            }
            if (query == this) {
                return true;
            }
            if (PoiSearch.m4161b(query.f3119a, this.f3119a) && PoiSearch.m4161b(query.f3120b, this.f3120b) && PoiSearch.m4161b(query.f3121c, this.f3121c) && query.f3123e == this.f3123e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 1231;
            int i3 = 0;
            int hashCode = ((this.f3121c == null ? 0 : this.f3121c.hashCode()) + (((this.f3120b == null ? 0 : this.f3120b.hashCode()) + 31) * 31)) * 31;
            if (this.f3125g) {
                i = 1231;
            } else {
                i = 1237;
            }
            i = (i + hashCode) * 31;
            if (!this.f3124f) {
                i2 = 1237;
            }
            i = (((((i + i2) * 31) + this.f3122d) * 31) + this.f3123e) * 31;
            if (this.f3119a != null) {
                i3 = this.f3119a.hashCode();
            }
            return i + i3;
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
            Query query = (Query) obj;
            if (this.f3120b == null) {
                if (query.f3120b != null) {
                    return false;
                }
            } else if (!this.f3120b.equals(query.f3120b)) {
                return false;
            }
            if (this.f3121c == null) {
                if (query.f3121c != null) {
                    return false;
                }
            } else if (!this.f3121c.equals(query.f3121c)) {
                return false;
            }
            if (this.f3125g != query.f3125g) {
                return false;
            }
            if (this.f3124f != query.f3124f) {
                return false;
            }
            if (this.f3122d != query.f3122d) {
                return false;
            }
            if (this.f3123e != query.f3123e) {
                return false;
            }
            if (this.f3119a == null) {
                if (query.f3119a != null) {
                    return false;
                }
                return true;
            } else if (this.f3119a.equals(query.f3119a)) {
                return true;
            } else {
                return false;
            }
        }

        public Query clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            Query query = new Query(this.f3119a, this.f3120b, this.f3121c);
            query.setPageNum(this.f3122d);
            query.setPageSize(this.f3123e);
            query.setLimitDiscount(this.f3125g);
            query.setLimitGroupbuy(this.f3124f);
            return query;
        }
    }

    public static class SearchBound implements Cloneable {
        public static final String BOUND_SHAPE = "Bound";
        public static final String ELLIPSE_SHAPE = "Ellipse";
        public static final String POLYGON_SHAPE = "Polygon";
        public static final String RECTANGLE_SHAPE = "Rectangle";
        /* renamed from: a */
        private LatLonPoint f3126a;
        /* renamed from: b */
        private LatLonPoint f3127b;
        /* renamed from: c */
        private int f3128c;
        /* renamed from: d */
        private LatLonPoint f3129d;
        /* renamed from: e */
        private String f3130e;
        /* renamed from: f */
        private boolean f3131f;
        /* renamed from: g */
        private List<LatLonPoint> f3132g;

        public SearchBound(LatLonPoint latLonPoint, int i) {
            this.f3131f = true;
            this.f3130e = BOUND_SHAPE;
            this.f3128c = i;
            this.f3129d = latLonPoint;
            m4153a(latLonPoint, C0480e.m4012a(i), C0480e.m4012a(i));
        }

        public SearchBound(LatLonPoint latLonPoint, int i, boolean z) {
            this.f3131f = true;
            this.f3130e = BOUND_SHAPE;
            this.f3128c = i;
            this.f3129d = latLonPoint;
            m4153a(latLonPoint, C0480e.m4012a(i), C0480e.m4012a(i));
            this.f3131f = z;
        }

        public SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f3131f = true;
            this.f3130e = RECTANGLE_SHAPE;
            m4154a(latLonPoint, latLonPoint2);
        }

        public SearchBound(List<LatLonPoint> list) {
            this.f3131f = true;
            this.f3130e = POLYGON_SHAPE;
            this.f3132g = list;
        }

        private SearchBound(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, LatLonPoint latLonPoint3, String str, List<LatLonPoint> list, boolean z) {
            this.f3131f = true;
            this.f3126a = latLonPoint;
            this.f3127b = latLonPoint2;
            this.f3128c = i;
            this.f3129d = latLonPoint3;
            this.f3130e = str;
            this.f3132g = list;
            this.f3131f = z;
        }

        /* renamed from: a */
        private void m4154a(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f3126a = latLonPoint;
            this.f3127b = latLonPoint2;
            if (this.f3126a.getLatitude() >= this.f3127b.getLatitude() || this.f3126a.getLongitude() >= this.f3127b.getLongitude()) {
                throw new IllegalArgumentException("invalid rect ");
            }
            this.f3129d = new LatLonPoint((this.f3126a.getLatitude() + this.f3127b.getLatitude()) / 2.0d, (this.f3126a.getLongitude() + this.f3127b.getLongitude()) / 2.0d);
        }

        /* renamed from: a */
        private void m4153a(LatLonPoint latLonPoint, double d, double d2) {
            double d3 = d / 2.0d;
            double d4 = d2 / 2.0d;
            double latitude = latLonPoint.getLatitude();
            double longitude = latLonPoint.getLongitude();
            m4154a(new LatLonPoint(latitude - d3, longitude - d4), new LatLonPoint(d3 + latitude, d4 + longitude));
        }

        public LatLonPoint getLowerLeft() {
            return this.f3126a;
        }

        public LatLonPoint getUpperRight() {
            return this.f3127b;
        }

        public LatLonPoint getCenter() {
            return this.f3129d;
        }

        public double getLonSpanInMeter() {
            if (RECTANGLE_SHAPE.equals(getShape())) {
                return this.f3127b.getLongitude() - this.f3126a.getLongitude();
            }
            return 0.0d;
        }

        public double getLatSpanInMeter() {
            if (RECTANGLE_SHAPE.equals(getShape())) {
                return this.f3127b.getLatitude() - this.f3126a.getLatitude();
            }
            return 0.0d;
        }

        public int getRange() {
            return this.f3128c;
        }

        public String getShape() {
            return this.f3130e;
        }

        public boolean isDistanceSort() {
            return this.f3131f;
        }

        public List<LatLonPoint> getPolyGonList() {
            return this.f3132g;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.f3132g == null ? 0 : this.f3132g.hashCode()) + (((this.f3127b == null ? 0 : this.f3127b.hashCode()) + (((this.f3126a == null ? 0 : this.f3126a.hashCode()) + (((this.f3131f ? 1231 : 1237) + (((this.f3129d == null ? 0 : this.f3129d.hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31) + this.f3128c) * 31;
            if (this.f3130e != null) {
                i = this.f3130e.hashCode();
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
            SearchBound searchBound = (SearchBound) obj;
            if (this.f3129d == null) {
                if (searchBound.f3129d != null) {
                    return false;
                }
            } else if (!this.f3129d.equals(searchBound.f3129d)) {
                return false;
            }
            if (this.f3131f != searchBound.f3131f) {
                return false;
            }
            if (this.f3126a == null) {
                if (searchBound.f3126a != null) {
                    return false;
                }
            } else if (!this.f3126a.equals(searchBound.f3126a)) {
                return false;
            }
            if (this.f3127b == null) {
                if (searchBound.f3127b != null) {
                    return false;
                }
            } else if (!this.f3127b.equals(searchBound.f3127b)) {
                return false;
            }
            if (this.f3132g == null) {
                if (searchBound.f3132g != null) {
                    return false;
                }
            } else if (!this.f3132g.equals(searchBound.f3132g)) {
                return false;
            }
            if (this.f3128c != searchBound.f3128c) {
                return false;
            }
            if (this.f3130e == null) {
                if (searchBound.f3130e != null) {
                    return false;
                }
                return true;
            } else if (this.f3130e.equals(searchBound.f3130e)) {
                return true;
            } else {
                return false;
            }
        }

        public SearchBound clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new SearchBound(this.f3126a, this.f3127b, this.f3128c, this.f3129d, this.f3130e, this.f3132g, this.f3131f);
        }
    }

    public PoiSearch(Context context, Query query) {
        C0479d.m3999a(context);
        this.f3137d = context.getApplicationContext();
        setQuery(query);
    }

    public void setOnPoiSearchListener(OnPoiSearchListener onPoiSearchListener) {
        this.f3138e = onPoiSearchListener;
    }

    /* renamed from: a */
    private boolean m4157a() {
        return (C0480e.m4020a(this.f3136c.f3119a) && C0480e.m4020a(this.f3136c.f3120b)) ? false : true;
    }

    /* renamed from: b */
    private boolean m4160b() {
        SearchBound bound = getBound();
        if (bound != null && bound.equals(SearchBound.BOUND_SHAPE)) {
            return true;
        }
        return false;
    }

    public PoiResult searchPOI() throws AMapException {
        if (m4160b() || m4157a()) {
            if ((!this.f3136c.queryEquals(this.f3139f) && this.f3135b == null) || !(this.f3136c.queryEquals(this.f3139f) || this.f3135b.equals(this.f3140g))) {
                this.f3141h = 0;
                this.f3139f = this.f3136c.clone();
                if (this.f3135b != null) {
                    this.f3140g = this.f3135b.clone();
                }
                if (f3133i != null) {
                    f3133i.clear();
                }
            }
            SearchBound searchBound = null;
            if (this.f3135b != null) {
                searchBound = this.f3135b.clone();
            }
            C0493r c0493r;
            PoiResult a;
            if (this.f3141h == 0) {
                c0493r = new C0493r(new C0494t(this.f3136c.clone(), searchBound), C0480e.m4018a(this.f3137d));
                c0493r.m4111a(this.f3136c.f3122d);
                c0493r.m4113b(this.f3136c.f3123e);
                a = PoiResult.m4147a(c0493r, (ArrayList) c0493r.getData());
                m4156a(a);
                return a;
            }
            PoiResult pageLocal = getPageLocal(this.f3136c.getPageNum());
            if (pageLocal != null) {
                return pageLocal;
            }
            c0493r = new C0493r(new C0494t(this.f3136c.clone(), searchBound), C0480e.m4018a(this.f3137d));
            c0493r.m4111a(this.f3136c.f3122d);
            c0493r.m4113b(this.f3136c.f3123e);
            a = PoiResult.m4147a(c0493r, (ArrayList) c0493r.getData());
            f3133i.put(Integer.valueOf(this.f3136c.f3122d), a);
            return a;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public void searchPOIAsyn() {
        new C05121(this).start();
    }

    public PoiItemDetail searchPOIDetail(String str) throws AMapException {
        return (PoiItemDetail) new C0492q(str, C0480e.m4018a(this.f3137d)).getData();
    }

    public void searchPOIDetailAsyn(final String str) {
        new Thread(this) {
            /* renamed from: b */
            final /* synthetic */ PoiSearch f3118b;

            public void run() {
                Message message = new Message();
                message.what = 101;
                Bundle bundle = new Bundle();
                Object obj = null;
                try {
                    obj = this.f3118b.searchPOIDetail(str);
                    bundle.putInt("errorCode", 0);
                } catch (AMapException e) {
                    bundle.putInt("errorCode", e.getErrorCode());
                } finally {
                    message.obj = obj;
                    message.setData(bundle);
                    this.f3118b.f3134a.sendMessage(message);
                }
            }
        }.start();
    }

    public void setQuery(Query query) {
        this.f3136c = query;
    }

    public void setBound(SearchBound searchBound) {
        this.f3135b = searchBound;
    }

    public Query getQuery() {
        return this.f3136c;
    }

    public SearchBound getBound() {
        return this.f3135b;
    }

    /* renamed from: b */
    private static boolean m4161b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* renamed from: a */
    private void m4156a(PoiResult poiResult) {
        f3133i = new HashMap();
        if (this.f3136c != null && poiResult != null && this.f3141h > 0 && this.f3141h > this.f3136c.getPageNum()) {
            f3133i.put(Integer.valueOf(this.f3136c.getPageNum()), poiResult);
        }
    }

    protected PoiResult getPageLocal(int i) {
        if (m4158a(i)) {
            return (PoiResult) f3133i.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }

    /* renamed from: a */
    private boolean m4158a(int i) {
        return i <= this.f3141h && i >= 0;
    }
}
