package p054u.aly;

import org.json.JSONObject;

/* compiled from: ReportResponse */
/* renamed from: u.aly.bn */
public class bn extends bq {
    /* renamed from: a */
    public C1419a f6381a;

    /* compiled from: ReportResponse */
    /* renamed from: u.aly.bn$a */
    public enum C1419a {
        SUCCESS,
        FAIL
    }

    public bn(JSONObject jSONObject) {
        super(jSONObject);
        if ("ok".equalsIgnoreCase(jSONObject.optString("status")) || "ok".equalsIgnoreCase(jSONObject.optString("success"))) {
            this.f6381a = C1419a.SUCCESS;
        } else {
            this.f6381a = C1419a.FAIL;
        }
    }
}
