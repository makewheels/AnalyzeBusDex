package com.e4a.runtime.components.impl.android.n18;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.VisibleComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n18.列表框 */
public interface C0714 extends VisibleComponent {
    @SimpleFunction
    /* renamed from: 删除项目 */
    void mo984(int i);

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 加载超文本 */
    void mo985(boolean z);

    @SimpleProperty
    /* renamed from: 加载超文本 */
    boolean mo986();

    @SimpleFunction
    /* renamed from: 取项目内容 */
    String mo987(int i);

    @SimpleFunction
    /* renamed from: 取项目数 */
    int mo988();

    @SimpleFunction
    /* renamed from: 取项目标记 */
    String mo989(int i);

    @SimpleProperty
    /* renamed from: 字体大小 */
    float mo990();

    @SimpleProperty(initializer = "9", type = "simple.single")
    /* renamed from: 字体大小 */
    void mo991(float f);

    @SimpleProperty
    /* renamed from: 字体颜色 */
    int mo992();

    @SimpleProperty(initializer = "-1", type = "simple.color")
    /* renamed from: 字体颜色 */
    void mo993(int i);

    @SimpleFunction
    /* renamed from: 插入项目 */
    void mo994(int i, String str);

    @SimpleFunction
    /* renamed from: 添加项目 */
    void mo995(String str);

    @SimpleFunction
    /* renamed from: 清空项目 */
    void mo996();

    @SimpleFunction
    /* renamed from: 绑定弹出菜单 */
    void mo793();

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 缩略内容 */
    void mo997(boolean z);

    @SimpleProperty
    /* renamed from: 缩略内容 */
    boolean mo998();

    @SimpleFunction
    /* renamed from: 置现行选中项 */
    void mo999(int i);

    @SimpleFunction
    /* renamed from: 置项目内容 */
    void mo1000(int i, String str);

    @SimpleFunction
    /* renamed from: 置项目对齐方式 */
    void mo1001(int i);

    @SimpleFunction
    /* renamed from: 置项目标记 */
    void mo1002(int i, String str);

    @SimpleProperty
    /* renamed from: 背景图片 */
    String mo1003();

    @SimpleProperty(initializer = "\"\"", type = "simple.asset")
    /* renamed from: 背景图片 */
    void mo1004(String str);

    @SimpleProperty
    /* renamed from: 背景图片2 */
    int mo10052();

    @SimpleProperty
    /* renamed from: 背景图片2 */
    void mo10062(int i);

    @SimpleFunction
    /* renamed from: 自动拉伸高度 */
    void mo1007(boolean z);

    @SimpleEvent
    /* renamed from: 表项被单击 */
    void mo1008(int i);

    @SimpleEvent
    /* renamed from: 表项被滚动 */
    void mo1009(int i, int i2, int i3);

    @SimpleEvent
    /* renamed from: 表项被长按 */
    void mo1010(int i);
}
