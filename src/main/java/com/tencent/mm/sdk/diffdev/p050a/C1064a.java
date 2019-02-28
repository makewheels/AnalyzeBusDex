package com.tencent.mm.sdk.diffdev.p050a;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.sdk.diffdev.OAuthListener;
import com.tencent.mm.sdk.p048b.C1055d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.sdk.diffdev.a.a */
public final class C1064a implements IDiffDevOAuth {
    private C1055d ac = null;
    private List<OAuthListener> ad = new ArrayList();
    private C1068d ae;
    private OAuthListener af = new C1065b(this);

    public final void addListener(OAuthListener oAuthListener) {
        if (!this.ad.contains(oAuthListener)) {
            this.ad.add(oAuthListener);
        }
    }

    public final boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str == null || str.length() <= 0 || str2 == null || str2.length() <= 0) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[]{str, str2}));
            return false;
        }
        if (this.ac == null) {
            this.ac = new C1055d(Looper.getMainLooper());
        }
        addListener(oAuthListener);
        if (this.ae != null) {
            Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
            return true;
        }
        this.ae = new C1068d(str, str2, str3, str4, str5, this.af);
        C1068d c1068d = this.ae;
        if (VERSION.SDK_INT >= 11) {
            c1068d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            c1068d.execute(new Void[0]);
        }
        return true;
    }

    public final void detach() {
        Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.ad.clear();
        stopAuth();
    }

    public final void removeAllListeners() {
        this.ad.clear();
    }

    public final void removeListener(OAuthListener oAuthListener) {
        this.ad.remove(oAuthListener);
    }

    public final boolean stopAuth() {
        boolean q;
        Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            q = this.ae == null ? true : this.ae.m7540q();
        } catch (Exception e) {
            Log.w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            q = false;
        }
        this.ae = null;
        return q;
    }
}
