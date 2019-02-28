package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.impl.android.ViewComponent;
import com.e4a.runtime.variants.Variant;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.面板 */
public interface C0642 extends VisibleComponent, ComponentContainer {
    @SimpleProperty
    /* renamed from: 布局 */
    Variant mo812();

    @SimpleProperty(initializer = "1", type = "simple.layout")
    /* renamed from: 布局 */
    void mo813(Variant variant);

    @SimpleFunction
    /* renamed from: 添加组件 */
    void mo814(ViewComponent viewComponent);

    @SimpleFunction
    /* renamed from: 清空组件 */
    void mo815();

    @SimpleProperty
    /* renamed from: 背景图片 */
    String mo816();

    @SimpleProperty(initializer = "\"\"", type = "simple.asset")
    /* renamed from: 背景图片 */
    void mo817(String str);

    @SimpleProperty
    /* renamed from: 背景图片2 */
    int mo8182();

    @SimpleProperty
    /* renamed from: 背景图片2 */
    void mo8192(int i);

    @SimpleProperty
    /* renamed from: 背景颜色 */
    int mo796();

    @SimpleProperty(initializer = "-16776961", type = "simple.color")
    /* renamed from: 背景颜色 */
    void mo797(int i);
}
