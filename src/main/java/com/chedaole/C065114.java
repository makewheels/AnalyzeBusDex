package com.chedaole;

import com.e4a.runtime.C0852_存储卡类;
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
import com.e4a.runtime.components.impl.android.n12.C0696;
import com.e4a.runtime.components.impl.android.n12.C0697Impl;
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
import p054u.aly.df;

@SimpleObject
/* compiled from: 窗口14.code */
/* renamed from: com.chedaole.窗口14 */
public class C065114 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口14 */
    public static C0644 f403314;
    @SimpleDataElement
    /* renamed from: f */
    public String f4034f = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String luxian = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: v */
    public String f4035v = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String wo = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f40361;
    @SimpleDataElement
    /* renamed from: 图片框2 */
    public C0739 f40372;
    @SimpleDataElement
    /* renamed from: 图片框3 */
    public C0739 f40383;
    @SimpleDataElement
    /* renamed from: 时钟1 */
    public C0696 f40391;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f40401;

    public C065114() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f403314 = this;
        f403314.mo840("E4A");
        f403314.mo797(-1);
        f403314.m5096(IntegerVariant.getIntegerVariant(4));
        f403314.mo838(1);
        f403314.mo826(false);
        C0713Impl c0713Impl = new C0713Impl(f403314);
        Objects.initializeProperties(c0713Impl);
        this.f40401 = c0713Impl;
        this.f40401.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.017d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40401.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40401.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.917d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40401.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.805d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40401.mo776(true);
        C0742Impl c0742Impl = new C0742Impl(f403314);
        Objects.initializeProperties(c0742Impl);
        this.f40372 = c0742Impl;
        this.f40372.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40372.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40372.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40372.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40372.mo797(0);
        this.f40372.mo1143(1);
        this.f40372.mo1139("lxee.png");
        this.f40372.mo776(true);
        c0742Impl = new C0742Impl(f403314);
        Objects.initializeProperties(c0742Impl);
        this.f40361 = c0742Impl;
        this.f40361.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.885d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40361.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.015d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40361.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40361.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40361.mo797(0);
        this.f40361.mo1143(1);
        this.f40361.mo1139("eee.png");
        this.f40361.mo776(true);
        C0697Impl c0697Impl = new C0697Impl(f403314);
        Objects.initializeProperties(c0697Impl);
        this.f40391 = c0697Impl;
        this.f40391.mo928(0);
        c0742Impl = new C0742Impl(f403314);
        Objects.initializeProperties(c0742Impl);
        this.f40383 = c0742Impl;
        this.f40383.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.023d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40383.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.014d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40383.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40383.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40383.mo797(0);
        this.f40383.mo1143(1);
        this.f40383.mo1139("icon01.png");
        this.f40383.mo776(true);
        EventDispatcher.registerEvent(this, "窗口14", "切换完毕");
        EventDispatcher.registerEvent(this, "窗口14", "按下某键");
        EventDispatcher.registerEvent(this, "图片框3", "被单击");
        EventDispatcher.registerEvent(this, "时钟1", "周期事件");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "窗口14", "创建完毕");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        f403314.mo765();
        this.f40401.mo765();
        this.f40372.mo765();
        this.f40361.mo765();
        this.f40391.mo765();
        this.f40383.mo765();
    }

    /* renamed from: 窗口14$切换完毕 */
    public void m522614$() {
        try {
            this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
            this.f40401.mo806(C0894.m6884());
            this.f40401.mo780(C0894.m6882());
            this.f40401.mo782(0);
            this.f40401.mo804(0);
            this.f40401.mo960JS("e4a");
            this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
            this.wo = ((this.wl + "/") + this.zz) + "/xian.txt";
            this.luxian = C0897_网络操作.m6922(this.wo, "utf-8", 5000);
            this.f40401.mo976(this.luxian);
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 窗口14$创建完毕 */
    public void m522714$() {
        try {
            this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
            this.f40401.mo806(C0894.m6884());
            this.f40401.mo780(C0894.m6882());
            this.f40401.mo782(0);
            this.f40401.mo804(0);
            this.f40401.mo960JS("e4a");
            this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
            this.wo = ((this.wl + "/") + this.zz) + "/xian.txt";
            this.luxian = C0897_网络操作.m6922(this.wo, "utf-8", 5000);
            this.f40401.mo976(this.luxian);
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m52251$(String 网页消息) {
        try {
            if (网页消息.equals("请输入您要搜索的路线")) {
                C0880_应用操作类.m6694("请输入您要搜索的路线");
                return;
            }
            this.f4035v = Integer.toString(C0890_文本操作.m6817_获取字符串长度(网页消息));
            if (StringVariant.getStringVariant(this.f4035v).cmp(ByteVariant.getByteVariant(df.f6529m)) < 0 && StringVariant.getStringVariant(this.f4035v).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                C0898_读写设置类.m6935_通过SP保存设置("小年", StringVariant.getStringVariant("2"));
                网页消息 = C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(网页消息, "路", bi_常量类.f6358b_空串), "快", "k"), "线", bi_常量类.f6358b_空串), "环", "h");
                C0898_读写设置类.m6935_通过SP保存设置("正反", StringVariant.getStringVariant("正"));
                C0898_读写设置类.m6935_通过SP保存设置("线路", StringVariant.getStringVariant(网页消息));
                if (C0880_应用操作类.m6712("过渡窗口") == null) {
                    C0880_应用操作类.m6692("过渡窗口", new C06532());
                }
                C0898_读写设置类.m6935_通过SP保存设置("方向", StringVariant.getStringVariant("zheng"));
                C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("过渡窗口"));
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 窗口14$按下某键 */
    public void m522814$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        try {
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                this.f40401.mo982();
                C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 图片框1$被单击 */
    public void m52221$() {
        if (C0897_网络操作.m6920_取网络状态()) {
            this.f40401.mo976(((("file:///" + C0852_存储卡类.m6665_取存储卡路径()) + "/cityisba/") + this.zz) + "/bendi/leadline.html");
        } else {
            C0880_应用操作类.m6694("无网络");
        }
    }

    /* renamed from: 时钟1$周期事件 */
    public void m52241$() {
        this.f40391.mo928(0);
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40401.mo946(), "luxian", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) < 0) {
            this.f40401.mo976(((this.wl + "/web/city/") + this.zz) + "/leadline.html");
        }
    }

    /* renamed from: 图片框3$被单击 */
    public void m52233$() {
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }
}
