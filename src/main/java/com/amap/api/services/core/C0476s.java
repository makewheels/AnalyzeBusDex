package com.amap.api.services.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.zip.GZIPInputStream;
import p054u.aly.bi_常量类;

/* compiled from: ProtocalHandler */
/* renamed from: com.amap.api.services.core.s */
public abstract class C0476s<T, V> {
    protected int maxTry = 1;
    protected Proxy proxy;
    protected String recommandURL = bi_常量类.f6358b;
    protected T task;

    protected abstract String getRequestString(boolean z);

    protected abstract String getUrl();

    protected abstract V paseJSON(String str) throws AMapException;

    public C0476s(T t, Proxy proxy) {
        m3992a(t, proxy);
    }

    public C0476s(Proxy proxy) {
        m3992a(null, proxy);
    }

    /* renamed from: a */
    private void m3992a(T t, Proxy proxy) {
        this.task = t;
        this.proxy = proxy;
        this.maxTry = 1;
    }

    protected byte[] getProtoBufferRequest() {
        try {
            return getRequestStr().getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected V loadData(InputStream inputStream) throws AMapException {
        String str;
        try {
            str = new String(C0480e.m4021a(inputStream), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || str.equals(bi_常量类.f6358b)) {
            return null;
        }
        C0480e.m4024b(str);
        return paseJSON(str);
    }

    protected byte[] makeProtobufRequestBytes() {
        return getProtoBufferRequest();
    }

    public V getData() throws AMapException {
        if (this.task != null) {
            return mo657a();
        }
        return null;
    }

    /* renamed from: a */
    private V mo657a() throws AMapException {
        AMapException e;
        Throwable th;
        int i = 0;
        V v = null;
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        while (i < this.maxTry) {
            InputStream sendRequest;
            try {
                this.recommandURL = getUrl();
                byte[] makeProtobufRequestBytes = makeProtobufRequestBytes();
                if (makeProtobufRequestBytes == null) {
                    httpURLConnection = C0485j.m4038a(this.recommandURL, this.proxy);
                } else {
                    httpURLConnection = C0485j.m4039a(this.recommandURL, makeProtobufRequestBytes, this.proxy);
                }
                sendRequest = sendRequest(httpURLConnection);
                try {
                    v = m3991a(sendRequest);
                    i = this.maxTry;
                    if (sendRequest != null) {
                        try {
                            sendRequest.close();
                            inputStream = null;
                        } catch (IOException e2) {
                            throw new AMapException("IO 操作异常 - IOException");
                        }
                    }
                    inputStream = sendRequest;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection = null;
                    }
                } catch (AMapException e3) {
                    e = e3;
                    i++;
                    try {
                        if (i < this.maxTry) {
                            throw new AMapException(e.getErrorMessage());
                        }
                        if (sendRequest == null) {
                            try {
                                sendRequest.close();
                                inputStream = null;
                            } catch (IOException e4) {
                                throw new AMapException("IO 操作异常 - IOException");
                            }
                        }
                        inputStream = sendRequest;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            httpURLConnection = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = sendRequest;
                    }
                }
            } catch (AMapException e5) {
                AMapException aMapException = e5;
                sendRequest = inputStream;
                e = aMapException;
                i++;
                if (i < this.maxTry) {
                    if (sendRequest == null) {
                        inputStream = sendRequest;
                    } else {
                        sendRequest.close();
                        inputStream = null;
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection = null;
                    }
                } else {
                    throw new AMapException(e.getErrorMessage());
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return v;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e6) {
                throw new AMapException("IO 操作异常 - IOException");
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }

    protected String getRequestStr() {
        return C0480e.m4015a(getRequestString(false), getRequestString(true));
    }

    protected InputStream sendRequest(HttpURLConnection httpURLConnection) throws AMapException {
        try {
            InputStream pushbackInputStream = new PushbackInputStream(httpURLConnection.getInputStream(), 2);
            byte[] bArr = new byte[2];
            if (pushbackInputStream.read(bArr) != 2) {
                return pushbackInputStream;
            }
            pushbackInputStream.unread(bArr);
            if (bArr[0] == (byte) 31 && bArr[1] == (byte) -117) {
                return new GZIPInputStream(pushbackInputStream);
            }
            return pushbackInputStream;
        } catch (ProtocolException e) {
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (UnknownHostException e2) {
            throw new AMapException("未知主机 - UnKnowHostException");
        } catch (UnknownServiceException e3) {
            throw new AMapException("服务器连接失败 - UnknownServiceException");
        } catch (IOException e4) {
            throw new AMapException("IO 操作异常 - IOException");
        }
    }

    /* renamed from: a */
    private V m3991a(InputStream inputStream) throws AMapException {
        return loadData(inputStream);
    }

    protected V onExceptionOccur() {
        return null;
    }

    protected String strEncoder(String str, boolean z) {
        String str2 = bi_常量类.f6358b;
        if (!z) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        } catch (Exception e2) {
            return str2;
        }
    }
}
