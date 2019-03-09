package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0889_文件操作;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0893_算术运算;
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
import com.e4a.runtime.components.impl.android.n2.C0717;
import com.e4a.runtime.components.impl.android.n2.C0722Impl;
import com.e4a.runtime.components.impl.android.n3.C0723;
import com.e4a.runtime.components.impl.android.n3.C0725Impl;
import com.e4a.runtime.components.impl.android.n4.C0739_图片框;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.components.impl.android.n83.C0775;
import com.e4a.runtime.components.impl.android.n83.C0776Impl;
import com.e4a.runtime.errors.RuntimeError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.StringVariant;
import com.tencent.smtt.sdk.WebView;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 主窗口.code */
/* renamed from: com.chedaole.主窗口 */
public class C0646 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 主窗口 */
    public static C0644 f3946;
    @SimpleDataElement
    /* renamed from: s */
    public String f3947s = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 友盟统计1 */
    public C0775 f39481;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739_图片框 f39491;
    @SimpleDataElement
    /* renamed from: 图片框2 */
    public C0739_图片框 f39502;
    @SimpleDataElement
    /* renamed from: 图片框3 */
    public C0739_图片框 f39513;
    @SimpleDataElement
    /* renamed from: 图片框4 */
    public C0739_图片框 f39524;
    @SimpleDataElement
    /* renamed from: 图片框5 */
    public C0739_图片框 f39535;
    @SimpleDataElement
    /* renamed from: 时钟1 */
    public C0696 f39541;
    @SimpleDataElement
    /* renamed from: 标签1 */
    public C0723 f39551;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f39561;
    @SimpleDataElement
    /* renamed from: 编辑框1 */
    public C0717 f39571;
    @SimpleDataElement
    /* renamed from: 返据 */
    public String f3958 = bi_常量类.f6358b_空串;

    public C0646() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f3946 = this;
        f3946.mo840("E4A");
        f3946.mo797_背景颜色(-1);
        f3946.m5096(IntegerVariant.getIntegerVariant(4));
        f3946.mo838(1);
        f3946.mo826(false);
        C0742Impl c0742Impl = new C0742Impl(f3946);
        Objects.initializeProperties(c0742Impl);
        this.f39491 = c0742Impl;
        this.f39491.mo782((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39491.mo804((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39491.mo780((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39491.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(1.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39491.mo797_背景颜色(0);
        this.f39491.mo1143(1);
        this.f39491.mo1139("zhuy.jpg");
        this.f39491.mo776_可视(true);
        c0742Impl = new C0742Impl(f3946);
        Objects.initializeProperties(c0742Impl);
        this.f39502 = c0742Impl;
        this.f39502.mo782((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.344d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39502.mo804((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.434d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39502.mo780((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.3d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39502.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39502.mo797_背景颜色(0);
        this.f39502.mo1143(1);
        this.f39502.mo1139("rj.png");
        this.f39502.mo776_可视(true);
        c0742Impl = new C0742Impl(f3946);
        Objects.initializeProperties(c0742Impl);
        this.f39513 = c0742Impl;
        this.f39513.mo782((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.344d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39513.mo804((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.526d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39513.mo780((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.3d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39513.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39513.mo797_背景颜色(0);
        this.f39513.mo1143(1);
        this.f39513.mo1139("qh.png");
        this.f39513.mo776_可视(true);
        C0713Impl c0713Impl = new C0713Impl(f3946);
        Objects.initializeProperties(c0713Impl);
        this.f39561 = c0713Impl;
        this.f39561.mo782((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39561.mo804((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39561.mo780((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39561.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39561.mo776_可视(false);
        C0722Impl c0722Impl = new C0722Impl(f3946);
        Objects.initializeProperties(c0722Impl);
        this.f39571 = c0722Impl;
        this.f39571.mo782((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39571.mo804((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.857d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39571.mo780((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.533d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39571.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39571.mo887_内容(bi_常量类.f6358b_空串);
        this.f39571.mo889_字体颜色(-1);
        this.f39571.mo896(false);
        this.f39571.mo892(false);
        this.f39571.mo1020(13.0f);
        this.f39571.mo774(false);
        this.f39571.mo1041(1);
        this.f39571.mo891_对齐方式(3);
        this.f39571.mo772(true);
        this.f39571.mo1023("百度一下");
        this.f39571.mo1035("txt.png");
        this.f39571.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f39571.mo776_可视(false);
        c0742Impl = new C0742Impl(f3946);
        Objects.initializeProperties(c0742Impl);
        this.f39524 = c0742Impl;
        this.f39524.mo782((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.675d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39524.mo804((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.857d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39524.mo780((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.183d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39524.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39524.mo797_背景颜色(0);
        this.f39524.mo1143(1);
        this.f39524.mo1139("quan.png");
        this.f39524.mo776_可视(false);
        c0742Impl = new C0742Impl(f3946);
        Objects.initializeProperties(c0742Impl);
        this.f39535 = c0742Impl;
        this.f39535.mo782((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.306d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39535.mo804((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.766d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39535.mo780((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.383d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39535.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.075d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39535.mo797_背景颜色(0);
        this.f39535.mo1143(1);
        this.f39535.mo1139("ti.png");
        this.f39535.mo776_可视(true);
        C0725Impl c0725Impl = new C0725Impl(f3946);
        Objects.initializeProperties(c0725Impl);
        this.f39551 = c0725Impl;
        this.f39551.mo782((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39551.mo804((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39551.mo780((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39551.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39551.mo895(bi_常量类.f6358b_空串);
        this.f39551.mo797_背景颜色(0);
        this.f39551.mo889_字体颜色(-16777216);
        this.f39551.mo896(false);
        this.f39551.mo892(false);
        this.f39551.mo891_对齐方式(4);
        this.f39551.mo1049_字体大小(9.0f);
        this.f39551.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f39551.mo776_可视(true);
        C0697Impl c0697Impl = new C0697Impl(f3946);
        Objects.initializeProperties(c0697Impl);
        this.f39541 = c0697Impl;
        this.f39541.mo928(0);
        C0776Impl c0776Impl = new C0776Impl(f3946);
        Objects.initializeProperties(c0776Impl);
        this.f39481 = c0776Impl;
        EventDispatcher.registerEvent(this, "图片框4", "被单击");
        EventDispatcher.registerEvent(this, "图片框2", "被单击");
        EventDispatcher.registerEvent(this, "图片框3", "被单击");
        EventDispatcher.registerEvent(this, "时钟1", "周期事件");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "图片框5", "被单击");
        EventDispatcher.registerEvent(this, "主窗口", "创建完毕");
        EventDispatcher.registerEvent(this, "主窗口", "按下某键");
        f3946.mo765();
        this.f39491.mo765();
        this.f39502.mo765();
        this.f39513.mo765();
        this.f39561.mo765();
        this.f39571.mo765();
        this.f39524.mo765();
        this.f39535.mo765();
        this.f39551.mo765();
        this.f39541.mo765();
        this.f39481.mo765();
    }

    /* renamed from: 主窗口$按下某键 */
    public void m5167$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        try {
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                this.f39561.mo982();
                C0880_应用操作类.m6703();
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 主窗口$创建完毕 */
    public void m5166$() {
        String dd = bi_常量类.f6358b_空串;
        String 数 = bi_常量类.f6358b_空串;
        String 地址 = bi_常量类.f6358b_空串;
        this.zz = bi_常量类.f6358b_空串;
        this.f3947s = "0";
        this.zz = "daqing";
        C0898_读写设置类.m6935_通过SP保存设置("城市", StringVariant.getStringVariant(this.zz));
        C0898_读写设置类.m6935_通过SP保存设置("成", StringVariant.getStringVariant(this.zz));
        C0898_读写设置类.m6935_通过SP保存设置("网", StringVariant.getStringVariant("http://gongjiaomishu.com"));
        数 = C0897_网络操作.m6922(("http://gongjiaomishu.com/web/city/" + this.zz) + "/1.asp", "GBK", 5000);
        if (数.equals(bi_常量类.f6358b_空串)) {
            this.f3958 = C0897_网络操作.m6922(("http://wo.gongjiaoyouxi.com/web/city/" + this.zz) + "/ver1.txt", "GBK", 5000);
            if (this.f3958.equals(bi_常量类.f6358b_空串)) {
                C0880_应用操作类.m6694("当前网络不稳定");
                return;
            } else {
                数 = C0897_网络操作.m6922(((this.f3958 + "/web/city/") + this.zz) + "/1.asp", "GBK", 2000);
                C0898_读写设置类.m6935_通过SP保存设置("网", StringVariant.getStringVariant(this.f3958));
            }
        }
        C0898_读写设置类.m6935_通过SP保存设置("冠名", StringVariant.getStringVariant("0"));
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821_寻找文本(数, "zhuye", 1)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f39561.mo806(C0894.m6884());
            this.f39561.mo780(C0894.m6882());
            this.f39561.mo782(0);
            this.f39561.mo804(0);
            this.f39561.mo768();
            this.f39561.mo960JS("aliz");
            this.f39561.mo776_可视(true);
            this.f39561.mo774(true);
            this.f39561.mo976(m5168(数, "k6", "k7"));
            this.f39541.mo928(4000);
        }
        this.f39551.mo895(C0890_文本操作.m6819_子文本替换(m5168(数, "k1", "k2"), ".0", bi_常量类.f6358b_空串));
        this.f39481.mo1302("57fb93d267e58e1b730025b1", "Umeng");
        this.f39481.mo1303("主窗口");
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m51741$(String 网页消息) {
        if (C0890_文本操作.m6816(网页消息, 4).equals("http")) {
            C0897_网络操作.m6927_打开指定网址(网页消息);
        }
        if (C0890_文本操作.m6816(网页消息, 4).equals("guan")) {
            this.f39561.mo776_可视(false);
            this.f39561.mo774(false);
        }
    }

    /* renamed from: 图片框2$被单击 */
    public void m51692$() {
        String wl = bi_常量类.f6358b_空串;
        wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
        C0889_文件操作.m6786(C0852_存储卡类.m6665_取存储卡路径() + "/cityisba");
        C0879.m6668("软件修复", "路线更新修复完毕!", "确认");
    }

    /* renamed from: 图片框3$被单击 */
    public void m51703$() {
        if (C0880_应用操作类.m6712("窗口12") == null) {
            C0880_应用操作类.m6692("窗口12", new C064912());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口12"));
    }

    /* renamed from: 图片框4$被单击 */
    public void m51714$() {
        C0897_网络操作.m6927_打开指定网址("https://m.baidu.com/from=844b/s?word=" + this.f39571.mo886_内容());
    }

    /* renamed from: 图片框5$被单击 */
    public void m51725$() {
        try {
            if (this.zz.equals(bi_常量类.f6358b_空串)) {
                if (this.f3947s.equals(C0108a.f262e)) {
                    C0880_应用操作类.m6694("位置获取失败,请手动选择城市");
                    if (C0880_应用操作类.m6712("窗口12") == null) {
                        C0880_应用操作类.m6692("窗口12", new C064912());
                    }
                    C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口12"));
                }
                C0880_应用操作类.m6694("位置获取请稍等....");
                this.f3947s = C0108a.f262e;
                return;
            }
            if (C0880_应用操作类.m6712("窗口3") == null) {
                C0880_应用操作类.m6692("窗口3", new C06543());
            }
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 取中间文本 */
    public String m5168(String 完整内容, String 左边文本, String 右边文本) {
        String 取中间文本 = bi_常量类.f6358b_空串;
        int 左边 = C0890_文本操作.m6821_寻找文本(完整内容, 左边文本, 0) + C0890_文本操作.m6817_获取字符串长度(左边文本);
        if (IntegerVariant.getIntegerVariant(左边).cmp(ByteVariant.getByteVariant((byte) -1)) == 0) {
            return bi_常量类.f6358b_空串;
        }
        int 右边 = C0890_文本操作.m6821_寻找文本(完整内容, 右边文本, 左边);
        if (IntegerVariant.getIntegerVariant(右边).cmp(ByteVariant.getByteVariant((byte) -1)) == 0 || 左边 > 右边) {
            return bi_常量类.f6358b_空串;
        }
        return C0890_文本操作.m6814_截取子串(完整内容, 左边, 右边 - 左边);
    }

    /* renamed from: 时钟1$周期事件 */
    public void m51731$() {
        this.f39541.mo928(0);
        this.f39561.mo776_可视(false);
        this.f39561.mo774(false);
    }
}
