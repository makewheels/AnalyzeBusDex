package com.chedaole;

import com.e4a.runtime.C0843;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
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
import com.e4a.runtime.components.impl.android.n15.C0698;
import com.e4a.runtime.components.impl.android.n15.C0713Impl;
import com.e4a.runtime.components.impl.android.n3.C0723;
import com.e4a.runtime.components.impl.android.n3.C0725Impl;
import com.e4a.runtime.components.impl.android.n4.C0739;
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
/* compiled from: 窗口7.code */
/* renamed from: com.chedaole.窗口7 */
public class C06587 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口7 */
    public static C0644 f42347;
    @SimpleDataElement
    /* renamed from: f */
    public String f4235f = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: i */
    public int f4236i;
    @SimpleDataElement
    /* renamed from: s */
    public String f4237s = bi_常量类.f6358b;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b;
    @SimpleDataElement
    /* renamed from: 启动时间 */
    public long f4238;
    @SimpleDataElement
    /* renamed from: 图片框1 */
    public C0739 f42391;
    @SimpleDataElement
    /* renamed from: 图片框2 */
    public C0739 f42402;
    @SimpleDataElement
    /* renamed from: 图片框3 */
    public C0739 f42413;
    @SimpleDataElement
    /* renamed from: 图片框4 */
    public C0739 f42424;
    @SimpleDataElement
    /* renamed from: 图片框6 */
    public C0739 f42436;
    @SimpleDataElement
    /* renamed from: 标签1 */
    public C0723 f42441;
    @SimpleDataElement
    /* renamed from: 浏览框1 */
    public C0698 f42451;

    public C06587() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f42347 = this;
        f42347.mo840("E4A");
        f42347.mo797(0);
        f42347.m5096(IntegerVariant.getIntegerVariant(4));
        f42347.mo838(1);
        f42347.mo826(false);
        C0713Impl c0713Impl = new C0713Impl(f42347);
        Objects.initializeProperties(c0713Impl);
        this.f42451 = c0713Impl;
        this.f42451.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42451.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.041d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42451.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42451.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.97d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42451.mo776(true);
        C0742Impl c0742Impl = new C0742Impl(f42347);
        Objects.initializeProperties(c0742Impl);
        this.f42413 = c0742Impl;
        this.f42413.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42413.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42413.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42413.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42413.mo797(-16742145);
        this.f42413.mo1143(1);
        this.f42413.mo1139("VAL.jpg");
        this.f42413.mo776(true);
        c0742Impl = new C0742Impl(f42347);
        Objects.initializeProperties(c0742Impl);
        this.f42391 = c0742Impl;
        this.f42391.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.9d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42391.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.019d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42391.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42391.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.046d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42391.mo797(0);
        this.f42391.mo1143(1);
        this.f42391.mo1139("TRT.png");
        this.f42391.mo776(true);
        c0742Impl = new C0742Impl(f42347);
        Objects.initializeProperties(c0742Impl);
        this.f42436 = c0742Impl;
        this.f42436.mo782((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42436.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.919d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42436.mo780((int) C0893.m6855(ByteVariant.getByteVariant((byte) 1).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42436.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42436.mo797(-1);
        this.f42436.mo1143(1);
        this.f42436.mo776(true);
        c0742Impl = new C0742Impl(f42347);
        Objects.initializeProperties(c0742Impl);
        this.f42424 = c0742Impl;
        this.f42424.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.567d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42424.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.929d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42424.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.256d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42424.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.053d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42424.mo797(0);
        this.f42424.mo1143(1);
        this.f42424.mo1139("ZR.jpg");
        this.f42424.mo776(true);
        c0742Impl = new C0742Impl(f42347);
        Objects.initializeProperties(c0742Impl);
        this.f42402 = c0742Impl;
        this.f42402.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.15d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42402.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.932d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42402.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.256d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42402.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.053d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42402.mo797(0);
        this.f42402.mo1143(1);
        this.f42402.mo1139("ZEE.jpg");
        this.f42402.mo776(true);
        C0725Impl c0725Impl = new C0725Impl(f42347);
        Objects.initializeProperties(c0725Impl);
        this.f42441 = c0725Impl;
        this.f42441.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.163d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42441.mo804((int) C0893.m6855(ByteVariant.getByteVariant((byte) 0).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42441.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.667d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f42441.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.083d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f42441.mo895(bi_常量类.f6358b);
        this.f42441.mo797(0);
        this.f42441.mo889(-1);
        this.f42441.mo896(false);
        this.f42441.mo892(false);
        this.f42441.mo891(7);
        this.f42441.mo1049(12.0f);
        this.f42441.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f42441.mo776(true);
        EventDispatcher.registerEvent(this, "图片框4", "被单击");
        EventDispatcher.registerEvent(this, "图片框2", "被单击");
        EventDispatcher.registerEvent(this, "窗口7", "创建完毕");
        EventDispatcher.registerEvent(this, "图片框3", "被单击");
        EventDispatcher.registerEvent(this, "窗口7", "按下某键");
        EventDispatcher.registerEvent(this, "浏览框1", "接口事件");
        EventDispatcher.registerEvent(this, "图片框1", "被单击");
        EventDispatcher.registerEvent(this, "浏览框1", "即将跳转");
        f42347.mo765();
        this.f42451.mo765();
        this.f42413.mo765();
        this.f42391.mo765();
        this.f42436.mo765();
        this.f42424.mo765();
        this.f42402.mo765();
        this.f42441.mo765();
    }

    /* renamed from: 窗口7$创建完毕 */
    public void m53367$() {
        this.f42451.mo960JS("jiang");
        this.wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
        this.f4235f = C0897_网络操作.m6922(this.wl + "/choujiang.txt", "utf-8", 5000);
        this.f42451.mo976(this.f4235f);
        this.f4236i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
        this.f42441.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) this.f4236i), ".0", bi_常量类.f6358b));
    }

    /* renamed from: 取像素 */
    public int m5329(int 像素) {
        return IntegerVariant.getIntegerVariant(像素).mul(DoubleVariant.getDoubleVariant((((double) C0894.m6882()) / 2.0d) / 240.0d)).getInteger();
    }

    /* renamed from: 浏览框1$接口事件 */
    public void m53351$(String 网页消息) {
        if (网页消息.equals("run")) {
            if (!C0889_文件操作.m6797(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt")) {
                C0889_文件操作.m6783(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt");
            }
            this.f4236i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
            if (IntegerVariant.getIntegerVariant(this.f4236i).cmp(ShortVariant.getShortVariant((short) 200)) >= 0) {
                this.f42451.mo976("javascript:run()");
                this.f4236i = IntegerVariant.getIntegerVariant(this.f4236i).sub(ShortVariant.getShortVariant((short) 200)).getInteger();
                this.f42441.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) this.f4236i), ".0", bi_常量类.f6358b));
                C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) this.f4236i), "yangbosen123"), "UTF-8");
            } else if (IntegerVariant.getIntegerVariant(C0879.m66692("提示", "您的积分不足200分,不能参加抽奖", "如何获取积分", "退出")).cmp(ByteVariant.getByteVariant((byte) 0)) == 0) {
                C0897_网络操作.m6927_打开指定网址(this.wl + "/hexin.html");
                return;
            } else {
                return;
            }
        }
        if (网页消息.equals("5")) {
            this.f4236i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
            this.f4236i = IntegerVariant.getIntegerVariant(this.f4236i).add(ByteVariant.getByteVariant((byte) 100)).getInteger();
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) this.f4236i), "yangbosen123"), "UTF-8");
            this.f42441.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) this.f4236i), ".0", bi_常量类.f6358b));
            C0879.m6668("奖品", "获得100积分", "确定");
        } else if (网页消息.equals("8")) {
            this.f4236i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
            this.f4236i = IntegerVariant.getIntegerVariant(this.f4236i).add(ByteVariant.getByteVariant((byte) 30)).getInteger();
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) this.f4236i), "yangbosen123"), "UTF-8");
            this.f42441.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) this.f4236i), ".0", bi_常量类.f6358b));
            C0879.m6668("奖品", "获得30积分", "确定");
        } else if (网页消息.equals("11")) {
            this.f4236i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
            this.f4236i = IntegerVariant.getIntegerVariant(this.f4236i).add(ShortVariant.getShortVariant((short) 500)).getInteger();
            C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) this.f4236i), "yangbosen123"), "UTF-8");
            this.f42441.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) this.f4236i), ".0", bi_常量类.f6358b));
            C0879.m6668("奖品", "获得500积分", "确定");
        } else {
            if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页消息, "fanxian", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                C0880_应用操作类.m6694(网页消息);
                this.f4237s = C0890_文本操作.m6819(网页消息, "fanxian", bi_常量类.f6358b);
                this.f4236i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
                this.f4236i += C0899.m6944(this.f4237s);
                C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) this.f4236i), "yangbosen123"), "UTF-8");
                this.f42441.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) this.f4236i), ".0", bi_常量类.f6358b));
            }
            if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(网页消息, "jianfenok", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
                this.f4237s = C0890_文本操作.m6819(网页消息, "jianfen", bi_常量类.f6358b);
                this.f4236i = (int) C0899.m6943(C0843.m6604Authcode(C0889_文件操作.m6802(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", "UTF-8"), "yangbosen123"));
                C0880_应用操作类.m6694("积分已经清空");
                this.f4236i -= C0899.m6944(Integer.toString(this.f4236i));
                C0889_文件操作.m6781_写出文本文件(C0852_存储卡类.m6665_取存储卡路径() + "/Android/tents.txt", C0843.m6603Authcode(C0899.m6945((double) this.f4236i), "yangbosen123"), "UTF-8");
                this.f42441.mo895(C0890_文本操作.m6819("我的积分：" + C0899.m6945((double) this.f4236i), ".0", bi_常量类.f6358b));
            }
        }
    }

    /* renamed from: 窗口7$按下某键 */
    public void m53377$(int i, BooleanReferenceParameter booleanReferenceParameter) {
        boolean 屏蔽 = booleanReferenceParameter.get();
        if (i == 4) {
            if (LongVariant.getLongVariant(C0891.m6826() - this.f4238).cmp(ShortVariant.getShortVariant((short) 2000)) > 0) {
                this.f4238 = C0891.m6826();
                this.f4235f = C0897_网络操作.m6922(this.wl + "/choujiang.txt", "utf-8", 5000);
                this.f42451.mo976(this.f4235f);
                this.f42402.mo776(true);
                this.f42402.mo774(true);
                this.f42424.mo776(true);
                this.f42424.mo774(true);
                this.f42436.mo776(true);
                this.f42436.mo774(true);
            } else {
                C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
            }
        }
        booleanReferenceParameter.set(屏蔽);
    }

    /* renamed from: 图片框1$被单击 */
    public void m53301$() {
        this.f4235f = C0897_网络操作.m6922(this.wl + "/choujiang.txt", "utf-8", 5000);
        this.f42451.mo976(this.f4235f);
        this.f42402.mo776(true);
        this.f42402.mo774(true);
        this.f42424.mo776(true);
        this.f42424.mo774(true);
        this.f42436.mo776(true);
        this.f42436.mo774(true);
    }

    /* renamed from: 图片框2$被单击 */
    public void m53312$() {
        this.f42402.mo776(false);
        this.f42402.mo774(false);
        this.f42436.mo776(false);
        this.f42436.mo774(false);
        this.f42424.mo776(false);
        this.f42424.mo774(false);
        this.f42451.mo976(this.wl + "/web/jifenshuoming.html");
    }

    /* renamed from: 浏览框1$即将跳转 */
    public void m53341$(String str, IntegerReferenceParameter integerReferenceParameter) {
        int 方式 = integerReferenceParameter.get();
        if (IntegerVariant.getIntegerVariant(C0890_文本操作.m6821(str, "chou", 0)).cmp(ByteVariant.getByteVariant((byte) 0)) > 0) {
            this.f42402.mo776(true);
            this.f42402.mo774(true);
            this.f42424.mo776(true);
            this.f42424.mo774(true);
            this.f42436.mo776(true);
            this.f42436.mo774(true);
        }
        integerReferenceParameter.set(方式);
    }

    /* renamed from: 图片框4$被单击 */
    public void m53334$() {
        this.f42402.mo776(false);
        this.f42402.mo774(false);
        this.f42424.mo776(false);
        this.f42424.mo774(false);
        this.f42436.mo776(false);
        this.f42436.mo774(false);
        this.f42451.mo976(this.wl + "/web/jifenlingqu.html");
    }

    /* renamed from: 图片框3$被单击 */
    public void m53323$() {
        C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
    }
}
