package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;

@SimpleObject
public interface TextComponent extends VisibleComponent {
    @SimpleProperty
    int FontTypeface();

    @SimpleProperty(initializer = "0", type = "simple.typeface")
    void FontTypeface(int i);

    @SimpleProperty
    /* renamed from: 内容 */
    String mo886();

    @SimpleProperty(initializer = "\"\"", type = "simple.string")
    /* renamed from: 内容 */
    void mo887(String str);

    @SimpleProperty
    /* renamed from: 字体颜色 */
    int mo888();

    @SimpleProperty(initializer = "-16777216", type = "simple.color")
    /* renamed from: 字体颜色 */
    void mo889(int i);

    @SimpleProperty
    /* renamed from: 对齐方式 */
    int mo890();

    @SimpleProperty(initializer = "0", type = "simple.justification")
    /* renamed from: 对齐方式 */
    void mo891(int i);

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 斜体 */
    void mo892(boolean z);

    @SimpleProperty
    /* renamed from: 斜体 */
    boolean mo893();

    @SimpleProperty
    /* renamed from: 标题 */
    String mo894();

    @SimpleProperty(initializer = "\"\"", type = "simple.string")
    /* renamed from: 标题 */
    void mo895(String str);

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 粗体 */
    void mo896(boolean z);

    @SimpleProperty
    /* renamed from: 粗体 */
    boolean mo897();

    @SimpleProperty
    /* renamed from: 透明度 */
    int mo898();

    @SimpleProperty(initializer = "255", type = "simple.integer")
    /* renamed from: 透明度 */
    void mo899(int i);
}
