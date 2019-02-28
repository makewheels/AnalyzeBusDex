package com.e4a.runtime;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.File;
import java.io.IOException;

@SimpleObject
/* renamed from: com.e4a.runtime.悬浮按钮类 */
public final class C0885 {
    private static Button floatButton;
    private static LayoutParams params;
    private static WindowManager windowManager;
    /* renamed from: 按钮被移动 */
    private static boolean f4334 = false;

    /* renamed from: com.e4a.runtime.悬浮按钮类$1 */
    static class C08821 implements OnTouchListener {
        int lastX;
        int lastY;
        int paramX;
        int paramY;

        C08821() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case 0:
                    this.lastX = (int) event.getRawX();
                    this.lastY = (int) event.getRawY();
                    this.paramX = C0885.params.x;
                    this.paramY = C0885.params.y;
                    mainActivity.getActiveForm().mo832();
                    break;
                case 1:
                    mainActivity.getActiveForm().mo831();
                    break;
                case 2:
                    int dx = ((int) event.getRawX()) - this.lastX;
                    int dy = ((int) event.getRawY()) - this.lastY;
                    if (dx > 5 || dy > 5) {
                        C0885.f4334 = true;
                    }
                    C0885.params.x = this.paramX + dx;
                    C0885.params.y = this.paramY + dy;
                    C0885.windowManager.updateViewLayout(C0885.floatButton, C0885.params);
                    break;
            }
            return false;
        }
    }

    /* renamed from: com.e4a.runtime.悬浮按钮类$2 */
    static class C08832 implements OnClickListener {
        C08832() {
        }

        public void onClick(View v) {
            if (C0885.f4334) {
                C0885.f4334 = false;
            } else {
                mainActivity.getActiveForm().mo830();
            }
        }
    }

    /* renamed from: com.e4a.runtime.悬浮按钮类$3 */
    static class C08843 implements OnLongClickListener {
        C08843() {
        }

        public boolean onLongClick(View v) {
            if (C0885.f4334) {
                C0885.f4334 = false;
            } else {
                mainActivity.getActiveForm().mo833();
            }
            return true;
        }
    }

    private C0885() {
    }

    @SimpleFunction
    /* renamed from: 创建悬浮按钮 */
    public static void m6738(String text, int textColor, int fontSize, int argb, String imagePath, int x, int y, int w, int h) {
        if (floatButton == null) {
            floatButton = new Button(C0841.m6594());
            floatButton.setText(text);
            floatButton.setTextColor(textColor);
            floatButton.setTextSize((float) fontSize);
            floatButton.setGravity(17);
            floatButton.setBackgroundColor(argb);
            C0885.m6745(floatButton, imagePath);
            windowManager = (WindowManager) C0841.m6594().getSystemService("window");
            params = new LayoutParams();
            params.type = 2002;
            params.format = 1;
            params.flags = 40;
            params.gravity = 51;
            params.x = x;
            params.y = y;
            params.width = w;
            params.height = h;
            windowManager.addView(floatButton, params);
            floatButton.setOnTouchListener(new C08821());
            floatButton.setOnClickListener(new C08832());
            floatButton.setOnLongClickListener(new C08843());
        }
    }

    @SimpleFunction
    /* renamed from: 修改悬浮按钮 */
    public static void m6737(String text, int textColor, int fontSize, int argb, String imagePath) {
        if (floatButton != null) {
            floatButton.setText(text);
            floatButton.setTextColor(textColor);
            floatButton.setTextSize((float) fontSize);
            floatButton.setGravity(17);
            floatButton.setBackgroundColor(argb);
            C0885.m6745(floatButton, imagePath);
        }
    }

    @SimpleFunction
    /* renamed from: 取悬浮按钮左边 */
    public static int m6740() {
        if (floatButton != null) {
            return params.x;
        }
        return 0;
    }

    @SimpleFunction
    /* renamed from: 取悬浮按钮顶边 */
    public static int m6741() {
        if (floatButton != null) {
            return params.y;
        }
        return 0;
    }

    @SimpleFunction
    /* renamed from: 取悬浮按钮宽度 */
    public static int m6739() {
        if (floatButton != null) {
            return params.width;
        }
        return 0;
    }

    @SimpleFunction
    /* renamed from: 取悬浮按钮高度 */
    public static int m6742() {
        if (floatButton != null) {
            return params.height;
        }
        return 0;
    }

    @SimpleFunction
    /* renamed from: 移动悬浮按钮 */
    public static void m6744(int x, int y, int w, int h) {
        if (floatButton != null) {
            params.x = x;
            params.y = y;
            params.width = w;
            params.height = h;
            windowManager.updateViewLayout(floatButton, params);
        }
    }

    @SimpleFunction
    /* renamed from: 隐藏悬浮按钮 */
    public static void m6748() {
        if (floatButton != null) {
            floatButton.setVisibility(4);
        }
    }

    @SimpleFunction
    /* renamed from: 显示悬浮按钮 */
    public static void m6743() {
        if (floatButton != null) {
            floatButton.setVisibility(0);
        }
    }

    @SimpleFunction
    /* renamed from: 销毁悬浮按钮 */
    public static void m6747() {
        if (floatButton != null) {
            windowManager.removeView(floatButton);
            floatButton = null;
        }
    }

    /* renamed from: 设置图片 */
    private static void m6745(Button view, String imagePath) {
        Drawable drawable = null;
        if (imagePath.length() > 0) {
            if (!imagePath.startsWith("/")) {
                try {
                    drawable = Drawable.createFromStream(C0841.m6594().getResources().getAssets().open(imagePath), imagePath);
                } catch (IOException e) {
                }
            } else if (new File(imagePath).exists()) {
                drawable = Drawable.createFromPath(imagePath);
            }
            view.setBackgroundDrawable(drawable);
            view.invalidate();
        }
    }

    /* renamed from: 设置字体样式 */
    private static void m6746(Button view, boolean set, int styleMask) {
        Typeface tf = view.getTypeface();
        if (tf == null) {
            tf = Typeface.DEFAULT;
        }
        int style = tf.getStyle() & (styleMask ^ -1);
        if (set) {
            style |= styleMask;
        }
        view.setTypeface(Typeface.create(tf, style));
    }
}
