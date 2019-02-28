package com.amap.api.services.core;

import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;
import java.net.Proxy;
import p054u.aly.bi_常量类;

/* compiled from: DriveRouteSearchHandler */
/* renamed from: com.amap.api.services.core.g */
public class C0482g extends C0476s<DriveRouteQuery, DriveRouteResult> {
    protected /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m4031a(str);
    }

    public C0482g(DriveRouteQuery driveRouteQuery, Proxy proxy) {
        super(driveRouteQuery, proxy);
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=").append(C0479d.m3999a(null).m4009f());
        stringBuffer.append("&origin=").append(C0480e.m4014a(((DriveRouteQuery) this.task).getFromAndTo().getFrom()));
        if (!C0488m.m4078h(((DriveRouteQuery) this.task).getFromAndTo().getStartPoiID())) {
            stringBuffer.append("&originid=").append(((DriveRouteQuery) this.task).getFromAndTo().getStartPoiID());
        }
        stringBuffer.append("&destination=").append(C0480e.m4014a(((DriveRouteQuery) this.task).getFromAndTo().getTo()));
        if (!C0488m.m4078h(((DriveRouteQuery) this.task).getFromAndTo().getDestinationPoiID())) {
            stringBuffer.append("&destinationid=").append(((DriveRouteQuery) this.task).getFromAndTo().getDestinationPoiID());
        }
        stringBuffer.append("&strategy=").append(bi_常量类.f6358b + ((DriveRouteQuery) this.task).getMode());
        stringBuffer.append("&extensions=all");
        if (((DriveRouteQuery) this.task).hasPassPoint()) {
            stringBuffer.append("&waypoints=").append(((DriveRouteQuery) this.task).getPassedPointStr());
        }
        if (((DriveRouteQuery) this.task).hasAvoidpolygons()) {
            stringBuffer.append("&avoidpolygons=").append(((DriveRouteQuery) this.task).getAvoidpolygonsStr());
        }
        if (((DriveRouteQuery) this.task).hasAvoidRoad()) {
            stringBuffer.append("&avoidroad=").append(((DriveRouteQuery) this.task).getAvoidRoad());
        }
        stringBuffer.append("&output=json");
        return C0480e.m4029f(stringBuffer.toString());
    }

    /* renamed from: a */
    protected DriveRouteResult m4031a(String str) throws AMapException {
        return C0488m.m4061c(str);
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/direction/driving?";
    }
}
