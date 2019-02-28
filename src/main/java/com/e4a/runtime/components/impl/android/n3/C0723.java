package com.e4a.runtime.components.impl.android.n3;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.TextComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n3.标签 */
public interface C0723 extends TextComponent {
    @SimpleFunction
    /* renamed from: 加载超文本 */
    void mo1045(String str);

    @SimpleFunction
    /* renamed from: 加载超文本2 */
    void mo10462(String str);

    @SimpleFunction
    /* renamed from: 取组件索引 */
    int mo1047();

    @SimpleProperty
    /* renamed from: 字体大小 */
    float mo1048();

    @SimpleProperty(initializer = "9", type = "simple.single")
    /* renamed from: 字体大小 */
    void mo1049(float f);

    @SimpleFunction
    /* renamed from: 添加删除线 */
    void mo1050();

    @SimpleFunction
    /* renamed from: 添加滚动条 */
    void mo1051();

    @SimpleFunction
    /* renamed from: 绑定事件 */
    void mo1052(C0797 c0797);

    @SimpleFunction
    /* renamed from: 置组件索引 */
    void mo1053(int i);

    @SimpleFunction
    /* renamed from: 置背景图片 */
    void mo1054(int i);

    @SimpleFunction
    /* renamed from: 自定义字体 */
    void mo1055(String str);

    @SimpleEvent
    /* renamed from: 被单击 */
    void mo1056();

    @SimpleEvent
    /* renamed from: 被长按 */
    void mo1057();
}
