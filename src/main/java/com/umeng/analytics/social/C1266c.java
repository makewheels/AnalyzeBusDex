package com.umeng.analytics.social;

import android.text.TextUtils;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.umeng.analytics.C1233a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* compiled from: UMNetwork */
/* renamed from: com.umeng.analytics.social.c */
public abstract class C1266c {
    /* renamed from: a */
    protected static String m8480a(String str) {
        int nextInt = new Random().nextInt(1000);
        try {
            String property = System.getProperty("line.separator");
            if (str.length() <= 1) {
                C1265b.m8471b(C1233a.f5589e, nextInt + ":\tInvalid baseUrl.");
                return null;
            }
            HttpUriRequest httpGet = new HttpGet(str);
            C1265b.m8469a(C1233a.f5589e, nextInt + ": GET_URL: " + str);
            HttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
            HttpResponse execute = new DefaultHttpClient(basicHttpParams).execute(httpGet);
            if (execute.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = execute.getEntity();
                if (entity == null) {
                    return null;
                }
                InputStream gZIPInputStream;
                InputStream content = entity.getContent();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                if (firstHeader != null && firstHeader.getValue().equalsIgnoreCase("gzip")) {
                    C1265b.m8469a(C1233a.f5589e, nextInt + "  Use GZIPInputStream get data....");
                    gZIPInputStream = new GZIPInputStream(content);
                } else if (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("deflate")) {
                    gZIPInputStream = content;
                } else {
                    C1265b.m8469a(C1233a.f5589e, nextInt + "  Use InflaterInputStream get data....");
                    gZIPInputStream = new InflaterInputStream(content);
                }
                String a = C1266c.m8479a(gZIPInputStream);
                C1265b.m8469a(C1233a.f5589e, nextInt + ":\tresponse: " + property + a);
                if (a != null) {
                    return a;
                }
                return null;
            }
            C1265b.m8469a(C1233a.f5589e, nextInt + ":\tFailed to get message." + str);
            return null;
        } catch (Exception e) {
            C1265b.m8474c(C1233a.f5589e, nextInt + ":\tClientProtocolException,Failed to send message." + str, e);
            return null;
        } catch (Exception e2) {
            C1265b.m8474c(C1233a.f5589e, nextInt + ":\tIOException,Failed to send message." + str, e2);
            return null;
        }
    }

    /* renamed from: a */
    private static String m8479a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 8192);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine + "\n");
            } catch (Exception e) {
                stringBuilder = C1233a.f5589e;
                C1265b.m8472b(stringBuilder, "Caught IOException in convertStreamToString()", e);
                return null;
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                    C1265b.m8472b(C1233a.f5589e, "Caught IOException in convertStreamToString()", e2);
                    return null;
                }
            }
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    protected static String m8481a(String str, String str2) {
        int nextInt = new Random().nextInt(1000);
        String property = System.getProperty("line.separator");
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        HttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        C1265b.m8469a(C1233a.f5589e, nextInt + ": POST_URL: " + str);
        try {
            HttpUriRequest httpPost = new HttpPost(str);
            if (!TextUtils.isEmpty(str2)) {
                C1265b.m8469a(C1233a.f5589e, nextInt + ": POST_BODY: " + str2);
                List arrayList = new ArrayList(1);
                arrayList.add(new BasicNameValuePair("data", str2));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            }
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = execute.getEntity();
                if (entity == null) {
                    return null;
                }
                InputStream inputStream;
                InputStream content = entity.getContent();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                if (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("deflate")) {
                    inputStream = content;
                } else {
                    inputStream = new InflaterInputStream(content);
                }
                String a = C1266c.m8479a(inputStream);
                C1265b.m8469a(C1233a.f5589e, nextInt + ":\tresponse: " + property + a);
                if (a == null) {
                    return null;
                }
                return a;
            }
            C1265b.m8473c(C1233a.f5589e, nextInt + ":\tFailed to send message." + str);
            return null;
        } catch (Exception e) {
            C1265b.m8474c(C1233a.f5589e, nextInt + ":\tClientProtocolException,Failed to send message." + str, e);
            return null;
        } catch (Exception e2) {
            C1265b.m8474c(C1233a.f5589e, nextInt + ":\tIOException,Failed to send message." + str, e2);
            return null;
        }
    }
}
