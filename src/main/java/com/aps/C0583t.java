package com.aps;

import android.content.ContentResolver;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.widget.Toast;
import com.amap.api.location.core.C0284c;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.params.HttpParams;

/* compiled from: Utils */
/* renamed from: com.aps.t */
public class C0583t {
    private C0583t() {
    }

    /* renamed from: a */
    public static void m4576a(Object... objArr) {
    }

    /* renamed from: a */
    static void m4573a(Context context, String str) {
        int i;
        if (str == null) {
            str = "null";
        }
        if (C0284c.m1833j().indexOf("test") != -1) {
            i = 1;
        } else if (C0560f.f3458d.indexOf("test") != -1) {
            i = 1;
        } else {
            char[] cArr = null;
            if (C0284c.m1833j().length() > 0) {
                cArr = C0284c.m1833j().substring(7, 8).toCharArray();
            }
            if (cArr == null || !Character.isLetter(cArr[0])) {
                i = 1;
            } else {
                i = 0;
            }
        }
        if (i != 0 && context != null) {
            Toast.makeText(context, str, 0).show();
            C0583t.m4576a(str);
        }
    }

    /* renamed from: a */
    public static void m4574a(Throwable th) {
    }

    /* renamed from: a */
    static boolean m4578a(C0556c c0556c) {
        if (c0556c == null || c0556c.m4450i().equals("5") || c0556c.m4450i().equals("6")) {
            return false;
        }
        double d = c0556c.m4440d();
        double e = c0556c.m4442e();
        float f = c0556c.m4444f();
        if (d == 0.0d && e == 0.0d && ((double) f) == 0.0d) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static int m4570a(int i) {
        return (i * 2) - 113;
    }

    /* renamed from: a */
    public static String[] m4580a(TelephonyManager telephonyManager) {
        int i = 1;
        int i2 = 0;
        String[] strArr = new String[]{"0", "0"};
        Object obj = null;
        if (telephonyManager != null) {
            try {
                obj = telephonyManager.getNetworkOperator();
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(obj)) {
            i = i2;
        } else if (!TextUtils.isDigitsOnly(obj)) {
            i = i2;
        } else if (obj.length() <= 4) {
            i = i2;
        }
        if (i != 0) {
            strArr[0] = obj.substring(0, 3);
            char[] toCharArray = obj.substring(3).toCharArray();
            i = i2;
            while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                i++;
            }
            strArr[1] = obj.substring(3, i + 3);
        }
        try {
            i2 = Integer.parseInt(strArr[0]);
        } catch (Exception e2) {
        }
        if (i2 == 0) {
            strArr[0] = "0";
        }
        return strArr;
    }

    /* renamed from: a */
    static int m4571a(CellLocation cellLocation, Context context) {
        if (C0583t.m4577a(context)) {
            C0583t.m4576a("air plane mode on");
            return 9;
        } else if (cellLocation instanceof GsmCellLocation) {
            return 1;
        } else {
            try {
                Class.forName("android.telephony.cdma.CdmaCellLocation");
                return 2;
            } catch (Throwable th) {
                th.printStackTrace();
                C0583t.m4574a(th);
                return 9;
            }
        }
    }

    /* renamed from: a */
    static long m4572a() {
        return System.currentTimeMillis();
    }

    /* renamed from: a */
    static boolean m4577a(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        if (C0583t.m4581b() < 17) {
            try {
                if (System.getInt(contentResolver, "airplane_mode_on", 0) != 1) {
                    z = false;
                }
                return z;
            } catch (Throwable th) {
                th.printStackTrace();
                C0583t.m4574a(th);
                return false;
            }
        }
        try {
            if (Global.getInt(contentResolver, "airplane_mode_on", 0) != 1) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            th2.printStackTrace();
            C0583t.m4574a(th2);
            return false;
        }
    }

    /* renamed from: a */
    static float m4569a(double[] dArr) {
        if (dArr.length != 4) {
            return 0.0f;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }

    /* renamed from: b */
    static Object m4583b(Context context, String str) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext().getSystemService(str);
    }

    /* renamed from: a */
    static void m4575a(HttpParams httpParams, int i) {
        httpParams.setIntParameter("http.connection.timeout", i);
        httpParams.setIntParameter("http.socket.timeout", i);
        httpParams.setLongParameter("http.conn-manager.timeout", (long) i);
    }

    /* renamed from: b */
    static int m4581b() {
        int i = 0;
        try {
            return VERSION.SDK_INT;
        } catch (Throwable th) {
            th.printStackTrace();
            C0583t.m4574a(th);
            return i;
        }
    }

    /* renamed from: a */
    public static byte[] m4579a(byte[] bArr) {
        byte[] toByteArray;
        Throwable th;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return toByteArray;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            toByteArray = null;
            th = th4;
            th.printStackTrace();
            return toByteArray;
        }
        return toByteArray;
    }

    /* renamed from: b */
    static NetworkInfo m4582b(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) C0583t.m4583b(context, "connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException e) {
                return null;
            }
        }
        activeNetworkInfo = null;
        return activeNetworkInfo;
    }
}
