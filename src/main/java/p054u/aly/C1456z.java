package p054u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.analytics.C1233a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ViewPageTracker */
/* renamed from: u.aly.z */
public class C1456z {
    /* renamed from: a */
    private static final String f6623a = "activities";
    /* renamed from: b */
    private final Map<String, Long> f6624b = new HashMap();
    /* renamed from: c */
    private final ArrayList<C1454x> f6625c = new ArrayList();

    /* renamed from: a */
    public void m10491a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f6624b) {
                this.f6624b.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* renamed from: b */
    public void m10492b(String str) {
        if (!TextUtils.isEmpty(str)) {
            Long l;
            synchronized (this.f6624b) {
                l = (Long) this.f6624b.remove(str);
            }
            if (l == null) {
                bj.m10008e(C1233a.f5589e, String.format("please call 'onPageStart(%s)' before onPageEnd", new Object[]{str}));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - l.longValue();
            synchronized (this.f6625c) {
                this.f6625c.add(new C1454x(str, currentTimeMillis));
            }
        }
    }

    /* renamed from: a */
    public void m10489a() {
        String str = null;
        long j = 0;
        synchronized (this.f6624b) {
            for (Entry entry : this.f6624b.entrySet()) {
                String str2;
                long longValue;
                if (((Long) entry.getValue()).longValue() > j) {
                    str2 = (String) entry.getKey();
                    longValue = ((Long) entry.getValue()).longValue();
                } else {
                    longValue = j;
                    str2 = str;
                }
                str = str2;
                j = longValue;
            }
        }
        if (str != null) {
            m10492b(str);
        }
    }

    /* renamed from: a */
    public void m10490a(Context context) {
        SharedPreferences a = C1451u.m10465a(context);
        Editor edit = a.edit();
        if (this.f6625c.size() > 0) {
            Object string = a.getString(f6623a, bi_常量类.f6358b);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(string)) {
                stringBuilder.append(string);
                stringBuilder.append(";");
            }
            synchronized (this.f6625c) {
                Iterator it = this.f6625c.iterator();
                while (it.hasNext()) {
                    C1454x c1454x = (C1454x) it.next();
                    stringBuilder.append(String.format("[\"%s\",%d]", new Object[]{c1454x.f6619a, Long.valueOf(c1454x.f6620b)}));
                    stringBuilder.append(";");
                }
                this.f6625c.clear();
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            edit.remove(f6623a);
            edit.putString(f6623a, stringBuilder.toString());
        }
        edit.commit();
    }

    /* renamed from: a */
    public static List<ay> m10488a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(f6623a, bi_常量类.f6358b);
        if (bi_常量类.f6358b.equals(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            String[] split = string.split(";");
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(new ae(str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }
}
