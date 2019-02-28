package com.e4a.runtime.components.impl.android.n56;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.VisibleComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n56.分组列表框 */
public interface C0757 extends VisibleComponent {
    @SimpleProperty
    /* renamed from: 分组信息字体大小 */
    float mo1181();

    @SimpleProperty(initializer = "6", type = "simple.single")
    /* renamed from: 分组信息字体大小 */
    void mo1182(float f);

    @SimpleProperty
    /* renamed from: 分组信息字体颜色 */
    int mo1183();

    @SimpleProperty(initializer = "-7829368", type = "simple.color")
    /* renamed from: 分组信息字体颜色 */
    void mo1184(int i);

    @SimpleProperty
    /* renamed from: 分组标题字体大小 */
    float mo1185();

    @SimpleProperty(initializer = "9", type = "simple.single")
    /* renamed from: 分组标题字体大小 */
    void mo1186(float f);

    @SimpleProperty
    /* renamed from: 分组标题字体颜色 */
    int mo1187();

    @SimpleProperty(initializer = "-16777216", type = "simple.color")
    /* renamed from: 分组标题字体颜色 */
    void mo1188(int i);

    @SimpleEvent
    /* renamed from: 分组被单击 */
    void mo1189(int i);

    @SimpleEvent
    /* renamed from: 分组被展开 */
    void mo1190(int i);

    @SimpleEvent
    /* renamed from: 分组被收起 */
    void mo1191(int i);

    @SimpleEvent
    /* renamed from: 分组被长按 */
    void mo1192(int i);

    @SimpleFunction
    /* renamed from: 初始化下载引擎 */
    void mo1193(int i, int i2, int i3, int i4, boolean z);

    @SimpleFunction
    /* renamed from: 删除分组 */
    void mo1194(int i);

    @SimpleFunction
    /* renamed from: 删除子项 */
    void mo1195(int i, int i2);

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 加载超文本 */
    void mo1196(boolean z);

    @SimpleProperty
    /* renamed from: 加载超文本 */
    boolean mo1197();

    @SimpleFunction
    /* renamed from: 取分组信息 */
    String mo1198(int i);

    @SimpleFunction
    /* renamed from: 取分组总数 */
    int mo1199();

    @SimpleFunction
    /* renamed from: 取分组标记 */
    String mo1200(int i);

    @SimpleFunction
    /* renamed from: 取分组标题 */
    String mo1201(int i);

    @SimpleFunction
    /* renamed from: 取分组状态 */
    boolean mo1202(int i);

    @SimpleFunction
    /* renamed from: 取子项信息 */
    String mo1203(int i, int i2);

    @SimpleFunction
    /* renamed from: 取子项图片 */
    String mo1204(int i, int i2);

    @SimpleFunction
    /* renamed from: 取子项总数 */
    int mo1205(int i);

    @SimpleFunction
    /* renamed from: 取子项按钮图片 */
    String mo1206(int i, int i2);

    @SimpleFunction
    /* renamed from: 取子项按钮标题 */
    String mo1207(int i, int i2);

    @SimpleFunction
    /* renamed from: 取子项标记 */
    String mo1208(int i, int i2);

    @SimpleFunction
    /* renamed from: 取子项标题 */
    String mo1209(int i, int i2);

    @SimpleFunction
    /* renamed from: 取子项选择框状态 */
    boolean mo1210(int i, int i2);

    @SimpleEvent
    /* renamed from: 图片加载完毕 */
    void mo1211(boolean z, String str, byte[] bArr);

    @SimpleProperty
    /* renamed from: 子项信息字体大小 */
    float mo1212();

    @SimpleProperty(initializer = "6", type = "simple.single")
    /* renamed from: 子项信息字体大小 */
    void mo1213(float f);

    @SimpleProperty
    /* renamed from: 子项信息字体颜色 */
    int mo1214();

    @SimpleProperty(initializer = "-7829368", type = "simple.color")
    /* renamed from: 子项信息字体颜色 */
    void mo1215(int i);

    @SimpleProperty
    /* renamed from: 子项图片宽度 */
    int mo1216();

    @SimpleProperty
    /* renamed from: 子项图片宽度 */
    void mo1217(int i);

    @SimpleProperty
    /* renamed from: 子项图片高度 */
    int mo1218();

    @SimpleProperty
    /* renamed from: 子项图片高度 */
    void mo1219(int i);

    @SimpleProperty
    /* renamed from: 子项按钮字体大小 */
    float mo1220();

