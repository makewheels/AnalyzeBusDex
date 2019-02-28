package com.amap.api.p015a.p016a;

import com.alipay.sdk.cons.C0108a;
import com.amap.api.maps2d.AMapException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;

/* compiled from: HttpTool */
/* renamed from: com.amap.api.a.a.i */
public class C0192i {
    /* renamed from: a */
    public static HttpURLConnection m715a(String str, Proxy proxy) throws AMapException {
        if (str == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(str);
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(50000);
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty("User-Agent", "AMAP SDK Android 2DMap 2.3.0");
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return httpURLConnection;
            }
            throw new AMapException("http连接失败 - ConnectionException");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new AMapException("未知主机 - UnKnowHostException");
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            throw new AMapException("url异常 - MalformedURLException");
        } catch (ProtocolException e3) {
            e3.printStackTrace();
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (SocketTimeoutException e4) {
            e4.printStackTrace();
            throw new AMapException("socket 连接超时 - SocketTimeoutException");
        } catch (IOException e5) {
            e5.printStackTrace();
            throw new AMapException("IO 操作异常 - IOException");
        }
    }

    /* renamed from: a */
    public static HttpURLConnection m716a(String str, byte[] bArr, Proxy proxy) throws AMapException {
        if (str == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        try {
            HttpURLConnection httpURLConnection;
            URL url = new URL(str);
            if (proxy != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(50000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("User-Agent", "AMAP SDK Android 2DMap 2.3.0");
            httpURLConnection.setRequestProperty("X-INFO", C0184e.m646a(null).m654b());
            httpURLConnection.setRequestProperty("ia", C0108a.f262e);
            httpURLConnection.setRequestProperty("key", C0184e.f524a);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
            outputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                return httpURLConnection;
            }
            throw new AMapException("http连接失败 - ConnectionException");
        } catch (UnknownHostException e) {
            throw new AMapException("未知主机 - UnKnowHostException");
        } catch (MalformedURLException e2) {
            throw new AMapException("url异常 - MalformedURLException");
        } catch (ProtocolException e3) {
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (SocketTimeoutException e4) {
            throw new AMapException("socket 连接超时 - SocketTimeoutException");
        } catch (IOException e5) {
            throw new AMapException("IO 操作异常 - IOException");
        } catch (Exception e6) {
            throw new AMapException("未知的错误");
        }
    }
}
