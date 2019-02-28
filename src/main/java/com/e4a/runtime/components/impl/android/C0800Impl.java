package com.e4a.runtime.components.impl.android;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0799;

/* renamed from: com.e4a.runtime.components.impl.android.单帧布局Impl */
public class C0800Impl extends LayoutImpl implements C0799 {
    C0800Impl(ViewComponentContainer container) {
        super(new FrameLayout(mainActivity.getContext()), container);
    }

    public void addComponent(ViewComponent component) {
        getLayoutManager().addView(component.getView(), new LayoutParams(component.mo779(), component.mo805()));
    }
}
