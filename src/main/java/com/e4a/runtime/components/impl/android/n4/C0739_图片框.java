package com.e4a.runtime.components.impl.android.n4;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.VisibleComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n4.图片框 */
public interface C0739_图片框 extends VisibleComponent {
    @SimpleFunction
    /* renamed from: 取组件索引 */
    int mo1137();

    @SimpleProperty
    /* renamed from: 图像 */
    String mo1138();

    @SimpleProperty(initializer = "\"\"", type = "simple.asset")
    /* renamed from: 图像 */
    void mo1139(String str);

    @SimpleProperty
    /* renamed from: 图像2 */
    int mo11402();

    @SimpleProperty
    /* renamed from: 图像2 */
    void mo11412(int i);

    @SimpleProperty
    /* renamed from: 显示方式 */
    int mo1142();

    @SimpleProperty(initializer = "1", type = "simple.integer")
    /* renamed from: 显示方式 */
    void mo1143(int i);

    @SimpleFunction
    /* renamed from: 绑定事件 */
    void mo1144(C0797 c0797);

    @SimpleFunction
    /* renamed from: 置组件索引 */
    void mo1145(int i);

    @SimpleEvent
    /* renamed from: 被单击 */
    void mo1146();

    @SimpleEvent
    /* renamed from: 被弹起 */
    void mo1147(int i, int i2);

    @SimpleEvent
    /* renamed from: 被按下 */
    void mo1148(int i, int i2);

    @SimpleEvent
    /* renamed from: 被移动 */
    void mo1149(int i, int i2, int i3, int i4);

    @SimpleEvent
    /* renamed from: 被长按 */
    void mo1150();

    @SimpleEvent
    /* renamed from: 触摸手势 */
    void mo1151(int i);

    @SimpleFunction
    /* renamed from: 载入字节图片 */
    void mo1152(byte[] bArr);

    @SimpleFunction
    /* renamed from: 载入超大图片 */
    void mo1153(String str, int i, int i2);
}
