package com.alipay.apmobilesecuritysdk.p004a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import com.alipay.apmobilesecuritysdk.p004a.p005a.C0050a;
import com.alipay.apmobilesecuritysdk.p006b.C0061a;
import com.alipay.apmobilesecuritysdk.p007c.C0062a;
import com.alipay.apmobilesecuritysdk.p007c.C0063b;
import com.alipay.apmobilesecuritysdk.p008d.C0068d;
import com.alipay.apmobilesecuritysdk.p009e.C0069a;
import com.alipay.apmobilesecuritysdk.p009e.C0070b;
import com.alipay.sdk.cons.C0108a;
import com.alipay.sdk.cons.C0109b;
import com.alipay.security.mobile.module.http.UploadFactory;
import com.alipay.security.mobile.module.p010a.C0159a;
import com.alipay.security.mobile.module.p010a.C0161c;
import com.alipay.security.mobile.module.p010a.p011a.C0158c;
import com.alipay.security.mobile.module.p012b.C0163a;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.apmobilesecuritysdk.a.a */
public class C0052a {
    /* renamed from: b */
    private static final String f98b = C0052a.class.getName();
    /* renamed from: c */
    private static boolean f99c = false;
    /* renamed from: a */
    private final Context f100a;

    public C0052a(Context context) {
        this.f100a = context;
    }

    /* renamed from: a */
    public static String m134a(Context context) {
        String str = bi_常量类.f6358b;
        try {
            str = C0060i.m170b();
            if (C0159a.m556a(str)) {
                C0056e a = C0055d.m142a(context);
                if (!(a == null || C0159a.m556a(a.m149c()))) {
                    str = a.m149c();
                }
            }
        } catch (Throwable th) {
        }
        return str;
    }

    /* renamed from: a */
    static /* synthetic */ void m135a(C0052a c0052a, String str, String str2, String str3) {
        try {
            C0057f c0057f = new C0057f(UploadFactory.create(c0052a.f100a, C0061a.f123b).getAppList("android", str, str2, str3));
            if (c0057f.m151a()) {
                C0059h.m164b(c0052a.f100a, c0057f.m153c());
                C0059h.m161a(c0052a.f100a, c0057f.m152b());
                C0052a.m136a(false);
            }
        } catch (Throwable th) {
            C0161c.m563a(th);
        } finally {
            C0052a.m136a(false);
        }
    }

    /* renamed from: a */
    private static synchronized void m136a(boolean z) {
        synchronized (C0052a.class) {
            f99c = z;
        }
    }

    /* renamed from: a */
    private static synchronized boolean m137a() {
        boolean z;
        synchronized (C0052a.class) {
            z = f99c;
        }
        return z;
    }

    /* renamed from: b */
    private C0058g m138b(Map<String, String> map) {
        try {
            Context context = this.f100a;
            DeviceDataReportRequest deviceDataReportRequest = new DeviceDataReportRequest();
            String str = "3";
            String str2 = bi_常量类.f6358b;
            String str3 = bi_常量类.f6358b;
            String str4 = bi_常量类.f6358b;
            String str5 = bi_常量类.f6358b;
            String a = C0159a.m555a(map, "umid", bi_常量类.f6358b);
            C0056e b = C0055d.m144b(context);
            if (b != null) {
                str2 = b.m149c();
                str3 = b.m147a();
                str5 = str3;
                str3 = b.m150d();
            } else {
                String str6 = str5;
                str5 = str3;
                str3 = str6;
            }
            b = C0055d.m141a();
            if (b != null) {
                str4 = b.m147a();
            }
            if (C0159a.m556a(str5) && C0159a.m556a(r0)) {
                str5 = C0050a.m131b(context);
                str4 = C0050a.m127a();
            }
            deviceDataReportRequest.os = "android";
            deviceDataReportRequest.priApdid = str5;
            deviceDataReportRequest.pubApdid = str4;
            deviceDataReportRequest.token = str2;
            deviceDataReportRequest.umidToken = a;
            deviceDataReportRequest.lastTime = str3;
            deviceDataReportRequest.version = str;
            Map hashMap = new HashMap();
            hashMap.putAll(C0068d.m180a(context, map));
            deviceDataReportRequest.dataMap = hashMap;
            if (deviceDataReportRequest.dataMap != null) {
                Object obj;
                C0163a.m566a();
                deviceDataReportRequest.dataMap.put("AL3", C0163a.m588l(context));
                Map map2 = deviceDataReportRequest.dataMap;
                str3 = "AA5";
                str4 = C0059h.m166d(context);
                str2 = C0059h.m165c(context);
                if (C0159a.m556a(str4) || C0159a.m556a(str2)) {
                    obj = bi_常量类.f6358b;
                } else {
                    C0163a.m566a();
                    obj = C0069a.m184a(C0163a.m589m(context), str2, str4);
                }
                map2.put(str3, obj);
            }
            return new C0058g(UploadFactory.create(this.f100a, C0061a.f123b).updateStaticData(deviceDataReportRequest));
        } catch (Throwable th) {
            C0161c.m563a(th);
            return null;
        }
    }

