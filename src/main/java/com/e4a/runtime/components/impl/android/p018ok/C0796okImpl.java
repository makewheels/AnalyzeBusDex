package com.e4a.runtime.components.impl.android.p018ok;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Xml;
import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;
import com.fanke.fansbox.wxapi.Constants;
import com.fanke.fansbox.wxapi.WXPayEntryActivity;
import com.iflytek.cloud.speech.SpeechConstant;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.umeng.analytics.onlineconfig.C1248a;
import java.io.StringReader;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.xmlpull.v1.XmlPullParser;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.ok微信支付类库.ok微信支付Impl */
public class C0796okImpl extends ComponentImpl implements C0794ok {
    public IWXAPI api = WXAPIFactory.createWXAPI(mainActivity.getContext(), Constants.APP_ID);
    Handler fanhui2 = new C07951();
    PayReq req;
    /* renamed from: 商品描述 */
    String f4327 = "微信支付";
    /* renamed from: 回调地址 */
    String f4328 = bi_常量类.f6358b_空串;
    /* renamed from: 支付金额 */
    String f4329 = C0108a.f262e;
    /* renamed from: 透传参数 */
    String f4330 = bi_常量类.f6358b_空串;

    /* renamed from: com.e4a.runtime.components.impl.android.ok微信支付类库.ok微信支付Impl$1 */
    class C07951 extends Handler {
        C07951() {
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                C0796okImpl.this.mo1421();
            } else {
                C0796okImpl.this.mo1420();
            }
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.ok微信支付类库.ok微信支付Impl$GetPrepayIdTask */
    class GetPrepayIdTask extends AsyncTask<Void, Void, Map<String, String>> {
        private ProgressDialog dialog;

        GetPrepayIdTask() {
        }

        protected void onPreExecute() {
            this.dialog = ProgressDialog.show(mainActivity.getContext(), "提示", "正在获取预支付订单...");
        }

        protected void onPostExecute(Map<String, String> map) {
            if (this.dialog != null) {
                this.dialog.dismiss();
            }
            String str = bi_常量类.f6358b_空串;
            try {
                str = ((String) map.get("prepay_id")).toString();
            } catch (Exception e) {
                e.printStackTrace();
                str = bi_常量类.f6358b_空串;
            }
            if (str.length() == 0) {
                C0796okImpl.this.mo1423(C0796okImpl.this.geturls(map));
            } else {
                C0796okImpl.this.mo1422(str);
            }
        }

        protected void onCancelled() {
            super.onCancelled();
        }

        protected Map<String, String> doInBackground(Void[] voidArr) {
            return C0796okImpl.this.decodeXml(new String(Util.httpPost(String.format("https://api.mch.weixin.qq.com/pay/unifiedorder", new Object[0]), C0796okImpl.this.genProductArgs())));
        }
    }

    public C0796okImpl(ComponentContainer componentContainer) {
        super(componentContainer);
    }

    /* renamed from: 初始化 */
    public void mo1417(String str, String str2, String str3) {
        Constants.APP_ID = str;
        Constants.WX_API_KEY = str2;
        Constants.WX_MCH_ID = str3;
    }

    /* renamed from: 获取订单 */
    public void mo1425(int i, String str, String str2, String str3) {
        this.f4329 = bi_常量类.f6358b_空串 + i;
        this.f4327 = str;
        this.f4328 = str2;
        this.f4330 = str3;
        if (this.f4328.equals(bi_常量类.f6358b_空串)) {
            this.f4328 = "http://127.0.0.1/test";
        }
        new GetPrepayIdTask().execute(new Void[0]);
    }

    /* renamed from: 当前微信支付可以支付 */
    public boolean mo1419() {
        return this.api.getWXAppSupportAPI() >= 570425345;
    }

    /* renamed from: 置KEY */
    public void mo1424KEY(String str) {
        Constants.WX_API_KEY = str;
    }

