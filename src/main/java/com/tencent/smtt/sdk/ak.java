package com.tencent.smtt.sdk;

import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.C1149m.C1093a;
import com.tencent.smtt.utils.TbsLog;

class ak implements C1093a {
    /* renamed from: a */
    final /* synthetic */ TbsLogReport f4965a;

    ak(TbsLogReport tbsLogReport) {
        this.f4965a = tbsLogReport;
    }

    /* renamed from: a */
    public void mo1872a(int i) {
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:" + i);
        if (i < ErrorCode.ERROR_CODE_LOAD_BASE) {
            this.f4965a.m7596g();
        }
    }
}
