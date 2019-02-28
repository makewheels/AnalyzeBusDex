package com.amap.api.mapcore.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpHost;

/* compiled from: ProxyUtil */
public class ac {
    /* renamed from: a */
    public static HttpHost m3018a(Context context) {
        try {
            if (VERSION.SDK_INT >= 11) {
                return m3019a(context, new URI("http://restapi.amap.com"));
            }
            return m3022b(context);
        } catch (Throwable e) {
            az.m3143a(e, "ProxyUtil", "getProxy");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            az.m3143a(e2, "ProxyUtil", "getProxy");
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static HttpHost m3022b(Context context) {
        Cursor query;
        String a;
        int b;
        String str;
        Throwable th;
        int i;
        Throwable th2;
        String toLowerCase;
        Cursor cursor;
        Throwable th3;
        int i2;
        az b2;
        Object obj = null;
        if (C0411z.m3521g(context) == 0) {
            String string;
            Object obj2;
            try {
                query = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            string = query.getString(query.getColumnIndex("apn"));
                            if (string != null) {
                                string = string.toLowerCase(Locale.US);
                            }
                            if (string != null && string.contains("ctwap")) {
                                a = m3017a();
                                b = m3021b();
                                try {
                                    if (TextUtils.isEmpty(a) || a.equals("null")) {
                                        obj2 = null;
                                        a = null;
                                    } else {
                                        obj2 = 1;
                                    }
                                    if (obj2 == null) {
                                        try {
                                            str = "10.0.0.200";
                                        } catch (Throwable e) {
                                            th = e;
                                            i = b;
                                            th2 = th;
                                            az.m3143a(th2, "ProxyUtil", "getHostProxy");
                                            string = C0411z.m3523i(context);
                                            if (string == null) {
                                                b = i;
                                                str = a;
                                            } else {
                                                toLowerCase = string.toLowerCase(Locale.US);
                                                str = m3017a();
                                                b = m3021b();
                                                if (toLowerCase.indexOf("ctwap") != -1) {
                                                    obj = 1;
                                                    a = str;
                                                    if (obj == null) {
                                                        a = "10.0.0.200";
                                                    }
                                                    if (b == -1) {
                                                        b = 80;
                                                        str = a;
                                                    }
                                                } else if (toLowerCase.indexOf("wap") != -1) {
                                                    if (!TextUtils.isEmpty(str)) {
                                                    }
                                                    obj2 = null;
                                                    string = a;
                                                    if (obj2 == null) {
                                                        string = "10.0.0.200";
                                                    }
                                                    str = string;
                                                    b = 80;
                                                }
                                                str = a;
                                            }
                                            if (query != null) {
                                                query.close();
                                            }
                                            if (m3020a(str, b)) {
                                                return new HttpHost(str, b, "http");
                                            }
                                            return null;
                                        } catch (Throwable e2) {
                                            th = e2;
                                            str = a;
                                            cursor = query;
                                            th3 = th;
                                            az.m3143a(th3, "ProxyUtil", "getHostProxy1");
                                            th3.printStackTrace();
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (m3020a(str, b)) {
                                                return new HttpHost(str, b, "http");
                                            }
                                            return null;
                                        }
                                    }
                                    str = a;
                                    if (b == -1) {
                                        b = 80;
                                    }
                                    if (query != null) {
                                        query.close();
                                    }
                                } catch (Throwable e22) {
                                    a = null;
                                    i2 = b;
                                    th2 = e22;
                                    i = i2;
                                    az.m3143a(th2, "ProxyUtil", "getHostProxy");
                                    string = C0411z.m3523i(context);
                                    if (string == null) {
                                        toLowerCase = string.toLowerCase(Locale.US);
                                        str = m3017a();
                                        b = m3021b();
                                        if (toLowerCase.indexOf("ctwap") != -1) {
                                            if (!(TextUtils.isEmpty(str) || str.equals("null"))) {
                                                obj = 1;
                                                a = str;
                                            }
                                            if (obj == null) {
                                                a = "10.0.0.200";
                                            }
                                            if (b == -1) {
                                                b = 80;
                                                str = a;
                                            }
                                        } else if (toLowerCase.indexOf("wap") != -1) {
                                            if (TextUtils.isEmpty(str) || str.equals("null")) {
                                                obj2 = null;
                                                string = a;
                                            } else {
                                                string = str;
                                                obj2 = 1;
                                            }
                                            if (obj2 == null) {
                                                string = "10.0.0.200";
                                            }
                                            str = string;
                                            b = 80;
                                        }
                                        str = a;
                                    } else {
                                        b = i;
                                        str = a;
                                    }
                                    if (query != null) {
                                        query.close();
                                    }
                                    if (m3020a(str, b)) {
                                        return new HttpHost(str, b, "http");
                                    }
                                    return null;
                                } catch (Throwable e222) {
                                    cursor = query;
                                    th3 = e222;
                                    str = null;
                                    az.m3143a(th3, "ProxyUtil", "getHostProxy1");
                                    th3.printStackTrace();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (m3020a(str, b)) {
                                        return new HttpHost(str, b, "http");
                                    }
                                    return null;
                                }
                                if (m3020a(str, b)) {
                                    return new HttpHost(str, b, "http");
                                }
                            } else if (string != null) {
                                if (string.contains("wap")) {
                                    a = m3017a();
                                    i = m3021b();
                                    try {
                                        Object obj3;
                                        if (TextUtils.isEmpty(a) || a.equals("null")) {
                                            obj3 = null;
                                            a = null;
                                        } else {
                                            obj3 = 1;
                                        }
                                        if (obj3 == null) {
                                            try {
                                                string = "10.0.0.172";
                                            } catch (SecurityException e3) {
                                                th2 = e3;
                                                try {
                                                    az.m3143a(th2, "ProxyUtil", "getHostProxy");
                                                    string = C0411z.m3523i(context);
                                                    if (string == null) {
                                                        b = i;
                                                        str = a;
                                                    } else {
                                                        toLowerCase = string.toLowerCase(Locale.US);
                                                        str = m3017a();
                                                        b = m3021b();
                                                        if (toLowerCase.indexOf("ctwap") != -1) {
                                                            obj = 1;
                                                            a = str;
                                                            if (obj == null) {
                                                                a = "10.0.0.200";
                                                            }
                                                            if (b == -1) {
                                                                b = 80;
                                                                str = a;
                                                            }
                                                        } else if (toLowerCase.indexOf("wap") != -1) {
                                                            if (TextUtils.isEmpty(str)) {
                                                            }
                                                            obj2 = null;
                                                            string = a;
                                                            if (obj2 == null) {
                                                                string = "10.0.0.200";
                                                            }
                                                            str = string;
                                                            b = 80;
                                                        }
                                                        str = a;
                                                    }
                                                    if (query != null) {
                                                        try {
                                                            query.close();
                                                        } catch (Throwable th32) {
                                                            b2 = az.m3144b();
                                                            if (b2 != null) {
                                                                b2.m3147b(th32, "ProxyUtil", "getHostProxy2");
                                                            }
                                                            th32.printStackTrace();
                                                        }
                                                    }
                                                    if (m3020a(str, b)) {
                                                        return new HttpHost(str, b, "http");
                                                    }
                                                    return null;
                                                } catch (Throwable th4) {
                                                    th2 = th4;
                                                    if (query != null) {
                                                        try {
                                                            query.close();
                                                        } catch (Throwable e2222) {
                                                            az b3 = az.m3144b();
                                                            if (b3 != null) {
                                                                b3.m3147b(e2222, "ProxyUtil", "getHostProxy2");
                                                            }
                                                            e2222.printStackTrace();
                                                        }
                                                    }
                                                    throw th2;
                                                }
                                            } catch (Throwable th22) {
                                                th = th22;
                                                b = i;
                                                str = a;
                                                cursor = query;
                                                th32 = th;
                                                try {
                                                    az.m3143a(th32, "ProxyUtil", "getHostProxy1");
                                                    th32.printStackTrace();
                                                    if (cursor != null) {
                                                        try {
                                                            cursor.close();
                                                        } catch (Throwable th322) {
                                                            b2 = az.m3144b();
                                                            if (b2 != null) {
                                                                b2.m3147b(th322, "ProxyUtil", "getHostProxy2");
                                                            }
                                                            th322.printStackTrace();
                                                        }
                                                    }
                                                    if (m3020a(str, b)) {
                                                        return new HttpHost(str, b, "http");
                                                    }
                                                    return null;
                                                } catch (Throwable th5) {
                                                    th22 = th5;
                                                    query = cursor;
                                                    if (query != null) {
                                                        query.close();
                                                    }
                                                    throw th22;
                                                }
                                            }
                                        }
                                        string = a;
                                        if (i == -1) {
                                            str = string;
                                            b = 80;
                                        } else {
                                            i2 = i;
                                            str = string;
                                            b = i2;
                                        }
                                        if (query != null) {
                                            try {
                                                query.close();
                                            } catch (Throwable th3222) {
                                                b2 = az.m3144b();
                                                if (b2 != null) {
                                                    b2.m3147b(th3222, "ProxyUtil", "getHostProxy2");
                                                }
                                                th3222.printStackTrace();
                                            }
                                        }
                                    } catch (SecurityException e4) {
                                        th22 = e4;
                                        a = null;
                                        az.m3143a(th22, "ProxyUtil", "getHostProxy");
                                        string = C0411z.m3523i(context);
                                        if (string == null) {
                                            toLowerCase = string.toLowerCase(Locale.US);
                                            str = m3017a();
                                            b = m3021b();
                                            if (toLowerCase.indexOf("ctwap") != -1) {
                                                obj = 1;
                                                a = str;
                                                if (obj == null) {
                                                    a = "10.0.0.200";
                                                }
                                                if (b == -1) {
                                                    b = 80;
                                                    str = a;
                                                }
                                            } else if (toLowerCase.indexOf("wap") != -1) {
                                                if (TextUtils.isEmpty(str)) {
                                                }
                                                obj2 = null;
                                                string = a;
                                                if (obj2 == null) {
                                                    string = "10.0.0.200";
                                                }
                                                str = string;
                                                b = 80;
                                            }
                                            str = a;
                                        } else {
                                            b = i;
                                            str = a;
                                        }
                                        if (query != null) {
                                            query.close();
                                        }
                                        if (m3020a(str, b)) {
                                            return new HttpHost(str, b, "http");
                                        }
                                        return null;
                                    } catch (Throwable th222) {
                                        cursor = query;
                                        th3222 = th222;
                                        b = i;
                                        str = null;
                                        az.m3143a(th3222, "ProxyUtil", "getHostProxy1");
                                        th3222.printStackTrace();
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (m3020a(str, b)) {
                                            return new HttpHost(str, b, "http");
                                        }
                                        return null;
                                    }
                                    if (m3020a(str, b)) {
                                        return new HttpHost(str, b, "http");
                                    }
                                }
                            }
                        }
                    } catch (SecurityException e5) {
                        th222 = e5;
                        i = -1;
                        a = null;
                        az.m3143a(th222, "ProxyUtil", "getHostProxy");
                        string = C0411z.m3523i(context);
                        if (string == null) {
                            b = i;
                            str = a;
                        } else {
                            toLowerCase = string.toLowerCase(Locale.US);
                            str = m3017a();
                            b = m3021b();
                            if (toLowerCase.indexOf("ctwap") != -1) {
                                obj = 1;
                                a = str;
                                if (obj == null) {
                                    a = "10.0.0.200";
                                }
                                if (b == -1) {
                                    b = 80;
                                    str = a;
                                }
                            } else if (toLowerCase.indexOf("wap") != -1) {
                                if (TextUtils.isEmpty(str)) {
                                }
                                obj2 = null;
                                string = a;
                                if (obj2 == null) {
                                    string = "10.0.0.200";
                                }
                                str = string;
                                b = 80;
                            }
                            str = a;
                        }
                        if (query != null) {
                            query.close();
                        }
                        if (m3020a(str, b)) {
                            return new HttpHost(str, b, "http");
                        }
                        return null;
                    } catch (Throwable th2222) {
                        cursor = query;
                        str = null;
                        th3222 = th2222;
                        b = -1;
                        az.m3143a(th3222, "ProxyUtil", "getHostProxy1");
                        th3222.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (m3020a(str, b)) {
                            return new HttpHost(str, b, "http");
                        }
                        return null;
                    }
                }
                b = -1;
                str = null;
                if (query != null) {
                    query.close();
                }
            } catch (SecurityException e6) {
                th2222 = e6;
                query = null;
                i = -1;
                a = null;
                az.m3143a(th2222, "ProxyUtil", "getHostProxy");
                string = C0411z.m3523i(context);
                if (string == null) {
                    toLowerCase = string.toLowerCase(Locale.US);
                    str = m3017a();
                    b = m3021b();
                    if (toLowerCase.indexOf("ctwap") != -1) {
                        obj = 1;
                        a = str;
                        if (obj == null) {
                            a = "10.0.0.200";
                        }
                        if (b == -1) {
                            b = 80;
                            str = a;
                        }
                    } else if (toLowerCase.indexOf("wap") != -1) {
                        if (TextUtils.isEmpty(str)) {
                        }
                        obj2 = null;
                        string = a;
                        if (obj2 == null) {
                            string = "10.0.0.200";
                        }
                        str = string;
                        b = 80;
                    }
                    str = a;
                } else {
                    b = i;
                    str = a;
                }
                if (query != null) {
                    query.close();
                }
                if (m3020a(str, b)) {
                    return new HttpHost(str, b, "http");
                }
                return null;
            } catch (Throwable th22222) {
                th3222 = th22222;
                cursor = null;
                str = null;
                b = -1;
                az.m3143a(th3222, "ProxyUtil", "getHostProxy1");
                th3222.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (m3020a(str, b)) {
                    return new HttpHost(str, b, "http");
                }
                return null;
            } catch (Throwable th6) {
                th22222 = th6;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th22222;
            }
            if (m3020a(str, b)) {
                return new HttpHost(str, b, "http");
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m3020a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    /* renamed from: a */
    private static String m3017a() {
        String defaultHost;
        try {
            defaultHost = Proxy.getDefaultHost();
        } catch (Throwable th) {
            th.printStackTrace();
            az.m3143a(th, "ProxyUtil", "getDefHost");
            defaultHost = null;
        }
        if (defaultHost == null) {
            return "null";
        }
        return defaultHost;
    }

    /* renamed from: a */
    private static HttpHost m3019a(Context context, URI uri) {
        if (C0411z.m3521g(context) == 0) {
            try {
                java.net.Proxy proxy;
                String hostName;
                int i = -1;
                List select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty()) {
                    proxy = null;
                } else {
                    proxy = (java.net.Proxy) select.get(0);
                    if (proxy == null || proxy.type() == Type.DIRECT) {
                        proxy = null;
                    }
                }
                if (proxy != null) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    if (inetSocketAddress != null) {
                        hostName = inetSocketAddress.getHostName();
                        i = inetSocketAddress.getPort();
                        if (m3020a(hostName, i)) {
                            return new HttpHost(hostName, i, "http");
                        }
                    }
                }
                hostName = null;
                if (m3020a(hostName, i)) {
                    return new HttpHost(hostName, i, "http");
                }
            } catch (Throwable e) {
                az.m3143a(e, "ProxyUtil", "getProxySelectorCfg");
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    private static int m3021b() {
        int i = -1;
        try {
            i = Proxy.getDefaultPort();
        } catch (Throwable th) {
            az.m3143a(th, "ProxyUtil", "getDefPort");
            th.printStackTrace();
        }
        return i;
    }
}
