package p054u.aly;

import org.json.JSONObject;

/* compiled from: URequest */
/* renamed from: u.aly.bp */
public abstract class bp {
    /* renamed from: b */
    protected static String f5645b = "POST";
    /* renamed from: c */
    protected static String f5646c = "GET";
    /* renamed from: d */
    protected String f5647d;

    /* renamed from: a */
    public abstract JSONObject mo1918a();

    /* renamed from: b */
    public abstract String mo1919b();

    /* renamed from: c */
    protected String m8431c() {
        return f5645b;
    }

    public bp(String str) {
        this.f5647d = str;
    }

    /* renamed from: a */
    public void m8429a(String str) {
        this.f5647d = str;
    }

    /* renamed from: d */
    public String m8432d() {
        return this.f5647d;
    }
}