    @SimpleProperty(initializer = "6", type = "simple.single")
    /* renamed from: 子项按钮字体大小 */
    void mo1221(float f);

    @SimpleProperty
    /* renamed from: 子项按钮字体颜色 */
    int mo1222();

    @SimpleProperty(initializer = "-16777216", type = "simple.color")
    /* renamed from: 子项按钮字体颜色 */
    void mo1223(int i);

    @SimpleProperty
    /* renamed from: 子项按钮宽度 */
    int mo1224();

    @SimpleProperty
    /* renamed from: 子项按钮宽度 */
    void mo1225(int i);

    @SimpleEvent
    /* renamed from: 子项按钮被单击 */
    void mo1226(int i, int i2);

    @SimpleProperty
    /* renamed from: 子项按钮高度 */
    int mo1227();

    @SimpleProperty
    /* renamed from: 子项按钮高度 */
    void mo1228(int i);

    @SimpleProperty
    /* renamed from: 子项标题字体大小 */
    float mo1229();

    @SimpleProperty(initializer = "9", type = "simple.single")
    /* renamed from: 子项标题字体大小 */
    void mo1230(float f);

    @SimpleProperty
    /* renamed from: 子项标题字体颜色 */
    int mo1231();

    @SimpleProperty(initializer = "-16777216", type = "simple.color")
    /* renamed from: 子项标题字体颜色 */
    void mo1232(int i);

    @SimpleEvent
    /* renamed from: 子项被单击 */
    void mo1233(int i, int i2);

    @SimpleEvent
    /* renamed from: 子项被长按 */
    void mo1234(int i, int i2);

    @SimpleEvent
    /* renamed from: 子项选择框被单击 */
    void mo1235(int i, int i2, boolean z);

    @SimpleFunction
    /* renamed from: 展开分组 */
    void mo1236(int i);

    @SimpleFunction
    /* renamed from: 收起分组 */
    void mo1237(int i);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 显示子项按钮 */
    void mo1238(boolean z);

    @SimpleProperty
    /* renamed from: 显示子项按钮 */
    boolean mo1239();

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 显示子项选择框 */
    void mo1240(boolean z);

    @SimpleProperty
    /* renamed from: 显示子项选择框 */
    boolean mo1241();

    @SimpleFunction
    /* renamed from: 添加分组 */
    int mo1242(String str, String str2);

    @SimpleFunction
    /* renamed from: 添加子项 */
    void mo1243(int i, String str, String str2, String str3, String str4, String str5);

    @SimpleFunction
    /* renamed from: 清空下载缓存 */
    void mo1244();

    @SimpleFunction
    /* renamed from: 清空子项 */
    void mo1245(int i);

    @SimpleFunction
    /* renamed from: 清空所有数据 */
    void mo1246();

    @SimpleFunction
    /* renamed from: 绑定弹出菜单 */
    void mo793();

    @SimpleFunction
    /* renamed from: 置分组信息 */
    void mo1247(int i, String str);

    @SimpleFunction
    /* renamed from: 置分组标记 */
    void mo1248(int i, String str);

    @SimpleFunction
    /* renamed from: 置分组标题 */
    void mo1249(int i, String str);

    @SimpleFunction
    /* renamed from: 置子项信息 */
    void mo1250(int i, int i2, String str);

    @SimpleFunction
    /* renamed from: 置子项图片 */
    void mo1251(int i, int i2, String str);

    @SimpleFunction
    /* renamed from: 置子项按钮图片 */
    void mo1252(int i, int i2, String str);

    @SimpleFunction
    /* renamed from: 置子项按钮标题 */
    void mo1253(int i, int i2, String str);

    @SimpleFunction
    /* renamed from: 置子项标记 */
    void mo1254(int i, int i2, String str);

    @SimpleFunction
    /* renamed from: 置子项标题 */
    void mo1255(int i, int i2, String str);

    @SimpleFunction
    /* renamed from: 置子项选择框状态 */
    void mo1256(int i, int i2, boolean z);

    @SimpleProperty
    /* renamed from: 背景图片 */
    String mo1257();

    @SimpleProperty(initializer = "\"\"", type = "simple.asset")
    /* renamed from: 背景图片 */
    void mo1258(String str);

    @SimpleProperty
    /* renamed from: 背景图片2 */
    int mo12592();

    @SimpleProperty
    /* renamed from: 背景图片2 */
    void mo12602(int i);

    @SimpleFunction
    /* renamed from: 选中分组 */
    void mo1261(int i);

    @SimpleFunction
    /* renamed from: 选中子项 */
    void mo1262(int i, int i2, boolean z);
}
