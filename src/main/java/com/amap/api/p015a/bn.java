package com.amap.api.p015a;

import com.amap.api.maps2d.AMapException;
import com.amap.api.p015a.p016a.C0192i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.zip.GZIPInputStream;
import p054u.aly.bi_常量类;

/* compiled from: ProtocalHandler */
/* renamed from: com.amap.api.a.bn */
public abstract class bn<T, V> {
    /* renamed from: a */
    protected Proxy f904a;
    /* renamed from: b */
    protected T f905b;
    /* renamed from: c */
    protected int f906c = 1;
    /* renamed from: d */
    protected int f907d = 20;
    /* renamed from: e */
    protected int f908e = 0;
    /* renamed from: f */
    protected int f909f = 0;
    /* renamed from: g */
    protected String f910g;
    /* renamed from: h */
    protected String f911h = bi_常量类.f6358b;

    /* renamed from: a */
    protected abstract V mo229a(InputStream inputStream) throws AMapException;

    /* renamed from: a */
    protected abstract byte[] mo230a();

    /* renamed from: b */
    protected abstract String mo231b();

    public bn(T t, Proxy proxy, String str, String str2) {
        this.f904a = proxy;
        this.f905b = t;
        this.f906c = 1;
        this.f907d = 5;
        this.f908e = 2;
        this.f910g = str2;
    }

    /* renamed from: c */
    protected byte[] m1492c() {
        return mo230a();
    }

    /* renamed from: d */
    public V m1493d() throws AMapException {
        if (this.f905b != null) {
            return mo234f();
        }
        return null;
    }

    /* renamed from: f */
    private V mo234f() throws AMapException {
        InputStream a;
        AMapException e;
        Throwable th;
        int i = 0;
        V v = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        while (i < this.f906c) {
            try {
                this.f911h = mo231b();
                byte[] c = m1492c();
                if (c == null) {
                    httpURLConnection = C0192i.m715a(this.f911h, this.f904a);
                } else {
                    httpURLConnection = C0192i.m716a(this.f911h, c, this.f904a);
                }
                a = m1488a(httpURLConnection);
                try {
                    v = mo232b(a);
                    i = this.f906c;
                    if (a != null) {
                        try {
                            a.close();
                            inputStream = null;
                        } catch (IOException e2) {
                            throw new AMapException("IO 操作异常 - IOException");
                        }
                    }
                    inputStream = a;
                    if (null != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            throw new AMapException("IO 操作异常 - IOException");
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        httpURLConnection = null;
                    }
                } catch (AMapException e4) {
                    e = e4;
                    try {
                        e.printStackTrace();
                        i++;
                        if (i >= this.f906c) {
                            Thread.sleep((long) (this.f908e * 1000));
                            if (a == null) {
                                try {
                                    a.close();
                                    inputStream = null;
                                } catch (IOException e5) {
                                    throw new AMapException("IO 操作异常 - IOException");
                                }
                            }
                            inputStream = a;
                            if (null != null) {
                                try {
                                    outputStream.close();
                                } catch (IOException e6) {
                                    throw new AMapException("IO 操作异常 - IOException");
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                httpURLConnection = null;
                            }
                            outputStream = null;
                        } else {
                            e.printStackTrace();
                            mo233e();
                            throw new AMapException(e.getErrorMessage());
                        }
                    } catch (InterruptedException e7) {
                        throw new AMapException(e7.getMessage());
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (AMapException e8) {
                AMapException aMapException = e8;
                a = inputStream;
                e = aMapException;
                e.printStackTrace();
                i++;
                if (i >= this.f906c) {
                    e.printStackTrace();
                    mo233e();
                    throw new AMapException(e.getErrorMessage());
                }
                Thread.sleep((long) (this.f908e * 1000));
                if (a == null) {
                    inputStream = a;
                } else {
                    a.close();
                    inputStream = null;
                }
                if (null != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                    httpURLConnection = null;
                }
                outputStream = null;
            } catch (Throwable th3) {
                th = th3;
                a = inputStream;
            }
            outputStream = null;
        }
        return v;
        if (a != null) {
            try {
                a.close();
            } catch (IOException e9) {
                throw new AMapException("IO 操作异常 - IOException");
            }
        }
        if (null != null) {
            try {
                outputStream.close();
            } catch (IOException e10) {
                throw new AMapException("IO 操作异常 - IOException");
            }
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }

    /* renamed from: a */
    protected InputStream m1488a(HttpURLConnection httpURLConnection) throws AMapException {
        try {
            InputStream pushbackInputStream = new PushbackInputStream(httpURLConnection.getInputStream(), 2);
            byte[] bArr = new byte[2];
            pushbackInputStream.read(bArr);
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

    /* renamed from: b */
    private V mo232b(InputStream inputStream) throws AMapException {
        return mo229a(inputStream);
    }

    /* renamed from: e */
    protected V mo233e() {
        return null;
    }
}
