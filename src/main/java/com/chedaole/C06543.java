package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.amap.api.services.district.DistrictSearchQuery;
import com.e4a.runtime.C0844;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0881;
import com.e4a.runtime.C0888_数组操作;
import com.e4a.runtime.C0889_文件操作;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0891;
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
import com.e4a.runtime.components.impl.android.n12.C0696;
import com.e4a.runtime.components.impl.android.n12.C0697Impl;
import com.e4a.runtime.components.impl.android.n15.C0698;
import com.e4a.runtime.components.impl.android.n15.C0713Impl;
import com.e4a.runtime.components.impl.android.n18.C0714;
import com.e4a.runtime.components.impl.android.n18.C0716Impl;
import com.e4a.runtime.components.impl.android.n3.C0723;
import com.e4a.runtime.components.impl.android.n3.C0725Impl;
import com.e4a.runtime.components.impl.android.n36.C0733;
import com.e4a.runtime.components.impl.android.n36.C0735Impl;
import com.e4a.runtime.components.impl.android.n4.C0739;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.components.impl.android.n73.C0768;
import com.e4a.runtime.components.impl.android.n73.C0770Impl;
import com.e4a.runtime.errors.RuntimeError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.variants.ArrayVariant;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.LongVariant;
import com.e4a.runtime.variants.ShortVariant;
import com.e4a.runtime.variants.StringVariant;
import com.tencent.smtt.sdk.WebView;
import java.util.Calendar;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口3.code */
/* renamed from: com.chedaole.窗口3 */
public class C06543 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口3 */
    public static C0644 f41373;
    @SimpleDataElement
    public String ab = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: d */
    public String f4138d = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: e */
    public String f4139e = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String fcv = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: h */
    public String f4140h = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: i */
    public int f4141i;
    @SimpleDataElement
    /* renamed from: j */
    public String[] f4142j;
    @SimpleDataElement
    /* renamed from: o */
    public int f4143o;
    @SimpleDataElement
    public String tozhi = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: v */
    public int f4144v;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: x */
    public String f4145x = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: y */
    public int f4146y;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zz1 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 下载器1 */
    public C0733 f41471;
    @SimpleDataElement
    /* renamed from: 下载器2 */
    public C0733 f41482;
    @SimpleDataElement
    /* renamed from: 公告 */
    public String f4149 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 分享对象 */
    public int f4150;
    @SimpleDataElement
    /* renamed from: 列表框1 */
    public C0714 f41511;
    @SimpleDataElement
    /* renamed from: 启动时间 */
    public long f4152;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f41531;
    @SimpleDataElement
    /* renamed from: 图片框10 */
    public C0739 f415410;
    @SimpleDataElement
    /* renamed from: 图片框11 */
    public C0739 f415511;
    @SimpleDataElement
    /* renamed from: 图片框12 */
    public C0739 f415612;
    @SimpleDataElement
    /* renamed from: 图片框13 */
    public C0739 f415713;
    @SimpleDataElement
    /* renamed from: 图片框14 */
    public C0739 f415814;
    @SimpleDataElement
    /* renamed from: 图片框15 */
    public C0739 f415915;
    @SimpleDataElement
    /* renamed from: 图片框16 */
    public C0739 f416016;
    @SimpleDataElement
    /* renamed from: 图片框17 */
    public C0739 f416117;
    @SimpleDataElement
    /* renamed from: 图片框18 */
    public C0739 f416218;
    @SimpleDataElement
    /* renamed from: 图片框19 */
    public C0739 f416319;
    @SimpleDataElement
    /* renamed from: 图片框2 */
    public C0739 f41642;
    @SimpleDataElement
    /* renamed from: 图片框20 */
    public C0739 f416520;
    @SimpleDataElement
    /* renamed from: 图片框21 */
    public C0739 f416621;
    @SimpleDataElement
    /* renamed from: 图片框22 */
    public C0739 f416722;
    @SimpleDataElement
    /* renamed from: 图片框23 */
    public C0739 f416823;
    @SimpleDataElement
    /* renamed from: 图片框3 */
    public C0739 f41693;
    @SimpleDataElement
    /* renamed from: 图片框4 */
    public C0739 f41704;
    @SimpleDataElement
    /* renamed from: 图片框5 */
    public C0739 f41715;
    @SimpleDataElement
    /* renamed from: 图片框6 */
    public C0739 f41726;
    @SimpleDataElement
    /* renamed from: 图片框7 */
    public C0739 f41737;
    @SimpleDataElement
    /* renamed from: 图片框8 */
    public C0739 f41748;
    @SimpleDataElement
    /* renamed from: 图片框9 */
    public C0739 f41759;
    @SimpleDataElement
    /* renamed from: 地 */
    public String f4176 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 地点 */
    public String f4177 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 天 */
    public String f4178 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 天气 */
    public String f4179 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 数 */
    public String f4180 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 新 */
    public Calendar f4181;
    @SimpleDataElement
    /* renamed from: 时钟1 */
    public C0696 f41821;
    @SimpleDataElement
    /* renamed from: 时钟2 */
    public C0696 f41832;
    @SimpleDataElement
    /* renamed from: 标签1 */
    public C0723 f41841;
    @SimpleDataElement
    /* renamed from: 标签2 */
    public C0723 f41852;
    @SimpleDataElement
    /* renamed from: 标签3 */
    public C0723 f41863;
    @SimpleDataElement
    /* renamed from: 标签4 */
    public C0723 f41874;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f41881;
    @SimpleDataElement
    /* renamed from: 浏览框2 */
    public C0698 f41892;
    @SimpleDataElement
    /* renamed from: 浏览框3 */
    public C0698 f41903;
    @SimpleDataElement
    /* renamed from: 温度 */
    public String f4191 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 状态栏通知1 */
    public C0768 f41921;
    @SimpleDataElement
    /* renamed from: 风 */
    public String f4193 = bi_常量类.f6358b_空串;

    public C06543() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f41373 = this;
        f41373.mo840("E4A");
        f41373.mo797_背景颜色(-1);
        f41373.m5096(IntegerVariant.getIntegerVariant(4));
        f41373.mo838(1);
        f41373.mo826(false);
        C0742Impl c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f416016 = c0742Impl;
        this.f416016.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.983d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416016.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.403d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416016.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.033d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416016.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.382d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416016.mo797_背景颜色(-1052689);
        this.f416016.mo1143(1);
        this.f416016.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f416520 = c0742Impl;
        this.f416520.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416520.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.366d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416520.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416520.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.537d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416520.mo797_背景颜色(-1052684);
        this.f416520.mo1143(1);
        this.f416520.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f416621 = c0742Impl;
        this.f416621.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416621.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.399d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416621.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416621.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.445d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416621.mo797_背景颜色(-16742145);
        this.f416621.mo1143(1);
        this.f416621.mo1139("zeee.jpg");
        this.f416621.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f415713 = c0742Impl;
        this.f415713.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415713.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.853d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415713.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415713.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.154d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415713.mo797_背景颜色(-16742145);
        this.f415713.mo1143(1);
        this.f415713.mo1139("zz_32.jpg");
        this.f415713.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41531 = c0742Impl;
        this.f41531.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41531.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41531.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41531.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41531.mo797_背景颜色(0);
        this.f41531.mo1143(1);
        this.f41531.mo1139("23ee.jpg");
        this.f41531.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41642 = c0742Impl;
        this.f41642.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41642.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41642.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41642.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.254d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41642.mo797_背景颜色(-16742145);
        this.f41642.mo1143(1);
        this.f41642.mo1139("banner.png");
        this.f41642.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41693 = c0742Impl;
        this.f41693.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41693.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.345d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41693.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41693.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.048d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41693.mo797_背景颜色(-1);
        this.f41693.mo1143(1);
        this.f41693.mo776_可视(true);
        C0725Impl c0725Impl = new C0725Impl(f41373);
        Objects.initializeProperties(c0725Impl);
        this.f41852 = c0725Impl;
        this.f41852.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41852.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.901d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41852.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41852.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.103d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41852.mo895("单击进入路线/长按删除路线");
        this.f41852.mo797_背景颜色(-8355712);
        this.f41852.mo889_字体颜色(-1);
        this.f41852.mo896(false);
        this.f41852.mo892(false);
        this.f41852.mo891_对齐方式(7);
        this.f41852.mo1049_字体大小(11.0f);
        this.f41852.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41852.mo776_可视(true);
        C0735Impl c0735Impl = new C0735Impl(f41373);
        Objects.initializeProperties(c0735Impl);
        this.f41471 = c0735Impl;
        c0735Impl = new C0735Impl(f41373);
        Objects.initializeProperties(c0735Impl);
        this.f41482 = c0735Impl;
        C0713Impl c0713Impl = new C0713Impl(f41373);
        Objects.initializeProperties(c0713Impl);
        this.f41881 = c0713Impl;
        this.f41881.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.05d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41881.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.248d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41881.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.067d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41881.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41881.mo776_可视(true);
        c0713Impl = new C0713Impl(f41373);
        Objects.initializeProperties(c0713Impl);
        this.f41892 = c0713Impl;
        this.f41892.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.983d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41892.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.32d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41892.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.017d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41892.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41892.mo776_可视(true);
        C0697Impl c0697Impl = new C0697Impl(f41373);
        Objects.initializeProperties(c0697Impl);
        this.f41821 = c0697Impl;
        this.f41821.mo928(0);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f415915 = c0742Impl;
        this.f415915.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.894d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415915.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.009d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415915.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.094d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415915.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415915.mo797_背景颜色(0);
        this.f415915.mo1143(1);
        this.f415915.mo1139("notice2.png");
        this.f415915.mo776_可视(true);
        c0725Impl = new C0725Impl(f41373);
        Objects.initializeProperties(c0725Impl);
        this.f41863 = c0725Impl;
        this.f41863.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41863.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.348d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41863.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41863.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41863.mo895(bi_常量类.f6358b_空串);
        this.f41863.mo797_背景颜色(-1);
        this.f41863.mo889_字体颜色(-6908266);
        this.f41863.mo896(false);
        this.f41863.mo892(false);
        this.f41863.mo891_对齐方式(7);
        this.f41863.mo1049_字体大小(9.0f);
        this.f41863.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41863.mo776_可视(true);
        c0725Impl = new C0725Impl(f41373);
        Objects.initializeProperties(c0725Impl);
        this.f41874 = c0725Impl;
        this.f41874.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41874.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.008d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41874.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.233d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41874.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41874.mo895(bi_常量类.f6358b_空串);
        this.f41874.mo797_背景颜色(0);
        this.f41874.mo889_字体颜色(-1);
        this.f41874.mo896(false);
        this.f41874.mo892(false);
        this.f41874.mo891_对齐方式(7);
        this.f41874.mo1049_字体大小(9.0f);
        this.f41874.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41874.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f415814 = c0742Impl;
        this.f415814.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(-0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415814.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.39d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415814.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.017d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415814.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.361d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415814.mo797_背景颜色(-1052689);
        this.f415814.mo1143(1);
        this.f415814.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f416117 = c0742Impl;
        this.f416117.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.946d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416117.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.018d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416117.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.025d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416117.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.015d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416117.mo797_背景颜色(0);
        this.f416117.mo1143(1);
        this.f416117.mo1139("ddd.png");
        this.f416117.mo776_可视(false);
        C0770Impl c0770Impl = new C0770Impl(f41373);
        Objects.initializeProperties(c0770Impl);
        this.f41921 = c0770Impl;
        c0697Impl = new C0697Impl(f41373);
        Objects.initializeProperties(c0697Impl);
        this.f41832 = c0697Impl;
        this.f41832.mo928(0);
        c0713Impl = new C0713Impl(f41373);
        Objects.initializeProperties(c0713Impl);
        this.f41903 = c0713Impl;
        this.f41903.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.367d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41903.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41903.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.283d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41903.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41903.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41737 = c0742Impl;
        this.f41737.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.763d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41737.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.41d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41737.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41737.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41737.mo797_背景颜色(-16742145);
        this.f41737.mo1143(1);
        this.f41737.mo1139("zz_07.jpg");
        this.f41737.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f415410 = c0742Impl;
        this.f415410.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.09d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415410.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.52d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415410.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415410.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415410.mo797_背景颜色(-16742145);
        this.f415410.mo1143(1);
        this.f415410.mo1139("zz_12.jpg");
        this.f415410.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f415511 = c0742Impl;
        this.f415511.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.763d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415511.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.519d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415511.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415511.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415511.mo797_背景颜色(-16742145);
        this.f415511.mo1143(1);
        this.f415511.mo1139("r05.jpg");
        this.f415511.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41715 = c0742Impl;
        this.f41715.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.09d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41715.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.63d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41715.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41715.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41715.mo797_背景颜色(-16742145);
        this.f41715.mo1143(1);
        this.f41715.mo1139("zz_18.jpg");
        this.f41715.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41759 = c0742Impl;
        this.f41759.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.425d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41759.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.63d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41759.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41759.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41759.mo797_背景颜色(-16742145);
        this.f41759.mo1143(1);
        this.f41759.mo1139("zz_19.jpg");
        this.f41759.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41726 = c0742Impl;
        this.f41726.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.763d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41726.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.63d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41726.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41726.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41726.mo797_背景颜色(-16742145);
        this.f41726.mo1143(1);
        this.f41726.mo1139("zz_21.jpg");
        this.f41726.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f416319 = c0742Impl;
        this.f416319.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.09d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416319.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.741d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416319.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416319.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416319.mo797_背景颜色(-16742145);
        this.f416319.mo1143(1);
        this.f416319.mo1139("zz_26.jpg");
        this.f416319.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41748 = c0742Impl;
        this.f41748.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.425d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41748.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.741d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41748.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41748.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41748.mo797_背景颜色(-16742145);
        this.f41748.mo1143(1);
        this.f41748.mo1139("r10.jpg");
        this.f41748.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f41704 = c0742Impl;
        this.f41704.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.09d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41704.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.413d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41704.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41704.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41704.mo797_背景颜色(0);
        this.f41704.mo1143(1);
        this.f41704.mo1139("zz_03.jpg");
        this.f41704.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f416218 = c0742Impl;
        this.f416218.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.425d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416218.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.52d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416218.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416218.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416218.mo797_背景颜色(0);
        this.f416218.mo1143(1);
        this.f416218.mo1139("r_03.jpg");
        this.f416218.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f415612 = c0742Impl;
        this.f415612.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.425d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415612.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.412d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415612.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f415612.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f415612.mo797_背景颜色(0);
        this.f415612.mo1143(1);
        this.f415612.mo1139("zz_05.jpg");
        this.f415612.mo776_可视(true);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f416722 = c0742Impl;
        this.f416722.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.017d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416722.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.926d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416722.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.1d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416722.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416722.mo797_背景颜色(0);
        this.f416722.mo1143(1);
        this.f416722.mo1139("icon01.png");
        this.f416722.mo776_可视(false);
        c0742Impl = new C0742Impl(f41373);
        Objects.initializeProperties(c0742Impl);
        this.f416823 = c0742Impl;
        this.f416823.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.667d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416823.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.733d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416823.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.329d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f416823.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.114d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f416823.mo797_背景颜色(0);
        this.f416823.mo1143(1);
        this.f416823.mo1139("shiyi.png");
        this.f416823.mo776_可视(true);
        C0716Impl c0716Impl = new C0716Impl(f41373);
        Objects.initializeProperties(c0716Impl);
        this.f41511 = c0716Impl;
        this.f41511.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41511.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.003d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41511.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41511.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.898d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41511.mo797_背景颜色(-1);
        this.f41511.mo991(17.0f);
        this.f41511.mo993(-8355712);
        this.f41511.mo1004(bi_常量类.f6358b_空串);
        this.f41511.mo776_可视(true);
        c0725Impl = new C0725Impl(f41373);
        Objects.initializeProperties(c0725Impl);
        this.f41841 = c0725Impl;
        this.f41841.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.117d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41841.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.427d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41841.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.717d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41841.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.299d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41841.mo895(bi_常量类.f6358b_空串);
        this.f41841.mo797_背景颜色(0);
        this.f41841.mo889_字体颜色(-16742145);
        this.f41841.mo896(true);
        this.f41841.mo892(false);
        this.f41841.mo891_对齐方式(7);
        this.f41841.mo1049_字体大小(30.0f);
        this.f41841.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41841.mo776_可视(true);
        EventDispatcher.registerEvent(this, "图片框4", "被单击");
        EventDispatcher.registerEvent(this, "图片框15", "被单击");
        EventDispatcher.registerEvent(this, "下载器1", "进度改变");
        EventDispatcher.registerEvent(this, "下载器1", "下载完毕");
        EventDispatcher.registerEvent(this, "状态栏通知1", "通知被单击");
        EventDispatcher.registerEvent(this, "浏览框3", "接口事件");
        EventDispatcher.registerEvent(this, "图片框6", "被单击");
        EventDispatcher.registerEvent(this, "图片框7", "被单击");
        EventDispatcher.registerEvent(this, "列表框1", "表项被单击");
        EventDispatcher.registerEvent(this, "图片框10", "被单击");
        EventDispatcher.registerEvent(this, "列表框1", "表项被长按");
        EventDispatcher.registerEvent(this, "下载器2", "下载完毕");
        EventDispatcher.registerEvent(this, "图片框9", "被单击");
        EventDispatcher.registerEvent(this, "窗口3", "切换完毕");
        EventDispatcher.registerEvent(this, "图片框19", "被单击");
        EventDispatcher.registerEvent(this, "图片框22", "被单击");
        EventDispatcher.registerEvent(this, "图片框5", "被单击");
        EventDispatcher.registerEvent(this, "图片框11", "被单击");
        EventDispatcher.registerEvent(this, "图片框18", "被单击");
        EventDispatcher.registerEvent(this, "图片框17", "被单击");
        EventDispatcher.registerEvent(this, "图片框23", "被单击");
        EventDispatcher.registerEvent(this, "图片框12", "被单击");
        EventDispatcher.registerEvent(this, "时钟1", "周期事件");
        EventDispatcher.registerEvent(this, "窗口3", "创建完毕");
        EventDispatcher.registerEvent(this, "标签4", "被单击");
        EventDispatcher.registerEvent(this, "窗口3", "按下某键");
        EventDispatcher.registerEvent(this, "图片框8", "被单击");
        f41373.mo765();
        this.f416016.mo765();
        this.f416520.mo765();
        this.f416621.mo765();
        this.f415713.mo765();
        this.f41531.mo765();
        this.f41642.mo765();
        this.f41693.mo765();
        this.f41852.mo765();
        this.f41471.mo765();
        this.f41482.mo765();
        this.f41881.mo765();
        this.f41892.mo765();
        this.f41821.mo765();
        this.f415915.mo765();
        this.f41863.mo765();
        this.f41874.mo765();
        this.f415814.mo765();
        this.f416117.mo765();
        this.f41921.mo765();
        this.f41832.mo765();
        this.f41903.mo765();
        this.f41737.mo765();
        this.f415410.mo765();
        this.f415511.mo765();
        this.f41715.mo765();
        this.f41759.mo765();
        this.f41726.mo765();
        this.f416319.mo765();
        this.f41748.mo765();
        this.f41704.mo765();
        this.f416218.mo765();
        this.f415612.mo765();
        this.f416722.mo765();
        this.f416823.mo765();
        this.f41511.mo765();
        this.f41841.mo765();
    }

    /* renamed from: 图片框4$被单击 */
    public void m52854$() {
        if (C0880_应用操作类.m6712("窗口5") == null) {
            C0880_应用操作类.m6692("窗口5", new C06565());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口5"));
    }

    /* renamed from: 图片框5$被单击 */
    public void m52865$() {
        this.f41863.mo776_可视(false);
        if (C0880_应用操作类.m6712("窗口4") == null) {
            C0880_应用操作类.m6692("窗口4", new C06554());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口4"));
    }

    /* renamed from: 图片框11$被单击 */
    public void m527711$() {
        C0881.m6717(m5275(this.ab, "ax1", "ax2"), bi_常量类.f6358b_空串);
    }

    /* renamed from: 图片框9$被单击 */
    public void m52909$() {
        this.f41863.mo776_可视(false);
        if (C0880_应用操作类.m6712("窗口9") == null) {
            C0880_应用操作类.m6692("窗口9", new C06609());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口9"));
    }

    /* renamed from: 图片框8$被单击 */
    public void m52898$() {
        this.f41863.mo776_可视(false);
        this.f41511.mo996();
        this.f41852.mo774(true);
        this.f41852.mo776_可视(true);
        this.f416722.mo776_可视(true);
        this.f41511.mo776_可视(true);
        this.f41511.mo774(true);
        this.f4140h = C0889_文件操作.m6802(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/sc.TXT", "UTF-8");
        this.f4142j = C0890_文本操作.m6806_分割字符串(this.f4140h, "z");
        this.f4141i = 0;
        while (this.f4141i < C0888_数组操作.m6769_取数组成员数(ArrayVariant.getArrayVariant(this.f4142j))) {
            if (!this.f4142j[this.f4141i].equals(bi_常量类.f6358b_空串)) {
                this.f4145x = C0890_文本操作.m6819(this.f4142j[this.f4141i], "y", bi_常量类.f6358b_空串);
                this.f4145x = C0890_文本操作.m6819(this.f4145x, "f", bi_常量类.f6358b_空串);
                this.f4145x = C0890_文本操作.m6819(this.f4145x, "a", bi_常量类.f6358b_空串);
                this.f4145x = C0890_文本操作.m6819(this.f4145x, "huan", "环");
                this.f4145x = C0890_文本操作.m6819(this.f4145x, "hun", "环");
                this.f4145x = C0890_文本操作.m6819(this.f4145x, "h", "环");
                this.f4145x = C0890_文本操作.m6819(this.f4145x, "k", "快");
                this.f41511.mo995((((("    公交" + this.f4145x) + "路线------") + "<font color=#FF0000  >") + ">>>>") + "</font>");
            }
            this.f4141i = IntegerVariant.getIntegerVariant(this.f4141i).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
        }
    }

    /* renamed from: 窗口3$创建完毕 */
    public void m52973$() {
        String str = bi_常量类.f6358b_空串;
        try {
            String z = bi_常量类.f6358b_空串;
            this.f4143o = 1;
            this.f41903.mo776_可视(false);
            this.f41903.mo774(false);
            this.f41841.mo774(false);
            this.f41841.mo776_可视(false);
            this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
            this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
            C0898_读写设置类.m6935_通过SP保存设置("从", StringVariant.getStringVariant(bi_常量类.f6358b_空串));
            C0898_读写设置类.m6935_通过SP保存设置("到", StringVariant.getStringVariant(bi_常量类.f6358b_空串));
            this.f41852.mo774(false);
            this.f41852.mo776_可视(false);
            this.f416722.mo776_可视(false);
            this.f41511.mo780(C0894.m6882());
            this.f41511.mo782(0);
            this.f41511.mo776_可视(false);
            this.f41511.mo774(false);
            this.f41511.mo985(true);
            this.f41881.mo806(C0894.m6884());
            this.f41881.mo780(C0894.m6882());
            this.f41881.mo782(0);
            this.f41881.mo804(0);
            this.f41881.mo776_可视(false);
            this.f41881.mo774(false);
            this.f41903.mo960JS("ali");
            if (!C0889_文件操作.m6797(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/bendi/laocity2.html")) {
                C0889_文件操作.m6784(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/");
                C0889_文件操作.m6782(this.zz + "isba.zip", ((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/isba.zip");
                C0844.m6615zip(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/isba.zip", ((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/");
            }
            if (!C0897_网络操作.m6920_取网络状态()) {
                if (IntegerVariant.getIntegerVariant(C0879.m66692("信号", "当前网络不是很稳定", "退出", "取消")).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
                    C0880_应用操作类.m6703();
                } else {
                    C0880_应用操作类.m6703();
                }
            }
            this.f41903.mo782(this.f41642.mo781());
            this.f41903.mo804(this.f41642.mo803());
            this.f41903.mo780(this.f41642.mo779());
            this.f41903.mo806(this.f41642.mo805());
            this.f41863.mo782(this.f41693.mo781());
            this.f41863.mo804(this.f41693.mo803());
            this.f41863.mo780(this.f41693.mo779());
            this.f41863.mo806(this.f41693.mo805());
            this.f4176 = this.zz;
            this.f41821.mo928(1000);
            if (this.zz.equals("haerbin")) {
                this.f41726.mo774(false);
                this.f41726.mo776_可视(false);
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 窗口3$按下某键 */
    public void m52983$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        try {
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                if (LongVariant.getLongVariant(C0891.m6826() - this.f4152).cmp(ShortVariant.getShortVariant((short) 1500)) > 0) {
                    this.f4152 = C0891.m6826();
                    this.f41881.mo776_可视(false);
                    this.f41881.mo774(false);
                    this.f41852.mo774(false);
                    this.f41852.mo776_可视(false);
                    this.f416722.mo776_可视(false);
                    this.f41511.mo776_可视(false);
                    this.f41511.mo774(false);
                    this.f41863.mo776_可视(true);
                    this.f41903.mo776_可视(true);
                    this.f41903.mo774(true);
                } else {
                    C0880_应用操作类.m6703();
                }
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: 更新 */
    public void m5292() {
        /*
        r24 = this;
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r2 = "";
        r20 = "";
        r17 = "";
        r13 = "";
        r15 = "";
        r19 = "";
        r12 = "";
        r18 = "";
        r22 = "";
        r23 = "";
        r21 = "";
        r14 = "";
        r16 = "";
        r10 = "";
        r11 = "";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r2.<init>();	 Catch:{ Throwable -> 0x03ee }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r3.<init>();	 Catch:{ Throwable -> 0x03ee }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r4.<init>();	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r5 = r0.wl;	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r5 = "/web/city/";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r4 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x03ee }
        r3 = "/xver.txt";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = "GBK";
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r20 = com.e4a.runtime.C0897.m6922(r2, r3, r4);	 Catch:{ Throwable -> 0x03ee }
        r2 = "";
        r0 = r20;
        r2 = r0.equals(r2);	 Catch:{ Throwable -> 0x03ee }
        if (r2 != 0) goto L_0x0273;
    L_0x0089:
        r0 = r20;
        r1 = r24;
        r1.ab = r0;	 Catch:{ Throwable -> 0x03ee }
        r2 = "ver";
        r3 = "var";
        r0 = r24;
        r1 = r20;
        r17 = r0.m5275(r1, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = "di1";
        r3 = "di2";
        r0 = r24;
        r1 = r20;
        r13 = r0.m5275(r1, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = "v1";
        r3 = "v2";
        r0 = r24;
        r1 = r20;
        r18 = r0.m5275(r1, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = "gg1";
        r3 = "gg2";
        r0 = r24;
        r1 = r20;
        r22 = r0.m5275(r1, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = "ggf1";
        r3 = "ggf2";
        r0 = r24;
        r1 = r20;
        r23 = r0.m5275(r1, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = "s1";
        r3 = "s2";
        r0 = r24;
        r1 = r20;
        r14 = r0.m5275(r1, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = "com.chedaole";
        r15 = com.e4a.runtime.C0881.m6728(r2);	 Catch:{ Throwable -> 0x03ee }
        r0 = r17;
        r2 = r15.equals(r0);	 Catch:{ Throwable -> 0x03ee }
        if (r2 != 0) goto L_0x013a;
    L_0x00e5:
        r2 = "版本更新提示";
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r3.<init>();	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r14);	 Catch:{ Throwable -> 0x03ee }
        r4 = "软件已升级，是否升为最新版本？";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x03ee }
        r4 = "升级";
        r5 = "取消";
        r2 = com.e4a.runtime.C0879.m66692(r2, r3, r4, r5);	 Catch:{ Throwable -> 0x03ee }
        r19 = java.lang.Integer.toString(r2);	 Catch:{ Throwable -> 0x03ee }
        r2 = com.e4a.runtime.variants.StringVariant.getStringVariant(r19);	 Catch:{ Throwable -> 0x03ee }
        r3 = 0;
        r3 = com.e4a.runtime.variants.ByteVariant.getByteVariant(r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.cmp(r3);	 Catch:{ Throwable -> 0x03ee }
        if (r2 != 0) goto L_0x013a;
    L_0x0115:
        r0 = r24;
        r2 = r0.f41471;	 Catch:{ Throwable -> 0x03ee }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r3.<init>();	 Catch:{ Throwable -> 0x03ee }
        r4 = com.e4a.runtime.C0852.m6665();	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r4 = "/chedaole.apk";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x03ee }
        r2.mo1125(r13, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = com.e4a.runtime.C0897.m6920();	 Catch:{ Throwable -> 0x03ee }
        r3 = 1;
        if (r2 != r3) goto L_0x013a;
    L_0x013a:
        r0 = r24;
        r2 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r3 = "UTF-8";
        r2 = com.e4a.runtime.C0895.m6905URL(r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r0.zz1 = r2;	 Catch:{ Throwable -> 0x03ee }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r2.<init>();	 Catch:{ Throwable -> 0x03ee }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r3.<init>();	 Catch:{ Throwable -> 0x03ee }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r4.<init>();	 Catch:{ Throwable -> 0x03ee }
        r5 = com.e4a.runtime.C0852.m6665();	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r5 = "/cityisba/";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r4 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x03ee }
        r3 = "/SJ.TXT";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x03ee }
        r2 = com.e4a.runtime.C0889.m6797(r2);	 Catch:{ Throwable -> 0x03ee }
        r3 = 1;
        if (r2 != r3) goto L_0x0367;
    L_0x018e:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r2.<init>();	 Catch:{ Throwable -> 0x03ee }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r3.<init>();	 Catch:{ Throwable -> 0x03ee }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r4.<init>();	 Catch:{ Throwable -> 0x03ee }
        r5 = com.e4a.runtime.C0852.m6665();	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r5 = "/cityisba/";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r4 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x03ee }
        r3 = "/SJ.TXT";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = "GBK";
        r12 = com.e4a.runtime.C0889.m6802(r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r0 = r18;
        r2 = r12.equals(r0);	 Catch:{ Throwable -> 0x03ee }
        if (r2 != 0) goto L_0x0260;
    L_0x01db:
        r0 = r24;
        r2 = r0.f41482;	 Catch:{ Throwable -> 0x03ee }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r3.<init>();	 Catch:{ Throwable -> 0x03ee }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r4.<init>();	 Catch:{ Throwable -> 0x03ee }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r5.<init>();	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r6 = r0.wl;	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x03ee }
        r6 = "/web/city/";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r5 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r4 = "/isba.zip";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x03ee }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r4.<init>();	 Catch:{ Throwable -> 0x03ee }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r5.<init>();	 Catch:{ Throwable -> 0x03ee }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r6.<init>();	 Catch:{ Throwable -> 0x03ee }
        r7 = com.e4a.runtime.C0852.m6665();	 Catch:{ Throwable -> 0x03ee }
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x03ee }
        r7 = "/cityisba/";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x03ee }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r6 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r5 = "/isba.zip";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x03ee }
        r2.mo1125(r3, r4);	 Catch:{ Throwable -> 0x03ee }
    L_0x0260:
        r2 = "";
        r0 = r23;
        r2 = r0.equals(r2);	 Catch:{ Throwable -> 0x03ee }
        if (r2 != 0) goto L_0x03f4;
    L_0x026a:
        r2 = "高高分";
        r3 = com.e4a.runtime.variants.StringVariant.getStringVariant(r23);	 Catch:{ Throwable -> 0x03ee }
        com.e4a.runtime.C0898.m6935(r2, r3);	 Catch:{ Throwable -> 0x03ee }
    L_0x0273:
        r2 = "tongzhi1";
        r3 = 1;
        r0 = r20;
        r2 = com.e4a.runtime.C0890.m6821(r0, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = com.e4a.runtime.variants.IntegerVariant.getIntegerVariant(r2);	 Catch:{ Throwable -> 0x03ee }
        r3 = 0;
        r3 = com.e4a.runtime.variants.ByteVariant.getByteVariant(r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.cmp(r3);	 Catch:{ Throwable -> 0x03ee }
        if (r2 <= 0) goto L_0x02c2;
    L_0x028b:
        r0 = r24;
        r2 = r0.f41921;	 Catch:{ Throwable -> 0x03ee }
        r3 = 1;
        r4 = "公交秘书";
        r5 = "t1";
        r6 = "t2";
        r0 = r24;
        r1 = r20;
        r5 = r0.m5275(r1, r5, r6);	 Catch:{ Throwable -> 0x03ee }
        r6 = "t2";
        r7 = "t3";
        r0 = r24;
        r1 = r20;
        r6 = r0.m5275(r1, r6, r7);	 Catch:{ Throwable -> 0x03ee }
        r7 = 2130837513; // 0x7f020009 float:1.7279982E38 double:1.052773612E-314;
        r8 = 0;
        r9 = 0;
        r2.mo1265(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ Throwable -> 0x03ee }
        r2 = "t3";
        r3 = "t4";
        r0 = r24;
        r1 = r20;
        r2 = r0.m5275(r1, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r0.tozhi = r2;	 Catch:{ Throwable -> 0x03ee }
    L_0x02c2:
        r2 = "tao1";
        r3 = 1;
        r0 = r20;
        r2 = com.e4a.runtime.C0890.m6821(r0, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = com.e4a.runtime.variants.IntegerVariant.getIntegerVariant(r2);	 Catch:{ Throwable -> 0x03ee }
        r3 = 0;
        r3 = com.e4a.runtime.variants.ByteVariant.getByteVariant(r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.cmp(r3);	 Catch:{ Throwable -> 0x03ee }
        if (r2 <= 0) goto L_0x0338;
    L_0x02da:
        r0 = r24;
        r2 = r0.f41903;	 Catch:{ Throwable -> 0x03ee }
        r3 = 1;
        r2.mo776(r3);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r2 = r0.f41903;	 Catch:{ Throwable -> 0x03ee }
        r3 = 1;
        r2.mo774(r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r2.<init>();	 Catch:{ Throwable -> 0x03ee }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r3.<init>();	 Catch:{ Throwable -> 0x03ee }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r4.<init>();	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r5 = r0.wl;	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r5 = "/web/city/";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r4 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x03ee }
        r3 = "/guanggao1.txt";
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x03ee }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = "utf-8";
        r4 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r10 = com.e4a.runtime.C0897.m6922(r2, r3, r4);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r2 = r0.f41903;	 Catch:{ Throwable -> 0x03ee }
        r2.mo976(r10);	 Catch:{ Throwable -> 0x03ee }
    L_0x0338:
        r2 = "g6";
        r3 = "g7";
        r0 = r24;
        r1 = r20;
        r2 = r0.m5275(r1, r2, r3);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r0.f4149 = r2;	 Catch:{ Throwable -> 0x03ee }
        r2 = "公告";
        r2 = com.e4a.runtime.C0898.m6937(r2);	 Catch:{ Throwable -> 0x03ee }
        r16 = r2.getString();	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r2 = r0.f4149;	 Catch:{ Throwable -> 0x03ee }
        r0 = r16;
        r2 = r2.equals(r0);	 Catch:{ Throwable -> 0x03ee }
        if (r2 != 0) goto L_0x0401;
    L_0x035e:
        r0 = r24;
        r2 = r0.f416117;	 Catch:{ Throwable -> 0x03ee }
        r3 = 1;
        r2.mo776(r3);	 Catch:{ Throwable -> 0x03ee }
    L_0x0366:
        return;
    L_0x0367:
        r0 = r24;
        r2 = r0.f41482;	 Catch:{ Throwable -> 0x03ee }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r3.<init>();	 Catch:{ Throwable -> 0x03ee }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r4.<init>();	 Catch:{ Throwable -> 0x03ee }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r5.<init>();	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r6 = r0.wl;	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x03ee }
        r6 = "/web/city/";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r5 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r4 = "/isba.zip";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x03ee }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x03ee }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r4.<init>();	 Catch:{ Throwable -> 0x03ee }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r5.<init>();	 Catch:{ Throwable -> 0x03ee }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x03ee }
        r6.<init>();	 Catch:{ Throwable -> 0x03ee }
        r7 = com.e4a.runtime.C0852.m6665();	 Catch:{ Throwable -> 0x03ee }
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x03ee }
        r7 = "/cityisba/";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x03ee }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x03ee }
        r0 = r24;
        r6 = r0.zz;	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x03ee }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r5 = "/isba.zip";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x03ee }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x03ee }
        r2.mo1125(r3, r4);	 Catch:{ Throwable -> 0x03ee }
        goto L_0x0260;
    L_0x03ee:
        r2 = move-exception;
        com.e4a.runtime.errors.RuntimeError.convertToRuntimeError(r2);
        goto L_0x0366;
    L_0x03f4:
        r2 = "高高分";
        r3 = "";
        r3 = com.e4a.runtime.variants.StringVariant.getStringVariant(r3);	 Catch:{ Throwable -> 0x03ee }
        com.e4a.runtime.C0898.m6935(r2, r3);	 Catch:{ Throwable -> 0x03ee }
        goto L_0x0273;
    L_0x0401:
        r0 = r24;
        r2 = r0.f416117;	 Catch:{ Throwable -> 0x03ee }
        r3 = 0;
        r2.mo776(r3);	 Catch:{ Throwable -> 0x03ee }
        goto L_0x0366;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chedaole.窗口3.更新():void");
    }

    /* renamed from: 状态栏通知1$通知被单击 */
    public void m52951$(int 通知ID) {
        C0897_网络操作.m6927_打开指定网址(this.tozhi);
    }

    /* renamed from: 取中间文本 */
    public String m5275(String 完整内容, String 左边文本, String 右边文本) {
        String 取中间文本 = bi_常量类.f6358b_空串;
        int 左边 = C0890_文本操作.m6821(完整内容, 左边文本, 0) + C0890_文本操作.m6817_获取字符串长度(左边文本);
        if (IntegerVariant.getIntegerVariant(左边).cmp(ByteVariant.getByteVariant((byte) -1)) == 0) {
            return bi_常量类.f6358b_空串;
        }
        int 右边 = C0890_文本操作.m6821(完整内容, 右边文本, 左边);
        if (IntegerVariant.getIntegerVariant(右边).cmp(ByteVariant.getByteVariant((byte) -1)) == 0 || 左边 > 右边) {
            return bi_常量类.f6358b_空串;
        }
        return C0890_文本操作.m6814_截取子串(完整内容, 左边, 右边 - 左边);
    }

    /* renamed from: 下载器2$下载完毕 */
    public void m52722$(int 任务索引, boolean 下载结果) {
        C0880_应用操作类.m6694(Integer.toString(任务索引));
        if (下载结果) {
            C0844.m6615zip(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/isba.zip", ((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/");
        }
    }

    /* renamed from: 下载器1$下载完毕 */
    public void m52701$(int 任务索引, boolean 下载结果) {
        if (下载结果) {
            this.f41841.mo776_可视(false);
            this.f41841.mo774(false);
            C0880_应用操作类.m6694("文件下载成功，开始更新！");
            C0881.m6735(C0852_存储卡类.m6665_取存储卡路径() + "/chedaole.apk");
            return;
        }
        C0880_应用操作类.m6694("文件下载失败！");
    }

    /* renamed from: 下载器1$进度改变 */
    public void m52711$(int 任务索引, int 文件总大小, int 已下载大小, int 下载进度) {
        this.f41841.mo782(0);
        this.f41841.mo804(0);
        this.f41841.mo780(C0894.m6882());
        this.f41841.mo806(C0894.m6884());
        this.f41841.mo1049_字体大小(50.0f);
        this.f41841.mo774(true);
        this.f41841.mo776_可视(true);
        this.f41841.mo895(Integer.toString(下载进度) + "%");
    }

    /* renamed from: 列表框1$表项被单击 */
    public void m52731$(int 项目索引) {
        String x = bi_常量类.f6358b_空串;
        String bb = bi_常量类.f6358b_空串;
        this.f41863.mo776_可视(false);
        C0898_读写设置类.m6935_通过SP保存设置("线路", StringVariant.getStringVariant(C0890_文本操作.m6819(C0890_文本操作.m6819(this.f4142j[项目索引], "y", bi_常量类.f6358b_空串), "f", bi_常量类.f6358b_空串)));
        C0898_读写设置类.m6935_通过SP保存设置("正反", StringVariant.getStringVariant("正"));
        C0898_读写设置类.m6935_通过SP保存设置("方向", StringVariant.getStringVariant("zheng"));
        if (C0880_应用操作类.m6712("过渡窗口") == null) {
            C0880_应用操作类.m6692("过渡窗口", new C06532_有初始化功能());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("过渡窗口"));
    }

    /* renamed from: 列表框1$表项被长按 */
    public void m52741$(int 项目索引) {
        String n = bi_常量类.f6358b_空串;
        String q = bi_常量类.f6358b_空串;
        String x = bi_常量类.f6358b_空串;
        this.f41863.mo776_可视(false);
        C0889_文件操作.m6781_写出文本文件(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/SC.txt", C0890_文本操作.m6819(C0889_文件操作.m6802(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/sc.TXT", "UTF-8"), this.f4142j[项目索引] + "z", bi_常量类.f6358b_空串), "UTF-8");
        C0880_应用操作类.m6694("路线删除成功");
        this.f41511.mo996();
        this.f41852.mo774(true);
        this.f41852.mo776_可视(true);
        this.f416722.mo776_可视(true);
        this.f41511.mo776_可视(true);
        this.f41511.mo774(true);
        this.f4140h = C0889_文件操作.m6802(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/sc.TXT", "UTF-8");
        this.f4142j = C0890_文本操作.m6806_分割字符串(this.f4140h, "z");
        this.f4141i = 0;
        while (this.f4141i < C0888_数组操作.m6769_取数组成员数(ArrayVariant.getArrayVariant(this.f4142j))) {
            if (!this.f4142j[this.f4141i].equals(bi_常量类.f6358b_空串)) {
                this.f41511.mo995(((((" 公交" + C0890_文本操作.m6819(this.f4142j[this.f4141i], "y", bi_常量类.f6358b_空串)) + "路线---------") + "<font color=#FF0000  >") + "进入") + "</font>");
            }
            this.f4141i = IntegerVariant.getIntegerVariant(this.f4141i).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
        }
    }

    /* renamed from: 时钟1$周期事件 */
    public void m52911$() {
        String 天气 = bi_常量类.f6358b_空串;
        String 黑 = bi_常量类.f6358b_空串;
        this.f41821.mo928(0);
        if (C0897_网络操作.m6920_取网络状态()) {
            this.f4180 = C0898_读写设置类.m6937_通过SP读取设置("安装数").getString();
            if (!this.f4180.equals("真")) {
                if (C0897_网络操作.m6920_取网络状态()) {
                    this.f41892.mo976(((this.wl + "/web/city/") + this.zz) + "/tijiaoshuliang.asp");
                }
                C0898_读写设置类.m6935_通过SP保存设置("安装数", StringVariant.getStringVariant("真"));
            }
            this.f41892.mo802();
        } else {
            C0880_应用操作类.m6694("无网络");
        }
        天气 = C0897_网络操作.m6922(((this.wl + "/web/city/") + this.zz) + "/tianqi.txt", "GBK", 2000);
        this.f4177 = m5275(天气, ((DistrictSearchQuery.KEYWORDS_CITY + C0899.m6939(34)) + ":") + C0899.m6939(34), ((C0899.m6939(34) + ",") + C0899.m6939(34)) + "cnty");
        this.f4178 = m5275(天气, (("txt_d" + C0899.m6939(34)) + ":") + C0899.m6939(34), ((C0899.m6939(34) + ",") + C0899.m6939(34)) + "txt_n");
        黑 = m5275(天气, (("txt_n" + C0899.m6939(34)) + ":") + C0899.m6939(34), C0899.m6939(34) + "}");
        this.f4191 = (("温度: " + m5275(天气, (("min" + C0899.m6939(34)) + ":") + C0899.m6939(34), C0899.m6939(34) + "}")) + " - ") + m5275(天气, (("max" + C0899.m6939(34)) + ":") + C0899.m6939(34), ((C0899.m6939(34) + ",") + C0899.m6939(34)) + "min");
        this.f4193 = m5275(天气, (("sc" + C0899.m6939(34)) + ":") + C0899.m6939(34), ((C0899.m6939(34) + ",") + C0899.m6939(34)) + "spd");
        this.f41863.mo895(((((((((this.f4177 + "  ") + this.f4178) + " ") + this.f4191) + " ") + "风: ") + this.f4193) + "级   夜间: ") + 黑);
        this.f41863.mo895(C0890_文本操作.m6819(this.f41863.mo894(), "风: 级", bi_常量类.f6358b_空串));
        if (this.f4178.equals(bi_常量类.f6358b_空串) || this.f4177.equals(bi_常量类.f6358b_空串)) {
            this.f41863.mo895(bi_常量类.f6358b_空串);
        }
        this.f41903.mo776_可视(false);
        this.f41903.mo774(false);
        this.f41874.mo895(this.f4177 + " ▼");
        m5292();
    }

    /* renamed from: 图片框6$被单击 */
    public void m52876$() {
        String huo = bi_常量类.f6358b_空串;
        if (C0880_应用操作类.m6712("窗口7") == null) {
            C0880_应用操作类.m6692("窗口7", new C06587());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口7"));
    }

    /* renamed from: 图片框7$被单击 */
    public void m52887$() {
        this.f41863.mo776_可视(false);
        this.f41881.mo776_可视(true);
        this.f41881.mo774(true);
        this.f41903.mo776_可视(false);
        this.f41903.mo774(false);
        this.f41881.mo768();
        if (C0897_网络操作.m6920_取网络状态()) {
            this.f41881.mo976(((this.wl + "/web/city/") + this.zz) + "/instruction.html");
        } else {
            C0880_应用操作类.m6694("无网络");
        }
    }

    /* renamed from: 图片框10$被单击 */
    public void m527610$() {
        if (C0880_应用操作类.m6712("窗口8") == null) {
            C0880_应用操作类.m6692("窗口8", new C06598());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口8"));
    }

    /* renamed from: 窗口3$切换完毕 */
    public void m52963$() {
        String dg = bi_常量类.f6358b_空串;
        this.f41863.mo776_可视(true);
        dg = C0898_读写设置类.m6937_通过SP读取设置("成s").getString();
        this.f41881.mo776_可视(false);
        this.f41881.mo774(false);
        this.f41852.mo774(false);
        this.f41852.mo776_可视(false);
        this.f416722.mo776_可视(false);
        this.f41511.mo776_可视(false);
        this.f41511.mo774(false);
        if (dg.equals(C0108a.f262e)) {
            dg = "0";
            C0898_读写设置类.m6935_通过SP保存设置("成s", StringVariant.getStringVariant("0"));
            this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
            this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
            C0898_读写设置类.m6935_通过SP保存设置("从", StringVariant.getStringVariant(bi_常量类.f6358b_空串));
            C0898_读写设置类.m6935_通过SP保存设置("到", StringVariant.getStringVariant(bi_常量类.f6358b_空串));
            this.f4176 = this.zz;
            this.f41821.mo928(1000);
            if (this.zz.equals("haerbin")) {
                this.f41726.mo774(false);
                this.f41726.mo776_可视(false);
            }
        }
    }

    /* renamed from: 图片框15$被单击 */
    public void m527915$() {
        this.f41863.mo776_可视(false);
        this.f41881.mo776_可视(true);
        this.f41881.mo774(true);
        C0898_读写设置类.m6935_通过SP保存设置("公告", StringVariant.getStringVariant(this.f4149));
        this.f416117.mo776_可视(false);
        this.f41903.mo776_可视(false);
        this.f41903.mo774(false);
        this.f41881.mo768();
        if (C0897_网络操作.m6920_取网络状态()) {
            this.f41881.mo976(((this.wl + "/web/city/") + this.zz) + "/news.html");
        } else {
            C0880_应用操作类.m6694("无网络");
        }
    }

    /* renamed from: 浏览框3$接口事件 */
    public void m52943$(String 网页消息) {
        if (C0890_文本操作.m6816(网页消息, 4).equals("http")) {
            C0897_网络操作.m6927_打开指定网址(网页消息);
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页消息, "gouwu1", 1)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0898_读写设置类.m6935_通过SP保存设置("购物", StringVariant.getStringVariant(C0108a.f262e));
            if (C0880_应用操作类.m6712("窗口8") == null) {
                C0880_应用操作类.m6692("窗口8", new C06598());
            }
            C0898_读写设置类.m6935_通过SP保存设置("购物", StringVariant.getStringVariant(C0108a.f262e));
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口8"));
        }
    }

    /* renamed from: 标签4$被单击 */
    public void m52934$() {
        if (C0880_应用操作类.m6712("窗口12") == null) {
            C0880_应用操作类.m6692("窗口12", new C064912());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口12"));
    }

    /* renamed from: 图片框17$被单击 */
    public void m528017$() {
        this.f41863.mo776_可视(false);
        this.f41881.mo776_可视(true);
        this.f41881.mo774(true);
        C0898_读写设置类.m6935_通过SP保存设置("公告", StringVariant.getStringVariant(this.f4149));
        this.f416117.mo776_可视(false);
        this.f41903.mo776_可视(false);
        this.f41903.mo774(false);
        if (C0897_网络操作.m6920_取网络状态()) {
            this.f41881.mo976(((this.wl + "/web/city/") + this.zz) + "/news.html");
        } else {
            C0880_应用操作类.m6694("无网络");
        }
    }

    /* renamed from: 图片框12$被单击 */
    public void m527812$() {
        if (C0880_应用操作类.m6712("窗口6") == null) {
            C0880_应用操作类.m6692("窗口6", new C06576());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口6"));
    }

    /* renamed from: 图片框19$被单击 */
    public void m528219$() {
        if (C0880_应用操作类.m6712("窗口10") == null) {
            C0880_应用操作类.m6692("窗口10", new C064710());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口10"));
    }

    /* renamed from: 图片框18$被单击 */
    public void m528118$() {
        this.f41863.mo776_可视(false);
        C0898_读写设置类.m6935_通过SP保存设置("高级", StringVariant.getStringVariant("0"));
        if (C0880_应用操作类.m6712("窗口14") == null) {
            C0880_应用操作类.m6692("窗口14", new C065114());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口14"));
    }

    /* renamed from: 图片框22$被单击 */
    public void m528322$() {
        this.f41881.mo776_可视(false);
        this.f41881.mo774(false);
        this.f41852.mo774(false);
        this.f41852.mo776_可视(false);
        this.f416722.mo776_可视(false);
        this.f41511.mo776_可视(false);
        this.f41511.mo774(false);
        this.f41863.mo776_可视(true);
        this.f41903.mo776_可视(true);
        this.f41903.mo774(true);
    }

    /* renamed from: 图片框23$被单击 */
    public void m528423$() {
        if (C0880_应用操作类.m6712("窗口13") == null) {
            C0880_应用操作类.m6692("窗口13", new C065013());
        }
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口13"));
    }
}
