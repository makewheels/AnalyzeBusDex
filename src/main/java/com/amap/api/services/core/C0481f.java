package com.amap.api.services.core;

import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.net.Proxy;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DistrictServerHandler */
/* renamed from: com.amap.api.services.core.f */
public class C0481f extends C0476s<DistrictSearchQuery, DistrictResult> {
    protected /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m4030a(str);
    }

    public C0481f(DistrictSearchQuery districtSearchQuery, Proxy proxy) {
        super(districtSearchQuery, proxy);
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=").append(((DistrictSearchQuery) this.task).getPageNum() + 1);
        stringBuffer.append("&offset=").append(((DistrictSearchQuery) this.task).getPageSize());
        stringBuffer.append("&showChild=").append(((DistrictSearchQuery) this.task).isShowChild());
        if (((DistrictSearchQuery) this.task).checkKeyWords()) {
            stringBuffer.append("&keywords=").append(strEncoder(((DistrictSearchQuery) this.task).getKeywords(), z));
        }
        if (((DistrictSearchQuery) this.task).checkLevels()) {
            stringBuffer.append("&level=").append(((DistrictSearchQuery) this.task).getKeywordsLevel());
        }
        stringBuffer.append("&key=" + C0479d.m3999a(null).m4009f());
        return C0480e.m4029f(stringBuffer.toString());
    }

    /* renamed from: a */
    protected DistrictResult m4030a(String str) throws AMapException {
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) this.task, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.getInt("count"));
            C0488m.m4050a(jSONObject.optJSONArray("districts"), arrayList, null);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return districtResult;
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/config/district?";
    }
}
