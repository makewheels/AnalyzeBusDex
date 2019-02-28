package com.tencent.mm.sdk.diffdev.p050a;

import com.autonavi.amap.mapcore.VTMCDataCache;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.sdk.diffdev.a.g */
public enum C1072g {
    UUID_EXPIRED(ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_OUTER),
    UUID_CANCELED(ErrorCode.INFO_MISS_SDKEXTENSION_JAR),
    UUID_SCANED(ErrorCode.INFO_DISABLE_X5),
    UUID_CONFIRM(ErrorCode.INFO_CAN_NOT_LOAD_TBS),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(VTMCDataCache.MAXSIZE);
    
    private int code;

    private C1072g(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
