package com.e4a.runtime.components.impl.android;

import android.view.ViewGroup;
import com.e4a.runtime.components.Layout;

public abstract class LayoutImpl implements Layout {
    private final ViewComponentContainer container;
    private final ViewGroup layoutManager;

    public abstract void addComponent(ViewComponent viewComponent);

    LayoutImpl(ViewGroup layoutManager, ViewComponentContainer container) {
        this.layoutManager = layoutManager;
        this.container = container;
    }

    protected final ViewGroup getLayoutManager() {
        return this.layoutManager;
    }

    protected final ViewComponentContainer getContainer() {
        return this.container;
    }
}
