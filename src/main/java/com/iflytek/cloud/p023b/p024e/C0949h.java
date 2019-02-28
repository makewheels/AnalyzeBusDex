package com.iflytek.cloud.p023b.p024e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.iflytek.cloud.Setting;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechError;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.b.e.h */
public class C0949h {
    /* renamed from: a */
    public static String m7163a(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return "none";
        }
        try {
            if (networkInfo.getType() == 1) {
                return "wifi";
            }
            String toLowerCase = networkInfo.getExtraInfo().toLowerCase();
            return TextUtils.isEmpty(toLowerCase) ? "none" : (toLowerCase.startsWith("3gwap") || toLowerCase.startsWith("uniwap")) ? "uniwap" : toLowerCase.startsWith("cmwap") ? "cmwap" : toLowerCase.startsWith("ctwap") ? "ctwap" : toLowerCase.startsWith("ctnet") ? "ctnet" : toLowerCase;
        } catch (Exception e) {
            C0939a.m7120a(e.toString());
            return "none";
        }
    }

    /* renamed from: a */
    public static void m7164a(Context context) throws SpeechError {
        if (Setting.f4357b && context != null) {
            NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
            if (allNetworkInfo != null && allNetworkInfo.length > 0) {
                int length = allNetworkInfo.length;
                int i = 0;
                while (i < length) {
                    NetworkInfo networkInfo = allNetworkInfo[i];
                    if (networkInfo != null && !networkInfo.isConnectedOrConnecting()) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
            throw new SpeechError((int) ErrorCode.ERROR_NO_NETWORK);
        }
    }

    /* renamed from: b */
    public static String m7165b(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return "none";
        }
        try {
            if (networkInfo.getType() == 1) {
                return "none";
            }
            return (bi_常量类.f6358b_空串 + networkInfo.getSubtypeName()) + ";" + networkInfo.getSubtype();
        } catch (Exception e) {
            C0939a.m7120a(e.toString());
            return "none";
        }
    }
}
