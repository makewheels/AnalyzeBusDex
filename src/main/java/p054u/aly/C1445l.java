package p054u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Caretaker */
/* renamed from: u.aly.l */
public class C1445l {
    /* renamed from: a */
    private final String f6572a = "umeng_event_snapshot";
    /* renamed from: b */
    private boolean f6573b = false;
    /* renamed from: c */
    private SharedPreferences f6574c;
    /* renamed from: d */
    private Map<String, ArrayList<aa>> f6575d = new HashMap();

    public C1445l(Context context) {
        this.f6574c = C1451u.m10466a(context, "umeng_event_snapshot");
    }

    /* renamed from: a */
    public void m10425a(boolean z) {
        this.f6573b = z;
    }

    /* renamed from: a */
    public int m10423a(String str) {
        if (this.f6575d.containsKey(str)) {
            return ((ArrayList) this.f6575d.get(str)).size();
        }
        return 0;
    }

    /* renamed from: a */
    public void m10424a(String str, aa aaVar) {
        if (this.f6573b) {
            m10422d(str);
        }
        if (this.f6575d.containsKey(str)) {
            ((ArrayList) this.f6575d.get(str)).add(aaVar);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aaVar);
            this.f6575d.put(str, arrayList);
        }
        if (this.f6573b) {
            m10421c(str);
        }
    }

    /* renamed from: b */
    public aa m10426b(String str) {
        aa aaVar;
        if (this.f6573b) {
            m10422d(str);
        }
        if (this.f6575d.containsKey(str)) {
            ArrayList arrayList = (ArrayList) this.f6575d.get(str);
            if (arrayList.size() > 0) {
                aaVar = (aa) arrayList.remove(arrayList.size() - 1);
                if (this.f6573b) {
                    m10421c(str);
                }
                return aaVar;
            }
        }
        aaVar = null;
        if (this.f6573b) {
            m10421c(str);
        }
        return aaVar;
    }

    /* renamed from: c */
    private void m10421c(String str) {
        String str2 = null;
        if (this.f6575d.containsKey(str)) {
            Serializable serializable = (ArrayList) this.f6575d.get(str);
            while (serializable.size() > 4) {
                serializable.remove(0);
            }
            str2 = C1450s.m10462a(serializable);
        }
        this.f6574c.edit().putString(str, str2).commit();
    }

    /* renamed from: d */
    private boolean m10422d(String str) {
        if (this.f6575d.containsKey(str)) {
            return true;
        }
        String string = this.f6574c.getString(str, null);
        if (string != null) {
            ArrayList arrayList = (ArrayList) C1450s.m10461a(string);
            if (arrayList != null) {
                this.f6575d.put(str, arrayList);
                return true;
            }
        }
        return false;
    }
}
