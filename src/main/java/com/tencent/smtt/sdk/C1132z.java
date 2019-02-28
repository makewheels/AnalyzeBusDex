package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.z */
final class C1132z extends Handler {
    C1132z(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                boolean a = TbsDownloader.m7583c(true);
                if (TbsShareManager.isThirdPartyApp(TbsDownloader.f4830c) && a) {
                    TbsDownloader.startDownload(TbsDownloader.f4830c);
                    return;
                }
                return;
            case 101:
                TbsDownloadConfig a2 = TbsDownloadConfig.m7565a(TbsDownloader.f4830c);
                if (TbsDownloader.m7583c(false) && a2.f4827b.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                    TbsDownloader.f4833f.m7897a();
                    return;
                } else {
                    QbSdk.f4786e.onDownloadFinish(ErrorCode.NONEEDTODOWN_ERROR);
                    return;
                }
            case 102:
                TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                int c = TbsShareManager.isThirdPartyApp(TbsDownloader.f4830c) ? TbsShareManager.m7633c(TbsDownloader.f4830c) : ac.m7706a().m7746e(TbsDownloader.f4830c);
                TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=" + c);
                TbsDownloader.f4833f.m7898a(c);
                TbsLogReport.m7589a(TbsDownloader.f4830c).m7607b();
                return;
            case 103:
                TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                ac.m7706a().m7734a((Context) message.obj);
                return;
            case ErrorCode.WRITE_DISK_ERROR /*104*/:
                TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                TbsLogReport.m7589a(TbsDownloader.f4830c).m7599a();
                return;
            default:
                return;
        }
    }
}
