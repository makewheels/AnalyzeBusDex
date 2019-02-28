package com.e4a.runtime.components.impl.android.p020;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.支付宝类库.支付宝Impl */
public class C0817Impl extends ComponentImpl implements C0813 {
    public static String PARTNER = bi_常量类.f6358b_空串;
    public static String RSA_PRIVATE = bi_常量类.f6358b_空串;
    private static final int SDK_CHECK_FLAG = 2;
    private static final int SDK_PAY_FLAG = 1;
    public static String SELLER = bi_常量类.f6358b_空串;
    public static String SERVER = bi_常量类.f6358b_空串;
    private Handler mHandler = new C08141();

    /* renamed from: com.e4a.runtime.components.impl.android.支付宝类库.支付宝Impl$1 */
    class C08141 extends Handler {
        C08141() {
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    PayResult payResult = new PayResult((String) message.obj);
                    payResult.getResult();
                    CharSequence resultStatus = payResult.getResultStatus();
                    if (TextUtils.equals(resultStatus, "9000")) {
                        C0817Impl.this.mo1459(1);
                        return;
                    } else if (TextUtils.equals(resultStatus, "8000")) {
                        C0817Impl.this.mo1459(2);
                        return;
                    } else {
                        C0817Impl.this.mo1459(0);
                        return;
                    }
                case 2:
                    C0817Impl.this.mo1460(((Boolean) message.obj).booleanValue());
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.支付宝类库.支付宝Impl$2 */
    class C08152 implements Runnable {
        C08152() {
        }

        public void run() {
            boolean checkAccountIfExist = new PayTask(mainActivity.getContext()).checkAccountIfExist();
            Message message = new Message();
            message.what = 2;
            message.obj = Boolean.valueOf(checkAccountIfExist);
            C0817Impl.this.mHandler.sendMessage(message);
        }
    }

    public C0817Impl(ComponentContainer componentContainer) {
        super(componentContainer);
    }

    /* renamed from: 初始化 */
    public void mo1456(String str, String str2, String str3, String str4) {
        PARTNER = str;
        RSA_PRIVATE = str2;
        SELLER = str3;
        SERVER = str4;
    }

    /* renamed from: 检查账户 */
    public void mo1461() {
        new Thread(new C08152()).start();
    }

    /* renamed from: 取SDK版本 */
    public String mo1457SDK() {
        return new PayTask(mainActivity.getContext()).getVersion();
    }

    /* renamed from: 开始支付 */
    public void mo1458(String str, String str2, String str3, String str4) {
        String orderInfo = getOrderInfo(str, str2, str3, str4);
        String sign = sign(orderInfo);
        try {
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        sign = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();
        new Thread(new Runnable() {
            public void run() {
                String pay = new PayTask(mainActivity.getContext()).pay(sign);
                Message message = new Message();
                message.what = 1;
                message.obj = pay;
                C0817Impl.this.mHandler.sendMessage(message);
            }
        }).start();
    }

    public String getOrderInfo(String str, String str2, String str3, String str4) {
        String str5 = ((((("partner=\"" + PARTNER + "\"") + "&seller_id=\"" + SELLER + "\"") + "&out_trade_no=\"" + str4 + "\"") + "&subject=\"" + str + "\"") + "&body=\"" + str2 + "\"") + "&total_fee=\"" + str3 + "\"";
        if (!SERVER.equals(bi_常量类.f6358b_空串)) {
            str5 = str5 + "&notify_url=\"" + SERVER + "\"";
        }
        return (((str5 + "&service=\"mobile.securitypay.pay\"") + "&payment_type=\"1\"") + "&_input_charset=\"utf-8\"") + "&it_b_pay=\"30m\"";
    }

    public String getOutTradeNo() {
        return (new SimpleDateFormat("MMddHHmmss", Locale.getDefault()).format(new Date()) + new Random().nextInt()).substring(0, 15);
    }

    public String sign(String str) {
        return SignUtils.sign(str, RSA_PRIVATE);
    }

    public String getSignType() {
        return "sign_type=\"RSA\"";
    }

    /* renamed from: 检查完毕 */
    public void mo1460(boolean z) {
        EventDispatcher.dispatchEvent(this, "检查完毕", Boolean.valueOf(z));
    }

    /* renamed from: 支付完毕 */
    public void mo1459(int i) {
        EventDispatcher.dispatchEvent(this, "支付完毕", Integer.valueOf(i));
    }
}
