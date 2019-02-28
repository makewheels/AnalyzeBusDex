package com.e4a.runtime.components.impl.android.p019;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.e4a.runtime.components.impl.android.支付宝免签约支付类库.支付宝免签约支付Impl */
public class C0812Impl extends ComponentImpl implements C0811 {
    private Bitmap bitmap;
    private String payurl;

    public C0812Impl(ComponentContainer componentContainer) {
        super(componentContainer);
    }

    /* renamed from: 初始化 */
    public void mo1454(String str) {
        if (str.length() <= 0) {
            this.bitmap = null;
        } else if (!str.startsWith("/")) {
            try {
                this.bitmap = ((BitmapDrawable) Drawable.createFromStream(mainActivity.getContext().getResources().getAssets().open(str), str)).getBitmap();
            } catch (IOException e) {
                this.bitmap = null;
            }
        } else if (new File(str).exists()) {
            this.bitmap = BitmapFactory.decodeFile(str);
        } else {
            this.bitmap = null;
        }
        Map hashMap = new HashMap();
        hashMap.put(DecodeHintType.CHARACTER_SET, "utf-8");
        try {
            this.payurl = new QRCodeReader().decode(new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(this.bitmap))), hashMap).getText();
        } catch (Exception e2) {
            this.payurl = null;
            e2.printStackTrace();
        }
    }

    /* renamed from: 开始支付 */
    public void mo1455() {
        if (this.payurl != null) {
            mainActivity.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=" + this.payurl + "#Intent;scheme=alipayqr;package=com.eg.android.AlipayGphone;end")));
        }
    }
}
