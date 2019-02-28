package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.FileDescriptor;

/* compiled from: ImageResizer */
/* renamed from: com.amap.api.mapcore.util.l */
public class C0394l extends C0393m {
    /* renamed from: a */
    protected int f2170a;
    /* renamed from: b */
    protected int f2171b;

    public C0394l(Context context, int i, int i2) {
        super(context);
        m3402a(i, i2);
    }

    /* renamed from: a */
    public void m3402a(int i, int i2) {
        this.f2170a = i;
        this.f2171b = i2;
    }

    /* renamed from: a */
    private Bitmap m3398a(int i) {
        C0399o.m3422a("ImageResizer", "processBitmap - " + i, ErrorCode.NETWORK_NOT_WIFI_ERROR);
        return C0394l.m3399a(this.d, i, this.f2170a, this.f2171b, m3385a());
    }

    /* renamed from: a */
    protected Bitmap mo613a(Object obj) {
        return m3398a(Integer.parseInt(String.valueOf(obj)));
    }

    /* renamed from: a */
    public static Bitmap m3399a(Resources resources, int i, int i2, int i3, C0392j c0392j) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = C0394l.m3397a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    /* renamed from: a */
    public static Bitmap m3400a(FileDescriptor fileDescriptor, int i, int i2, C0392j c0392j) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = C0394l.m3397a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    /* renamed from: a */
    public static int m3397a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            i5 = Math.round(((float) i3) / ((float) i2));
            int round = Math.round(((float) i4) / ((float) i));
            if (i5 >= round) {
                i5 = round;
            }
            float f = (float) (i4 * i3);
            while (f / ((float) (i5 * i5)) > ((float) ((i * i2) * 2))) {
                i5++;
            }
        }
        return i5;
    }
}
