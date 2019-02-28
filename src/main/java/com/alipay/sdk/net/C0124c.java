package com.alipay.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.data.C0113c;
import com.alipay.sdk.exception.NetErrorException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;

/* renamed from: com.alipay.sdk.net.c */
public final class C0124c {
    /* renamed from: a */
    static C0122a f354a;

    /* renamed from: a */
    public static String m397a(HttpResponse httpResponse) throws NetErrorException {
        Throwable th;
        InputStream inputStream;
        Throwable th2;
        StatusLine statusLine = httpResponse.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        HttpEntity entity = httpResponse.getEntity();
        InputStream inputStream2 = null;
        try {
            inputStream2 = entity.getContent();
            try {
                if (statusLine.getStatusCode() != 200 || inputStream2 == null) {
                    throw new NetErrorException(statusCode + " " + statusLine.getReasonPhrase());
                }
                Header contentEncoding = entity.getContentEncoding();
                if (contentEncoding != null && contentEncoding.getValue().contains("gzip")) {
                    inputStream2 = new GZIPInputStream(inputStream2);
                }
                try {
                    int contentLength = (int) entity.getContentLength();
                    statusCode = contentLength < 0 ? 4096 : contentLength;
                    String contentCharSet = EntityUtils.getContentCharSet(entity);
                    if (contentCharSet == null) {
                        contentCharSet = "UTF-8";
                    }
                    Reader inputStreamReader = new InputStreamReader(inputStream2, contentCharSet);
                    CharArrayBuffer charArrayBuffer = new CharArrayBuffer(statusCode);
                    char[] cArr = new char[1024];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        charArrayBuffer.append(cArr, 0, read);
                    }
                    contentCharSet = charArrayBuffer.toString();
                    try {
                        inputStream2.close();
                    } catch (Exception e) {
                    }
                    return contentCharSet;
                } catch (Exception e2) {
                    throw new NetErrorException();
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    th2 = th;
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                    throw th2;
                }
            } catch (Throwable th32) {
                th = th32;
                inputStream = inputStream2;
                th2 = th;
                inputStream.close();
                throw th2;
            }
        } catch (Throwable th322) {
            th = th322;
            inputStream = inputStream2;
            th2 = th;
            inputStream.close();
            throw th2;
        }
    }

    /* renamed from: a */
    private static HttpResponse m398a(Context context, String str, String str2, C0113c c0113c) throws NetErrorException {
        if (f354a == null) {
            f354a = new C0122a(context, str);
        } else if (!TextUtils.equals(str, f354a.f349a)) {
            f354a.f349a = str;
        }
        return c0113c != null ? f354a.m381a(str2, c0113c) : f354a.m381a(str2, null);
    }

    /* renamed from: a */
    private static void m399a() {
        f354a = null;
    }
}