    /* renamed from: b */
    public static String m139b(Context context) {
        try {
            String a = C0060i.m167a();
            if (!C0159a.m556a(a)) {
                return a;
            }
            C0056e a2 = C0055d.m142a(context);
            if (a2 != null && !C0159a.m556a(a2.m147a())) {
                return a2.m147a();
            }
            a = C0050a.m128a(context);
            if (!C0159a.m556a(a)) {
                return a;
            }
            a = C0070b.m185a(context);
            return !C0159a.m556a(a) ? a : a;
        } catch (Throwable th) {
            return bi_常量类.f6358b;
        }
    }

    /* renamed from: a */
    public final String m140a(Map<String, String> map) {
        String str = bi_常量类.f6358b;
        if (map == null) {
            return bi_常量类.f6358b;
        }
        String str2 = this.f100a.getFilesDir().getAbsolutePath() + "/log/ap";
        String str3 = Build.MODEL;
        String str4 = this.f100a.getApplicationContext().getApplicationInfo().packageName;
        String str5 = "security-sdk-token";
        String str6 = "3.0.2.20150525";
        String a = C0159a.m555a(map, C0109b.f277c, bi_常量类.f6358b);
        String a2 = C0159a.m555a(map, C0109b.f281g, bi_常量类.f6358b);
        String str7 = bi_常量类.f6358b;
        C0056e a3 = C0055d.m142a(this.f100a);
        if (a3 != null) {
            str7 = a3.m147a();
        }
        C0161c.m562a(str2, new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", new C0062a(str3, str4, str5, str6, a, a2, str7).toString());
        new Thread(new C0053b(this)).start();
        str3 = C0159a.m555a(map, "userId", bi_常量类.f6358b);
        C0068d.m181a();
        String b = C0068d.m182b(this.f100a, map);
        C0056e a4 = C0055d.m142a(this.f100a);
        if (a4 != null) {
            Object obj = !C0159a.m557a(b, a4.m148b()) ? 1 : null;
        } else {
            int i = 1;
        }
        boolean a5 = C0060i.m169a(this.f100a);
        if (obj == null && a5 && !C0159a.m556a(a4.m149c())) {
            b = a4.m149c();
        } else {
            try {
                C0058g b2 = m138b((Map) map);
                if (b2 == null || !b2.m154a()) {
                    if (b2 != null) {
                        C0161c.m561a("Server error, result:" + b2.m158e());
                    } else {
                        C0161c.m561a("Server error, response is null");
                    }
                    b = (a4 == null || C0159a.m556a(a4.m149c())) ? bi_常量类.f6358b : a4.m149c();
                } else {
                    b = f98b;
                    Context context = this.f100a;
                    boolean f = b2.m159f();
                    try {
                        Editor edit = context.getSharedPreferences("vkeyid_settings", 0).edit();
                        if (edit != null) {
                            edit.putString("log_switch", f ? C0158c.m551a(C0158c.m550a(), C0108a.f262e) : C0158c.m551a(C0158c.m550a(), "0"));
                            edit.commit();
                        }
                    } catch (Throwable th) {
                    }
                    b = C0059h.m166d(this.f100a);
                    if (!(C0159a.m556a(b2.m160g()) || C0159a.m557a(b, b2.m160g()))) {
                        b = b2.m156c();
                        str4 = bi_常量类.f6358b;
                        if (!C0052a.m137a()) {
                            C0052a.m136a(true);
                            new C0054c(this, str3, b, str4).start();
                            C0052a.m136a(false);
                        }
                    }
                    b = C0068d.m182b(this.f100a, map);
                    if (b2 != null) {
                        C0056e c0056e = new C0056e(b2, b);
                        C0055d.m143a(this.f100a, c0056e);
                        C0060i.m168a(c0056e);
                        context = this.f100a;
                        C0050a.m129a(c0056e);
                        context = this.f100a;
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            Editor edit2 = context.getSharedPreferences("vkeyid_settings", 0).edit();
                            if (edit2 != null) {
                                edit2.putString("vkey_valid", C0158c.m551a(C0158c.m550a(), String.valueOf(currentTimeMillis)));
                                edit2.commit();
                            }
                        } catch (Throwable th2) {
                        }
                    }
                    b = b2.m156c();
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                b = str;
                C0161c.m563a(th4);
                return b;
            }
        }
        try {
            new C0063b(str2, UploadFactory.create(this.f100a, C0061a.f123b)).m174a(this.f100a);
            return b;
        } catch (Throwable th5) {
            th4 = th5;
            C0161c.m563a(th4);
            return b;
        }
    }
}
