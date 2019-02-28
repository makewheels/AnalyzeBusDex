package com.e4a.runtime.components.impl.android;

import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0823;

/* renamed from: com.e4a.runtime.components.impl.android.线性布局Impl */
public class C0824Impl extends LayoutImpl implements C0823 {
    C0824Impl(ViewComponentContainer container) {
        super(new RadioGroup(mainActivity.getContext()), container);
        LinearLayout layoutManager = (LinearLayout) getLayoutManager();
        layoutManager.setWeightSum(1.0f);
        layoutManager.setBaselineAligned(false);
        mo1472(1);
    }

    /* renamed from: 方向 */
    public void mo1472(int newOrientation) {
        ((LinearLayout) getLayoutManager()).setOrientation(newOrientation == 0 ? 0 : 1);
    }

    public void addComponent(ViewComponent component) {
        getLayoutManager().addView(component.getView(), new LayoutParams(component.mo779(), component.mo805()));
    }

    /* renamed from: 取布局 */
    public LinearLayout m6568() {
        return (LinearLayout) getLayoutManager();
    }
}
