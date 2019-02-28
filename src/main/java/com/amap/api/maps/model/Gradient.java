package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

public class Gradient {
    /* renamed from: a */
    private int f2267a;
    /* renamed from: b */
    private int[] f2268b;
    /* renamed from: c */
    private float[] f2269c;
    /* renamed from: d */
    private boolean f2270d;

    /* renamed from: com.amap.api.maps.model.Gradient$a */
    private class C0414a {
        /* renamed from: a */
        final /* synthetic */ Gradient f2263a;
        /* renamed from: b */
        private final int f2264b;
        /* renamed from: c */
        private final int f2265c;
        /* renamed from: d */
        private final float f2266d;

        private C0414a(Gradient gradient, int i, int i2, float f) {
            this.f2263a = gradient;
            this.f2264b = i;
            this.f2265c = i2;
            this.f2266d = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
        int i2 = 1;
        this.f2270d = true;
        if (iArr == null || fArr == null) {
            try {
                throw new AMapException("colors and startPoints should not be null");
            } catch (AMapException e) {
                this.f2270d = false;
                Log.e("amap", e.getErrorMessage());
                e.printStackTrace();
            }
        } else if (iArr.length != fArr.length) {
            throw new AMapException("colors and startPoints should be same length");
        } else if (iArr.length == 0) {
            throw new AMapException("No colors have been defined");
        } else {
            while (i2 < fArr.length) {
                if (fArr[i2] <= fArr[i2 - 1]) {
                    throw new AMapException("startPoints should be in increasing order");
                }
                i2++;
            }
            this.f2267a = i;
            this.f2268b = new int[iArr.length];
            this.f2269c = new float[fArr.length];
            System.arraycopy(iArr, 0, this.f2268b, 0, iArr.length);
            System.arraycopy(fArr, 0, this.f2269c, 0, fArr.length);
            this.f2270d = true;
        }
    }

    /* renamed from: a */
    private HashMap<Integer, C0414a> m3550a() {
        HashMap<Integer, C0414a> hashMap = new HashMap();
        if (this.f2269c[0] != 0.0f) {
            int argb = Color.argb(0, Color.red(this.f2268b[0]), Color.green(this.f2268b[0]), Color.blue(this.f2268b[0]));
            hashMap.put(Integer.valueOf(0), new C0414a(argb, this.f2268b[0], this.f2269c[0] * ((float) this.f2267a)));
        }
        for (int i = 1; i < this.f2268b.length; i++) {
            hashMap.put(Integer.valueOf((int) (((float) this.f2267a) * this.f2269c[i - 1])), new C0414a(this.f2268b[i - 1], this.f2268b[i], (this.f2269c[i] - this.f2269c[i - 1]) * ((float) this.f2267a)));
        }
        if (this.f2269c[this.f2269c.length - 1] != 1.0f) {
            int length = this.f2269c.length - 1;
            hashMap.put(Integer.valueOf((int) (((float) this.f2267a) * this.f2269c[length])), new C0414a(this.f2268b[length], this.f2268b[length], ((float) this.f2267a) * (1.0f - this.f2269c[length])));
        }
        return hashMap;
    }

    protected int[] generateColorMap(double d) {
        int i = 0;
        HashMap a = m3550a();
        int[] iArr = new int[this.f2267a];
        int i2 = 0;
        C0414a c0414a = (C0414a) a.get(Integer.valueOf(0));
        int i3 = 0;
        while (i2 < this.f2267a) {
            int i4;
            C0414a c0414a2;
            if (a.containsKey(Integer.valueOf(i2))) {
                i4 = i2;
                c0414a2 = (C0414a) a.get(Integer.valueOf(i2));
            } else {
                c0414a2 = c0414a;
                i4 = i3;
            }
            iArr[i2] = m3549a(c0414a2.f2264b, c0414a2.f2265c, ((float) (i2 - i4)) / c0414a2.f2266d);
            i2++;
            i3 = i4;
            c0414a = c0414a2;
        }
        if (d != 1.0d) {
            while (i < this.f2267a) {
                i3 = iArr[i];
                iArr[i] = Color.argb((int) (((double) Color.alpha(i3)) * d), Color.red(i3), Color.green(i3), Color.blue(i3));
                i++;
            }
        }
        return iArr;
    }

    /* renamed from: a */
    static int m3549a(int i, int i2, float f) {
        int i3 = 0;
        int alpha = (int) ((((float) (Color.alpha(i2) - Color.alpha(i))) * f) + ((float) Color.alpha(i)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        while (i3 < 3) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
            i3++;
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    protected boolean isAvailable() {
        return this.f2270d;
    }
}
