package com.e4a.runtime.components.impl.android.n30;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.VisibleComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n30.图片列表框 */
public interface C0726 extends VisibleComponent {
    @SimpleProperty
    /* renamed from: 列数 */
    int mo1062();

    @SimpleProperty(initializer = "3", type = "simple.integer")
    /* renamed from: 列数 */
    void mo1063(int i);

    @SimpleProperty
    /* renamed from: 列间距 */
    int mo1064();

    @SimpleProperty(initializer = "15", type = "simple.integer")
    /* renamed from: 列间距 */
    void mo1065(int i);

    @SimpleFunction
    /* renamed from: 初始化下载引擎 */
    void mo1066(int i, int i2, int i3, int i4, boolean z);

    @SimpleFunction
    /* renamed from: 删除项目 */
    void mo1067(int i);

    @SimpleProperty
    /* renamed from: 副标题字体大小 */
    float mo1068();

    @SimpleProperty(initializer = "9", type = "simple.single")
    /* renamed from: 副标题字体大小 */
    void mo1069(float f);

    @SimpleProperty
    /* renamed from: 副标题字体颜色 */
    int mo1070();

    @SimpleProperty(initializer = "-1", type = "simple.color")
    /* renamed from: 副标题字体颜色 */
    void mo1071(int i);

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 加载超文本 */
    void mo1072(boolean z);

    @SimpleProperty
    /* renamed from: 加载超文本 */
    boolean mo1073();

    @SimpleFunction
    /* renamed from: 取图片显示方式 */
    int mo1074();

    @SimpleFunction
    /* renamed from: 取项目副标题 */
    String mo1075(int i);

    @SimpleFunction
    /* renamed from: 取项目图片 */
    String mo1076(int i);

    @SimpleFunction
    /* renamed from: 取项目数 */
    int mo1077();

    @SimpleFunction
    /* renamed from: 取项目标记 */
    String mo1078(int i);

    @SimpleFunction
    /* renamed from: 取项目标题 */
    String mo1079(int i);

    @SimpleFunction
    /* renamed from: 取项目消息数 */
    int mo1080(int i);

    @SimpleEvent
    /* renamed from: 图片加载完毕 */
    void mo1081(boolean z, String str, byte[] bArr);

    @SimpleProperty
    /* renamed from: 图片外边距 */
    int mo1082();

    @SimpleProperty(initializer = "0", type = "simple.integer")
    /* renamed from: 图片外边距 */
    void mo1083(int i);

    @SimpleProperty
    /* renamed from: 图片宽度 */
    int mo1084();

    @SimpleProperty(initializer = "50", type = "simple.integer")
    /* renamed from: 图片宽度 */
    void mo1085(int i);

    @SimpleProperty
    /* renamed from: 图片高度 */
    int mo1086();

    @SimpleProperty(initializer = "50", type = "simple.integer")
    /* renamed from: 图片高度 */
    void mo1087(int i);

    @SimpleProperty
    /* renamed from: 字体大小 */
    float mo1088();

    @SimpleProperty(initializer = "9", type = "simple.single")
    /* renamed from: 字体大小 */
    void mo1089(float f);

    @SimpleProperty
    /* renamed from: 字体颜色 */
    int mo1090();

    @SimpleProperty(initializer = "-1", type = "simple.color")
    /* renamed from: 字体颜色 */
    void mo1091(int i);

    @SimpleFunction
    /* renamed from: 插入项目 */
    void mo1092(int i, String str, String str2);

    @SimpleFunction
    /* renamed from: 显示副标题 */
    void mo1093();

    @SimpleFunction
    /* renamed from: 显示标题 */
    void mo1094();

    @SimpleProperty
    /* renamed from: 标题背景颜色 */
    int mo1095();

    @SimpleProperty(initializer = "0", type = "simple.color")
    /* renamed from: 标题背景颜色 */
    void mo1096(int i);

    @SimpleFunction
    /* renamed from: 添加项目 */
    void mo1097(String str, String str2);

    @SimpleFunction
    /* renamed from: 清空下载缓存 */
    void mo1098();

    @SimpleFunction
    /* renamed from: 清空项目 */
    void mo1099();

    @SimpleFunction
    /* renamed from: 监听触摸手势 */
    void mo1100();

    @SimpleFunction
    /* renamed from: 绑定弹出菜单 */
    void mo793();

    @SimpleFunction
    /* renamed from: 置图片显示方式 */
    void mo1101(int i);

    @SimpleFunction
    /* renamed from: 置现行选中项 */
    void mo1102(int i);

    @SimpleFunction
    /* renamed from: 置项目副标题 */
    void mo1103(int i, String str);

    @SimpleFunction
    /* renamed from: 置项目图片 */
    void mo1104(int i, String str);

    @SimpleFunction
    /* renamed from: 置项目标记 */
    void mo1105(int i, String str);

    @SimpleFunction
    /* renamed from: 置项目标题 */
    void mo1106(int i, String str);

    @SimpleFunction
    /* renamed from: 置项目样式 */
    void mo1107(int i);

    @SimpleFunction
    /* renamed from: 置项目消息数 */
    void mo1108(int i, int i2);

    @SimpleProperty
    /* renamed from: 背景图片 */
    String mo1109();

    @SimpleProperty(initializer = "\"\"", type = "simple.asset")
    /* renamed from: 背景图片 */
    void mo1110(String str);

    @SimpleProperty
    /* renamed from: 背景图片2 */
    int mo11112();

    @SimpleProperty
    /* renamed from: 背景图片2 */
    void mo11122(int i);

    @SimpleFunction
    /* renamed from: 自动拉伸高度 */
    void mo1113(boolean z);

    @SimpleProperty
    /* renamed from: 行间距 */
    int mo1114();

    @SimpleProperty(initializer = "15", type = "simple.integer")
    /* renamed from: 行间距 */
    void mo1115(int i);

    @SimpleEvent
    /* renamed from: 表项被单击 */
    void mo1116(int i);

    @SimpleEvent
    /* renamed from: 表项被滚动 */
    void mo1117(int i, int i2, int i3);

    @SimpleEvent
    /* renamed from: 表项被长按 */
    void mo1118(int i);

    @SimpleEvent
    /* renamed from: 触摸手势 */
    void mo1119(int i);

    @SimpleFunction
    /* renamed from: 隐藏副标题 */
    void mo1120();

    @SimpleFunction
    /* renamed from: 隐藏标题 */
    void mo1121();
}
