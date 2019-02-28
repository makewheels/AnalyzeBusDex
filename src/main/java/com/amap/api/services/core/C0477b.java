package com.amap.api.services.core;

import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;
import java.net.Proxy;
import p054u.aly.bi_常量类;

/* compiled from: BusRouteSearchHandler */
/* renamed from: com.amap.api.services.core.b */
public class C0477b extends C0476s<BusRouteQuery, BusRouteResult> {
    protected /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m3993a(str);
    }

    public C0477b(BusRouteQuery busRouteQuery, Proxy proxy) {
        super(busRouteQuery, proxy);
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C0479d.m3999a(null).m4009f());
        stringBuffer.append("&origin=").append(C0480e.m4014a(((BusRouteQuery) this.task).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=").append(C0480e.m4014a(((BusRouteQuery) this.task).getFromAndTo().getTo()));
        String city = ((BusRouteQuery) this.task).getCity();
        if (!C0488m.m4078h(city)) {
            stringBuffer.append("&city=").append(strEncoder(city, z));
        }
        stringBuffer.append("&strategy=").append(bi_常量类.f6358b + ((BusRouteQuery) this.task).getMode());
        stringBuffer.append("&nightflag=").append(((BusRouteQuery) this.task).getNightFlag());
        stringBuffer.append("&output=json");
        return C0480e.m4029f(stringBuffer.toString());
    }

    /* renamed from: a */
    protected BusRouteResult m3993a(String str) throws AMapException {
        return C0488m.m4054b(str);
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/direction/transit/integrated?";
    }
}
