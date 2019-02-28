package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0881;
import com.e4a.runtime.C0888;
import com.e4a.runtime.C0889_文件操作;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0891;
import com.e4a.runtime.C0893;
import com.e4a.runtime.C0894;
import com.e4a.runtime.C0895;
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
import com.e4a.runtime.components.impl.android.n2.C0717;
import com.e4a.runtime.components.impl.android.n2.C0722Impl;
import com.e4a.runtime.components.impl.android.n3.C0723;
import com.e4a.runtime.components.impl.android.n3.C0725Impl;
import com.e4a.runtime.components.impl.android.n36.C0733;
import com.e4a.runtime.components.impl.android.n36.C0735Impl;
import com.e4a.runtime.components.impl.android.n4.C0739;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.components.impl.android.n46.C0753GIF;
import com.e4a.runtime.components.impl.android.n46.C0754GIFImpl;
import com.e4a.runtime.components.impl.android.p018ok.C0794ok;
import com.e4a.runtime.components.impl.android.p018ok.C0796okImpl;
import com.e4a.runtime.components.impl.android.p020.C0813;
import com.e4a.runtime.components.impl.android.p020.C0817Impl;
import com.e4a.runtime.errors.RuntimeError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.helpers.ConvHelpers;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.parameters.IntegerReferenceParameter;
import com.e4a.runtime.variants.ArrayVariant;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.LongVariant;
import com.e4a.runtime.variants.ShortVariant;
import com.e4a.runtime.variants.StringVariant;
import com.tencent.smtt.sdk.WebView;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口13.code */
/* renamed from: com.chedaole.窗口13 */
public class C065013 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口13 */
    public static C0644 f396813;
    @SimpleDataElement
    /* renamed from: GIF图片框1 */
    public C0753GIF f3969GIF1;
    @SimpleDataElement
    /* renamed from: a */
    public long f3970a;
    @SimpleDataElement
    public String a1 = bi_常量类.f6358b;
    @SimpleDataElement
    public String ab = bi_常量类.f6358b;
    @SimpleDataElement
    public String abc = bi_常量类.f6358b;
    @SimpleDataElement
    public String bb = bi_常量类.f6358b;
    @SimpleDataElement
    public int ci;
    @SimpleDataElement
    /* renamed from: d */
    public String f3971d = bi_常量类.f6358b;
    @SimpleDataElement
    public String dd = bi_常量类.f6358b;
    @SimpleDataElement
    public String dian = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: f */
    public String[] f3972f;
    @SimpleDataElement
    public String fd = bi_常量类.f6358b;
    @SimpleDataElement
    public String ff = bi_常量类.f6358b;
    @SimpleDataElement
    public String[] fff;
    @SimpleDataElement
    public String gg = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: h */
    public int f3973h;
    @SimpleDataElement
    public String id = bi_常量类.f6358b;
    @SimpleDataElement
    public String id1 = bi_常量类.f6358b;
    @SimpleDataElement
    public String ids = bi_常量类.f6358b;
    @SimpleDataElement
    public String jjj = bi_常量类.f6358b;
    @SimpleDataElement
    public String kk = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: ok微信支付1 */
    public C0794ok f3974ok1;
    @SimpleDataElement
    /* renamed from: p */
    public String f3975p = bi_常量类.f6358b;
    @SimpleDataElement
    public String pp = bi_常量类.f6358b;
    @SimpleDataElement
    public String ppp = bi_常量类.f6358b;
    @SimpleDataElement
    public String title = bi_常量类.f6358b;
    @SimpleDataElement
    public String vc = bi_常量类.f6358b;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b;
    @SimpleDataElement
    public String[] yyy;
    @SimpleDataElement
    public String[] zzz;
    @SimpleDataElement
    /* renamed from: 下载器1 */
    public C0733 f39761;
    @SimpleDataElement
    /* renamed from: 价格 */
    public String f3977 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 价格1 */
    public String f39781 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 价格2 */
    public String f39792 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 元 */
    public String f3980 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 分 */
    public String f3981 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 分类 */
    public String f3982 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 列表框1 */
    public C0714 f39831;
    @SimpleDataElement
    /* renamed from: 县 */
    public String f3984 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 启动时间 */
    public long f3985;
    @SimpleDataElement
    /* renamed from: 图片1 */
    public String f39861 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f39871;
    @SimpleDataElement
    /* renamed from: 图片框4 */
    public C0739 f39884;
    @SimpleDataElement
    /* renamed from: 图片框5 */
    public C0739 f39895;
    @SimpleDataElement
    /* renamed from: 图片框7 */
    public C0739 f39907;
    @SimpleDataElement
    /* renamed from: 图片框8 */
    public C0739 f39918;
    @SimpleDataElement
    /* renamed from: 备注 */
    public String f3992 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 大框 */
    public String[] f3993;
    @SimpleDataElement
    /* renamed from: 市 */
    public String f3994 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 总 */
    public String f3995 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 支付宝1 */
    public C0813 f39961;
    @SimpleDataElement
    /* renamed from: 收货人 */
    public String f3997 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 收货地址 */
    public String f3998 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 数 */
    public String f3999 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 时钟1 */
    public C0696 f40001;
    @SimpleDataElement
    /* renamed from: 时钟10 */
    public C0696 f400110;
    @SimpleDataElement
    /* renamed from: 时钟11 */
    public C0696 f400211;
    @SimpleDataElement
    /* renamed from: 时钟2 */
    public C0696 f40032;
    @SimpleDataElement
    /* renamed from: 时钟3 */
    public C0696 f40043;
    @SimpleDataElement
    /* renamed from: 时钟4 */
    public C0696 f40054;
    @SimpleDataElement
    /* renamed from: 时钟5 */
    public C0696 f40065;
    @SimpleDataElement
    /* renamed from: 时钟6 */
    public C0696 f40076;
    @SimpleDataElement
    /* renamed from: 时钟7 */
    public C0696 f40087;
    @SimpleDataElement
    /* renamed from: 时钟8 */
    public C0696 f40098;
    @SimpleDataElement
    /* renamed from: 时钟9 */
    public C0696 f40109;
    @SimpleDataElement
    /* renamed from: 月销1 */
    public String f40111 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 月销2 */
    public String f40122 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 月销3 */
    public String f40133 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 标签1 */
    public C0723 f40141;
    @SimpleDataElement
    /* renamed from: 标签13 */
    public C0723 f401513;
    @SimpleDataElement
    /* renamed from: 标签14 */
    public C0723 f401614;
    @SimpleDataElement
    /* renamed from: 标签17 */
    public C0723 f401717;
    @SimpleDataElement
    /* renamed from: 标签18 */
    public C0723 f401818;
    @SimpleDataElement
    /* renamed from: 标签2 */
    public C0723 f40192;
    @SimpleDataElement
    /* renamed from: 标签3 */
    public C0723 f40203;
    @SimpleDataElement
    /* renamed from: 标题 */
    public String f4021 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 标题1 */
    public String f40221 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 次 */
    public int f4023;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f40241;
    @SimpleDataElement
    /* renamed from: 浏览框2 */
    public C0698 f40252;
    @SimpleDataElement
    /* renamed from: 电话号 */
    public String f4026 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 省 */
    public String f4027 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 编辑框1 */
    public C0717 f40281;
    @SimpleDataElement
    /* renamed from: 编辑框2 */
    public C0717 f40292;
    @SimpleDataElement
    /* renamed from: 编辑框3 */
    public C0717 f40303;
    @SimpleDataElement
    /* renamed from: 详细 */
    public String f4031 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 页 */
    public int f4032;

    public C065013() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f396813 = this;
        f396813.mo840(bi_常量类.f6358b);
        f396813.mo797(-1);
        f396813.m5096(IntegerVariant.getIntegerVariant(4));
        f396813.mo838(1);
        f396813.mo826(false);
        C0725Impl c0725Impl = new C0725Impl(f396813);
        Objects.initializeProperties(c0725Impl);
        this.f40203 = c0725Impl;
        this.f40203.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40203.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.871d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40203.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40203.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.134d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40203.mo895("开始支付");
        this.f40203.mo797(-578037);
        this.f40203.mo889(-1);
        this.f40203.mo896(false);
        this.f40203.mo892(false);
        this.f40203.mo891(7);
        this.f40203.mo1049(15.0f);
        this.f40203.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40203.mo776(true);
        C0742Impl c0742Impl = new C0742Impl(f396813);
        Objects.initializeProperties(c0742Impl);
        this.f39907 = c0742Impl;
        this.f39907.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39907.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.008d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39907.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39907.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.093d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39907.mo797(-16742145);
        this.f39907.mo1143(1);
        this.f39907.mo1139("search.png");
        this.f39907.mo776(true);
        C0796okImpl c0796okImpl = new C0796okImpl(f396813);
        Objects.initializeProperties(c0796okImpl);
        this.f3974ok1 = c0796okImpl;
        C0735Impl c0735Impl = new C0735Impl(f396813);
        Objects.initializeProperties(c0735Impl);
        this.f39761 = c0735Impl;
        C0697Impl c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40001 = c0697Impl;
        this.f40001.mo928(0);
        C0722Impl c0722Impl = new C0722Impl(f396813);
        Objects.initializeProperties(c0722Impl);
        this.f40281 = c0722Impl;
        this.f40281.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.2d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40281.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.341d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40281.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.133d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40281.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40281.mo887(bi_常量类.f6358b);
        this.f40281.mo889(-16777216);
        this.f40281.mo896(false);
        this.f40281.mo892(false);
        this.f40281.mo1020(9.0f);
        this.f40281.mo774(true);
        this.f40281.mo1041(1);
        this.f40281.mo891(3);
        this.f40281.mo772(true);
        this.f40281.mo1035(bi_常量类.f6358b);
        this.f40281.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40281.mo776(false);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40032 = c0697Impl;
        this.f40032.mo928(0);
        c0722Impl = new C0722Impl(f396813);
        Objects.initializeProperties(c0722Impl);
        this.f40292 = c0722Impl;
        this.f40292.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40292.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.422d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40292.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.5d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40292.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40292.mo887(bi_常量类.f6358b);
        this.f40292.mo889(-16777216);
        this.f40292.mo896(false);
        this.f40292.mo892(false);
        this.f40292.mo1020(9.0f);
        this.f40292.mo774(true);
        this.f40292.mo1041(1);
        this.f40292.mo891(3);
        this.f40292.mo772(true);
        this.f40292.mo1035(bi_常量类.f6358b);
        this.f40292.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40292.mo776(false);
        C0713Impl c0713Impl = new C0713Impl(f396813);
        Objects.initializeProperties(c0713Impl);
        this.f40241 = c0713Impl;
        this.f40241.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40241.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.094d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40241.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40241.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.898d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40241.mo776(true);
        c0722Impl = new C0722Impl(f396813);
        Objects.initializeProperties(c0722Impl);
        this.f40303 = c0722Impl;
        this.f40303.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.177d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40303.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40303.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.567d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40303.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40303.mo887(bi_常量类.f6358b);
        this.f40303.mo889(-16777216);
        this.f40303.mo896(false);
        this.f40303.mo892(false);
        this.f40303.mo1020(11.0f);
        this.f40303.mo774(true);
        this.f40303.mo1041(1);
        this.f40303.mo891(5);
        this.f40303.mo772(true);
        this.f40303.mo1023("输入搜索的宝贝商品");
        this.f40303.mo1035(bi_常量类.f6358b);
        this.f40303.mo899(250);
        this.f40303.mo776(true);
        c0742Impl = new C0742Impl(f396813);
        Objects.initializeProperties(c0742Impl);
        this.f39884 = c0742Impl;
        this.f39884.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.85d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39884.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39884.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.117d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39884.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39884.mo797(0);
        this.f39884.mo1143(1);
        this.f39884.mo776(true);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40043 = c0697Impl;
        this.f40043.mo928(0);
        c0725Impl = new C0725Impl(f396813);
        Objects.initializeProperties(c0725Impl);
        this.f401513 = c0725Impl;
        this.f401513.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.821d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f401513.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.921d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f401513.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.167d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f401513.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f401513.mo895("下一页");
        this.f401513.mo797(-1052689);
        this.f401513.mo889(-16777216);
        this.f401513.mo896(false);
        this.f401513.mo892(false);
        this.f401513.mo891(7);
        this.f401513.mo1049(9.0f);
        this.f401513.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f401513.mo776(false);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40054 = c0697Impl;
        this.f40054.mo928(0);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40065 = c0697Impl;
        this.f40065.mo928(0);
        c0725Impl = new C0725Impl(f396813);
        Objects.initializeProperties(c0725Impl);
        this.f401614 = c0725Impl;
        this.f401614.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f401614.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.009d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f401614.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.133d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f401614.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f401614.mo895(bi_常量类.f6358b);
        this.f401614.mo797(0);
        this.f401614.mo889(-16777216);
        this.f401614.mo896(false);
        this.f401614.mo892(false);
        this.f401614.mo891(4);
        this.f401614.mo1049(9.0f);
        this.f401614.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f401614.mo776(true);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40076 = c0697Impl;
        this.f40076.mo928(0);
        c0713Impl = new C0713Impl(f396813);
        Objects.initializeProperties(c0713Impl);
        this.f40252 = c0713Impl;
        this.f40252.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.467d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40252.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40252.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.067d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40252.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40252.mo776(false);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40087 = c0697Impl;
        this.f40087.mo928(0);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40098 = c0697Impl;
        this.f40098.mo928(0);
        c0725Impl = new C0725Impl(f396813);
        Objects.initializeProperties(c0725Impl);
        this.f401717 = c0725Impl;
        this.f401717.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.267d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f401717.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.341d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f401717.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.55d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f401717.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.206d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f401717.mo895(bi_常量类.f6358b);
        this.f401717.mo797(0);
        this.f401717.mo889(-16742145);
        this.f401717.mo896(false);
        this.f401717.mo892(false);
        this.f401717.mo891(7);
        this.f401717.mo1049(30.0f);
        this.f401717.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f401717.mo776(true);
        C0716Impl c0716Impl = new C0716Impl(f396813);
        Objects.initializeProperties(c0716Impl);
        this.f39831 = c0716Impl;
        this.f39831.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39831.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.094d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39831.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39831.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.403d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39831.mo797(-1);
        this.f39831.mo991(11.0f);
        this.f39831.mo993(-8355712);
        this.f39831.mo1004(bi_常量类.f6358b);
        this.f39831.mo776(true);
        c0725Impl = new C0725Impl(f396813);
        Objects.initializeProperties(c0725Impl);
        this.f401818 = c0725Impl;
        this.f401818.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.798d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f401818.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.444d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f401818.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.2d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f401818.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f401818.mo895("清空历史关闭");
        this.f401818.mo797(0);
        this.f401818.mo889(-16777216);
        this.f401818.mo896(false);
        this.f401818.mo892(false);
        this.f401818.mo891(7);
        this.f401818.mo1049(9.0f);
        this.f401818.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f401818.mo776(true);
        c0725Impl = new C0725Impl(f396813);
        Objects.initializeProperties(c0725Impl);
        this.f40141 = c0725Impl;
        this.f40141.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40141.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.877d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40141.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40141.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.124d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40141.mo895("低奖金商品分类");
        this.f40141.mo797(-8355712);
        this.f40141.mo889(-16777216);
        this.f40141.mo896(false);
        this.f40141.mo892(false);
        this.f40141.mo891(7);
        this.f40141.mo1049(12.0f);
        this.f40141.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40141.mo776(true);
        C0754GIFImpl c0754GIFImpl = new C0754GIFImpl(f396813);
        Objects.initializeProperties(c0754GIFImpl);
        this.f3969GIF1 = c0754GIFImpl;
        this.f3969GIF1.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.21d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f3969GIF1.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.125d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f3969GIF1.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.567d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f3969GIF1.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.268d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f3969GIF1.mo797(-16742145);
        this.f3969GIF1.mo1177("jiazai.gif");
        this.f3969GIF1.mo776(true);
        c0725Impl = new C0725Impl(f396813);
        Objects.initializeProperties(c0725Impl);
        this.f40192 = c0725Impl;
        this.f40192.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.013d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40192.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.921d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40192.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.167d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f40192.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f40192.mo895("后退");
        this.f40192.mo797(-1315861);
        this.f40192.mo889(-16777216);
        this.f40192.mo896(false);
        this.f40192.mo892(false);
        this.f40192.mo891(7);
        this.f40192.mo1049(9.0f);
        this.f40192.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f40192.mo776(true);
        C0817Impl c0817Impl = new C0817Impl(f396813);
        Objects.initializeProperties(c0817Impl);
        this.f39961 = c0817Impl;
        c0742Impl = new C0742Impl(f396813);
        Objects.initializeProperties(c0742Impl);
        this.f39895 = c0742Impl;
        this.f39895.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.058d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39895.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.895d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39895.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.433d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39895.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39895.mo797(0);
        this.f39895.mo1143(1);
        this.f39895.mo1139("wei.png");
        this.f39895.mo776(true);
        c0742Impl = new C0742Impl(f396813);
        Objects.initializeProperties(c0742Impl);
        this.f39918 = c0742Impl;
        this.f39918.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.529d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39918.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.897d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39918.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.4d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39918.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.072d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39918.mo797(0);
        this.f39918.mo1143(1);
        this.f39918.mo1139("zhi.png");
        this.f39918.mo776(true);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f40109 = c0697Impl;
        this.f40109.mo928(0);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f400110 = c0697Impl;
        this.f400110.mo928(0);
        c0742Impl = new C0742Impl(f396813);
        Objects.initializeProperties(c0742Impl);
        this.f39871 = c0742Impl;
        this.f39871.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.75d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39871.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39871.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.067d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f39871.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f39871.mo797(0);
        this.f39871.mo1143(1);
        this.f39871.mo1139("qux.png");
        this.f39871.mo776(true);
        c0697Impl = new C0697Impl(f396813);
        Objects.initializeProperties(c0697Impl);
        this.f400211 = c0697Impl;
        this.f400211.mo928(0);
        EventDispatcher.registerEvent(this, "支付宝1", "支付完毕");
        EventDispatcher.registerEvent(this, "标签18", "被单击");
        EventDispatcher.registerEvent(this, "图片框4", "被单击");
        EventDispatcher.registerEvent(this, "下载器1", "下载完毕");
        EventDispatcher.registerEvent(this, "下载器1", "进度改变");
        EventDispatcher.registerEvent(this, "时钟7", "周期事件");
        EventDispatcher.registerEvent(this, "ok微信支付1", "支付成功");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "列表框1", "表项被单击");
        EventDispatcher.registerEvent(this, "标签13", "被单击");
        EventDispatcher.registerEvent(this, "时钟5", "周期事件");
        EventDispatcher.registerEvent(this, "ok微信支付1", "生成预支付订单号完毕");
        EventDispatcher.registerEvent(this, "时钟3", "周期事件");
        EventDispatcher.registerEvent(this, "时钟8", "周期事件");
        EventDispatcher.registerEvent(this, "图片框5", "被单击");
        EventDispatcher.registerEvent(this, "窗口13", "按下某键");
        EventDispatcher.registerEvent(this, "浏览框2", "接口事件");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        EventDispatcher.registerEvent(this, "编辑框3", "被单击");
        EventDispatcher.registerEvent(this, "时钟4", "周期事件");
        EventDispatcher.registerEvent(this, "编辑框3", "内容被改变");
        EventDispatcher.registerEvent(this, "窗口13", "创建完毕");
        EventDispatcher.registerEvent(this, "标签14", "被单击");
        EventDispatcher.registerEvent(this, "时钟1", "周期事件");
        EventDispatcher.registerEvent(this, "时钟6", "周期事件");
        EventDispatcher.registerEvent(this, "标签2", "被单击");
        EventDispatcher.registerEvent(this, "时钟2", "周期事件");
        EventDispatcher.registerEvent(this, "时钟9", "周期事件");
        EventDispatcher.registerEvent(this, "时钟10", "周期事件");
        EventDispatcher.registerEvent(this, "时钟11", "周期事件");
        EventDispatcher.registerEvent(this, "图片框8", "被单击");
        EventDispatcher.registerEvent(this, "浏览框1", "即将跳转");
        f396813.mo765();
        this.f40203.mo765();
        this.f39907.mo765();
        this.f3974ok1.mo765();
        this.f39761.mo765();
        this.f40001.mo765();
        this.f40281.mo765();
        this.f40032.mo765();
        this.f40292.mo765();
        this.f40241.mo765();
        this.f40303.mo765();
        this.f39884.mo765();
        this.f40043.mo765();
        this.f401513.mo765();
        this.f40054.mo765();
        this.f40065.mo765();
        this.f401614.mo765();
        this.f40076.mo765();
        this.f40252.mo765();
        this.f40087.mo765();
        this.f40098.mo765();
        this.f401717.mo765();
        this.f39831.mo765();
        this.f401818.mo765();
        this.f40141.mo765();
        this.f3969GIF1.mo765();
        this.f40192.mo765();
        this.f39961.mo765();
        this.f39895.mo765();
        this.f39918.mo765();
        this.f40109.mo765();
        this.f400110.mo765();
        this.f39871.mo765();
        this.f400211.mo765();
    }

    /* renamed from: 窗口13$创建完毕 */
    public void m521813$() {
        this.f40001.mo928(2000);
        this.f39831.mo776(false);
        this.f39831.mo774(false);
        this.f401818.mo776(false);
        this.f401818.mo774(false);
        this.f39831.mo1001(7);
        this.f3969GIF1.mo776(false);
        this.f3969GIF1.mo774(false);
        this.wl = "http://gongjiaomishu.com";
        this.f4032 = 1;
        this.f40303.mo1027();
        this.f401717.mo774(false);
        this.f401717.mo776(false);
        this.f401513.mo776(false);
        this.f401513.mo774(false);
        this.f40192.mo776(false);
        this.f40192.mo774(false);
        this.f40203.mo776(false);
        this.f40203.mo774(false);
        this.f39895.mo776(false);
        this.f39895.mo774(false);
        this.f39918.mo776(false);
        this.f39918.mo774(false);
        this.f40241.mo774(true);
        this.f40241.mo776(true);
        this.f3970a = 1;
        this.ff = C0897_网络操作.m6922(this.wl + "/gongjiaoa1.txt", "utf-8", 5000);
        this.f39961.mo1456("2088221514735277", "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAMQ2bmQ4OR3d/MNagvMWgWtJzYnWRBqO2vevhbOITLJhWwbbhpEMqyUXZXm11U3uBP7XtYYJ631ksqm9kiXQuCxzf0byBFt6D6BbpQb+aaf14Wy9oWo0RJIp8IDIgFWJOaF8TQVwdW6sqNbfKLdTp31PgR9fiem3ZUfCu0AIkjzdAgMBAAECgYBOQ5vi095MgIha79Z92gNDZUvb6CCAK21CELwW8Y4ONPEXGidh4hi+EcgDNTlg/Uj20dnxHjHVcX4mYJxUAx4Cwiojxwv6jA8AV/mQMGqocL8B1oizbkkuDWths5TVDnEeQJBfnKEDJJ7TkiXzzUXhcXZnZ76kv3JFK64ahNvvbQJBAOcSGyDmzNAG2+vV/51NpLzJTlEFmhA+3fRNKoKaBoDjs6Q0439KyC84utH2f1kFBkxx3IEAzZPBVkJRwTaZRqcCQQDZYZYoX7aZkRemA52p4g8KDcgN2IpB9qOQtYgDJR/26YDjynPSWgCAYEq8ON5e1xXwnu0tvcMmIK5e6s0CHFTbAj8BziJoH2V6OpN9RC67C+A9mVUDTQfnGJajUfcDDjD+0MiWf9NHK05lEAxll4dnKqLh9gHDAD6a6OfDnN/ljU0CQEFWNX25FvcdRxBc8dyH16Fb9w9CUHv3F7588X6QgAUEtfrBdQJ6jsAHMS9VoHC9ERkbi4o+CRPCquZYiHnj7hUCQQCB4rBnWhuXY4gjpgh9BW0COpN/rzaXm2Mq1RMJiAqEuQUNDo6KO7a/JSpOwr11LmsnxQEeXj9euBap2au9HfZd", "alifangxiang2015@126.com", "http://www.chengshiyouxi.com/zhifubao/myserver.php");
        this.f3974ok1.mo1417("wx3810718aaeeeafcd", "9VPnMa7VjKAtpdGENVL66d5pdbdfy28q", "1387406602");
        this.f40241.mo960JS("hua");
        this.f40252.mo960JS("hua");
        this.f40241.mo976(this.ff);
        this.f40141.mo776(false);
        this.f40141.mo774(false);
    }

    /* renamed from: 支付宝1$支付完毕 */
    public void m51981$(int 支付结果) {
        if (IntegerVariant.getIntegerVariant(支付结果).cmp(ByteVariant.getByteVariant((byte) 1)) == 0) {
            C0880_应用操作类.m6694("付款成功");
            this.f40203.mo776(false);
            this.f40203.mo774(false);
            this.f39895.mo776(false);
            this.f39895.mo774(false);
            this.f39918.mo776(false);
            this.f39918.mo774(false);
            this.f40241.mo774(true);
            this.f40241.mo776(true);
            this.f40241.mo976(((((((((((((((this.wl + "/gongjiaoa/jiaoyi.asp?id=135&ming=") + C0895.m6905URL(this.title, "GBK")) + "name:") + C0895.m6905URL(this.ids, "GBK")) + C0895.m6905URL(this.f3975p, "GBK")) + "&qian=") + C0895.m6905URL(this.f3995, "GBK")) + "&dizhi=") + C0895.m6905URL(this.ppp, "GBK")) + C0895.m6905URL(this.f3992 + this.f3999, "GBK")) + "&tel=") + C0895.m6905URL(this.dian, "GBK")) + C0895.m6905URL(this.pp, "GBK")) + "&ic=") + C0898_读写设置类.m6937_通过SP读取设置("用户").getString());
        }
        if (IntegerVariant.getIntegerVariant(支付结果).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
            C0880_应用操作类.m6694("付款失败");
        }
        if (IntegerVariant.getIntegerVariant(支付结果).cmp(ByteVariant.getByteVariant((byte) 3)) == 0) {
            C0880_应用操作类.m6694("付款处理中");
        }
    }

    /* renamed from: 浏览框1$即将跳转 */
    public void m52151$(String str, IntegerReferenceParameter integerReferenceParameter) {
        int 方式 = integerReferenceParameter.get();
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "login", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f401513.mo776(false);
            this.f401513.mo774(false);
            this.f40192.mo776(false);
            this.f40192.mo774(false);
            this.dd = C0108a.f262e;
        } else {
            this.dd = "0";
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "downloadTaobao", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            C0879.m6668("提示", "奖金模式暂不支持淘宝客户端", "确定");
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "tab=all", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f40141.mo776(true);
            this.f40141.mo774(true);
            this.f40141.mo768();
        } else {
            this.f40141.mo776(false);
            this.f40141.mo774(false);
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "item.taobao.com/item.ht", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f401513.mo776(false);
            this.f401513.mo774(false);
            this.f40192.mo776(false);
            this.f40192.mo774(false);
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "jiaomishu.com", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f401513.mo776(false);
            this.f401513.mo774(false);
            this.f40192.mo776(false);
            this.f40192.mo774(false);
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "order", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0 && IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "buyNow=true", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            if (C0898_读写设置类.m6937_通过SP读取设置("用户").cmp(StringVariant.getStringVariant(bi_常量类.f6358b)) == 0) {
                C0880_应用操作类.m6694("请先登入我的公司");
                this.f40241.mo976(this.wl + "/gongjiaoa/");
            } else {
                this.f40281.mo887(str);
                this.f40203.mo776(true);
                this.f40203.mo774(true);
                this.f40203.mo895("等待加载付款方式");
                this.f40203.mo768();
                this.f40032.mo928(5000);
            }
        }
        integerReferenceParameter.set(方式);
    }

    /* renamed from: 时钟2$周期事件 */
    public void m52022$() {
        this.f40032.mo928(0);
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40281.mo886(), "order", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0 && IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40281.mo886(), "buyNow=true", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f3970a = LongVariant.getLongVariant(this.f3970a).add(ByteVariant.getByteVariant((byte) 1)).getLong();
            this.f40241.mo976("javascript:window.hua.jsAndroid(document.getElementsByTagName('html')[0].innerHTML)");
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40281.mo886(), "login", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f40241.mo774(true);
            this.f40241.mo776(true);
        }
    }

    /* renamed from: g */
    public void m5187g(String str) {
        try {
            int i;
            this.title = bi_常量类.f6358b;
            this.f3975p = bi_常量类.f6358b;
            this.pp = bi_常量类.f6358b;
            this.ppp = bi_常量类.f6358b;
            this.dian = bi_常量类.f6358b;
            this.jjj = str;
            this.f40241.mo776(true);
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/666777.txt", this.jjj, "GBK");
            this.title = m5193(str, (((("div class=" + C0899.m6939(34)) + "title") + C0899.m6939(34)) + " data-reactid=") + C0899.m6939(34), "/div>");
            this.title = m5193(this.title, ">", "<");
            this.f3997 = m5193(str, "收货人", "</div>");
            this.yyy = C0890_文本操作.m6812(this.f3997, ">", "<");
            for (i = 0; i < C0888.m6769(ArrayVariant.getArrayVariant(this.yyy)); i = IntegerVariant.getIntegerVariant(i).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
                this.pp += this.yyy[i];
            }
            this.f3997 = "收货人:" + this.pp;
            this.f3998 = m5193(str, ">收货地址", "</div>");
            this.zzz = C0890_文本操作.m6812(this.f3998, ">", "<");
            for (i = 0; i < C0888.m6769(ArrayVariant.getArrayVariant(this.zzz)); i = IntegerVariant.getIntegerVariant(i).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
                this.ppp += this.zzz[i];
            }
            this.f3998 = "收货地址:" + this.ppp;
            this.f3982 = m5193(str, (((("div class=" + C0899.m6939(34)) + "sku-info") + C0899.m6939(34)) + " data-reactid=") + C0899.m6939(34), "</div>");
            this.ids = this.f40241.mo944();
            this.ids = C0890_文本操作.m68132(this.ids, "itemId=", "&");
            String 源码 = m5193(str, "送至", ">提交订单");
            this.f3980 = m5193(源码, ("1.1.0.0.5.1" + C0899.m6939(34)) + ">", "</span>");
            this.f3981 = m5193(源码, ("1.1.0.0.5.2.1" + C0899.m6939(34)) + ">", "</span>");
            this.f3999 = m5193(源码, ("1.1.0.0.1" + C0899.m6939(34)) + ">", "</span>");
            this.f3995 = Double.toString(C0899.m6943(this.f3980) + (C0899.m6943(this.f3981) * 0.01d));
            this.f40292.mo887((((((((((this.title + "元:") + this.f3980) + "分:") + this.f3981) + "数：") + this.f3999) + "总：") + this.f3995) + this.pp) + this.ppp);
            this.dian = C0890_文本操作.m6815(this.pp, 11);
            this.fff = C0890_文本操作.m6812(this.f3982, ">", "<");
            for (i = 0; i < C0888.m6769(ArrayVariant.getArrayVariant(this.fff)); i = IntegerVariant.getIntegerVariant(i).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
                this.f3975p += this.fff[i];
            }
            this.f40203.mo776(true);
            this.f40203.mo774(true);
            this.f40203.mo895(bi_常量类.f6358b);
            this.f40203.mo797(-1);
            this.f39895.mo776(true);
            this.f39895.mo774(true);
            this.f39895.mo768();
            this.f39918.mo776(true);
            this.f39918.mo774(true);
            this.f39918.mo768();
            if (this.title.equals(bi_常量类.f6358b) || this.f3999.equals(bi_常量类.f6358b)) {
                this.f40203.mo776(false);
                this.f40203.mo774(false);
                this.f40241.mo774(true);
                this.f40241.mo776(true);
                C0880_应用操作类.m6694("请先登录淘宝");
            } else if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6817_获取字符串长度(this.f3975p)).cmp(ShortVariant.getShortVariant((short) 200)) > 0 || IntegerVariant.getIntegerVariant(C0890_文本操作.m6817_获取字符串长度(this.pp)).cmp(ShortVariant.getShortVariant((short) 200)) > 0) {
                this.f40203.mo776(false);
                this.f40203.mo774(false);
                this.f40241.mo774(true);
                this.f40241.mo776(true);
                C0879.m6668("提示", " 请确认您的淘宝后台收货地址是否正确,请进入淘宝后台添加", "确定");
                C0880_应用操作类.m6703();
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m52161$(String 网页信息) {
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "分类开始吧", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f3973h = 6;
            this.f4032 = 1;
            this.f401513.mo895("加载中");
            this.f401513.mo776(true);
            this.f401513.mo774(true);
            this.f401513.mo768();
            this.f40192.mo776(true);
            this.f40192.mo774(true);
            this.f40192.mo768();
            this.f39831.mo776(false);
            this.f39831.mo774(false);
            this.f401818.mo776(false);
            this.f401818.mo774(false);
            if (C0890_文本操作.m6816(m5193(网页信息, "分类结束", "分类开始"), 4).equals("http")) {
                this.f40241.mo976(m5193(网页信息, "分类结束", "分类开始"));
            } else {
                this.f40241.mo976(((("http://pub.alimama.com/promo/search/index.htm?q=" + m5193(网页信息, "分类结束", "分类开始")) + "&startTkRate=10&endTkRate=50&toPage=") + Integer.toString(this.f4032)) + "&perPageSize=40");
                this.f40303.mo887(m5193(网页信息, "分类结束", "分类开始"));
            }
            this.f40241.mo776(false);
            this.f40043.mo928(5000);
            this.f3969GIF1.mo776(true);
            this.f3969GIF1.mo774(true);
        } else if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "进入店铺", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f3993 = C0890_文本操作.m6812(网页信息, "</span><img src=", "点击进入店铺");
            int i = 0;
            while (i < C0888.m6769(ArrayVariant.getArrayVariant(this.f3993))) {
                this.bb = "</span><img src=" + this.f3993[i];
                this.a1 = m5193(this.bb, "</span><img src=", "goldclick=");
                this.a1 += "jiewei";
                this.f39861 = m5193(this.a1, ("data-src=" + C0899.m6939(34)) + "//", C0899.m6939(34));
                this.id1 = m5193(this.a1, "?id=", C0899.m6939(34));
                this.f40221 = m5193(this.a1, "title=" + C0899.m6939(34), "jiewei");
                this.f39781 = m5193(this.bb, "￥</span><span", "/span>");
                this.f39792 = m5193(this.f39781, ">", "<");
                this.f40111 = m5193(this.bb, "月销：</span><span", "span>");
                this.f40122 = m5193(this.f40111, "span p-id", "/");
                this.f40133 = m5193(this.f40122, ">", "<");
                this.id1 = "https://item.taobao.com/item.htm?id=" + this.id1;
                this.abc = C0889_文件操作.m6803_读入资源文件("test.txt", "UTF-8");
                this.vc = m5193(this.abc, "<!--", "-->");
                this.vc = C0890_文本操作.m6819(this.vc, "shoujidizhi", this.id1);
                this.vc = C0890_文本操作.m6819(this.vc, "shoujitupian", this.f39861);
                this.vc = C0890_文本操作.m6819(this.vc, "shoujibiaoti", this.f40221);
                this.vc = C0890_文本操作.m6819(this.vc, "shoujijiage", this.f39792);
                this.vc = C0890_文本操作.m6819(this.vc, "shoujirenshu", this.f40133);
                i = IntegerVariant.getIntegerVariant(i).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
                this.fd = (this.fd + "\n") + this.vc;
            }
            this.kk = C0890_文本操作.m6819(this.abc, "yiqide", this.fd);
            this.kk = C0890_文本操作.m6819(this.kk, "//dn.com", "//img.alicdn.com");
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/vc.html", this.kk, "UTF-8");
            this.fd = bi_常量类.f6358b;
            this.f401513.mo895("下一页");
            this.f40241.mo976("file:///sdcard/tencent/shi/vc.html");
            this.f3969GIF1.mo776(false);
            this.f3969GIF1.mo774(false);
            this.f39831.mo776(false);
            this.f39831.mo774(false);
            this.f401818.mo776(false);
            this.f401818.mo774(false);
            this.f40065.mo928(1000);
        } else if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "收货地址", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0 && IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "收货人", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            m5187g(网页信息);
        } else if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "nimen#", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.gg = m5193(网页信息, "women@@", "nimen##");
            C0898_读写设置类.m6935_通过SP保存设置("用户", StringVariant.getStringVariant(this.gg));
        } else {
            if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "省", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0 && IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "iqkacai", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                this.f3972f = C0890_文本操作.m6806_分割字符串(网页信息, "/");
                this.f4027 = this.f3972f[0];
                this.f3994 = this.f3972f[1];
                this.f3984 = this.f3972f[2];
                this.f4031 = this.f3972f[3];
                this.f4026 = this.f3972f[4];
                this.f3992 = this.f3972f[5];
                this.f4021 = this.f3972f[6];
                this.f3977 = this.f3972f[7];
                this.f3997 = this.f3972f[8];
                this.id = this.f3972f[9];
            }
            if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "省", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) <= 0 || IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "iqkacai", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) <= 0) {
                if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40241.mo944(), "login", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) <= 0 && IntegerVariant.getIntegerVariant(this.f4023).cmp(ByteVariant.getByteVariant((byte) 1)) == 0) {
                    this.f40043.mo928(5000);
                    C0880_应用操作类.m6694("zhan");
                    this.f3969GIF1.mo776(true);
                    this.f3969GIF1.mo774(true);
                    this.f4023 = IntegerVariant.getIntegerVariant(this.f4023).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
                    return;
                }
                if (!this.dd.equals(C0108a.f262e)) {
                    this.f40241.mo976(this.ff);
                }
                this.f40054.mo928(100);
            } else if (this.f4027.equals(bi_常量类.f6358b) || this.f3994.equals(bi_常量类.f6358b) || this.f3984.equals(bi_常量类.f6358b) || this.f4031.equals(bi_常量类.f6358b) || this.f4026.equals(bi_常量类.f6358b) || this.f4021.equals(bi_常量类.f6358b) || this.id.equals(bi_常量类.f6358b) || this.f3977.equals(bi_常量类.f6358b) || this.f3997.equals(bi_常量类.f6358b)) {
                C0880_应用操作类.m6694("此商品填写信息不完整");
            } else {
                this.f3995 = this.f3977;
                this.title = this.f4021;
                this.dian = this.f4026;
                this.ppp = ((this.f4027 + this.f3994) + this.f3984) + this.f4031;
                this.pp = this.f3997 + this.f4026;
                this.f3974ok1.mo1425((int) C0893.m6861(DoubleVariant.getDoubleVariant(C0899.m6943(this.f3977)).mul(ByteVariant.getByteVariant((byte) 100)).getDouble(), 0), "vgongsi", "http://www.chengshiyouxi.com/pay/notify5.php", this.f4026);
            }
        }
    }

    /* renamed from: ok微信支付1$生成预支付订单号完毕 */
    public void m5189ok1$(String 订单号) {
        this.f40252.mo976(((((((((((((((this.wl + "/gongjiaoabei/jiaoyi.asp?id=135&ming=") + C0895.m6905URL(this.title, "GBK")) + "name:") + C0895.m6905URL(this.ids, "GBK")) + C0895.m6905URL(this.f3975p, "GBK")) + "&qian=") + C0895.m6905URL(this.f3995, "GBK")) + "&dizhi=") + C0895.m6905URL(this.ppp, "GBK")) + C0895.m6905URL((this.f3999 + this.f3992) + 订单号, "GBK")) + "&tel=") + C0895.m6905URL(this.dian, "GBK")) + C0895.m6905URL(this.pp, "GBK")) + "&ic=") + C0898_读写设置类.m6937_通过SP读取设置("用户").getString());
        this.f3974ok1.mo1418(订单号);
    }

    /* renamed from: ok微信支付1$支付成功 */
    public void m5188ok1$() {
        this.f40241.mo976(((((((((((((((this.wl + "/gongjiaoa/jiaoyi.asp?id=135&ming=") + C0895.m6905URL(this.title, "GBK")) + "name:") + C0895.m6905URL(this.ids, "GBK")) + C0895.m6905URL(this.f3975p, "GBK")) + "&qian=") + C0895.m6905URL(this.f3995, "GBK")) + "&dizhi=") + C0895.m6905URL(this.ppp, "GBK")) + C0895.m6905URL(this.f3992 + this.f3999, "GBK")) + "&tel=") + C0895.m6905URL(this.dian, "GBK")) + C0895.m6905URL(this.pp, "GBK")) + "&ic=") + C0898_读写设置类.m6937_通过SP读取设置("用户").getString());
        this.f40203.mo776(false);
        this.f40203.mo774(false);
        this.f39895.mo776(false);
        this.f39895.mo774(false);
        this.f39918.mo776(false);
        this.f39918.mo774(false);
        this.f40241.mo774(true);
        this.f40241.mo776(true);
    }

    /* renamed from: 窗口13$按下某键 */
    public void m521913$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        try {
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                if (LongVariant.getLongVariant(C0891.m6826() - this.f3985).cmp(ShortVariant.getShortVariant((short) 1000)) > 0) {
                    this.f39895.mo776(false);
                    this.f39895.mo774(false);
                    this.f39918.mo776(false);
                    this.f39918.mo774(false);
                    this.f40203.mo776(false);
                    this.f40203.mo774(false);
                    if (this.f40241.mo946().equals("商品详情") || this.f40241.mo946().equals("确认订单") || IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40241.mo946(), "天猫T", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                        this.f40241.mo952();
                    } else {
                        this.f40241.mo774(true);
                        C0879.m6671();
                        this.f40241.mo976(this.ff);
                        this.f400211.mo928(1000);
                        this.f401513.mo776(false);
                        this.f401513.mo774(false);
                        this.f40192.mo776(false);
                        this.f40192.mo774(false);
                        this.f39831.mo776(false);
                        this.f39831.mo774(false);
                        this.f401818.mo776(false);
                        this.f401818.mo774(false);
                        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40241.mo944(), "kuaidi100", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                            this.f40241.mo976("http://gongjiaomishu.com/gongjiaoa/logjilu.asp");
                        }
                        if (this.f40241.mo946().equals("商品详情") || this.f40241.mo946().equals("确认订单") || IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40241.mo946(), "天猫T", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                            if (IntegerVariant.getIntegerVariant(this.f4032).cmp(ByteVariant.getByteVariant((byte) 2)) == 0) {
                                this.f40241.mo976("file:///sdcard/tencent/shi/vc.html");
                            } else {
                                this.f40241.mo976("file:///sdcard/tencent/shi/vca.html");
                            }
                            this.f401513.mo776(true);
                            this.f401513.mo774(true);
                            this.f401513.mo768();
                            this.f40192.mo776(true);
                            this.f40192.mo774(true);
                            this.f40192.mo768();
                        } else {
                            this.ff = C0897_网络操作.m6922(this.wl + "/gongjiaoa1.txt", "utf-8", 5000);
                            this.f40241.mo976(this.ff);
                        }
                        this.f40141.mo776(false);
                        this.f40141.mo774(false);
                        this.f40203.mo776(false);
                        this.f40203.mo774(false);
                        this.f3985 = C0891.m6826();
                    }
                } else {
                    C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
                }
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 下载器1$进度改变 */
    public void m51911$(int 任务索引, int 文件总大小, int 已下载大小, int 下载进度) {
        this.f401717.mo1049(50.0f);
        this.f401717.mo774(true);
        this.f401717.mo776(true);
        this.f401717.mo895(Integer.toString(下载进度) + "%");
    }

    /* renamed from: 取中间文本 */
    public String m5193(String 完整内容, String 左边文本, String 右边文本) {
        String 取中间文本 = bi_常量类.f6358b;
        int 左边 = C0890_文本操作.m6821(完整内容, 左边文本, 0) + C0890_文本操作.m6817_获取字符串长度(左边文本);
        if (IntegerVariant.getIntegerVariant(左边).cmp(ByteVariant.getByteVariant((byte) -1)) == 0) {
            return bi_常量类.f6358b;
        }
        int 右边 = C0890_文本操作.m6821(完整内容, 右边文本, 左边);
        if (IntegerVariant.getIntegerVariant(右边).cmp(ByteVariant.getByteVariant((byte) -1)) == 0 || 左边 > 右边) {
            return bi_常量类.f6358b;
        }
        return C0890_文本操作.m6814_截取子串(完整内容, 左边, 右边 - 左边);
    }

    /* renamed from: 更新 */
    public void m5210() {
        String 返回数据 = bi_常量类.f6358b;
        String 版本号 = bi_常量类.f6358b;
        String 下载地址 = bi_常量类.f6358b;
        String 备注 = bi_常量类.f6358b;
        String 结果 = bi_常量类.f6358b;
        String y = bi_常量类.f6358b;
        String 站点升级 = bi_常量类.f6358b;
        String 返据 = bi_常量类.f6358b;
        String 升级内容 = bi_常量类.f6358b;
        String 本机 = bi_常量类.f6358b;
        C0889_文件操作.m6786(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/shi/");
        C0889_文件操作.m6784(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/shi/");
        if (C0897_网络操作.m6920_取网络状态() && C0897_网络操作.m6922(this.wl + "/gongjiaoa/xver.txt", "GBK", 5000).equals(bi_常量类.f6358b)) {
            this.wl = "bei.bussecretary.com";
            this.ff = C0897_网络操作.m6922(this.wl + "/gongjiaoa.txt", "utf-8", 5000);
            this.f40241.mo976(this.ff);
        }
    }

    /* renamed from: 下载器1$下载完毕 */
    public void m51901$(int 任务索引, boolean 下载结果) {
        if (下载结果) {
            this.f401717.mo774(false);
            this.f401717.mo776(false);
            C0880_应用操作类.m6694("文件下载成功，开始更新！");
            C0881.m6735(C0852_存储卡类.m6665_取存储卡路径() + "/vgongshi.apk");
            return;
        }
        C0880_应用操作类.m6694("文件下载失败！");
    }

    /* renamed from: 时钟1$周期事件 */
    public void m51991$() {
        m5210();
        this.f40001.mo928(0);
    }

    /* renamed from: 图片框4$被单击 */
    public void m51954$() {
        this.f40203.mo776(false);
        this.f40203.mo774(false);
        this.f39831.mo776(false);
        this.f39831.mo774(false);
        this.f401818.mo776(false);
        this.f401818.mo774(false);
        this.f39895.mo776(false);
        this.f39895.mo774(false);
        this.f39918.mo776(false);
        this.f39918.mo774(false);
        this.f3973h = 6;
        this.f4032 = 1;
        this.f4023 = 1;
        this.ci = 1;
        this.f401513.mo895("加载中");
        this.f40141.mo776(false);
        this.f40141.mo774(false);
        this.f39831.mo996();
        this.f401513.mo776(true);
        this.f401513.mo774(true);
        this.f401513.mo768();
        this.f40192.mo776(true);
        this.f40192.mo774(true);
        this.f40192.mo768();
        if (!C0889_文件操作.m6798(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/shi/")) {
            C0889_文件操作.m6784(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/shi/");
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6817_获取字符串长度(this.f40303.mo886())).cmp(ByteVariant.getByteVariant((byte) 8)) > 0) {
            this.f40241.mo976("http://pub.alimama.com/promo/search/index.htm?q=" + this.f40303.mo886());
        } else {
            this.f40241.mo976(((("http://pub.alimama.com/promo/search/index.htm?q=" + this.f40303.mo886()) + "&startTkRate=10&endTkRate=50&toPage=") + Integer.toString(this.f4032)) + "&perPageSize=40");
        }
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/lishi.txt", "utf-8"), this.f40303.mo886(), 0)).cmp(ByteVariant.getByteVariant((byte) 0)) <= 0) {
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/lishi.txt", (C0890_文本操作.m6819(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/lishi.txt", "utf-8"), this.f40303.mo886() + "zk", bi_常量类.f6358b) + this.f40303.mo886()) + "zk", "utf-8");
        }
        this.f40241.mo776(false);
        this.f40043.mo928(5000);
        this.f3969GIF1.mo776(true);
        this.f3969GIF1.mo774(true);
        this.f3969GIF1.mo768();
        this.title = bi_常量类.f6358b;
        this.f3975p = bi_常量类.f6358b;
        this.pp = bi_常量类.f6358b;
        this.ppp = bi_常量类.f6358b;
        this.dian = bi_常量类.f6358b;
    }

    /* renamed from: 时钟3$周期事件 */
    public void m52033$() {
        this.f40043.mo928(0);
        this.f40241.mo976("javascript:window.hua.jsAndroid(document.getElementsByTagName('html')[0].innerHTML)");
    }

    /* renamed from: 标签13$被单击 */
    public void m521113$() {
        String fd = bi_常量类.f6358b;
        this.f3973h = 6;
        this.f4032 = IntegerVariant.getIntegerVariant(this.f4032).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
        if (IntegerVariant.getIntegerVariant(this.ci).cmp(ByteVariant.getByteVariant((byte) 1)) > 0) {
            this.f40241.mo939();
            this.ci = IntegerVariant.getIntegerVariant(this.ci).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
            return;
        }
        this.f401513.mo895("加载中");
        this.f40087.mo928(1000);
        if (!C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/vck.html", "UTF-8").equals(bi_常量类.f6358b)) {
            fd = C0899.m6945((double) C0893.m6860(1, 10000));
            C0889_文件操作.m6781_写出文本文件(((C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/vcak") + fd) + ".html", C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/vck.html", "UTF-8"), "UTF-8");
            this.f40241.mo976(("file:///sdcard/tencent/shi/vcak" + fd) + ".html");
        }
    }

    /* renamed from: 时钟4$周期事件 */
    public void m52044$() {
        this.f40054.mo928(0);
        if (this.dd.equals(C0108a.f262e)) {
            this.f40241.mo776(true);
            C0879.m6671();
            return;
        }
        this.f401513.mo776(false);
        this.f401513.mo774(false);
        this.f40192.mo776(false);
        this.f40192.mo774(false);
        this.f401513.mo895("下一页");
        this.f40241.mo976(("https://s.m.taobao.com/h5?q=" + this.f40303.mo886()) + "&search=提交&tab=all");
        this.f40076.mo928(1000);
        C0879.m6671();
        this.f40241.mo776(true);
    }

    /* renamed from: 时钟5$周期事件 */
    public void m52055$() {
        this.f40065.mo928(0);
        this.f40241.mo776(true);
        this.f40087.mo928(1000);
        C0879.m6671();
    }

    /* renamed from: 标签14$被单击 */
    public void m521214$() {
        this.f39895.mo776(false);
        this.f39895.mo774(false);
        this.f39918.mo776(false);
        this.f39918.mo774(false);
        this.f40203.mo776(false);
        this.f40203.mo774(false);
        if (this.f40241.mo946().equals("商品详情") || this.f40241.mo946().equals("确认订单") || IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40241.mo946(), "天猫T", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f40241.mo952();
            return;
        }
        this.f40241.mo774(true);
        C0879.m6671();
        this.f40241.mo976(this.ff);
        this.f400211.mo928(1000);
        this.f401513.mo776(false);
        this.f401513.mo774(false);
        this.f40192.mo776(false);
        this.f40192.mo774(false);
        this.f39831.mo776(false);
        this.f39831.mo774(false);
        this.f401818.mo776(false);
        this.f401818.mo774(false);
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40241.mo944(), "kuaidi100", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f40241.mo976("http://gongjiaomishu.com/gongjiaoa/logjilu.asp");
        }
        if (this.f40241.mo946().equals("商品详情") || this.f40241.mo946().equals("确认订单") || IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40241.mo946(), "天猫T", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            if (IntegerVariant.getIntegerVariant(this.f4032).cmp(ByteVariant.getByteVariant((byte) 2)) == 0) {
                this.f40241.mo976("file:///sdcard/tencent/shi/vc.html");
            } else {
                this.f40241.mo976("file:///sdcard/tencent/shi/vca.html");
            }
            this.f401513.mo776(true);
            this.f401513.mo774(true);
            this.f401513.mo768();
            this.f40192.mo776(true);
            this.f40192.mo774(true);
            this.f40192.mo768();
        } else {
            this.ff = C0897_网络操作.m6922(this.wl + "/gongjiaoa1.txt", "utf-8", 5000);
            this.f40241.mo976(this.ff);
        }
        this.f40141.mo776(false);
        this.f40141.mo774(false);
        this.f40203.mo776(false);
        this.f40203.mo774(false);
    }

    /* renamed from: 时钟6$周期事件 */
    public void m52066$() {
        this.f40076.mo928(0);
        this.f3969GIF1.mo776(false);
        this.f3969GIF1.mo774(false);
    }

    /* renamed from: 时钟7$周期事件 */
    public void m52077$() {
        this.f40087.mo928(0);
        this.f40098.mo928(5000);
        this.f4032 = IntegerVariant.getIntegerVariant(this.f4032).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
        this.f40252.mo976(((("http://pub.alimama.com/promo/search/index.htm?q=" + this.f40303.mo886()) + "&startTkRate=10&endTkRate=50&toPage=") + Integer.toString(this.f4032)) + "&perPageSize=40");
    }

    /* renamed from: 时钟8$周期事件 */
    public void m52088$() {
        this.f40098.mo928(0);
        this.f40252.mo976("javascript:window.hua.jsAndroid(document.getElementsByTagName('html')[0].innerHTML)");
    }

    /* renamed from: 浏览框2$接口事件 */
    public void m52172$(String 网页信息) {
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页信息, "进入店铺", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f3993 = C0890_文本操作.m6812(网页信息, "</span><img src=", "点击进入店铺");
            int i = 0;
            while (i < C0888.m6769(ArrayVariant.getArrayVariant(this.f3993))) {
                this.bb = "</span><img src=" + this.f3993[i];
                this.a1 = m5193(this.bb, "</span><img src=", "goldclick=");
                this.a1 += "jiewei";
                this.f39861 = m5193(this.a1, ("data-src=" + C0899.m6939(34)) + "//", C0899.m6939(34));
                this.id1 = m5193(this.a1, "?id=", C0899.m6939(34));
                this.f40221 = m5193(this.a1, "title=" + C0899.m6939(34), "jiewei");
                this.f39781 = m5193(this.bb, "￥</span><span", "/span>");
                this.f39792 = m5193(this.f39781, ">", "<");
                this.f40111 = m5193(this.bb, "月销：</span><span", "span>");
                this.f40122 = m5193(this.f40111, "span p-id", "/");
                this.f40133 = m5193(this.f40122, ">", "<");
                this.id1 = "https://item.taobao.com/item.htm?id=" + this.id1;
                this.abc = C0889_文件操作.m6803_读入资源文件("test.txt", "UTF-8");
                this.vc = m5193(this.abc, "<!--", "-->");
                this.vc = C0890_文本操作.m6819(this.vc, "shoujidizhi", this.id1);
                this.vc = C0890_文本操作.m6819(this.vc, "shoujitupian", this.f39861);
                this.vc = C0890_文本操作.m6819(this.vc, "shoujibiaoti", this.f40221);
                this.vc = C0890_文本操作.m6819(this.vc, "shoujijiage", this.f39792);
                this.vc = C0890_文本操作.m6819(this.vc, "shoujirenshu", this.f40133);
                i = IntegerVariant.getIntegerVariant(i).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
                this.fd = (this.fd + "\n") + this.vc;
            }
            this.kk = C0890_文本操作.m6819(this.abc, "yiqide", this.fd);
            this.kk = C0890_文本操作.m6819(this.kk, "//dn.com", "//img.alicdn.com");
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/vca.html", C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/vck.html", "UTF-8"), "UTF-8");
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/vck.html", this.kk, "UTF-8");
            this.fd = bi_常量类.f6358b;
            this.f401513.mo895("下一页");
        }
    }

    /* renamed from: 列表框1$表项被单击 */
    public void m51921$(int 项目索引) {
        this.f40303.mo887(this.f39831.mo987(项目索引));
    }

    /* renamed from: 编辑框3$被单击 */
    public void m52213$() {
        this.f39831.mo996();
        String[] dd = C0890_文本操作.m6806_分割字符串(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/lishi.txt", "UTF-8"), "zk");
        this.f39831.mo776(true);
        this.f39831.mo774(true);
        this.f401818.mo776(true);
        this.f401818.mo774(true);
        this.f39831.mo768();
        this.f401818.mo768();
        int o = C0888.m6769(ArrayVariant.getArrayVariant(dd));
        while (IntegerVariant.getIntegerVariant(o).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            o = IntegerVariant.getIntegerVariant(o).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
            this.f39831.mo995(dd[o]);
        }
    }

    /* renamed from: 标签18$被单击 */
    public void m521318$() {
        C0889_文件操作.m6785(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/lishi.txt");
        this.f39831.mo996();
        this.f39831.mo776(false);
        this.f39831.mo774(false);
        this.f401818.mo776(false);
        this.f401818.mo774(false);
    }

    /* renamed from: 编辑框3$内容被改变 */
    public void m52203$(String 新内容) {
        this.f39831.mo996();
        String[] dd = C0890_文本操作.m6806_分割字符串(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/lishi.txt", "UTF-8"), "zk");
        this.f39831.mo776(true);
        this.f39831.mo774(true);
        this.f401818.mo776(true);
        this.f401818.mo774(true);
        this.f39831.mo768();
        this.f401818.mo768();
        this.f3969GIF1.mo768();
        int o = C0888.m6769(ArrayVariant.getArrayVariant(dd));
        while (IntegerVariant.getIntegerVariant(o).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            o = IntegerVariant.getIntegerVariant(o).sub(ByteVariant.getByteVariant((byte) 1)).getInteger();
            this.f39831.mo995(dd[o]);
        }
    }

    /* renamed from: 标签2$被单击 */
    public void m52142$() {
        String ll = bi_常量类.f6358b;
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(this.f40241.mo944(), "vcak", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f40241.mo952();
            this.ci = IntegerVariant.getIntegerVariant(this.ci).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
        } else if (!C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/tencent/shi/vc.html", "UTF-8").equals(bi_常量类.f6358b)) {
            this.f40241.mo976("file:///sdcard/tencent/shi/vc.html");
        }
    }

    /* renamed from: 图片框8$被单击 */
    public void m51978$() {
        this.f40241.mo976("javascript:window.hua.jsAndroid(document.getElementsByTagName('html')[0].innerHTML)");
        this.f400110.mo928(1000);
    }

    /* renamed from: 图片框5$被单击 */
    public void m51965$() {
        this.f40241.mo976("javascript:window.hua.jsAndroid(document.getElementsByTagName('html')[0].innerHTML)");
        this.f40109.mo928(1000);
    }

    /* renamed from: 时钟9$周期事件 */
    public void m52099$() {
        this.f40109.mo928(0);
        this.f3974ok1.mo1425((int) C0893.m6861(DoubleVariant.getDoubleVariant(C0899.m6943(this.f3995)).mul(ByteVariant.getByteVariant((byte) 100)).getDouble(), 0), "vgongsi", "http://www.chengshiyouxi.com/pay/notify5.php", this.dian + this.ids);
    }

    /* renamed from: 时钟10$周期事件 */
    public void m520010$() {
        String shijian = bi_常量类.f6358b;
        shijian = C0890_文本操作.m6819(C0890_文本操作.m6819(C0899.m6945(ConvHelpers.string2double(((((Integer.toString(C0891.m6828(C0891.m6837())) + Integer.toString(C0891.m6834(C0891.m6837()))) + Integer.toString(C0891.m6830(C0891.m6837()))) + Integer.toString(C0891.m6827(C0891.m6837()))) + Integer.toString(C0891.m6825(C0891.m6837()))) + Integer.toString(C0891.m6840(C0891.m6837())))), ".", bi_常量类.f6358b), "E", bi_常量类.f6358b);
        this.f400110.mo928(0);
        this.f39961.mo1458("购物", this.title, this.f3995, ((this.dian + this.ids) + "7277") + shijian);
    }

    /* renamed from: 图片框1$被单击 */
    public void m51941$() {
        this.f40303.mo887(bi_常量类.f6358b);
    }

    /* renamed from: 时钟11$周期事件 */
    public void m520111$() {
        this.f400211.mo928(0);
        this.f40241.mo776(true);
        this.f40241.mo768();
    }
}
