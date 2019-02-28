package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.support.v4.util.LongSparseArray;
import android.util.Log;
import com.amap.api.mapcore.util.C0387h;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(f2288a, f2289b);
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    /* renamed from: a */
    private static final int[] f2288a = new int[]{Color.rgb(102, 225, 0), Color.rgb(WebView.NORMAL_MODE_ALPHA, 0, 0)};
    /* renamed from: b */
    private static final float[] f2289b = new float[]{0.2f, 1.0f};
    /* renamed from: c */
    private C0416a f2290c;
    /* renamed from: d */
    private Collection<WeightedLatLng> f2291d;
    /* renamed from: e */
    private C0387h f2292e;
    /* renamed from: f */
    private int f2293f;
    /* renamed from: g */
    private Gradient f2294g;
    /* renamed from: h */
    private int[] f2295h;
    /* renamed from: i */
    private double[] f2296i;
    /* renamed from: j */
    private double f2297j;
    /* renamed from: k */
    private double[] f2298k;

    public static class Builder {
        /* renamed from: a */
        private Collection<WeightedLatLng> f2284a;
        /* renamed from: b */
        private int f2285b = 12;
        /* renamed from: c */
        private Gradient f2286c = HeatmapTileProvider.DEFAULT_GRADIENT;
        /* renamed from: d */
        private double f2287d = 0.6d;

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.m3566d(collection));
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.f2284a = collection;
            return this;
        }

        public Builder radius(int i) {
            this.f2285b = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder gradient(Gradient gradient) {
            this.f2286c = gradient;
            return this;
        }

        public Builder transparency(double d) {
            this.f2287d = Math.max(0.0d, Math.min(d, 1.0d));
            return this;
        }

        public HeatmapTileProvider build() {
            if (this.f2284a != null && this.f2284a.size() != 0) {
                return new HeatmapTileProvider();
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e) {
                Log.e("amap", e.getErrorMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    private HeatmapTileProvider(Builder builder) {
        this.f2291d = builder.f2284a;
        this.f2293f = builder.f2285b;
        this.f2294g = builder.f2286c;
        if (this.f2294g == null || !this.f2294g.isAvailable()) {
            this.f2294g = DEFAULT_GRADIENT;
        }
        this.f2297j = builder.f2287d;
        this.f2296i = m3562a(this.f2293f, ((double) this.f2293f) / 3.0d);
        m3560a(this.f2294g);
        m3565c(this.f2291d);
    }

    /* renamed from: c */
    private void m3565c(Collection<WeightedLatLng> collection) {
        Collection arrayList = new ArrayList();
        for (WeightedLatLng weightedLatLng : collection) {
            if (weightedLatLng.latLng.latitude < 85.0d && weightedLatLng.latLng.latitude > -85.0d) {
                arrayList.add(weightedLatLng);
            }
        }
        this.f2291d = arrayList;
        this.f2292e = m3558a(this.f2291d);
        this.f2290c = new C0416a(this.f2292e);
        for (WeightedLatLng weightedLatLng2 : this.f2291d) {
            this.f2290c.m3587a(weightedLatLng2);
        }
        this.f2298k = m3561a(this.f2293f);
    }

    /* renamed from: d */
    private static Collection<WeightedLatLng> m3566d(Collection<LatLng> collection) {
        Collection arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    public Tile getTile(int i, int i2, int i3) {
        double d;
        double pow = 1.0d / Math.pow(2.0d, (double) i3);
        double d2 = (((double) this.f2293f) * pow) / 256.0d;
        double d3 = ((2.0d * d2) + pow) / ((double) ((this.f2293f * 2) + 256));
        double d4 = (((double) i) * pow) - d2;
        double d5 = (((double) (i + 1)) * pow) + d2;
        double d6 = (((double) i2) * pow) - d2;
        double d7 = (pow * ((double) (i2 + 1))) + d2;
        ArrayList arrayList = new ArrayList();
        Collection a;
        if (d4 < 0.0d) {
            a = this.f2290c.m3586a(new C0387h(1.0d + d4, 1.0d, d6, d7));
            d = -1.0d;
        } else if (d5 > 1.0d) {
            a = this.f2290c.m3586a(new C0387h(0.0d, d5 - 1.0d, d6, d7));
            d = 1.0d;
        } else {
            Object obj = arrayList;
            d = 0.0d;
        }
        C0387h c0387h = new C0387h(d4, d5, d6, d7);
        if (!c0387h.m3328a(new C0387h(this.f2292e.f2128a - d2, this.f2292e.f2130c + d2, this.f2292e.f2129b - d2, d2 + this.f2292e.f2131d))) {
            return TileProvider.NO_TILE;
        }
        Collection<WeightedLatLng> a2 = this.f2290c.m3586a(c0387h);
        if (a2.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, new int[]{(this.f2293f * 2) + 256, (this.f2293f * 2) + 256});
        for (WeightedLatLng weightedLatLng : a2) {
            DPoint point = weightedLatLng.getPoint();
            int i4 = (int) ((point.f3635x - d4) / d3);
            int i5 = (int) ((point.f3636y - d6) / d3);
            double[] dArr2 = dArr[i4];
            dArr2[i5] = dArr2[i5] + weightedLatLng.intensity;
        }
        for (WeightedLatLng weightedLatLng2 : r17) {
            point = weightedLatLng2.getPoint();
            i4 = (int) (((point.f3635x + d) - d4) / d3);
            i5 = (int) ((point.f3636y - d6) / d3);
            dArr2 = dArr[i4];
            dArr2[i5] = dArr2[i5] + weightedLatLng2.intensity;
        }
        return m3559a(m3557a(m3563a(dArr, this.f2296i), this.f2295h, this.f2298k[i3]));
    }

    /* renamed from: a */
    private void m3560a(Gradient gradient) {
        this.f2294g = gradient;
        this.f2295h = gradient.generateColorMap(this.f2297j);
    }

    /* renamed from: a */
    private double[] m3561a(int i) {
        int i2 = 11;
        double[] dArr = new double[21];
        for (int i3 = 5; i3 < 11; i3++) {
            dArr[i3] = m3556a(this.f2291d, this.f2292e, i, (int) (1280.0d * Math.pow(2.0d, (double) i3)));
            if (i3 == 5) {
                for (int i4 = 0; i4 < i3; i4++) {
                    dArr[i4] = dArr[i3];
                }
            }
        }
        while (i2 < 21) {
            dArr[i2] = dArr[10];
            i2++;
        }
        return dArr;
    }

    /* renamed from: a */
    private static Tile m3559a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return new Tile(256, 256, byteArrayOutputStream.toByteArray());
    }

    /* renamed from: a */
    static C0387h m3558a(Collection<WeightedLatLng> collection) {
        Iterator it = collection.iterator();
        WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
        double d = weightedLatLng.getPoint().f3635x;
        double d2 = weightedLatLng.getPoint().f3635x;
        double d3 = weightedLatLng.getPoint().f3636y;
        double d4 = weightedLatLng.getPoint().f3636y;
        while (it.hasNext()) {
            weightedLatLng = (WeightedLatLng) it.next();
            double d5 = weightedLatLng.getPoint().f3635x;
            double d6 = weightedLatLng.getPoint().f3636y;
            if (d5 < d) {
                d = d5;
            }
            if (d5 > d2) {
                d2 = d5;
            }
            if (d6 < d3) {
                d3 = d6;
            }
            if (d6 > d4) {
                d4 = d6;
            }
        }
        return new C0387h(d, d2, d3, d4);
    }

    /* renamed from: a */
    static double[] m3562a(int i, double d) {
        double[] dArr = new double[((i * 2) + 1)];
        for (int i2 = -i; i2 <= i; i2++) {
            dArr[i2 + i] = Math.exp(((double) ((-i2) * i2)) / ((2.0d * d) * d));
        }
        return dArr;
    }

    /* renamed from: a */
    static double[][] m3563a(double[][] dArr, double[] dArr2) {
        int floor = (int) Math.floor(((double) dArr2.length) / 2.0d);
        int length = dArr.length;
        int i = length - (floor * 2);
        int i2 = (floor + i) - 1;
        double[][] dArr3 = (double[][]) Array.newInstance(Double.TYPE, new int[]{length, length});
        int i3 = 0;
        while (i3 < length) {
            int i4;
            for (i4 = 0; i4 < length; i4++) {
                int i5;
                double d = dArr[i3][i4];
                if (d != 0.0d) {
                    i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    int i6 = floor > i3 - floor ? floor : i3 - floor;
                    while (i6 < i5) {
                        double[] dArr4 = dArr3[i6];
                        dArr4[i4] = dArr4[i4] + (dArr2[i6 - (i3 - floor)] * d);
                        i6++;
                    }
                }
            }
            i3++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance(Double.TYPE, new int[]{i, i});
        for (i = floor; i < i2 + 1; i++) {
            i3 = 0;
            while (i3 < length) {
                d = dArr3[i][i3];
                if (d != 0.0d) {
                    i5 = (i2 < i3 + floor ? i2 : i3 + floor) + 1;
                    i4 = floor > i3 - floor ? floor : i3 - floor;
                    while (i4 < i5) {
                        dArr4 = dArr5[i - floor];
                        int i7 = i4 - floor;
                        dArr4[i7] = dArr4[i7] + (dArr2[i4 - (i3 - floor)] * d);
                        i4++;
                    }
                }
                i3++;
            }
        }
        return dArr5;
    }

    /* renamed from: a */
    static Bitmap m3557a(double[][] dArr, int[] iArr, double d) {
        int i = iArr[iArr.length - 1];
        double length = ((double) (iArr.length - 1)) / d;
        int length2 = dArr.length;
        int[] iArr2 = new int[(length2 * length2)];
        for (int i2 = 0; i2 < length2; i2++) {
            for (int i3 = 0; i3 < length2; i3++) {
                double d2 = dArr[i3][i2];
                int i4 = (i2 * length2) + i3;
                int i5 = (int) (d2 * length);
                if (d2 == 0.0d) {
                    iArr2[i4] = 0;
                } else if (i5 < iArr.length) {
                    iArr2[i4] = iArr[i5];
                } else {
                    iArr2[i4] = i;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    /* renamed from: a */
    static double m3556a(Collection<WeightedLatLng> collection, C0387h c0387h, int i, int i2) {
        double d = c0387h.f2128a;
        double d2 = c0387h.f2130c;
        double d3 = c0387h.f2129b;
        double d4 = c0387h.f2131d;
        double d5 = ((double) ((int) (((double) (i2 / (i * 2))) + 0.5d))) / (d2 - d > d4 - d3 ? d2 - d : d4 - d3);
        LongSparseArray longSparseArray = new LongSparseArray();
        d4 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            LongSparseArray longSparseArray2;
            int i3 = (int) ((weightedLatLng.getPoint().f3635x - d) * d5);
            int i4 = (int) ((weightedLatLng.getPoint().f3636y - d3) * d5);
            LongSparseArray longSparseArray3 = (LongSparseArray) longSparseArray.get((long) i3);
            if (longSparseArray3 == null) {
                longSparseArray3 = new LongSparseArray();
                longSparseArray.put((long) i3, longSparseArray3);
                longSparseArray2 = longSparseArray3;
            } else {
                longSparseArray2 = longSparseArray3;
            }
            Double d6 = (Double) longSparseArray2.get((long) i4);
            if (d6 == null) {
                d6 = Double.valueOf(0.0d);
            }
            Double valueOf = Double.valueOf(weightedLatLng.intensity + d6.doubleValue());
            longSparseArray2.put((long) i4, valueOf);
            if (valueOf.doubleValue() > d4) {
                d2 = valueOf.doubleValue();
            } else {
                d2 = d4;
            }
            d4 = d2;
        }
        return d4;
    }

    public int getTileHeight() {
        return 256;
    }

    public int getTileWidth() {
        return 256;
    }
}
