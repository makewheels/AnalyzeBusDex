package com.tencent.mm.sdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.p048b.C1050a;
import com.tencent.mm.sdk.p048b.C1052b;

public class PayReq extends BaseReq {
    private static final int EXTDATA_MAX_LENGTH = 1024;
    private static final String TAG = "MicroMsg.PaySdk.PayReq";
    public String appId;
    public String extData;
    public String nonceStr;
    public Options options;
    public String packageValue;
    public String partnerId;
    public String prepayId;
    public String sign;
    public String signType;
    public String timeStamp;

    public static class Options {
        public static final int INVALID_FLAGS = -1;
        public String callbackClassName;
        public int callbackFlags = -1;

        public void fromBundle(Bundle bundle) {
            this.callbackClassName = C1050a.m7509b(bundle, "_wxapi_payoptions_callback_classname");
            this.callbackFlags = C1050a.m7508a(bundle, "_wxapi_payoptions_callback_flags");
        }

        public void toBundle(Bundle bundle) {
            bundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
            bundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
        }
    }

    public boolean checkArgs() {
        if (this.appId == null || this.appId.length() == 0) {
            C1052b.m7515b(TAG, "checkArgs fail, invalid appId");
            return false;
        } else if (this.partnerId == null || this.partnerId.length() == 0) {
            C1052b.m7515b(TAG, "checkArgs fail, invalid partnerId");
            return false;
        } else if (this.prepayId == null || this.prepayId.length() == 0) {
            C1052b.m7515b(TAG, "checkArgs fail, invalid prepayId");
            return false;
        } else if (this.nonceStr == null || this.nonceStr.length() == 0) {
            C1052b.m7515b(TAG, "checkArgs fail, invalid nonceStr");
            return false;
        } else if (this.timeStamp == null || this.timeStamp.length() == 0) {
            C1052b.m7515b(TAG, "checkArgs fail, invalid timeStamp");
            return false;
        } else if (this.packageValue == null || this.packageValue.length() == 0) {
            C1052b.m7515b(TAG, "checkArgs fail, invalid packageValue");
            return false;
        } else if (this.sign == null || this.sign.length() == 0) {
            C1052b.m7515b(TAG, "checkArgs fail, invalid sign");
            return false;
        } else if (this.extData == null || this.extData.length() <= EXTDATA_MAX_LENGTH) {
            return true;
        } else {
            C1052b.m7515b(TAG, "checkArgs fail, extData length too long");
            return false;
        }
    }

    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.appId = C1050a.m7509b(bundle, "_wxapi_payreq_appid");
        this.partnerId = C1050a.m7509b(bundle, "_wxapi_payreq_partnerid");
        this.prepayId = C1050a.m7509b(bundle, "_wxapi_payreq_prepayid");
        this.nonceStr = C1050a.m7509b(bundle, "_wxapi_payreq_noncestr");
        this.timeStamp = C1050a.m7509b(bundle, "_wxapi_payreq_timestamp");
        this.packageValue = C1050a.m7509b(bundle, "_wxapi_payreq_packagevalue");
        this.sign = C1050a.m7509b(bundle, "_wxapi_payreq_sign");
        this.extData = C1050a.m7509b(bundle, "_wxapi_payreq_extdata");
        this.signType = C1050a.m7509b(bundle, "_wxapi_payreq_sign_type");
        this.options = new Options();
        this.options.fromBundle(bundle);
    }

    public int getType() {
        return 5;
    }

    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putString("_wxapi_payreq_appid", this.appId);
        bundle.putString("_wxapi_payreq_partnerid", this.partnerId);
        bundle.putString("_wxapi_payreq_prepayid", this.prepayId);
        bundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
        bundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
        bundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
        bundle.putString("_wxapi_payreq_sign", this.sign);
        bundle.putString("_wxapi_payreq_extdata", this.extData);
        bundle.putString("_wxapi_payreq_sign_type", this.signType);
        if (this.options != null) {
            this.options.toBundle(bundle);
        }
    }
}
