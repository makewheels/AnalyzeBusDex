package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0886;
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
import com.e4a.runtime.variants.StringVariant;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口12.code */
/* renamed from: com.chedaole.窗口12 */
public class C064912 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口12 */
    public static C0644 f396512;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f39661;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f39671;

    public C064912() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f396512 = this;
        f396512.mo840("E4A");
        f396512.mo797_背景颜色(-1);
        f396512.m5096(IntegerVariant.getIntegerVariant(4));
        f396512.mo838(1);
        f396512.mo826(false);
        C0713Impl c0713Impl = new C0713Impl(f396512);
        Objects.initializeProperties(c0713Impl);
        this.f39671 = c0713Impl;
        this.f39671.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39671.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39671.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39671.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39671.mo776_可视(true);
        C0742Impl c0742Impl = new C0742Impl(f396512);
        Objects.initializeProperties(c0742Impl);
        this.f39661 = c0742Impl;
        this.f39661.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.023d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39661.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.014d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39661.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39661.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39661.mo797_背景颜色(0);
        this.f39661.mo1143(1);
        this.f39661.mo1139("icon01.png");
        this.f39661.mo776_可视(true);
        EventDispatcher.registerEvent(this, "窗口12", "按下某键");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "窗口12", "创建完毕");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        f396512.mo765();
        this.f39671.mo765();
        this.f39661.mo765();
    }

    /* renamed from: 窗口12$创建完毕 */
    public void m518512$() {
        this.f39671.mo806(C0894.m6884());
        this.f39671.mo780(C0894.m6882());
        this.f39671.mo804(0);
        this.f39671.mo782(0);
        this.f39671.mo960JS("e4a");
        this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
        if (C0897_网络操作.m6920_取网络状态()) {
            this.f39671.mo976(this.wl + "/web/citydao1.html");
        } else if (IntegerVariant.getIntegerVariant(C0879.m66692("信号", "当前网络不是很稳定", "退出", "取消")).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
            C0880_应用操作类.m6703();
        } else {
            C0880_应用操作类.m6703();
        }
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m51841$(String 网页消息) {
        C0898_读写设置类.m6935_通过SP保存设置("成s", StringVariant.getStringVariant(C0108a.f262e));
        this.zz = C0886.m6750(网页消息);
        C0898_读写设置类.m6935_通过SP保存设置("成", StringVariant.getStringVariant(this.zz));
        C0880_应用操作类.m6694(this.zz);
        C0898_读写设置类.m6935_通过SP保存设置("城市", StringVariant.getStringVariant(网页消息));
        if (C0880_应用操作类.m6712("窗口3") == null) {
            C0880_应用操作类.m6692("窗口3", new C06543());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }

    /* renamed from: 窗口12$按下某键 */
    public void m518612$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        try {
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                C0880_应用操作类.m6703();
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 图片框1$被单击 */
    public void m51831$() {
        C0880_应用操作类.m6703();
    }
}
