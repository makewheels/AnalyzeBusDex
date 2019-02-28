package com.amap.api.mapcore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* compiled from: MapOverlayViewGroup */
class aq extends ViewGroup {
    /* renamed from: a */
    private C0313u f1352a;

    /* compiled from: MapOverlayViewGroup */
    /* renamed from: com.amap.api.mapcore.aq$a */
    public static class C0320a extends LayoutParams {
        /* renamed from: a */
        public FPoint f1497a = null;
        /* renamed from: b */
        public int f1498b = 0;
        /* renamed from: c */
        public int f1499c = 0;
        /* renamed from: d */
        public int f1500d = 51;

        public C0320a(int i, int i2, FPoint fPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.f1497a = fPoint;
            this.f1498b = i3;
            this.f1499c = i4;
            this.f1500d = i5;
        }

        public C0320a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0320a(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public aq(Context context) {
        super(context);
    }

    public aq(Context context, C0313u c0313u) {
        super(context);
        this.f1352a = c0313u;
        setBackgroundColor(-1);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                if (childAt.getLayoutParams() instanceof C0320a) {
                    m1984a(childAt, (C0320a) childAt.getLayoutParams());
                } else {
                    m1983a(childAt, childAt.getLayoutParams());
                }
            }
        }
    }

    /* renamed from: a */
    private void m1983a(View view, LayoutParams layoutParams) {
        int[] iArr = new int[2];
        m1982a(view, layoutParams.width, layoutParams.height, iArr);
        m1981a(view, iArr[0], iArr[1], 0, 0, 51);
    }

    /* renamed from: a */
    private void m1984a(View view, C0320a c0320a) {
        int[] iArr = new int[2];
        m1982a(view, c0320a.width, c0320a.height, iArr);
        if (view instanceof bj) {
            m1981a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), c0320a.f1500d);
        } else if (view instanceof aj) {
            m1981a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], c0320a.f1500d);
        } else if (view instanceof C0342m) {
            m1981a(view, iArr[0], iArr[1], 0, 0, c0320a.f1500d);
        } else if (c0320a.f1497a != null) {
            IPoint iPoint = new IPoint();
            this.f1352a.mo395c().map2Win(c0320a.f1497a.f3637x, c0320a.f1497a.f3638y, iPoint);
            iPoint.f3639x += c0320a.f1498b;
            iPoint.f3640y += c0320a.f1499c;
            m1981a(view, iArr[0], iArr[1], iPoint.f3639x, iPoint.f3640y, c0320a.f1500d);
            if (view.getVisibility() == 0) {
                mo320a();
            }
        }
    }

    /* renamed from: a */
    protected void mo320a() {
    }

    /* renamed from: a */
    private void m1982a(View view, int i, int i2, int[] iArr) {
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
    private void m1981a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6 = i5 & 7;
        int i7 = i5 & ErrorCode.DOWNLOAD_OVER_FLOW;
        if (i6 == 5) {
            i3 -= i;
        } else if (i6 == 1) {
            i3 -= i / 2;
        }
        if (i7 == 80) {
            i4 -= i2;
        } else if (i7 == 17) {
            i4 -= i2 / 2;
        } else if (i7 == 16) {
            i4 = (i4 / 2) - (i2 / 2);
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
    }
}
