package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
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
import com.e4a.runtime.components.impl.android.n15.C0698;
import com.e4a.runtime.components.impl.android.n15.C0713Impl;
import com.e4a.runtime.components.impl.android.n2.C0717;
import com.e4a.runtime.components.impl.android.n2.C0722Impl;
import com.e4a.runtime.components.impl.android.n37.C0736;
import com.e4a.runtime.components.impl.android.n37.C0738Impl;
import com.e4a.runtime.components.impl.android.n4.C0739;
import com.e4a.runtime.components.impl.android.n4.C0742Impl;
import com.e4a.runtime.components.impl.android.p018ok.C0794ok;
import com.e4a.runtime.components.impl.android.p018ok.C0796okImpl;
import com.e4a.runtime.components.impl.android.p019.C0811;
import com.e4a.runtime.components.impl.android.p019.C0812Impl;
import com.e4a.runtime.components.impl.android.p020.C0813;
import com.e4a.runtime.components.impl.android.p020.C0817Impl;
import com.e4a.runtime.errors.RuntimeError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.helpers.ConvHelpers;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.e4a.runtime.variants.ByteVariant;
import com.e4a.runtime.variants.DoubleVariant;
import com.e4a.runtime.variants.IntegerVariant;
import com.e4a.runtime.variants.StringVariant;
import com.tencent.smtt.sdk.WebView;
import p054u.aly.bi_常量类;

