package com.amap.api.mapcore.util;

import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: HttpUrlUtil */
public class br {
    /* renamed from: a */
    private static bs f2084a;
    /* renamed from: g */
    private static TrustManager f2085g = new bx();
    /* renamed from: b */
    private int f2086b;
    /* renamed from: c */
    private int f2087c;
    /* renamed from: d */
    private boolean f2088d;
    /* renamed from: e */
    private SSLContext f2089e;
    /* renamed from: f */
    private Proxy f2090f;

    /* renamed from: a */
    public static void m3285a(bs bsVar) {
        f2084a = bsVar;
    }

    br(int i, int i2, Proxy proxy, boolean z) {
        this.f2086b = i;
        this.f2087c = i2;
        this.f2090f = proxy;
        this.f2088d = z;
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, new TrustManager[]{f2085g}, null);
                this.f2089e = instance;
            } catch (Throwable e) {
                az.m3143a(e, "HttpUrlUtil", "HttpUrlUtil");
                e.printStackTrace();
            } catch (Throwable e2) {
                az.m3143a(e2, "HttpUrlUtil", "HttpUrlUtil");
                e2.printStackTrace();
            } catch (Throwable e22) {
                az.m3143a(e22, "HttpUtil", "HttpUtil");
                e22.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    bw m3287a(String str, Map<String, String> map, Map<String, String> map2) throws C0406v {
        try {
            String a = m3283a((Map) map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (a != null) {
                stringBuffer.append("?").append(a);
            }
            HttpURLConnection a2 = m3284a(new URL(stringBuffer.toString()));
            m3286a(map, a2);
            a2.setRequestMethod("GET");
            a2.setDoInput(true);
            a2.connect();
            return m3282a(a2);
        } catch (Throwable e) {
            az.m3143a(e, "HttpUrlUtil", "getRequest");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            az.m3143a(e2, "HttpUrlUtil", "getRequest");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            az.m3143a(e22, "HttpUrlUtil", "getRequest");
            e22.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    bw m3289a(String str, Map<String, String> map, Map<String, String> map2, byte[] bArr) throws C0406v {
        if (map2 != null) {
            try {
                String a = m3283a((Map) map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (a != null) {
                    stringBuffer.append("?").append(a);
                }
                str = stringBuffer.toString();
            } catch (Throwable th) {
                az.m3143a(th, "HttpUrlUtil", "PostReqeust3");
                th.printStackTrace();
                return null;
            }
        }
        return m3290a(str, (Map) map, bArr);
    }

    /* renamed from: a */
    bw m3290a(String str, Map<String, String> map, byte[] bArr) throws C0406v {
        try {
            HttpURLConnection a = m3284a(new URL(str));
            m3286a(map, a);
            a.setRequestMethod("POST");
            a.setUseCaches(false);
            a.setDoInput(true);
            a.setDoOutput(true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            a.connect();
            return m3282a(a);
        } catch (Throwable e) {
            az.m3143a(e, "HttpUrlUtil", "postRequest");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            az.m3143a(e2, "HttpUrlUtil", "postRequest");
            e2.printStackTrace();
            return null;
        } catch (Throwable e22) {
            az.m3143a(e22, "HttpUrlUtil", "postRequest");
            e22.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    bw m3291b(String str, Map<String, String> map, Map<String, String> map2) throws C0406v {
        String a = m3283a((Map) map2);
        if (a == null) {
            return m3290a(str, (Map) map, new byte[0]);
        }
        try {
            return m3290a(str, (Map) map, a.getBytes("UTF-8"));
        } catch (Throwable e) {
            az.m3143a(e, "HttpUrlUtil", "postRequest1");
            e.printStackTrace();
            return m3290a(str, (Map) map, a.getBytes());
        }
    }

    /* renamed from: a */
    bw m3288a(String str, Map<String, String> map, Map<String, String> map2, HttpEntity httpEntity) throws C0406v {
        Throwable e;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Exception exception;
        bw bwVar = null;
        if (map2 != null) {
            try {
                String a = m3283a((Map) map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (a != null) {
                    stringBuffer.append("?").append(a);
                }
                str = stringBuffer.toString();
            } catch (IllegalStateException e2) {
                e = e2;
                Object obj = bwVar;
                Object obj2 = bwVar;
                try {
                    az.m3143a(e, "HttpUrlUtil", "postRequest2");
                    e.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e3) {
                            az.m3143a(e3, "HttpUrlUtil", "postRequest2");
                            e3.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                            e3 = e4;
                            az.m3143a(e3, "HttpUrlUtil", "postRequest2");
                            exception.printStackTrace();
                            return bwVar;
                        }
                    }
                    return bwVar;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e32) {
                            az.m3143a(e32, "HttpUrlUtil", "postRequest2");
                            e32.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e322) {
                            az.m3143a(e322, "HttpUrlUtil", "postRequest2");
                            e322.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e322 = e5;
                inputStream = bwVar;
                byteArrayOutputStream = bwVar;
                az.m3143a(e322, "HttpUrlUtil", "postRequest2");
                e322.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e3222) {
                        az.m3143a(e3222, "HttpUrlUtil", "postRequest2");
                        e3222.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        e3222 = e6;
                        az.m3143a(e3222, "HttpUrlUtil", "postRequest2");
                        exception.printStackTrace();
                        return bwVar;
                    }
                }
                return bwVar;
            } catch (Throwable e32222) {
                Throwable th2;
                inputStream = bwVar;
                byteArrayOutputStream = bwVar;
                th2 = e32222;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th2;
            }
        }
        byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = httpEntity.getContent();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                bwVar = m3290a(str, (Map) map, byteArrayOutputStream.toByteArray());
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e322222) {
                        az.m3143a(e322222, "HttpUrlUtil", "postRequest2");
                        e322222.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e7) {
                        exception = e7;
                        az.m3143a((Throwable) exception, "HttpUrlUtil", "postRequest2");
                        exception.printStackTrace();
                        return bwVar;
                    }
                }
            } catch (IllegalStateException e8) {
                e322222 = e8;
                az.m3143a(e322222, "HttpUrlUtil", "postRequest2");
                e322222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bwVar;
            } catch (IOException e9) {
                e322222 = e9;
                az.m3143a(e322222, "HttpUrlUtil", "postRequest2");
                e322222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bwVar;
            } catch (Throwable th3) {
                e322222 = th3;
                az.m3143a(e322222, "HttpUrlUtil", "postRequest2");
                e322222.printStackTrace();
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return bwVar;
            }
        } catch (IllegalStateException e10) {
            e322222 = e10;
            obj = bwVar;
            az.m3143a(e322222, "HttpUrlUtil", "postRequest2");
            e322222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bwVar;
        } catch (IOException e11) {
            e322222 = e11;
            obj = bwVar;
            az.m3143a(e322222, "HttpUrlUtil", "postRequest2");
            e322222.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return bwVar;
        } catch (Throwable e3222222) {
            obj = bwVar;
            th2 = e3222222;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th2;
        }
        return bwVar;
    }

    /* renamed from: a */
    private void m3286a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, (String) map.get(str));
            }
        }
        httpURLConnection.setConnectTimeout(this.f2086b);
        httpURLConnection.setReadTimeout(this.f2087c);
    }

    /* renamed from: a */
    private HttpURLConnection m3284a(URL url) throws IOException {
        HttpURLConnection httpURLConnection;
        if (this.f2090f != null) {
            URLConnection openConnection = url.openConnection(this.f2090f);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (this.f2088d) {
            httpURLConnection = (HttpsURLConnection) openConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f2089e.getSocketFactory());
        } else {
            httpURLConnection = (HttpURLConnection) openConnection;
        }
        if (VERSION.SDK != null && VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private bw m3282a(HttpURLConnection httpURLConnection) throws C0406v, IOException {
        IOException e;
        Throwable th;
        InputStream gZIPInputStream;
        InputStream inputStream;
        PushbackInputStream pushbackInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        InputStream pushbackInputStream2;
        try {
            Map headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new C0406v("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode);
            }
            byte[] bArr;
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream2 = httpURLConnection.getInputStream();
                try {
                    pushbackInputStream2 = new PushbackInputStream(inputStream2, 2);
                } catch (IOException e2) {
                    e = e2;
                    pushbackInputStream2 = null;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    pushbackInputStream2 = null;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable e3) {
                            az.m3143a(e3, "HttpUrlUtil", "parseResult");
                            e3.printStackTrace();
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable e4) {
                            az.m3143a(e4, "HttpUrlUtil", "parseResult");
                            e4.printStackTrace();
                        }
                    }
                    if (pushbackInputStream != null) {
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable e5) {
                            az.m3143a(e5, "HttpUrlUtil", "parseResult");
                            e5.printStackTrace();
                        }
                    }
                    if (pushbackInputStream2 != null) {
                        try {
                            pushbackInputStream2.close();
                        } catch (Throwable e52) {
                            az.m3143a(e52, "HttpUrlUtil", "parseResult");
                            e52.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable e522) {
                            az.m3143a(e522, "HttpUrlUtil", "parseResult");
                            e522.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                pushbackInputStream2 = null;
                inputStream2 = null;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                pushbackInputStream2 = null;
                inputStream2 = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                bArr = new byte[2];
                pushbackInputStream2.read(bArr);
                pushbackInputStream2.unread(bArr);
                if (bArr[0] == (byte) 31 && bArr[1] == (byte) -117) {
                    gZIPInputStream = new GZIPInputStream(pushbackInputStream2);
                } else {
                    gZIPInputStream = pushbackInputStream2;
                }
            } catch (IOException e7) {
                e = e7;
                inputStream = pushbackInputStream2;
                pushbackInputStream2 = null;
                gZIPInputStream = inputStream;
                throw e;
            } catch (Throwable th5) {
                th = th5;
                inputStream = pushbackInputStream2;
                pushbackInputStream2 = null;
                gZIPInputStream = inputStream;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                if (f2084a != null) {
                    f2084a.mo595a();
                }
                bw bwVar = new bw();
                bwVar.f2097a = byteArrayOutputStream.toByteArray();
                bwVar.f2098b = headerFields;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e32) {
                        az.m3143a(e32, "HttpUrlUtil", "parseResult");
                        e32.printStackTrace();
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable e42) {
                        az.m3143a(e42, "HttpUrlUtil", "parseResult");
                        e42.printStackTrace();
                    }
                }
                if (pushbackInputStream2 != null) {
                    try {
                        pushbackInputStream2.close();
                    } catch (Throwable e8) {
                        az.m3143a(e8, "HttpUrlUtil", "parseResult");
                        e8.printStackTrace();
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable e5222) {
                        az.m3143a(e5222, "HttpUrlUtil", "parseResult");
                        e5222.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e52222) {
                        az.m3143a(e52222, "HttpUrlUtil", "parseResult");
                        e52222.printStackTrace();
                    }
                }
                return bwVar;
            } catch (IOException e9) {
                e = e9;
                inputStream = pushbackInputStream2;
                pushbackInputStream2 = gZIPInputStream;
                gZIPInputStream = inputStream;
                throw e;
            } catch (Throwable th6) {
                th = th6;
                inputStream = pushbackInputStream2;
                pushbackInputStream2 = gZIPInputStream;
                gZIPInputStream = inputStream;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e10) {
            e = e10;
            pushbackInputStream2 = null;
            inputStream2 = null;
            byteArrayOutputStream = null;
            throw e;
        } catch (Throwable th7) {
            th = th7;
            pushbackInputStream2 = null;
            inputStream2 = null;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (pushbackInputStream != null) {
                pushbackInputStream.close();
            }
            if (pushbackInputStream2 != null) {
                pushbackInputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private String m3283a(Map<String, String> map) {
        List linkedList = new LinkedList();
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        if (linkedList.size() > 0) {
            return URLEncodedUtils.format(linkedList, "UTF-8");
        }
        return null;
    }
}
