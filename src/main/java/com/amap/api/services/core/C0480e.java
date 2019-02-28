package com.amap.api.services.core;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.alipay.sdk.cons.C0108a;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: CoreUtil */
/* renamed from: com.amap.api.services.core.e */
public class C0480e {
    /* renamed from: a */
    public static byte[] m4021a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* renamed from: a */
    public static boolean m4020a(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* renamed from: a */
    public static double m4012a(int i) {
        return ((double) i) / 111700.0d;
    }

    /* renamed from: a */
    public static Proxy m4018a(Context context) {
        URI uri;
        Proxy a;
        try {
            uri = new URI("http://restapi.amap.com");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            uri = null;
        }
        if (VERSION.SDK_INT >= 11) {
            a = C0480e.m4019a(context, uri);
        } else {
            a = C0480e.m4025c(context);
        }
        if (a == null || a.type() == Type.DIRECT) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Proxy m4019a(Context context, URI uri) {
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private static java.net.Proxy m4025c(android.content.Context r10) {
        /*
        r9 = -1;
        r7 = 80;
        r6 = 0;
        r0 = "connectivity";
        r0 = r10.getSystemService(r0);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r8 = r0.getActiveNetworkInfo();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r8 == 0) goto L_0x010c;
    L_0x0012:
        r0 = r8.getType();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r1 = 1;
        if (r0 != r1) goto L_0x0031;
    L_0x0019:
        r1 = android.net.Proxy.getHost(r10);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r0 = android.net.Proxy.getPort(r10);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r7 = r0;
    L_0x0022:
        if (r1 == 0) goto L_0x010c;
    L_0x0024:
        r0 = new java.net.Proxy;	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r2 = java.net.Proxy.Type.HTTP;	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r1 = java.net.InetSocketAddress.createUnresolved(r1, r7);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r0.<init>(r2, r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
    L_0x002f:
        r6 = r0;
    L_0x0030:
        return r6;
    L_0x0031:
        r0 = "content://telephony/carriers/preferapn";
        r1 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        r0 = r10.getContentResolver();	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r2 == 0) goto L_0x0115;
    L_0x0045:
        r0 = r2.moveToFirst();	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == 0) goto L_0x0115;
    L_0x004b:
        r0 = "proxy";
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == r9) goto L_0x0112;
    L_0x0053:
        r1 = r2.getString(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r1 == 0) goto L_0x0062;
    L_0x0059:
        r0 = "";
        r0 = r1.equals(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == 0) goto L_0x0062;
    L_0x0061:
        r1 = r6;
    L_0x0062:
        r0 = "port";
        r0 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == r9) goto L_0x010f;
    L_0x006a:
        r0 = r2.getString(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r0 == 0) goto L_0x010f;
    L_0x0070:
        r3 = "";
        r3 = r0.equals(r3);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
        if (r3 != 0) goto L_0x010f;
    L_0x0078:
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0083, RuntimeException -> 0x0100 }
    L_0x007c:
        if (r2 == 0) goto L_0x0081;
    L_0x007e:
        r2.close();	 Catch:{ Exception -> 0x0109, RuntimeException -> 0x0100 }
    L_0x0081:
        r7 = r0;
        goto L_0x0022;
    L_0x0083:
        r0 = move-exception;
        r0 = r7;
    L_0x0085:
        r1 = r8.getExtraInfo();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 == 0) goto L_0x00f5;
    L_0x008b:
        r2 = "";
        r2 = r1.equals(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r2 != 0) goto L_0x00f5;
    L_0x0093:
        r2 = java.util.Locale.US;	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r1 = r1.toLowerCase(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r2 = "cmwap";
        r2 = r1.startsWith(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r2 != 0) goto L_0x00b1;
    L_0x00a1:
        r2 = "3gwap";
        r2 = r1.startsWith(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r2 != 0) goto L_0x00b1;
    L_0x00a9:
        r2 = "uniwap";
        r2 = r1.startsWith(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r2 == 0) goto L_0x00cd;
    L_0x00b1:
        r0 = android.net.Proxy.getDefaultHost();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r0 == 0) goto L_0x00ca;
    L_0x00b7:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00bf:
        r1 = "null";
        r1 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00c7:
        r1 = r0;
        goto L_0x0022;
    L_0x00ca:
        r0 = "10.0.0.172";
        goto L_0x00c7;
    L_0x00cd:
        r2 = "ctwap";
        r1 = r1.startsWith(r2);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 == 0) goto L_0x00f1;
    L_0x00d5:
        r0 = android.net.Proxy.getDefaultHost();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r0 == 0) goto L_0x00ee;
    L_0x00db:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 != 0) goto L_0x00ee;
    L_0x00e3:
        r1 = "null";
        r1 = r0.equals(r1);	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        if (r1 != 0) goto L_0x00ee;
    L_0x00eb:
        r1 = r0;
        goto L_0x0022;
    L_0x00ee:
        r0 = "10.0.0.200";
        goto L_0x00eb;
    L_0x00f1:
        r7 = r0;
        r1 = r6;
        goto L_0x0022;
    L_0x00f5:
        r1 = android.net.Proxy.getDefaultHost();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r0 = android.net.Proxy.getDefaultPort();	 Catch:{ RuntimeException -> 0x0100, Exception -> 0x0106 }
        r7 = r0;
        goto L_0x0022;
    L_0x0100:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0030;
    L_0x0106:
        r0 = move-exception;
        goto L_0x0030;
    L_0x0109:
        r1 = move-exception;
        goto L_0x0085;
    L_0x010c:
        r0 = r6;
        goto L_0x002f;
    L_0x010f:
        r0 = r7;
        goto L_0x007c;
    L_0x0112:
        r1 = r6;
        goto L_0x0062;
    L_0x0115:
        r0 = r7;
        r1 = r6;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.core.e.c(android.content.Context):java.net.Proxy");
    }

    /* renamed from: b */
    public static void m4024b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status") && jSONObject.has("info")) {
                String string = jSONObject.getString("status");
                String string2 = jSONObject.getString("info");
                if (!string.equals(C0108a.f262e) && string.equals("0")) {
                    if (string2.equals("INVALID_USER_KEY") || string2.equals("INSUFFICIENT_PRIVILEGES") || string2.equals("INVALID_USER_SCODE") || string2.equals("INVALID_USER_SIGNATURE")) {
                        throw new AMapException("key鉴权失败");
                    } else if (string2.equals("SERVICE_NOT_EXIST") || string2.equals("SERVICE_RESPONSE_ERROR") || string2.equals("OVER_QUOTA") || string2.equals("UNKNOWN_ERROR")) {
                        throw new AMapException("未知的错误");
                    } else if (string2.equals("INVALID_PARAMS")) {
                        throw new AMapException("无效的参数 - IllegalArgumentException");
                    } else if (string2.equals("服务正在维护中")) {
                        throw new AMapException("未知的错误");
                    } else if (string2.equals("参数缺失或格式非法")) {
                        throw new AMapException("无效的参数 - IllegalArgumentException");
                    } else if (string2.equals("账号未激活或已被冻结")) {
                        throw new AMapException("无效的参数 - IllegalArgumentException");
                    } else if (string2.startsWith("UNKOWN_ERROR")) {
                        throw new AMapException("未知的错误");
                    } else {
                        throw new AMapException(string2);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static double m4011a(double d) {
        return Double.parseDouble(new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US)).format(d));
    }

    /* renamed from: a */
    public static String m4014a(LatLonPoint latLonPoint) {
        if (latLonPoint == null) {
            return bi_常量类.f6358b_空串;
        }
        double a = C0480e.m4011a(latLonPoint.getLongitude());
        return a + "," + C0480e.m4011a(latLonPoint.getLatitude());
    }

    /* renamed from: c */
    public static Date m4026c(String str) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /* renamed from: d */
    public static Date m4027d(String str) {
        Date date = null;
        if (!(str == null || str.trim().equals(bi_常量类.f6358b_空串))) {
            try {
                date = new SimpleDateFormat("HHmm").parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /* renamed from: a */
    public static String m4016a(Date date) {
        return date != null ? new SimpleDateFormat("HH:mm").format(date) : bi_常量类.f6358b_空串;
    }

    /* renamed from: e */
    public static Date m4028e(String str) {
        Date date = null;
        if (!(str == null || str.trim().equals(bi_常量类.f6358b_空串))) {
            try {
                date = new SimpleDateFormat("HH:mm").parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /* renamed from: a */
    public static String m4017a(List<LatLonPoint> list) {
        if (list == null) {
            return bi_常量类.f6358b_空串;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            LatLonPoint latLonPoint = (LatLonPoint) list.get(i);
            double a = C0480e.m4011a(latLonPoint.getLongitude());
            stringBuffer.append(a).append(",").append(C0480e.m4011a(latLonPoint.getLatitude()));
            stringBuffer.append(";");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static String m4022b(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String toUpperCase = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA).toUpperCase(Locale.US);
                if (toUpperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(toUpperCase);
                stringBuffer.append(":");
            }
            return stringBuffer.toString();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public static String m4029f(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : split) {
            stringBuffer.append(append);
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    /* renamed from: a */
    public static String m4015a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2);
        String a = C0480e.m4013a();
        stringBuffer.append("&ts=" + a);
        stringBuffer.append("&scode=" + C0480e.m4023b(a, str));
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static String m4013a() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String str = C0108a.f262e;
        int length = valueOf.length();
        return valueOf.substring(0, length - 2) + str + valueOf.substring(length - 1);
    }

    /* renamed from: b */
    public static String m4023b(String str, String str2) {
        return C0490o.m4100a(C0479d.m3999a(null).m4010h() + ":" + str.substring(0, str.length() - 3) + ":" + str2);
    }
}
