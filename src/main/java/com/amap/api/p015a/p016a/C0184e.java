package com.amap.api.p015a.p016a;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.amap.api.p015a.C0269x;
import com.amap.api.p015a.C0269x.C0268a;
import com.amap.api.p015a.C0270y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import p054u.aly.bi_常量类;

/* compiled from: ClientInfoUtil */
/* renamed from: com.amap.api.a.a.e */
public class C0184e {
    /* renamed from: a */
    public static String f524a = bi_常量类.f6358b_空串;
    /* renamed from: b */
    public static int f525b = 2048;
    /* renamed from: c */
    private static C0184e f526c = null;
    /* renamed from: d */
    private static Context f527d = null;
    /* renamed from: e */
    private static TelephonyManager f528e;
    /* renamed from: f */
    private static ConnectivityManager f529f;
    /* renamed from: g */
    private static String f530g;
    /* renamed from: h */
    private static String f531h;
    /* renamed from: i */
    private static String f532i = bi_常量类.f6358b_空串;

    /* renamed from: a */
    public static C0184e m646a(Context context) {
        if (f526c == null) {
            f526c = new C0184e();
            f527d = context;
            f528e = (TelephonyManager) f527d.getSystemService("phone");
            f529f = (ConnectivityManager) f527d.getSystemService("connectivity");
            f530g = f527d.getApplicationContext().getPackageName();
            f531h = C0184e.m652g();
            f524a = C0184e.m649b(f527d);
            f532i = C0270y.m1735b(f527d);
        }
        return f526c;
    }

