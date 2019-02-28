package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.g */
final class C1108g implements TbsListener {
    C1108g() {
    }

    public void onCallBackErrorCode(int i, String str) {
        TbsLog.m7925e("QbSdk", "onCallBackErrorCode errCode = " + i + " info: " + str);
        if (QbSdk.f4796o != null) {
            QbSdk.f4796o.onCallBackErrorCode(i, str);
        }
    }

    public void onDownloadFinish(int i) {
        TbsDownloader.f4828a = false;
        if (QbSdk.f4796o != null) {
            QbSdk.f4796o.onDownloadFinish(i);
        }
        if (QbSdk.mTbsListenerDebug != null) {
            QbSdk.mTbsListenerDebug.onDownloadFinish(i);
        }
    }

    public void onDownloadProgress(int i) {
        if (QbSdk.mTbsListenerDebug != null) {
            QbSdk.mTbsListenerDebug.onDownloadProgress(i);
        }
        if (QbSdk.f4796o != null) {
            QbSdk.f4796o.onDownloadProgress(i);
        }
    }

    public void onInstallFinish(int i) {
        QbSdk.setTBSInstallingStatus(false);
        TbsDownloader.f4828a = false;
        if (QbSdk.f4796o != null) {
            QbSdk.f4796o.onInstallFinish(i);
        }
        if (QbSdk.mTbsListenerDebug != null) {
            QbSdk.mTbsListenerDebug.onInstallFinish(i);
        }
    }
}
