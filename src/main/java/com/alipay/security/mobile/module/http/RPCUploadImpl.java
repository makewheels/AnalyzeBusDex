package com.alipay.security.mobile.module.http;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.C0031w;
import com.alipay.android.phone.mrpc.core.C0032h;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.security.mobile.module.http.constant.ConfigConstant;
import com.alipay.security.mobile.module.p010a.C0159a;
import com.alipay.security.mobile.module.p010a.C0161c;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.vkeydfp.AppListCmdService;
import com.alipay.tscenter.biz.rpc.vkeydfp.DeviceDataReportService;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.AppListCmdRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.AppListResult;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;
import org.json.JSONObject;

public class RPCUploadImpl implements IUpload {
    /* renamed from: f */
    private static RPCUploadImpl f488f = null;
    /* renamed from: g */
    private static DeviceDataReportResult f489g;
    /* renamed from: a */
    BugTrackMessageService f490a = null;
    /* renamed from: b */
    DeviceDataReportService f491b = null;
    /* renamed from: c */
    AppListCmdService f492c = null;
    /* renamed from: d */
    private Context f493d;
    /* renamed from: e */
    private C0031w f494e = null;

    private RPCUploadImpl(Context context) {
        this.f493d = context;
        try {
            aa aaVar = new aa();
            aaVar.m46a(ConfigConstant.DATA_POST_RPC_ADDRESS);
            this.f494e = new C0032h(context);
            this.f490a = (BugTrackMessageService) this.f494e.mo15a(BugTrackMessageService.class, aaVar);
            this.f491b = (DeviceDataReportService) this.f494e.mo15a(DeviceDataReportService.class, aaVar);
            this.f492c = (AppListCmdService) this.f494e.mo15a(AppListCmdService.class, aaVar);
        } catch (Throwable e) {
            C0161c.m563a(e);
        }
    }

    public static synchronized RPCUploadImpl getInstance(Context context) {
        RPCUploadImpl rPCUploadImpl;
        synchronized (RPCUploadImpl.class) {
            if (f488f == null) {
                f488f = new RPCUploadImpl(context);
            }
            rPCUploadImpl = f488f;
        }
        return rPCUploadImpl;
    }

    public AppListResult getAppList(String str, String str2, String str3, String str4) {
        AppListResult appListResult = null;
        try {
            AppListCmdRequest appListCmdRequest = new AppListCmdRequest();
            appListCmdRequest.os = str;
            appListCmdRequest.apdid = str4;
            appListCmdRequest.userId = str2;
            appListCmdRequest.token = str3;
            appListResult = this.f492c.getAppListCmd(appListCmdRequest);
        } catch (Exception e) {
        }
        return appListResult;
    }

    public boolean logCollect(String str) {
        if (C0159a.m556a(str)) {
            return false;
        }
        boolean booleanValue;
        if (this.f490a != null) {
            String str2 = null;
            try {
                str2 = this.f490a.logCollect(C0159a.m559c(str));
            } catch (Exception e) {
            }
            if (!C0159a.m556a(str2)) {
                try {
                    booleanValue = ((Boolean) new JSONObject(str2).get("success")).booleanValue();
                } catch (Throwable e2) {
                    C0161c.m563a(e2);
                }
                return booleanValue;
            }
        }
        booleanValue = false;
        return booleanValue;
    }

    public DeviceDataReportResult updateStaticData(final DeviceDataReportRequest deviceDataReportRequest) {
        if (deviceDataReportRequest == null) {
            return null;
        }
        if (this.f491b != null) {
            try {
                f489g = null;
                new Thread(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ RPCUploadImpl f487b;

                    public void run() {
                        try {
                            RPCUploadImpl.f489g = this.f487b.f491b.reportStaticData(deviceDataReportRequest);
                        } catch (Throwable th) {
                            RPCUploadImpl.f489g = new DeviceDataReportResult();
                            RPCUploadImpl.f489g.success = false;
                            RPCUploadImpl.f489g.resultCode = "static data rpc upload error, " + C0161c.m565b(th);
                        }
                    }
                }).start();
                int i = ConfigConstant.STATIC_DATA_UPDATE_TIMEOUT;
                while (f489g == null && i >= 0) {
                    Thread.sleep(50);
                    i -= 50;
                }
            } catch (Throwable e) {
                C0161c.m563a(e);
            }
        }
        return f489g;
    }
}
