package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.variants.Variant;

@UsesPermissions(permissionNames = "android.permission.INTERNET,android.permission.WRITE_EXTERNAL_STORAGE,android.permission.MOUNT_UNMOUNT_FILESYSTEMS,android.permission.ACCESS_NETWORK_STATE,android.permission.ACCESS_WIFI_STATE,com.android.launcher.permission.INSTALL_SHORTCUT,com.android.launcher.permission.READ_SETTINGS,android.permission.SYSTEM_ALERT_WINDOW,android.permission.GET_TASKS,android.permission.READ_PHONE_STATE,android.permission.WAKE_LOCK,android.permission.CHANGE_CONFIGURATION")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.窗口 */
public interface C0644 extends VisibleComponent, ComponentContainer {
    @SimpleEvent
    /* renamed from: 切换完毕 */
    void mo825();

    @SimpleProperty(initializer = "False", type = "simple.boolean")
    /* renamed from: 可否滚动 */
    void mo826(boolean z);

    @SimpleProperty
    /* renamed from: 可否滚动 */
    boolean mo827();

    @SimpleProperty
    /* renamed from: 宽度 */
    int mo779();

    @SimpleEvent
    /* renamed from: 屏幕方向被改变 */
    void mo828(int i);

    @SimpleProperty
    /* renamed from: 布局 */
    Variant m5095();

    @SimpleProperty(initializer = "4", type = "simple.layout")
    /* renamed from: 布局 */
    void m5096(Variant variant);

    @SimpleEvent
    /* renamed from: 弹出菜单被选择 */
    void mo829(String str);

    @SimpleEvent
    /* renamed from: 悬浮按钮被单击 */
    void mo830();

    @SimpleEvent
    /* renamed from: 悬浮按钮被弹起 */
    void mo831();

    @SimpleEvent
    /* renamed from: 悬浮按钮被按下 */
    void mo832();

    @SimpleEvent
    /* renamed from: 悬浮按钮被长按 */
    void mo833();

    @SimpleEvent
    /* renamed from: 按下某键 */
    void mo834(int i, BooleanReferenceParameter booleanReferenceParameter);

    @SimpleEvent
    /* renamed from: 日期框被选择 */
    void mo835(String str);

    @SimpleEvent
    /* renamed from: 时间框被选择 */
    void mo836(String str);

    @SimpleProperty
    /* renamed from: 显示方式 */
    int mo837();

    @SimpleProperty(initializer = "1", type = "simple.integer")
    /* renamed from: 显示方式 */
    void mo838(int i);

    @SimpleProperty
    /* renamed from: 标题 */
    String mo839();

    @SimpleProperty(initializer = "\"\"", type = "simple.string")
    /* renamed from: 标题 */
    void mo840(String str);

    @SimpleFunction
    /* renamed from: 添加弹出菜单 */
    void mo841(String str);

    @SimpleFunction
    /* renamed from: 添加菜单 */
    void mo842(String str, int i);

    @SimpleFunction
    /* renamed from: 清空弹出菜单 */
    void mo843();

    @SimpleFunction
    /* renamed from: 清空菜单 */
    void mo844();

    @SimpleEvent
    /* renamed from: 程序被启动 */
    void mo845(String str);

    @SimpleEvent
    /* renamed from: 程序被暂停 */
    void mo846();

    @SimpleEvent
    /* renamed from: 程序被重启 */
    void mo847();

    @SimpleEvent
    /* renamed from: 程序被销毁 */
    void mo848();

    @SimpleProperty
    /* renamed from: 背景图片 */
    String mo816();

    @SimpleProperty(initializer = "\"\"", type = "simple.asset")
    /* renamed from: 背景图片 */
    void mo817(String str);

    @SimpleProperty
    /* renamed from: 背景图片2 */
    int mo8182();

    @SimpleProperty
    /* renamed from: 背景图片2 */
    void mo8192(int i);

    @SimpleProperty
    /* renamed from: 背景颜色 */
    int mo796();

    @SimpleProperty(initializer = "-16776961", type = "simple.color")
    /* renamed from: 背景颜色 */
    void mo797_背景颜色(int i);

    @SimpleEvent
    /* renamed from: 菜单被选择 */
    void mo849(String str);

    @SimpleEvent
    /* renamed from: 触摸手势 */
    void mo850(int i);

    @SimpleProperty
    /* renamed from: 高度 */
    int mo805();
}
