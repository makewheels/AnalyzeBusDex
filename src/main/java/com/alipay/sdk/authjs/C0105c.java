package com.alipay.sdk.authjs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.sdk.authjs.C0104a.C0103a;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.authjs.c */
public final class C0105c {
    /* renamed from: a */
    C0093b f252a;
    /* renamed from: b */
    Context f253b;

    public C0105c(Context context, C0093b c0093b) {
        this.f253b = context;
        this.f252a = c0093b;
    }

    /* renamed from: a */
    private static /* synthetic */ C0103a m276a(C0105c c0105c, C0104a c0104a) {
        if (c0104a != null && "toast".equals(c0104a.f248k)) {
            JSONObject jSONObject = c0104a.f250m;
            CharSequence optString = jSONObject.optString("content");
            int optInt = jSONObject.optInt("duration");
            int i = 1;
            if (optInt < 2500) {
                i = 0;
            }
            Toast.makeText(c0105c.f253b, optString, i).show();
            new Timer().schedule(new C0107e(c0105c, c0104a), (long) i);
        }
        return C0103a.NONE_ERROR;
    }

    /* renamed from: a */
    private static void m279a(Runnable runnable) {
        if (runnable != null) {
            if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : null) != null) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        }
    }

    /* renamed from: a */
    private void m280a(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(C0104a.f242e);
            try {
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(C0104a.f243f);
                    jSONObject2 = jSONObject2 instanceof JSONObject ? jSONObject2 : null;
                    String string2 = jSONObject.getString(C0104a.f244g);
                    String string3 = jSONObject.getString(C0104a.f241d);
                    C0104a c0104a = new C0104a(C0104a.f239b);
                    c0104a.f247j = string3;
                    c0104a.f248k = string2;
                    c0104a.f250m = jSONObject2;
                    c0104a.f246i = string;
                    m283a(c0104a);
                }
            } catch (Exception e) {
                str2 = string;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        m284a(str2, C0103a.RUNTIME_ERROR);
                    } catch (JSONException e2) {
                    }
                }
            }
        } catch (Exception e3) {
            str2 = null;
            if (!TextUtils.isEmpty(str2)) {
                m284a(str2, C0103a.RUNTIME_ERROR);
            }
        }
    }

    /* renamed from: b */
    private C0103a m281b(C0104a c0104a) {
        if (c0104a != null && "toast".equals(c0104a.f248k)) {
            JSONObject jSONObject = c0104a.f250m;
            CharSequence optString = jSONObject.optString("content");
            int optInt = jSONObject.optInt("duration");
            int i = 1;
            if (optInt < 2500) {
                i = 0;
            }
            Toast.makeText(this.f253b, optString, i).show();
            new Timer().schedule(new C0107e(this, c0104a), (long) i);
        }
        return C0103a.NONE_ERROR;
    }

    /* renamed from: c */
    private void m282c(C0104a c0104a) {
        JSONObject jSONObject = c0104a.f250m;
        CharSequence optString = jSONObject.optString("content");
        int optInt = jSONObject.optInt("duration");
        int i = 1;
        if (optInt < 2500) {
            i = 0;
        }
        Toast.makeText(this.f253b, optString, i).show();
        new Timer().schedule(new C0107e(this, c0104a), (long) i);
    }

    /* renamed from: a */
    public final void m283a(C0104a c0104a) throws JSONException {
        if (c0104a != null) {
            if (TextUtils.isEmpty(c0104a.f248k)) {
                m284a(c0104a.f246i, C0103a.INVALID_PARAMETER);
                return;
            }
            Runnable c0106d = new C0106d(this, c0104a);
            if ((Looper.getMainLooper() == Looper.myLooper() ? 1 : null) != null) {
                c0106d.run();
            } else {
                new Handler(Looper.getMainLooper()).post(c0106d);
            }
        }
    }

    /* renamed from: a */
    public final void m284a(String str, C0103a c0103a) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", c0103a.ordinal());
            C0104a c0104a = new C0104a(C0104a.f240c);
            c0104a.f250m = jSONObject;
            c0104a.f246i = str;
            this.f252a.mo22a(c0104a);
        }
    }
}
