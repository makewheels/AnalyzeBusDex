package com.e4a.runtime.components.impl.android.util;

import android.view.View;

public final class ViewUtil {
    private ViewUtil() {
    }

    public static int getWidth(View view) {
        return view.getWidth();
    }

    public static void setWidth(View view, int width) {
        view.getLayoutParams().width = simpleToAndroidLength(width);
    }

    public static int getHeight(View view) {
        return view.getHeight();
    }

    public static void setHeight(View view, int height) {
        view.getLayoutParams().height = simpleToAndroidLength(height);
    }

    private static int simpleToAndroidLength(int simpleLength) {
        switch (simpleLength) {
            case -2:
                return -2;
            case -1:
                return -1;
            default:
                return simpleLength;
        }
    }
}
