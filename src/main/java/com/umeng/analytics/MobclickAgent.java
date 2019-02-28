package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;
import com.umeng.analytics.social.C1268e;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import p054u.aly.bi_常量类;
import p054u.aly.bj;

public class MobclickAgent {
    /* renamed from: a */
    private static final String f5568a = "input map is null";
    /* renamed from: b */
    private static final C1243c f5569b = new C1243c();

    public static void setAutoLocation(boolean z) {
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        AnalyticsConfig.CATCH_EXCEPTION = z;
    }

    public static void setWrapper(String str, String str2) {
        f5569b.m8395a(str, str2);
    }

    public static void setSessionContinueMillis(long j) {
        AnalyticsConfig.kContinueSessionMillis = j;
    }

    public static void setEnableEventBuffer(boolean z) {
        AnalyticsConfig.ENABLE_MEMORY_BUFFER = z;
    }

    public static void setOnlineConfigureListener(UmengOnlineConfigureListener umengOnlineConfigureListener) {
        f5569b.m8393a(umengOnlineConfigureListener);
    }

    public static C1243c getAgent() {
        return f5569b;
    }

    public static void setOpenGLContext(GL10 gl10) {
        if (gl10 != null) {
            String[] a = bi_常量类.m9974a(gl10);
            if (a.length == 2) {
                AnalyticsConfig.GPU_VENDER = a[0];
                AnalyticsConfig.GPU_RENDERER = a[1];
            }
        }
    }

    public static void openActivityDurationTrack(boolean z) {
        AnalyticsConfig.ACTIVITY_DURATION_OPEN = z;
    }

    public static void onPageStart(String str) {
        if (TextUtils.isEmpty(str)) {
            bj.m10002b(C1233a.f5589e, "pageName is null or empty");
        } else {
            f5569b.m8394a(str);
        }
    }

    public static void onPageEnd(String str) {
        if (TextUtils.isEmpty(str)) {
            bj.m10002b(C1233a.f5589e, "pageName is null or empty");
        } else {
            f5569b.m8399b(str);
        }
    }

    public static void setDebugMode(boolean z) {
        bj.f6362a = z;
        C1268e.f5716v = z;
    }

    public static void onPause(Context context) {
        f5569b.m8400c(context);
    }

    public static void onResume(Context context) {
        if (context == null) {
            bj.m10002b(C1233a.f5589e, "unexpected null context in onResume");
        } else {
            f5569b.m8397b(context);
        }
    }

    public static void onResume(Context context, String str, String str2) {
        if (context == null) {
            bj.m10002b(C1233a.f5589e, "unexpected null context in onResume");
        } else if (str == null || str.length() == 0) {
            bj.m10002b(C1233a.f5589e, "unexpected empty appkey in onResume");
        } else {
            AnalyticsConfig.setAppkey(str);
            AnalyticsConfig.setChannel(str2);
            f5569b.m8397b(context);
        }
    }

    public static void reportError(Context context, String str) {
        f5569b.m8385a(context, str);
    }

    public static void reportError(Context context, Throwable th) {
        f5569b.m8391a(context, th);
    }

    public static void flush(Context context) {
        f5569b.m8402d(context);
    }

    public static void onEvent(Context context, String str) {
        f5569b.m8387a(context, str, null, -1, 1);
    }

    public static void onEvent(Context context, String str, int i) {
        f5569b.m8387a(context, str, null, -1, i);
    }

    public static void onEvent(Context context, String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            bj.m10000a(C1233a.f5589e, "label is null or empty");
        } else {
            f5569b.m8387a(context, str, str2, -1, i);
        }
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            bj.m10000a(C1233a.f5589e, "label is null or empty");
        } else {
            f5569b.m8387a(context, str, str2, -1, 1);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            bj.m10002b(C1233a.f5589e, f5568a);
            return;
        }
        f5569b.m8390a(context, str, new HashMap(map), -1);
    }

    public static void onEventDuration(Context context, String str, long j) {
        if (j <= 0) {
            bj.m10000a(C1233a.f5589e, "duration is not valid in onEventDuration");
        } else {
            f5569b.m8387a(context, str, null, j, 1);
        }
    }

    public static void onEventDuration(Context context, String str, String str2, long j) {
        if (TextUtils.isEmpty(str2)) {
            bj.m10000a(C1233a.f5589e, "label is null or empty");
        } else if (j <= 0) {
            bj.m10000a(C1233a.f5589e, "duration is not valid in onEventDuration");
        } else {
            f5569b.m8387a(context, str, str2, j, 1);
        }
    }

    public static void onEventDuration(Context context, String str, Map<String, String> map, long j) {
        if (j <= 0) {
            bj.m10000a(C1233a.f5589e, "duration is not valid in onEventDuration");
        } else if (map == null) {
            bj.m10002b(C1233a.f5589e, f5568a);
        } else {
            f5569b.m8390a(context, str, new HashMap(map), j);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i) {
        Map hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("__ct__", Integer.valueOf(i));
        f5569b.m8390a(context, str, hashMap, -1);
    }

    public static void onEventBegin(Context context, String str) {
        f5569b.m8386a(context, str, null);
    }

    public static void onEventEnd(Context context, String str) {
        f5569b.m8398b(context, str, null);
    }

    public static void onEventBegin(Context context, String str, String str2) {
        f5569b.m8386a(context, str, str2);
    }

    public static void onEventEnd(Context context, String str, String str2) {
        f5569b.m8398b(context, str, str2);
    }

    public static void onKVEventBegin(Context context, String str, Map<String, String> map, String str2) {
        if (map == null) {
            bj.m10002b(C1233a.f5589e, f5568a);
        } else {
            f5569b.m8389a(context, str, new HashMap(map), str2);
        }
    }

    public static void onKVEventEnd(Context context, String str, String str2) {
        f5569b.m8401c(context, str, str2);
    }

    public static void onSocialEvent(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            bj.m10002b(C1233a.f5589e, "context is null in onShareEvent");
            return;
        }
        C1268e.f5699e = "3";
        UMSocialService.share(context, str, uMPlatformDataArr);
    }

    public static void onSocialEvent(Context context, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            bj.m10002b(C1233a.f5589e, "context is null in onShareEvent");
            return;
        }
        C1268e.f5699e = "3";
        UMSocialService.share(context, uMPlatformDataArr);
    }

    public static String getConfigParams(Context context, String str) {
        return C1245f.m8407a(context).m8424g().getString(str, bi_常量类.f6358b_空串);
    }

    public static void updateOnlineConfig(Context context, String str, String str2) {
        if (str == null || str.length() == 0) {
            bj.m10002b(C1233a.f5589e, "unexpected empty appkey in onResume");
            return;
        }
        AnalyticsConfig.setAppkey(str);
        AnalyticsConfig.setChannel(str2);
        f5569b.m8384a(context);
    }

    public static void updateOnlineConfig(Context context) {
        f5569b.m8384a(context);
    }

    public static void setUserID(Context context, String str, String str2, Gender gender, int i) {
        if (TextUtils.isEmpty(str)) {
            bj.m10004c(C1233a.f5589e, "userID is null or empty");
            str = null;
        }
        if (TextUtils.isEmpty(str2)) {
            bj.m10000a(C1233a.f5589e, "id source is null or empty");
            str2 = null;
        }
        if (i <= 0 || i >= 200) {
            bj.m10000a(C1233a.f5589e, "not a valid age!");
            i = -1;
        }
        C1245f.m8407a(context).m8414a(str, str2, i, gender.value);
    }

    public static void onKillProcess(Context context) {
        f5569b.m8403e(context);
    }
}
