package com.e4a.runtime.components.impl.android.p021;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.components.Component;

@UsesPermissions(permissionNames = "android.permission.INTERNET")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.高德导航类库.高德导航 */
public interface C0830 extends Component {
    @SimpleFunction
    /* renamed from: 初始化 */
    void mo1491();

    @SimpleFunction
    /* renamed from: 开始步行实时导航 */
    void mo1492();

    @SimpleFunction
    /* renamed from: 开始步行模拟导航 */
    void mo1493();

    @SimpleFunction
    /* renamed from: 开始驾车实时导航 */
    void mo1494();

    @SimpleFunction
    /* renamed from: 开始驾车模拟导航 */
    void mo1495();

    @SimpleEvent
    /* renamed from: 规划导航路线完毕 */
    void mo1496(boolean z);

    @SimpleFunction
    /* renamed from: 规划步行导航路线 */
    void mo1497(double d, double d2, double d3, double d4);

    @SimpleFunction
    /* renamed from: 规划驾车导航路线 */
    void mo1498(double d, double d2, double d3, double d4);

    @SimpleFunction
    /* renamed from: 设置导航发音人 */
    void mo1499(int i);

    @SimpleFunction
    /* renamed from: 释放资源 */
    void mo1500();
}
