package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.mapcore.util.bl.C0368a;
import com.amap.api.mapcore.util.bl.C0369b;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/* compiled from: ImageCache */
/* renamed from: com.amap.api.mapcore.util.j */
public class C0392j {
    /* renamed from: a */
    private static final CompressFormat f2157a = CompressFormat.PNG;
    /* renamed from: b */
    private bl f2158b;
    /* renamed from: c */
    private C0389p<String, Bitmap> f2159c;
    /* renamed from: d */
    private C0391a f2160d;
    /* renamed from: e */
    private final Object f2161e = new Object();
    /* renamed from: f */
    private boolean f2162f = true;
    /* renamed from: g */
    private HashMap<String, WeakReference<Bitmap>> f2163g;

    /* compiled from: ImageCache */
    /* renamed from: com.amap.api.mapcore.util.j$a */
    public static class C0391a {
        /* renamed from: a */
        public int f2149a = 5242880;
        /* renamed from: b */
        public int f2150b = 10485760;
        /* renamed from: c */
        public File f2151c;
        /* renamed from: d */
        public CompressFormat f2152d = C0392j.f2157a;
        /* renamed from: e */
        public int f2153e = 100;
        /* renamed from: f */
        public boolean f2154f = true;
        /* renamed from: g */
        public boolean f2155g = true;
        /* renamed from: h */
        public boolean f2156h = false;

        public C0391a(Context context, String str) {
            this.f2151c = C0392j.m3363a(context, str);
        }

        /* renamed from: a */
        public void m3354a(int i) {
            this.f2149a = i;
        }

        /* renamed from: b */
        public void m3357b(int i) {
            if (i <= 0) {
                this.f2155g = false;
            }
            this.f2150b = i;
        }

        /* renamed from: a */
        public void m3355a(String str) {
            this.f2151c = new File(str);
        }

        /* renamed from: a */
        public void m3356a(boolean z) {
            this.f2154f = z;
        }

        /* renamed from: b */
        public void m3358b(boolean z) {
            this.f2155g = z;
        }
    }

    private C0392j(C0391a c0391a) {
        m3366b(c0391a);
    }

    /* renamed from: a */
    public static C0392j m3361a(C0391a c0391a) {
        return new C0392j(c0391a);
    }

