package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.impl.android.ViewComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.垂直滚动框 */
public interface C0806 extends VisibleComponent, ComponentContainer {
    @SimpleFunction
    /* renamed from: 取最大滚动位置 */
    int mo1437();

    @SimpleFunction
    /* renamed from: 显示滚动条 */
    void mo1438();

    @SimpleFunction
    /* renamed from: 添加组件 */
    void mo1439(ViewComponent viewComponent);

    @SimpleFunction
    /* renamed from: 清空组件 */
    void mo1440();

    @SimpleFunction
    /* renamed from: 滚动 */
    void mo1441(int i);

    @SimpleFunction
    /* renamed from: 滚动到底部 */
    void mo1442();

    @SimpleFunction
    /* renamed from: 滚动到顶部 */
    void mo1443();

    @SimpleEvent
    /* renamed from: 被滚动 */
    void mo1444(int i, boolean z);

    @SimpleFunction
    /* renamed from: 隐藏滚动条 */
    void mo1445();
}
