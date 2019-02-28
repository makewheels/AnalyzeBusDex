package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.sdk.p051a.C1091d;
import com.tencent.smtt.utils.Apn;
import p054u.aly.bi_常量类;

public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";
    /* renamed from: f */
    static boolean f4863f = false;
    public static String gReaderPackName = bi_常量类.f6358b_空串;
    public static String gReaderPackVersion = bi_常量类.f6358b_空串;
    /* renamed from: a */
    Context f4864a = null;
    /* renamed from: b */
    C1109h f4865b = null;
    /* renamed from: c */
    Object f4866c = null;
    /* renamed from: d */
    ReaderCallback f4867d = null;
    /* renamed from: e */
    ReaderCallback f4868e = null;

    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) {
        super(context.getApplicationContext());
        if (context instanceof Activity) {
            this.f4867d = readerCallback;
            this.f4864a = context;
            this.f4868e = new al(this);
            return;
        }
        throw new RuntimeException("error: unexpect context(none Activity)");
    }

    /* renamed from: a */
    static boolean m7625a(Context context) {
        boolean z = true;
        if (!f4863f) {
            C1110i.m7845a(true).m7854a(context.getApplicationContext(), true);
            if (C1110i.m7845a(false).m7859c() == null) {
                z = false;
            }
            f4863f = z;
        }
        return f4863f;
    }

    public static Drawable getResDrawable(Context context, int i) {
        return m7625a(context) ? C1109h.m7832a(i) : null;
    }

    public static String getResString(Context context, int i) {
        return m7625a(context) ? C1109h.m7836b(i) : bi_常量类.f6358b_空串;
    }

    public static boolean isSupportExt(Context context, String str) {
        return m7625a(context) && C1109h.m7833a(context) && C1109h.m7834a(str);
    }

    /* renamed from: a */
    boolean m7626a() {
        boolean z = false;
        try {
            if (this.f4865b == null) {
                this.f4865b = new C1109h(this.f4868e);
            }
            if (this.f4866c == null) {
                this.f4866c = this.f4865b.m7837a();
            }
            if (this.f4866c != null) {
                z = this.f4865b.m7842a(this.f4866c, this.f4864a);
            }
        } catch (NullPointerException e) {
            Log.e(TAG, "Unexpect null object!");
        }
        return z;
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        if (this.f4865b != null && this.f4866c != null) {
            this.f4865b.m7840a(this.f4866c, num, obj, obj2);
        }
    }

    public boolean downloadPlugin(String str) {
        if (this.f4866c != null) {
            return this.f4865b.m7844a(this.f4866c, this.f4864a, str, true);
        }
        Log.e(TAG, "downloadPlugin failed!");
        return false;
    }

    public void onSizeChanged(int i, int i2) {
        if (this.f4865b != null && this.f4866c != null) {
            this.f4865b.m7839a(this.f4866c, i, i2);
        }
    }

    public void onStop() {
        if (this.f4865b != null) {
            this.f4865b.m7838a(this.f4866c);
            this.f4866c = null;
        }
        this.f4864a = null;
        f4863f = false;
    }

    public void openFile(Bundle bundle) {
        int i = 1;
        if (this.f4866c == null || bundle == null) {
            Log.e(TAG, "init failed!");
            return;
        }
        bundle.putBoolean("browser6.0", (!C1091d.m7699b(this.f4864a) ? 1 : 0) | C1091d.m7700c(this.f4864a));
        boolean a = C1091d.m7694a(this.f4864a, 6101625, 610000);
        if (C1091d.m7699b(this.f4864a)) {
            i = 0;
        }
        bundle.putBoolean("browser6.1", a | i);
        if (!this.f4865b.m7843a(this.f4866c, this.f4864a, bundle, (FrameLayout) this)) {
            Log.e(TAG, "OpenFile failed!");
        }
    }

    public boolean preOpen(String str, boolean z) {
        boolean z2 = false;
        if (isSupportExt(this.f4864a, str)) {
            boolean a = m7625a(this.f4864a);
            if (a) {
                a = m7626a();
                if (z && a) {
                    if (Apn.getApnType(this.f4864a) == 3) {
                        z2 = true;
                    }
                    return this.f4865b.m7844a(this.f4866c, this.f4864a, str, z2);
                }
            }
            return a;
        }
        Log.e(TAG, "not supported by:" + str);
        return false;
    }

    public void userStatistics(String str) {
        if (this.f4865b != null) {
            this.f4865b.m7841a(this.f4866c, str);
        }
    }
}
