package com.amap.api.maps2d;

import com.amap.api.p015a.C0269x;
import com.amap.api.p015a.C0269x.C0268a;

public class AMapNativeRenderer {
    public static native void nativeDrawLineByTextureID(float[] fArr, int i, float f, int i2, float f2, float f3, float f4, float f5, float f6);

    static {
        try {
            if (C0269x.f1184e == C0268a.U116114) {
                System.loadLibrary("mapv3ex116114");
            } else {
                System.loadLibrary("mapv3ex");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
