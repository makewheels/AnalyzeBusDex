package com.e4a.runtime.components.impl.android.n89;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.components.VisibleComponent;

@UsesPermissions(permissionNames = "android.permission.INTERNET,android.permission.WRITE_EXTERNAL_STORAGE,android.permission.ACCESS_COARSE_LOCATION,android.permission.ACCESS_NETWORK_STATE,android.permission.ACCESS_FINE_LOCATION,android.permission.READ_PHONE_STATE,android.permission.ACCESS_WIFI_STATE,android.permission.CHANGE_CONFIGURATION")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n89.高德地图 */
public interface C0778 extends VisibleComponent {
    @SimpleFunction
    /* renamed from: 保存截图 */
    void mo1337(String str);

    @SimpleFunction
    /* renamed from: 删除圆圈 */
    void mo1338(String str);

    @SimpleFunction
    /* renamed from: 删除所有标记 */
    void mo1339();

    @SimpleFunction
    /* renamed from: 删除标记 */
    void mo1340(String str);

    @SimpleFunction
    /* renamed from: 删除线条 */
    void mo1341(String str);

    @SimpleFunction
    /* renamed from: 刷新地图 */
    void mo1342();

    @SimpleFunction
    /* renamed from: 向上移动视图 */
    void mo1343();

    @SimpleFunction
    /* renamed from: 向下移动视图 */
    void mo1344();

    @SimpleFunction
    /* renamed from: 向右移动视图 */
    void mo1345();

    @SimpleFunction
    /* renamed from: 向左移动视图 */
    void mo1346();

    @SimpleEvent
    /* renamed from: 地图加载完毕 */
    void mo1347();

    @SimpleEvent
    /* renamed from: 地图被单击 */
    void mo1348(double d, double d2);

    @SimpleEvent
    /* renamed from: 地图被长按 */
    void mo1349(double d, double d2);

    @SimpleFunction
    /* renamed from: 地址查询坐标 */
    void mo1350(String str, String str2);

    @SimpleEvent
    /* renamed from: 地址查询坐标完毕 */
    void mo1351(boolean z, double d, double d2);

    @SimpleFunction
    /* renamed from: 坐标查询地址 */
    void mo1352(double d, double d2);

    @SimpleEvent
    /* renamed from: 坐标查询地址完毕 */
    void mo1353(boolean z, String str);

    @SimpleEvent
    /* renamed from: 定位完毕 */
    void mo1354(double d, double d2, String str, String str2, String str3, String str4);

    @SimpleFunction
    /* renamed from: 开始搜索路线 */
    void mo1355(int i, String str);

    @SimpleFunction
    /* renamed from: 开始搜索路线2 */
    void mo13562(String str, String str2, int i, String str3);

    @SimpleFunction
    /* renamed from: 开始选择终点 */
    void mo1357();

    @SimpleFunction
    /* renamed from: 开始选择起点 */
    void mo1358();

    @SimpleEvent
    /* renamed from: 截图完毕 */
    void mo1359(boolean z);

    @SimpleEvent
    /* renamed from: 搜索路线完毕 */
    void mo1360(boolean z, double d, double d2, double d3, double d4);

    @SimpleFunction
    /* renamed from: 放大视图 */
    void mo1361();

    @SimpleFunction
    /* renamed from: 显示交通状况 */
    void mo1362(boolean z);

    @SimpleFunction
    /* renamed from: 显示定位按钮 */
    void mo1363(boolean z);

    @SimpleFunction
    /* renamed from: 显示指南针 */
    void mo1364(boolean z);

    @SimpleFunction
    /* renamed from: 显示标记信息窗口 */
    void mo1365(String str);

    @SimpleFunction
    /* renamed from: 显示比例尺 */
    void mo1366(boolean z);

    @SimpleFunction
    /* renamed from: 显示缩放按钮 */
    void mo1367(boolean z);

    @SimpleFunction
    /* renamed from: 查询公交站点 */
    void mo1368(String str, String str2);

    @SimpleFunction
    /* renamed from: 查询公交线路 */
    void mo1369(String str, String str2);

    @SimpleEvent
    /* renamed from: 标记信息窗口被单击 */
    void mo1370(String str, String str2, String str3);

    @SimpleEvent
    /* renamed from: 标记被单击 */
    void mo1371(String str, String str2, String str3, boolean z);

    @SimpleEvent
    /* renamed from: 标记被拖动完毕 */
    void mo1372(String str, double d, double d2);

    @SimpleFunction
    /* renamed from: 添加地理围栏 */
    void mo1373(double d, double d2, float f);

    @SimpleFunction
    /* renamed from: 添加标记 */
    String mo1374(double d, double d2, String str, String str2, int i, boolean z);

    @SimpleFunction
    /* renamed from: 添加标记2 */
    String mo13752(double d, double d2, String str, String str2, int i, boolean z);

    @SimpleFunction
    /* renamed from: 画圆圈 */
    String mo1376(double d, double d2, double d3, float f, int i, int i2);

    @SimpleFunction
    /* renamed from: 画线条 */
    String mo1377(double d, double d2, double d3, double d4, int i, int i2, int i3);

    @SimpleFunction
    /* renamed from: 禁用手势 */
    void mo1378(boolean z);

    @SimpleFunction
    /* renamed from: 移动视图 */
    void mo1379(double d, double d2);

    @SimpleFunction
    /* renamed from: 缩小视图 */
    void mo1380();

    @SimpleFunction
    /* renamed from: 置地图模式 */
    void mo1381(int i);

    @SimpleFunction
    /* renamed from: 置定位模式 */
    void mo1382(int i);

    @SimpleFunction
    /* renamed from: 置缩放级别 */
    void mo1383(float f);

    @SimpleFunction
    /* renamed from: 获取天气 */
    void mo1384();

    @SimpleEvent
    /* renamed from: 获取天气完毕 */
    void mo1385(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    @SimpleEvent
    /* renamed from: 视图被改变 */
    void mo1386(float f);

    @SimpleFunction
    /* renamed from: 计算两点距离 */
    float mo1387(double d, double d2, double d3, double d4);

    @SimpleEvent
    /* renamed from: 进出围栏 */
    void mo1388(boolean z);

    @SimpleFunction
    /* renamed from: 隐藏标记信息窗口 */
    void mo1389(String str);
}
