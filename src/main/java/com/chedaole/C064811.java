package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0893;
import com.e4a.runtime.C0894;
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

@SimpleObject
/* compiled from: 窗口11.code */
/* renamed from: com.chedaole.窗口11 */
public class C064811 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口11 */
    public static C0644 f396211;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f39631;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f39641;

    public C064811() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f396211 = this;
        f396211.mo840("E4A");
        f396211.mo797_背景颜色(-1);
        f396211.m5096(IntegerVariant.getIntegerVariant(4));
        f396211.mo838(1);
        f396211.mo826(false);
        C0742Impl c0742Impl = new C0742Impl(f396211);
        Objects.initializeProperties(c0742Impl);
        this.f39631 = c0742Impl;
        this.f39631.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39631.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39631.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39631.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39631.mo797_背景颜色(-16742145);
        this.f39631.mo1143(1);
        this.f39631.mo1139("gg_01.jpg");
        this.f39631.mo776_可视(true);
        C0713Impl c0713Impl = new C0713Impl(f396211);
        Objects.initializeProperties(c0713Impl);
        this.f39641 = c0713Impl;
        this.f39641.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39641.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39641.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39641.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39641.mo776_可视(true);
        EventDispatcher.registerEvent(this, "窗口11", "创建完毕");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        EventDispatcher.registerEvent(this, "窗口11", "按下某键");
        f396211.mo765();
        this.f39631.mo765();
        this.f39641.mo765();
    }

    /* renamed from: 窗口11$创建完毕 */
    public void m518111$() {
        this.f39641.mo960JS("yiyuan");
        this.f39641.mo976("http://111.40.89.205/hospital/");
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m51801$(String 网页消息) {
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页消息, "maika", 1)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0898_读写设置类.m6935_通过SP保存设置("买卡", StringVariant.getStringVariant(C0108a.f262e));
            if (C0880_应用操作类.m6712("窗口8") == null) {
                C0880_应用操作类.m6692("窗口8", new C06598());
            }
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口8"));
        }
    }

    /* renamed from: 窗口11$按下某键 */
    public void m518211$(int i, BooleanReferenceParameter booleanReferenceParameter) {
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
    public void m51791$() {
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }
}
