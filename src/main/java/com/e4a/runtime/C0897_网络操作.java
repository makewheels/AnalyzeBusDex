package com.e4a.runtime;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.collections.C0682;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

@UsesPermissions(permissionNames = "android.permission.INTERNET")
@SimpleObject
/* renamed from: com.e4a.runtime.网络操作 */
public final class C0897_网络操作 {
    public static final int NETWORKTYPE_2G = 2;
    public static final int NETWORKTYPE_3G = 3;
    public static final int NETWORKTYPE_4G = 5;
    public static final int NETWORKTYPE_INVALID = 0;
    public static final int NETWORKTYPE_UNKNOWN = 6;
    public static final int NETWORKTYPE_WAP = 1;
    public static final int NETWORKTYPE_WIFI = 4;
    private static DefaultHttpClient client = new DefaultHttpClient();
    private static String cookies_get = bi_常量类.f6358b_空串;
    private static String cookies_set = null;
    private static Header[] reqHeaders = null;
    private static Header[] responseHeaders = null;
    /* renamed from: 协议头 */
    private static String f4340 = null;
    /* renamed from: 待清除协议头 */
    private static String f4341 = null;
    /* renamed from: 永久清除协议头 */
    private static boolean f4342 = false;

    private C0897_网络操作() {
    }