    /* renamed from: b */
    private void m3366b(C0391a c0391a) {
        this.f2160d = c0391a;
        if (this.f2160d.f2154f) {
            C0399o.m3422a("ImageCache", "Memory cache created (size = " + this.f2160d.f2149a + ")", ErrorCode.NETWORK_NOT_WIFI_ERROR);
            if (C0405u.m3483c()) {
                this.f2163g = new HashMap();
            }
            this.f2159c = new C0389p<String, Bitmap>(this, this.f2160d.f2149a) {
                /* renamed from: a */
                final /* synthetic */ C0392j f2148a;

                /* renamed from: a */
                protected void m3353a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                    if (C0405u.m3483c() && this.f2148a.f2163g != null && bitmap != null && !bitmap.isRecycled()) {
                        this.f2148a.f2163g.put(str, new WeakReference(bitmap));
                    }
                }

                /* renamed from: a */
                protected int m3351a(String str, Bitmap bitmap) {
                    int a = C0392j.m3359a(bitmap);
                    return a == 0 ? 1 : a;
                }
            };
        }
        if (c0391a.f2156h) {
            m3372a();
        }
    }

    /* renamed from: a */
    public void m3372a() {
        synchronized (this.f2161e) {
            if (this.f2158b == null || this.f2158b.m3271a()) {
                File file = this.f2160d.f2151c;
                if (this.f2160d.f2155g && file != null) {
                    try {
                        if (file.exists()) {
                            m3367b(file);
                        }
                        file.mkdir();
                    } catch (Exception e) {
                    }
                    if (C0392j.m3360a(file) > ((long) this.f2160d.f2150b)) {
                        try {
                            this.f2158b = bl.m3249a(file, 1, 1, (long) this.f2160d.f2150b);
                            C0399o.m3422a("ImageCache", "Disk cache initialized", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                        } catch (IOException e2) {
                            this.f2160d.f2151c = null;
                            C0399o.m3422a("ImageCache", "initDiskCache - " + e2, ErrorCode.DOWNLOAD_OVER_FLOW);
                        }
                    }
                }
            }
            this.f2162f = false;
            this.f2161e.notifyAll();
        }
    }

    /* renamed from: b */
    private void m3367b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                m3367b(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }

    /* renamed from: a */
    public void m3373a(String str, Bitmap bitmap) {
        IOException iOException;
        OutputStream outputStream;
        Object obj;
        Throwable th;
        Throwable th2;
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.f2159c != null) {
                this.f2159c.m3349b(str, bitmap);
            }
            synchronized (this.f2161e) {
                if (this.f2158b != null) {
                    String c = C0392j.m3368c(str);
                    OutputStream outputStream2 = null;
                    try {
                        C0369b a = this.f2158b.m3269a(c);
                        if (a == null) {
                            C0368a b = this.f2158b.m3272b(c);
                            if (b != null) {
                                outputStream2 = b.m3229a(0);
                                try {
                                    bitmap.compress(this.f2160d.f2152d, this.f2160d.f2153e, outputStream2);
                                    b.m3230a();
                                    outputStream2.close();
                                } catch (IOException e) {
                                    iOException = e;
                                    outputStream = outputStream2;
                                    IOException iOException2 = iOException;
                                    try {
                                        C0399o.m3422a("ImageCache", "addBitmapToCache - " + obj, ErrorCode.DOWNLOAD_OVER_FLOW);
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e2) {
                                            }
                                        }
                                        return;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (outputStream != null) {
                                            try {
                                                outputStream.close();
                                            } catch (IOException e3) {
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th2 = th4;
                                    outputStream = outputStream2;
                                    th = th2;
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            a.m3232a(0).close();
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e4) {
                            }
                        }
                    } catch (IOException e5) {
                        iOException = e5;
                        outputStream = null;
                        obj = iOException;
                        C0399o.m3422a("ImageCache", "addBitmapToCache - " + obj, ErrorCode.DOWNLOAD_OVER_FLOW);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return;
                    } catch (Throwable th42) {
                        th2 = th42;
                        outputStream = null;
                        th = th2;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                }
            }
            return;
        }
        return;
    }

    /* renamed from: a */
    public Bitmap m3371a(String str) {
        Bitmap bitmap;
        if (C0405u.m3483c() && this.f2163g != null) {
            WeakReference weakReference = (WeakReference) this.f2163g.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                }
                this.f2163g.remove(str);
                if (bitmap == null && this.f2159c != null) {
                    bitmap = (Bitmap) this.f2159c.m3345a((Object) str);
                }
                if (bitmap == null && !bitmap.isRecycled()) {
                    C0399o.m3422a("ImageCache", "Memory cache hit", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                    return bitmap;
                }
            }
        }
        bitmap = null;
        bitmap = (Bitmap) this.f2159c.m3345a((Object) str);
        return bitmap == null ? null : null;
    }

    /* renamed from: b */
    public Bitmap m3374b(String str) {
        InputStream a;
        Object e;
        Throwable th;
        Bitmap bitmap = null;
        String c = C0392j.m3368c(str);
        synchronized (this.f2161e) {
            while (this.f2162f) {
                try {
                    this.f2161e.wait();
                } catch (InterruptedException e2) {
                }
            }
            if (this.f2158b != null) {
                try {
                    C0369b a2 = this.f2158b.m3269a(c);
                    if (a2 != null) {
                        C0399o.m3422a("ImageCache", "Disk cache hit", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                        a = a2.m3232a(0);
                        if (a != null) {
                            try {
                                bitmap = C0394l.m3400a(((FileInputStream) a).getFD(), Integer.MAX_VALUE, Integer.MAX_VALUE, this);
                            } catch (IOException e3) {
                                e = e3;
                                try {
                                    C0399o.m3422a("ImageCache", "getBitmapFromDiskCache - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                                    if (a != null) {
                                        try {
                                            a.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    return bitmap;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (a != null) {
                                        try {
                                            a.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    Object obj = bitmap;
                    if (a != null) {
                        try {
                            a.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (IOException e7) {
                    e = e7;
                    a = bitmap;
                    C0399o.m3422a("ImageCache", "getBitmapFromDiskCache - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                    if (a != null) {
                        a.close();
                    }
                    return bitmap;
                } catch (Throwable th3) {
                    th = th3;
                    a = bitmap;
                    if (a != null) {
                        a.close();
                    }
                    throw th;
                }
            }
        }
        return bitmap;
    }

    /* renamed from: b */
    public void m3375b() {
        if (C0405u.m3483c() && this.f2163g != null) {
            this.f2163g.clear();
        }
        if (this.f2159c != null) {
            this.f2159c.m3346a();
            C0399o.m3422a("ImageCache", "Memory cache cleared", ErrorCode.NETWORK_NOT_WIFI_ERROR);
        }
        synchronized (this.f2161e) {
            this.f2162f = true;
            if (!(this.f2158b == null || this.f2158b.m3271a())) {
                try {
                    this.f2158b.m3274c();
                    C0399o.m3422a("ImageCache", "Disk cache cleared", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                } catch (IOException e) {
                    C0399o.m3422a("ImageCache", "clearCache - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                }
                this.f2158b = null;
                m3372a();
            }
        }
    }

    /* renamed from: c */
    public void m3376c() {
        synchronized (this.f2161e) {
            if (this.f2158b != null) {
                try {
                    this.f2158b.m3273b();
                    C0399o.m3422a("ImageCache", "Disk cache flushed", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                } catch (IOException e) {
                    C0399o.m3422a("ImageCache", "flush - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                }
            }
        }
    }

    /* renamed from: d */
    public void m3377d() {
        if (C0405u.m3483c() && this.f2163g != null) {
            this.f2163g.clear();
        }
        if (this.f2159c != null) {
            this.f2159c.m3346a();
            C0399o.m3422a("ImageCache", "Memory cache cleared", ErrorCode.NETWORK_NOT_WIFI_ERROR);
        }
        synchronized (this.f2161e) {
            if (this.f2158b != null) {
                try {
                    if (!this.f2158b.m3271a()) {
                        this.f2158b.m3274c();
                        this.f2158b = null;
                        C0399o.m3422a("ImageCache", "Disk cache closed", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                    }
                } catch (IOException e) {
                    C0399o.m3422a("ImageCache", "close - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                }
            }
        }
    }

    /* renamed from: a */
    public static File m3363a(Context context, String str) {
        File a = C0392j.m3362a(context);
        String path = (("mounted".equals(Environment.getExternalStorageState()) || !C0392j.m3369e()) && a != null) ? a.getPath() : context.getCacheDir().getPath();
        C0399o.m3422a("ImageCache", "Disk cachePath: " + path, ErrorCode.NETWORK_NOT_WIFI_ERROR);
        return new File(path + File.separator + str);
    }

    /* renamed from: c */
    public static String m3368c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes("utf-8"));
            return C0392j.m3364a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        } catch (UnsupportedEncodingException e2) {
            return String.valueOf(str.hashCode());
        }
    }

    /* renamed from: a */
    private static String m3364a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA);
            if (toHexString.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public static int m3359a(Bitmap bitmap) {
        if (C0405u.m3485d()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* renamed from: e */
    public static boolean m3369e() {
        if (C0405u.m3479b()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    /* renamed from: a */
    public static File m3362a(Context context) {
        if (C0405u.m3466a()) {
            return context.getExternalCacheDir();
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
    }

    /* renamed from: a */
    public static long m3360a(File file) {
        if (C0405u.m3479b()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }
}
