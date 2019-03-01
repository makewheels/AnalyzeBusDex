package com.chedaole;

import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.C0843_加密操作;
import com.e4a.runtime.C0852_存储卡类;
import com.e4a.runtime.C0879;
import com.e4a.runtime.C0880_应用操作类;
import com.e4a.runtime.C0889_文件操作;
import com.e4a.runtime.C0890_文本操作;
import com.e4a.runtime.C0893;
import com.e4a.runtime.C0894;
import com.e4a.runtime.C0898_读写设置类;
import com.e4a.runtime.Objects;
import com.e4a.runtime.annotations.SimpleDataElement;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.n2.C0717;
import com.e4a.runtime.components.impl.android.n2.C0722Impl;
import com.e4a.runtime.components.impl.android.n42.C0743;
import com.e4a.runtime.components.impl.android.n42.C0752Impl;
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
/* compiled from: 窗口2.code */
/* renamed from: com.chedaole.窗口2 */
public class C06532_有初始化功能 extends C0645Impl {
    @SimpleDataElement
    /* renamed from: 窗口2 */
    public static C0644 f41262;
    @SimpleDataElement
    public String wl = bi_常量类.f6358b_空串;
    @SimpleDataElement
    public String zz = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 启动时间 */
    public int f4127;
    @SimpleDataElement
    /* renamed from: 地址 */
    public String f4128 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 坐标 */
    public String f4129 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 多线程1 */
    public C0743 f41301;
    @SimpleDataElement
    /* renamed from: 广告 */
    public String f4131 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 时间 */
    public String f4132 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 站点 */
    public String f4133_站点 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 线路 */
    public String f4134 = bi_常量类.f6358b_空串;
    @SimpleDataElement
    /* renamed from: 编辑框1 */
    public C0717 f41351;
    @SimpleDataElement
    /* renamed from: 起始 */
    public String f4136 = bi_常量类.f6358b_空串;

    public C06532_有初始化功能() {
        Objects.initializeProperties(this);
        $define();
    }

