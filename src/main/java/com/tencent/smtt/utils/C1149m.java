package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* renamed from: com.tencent.smtt.utils.m */
public class C1149m {

    /* renamed from: com.tencent.smtt.utils.m$a */
    public interface C1093a {
        /* renamed from: a */
        void mo1872a(int i);
    }

    /* renamed from: a */
    public static String m8000a(String str, Map<String, String> map, byte[] bArr, C1093a c1093a, boolean z) {
        if (bArr == null) {
            return null;
        }
        HttpURLConnection a = C1149m.m8003a(str, (Map) map);
        if (a == null) {
            return null;
        }
        if (z) {
            C1149m.m8005a(a, bArr);
        } else {
            C1149m.m8006b(a, bArr);
        }
        return C1149m.m8002a(a, c1093a, false);
    }

    /* renamed from: a */
    public static String m8001a(String str, byte[] bArr, C1093a c1093a, boolean z) {
        String c;
        byte[] a;
        if (z) {
            try {
                c = C1152p.m8013a().m8018c();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        c = C1151o.m8008a().m8011b();
        String str2 = str + c;
        if (z) {
            try {
                a = C1152p.m8013a().m8016a(bArr);
            } catch (Exception e2) {
                e2.printStackTrace();
                a = bArr;
            }
        } else {
            a = C1151o.m8008a().m8010a(bArr);
        }
        if (a == null) {
            return null;
        }
        Map hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Content-Length", String.valueOf(a.length));
        HttpURLConnection a2 = C1149m.m8003a(str2, hashMap);
        if (a2 != null) {
            C1149m.m8006b(a2, a);
            c = C1149m.m8002a(a2, c1093a, z);
        } else {
            c = null;
        }
        return c;
    }

    /* renamed from: a */
    private static String m8002a(HttpURLConnection httpURLConnection, C1093a c1093a, boolean z) {
        Closeable inflaterInputStream;
        Throwable th;
        Closeable closeable;
        Throwable th2;
        Closeable closeable2 = null;
        try {
            String contentEncoding;
            Closeable byteArrayOutputStream;
            int responseCode = httpURLConnection.getResponseCode();
            if (c1093a != null) {
                c1093a.mo1872a(responseCode);
            }
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    if (contentEncoding != null) {
                        if (contentEncoding.equalsIgnoreCase("deflate")) {
                            inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                        }
                    }
                    Object obj = inputStream;
                } else {
                    inflaterInputStream = new GZIPInputStream(inputStream);
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Throwable th3) {
                    th = th3;
                    C1149m.m8004a(inflaterInputStream);
                    C1149m.m8004a(closeable2);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[128];
                    while (true) {
                        int read = inflaterInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (z) {
                        closeable2 = inflaterInputStream;
                        contentEncoding = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                    } else {
                        closeable2 = inflaterInputStream;
                        contentEncoding = new String(C1151o.m8008a().m8012c(byteArrayOutputStream.toByteArray()));
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    closeable2 = byteArrayOutputStream;
                    th = th2;
                    C1149m.m8004a(inflaterInputStream);
                    C1149m.m8004a(closeable2);
                    throw th;
                }
            }
            byteArrayOutputStream = null;
            contentEncoding = null;
            C1149m.m8004a(closeable2);
            C1149m.m8004a(byteArrayOutputStream);
            return contentEncoding;
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
            C1149m.m8004a(inflaterInputStream);
            C1149m.m8004a(closeable2);
            throw th;
        }
    }

    /* renamed from: a */
    private static HttpURLConnection m8003a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        Exception e;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
                if (VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Entry entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return httpURLConnection;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            httpURLConnection = null;
            e = exception;
            e.printStackTrace();
            return httpURLConnection;
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private static void m8004a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    private static void m8005a(HttpURLConnection httpURLConnection, byte[] bArr) {
        Closeable gZIPOutputStream;
        Exception e;
        Throwable th;
        try {
            gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                C1149m.m8004a(null);
                C1149m.m8004a(gZIPOutputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    C1149m.m8004a(null);
                    C1149m.m8004a(gZIPOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    C1149m.m8004a(null);
                    C1149m.m8004a(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            gZIPOutputStream = null;
            e.printStackTrace();
            C1149m.m8004a(null);
            C1149m.m8004a(gZIPOutputStream);
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            C1149m.m8004a(null);
            C1149m.m8004a(gZIPOutputStream);
            throw th;
        }
    }

    /* renamed from: b */
    private static void m8006b(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
