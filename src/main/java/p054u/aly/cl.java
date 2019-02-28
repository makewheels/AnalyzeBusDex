package p054u.aly;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FieldMetaData */
/* renamed from: u.aly.cl */
public class cl implements Serializable {
    /* renamed from: d */
    private static Map<Class<? extends bz>, Map<? extends cg, cl>> f6426d = new HashMap();
    /* renamed from: a */
    public final String f6427a;
    /* renamed from: b */
    public final byte f6428b;
    /* renamed from: c */
    public final cm f6429c;

    public cl(String str, byte b, cm cmVar) {
        this.f6427a = str;
        this.f6428b = b;
        this.f6429c = cmVar;
    }

    /* renamed from: a */
    public static void m10164a(Class<? extends bz> cls, Map<? extends cg, cl> map) {
        f6426d.put(cls, map);
    }

    /* renamed from: a */
    public static Map<? extends cg, cl> m10163a(Class<? extends bz> cls) {
        if (!f6426d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return (Map) f6426d.get(cls);
    }
}
