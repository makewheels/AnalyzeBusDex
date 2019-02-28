package com.iflytek.cloud.p030c;

import android.text.TextUtils;
import com.alipay.sdk.cons.C0108a;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.iflytek.cloud.c.a */
public class C0950a {
    /* renamed from: a */
    HashMap<String, String> f4501a = new HashMap();

    public C0950a(String str, String[][] strArr) {
        m7169a(str);
        m7172a(strArr);
    }

    /* renamed from: a */
    public int m7166a(String str, int i) {
        if (this.f4501a.containsKey(str)) {
            try {
                i = Integer.parseInt((String) this.f4501a.get(str));
            } catch (Exception e) {
            }
        }
        return i;
    }

    /* renamed from: a */
    public void m7167a() {
        this.f4501a.clear();
    }

    /* renamed from: a */
    public void m7168a(C0950a c0950a, String str) {
        if (c0950a != null) {
            m7170a(str, c0950a.m7179d(str));
        }
    }

    /* renamed from: a */
    public void m7169a(String str) {
        this.f4501a.clear();
        m7176b(str);
    }

    /* renamed from: a */
    public void m7170a(String str, String str2) {
        m7171a(str, str2, true);
    }

    /* renamed from: a */
    public void m7171a(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (z || !this.f4501a.containsKey(str)) {
                this.f4501a.put(str, str2);
            }
        }
    }

    /* renamed from: a */
    public void m7172a(String[][] strArr) {
        if (strArr != null) {
            for (Object[] objArr : strArr) {
                if (this.f4501a.containsKey(objArr[0])) {
                    String str = (String) this.f4501a.get(objArr[0]);
                    this.f4501a.remove(objArr[0]);
                    for (int i = 1; i < objArr.length; i++) {
                        this.f4501a.put(objArr[i], str);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m7173a(String str, boolean z) {
        if (!this.f4501a.containsKey(str)) {
            return z;
        }
        String str2 = (String) this.f4501a.get(str);
        return (str2.equals("true") || str2.equals(C0108a.f262e)) ? true : (str2.equals("false") || str2.equals("0")) ? false : z;
    }

    /* renamed from: b */
    public C0950a m7174b() {
        C0950a c0950a = new C0950a();
        for (Entry entry : this.f4501a.entrySet()) {
            c0950a.m7170a((String) entry.getKey(), (String) entry.getValue());
        }
        return c0950a;
    }

    /* renamed from: b */
    public String m7175b(String str, String str2) {
        return !this.f4501a.containsKey(str) ? str2 : (String) this.f4501a.get(str);
    }

    /* renamed from: b */
    public void m7176b(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                int indexOf = str2.indexOf("=");
                if (indexOf > 0 && indexOf < str2.length()) {
                    this.f4501a.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                }
            }
        }
    }

    /* renamed from: c */
    public Boolean m7177c(String str) {
        if (TextUtils.isEmpty(str)) {
            return Boolean.valueOf(false);
        }
        if (!this.f4501a.containsKey(str)) {
            return Boolean.valueOf(false);
        }
        this.f4501a.remove(str);
        return Boolean.valueOf(true);
    }

    /* renamed from: c */
    public HashMap<String, String> m7178c() {
        return this.f4501a;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m7174b();
    }

    /* renamed from: d */
    public String m7179d(String str) {
        return !this.f4501a.containsKey(str) ? null : (String) this.f4501a.get(str);
    }

    /* renamed from: d */
    public void m7180d() {
        for (Entry entry : this.f4501a.entrySet()) {
            Object replaceAll = ((String) entry.getValue()).replaceAll("[,\n ]", "|");
            if (replaceAll.length() > 124) {
                replaceAll = replaceAll.substring(0, 124);
            }
            entry.setValue(replaceAll);
        }
    }

    public String toString() {
        m7180d();
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : this.f4501a.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) entry.getValue());
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        String stringBuffer2 = stringBuffer.toString();
        C0939a.m7122b(stringBuffer2);
        return stringBuffer2;
    }
}
