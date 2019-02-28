package com.amap.api.maps2d;

import com.amap.api.maps2d.model.LatLng;

public class AMapUtils {
    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        double d = latLng.longitude;
        double d2 = latLng.latitude;
        d *= 0.01745329251994329d;
        d2 *= 0.01745329251994329d;
        double d3 = latLng2.longitude * 0.01745329251994329d;
        double d4 = latLng2.latitude * 0.01745329251994329d;
        double sin = Math.sin(d);
        double sin2 = Math.sin(d2);
        d = Math.cos(d);
        d2 = Math.cos(d2);
        double sin3 = Math.sin(d3);
        double sin4 = Math.sin(d4);
        d3 = Math.cos(d3);
        d4 = Math.cos(d4);
        r17 = new double[3];
        double[] dArr = new double[]{d * d2, d2 * sin, sin2};
        dArr[0] = d4 * d3;
        dArr[1] = d4 * sin3;
        dArr[2] = sin4;
        return (float) (Math.asin(Math.sqrt((((r17[0] - dArr[0]) * (r17[0] - dArr[0])) + ((r17[1] - dArr[1]) * (r17[1] - dArr[1]))) + ((r17[2] - dArr[2]) * (r17[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d);
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        double sin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
        double d = (latLng2.longitude - latLng.longitude) / 360.0d;
        if (d < 0.0d) {
            d += 1.0d;
        }
        return (float) (d * ((6378137.0d * (6.283185307179586d * 6378137.0d)) * sin));
    }
}
