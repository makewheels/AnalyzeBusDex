package com.chedaole;

import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0893;
import com.e4a.runtime.C0894;
import com.e4a.runtime.C0897_网络操作;
import com.e4a.runtime.C0898_读写设置类;
import com.e4a.runtime.Objects;
import com.e4a.runtime.annotations.SimpleDataElement;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.n15.C0698;
import com.e4a.runtime.components.impl.android.n15.C0713Impl;
import com.e4a.runtime.components.impl.android.n4.C0739;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.errors.RuntimeError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口5.code */
/* renamed from: com.chedaole.窗口5 */
public class C06565 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口5 */
    public static C0644 f42215;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f42221;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f42231;

    public C06565() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f42215 = this;
        f42215.mo840("E4A");
        f42215.mo797_背景颜色(-1);
        f42215.m5096(IntegerVariant.getIntegerVariant(4));
        f42215.mo838(1);
        f42215.mo826(false);
        C0713Impl c0713Impl = new C0713Impl(f42215);
        Objects.initializeProperties(c0713Impl);
        this.f42231 = c0713Impl;
        this.f42231.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42231.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42231.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42231.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42231.mo776_可视(true);
        C0742Impl c0742Impl = new C0742Impl(f42215);
        Objects.initializeProperties(c0742Impl);
        this.f42221 = c0742Impl;
        this.f42221.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.023d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42221.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.014d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42221.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42221.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42221.mo797_背景颜色(0);
        this.f42221.mo1143(1);
        this.f42221.mo1139("icon01.png");
        this.f42221.mo776_可视(true);
        EventDispatcher.registerEvent(this, "窗口5", "创建完毕");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "窗口5", "按下某键");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        f42215.mo765();
        this.f42231.mo765();
        this.f42221.mo765();
    }

    /* renamed from: 窗口5$创建完毕 */
    public void m53175$() {
        this.f42231.mo806(C0894.m6884());
        this.f42231.mo780(C0894.m6882());
        this.f42231.mo804(0);
        this.f42231.mo782(0);
        this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
        this.f42231.mo960JS("hua");
        if (C0897_网络操作.m6920_取网络状态()) {
            this.f42231.mo976(this.wl + "/web/city/daqing/lvyou/index.html");
        } else if (IntegerVariant.getIntegerVariant(C0879.m66692("信号", "当前网络不是很稳定", "退出", "取消")).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
            C0880_应用操作类.m6703();
        } else {
            C0880_应用操作类.m6703();
        }
    }

    /* renamed from: 窗口5$按下某键 */
    public void m53185$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        try {
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 图片框1$被单击 */
    public void m53151$() {
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m53161$(String 网页消息) {
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821_寻找文本(网页消息, "tui", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
        }
    }
}
