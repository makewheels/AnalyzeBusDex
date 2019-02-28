package com.e4a.runtime.components.impl.android.util;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.smtt.sdk.WebView;

public class PaintUtil {
    private PaintUtil() {
    }

    public static int extractARGB(Paint paint) {
        return paint.getColor() | (paint.getAlpha() << 24);
    }

    public static void changePaint(Paint paint, int argb) {
        if ((-16777216 & argb) == 0) {
            paint.setAlpha(0);
            paint.setXfermode(new PorterDuffXfermode(Mode.CLEAR));
            return;
        }
        paint.setColor(16777215 & argb);
        paint.setAlpha((argb >> 24) & WebView.NORMAL_MODE_ALPHA);
        paint.setXfermode(null);
    }
}
