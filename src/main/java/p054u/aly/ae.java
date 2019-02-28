package p054u.aly;

import org.json.JSONArray;

/* compiled from: UPage */
/* renamed from: u.aly.ae */
public class ae extends ay {
    public ae(JSONArray jSONArray) throws Exception {
        m8635a(jSONArray);
    }

    public ae(String str) throws Exception {
        m8635a(new JSONArray(str));
    }

    /* renamed from: a */
    private void m8635a(JSONArray jSONArray) throws Exception {
        m8620a(jSONArray.getString(0));
        m8619a((long) jSONArray.getInt(1));
    }
}
