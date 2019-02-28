package p054u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: UEKV */
/* renamed from: u.aly.ab */
public class ab extends ao implements C1275p {
    public ab(String str, Map<String, Object> map, long j, int i) {
        m8541a(str);
        m8546b(System.currentTimeMillis());
        if (map.size() > 0) {
            m8542a(m8576b(map));
        }
        if (i <= 0) {
            i = 1;
        }
        m8539a(i);
        if (j > 0) {
            m8540a(j);
        }
    }

    /* renamed from: b */
    private HashMap<String, az> m8576b(Map<String, Object> map) {
        Iterator it = map.entrySet().iterator();
        HashMap<String, az> hashMap = new HashMap();
        int i = 0;
        while (i < 10 && it.hasNext()) {
            Entry entry = (Entry) it.next();
            az azVar = new az();
            Object value = entry.getValue();
            if (value instanceof String) {
                azVar.m9587b((String) value);
            } else if (value instanceof Long) {
                azVar.m9586b(((Long) value).longValue());
            } else if (value instanceof Integer) {
                azVar.m9586b(((Integer) value).longValue());
            } else if (value instanceof Float) {
                azVar.m9586b(((Float) value).longValue());
            } else if (value instanceof Double) {
                azVar.m9586b(((Double) value).longValue());
            }
            if (azVar.m9568k()) {
                hashMap.put(entry.getKey(), azVar);
                i++;
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public static aa m8574a(String str, String str2, Map<String, Object> map) {
        aa aaVar = new aa();
        aaVar.f5732b = str;
        aaVar.f5733c = str2;
        aaVar.f5734d = map;
        return aaVar;
    }

    /* renamed from: b */
    public static String m8575b(String str, String str2, Map<String, Object> map) {
        return str + str2;
    }

    /* renamed from: a */
    public void mo1926a(bf bfVar, String str) {
        if (bfVar.m9822s() > 0) {
            for (av avVar : bfVar.m9824u()) {
                if (str.equals(avVar.m9360c())) {
                    break;
                }
            }
        }
        av avVar2 = null;
        if (avVar2 == null) {
            avVar2 = new av();
            avVar2.m9348a(str);
            bfVar.m9790a(avVar2);
        }
        avVar2.m9351a((ao) this);
    }
}
