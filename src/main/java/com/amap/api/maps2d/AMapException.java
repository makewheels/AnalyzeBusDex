package com.amap.api.maps2d;

public class AMapException extends Exception {
    public static final String ERROR_CONNECTION = "http连接失败 - ConnectionException";
    public static final String ERROR_FAILURE_AUTH = "key鉴权失败";
    public static final String ERROR_INVALID_PARAMETER = "无效的参数 - IllegalArgumentException";
    public static final String ERROR_IO = "IO 操作异常 - IOException";
    public static final String ERROR_NULL_PARAMETER = "空指针异常 - NullPointException";
    public static final String ERROR_PROTOCOL = "协议解析错误 - ProtocolException";
    public static final String ERROR_SOCKET = "socket 连接异常 - SocketException";
    public static final String ERROR_SOCKE_TIME_OUT = "socket 连接超时 - SocketTimeoutException";
    public static final String ERROR_UNKNOWN = "未知的错误";
    public static final String ERROR_UNKNOW_HOST = "未知主机 - UnKnowHostException";
    public static final String ERROR_UNKNOW_SERVICE = "服务器连接失败 - UnknownServiceException";
    public static final String ERROR_URL = "url异常 - MalformedURLException";
    /* renamed from: a */
    private String f2549a = "未知的错误";

    public AMapException(String str) {
        this.f2549a = str;
    }

    public String getErrorMessage() {
        return this.f2549a;
    }
}