    public void $define() {
        f41262 = this;
        f41262.mo840("车到了");
        f41262.mo797_背景颜色(0);
        f41262.m5096(IntegerVariant.getIntegerVariant(4));
        f41262.mo838(1);
        f41262.mo826(false);
        C0752Impl c0752Impl = new C0752Impl(f41262);
        Objects.initializeProperties(c0752Impl);
        this.f41301 = c0752Impl;
        C0722Impl c0722Impl = new C0722Impl(f41262);
        Objects.initializeProperties(c0722Impl);
        this.f41351 = c0722Impl;
        this.f41351.mo782((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.25d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41351.mo804((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.165d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41351.mo780((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.383d).mul(IntegerVariant.getIntegerVariant(C0894.m6882()))));
        this.f41351.mo806((int) C0893.m6855(DoubleVariant.getDoubleVariant(0.299d).mul(IntegerVariant.getIntegerVariant(C0894.m6884() - C0894.m6885()))));
        this.f41351.mo887_内容(bi_常量类.f6358b_空串);
        this.f41351.mo889_字体颜色(-16777216);
        this.f41351.mo896(false);
        this.f41351.mo892(false);
        this.f41351.mo1020(9.0f);
        this.f41351.mo774(true);
        this.f41351.mo1041(4);
        this.f41351.mo891_对齐方式(3);
        this.f41351.mo772(true);
        this.f41351.mo1035(bi_常量类.f6358b_空串);
        this.f41351.mo899(WebView.NORMAL_MODE_ALPHA);
        this.f41351.mo776_可视(false);
        EventDispatcher.registerEvent(this, "窗口2", "按下某键");
        EventDispatcher.registerEvent(this, "窗口2", "切换完毕");
        EventDispatcher.registerEvent(this, "窗口2", "创建完毕");
        EventDispatcher.registerEvent(this, "多线程1", "取网页源码完毕");
        f41262.mo765();
        this.f41301.mo765();
        this.f41351.mo765();
    }

    /* renamed from: 窗口2$创建完毕 */
    public void m52672$() {
    }

    /* renamed from: 获取车信息 */
    public void m5269() {
        String str = bi_常量类.f6358b_空串;
        str = bi_常量类.f6358b_空串;
        try {
            String 路线 = bi_常量类.f6358b_空串;
            String 内容 = bi_常量类.f6358b_空串;
            内容 = C0843_加密操作.m6604Authcode_Authcode解密(this.f41351.mo886_内容(),
            		"199071lh@zhaoqianwangpengluzhipengliuxueyingzhangdeiqian");
            this.f4133_站点 = m5264(内容, "路开", "路束");
            this.f4129 = m5264(内容, "|1|", "|1|");
            this.f4128 = m5264(内容, "地开", "地束");
            this.f4136 = m5264(内容, "目开", "目束");
            this.f4132 = m5264(内容, "时开", "时束");
            this.f4131 = m5264(内容, "广告开", "广告束");
            C0898_读写设置类.m6935_通过SP保存设置("地址", StringVariant.getStringVariant(this.f4128));
            C0898_读写设置类.m6935_通过SP保存设置("起始", StringVariant.getStringVariant(this.f4136));
            C0898_读写设置类.m6935_通过SP保存设置("站点", StringVariant.getStringVariant(this.f4133_站点));
            C0898_读写设置类.m6935_通过SP保存设置("坐标", StringVariant.getStringVariant(this.f4129));
            C0898_读写设置类.m6935_通过SP保存设置("时间", StringVariant.getStringVariant(this.f4132));
            if (this.f4131.equals(bi_常量类.f6358b_空串)) {
                C0898_读写设置类.m6935_通过SP保存设置("广告", StringVariant.getStringVariant(bi_常量类.f6358b_空串));
            } else {
                C0898_读写设置类.m6935_通过SP保存设置("广告", StringVariant.getStringVariant(this.f4131));
            }
            if (C0880_应用操作类.m6712("正窗口") == null) {
                C0880_应用操作类.m6692("正窗口", new C06521_详情页());
            }
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("正窗口"));
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 取中间文本 */
    public String m5264(String 完整内容, String 左边文本, String 右边文本) {
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

    /* renamed from: 多线程1$取网页源码完毕 */
    public void m52651$(String 源码) {
        try {
            if (源码.equals(bi_常量类.f6358b_空串)) {
                C0879.m6671();
                C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
                return;
            }
            C0889_文件操作.m6781_写出文本文件(((((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/") + this.f4134) + ".TXT", 源码, "GBK");
            this.f41351.mo887_内容(源码);
            C0879.m6671();
            m5269();
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }

    /* renamed from: 窗口2$按下某键 */
    public void m52682$(int i, BooleanReferenceParameter booleanReferenceParameter) {
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

    /* renamed from: 窗口2$切换完毕 */
    public void m52662$() {
        String str = bi_常量类.f6358b_空串;
        str = bi_常量类.f6358b_空串;
        str = bi_常量类.f6358b_空串;
        try {
            String wl = bi_常量类.f6358b_空串;
            String c = bi_常量类.f6358b_空串;
            String wlw = bi_常量类.f6358b_空串;
            this.zz = C0898_读写设置类.m6937_通过SP读取设置("成").getString();
            if (C0898_读写设置类.m6937_通过SP读取设置("小年").getString().equals(C0108a.f262e)) {
                C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("过"));
                return;
            }
            wl = C0898_读写设置类.m6937_通过SP读取设置("网").getString();
            this.f4134 = C0898_读写设置类.m6937_通过SP读取设置("线路").getString();
            this.f4134 = C0890_文本操作.m6819(this.f4134, "fF", bi_常量类.f6358b_空串);
            this.f4134 = C0890_文本操作.m6819(this.f4134, "ff", bi_常量类.f6358b_空串);
            if (C0889_文件操作.m6797(((((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/") + this.f4134) + ".TXT")) {
                this.f41351.mo887_内容(C0889_文件操作.m6802(((((C0852_存储卡类.m6665_取存储卡路径() + "/cityisba/") + this.zz) + "/") + this.f4134) + ".TXT", "GBK"));
                m5269();
                return;
            }
            C0880_应用操作类.m6694("这个路线暂时没有开通");
            C0880_应用操作类.m6693_切换窗口(C0880_应用操作类.m6712("窗口3"));
        } catch (Throwable th) {
            RuntimeError.convertToRuntimeError(th);
        }
    }
}
