package com.iflytek.cloud.util;

import android.text.TextUtils;
import com.alipay.sdk.cons.C0110c;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class UserWords {
    /* renamed from: a */
    private Hashtable<String, ArrayList<String>> f4609a;

    public UserWords() {
        this.f4609a = null;
        this.f4609a = new Hashtable();
    }

    public UserWords(String str) {
        this.f4609a = null;
        this.f4609a = new Hashtable();
        m7296a(str);
    }

    /* renamed from: a */
    private String m7295a() {
        try {
            if (this.f4609a == null) {
                C0939a.m7120a("mwords is null...");
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f4609a.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                Iterator it = ((ArrayList) entry.getValue()).iterator();
                while (it.hasNext()) {
                    jSONArray2.put((String) it.next());
                }
                jSONObject2.put("words", jSONArray2);
                jSONObject2.put(C0110c.f289e, entry.getKey());
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("userword", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m7296a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                C0939a.m7120a("userword is null...");
                return;
            }
            JSONArray jSONArray = new JSONObject(new JSONTokener(str)).getJSONArray("userword");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                JSONArray jSONArray2 = jSONObject.getJSONArray("words");
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    String obj = jSONArray2.get(i2).toString();
                    if (!(arrayList == null || arrayList.contains(obj))) {
                        arrayList.add(obj);
                    }
                }
                this.f4609a.put(jSONObject.get(C0110c.f289e).toString(), arrayList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m7297a(ArrayList<String> arrayList, String str) {
        if (arrayList == null || arrayList.contains(str)) {
            return false;
        }
        arrayList.add(str);
        return true;
    }

    /* renamed from: a */
    private boolean m7298a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList == null || arrayList2 == null) {
            return false;
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            m7297a((ArrayList) arrayList, (String) it.next());
        }
        return true;
    }

    public ArrayList<String> getKeys() {
        if (this.f4609a == null || this.f4609a.isEmpty()) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (Object add : this.f4609a.keySet()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public ArrayList<String> getWords() {
        return getWords("default");
    }

    public ArrayList<String> getWords(String str) {
        return (ArrayList) this.f4609a.get(str);
    }

    public boolean hasKey(String str) {
        return this.f4609a.containsKey(str);
    }

    public boolean putWord(String str) {
        return putWord("default", str);
    }

    public boolean putWord(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        ArrayList words = getWords(str);
        if (words != null) {
            m7297a(words, str2);
        } else {
            words = new ArrayList();
            m7297a(words, str2);
            this.f4609a.put(str, words);
        }
        return true;
    }

    public boolean putWords(String str, ArrayList<String> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        ArrayList words = getWords(str);
        if (words != null) {
            m7298a(words, (ArrayList) arrayList);
        } else {
            m7298a(new ArrayList(), (ArrayList) arrayList);
            this.f4609a.put(str, arrayList);
        }
        return true;
    }

    public boolean putWords(ArrayList<String> arrayList) {
        return putWords("default", arrayList);
    }

    public String toString() {
        return m7295a();
    }
}
