package com.autonavi.tbt;

/* compiled from: AMapCoreException */
/* renamed from: com.autonavi.tbt.h */
public class C0618h extends Exception {
    /* renamed from: a */
    private String f3811a = "未知的错误";
    /* renamed from: b */
    private int f3812b = -1;

    public C0618h(String str) {
        super(str);
        m4861a(str);
    }

    /* renamed from: a */
    private void m4861a(String str) {
        if ("IO 操作异常 - IOException".equals(str)) {
            this.f3812b = 21;
        } else if ("socket 连接异常 - SocketException".equals(str)) {
            this.f3812b = 22;
        } else if ("socket 连接超时 - SocketTimeoutException".equals(str)) {
            this.f3812b = 23;
        } else if ("无效的参数 - IllegalArgumentException".equals(str)) {
            this.f3812b = 24;
        } else if ("空指针异常 - NullPointException".equals(str)) {
            this.f3812b = 25;
        } else if ("url异常 - MalformedURLException".equals(str)) {
            this.f3812b = 26;
        } else if ("未知主机 - UnKnowHostException".equals(str)) {
            this.f3812b = 27;
        } else if ("服务器连接失败 - UnknownServiceException".equals(str)) {
            this.f3812b = 28;
        } else if ("协议解析错误 - ProtocolException".equals(str)) {
            this.f3812b = 29;
        } else if ("http连接失败 - ConnectionException".equals(str)) {
            this.f3812b = 30;
        } else if ("未知的错误".equals(str)) {
            this.f3812b = 31;
        } else if ("key鉴权失败".equals(str)) {
            this.f3812b = 32;
        } else if ("requeust is null".equals(str)) {
            this.f3812b = 1;
        } else if ("request url is empty".equals(str)) {
            this.f3812b = 2;
        } else if ("response is null".equals(str)) {
            this.f3812b = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.f3812b = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.f3812b = 5;
        } else if ("sdk info is null".equals(str)) {
            this.f3812b = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.f3812b = 7;
        } else if ("线程池为空".equals(str)) {
            this.f3812b = 8;
        } else {
            this.f3812b = -1;
        }
    }
}
