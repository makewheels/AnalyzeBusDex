package com.e4a.runtime.components.impl.android.n15;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.components.VisibleComponent;
import com.e4a.runtime.parameters.IntegerReferenceParameter;

@UsesPermissions(permissionNames = "android.permission.INTERNET,android.permission.ACCESS_FINE_LOCATION,android.permission.ACCESS_COARSE_LOCATION")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n15.浏览框 */
public interface C0698 extends VisibleComponent {
    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 保存密码 */
    void mo933(boolean z);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 保存表单 */
    void mo934(boolean z);

    @SimpleEvent
    /* renamed from: 信息框被单击 */
    void mo935(String str, String str2);

    @SimpleFunction
    /* renamed from: 停止 */
    void mo936();

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 允许加载图片 */
    void mo937(boolean z);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 允许弹出对话框 */
    void mo938(boolean z);

    @SimpleFunction
    /* renamed from: 前进 */
    void mo939();

    @SimpleFunction
    /* renamed from: 加载数据 */
    void mo940(String str, String str2);

    @SimpleEvent
    /* renamed from: 即将跳转 */
    void mo941(String str, IntegerReferenceParameter integerReferenceParameter);

    @SimpleFunction
    /* renamed from: 取cookie */
    String mo942cookie(String str);

    @SimpleFunction
    /* renamed from: 取图标 */
    byte[] mo943();

    @SimpleFunction
    /* renamed from: 取地址 */
    String mo944();

    @SimpleFunction
    /* renamed from: 取数据库目录 */
    String mo945();

    @SimpleFunction
    /* renamed from: 取标题 */
    String mo946();

    @SimpleFunction
    /* renamed from: 取请求头 */
    String mo947();

    @SimpleFunction
    /* renamed from: 取进度 */
    int mo948();

    @SimpleFunction
    /* renamed from: 取默认请求头 */
    String mo949();

    @SimpleProperty
    /* renamed from: 可否前进 */
    boolean mo950();

    @SimpleProperty
    /* renamed from: 可否后退 */
    boolean mo951();

    @SimpleFunction
    /* renamed from: 后退 */
    void mo952();

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 启用DomStorage */
    void mo953DomStorage(boolean z);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 启用JS */
    void mo954JS(boolean z);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 启用地理定位 */
    void mo955(boolean z);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 启用插件 */
    void mo956(boolean z);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 启用缓存 */
    void mo957(boolean z);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 启用缩放 */
    void mo958(boolean z);

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 启用缩放按钮 */
    void mo959(boolean z);

    @SimpleFunction
    /* renamed from: 增加JS接口 */
    void mo960JS(String str);

    @SimpleEvent
    /* renamed from: 子窗口开始载入 */
    void mo961(String str);

    @SimpleEvent
    /* renamed from: 子窗口载入完毕 */
    void mo962(String str);

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 宽屏显示 */
    void mo963(boolean z);

    @SimpleEvent
    /* renamed from: 开始下载 */
    void mo964(String str, long j);

    @SimpleEvent
    /* renamed from: 开始载入 */
    void mo965(String str);

    @SimpleFunction
    /* renamed from: 截取快照 */
    byte[] mo966();

    @SimpleEvent
    /* renamed from: 接口事件 */
    void mo967(String str);

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 显示子窗口 */
    void mo968(boolean z);

    @SimpleProperty(initializer = "2", type = "simple.integer")
    /* renamed from: 显示方式 */
    void mo969(int i);

    @SimpleFunction
    /* renamed from: 清空cookie */
    void mo970cookie();

    @SimpleFunction
    /* renamed from: 置cookie */
    void mo971cookie(String str, String str2);

    @SimpleFunction
    /* renamed from: 置请求头 */
    void mo972(String str);

    @SimpleFunction
    /* renamed from: 自动拉伸高度 */
    void mo973(boolean z);

    @SimpleEvent
    /* renamed from: 触摸手势 */
    void mo974(int i);

    @SimpleEvent
    /* renamed from: 询问框被单击 */
    void mo975(String str, String str2, int i);

    @SimpleFunction
    /* renamed from: 跳转 */
    void mo976(String str);

    @SimpleFunction
    /* renamed from: 跳转2 */
    void mo9772(String str, String str2);

    @SimpleEvent
    /* renamed from: 载入失败 */
    void mo978(int i, String str);

    @SimpleEvent
    /* renamed from: 载入完毕 */
    void mo979(String str);

    @SimpleEvent
    /* renamed from: 输入框被单击 */
    void mo980(String str, String str2, String str3, int i);

    @SimpleEvent
    /* renamed from: 进度改变 */
    void mo981(int i);

    @SimpleFunction
    /* renamed from: 释放内存 */
    void mo982();

    @SimpleFunction
    /* renamed from: 重载 */
    void mo983();
}
