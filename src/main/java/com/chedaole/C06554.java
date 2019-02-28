package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0847;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0888;
import com.e4a.runtime.C0889_文件操作;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0893;
import com.e4a.runtime.C0894;
import com.e4a.runtime.C0895;
import com.e4a.runtime.C0898_读写设置类;
import com.e4a.runtime.C0899;
import com.e4a.runtime.Objects;
import com.e4a.runtime.annotations.SimpleDataElement;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.Component;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.n1.C0693;
import com.e4a.runtime.components.impl.android.n1.C0695Impl;
import com.e4a.runtime.components.impl.android.n2.C0717;
import com.e4a.runtime.components.impl.android.n2.C0722Impl;
import com.e4a.runtime.components.impl.android.n3.C0723;
import com.e4a.runtime.components.impl.android.n3.C0725Impl;
import com.e4a.runtime.components.impl.android.n4.C0739;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.components.impl.android.n42.C0743;
import com.e4a.runtime.components.impl.android.n42.C0752Impl;
import com.e4a.runtime.components.impl.android.n56.C0757;
import com.e4a.runtime.components.impl.android.n56.C0767Impl;
import com.e4a.runtime.components.impl.android.n89.C0778;
import com.e4a.runtime.components.impl.android.n89.C0789Impl;
import com.e4a.runtime.components.impl.android.p021.C0830;
import com.e4a.runtime.components.impl.android.p021.C0831Impl;
import com.e4a.runtime.errors.RuntimeError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.variants.ArrayVariant;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.StringVariant;
import com.tencent.smtt.sdk.WebView;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口4.code */
/* renamed from: com.chedaole.窗口4 */
public class C06554 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口4 */
    public static C0644 f41944;
    @SimpleDataElement
    public String AK = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: a */
    public int f4195a;
    @SimpleDataElement
    public String ggg = bi_常量类.f6358b;
    @SimpleDataElement
    public String gggg = bi_常量类.f6358b;
    @SimpleDataElement
    public int iv;
    @SimpleDataElement
    public int ivs;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b;
    @SimpleDataElement
    public String yq = bi_常量类.f6358b;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 分组列表框1 */
    public C0757 f41961;
    @SimpleDataElement
    /* renamed from: 启动时间 */
    public long f4197;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f41981;
    @SimpleDataElement
    /* renamed from: 图片框2 */
    public C0739 f41992;
    @SimpleDataElement
    /* renamed from: 图片框3 */
    public C0739 f42003;
    @SimpleDataElement
    /* renamed from: 图片框4 */
    public C0739 f42014;
    @SimpleDataElement
    /* renamed from: 图片框5 */
    public C0739 f42025;
    @SimpleDataElement
    /* renamed from: 图片框6 */
    public C0739 f42036;
    @SimpleDataElement
    /* renamed from: 图片框7 */
    public C0739 f42047;
    @SimpleDataElement
    /* renamed from: 城市 */
    public String f4205 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 多线程1 */
    public C0743 f42061;
    @SimpleDataElement
    /* renamed from: 按钮1 */
    public C0693 f42071;
    @SimpleDataElement
    /* renamed from: 标签1 */
    public C0723 f42081;
    @SimpleDataElement
    /* renamed from: 标签2 */
    public C0723 f42092;
    @SimpleDataElement
    /* renamed from: 标签3 */
    public C0723 f42103;
    @SimpleDataElement
    /* renamed from: 标签4 */
    public C0723 f42114;
    @SimpleDataElement
    /* renamed from: 标签5 */
    public C0723 f42125;
    @SimpleDataElement
    /* renamed from: 标签6 */
    public C0723 f42136;
    @SimpleDataElement
    /* renamed from: 终点 */
    public String f4214 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 编辑框1 */
    public C0717 f42151;
    @SimpleDataElement
    /* renamed from: 编辑框2 */
    public C0717 f42162;
    @SimpleDataElement
    /* renamed from: 编辑框3 */
    public C0717 f42173;
    @SimpleDataElement
    /* renamed from: 起点 */
    public String f4218 = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 高德地图1 */
    public C0778 f42191;
    @SimpleDataElement
    /* renamed from: 高德导航1 */
    public C0830 f42201;

    public C06554() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f41944 = this;
        f41944.mo840("E4A");
        f41944.mo797(0);
        f41944.m5096(IntegerVariant.getIntegerVariant(4));
        f41944.mo838(1);
        f41944.mo826(false);
        C0722Impl c0722Impl = new C0722Impl(f41944);
        Objects.initializeProperties(c0722Impl);
        this.f42162 = c0722Impl;
        this.f42162.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.273d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42162.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.397d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42162.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.333d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42162.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42162.mo887(bi_常量类.f6358b);
        this.f42162.mo889(-16777216);
        this.f42162.mo896(false);
        this.f42162.mo892(false);
        this.f42162.mo1020(9.0f);
        this.f42162.mo774(true);
        this.f42162.mo1041(1);
        this.f42162.mo891(3);
        this.f42162.mo772(true);
        this.f42162.mo1035(bi_常量类.f6358b);
        this.f42162.mo899(0);
        this.f42162.mo776(true);
        C0752Impl c0752Impl = new C0752Impl(f41944);
        Objects.initializeProperties(c0752Impl);
        this.f42061 = c0752Impl;
        C0767Impl c0767Impl = new C0767Impl(f41944);
        Objects.initializeProperties(c0767Impl);
        this.f41961 = c0767Impl;
        this.f41961.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.008d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41961.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.523d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41961.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.983d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41961.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.475d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41961.mo797(0);
        this.f41961.mo1186(10.0f);
        this.f41961.mo1188(Component.f3925);
        this.f41961.mo1182(9.0f);
        this.f41961.mo1184(-16777216);
        this.f41961.mo1230(10.0f);
        this.f41961.mo1232(-16777216);
        this.f41961.mo1213(10.0f);
        this.f41961.mo1215(-16777216);
        this.f41961.mo1221(10.0f);
        this.f41961.mo1223(Component.f3916);
        this.f41961.mo1258(bi_常量类.f6358b);
        this.f41961.mo776(true);
        this.f41961.mo1238(true);
        C0742Impl c0742Impl = new C0742Impl(f41944);
        Objects.initializeProperties(c0742Impl);
        this.f41981 = c0742Impl;
        this.f41981.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41981.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.343d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41981.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.183d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41981.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41981.mo797(0);
        this.f41981.mo1143(1);
        this.f41981.mo1139("cfd.png");
        this.f41981.mo776(true);
        c0742Impl = new C0742Impl(f41944);
        Objects.initializeProperties(c0742Impl);
        this.f41992 = c0742Impl;
        this.f41992.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41992.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.406d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41992.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.183d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41992.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41992.mo797(0);
        this.f41992.mo1143(1);
        this.f41992.mo1139("mdd.png");
        this.f41992.mo776(true);
        C0725Impl c0725Impl = new C0725Impl(f41944);
        Objects.initializeProperties(c0725Impl);
        this.f42092 = c0725Impl;
        this.f42092.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.271d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42092.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.391d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42092.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.333d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42092.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.003d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42092.mo895(bi_常量类.f6358b);
        this.f42092.mo797(-8355712);
        this.f42092.mo889(-16777216);
        this.f42092.mo896(false);
        this.f42092.mo892(false);
        this.f42092.mo891(4);
        this.f42092.mo1049(9.0f);
        this.f42092.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42092.mo776(true);
        c0725Impl = new C0725Impl(f41944);
        Objects.initializeProperties(c0725Impl);
        this.f42114 = c0725Impl;
        this.f42114.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.273d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42114.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.455d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42114.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.333d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42114.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.003d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42114.mo895(bi_常量类.f6358b);
        this.f42114.mo797(-8355712);
        this.f42114.mo889(-16777216);
        this.f42114.mo896(false);
        this.f42114.mo892(false);
        this.f42114.mo891(4);
        this.f42114.mo1049(9.0f);
        this.f42114.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42114.mo776(true);
        c0725Impl = new C0725Impl(f41944);
        Objects.initializeProperties(c0725Impl);
        this.f42125 = c0725Impl;
        this.f42125.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(-0.002d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42125.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.512d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42125.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42125.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.003d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42125.mo895(bi_常量类.f6358b);
        this.f42125.mo797(-7612746);
        this.f42125.mo889(-8355712);
        this.f42125.mo896(false);
        this.f42125.mo892(false);
        this.f42125.mo891(4);
        this.f42125.mo1049(9.0f);
        this.f42125.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42125.mo776(true);
        c0742Impl = new C0742Impl(f41944);
        Objects.initializeProperties(c0742Impl);
        this.f42003 = c0742Impl;
        this.f42003.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.992d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42003.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.516d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42003.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42003.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.485d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42003.mo797(0);
        this.f42003.mo1143(1);
        this.f42003.mo1139("right.png");
        this.f42003.mo776(true);
        c0742Impl = new C0742Impl(f41944);
        Objects.initializeProperties(c0742Impl);
        this.f42014 = c0742Impl;
        this.f42014.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(-0.002d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42014.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.516d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42014.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42014.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.485d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42014.mo797(0);
        this.f42014.mo1143(1);
        this.f42014.mo1139("left.png");
        this.f42014.mo776(true);
        c0722Impl = new C0722Impl(f41944);
        Objects.initializeProperties(c0722Impl);
        this.f42173 = c0722Impl;
        this.f42173.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.277d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42173.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.33d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42173.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.333d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42173.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42173.mo887(bi_常量类.f6358b);
        this.f42173.mo889(-16777216);
        this.f42173.mo896(false);
        this.f42173.mo892(false);
        this.f42173.mo1020(9.0f);
        this.f42173.mo774(true);
        this.f42173.mo1041(1);
        this.f42173.mo891(3);
        this.f42173.mo772(true);
        this.f42173.mo1035(bi_常量类.f6358b);
        this.f42173.mo899(0);
        this.f42173.mo776(true);
        c0722Impl = new C0722Impl(f41944);
        Objects.initializeProperties(c0722Impl);
        this.f42151 = c0722Impl;
        this.f42151.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.273d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42151.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.329d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42151.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.333d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42151.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42151.mo887(bi_常量类.f6358b);
        this.f42151.mo889(-16777216);
        this.f42151.mo896(false);
        this.f42151.mo892(false);
        this.f42151.mo1020(9.0f);
        this.f42151.mo774(true);
        this.f42151.mo1041(1);
        this.f42151.mo891(3);
        this.f42151.mo772(true);
        this.f42151.mo1035(bi_常量类.f6358b);
        this.f42151.mo899(0);
        this.f42151.mo776(true);
        c0725Impl = new C0725Impl(f41944);
        Objects.initializeProperties(c0725Impl);
        this.f42136 = c0725Impl;
        this.f42136.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42136.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.324d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42136.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42136.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.003d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42136.mo895(bi_常量类.f6358b);
        this.f42136.mo797(-7612746);
        this.f42136.mo889(-8355712);
        this.f42136.mo896(false);
        this.f42136.mo892(false);
        this.f42136.mo891(4);
        this.f42136.mo1049(9.0f);
        this.f42136.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42136.mo776(true);
        c0725Impl = new C0725Impl(f41944);
        Objects.initializeProperties(c0725Impl);
        this.f42103 = c0725Impl;
        this.f42103.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42103.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.466d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42103.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42103.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.045d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42103.mo895(bi_常量类.f6358b);
        this.f42103.mo797(0);
        this.f42103.mo889(Component.f3916);
        this.f42103.mo896(false);
        this.f42103.mo892(false);
        this.f42103.mo891(4);
        this.f42103.mo1049(12.0f);
        this.f42103.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42103.mo776(true);
        c0742Impl = new C0742Impl(f41944);
        Objects.initializeProperties(c0742Impl);
        this.f42036 = c0742Impl;
        this.f42036.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.627d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42036.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.36d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42036.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.117d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42036.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.062d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42036.mo797(0);
        this.f42036.mo1143(1);
        this.f42036.mo1139("loc_focus.png");
        this.f42036.mo776(true);
        C0695Impl c0695Impl = new C0695Impl(f41944);
        Objects.initializeProperties(c0695Impl);
        this.f42071 = c0695Impl;
        this.f42071.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.765d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42071.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.375d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42071.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.2d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42071.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42071.mo895(bi_常量类.f6358b);
        this.f42071.mo889(-16777216);
        this.f42071.mo896(false);
        this.f42071.mo892(false);
        this.f42071.mo891(7);
        this.f42071.mo906(13.0f);
        this.f42071.mo902("ggdh.png");
        this.f42071.mo912(bi_常量类.f6358b);
        this.f42071.mo908(bi_常量类.f6358b);
        this.f42071.mo774(true);
        this.f42071.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42071.mo776(true);
        C0789Impl c0789Impl = new C0789Impl(f41944);
        Objects.initializeProperties(c0789Impl);
        this.f42191 = c0789Impl;
        this.f42191.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42191.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42191.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.017d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42191.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.32d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42191.mo776(true);
        c0742Impl = new C0742Impl(f41944);
        Objects.initializeProperties(c0742Impl);
        this.f42047 = c0742Impl;
        this.f42047.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.775d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42047.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.095d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42047.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.217d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42047.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.031d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42047.mo797(0);
        this.f42047.mo1143(1);
        this.f42047.mo1139("zzdh.png");
        this.f42047.mo776(false);
        c0725Impl = new C0725Impl(f41944);
        Objects.initializeProperties(c0725Impl);
        this.f42081 = c0725Impl;
        this.f42081.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.004d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42081.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.463d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42081.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42081.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42081.mo895(bi_常量类.f6358b);
        this.f42081.mo797(-7612746);
        this.f42081.mo889(-8355712);
        this.f42081.mo896(false);
        this.f42081.mo892(false);
        this.f42081.mo891(4);
        this.f42081.mo1049(9.0f);
        this.f42081.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42081.mo776(true);
        C0831Impl c0831Impl = new C0831Impl(f41944);
        Objects.initializeProperties(c0831Impl);
        this.f42201 = c0831Impl;
        c0742Impl = new C0742Impl(f41944);
        Objects.initializeProperties(c0742Impl);
        this.f42025 = c0742Impl;
        this.f42025.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.023d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42025.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.014d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42025.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42025.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42025.mo797(0);
        this.f42025.mo1143(1);
        this.f42025.mo1139("icon01.png");
        this.f42025.mo776(true);
        EventDispatcher.registerEvent(this, "高德地图1", "定位完毕");
        EventDispatcher.registerEvent(this, "按钮1", "被单击");
        EventDispatcher.registerEvent(this, "窗口4", "切换完毕");
        EventDispatcher.registerEvent(this, "窗口4", "按下某键");
        EventDispatcher.registerEvent(this, "分组列表框1", "子项被单击");
        EventDispatcher.registerEvent(this, "图片框6", "被单击");
        EventDispatcher.registerEvent(this, "图片框7", "被单击");
        EventDispatcher.registerEvent(this, "图片框5", "被单击");
        EventDispatcher.registerEvent(this, "高德导航1", "规划导航路线完毕");
        EventDispatcher.registerEvent(this, "高德地图1", "搜索路线完毕");
        EventDispatcher.registerEvent(this, "编辑框1", "获得焦点");
        EventDispatcher.registerEvent(this, "多线程1", "取网页源码完毕");
        EventDispatcher.registerEvent(this, "窗口4", "创建完毕");
        f41944.mo765();
        this.f42162.mo765();
        this.f42061.mo765();
        this.f41961.mo765();
        this.f41981.mo765();
        this.f41992.mo765();
        this.f42092.mo765();
        this.f42114.mo765();
        this.f42125.mo765();
        this.f42003.mo765();
        this.f42014.mo765();
        this.f42173.mo765();
        this.f42151.mo765();
        this.f42136.mo765();
        this.f42103.mo765();
        this.f42036.mo765();
        this.f42071.mo765();
        this.f42191.mo765();
        this.f42047.mo765();
        this.f42081.mo765();
        this.f42201.mo765();
        this.f42025.mo765();
    }

    /* renamed from: 按钮1$被单击 */
    public void m53051$() {
        this.gggg = "2";
        this.ggg = "2";
        this.f4195a = 1;
        if (this.f42151.mo886().equals(bi_常量类.f6358b) && this.f42173.mo886().equals(bi_常量类.f6358b)) {
            C0880_应用操作类.m6694("起点不能为空");
        } else if (this.f42162.mo886().equals(bi_常量类.f6358b)) {
            C0880_应用操作类.m6694("终点不能为空");
        } else {
            if (this.f42151.mo777()) {
                this.f4218 = C0895.m6905URL(C0890_文本操作.m6808(this.f42151.mo886()), "UTF-8");
            } else {
                this.f4218 = C0895.m6905URL(C0890_文本操作.m6808(this.f42173.mo886()), "UTF-8");
            }
            if (this.zz.equals("daqing")) {
                this.yq = "大庆";
            }
            if (this.zz.equals("suihua")) {
                this.yq = "绥化";
            }
            if (this.zz.equals("mudanjiang")) {
                this.yq = "牡丹江";
            }
            if (this.zz.equals("shuangyashan")) {
                this.yq = "双鸭山";
            }
            if (this.zz.equals("haerbin")) {
                this.yq = "哈尔滨";
            }
            this.f4214 = C0895.m6905URL(C0890_文本操作.m6808(this.f42162.mo886()), "UTF-8");
            this.f4205 = C0895.m6905URL(C0890_文本操作.m6808(this.yq), "UTF-8");
            C0880_应用操作类.m6694("正在查询,请稍后");
            this.f42061.mo1169((((((("http://api.map.baidu.com/direction/v1?mode=transit&origin=" + this.f4218) + "&destination=") + this.f4214) + "&region=") + this.f4205) + "&ak=") + this.AK, "UTF-8");
        }
    }

    /* renamed from: 多线程1$取网页源码完毕 */
    public void m53041$(String 源码) {
        if (源码.equals(bi_常量类.f6358b)) {
            C0880_应用操作类.m6694("查询失败,未获取到源码");
            return;
        }
        C0889_文件操作.m6781_写出文本文件("/sdcard/1234.txt", 源码, "UTF-8");
        String 状态 = bi_常量类.f6358b;
        状态 = C0890_文本操作.m68132(源码, "<status>", "</status>");
        if (状态.equals("0")) {
            String 类型 = bi_常量类.f6358b;
            类型 = C0890_文本操作.m68132(源码, "<type>", "</type>");
            if (类型.equals(C0108a.f262e)) {
                m5311(源码);
            } else if (类型.equals("2")) {
                m5310(源码);
            } else {
                C0880_应用操作类.m6694("未知错误2");
            }
        } else if (状态.equals("2")) {
            C0880_应用操作类.m6694("参数错误,请重新填写参数");
        } else if (状态.equals("5")) {
            C0880_应用操作类.m6694("权限或配额校验失败,请更换AK");
        } else {
            C0880_应用操作类.m6694("未知错误1");
        }
    }

    /* renamed from: 选择起点终点 */
    public void m5311(String 源码) {
        String[] 地点数组;
        String[] 地点列表;
        boolean[] 选择状态;
        int 计次;
        String 地点源码 = bi_常量类.f6358b;
        String 地点名称 = bi_常量类.f6358b;
        地点源码 = C0890_文本操作.m68132(源码, "<origin>", "</origin>");
        if (!地点源码.equals(bi_常量类.f6358b)) {
            地点数组 = C0890_文本操作.m6812(地点源码, "<content>", "</content>");
            if (IntegerVariant.getIntegerVariant(C0888.m6769(ArrayVariant.getArrayVariant(地点数组))).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                地点列表 = new String[C0888.m6769(ArrayVariant.getArrayVariant(地点数组))];
                选择状态 = new boolean[C0888.m6769(ArrayVariant.getArrayVariant(地点数组))];
                for (计次 = 0; 计次 < C0888.m6769(ArrayVariant.getArrayVariant(地点数组)); 计次 = IntegerVariant.getIntegerVariant(计次).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
                    地点列表[计次] = C0890_文本操作.m68132(地点数组[计次], "<name>", "</name>");
                    选择状态[计次] = false;
                }
                选择状态[0] = true;
                if (IntegerVariant.getIntegerVariant(C0888.m6769(ArrayVariant.getArrayVariant(地点列表))).cmp(ByteVariant.getByteVariant((byte) 1)) > 0 && this.gggg.equals(地点列表[0]) && this.gggg.equals(地点列表[1])) {
                    C0879.m6668("提示", "请输入详细地址，不要缩写 例：(新玛特) 输入：(新村新玛特)", "确定");
                    this.gggg = C0108a.f262e;
                    return;
                }
                this.gggg = 地点列表[0];
                this.f4218 = C0879.m6672("请选择起点", 地点列表, 选择状态);
            }
        }
        地点源码 = C0890_文本操作.m68132(源码, "<destination>", "</destination>");
        if (!地点源码.equals(bi_常量类.f6358b)) {
            地点数组 = C0890_文本操作.m6812(地点源码, "<content>", "</content>");
            if (IntegerVariant.getIntegerVariant(C0888.m6769(ArrayVariant.getArrayVariant(地点数组))).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                地点列表 = new String[C0888.m6769(ArrayVariant.getArrayVariant(地点数组))];
                选择状态 = new boolean[C0888.m6769(ArrayVariant.getArrayVariant(地点数组))];
                for (计次 = 0; 计次 < C0888.m6769(ArrayVariant.getArrayVariant(地点数组)); 计次 = IntegerVariant.getIntegerVariant(计次).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
                    地点列表[计次] = C0890_文本操作.m68132(地点数组[计次], "<name>", "</name>");
                    选择状态[计次] = false;
                }
                选择状态[0] = true;
                if (IntegerVariant.getIntegerVariant(C0888.m6769(ArrayVariant.getArrayVariant(地点列表))).cmp(ByteVariant.getByteVariant((byte) 1)) > 0 && this.ggg.equals(地点列表[0]) && this.ggg.equals(地点列表[1])) {
                    C0879.m6668("提示", "请输入详细地址，不要缩写 例：(新玛特) 输入：(新村新玛特)", "确定");
                    this.ggg = C0108a.f262e;
                    return;
                }
                this.ggg = 地点列表[0];
                this.f4214 = C0879.m6672("请选择终点", 地点列表, 选择状态);
            }
        }
        C0880_应用操作类.m6694("正在查询,请您稍后");
        if (IntegerVariant.getIntegerVariant(this.f4195a).cmp(ByteVariant.getByteVariant((byte) 2)) == 0) {
            C0880_应用操作类.m6694("没找到地址");
            return;
        }
        this.f4195a = IntegerVariant.getIntegerVariant(this.f4195a).add(ByteVariant.getByteVariant((byte) 1)).getInteger();
        this.f42061.mo1169((((((("http://api.map.baidu.com/direction/v1?mode=transit&origin=" + this.f4218) + "&destination=") + this.f4214) + "&region=") + this.f4205) + "&ak=") + this.AK, "UTF-8");
    }

    /* renamed from: 解析路线 */
    public void m5310(String 源码) {
        String 路线距离 = bi_常量类.f6358b;
        String 路线时间 = bi_常量类.f6358b;
        String 步骤源码 = bi_常量类.f6358b;
        String 步骤描述 = bi_常量类.f6358b;
        String 步骤类型 = bi_常量类.f6358b;
        String 步行距离 = bi_常量类.f6358b;
        String 公交起点 = bi_常量类.f6358b;
        String 公交名称 = bi_常量类.f6358b;
        String 公交站数 = bi_常量类.f6358b;
        String 公交终点 = bi_常量类.f6358b;
        String 子项图标 = bi_常量类.f6358b;
        this.f41961.mo1246();
        this.f41961.mo1196(true);
        String[] 路线数组 = C0890_文本操作.m6812(源码, "<scheme>", "</scheme>");
        this.f42103.mo895(Integer.toString(C0888.m6769(ArrayVariant.getArrayVariant(路线数组))));
        this.f42103.mo895(("为您提供" + this.f42103.mo894()) + "条路线可以参考");
        for (int 计次 = 0; 计次 < C0888.m6769(ArrayVariant.getArrayVariant(路线数组)); 计次 = IntegerVariant.getIntegerVariant(计次).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
            路线距离 = C0890_文本操作.m68132(路线数组[计次], "<distance>", "</distance>") + "米";
            this.f41961.mo1242("路线" + IntegerVariant.getIntegerVariant(计次).add(ByteVariant.getByteVariant((byte) 1)).getString(), (("距离:" + 路线距离) + "  时间:") + (C0847.m6639(C0890_文本操作.m68132(路线数组[计次], "<duration>", "</duration>"), "60", 0) + "分 "));
            String[] 步骤数组 = C0890_文本操作.m6812(C0890_文本操作.m68132(路线数组[计次], "<steps>", "</steps>"), "<info>", "</info>");
            for (int 计次2 = 0; 计次2 < C0888.m6769(ArrayVariant.getArrayVariant(步骤数组)); 计次2 = IntegerVariant.getIntegerVariant(计次2).add(ByteVariant.getByteVariant((byte) 1)).getInteger()) {
                步骤类型 = C0890_文本操作.m68132(步骤数组[计次2], "<type>", "</type>");
                步骤描述 = C0890_文本操作.m68132(步骤数组[计次2], "<stepInstruction>", "</stepInstruction>");
                if (步骤描述.equals(bi_常量类.f6358b)) {
                    if (步骤类型.equals("5")) {
                        步行距离 = C0890_文本操作.m68132(步骤数组[计次2], "<distance>", "</distance>");
                        步骤描述 = ("步行" + 步行距离) + "米";
                        if (IntegerVariant.getIntegerVariant(C0899.m6944(步行距离)).cmp(ByteVariant.getByteVariant((byte) 20)) < 0) {
                            步骤描述 = "上车";
                        }
                    } else {
                        公交起点 = C0890_文本操作.m68132(步骤数组[计次2], "<start_name>", "</start_name>");
                        公交名称 = C0890_文本操作.m68132(步骤数组[计次2], "<name>", "</name>");
                        公交站数 = C0890_文本操作.m68132(步骤数组[计次2], "<stop_num>", "</stop_num>");
                        步骤描述 = ((((((("从<font color=#0088FF>" + 公交起点) + "</font>,乘") + 公交名称) + ",经过") + 公交站数) + "站,到<font color=#0088FF>") + C0890_文本操作.m68132(步骤数组[计次2], "<end_name>", "</end_name>")) + "</font>";
                    }
                } else {
                    步骤描述 = C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(步骤描述, "&lt;", "<"), "&gt;", ">"), "&quot;#313233&quot;", "#0088FF");
                }
                if (步骤类型.equals("5")) {
                    this.f41961.mo1243(计次, "man.png", 步骤描述, bi_常量类.f6358b, bi_常量类.f6358b, bi_常量类.f6358b);
                } else {
                    this.f41961.mo1243(计次, "bus.png", ((步骤描述 + "<font color=#FF0000  >") + "《点击查看此线多久来车》") + "</font>", bi_常量类.f6358b, bi_常量类.f6358b, bi_常量类.f6358b);
                }
            }
        }
    }

    /* renamed from: 分组列表框1$子项被单击 */
    public void m52991$(int 分组索引, int 子项索引) {
        String ll = bi_常量类.f6358b;
        String lu = bi_常量类.f6358b;
        ll = this.f41961.mo1209(分组索引, 子项索引);
        lu = m5300(ll, ",乘", "路");
        if (lu.equals(bi_常量类.f6358b)) {
            lu = C0890_文本操作.m6819(C0890_文本操作.m6819(m5300(ll, ",乘", "线"), "快", "k"), "环", "h");
            C0898_读写设置类.m6935_通过SP保存设置("正反", StringVariant.getStringVariant("正"));
            C0898_读写设置类.m6935_通过SP保存设置("线路", StringVariant.getStringVariant(lu));
            if (C0880_应用操作类.m6712("过渡窗口") == null) {
                C0880_应用操作类.m6692("过渡窗口", new C06532());
            }
            C0898_读写设置类.m6935_通过SP保存设置("方向", StringVariant.getStringVariant("zheng"));
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("过渡窗口"));
            return;
        }
        lu = C0890_文本操作.m6819(C0890_文本操作.m6819(C0890_文本操作.m6819(lu, "快", "k"), "环", "h"), "z0", "k");
        C0898_读写设置类.m6935_通过SP保存设置("正反", StringVariant.getStringVariant("正"));
        C0898_读写设置类.m6935_通过SP保存设置("线路", StringVariant.getStringVariant(lu));
        if (C0880_应用操作类.m6712("过渡窗口") == null) {
            C0880_应用操作类.m6692("过渡窗口", new C06532());
        }
        C0898_读写设置类.m6935_通过SP保存设置("方向", StringVariant.getStringVariant("zheng"));
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("过渡窗口"));
    }

    /* renamed from: 取中间文本 */
    public String m5300(String 完整内容, String 左边文本, String 右边文本) {
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

    /* renamed from: 窗口4$按下某键 */
    public void m53084$(int i, BooleanReferenceParameter booleanReferenceParameter) {
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

    /* renamed from: 窗口4$创建完毕 */
    public void m53074$() {
        String y = bi_常量类.f6358b;
        String z = bi_常量类.f6358b;
        this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
        this.AK = C0889_文件操作.m6802(((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/baidu.TXT", "GBK");
        this.f42191.mo1366(true);
        this.f42191.mo1367(true);
        this.f42191.mo1364(true);
        this.f42191.mo1363(true);
    }

    /* renamed from: 高德地图1$定位完毕 */
    public void m53121$(double 纬度, double 经度, String 省份, String 城市, String 地区, String 街道) {
        this.f42151.mo887(街道);
    }

    /* renamed from: 编辑框1$获得焦点 */
    public void m53091$() {
        this.f42173.mo776(true);
        this.f42173.mo774(true);
        this.f42151.mo887(bi_常量类.f6358b);
        this.f42151.mo776(false);
        this.f42151.mo774(false);
        this.f42173.mo798();
    }

    /* renamed from: 图片框6$被单击 */
    public void m53026$() {
        this.f42151.mo776(true);
        this.f42151.mo774(true);
        this.f42173.mo776(false);
        this.f42173.mo774(false);
        this.f42191.mo1366(true);
        this.f42191.mo1367(true);
        this.f42191.mo1364(true);
        this.f42191.mo1363(true);
        this.f42191.mo1342();
    }

    /* renamed from: 图片框7$被单击 */
    public void m53037$() {
        C0879.m6668("提示", "数据调试中", "确定");
    }

    /* renamed from: 窗口4$切换完毕 */
    public void m53064$() {
        this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
        if (C0898_读写设置类.m6937_通过SP读取设置("从").cmp(StringVariant.getStringVariant(bi_常量类.f6358b)) != 0) {
            this.f42173.mo887(C0898_读写设置类.m6937_通过SP读取设置("从").getString());
            this.f42162.mo887(C0898_读写设置类.m6937_通过SP读取设置("到").getString());
            this.f42173.mo776(true);
            this.f42173.mo774(true);
            this.f42151.mo776(false);
            this.f42151.mo774(false);
        }
    }

    /* renamed from: 高德地图1$搜索路线完毕 */
    public void m53131$(boolean 搜索结果, double 起点纬度, double 起点经度, double 终点纬度, double 终点经度) {
        if (搜索结果) {
            C0880_应用操作类.m6694("搜索路线成功,开始规划导航路线……");
            this.f42201.mo1498(起点纬度, 起点经度, 终点纬度, 终点经度);
            return;
        }
        C0880_应用操作类.m6694("搜索路线失败");
    }

    /* renamed from: 高德导航1$规划导航路线完毕 */
    public void m53141$(boolean 规划结果) {
        if (!规划结果) {
            C0880_应用操作类.m6694("导航路线规划失败");
        } else if (IntegerVariant.getIntegerVariant(C0879.m66692("提示", "路线规划完毕", "开始导航", "取消")).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
            this.f42201.mo1494();
        } else {
            C0880_应用操作类.m6694("取消导航");
        }
    }

    /* renamed from: 图片框5$被单击 */
    public void m53015$() {
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }
}
