package com.amap.api.services.core;

import com.amap.api.services.help.Tip;
import java.net.Proxy;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InputtipsHandler */
/* renamed from: com.amap.api.services.core.k */
public class C0486k extends C0476s<C0487l, ArrayList<Tip>> {
    protected /* synthetic */ Object paseJSON(String str) throws AMapException {
        return m4040a(str);
    }

    public C0486k(C0487l c0487l, Proxy proxy) {
        super(c0487l, proxy);
    }

    /* renamed from: a */
    protected ArrayList<Tip> m4040a(String str) throws AMapException {
        ArrayList<Tip> arrayList = null;
        try {
            arrayList = C0488m.m4089o(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    protected String getUrl() {
        return "http://restapi.amap.com/v3/assistant/inputtips?";
    }

    protected String getRequestString(boolean z) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json").append("&keywords=").append(strEncoder(((C0487l) this.task).f2945a, z));
        String str = ((C0487l) this.task).f2946b;
        if (!C0488m.m4078h(str)) {
            stringBuffer.append("&city=").append(strEncoder(str, z));
        }
        stringBuffer.append("&key=" + C0479d.m3999a(null).m4009f());
        return C0480e.m4029f(stringBuffer.toString());
    }
}
