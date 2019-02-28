package com.amap.api.p015a;

import android.content.Context;
import android.graphics.Point;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.amap.api.maps2d.model.LatLng;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: MapOverlayViewGroup */
/* renamed from: com.amap.api.a.az */
class az extends ViewGroup {
    /* renamed from: a */
    private af f691a;

    /* compiled from: MapOverlayViewGroup */
    /* renamed from: com.amap.api.a.az$a */
    public static class C0213a extends LayoutParams {
        /* renamed from: a */
        public int f686a;
        /* renamed from: b */
        public LatLng f687b;
        /* renamed from: c */
        public int f688c;
        /* renamed from: d */
        public int f689d;
        /* renamed from: e */
        public int f690e;

        public C0213a(int i, int i2, LatLng latLng, int i3, int i4, int i5) {
            super(i, i2);
            this.f686a = 1;
            this.f687b = null;
            this.f688c = 0;
            this.f689d = 0;
            this.f690e = 51;
            this.f686a = 0;
            this.f687b = latLng;
            this.f688c = i3;
            this.f689d = i4;
            this.f690e = i5;
        }

        public C0213a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f686a = 1;
            this.f687b = null;
            this.f688c = 0;
            this.f689d = 0;
            this.f690e = 51;
        }

        public C0213a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f686a = 1;
            this.f687b = null;
            this.f688c = 0;
            this.f689d = 0;
            this.f690e = 51;
        }
    }

    public az(Context context, af afVar) {
        super(context);
        this.f691a = afVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                if (childAt.getLayoutParams() instanceof C0213a) {
                    C0213a c0213a = (C0213a) childAt.getLayoutParams();
                    if (c0213a.f686a == 0) {
                        m1132b(childAt, c0213a);
                    } else {
                        m1130a(childAt, c0213a);
                    }
                } else {
                    m1130a(childAt, new C0213a(childAt.getLayoutParams()));
                }
            }
        }
    }

    /* renamed from: a */
    public void m1133a() {
        onLayout(false, 0, 0, 0, 0);
    }

    /* renamed from: a */
    private void m1130a(View view, C0213a c0213a) {
        int[] iArr = new int[2];
        m1129a(view, c0213a.width, c0213a.height, iArr);
        m1128a(view, iArr[0], iArr[1], c0213a.f688c, c0213a.f689d, c0213a.f690e);
    }

    /* renamed from: b */
    private void m1132b(View view, C0213a c0213a) {
        int[] iArr = new int[2];
        m1129a(view, c0213a.width, c0213a.height, iArr);
        if (view instanceof cg) {
            m1131a((cg) view, iArr, c0213a.f690e);
        } else if (view instanceof au) {
            m1128a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], c0213a.f690e);
        } else if (view instanceof C0267w) {
            m1128a(view, iArr[0], iArr[1], 0, 0, c0213a.f690e);
        } else if (c0213a.f687b != null) {
            Point a;
            try {
                a = this.f691a.mo144s().mo182a(new ac((int) (c0213a.f687b.latitude * 1000000.0d), (int) (c0213a.f687b.longitude * 1000000.0d)), null);
            } catch (RemoteException e) {
                e.printStackTrace();
                a = null;
            }
            if (a != null) {
                a.x += c0213a.f688c;
                a.y += c0213a.f689d;
                m1128a(view, iArr[0], iArr[1], a.x, a.y, c0213a.f690e);
            }
        }
    }

    /* renamed from: a */
    private void m1131a(cg cgVar, int[] iArr, int i) {
        int b = cgVar.m1633b();
        if (b == 1) {
            m1128a(cgVar, iArr[0], iArr[1], getWidth() - iArr[0], (getHeight() + iArr[1]) / 2, i);
        } else if (b == 0) {
            m1128a(cgVar, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), i);
        }
    }

    /* renamed from: a */
    private void m1129a(View view, int i, int i2, int[] iArr) {
        if (view instanceof ListView) {
            View view2 = (View) view.getParent();
            if (view2 != null) {
                iArr[0] = view2.getWidth();
                iArr[1] = view2.getHeight();
            }
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    /* renamed from: a */
    private void m1128a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 & 7;
        int i7 = i5 & ErrorCode.DOWNLOAD_OVER_FLOW;
        if (i6 == 5) {
            i3 -= i;
        } else if (i6 == 1) {
            i3 -= i / 2;
        }
        if (i7 == 80) {
            i4 -= i2;
        } else if (i7 == 16) {
            i4 -= i2 / 2;
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
    }
}
