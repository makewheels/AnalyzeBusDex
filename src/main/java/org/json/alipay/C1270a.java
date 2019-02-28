package org.json.alipay;

import com.e4a.runtime.components.Component;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: org.json.alipay.a */
public class C1270a {
    /* renamed from: a */
    private ArrayList f5718a;

    public C1270a() {
        this.f5718a = new ArrayList();
    }

    public C1270a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                this.f5718a.add(Array.get(obj, i));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public C1270a(String str) {
        this(new C1273c(str));
    }

    public C1270a(Collection collection) {
        this.f5718a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public C1270a(C1273c c1273c) {
        this();
        char c = c1273c.m8511c();
        if (c == '[') {
            c = ']';
        } else if (c == '(') {
            c = ')';
        } else {
            throw c1273c.m8508a("A JSONArray text must start with '['");
        }
        if (c1273c.m8511c() != ']') {
            c1273c.m8509a();
            while (true) {
                if (c1273c.m8511c() == ',') {
                    c1273c.m8509a();
                    this.f5718a.add(null);
                } else {
                    c1273c.m8509a();
                    this.f5718a.add(c1273c.m8512d());
                }
                char c2 = c1273c.m8511c();
                switch (c2) {
                    case Component.KEYCODE_M /*41*/:
                    case ']':
                        if (c != c2) {
                            throw c1273c.m8508a("Expected a '" + new Character(c) + "'");
                        }
                        return;
                    case Component.KEYCODE_P /*44*/:
                    case Component.KEYCODE_LEFT_SHIFT /*59*/:
                        if (c1273c.m8511c() != ']') {
                            c1273c.m8509a();
                        } else {
                            return;
                        }
                    default:
                        throw c1273c.m8508a("Expected a ',' or ']'");
                }
            }
        }
    }

    /* renamed from: a */
    private String m8498a(String str) {
        int size = this.f5718a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(C1272b.m8501a(this.f5718a.get(i)));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public final int m8499a() {
        return this.f5718a.size();
    }

    /* renamed from: a */
    public final Object m8500a(int i) {
        Object obj = (i < 0 || i >= this.f5718a.size()) ? null : this.f5718a.get(i);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public String toString() {
        try {
            return "[" + m8498a(",") + ']';
        } catch (Exception e) {
            return null;
        }
    }
}
