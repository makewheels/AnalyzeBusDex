package com.e4a.runtime.components.impl.android.p019;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.zxing.LuminanceSource;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.e4a.runtime.components.impl.android.支付宝免签约支付类库.RGBLuminanceSource */
public class RGBLuminanceSource extends LuminanceSource {
    private final byte[] luminances;

    public RGBLuminanceSource(String str) throws Exception {
        this(RGBLuminanceSource.loadBitmap(str));
    }

    public RGBLuminanceSource(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        this.luminances = new byte[(width * height)];
        for (int i = 0; i < height; i++) {
            int i2 = i * width;
            for (int i3 = 0; i3 < width; i3++) {
                int i4 = iArr[i2 + i3];
                int i5 = (i4 >> 16) & WebView.NORMAL_MODE_ALPHA;
                int i6 = (i4 >> 8) & WebView.NORMAL_MODE_ALPHA;
                i4 &= WebView.NORMAL_MODE_ALPHA;
                if (i5 == i6 && i6 == i4) {
                    this.luminances[i2 + i3] = (byte) i5;
                } else {
                    this.luminances[i2 + i3] = (byte) ((i4 + ((i5 + i6) + i6)) >> 2);
                }
            }
        }
    }

    public byte[] getRow(int i, byte[] bArr) {
        if (i < 0 || i >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.luminances, i * width, bArr, 0, width);
        return bArr;
    }

    public byte[] getMatrix() {
        return this.luminances;
    }

    private static Bitmap loadBitmap(String str) throws Exception {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            return decodeFile;
        }
        throw new Exception("Couldn't open " + str);
    }
}
