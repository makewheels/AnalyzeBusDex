package com.tencent.smtt.sdk;

import android.os.Bundle;
import com.alipay.sdk.cons.C0110c;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.smtt.sdk.p051a.C1091d;
import p054u.aly.bi_常量类;

class al implements ReaderCallback {
    /* renamed from: a */
    final /* synthetic */ TbsReaderView f4966a;

    al(TbsReaderView tbsReaderView) {
        this.f4966a = tbsReaderView;
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        Bundle bundle = null;
        int i = 0;
        String resString;
        String str;
        Bundle bundle2;
        switch (num.intValue()) {
            case ReaderCallback.READER_PDF_LIST /*5008*/:
                if (!C1091d.m7700c(this.f4966a.f4864a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.f4966a.f4864a, ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_PDF_ID);
                    this.f4966a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG);
                    break;
                }
                str = bi_常量类.f6358b;
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.f4966a.f4864a, str, 4, 0, "pdf", bundle);
                this.f4966a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER);
                i = 1;
                break;
            case ReaderCallback.READER_PPT_PLAY_MODEL /*5009*/:
                if (!C1091d.m7700c(this.f4966a.f4864a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.f4966a.f4864a, ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_PPT_ID);
                    this.f4966a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG);
                    break;
                }
                str = bi_常量类.f6358b;
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.f4966a.f4864a, str, 4, 0, bi_常量类.f6358b, bundle);
                this.f4966a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER);
                i = 1;
                break;
            case ReaderCallback.READER_TXT_READING_MODEL /*5010*/:
                if (!C1091d.m7700c(this.f4966a.f4864a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.f4966a.f4864a, ReaderCallback.READER_PLUGIN_RES_TXT_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_TXT_ID);
                    this.f4966a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG);
                    break;
                }
                str = bi_常量类.f6358b;
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.f4966a.f4864a, str, 4, 0, "txt", bundle);
                i = 1;
                break;
            case ReaderCallback.READER_SEARCH_IN_DOCUMENT /*5026*/:
                if (!C1091d.m7700c(this.f4966a.f4864a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.f4966a.f4864a, ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_DOC_ID);
                    this.f4966a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG);
                    break;
                }
                str = bi_常量类.f6358b;
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.f4966a.f4864a, str, 4, 0, "doc", bundle);
                this.f4966a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER);
                i = 1;
                break;
            case ReaderCallback.READER_PLUGIN_SO_VERSION /*5030*/:
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    TbsReaderView.gReaderPackName = bundle2.getString(C0110c.f289e);
                    TbsReaderView.gReaderPackVersion = bundle2.getString("version");
                }
                i = 1;
                break;
        }
        if (this.f4966a.f4867d != null && r3 == 0) {
            this.f4966a.f4867d.onCallBackAction(num, obj, obj2);
        }
    }
}
