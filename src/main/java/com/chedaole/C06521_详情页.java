package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.autonavi.amap.mapcore.VTMCDataCache;
import com.e4a.runtime.C0843;
import com.e4a.runtime.C0850;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0888;
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
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.components.C0642;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.C0821;
import com.e4a.runtime.components.Component;
import com.e4a.runtime.components.impl.android.C0643Impl;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.C0798Impl;
import com.e4a.runtime.components.impl.android.C0822Impl;
import com.e4a.runtime.components.impl.android.ViewComponent;
import com.e4a.runtime.components.impl.android.n12.C0696;
import com.e4a.runtime.components.impl.android.n12.C0697Impl;
import com.e4a.runtime.components.impl.android.n15.C0698;
import com.e4a.runtime.components.impl.android.n15.C0713Impl;
import com.e4a.runtime.components.impl.android.n2.C0717;
import com.e4a.runtime.components.impl.android.n2.C0722Impl;
import com.e4a.runtime.components.impl.android.n3.C0723;
import com.e4a.runtime.components.impl.android.n3.C0725Impl;
import com.e4a.runtime.components.impl.android.n30.C0726;
import com.e4a.runtime.components.impl.android.n30.C0731Impl;
import com.e4a.runtime.components.impl.android.n4.C0739;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.components.impl.android.n42.C0743;
import com.e4a.runtime.components.impl.android.n42.C0752Impl;
import com.e4a.runtime.components.impl.android.n46.C0753GIF;
import com.e4a.runtime.components.impl.android.n46.C0754GIFImpl;
import com.e4a.runtime.errors.RuntimeError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.helpers.ConvHelpers;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.variants.ArrayVariant;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.LongVariant;
import com.e4a.runtime.variants.ObjectVariant;
import com.e4a.runtime.variants.ShortVariant;
import com.e4a.runtime.variants.StringVariant;
import com.iflytek.cloud.speech.ErrorCode;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.WebView;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口1.code */
/* renamed from: com.chedaole.窗口1 */
public class C06521_详情页 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口1 */
    public static C0644 f40411;
    @SimpleDataElement
    /* renamed from: GIF图片框1 */
    public C0753GIF f4042GIF1;
    @SimpleDataElement
    public String b18 = bi_常量类.f6358b;
    @SimpleDataElement
    public String b19 = bi_常量类.f6358b;
    @SimpleDataElement
    public String b20 = bi_常量类.f6358b;
    @SimpleDataElement
    public String b21 = bi_常量类.f6358b;
    @SimpleDataElement
    public String b22 = bi_常量类.f6358b;
    @SimpleDataElement
    public long bx;
    @SimpleDataElement
    public int dddd;
    @SimpleDataElement
    public int idc;
    @SimpleDataElement
    public int jc;
    @SimpleDataElement
    /* renamed from: k */
    public int f4043k;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b;
    @SimpleDataElement
    public String zz_城市 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 个数 */
    public int f4044;
    @SimpleDataElement
    /* renamed from: 临时 */
    public String f4045 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 事件监听器1 */
    public C0797 f40461;
    @SimpleDataElement
    /* renamed from: 启动时间 */
    public long f4047;
    @SimpleDataElement
    /* renamed from: 图像2 */
    public C0739 f40482;
    @SimpleDataElement
    /* renamed from: 图片列表框1 */
    public C0726 f40491;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f40501;
    @SimpleDataElement
    /* renamed from: 图片框10 */
    public C0739 f405110;
    @SimpleDataElement
    /* renamed from: 图片框11 */
    public C0739 f405211;
    @SimpleDataElement
    /* renamed from: 图片框12 */
    public C0739 f405312;
    @SimpleDataElement
    /* renamed from: 图片框13 */
    public C0739 f405413;
    @SimpleDataElement
    /* renamed from: 图片框14 */
    public C0739 f405514;
    @SimpleDataElement
    /* renamed from: 图片框15 */
    public C0739 f405615;
    @SimpleDataElement
    /* renamed from: 图片框16 */
    public C0739 f405716;
    @SimpleDataElement
    /* renamed from: 图片框17 */
    public C0739 f405817;
    @SimpleDataElement
    /* renamed from: 图片框2 */
    public C0739 f40592;
    @SimpleDataElement
    /* renamed from: 图片框3 */
    public C0739 f40603;
    @SimpleDataElement
    /* renamed from: 图片框4 */
    public C0739 f40614;
    @SimpleDataElement
    /* renamed from: 图片框5 */
    public C0739 f40625;
    @SimpleDataElement
    /* renamed from: 图片框6 */
    public C0739 f40636;
    @SimpleDataElement
    /* renamed from: 图片框7 */
    public C0739 f40647;
    @SimpleDataElement
    /* renamed from: 图片框8 */
    public C0739 f40658;
    @SimpleDataElement
    /* renamed from: 图片框9 */
    public C0739 f40669;
    @SimpleDataElement
    /* renamed from: 图片高度 */
    public int f4067;
    @SimpleDataElement
    /* renamed from: 地址 */
    public String f4068 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 多线程1 */
    public C0743 f40691;
    @SimpleDataElement
    /* renamed from: 多线程2 */
    public C0743 f40702;
    @SimpleDataElement
    /* renamed from: 广告 */
    public String f4071 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 广广告 */
    public String f4072 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 当前位置 */
    public int f4073;
    @SimpleDataElement
    /* renamed from: 循环次数 */
    public int f4074;
    @SimpleDataElement
    /* renamed from: 换向 */
    public int f4075;
    @SimpleDataElement
    /* renamed from: 方向 */
    public String f4076 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 时钟1 */
    public C0696 f40771;
    @SimpleDataElement
    /* renamed from: 时钟2 */
    public C0696 f40782;
    @SimpleDataElement
    /* renamed from: 时钟3 */
    public C0696 f40793;
    @SimpleDataElement
    /* renamed from: 时钟4 */
    public C0696 f40804;
    @SimpleDataElement
    /* renamed from: 时间 */
    public String f4081 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 标签1 */
    public C0723 f40821;
    @SimpleDataElement
    /* renamed from: 标签10 */
    public C0723 f408310;
    @SimpleDataElement
    /* renamed from: 标签11 */
    public C0723 f408411;
    @SimpleDataElement
    /* renamed from: 标签12 */
    public C0723 f408512;
    @SimpleDataElement
    /* renamed from: 标签13 */
    public C0723 f408613;
    @SimpleDataElement
    /* renamed from: 标签14 */
    public C0723 f408714;
    @SimpleDataElement
    /* renamed from: 标签15 */
    public C0723 f408815;
    @SimpleDataElement
    /* renamed from: 标签16 */
    public C0723 f408916;
    @SimpleDataElement
    /* renamed from: 标签17 */
    public C0723 f409017;
    @SimpleDataElement
    /* renamed from: 标签18 */
    public C0723 f409118;
    @SimpleDataElement
    /* renamed from: 标签19 */
    public C0723 f409219;
    @SimpleDataElement
    /* renamed from: 标签2 */
    public C0723 f40932;
    @SimpleDataElement
    /* renamed from: 标签20 */
    public C0723 f409420;
    @SimpleDataElement
    /* renamed from: 标签21 */
    public C0723 f409521;
    @SimpleDataElement
    /* renamed from: 标签22 */
    public C0723 f409622;
    @SimpleDataElement
    /* renamed from: 标签3 */
    public C0723 f40973;
    @SimpleDataElement
    /* renamed from: 标签4 */
    public C0723 f40984;
    @SimpleDataElement
    /* renamed from: 标签5 */
    public C0723 f40995;
    @SimpleDataElement
    /* renamed from: 标签6 */
    public C0723 f41006;
    @SimpleDataElement
    /* renamed from: 标签7 */
    public C0723 f41017;
    @SimpleDataElement
    /* renamed from: 标签8 */
    public C0723 f41028;
    @SimpleDataElement
    /* renamed from: 标签9 */
    public C0723 f41039;
    @SimpleDataElement
    /* renamed from: 标记 */
    public Object f4104;
    @SimpleDataElement
    /* renamed from: 横 */
    public int f4105;
    @SimpleDataElement
    /* renamed from: 水平滚动框1 */
    public C0821 f41061;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f41071;
    @SimpleDataElement
    /* renamed from: 浏览框2 */
    public C0698 f41082;
    @SimpleDataElement
    /* renamed from: 浏览框3 */
    public C0698 f41093;
    @SimpleDataElement
    /* renamed from: 浏览框4 */
    public C0698 f41104;
    @SimpleDataElement
    /* renamed from: 浏览框5 */
    public C0698 f41115;
    @SimpleDataElement
    /* renamed from: 源码 */
    public String f4112 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 站图 */
    public C0683_集合类 f4113;
    @SimpleDataElement
    /* renamed from: 站点名 */
    public C0683_集合类 f4114_站点名集合;
    @SimpleDataElement
    /* renamed from: 站点名字 */
    public String[] f4115_站点名字_String数组;
    @SimpleDataElement
    /* renamed from: 站点坐标 */
    public String[] f4116_站点坐标_String数组;
    @SimpleDataElement
    /* renamed from: 线路 */
    public String f4117_线路名 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 编辑框1 */
    public C0717 f41181;
    @SimpleDataElement
    /* renamed from: 编辑框2 */
    public C0717 f41192;
    @SimpleDataElement
    /* renamed from: 路线起始 */
    public String f4120 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 路线首发 */
    public String f4121 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 车地理位置 */
    public String f4122 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 面板1 */
    public C0642 f41231;
    @SimpleDataElement
    /* renamed from: 面板2 */
    public C0642 f41242;
    @SimpleDataElement
    /* renamed from: 预计时间 */
    public String f4125 = bi_常量类.f6358b;

    public C06521_详情页() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f40411 = this;
        f40411.mo840("公交秘书");
        f40411.mo797(-1);
        f40411.m5096(IntegerVariant.getIntegerVariant(4));
        f40411.mo838(1);
        f40411.mo826(false);
        C0713Impl c0713Impl = new C0713Impl(f40411);
        Objects.initializeProperties(c0713Impl);
        this.f41115 = c0713Impl;
        this.f41115.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.133d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41115.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41115.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.992d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41115.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41115.mo776(true);
        C0643Impl c0643Impl = new C0643Impl(f40411);
        Objects.initializeProperties(c0643Impl);
        this.f41242 = c0643Impl;
        this.f41242.mo813(IntegerVariant.getIntegerVariant(4));
        this.f41242.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41242.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.506d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41242.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41242.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.599d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41242.mo797(0);
        this.f41242.mo776(true);
        c0643Impl = new C0643Impl(f40411);
        Objects.initializeProperties(c0643Impl);
        this.f41231 = c0643Impl;
        this.f41231.mo813(IntegerVariant.getIntegerVariant(4));
        this.f41231.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41231.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41231.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41231.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41231.mo797(-921103);
        this.f41231.mo776(true);
        C0742Impl c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40501 = c0742Impl;
        this.f40501.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40501.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40501.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.017d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40501.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40501.mo797(-16742145);
        this.f40501.mo1143(1);
        this.f40501.mo1139("gg_01.jpg");
        this.f40501.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40592 = c0742Impl;
        this.f40592.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40592.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.213d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40592.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.979d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40592.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.237d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40592.mo797(-1);
        this.f40592.mo1143(1);
        this.f40592.mo1139("gg_07.jpg");
        this.f40592.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40603 = c0742Impl;
        this.f40603.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.498d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40603.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.231d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40603.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.004d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40603.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40603.mo797(-1184275);
        this.f40603.mo1143(1);
        this.f40603.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40614 = c0742Impl;
        this.f40614.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40614.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.395d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40614.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.979d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40614.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.003d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40614.mo797(-1184275);
        this.f40614.mo1143(1);
        this.f40614.mo776(true);
        C0725Impl c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f41006 = c0725Impl;
        this.f41006.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.583d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41006.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.299d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41006.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.233d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41006.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41006.mo895("选择");
        this.f41006.mo797(0);
        this.f41006.mo889(-8076048);
        this.f41006.mo896(false);
        this.f41006.mo892(false);
        this.f41006.mo891(4);
        this.f41006.mo1049(29.0f);
        this.f41006.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41006.mo776(true);
        C0798Impl c0798Impl = new C0798Impl(f40411);
        Objects.initializeProperties(c0798Impl);
        this.f40461 = c0798Impl;
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f41039 = c0725Impl;
        this.f41039.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41039.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.103d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41039.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.017d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41039.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.021d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41039.mo895("标签");
        this.f41039.mo797(-16742145);
        this.f41039.mo889(-16777216);
        this.f41039.mo896(false);
        this.f41039.mo892(false);
        this.f41039.mo891(4);
        this.f41039.mo1049(9.0f);
        this.f41039.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41039.mo776(false);
        C0697Impl c0697Impl = new C0697Impl(f40411);
        Objects.initializeProperties(c0697Impl);
        this.f40771 = c0697Impl;
        this.f40771.mo928(ErrorCode.MSP_ERROR_MMP_BASE);
        C0752Impl c0752Impl = new C0752Impl(f40411);
        Objects.initializeProperties(c0752Impl);
        this.f40691 = c0752Impl;
        C0722Impl c0722Impl = new C0722Impl(f40411);
        Objects.initializeProperties(c0722Impl);
        this.f41181 = c0722Impl;
        this.f41181.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.65d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41181.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.702d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41181.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.333d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41181.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.279d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41181.mo887(bi_常量类.f6358b);
        this.f41181.mo889(-16777216);
        this.f41181.mo896(false);
        this.f41181.mo892(false);
        this.f41181.mo1020(9.0f);
        this.f41181.mo774(true);
        this.f41181.mo1041(4);
        this.f41181.mo891(3);
        this.f41181.mo772(true);
        this.f41181.mo1035(bi_常量类.f6358b);
        this.f41181.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41181.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f40995 = c0725Impl;
        this.f40995.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.033d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40995.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.396d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40995.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.933d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40995.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40995.mo895("↓选择候车站名↓");
        this.f40995.mo797(0);
        this.f40995.mo889(-1224641);
        this.f40995.mo896(false);
        this.f40995.mo892(false);
        this.f40995.mo891(7);
        this.f40995.mo1049(12.0f);
        this.f40995.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40995.mo776(true);
        c0752Impl = new C0752Impl(f40411);
        Objects.initializeProperties(c0752Impl);
        this.f40702 = c0752Impl;
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f41017 = c0725Impl;
        this.f41017.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.777d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41017.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.253d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41017.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41017.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41017.mo895(bi_常量类.f6358b);
        this.f41017.mo797(-1118482);
        this.f41017.mo889(-16777216);
        this.f41017.mo896(false);
        this.f41017.mo892(false);
        this.f41017.mo891(7);
        this.f41017.mo1049(9.0f);
        this.f41017.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41017.mo776(true);
        c0697Impl = new C0697Impl(f40411);
        Objects.initializeProperties(c0697Impl);
        this.f40793 = c0697Impl;
        this.f40793.mo928(0);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f408411 = c0725Impl;
        this.f408411.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.383d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408411.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.009d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408411.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.217d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408411.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408411.mo895(bi_常量类.f6358b);
        this.f408411.mo797(0);
        this.f408411.mo889(-1);
        this.f408411.mo896(false);
        this.f408411.mo892(false);
        this.f408411.mo891(7);
        this.f408411.mo1049(14.0f);
        this.f408411.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f408411.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40636 = c0742Impl;
        this.f40636.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40636.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.09d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40636.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.979d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40636.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.114d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40636.mo797(-16742145);
        this.f40636.mo1143(1);
        this.f40636.mo1139("gg_04.jpg");
        this.f40636.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40647 = c0742Impl;
        this.f40647.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.054d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40647.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.218d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40647.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.217d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40647.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40647.mo797(-16742145);
        this.f40647.mo1143(1);
        this.f40647.mo1139("22.jpg");
        this.f40647.mo776(true);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f40821 = c0725Impl;
        this.f40821.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40821.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.117d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40821.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40821.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.065d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40821.mo895(bi_常量类.f6358b);
        this.f40821.mo797(0);
        this.f40821.mo889(-16777216);
        this.f40821.mo896(false);
        this.f40821.mo892(false);
        this.f40821.mo891(4);
        this.f40821.mo1049(12.0f);
        this.f40821.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40821.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40625 = c0742Impl;
        this.f40625.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.758d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40625.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.222d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40625.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.183d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40625.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40625.mo797(0);
        this.f40625.mo1143(1);
        this.f40625.mo1139("ws.jpg");
        this.f40625.mo776(true);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f41028 = c0725Impl;
        this.f41028.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.8d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41028.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.299d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41028.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.117d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41028.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41028.mo895("站");
        this.f41028.mo797(0);
        this.f41028.mo889(-8141328);
        this.f41028.mo896(false);
        this.f41028.mo892(false);
        this.f41028.mo891(4);
        this.f41028.mo1049(18.0f);
        this.f41028.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41028.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f405211 = c0742Impl;
        this.f405211.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.008d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405211.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405211.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.013d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405211.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405211.mo797(-16742145);
        this.f405211.mo1143(1);
        this.f405211.mo1139("a2.jpg");
        this.f405211.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f405312 = c0742Impl;
        this.f405312.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.004d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405312.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.092d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405312.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.013d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405312.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.09d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405312.mo797(-16742145);
        this.f405312.mo1143(1);
        this.f405312.mo1139("a3.jpg");
        this.f405312.mo776(true);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f40932 = c0725Impl;
        this.f40932.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40932.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40932.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40932.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40932.mo895(bi_常量类.f6358b);
        this.f40932.mo797(0);
        this.f40932.mo889(-16777216);
        this.f40932.mo896(false);
        this.f40932.mo892(false);
        this.f40932.mo891(4);
        this.f40932.mo1049(9.0f);
        this.f40932.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40932.mo776(true);
        C0754GIFImpl c0754GIFImpl = new C0754GIFImpl(f40411);
        Objects.initializeProperties(c0754GIFImpl);
        this.f4042GIF1 = c0754GIFImpl;
        this.f4042GIF1.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.002d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f4042GIF1.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.552d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f4042GIF1.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f4042GIF1.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.015d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f4042GIF1.mo797(-16742145);
        this.f4042GIF1.mo1177("f1.gif");
        this.f4042GIF1.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f405514 = c0742Impl;
        this.f405514.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405514.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.516d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405514.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.117d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405514.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405514.mo797(0);
        this.f405514.mo1143(1);
        this.f405514.mo776(false);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f405615 = c0742Impl;
        this.f405615.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.3d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405615.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.516d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405615.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.133d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405615.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405615.mo797(-1);
        this.f405615.mo1143(1);
        this.f405615.mo776(false);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f405716 = c0742Impl;
        this.f405716.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.467d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405716.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.516d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405716.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405716.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405716.mo797(-1);
        this.f405716.mo1143(1);
        this.f405716.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f40984 = c0725Impl;
        this.f40984.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40984.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.279d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40984.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.267d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40984.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40984.mo895(bi_常量类.f6358b);
        this.f40984.mo797(0);
        this.f40984.mo889(-8076048);
        this.f40984.mo896(false);
        this.f40984.mo892(false);
        this.f40984.mo891(7);
        this.f40984.mo1049(29.0f);
        this.f40984.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40984.mo776(true);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f40973 = c0725Impl;
        this.f40973.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.367d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40973.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.279d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40973.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.117d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40973.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40973.mo895("分");
        this.f40973.mo797(0);
        this.f40973.mo889(-8141328);
        this.f40973.mo896(false);
        this.f40973.mo892(false);
        this.f40973.mo891(4);
        this.f40973.mo1049(18.0f);
        this.f40973.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40973.mo776(true);
        c0713Impl = new C0713Impl(f40411);
        Objects.initializeProperties(c0713Impl);
        this.f41071 = c0713Impl;
        this.f41071.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41071.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.888d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41071.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.067d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41071.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.021d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41071.mo776(false);
        C0731Impl c0731Impl = new C0731Impl(f40411);
        Objects.initializeProperties(c0731Impl);
        this.f40491 = c0731Impl;
        this.f40491.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40491.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.917d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40491.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40491.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40491.mo797(-16777216);
        this.f40491.mo1089(9.0f);
        this.f40491.mo1091(Component.f3916);
        this.f40491.mo1063(5);
        this.f40491.mo1115(10);
        this.f40491.mo1065(25);
        this.f40491.mo1085(25);
        this.f40491.mo1087(25);
        this.f40491.mo1110("dt.png");
        this.f40491.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40658 = c0742Impl;
        this.f40658.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.183d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40658.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.388d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40658.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.617d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40658.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.271d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40658.mo797(-2368549);
        this.f40658.mo1143(1);
        this.f40658.mo776(true);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f408310 = c0725Impl;
        this.f408310.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.217d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408310.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.403d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408310.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.567d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408310.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408310.mo895("距几站提醒列如:2");
        this.f408310.mo797(0);
        this.f408310.mo889(-16777216);
        this.f408310.mo896(false);
        this.f408310.mo892(false);
        this.f408310.mo891(7);
        this.f408310.mo1049(10.0f);
        this.f408310.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f408310.mo776(false);
        c0722Impl = new C0722Impl(f40411);
        Objects.initializeProperties(c0722Impl);
        this.f41192 = c0722Impl;
        this.f41192.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.229d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41192.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.472d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41192.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.533d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41192.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41192.mo887("2");
        this.f41192.mo889(-16777216);
        this.f41192.mo896(false);
        this.f41192.mo892(false);
        this.f41192.mo1020(12.0f);
        this.f41192.mo774(true);
        this.f41192.mo1041(1);
        this.f41192.mo891(7);
        this.f41192.mo772(true);
        this.f41192.mo1035("gg_04.jpg");
        this.f41192.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41192.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f408512 = c0725Impl;
        this.f408512.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.242d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408512.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.578d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408512.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.233d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408512.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408512.mo895("确定");
        this.f408512.mo797(Component.f3916);
        this.f408512.mo889(-1);
        this.f408512.mo896(false);
        this.f408512.mo892(false);
        this.f408512.mo891(7);
        this.f408512.mo1049(10.0f);
        this.f408512.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f408512.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f408613 = c0725Impl;
        this.f408613.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.508d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408613.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.578d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408613.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.233d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408613.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408613.mo895("取消");
        this.f408613.mo797(-8355712);
        this.f408613.mo889(-1);
        this.f408613.mo896(false);
        this.f408613.mo892(false);
        this.f408613.mo891(7);
        this.f408613.mo1049(10.0f);
        this.f408613.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f408613.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f408714 = c0725Impl;
        this.f408714.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408714.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.255d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408714.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408714.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408714.mo895(bi_常量类.f6358b);
        this.f408714.mo797(-1);
        this.f408714.mo889(-16742145);
        this.f408714.mo896(false);
        this.f408714.mo892(false);
        this.f408714.mo891(7);
        this.f408714.mo1049(12.0f);
        this.f408714.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f408714.mo776(true);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f408815 = c0725Impl;
        this.f408815.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408815.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.316d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408815.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408815.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408815.mo895(bi_常量类.f6358b);
        this.f408815.mo797(-1);
        this.f408815.mo889(-16742145);
        this.f408815.mo896(false);
        this.f408815.mo892(false);
        this.f408815.mo891(7);
        this.f408815.mo1049(12.0f);
        this.f408815.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f408815.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f405110 = c0742Impl;
        this.f405110.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.458d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405110.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.212d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405110.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405110.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405110.mo797(0);
        this.f405110.mo1143(1);
        this.f405110.mo1139("08.png");
        this.f405110.mo776(true);
        c0713Impl = new C0713Impl(f40411);
        Objects.initializeProperties(c0713Impl);
        this.f41082 = c0713Impl;
        this.f41082.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.933d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41082.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.485d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41082.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.05d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41082.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.021d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41082.mo776(true);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f408916 = c0725Impl;
        this.f408916.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.867d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408916.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.105d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408916.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.133d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f408916.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f408916.mo895(bi_常量类.f6358b);
        this.f408916.mo797(0);
        this.f408916.mo889(-16777216);
        this.f408916.mo896(false);
        this.f408916.mo892(false);
        this.f408916.mo891(7);
        this.f408916.mo1049(8.0f);
        this.f408916.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f408916.mo776(true);
        c0713Impl = new C0713Impl(f40411);
        Objects.initializeProperties(c0713Impl);
        this.f41093 = c0713Impl;
        this.f41093.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41093.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41093.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41093.mo806((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41093.mo776(false);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f40669 = c0742Impl;
        this.f40669.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.9d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40669.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40669.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40669.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40669.mo797(0);
        this.f40669.mo1143(1);
        this.f40669.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f405413 = c0742Impl;
        this.f405413.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.9d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405413.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405413.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405413.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405413.mo797(0);
        this.f405413.mo1143(1);
        this.f405413.mo776(true);
        c0742Impl = new C0742Impl(f40411);
        Objects.initializeProperties(c0742Impl);
        this.f405817 = c0742Impl;
        this.f405817.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.023d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405817.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.588d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405817.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f405817.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.036d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f405817.mo797(0);
        this.f405817.mo1143(1);
        this.f405817.mo1139("time.png");
        this.f405817.mo776(true);
        c0713Impl = new C0713Impl(f40411);
        Objects.initializeProperties(c0713Impl);
        this.f41104 = c0713Impl;
        this.f41104.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41104.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.566d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41104.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.7d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41104.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.31d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41104.mo776(false);
        c0697Impl = new C0697Impl(f40411);
        Objects.initializeProperties(c0697Impl);
        this.f40782 = c0697Impl;
        this.f40782.mo928(0);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f409017 = c0725Impl;
        this.f409017.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409017.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409017.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.033d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409017.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409017.mo895(bi_常量类.f6358b);
        this.f409017.mo797(0);
        this.f409017.mo889(-16777216);
        this.f409017.mo896(false);
        this.f409017.mo892(false);
        this.f409017.mo891(7);
        this.f409017.mo1049(12.0f);
        this.f409017.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f409017.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f409118 = c0725Impl;
        this.f409118.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409118.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409118.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.117d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409118.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409118.mo895(bi_常量类.f6358b);
        this.f409118.mo797(0);
        this.f409118.mo889(Component.f3916);
        this.f409118.mo896(false);
        this.f409118.mo892(false);
        this.f409118.mo891(7);
        this.f409118.mo1049(6.0f);
        this.f409118.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f409118.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f409219 = c0725Impl;
        this.f409219.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.133d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409219.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409219.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.167d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409219.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409219.mo895(bi_常量类.f6358b);
        this.f409219.mo797(0);
        this.f409219.mo889(Component.f3920);
        this.f409219.mo896(false);
        this.f409219.mo892(false);
        this.f409219.mo891(7);
        this.f409219.mo1049(6.0f);
        this.f409219.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f409219.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f409420 = c0725Impl;
        this.f409420.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.383d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409420.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409420.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.233d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409420.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409420.mo895(bi_常量类.f6358b);
        this.f409420.mo797(0);
        this.f409420.mo889(Component.f3925);
        this.f409420.mo896(false);
        this.f409420.mo892(false);
        this.f409420.mo891(4);
        this.f409420.mo1049(6.0f);
        this.f409420.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f409420.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f409521 = c0725Impl;
        this.f409521.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.7d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409521.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409521.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409521.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409521.mo895(bi_常量类.f6358b);
        this.f409521.mo797(0);
        this.f409521.mo889(-7339777);
        this.f409521.mo896(false);
        this.f409521.mo892(false);
        this.f409521.mo891(4);
        this.f409521.mo1049(6.0f);
        this.f409521.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f409521.mo776(false);
        c0725Impl = new C0725Impl(f40411);
        Objects.initializeProperties(c0725Impl);
        this.f409622 = c0725Impl;
        this.f409622.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.867d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409622.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409622.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.133d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f409622.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f409622.mo895(bi_常量类.f6358b);
        this.f409622.mo797(0);
        this.f409622.mo889(-16777216);
        this.f409622.mo896(false);
        this.f409622.mo892(false);
        this.f409622.mo891(4);
        this.f409622.mo1049(6.0f);
        this.f409622.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f409622.mo776(false);
        c0697Impl = new C0697Impl(f40411);
        Objects.initializeProperties(c0697Impl);
        this.f40804 = c0697Impl;
        this.f40804.mo928(0);
        EventDispatcher.registerEvent(this, "标签18", "被单击");
        EventDispatcher.registerEvent(this, "事件监听器1", "被单击");
        EventDispatcher.registerEvent(this, "时钟4", "周期事件");
        EventDispatcher.registerEvent(this, "图片列表框1", "表项被单击");
        EventDispatcher.registerEvent(this, "时钟1", "周期事件");
        EventDispatcher.registerEvent(this, "时钟2", "周期事件");
        EventDispatcher.registerEvent(this, "标签20", "被单击");
        EventDispatcher.registerEvent(this, "标签12", "被单击");
        EventDispatcher.registerEvent(this, "标签13", "被单击");
        EventDispatcher.registerEvent(this, "图片框10", "被单击");
        EventDispatcher.registerEvent(this, "窗口1", "按下某键");
        EventDispatcher.registerEvent(this, "标签22", "被单击");
        EventDispatcher.registerEvent(this, "标签21", "被单击");
        EventDispatcher.registerEvent(this, "时钟3", "周期事件");
        EventDispatcher.registerEvent(this, "标签19", "被单击");
        EventDispatcher.registerEvent(this, "窗口1", "创建完毕");
        EventDispatcher.registerEvent(this, "窗口1", "切换完毕");
        EventDispatcher.registerEvent(this, "多线程1", "取网页源码完毕");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        EventDispatcher.registerEvent(this, "图片框17", "被单击");
        EventDispatcher.registerEvent(this, "标签11", "被单击");
        f40411.mo765();
        this.f41115.mo765();
        this.f41242.mo765();
        this.f41231.mo765();
        this.f40501.mo765();
        this.f40592.mo765();
        this.f40603.mo765();
        this.f40614.mo765();
        this.f41006.mo765();
        this.f40461.mo765();
        this.f41039.mo765();
        this.f40771.mo765();
        this.f40691.mo765();
        this.f41181.mo765();
        this.f40995.mo765();
        this.f40702.mo765();
        this.f41017.mo765();
        this.f40793.mo765();
        this.f408411.mo765();
        this.f40636.mo765();
        this.f40647.mo765();
        this.f40821.mo765();
        this.f40625.mo765();
        this.f41028.mo765();
        this.f405211.mo765();
        this.f405312.mo765();
        this.f40932.mo765();
        this.f4042GIF1.mo765();
        this.f405514.mo765();
        this.f405615.mo765();
        this.f405716.mo765();
        this.f40984.mo765();
        this.f40973.mo765();
        this.f41071.mo765();
        this.f40491.mo765();
        this.f40658.mo765();
        this.f408310.mo765();
        this.f41192.mo765();
        this.f408512.mo765();
        this.f408613.mo765();
        this.f408714.mo765();
        this.f408815.mo765();
        this.f405110.mo765();
        this.f41082.mo765();
        this.f408916.mo765();
        this.f41093.mo765();
        this.f40669.mo765();
        this.f405413.mo765();
        this.f405817.mo765();
        this.f41104.mo765();
        this.f40782.mo765();
        this.f409017.mo765();
        this.f409118.mo765();
        this.f409219.mo765();
        this.f409420.mo765();
        this.f409521.mo765();
        this.f409622.mo765();
        this.f40804.mo765();
    }

    /* renamed from: 取像素 */
    public int m5234(int 像素) {
        return IntegerVariant.getIntegerVariant(像素).mul(DoubleVariant.getDoubleVariant((((double) C0894.m6882()) / 2.0d) / 240.0d)).getInteger();
    }

    /* renamed from: 窗口1$按下某键 */
    public void m52591$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        try {
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                if (this.f41082.mo777()) {
                    this.f41082.mo776(false);
                    this.f41082.mo774(false);
                } else {
                    int integer = IntegerVariant.getIntegerVariant(this.f4113.m5456()).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
                    for (int 计数 = 0; 计数 <= integer; 计数++) {
                        ((C0723) this.f4114_站点名集合.m5455(计数).getObject()).mo802();
                        ((C0739) this.f4113.m5455(计数).getObject()).mo802();
                    }
                    this.f40771.mo928(0);
                    this.f40793.mo928(0);
                    this.f41242.mo815();
                    this.f41082.mo776(false);
                    this.f41082.mo774(false);
                    this.f40782.mo928(0);
                    C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
                }
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 窗口1$创建完毕 */
    public void m52581$() {
        String B = bi_常量类.f6358b;
        this.zz_城市 = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
        C0683_集合类 c0683 = new C0683_集合类();
        Objects.initializeProperties(c0683);
        this.f4114_站点名集合 = c0683;
        c0683 = new C0683_集合类();
        Objects.initializeProperties(c0683);
        this.f4113 = c0683;
        this.f41028.mo776(false);
        this.f41017.mo776(false);
        this.f40973.mo776(false);
        if (!this.zz_城市.equals("daqing")) {
            this.f405817.mo776(false);
            this.f405817.mo774(false);
        }
        if (C0898_读写设置类.m6937_通过SP读取设置("高级").cmp(StringVariant.getStringVariant(C0108a.f262e)) == 0) {
            this.f409017.mo776(true);
            this.f41115.mo776(false);
            this.f408411.mo776(false);
            int i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
            this.f40782.mo928(5000);
            i = IntegerVariant.getIntegerVariant(i).sub(ByteVariant.getByteVariant((byte) 20)).getInteger();
            this.f409017.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) i), ".0", bi_常量类.f6358b));
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) i), "yangbosen123"), "UTF-8");
        }
        this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
        this.f41115.mo776(false);
        this.f41231.mo806(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).sub(IntegerVariant.getIntegerVariant(m5234(50))).getInteger());
        this.f41231.mo780(C0894.m6882());
        this.f41231.mo797(-921103);
        this.f41242.mo804(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).sub(IntegerVariant.getIntegerVariant(m5234(27))).getInteger());
        this.f41242.mo806(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).add(ByteVariant.getByteVariant((byte) 70)).getInteger());
        this.f41242.mo780(C0894.m6882());
        this.f41242.mo797(-921103);
        this.f405211.mo782(6);
        this.f405312.mo782(6);
        this.f405211.mo804(this.f4067 + m5234(80));
        this.f405312.mo804(this.f4067 + m5234(80));
        this.f405211.mo806(m5234(60));
        this.f405312.mo806(m5234(60));
        this.f40501.mo806(m5234(64));
        this.f40501.mo780(C0894.m6882());
        this.f40658.mo776(false);
        this.f405514.mo776(false);
        this.f408411.mo804(0);
        this.f408411.mo806(m5234(64));
        this.f408411.mo780(C0894.m6882());
        this.f408411.mo782(0);
        this.f408411.mo1049(13.0f);
        this.f41242.mo817("w34.jpg");
        this.f40821.mo1055("zt.ttf");
        this.f40932.mo1055("zt.ttf");
        this.f408411.mo1055("zt.ttf");
        this.f40984.mo1055("zt.ttf");
        this.f40995.mo1055("zt.ttf");
        this.f41006.mo1055("zt.ttf");
        this.f41017.mo1055("zt.ttf");
        this.f40973.mo1055("zt.ttf");
        this.f41028.mo1055("zt.ttf");
        this.f40821.mo804(m5234(76));
        this.f40821.mo780(C0894.m6882() - m5234(50));
        this.f40821.mo806(m5234(45));
        this.f40821.mo895(bi_常量类.f6358b);
        this.f40932.mo804(m5234(TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR));
        this.f40932.mo806(m5234(30));
        this.f40932.mo780(C0894.m6882());
        this.f40932.mo1049(9.0f);
        this.f40932.mo889(-6118750);
        this.f40932.mo895(bi_常量类.f6358b);
        this.f40592.mo804(m5234(165));
        this.f40592.mo806(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).sub(IntegerVariant.getIntegerVariant(m5234(160))).getInteger());
        this.f4067 = m5234(200);
        this.f40984.mo804(this.f4067 + m5234(31));
        this.f40984.mo782(m5234(40));
        this.f40984.mo780(m5234(148));
        this.f40984.mo806(m5234(85));
        this.f40973.mo804(this.f4067 + m5234(49));
        this.f40973.mo782(m5234(165));
        this.f40973.mo780(m5234(50));
        this.f40973.mo806(m5234(65));
        this.f40984.mo1049(30.0f);
        this.f41006.mo1049(30.0f);
        this.f40995.mo804(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).sub(IntegerVariant.getIntegerVariant(m5234(90))).getInteger());
        this.f40995.mo780(m5234(448));
        this.f40995.mo806(m5234(40));
        this.f41006.mo804(this.f4067 + m5234(31));
        this.f41006.mo782(DoubleVariant.getDoubleVariant(((double) C0894.m6882()) / 2.0d).add(IntegerVariant.getIntegerVariant(m5234(52))).getInteger());
        this.f41006.mo806(m5234(85));
        this.f41006.mo780(m5234(TbsListener.ErrorCode.APK_PATH_ERROR));
        this.f41028.mo804(this.f4067 + m5234(49));
        this.f41028.mo782(DoubleVariant.getDoubleVariant(((double) C0894.m6882()) / 2.0d).add(IntegerVariant.getIntegerVariant(m5234(135))).getInteger());
        this.f41028.mo806(m5234(75));
        this.f41028.mo780(m5234(TbsListener.ErrorCode.APK_PATH_ERROR));
        this.f41006.mo776(false);
        this.f41017.mo804(this.f4067 + m5234(4));
        this.f41017.mo782(DoubleVariant.getDoubleVariant(((double) C0894.m6882()) / 2.0d).add(IntegerVariant.getIntegerVariant(m5234(127))).getInteger());
        this.f41017.mo806(m5234(32));
        this.f41017.mo780(m5234(80));
        this.f41017.mo1049(11.0f);
        this.f40603.mo804(IntegerVariant.getIntegerVariant(this.f4067).add(ByteVariant.getByteVariant((byte) 2)).getInteger());
        this.f40603.mo806(m5234(135));
        this.f40603.mo780(m5234(3));
        this.f40614.mo804(this.f4067 + m5234(138));
        this.f40614.mo780(m5234(470));
        this.f40614.mo806(m5234(3));
        this.f40625.mo804(this.f4067 - m5234(24));
        this.f40625.mo782(C0894.m6882() - m5234(128));
        this.f40625.mo780(m5234(TbsListener.ErrorCode.WRITE_DISK_ERROR));
        this.f40625.mo806(m5234(27));
        this.f40625.mo776(false);
        this.f40636.mo804(m5234(70));
        this.f40636.mo782(5);
        this.f40636.mo780(C0894.m6882() - m5234(10));
        this.f40636.mo806(m5234(88));
        this.f40647.mo804(this.f4067 - m5234(14));
        this.f40647.mo780(m5234(TbsListener.ErrorCode.WRITE_DISK_ERROR));
        this.f40647.mo806(m5234(26));
        this.f40658.mo804(this.f40614.mo805() + m5234(TbsListener.ErrorCode.ERROR_QBSDK_INIT_ISSUPPORT));
        this.f408310.mo804(this.f40614.mo805() + m5234(TbsListener.ErrorCode.THROWABLE_INITX5CORE));
        this.f41192.mo804(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).sub(IntegerVariant.getIntegerVariant(m5234(65))).add(IntegerVariant.getIntegerVariant(this.f40995.mo805())).getInteger());
        this.f408512.mo804(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).add(IntegerVariant.getIntegerVariant(m5234(47))).getInteger());
        this.f408613.mo804(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).add(IntegerVariant.getIntegerVariant(m5234(47))).getInteger());
        this.f41115.mo804(0);
        this.f41115.mo780(C0894.m6882());
        this.f41115.mo806(m5234(63));
        this.f41231.mo814((ViewComponent) this.f40501);
        this.f41231.mo814((ViewComponent) this.f40592);
        this.f41231.mo814((ViewComponent) this.f40603);
        this.f41231.mo814((ViewComponent) this.f40614);
        this.f41231.mo814((ViewComponent) this.f40625);
        this.f41231.mo814((ViewComponent) this.f40647);
        this.f41231.mo814((ViewComponent) this.f41115);
        this.f41231.mo814((ViewComponent) this.f40984);
        this.f41231.mo814((ViewComponent) this.f40995);
        this.f41231.mo814((ViewComponent) this.f41006);
        this.f408916.mo804(m5234(85));
        this.f4042GIF1.mo804(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).add(IntegerVariant.getIntegerVariant(m5234(25))).getInteger());
        this.f4042GIF1.mo782(0);
        this.f4042GIF1.mo806(m5234(11));
        this.f4042GIF1.mo780(C0894.m6882());
        this.f40491.mo782(0);
        this.f40491.mo806(m5234(TbsListener.ErrorCode.VERIFY_ERROR));
        this.f40491.mo804(IntegerVariant.getIntegerVariant(C0894.m6884() - this.f40491.mo805()).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
        this.f40491.mo780(C0894.m6882());
        this.f40491.mo1083(7);
        this.f40491.mo1097("x1.png", "地图");
        this.f40491.mo1097("x2.png", "换向");
        this.f40491.mo1097("x3.png", "提醒");
        this.f40491.mo1097("x4.png", "纠错");
        this.f40491.mo1097("x5.png", "收藏");
        this.f40491.mo789();
        if (this.zz_城市.equals("haerbin")) {
            this.dddd = 20;
        } else {
            this.dddd = 30;
        }
    }

    /* renamed from: 获取车信息 */
    public void m5260() {
        String 路线 = bi_常量类.f6358b;
        String 坐标 = bi_常量类.f6358b;
        String 临时文本 = bi_常量类.f6358b;
        this.f4068 = C0898_读写设置类.m6937_通过SP读取设置("地址").getString();
        this.f4120 = C0898_读写设置类.m6937_通过SP读取设置("起始").getString();
        路线 = C0898_读写设置类.m6937_通过SP读取设置("站点").getString();
        坐标 = C0898_读写设置类.m6937_通过SP读取设置("坐标").getString();
        this.f4115_站点名字_String数组 = C0890_文本操作.m6806_分割字符串(路线, "||");
        this.f4116_站点坐标_String数组 = C0890_文本操作.m6806_分割字符串(坐标, "\n");
        this.f4074 = C0888.m6769(ArrayVariant.getArrayVariant(this.f4115_站点名字_String数组));
        this.f4081 = C0898_读写设置类.m6937_通过SP读取设置("时间").getString();
        this.f4121 = this.f4081;
    }

    /* renamed from: 增加N */
    public String m5239N(String 数据) {
        String 增加N = bi_常量类.f6358b;
        this.f4045 = bi_常量类.f6358b;
        数据 = C0890_文本操作.m6808(数据);
        for (int x = 0; x <= C0890_文本操作.m6817_获取字符串长度(数据); x = IntegerVariant.getIntegerVariant(x).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
            if (!C0890_文本操作.m6814_截取子串(数据, x, 1).equals(null)) {
                if (this.f4045.equals(bi_常量类.f6358b)) {
                    this.f4045 = C0890_文本操作.m6814_截取子串(数据, x, 1);
                } else {
                    this.f4045 = (this.f4045 + "\n") + C0890_文本操作.m6814_截取子串(数据, x, 1);
                }
            }
        }
        return 增加N;
    }

    /* renamed from: 加载站点 */
    public void m5232_加载站点(String str, String str2, int i) {
        String str3 = bi_常量类.f6358b;
        try {
            String 站临时 = bi_常量类.f6358b;
            C0725Impl c0725Impl = new C0725Impl(this.f41061);
            Objects.initializeProperties(c0725Impl);
            C0723 站名 = c0725Impl;
            C0742Impl c0742Impl = new C0742Impl(this.f41061);
            Objects.initializeProperties(c0742Impl);
            C0739 站标 = c0742Impl;
            this.f4105 = IntegerVariant.getIntegerVariant(i).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
            if (IntegerVariant.getIntegerVariant(C0894.m6884()).cmp(ShortVariant.getShortVariant((short) 860)) < 0) {
                站名.mo1049(10.0f);
            } else {
                站名.mo1049(11.0f);
            }
            站名.mo889(-14145496);
            站名.mo797(0);
            站名.mo776(true);
            站名.mo891(6);
            m5239N(str);
            String 站名字 = this.f4045;
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 10)) < 0) {
                站名.mo895(((IntegerVariant.getIntegerVariant(i).add(ByteVariant.getByteVariant((byte) 1)).getString() + " ") + "\n") + 站名字);
            } else {
                站名.mo895((IntegerVariant.getIntegerVariant(i).add(ByteVariant.getByteVariant((byte) 1)).getString() + "\n") + 站名字);
            }
            站名.mo780((int) (((double) C0894.m6882()) / 12.0d));
            站名.mo806(-2);
            站名.mo790(IntegerVariant.getIntegerVariant(this.f4105).mul(ByteVariant.getByteVariant((byte) 8).add(ShortVariant.getShortVariant((short) 145))).getInteger(), m5234(65), (int) (((double) C0894.m6882()) / 12.0d), this.f41061.mo805() - m5234(80));
            站名.mo1053(i);
            站名.mo1052(this.f40461);
            this.f4114_站点名集合.m5454(ObjectVariant.getObjectVariant(站名));
            站标.mo780(DoubleVariant.getDoubleVariant(((double) C0894.m6882()) / 12.0d).add(IntegerVariant.getIntegerVariant(m5234(6))).getInteger());
            站标.mo806((int) (((double) 站标.mo779()) / 2.0d));
            站标.mo1143(1);
            站标.mo1139(bi_常量类.f6358b);
            站标.mo790(IntegerVariant.getIntegerVariant(this.f4105).mul(ByteVariant.getByteVariant((byte) 8).add(ShortVariant.getShortVariant((short) 145))).getInteger(), m5234(30), 站标.mo779(), 站标.mo805());
            站标.mo776(true);
            this.f4113.m5454(ObjectVariant.getObjectVariant(站标));
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 图片框1$被单击 */
    public void m52361$() {
        int integer = IntegerVariant.getIntegerVariant(this.f4113.m5456()).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
        for (int 计数 = 0; 计数 <= integer; 计数++) {
            ((C0723) this.f4114_站点名集合.m5455(计数).getObject()).mo802();
            ((C0739) this.f4113.m5455(计数).getObject()).mo802();
        }
        this.f40771.mo928(0);
        this.f40793.mo928(0);
        this.f41242.mo815();
        this.f41082.mo776(false);
        this.f41082.mo774(false);
        this.f40782.mo928(0);
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口14"));
    }

    /* renamed from: 标签11$被单击 */
    public void m524811$() {
        m5256();
    }

    /* renamed from: 清除数据 */
    public void m5256() {
        int integer = IntegerVariant.getIntegerVariant(this.f4113.m5456()).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
        for (int 计数 = 0; 计数 <= integer; 计数++) {
            ((C0723) this.f4114_站点名集合.m5455(计数).getObject()).mo802();
            ((C0739) this.f4113.m5455(计数).getObject()).mo802();
        }
        this.f41061.mo780(m5234(480));
        this.f40771.mo928(0);
        this.f40793.mo928(0);
        this.f41242.mo815();
        this.f41061.mo802();
        this.f40782.mo928(0);
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }

    /* renamed from: 事件监听器1$被单击 */
    public void m52291$(int i) {
        try {
            this.f41028.mo776(true);
            this.f40973.mo776(true);
            this.f408714.mo776(false);
            this.f408815.mo776(false);
            C0723 名字 = (C0723) this.f4114_站点名集合.m5455(i).getObject();
            C0739 图标 = (C0739) this.f4113.m5455(i).getObject();
            this.f4073 = i;
            图标.mo1139("ic_dot_red23.png");
            名字.mo889(Component.f3916);
            图标.mo806((int) (DoubleVariant.getDoubleVariant(((double) C0894.m6882()) / 12.0d).add(IntegerVariant.getIntegerVariant(m5234(6))).getDouble() / 2.0d));
            if (LongVariant.getLongVariant(C0891.m6826() - this.bx).cmp(ShortVariant.getShortVariant((short) 5000)) > 0) {
                this.f409118.mo895(bi_常量类.f6358b);
                this.f409219.mo895(bi_常量类.f6358b);
                this.f409420.mo895(bi_常量类.f6358b);
                this.f409521.mo895(bi_常量类.f6358b);
                this.f409622.mo895(bi_常量类.f6358b);
                this.f409118.mo776(false);
                this.f409219.mo776(false);
                this.f409420.mo776(false);
                this.f409521.mo776(false);
                this.f409622.mo776(false);
                this.f40691.mo1169(this.f4068, "GBK");
                this.bx = C0891.m6826();
            } else if (LongVariant.getLongVariant(C0891.m6826() - this.bx).cmp(ShortVariant.getShortVariant((short) 500)) < 0) {
                C0880_应用操作类.m6694("请不要连击屏幕");
            } else {
                this.f409118.mo895(bi_常量类.f6358b);
                this.f409219.mo895(bi_常量类.f6358b);
                this.f409420.mo895(bi_常量类.f6358b);
                this.f409521.mo895(bi_常量类.f6358b);
                this.f409622.mo895(bi_常量类.f6358b);
                this.f409118.mo776(false);
                this.f409219.mo776(false);
                this.f409420.mo776(false);
                this.f409521.mo776(false);
                this.f409622.mo776(false);
                m5263();
            }
            this.f40771.mo928(5000);
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 刷新 */
    public void mo769() {
        try {
            int integer = IntegerVariant.getIntegerVariant(this.f4114_站点名集合.m5456()).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
            for (int i = 0; i <= integer; i++) {
                if (this.f4073 != i) {
                    C0723 站名 = (C0723) this.f4114_站点名集合.m5455(i).getObject();
                    ((C0739) this.f4113.m5455(i).getObject()).mo1139(bi_常量类.f6358b);
                    站名.mo889(-16777216);
                    if (IntegerVariant.getIntegerVariant(C0894.m6884()).cmp(ShortVariant.getShortVariant((short) 860)) < 0) {
                        站名.mo1049(10.0f);
                    } else {
                        站名.mo1049(11.0f);
                    }
                }
            }
            this.f405514.mo776(false);
            this.f405615.mo776(false);
            this.f405716.mo776(false);
            this.f40669.mo776(false);
            this.f405413.mo776(false);
            this.f41006.mo776(false);
            this.f41017.mo776(false);
            this.f40625.mo776(false);
            this.f40482.mo782(-70);
            this.f405514.mo776(false);
            this.f409118.mo776(false);
            this.f409219.mo776(false);
            this.f409420.mo776(false);
            this.f409521.mo776(false);
            this.f409622.mo776(false);
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 计算车在哪里 */
    public void m5263() {
        String str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        try {
            String ccs = bi_常量类.f6358b;
            String 文本 = bi_常量类.f6358b;
            String 临时文本 = bi_常量类.f6358b;
            String 预计时间 = bi_常量类.f6358b;
            String 标题 = bi_常量类.f6358b;
            String 搜索字 = bi_常量类.f6358b;
            String 搜索字1 = bi_常量类.f6358b;
            String 搜索字2 = bi_常量类.f6358b;
            String 搜索字3 = bi_常量类.f6358b;
            String 搜索字6 = bi_常量类.f6358b;
            String 搜索字5 = bi_常量类.f6358b;
            String[] 经纬 = new String[2];
            mo769();
            this.f409118.mo895(bi_常量类.f6358b);
            this.f409219.mo895(bi_常量类.f6358b);
            this.f409420.mo895(bi_常量类.f6358b);
            this.f409521.mo895(bi_常量类.f6358b);
            this.f409622.mo895(bi_常量类.f6358b);
            this.f409118.mo776(false);
            this.f409219.mo776(false);
            this.f409420.mo776(false);
            this.f409521.mo776(false);
            this.f409622.mo776(false);
            this.f408714.mo895(bi_常量类.f6358b);
            this.f408815.mo895(bi_常量类.f6358b);
            if (C0889_文件操作.m6797(((((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz_城市) + "/") + this.f4117_线路名) + "A.TXT")) {
                ccs = C0889_文件操作.m6802(((((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz_城市) + "/") + this.f4117_线路名) + "A.TXT", "GBK");
                if (!ccs.equals(bi_常量类.f6358b)) {
                    this.f41181.mo887(ccs);
                    this.jc = 0;
                    int 车3 = 1;
                    boolean 车在 = false;
                    while (this.jc < C0888.m6769(ArrayVariant.getArrayVariant(this.f4115_站点名字_String数组))) {
                        int 综合数 = IntegerVariant.getIntegerVariant(this.f4073).sub(ByteVariant.getByteVariant((byte) 1)).sub(IntegerVariant.getIntegerVariant(this.jc)).getInteger();
                        if (IntegerVariant.getIntegerVariant(this.f4073).cmp(ByteVariant.getByteVariant((byte) 0)) != 0) {
                            for (int js = 0; js <= 50; js++) {
                                boolean 半站 = false;
                                搜索字 = ("a" + C0899.m6959(IntegerVariant.getIntegerVariant(js).add(ByteVariant.getByteVariant((byte) 1)).getInteger())) + "a";
                                搜索字1 = ("a" + C0899.m6959(IntegerVariant.getIntegerVariant(js).add(ByteVariant.getByteVariant((byte) 1)).getInteger())) + "a<";
                                搜索字2 = ">g" + C0899.m6959(IntegerVariant.getIntegerVariant(js).add(ByteVariant.getByteVariant((byte) 1)).getInteger());
                                搜索字3 = ("g" + C0899.m6959(IntegerVariant.getIntegerVariant(js).add(ByteVariant.getByteVariant((byte) 1)).getInteger())) + "<";
                                搜索字5 = ">f" + C0899.m6959(IntegerVariant.getIntegerVariant(js).add(ByteVariant.getByteVariant((byte) 1)).getInteger());
                                搜索字6 = ("f" + C0899.m6959(IntegerVariant.getIntegerVariant(js).add(ByteVariant.getByteVariant((byte) 1)).getInteger())) + "<";
                                临时文本 = m5233(this.f41181.mo886(), 搜索字, 搜索字1);
                                if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(临时文本, this.f4076, 1)).cmp(ByteVariant.getByteVariant((byte) -1)) > 0) {
                                    文本 = C0890_文本操作.m6814_截取子串(临时文本, 0, C0890_文本操作.m6821(临时文本, "|", 0));
                                    if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(文本, ".", 0)).cmp(ByteVariant.getByteVariant((byte) -1)) > 0) {
                                        文本 = C0890_文本操作.m6814_截取子串(临时文本, 0, C0890_文本操作.m6821(临时文本, ".", 0));
                                        半站 = true;
                                    }
                                    if (文本.equals("0")) {
                                        文本 = "0";
                                    } else if (C0899.m6944(文本) != 综合数) {
                                        continue;
                                    } else {
                                        C0739 图像;
                                        int P;
                                        if (IntegerVariant.getIntegerVariant(车3).cmp(ByteVariant.getByteVariant((byte) 1)) == 0) {
                                            图像 = (C0739) this.f4113.m5455(综合数).getObject();
                                            ((C0723) this.f4114_站点名集合.m5455(综合数).getObject()).mo889(-13906239);
                                            this.f409118.mo776(true);
                                            this.f409118.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                            this.f409118.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                            this.f409118.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                            this.f409118.mo806(65);
                                            this.f409118.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                            this.b18 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            if (综合数 == this.f4073) {
                                                图像.mo1139("loc_focus.png");
                                                车在 = true;
                                            } else {
                                                if (半站) {
                                                    this.f409118.mo776(true);
                                                    this.f409118.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                                    this.f409118.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                                    this.f409118.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                                    this.f409118.mo806(65);
                                                    this.f409118.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                                    this.b18 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                                    this.f405514.mo776(true);
                                                    this.f405514.mo804(图像.mo803());
                                                    this.f405514.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).getInteger());
                                                    this.f405514.mo780(图像.mo779());
                                                    this.f405514.mo806(图像.mo805());
                                                    this.f405514.mo1139("011.jpg");
                                                } else {
                                                    图像.mo1139("011.jpg");
                                                }
                                                if (IntegerVariant.getIntegerVariant(C0899.m6944(文本)).cmp(StringVariant.getStringVariant("0")) == 0) {
                                                    this.f41006.mo776(true);
                                                    this.f41006.mo895("起点");
                                                    this.f40984.mo895(bi_常量类.f6358b);
                                                    this.f40973.mo895(bi_常量类.f6358b);
                                                    this.f41017.mo895(bi_常量类.f6358b);
                                                    this.f41028.mo895(bi_常量类.f6358b);
                                                    C0894.m6875();
                                                    break;
                                                }
                                                标题 = C0890_文本操作.m6819(((C0723) this.f4114_站点名集合.m5455(综合数).getObject()).mo894(), "\n", bi_常量类.f6358b);
                                                this.f40995.mo776(true);
                                                if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6817_获取字符串长度(标题)).cmp(ByteVariant.getByteVariant((byte) 9)) > 0) {
                                                    this.f40995.mo895("过" + 标题);
                                                } else {
                                                    this.f40995.mo895("最近车辆经过-" + 标题);
                                                }
                                                this.f41028.mo776(true);
                                                this.f41028.mo895("站");
                                                this.f41006.mo895(C0899.m6959(this.jc));
                                                this.f41006.mo776(true);
                                                this.f40625.mo776(true);
                                                P = 0;
                                                while (IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).cmp(IntegerVariant.getIntegerVariant(this.f4073).add(ByteVariant.getByteVariant((byte) 1))) < 0) {
                                                    P += C0899.m6944(this.f4116_站点坐标_String数组[IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).getInteger()]);
                                                    综合数 = IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
                                                }
                                                if (IntegerVariant.getIntegerVariant(P).cmp(ShortVariant.getShortVariant((short) 500)) < 0) {
                                                    this.f41017.mo895(C0899.m6959(P) + "米");
                                                    this.f40984.mo895(C0899.m6959((int) (((double) this.jc) / 2.0d)));
                                                    if (this.f40984.mo894().equals("0")) {
                                                        this.f40984.mo895("﹤1");
                                                    }
                                                } else if (IntegerVariant.getIntegerVariant(P).cmp(ShortVariant.getShortVariant((short) 500)) > 0) {
                                                    this.f41017.mo895(Double.toString(C0893.m6861(ConvHelpers.string2double(C0899.m6945(((double) P) / 1000.0d)), 1)) + "km");
                                                    if (StringVariant.getStringVariant(m5262((int) (((double) P) / 1000.0d), this.dddd)).cmp(ByteVariant.getByteVariant((byte) 99)) > 0) {
                                                        this.f40984.mo895(">99");
                                                    } else {
                                                        this.f40984.mo895(C0899.m6959(StringVariant.getStringVariant(m5262((int) (((double) P) / 1000.0d), this.dddd)).add(DoubleVariant.getDoubleVariant(((double) this.jc) / 2.0d)).getInteger()));
                                                    }
                                                    if (this.f40984.mo894().equals("0")) {
                                                        this.f40984.mo895(C0108a.f262e);
                                                    }
                                                }
                                                this.f41017.mo776(true);
                                                this.f40973.mo776(true);
                                                this.f40973.mo895("分");
                                            }
                                        }
                                        if (IntegerVariant.getIntegerVariant(车3).cmp(ByteVariant.getByteVariant((byte) 2)) == 0) {
                                            图像 = (C0739) this.f4113.m5455(综合数).getObject();
                                            ((C0723) this.f4114_站点名集合.m5455(综合数).getObject()).mo889(-13906239);
                                            this.f409219.mo776(true);
                                            this.f409219.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                            this.f409219.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                            this.f409219.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                            this.f409219.mo806(65);
                                            this.f409219.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                            this.b19 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            P = 0;
                                            while (IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).cmp(IntegerVariant.getIntegerVariant(this.f4073).add(ByteVariant.getByteVariant((byte) 1))) < 0) {
                                                P += C0899.m6944(this.f4116_站点坐标_String数组[IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).getInteger()]);
                                                综合数 = IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
                                            }
                                            if (IntegerVariant.getIntegerVariant(P).cmp(ShortVariant.getShortVariant((short) 500)) < 0) {
                                                this.f408714.mo895((((((("第2车距您" + C0899.m6959(this.jc)) + "站,") + C0899.m6959(P)) + "米") + ",约") + C0899.m6959(ByteVariant.getByteVariant((byte) 1).add(DoubleVariant.getDoubleVariant(((double) this.jc) / 2.0d)).getInteger())) + "分");
                                            } else if (IntegerVariant.getIntegerVariant(P).cmp(ShortVariant.getShortVariant((short) 500)) > 0) {
                                                this.f408714.mo895((((((("第2车距您" + C0899.m6959(this.jc)) + "站,") + Double.toString(C0893.m6861(ConvHelpers.string2double(C0899.m6945(((double) P) / 1000.0d)), 1))) + "km") + ",约") + C0899.m6959(StringVariant.getStringVariant(m5262((int) (((double) P) / 1000.0d), this.dddd)).add(DoubleVariant.getDoubleVariant(((double) this.jc) / 2.0d)).getInteger())) + "分");
                                            }
                                            if (半站) {
                                                this.f405615.mo776(true);
                                                this.f405615.mo804(图像.mo803());
                                                this.f405615.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).getInteger());
                                                this.f405615.mo780(图像.mo779());
                                                this.f405615.mo806(图像.mo805());
                                                this.f405615.mo1139("011.jpg");
                                                this.f409219.mo776(true);
                                                this.f409219.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                                this.f409219.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                                this.f409219.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                                this.f409219.mo806(65);
                                                this.f409219.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                                this.b19 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            } else {
                                                图像.mo1139("011.jpg");
                                            }
                                            if (车在) {
                                                标题 = C0890_文本操作.m6819(((C0723) this.f4114_站点名集合.m5455(综合数).getObject()).mo894(), "\n", bi_常量类.f6358b);
                                                this.f40995.mo776(true);
                                                if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6817_获取字符串长度(标题)).cmp(ByteVariant.getByteVariant((byte) 9)) > 0) {
                                                    this.f40995.mo895("到" + 标题);
                                                } else {
                                                    this.f40995.mo895("最近车辆已到-" + 标题);
                                                }
                                                this.f41028.mo776(true);
                                                this.f41028.mo895("站");
                                                this.f41006.mo895(C0899.m6959(this.jc));
                                                this.f41006.mo776(true);
                                                this.f40625.mo776(true);
                                                车在 = false;
                                            }
                                        }
                                        if (IntegerVariant.getIntegerVariant(车3).cmp(ByteVariant.getByteVariant((byte) 3)) == 0) {
                                            图像 = (C0739) this.f4113.m5455(综合数).getObject();
                                            ((C0723) this.f4114_站点名集合.m5455(综合数).getObject()).mo889(-13906239);
                                            this.f409420.mo776(true);
                                            this.f409420.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                            this.f409420.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                            this.f409420.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                            this.f409420.mo806(65);
                                            this.f409420.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                            this.b20 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            P = 0;
                                            while (IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).cmp(IntegerVariant.getIntegerVariant(this.f4073).add(ByteVariant.getByteVariant((byte) 1))) < 0) {
                                                P += C0899.m6944(this.f4116_站点坐标_String数组[IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).getInteger()]);
                                                综合数 = IntegerVariant.getIntegerVariant(综合数).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
                                            }
                                            if (IntegerVariant.getIntegerVariant(P).cmp(ShortVariant.getShortVariant((short) 500)) < 0) {
                                                this.f408815.mo895((((((("第3车距您" + C0899.m6959(this.jc)) + "站,") + C0899.m6959(P)) + "米") + ",约") + C0899.m6959(ByteVariant.getByteVariant((byte) 1).add(DoubleVariant.getDoubleVariant(((double) this.jc) / 2.0d)).getInteger())) + "分");
                                            } else if (IntegerVariant.getIntegerVariant(P).cmp(ShortVariant.getShortVariant((short) 500)) > 0) {
                                                this.f408815.mo895((((((("第3车距您" + C0899.m6959(this.jc)) + "站,") + Double.toString(C0893.m6861(ConvHelpers.string2double(C0899.m6945(((double) P) / 1000.0d)), 1))) + "km") + ",约") + C0899.m6959(StringVariant.getStringVariant(m5262((int) (((double) P) / 1000.0d), this.dddd)).add(DoubleVariant.getDoubleVariant(((double) this.jc) / 2.0d)).getInteger())) + "分");
                                            }
                                            if (半站) {
                                                this.f405716.mo776(true);
                                                this.f405716.mo804(图像.mo803());
                                                this.f405716.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).getInteger());
                                                this.f405716.mo780(图像.mo779());
                                                this.f405716.mo806(图像.mo805());
                                                this.f405716.mo1139("011.jpg");
                                                this.f409420.mo776(true);
                                                this.f409420.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                                this.f409420.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                                this.f409420.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                                this.f409420.mo806(65);
                                                this.f409420.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                                this.b20 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            } else {
                                                图像.mo1139("011.jpg");
                                            }
                                            if (车在) {
                                                标题 = C0890_文本操作.m6819(((C0723) this.f4114_站点名集合.m5455(综合数).getObject()).mo894(), "\n", bi_常量类.f6358b);
                                                this.f40995.mo776(true);
                                                if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6817_获取字符串长度(标题)).cmp(ByteVariant.getByteVariant((byte) 9)) > 0) {
                                                    this.f40995.mo895("到" + 标题);
                                                } else {
                                                    this.f40995.mo895("最近车辆已到-" + 标题);
                                                }
                                                this.f41028.mo776(true);
                                                this.f41028.mo895("站");
                                                this.f41006.mo895(C0899.m6959(this.jc));
                                                this.f41006.mo776(true);
                                                this.f40625.mo776(true);
                                                车在 = false;
                                            }
                                        }
                                        if (IntegerVariant.getIntegerVariant(车3).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                                            图像 = (C0739) this.f4113.m5455(综合数).getObject();
                                            ((C0723) this.f4114_站点名集合.m5455(综合数).getObject()).mo889(-13906239);
                                            this.f409521.mo776(true);
                                            this.f409521.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                            this.f409521.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                            this.f409521.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                            this.f409521.mo806(65);
                                            this.f409521.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                            this.b21 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            if (半站) {
                                                this.f40669.mo776(true);
                                                this.f40669.mo804(图像.mo803());
                                                this.f40669.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).getInteger());
                                                this.f40669.mo780(图像.mo779());
                                                this.f40669.mo806(图像.mo805());
                                                this.f40669.mo1139("011.jpg");
                                                this.f409521.mo776(true);
                                                this.f409521.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                                this.f409521.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                                this.f409521.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                                this.f409521.mo806(65);
                                                this.f409521.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                                this.b21 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            } else {
                                                图像.mo1139("011.jpg");
                                            }
                                        }
                                        if (IntegerVariant.getIntegerVariant(车3).cmp(ByteVariant.getByteVariant((byte) 5)) == 0) {
                                            图像 = (C0739) this.f4113.m5455(综合数).getObject();
                                            ((C0723) this.f4114_站点名集合.m5455(综合数).getObject()).mo889(-13906239);
                                            this.f409622.mo776(true);
                                            this.f409622.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                            this.f409622.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                            this.f409622.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                            this.f409622.mo806(65);
                                            this.f409622.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                            this.b22 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            if (半站) {
                                                this.f405413.mo776(true);
                                                this.f405413.mo804(图像.mo803());
                                                this.f405413.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).getInteger());
                                                this.f405413.mo780(图像.mo779());
                                                this.f405413.mo806(图像.mo805());
                                                this.f405413.mo1139("011.jpg");
                                                this.f409622.mo776(true);
                                                this.f409622.mo804(IntegerVariant.getIntegerVariant(图像.mo803() - 图像.mo805()).sub(DoubleVariant.getDoubleVariant(((double) 图像.mo805()) / 2.0d)).getInteger());
                                                this.f409622.mo782(IntegerVariant.getIntegerVariant(图像.mo781()).add(ByteVariant.getByteVariant((byte) 30)).sub(ByteVariant.getByteVariant((byte) 25)).getInteger());
                                                this.f409622.mo780(IntegerVariant.getIntegerVariant(图像.mo779()).add(ByteVariant.getByteVariant((byte) 50)).getInteger());
                                                this.f409622.mo806(65);
                                                this.f409622.mo895(m5233(this.f41181.mo886(), 搜索字2, 搜索字3));
                                                this.b22 = m5233(this.f41181.mo886(), 搜索字5, 搜索字6);
                                            } else {
                                                图像.mo1139("011.jpg");
                                            }
                                        }
                                        if (IntegerVariant.getIntegerVariant(车3).cmp(ByteVariant.getByteVariant((byte) 5)) > 0) {
                                            C0894.m6875();
                                            break;
                                        }
                                        车3 = IntegerVariant.getIntegerVariant(车3).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
                                    }
                                }
                            }
                            if (IntegerVariant.getIntegerVariant(车3).cmp(ByteVariant.getByteVariant((byte) 5)) > 0) {
                                break;
                            }
                            this.jc = IntegerVariant.getIntegerVariant(this.jc).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
                        } else {
                            this.f41006.mo776(true);
                            this.f41006.mo895("起点");
                            this.f40984.mo895(bi_常量类.f6358b);
                            this.f40973.mo895(bi_常量类.f6358b);
                            this.f41017.mo895(bi_常量类.f6358b);
                            this.f41028.mo895(bi_常量类.f6358b);
                            C0894.m6875();
                            break;
                        }
                    }
                    if (IntegerVariant.getIntegerVariant(车3).cmp(ByteVariant.getByteVariant((byte) 1)) == 0) {
                        this.f40995.mo895("↓选择候车站名↓");
                        this.f41006.mo776(true);
                        this.f41006.mo895(bi_常量类.f6358b);
                        this.f40984.mo895(bi_常量类.f6358b);
                        this.f40973.mo895(bi_常量类.f6358b);
                        this.f41017.mo895(bi_常量类.f6358b);
                        this.f41028.mo895(bi_常量类.f6358b);
                        C0894.m6875();
                    }
                }
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 时钟1$周期事件 */
    public void m52441$() {
        this.f40691.mo1169(this.f4068, "GBK");
    }

    /* renamed from: 多线程1$取网页源码完毕 */
    public void m52411$(String str) {
        String str2 = bi_常量类.f6358b;
        try {
            String ccss = bi_常量类.f6358b;
            ccss = m5233(str, Integer.toString(ConvHelpers.byte2integer((byte) 4)), Integer.toString(ConvHelpers.byte2integer((byte) 4)));
            if (!str.equals(bi_常量类.f6358b) && !ccss.equals("0")) {
                C0889_文件操作.m6781_写出文本文件(((((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz_城市) + "/") + this.f4117_线路名) + "A.TXT", str, "GBK");
                m5263();
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 取中间文本 */
    public String m5233(String str, String str2, String str3) {
        String 取中间文本 = bi_常量类.f6358b;
        try {
            取中间文本 = bi_常量类.f6358b;
            int 左边 = C0890_文本操作.m6821(str, str2, 0) + C0890_文本操作.m6817_获取字符串长度(str2);
            if (IntegerVariant.getIntegerVariant(左边).cmp(ByteVariant.getByteVariant((byte) -1)) == 0) {
                return bi_常量类.f6358b;
            }
            int 右边 = C0890_文本操作.m6821(str, str3, 左边);
            if (IntegerVariant.getIntegerVariant(右边).cmp(ByteVariant.getByteVariant((byte) -1)) == 0 || 左边 > 右边) {
                return bi_常量类.f6358b;
            }
            return C0890_文本操作.m6814_截取子串(str, 左边, 右边 - 左边);
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
            return 取中间文本;
        }
    }

    /* renamed from: 窗口1$切换完毕 */
    public void m52571$() {
        String str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        try {
            String n = bi_常量类.f6358b;
            String nn = bi_常量类.f6358b;
            this.f408714.mo776(false);
            this.f408815.mo776(false);
            this.f408411.mo776(true);
            this.zz_城市 = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
            this.f41082.mo776(false);
            this.f41082.mo774(false);
            C0822Impl c0822Impl = new C0822Impl(this.f41242);
            Objects.initializeProperties(c0822Impl);
            this.f41061 = c0822Impl;
            this.f41061.mo782(0);
            this.f41061.mo804(0);
            this.f41061.mo774(true);
            this.f41061.mo806(DoubleVariant.getDoubleVariant(((double) C0894.m6884()) / 2.0d).sub(IntegerVariant.getIntegerVariant(m5234(60))).getInteger());
            this.f41061.mo780(C0894.m6882());
            this.f41061.mo776(true);
            this.f41061.mo1465((ViewComponent) this.f405514);
            this.f41061.mo1465((ViewComponent) this.f405615);
            this.f41061.mo1465((ViewComponent) this.f405716);
            this.f41061.mo1465((ViewComponent) this.f40669);
            this.f41061.mo1465((ViewComponent) this.f405413);
            this.f41061.mo1465((ViewComponent) this.f405817);
            this.f41061.mo1465((ViewComponent) this.f409118);
            this.f41061.mo1465((ViewComponent) this.f409219);
            this.f41061.mo1465((ViewComponent) this.f409420);
            this.f41061.mo1465((ViewComponent) this.f409521);
            this.f41061.mo1465((ViewComponent) this.f409622);
            this.f409017.mo776(false);
            this.f405817.mo782(15);
            this.f405817.mo780(TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            this.f405817.mo806(TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
            this.f405817.mo804(160);
            this.f41061.mo768();
            this.f405514.mo782(0);
            this.f405514.mo776(false);
            this.f405615.mo782(0);
            this.f405615.mo776(false);
            this.f405716.mo782(0);
            this.f405716.mo776(false);
            this.f40669.mo782(0);
            this.f40669.mo776(false);
            this.f405413.mo782(0);
            this.f405413.mo776(false);
            this.f409118.mo776(false);
            this.f409219.mo776(false);
            this.f409420.mo776(false);
            this.f409521.mo776(false);
            this.f409622.mo776(false);
            this.f40771.mo928(0);
            this.f40793.mo928(0);
            this.f40984.mo895(bi_常量类.f6358b);
            this.f40973.mo895(bi_常量类.f6358b);
            this.f41017.mo895(bi_常量类.f6358b);
            this.f41028.mo895(bi_常量类.f6358b);
            this.f41006.mo895(bi_常量类.f6358b);
            this.f41104.mo776(false);
            this.f41104.mo774(false);
            this.f4114_站点名集合.m5459();
            this.f4113.m5459();
            this.f4073 = 0;
            this.f4117_线路名 = C0898_读写设置类.m6937_通过SP读取设置("线路").getString();
            this.f4076 = C0898_读写设置类.m6937_通过SP读取设置("方向").getString();
            this.f41028.mo776(false);
            this.f40973.mo776(false);
            if (this.f4076.equals("zheng")) {
                this.f405211.mo776(true);
                this.f405312.mo776(false);
            } else {
                this.f405312.mo776(true);
                this.f405211.mo776(false);
            }
            this.f40995.mo776(true);
            this.f40995.mo895("↓请选择候车站名↓");
            this.f40973.mo895(bi_常量类.f6358b);
            this.f41028.mo895(bi_常量类.f6358b);
            this.f408411.mo895(C0890_文本操作.m6819(this.f4117_线路名, "f", bi_常量类.f6358b));
            this.f408411.mo895(C0890_文本操作.m6819(this.f408411.mo894(), "huan", "环 "));
            this.f408411.mo895(C0890_文本操作.m6819(this.f408411.mo894(), "kuai", "快 "));
            this.f408411.mo895((" " + C0890_文本操作.m6819(this.f408411.mo894(), "h", "环 ")) + " 路   ");
            this.f408411.mo895(C0890_文本操作.m6819(this.f408411.mo894(), "a", bi_常量类.f6358b));
            this.f408411.mo895(C0890_文本操作.m6819(this.f408411.mo894(), "m", bi_常量类.f6358b));
            this.f41093.mo976(((((this.wl + "/web/city/") + this.zz_城市) + "/shtml/") + this.f4117_线路名) + ".html");
            this.f408916.mo895(C0890_文本操作.m6808(C0890_文本操作.m6819(this.f408411.mo894(), "路", bi_常量类.f6358b)));
            this.f408916.mo895(C0890_文本操作.m6819(this.f408916.mo894(), "m", bi_常量类.f6358b));
            m5260();
            this.f40821.mo895(this.f4120);
            this.f40932.mo895(this.f4121);
            if (IntegerVariant.getIntegerVariant(this.f4113.m5456()).cmp(ByteVariant.getByteVariant((byte) 3)) > 0 && IntegerVariant.getIntegerVariant(this.f4114_站点名集合.m5456()).cmp(ByteVariant.getByteVariant((byte) 3)) > 0) {
                m5256();
            }
            for (int 计次 = 0; IntegerVariant.getIntegerVariant(计次).cmp(IntegerVariant.getIntegerVariant(this.f4074).sub(ByteVariant.getByteVariant((byte) 1))) < 0; 计次 = IntegerVariant.getIntegerVariant(计次).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
                m5232_加载站点(this.f4115_站点名字_String数组[计次], this.f4116_站点坐标_String数组[计次], 计次);
            }
            this.f4072 = C0898_读写设置类.m6937_通过SP读取设置("高高分").getString();
            if (!this.f4072.equals(bi_常量类.f6358b)) {
                this.f408411.mo776(false);
                this.f41115.mo776(true);
                this.f41115.mo976(this.f4072);
            }
            if (this.f4072.equals(bi_常量类.f6358b) && this.f4071.equals(bi_常量类.f6358b)) {
                this.f41115.mo776(false);
            }
            if (C0898_读写设置类.m6937_通过SP读取设置("高级").cmp(StringVariant.getStringVariant(C0108a.f262e)) == 0) {
                this.f409017.mo776(true);
                this.f41115.mo776(false);
                this.f408411.mo776(false);
                int i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
                this.f40782.mo928(5000);
                i = IntegerVariant.getIntegerVariant(i).sub(ByteVariant.getByteVariant((byte) 20)).getInteger();
                this.f409017.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) i), ".0", bi_常量类.f6358b));
                C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) i), "yangbosen123"), "UTF-8");
            }
            this.f40804.mo928(VTMCDataCache.MAXSIZE);
            if (this.zz_城市.equals("haerbin")) {
                this.dddd = 20;
            } else {
                this.dddd = 30;
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 计算 */
    public String m5262(int i, int i2) {
        String 整数到时间;
        Throwable th;
        String str = bi_常量类.f6358b;
        try {
            str = bi_常量类.f6358b;
            try {
                整数到时间 = m5243(C0893.m6855(DoubleVariant.getDoubleVariant(((double) C0899.m6944(Integer.toString(i))) / ((double) C0899.m6944(Integer.toString(i2)))).mul(IntegerVariant.getIntegerVariant(3600000))));
            } catch (Throwable th2) {
                th = th2;
                整数到时间 = str;
                RuntimeError.convertToRuntimeError(th);
                return 整数到时间;
            }
        } catch (Throwable th22) {
            th = th22;
            整数到时间 = str;
            RuntimeError.convertToRuntimeError(th);
            return 整数到时间;
        }
        return 整数到时间;
    }

    /* renamed from: 整数到时间 */
    public String m5243(long j) {
        String 整数到时间 = bi_常量类.f6358b;
        try {
            整数到时间 = bi_常量类.f6358b;
            long 参数2;
            long 参数3;
            if (LongVariant.getLongVariant(j).cmp(IntegerVariant.getIntegerVariant(36000000)) > 0) {
                long 参数1 = C0893.m6855(DoubleVariant.getDoubleVariant(((double) j) / 3600000.0d));
                参数2 = C0893.m6855(DoubleVariant.getDoubleVariant(LongVariant.getLongVariant(j).sub(LongVariant.getLongVariant(参数1).mul(IntegerVariant.getIntegerVariant(3600000))).getDouble() / 60000.0d));
                参数3 = C0893.m6855(DoubleVariant.getDoubleVariant(LongVariant.getLongVariant(j).sub(LongVariant.getLongVariant(参数1).mul(IntegerVariant.getIntegerVariant(3600000))).sub(LongVariant.getLongVariant(参数2).mul(IntegerVariant.getIntegerVariant(60000))).getDouble() / 1000.0d));
                整数到时间 = ((C0899.m6959((int) 参数1) + "小时") + m5261(C0899.m6959((int) 参数2))) + bi_常量类.f6358b;
                this.f40973.mo776(false);
                return 整数到时间;
            }
            参数2 = C0893.m6855(DoubleVariant.getDoubleVariant(((double) j) / 60000.0d));
            参数3 = C0893.m6855(DoubleVariant.getDoubleVariant(LongVariant.getLongVariant(j).sub(LongVariant.getLongVariant(参数2).mul(IntegerVariant.getIntegerVariant(60000))).getDouble() / 1000.0d));
            return m5261(C0899.m6959((int) 参数2)) + bi_常量类.f6358b;
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
            return 整数到时间;
        }
    }

    /* renamed from: 补零 */
    public String m5261(String str) {
        String 补零 = bi_常量类.f6358b;
        try {
            补零 = bi_常量类.f6358b;
            if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6817_获取字符串长度(str)).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
                return "00";
            }
            return IntegerVariant.getIntegerVariant(C0890_文本操作.m6817_获取字符串长度(str)).cmp(ByteVariant.getByteVariant((byte) 1)) == 0 ? "0" + str : str;
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
            return 补零;
        }
    }

    /* renamed from: 图片列表框1$表项被单击 */
    public void m52351$_底部五个按钮点击事件(int 项目索引) {
        String 正反 = bi_常量类.f6358b;
        String 方向 = bi_常量类.f6358b;
        String 资源1 = bi_常量类.f6358b;
        String 正反1 = bi_常量类.f6358b;
        String 线路a = bi_常量类.f6358b;
        if (项目索引 == 0) {
            this.f41082.mo776(true);
            this.f41082.mo774(true);
            this.f41082.mo804(0);
            this.f41082.mo782(0);
            this.f41082.mo780(C0894.m6882());
            this.f41082.mo806(C0894.m6884());
            if (C0898_读写设置类.m6937_通过SP读取设置("正反").getString().equals("正")) {
                方向 = Integer.toString(ConvHelpers.byte2integer((byte) 1));
            } else {
                this.f4117_线路名 = C0890_文本操作.m6814_截取子串(this.f4117_线路名, 1, C0890_文本操作.m6817_获取字符串长度(this.f4117_线路名));
                方向 = Integer.toString(ConvHelpers.byte2integer((byte) null));
            }
            if (this.zz_城市.equals("daqing")) {
                资源1 = C0889_文件操作.m6803_读入资源文件("index.TXT", "UTF-8");
                this.f4117_线路名 = C0890_文本操作.m6819(this.f4117_线路名, "huan", "环");
                C0889_文件操作.m6781_写出文本文件(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz_城市) + "/805.html", C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(资源1, "haimalu", C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(this.f4117_线路名, "h", "环"), "k", "快"), "m", bi_常量类.f6358b), "环", "环线巴士")), "路线", this.f4117_线路名), "方向", 方向), "大庆", this.zz_城市), "UTF-8");
                this.f41082.mo976(("file:///sdcard/cityisba/" + this.zz_城市) + "/805.html");
                return;
            }
            this.f41082.mo976((("http://busmishu.com:8080/BusComeServer/pages/heb/HebAction.do?action=realtime&bus_name=" + this.f4117_线路名) + "&bus_direction=") + 方向);
        } else if (项目索引 == 1) {
            C0898_读写设置类.m6935_通过SP保存设置("小年", StringVariant.getStringVariant("2"));
            int integer = IntegerVariant.getIntegerVariant(
            		this.f4113.m5456()).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
            for (int 计数 = 0; 计数 <= integer; 计数++) {
                ((C0723) this.f4114_站点名集合.m5455(计数).getObject()).mo802();
                ((C0739) this.f4113.m5455(计数).getObject()).mo802();
            }
            this.f40771.mo928(0);
            this.f40793.mo928(0);
            if (C0898_读写设置类.m6937_通过SP读取设置("正反").getString().equals("正")) {
                C0898_读写设置类.m6935_通过SP保存设置("线路", StringVariant.getStringVariant("f" + this.f4117_线路名));
                C0898_读写设置类.m6935_通过SP保存设置("正反", StringVariant.getStringVariant("反"));
                C0898_读写设置类.m6935_通过SP保存设置("方向", StringVariant.getStringVariant("fan"));
            } else {
            	//从第二个位置截到最后
                this.f4117_线路名 = C0890_文本操作.m6814_截取子串(
                		this.f4117_线路名, 1, C0890_文本操作.m6817_获取字符串长度(this.f4117_线路名));
                C0898_读写设置类.m6935_通过SP保存设置("线路", StringVariant.getStringVariant(this.f4117_线路名));
                C0898_读写设置类.m6935_通过SP保存设置("正反", StringVariant.getStringVariant("正"));
                C0898_读写设置类.m6935_通过SP保存设置("方向", StringVariant.getStringVariant("zheng"));
            }
            if (C0880_应用操作类.m6712("过渡窗口") == null) {
                C0880_应用操作类.m6692("过渡窗口", new C06532());
            }
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("过渡窗口"));
        } else if (项目索引 == 2) {
            if (IntegerVariant.getIntegerVariant(this.f4075).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
                C0880_应用操作类.m6694("提醒开");
                this.f41192.mo776(true);
                this.f408310.mo776(true);
                this.f408512.mo776(true);
                this.f408613.mo776(true);
                this.f40658.mo776(true);
                this.f4075 = IntegerVariant.getIntegerVariant(this.f4075).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
            } else if (IntegerVariant.getIntegerVariant(this.f4075).cmp(ByteVariant.getByteVariant((byte) 1)) == 0) {
                C0880_应用操作类.m6694("提醒关");
                C0850.m6641();
                this.f4075 = 0;
                this.f40793.mo924(false);
                this.f41192.mo776(false);
                this.f408310.mo776(false);
                this.f408512.mo776(false);
                this.f408613.mo776(false);
                this.f40658.mo776(false);
            }
        } else if (项目索引 == 3) {
            if (C0897_网络操作.m6920_取网络状态()) {
                C0897_网络操作.m6927_打开指定网址(((this.wl + "/web/city/") + this.zz_城市) + "/wrong.html");
            }
        } else if (项目索引 == 4) {
            m52404_详情页底部收藏按钮();
        }
    }

    /* renamed from: 时钟3$周期事件 */
    public void m52463$() {
        try {
            m5230();
            C0880_应用操作类.m6694(this.f41006.mo894());
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 到站提示 */
    public void m5230() {
        try {
            if (this.f41006.mo894().equals(this.f41192.mo886())) {
                C0850.m6647(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz_城市) + "/TS.MP3");
                this.f40793.mo924(false);
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 标签12$被单击 */
    public void m524912$() {
        try {
            this.f41192.mo776(false);
            this.f408310.mo776(false);
            this.f408512.mo776(false);
            this.f408613.mo776(false);
            this.f40793.mo928(8000);
            this.f40658.mo776(false);
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 标签13$被单击 */
    public void m525013$() {
        this.f41192.mo776(false);
        this.f408310.mo776(false);
        this.f408512.mo776(false);
        this.f408613.mo776(false);
        this.f40658.mo776(false);
    }

    /* renamed from: 处理4 */
    public void m52404_详情页底部收藏按钮() {
        String v = bi_常量类.f6358b;
        String 线路1 = bi_常量类.f6358b;
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f4117_线路名, "101", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0880_应用操作类.m6694("此条路线不能收藏");
        } else if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f4117_线路名, "16", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0880_应用操作类.m6694("此条路线不能收藏");
        } else if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f4117_线路名, "19", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0880_应用操作类.m6694("此条路线不能收藏");
        } else if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f4117_线路名, "202", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0880_应用操作类.m6694("此条路线不能收藏");
        } else if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f4117_线路名, "lin1", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0880_应用操作类.m6694("此条路线不能收藏");
        } else {
            C0880_应用操作类.m6694("路线收藏成功");
            v = C0889_文件操作.m6802(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz_城市) + "/SC.txt", "UTF-8");
            线路1 = C0890_文本操作.m6819(this.f4117_线路名, "f", bi_常量类.f6358b);
            C0889_文件操作.m6781_写出文本文件(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz_城市) + "/SC.txt", ((C0890_文本操作.m6819(v, ("y" + 线路1) + "z", bi_常量类.f6358b) + "y") + 线路1) + "z", "UTF-8");
        }
    }

    /* renamed from: 图片框10$被单击 */
    public void m523710$() {
        if (this.f408714.mo777()) {
            this.f408714.mo776(false);
            this.f408815.mo776(false);
            this.f408714.mo895(bi_常量类.f6358b);
            this.f408815.mo895(bi_常量类.f6358b);
            return;
        }
        this.f408714.mo776(true);
        this.f408815.mo776(true);
    }

    /* renamed from: 图片框17$被单击 */
    public void m523817$() {
        String p = bi_常量类.f6358b;
        if (this.f41104.mo777()) {
            this.f41104.mo776(false);
            this.f41104.mo774(false);
        } else {
            this.f41104.mo776(true);
            this.f41104.mo774(true);
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(C0897_网络操作.m6922(((((this.wl + "/web/city/") + this.zz_城市) + "/time/") + this.f4117_线路名) + ".html", "UTF-8", 2000), "参考", 1)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f41104.mo976(((((this.wl + "/web/city/") + this.zz_城市) + "/time/") + this.f4117_线路名) + ".html");
        } else {
            C0880_应用操作类.m6694("网络不稳定");
        }
    }

    /* renamed from: 时钟2$周期事件 */
    public void m52452$() {
        this.f409017.mo776(true);
        this.f41115.mo776(false);
        this.f408411.mo776(false);
        if (!C0889_文件操作.m6797(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt")) {
            C0889_文件操作.m6783(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt");
        }
        int i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
        if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 20)) < 0) {
            this.f40782.mo928(0);
        }
        i = IntegerVariant.getIntegerVariant(i).sub(ByteVariant.getByteVariant((byte) 20)).getInteger();
        this.f409017.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) i), ".0", bi_常量类.f6358b));
        C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) i), "yangbosen123"), "UTF-8");
    }

    /* renamed from: 标签18$被单击 */
    public void m525118$() {
        if (this.f409118.mo894().equals("点击文字开始申请冠名")) {
            C0898_读写设置类.m6935_通过SP保存设置("冠名", StringVariant.getStringVariant(C0108a.f262e));
            if (C0880_应用操作类.m6712("窗口8") == null) {
                C0880_应用操作类.m6692("窗口8", new C06598());
            }
            m5242();
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口8"));
            return;
        }
        C0897_网络操作.m6927_打开指定网址(this.b18);
    }

    /* renamed from: 标签19$被单击 */
    public void m525219$() {
        if (this.f409219.mo894().equals("点击文字开始申请冠名")) {
            C0898_读写设置类.m6935_通过SP保存设置("冠名", StringVariant.getStringVariant(C0108a.f262e));
            if (C0880_应用操作类.m6712("窗口8") == null) {
                C0880_应用操作类.m6692("窗口8", new C06598());
            }
            m5242();
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口8"));
            return;
        }
        C0897_网络操作.m6927_打开指定网址(this.b19);
    }

    /* renamed from: 标签20$被单击 */
    public void m525320$() {
        if (this.f409420.mo894().equals("点击文字开始申请冠名")) {
            C0898_读写设置类.m6935_通过SP保存设置("冠名", StringVariant.getStringVariant(C0108a.f262e));
            if (C0880_应用操作类.m6712("窗口8") == null) {
                C0880_应用操作类.m6692("窗口8", new C06598());
            }
            m5242();
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口8"));
            return;
        }
        C0897_网络操作.m6927_打开指定网址(this.b20);
    }

    /* renamed from: 标签21$被单击 */
    public void m525421$() {
        if (this.f409521.mo894().equals("点击文字开始申请冠名")) {
            C0898_读写设置类.m6935_通过SP保存设置("冠名", StringVariant.getStringVariant(C0108a.f262e));
            if (C0880_应用操作类.m6712("窗口8") == null) {
                C0880_应用操作类.m6692("窗口8", new C06598());
            }
            m5242();
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口8"));
            return;
        }
        C0897_网络操作.m6927_打开指定网址(this.b21);
    }

    /* renamed from: 标签22$被单击 */
    public void m525522$() {
        if (this.f409622.mo894().equals("点击文字开始申请冠名")) {
            C0898_读写设置类.m6935_通过SP保存设置("冠名", StringVariant.getStringVariant(C0108a.f262e));
            if (C0880_应用操作类.m6712("窗口8") == null) {
                C0880_应用操作类.m6692("窗口8", new C06598());
            }
            m5242();
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口8"));
            return;
        }
        C0897_网络操作.m6927_打开指定网址(this.b22);
    }

    /* renamed from: 时钟4$周期事件 */
    public void m52474$() {
        this.f41028.mo776(true);
        this.f40973.mo776(true);
        this.f40804.mo928(0);
        this.f408714.mo776(false);
        this.f408815.mo776(false);
        C0723 名字 = (C0723) this.f4114_站点名集合.m5455(0).getObject();
        C0739 图标 = (C0739) this.f4113.m5455(0).getObject();
        this.f4073 = 0;
        图标.mo1139("ic_dot_red23.png");
        名字.mo889(Component.f3916);
        图标.mo806((int) (DoubleVariant.getDoubleVariant(((double) C0894.m6882()) / 12.0d).add(IntegerVariant.getIntegerVariant(m5234(6))).getDouble() / 2.0d));
        this.f409118.mo776(false);
        this.f409219.mo776(false);
        this.f409420.mo776(false);
        this.f409521.mo776(false);
        this.f409622.mo776(false);
        this.f40691.mo1169(this.f4068, "GBK");
    }

    /* renamed from: 好的 */
    public void m5242() {
        int integer = IntegerVariant.getIntegerVariant(this.f4113.m5456()).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
        for (int 计数 = 0; 计数 <= integer; 计数++) {
            ((C0723) this.f4114_站点名集合.m5455(计数).getObject()).mo802();
            ((C0739) this.f4113.m5455(计数).getObject()).mo802();
        }
        this.f40771.mo928(0);
        this.f40793.mo928(0);
        this.f41242.mo815();
        this.f41082.mo776(false);
        this.f41082.mo774(false);
        this.f40782.mo928(0);
    }
}
