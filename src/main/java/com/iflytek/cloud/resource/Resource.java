package com.iflytek.cloud.resource;

import android.text.TextUtils;
import java.util.Locale;
import p054u.aly.bi_常量类;

public class Resource {
    public static final int TAG_ERROR_CODE = 0;
    public static final int TAG_ERROR_UNKNOWN = 1;
    public static final int TEXT_AGAIN = 9;
    public static final int TEXT_CANCEL = 4;
    public static final int TEXT_DETAIL = 3;
    public static final int TEXT_HELP_LINK = 1;
    public static final int TEXT_HELP_RECO = 13;
    public static final int TEXT_HELP_SMS = 12;
    public static final int TEXT_KNOW = 2;
    public static final int TEXT_MORE = 7;
    public static final int TEXT_PLAYBACK = 10;
    public static final int TEXT_POWER_LINK = 0;
    public static final int TEXT_RETRIEVE = 11;
    public static final int TEXT_RETRY = 8;
    public static final int TEXT_SET = 6;
    public static final int TEXT_STOP = 5;
    public static final int TITLE_AUDIO_PLAYING = 6;
    public static final int TITLE_AUDIO_REQUEST = 4;
    public static final int TITLE_CONNECTING = 1;
    public static final int TITLE_DATA_UPLOAD = 7;
    public static final int TITLE_ERROR = 5;
    public static final int TITLE_HELP = 0;
    public static final int TITLE_RECOGNIZE_WAITING = 3;
    public static final int TITLE_RECORDING = 2;
    /* renamed from: a */
    private static Locale f4552a = Locale.CHINA;

    private Resource() {
    }

    /* renamed from: a */
    private static boolean m7246a(String str) {
        return TextUtils.isEmpty(str) || Locale.CHINA.toString().equalsIgnoreCase(str) || Locale.CHINESE.toString().equalsIgnoreCase(str);
    }

    public static String getErrorDescription(int i) {
        String[] strArr = C0960a.f4555c;
        if (f4552a.equals(Locale.US)) {
            strArr = C0961b.f4559c;
        } else if (f4552a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = C0962c.f4563c;
        }
        return (i <= 0 || i >= strArr.length) ? getErrorTag(1) : strArr[i];
    }

    public static String getErrorTag(int i) {
        String[] strArr = C0960a.f4556d;
        if (f4552a.equals(Locale.US)) {
            strArr = C0961b.f4560d;
        } else if (f4552a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = C0962c.f4564d;
        }
        return (i < 0 || i >= strArr.length) ? bi_常量类.f6358b : strArr[i];
    }

    public static String getLanguage() {
        return f4552a.toString();
    }

    public static String getText(int i) {
        String[] strArr = C0960a.f4553a;
        if (f4552a.equals(Locale.US)) {
            strArr = C0961b.f4557a;
        } else if (f4552a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = C0962c.f4561a;
        }
        return (i < 0 || i >= strArr.length) ? bi_常量类.f6358b : strArr[i];
    }

    public static String getTitle(int i) {
        String[] strArr = C0960a.f4554b;
        if (f4552a.equals(Locale.US)) {
            strArr = C0961b.f4558b;
        } else if (f4552a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = C0962c.f4562b;
        }
        return (i < 0 || i >= strArr.length) ? bi_常量类.f6358b : strArr[i];
    }

    public static boolean matchLanguage(String str) {
        String str2 = bi_常量类.f6358b;
        if (str != null) {
            str2 = str.trim();
        }
        return f4552a.toString().equalsIgnoreCase(str2) ? true : m7246a(str2) && m7246a(f4552a.toString());
    }

    public static void setErrorDescription(int i, String str) {
        String[] strArr = C0960a.f4555c;
        if (f4552a.equals(Locale.US)) {
            strArr = C0961b.f4559c;
        } else if (f4552a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = C0962c.f4563c;
        }
        if (i > 0 && i < strArr.length) {
            strArr[i] = str;
        }
    }

    public static void setText(int i, String str) {
        String[] strArr = C0960a.f4553a;
        if (f4552a.equals(Locale.US)) {
            strArr = C0961b.f4557a;
        } else if (f4552a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = C0962c.f4561a;
        }
        if (i >= 0 && i < strArr.length) {
            strArr[i] = str;
        }
    }

    public static void setTitle(int i, String str) {
        String[] strArr = C0960a.f4554b;
        if (f4552a.equals(Locale.US)) {
            strArr = C0961b.f4558b;
        } else if (f4552a.equals(Locale.TRADITIONAL_CHINESE)) {
            strArr = C0962c.f4562b;
        }
        if (i >= 0 && i < strArr.length) {
            strArr[i] = str;
        }
    }

    public static void setUILanguage(Locale locale) {
        if (locale != null) {
            if (locale.equals(Locale.US) || locale.equals(Locale.CHINA) || locale.equals(Locale.TRADITIONAL_CHINESE)) {
                f4552a = locale;
            }
        }
    }
}
