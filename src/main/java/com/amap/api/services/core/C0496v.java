package com.amap.api.services.core;

import com.amap.api.services.route.RouteSearch.WalkRouteQuery;
import com.amap.api.services.route.WalkRouteResult;
import java.net.Proxy;

/* compiled from: WalkRouteSearchHandler */
/* renamed from: com.amap.api.services.core.v */
public class C0496v extends C0476s<WalkRouteQuery, WalkRouteResult> {
    protected /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m4119a(str);
    }

    public C0496v(WalkRouteQuery walkRouteQuery, Proxy proxy) {
        super(walkRouteQuery, proxy);
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C0479d.m3999a(null).m4009f());
        stringBuffer.append("&origin=").append(C0480e.m4014a(((WalkRouteQuery) this.task).getFromAndTo().getFrom()));
        stringBuffer.append("&destination=").append(C0480e.m4014a(((WalkRouteQuery) this.task).getFromAndTo().getTo()));
        stringBuffer.append("&multipath=0");
        stringBuffer.append("&output=json");
        return C0480e.m4029f(stringBuffer.toString());
    }

    /* renamed from: a */
    protected WalkRouteResult m4119a(String str) throws AMapException {
        return C0488m.m4067d(str);
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/direction/walking?";
    }
}
