package com.e4a.runtime.components.impl.android;

import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.C0825;

/* renamed from: com.e4a.runtime.components.impl.android.绝对布局Impl */
public class C0826Impl extends LayoutImpl implements C0825 {
    C0826Impl(ViewComponentContainer container) {
        super(new AbsoluteLayout(mainActivity.getContext()), container);
    }

    public void addComponent(ViewComponent component) {
        getLayoutManager().addView(component.getView(), new LayoutParams(-2, -2, component.mo781(), component.mo803()));
    }

    void placeComponent(ViewComponent component) {
        component.getView().setLayoutParams(new LayoutParams(component.mo779(), component.mo805(), component.mo781(), component.mo803()));
    }

    public void removeComponent(ViewComponent component) {
        getLayoutManager().removeView(component.getView());
    }
}
