package com.iflytek.cloud.p022a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.a.c */
public class C0915c {
    /* renamed from: c */
    private static SimpleDateFormat f4367c = new SimpleDateFormat("yyyy.MM.dd");
    /* renamed from: a */
    ArrayList<Integer> f4368a = null;
    /* renamed from: b */
    boolean f4369b = false;
    /* renamed from: d */
    private String f4370d = null;
    /* renamed from: e */
    private String f4371e = null;
    /* renamed from: f */
    private int f4372f = -1;
    /* renamed from: g */
    private String f4373g = bi_常量类.f6358b_空串;
    /* renamed from: h */
    private String f4374h = null;
    /* renamed from: i */
    private String f4375i = null;

    public C0915c(String str, String str2, int i) {
        this.f4374h = str;
        this.f4375i = str2;
        this.f4370d = bi_常量类.f6358b_空串 + i;
    }

    public C0915c(JSONObject jSONObject, boolean z) {
        try {
            this.f4369b = z;
            this.f4370d = jSONObject.getString("id");
            this.f4374h = jSONObject.getString("url");
            if (z) {
                this.f4371e = jSONObject.getString("expire");
                this.f4372f = jSONObject.getInt("valid");
                this.f4373g = jSONObject.getString("pkg");
                return;
            }
            this.f4375i = jSONObject.getString("title");
            this.f4368a = m6984a(jSONObject.getString("code"));
        } catch (JSONException e) {
        }
    }

    /* renamed from: a */
    public String m6983a(ArrayList<Integer> arrayList) {
        String str = bi_常量类.f6358b_空串;
        int i = 0;
        while (i < arrayList.size()) {
            if (i != 0) {
                str = str + ",";
            }
            String str2 = str + String.valueOf(arrayList.get(i));
            i++;
            str = str2;
        }
        return str;
    }

    /* renamed from: a */
    public ArrayList<Integer> m6984a(String str) {
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            String[] split = str.trim().split(",");
            for (String trim : split) {
                arrayList.add(Integer.valueOf(Integer.parseInt(trim.trim())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    /* renamed from: a */
    public boolean m6985a() {
        return !this.f4370d.equals("-1") && this.f4372f >= 0;
    }

    /* renamed from: b */
    public String m6986b() {
        return this.f4374h;
    }

    /* renamed from: c */
    public long m6987c() {
        Date date = new Date(System.currentTimeMillis());
        try {
            date = f4367c.parse(this.f4371e);
        } catch (ParseException e) {
        }
        return date.getTime();
    }

    /* renamed from: d */
    public boolean m6988d() {
        return (this.f4369b && this.f4372f != -1) ? m6987c() >= System.currentTimeMillis() && this.f4372f != 0 : true;
    }

    /* renamed from: e */
    public void m6989e() {
        if (this.f4372f != -1) {
            this.f4372f--;
        }
    }

    /* renamed from: f */
    public String m6990f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f4370d);
            jSONObject.put("url", this.f4374h);
            if (this.f4369b) {
                jSONObject.put("expire", this.f4371e);
                jSONObject.put("valid", String.valueOf(this.f4372f));
                jSONObject.put("pkg", this.f4373g);
            } else {
                jSONObject.put("title", this.f4375i);
                jSONObject.put("code", m6983a(this.f4368a));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String toString() {
        return m6990f();
    }
}
