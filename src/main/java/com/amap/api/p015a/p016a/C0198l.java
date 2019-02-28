package com.amap.api.p015a.p016a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.FileDescriptor;

/* compiled from: ImageResizer */
/* renamed from: com.amap.api.a.a.l */
public class C0198l extends C0197m {
    /* renamed from: a */
    protected int f592a;
    /* renamed from: b */
    protected int f593b;

    public C0198l(Context context, int i, int i2) {
        super(context);
        m773a(i, i2);
    }

    /* renamed from: a */
    public void m773a(int i, int i2) {
        this.f592a = i;
        this.f593b = i2;
    }

    /* renamed from: a */
    private Bitmap m769a(int i) {
        C0202n.m788a("ImageResizer", "processBitmap - " + i, ErrorCode.NETWORK_NOT_WIFI_ERROR);
        return C0198l.m770a(this.d, i, this.f592a, this.f593b, m759a());
    }

    /* renamed from: a */
    protected Bitmap mo32a(Object obj) {
        return m769a(Integer.parseInt(String.valueOf(obj)));
    }

    /* renamed from: a */
    public static Bitmap m770a(Resources resources, int i, int i2, int i3, C0196j c0196j) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = C0198l.m768a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    /* renamed from: a */
    public static Bitmap m771a(FileDescriptor fileDescriptor, int i, int i2, C0196j c0196j) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = C0198l.m768a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    /* renamed from: a */
    public static int m768a(Options options, int i, int i2) {
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
