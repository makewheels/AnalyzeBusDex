package com.amap.api.mapcore.util;

/* compiled from: AMapCoreException */
/* renamed from: com.amap.api.mapcore.util.v */
public class C0406v extends Exception {
    /* renamed from: a */
    private String f2191a = "未知的错误";
    /* renamed from: b */
    private int f2192b = -1;

    public C0406v(String str) {
        super(str);
        m3487a(str);
    }

    /* renamed from: a */
    public String m3488a() {
        return this.f2191a;
    }

    /* renamed from: a */
    private void m3487a(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f2192b = 21;
        } else if ("socket 连接异常 - SocketException".equals(str)) {
            this.f2192b = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f2192b = 23;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f2192b = 24;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f2192b = 25;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f2192b = 26;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f2192b = 27;
        } else if ("服务器连接失败 - UnknownServiceException".equals(str)) {
            this.f2192b = 28;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f2192b = 29;
        } else if ("http连接失败 - ConnectionException".equals(str)) {
            this.f2192b = 30;
        } else if ("未知的错误".equals(str)) {
            this.f2192b = 31;
        } else if ("key鉴权失败".equals(str)) {
            this.f2192b = 32;
        } else if ("requeust is null".equals(str)) {
            this.f2192b = 1;
        } else if ("request url is empty".equals(str)) {
            this.f2192b = 2;
        } else if ("response is null".equals(str)) {
            this.f2192b = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f2192b = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f2192b = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f2192b = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f2192b = 7;
        } else if ("线程池为空".equals(str)) {
            this.f2192b = 8;
        } else {
            this.f2192b = -1;
        }
    }
}
