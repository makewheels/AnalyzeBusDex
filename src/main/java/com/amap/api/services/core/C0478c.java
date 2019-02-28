package com.amap.api.services.core;

import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineQuery.SearchType;
import com.amap.api.services.busline.BusStationQuery;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: BusSearchServerHandler */
/* renamed from: com.amap.api.services.core.c */
public class C0478c<T> extends C0476s<T, ArrayList<?>> {
    /* renamed from: a */
    private int f2932a = 0;
    /* renamed from: b */
    private List<String> f2933b = new ArrayList();
    /* renamed from: c */
    private List<SuggestionCity> f2934c = new ArrayList();

    protected /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m3995a(str);
    }

    public C0478c(T t, Proxy proxy) {
        super(t, proxy);
    }

    /* renamed from: a */
    public T mo657a() {
        return this.task;
    }

    /* renamed from: b */
    public int m3996b() {
        return this.f2932a;
    }

    protected String getUrl() {
        String str = this.task instanceof BusLineQuery ? ((BusLineQuery) this.task).getCategory() == SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.task).getCategory() == SearchType.BY_LINE_NAME ? "linename" : bi_常量类.f6358b_空串 : "stopname";
        return "http://restapi.amap.com/v3/bus/" + str + "?";
    }

    /* renamed from: a */
    protected ArrayList<?> m3995a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("suggestion")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("suggestion");
                this.f2934c = C0488m.m4042a(jSONObject2);
                this.f2933b = C0488m.m4056b(jSONObject2);
            }
            this.f2932a = jSONObject.getInt("count");
            if (this.task instanceof BusLineQuery) {
                return C0488m.m4080i(jSONObject);
            }
            return C0488m.m4071e(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public List<String> m3997c() {
        return this.f2933b;
    }

    /* renamed from: d */
    public List<SuggestionCity> m3998d() {
        return this.f2934c;
    }

    protected String getRequestString(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("output=json");
        String city;
        if (this.task instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) this.task;
            stringBuilder.append("&extensions=all");
            if (busLineQuery.getCategory() == SearchType.BY_LINE_ID) {
                stringBuilder.append("&id=").append(strEncoder(((BusLineQuery) this.task).getQueryString(), z));
            } else {
                city = busLineQuery.getCity();
                if (!C0488m.m4078h(city)) {
                    stringBuilder.append("&city=").append(strEncoder(city, z));
                }
                stringBuilder.append("&keywords=" + strEncoder(busLineQuery.getQueryString(), z));
                stringBuilder.append("&offset=" + busLineQuery.getPageSize());
                stringBuilder.append("&page=" + (busLineQuery.getPageNumber() + 1));
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) this.task;
            city = busStationQuery.getCity();
            if (!C0488m.m4078h(city)) {
                stringBuilder.append("&city=").append(strEncoder(city, z));
            }
            stringBuilder.append("&keywords=" + strEncoder(busStationQuery.getQueryString(), z));
            stringBuilder.append("&offset=" + busStationQuery.getPageSize());
            stringBuilder.append("&page=" + (busStationQuery.getPageNumber() + 1));
        }
        stringBuilder.append("&key=" + C0479d.m3999a(null).m4009f());
        return C0480e.m4029f(stringBuilder.toString());
    }
}
