package com.amap.api.maps2d.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.amap.api.p015a.ao.C0207a;
import com.amap.api.p015a.aw;
import java.io.InputStream;
import p054u.aly.bi_常量类;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;

    public static BitmapDescriptor fromResource(int i) {
        BitmapDescriptor bitmapDescriptor = null;
        try {
            Context context = aw.f673a;
            if (context != null) {
                bitmapDescriptor = fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i)));
            }
        } catch (Exception e) {
        }
        return bitmapDescriptor;
    }

    public static BitmapDescriptor fromView(View view) {
        BitmapDescriptor bitmapDescriptor = null;
        try {
            Context context = aw.f673a;
            if (context != null) {
                View frameLayout = new FrameLayout(context);
                frameLayout.addView(view);
                frameLayout.destroyDrawingCache();
                bitmapDescriptor = fromBitmap(m3784a(frameLayout));
            }
        } catch (Exception e) {
        }
        return bitmapDescriptor;
    }

    /* renamed from: a */
    private static Bitmap m3784a(View view) {
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache().copy(Config.ARGB_8888, false);
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        BitmapDescriptor bitmapDescriptor = null;
        try {
            Context context = aw.f673a;
            if (context != null) {
                InputStream openFileInput = context.openFileInput(str);
                Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
                openFileInput.close();
                bitmapDescriptor = fromBitmap(decodeStream);
            }
        } catch (Exception e) {
        }
        return bitmapDescriptor;
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(C0207a.marker_default.name() + ".png");
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor defaultMarker(float f) {
        try {
            float f2;
            float f3 = (float) ((((int) (15.0f + f)) / 30) * 30);
            if (f3 > 330.0f) {
                f2 = 330.0f;
            } else if (f3 < 0.0f) {
                f2 = 0.0f;
            } else {
                f2 = f3;
            }
            String str = bi_常量类.f6358b_空串;
            if (f2 == 0.0f) {
                str = "RED";
            } else if (f2 == 30.0f) {
                str = "ORANGE";
            } else if (f2 == 60.0f) {
                str = "YELLOW";
            } else if (f2 == 120.0f) {
                str = "GREEN";
            } else if (f2 == 180.0f) {
                str = "CYAN";
            } else if (f2 == 210.0f) {
                str = "AZURE";
            } else if (f2 == 240.0f) {
                str = "BLUE";
            } else if (f2 == 270.0f) {
                str = "VIOLET";
            } else if (f2 == 300.0f) {
                str = "MAGENTAV";
            } else if (f2 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + ".png");
        } catch (Exception e) {
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDescriptor(bitmap);
    }
}
