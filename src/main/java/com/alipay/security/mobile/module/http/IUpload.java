package com.alipay.security.mobile.module.http;

import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

public interface IUpload {
    AppListResult getAppList(String str, String str2, String str3, String str4);

    boolean logCollect(String str);

    DeviceDataReportResult updateStaticData(DeviceDataReportRequest deviceDataReportRequest);
}
