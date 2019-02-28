package com.e4a.runtime;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.n37.C0738Impl;
import com.e4a.runtime.components.impl.android.n79.C0771;

public interface ApplicationFunctions {
    void finish();

    boolean isActiveForm(C0645Impl c0645Impl);

    /* renamed from: 保存客户 */
    void mo857(String str, C0738Impl c0738Impl);

    /* renamed from: 保存对象 */
    void mo858(String str, Object obj);

    /* renamed from: 保存模块 */
    void mo859(String str, Object obj);

    /* renamed from: 保存窗口 */
    void mo860(String str, C0645Impl c0645Impl);

    /* renamed from: 切换窗口 */
    void mo861(C0644 c0644);

    /* renamed from: 弹出提示 */
    void mo862(String str);

    /* renamed from: 弹出提示2 */
    void mo8632(String str, String str2, int i, int i2);

    /* renamed from: 强制结束程序 */
    void mo864();

    /* renamed from: 是否在前台 */
    boolean mo865();

    /* renamed from: 是否自适应 */
    boolean mo866();

    /* renamed from: 注册弹出菜单 */
    void mo867(View view);

    /* renamed from: 窗口置后台 */
    void mo868();

    /* renamed from: 绑定活动栏 */
    void mo869(C0771 c0771);

    /* renamed from: 结束程序 */
    void mo870();

    /* renamed from: 获取上下文 */
    Context mo871();

    /* renamed from: 获取全局应用 */
    Application mo872();

    /* renamed from: 获取全局应用上下文 */
    Context mo873();

    /* renamed from: 获取启动参数 */
    Intent mo874();

    /* renamed from: 获取启动设置 */
    Bundle mo875();

    /* renamed from: 读取客户 */
    C0738Impl mo876(String str);

    /* renamed from: 读取对象 */
    Object mo877(String str);

    /* renamed from: 读取模块 */
    Object mo878(String str);

    /* renamed from: 读取窗口 */
    C0645Impl mo879(String str);

    /* renamed from: 转换字体大小 */
    float mo880(float f);

    /* renamed from: 返回应用 */
    void mo881();

    /* renamed from: 返回桌面 */
    void mo882();

    /* renamed from: 销毁窗口 */
    void mo883(String str);
}
