package com.e4a.runtime;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.n37.C0738Impl;
import com.e4a.runtime.components.impl.android.n79.C0771;

@SimpleObject
/* renamed from: com.e4a.runtime.应用操作 */
public abstract class C0880_应用操作类 {
    private static ApplicationFunctions applicationFunctions;

    private C0880_应用操作类() {
    }

    public static void initialize(ApplicationFunctions functions) {
        applicationFunctions = functions;
    }

    @SimpleFunction
    /* renamed from: 读取窗口 */
    public static C0645Impl m6712(String formname) {
        return applicationFunctions.mo879(formname);
    }

    @SimpleFunction
    /* renamed from: 保存窗口 */
    public static void m6692(String formname, C0645Impl formImpl) {
        applicationFunctions.mo860(formname, formImpl);
    }

    @SimpleFunction
    /* renamed from: 读取客户 */
    public static C0738Impl m6709(String clientname) {
        return applicationFunctions.mo876(clientname);
    }

    @SimpleFunction
    /* renamed from: 保存客户 */
    public static void m6689(String clientname, C0738Impl clientImpl) {
        applicationFunctions.mo857(clientname, clientImpl);
    }

    @SimpleFunction
    /* renamed from: 读取模块 */
    public static Object m6711(String modelname) {
        return applicationFunctions.mo878(modelname);
    }

    @SimpleFunction
    /* renamed from: 保存模块 */
    public static void m6691(String modelname, Object model) {
        applicationFunctions.mo859(modelname, model);
    }

    @SimpleFunction
    /* renamed from: 读取对象 */
    public static Object m6710(String objname) {
        return applicationFunctions.mo877(objname);
    }

    @SimpleFunction
    /* renamed from: 保存对象 */
    public static void m6690(String objname, Object obj) {
        applicationFunctions.mo858(objname, obj);
    }

    @SimpleFunction
    /* renamed from: 切换窗口 */
    public static void m6693_切换窗口(C0644 formname) {
        applicationFunctions.mo861(formname);
    }

    @SimpleFunction
    public static void Finish() {
        applicationFunctions.finish();
    }

    @SimpleFunction
    /* renamed from: 弹出提示 */
    public static void m6694(String msg) {
        applicationFunctions.mo862(msg);
    }

    @SimpleFunction
    /* renamed from: 结束程序 */
    public static void m6703() {
        applicationFunctions.mo870();
    }

    @SimpleFunction
    /* renamed from: 窗口置后台 */
    public static void m6701() {
        applicationFunctions.mo868();
    }

    @SimpleFunction
    /* renamed from: 返回桌面 */
    public static void m6715() {
        applicationFunctions.mo882();
    }

    @SimpleFunction
    /* renamed from: 返回应用 */
    public static void m6714() {
        applicationFunctions.mo881();
    }

    @SimpleFunction
    /* renamed from: 弹出提示2 */
    public static void m66952(String imagePath, String text, int style, int loaction) {
        applicationFunctions.mo8632(imagePath, text, style, loaction);
    }

    @SimpleFunction
    /* renamed from: 是否在前台 */
    public static boolean m6698() {
        return applicationFunctions.mo865();
    }

    @SimpleFunction
    /* renamed from: 注册弹出菜单 */
    public static void m6700(View v) {
        applicationFunctions.mo867(v);
    }

    @SimpleFunction
    /* renamed from: 获取全局应用 */
    public static Application m6705() {
        return applicationFunctions.mo872();
    }

    @SimpleFunction
    /* renamed from: 获取全局应用上下文 */
    public static Context m6706() {
        return applicationFunctions.mo873();
    }

    @SimpleFunction
    /* renamed from: 获取上下文 */
    public static Context m6704() {
        return applicationFunctions.mo871();
    }

    @SimpleFunction
    /* renamed from: 获取启动参数 */
    public static Intent m6707() {
        return applicationFunctions.mo874();
    }

    @SimpleFunction
    /* renamed from: 获取启动设置 */
    public static Bundle m6708() {
        return applicationFunctions.mo875();
    }

    @SimpleFunction
    /* renamed from: 转换字体大小 */
    public static float m6713(float 字体大小) {
        return applicationFunctions.mo880(字体大小);
    }

    @SimpleFunction
    /* renamed from: 是否自适应 */
    public static boolean m6699() {
        return applicationFunctions.mo866();
    }

    @SimpleFunction
    /* renamed from: 绑定活动栏 */
    public static void m6702(C0771 actionbar) {
        applicationFunctions.mo869(actionbar);
    }

    @SimpleFunction
    /* renamed from: 强制结束程序 */
    public static void m6696() {
        applicationFunctions.mo864();
    }

    @SimpleFunction
    /* renamed from: 销毁窗口 */
    public static void m6716(String formname) {
        applicationFunctions.mo883(formname);
    }

    @SimpleFunction
    /* renamed from: 是否为当前窗口 */
    public static boolean m6697(C0645Impl form) {
        return applicationFunctions.isActiveForm(form);
    }
}
