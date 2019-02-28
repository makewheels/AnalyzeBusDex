package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleObject
/* renamed from: com.e4a.runtime.坐标转换 */
public final class C0846 {
    /* renamed from: a */
    private static double f4332a = 6378245.0d;
    private static double ee = 0.006693421622965943d;
    private static double pi = 3.141592653589793d;
    private static double x_pi = 52.35987755982988d;

    private C0846() {
    }

    @SimpleFunction
    /* renamed from: 火星转百度 */
    public static double[] m6632(double 火星纬度, double 火星经度) {
        double x = 火星经度;
        double y = 火星纬度;
        double z = Math.sqrt((x * x) + (y * y)) + (2.0E-5d * Math.sin(x_pi * y));
        double theta = Math.atan2(y, x) + (3.0E-6d * Math.cos(x_pi * x));
        return new double[]{(Math.sin(theta) * z) + 0.006d, (Math.cos(theta) * z) + 0.0065d};
    }

    @SimpleFunction
    /* renamed from: 百度转火星 */
    public static double[] m6633(double 百度纬度, double 百度经度) {
        double x = 百度经度 - 0.0065d;
        double y = 百度纬度 - 0.006d;
        double z = Math.sqrt((x * x) + (y * y)) - (2.0E-5d * Math.sin(x_pi * y));
        double theta = Math.atan2(y, x) - (3.0E-6d * Math.cos(x_pi * x));
        return new double[]{Math.sin(theta) * z, Math.cos(theta) * z};
    }

    @SimpleFunction
    /* renamed from: 地球转火星 */
    public static double[] m6631(double wgLat, double wgLon) {
        double[] result = new double[2];
        if (C0846.outOfChina(wgLat, wgLon)) {
            result[0] = wgLat;
            result[1] = wgLon;
        } else {
            double dLat = C0846.transformLat(wgLon - 105.0d, wgLat - 35.0d);
            double dLon = C0846.transformLon(wgLon - 105.0d, wgLat - 35.0d);
            double radLat = (wgLat / 180.0d) * pi;
            double magic = Math.sin(radLat);
            magic = 1.0d - ((ee * magic) * magic);
            double sqrtMagic = Math.sqrt(magic);
            dLon = (180.0d * dLon) / (((f4332a / sqrtMagic) * Math.cos(radLat)) * pi);
            result[0] = wgLat + ((180.0d * dLat) / (((f4332a * (1.0d - ee)) / (magic * sqrtMagic)) * pi));
            result[1] = wgLon + dLon;
        }
        return result;
    }

    private static boolean outOfChina(double lat, double lon) {
        if (lon < 72.004d || lon > 137.8347d || lat < 0.8293d || lat > 55.8271d) {
            return true;
        }
        return false;
    }

    private static double transformLat(double x, double y) {
        return (((((((-100.0d + (2.0d * x)) + (3.0d * y)) + ((0.2d * y) * y)) + ((0.1d * x) * y)) + (0.2d * Math.sqrt(Math.abs(x)))) + ((((20.0d * Math.sin((6.0d * x) * pi)) + (20.0d * Math.sin((2.0d * x) * pi))) * 2.0d) / 3.0d)) + ((((20.0d * Math.sin(pi * y)) + (40.0d * Math.sin((y / 3.0d) * pi))) * 2.0d) / 3.0d)) + ((((160.0d * Math.sin((y / 12.0d) * pi)) + (320.0d * Math.sin((pi * y) / 30.0d))) * 2.0d) / 3.0d);
    }

    private static double transformLon(double x, double y) {
        return (((((((300.0d + x) + (2.0d * y)) + ((0.1d * x) * x)) + ((0.1d * x) * y)) + (0.1d * Math.sqrt(Math.abs(x)))) + ((((20.0d * Math.sin((6.0d * x) * pi)) + (20.0d * Math.sin((2.0d * x) * pi))) * 2.0d) / 3.0d)) + ((((20.0d * Math.sin(pi * x)) + (40.0d * Math.sin((x / 3.0d) * pi))) * 2.0d) / 3.0d)) + ((((150.0d * Math.sin((x / 12.0d) * pi)) + (300.0d * Math.sin((x / 30.0d) * pi))) * 2.0d) / 3.0d);
    }
}
