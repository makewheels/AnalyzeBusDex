package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.C1149m.C1093a;
import com.tencent.smtt.utils.TbsLog;

class aj implements C1093a {
    /* renamed from: a */
    final /* synthetic */ TbsLogReport f4964a;

    aj(TbsLogReport tbsLogReport) {
        this.f4964a = tbsLogReport;
    }

    /* renamed from: a */
    public void mo1872a(int i) {
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=" + i);
    }
}
