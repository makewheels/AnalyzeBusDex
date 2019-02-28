package com.e4a.runtime.helpers;

import com.e4a.runtime.errors.ConversionError;

public final class ConvHelpers {
    private ConvHelpers() {
    }

    public static int boolean2integer(boolean b) {
        return b ? -1 : 0;
    }

    public static long boolean2long(boolean b) {
        return b ? -1 : 0;
    }

    public static float boolean2single(boolean b) {
        return b ? -1.0f : 0.0f;
    }

    public static double boolean2double(boolean b) {
        return b ? -1.0d : 0.0d;
    }

    public static String boolean2string(boolean b) {
        return b ? "True" : "False";
    }

    public static int byte2integer(byte b) {
        return (b << 24) >> 24;
    }

    public static byte short2byte(short s) {
        return (byte) ((s << 24) >> 24);
    }

    public static boolean integer2boolean(int i) {
        return i != 0;
    }

    public static byte integer2byte(int i) {
        return (byte) ((i << 24) >> 24);
    }

    public static short integer2short(int i) {
        return (short) ((i << 16) >> 16);
    }

    public static boolean long2boolean(long l) {
        return l != 0;
    }

    public static byte long2byte(long l) {
        return (byte) ((int) ((l << 56) >> 56));
    }

    public static short long2short(long l) {
        return (short) ((int) ((l << 48) >> 48));
    }

    public static boolean single2boolean(float f) {
        return f != 0.0f;
    }

    public static byte single2byte(float f) {
        return (byte) ((int) ((((long) f) << 56) >> 56));
    }

    public static short single2short(float f) {
        return (short) ((int) ((((long) f) << 48) >> 48));
    }

    public static boolean double2boolean(double d) {
        return d != 0.0d;
    }

    public static byte double2byte(double d) {
        return (byte) ((int) ((((long) d) << 56) >> 56));
    }

    public static short double2short(double d) {
        return (short) ((int) ((((long) d) << 48) >> 48));
    }

    public static boolean string2boolean(String s) {
        s = s.trim();
        if (s.equals("True")) {
            return true;
        }
        if (s.equals("False")) {
            return false;
        }
        if (string2double(s) == 0.0d) {
            return false;
        }
        return true;
    }

    public static byte string2byte(String s) {
        return double2byte(string2double(s));
    }

    public static short string2short(String s) {
        return double2short(string2double(s));
    }

    public static int string2integer(String s) {
        return (int) string2double(s);
    }

    public static long string2long(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            throw new ConversionError();
        }
    }

    public static float string2single(String s) {
        return (float) string2double(s);
    }

    public static double string2double(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            throw new ConversionError();
        }
    }
}
