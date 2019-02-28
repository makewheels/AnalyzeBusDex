package com.tencent.smtt.sdk.p051a;

import MTT.ThirdAppInfoNew;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.utils.C1135b;
import com.tencent.smtt.utils.C1152p;
import com.tencent.smtt.utils.C1158v;
import com.tencent.smtt.utils.C1159w;
import com.tencent.smtt.utils.TbsLog;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.sdk.a.b */
public class C1086b {
    /* renamed from: a */
    public static byte[] f4937a;

    static {
        f4937a = null;
        try {
            f4937a = "65dRa93L".getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
        }
    }

    /* renamed from: a */
    private static String m7686a(Context context) {
        String str = null;
        try {
            byte[] toByteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (toByteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(toByteArray);
                toByteArray = instance.digest();
                if (toByteArray != null) {
                    StringBuilder stringBuilder = new StringBuilder(bi_常量类.f6358b_空串);
                    if (toByteArray != null && toByteArray.length > 0) {
                        for (int i = 0; i < toByteArray.length; i++) {
                            String toUpperCase = Integer.toHexString(toByteArray[i] & WebView.NORMAL_MODE_ALPHA).toUpperCase();
                            if (i > 0) {
                                stringBuilder.append(":");
                            }
                            if (toUpperCase.length() < 2) {
                                stringBuilder.append(0);
                            }
                            stringBuilder.append(toUpperCase);
                        }
                        str = stringBuilder.toString();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /* renamed from: a */
    public static void m7687a(ThirdAppInfoNew thirdAppInfoNew) {
        new C1087c("HttpUtils", thirdAppInfoNew).start();
    }

    /* renamed from: a */
    public static void m7688a(Context context, String str, String str2, String str3, int i, boolean z) {
        String str4;
        String str5 = bi_常量类.f6358b_空串;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (TbsConfig.APP_QQ.equals(applicationInfo.packageName)) {
                str5 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                    str5 = str5 + "." + QbSdk.getQQBuildNumber();
                }
            }
            str4 = str5;
        } catch (Exception e) {
            Exception exception = e;
            str4 = str5;
            exception.printStackTrace();
        }
        try {
            ThirdAppInfoNew thirdAppInfoNew = new ThirdAppInfoNew();
            thirdAppInfoNew.sAppName = context.getApplicationInfo().packageName;
            C1159w.m8057a(context);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            thirdAppInfoNew.sTime = simpleDateFormat.format(Calendar.getInstance().getTime());
            thirdAppInfoNew.sGuid = str;
            if (z) {
                thirdAppInfoNew.sQua2 = str2;
            } else {
                thirdAppInfoNew.sQua2 = C1158v.m8046a(context);
            }
            thirdAppInfoNew.sLc = str3;
            str5 = C1135b.m7954e(context);
            String c = C1135b.m7952c(context);
            String d = C1135b.m7953d(context);
            Object f = C1135b.m7955f(context);
            if (!(c == null || bi_常量类.f6358b_空串.equals(c))) {
                thirdAppInfoNew.sImei = c;
            }
            if (!(d == null || bi_常量类.f6358b_空串.equals(d))) {
                thirdAppInfoNew.sImsi = d;
            }
            if (!TextUtils.isEmpty(f)) {
                thirdAppInfoNew.sAndroidID = f;
            }
            if (!(str5 == null || bi_常量类.f6358b_空串.equals(str5))) {
                thirdAppInfoNew.sMac = str5;
            }
            thirdAppInfoNew.iPv = (long) i;
            thirdAppInfoNew.iCoreType = z ? 1 : 0;
            thirdAppInfoNew.sAppVersionName = str4;
            thirdAppInfoNew.sAppSignature = C1086b.m7686a(context);
            C1086b.m7687a(thirdAppInfoNew);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private static JSONObject m7690c(ThirdAppInfoNew thirdAppInfoNew) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("APPNAME", thirdAppInfoNew.sAppName);
            jSONObject.put("TIME", thirdAppInfoNew.sTime);
            jSONObject.put("QUA2", thirdAppInfoNew.sQua2);
            jSONObject.put("LC", thirdAppInfoNew.sLc);
            jSONObject.put("GUID", thirdAppInfoNew.sGuid);
            jSONObject.put("IMEI", thirdAppInfoNew.sImei);
            jSONObject.put("IMSI", thirdAppInfoNew.sImsi);
            jSONObject.put("MAC", thirdAppInfoNew.sMac);
            jSONObject.put("PV", thirdAppInfoNew.iPv);
            jSONObject.put("CORETYPE", thirdAppInfoNew.iCoreType);
            jSONObject.put("APPVN", thirdAppInfoNew.sAppVersionName);
            if (thirdAppInfoNew.sAppSignature == null) {
                jSONObject.put("SIGNATURE", "0");
            } else {
                jSONObject.put("SIGNATURE", thirdAppInfoNew.sAppSignature);
            }
            jSONObject.put("PROTOCOL_VERSION", 3);
            jSONObject.put("ANDROID_ID", thirdAppInfoNew.sAndroidID);
            try {
                if (QbSdk.getTID() == null) {
                    return jSONObject;
                }
                if (thirdAppInfoNew.sAppName.equals(TbsConfig.APP_QQ)) {
                    jSONObject.put("TID", C1152p.m8013a().m8015a(QbSdk.getTID()));
                    jSONObject.put("TIDTYPE", 1);
                    return jSONObject;
                } else if (!thirdAppInfoNew.sAppName.equals("com.tencent.mm")) {
                    return jSONObject;
                } else {
                    jSONObject.put("TID", QbSdk.getTID());
                    jSONObject.put("TIDTYPE", 0);
                    return jSONObject;
                }
            } catch (Exception e) {
                return jSONObject;
            }
        } catch (Exception e2) {
            TbsLog.m7925e("sdkreport", "getPostData exception!");
            return null;
        }
    }
}
