package com.e4a.runtime;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.net.Uri;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.variants.ArrayVariant;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@SimpleObject
/* renamed from: com.e4a.runtime.图片操作 */
public final class C0845 {
    private C0845() {
    }

    private static byte[] Bitmap2Bytes(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    private static Bitmap Bytes2Bitmap(byte[] buffer) {
        return BitmapFactory.decodeByteArray(buffer, 0, buffer.length);
    }

    @SimpleFunction
    /* renamed from: 旋转图片 */
    public static byte[] m6626(byte[] bmp, float degree) {
        Bitmap zijie = C0845.Bytes2Bitmap(bmp);
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        return C0845.Bitmap2Bytes(Bitmap.createBitmap(zijie, 0, 0, zijie.getWidth(), zijie.getHeight(), matrix, true));
    }

    @SimpleFunction
    /* renamed from: 倾斜图片 */
    public static byte[] m6616(byte[] bmp, float x, float y) {
        Bitmap zijie = C0845.Bytes2Bitmap(bmp);
        Matrix matrix = new Matrix();
        matrix.postSkew(x, y);
        return C0845.Bitmap2Bytes(Bitmap.createBitmap(zijie, 0, 0, zijie.getWidth(), zijie.getHeight(), matrix, true));
    }

    @SimpleFunction
    /* renamed from: 缩放图片 */
    public static byte[] m6628(byte[] bm, int w, int h) {
        Bitmap lin = C0845.Bytes2Bitmap(bm);
        int width = lin.getWidth();
        int height = lin.getHeight();
        float scaleWidth = ((float) w) / ((float) width);
        float scaleHeight = ((float) h) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        return C0845.Bitmap2Bytes(Bitmap.createBitmap(lin, 0, 0, width, height, matrix, true));
    }

    @SimpleFunction
    /* renamed from: 取图片宽度2 */
    public static int m66222(byte[] bmp) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bmp, 0, bmp.length, options);
        return options.outWidth;
    }

    @SimpleFunction
    /* renamed from: 取图片高度2 */
    public static int m66252(byte[] bmp) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bmp, 0, bmp.length, options);
        return options.outHeight;
    }

    @SimpleFunction
    /* renamed from: 反转图片 */
    public static byte[] m6620(byte[] bmp, int flag) {
        float[] floats = null;
        switch (flag) {
            case 0:
                floats = new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
                break;
            case 1:
                floats = new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
                break;
        }
        if (floats == null) {
            return bmp;
        }
        Matrix matrix = new Matrix();
        matrix.setValues(floats);
        Bitmap ceshi = C0845.Bytes2Bitmap(bmp);
        return C0845.Bitmap2Bytes(Bitmap.createBitmap(ceshi, 0, 0, ceshi.getWidth(), ceshi.getHeight(), matrix, true));
    }

    @SimpleFunction
    /* renamed from: 取图片宽度 */
    public static int m6621(String imagePath) {
        try {
            InputStream is;
            if (imagePath.startsWith("/")) {
                is = new FileInputStream(imagePath);
            } else {
                is = C0841.m6594().getResources().getAssets().open(imagePath);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, options);
            return options.outWidth;
        } catch (IOException e) {
            return 0;
        }
    }

    @SimpleFunction
    /* renamed from: 取图片高度 */
    public static int m6624(String imagePath) {
        try {
            InputStream is;
            if (imagePath.startsWith("/")) {
                is = new FileInputStream(imagePath);
            } else {
                is = C0841.m6594().getResources().getAssets().open(imagePath);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(is, null, options);
            return options.outHeight;
        } catch (IOException e) {
            return 0;
        }
    }

    @SimpleFunction
    /* renamed from: 压缩图片 */
    public static byte[] m6618(byte[] 待压缩图片) {
        Bitmap image = C0845.Bytes2Bitmap(待压缩图片);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(CompressFormat.JPEG, 100, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {
            baos.reset();
            image.compress(CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        return C0845.Bitmap2Bytes(BitmapFactory.decodeStream(new ByteArrayInputStream(baos.toByteArray()), null, null));
    }

    @SimpleFunction
    /* renamed from: 压缩图片2 */
    public static void m66192(String 待压缩图片路径, String 压缩后保存路径, int 压缩后最大宽高限度) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(待压缩图片路径, options);
        options.inJustDecodeBounds = false;
        int be = (int) (((float) options.outHeight) / ((float) 压缩后最大宽高限度));
        if (be <= 0) {
            be = 1;
        }
        options.inSampleSize = be;
        bitmap = BitmapFactory.decodeFile(待压缩图片路径, options);
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        try {
            FileOutputStream out = new FileOutputStream(new File(压缩后保存路径));
            if (bitmap.compress(CompressFormat.JPEG, 100, out)) {
                out.flush();
                out.close();
            }
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 切割图片 */
    public static C0683_集合类 m6617(byte[] 待切割图片, int 横向切割片数, int 纵向切割片数) {
        C0683_集合类 pieces = new C0683_集合类();
        Bitmap bitmap = C0845.Bytes2Bitmap(待切割图片);
        int pieceWidth = bitmap.getWidth() / 横向切割片数;
        int pieceHeight = bitmap.getHeight() / 纵向切割片数;
        for (int i = 0; i < 纵向切割片数; i++) {
            for (int j = 0; j < 横向切割片数; j++) {
                pieces.m5454_集合add元素(ArrayVariant.getArrayVariant(C0845.Bitmap2Bytes(Bitmap.createBitmap(bitmap, j * pieceWidth, i * pieceHeight, pieceWidth, pieceHeight))));
            }
        }
        return pieces;
    }

    @SimpleFunction
    /* renamed from: 设置图片圆角 */
    public static byte[] m6630(byte[] 图片文件, int 圆角度) {
        Bitmap bitmap = C0845.Bytes2Bitmap(图片文件);
        Bitmap roundCornerBitmap = C0845.toRoundCorner(bitmap, 圆角度);
        if (圆角度 < 100) {
            return C0845.Bitmap2Bytes(roundCornerBitmap);
        }
        return C0845.Bitmap2Bytes(C0845.getCroppedRoundBitmap(roundCornerBitmap, (bitmap.getWidth() < bitmap.getHeight() ? bitmap.getWidth() : bitmap.getHeight()) / 2));
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, int pixels) {
        Bitmap roundCornerBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(roundCornerBitmap);
        Paint paint = new Paint();
        paint.setColor(-12434878);
        paint.setAntiAlias(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float roundPx = (float) pixels;
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return roundCornerBitmap;
    }

    public static Bitmap getCroppedRoundBitmap(Bitmap bmp, int radius) {
        Bitmap squareBitmap;
        Bitmap scaledSrcBmp;
        int diameter = radius * 2;
        int bmpWidth = bmp.getWidth();
        int bmpHeight = bmp.getHeight();
        Bitmap bitmap;
        int i;
        if (bmpHeight > bmpWidth) {
            bitmap = bmp;
            i = (bmpHeight - bmpWidth) / 2;
            squareBitmap = Bitmap.createBitmap(bitmap, 0, i, bmpWidth, bmpWidth);
        } else if (bmpHeight < bmpWidth) {
            int x = (bmpWidth - bmpHeight) / 2;
            bitmap = bmp;
            i = 0;
            squareBitmap = Bitmap.createBitmap(bitmap, x, i, bmpHeight, bmpHeight);
        } else {
            squareBitmap = bmp;
        }
        if (squareBitmap.getWidth() == diameter && squareBitmap.getHeight() == diameter) {
            scaledSrcBmp = squareBitmap;
        } else {
            scaledSrcBmp = Bitmap.createScaledBitmap(squareBitmap, diameter, diameter, true);
        }
        Bitmap output = Bitmap.createBitmap(scaledSrcBmp.getWidth(), scaledSrcBmp.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, scaledSrcBmp.getWidth(), scaledSrcBmp.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle((float) (scaledSrcBmp.getWidth() / 2), (float) (scaledSrcBmp.getHeight() / 2), (float) (scaledSrcBmp.getWidth() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(scaledSrcBmp, rect, rect, paint);
        return output;
    }

    @SimpleFunction
    /* renamed from: 设置图片倒影 */
    public static byte[] m6629(byte[] 图片文件) {
        return C0845.Bitmap2Bytes(C0845.createReflectionImageWithOrigin(C0845.Bytes2Bitmap(图片文件)));
    }

    public static Bitmap createReflectionImageWithOrigin(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap reflectionImage = Bitmap.createBitmap(bitmap, 0, height / 2, width, height / 2, matrix, false);
        Bitmap bitmapWithReflection = Bitmap.createBitmap(width, (height / 2) + height, Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapWithReflection);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, null);
        canvas.drawRect(0.0f, (float) height, (float) width, (float) (height + 4), new Paint());
        canvas.drawBitmap(reflectionImage, 0.0f, (float) (height + 4), null);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0.0f, (float) bitmap.getHeight(), 0.0f, (float) (bitmapWithReflection.getHeight() + 4), 1895825407, 16777215, TileMode.CLAMP));
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawRect(0.0f, (float) height, (float) width, (float) (bitmapWithReflection.getHeight() + 4), paint);
        return bitmapWithReflection;
    }

    @SimpleFunction
    /* renamed from: 取图片部分 */
    public static byte[] m6623(byte[] 待取图片, int x, int y, int w, int h) {
        return C0845.Bitmap2Bytes(Bitmap.createBitmap(C0845.Bytes2Bitmap(待取图片), x, y, w, h));
    }

    @SimpleFunction
    /* renamed from: 更新系统相册 */
    public static void m6627(String imagepath) {
        mainActivity.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + imagepath)));
    }
}
