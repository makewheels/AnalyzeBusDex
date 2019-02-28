package com.e4a.runtime.components.impl.android.n2;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.TextComponent;
import com.e4a.runtime.parameters.BooleanReferenceParameter;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n2.编辑框 */
public interface C0717 extends TextComponent {
    @SimpleFunction
    /* renamed from: 全选 */
    void mo1011();

    @SimpleEvent
    /* renamed from: 内容被改变 */
    void mo1012(String str);

    @SimpleFunction
    /* renamed from: 删除文本 */
    void mo1013(int i, int i2);

    @SimpleFunction
    /* renamed from: 加入文本 */
    void mo1014(String str);

    @SimpleFunction
    /* renamed from: 加载超文本 */
    void mo1015(String str);

    @SimpleFunction
    /* renamed from: 加载超文本2 */
    void mo10162(String str);

    @SimpleFunction
    /* renamed from: 取光标位置 */
    int mo1017();

    @SimpleFunction
    /* renamed from: 取组件索引 */
    int mo1018();

    @SimpleProperty
    /* renamed from: 字体大小 */
    float mo1019();

    @SimpleProperty(initializer = "9", type = "simple.single")
    /* renamed from: 字体大小 */
    void mo1020(float f);

    @SimpleEvent
    /* renamed from: 按下某键 */
    void mo1021(int i, BooleanReferenceParameter booleanReferenceParameter);

    @SimpleProperty
    /* renamed from: 提示信息 */
    String mo1022();

    @SimpleProperty(initializer = "\"\"", type = "simple.string")
    /* renamed from: 提示信息 */
    void mo1023(String str);

    @SimpleFunction
    /* renamed from: 插入文本 */
    void mo1024(int i, String str);

    @SimpleFunction
    /* renamed from: 显示光标 */
    void mo1025();

    @SimpleFunction
    /* renamed from: 显示输入法 */
    void mo1026();

    @SimpleFunction
    /* renamed from: 监听被单击事件 */
    void mo1027();

    @SimpleFunction
    /* renamed from: 绑定事件 */
    void mo1028(C0797 c0797);

    @SimpleFunction
    /* renamed from: 置光标位置 */
    void mo1029(int i);

    @SimpleFunction
    /* renamed from: 置多行模式 */
    void mo1030(boolean z);

    @SimpleFunction
    /* renamed from: 置左侧图标 */
    void mo1031(String str, int i, int i2, int i3);

    @SimpleFunction
    /* renamed from: 置提示信息颜色 */
    void mo1032(int i);

    @SimpleFunction
    /* renamed from: 置组件索引 */
    void mo1033(int i);

    @SimpleProperty
    /* renamed from: 背景图片 */
    String mo1034();

    @SimpleProperty(initializer = "\"\"", type = "simple.asset")
    /* renamed from: 背景图片 */
    void mo1035(String str);

    @SimpleProperty
    /* renamed from: 背景图片2 */
    int mo10362();

    @SimpleProperty
    /* renamed from: 背景图片2 */
    void mo10372(int i);

    @SimpleFunction
    /* renamed from: 自定义字体 */
    void mo1038(String str);

    @SimpleEvent
    /* renamed from: 被单击 */
    void mo1039();

    @SimpleProperty
    /* renamed from: 输入方式 */
    int mo1040();

    @SimpleProperty(initializer = "1", type = "simple.integer")
    /* renamed from: 输入方式 */
    void mo1041(int i);

    @SimpleFunction
    /* renamed from: 选中文本 */
    void mo1042(int i, int i2);

    @SimpleFunction
    /* renamed from: 隐藏光标 */
    void mo1043();

    @SimpleFunction
    /* renamed from: 隐藏输入法 */
    void mo1044();
}
