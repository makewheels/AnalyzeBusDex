package com.e4a.runtime.components.impl;

import com.e4a.runtime.components.Component;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.events.EventDispatcher;

public abstract class ComponentImpl implements Component {
    private final ComponentContainer componentContainer;

    protected ComponentImpl(ComponentContainer container) {
        this.componentContainer = container;
    }

    protected ComponentContainer getComponentContainer() {
        return this.componentContainer;
    }

    /* renamed from: 创建完毕 */
    public void mo765() {
        EventDispatcher.dispatchEvent(this, "创建完毕", new Object[0]);
    }
}
