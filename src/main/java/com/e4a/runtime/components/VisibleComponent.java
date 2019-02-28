package com.e4a.runtime.components;

import android.view.View;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;

@SimpleObject
public interface VisibleComponent extends Component {
    @SimpleProperty
    /* renamed from: 列 */
    int mo766();

    @SimpleProperty(initializer = "-1", type = "simple.integer")
    /* renamed from: 列 */
    void mo767(int i);

    @SimpleFunction
    /* renamed from: 到顶层 */
    void mo768();

    @SimpleFunction
    /* renamed from: 刷新 */
    void mo769();

    @SimpleFunction
    /* renamed from: 取宽度 */
    int mo770();

    @SimpleFunction
    /* renamed from: 取高度 */
    int mo771();

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 可停留焦点 */
    void mo772(boolean z);

    @SimpleProperty
    /* renamed from: 可停留焦点 */
    boolean mo773();

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 可用 */
    void mo774(boolean z);

    @SimpleProperty
    /* renamed from: 可用 */
    boolean mo775();

    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 可视 */
    void mo776(boolean z);

    @SimpleProperty
    /* renamed from: 可视 */
    boolean mo777();

    @SimpleEvent
    /* renamed from: 失去焦点 */
    void mo778();

    @SimpleProperty
    /* renamed from: 宽度 */
    int mo779();

    @SimpleProperty
    /* renamed from: 宽度 */
    void mo780(int i);

    @SimpleProperty
    /* renamed from: 左边 */
    int mo781();

    @SimpleProperty
    /* renamed from: 左边 */
    void mo782(int i);

    @SimpleFunction
    /* renamed from: 开启特效 */
    void mo783(int i, int i2, boolean z);

    @SimpleEvent
    /* renamed from: 开启特效完毕 */
    void mo784();

    @SimpleFunction
    /* renamed from: 旋转特效 */
    void mo785(float f, float f2, int i, boolean z);

    @SimpleFunction
    /* renamed from: 清除焦点 */
    void mo786();

    @SimpleProperty
    /* renamed from: 父组件 */
    void mo787(C0642 c0642);

    @SimpleFunction
    /* renamed from: 电视机关闭特效 */
    void mo788();

    @SimpleFunction
    /* renamed from: 监听绘制 */
    void mo789();

    @SimpleFunction
    /* renamed from: 移动 */
    void mo790(int i, int i2, int i3, int i4);

    @SimpleFunction
    /* renamed from: 移动特效 */
    void mo791(int i, int i2, int i3, int i4, int i5, boolean z);

    @SimpleEvent
    /* renamed from: 移动特效完毕 */
    void mo792();

    @SimpleFunction
    /* renamed from: 绑定弹出菜单 */
    void mo793();

    @SimpleEvent
    /* renamed from: 绘制完毕 */
    void mo794(int i, int i2);

    @SimpleFunction
    /* renamed from: 置特效重复模式 */
    void mo795(int i, int i2);

    @SimpleProperty
    /* renamed from: 背景颜色 */
    int mo796();

    @SimpleProperty(type = "simple.color")
    /* renamed from: 背景颜色 */
    void mo797(int i);

    @SimpleFunction
    /* renamed from: 获取焦点 */
    void mo798();

    @SimpleEvent
    /* renamed from: 获得焦点 */
    void mo799();

    @SimpleProperty
    /* renamed from: 行 */
    int mo800();

    @SimpleProperty(initializer = "-1", type = "simple.integer")
    /* renamed from: 行 */
    void mo801(int i);

    @SimpleFunction
    /* renamed from: 销毁 */
    View mo802();

    @SimpleProperty
    /* renamed from: 顶边 */
    int mo803();

    @SimpleProperty
    /* renamed from: 顶边 */
    void mo804(int i);

    @SimpleProperty
    /* renamed from: 高度 */
    int mo805();

    /* renamed from: 高度 */
    void mo806(int i);
}
