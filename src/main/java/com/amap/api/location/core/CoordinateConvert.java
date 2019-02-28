package com.amap.api.location.core;

import com.aps.C0584u;

public class CoordinateConvert {
    public static GeoPoint fromGpsToAMap(double d, double d2) {
        try {
            double[] a = C0584u.m4585a(d2, d);
            return new GeoPoint((int) (a[1] * 1000000.0d), (int) (a[0] * 1000000.0d));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static double[] fromSeveralGpsToAMap(String str) {
        try {
            String[] split = str.split(",");
            int length = split.length;
            double[] dArr = new double[length];
            for (int i = 0; i < length / 2; i++) {
                double[] a = C0584u.m4585a(Double.parseDouble(split[i * 2]), Double.parseDouble(split[(i * 2) + 1]));
                dArr[i * 2] = a[0];
                dArr[(i * 2) + 1] = a[1];
            }
            return dArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static double[] fromSeveralGpsToAMap(double[] dArr) {
        try {
            int length = dArr.length;
            double[] dArr2 = new double[length];
            for (int i = 0; i < length / 2; i++) {
                double[] a = C0584u.m4585a(dArr[i * 2], dArr[(i * 2) + 1]);
                dArr2[i * 2] = a[0];
                dArr2[(i * 2) + 1] = a[1];
            }
            return dArr2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
