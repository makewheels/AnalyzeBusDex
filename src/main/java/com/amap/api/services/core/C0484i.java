package com.amap.api.services.core;

import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.net.Proxy;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GeocodingHandler */
/* renamed from: com.amap.api.services.core.i */
public class C0484i extends C0476s<GeocodeQuery, ArrayList<GeocodeAddress>> {
    protected /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m4037a(str);
    }

    public C0484i(GeocodeQuery geocodeQuery, Proxy proxy) {
        super(geocodeQuery, proxy);
    }

    /* renamed from: a */
    protected ArrayList<GeocodeAddress> m4037a(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("count") && jSONObject.getInt("count") > 0) {
                arrayList = C0488m.m4088n(jSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/geocode/geo?";
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&address=").append(strEncoder(((GeocodeQuery) this.task).getLocationName(), z));
        String city = ((GeocodeQuery) this.task).getCity();
        if (!C0488m.m4078h(city)) {
            stringBuffer.append("&city=").append(strEncoder(city, z));
        }
        stringBuffer.append("&key=" + C0479d.m3999a(null).m4009f());
        return C0480e.m4029f(stringBuffer.toString());
    }
}
