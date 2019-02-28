package com.autonavi.amap.mapcore;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Typeface;
import com.amap.api.mapcore.util.az;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p054u.aly.bi_常量类;

public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    static final int TEXT_FONTSIZE = 24;
    static Paint paint = null;
    private float base_line = 0.0f;
    private float start_x = 0.0f;

    public static int GetNearstSize2N(int i) {
        int i2 = 1;
        while (i > i2) {
            i2 *= 2;
        }
        return i2;
    }

    public TextTextureGenerator() {
        paint = newPaint(null, 24, 49);
        this.start_x = 0.0f;
        FontMetrics fontMetrics = paint.getFontMetrics();
        this.base_line = ((24.0f - (fontMetrics.bottom - fontMetrics.top)) / 2.0f) - fontMetrics.top;
    }

    private static Paint newPaint(String str, int i, int i2) {
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setTextSize((float) i);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setTypeface(Typeface.DEFAULT);
        switch (i2) {
            case 49:
                paint.setTextAlign(Align.LEFT);
                break;
            case 50:
                paint.setTextAlign(Align.RIGHT);
                break;
            case 51:
                paint.setTextAlign(Align.CENTER);
                break;
            default:
                paint.setTextAlign(Align.LEFT);
                break;
        }
        return paint;
    }

    public byte[] getTextPixelBuffer(int i) {
        char[] cArr = new char[]{(char) i};
        Bitmap createBitmap = Bitmap.createBitmap(24, 24, Config.ALPHA_8);
        Canvas canvas = new Canvas(createBitmap);
        byte[] bArr = new byte[576];
        Buffer wrap = ByteBuffer.wrap(bArr);
        float measureText = paint.measureText(cArr[0] + bi_常量类.f6358b);
        Align textAlign = paint.getTextAlign();
        measureText -= 24.0f;
        if (textAlign == Align.CENTER || measureText < 4.0f) {
            canvas.drawText(cArr, 0, 1, this.start_x, this.base_line, paint);
        } else {
            paint.setTextAlign(Align.CENTER);
            paint.setTextSize(24.0f - measureText);
            canvas.drawText(cArr, 0, 1, (24.0f - measureText) / 2.0f, this.base_line, paint);
            paint.setTextAlign(textAlign);
        }
        createBitmap.copyPixelsToBuffer(wrap);
        createBitmap.recycle();
        return bArr;
    }

    private byte[] getPixels(Bitmap bitmap) {
        if (bitmap == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[((bitmap.getWidth() * bitmap.getHeight()) * 4)];
        Buffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        bitmap.copyPixelsToBuffer(wrap);
        return bArr;
    }

    public static byte[] getCharsWidths(int[] iArr) {
        try {
            Paint newPaint = newPaint(null, 24, 49);
            int length = iArr.length;
            byte[] bArr = new byte[length];
            float[] fArr = new float[1];
            for (int i = 0; i < length; i++) {
                newPaint.getTextWidths(((char) iArr[i]) + bi_常量类.f6358b, fArr);
                bArr[i] = (byte) ((int) fArr[0]);
            }
            return bArr;
        } catch (Throwable th) {
            az.m3143a(th, "TextTextureGenerator", "getCharsWidths");
            return new byte[0];
        }
    }

    public static byte[] getCharWidths() {
        Paint newPaint = newPaint(null, 24, 49);
        byte[] bArr = new byte[256];
        float[] fArr = new float[1];
        for (int i = 0; i < 256; i++) {
            newPaint.getTextWidths(((char) i) + bi_常量类.f6358b, fArr);
            bArr[i] = (byte) ((int) fArr[0]);
        }
        return bArr;
    }
}