    @SimpleFunction
    /* renamed from: 禁止重定向 */
    public static void m6932(boolean value) {
        final boolean set = value;
        client.setRedirectHandler(new RedirectHandler() {
            public boolean isRedirectRequested(HttpResponse response, HttpContext context) {
                return !set;
            }

            public URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext) {
                return null;
            }
        });
    }

    @SimpleFunction
    /* renamed from: 同步cookies */
    public static String m6925cookies(String url) {
        CookieSyncManager.createInstance(C0841.m6594());
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        List<Cookie> cookies = client.getCookieStore().getCookies();
        String cookieString = bi_常量类.f6358b_空串;
        if (!cookies.isEmpty()) {
            for (Cookie cookie : cookies) {
                cookieString = cookie.getName() + "=" + cookie.getValue() + ";" + cookieString;
            }
            cookieString = "Set-Cookie:" + cookieString + ";domain=http://bbs.e4asoft.com" + ";path=/";
        }
        cookieManager.setCookie(url, cookieString);
        CookieSyncManager.getInstance().sync();
        return cookieString;
    }

    @SimpleFunction
    /* renamed from: 清空cookie */
    public static void m6929cookie() {
        CookieSyncManager cookieSyncMngr = CookieSyncManager.createInstance(C0841.m6594());
        CookieManager.getInstance().removeAllCookie();
    }

    @SimpleFunction
    /* renamed from: 取请求头 */
    public static String m6924() {
        if (reqHeaders == null) {
            return bi_常量类.f6358b_空串;
        }
        String result = bi_常量类.f6358b_空串;
        for (int i = 0; i < reqHeaders.length; i++) {
            String name = reqHeaders[i].getName();
            String value = reqHeaders[i].getValue();
            if (result.equals(bi_常量类.f6358b_空串)) {
                result = name + ":" + value;
            } else {
                result = result + "\n" + name + ":" + value;
            }
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 取响应头 */
    public static String m6915() {
        if (responseHeaders == null) {
            return bi_常量类.f6358b_空串;
        }
        String result = bi_常量类.f6358b_空串;
        for (int i = 0; i < responseHeaders.length; i++) {
            String name = responseHeaders[i].getName();
            String value = responseHeaders[i].getValue();
            if (result.equals(bi_常量类.f6358b_空串)) {
                result = name + ":" + value;
            } else {
                result = result + "\n" + name + ":" + value;
            }
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 发送网络数据 */
    public static String m6909(String loginUrl, String paramdata, String Charset, int timeout) {
        try {
            String[] keyPair;
            String param;
            HttpPost httpPost = new HttpPost(loginUrl);
            List<NameValuePair> params = new ArrayList();
            String name = bi_常量类.f6358b_空串;
            String value = bi_常量类.f6358b_空串;
            if (!bi_常量类.f6358b_空串.equals(paramdata)) {
                if (paramdata.indexOf("&", 0) > 0) {
                    for (String param2 : paramdata.split("\\Q&\\E")) {
                        keyPair = param2.split("\\Q=\\E");
                        params.add(new BasicNameValuePair(keyPair[0], keyPair.length > 1 ? keyPair[1].trim() : bi_常量类.f6358b_空串));
                    }
                    httpPost.setEntity(new UrlEncodedFormEntity(params, Charset));
                } else if (paramdata.indexOf("=", 0) > 0) {
                    keyPair = paramdata.split("\\Q=\\E");
                    params.add(new BasicNameValuePair(keyPair[0], keyPair.length > 1 ? keyPair[1].trim() : bi_常量类.f6358b_空串));
                    httpPost.setEntity(new UrlEncodedFormEntity(params, Charset));
                } else {
                    StringEntity entity = new StringEntity(paramdata, Charset);
                    entity.setContentType("application/x-www-form-urlencoded");
                    httpPost.setEntity(entity);
                }
            }
            if (!(f4340 == null || f4340.equals(bi_常量类.f6358b_空串))) {
                for (String param22 : f4340.split("\\Q\n\\E")) {
                    param22 = C0890_文本操作.m6808_trim删除首尾空格(param22);
                    name = C0890_文本操作.m6816(param22, C0890_文本操作.m6821_寻找文本(param22, ":", 0));
                    httpPost.addHeader(name, C0890_文本操作.m6815(param22, (C0890_文本操作.m6817_获取字符串长度(param22) - C0890_文本操作.m6817_获取字符串长度(name)) - 1));
                }
            }
            if (f4341 != null) {
                httpPost.removeHeaders(f4341);
                if (!f4342) {
                    f4341 = null;
                }
            }
            if (!(cookies_set == null || cookies_set.equals(bi_常量类.f6358b_空串))) {
                httpPost.addHeader("Cookie", cookies_set);
            }
            reqHeaders = httpPost.getAllHeaders();
            HttpParams httpparam = client.getParams();
            HttpConnectionParams.setConnectionTimeout(httpparam, timeout);
            HttpConnectionParams.setSoTimeout(httpparam, timeout);
            HttpResponse httpResponse = client.execute(httpPost);
            responseHeaders = httpResponse.getAllHeaders();
            cookies_get = bi_常量类.f6358b_空串;
            Header[] headers = httpResponse.getHeaders("Set-Cookie");
            if (headers != null) {
                for (Header value2 : headers) {
                    String[] cookievalues = value2.getValue().split(";");
                    for (String split : cookievalues) {
                        keyPair = split.split("=");
                        String key = keyPair[0].trim();
                        String value22 = keyPair.length > 1 ? keyPair[1].trim() : bi_常量类.f6358b_空串;
                        if (cookies_get.equals(bi_常量类.f6358b_空串)) {
                            cookies_get = key + "=" + value22;
                        } else {
                            cookies_get += ";" + key + "=" + value22;
                        }
                    }
                }
            }
            return EntityUtils.toString(httpResponse.getEntity(), Charset);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 发送网络数据2 */
    public static String m69102(String IP, int PORT, String CONTENT, String CHARSET, int TIMEOUT) {
        String str1 = bi_常量类.f6358b_空串;
        try {
            Socket localSocket = new Socket(IP, PORT);
            localSocket.setSoTimeout(TIMEOUT);
            BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localSocket.getInputStream(), CHARSET));
            PrintWriter localPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(localSocket.getOutputStream(), CHARSET)), true);
            localPrintWriter.println(CONTENT);
            while (true) {
                String str2 = localBufferedReader.readLine();
                if (str2 == null) {
                    localSocket.close();
                    localBufferedReader.close();
                    localPrintWriter.close();
                    return str1;
                }
                str1 = str1 + str2 + "\n";
            }
        } catch (IOException e) {
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 发送网络数据3 */
    public static String m69113(String loginUrl, C0682 paramHashmap, String Charset, int timeout) {
        try {
            HttpPost httpPost = new HttpPost(loginUrl);
            List<NameValuePair> params = new ArrayList();
            String name = bi_常量类.f6358b_空串;
            while (paramHashmap.m5451()) {
                name = paramHashmap.m5444();
                params.add(new BasicNameValuePair(name, paramHashmap.m5448(name).getString()));
            }
            httpPost.setEntity(new UrlEncodedFormEntity(params, Charset));
            if (!(f4340 == null || f4340.equals(bi_常量类.f6358b_空串))) {
                for (String param : f4340.split("\\Q\n\\E")) {
                    String param2 = C0890_文本操作.m6808_trim删除首尾空格(param2);
                    name = C0890_文本操作.m6816(param2, C0890_文本操作.m6821_寻找文本(param2, ":", 0));
                    httpPost.addHeader(name, C0890_文本操作.m6815(param2, (C0890_文本操作.m6817_获取字符串长度(param2) - C0890_文本操作.m6817_获取字符串长度(name)) - 1));
                }
            }
            if (f4341 != null) {
                httpPost.removeHeaders(f4341);
                if (!f4342) {
                    f4341 = null;
                }
            }
            if (!(cookies_set == null || cookies_set.equals(bi_常量类.f6358b_空串))) {
                httpPost.addHeader("Cookie", cookies_set);
            }
            reqHeaders = httpPost.getAllHeaders();
            HttpParams httpparam = client.getParams();
            HttpConnectionParams.setConnectionTimeout(httpparam, timeout);
            HttpConnectionParams.setSoTimeout(httpparam, timeout);
            HttpResponse httpResponse = client.execute(httpPost);
            responseHeaders = httpResponse.getAllHeaders();
            cookies_get = bi_常量类.f6358b_空串;
            Header[] headers = httpResponse.getHeaders("Set-Cookie");
            if (headers != null) {
                for (Header value : headers) {
                    String[] cookievalues = value.getValue().split(";");
                    for (String split : cookievalues) {
                        String[] keyPair = split.split("=");
                        String key = keyPair[0].trim();
                        String value2 = keyPair.length > 1 ? keyPair[1].trim() : bi_常量类.f6358b_空串;
                        if (cookies_get.equals(bi_常量类.f6358b_空串)) {
                            cookies_get = key + "=" + value2;
                        } else {
                            cookies_get += ";" + key + "=" + value2;
                        }
                    }
                }
            }
            return EntityUtils.toString(httpResponse.getEntity(), Charset);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 置cookies */
    public static void m6933cookies(String cookies) {
        cookies_set = cookies;
    }

    @SimpleFunction
    /* renamed from: 取cookies */
    public static String m6913cookies() {
        return cookies_get;
    }

    @SimpleFunction
    /* renamed from: 置附加协议头 */
    public static void m6934(String header) {
        f4340 = header;
    }

    @SimpleFunction
    /* renamed from: 清除协议头 */
    public static void m6930(String header, boolean 永久清除) {
        f4341 = header;
    }

    @SimpleFunction
    /* renamed from: 取网络文件 */
    public static byte[] m6918(String Url, int timeout) {
        try {
            HttpGet httprequest = new HttpGet(Url);
            if (!(f4340 == null || f4340.equals(bi_常量类.f6358b_空串))) {
                String name = bi_常量类.f6358b_空串;
                String value = bi_常量类.f6358b_空串;
                for (String param : f4340.split("\\Q\n\\E")) {
                    String param2 = C0890_文本操作.m6808_trim删除首尾空格(param2);
                    name = C0890_文本操作.m6816(param2, C0890_文本操作.m6821_寻找文本(param2, ":", 0));
                    httprequest.addHeader(name, C0890_文本操作.m6815(param2, (C0890_文本操作.m6817_获取字符串长度(param2) - C0890_文本操作.m6817_获取字符串长度(name)) - 1));
                }
            }
            if (f4341 != null) {
                httprequest.removeHeaders(f4341);
                if (!f4342) {
                    f4341 = null;
                }
            }
            if (!(cookies_set == null || cookies_set.equals(bi_常量类.f6358b_空串))) {
                httprequest.addHeader("Cookie", cookies_set);
            }
            reqHeaders = httprequest.getAllHeaders();
            HttpParams httpparam = client.getParams();
            HttpConnectionParams.setConnectionTimeout(httpparam, timeout);
            HttpConnectionParams.setSoTimeout(httpparam, timeout);
            HttpResponse httpResponse = client.execute(httprequest);
            responseHeaders = httpResponse.getAllHeaders();
            cookies_get = bi_常量类.f6358b_空串;
            Header[] headers = httpResponse.getHeaders("Set-Cookie");
            if (headers != null) {
                for (Header value2 : headers) {
                    String[] cookievalues = value2.getValue().split(";");
                    for (String split : cookievalues) {
                        String[] keyPair = split.split("=");
                        String key = keyPair[0].trim();
                        String value22 = keyPair.length > 1 ? keyPair[1].trim() : bi_常量类.f6358b_空串;
                        if (cookies_get.equals(bi_常量类.f6358b_空串)) {
                            cookies_get = key + "=" + value22;
                        } else {
                            cookies_get += ";" + key + "=" + value22;
                        }
                    }
                }
            }
            return EntityUtils.toByteArray(httpResponse.getEntity());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (IOException e2) {
            e2.printStackTrace();
            return new byte[0];
        }
    }

    @SimpleFunction
    /* renamed from: 取网页源码 */
    public static String m6922(String Url, String Charset, int timeout) {
        try {
            HttpGet httprequest = new HttpGet(Url);
            if (!(f4340 == null || f4340.equals(bi_常量类.f6358b_空串))) {
                String name = bi_常量类.f6358b_空串;
                String value = bi_常量类.f6358b_空串;
                for (String param : f4340.split("\\Q\n\\E")) {
                    String param2 = C0890_文本操作.m6808_trim删除首尾空格(param2);
                    name = C0890_文本操作.m6816(param2, C0890_文本操作.m6821_寻找文本(param2, ":", 0));
                    httprequest.addHeader(name, C0890_文本操作.m6815(param2, (C0890_文本操作.m6817_获取字符串长度(param2) - C0890_文本操作.m6817_获取字符串长度(name)) - 1));
                }
            }
            if (f4341 != null) {
                httprequest.removeHeaders(f4341);
                if (!f4342) {
                    f4341 = null;
                }
            }
            if (!(cookies_set == null || cookies_set.equals(bi_常量类.f6358b_空串))) {
                httprequest.addHeader("Cookie", cookies_set);
            }
            reqHeaders = httprequest.getAllHeaders();
            HttpParams httpparam = client.getParams();
            HttpConnectionParams.setConnectionTimeout(httpparam, timeout);
            HttpConnectionParams.setSoTimeout(httpparam, timeout);
            HttpResponse httpResponse = client.execute(httprequest);
            responseHeaders = httpResponse.getAllHeaders();
            HttpEntity he = httpResponse.getEntity();
            if (he == null) {
                return bi_常量类.f6358b_空串;
            }
            cookies_get = bi_常量类.f6358b_空串;
            Header[] headers = httpResponse.getHeaders("Set-Cookie");
            if (headers != null) {
                for (Header value2 : headers) {
                    String[] cookievalues = value2.getValue().split(";");
                    for (String split : cookievalues) {
                        String[] keyPair = split.split("=");
                        String key = keyPair[0].trim();
                        String value22 = keyPair.length > 1 ? keyPair[1].trim() : bi_常量类.f6358b_空串;
                        if (cookies_get.equals(bi_常量类.f6358b_空串)) {
                            cookies_get = key + "=" + value22;
                        } else {
                            cookies_get += ";" + key + "=" + value22;
                        }
                    }
                }
            }
            return EntityUtils.toString(he, Charset);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 取网页源码2 */
    public static String m69232(String url, String charset, int timeout) {
        try {
            int i;
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(timeout);
            conn.setReadTimeout(timeout);
            conn.setRequestProperty("Referer", url);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; BOIE9;ZHCN)");
            if (cookies_set != null && !cookies_set.equals(bi_常量类.f6358b_空串)) {
                conn.setRequestProperty("Cookie", cookies_set);
            } else if (!cookies_get.equals(bi_常量类.f6358b_空串)) {
                conn.setRequestProperty("Cookie", cookies_get);
            }
            if (!(f4340 == null || f4340.equals(bi_常量类.f6358b_空串))) {
                String name = bi_常量类.f6358b_空串;
                String value = bi_常量类.f6358b_空串;
                for (String param : f4340.split("\\Q\n\\E")) {
                    String param2 = C0890_文本操作.m6808_trim删除首尾空格(param2);
                    name = C0890_文本操作.m6816(param2, C0890_文本操作.m6821_寻找文本(param2, ":", 0));
                    conn.setRequestProperty(name, C0890_文本操作.m6815(param2, (C0890_文本操作.m6817_获取字符串长度(param2) - C0890_文本操作.m6817_获取字符串长度(name)) - 1));
                }
            }
            InputStream inStream = conn.getInputStream();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            while (true) {
                i = inStream.read(buffer);
                if (i == -1) {
                    break;
                }
                outStream.write(buffer, 0, i);
            }
            String str = new String(outStream.toByteArray(), charset);
            String key = bi_常量类.f6358b_空串;
            if (conn != null) {
                i = 1;
                while (true) {
                    key = conn.getHeaderFieldKey(i);
                    if (key == null) {
                        break;
                    }
                    if (key.equalsIgnoreCase("Set-Cookie")) {
                        cookies_get = conn.getHeaderField(key) + ";" + cookies_get;
                    }
                    i++;
                }
            }
            outStream.close();
            inStream.close();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 发送网络数据4 */
    public static String m69124(String 网址, String 数据, String 编码, int 超时) {
        Exception e;
        String result = bi_常量类.f6358b_空串;
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(网址).openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setReadTimeout(超时);
            urlConnection.setConnectTimeout(超时);
            urlConnection.setRequestProperty("Connection", "keep-alive");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlConnection.setRequestProperty("Content-Length", String.valueOf(数据.getBytes().length));
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0");
            if (!(f4340 == null || f4340.equals(bi_常量类.f6358b_空串))) {
                String name = bi_常量类.f6358b_空串;
                String value = bi_常量类.f6358b_空串;
                for (String param : f4340.split("\\Q\n\\E")) {
                    String param2 = C0890_文本操作.m6808_trim删除首尾空格(param2);
                    name = C0890_文本操作.m6816(param2, C0890_文本操作.m6821_寻找文本(param2, ":", 0));
                    urlConnection.setRequestProperty(name, C0890_文本操作.m6815(param2, (C0890_文本操作.m6817_获取字符串长度(param2) - C0890_文本操作.m6817_获取字符串长度(name)) - 1));
                }
            }
            if (cookies_set != null && !cookies_set.equals(bi_常量类.f6358b_空串)) {
                urlConnection.setRequestProperty("Cookie", cookies_set);
            } else if (!cookies_get.equals(bi_常量类.f6358b_空串)) {
                urlConnection.setRequestProperty("Cookie", cookies_get);
            }
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            OutputStream os = urlConnection.getOutputStream();
            os.write(数据.getBytes(编码));
            os.flush();
            InputStream is = urlConnection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            while (true) {
                int len = is.read(buffer);
                if (len == -1) {
                    break;
                }
                baos.write(buffer, 0, len);
            }
            is.close();
            baos.close();
            String str = new String(baos.toByteArray(), 编码);
            try {
                String key = bi_常量类.f6358b_空串;
                if (urlConnection != null) {
                    int i = 1;
                    while (true) {
                        key = urlConnection.getHeaderFieldKey(i);
                        if (key == null) {
                            break;
                        }
                        if (key.equalsIgnoreCase("Set-Cookie")) {
                            cookies_get = urlConnection.getHeaderField(key) + ";" + cookies_get;
                        }
                        i++;
                    }
                }
                return str;
            } catch (Exception e2) {
                e = e2;
                result = str;
                e.printStackTrace();
                return result;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return result;
        }
    }

    @SimpleFunction
    /* renamed from: 取网络文件大小 */
    public static int m6919(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestProperty("Accept-Encoding", "identity");
            return conn.getContentLength();
        } catch (IOException e) {
            return -1;
        }
    }

    @SimpleFunction
    /* renamed from: 取网络状态 */
    public static boolean m6920_取网络状态() {
        ConnectivityManager conMan = (ConnectivityManager) C0841.m6594().getSystemService("connectivity");
        State mobile = conMan.getNetworkInfo(0).getState();
        State wifi = conMan.getNetworkInfo(1).getState();
        if (mobile == State.CONNECTED || wifi == State.CONNECTED) {
            return true;
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 取网络类型 */
    public static int m6921() {
        NetworkInfo ni = ((ConnectivityManager) C0841.m6594().getSystemService("connectivity")).getActiveNetworkInfo();
        if (ni == null || !ni.isConnectedOrConnecting()) {
            return 0;
        }
        if (VERSION.SDK_INT >= 14) {
            switch (ni.getType()) {
                case 0:
                    switch (ni.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 5;
                        default:
                            return 6;
                    }
                case 1:
                    return 4;
                default:
                    return 6;
            }
        }
        switch (ni.getType()) {
            case 0:
                switch (ni.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                        return 3;
                    default:
                        return 6;
                }
            case 1:
                return 4;
            default:
                return 6;
        }
    }

    @SimpleFunction
    /* renamed from: 打开网络设置 */
    public static void m6928() {
        mainActivity.getContext().startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }

    @SimpleFunction
    /* renamed from: 打开指定网址 */
    public static void m6927_打开指定网址(String url) {
        mainActivity.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    @SimpleFunction
    /* renamed from: JSON解析 */
    public static String m6908JSON(String json, String item, String name, int type) {
        String value = bi_常量类.f6358b_空串;
        switch (type) {
            case 1:
                try {
                    value = new JSONObject(json).getString(name);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return bi_常量类.f6358b_空串;
                }
            case 2:
                try {
                    value = new JSONObject(json).getJSONObject(item).getString(name);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return bi_常量类.f6358b_空串;
                }
            case 3:
                try {
                    JSONArray numberList = new JSONObject(json).getJSONArray(item);
                    for (int i = 0; i < numberList.length(); i++) {
                        if (i == 0) {
                            value = numberList.getJSONObject(i).getString(name);
                        } else {
                            value = value + "\n" + numberList.getJSONObject(i).getString(name);
                        }
                    }
                    break;
                } catch (Exception e22) {
                    e22.printStackTrace();
                    return bi_常量类.f6358b_空串;
                }
        }
        return value;
    }

    @SimpleFunction
    /* renamed from: 取外网IP */
    public static String m6916IP() {
        String result = bi_常量类.f6358b_空串;
        String html = C0897_网络操作.m69232("http://www.123cha.com/", "UTF-8", 5000);
        if (html.equals(bi_常量类.f6358b_空串)) {
            return result;
        }
        String[] html2 = C0892.m6854(html, "(?<=\\Q您的ip:[\\E).*?(?=\\Q</a>]\\E)");
        if (html2.length <= 0) {
            return result;
        }
        String[] html3 = html2[0].split("\\Q_blank>\\E");
        if (html3.length > 1) {
            return html3[1];
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 取手机所在地区 */
    public static String m6917() {
        String result = bi_常量类.f6358b_空串;
        String html = C0897_网络操作.m69232("http://www.123cha.com/", "UTF-8", 5000);
        if (html.equals(bi_常量类.f6358b_空串)) {
            return result;
        }
        String[] html2 = C0892.m6854(html, "(?<=\\Q来自:&nbsp;\\E).*?(?=\\Q&nbsp;++\\E)");
        if (html2.length <= 0) {
            return result;
        }
        String[] html3 = html2[0].split("\\Q&nbsp;\\E");
        if (html3.length > 1) {
            return html3[0] + html3[1];
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 取内网IP */
    public static String m6914IP() {
        try {
            Enumeration<NetworkInterface> mEnumeration = NetworkInterface.getNetworkInterfaces();
            while (mEnumeration.hasMoreElements()) {
                Enumeration<InetAddress> enumIPAddr = ((NetworkInterface) mEnumeration.nextElement()).getInetAddresses();
                while (enumIPAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) enumIPAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
            return bi_常量类.f6358b_空串;
        } catch (SocketException ex) {
            ex.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 域名取IP */
    public static String m6926IP(String host) {
        try {
            HttpGet httprequest = new HttpGet("http://www.ip138.com/ips138.asp?ip=" + host);
            HttpParams httpparam = client.getParams();
            HttpConnectionParams.setConnectionTimeout(httpparam, 5000);
            HttpConnectionParams.setSoTimeout(httpparam, 5000);
            HttpResponse httpResponse = client.execute(httprequest);
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                return bi_常量类.f6358b_空串;
            }
            String jieguo = EntityUtils.toString(httpResponse.getEntity(), "GBK");
            if (jieguo.length() <= 100) {
                return bi_常量类.f6358b_空串;
            }
            String[] temp = C0892.m6854(jieguo, "(?<= >> ).*?(?=</font></h1></td>)");
            if (temp.length > 0) {
                return temp[0].trim();
            }
            return bi_常量类.f6358b_空串;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        } catch (IOException e2) {
            e2.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 百度翻译 */
    public static String m6931(String appid, String token, String text, int from, int to) {
        String from2 = bi_常量类.f6358b_空串;
        String to2 = bi_常量类.f6358b_空串;
        switch (from) {
            case 0:
                from2 = "auto";
                break;
            case 1:
                from2 = "zh";
                break;
            case 2:
                from2 = "en";
                break;
            case 3:
                from2 = "jp";
                break;
            case 4:
                from2 = "kor";
                break;
            case 5:
                from2 = "spa";
                break;
            case 6:
                from2 = "fra";
                break;
            case 7:
                from2 = "th";
                break;
            case 8:
                from2 = "ara";
                break;
            case 9:
                from2 = "ru";
                break;
            case 10:
                from2 = "pt";
                break;
            case 11:
                from2 = "yue";
                break;
            case 12:
                from2 = "wyw";
                break;
            case 13:
                from2 = "de";
                break;
            case 14:
                from2 = "it";
                break;
            default:
                from2 = "auto";
                break;
        }
        switch (to) {
            case 0:
                to2 = "auto";
                break;
            case 1:
                to2 = "zh";
                break;
            case 2:
                to2 = "en";
                break;
            case 3:
                to2 = "jp";
                break;
            case 4:
                to2 = "kor";
                break;
            case 5:
                to2 = "spa";
                break;
            case 6:
                to2 = "fra";
                break;
            case 7:
                to2 = "th";
                break;
            case 8:
                to2 = "ara";
                break;
            case 9:
                to2 = "ru";
                break;
            case 10:
                to2 = "pt";
                break;
            case 11:
                to2 = "yue";
                break;
            case 12:
                to2 = "wyw";
                break;
            case 13:
                to2 = "de";
                break;
            case 14:
                to2 = "it";
                break;
        }
        to2 = "auto";
        int salt = new Random().nextInt(10000);
        String temp = C0899.m6952(C0897_网络操作.m6918("http://api.fanyi.baidu.com/api/trans/vip/translate?q=" + C0895.m6905URL(text, "UTF-8") + "&from=" + from2 + "&to=" + to2 + "&appid=" + appid + "&salt=" + salt + "&sign=" + C0890_文本操作.m6811(C0843_加密操作.m6613MD5(C0899.m6961(appid + text + salt + token, "UTF-8"))), 5000), "UTF-8");
        if (C0890_文本操作.m6817_获取字符串长度(temp) <= 5 || C0890_文本操作.m6821_寻找文本(temp, "error", 0) != -1) {
            return bi_常量类.f6358b_空串;
        }
        String[] shuzu1 = C0890_文本操作.m6806_分割字符串(temp, "dst\":\"");
        if (shuzu1.length < 2) {
            return bi_常量类.f6358b_空串;
        }
        String[] shuzu2 = C0890_文本操作.m6806_分割字符串(shuzu1[1], "\"");
        if (shuzu2.length >= 2) {
            return C0895.m6904UCS2(shuzu2[0]);
        }
        return bi_常量类.f6358b_空串;
    }
}
