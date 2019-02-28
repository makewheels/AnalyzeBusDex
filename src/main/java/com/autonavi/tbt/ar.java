package com.autonavi.tbt;

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
public class ar {
    /* renamed from: a */
    private static as f3753a;
    /* renamed from: g */
    private static TrustManager f3754g = new ax();
    /* renamed from: b */
    private int f3755b;
    /* renamed from: c */
    private int f3756c;
    /* renamed from: d */
    private boolean f3757d;
    /* renamed from: e */
    private SSLContext f3758e;
    /* renamed from: f */
    private Proxy f3759f;

    ar(int i, int i2, Proxy proxy, boolean z) {
        this.f3755b = i;
        this.f3756c = i2;
        this.f3759f = proxy;
        this.f3757d = z;
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, new TrustManager[]{f3754g}, null);
                this.f3758e = instance;
            } catch (Throwable e) {
                ae.m4671a(e, "HttpUrlUtil", "HttpUrlUtil");
                e.printStackTrace();
            } catch (Throwable e2) {
                ae.m4671a(e2, "HttpUrlUtil", "HttpUrlUtil");
                e2.printStackTrace();
            } catch (Throwable e22) {
                ae.m4671a(e22, "HttpUtil", "HttpUtil");
                e22.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    aw m4770a(String str, Map<String, String> map, Map<String, String> map2) throws C0618h {
        try {
            String a = m4767a((Map) map2);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            if (a != null) {
                stringBuffer.append("?").append(a);
            }
            HttpURLConnection a2 = m4768a(new URL(stringBuffer.toString()));
            m4769a(map, a2);
            a2.setRequestMethod("GET");
            a2.setDoInput(true);
            a2.connect();
            return m4766a(a2);
        } catch (Throwable e) {
            ae.m4671a(e, "HttpUrlUtil", "getRequest");
            e.printStackTrace();
            throw new C0618h("url异常 - MalformedURLException");
        } catch (Throwable e2) {
            ae.m4671a(e2, "HttpUrlUtil", "getRequest");
            e2.printStackTrace();
            throw new C0618h("IO 操作异常 - IOException");
        } catch (Throwable e22) {
            ae.m4671a(e22, "HttpUrlUtil", "getRequest");
            e22.printStackTrace();
            C0618h c0618h = new C0618h("未知的错误");
        }
    }

    /* renamed from: a */
    aw m4772a(String str, Map<String, String> map, Map<String, String> map2, byte[] bArr) throws C0618h {
        C0618h e;
        if (map2 != null) {
            try {
                String a = m4767a((Map) map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (a != null) {
                    stringBuffer.append("?").append(a);
                }
                str = stringBuffer.toString();
            } catch (C0618h e2) {
                throw e2;
            } catch (Throwable th) {
                ae.m4671a(th, "HttpUrlUtil", "PostReqeust3");
                th.printStackTrace();
                e2 = new C0618h("未知的错误");
            }
        }
        return m4773a(str, (Map) map, bArr);
    }

    /* renamed from: a */
    aw m4773a(String str, Map<String, String> map, byte[] bArr) throws C0618h {
        try {
            HttpURLConnection a = m4768a(new URL(str));
            m4769a(map, a);
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
            return m4766a(a);
        } catch (Throwable e) {
            ae.m4671a(e, "HttpUrlUtil", "postRequest");
            e.printStackTrace();
            throw new C0618h("url异常 - MalformedURLException");
        } catch (Throwable e2) {
            ae.m4671a(e2, "HttpUrlUtil", "postRequest");
            e2.printStackTrace();
            throw new C0618h("IO 操作异常 - IOException");
        } catch (Throwable e22) {
            ae.m4671a(e22, "HttpUrlUtil", "postRequest");
            e22.printStackTrace();
            C0618h c0618h = new C0618h("未知的错误");
        }
    }

    /* renamed from: b */
    aw m4774b(String str, Map<String, String> map, Map<String, String> map2) throws C0618h {
        String a = m4767a((Map) map2);
        if (a == null) {
            return m4773a(str, (Map) map, new byte[0]);
        }
        try {
            return m4773a(str, (Map) map, a.getBytes("UTF-8"));
        } catch (Throwable e) {
            ae.m4671a(e, "HttpUrlUtil", "postRequest1");
            e.printStackTrace();
            return m4773a(str, (Map) map, a.getBytes());
        }
    }

    /* renamed from: a */
    aw m4771a(String str, Map<String, String> map, Map<String, String> map2, HttpEntity httpEntity) throws C0618h {
        Throwable e;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream = null;
        if (map2 != null) {
            try {
                String a = m4767a((Map) map2);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                if (a != null) {
                    stringBuffer.append("?").append(a);
                }
                str = stringBuffer.toString();
            } catch (IllegalStateException e2) {
                e = e2;
                byteArrayOutputStream = null;
                ae.m4671a(e, "HttpUrlUtil", "postRequest2");
                e.printStackTrace();
                throw new C0618h("无效的参数 - IllegalArgumentException");
            } catch (IOException e3) {
                e = e3;
                byteArrayOutputStream = null;
                ae.m4671a(e, "HttpUrlUtil", "postRequest2");
                e.printStackTrace();
                throw new C0618h("IO 操作异常 - IOException");
            } catch (Throwable th) {
                e = th;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw e;
            }
        }
        byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = httpEntity.getContent();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            aw a2 = m4773a(str, (Map) map, byteArrayOutputStream.toByteArray());
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable e4) {
                    ae.m4671a(e4, "HttpUrlUtil", "postRequest2");
                    e4.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e5) {
                    ae.m4671a(e5, "HttpUrlUtil", "postRequest2");
                    e5.printStackTrace();
                }
            }
            return a2;
        } catch (IllegalStateException e6) {
            e = e6;
            ae.m4671a(e, "HttpUrlUtil", "postRequest2");
            e.printStackTrace();
            throw new C0618h("无效的参数 - IllegalArgumentException");
        } catch (IOException e7) {
            e = e7;
            ae.m4671a(e, "HttpUrlUtil", "postRequest2");
            e.printStackTrace();
            throw new C0618h("IO 操作异常 - IOException");
        } catch (Throwable th2) {
            e = th2;
            ae.m4671a(e, "HttpUrlUtil", "postRequest2");
            e.printStackTrace();
            throw new C0618h("未知的错误");
        }
    }

    /* renamed from: a */
    private void m4769a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, (String) map.get(str));
            }
        }
        httpURLConnection.setConnectTimeout(this.f3755b);
        httpURLConnection.setReadTimeout(this.f3756c);
    }

    /* renamed from: a */
    private HttpURLConnection m4768a(URL url) throws IOException {
        HttpURLConnection httpURLConnection;
        if (this.f3759f != null) {
            URLConnection openConnection = url.openConnection(this.f3759f);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (this.f3757d) {
            httpURLConnection = (HttpsURLConnection) openConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.f3758e.getSocketFactory());
        } else {
            httpURLConnection = (HttpURLConnection) openConnection;
        }
        if (VERSION.SDK != null && VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private aw m4766a(HttpURLConnection httpURLConnection) throws C0618h, IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        IOException e;
        Throwable th;
        InputStream inputStream2;
        PushbackInputStream pushbackInputStream = null;
        InputStream pushbackInputStream2;
        try {
            Map headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new C0618h("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode);
            }
            byte[] bArr;
            InputStream gZIPInputStream;
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    pushbackInputStream2 = new PushbackInputStream(inputStream, 2);
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
                            ae.m4671a(e3, "HttpUrlUtil", "parseResult");
                            e3.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e4) {
                            ae.m4671a(e4, "HttpUrlUtil", "parseResult");
                            e4.printStackTrace();
                        }
                    }
                    if (pushbackInputStream != null) {
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable e5) {
                            ae.m4671a(e5, "HttpUrlUtil", "parseResult");
                            e5.printStackTrace();
                        }
                    }
                    if (pushbackInputStream2 != null) {
                        try {
                            pushbackInputStream2.close();
                        } catch (Throwable e52) {
                            ae.m4671a(e52, "HttpUrlUtil", "parseResult");
                            e52.printStackTrace();
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable e522) {
                            ae.m4671a(e522, "HttpUrlUtil", "parseResult");
                            e522.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                pushbackInputStream2 = null;
                inputStream = null;
                throw e;
            } catch (Throwable th4) {
                th = th4;
                pushbackInputStream2 = null;
                inputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
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
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = null;
                gZIPInputStream = inputStream2;
                throw e;
            } catch (Throwable th5) {
                th = th5;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = null;
                gZIPInputStream = inputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
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
                if (f3753a != null) {
                    f3753a.m4775a();
                }
                aw awVar = new aw();
                awVar.f3769a = byteArrayOutputStream.toByteArray();
                awVar.f3770b = headerFields;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable e32) {
                        ae.m4671a(e32, "HttpUrlUtil", "parseResult");
                        e32.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e42) {
                        ae.m4671a(e42, "HttpUrlUtil", "parseResult");
                        e42.printStackTrace();
                    }
                }
                if (pushbackInputStream2 != null) {
                    try {
                        pushbackInputStream2.close();
                    } catch (Throwable e8) {
                        ae.m4671a(e8, "HttpUrlUtil", "parseResult");
                        e8.printStackTrace();
                    }
                }
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable e5222) {
                        ae.m4671a(e5222, "HttpUrlUtil", "parseResult");
                        e5222.printStackTrace();
                    }
                }
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable e52222) {
                        ae.m4671a(e52222, "HttpUrlUtil", "parseResult");
                        e52222.printStackTrace();
                    }
                }
                return awVar;
            } catch (IOException e9) {
                e = e9;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = gZIPInputStream;
                gZIPInputStream = inputStream2;
                throw e;
            } catch (Throwable th6) {
                th = th6;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = gZIPInputStream;
                gZIPInputStream = inputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
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
            inputStream = null;
            byteArrayOutputStream = null;
            throw e;
        } catch (Throwable th7) {
            th = th7;
            pushbackInputStream2 = null;
            inputStream = null;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
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
    private String m4767a(Map<String, String> map) {
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
