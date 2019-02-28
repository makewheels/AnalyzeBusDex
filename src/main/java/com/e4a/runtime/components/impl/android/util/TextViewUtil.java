package com.e4a.runtime.components.impl.android.util;

import android.graphics.Typeface;
import android.widget.TextView;

public class TextViewUtil {
    private TextViewUtil() {
    }

    public static void setJustification(TextView textview, int justification) {
        int gravity;
        switch (justification) {
            case 0:
                gravity = 3;
                break;
            case 1:
                gravity = 1;
                break;
            case 2:
                gravity = 5;
                break;
            case 3:
                gravity = 51;
                break;
            case 4:
                gravity = 19;
                break;
            case 5:
                gravity = 83;
                break;
            case 6:
                gravity = 49;
                break;
            case 7:
                gravity = 17;
                break;
            case 8:
                gravity = 81;
                break;
            case 9:
                gravity = 53;
                break;
            case 10:
                gravity = 21;
                break;
            case 11:
                gravity = 85;
                break;
            default:
                throw new IllegalArgumentException();
        }
        textview.setGravity(gravity);
        textview.invalidate();
    }

    public static void setBackgroundColor(TextView textview, int argb) {
        textview.setBackgroundColor(argb);
        textview.invalidate();
    }

    public static boolean isEnabled(TextView textview) {
        return textview.isEnabled();
    }

    public static void setEnabled(TextView textview, boolean enabled) {
        textview.setEnabled(enabled);
        textview.invalidate();
    }

    public static boolean isFontBold(TextView textview) {
        return textview.getTypeface().isBold();
    }

    public static void setFontBold(TextView textview, boolean bold) {
        setFontStyle(textview, bold, 1);
    }

    public static boolean isFontItalic(TextView textview) {
        return textview.getTypeface().isItalic();
    }

    public static void setFontItalic(TextView textview, boolean italic) {
        setFontStyle(textview, italic, 2);
    }

    public static void setFontTypeface(TextView textview, int typeface) {
        Typeface tf;
        switch (typeface) {
            case 0:
                tf = Typeface.DEFAULT;
                break;
            case 1:
                tf = Typeface.SANS_SERIF;
                break;
            case 2:
                tf = Typeface.SERIF;
                break;
            case 3:
                tf = Typeface.MONOSPACE;
                break;
            default:
                throw new IllegalArgumentException();
        }
        textview.setTypeface(tf);
        textview.invalidate();
    }

    public static String getText(TextView textview) {
        return textview.getText().toString();
    }

    public static void setText(TextView textview, String text) {
        textview.setText(text);
        textview.invalidate();
    }

    public static void setTextColor(TextView textview, int argb) {
        textview.setTextColor(argb);
        textview.invalidate();
    }

    private static void setFontStyle(TextView textview, boolean set, int styleMask) {
        Typeface tf = textview.getTypeface();
        if (tf == null) {
            tf = Typeface.DEFAULT;
        }
        int style = tf.getStyle() & (styleMask ^ -1);
        if (set) {
            style |= styleMask;
        }
        textview.setTypeface(Typeface.create(tf, style));
        textview.invalidate();
    }
}
