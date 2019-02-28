package com.alipay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.cons.C0109b;
import com.alipay.sdk.cons.C0110c;
import com.alipay.sdk.data.C0111a;
import com.alipay.sdk.data.C0112b;
import com.alipay.sdk.data.C0113c;
import com.alipay.sdk.data.C0115e;
import com.alipay.sdk.data.C0116f;
import com.alipay.sdk.encrypt.C0117a;
import com.alipay.sdk.encrypt.C0119c;
import com.alipay.sdk.encrypt.C0121e;
import com.alipay.sdk.exception.NetErrorException;
import com.alipay.sdk.protocol.C0128c;
import com.alipay.sdk.protocol.C0131e;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.tid.C0139b;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Calendar;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi;

/* renamed from: com.alipay.sdk.net.d */
public final class C0125d {
    /* renamed from: a */
    private int f355a = 0;
    /* renamed from: b */
    private C0113c f356b;

    public C0125d(C0113c c0113c) {
        this.f356b = c0113c;
    }

    /* renamed from: a */
    private String m400a(Context context, String str, String str2, C0113c c0113c, C0116f c0116f) throws NetErrorException {
        try {
            if (C0124c.f354a == null) {
                C0124c.f354a = new C0122a(context, str);
            } else if (!TextUtils.equals(str, C0124c.f354a.f349a)) {
                C0124c.f354a.f349a = str;
            }
            HttpResponse a = c0113c != null ? C0124c.f354a.m381a(str2, c0113c) : C0124c.f354a.m381a(str2, null);
            StatusLine statusLine = a.getStatusLine();
            c0116f.f325c = statusLine.getStatusCode();
            c0116f.f326d = statusLine.getReasonPhrase();
            C0113c c0113c2 = this.f356b;
            Header[] headers = a.getHeaders("Msp-Param");
            if (c0113c2 != null && headers.length > 0) {
                c0113c2.f306b = headers;
            }
            String a2 = C0124c.m397a(a);
            C0124c.f354a = null;
            return a2;
        } catch (Exception e) {
            throw new NetErrorException();
        } catch (Throwable th) {
            C0124c.f354a = null;
        }
    }

