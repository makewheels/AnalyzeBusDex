package com.ta.utdid2.p036a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ta.utdid2.p037b.p038a.C1015c;
import com.ta.utdid2.p037b.p038a.C1017e;
import com.ut.device.AidCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: AidRequester */
/* renamed from: com.ta.utdid2.a.b */
public class C1008b {
    /* renamed from: a */
    private static final String f4674a = C1008b.class.getName();
    /* renamed from: b */
    private static C1008b f4675b = null;
    /* renamed from: c */
    private Context f4676c;
    /* renamed from: d */
    private Object f4677d = new Object();

    /* compiled from: AidRequester */
    /* renamed from: com.ta.utdid2.a.b$a */
    class C1007a extends Thread {
        /* renamed from: a */
        HttpPost f4667a;
        /* renamed from: b */
        String f4668b = bi_常量类.f6358b_空串;
        /* renamed from: c */
        AidCallback f4669c;
        /* renamed from: d */
        String f4670d;
        /* renamed from: e */
        String f4671e;
        /* renamed from: f */
        String f4672f = bi_常量类.f6358b_空串;
        /* renamed from: g */
        final /* synthetic */ C1008b f4673g;

        public C1007a(C1008b c1008b, HttpPost httpPost) {
            this.f4673g = c1008b;
            this.f4667a = httpPost;
        }

        public C1007a(C1008b c1008b, HttpPost httpPost, AidCallback aidCallback, String str, String str2, String str3) {
            this.f4673g = c1008b;
            this.f4667a = httpPost;
            this.f4669c = aidCallback;
            this.f4670d = str;
            this.f4671e = str2;
            this.f4672f = str3;
        }

        public final void run() {
            HttpResponse execute;
            String readLine;
            BufferedReader bufferedReader = null;
            if (this.f4669c != null) {
                this.f4669c.onAidEventChanged(1000, this.f4670d);
            }
            try {
                execute = new DefaultHttpClient().execute(this.f4667a);
            } catch (Exception e) {
                if (this.f4669c != null) {
                    this.f4669c.onAidEventChanged(1002, this.f4670d);
                }
                Log.e(C1008b.f4674a, e.toString());
                execute = null;
            }
            if (execute != null) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(execute.getEntity().getContent(), Charset.forName("UTF-8")));
                } catch (Exception e2) {
                    if (this.f4669c != null) {
                        this.f4669c.onAidEventChanged(1002, this.f4670d);
                    }
                    Log.e(C1008b.f4674a, e2.toString());
                }
            } else {
                Log.e(C1008b.f4674a, "response is null!");
            }
            if (bufferedReader != null) {
                while (true) {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (C1015c.f4699a) {
                            Log.d(C1008b.f4674a, readLine);
                        }
                        this.f4668b = readLine;
                    } catch (Exception e22) {
                        if (this.f4669c != null) {
                            this.f4669c.onAidEventChanged(1002, this.f4670d);
                        }
                        Log.e(C1008b.f4674a, e22.toString());
                    }
                }
            } else {
                Log.e(C1008b.f4674a, "BufferredReader is null!");
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    if (C1015c.f4699a) {
                        Log.d(C1008b.f4674a, "close the bufferreader");
                    }
                } catch (IOException e3) {
                    Log.e(C1008b.f4674a, e3.toString());
                }
            }
            if (this.f4669c == null) {
                synchronized (this.f4673g.f4677d) {
                    this.f4673g.f4677d.notifyAll();
                }
                return;
            }
            readLine = C1008b.m7358b(this.f4668b, this.f4670d);
            this.f4669c.onAidEventChanged(1001, readLine);
            C1009c.m7364a(this.f4673g.f4676c, this.f4671e, readLine, this.f4672f);
        }

        /* renamed from: a */
        public final String m7352a() {
            return this.f4668b;
        }
    }

    /* renamed from: a */
    public static synchronized C1008b m7353a(Context context) {
        C1008b c1008b;
        synchronized (C1008b.class) {
            if (f4675b == null) {
                f4675b = new C1008b(context);
            }
            c1008b = f4675b;
        }
        return c1008b;
    }

    private C1008b(Context context) {
        this.f4676c = context;
    }

    /* renamed from: a */
    public final void m7361a(String str, String str2, String str3, String str4, AidCallback aidCallback) {
        String b = C1008b.m7359b(str, str2, str3, str4);
        if (C1015c.f4699a) {
            Log.d(f4674a, "url:" + b + "; len:" + b.length());
        }
        new C1007a(this, new HttpPost(b), aidCallback, str4, str, str2).start();
    }

    /* renamed from: a */
    public final String m7360a(String str, String str2, String str3, String str4) {
        String b = C1008b.m7359b(str, str2, str3, str4);
        int i = C1017e.m7377b(this.f4676c) ? 3000 : 1000;
        if (C1015c.f4699a) {
            Log.d(f4674a, "url:" + b + "; timeout:" + i);
        }
        C1007a c1007a = new C1007a(this, new HttpPost(b));
        c1007a.start();
        try {
            synchronized (this.f4677d) {
                this.f4677d.wait((long) i);
            }
        } catch (Exception e) {
            Log.e(f4674a, e.toString());
        }
        String a = c1007a.m7352a();
        if (C1015c.f4699a) {
            Log.d(f4674a, "mLine:" + a);
        }
        return C1008b.m7358b(a, str4);
    }

    /* renamed from: b */
    private static String m7358b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string;
            if (jSONObject.has("data")) {
                jSONObject = jSONObject.getJSONObject("data");
                if (!jSONObject.has("action") || !jSONObject.has("aid")) {
                    return str2;
                }
                string = jSONObject.getString("action");
                return (string.equalsIgnoreCase("new") || string.equalsIgnoreCase("changed")) ? jSONObject.getString("aid") : str2;
            } else if (!jSONObject.has("isError") || !jSONObject.has("status")) {
                return str2;
            } else {
                string = jSONObject.getString("isError");
                String string2 = jSONObject.getString("status");
                if (!string.equalsIgnoreCase("true")) {
                    return str2;
                }
                if (!string2.equalsIgnoreCase("404") && !string2.equalsIgnoreCase("401")) {
                    return str2;
                }
                if (C1015c.f4699a) {
                    Log.d(f4674a, "remove the AID, status:" + string2);
                }
                return bi_常量类.f6358b_空串;
            }
        } catch (JSONException e) {
            Log.e(f4674a, e.toString());
            return str2;
        } catch (Exception e2) {
            Log.e(f4674a, e2.toString());
            return str2;
        }
    }

    /* renamed from: b */
    private static String m7359b(String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            str3 = URLEncoder.encode(str3, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return stringBuilder.append("http://hydra.alibaba.com/").append(str).append("/get_aid/?auth[token]=").append(str2).append("&type=utdid&id=").append(str3).append("&aid=").append(str4).toString();
    }
}
