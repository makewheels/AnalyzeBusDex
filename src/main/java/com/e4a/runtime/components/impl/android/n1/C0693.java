package com.e4a.runtime.components.impl.android.n1;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.TextComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n1.按钮 */
public interface C0693 extends TextComponent {
    @SimpleFunction
    /* renamed from: 取组件索引 */
    int mo900();

    @SimpleProperty
    /* renamed from: 图片 */
    String mo901();

    @SimpleProperty
    /* renamed from: 图片 */
    void mo902(String str);

    @SimpleProperty
    /* renamed from: 图片2 */
    int mo9032();

    @SimpleProperty
    /* renamed from: 图片2 */
    void mo9042(int i);

    @SimpleProperty
    /* renamed from: 字体大小 */
    float mo905();

    @SimpleProperty(initializer = "9", type = "simple.single")
    /* renamed from: 字体大小 */
    void mo906(float f);

    @SimpleProperty
    /* renamed from: 弹起图片 */
    String mo907();

    @SimpleProperty
    /* renamed from: 弹起图片 */
    void mo908(String str);

    @SimpleProperty
    /* renamed from: 弹起图片2 */
    int mo9092();

    @SimpleProperty
    /* renamed from: 弹起图片2 */
    void mo9102(int i);

    @SimpleProperty
    /* renamed from: 按下图片 */
    String mo911();

    @SimpleProperty
    /* renamed from: 按下图片 */
    void mo912(String str);

    @SimpleProperty
    /* renamed from: 按下图片2 */
    int mo9132();

    @SimpleProperty
    /* renamed from: 按下图片2 */
    void mo9142(int i);

    @SimpleFunction
    /* renamed from: 绑定事件 */
    void mo915(C0797 c0797);

    @SimpleFunction
    /* renamed from: 置组件索引 */
    void mo916(int i);

    @SimpleFunction
    /* renamed from: 自定义字体 */
    void mo917(String str);

    @SimpleEvent
    /* renamed from: 被单击 */
    void mo918();

    @SimpleEvent
    /* renamed from: 被弹起 */
    void mo919(int i, int i2);

    @SimpleEvent
    /* renamed from: 被按下 */
    void mo920(int i, int i2);

    @SimpleEvent
    /* renamed from: 被移动 */
    void mo921(int i, int i2, int i3, int i4);

    @SimpleEvent
    /* renamed from: 被长按 */
    void mo922();

    @SimpleEvent
    /* renamed from: 触摸手势 */
    void mo923(int i);
}
