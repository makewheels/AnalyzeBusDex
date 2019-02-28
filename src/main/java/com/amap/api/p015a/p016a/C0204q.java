package com.amap.api.p015a.p016a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build.VERSION;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.p015a.C0269x;
import com.amap.api.p015a.ac;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import java.util.List;

/* compiled from: Util */
/* renamed from: com.amap.api.a.a.q */
public class C0204q {
    /* renamed from: a */
    public static final int[] f599a = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    /* renamed from: b */
    public static double[] f600b = new double[]{7453.642d, 3742.9905d, 1873.333d, 936.89026d, 468.472d, 234.239d, 117.12d, 58.56d, 29.28d, 14.64d, 7.32d, 3.66d, 1.829d, 0.915d, 0.4575d, 0.228d, 0.1144d};

    /* renamed from: a */
    public static Bitmap m797a(String str) {
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return decodeStream;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m799a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    /* renamed from: a */
    public static float m792a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 45.0f) {
            return 45.0f;
        }
        return f;
    }

    /* renamed from: b */
    public static float m807b(float f) {
        if (f > ((float) C0269x.f1182c)) {
            return (float) C0269x.f1182c;
        }
        if (f < ((float) C0269x.f1183d)) {
            return (float) C0269x.f1183d;
        }
        return f;
    }

    /* renamed from: a */
    public static FloatBuffer m801a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    /* renamed from: a */
    public static int m793a(int i) {
        int log = (int) (Math.log((double) i) / Math.log(2.0d));
        if ((1 << log) >= i) {
            return 1 << log;
        }
        return 1 << (log + 1);
    }

    /* renamed from: a */
    public static String m800a(String... strArr) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            if (i2 != strArr.length - 1) {
                stringBuilder.append(",");
            }
            i2++;
            i++;
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static int m794a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    /* renamed from: a */
    public static Bitmap m796a(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.hasAlpha() ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    /* renamed from: a */
    public static Bitmap m795a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    /* renamed from: a */
    public static double m791a(LatLng latLng, LatLng latLng2) {
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        d *= 0.01745329251994329d;
        d2 *= 0.01745329251994329d;
        double d3 = latLng2.longitude * 0.01745329251994329d;
        double d4 = latLng2.latitude * 0.01745329251994329d;
        double sin = Math.sin(d);
        double sin2 = Math.sin(d2);
        d = Math.cos(d);
        d2 = Math.cos(d2);
        double sin3 = Math.sin(d3);
        double sin4 = Math.sin(d4);
        d3 = Math.cos(d3);
        d4 = Math.cos(d4);
        r17 = new double[3];
        double[] dArr = new double[]{d * d2, d2 * sin, sin2};
        dArr[0] = d4 * d3;
        dArr[1] = d4 * sin3;
        dArr[2] = sin4;
        return Math.asin(Math.sqrt((((r17[0] - dArr[0]) * (r17[0] - dArr[0])) + ((r17[1] - dArr[1]) * (r17[1] - dArr[1]))) + ((r17[2] - dArr[2]) * (r17[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d;
    }

    /* renamed from: b */
    public static String m808b(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    /* renamed from: a */
    public static boolean m802a() {
        return VERSION.SDK_INT >= 8;
    }

    /* renamed from: b */
    public static boolean m809b() {
        return VERSION.SDK_INT >= 9;
    }

    /* renamed from: c */
    public static boolean m810c() {
        return VERSION.SDK_INT >= 11;
    }

    /* renamed from: d */
    public static boolean m811d() {
        return VERSION.SDK_INT >= 12;
    }

    /* renamed from: a */
    public static ac m798a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new ac((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
    }

    /* renamed from: a */
    public static boolean m805a(LatLng latLng, List<LatLng> list) {
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        double d3 = latLng.latitude;
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            double d4 = ((LatLng) list.get(i)).longitude;
            double d5 = ((LatLng) list.get(i)).latitude;
            double d6 = ((LatLng) list.get(i + 1)).longitude;
            double d7 = ((LatLng) list.get(i + 1)).latitude;
            if (C0204q.m803a(d, d2, d4, d5, d6, d7)) {
                return true;
            }
            int i3;
            if (Math.abs(d7 - d5) < 1.0E-9d) {
                i3 = i2;
            } else {
                if (C0204q.m803a(d4, d5, d, d2, 180.0d, d3)) {
                    if (d5 > d7) {
                        i3 = i2 + 1;
                    }
                } else if (C0204q.m803a(d6, d7, d, d2, 180.0d, d3)) {
                    if (d7 > d5) {
                        i3 = i2 + 1;
                    }
                } else if (C0204q.m804a(d4, d5, d6, d7, d, d2, 180.0d, d3)) {
                    i3 = i2 + 1;
                }
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2 % 2 != 0;
    }

    /* renamed from: a */
    public static boolean m803a(double d, double d2, double d3, double d4, double d5, double d6) {
        if (Math.abs(C0204q.m806b(d, d2, d3, d4, d5, d6)) >= 1.0E-9d || (d - d3) * (d - d5) > 0.0d || (d2 - d4) * (d2 - d6) > 0.0d) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static double m806b(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    /* renamed from: a */
    public static boolean m804a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = ((d3 - d) * (d8 - d6)) - ((d4 - d2) * (d7 - d5));
        if (d9 == 0.0d) {
            return false;
        }
        double d10 = (((d2 - d6) * (d7 - d5)) - ((d - d5) * (d8 - d6))) / d9;
        d9 = (((d2 - d6) * (d3 - d)) - ((d - d5) * (d4 - d2))) / d9;
        if (d10 < 0.0d || d10 > 1.0d || d9 < 0.0d || d9 > 1.0d) {
            return false;
        }
        return true;
    }
}
