package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0843_加密操作;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0881;
import com.e4a.runtime.C0889_文件操作;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0891;
import com.e4a.runtime.C0893_算术运算;
import com.e4a.runtime.C0894;
import com.e4a.runtime.C0897_网络操作;
import com.e4a.runtime.C0898_读写设置类;
import com.e4a.runtime.C0899_转换操作;
import com.e4a.runtime.Objects;
import com.e4a.runtime.annotations.SimpleDataElement;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.n12.C0696;
import com.e4a.runtime.components.impl.android.n12.C0697Impl;
import com.e4a.runtime.components.impl.android.n15.C0698;
import com.e4a.runtime.components.impl.android.n15.C0713Impl;
import com.e4a.runtime.components.impl.android.n3.C0723;
import com.e4a.runtime.components.impl.android.n3.C0725Impl;
import com.e4a.runtime.components.impl.android.n4.C0739_图片框;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.parameters.IntegerReferenceParameter;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.LongVariant;
import com.e4a.runtime.variants.ShortVariant;
import com.tencent.smtt.sdk.WebView;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口6.code */
/* renamed from: com.chedaole.窗口6 */
public class C06576 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口6 */
    public static C0644 f42246;
    @SimpleDataElement
    public String huo = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: i */
    public int f4225i;
    @SimpleDataElement
    /* renamed from: v */
    public int f4226v;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 启动时间 */
    public long f4227;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739_图片框 f42281;
    @SimpleDataElement
    /* renamed from: 图片框2 */
    public C0739_图片框 f42292;
    @SimpleDataElement
    /* renamed from: 时钟1 */
    public C0696 f42301;
    @SimpleDataElement
    /* renamed from: 标签1 */
    public C0723 f42311;
    @SimpleDataElement
    /* renamed from: 标签2 */
    public C0723 f42322;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f42331;

    public C06576() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f42246 = this;
        f42246.mo840("E4A");
        f42246.mo797_背景颜色(-1);
        f42246.m5096(IntegerVariant.getIntegerVariant(4));
        f42246.mo838(1);
        f42246.mo826(false);
        C0713Impl c0713Impl = new C0713Impl(f42246);
        Objects.initializeProperties(c0713Impl);
        this.f42331 = c0713Impl;
        this.f42331.mo782((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42331.mo804((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42331.mo780((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42331.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.919d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42331.mo776_可视(true);
        C0697Impl c0697Impl = new C0697Impl(f42246);
        Objects.initializeProperties(c0697Impl);
        this.f42301 = c0697Impl;
        this.f42301.mo928(0);
        C0742Impl c0742Impl = new C0742Impl(f42246);
        Objects.initializeProperties(c0742Impl);
        this.f42292 = c0742Impl;
        this.f42292.mo782((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42292.mo804((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42292.mo780((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42292.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42292.mo797_背景颜色(-16742145);
        this.f42292.mo1143(1);
        this.f42292.mo1139("VAL.jpg");
        this.f42292.mo776_可视(true);
        c0742Impl = new C0742Impl(f42246);
        Objects.initializeProperties(c0742Impl);
        this.f42281 = c0742Impl;
        this.f42281.mo782((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.9d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42281.mo804((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.017d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42281.mo780((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42281.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42281.mo797_背景颜色(0);
        this.f42281.mo1143(1);
        this.f42281.mo1139("TRT.png");
        this.f42281.mo776_可视(true);
        C0725Impl c0725Impl = new C0725Impl(f42246);
        Objects.initializeProperties(c0725Impl);
        this.f42322 = c0725Impl;
        this.f42322.mo782((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.133d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42322.mo804((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42322.mo780((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.1d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42322.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42322.mo895("积分兑换");
        this.f42322.mo797_背景颜色(0);
        this.f42322.mo889_字体颜色(-16777216);
        this.f42322.mo896(false);
        this.f42322.mo892(false);
        this.f42322.mo891_对齐方式(7);
        this.f42322.mo1049_字体大小(12.0f);
        this.f42322.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42322.mo776_可视(false);
        c0725Impl = new C0725Impl(f42246);
        Objects.initializeProperties(c0725Impl);
        this.f42311 = c0725Impl;
        this.f42311.mo782((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.21d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42311.mo804((int) C0893_算术运算.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42311.mo780((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.617d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42311.mo806((int) C0893_算术运算.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42311.mo895(bi_常量类.f6358b_空串);
        this.f42311.mo797_背景颜色(0);
        this.f42311.mo889_字体颜色(-1);
        this.f42311.mo896(false);
        this.f42311.mo892(false);
        this.f42311.mo891_对齐方式(7);
        this.f42311.mo1049_字体大小(12.0f);
        this.f42311.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42311.mo776_可视(true);
        EventDispatcher.registerEvent(this, "图片框2", "被单击");
        EventDispatcher.registerEvent(this, "窗口6", "按下某键");
        EventDispatcher.registerEvent(this, "窗口6", "切换完毕");
        EventDispatcher.registerEvent(this, "时钟1", "周期事件");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "浏览框1", "开始载入");
        EventDispatcher.registerEvent(this, "标签2", "被单击");
        EventDispatcher.registerEvent(this, "窗口6", "创建完毕");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        EventDispatcher.registerEvent(this, "浏览框1", "即将跳转");
        f42246.mo765();
        this.f42331.mo765();
        this.f42301.mo765();
        this.f42292.mo765();
        this.f42281.mo765();
        this.f42322.mo765();
        this.f42311.mo765();
    }

    /* renamed from: 浏览框1$即将跳转 */
    public void m53231$(String str, IntegerReferenceParameter integerReferenceParameter) {
        int 方式 = integerReferenceParameter.get();
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821_寻找文本(str, "uland.taobao.com", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0897_网络操作.m6927_打开指定网址(str);
        }
        integerReferenceParameter.set(方式);
    }

    /* renamed from: 浏览框1$开始载入 */
    public void m53241$(String 地址) {
        if (C0890_文本操作.m6816(地址, 6).equals("weixin")) {
            C0897_网络操作.m6927_打开指定网址(地址);
            this.f42331.mo976(this.huo);
            this.f42331.mo936();
        }
    }

    /* renamed from: 窗口6$切换完毕 */
    public void m53266$() {
        this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
        this.f42301.mo928(6000);
        if (this.zz.equals("haerbin")) {
            this.f42301.mo928(0);
            this.f42311.mo895("公交淘宝");
        }
    }

    /* renamed from: 窗口6$按下某键 */
    public void m53286$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        if (i == 4) {
            if (LongVariant.getLongVariant(C0891.m6826() - this.f4227).cmp(ShortVariant.getShortVariant((short) 2000)) > 0) {
                this.f4227 = C0891.m6826();
                this.f42331.mo952();
            } else {
                this.f42301.mo928(0);
                C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
            }
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 窗口6$创建完毕 */
    public void m53276$() {
        String f = bi_常量类.f6358b_空串;
        String p = bi_常量类.f6358b_空串;
        String gg = bi_常量类.f6358b_空串;
        String ggb = bi_常量类.f6358b_空串;
        this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
        this.f42331.mo976(C0897_网络操作.m6922(this.wl + "/taokea.txt", "utf-8", 5000));
        this.f42331.mo960JS("hua");
        this.f42301.mo928(6000);
        this.f42322.mo895("积分 ▼");
        if (!C0889_文件操作.m6797_文件是否存在(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tent.txt")) {
            C0889_文件操作.m6783_创建文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tent.txt");
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tent.txt", C0843_加密操作.m6603Authcode("0", "yangbosen123"), "UTF-8");
        }
        if (!C0889_文件操作.m6797_文件是否存在(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tentz.txt")) {
            C0889_文件操作.m6783_创建文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tentz.txt");
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tentz.txt", C0843_加密操作.m6603Authcode(C0108a.f262e, "yangbosen123"), "UTF-8");
        }
        if (!C0889_文件操作.m6797_文件是否存在(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt")) {
            C0889_文件操作.m6783_创建文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt");
            this.f4225i = 0;
        }
        this.f4225i = (int) C0899_转换操作.m6943(C0843_加密操作.m6604Authcode_Authcode解密(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
        this.f42311.mo895(C0890_文本操作.m6819_子文本替换("我的积分：" + C0899_转换操作.m6945_转文本((double) this.f4225i), ".0", bi_常量类.f6358b_空串));
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821_寻找文本(C0897_网络操作.m6922(this.wl + "/1.txt", "GBK", 5000), "alifangxiang", 1)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            gg = C0897_网络操作.m6922(this.wl + "/taokeshi.txt", "utf-8", 5000);
            if (!gg.equals(C0843_加密操作.m6604Authcode_Authcode解密(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tent.txt", "UTF-8"), "yangbosen123"))) {
                C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tent.txt", C0843_加密操作.m6603Authcode(gg, "yangbosen123"), "UTF-8");
                C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tentz.txt", C0843_加密操作.m6603Authcode("0", "yangbosen123"), "UTF-8");
            }
        } else {
            C0880_应用操作类.m6694("网络不稳定");
        }
        this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
        if (this.zz.equals("haerbin")) {
            this.f42301.mo928(0);
            this.f42311.mo895("公交淘宝");
        }
        this.huo = C0897_网络操作.m6922(this.wl + "/huo.txt", "UTF-8", 5000);
    }

    /* renamed from: 时钟1$周期事件 */
    public void m53211$() {
        this.f4226v = (int) C0899_转换操作.m6943(C0843_加密操作.m6604Authcode_Authcode解密(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tentz.txt", "UTF-8"), "yangbosen123"));
        this.f4226v = IntegerVariant.getIntegerVariant(this.f4226v).add(ByteVariant.getByteVariant((byte) 2)).getInteger();
        if (IntegerVariant.getIntegerVariant(this.f4226v).cmp(ShortVariant.getShortVariant((short) 200)) > 0) {
            this.f4225i = (int) C0899_转换操作.m6943(C0843_加密操作.m6604Authcode_Authcode解密(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
            this.f42311.mo895(C0890_文本操作.m6819_子文本替换("我的积分：" + C0899_转换操作.m6945_转文本((double) this.f4225i), ".0", bi_常量类.f6358b_空串));
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tentz.txt", C0843_加密操作.m6603Authcode(C0899_转换操作.m6945_转文本((double) this.f4226v), "yangbosen123"), "UTF-8");
            return;
        }
        C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tentz.txt", C0843_加密操作.m6603Authcode(C0899_转换操作.m6945_转文本((double) this.f4226v), "yangbosen123"), "UTF-8");
        this.f4225i = (int) C0899_转换操作.m6943(C0843_加密操作.m6604Authcode_Authcode解密(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
        this.f4225i = IntegerVariant.getIntegerVariant(this.f4225i).add(ByteVariant.getByteVariant((byte) 2)).getInteger();
        this.f42311.mo895(C0890_文本操作.m6819_子文本替换("我的积分：" + C0899_转换操作.m6945_转文本((double) this.f4225i), ".0", bi_常量类.f6358b_空串));
        C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843_加密操作.m6603Authcode(C0899_转换操作.m6945_转文本((double) this.f4225i), "yangbosen123"), "UTF-8");
    }

    /* renamed from: 图片框1$被单击 */
    public void m53191$() {
        String f = bi_常量类.f6358b_空串;
        this.f42331.mo976(C0897_网络操作.m6922(this.wl + "/taokea.txt", "utf-8", 5000));
    }

    /* renamed from: 标签2$被单击 */
    public void m53222$() {
        if (C0880_应用操作类.m6712("窗口7") == null) {
            C0880_应用操作类.m6692("窗口7", new C06587());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口7"));
    }

    /* renamed from: 图片框2$被单击 */
    public void m53202$() {
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m53251$(String 网页消息) {
        String fff = bi_常量类.f6358b_空串;
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821_寻找文本(网页消息, "bao", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            fff = C0894.m6881();
            C0881.m6734("com.taobao.taobao");
            C0894.m6900(fff);
            C0894.m6896(2000);
            C0894.m6900(fff);
        }
    }
}