    /* renamed from: a */
    private static String m401a(String str) {
        InputStream fileInputStream;
        Throwable th;
        String str2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                char[] cArr = new char[2048];
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    stringBuilder.append(cArr, 0, read);
                }
                bufferedReader.close();
                str2 = stringBuilder.toString();
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            Object obj = str2;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str2;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            fileInputStream = str2;
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str2;
    }

    /* renamed from: a */
    private JSONObject m402a(Context context, C0115e c0115e, C0116f c0116f) throws NetErrorException {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 65.0d))));
                    break;
                case 1:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 97.0d))));
                    break;
                case 2:
                    stringBuilder.append(String.valueOf(new Random().nextInt(10)));
                    break;
                default:
                    break;
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        try {
            String a = m400a(context, c0115e.f316a.f299a, c0115e.m338a(stringBuilder2).toString(), (C0113c) c0115e.f317b.get(), c0116f);
            c0116f.f327e = Calendar.getInstance().getTimeInMillis();
            JSONObject a2;
            if (c0115e.f318c) {
                a2 = C0125d.m405a(a, c0116f);
                if (c0116f.f325c != 1000 || this.f355a >= 3) {
                    this.f355a = 0;
                    String b = C0121e.m370b(stringBuilder2, a2.optString("res_data"));
                    "respData:" + b;
                    return new JSONObject(b);
                }
                this.f355a++;
                return m402a(context, c0115e, c0116f);
            }
            a2 = C0125d.m405a(a, c0116f);
            "respData:" + a2.toString();
            return a2;
        } catch (NetErrorException e) {
            throw e;
        } catch (Exception e2) {
            throw new NetErrorException();
        }
    }

    /* renamed from: a */
    private JSONObject m403a(Context context, C0115e c0115e, C0116f c0116f, String str, String str2) throws JSONException, NetErrorException {
        JSONObject a = C0125d.m405a(str2, c0116f);
        if (c0116f.f325c != 1000 || this.f355a >= 3) {
            this.f355a = 0;
            String b = C0121e.m370b(str, a.optString("res_data"));
            "respData:" + b;
            return new JSONObject(b);
        }
        this.f355a++;
        return m402a(context, c0115e, c0116f);
    }

    /* renamed from: a */
    private static JSONObject m404a(C0116f c0116f, String str) throws JSONException {
        JSONObject a = C0125d.m405a(str, c0116f);
        "respData:" + a.toString();
        return a;
    }

    /* renamed from: a */
    private static JSONObject m405a(String str, C0116f c0116f) throws JSONException {
        JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
        if (optJSONObject != null) {
            c0116f.f325c = optJSONObject.optInt("code", C0116f.f324b);
            c0116f.f326d = optJSONObject.optString("error_msg", bi.f6358b);
            optJSONObject = optJSONObject.optJSONObject("params");
            if (optJSONObject != null) {
                if (c0116f.f325c == 1000) {
                    String optString = optJSONObject.optString("public_key");
                    if (!TextUtils.isEmpty(optString)) {
                        C0136b.m459a().f415b.m326a(optString);
                    }
                }
                C0111a c0111a = new C0111a();
                c0111a.f301c = optJSONObject.optString("next_api_name");
                c0111a.f302d = optJSONObject.optString("next_api_version");
                c0111a.f300b = optJSONObject.optString("next_namespace");
                c0111a.f299a = optJSONObject.optString("next_request_url");
                c0116f.f334l = c0111a;
                return optJSONObject;
            }
            int i = c0116f.f325c;
        } else {
            c0116f.f325c = C0116f.f324b;
            c0116f.f326d = bi.f6358b;
        }
        return null;
    }

    /* renamed from: a */
    private static void m406a(JSONObject jSONObject) {
        String optString = jSONObject.optString("public_key");
        if (!TextUtils.isEmpty(optString)) {
            C0136b.m459a().f415b.m326a(optString);
        }
    }

    /* renamed from: a */
    public final C0128c m407a(Context context, C0115e c0115e, boolean z) throws NetErrorException {
        C0116f c0116f = new C0116f();
        JSONObject a = m402a(context, c0115e, c0116f);
        if (a.optBoolean("gzip")) {
            JSONObject optJSONObject = a.optJSONObject(C0110c.f287c);
            if (optJSONObject != null && optJSONObject.has("quickpay")) {
                try {
                    byte[] a2 = C0112b.m302a(C0117a.m355a(optJSONObject.optString("quickpay")));
                    if (TextUtils.equals(C0119c.m362a(a2), a.optString("md5"))) {
                        a.put(C0110c.f287c, new JSONObject(new String(a2, "utf-8")));
                    }
                } catch (Exception e) {
                }
            }
        } else {
            c0116f.f333k = false;
        }
        "responsestring decoded " + a;
        C0128c c0128c = new C0128c(c0115e, c0116f);
        c0128c.mo26a(a);
        if (!z) {
            C0131e c0131e = new C0131e();
            C0128c a3 = C0131e.m445a(c0128c);
            if (a3 != null) {
                c0128c = a3;
            }
            C0116f c0116f2 = c0128c.f392b;
            JSONObject jSONObject = c0128c.f393c;
            C0111a c0111a = c0128c.f391a.f316a;
            C0111a c0111a2 = c0128c.f392b.f334l;
            if (TextUtils.isEmpty(c0111a2.f301c)) {
                c0111a2.f301c = c0111a.f301c;
            }
            if (TextUtils.isEmpty(c0111a2.f302d)) {
                c0111a2.f302d = c0111a.f302d;
            }
            if (TextUtils.isEmpty(c0111a2.f300b)) {
                c0111a2.f300b = c0111a.f300b;
            }
            if (TextUtils.isEmpty(c0111a2.f299a)) {
                c0111a2.f299a = c0111a.f299a;
            }
            String str = "session";
            JSONObject optJSONObject2 = jSONObject.optJSONObject("reflected_data");
            if (optJSONObject2 != null) {
                "session = " + optJSONObject2.optString(str, bi.f6358b);
                c0128c.f392b.f331i = optJSONObject2;
            } else if (jSONObject.has(str)) {
                optJSONObject2 = new JSONObject();
                try {
                    optJSONObject2.put(str, jSONObject.optString(str));
                    CharSequence charSequence = C0139b.m480a().f422a;
                    if (!TextUtils.isEmpty(charSequence)) {
                        optJSONObject2.put(C0109b.f277c, charSequence);
                    }
                    c0116f2.f331i = optJSONObject2;
                } catch (JSONException e2) {
                }
            }
            c0116f2.f328f = jSONObject.optString("end_code", "0");
            c0116f2.f332j = jSONObject.optString("user_id", bi.f6358b);
            str = jSONObject.optString("result");
            try {
                str = URLDecoder.decode(jSONObject.optString("result"), "UTF-8");
            } catch (UnsupportedEncodingException e3) {
            }
            c0116f2.f329g = str;
            c0116f2.f330h = jSONObject.optString("memo", bi.f6358b);
        }
        return c0128c;
    }
}
