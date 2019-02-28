package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0843;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0889_文件操作;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0893;
import com.e4a.runtime.C0894;
import com.e4a.runtime.C0897_网络操作;
import com.e4a.runtime.C0898_读写设置类;
import com.e4a.runtime.C0899;
import com.e4a.runtime.Objects;
import com.e4a.runtime.annotations.SimpleDataElement;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.n15.C0698;
import com.e4a.runtime.components.impl.android.n15.C0713Impl;
import com.e4a.runtime.components.impl.android.n4.C0739;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.components.impl.android.n9.C0790;
import com.e4a.runtime.components.impl.android.n9.C0792Impl;
import com.e4a.runtime.errors.RuntimeError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.parameters.IntegerReferenceParameter;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.StringVariant;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口9.code */
/* renamed from: com.chedaole.窗口9 */
public class C06609 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口9 */
    public static C0644 f42639;
    @SimpleDataElement
    public int ddv;
    @SimpleDataElement
    public int idc;
    @SimpleDataElement
    public String mi = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: p */
    public String f4264p = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zhang = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f42651;
    @SimpleDataElement
    /* renamed from: 手机1 */
    public C0790 f42661;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f42671;

    public C06609() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f42639 = this;
        f42639.mo840("E4A");
        f42639.mo797(-1);
        f42639.m5096(IntegerVariant.getIntegerVariant(4));
        f42639.mo838(1);
        f42639.mo826(false);
        C0792Impl c0792Impl = new C0792Impl(f42639);
        Objects.initializeProperties(c0792Impl);
        this.f42661 = c0792Impl;
        C0713Impl c0713Impl = new C0713Impl(f42639);
        Objects.initializeProperties(c0713Impl);
        this.f42671 = c0713Impl;
        this.f42671.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42671.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42671.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42671.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42671.mo776(true);
        C0742Impl c0742Impl = new C0742Impl(f42639);
        Objects.initializeProperties(c0742Impl);
        this.f42651 = c0742Impl;
        this.f42651.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.023d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42651.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.014d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42651.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42651.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42651.mo797(0);
        this.f42651.mo1143(1);
        this.f42651.mo1139("icon01.png");
        this.f42651.mo776(true);
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "窗口9", "创建完毕");
        EventDispatcher.registerEvent(this, "窗口9", "按下某键");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        EventDispatcher.registerEvent(this, "浏览框1", "即将跳转");
        f42639.mo765();
        this.f42661.mo765();
        this.f42671.mo765();
        this.f42651.mo765();
    }

    /* renamed from: 窗口9$创建完毕 */
    public void m53509$() {
        String h = bi_常量类.f6358b_空串;
        this.f42671.mo768();
        this.f42671.mo782(0);
        this.f42671.mo804(0);
        this.f42651.mo768();
        this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
        this.f42671.mo780(C0894.m6882());
        this.f42671.mo806(C0894.m6884());
        this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
        this.f42671.mo960JS("e4a");
        if (!C0897_网络操作.m6920_取网络状态()) {
            return;
        }
        if (C0898_读写设置类.m6937_通过SP读取设置("你好").getString().equals(C0108a.f262e)) {
            this.f42671.mo976(this.wl + "/web/neice/gaojineice1.html");
            return;
        }
        this.f4264p = C0897_网络操作.m6922(this.wl + "/1.txt", "GBK", 2000);
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f4264p, "alifangxiang", 1)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f42671.mo976((((this.wl + "/web/city/") + this.zz) + "/huiyuan/index.asp?mei=") + this.f42661.mo1395IMEI());
        } else {
            C0880_应用操作类.m6694("网络不稳定");
        }
    }

    /* renamed from: 窗口9$按下某键 */
    public void m53519$(int i, BooleanReferenceParameter booleanReferenceParameter) {
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

    /* renamed from: 浏览框1$即将跳转 */
    public void m53481$(String str, IntegerReferenceParameter integerReferenceParameter) {
        int 方式 = integerReferenceParameter.get();
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "gaojineice", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0898_读写设置类.m6935_通过SP保存设置("你好", StringVariant.getStringVariant(C0108a.f262e));
        }
        integerReferenceParameter.set(方式);
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m53491$(String 网页消息) {
        try {
            if (C0890_文本操作.m6815(网页消息, 1).equals("a")) {
                网页消息 = C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(网页消息, "路", bi_常量类.f6358b_空串), "快", "k"), "线", bi_常量类.f6358b_空串), "环", "h");
                if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页消息, "ji", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                    C0898_读写设置类.m6935_通过SP保存设置("高级", StringVariant.getStringVariant(C0108a.f262e));
                    网页消息 = C0890_文本操作.m6819(网页消息, "gaoji", bi_常量类.f6358b_空串);
                    this.idc = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
                    if (IntegerVariant.getIntegerVariant(this.idc).cmp(ByteVariant.getByteVariant((byte) 20)) < 0) {
                        this.ddv = C0879.m66692("提示", "您的积分不足", "如何获取积分", "退出");
                        if (IntegerVariant.getIntegerVariant(this.ddv).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
                            C0897_网络操作.m6927_打开指定网址("http://www.gongjiaomishu.com/hexin.html");
                            return;
                        }
                        return;
                    }
                }
                C0898_读写设置类.m6935_通过SP保存设置("高级", StringVariant.getStringVariant("0"));
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

    /* renamed from: 图片框1$被单击 */
    public void m53471$() {
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }
}
