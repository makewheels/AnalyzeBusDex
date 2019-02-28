package com.amap.api.p015a.p016a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.p015a.p016a.C0189f.C0186a;
import com.amap.api.p015a.p016a.C0189f.C0188c;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/* compiled from: ImageCache */
/* renamed from: com.amap.api.a.a.j */
public class C0196j {
    /* renamed from: a */
    private static final CompressFormat f579a = CompressFormat.JPEG;
    /* renamed from: b */
    private C0189f f580b;
    /* renamed from: c */
    private C0193o<String, Bitmap> f581c;
    /* renamed from: d */
    private C0195a f582d;
    /* renamed from: e */
    private final Object f583e = new Object();
    /* renamed from: f */
    private boolean f584f = true;
    /* renamed from: g */
    private HashMap<String, WeakReference<Bitmap>> f585g;

    /* compiled from: ImageCache */
    /* renamed from: com.amap.api.a.a.j$a */
    public static class C0195a {
        /* renamed from: a */
        public int f571a = 5120;
        /* renamed from: b */
        public int f572b = 10485760;
        /* renamed from: c */
        public File f573c;
        /* renamed from: d */
        public CompressFormat f574d = C0196j.f579a;
        /* renamed from: e */
        public int f575e = 100;
        /* renamed from: f */
        public boolean f576f = true;
        /* renamed from: g */
        public boolean f577g = true;
        /* renamed from: h */
        public boolean f578h = false;

        public C0195a(Context context, String str) {
            this.f573c = C0196j.m738a(context, str);
        }

        /* renamed from: a */
        public void m729a(int i) {
            this.f571a = i;
        }

        /* renamed from: b */
        public void m732b(int i) {
            this.f572b = i;
        }

        /* renamed from: a */
        public void m730a(String str) {
            this.f573c = new File(str);
        }

        /* renamed from: a */
        public void m731a(boolean z) {
            this.f576f = z;
        }

        /* renamed from: b */
        public void m733b(boolean z) {
            this.f577g = z;
        }
    }

    private C0196j(C0195a c0195a) {
        m741b(c0195a);
    }

    /* renamed from: a */
    public static C0196j m736a(C0195a c0195a) {
        return new C0196j(c0195a);
    }

