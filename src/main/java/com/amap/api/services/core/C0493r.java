package com.amap.api.services.core;

import com.amap.api.services.poisearch.PoiHandler;
import com.amap.api.services.poisearch.PoiSearch.Query;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchKeywordsHandler */
/* renamed from: com.amap.api.services.core.r */
public class C0493r extends PoiHandler<C0494t, ArrayList<PoiItem>> {
    /* renamed from: a */
    private int f2948a = 1;
    /* renamed from: b */
    private int f2949b = 20;
    /* renamed from: c */
    private int f2950c = 0;
    /* renamed from: d */
    private List<String> f2951d = new ArrayList();
    /* renamed from: e */
    private List<SuggestionCity> f2952e = new ArrayList();

    public /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m4110a(str);
    }

    public C0493r(C0494t c0494t, Proxy proxy) {
        super(c0494t, proxy);
    }

    /* renamed from: a */
    public void m4111a(int i) {
        this.f2948a = i + 1;
    }

    /* renamed from: b */
    public void m4113b(int i) {
        int i2;
        int i3 = 30;
        if (i > 30) {
            i2 = 30;
        } else {
            i2 = i;
        }
        if (i2 > 0) {
            i3 = i2;
        }
        this.f2949b = i3;
    }

    /* renamed from: a */
    public int mo657a() {
        return this.f2949b;
    }

    /* renamed from: b */
    public int m4112b() {
        return this.f2950c;
    }

    /* renamed from: c */
    public Query m4114c() {
        return ((C0494t) this.task).f2953a;
    }

    /* renamed from: d */
    public SearchBound m4115d() {
        return ((C0494t) this.task).f2954b;
    }

    /* renamed from: e */
    public List<String> m4116e() {
        return this.f2951d;
    }

    /* renamed from: f */
    public List<SuggestionCity> m4117f() {
        return this.f2952e;
    }

    protected String getUrl() {
        String str = "http://restapi.amap.com/v3/place";
        if (((C0494t) this.task).f2954b == null) {
            return str + "/text?";
        }
        if (((C0494t) this.task).f2954b.getShape().equals(SearchBound.BOUND_SHAPE)) {
            return str + "/around?";
        }
        return (((C0494t) this.task).f2954b.getShape().equals(SearchBound.RECTANGLE_SHAPE) || ((C0494t) this.task).f2954b.getShape().equals(SearchBound.POLYGON_SHAPE)) ? str + "/polygon?" : str;
    }

    /* renamed from: a */
    public ArrayList<PoiItem> m4110a(String str) throws AMapException {
        ArrayList<PoiItem> c;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f2950c = jSONObject.optInt("count");
            c = C0488m.m4062c(jSONObject);
            try {
                if (jSONObject.has("suggestion")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("suggestion");
                    this.f2952e = C0488m.m4042a(jSONObject2);
                    this.f2951d = C0488m.m4056b(jSONObject2);
                }
            } catch (JSONException e) {
                e = e;
                e.printStackTrace();
                return c;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return c;
            }
        } catch (JSONException e3) {
            JSONException e4;
            JSONException jSONException = e3;
            c = null;
            e4 = jSONException;
            e4.printStackTrace();
            return c;
        } catch (Exception e5) {
            Exception e6;
            Exception exception = e5;
            c = null;
            e6 = exception;
            e6.printStackTrace();
            return c;
        }
        return c;
    }

    protected String getRequestString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("output=json");
        if (((C0494t) this.task).f2954b != null) {
            if (((C0494t) this.task).f2954b.getShape().equals(SearchBound.BOUND_SHAPE)) {
                double a = C0480e.m4011a(((C0494t) this.task).f2954b.getCenter().getLongitude());
                stringBuilder.append("&location=").append(a + "," + C0480e.m4011a(((C0494t) this.task).f2954b.getCenter().getLatitude()));
                stringBuilder.append("&radius=").append(((C0494t) this.task).f2954b.getRange());
                stringBuilder.append("&sortrule=").append(m4107g());
            } else if (((C0494t) this.task).f2954b.getShape().equals(SearchBound.RECTANGLE_SHAPE)) {
                LatLonPoint lowerLeft = ((C0494t) this.task).f2954b.getLowerLeft();
                LatLonPoint upperRight = ((C0494t) this.task).f2954b.getUpperRight();
                double a2 = C0480e.m4011a(lowerLeft.getLatitude());
                double a3 = C0480e.m4011a(lowerLeft.getLongitude());
                stringBuilder.append("&polygon=" + a3 + "," + a2 + ";" + C0480e.m4011a(upperRight.getLongitude()) + "," + C0480e.m4011a(upperRight.getLatitude()));
            } else if (((C0494t) this.task).f2954b.getShape().equals(SearchBound.POLYGON_SHAPE)) {
                List polyGonList = ((C0494t) this.task).f2954b.getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    stringBuilder.append("&polygon=" + C0480e.m4017a(polyGonList));
                }
            }
        }
        String city = ((C0494t) this.task).f2953a.getCity();
        if (!isNullString(city)) {
            stringBuilder.append("&city=").append(strEncoder(city, z));
        }
        if (!C0480e.m4020a(m4108h())) {
            stringBuilder.append(m4108h());
        }
        stringBuilder.append("&keywords=" + strEncoder(((C0494t) this.task).f2953a.getQueryString(), z));
        stringBuilder.append("&offset=" + this.f2949b);
        stringBuilder.append("&page=" + this.f2948a);
        stringBuilder.append("&types=" + strEncoder(((C0494t) this.task).f2953a.getCategory(), z));
        stringBuilder.append("&extensions=all");
        stringBuilder.append("&key=" + C0479d.m3999a(null).m4009f());
        return C0480e.m4029f(stringBuilder.toString());
    }

    /* renamed from: g */
    private String m4107g() {
        if (((C0494t) this.task).f2954b.isDistanceSort()) {
            return "distance";
        }
        return "weight";
    }

    /* renamed from: h */
    private String m4108h() {
        StringBuffer stringBuffer = new StringBuffer();
        if (((C0494t) this.task).f2953a.hasGroupBuyLimit() && ((C0494t) this.task).f2953a.hasDiscountLimit()) {
            stringBuffer.append("&filter=groupbuy:1|discount:1");
            return stringBuffer.toString();
        }
        if (((C0494t) this.task).f2953a.hasGroupBuyLimit()) {
            stringBuffer.append("&filter=");
            stringBuffer.append("groupbuy:1");
        }
        if (((C0494t) this.task).f2953a.hasDiscountLimit()) {
            stringBuffer.append("&filter=");
            stringBuffer.append("discount:1");
        }
        return stringBuffer.toString();
    }
}