@SimpleObject
/* compiled from: 窗口8.code */
/* renamed from: com.chedaole.窗口8 */
public class C06598 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口8 */
    public static C0644 f42468;
    @SimpleDataElement
    /* renamed from: a */
    public String f4247a = bi_常量类.f6358b;
    @SimpleDataElement
    public String[] aav;
    @SimpleDataElement
    public String dingdan = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: e */
    public String f4248e = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: f */
    public String f4249f = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: g */
    public String f4250g = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: ok微信支付1 */
    public C0794ok f4251ok1;
    @SimpleDataElement
    public String shijian = bi_常量类.f6358b;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: x */
    public String f4252x = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f42531;
    @SimpleDataElement
    /* renamed from: 图片框2 */
    public C0739 f42542;
    @SimpleDataElement
    /* renamed from: 图片框3 */
    public C0739 f42553;
    @SimpleDataElement
    /* renamed from: 图片框4 */
    public C0739 f42564;
    @SimpleDataElement
    /* renamed from: 客户1 */
    public C0736 f42571;
    @SimpleDataElement
    /* renamed from: 支付宝1 */
    public C0813 f42581;
    @SimpleDataElement
    /* renamed from: 支付宝免签约支付1 */
    public C0811 f42591;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f42601;
    @SimpleDataElement
    /* renamed from: 编辑框1 */
    public C0717 f42611;
    @SimpleDataElement
    /* renamed from: 额度 */
    public String f4262 = bi_常量类.f6358b;

    public C06598() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f42468 = this;
        f42468.mo840("E4A");
        f42468.mo797(-1);
        f42468.m5096(IntegerVariant.getIntegerVariant(4));
        f42468.mo838(1);
        f42468.mo826(false);
        C0817Impl c0817Impl = new C0817Impl(f42468);
        Objects.initializeProperties(c0817Impl);
        this.f42581 = c0817Impl;
        C0713Impl c0713Impl = new C0713Impl(f42468);
        Objects.initializeProperties(c0713Impl);
        this.f42601 = c0713Impl;
        this.f42601.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42601.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42601.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42601.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(1.001d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42601.mo776(true);
        C0742Impl c0742Impl = new C0742Impl(f42468);
        Objects.initializeProperties(c0742Impl);
        this.f42531 = c0742Impl;
        this.f42531.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.875d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42531.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.014d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42531.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42531.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42531.mo797(0);
        this.f42531.mo1143(1);
        this.f42531.mo1139("eee.png");
        this.f42531.mo776(true);
        c0742Impl = new C0742Impl(f42468);
        Objects.initializeProperties(c0742Impl);
        this.f42542 = c0742Impl;
        this.f42542.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.363d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42542.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.526d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42542.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.313d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42542.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.173d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42542.mo797(0);
        this.f42542.mo1143(1);
        this.f42542.mo776(false);
        C0738Impl c0738Impl = new C0738Impl(f42468);
        Objects.initializeProperties(c0738Impl);
        this.f42571 = c0738Impl;
        C0812Impl c0812Impl = new C0812Impl(f42468);
        Objects.initializeProperties(c0812Impl);
        this.f42591 = c0812Impl;
        C0796okImpl c0796okImpl = new C0796okImpl(f42468);
        Objects.initializeProperties(c0796okImpl);
        this.f4251ok1 = c0796okImpl;
        c0742Impl = new C0742Impl(f42468);
        Objects.initializeProperties(c0742Impl);
        this.f42564 = c0742Impl;
        this.f42564.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.45d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42564.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.01d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42564.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.35d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42564.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.103d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42564.mo797(-16742145);
        this.f42564.mo1143(1);
        this.f42564.mo776(false);
        C0722Impl c0722Impl = new C0722Impl(f42468);
        Objects.initializeProperties(c0722Impl);
        this.f42611 = c0722Impl;
        this.f42611.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.067d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42611.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42611.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.883d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42611.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.052d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42611.mo887(bi_常量类.f6358b);
        this.f42611.mo889(-16777216);
        this.f42611.mo896(false);
        this.f42611.mo892(false);
        this.f42611.mo1020(9.0f);
        this.f42611.mo774(true);
        this.f42611.mo1041(1);
        this.f42611.mo891(3);
        this.f42611.mo772(true);
        this.f42611.mo1035(bi_常量类.f6358b);
        this.f42611.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42611.mo776(false);
        c0742Impl = new C0742Impl(f42468);
        Objects.initializeProperties(c0742Impl);
        this.f42553 = c0742Impl;
        this.f42553.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.023d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42553.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.014d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42553.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42553.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42553.mo797(0);
        this.f42553.mo1143(1);
        this.f42553.mo1139("icon01.png");
        this.f42553.mo776(true);
        EventDispatcher.registerEvent(this, "ok微信支付1", "生成预支付订单号完毕");
        EventDispatcher.registerEvent(this, "图片框3", "被单击");
        EventDispatcher.registerEvent(this, "ok微信支付1", "支付成功");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "ok微信支付1", "支付失败");
        EventDispatcher.registerEvent(this, "窗口8", "创建完毕");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        EventDispatcher.registerEvent(this, "窗口8", "切换完毕");
        EventDispatcher.registerEvent(this, "窗口8", "按下某键");
        f42468.mo765();
        this.f42581.mo765();
        this.f42601.mo765();
        this.f42531.mo765();
        this.f42542.mo765();
        this.f42571.mo765();
        this.f42591.mo765();
        this.f4251ok1.mo765();
        this.f42564.mo765();
        this.f42611.mo765();
        this.f42553.mo765();
    }

    /* renamed from: 窗口8$按下某键 */
    public void m53468$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        try {
            if (IntegerVariant.getIntegerVariant(i).cmp(ByteVariant.getByteVariant((byte) 4)) == 0) {
                if (this.f4252x.equals("5")) {
                    C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口1"));
                } else {
                    C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
                }
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 窗口8$创建完毕 */
    public void m53458$() {
        String str = bi_常量类.f6358b;
        str = bi_常量类.f6358b;
        try {
            String huo = bi_常量类.f6358b;
            String huoo = bi_常量类.f6358b;
            this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
            this.f4251ok1.mo1417("wx3810718aaeeeafcd", "9VPnMa7VjKAtpdGENVL66d5pdbdfy28q", "1387406602");
            this.f42601.mo960JS("hua");
            if (C0898_读写设置类.m6937_通过SP读取设置("冠名").cmp(StringVariant.getStringVariant(C0108a.f262e)) == 0) {
                this.f42601.mo976(this.wl + "/guanming/index.html");
                this.f4252x = "5";
            } else if (C0898_读写设置类.m6937_通过SP读取设置("购物").cmp(StringVariant.getStringVariant(C0108a.f262e)) == 0) {
                this.f42601.mo976(C0897_网络操作.m6922(this.wl + "/gouwu/gouwu.txt", "UTF-8", 5000));
                C0898_读写设置类.m6935_通过SP保存设置("购物", StringVariant.getStringVariant("0"));
            } else if (C0898_读写设置类.m6937_通过SP读取设置("买卡").cmp(StringVariant.getStringVariant(C0108a.f262e)) == 0) {
                this.f42601.mo976(C0897_网络操作.m6922(this.wl + "/gouwu/maika.txt", "UTF-8", 5000));
                C0898_读写设置类.m6935_通过SP保存设置("买卡", StringVariant.getStringVariant("0"));
            } else {
                huo = C0897_网络操作.m6922(this.wl + "/huo.txt", "UTF-8", 5000);
                if (C0890_文本操作.m6816(huo, 4).equals("http")) {
                    this.f42601.mo976(huo);
                    return;
                }
                C0880_应用操作类.m6694("网络不稳定");
                C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m53431$(String 网页消息) {
        try {
            if (IntegerVariant.getIntegerVariant(C0891.m6827(C0891.m6837())).cmp(ByteVariant.getByteVariant((byte) 21)) == 0 && IntegerVariant.getIntegerVariant(C0891.m6825(C0891.m6837())).cmp(ByteVariant.getByteVariant((byte) 50)) > 0) {
                C0879.m6668("提示", "试运期间21:50后停止充值", "确定");
            } else if (IntegerVariant.getIntegerVariant(C0891.m6827(C0891.m6837())).cmp(ByteVariant.getByteVariant((byte) 21)) > 0) {
                C0879.m6668("提示", "试运期间21:50后停止充值", "确定");
            } else if (IntegerVariant.getIntegerVariant(C0891.m6827(C0891.m6837())).cmp(ByteVariant.getByteVariant((byte) 6)) < 0) {
                C0879.m6668("提示", "试运期间6:10后开始充值", "确定");
            } else {
                this.shijian = C0899.m6945(ConvHelpers.string2double(((((Integer.toString(C0891.m6828(C0891.m6837())) + Integer.toString(C0891.m6834(C0891.m6837()))) + Integer.toString(C0891.m6830(C0891.m6837()))) + Integer.toString(C0891.m6827(C0891.m6837()))) + Integer.toString(C0891.m6825(C0891.m6837()))) + Integer.toString(C0891.m6840(C0891.m6837()))));
                this.aav = C0890_文本操作.m6806_分割字符串(网页消息, "/");
                this.shijian = C0890_文本操作.m6819(this.shijian, ".", bi_常量类.f6358b);
                this.shijian = C0890_文本操作.m6819(this.shijian, "E", bi_常量类.f6358b);
                if (this.aav[0].equals(C0108a.f262e)) {
                    this.dingdan = C0108a.f262e;
                    this.f4248e = Integer.toString(ConvHelpers.byte2integer((byte) 1));
                    this.f4262 = "1元";
                }
                if (this.aav[0].equals("4")) {
                    this.dingdan = "9.95";
                    this.f4262 = "10元";
                    this.f4248e = Integer.toString(ConvHelpers.byte2integer((byte) 10));
                }
                if (this.aav[0].equals("5")) {
                    this.dingdan = "19.90";
                    this.f4262 = "20元";
                    this.f4248e = Integer.toString(ConvHelpers.byte2integer((byte) 20));
                }
                if (this.aav[0].equals("6")) {
                    this.dingdan = "29.85";
                    this.f4262 = "30元";
                    this.f4248e = Integer.toString(ConvHelpers.byte2integer((byte) 30));
                }
                if (this.aav[0].equals("7")) {
                    this.dingdan = "49.75";
                    this.f4262 = "50元";
                    this.f4248e = Integer.toString(ConvHelpers.byte2integer((byte) 50));
                }
                if (this.aav[0].equals("8")) {
                    this.dingdan = "99.5";
                    this.f4262 = "100元";
                    this.f4248e = Integer.toString(ConvHelpers.byte2integer((byte) 100));
                }
                if (StringVariant.getStringVariant(this.aav[3]).cmp(ByteVariant.getByteVariant((byte) 2)) == 0) {
                    this.f4251ok1.mo1425((int) C0893.m6861(DoubleVariant.getDoubleVariant(C0899.m6943(this.dingdan)).mul(ByteVariant.getByteVariant((byte) 100)).getDouble(), 0), this.aav[1], "http://www.chengshiyouxi.com/pay/notify.php", this.aav[1]);
                }
                if (StringVariant.getStringVariant(this.aav[3]).cmp(ByteVariant.getByteVariant((byte) 1)) == 0) {
                    this.dingdan = this.aav[0];
                    this.f4251ok1.mo1425((int) C0893.m6861(DoubleVariant.getDoubleVariant(C0899.m6943(this.dingdan)).mul(ByteVariant.getByteVariant((byte) 100)).getDouble(), 0), this.aav[1], "http://www.chengshiyouxi.com/pay/notify1.php", this.aav[1]);
                }
                if (this.aav[3].equals("5")) {
                    this.dingdan = this.aav[0];
                    this.f4251ok1.mo1425((int) C0893.m6861(DoubleVariant.getDoubleVariant(C0899.m6943(this.dingdan)).mul(ByteVariant.getByteVariant((byte) 100)).getDouble(), 0), this.aav[1], "http://www.chengshiyouxi.com/pay/notify2.php", this.aav[1]);
                }
            }
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 窗口8$切换完毕 */
    public void m53448$() {
        String huo = bi_常量类.f6358b;
        String huoo = bi_常量类.f6358b;
        if (C0898_读写设置类.m6937_通过SP读取设置("购物").cmp(StringVariant.getStringVariant(C0108a.f262e)) == 0) {
            this.f42601.mo976(C0897_网络操作.m6922(this.wl + "/gouwu/gouwu.txt", "UTF-8", 5000));
            C0898_读写设置类.m6935_通过SP保存设置("购物", StringVariant.getStringVariant("0"));
        } else if (C0898_读写设置类.m6937_通过SP读取设置("买卡").cmp(StringVariant.getStringVariant(C0108a.f262e)) == 0) {
            this.f42601.mo976(C0897_网络操作.m6922(this.wl + "/gouwu/maika.txt", "UTF-8", 5000));
            C0898_读写设置类.m6935_通过SP保存设置("买卡", StringVariant.getStringVariant("0"));
        } else {
            if (C0898_读写设置类.m6937_通过SP读取设置("冠名").cmp(StringVariant.getStringVariant(C0108a.f262e)) == 0) {
                this.f4252x = "5";
                this.f42601.mo976(this.wl + "/guanming/index.html");
            } else {
                huo = C0897_网络操作.m6922(this.wl + "/huo.txt", "UTF-8", 5000);
                if (C0890_文本操作.m6816(huo, 4).equals("http")) {
                    this.f42601.mo976(huo);
                } else {
                    C0880_应用操作类.m6694("网络不稳定");
                    C0898_读写设置类.m6935_通过SP保存设置("冠名", StringVariant.getStringVariant("0"));
                    C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
                }
            }
            C0898_读写设置类.m6935_通过SP保存设置("冠名", StringVariant.getStringVariant("0"));
        }
    }

    /* renamed from: 图片框1$被单击 */
    public void m53411$() {
        String str = bi_常量类.f6358b;
        try {
            String huo = bi_常量类.f6358b;
            if (C0890_文本操作.m6816(C0897_网络操作.m6922(this.wl + "/huo.txt", "UTF-8", 5000), 4).equals("http")) {
                this.f42601.mo976(this.wl + "/shouji/index2.html");
                return;
            }
            C0880_应用操作类.m6694("网络不稳定");
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: ok微信支付1$支付失败 */
    public void m5338ok1$() {
        C0880_应用操作类.m6694("支付失败");
    }

    /* renamed from: ok微信支付1$生成预支付订单号完毕 */
    public void m5340ok1$(String 订单号) {
        this.f4251ok1.mo1418(订单号);
    }

    /* renamed from: ok微信支付1$支付成功 */
    public void m5339ok1$() {
        C0880_应用操作类.m6694("支付成功");
        this.f42601.mo976((((((this.wl + "/guanming/ok.asp?name=") + this.dingdan) + "&zhi=") + this.aav[1]) + "&bei=") + this.aav[2]);
    }

    /* renamed from: 图片框3$被单击 */
    public void m53423$() {
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }
}
