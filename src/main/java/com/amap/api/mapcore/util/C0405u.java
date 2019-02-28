package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.mapcore.C0313u;
import com.amap.api.mapcore.C0344n;
import com.amap.api.mapcore.ak;
import com.amap.api.mapcore.util.ad.C0356a;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* compiled from: Util */
/* renamed from: com.amap.api.mapcore.util.u */
public class C0405u {
    /* renamed from: a */
    static final int[] f2188a = new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    /* renamed from: b */
    static final double[] f2189b = new double[]{7453.642d, 3742.9905d, 1873.333d, 936.89026d, 468.472d, 234.239d, 117.12d, 58.56d, 29.28d, 14.64d, 7.32d, 3.66d, 1.829d, 0.915d, 0.4575d, 0.228d, 0.1144d};
    /* renamed from: c */
    public static Handler f2190c = new Handler();

    /* renamed from: a */
    public static Bitmap m3450a(Context context, String str) {
        try {
            InputStream open = C0402s.m3433a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            az.m3143a(th, "Util", "fromAsset");
            return null;
        }
    }

    /* renamed from: a */
    public static void m3463a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* renamed from: a */
    public static String m3459a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    /* renamed from: a */
    public static float m3443a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 45.0f) {
            return 45.0f;
        }
        return f;
    }

    /* renamed from: b */
    public static float m3473b(float f) {
        if (f > 20.0f) {
            return 20.0f;
        }
        if (f < 3.0f) {
            return 3.0f;
        }
        return f;
    }

    /* renamed from: a */
    public static FloatBuffer m3461a(float[] fArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        } catch (Throwable th) {
            az.m3143a(th, "Util", "makeFloatBuffer1");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static FloatBuffer m3462a(float[] fArr, FloatBuffer floatBuffer) {
        try {
            floatBuffer.clear();
            floatBuffer.put(fArr);
            floatBuffer.position(0);
            return floatBuffer;
        } catch (Throwable th) {
            az.m3143a(th, "Util", "makeFloatBuffer2");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static int m3447a(GL10 gl10, Bitmap bitmap) {
        return C0405u.m3448a(gl10, bitmap, false);
    }

    /* renamed from: a */
    public static int m3448a(GL10 gl10, Bitmap bitmap, boolean z) {
        return C0405u.m3446a(gl10, 0, bitmap, z);
    }

    /* renamed from: a */
    public static int m3445a(GL10 gl10, int i, Bitmap bitmap) {
        return C0405u.m3446a(gl10, i, bitmap, false);
    }

    /* renamed from: a */
    public static int m3446a(GL10 gl10, int i, Bitmap bitmap, boolean z) {
        int b = C0405u.m3474b(gl10, i, bitmap, z);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return b;
    }

    /* renamed from: b */
    public static int m3474b(GL10 gl10, int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = new int[]{0};
            gl10.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        gl10.glEnable(3553);
        gl10.glBindTexture(3553, i);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
        if (z) {
            gl10.glTexParameterf(3553, 10242, 10497.0f);
            gl10.glTexParameterf(3553, 10243, 10497.0f);
        } else {
            gl10.glTexParameterf(3553, 10242, 33071.0f);
            gl10.glTexParameterf(3553, 10243, 33071.0f);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        gl10.glDisable(3553);
        return i;
    }

    /* renamed from: a */
    public static int m3444a(int i) {
        int log = (int) (Math.log((double) i) / Math.log(2.0d));
        if ((1 << log) >= i) {
            return 1 << log;
        }
        return 1 << (log + 1);
    }

    /* renamed from: a */
    public static String m3460a(String... strArr) {
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
    public static int m3449a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    /* renamed from: a */
    public static Bitmap m3452a(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, bitmap.hasAlpha() ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    /* renamed from: b */
    public static byte[] m3481b(Context context, final String str) {
        try {
            InputStream open = C0402s.m3433a(context).open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (FileNotFoundException e) {
            f2190c.post(new Runnable() {
                public void run() {
                    Toast.makeText(ak.f1476a, str + "  is not found!", 0).show();
                }
            });
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable th) {
            az.m3143a(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: a */
    public static Bitmap m3451a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    /* renamed from: a */
    public static String m3456a(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getCacheDir().toString() + "/";
        }
        File file;
        File file2;
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals(bi_常量类.f6358b)) {
            file = new File(Environment.getExternalStorageDirectory(), "amap");
            if (!file.exists()) {
                file.mkdir();
            }
            file2 = new File(file, "mini_mapv3");
            if (!file2.exists()) {
                file2.mkdir();
            }
            return file2.toString() + "/";
        }
        file2 = new File(MapsInitializer.sdcardDir);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        file = new File(file2, "mini_mapv3");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + "/";
    }

    /* renamed from: b */
    public static String m3476b(Context context) {
        String str = bi_常量类.f6358b;
        File file;
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.equals(bi_常量类.f6358b)) {
            file = new File(Environment.getExternalStorageDirectory(), "amap");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, "VMAP2");
            if (!file2.exists()) {
                file2.mkdir();
            }
            return file2.toString() + "/";
        }
        str = MapsInitializer.sdcardDir + "VMAP2/";
        file = new File(str);
        if (file.exists()) {
            return str;
        }
        file.mkdirs();
        return str;
    }

    /* renamed from: b */
    public static String m3475b(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    /* renamed from: c */
    public static boolean m3484c(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        State state = activeNetworkInfo.getState();
        if (state == null || state == State.DISCONNECTED || state == State.DISCONNECTING) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m3466a() {
        return VERSION.SDK_INT >= 8;
    }

    /* renamed from: b */
    public static boolean m3479b() {
        return VERSION.SDK_INT >= 9;
    }

    /* renamed from: c */
    public static boolean m3483c() {
        return VERSION.SDK_INT >= 11;
    }

    /* renamed from: d */
    public static boolean m3485d() {
        return VERSION.SDK_INT >= 12;
    }

    /* renamed from: a */
    public static void m3465a(GL10 gl10, int i) {
        gl10.glDeleteTextures(1, new int[]{i}, 0);
    }

    /* renamed from: a */
    public static String m3458a(InputStream inputStream) {
        try {
            return new String(C0405u.m3482b(inputStream), "utf-8");
        } catch (Throwable th) {
            az.m3143a(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m3482b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static String m3457a(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        Throwable e;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader2 = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                    } catch (Throwable th) {
                        e = th;
                        bufferedReader2 = bufferedReader;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e42) {
                                e42.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e422) {
                        e422.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                bufferedReader = null;
                fileInputStream2 = fileInputStream;
                try {
                    az.m3143a(e, "Util", "readFile fileNotFound");
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e4222) {
                            e4222.printStackTrace();
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e42222) {
                                    e42222.printStackTrace();
                                }
                            }
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e52) {
                                    e52.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e422222) {
                            e422222.printStackTrace();
                        }
                    }
                    return stringBuffer.toString();
                } catch (Throwable th4) {
                    e = th4;
                    fileInputStream = fileInputStream2;
                    bufferedReader2 = bufferedReader;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e522) {
                            e522.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5222) {
                                    e5222.printStackTrace();
                                }
                            }
                        } catch (Throwable th5) {
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e52222) {
                                    e52222.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e522222) {
                            e522222.printStackTrace();
                        }
                    }
                    throw e;
                }
            } catch (IOException e7) {
                e = e7;
                try {
                    az.m3143a(e, "Util", "readFile io");
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4222222) {
                            e4222222.printStackTrace();
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e42222222) {
                                    e42222222.printStackTrace();
                                }
                            }
                        } catch (Throwable th6) {
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e5222222) {
                                    e5222222.printStackTrace();
                                }
                            }
                        }
                    }
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e422222222) {
                            e422222222.printStackTrace();
                        }
                    }
                    return stringBuffer.toString();
                } catch (Throwable th7) {
                    e = th7;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw e;
                }
            }
        } catch (FileNotFoundException e8) {
            e = e8;
            bufferedReader = null;
            az.m3143a(e, "Util", "readFile fileNotFound");
            e.printStackTrace();
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return stringBuffer.toString();
        } catch (IOException e9) {
            e = e9;
            fileInputStream = null;
            az.m3143a(e, "Util", "readFile io");
            e.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            return stringBuffer.toString();
        } catch (Throwable th8) {
            e = th8;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw e;
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static void m3464a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
                String string = jSONObject.getString("status");
                if (string.equals("E6008")) {
                    throw new AMapException("key为空");
                } else if (string.equals("E6012")) {
                    throw new AMapException("key不存在");
                } else if (string.equals("E6018")) {
                    throw new AMapException("key被锁定");
                }
            }
        } catch (Throwable e) {
            az.m3143a(e, "Util", "paseAuthFailurJson");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public static boolean m3468a(LatLng latLng, List<LatLng> list) {
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        double d3 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (!((LatLng) list.get(0)).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            double d4 = ((LatLng) list.get(i)).longitude;
            double d5 = ((LatLng) list.get(i)).latitude;
            double d6 = ((LatLng) list.get(i + 1)).longitude;
            double d7 = ((LatLng) list.get(i + 1)).latitude;
            if (C0405u.m3480b(d, d2, d4, d5, d6, d7)) {
                return true;
            }
            int i3;
            if (Math.abs(d7 - d5) < 1.0E-9d) {
                i3 = i2;
            } else {
                if (C0405u.m3480b(d4, d5, d, d2, 180.0d, d3)) {
                    if (d5 > d7) {
                        i3 = i2 + 1;
                    }
                } else if (C0405u.m3480b(d6, d7, d, d2, 180.0d, d3)) {
                    if (d7 > d5) {
                        i3 = i2 + 1;
                    }
                } else if (C0405u.m3467a(d4, d5, d6, d7, d, d2, 180.0d, d3)) {
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
    public static double m3441a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    /* renamed from: b */
    public static boolean m3480b(double d, double d2, double d3, double d4, double d5, double d6) {
        if (Math.abs(C0405u.m3441a(d, d2, d3, d4, d5, d6)) >= 1.0E-9d || (d - d3) * (d - d5) > 0.0d || (d2 - d4) * (d2 - d6) > 0.0d) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m3467a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
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

    /* renamed from: a */
    public static float[] m3471a(C0313u c0313u, List<IPoint> list) {
        int i = 0;
        List arrayList = new ArrayList();
        List<FPoint> b = C0405u.m3477b(c0313u, (List) list);
        FPoint[] a = C0405u.m3472a(c0313u);
        int i2 = 0;
        while (i2 < 4) {
            arrayList.clear();
            for (int i3 = 0; i3 < b.size() - 1; i3++) {
                FPoint fPoint = (FPoint) b.get(i3);
                FPoint fPoint2 = (FPoint) b.get(i3 + 1);
                if (i3 == 0 && C0405u.m3469a(fPoint, a[i2], a[(i2 + 1) % 4])) {
                    arrayList.add(fPoint);
                }
                if (C0405u.m3469a(fPoint, a[i2], a[(i2 + 1) % 4])) {
                    if (C0405u.m3469a(fPoint2, a[i2], a[(i2 + 1) % 4])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(C0405u.m3455a(a[i2], a[(i2 + 1) % 4], fPoint, fPoint2));
                    }
                } else if (C0405u.m3469a(fPoint2, a[i2], a[(i2 + 1) % 4])) {
                    arrayList.add(C0405u.m3455a(a[i2], a[(i2 + 1) % 4], fPoint, fPoint2));
                    arrayList.add(fPoint2);
                }
            }
            b.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                b.add(arrayList.get(i4));
            }
            byte b2 = (byte) (i2 + 1);
        }
        float[] fArr = new float[(b.size() * 3)];
        for (FPoint fPoint3 : b) {
            fArr[i * 3] = fPoint3.f3637x;
            fArr[(i * 3) + 1] = fPoint3.f3638y;
            fArr[(i * 3) + 2] = 0.0f;
            i++;
        }
        return fArr;
    }

    /* renamed from: a */
    private static FPoint[] m3472a(C0313u c0313u) {
        FPoint[] fPointArr = new FPoint[4];
        FPoint fPoint = new FPoint();
        c0313u.mo360a(-300, -300, fPoint);
        fPointArr[0] = fPoint;
        fPoint = new FPoint();
        c0313u.mo360a(c0313u.mo406h() + ErrorCode.ERROR_CODE_LOAD_BASE, -300, fPoint);
        fPointArr[1] = fPoint;
        fPoint = new FPoint();
        c0313u.mo360a(c0313u.mo406h() + ErrorCode.ERROR_CODE_LOAD_BASE, c0313u.mo409i() + ErrorCode.ERROR_CODE_LOAD_BASE, fPoint);
        fPointArr[2] = fPoint;
        fPoint = new FPoint();
        c0313u.mo360a(-100, c0313u.mo409i() + ErrorCode.ERROR_CODE_LOAD_BASE, fPoint);
        fPointArr[3] = fPoint;
        return fPointArr;
    }

    /* renamed from: b */
    private static List<FPoint> m3477b(C0313u c0313u, List<IPoint> list) {
        List<FPoint> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            FPoint fPoint = new FPoint();
            c0313u.mo390b(((IPoint) list.get(i)).f3640y, ((IPoint) list.get(i)).f3639x, fPoint);
            arrayList.add(fPoint);
        }
        return arrayList;
    }

    /* renamed from: a */
    private static FPoint m3455a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3, FPoint fPoint4) {
        FPoint fPoint5 = new FPoint(0.0f, 0.0f);
        double d = (double) (((fPoint2.f3638y - fPoint.f3638y) * (fPoint.f3637x - fPoint3.f3637x)) - ((fPoint2.f3637x - fPoint.f3637x) * (fPoint.f3638y - fPoint3.f3638y)));
        double d2 = (double) (((fPoint2.f3638y - fPoint.f3638y) * (fPoint4.f3637x - fPoint3.f3637x)) - ((fPoint2.f3637x - fPoint.f3637x) * (fPoint4.f3638y - fPoint3.f3638y)));
        fPoint5.f3637x = (float) (((double) fPoint3.f3637x) + ((((double) (fPoint4.f3637x - fPoint3.f3637x)) * d) / d2));
        fPoint5.f3638y = (float) (((d * ((double) (fPoint4.f3638y - fPoint3.f3638y))) / d2) + ((double) fPoint3.f3638y));
        return fPoint5;
    }

    /* renamed from: a */
    private static boolean m3469a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        if (((double) (((fPoint3.f3637x - fPoint2.f3637x) * (fPoint.f3638y - fPoint2.f3638y)) - ((fPoint.f3637x - fPoint2.f3637x) * (fPoint3.f3638y - fPoint2.f3638y)))) >= 0.0d) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static float m3442a(double d, double d2, double d3, double d4) {
        if (d > 0.0d) {
            float a = (float) C0405u.m3440a(d, d3);
            if (d2 > 0.0d) {
                return (float) Math.min((double) a, C0405u.m3440a(d2, d4));
            }
            return a;
        } else if (d2 > 0.0d) {
            return (float) C0405u.m3440a(d2, d4);
        } else {
            return 0.0f;
        }
    }

    /* renamed from: a */
    public static double m3440a(double d, double d2) {
        if (d2 > 0.0d) {
            return Math.log((1048576.0d * d) / d2) / Math.log(2.0d);
        }
        return 0.0d;
    }

    /* renamed from: e */
    public static ad m3486e() {
        try {
            if (C0344n.f1882e != null) {
                return C0344n.f1882e;
            }
            return new C0356a(C0344n.f1879b, "V2.5.1", C0344n.f1880c).m3031a(new String[]{"com.amap.api.maps"}).m3032a();
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: b */
    private static void m3478b(View view) {
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                C0405u.m3478b(((ViewGroup) view).getChildAt(i));
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setHorizontallyScrolling(false);
        }
    }

    /* renamed from: a */
    public static Bitmap m3453a(View view) {
        try {
            C0405u.m3478b(view);
            view.destroyDrawingCache();
            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            return view.getDrawingCache().copy(Config.ARGB_8888, false);
        } catch (Throwable th) {
            az.m3143a(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static DPoint m3454a(LatLng latLng) {
        double d = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return new DPoint(d * 1.0d, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * 1.0d);
    }

    /* renamed from: a */
    public static float[] m3470a(C0313u c0313u, int i, FPoint fPoint, float f, int i2, int i3, float f2, float f3) throws RemoteException {
        float f4 = fPoint.f3637x;
        float f5 = fPoint.f3638y;
        float[] fArr = new float[12];
        float a = c0313u.mo427v().mo499a(i2);
        float a2 = c0313u.mo427v().mo499a(i3);
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[4];
        Matrix.setIdentityM(fArr2, 0);
        if (i == 3) {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, c0313u.mo395c().getMapAngle(), 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
            Matrix.translateM(fArr2, 0, f4 - (a / 2.0f), f5 - (a2 / 2.0f), 0.0f);
            Matrix.rotateM(fArr2, 0, -c0313u.mo395c().getCameraHeaderAngle(), 1.0f, 0.0f, 0.0f);
            Matrix.translateM(fArr2, 0, (a / 2.0f) - f4, (a2 / 2.0f) - f5, 0.0f);
        } else if (i == 1) {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
        } else {
            Matrix.translateM(fArr2, 0, f4, f5, 0.0f);
            Matrix.rotateM(fArr2, 0, c0313u.mo395c().getMapAngle(), 0.0f, 0.0f, 1.0f);
            Matrix.rotateM(fArr2, 0, -c0313u.mo395c().getCameraHeaderAngle(), 1.0f, 0.0f, 0.0f);
            Matrix.rotateM(fArr2, 0, f, 0.0f, 0.0f, 1.0f);
            Matrix.translateM(fArr2, 0, -f4, -f5, 0.0f);
        }
        float[] fArr4 = new float[]{f4 - (a * f2), ((1.0f - f3) * a2) + f5, 0.0f, 1.0f};
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[0] = fArr4[0];
        fArr[1] = fArr4[1];
        fArr[2] = fArr4[2];
        fArr3[0] = ((1.0f - f2) * a) + f4;
        fArr3[1] = ((1.0f - f3) * a2) + f5;
        fArr3[2] = 0.0f;
        fArr3[3] = 1.0f;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[3] = fArr4[0];
        fArr[4] = fArr4[1];
        fArr[5] = fArr4[2];
        fArr3[0] = ((1.0f - f2) * a) + f4;
        fArr3[1] = f5 - (a2 * f3);
        fArr3[2] = 0.0f;
        fArr3[3] = 1.0f;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[6] = fArr4[0];
        fArr[7] = fArr4[1];
        fArr[8] = fArr4[2];
        fArr3[0] = f4 - (a * f2);
        fArr3[1] = f5 - (a2 * f3);
        fArr3[2] = 0.0f;
        fArr3[3] = 1.0f;
        Matrix.multiplyMV(fArr4, 0, fArr2, 0, fArr3, 0);
        fArr[9] = fArr4[0];
        fArr[10] = fArr4[1];
        fArr[11] = fArr4[2];
        return fArr;
    }
}
