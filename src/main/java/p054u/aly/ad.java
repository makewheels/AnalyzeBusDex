package p054u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: UGKV */
/* renamed from: u.aly.ad */
public class ad extends ao implements C1275p {
    public ad(String str, Map<String, Object> map) {
        m8541a(str);
        m8546b(System.currentTimeMillis());
        if (map.size() > 0) {
            m8542a(m8610b(map));
        }
        m8539a(this.d > 0 ? this.d : 1);
    }

    /* renamed from: b */
    private HashMap<String, az> m8610b(Map<String, Object> map) {
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
        avVar2.m9357b((ao) this);
    }
}
