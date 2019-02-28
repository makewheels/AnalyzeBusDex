package com.amap.api.services.core;

import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReverseGeocodingHandler */
/* renamed from: com.amap.api.services.core.u */
public class C0495u extends C0476s<RegeocodeQuery, RegeocodeAddress> {
    protected /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m4118a(str);
    }

    public C0495u(RegeocodeQuery regeocodeQuery, Proxy proxy) {
        super(regeocodeQuery, proxy);
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/geocode/regeo?";
    }

    /* renamed from: a */
    protected RegeocodeAddress m4118a(String str) throws AMapException {
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("regeocode");
            regeocodeAddress.setFormatAddress(C0488m.m4055b(jSONObject, "formatted_address"));
            C0488m.m4051a(jSONObject.getJSONObject("addressComponent"), regeocodeAddress);
            C0488m.m4065c(jSONObject.getJSONArray("pois"), regeocodeAddress);
            C0488m.m4059b(jSONObject.getJSONArray("roads"), regeocodeAddress);
            C0488m.m4049a(jSONObject.getJSONArray("roadinters"), regeocodeAddress);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return regeocodeAddress;
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&extensions=all").append("&location=").append(((RegeocodeQuery) this.task).getPoint().getLongitude()).append(",").append(((RegeocodeQuery) this.task).getPoint().getLatitude());
        stringBuffer.append("&radius=").append(((RegeocodeQuery) this.task).getRadius());
        stringBuffer.append("&coordsys=").append(((RegeocodeQuery) this.task).getLatLonType());
        stringBuffer.append("&key=" + C0479d.m3999a(null).m4009f());
        return C0480e.m4029f(stringBuffer.toString());
    }
}
