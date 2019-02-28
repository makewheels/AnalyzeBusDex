package com.iflytek.cloud.util.p032a;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.util.ContactManager;
import com.iflytek.cloud.util.ContactManager.ContactListener;
import com.iflytek.cloud.util.p032a.p034c.C0983a;
import com.iflytek.cloud.util.p032a.p035b.C0984a;
import com.iflytek.cloud.util.p032a.p035b.C0985b;

/* renamed from: com.iflytek.cloud.util.a.b */
public class C0986b extends ContactManager {
    /* renamed from: a */
    private static C0986b f4645a = null;
    /* renamed from: b */
    private static Context f4646b = null;
    /* renamed from: c */
    private static int f4647c = 4;
    /* renamed from: d */
    private static C0983a f4648d = null;
    /* renamed from: e */
    private static C0980a f4649e = null;
    /* renamed from: f */
    private static C0985b f4650f;
    /* renamed from: g */
    private static C0984a f4651g;
    /* renamed from: i */
    private static ContactListener f4652i = null;
    /* renamed from: h */
    private HandlerThread f4653h = null;
    /* renamed from: j */
    private Handler f4654j;
    /* renamed from: k */
    private long f4655k = 0;
    /* renamed from: l */
    private long f4656l = 0;

    /* renamed from: com.iflytek.cloud.util.a.b$a */
    private class C0984a extends ContentObserver {
        /* renamed from: a */
        final /* synthetic */ C0986b f4626a;

        public C0984a(C0986b c0986b, Handler handler) {
            this.f4626a = c0986b;
            super(handler);
        }

        public void onChange(boolean z) {
            C0939a.m7121a("iFly_ContactManager", "CallLogObserver | onChange");
            if (System.currentTimeMillis() - this.f4626a.f4656l < 5000) {
                C0939a.m7121a("iFly_ContactManager", "onChange too much");
                return;
            }
            this.f4626a.f4656l = System.currentTimeMillis();
            this.f4626a.m7336c();
        }
    }

    /* renamed from: com.iflytek.cloud.util.a.b$b */
    private class C0985b extends ContentObserver {
        /* renamed from: a */
        final /* synthetic */ C0986b f4627a;

        public C0985b(C0986b c0986b, Handler handler) {
            this.f4627a = c0986b;
            super(handler);
        }

        public void onChange(boolean z) {
            C0939a.m7121a("iFly_ContactManager", "ContactObserver_Contact| onChange");
            if (System.currentTimeMillis() - this.f4627a.f4655k < 5000) {
                C0939a.m7121a("iFly_ContactManager", "onChange too much");
                return;
            }
            this.f4627a.f4655k = System.currentTimeMillis();
            this.f4627a.m7333b();
            this.f4627a.m7336c();
        }
    }

    private C0986b() {
        if (VERSION.SDK_INT > f4647c) {
            f4648d = new C0985b(f4646b);
        } else {
            f4648d = new C0984a(f4646b);
        }
        f4649e = new C0980a(f4646b, f4648d);
        this.f4653h = new HandlerThread("ContactManager_worker");
        this.f4653h.start();
        this.f4654j = new Handler(this.f4653h.getLooper());
        this.f4653h.setPriority(1);
        f4650f = new C0985b(this, this.f4654j);
        f4651g = new C0984a(this, this.f4654j);
    }

    /* renamed from: a */
    public static C0986b m7329a() {
        return f4645a;
    }

    /* renamed from: a */
    public static C0986b m7330a(Context context, ContactListener contactListener) {
        f4652i = contactListener;
        f4646b = context;
        if (f4645a == null) {
            f4645a = new C0986b();
            f4646b.getContentResolver().registerContentObserver(f4648d.mo1612a(), true, f4650f);
            f4646b.getContentResolver().registerContentObserver(f4648d.m7321f(), true, f4651g);
        }
        return f4645a;
    }

    /* renamed from: b */
    private void m7333b() {
        if (f4652i != null && f4649e != null) {
            String a = C0989e.m7341a(f4649e.m7313a(), '\n');
            String str = f4646b.getFilesDir().getParent() + '/' + "name.txt";
            String a2 = C0988d.m7339a(str);
            if (a == null || a2 == null || !a.equals(a2)) {
                C0988d.m7338a(str, a, true);
                f4652i.onContactQueryFinish(a, true);
                return;
            }
            C0939a.m7121a("iFly_ContactManager", "contact name is not change.");
            f4652i.onContactQueryFinish(a, false);
        }
    }

    /* renamed from: c */
    private void m7336c() {
        if (f4649e != null) {
            f4649e.m7312a(10);
        }
    }

    public void asyncQueryAllContactsName() {
        this.f4654j.post(new C0987c(this));
    }

    public String queryAllContactsName() {
        if (f4649e == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : f4649e.m7313a()) {
            stringBuilder.append(str + '\n');
        }
        return stringBuilder.toString();
    }
}