    /* renamed from: b */
    private void m741b(C0195a c0195a) {
        this.f582d = c0195a;
        if (this.f582d.f576f) {
            C0202n.m788a("ImageCache", "Memory cache created (size = " + this.f582d.f571a + ")", ErrorCode.NETWORK_NOT_WIFI_ERROR);
            if (C0204q.m810c()) {
                this.f585g = new HashMap();
            }
            this.f581c = new C0193o<String, Bitmap>(this, this.f582d.f571a) {
                /* renamed from: a */
                final /* synthetic */ C0196j f570a;

                /* renamed from: a */
                protected void m728a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
                    if (C0204q.m810c() && this.f570a.f585g != null && bitmap != null && !bitmap.isRecycled()) {
                        this.f570a.f585g.put(str, new WeakReference(bitmap));
                    }
                }

                /* renamed from: a */
                protected int m726a(String str, Bitmap bitmap) {
                    int a = C0196j.m734a(bitmap) / 1024;
                    return a == 0 ? 1 : a;
                }
            };
        }
        if (c0195a.f578h) {
            m746a();
        }
    }

    /* renamed from: a */
    public void m746a() {
        synchronized (this.f583e) {
            if (this.f580b == null || this.f580b.m704a()) {
                File file = this.f582d.f573c;
                if (this.f582d.f577g && file != null) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (C0196j.m735a(file) > ((long) this.f582d.f572b)) {
                        try {
                            this.f580b = C0189f.m681a(file, 1, 1, (long) this.f582d.f572b);
                            C0202n.m788a("ImageCache", "Disk cache initialized", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                        } catch (IOException e) {
                            this.f582d.f573c = null;
                            C0202n.m788a("ImageCache", "initDiskCache - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                        }
                    }
                }
            }
            this.f584f = false;
            this.f583e.notifyAll();
        }
    }

    /* renamed from: a */
    public void m747a(String str, Bitmap bitmap) {
        IOException iOException;
        OutputStream outputStream;
        Object obj;
        Throwable th;
        Exception exception;
        Throwable th2;
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.f581c != null) {
                this.f581c.m724b(str, bitmap);
            }
            synchronized (this.f583e) {
                if (this.f580b != null) {
                    String c = C0196j.m742c(str);
                    OutputStream outputStream2 = null;
                    try {
                        C0188c a = this.f580b.m703a(c);
                        if (a == null) {
                            C0186a b = this.f580b.m705b(c);
                            if (b != null) {
                                outputStream2 = b.m661a(0);
                                try {
                                    bitmap.compress(this.f582d.f574d, this.f582d.f575e, outputStream2);
                                    b.m662a();
                                    outputStream2.close();
                                } catch (IOException e) {
                                    iOException = e;
                                    outputStream = outputStream2;
                                    IOException iOException2 = iOException;
                                    try {
                                        C0202n.m788a("ImageCache", "addBitmapToCache - " + obj, ErrorCode.DOWNLOAD_OVER_FLOW);
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
                                } catch (Exception e4) {
                                    exception = e4;
                                    outputStream = outputStream2;
                                    Exception exception2 = exception;
                                    C0202n.m788a("ImageCache", "addBitmapToCache - " + obj, ErrorCode.DOWNLOAD_OVER_FLOW);
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    return;
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
                            a.m678a(0).close();
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e6) {
                            }
                        }
                    } catch (IOException e7) {
                        iOException = e7;
                        outputStream = null;
                        obj = iOException;
                        C0202n.m788a("ImageCache", "addBitmapToCache - " + obj, ErrorCode.DOWNLOAD_OVER_FLOW);
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return;
                    } catch (Exception e42) {
                        exception = e42;
                        outputStream = null;
                        obj = exception;
                        C0202n.m788a("ImageCache", "addBitmapToCache - " + obj, ErrorCode.DOWNLOAD_OVER_FLOW);
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
    public Bitmap m745a(String str) {
        Bitmap bitmap;
        if (C0204q.m810c() && this.f585g != null) {
            WeakReference weakReference = (WeakReference) this.f585g.get(str);
            if (weakReference != null) {
                bitmap = (Bitmap) weakReference.get();
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                }
                this.f585g.remove(str);
                if (bitmap == null && this.f581c != null) {
                    bitmap = (Bitmap) this.f581c.m720a((Object) str);
                }
                if (bitmap == null && !bitmap.isRecycled()) {
                    C0202n.m788a("ImageCache", "Memory cache hit", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                    return bitmap;
                }
            }
        }
        bitmap = null;
        bitmap = (Bitmap) this.f581c.m720a((Object) str);
        return bitmap == null ? null : null;
    }

    /* renamed from: b */
    public Bitmap m748b(String str) {
        InputStream a;
        Object e;
        Throwable th;
        Bitmap bitmap = null;
        String c = C0196j.m742c(str);
        synchronized (this.f583e) {
            while (this.f584f) {
                try {
                    this.f583e.wait();
                } catch (InterruptedException e2) {
                }
            }
            if (this.f580b != null) {
                try {
                    C0188c a2 = this.f580b.m703a(c);
                    if (a2 != null) {
                        C0202n.m788a("ImageCache", "Disk cache hit", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                        a = a2.m678a(0);
                        if (a != null) {
                            try {
                                bitmap = C0198l.m771a(((FileInputStream) a).getFD(), Integer.MAX_VALUE, Integer.MAX_VALUE, this);
                            } catch (IOException e3) {
                                e = e3;
                                try {
                                    C0202n.m788a("ImageCache", "getBitmapFromDiskCache - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
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
                    C0202n.m788a("ImageCache", "getBitmapFromDiskCache - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
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
    public void m749b() {
        if (C0204q.m810c() && this.f585g != null) {
            this.f585g.clear();
        }
        if (this.f581c != null) {
            this.f581c.m721a();
            C0202n.m788a("ImageCache", "Memory cache cleared", ErrorCode.NETWORK_NOT_WIFI_ERROR);
        }
        synchronized (this.f583e) {
            this.f584f = true;
            if (!(this.f580b == null || this.f580b.m704a())) {
                try {
                    this.f580b.m707c();
                    C0202n.m788a("ImageCache", "Disk cache cleared", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                } catch (IOException e) {
                    C0202n.m788a("ImageCache", "clearCache - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                }
                this.f580b = null;
                m746a();
            }
        }
    }

    /* renamed from: c */
    public void m750c() {
        synchronized (this.f583e) {
            if (this.f580b != null) {
                try {
                    this.f580b.m706b();
                    C0202n.m788a("ImageCache", "Disk cache flushed", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                } catch (IOException e) {
                    C0202n.m788a("ImageCache", "flush - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                }
            }
        }
    }

    /* renamed from: d */
    public void m751d() {
        if (C0204q.m810c() && this.f585g != null) {
            this.f585g.clear();
        }
        if (this.f581c != null) {
            this.f581c.m721a();
            C0202n.m788a("ImageCache", "Memory cache cleared", ErrorCode.NETWORK_NOT_WIFI_ERROR);
        }
        synchronized (this.f583e) {
            if (this.f580b != null) {
                try {
                    if (!this.f580b.m704a()) {
                        this.f580b.m707c();
                        this.f580b = null;
                        C0202n.m788a("ImageCache", "Disk cache closed", ErrorCode.NETWORK_NOT_WIFI_ERROR);
                    }
                } catch (IOException e) {
                    C0202n.m788a("ImageCache", "close - " + e, ErrorCode.DOWNLOAD_OVER_FLOW);
                }
            }
        }
    }

    /* renamed from: a */
    public static File m738a(Context context, String str) {
        File a = C0196j.m737a(context);
        String path = (("mounted".equals(Environment.getExternalStorageState()) || !C0196j.m743e()) && a != null) ? a.getPath() : context.getCacheDir().getPath();
        C0202n.m788a("ImageCache", "Disk cachePath: " + path, ErrorCode.NETWORK_NOT_WIFI_ERROR);
        return new File(path + File.separator + str);
    }

    /* renamed from: c */
    public static String m742c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return C0196j.m739a(instance.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

    /* renamed from: a */
    private static String m739a(byte[] bArr) {
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
    public static int m734a(Bitmap bitmap) {
        if (C0204q.m811d()) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /* renamed from: e */
    public static boolean m743e() {
        if (C0204q.m809b()) {
            return Environment.isExternalStorageRemovable();
        }
        return true;
    }

    /* renamed from: a */
    public static File m737a(Context context) {
        if (C0204q.m802a()) {
            return context.getExternalCacheDir();
        }
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/cache/"));
    }

    /* renamed from: a */
    public static long m735a(File file) {
        if (C0204q.m809b()) {
            return file.getUsableSpace();
        }
        StatFs statFs = new StatFs(file.getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }
}
