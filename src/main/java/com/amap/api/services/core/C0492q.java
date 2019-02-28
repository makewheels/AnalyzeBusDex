package com.amap.api.services.core;

import com.amap.api.services.poisearch.PoiHandler;
import com.amap.api.services.poisearch.PoiItemDetail;
import java.net.Proxy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PoiSearchIdHandler */
/* renamed from: com.amap.api.services.core.q */
public class C0492q extends PoiHandler<String, PoiItemDetail> {
    public /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m4106a(str);
    }

    public C0492q(String str, Proxy proxy) {
        super(str, proxy);
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/place/detail?";
    }

    /* renamed from: a */
    public PoiItemDetail m4106a(String str) throws AMapException {
        PoiItemDetail poiItemDetail = null;
        try {
            poiItemDetail = m4104a(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return poiItemDetail;
    }

    /* renamed from: a */
    private PoiItemDetail m4104a(JSONObject jSONObject) throws JSONException {
        PoiItemDetail poiItemDetail = null;
        if (jSONObject != null && jSONObject.has("pois")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray.length() > 0) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                poiItemDetail = C0488m.m4066d(jSONObject2);
                if (jSONObject2.has("rich_content")) {
                    C0488m.m4046a(poiItemDetail, jSONObject2.optJSONObject("rich_content"));
                }
                if (jSONObject2.has("deep_info")) {
                    C0488m.m4072e(poiItemDetail, jSONObject2.optJSONObject("deep_info"), jSONObject2);
                }
            }
        }
        return poiItemDetail;
    }

    protected String getRequestString(boolean z) {
        return m4105a();
    }

    /* renamed from: a */
    private String m4105a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=").append((String) this.task);
        stringBuilder.append("&output=json");
        stringBuilder.append("&extensions=all");
        stringBuilder.append("&key=" + C0479d.m3999a(null).m4009f());
        return C0480e.m4029f(stringBuilder.toString());
    }
}
