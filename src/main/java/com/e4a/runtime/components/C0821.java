package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.impl.android.ViewComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.水平滚动框 */
public interface C0821 extends VisibleComponent {
    @SimpleFunction
    /* renamed from: 取最大滚动位置 */
    int mo1463();

    @SimpleFunction
    /* renamed from: 显示滚动条 */
    void mo1464();

    @SimpleFunction
    /* renamed from: 添加组件 */
    void mo1465(ViewComponent viewComponent);

    @SimpleFunction
    /* renamed from: 清空组件 */
    void mo1466();

    @SimpleFunction
    /* renamed from: 滚动 */
    void mo1467(int i);

    @SimpleFunction
    /* renamed from: 滚动到右边 */
    void mo1468();

    @SimpleFunction
    /* renamed from: 滚动到左边 */
    void mo1469();

    @SimpleEvent
    /* renamed from: 被滚动 */
    void mo1470(int i, boolean z);

    @SimpleFunction
    /* renamed from: 隐藏滚动条 */
    void mo1471();
}