    private String geturls(Map<String, String> map) {
        List arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        String str = bi_常量类.f6358b_空串;
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                str = ((String) arrayList.get(i)) + "=" + ((String) map.get(arrayList.get(i)));
            } else {
                str = str + "\n" + ((String) arrayList.get(i)) + "=" + ((String) map.get(arrayList.get(i)));
            }
        }
        return str;
    }

    private String genNonceStr() {
        return getMessageDigest(String.valueOf(new Random().nextInt(10000)).getBytes());
    }

    private String getMessageDigest(byte[] bArr) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    private String genProductArgs() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String genNonceStr = genNonceStr();
            stringBuffer.append("</xml>");
            List linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair(SpeechConstant.APPID, Constants.APP_ID));
            linkedList.add(new BasicNameValuePair("attach", this.f4330));
            linkedList.add(new BasicNameValuePair("body", this.f4327));
            linkedList.add(new BasicNameValuePair("mch_id", Constants.WX_MCH_ID));
            linkedList.add(new BasicNameValuePair("nonce_str", genNonceStr));
            linkedList.add(new BasicNameValuePair("notify_url", this.f4328));
            linkedList.add(new BasicNameValuePair("out_trade_no", genOutTradNo()));
            linkedList.add(new BasicNameValuePair("spbill_create_ip", "127.0.0.1"));
            linkedList.add(new BasicNameValuePair("total_fee", this.f4329));
            linkedList.add(new BasicNameValuePair("trade_type", "APP"));
            linkedList.add(new BasicNameValuePair("sign", genPackageSign(linkedList)));
            return toXml(linkedList);
        } catch (Exception e) {
            return null;
        }
    }

    private String genPackageSign(List<NameValuePair> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(((NameValuePair) list.get(i)).getName());
            stringBuilder.append('=');
            stringBuilder.append(((NameValuePair) list.get(i)).getValue());
            stringBuilder.append('&');
        }
        stringBuilder.append("key=");
        stringBuilder.append(Constants.WX_API_KEY);
        return getMessageDigest(stringBuilder.toString().getBytes()).toUpperCase();
    }

    private String toXml(List<NameValuePair> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append("<" + ((NameValuePair) list.get(i)).getName() + ">");
            stringBuilder.append(((NameValuePair) list.get(i)).getValue());
            stringBuilder.append("</" + ((NameValuePair) list.get(i)).getName() + ">");
        }
        stringBuilder.append("</xml>");
        return stringBuilder.toString();
    }

    private String genAppSign(List<NameValuePair> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(((NameValuePair) list.get(i)).getName());
            stringBuilder.append('=');
            stringBuilder.append(((NameValuePair) list.get(i)).getValue());
            stringBuilder.append('&');
        }
        stringBuilder.append("key=");
        stringBuilder.append(Constants.WX_API_KEY);
        return getMessageDigest(stringBuilder.toString().getBytes()).toUpperCase();
    }

    private String genOutTradNo() {
        return m6472(30);
    }

    /* renamed from: 取随机文本 */
    private String m6472(int i) {
        String str = bi_常量类.f6358b_空串;
        for (int i2 = 0; i2 < i; i2++) {
            if (m6475(1, 2) == 1) {
                str = str + m6473(m6475(97, 102));
            } else {
                str = str + m6473(m6475(48, 57));
            }
        }
        return str;
    }

    /* renamed from: 取随机数 */
    public int m6475(int i, int i2) {
        if (i > i2 || i < 0 || i2 < 0) {
            return -1;
        }
        return (int) ((Math.random() * ((double) ((i2 - i) + 1))) + ((double) i));
    }

    /* renamed from: 字符 */
    private String m6473(int i) {
        return Character.toString((char) i);
    }

    public Map<String, String> decodeXml(String str) {
        try {
            Map<String, String> hashMap = new HashMap();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                switch (eventType) {
                    case 2:
                        if (!"xml".equals(name)) {
                            hashMap.put(name, newPullParser.nextText());
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            return hashMap;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: 开始支付 */
    public void mo1418(String str) {
        WXPayEntryActivity.fanhuiHandler = this.fanhui2;
        this.req = new PayReq();
        this.req.appId = Constants.APP_ID;
        this.req.partnerId = Constants.WX_MCH_ID;
        this.req.prepayId = str;
        this.req.packageValue = "Sign=WXPay";
        this.req.nonceStr = genNonceStr();
        this.req.timeStamp = String.valueOf(genTimeStamp());
        List linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair(SpeechConstant.APPID, this.req.appId));
        linkedList.add(new BasicNameValuePair("noncestr", this.req.nonceStr));
        linkedList.add(new BasicNameValuePair(C1248a.f5655b, this.req.packageValue));
        linkedList.add(new BasicNameValuePair("partnerid", this.req.partnerId));
        linkedList.add(new BasicNameValuePair("prepayid", this.req.prepayId));
        linkedList.add(new BasicNameValuePair("timestamp", this.req.timeStamp));
        this.req.sign = genAppSign(linkedList);
        this.api.registerApp(Constants.APP_ID);
        this.api.sendReq(this.req);
    }

    private long genTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    /* renamed from: 生成预支付订单号完毕 */
    public void mo1422(String str) {
        EventDispatcher.dispatchEvent(this, "生成预支付订单号完毕", str);
    }

    /* renamed from: 生成预支付订单号错误 */
    public void mo1423(String str) {
        EventDispatcher.dispatchEvent(this, "生成预支付订单号错误", str);
    }

    /* renamed from: 支付成功 */
    public void mo1421() {
        EventDispatcher.dispatchEvent(this, "支付成功", new Object[0]);
    }

    /* renamed from: 支付失败 */
    public void mo1420() {
        EventDispatcher.dispatchEvent(this, "支付失败", new Object[0]);
    }
}