    /* renamed from: g */
    private static String m652g() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) f527d.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        f531h = i2 > i ? i + "*" + i2 : i2 + "*" + i;
        return f531h;
    }

    private C0184e() {
    }

    /* renamed from: a */
    public String m653a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f532i).append(f530g);
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public String m654b() {
        KeyGenerator instance;
        Exception e;
        try {
            instance = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            instance = null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        try {
            Object a = C0191h.m712a(encoded, C0191h.m710a(f527d));
            Object a2 = C0191h.m713a(encoded, m655c().getBytes());
            encoded = new byte[(a.length + a2.length)];
            try {
                System.arraycopy(a, 0, encoded, 0, a.length);
                System.arraycopy(a2, 0, encoded, a.length, a2.length);
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return C0191h.m714b(C0191h.m711a(encoded));
            }
        } catch (Exception e4) {
            Exception exception = e4;
            encoded = null;
            e = exception;
            e.printStackTrace();
            return C0191h.m714b(C0191h.m711a(encoded));
        }
        return C0191h.m714b(C0191h.m711a(encoded));
    }

    /* renamed from: c */
    public String m655c() {
        String deviceId;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ia=1&");
        if (f524a != null && f524a.length() > 0) {
            stringBuilder.append("key=");
            stringBuilder.append(f524a);
            stringBuilder.append("&");
        }
        stringBuilder.append("ct=android");
        if (C0269x.f1184e != C0268a.ALIBABA) {
            deviceId = f528e.getDeviceId();
            String subscriberId = f528e.getSubscriberId();
            stringBuilder.append("&ime=" + deviceId);
            stringBuilder.append("&sim=" + subscriberId);
            stringBuilder.append("&mod=");
            stringBuilder.append(m657e());
        }
        stringBuilder.append("&pkg=" + f530g);
        stringBuilder.append("&sv=");
        stringBuilder.append(m656d());
        stringBuilder.append("&nt=");
        stringBuilder.append(m658f());
        deviceId = f528e.getNetworkOperatorName();
        stringBuilder.append("&np=");
        stringBuilder.append(deviceId);
        stringBuilder.append("&ctm=" + System.currentTimeMillis());
        stringBuilder.append("&re=" + f531h);
        stringBuilder.append("&av=V2.3.0");
        stringBuilder.append("&pro=2dmap");
        if (C0269x.f1184e == C0268a.ALIBABA) {
            stringBuilder.append("&channel=1");
        }
        return stringBuilder.toString();
    }

    /* renamed from: d */
    public String m656d() {
        return VERSION.RELEASE;
    }

    /* renamed from: e */
    public String m657e() {
        return Build.MODEL;
    }

    /* renamed from: f */
    public String m658f() {
        if (f527d.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return bi_常量类.f6358b_空串;
        }
        if (f529f == null) {
            return bi_常量类.f6358b_空串;
        }
        NetworkInfo activeNetworkInfo = f529f.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return bi_常量类.f6358b_空串;
        }
        return activeNetworkInfo.getTypeName();
    }

    /* renamed from: b */
    public static String m649b(Context context) {
        if (f524a == null || f524a.equals(bi_常量类.f6358b_空串)) {
            try {
                f524a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.amap.api.v2.apikey");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return f524a;
    }

    /* renamed from: a */
    public static byte[] m648a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[f525b];
        while (true) {
            int read = inputStream.read(bArr, 0, f525b);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: c */
    public static Proxy m650c(Context context) {
        URI uri;
        Proxy a;
        try {
            uri = new URI("http://restapi.amap.com");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            uri = null;
        }
        if (VERSION.SDK_INT >= 11) {
            a = C0184e.m647a(context, uri);
        } else {
            a = C0184e.m651d(context);
        }
        if (a == null || a.type() == Type.DIRECT) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Proxy m647a(Context context, URI uri) {
        List select;
        try {
            select = ProxySelector.getDefault().select(uri);
        } catch (Exception e) {
            select = null;
        }
        if (select == null || select.size() <= 0) {
            return null;
        }
        return (Proxy) select.get(0);
    }

    /* renamed from: d */
    private static Proxy m651d(Context context) {
        String host;
        String string;
        int i = 80;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    host = android.net.Proxy.getHost(context);
                    i = android.net.Proxy.getPort(context);
                } else {
                    int i2;
                    try {
                        Cursor query = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                        if (query == null || !query.moveToFirst()) {
                            i2 = 80;
                            host = null;
                        } else {
                            i2 = query.getColumnIndex("proxy");
                            if (i2 != -1) {
                                host = query.getString(i2);
                                if (host != null && host.equals(bi_常量类.f6358b_空串)) {
                                    host = null;
                                }
                            } else {
                                host = null;
                            }
                            i2 = query.getColumnIndex("port");
                            if (i2 != -1) {
                                string = query.getString(i2);
                                if (!(string == null || string.equals(bi_常量类.f6358b_空串))) {
                                    i2 = Integer.parseInt(string);
                                }
                            }
                            i2 = 80;
                        }
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e) {
                                host = activeNetworkInfo.getExtraInfo();
                                if (host != null || host.equals(bi_常量类.f6358b_空串)) {
                                    host = android.net.Proxy.getDefaultHost();
                                    i = android.net.Proxy.getDefaultPort();
                                    if (host != null) {
                                        return new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(host, i));
                                    }
                                    return null;
                                }
                                host = host.toLowerCase(Locale.US);
                                if (host.startsWith("cmwap") || host.startsWith("3gwap") || host.startsWith("uniwap")) {
                                    string = android.net.Proxy.getDefaultHost();
                                    if (string == null || string.equals(bi_常量类.f6358b_空串) || string.equals("null")) {
                                        string = "10.0.0.172";
                                    }
                                    host = string;
                                    if (host != null) {
                                        return new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(host, i));
                                    }
                                    return null;
                                }
                                if (host.startsWith("ctwap")) {
                                    string = android.net.Proxy.getDefaultHost();
                                    if (string == null || string.equals(bi_常量类.f6358b_空串) || string.equals("null")) {
                                        string = "10.0.0.200";
                                    }
                                    host = string;
                                } else {
                                    i = i2;
                                    host = null;
                                }
                                if (host != null) {
                                    return new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(host, i));
                                }
                                return null;
                            }
                        }
                        i = i2;
                    } catch (Exception e2) {
                        i2 = 80;
                        host = activeNetworkInfo.getExtraInfo();
                        if (host != null) {
                        }
                        host = android.net.Proxy.getDefaultHost();
                        i = android.net.Proxy.getDefaultPort();
                        if (host != null) {
                            return new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(host, i));
                        }
                        return null;
                    }
                }
                if (host != null) {
                    return new Proxy(Type.HTTP, InetSocketAddress.createUnresolved(host, i));
                }
            }
            return null;
        } catch (Exception e3) {
            return null;
        }
    }
}
