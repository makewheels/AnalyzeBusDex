package org.json.alipay;

import com.e4a.runtime.components.Component;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: org.json.alipay.b */
public class C1272b {
    /* renamed from: a */
    public static final Object f5719a = new C1271a();
    /* renamed from: b */
    private Map f5720b;

    /* renamed from: org.json.alipay.b$a */
    private static final class C1271a {
        private C1271a() {
        }

        protected final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return "null";
        }
    }

    public C1272b() {
        this.f5720b = new HashMap();
    }

    public C1272b(String str) {
        this(new C1273c(str));
    }

    public C1272b(Map map) {
        if (map == null) {
            map = new HashMap();
        }
        this.f5720b = map;
    }

    public C1272b(C1273c c1273c) {
        this();
        if (c1273c.m8511c() != '{') {
            throw c1273c.m8508a("A JSONObject text must begin with '{'");
        }
        while (true) {
            switch (c1273c.m8511c()) {
                case '\u0000':
                    throw c1273c.m8508a("A JSONObject text must end with '}'");
                case '}':
                    return;
                default:
                    c1273c.m8509a();
                    String obj = c1273c.m8512d().toString();
                    char c = c1273c.m8511c();
                    if (c == '=') {
                        if (c1273c.m8510b() != '>') {
                            c1273c.m8509a();
                        }
                    } else if (c != ':') {
                        throw c1273c.m8508a("Expected a ':' after a key");
                    }
                    Object d = c1273c.m8512d();
                    if (obj == null) {
                        throw new JSONException("Null key.");
                    }
                    if (d != null) {
                        C1272b.m8502b(d);
                        this.f5720b.put(obj, d);
                    } else {
                        this.f5720b.remove(obj);
                    }
                    switch (c1273c.m8511c()) {
                        case Component.KEYCODE_P /*44*/:
                        case Component.KEYCODE_LEFT_SHIFT /*59*/:
                            if (c1273c.m8511c() != '}') {
                                c1273c.m8509a();
                            } else {
                                return;
                            }
                        case '}':
                            return;
                        default:
                            throw c1273c.m8508a("Expected a ',' or '}'");
                    }
            }
        }
    }

    /* renamed from: a */
    static String m8501a(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof C1272b) || (obj instanceof C1270a)) ? obj.toString() : obj instanceof Map ? new C1272b((Map) obj).toString() : obj instanceof Collection ? new C1270a((Collection) obj).toString() : obj.getClass().isArray() ? new C1270a(obj).toString() : C1272b.m8503c(obj.toString());
        } else {
            obj = (Number) obj;
            if (obj == null) {
                throw new JSONException("Null pointer");
            }
            C1272b.m8502b(obj);
            String obj2 = obj.toString();
            if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
                return obj2;
            }
            while (obj2.endsWith("0")) {
                obj2 = obj2.substring(0, obj2.length() - 1);
            }
            return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
        }
    }

    /* renamed from: b */
    private static void m8502b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            if (((Double) obj).isInfinite() || ((Double) obj).isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (!(obj instanceof Float)) {
        } else {
            if (((Float) obj).isInfinite() || ((Float) obj).isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    /* renamed from: c */
    public static String m8503c(String str) {
        int i = 0;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append('\"');
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    stringBuffer.append("\\b");
                    break;
                case '\t':
                    stringBuffer.append("\\t");
                    break;
                case '\n':
                    stringBuffer.append("\\n");
                    break;
                case '\f':
                    stringBuffer.append("\\f");
                    break;
                case '\r':
                    stringBuffer.append("\\r");
                    break;
                case Component.KEYCODE_F /*34*/:
                case '\\':
                    stringBuffer.append('\\');
                    stringBuffer.append(charAt);
                    break;
                case Component.KEYCODE_S /*47*/:
                    if (i2 == 60) {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt);
                    break;
                default:
                    if (charAt >= ' ' && ((charAt < '' || charAt >= ' ') && (charAt < ' ' || charAt >= '℀'))) {
                        stringBuffer.append(charAt);
                        break;
                    }
                    String str2 = "000" + Integer.toHexString(charAt);
                    stringBuffer.append("\\u" + str2.substring(str2.length() - 4));
                    break;
                    break;
            }
            i++;
            char c = charAt;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public final Object m8504a(String str) {
        Object obj = str == null ? null : this.f5720b.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONObject[" + C1272b.m8503c(str) + "] not found.");
    }

    /* renamed from: a */
    public final Iterator m8505a() {
        return this.f5720b.keySet().iterator();
    }

    /* renamed from: b */
    public final boolean m8506b(String str) {
        return this.f5720b.containsKey(str);
    }

    public String toString() {
        try {
            Iterator a = m8505a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (a.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = a.next();
                stringBuffer.append(C1272b.m8503c(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(C1272b.m8501a(this.f5720b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
