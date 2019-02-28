package com.e4a.runtime.components.impl.android;

import android.view.ViewGroup;
import com.e4a.runtime.components.ComponentContainer;

public interface ViewComponentContainer extends ComponentContainer {
    ViewGroup getLayoutManager();
}
