package com.autonavi.tbt;

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
/* renamed from: com.autonavi.tbt.o */
public class C0626o {
    /* renamed from: a */
    public static HttpHost m4923a(Context context) {
        try {
            if (VERSION.SDK_INT >= 11) {
                return C0626o.m4924a(context, new URI("http://restapi.amap.com"));
            }
            return C0626o.m4927b(context);
        } catch (Throwable e) {
            ae.m4671a(e, "ProxyUtil", "getProxy");
            e.printStackTrace();
            return null;
        } catch (Throwable e2) {
            ae.m4671a(e2, "ProxyUtil", "getProxy");
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static HttpHost m4927b(Context context) {
        String string;
        String a;
        int b;
        Object obj;
        String str;
        Throwable th;
        int i;
        Throwable th2;
        String toLowerCase;
        Cursor cursor;
        Throwable th3;
        int i2;
        ae b2;
        Object obj2 = null;
        if (C0623l.m4892g(context) == 0) {
            Cursor query;
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
                                a = C0626o.m4922a();
                                b = C0626o.m4926b();
                                try {
                                    if (TextUtils.isEmpty(a) || a.equals("null")) {
                                        obj = null;
                                        a = null;
                                    } else {
                                        obj = 1;
                                    }
                                    if (obj == null) {
                                        try {
                                            str = "10.0.0.200";
                                        } catch (Throwable e) {
                                            th = e;
                                            i = b;
                                            th2 = th;
                                            ae.m4671a(th2, "ProxyUtil", "getHostProxy");
                                            string = C0623l.m4894i(context);
                                            if (string == null) {
                                                b = i;
                                                str = a;
                                            } else {
                                                toLowerCase = string.toLowerCase(Locale.US);
                                                str = C0626o.m4922a();
                                                b = C0626o.m4926b();
                                                if (toLowerCase.indexOf("ctwap") != -1) {
                                                    obj2 = 1;
                                                    a = str;
                                                    if (obj2 == null) {
                                                        a = "10.0.0.200";
                                                    }
                                                    if (b == -1) {
                                                        b = 80;
                                                        str = a;
                                                    }
                                                } else if (toLowerCase.indexOf("wap") != -1) {
                                                    if (!TextUtils.isEmpty(str)) {
                                                    }
                                                    obj = null;
                                                    string = a;
                                                    if (obj == null) {
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
                                            if (C0626o.m4925a(str, b)) {
                                                return new HttpHost(str, b, "http");
                                            }
                                            return null;
                                        } catch (Throwable e2) {
                                            th = e2;
                                            str = a;
                                            cursor = query;
                                            th3 = th;
                                            ae.m4671a(th3, "ProxyUtil", "getHostProxy1");
                                            th3.printStackTrace();
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (C0626o.m4925a(str, b)) {
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
                                    ae.m4671a(th2, "ProxyUtil", "getHostProxy");
                                    string = C0623l.m4894i(context);
                                    if (string == null) {
                                        toLowerCase = string.toLowerCase(Locale.US);
                                        str = C0626o.m4922a();
                                        b = C0626o.m4926b();
                                        if (toLowerCase.indexOf("ctwap") != -1) {
                                            if (!(TextUtils.isEmpty(str) || str.equals("null"))) {
                                                obj2 = 1;
                                                a = str;
                                            }
                                            if (obj2 == null) {
                                                a = "10.0.0.200";
                                            }
                                            if (b == -1) {
                                                b = 80;
                                                str = a;
                                            }
                                        } else if (toLowerCase.indexOf("wap") != -1) {
                                            if (TextUtils.isEmpty(str) || str.equals("null")) {
                                                obj = null;
                                                string = a;
                                            } else {
                                                string = str;
                                                obj = 1;
                                            }
                                            if (obj == null) {
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
                                    if (C0626o.m4925a(str, b)) {
                                        return new HttpHost(str, b, "http");
                                    }
                                    return null;
                                } catch (Throwable e222) {
                                    cursor = query;
                                    th3 = e222;
                                    str = null;
                                    ae.m4671a(th3, "ProxyUtil", "getHostProxy1");
                                    th3.printStackTrace();
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (C0626o.m4925a(str, b)) {
                                        return new HttpHost(str, b, "http");
                                    }
                                    return null;
                                }
                                if (C0626o.m4925a(str, b)) {
                                    return new HttpHost(str, b, "http");
                                }
                            } else if (string != null) {
                                if (string.contains("wap")) {
                                    a = C0626o.m4922a();
                                    i = C0626o.m4926b();
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
                                                    ae.m4671a(th2, "ProxyUtil", "getHostProxy");
                                                    string = C0623l.m4894i(context);
                                                    if (string == null) {
                                                        b = i;
                                                        str = a;
                                                    } else {
                                                        toLowerCase = string.toLowerCase(Locale.US);
                                                        str = C0626o.m4922a();
                                                        b = C0626o.m4926b();
                                                        if (toLowerCase.indexOf("ctwap") != -1) {
                                                            obj2 = 1;
                                                            a = str;
                                                            if (obj2 == null) {
                                                                a = "10.0.0.200";
                                                            }
                                                            if (b == -1) {
                                                                b = 80;
                                                                str = a;
                                                            }
                                                        } else if (toLowerCase.indexOf("wap") != -1) {
                                                            if (TextUtils.isEmpty(str)) {
                                                            }
                                                            obj = null;
                                                            string = a;
                                                            if (obj == null) {
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
                                                            b2 = ae.m4672b();
                                                            if (b2 != null) {
                                                                b2.m4673b(th32, "ProxyUtil", "getHostProxy2");
                                                            }
                                                            th32.printStackTrace();
                                                        }
                                                    }
                                                    if (C0626o.m4925a(str, b)) {
                                                        return new HttpHost(str, b, "http");
                                                    }
                                                    return null;
                                                } catch (Throwable th4) {
                                                    th2 = th4;
                                                    if (query != null) {
                                                        try {
                                                            query.close();
                                                        } catch (Throwable e2222) {
                                                            ae b3 = ae.m4672b();
                                                            if (b3 != null) {
                                                                b3.m4673b(e2222, "ProxyUtil", "getHostProxy2");
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
                                                    ae.m4671a(th32, "ProxyUtil", "getHostProxy1");
                                                    th32.printStackTrace();
                                                    if (cursor != null) {
                                                        try {
                                                            cursor.close();
                                                        } catch (Throwable th322) {
                                                            b2 = ae.m4672b();
                                                            if (b2 != null) {
                                                                b2.m4673b(th322, "ProxyUtil", "getHostProxy2");
                                                            }
                                                            th322.printStackTrace();
                                                        }
                                                    }
                                                    if (C0626o.m4925a(str, b)) {
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
                                                b2 = ae.m4672b();
                                                if (b2 != null) {
                                                    b2.m4673b(th3222, "ProxyUtil", "getHostProxy2");
                                                }
                                                th3222.printStackTrace();
                                            }
                                        }
                                    } catch (SecurityException e4) {
                                        th22 = e4;
                                        a = null;
                                        ae.m4671a(th22, "ProxyUtil", "getHostProxy");
                                        string = C0623l.m4894i(context);
                                        if (string == null) {
                                            toLowerCase = string.toLowerCase(Locale.US);
                                            str = C0626o.m4922a();
                                            b = C0626o.m4926b();
                                            if (toLowerCase.indexOf("ctwap") != -1) {
                                                obj2 = 1;
                                                a = str;
                                                if (obj2 == null) {
                                                    a = "10.0.0.200";
                                                }
                                                if (b == -1) {
                                                    b = 80;
                                                    str = a;
                                                }
                                            } else if (toLowerCase.indexOf("wap") != -1) {
                                                if (TextUtils.isEmpty(str)) {
                                                }
                                                obj = null;
                                                string = a;
                                                if (obj == null) {
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
                                        if (C0626o.m4925a(str, b)) {
                                            return new HttpHost(str, b, "http");
                                        }
                                        return null;
                                    } catch (Throwable th222) {
                                        cursor = query;
                                        th3222 = th222;
                                        b = i;
                                        str = null;
                                        ae.m4671a(th3222, "ProxyUtil", "getHostProxy1");
                                        th3222.printStackTrace();
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        if (C0626o.m4925a(str, b)) {
                                            return new HttpHost(str, b, "http");
                                        }
                                        return null;
                                    }
                                    if (C0626o.m4925a(str, b)) {
                                        return new HttpHost(str, b, "http");
                                    }
                                }
                            }
                        }
                    } catch (SecurityException e5) {
                        th222 = e5;
                        i = -1;
                        a = null;
                        ae.m4671a(th222, "ProxyUtil", "getHostProxy");
                        string = C0623l.m4894i(context);
                        if (string == null) {
                            b = i;
                            str = a;
                        } else {
                            toLowerCase = string.toLowerCase(Locale.US);
                            str = C0626o.m4922a();
                            b = C0626o.m4926b();
                            if (toLowerCase.indexOf("ctwap") != -1) {
                                obj2 = 1;
                                a = str;
                                if (obj2 == null) {
                                    a = "10.0.0.200";
                                }
                                if (b == -1) {
                                    b = 80;
                                    str = a;
                                }
                            } else if (toLowerCase.indexOf("wap") != -1) {
                                if (TextUtils.isEmpty(str)) {
                                }
                                obj = null;
                                string = a;
                                if (obj == null) {
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
                        if (C0626o.m4925a(str, b)) {
                            return new HttpHost(str, b, "http");
                        }
                        return null;
                    } catch (Throwable th2222) {
                        cursor = query;
                        str = null;
                        th3222 = th2222;
                        b = -1;
                        ae.m4671a(th3222, "ProxyUtil", "getHostProxy1");
                        th3222.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (C0626o.m4925a(str, b)) {
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
                ae.m4671a(th2222, "ProxyUtil", "getHostProxy");
                string = C0623l.m4894i(context);
                if (string == null) {
                    toLowerCase = string.toLowerCase(Locale.US);
                    str = C0626o.m4922a();
                    b = C0626o.m4926b();
                    if (toLowerCase.indexOf("ctwap") != -1) {
                        obj2 = 1;
                        a = str;
                        if (obj2 == null) {
                            a = "10.0.0.200";
                        }
                        if (b == -1) {
                            b = 80;
                            str = a;
                        }
                    } else if (toLowerCase.indexOf("wap") != -1) {
                        if (TextUtils.isEmpty(str)) {
                        }
                        obj = null;
                        string = a;
                        if (obj == null) {
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
                if (C0626o.m4925a(str, b)) {
                    return new HttpHost(str, b, "http");
                }
                return null;
            } catch (Throwable th22222) {
                th3222 = th22222;
                cursor = null;
                str = null;
                b = -1;
                ae.m4671a(th3222, "ProxyUtil", "getHostProxy1");
                th3222.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (C0626o.m4925a(str, b)) {
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
            if (C0626o.m4925a(str, b)) {
                return new HttpHost(str, b, "http");
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m4925a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    /* renamed from: a */
    private static String m4922a() {
        String defaultHost;
        try {
            defaultHost = Proxy.getDefaultHost();
        } catch (Throwable th) {
            th.printStackTrace();
            ae.m4671a(th, "ProxyUtil", "getDefHost");
            defaultHost = null;
        }
        if (defaultHost == null) {
            return "null";
        }
        return defaultHost;
    }

    /* renamed from: a */
    private static HttpHost m4924a(Context context, URI uri) {
        if (C0623l.m4892g(context) == 0) {
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
                        if (C0626o.m4925a(hostName, i)) {
                            return new HttpHost(hostName, i, "http");
                        }
                    }
                }
                hostName = null;
                if (C0626o.m4925a(hostName, i)) {
                    return new HttpHost(hostName, i, "http");
                }
            } catch (Throwable e) {
                ae.m4671a(e, "ProxyUtil", "getProxySelectorCfg");
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    private static int m4926b() {
        int i = -1;
        try {
            i = Proxy.getDefaultPort();
        } catch (Throwable th) {
            ae.m4671a(th, "ProxyUtil", "getDefPort");
            th.printStackTrace();
        }
        return i;
    }
}
