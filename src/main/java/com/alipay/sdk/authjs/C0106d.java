package com.alipay.sdk.authjs;

import android.widget.Toast;
import com.alipay.sdk.authjs.C0104a.C0103a;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.authjs.d */
final class C0106d implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0104a f254a;
    /* renamed from: b */
    final /* synthetic */ C0105c f255b;

    C0106d(C0105c c0105c, C0104a c0104a) {
        this.f255b = c0105c;
        this.f254a = c0104a;
    }

    public final void run() {
        C0105c c0105c = this.f255b;
        C0104a c0104a = this.f254a;
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
        C0103a c0103a = C0103a.NONE_ERROR;
        if (c0103a != C0103a.NONE_ERROR) {
            try {
                this.f255b.m284a(this.f254a.f246i, c0103a);
            } catch (JSONException e) {
            }
        }
    }
}
