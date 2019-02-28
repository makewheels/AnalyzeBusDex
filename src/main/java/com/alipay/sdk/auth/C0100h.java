package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.alipay.sdk.data.C0112b;
import com.alipay.sdk.data.C0113c;
import com.alipay.sdk.data.C0114d;
import com.alipay.sdk.data.C0115e;
import com.alipay.sdk.net.C0125d;
import com.alipay.sdk.sys.C0136b;
import com.alipay.sdk.widget.C0151a;
import org.json.JSONObject;

/* renamed from: com.alipay.sdk.auth.h */
public final class C0100h {
    /* renamed from: a */
    private static final String f223a = "com.eg.android.AlipayGphone";
    /* renamed from: b */
    private static final int f224b = 65;
    /* renamed from: c */
    private static C0151a f225c = null;
    /* renamed from: d */
    private static String f226d = null;

    /* renamed from: a */
    public static void m255a(Activity activity, APAuthInfo aPAuthInfo) {
        if (C0100h.m257a((Context) activity)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("alipayauth://platformapi/startapp");
            stringBuilder.append("?appId=20000122");
            stringBuilder.append("&approveType=005");
            stringBuilder.append("&scope=kuaijie");
            stringBuilder.append("&productId=");
            stringBuilder.append(aPAuthInfo.getProductId());
            stringBuilder.append("&thirdpartyId=");
            stringBuilder.append(aPAuthInfo.getAppId());
            stringBuilder.append("&redirectUri=");
            stringBuilder.append(aPAuthInfo.getRedirectUri());
            C0100h.m256a(activity, stringBuilder.toString());
            return;
        }
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    C0151a c0151a = new C0151a(activity);
                    f225c = c0151a;
                    c0151a.m544b();
                    C0136b.m459a().m466a(activity, C0114d.m315a());
                }
            } catch (Exception e) {
                f225c = null;
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("app_id=");
        stringBuilder.append(aPAuthInfo.getAppId());
        stringBuilder.append("&partner=");
        stringBuilder.append(aPAuthInfo.getPid());
        stringBuilder.append("&scope=kuaijie");
        stringBuilder.append("&login_goal=auth");
        stringBuilder.append("&redirect_url=");
        stringBuilder.append(aPAuthInfo.getRedirectUri());
        stringBuilder.append("&view=wap");
        stringBuilder.append("&prod_code=");
        stringBuilder.append(aPAuthInfo.getProductId());
        C0115e a = C0112b.m297a(new C0113c(), stringBuilder.toString(), new JSONObject());
        a.f316a.f300b = "com.alipay.mobilecashier";
        a.f316a.f303e = "com.alipay.mcpay";
        a.f316a.f302d = "4.0.0";
        a.f316a.f301c = "/cashier/main";
        new Thread(new C0101i(new C0125d(new C0113c()), activity, a, aPAuthInfo)).start();
    }

    /* renamed from: a */
    public static void m256a(Activity activity, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }

    /* renamed from: a */
    private static boolean m257a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 128);
            return packageInfo != null && packageInfo.versionCode >= 65;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /* renamed from: b */
    private static void m259b(Activity activity, APAuthInfo aPAuthInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("alipayauth://platformapi/startapp");
        stringBuilder.append("?appId=20000122");
        stringBuilder.append("&approveType=005");
        stringBuilder.append("&scope=kuaijie");
        stringBuilder.append("&productId=");
        stringBuilder.append(aPAuthInfo.getProductId());
        stringBuilder.append("&thirdpartyId=");
        stringBuilder.append(aPAuthInfo.getAppId());
        stringBuilder.append("&redirectUri=");
        stringBuilder.append(aPAuthInfo.getRedirectUri());
        C0100h.m256a(activity, stringBuilder.toString());
    }

    /* renamed from: c */
    private static void m261c(Activity activity, APAuthInfo aPAuthInfo) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    C0151a c0151a = new C0151a(activity);
                    f225c = c0151a;
                    c0151a.m544b();
                    C0136b.m459a().m466a(activity, C0114d.m315a());
                }
            } catch (Exception e) {
                f225c = null;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("app_id=");
        stringBuilder.append(aPAuthInfo.getAppId());
        stringBuilder.append("&partner=");
        stringBuilder.append(aPAuthInfo.getPid());
        stringBuilder.append("&scope=kuaijie");
        stringBuilder.append("&login_goal=auth");
        stringBuilder.append("&redirect_url=");
        stringBuilder.append(aPAuthInfo.getRedirectUri());
        stringBuilder.append("&view=wap");
        stringBuilder.append("&prod_code=");
        stringBuilder.append(aPAuthInfo.getProductId());
        C0115e a = C0112b.m297a(new C0113c(), stringBuilder.toString(), new JSONObject());
        a.f316a.f300b = "com.alipay.mobilecashier";
        a.f316a.f303e = "com.alipay.mcpay";
        a.f316a.f302d = "4.0.0";
        a.f316a.f301c = "/cashier/main";
        new Thread(new C0101i(new C0125d(new C0113c()), activity, a, aPAuthInfo)).start();
    }
}
