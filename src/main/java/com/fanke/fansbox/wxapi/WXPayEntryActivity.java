package com.fanke.fansbox.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import com.stub.StubApp;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";
    public static Handler fanhuiHandler = null;
    private IWXAPI api;

    public native void onCreate(Bundle bundle);

    static {
        StubApp.interface11(4);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.api.handleIntent(intent, this);
    }

    public void onReq(BaseReq req) {
    }

    public void onResp(BaseResp resp) {
        Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);
        Message msg2;
        if (resp.errCode == 0) {
            if (fanhuiHandler != null) {
                msg2 = new Message();
                msg2.what = 0;
                fanhuiHandler.sendMessage(msg2);
            } else {
                Toast.makeText(this, "支付成功", 0).show();
            }
        } else if (fanhuiHandler != null) {
            msg2 = new Message();
            msg2.what = resp.errCode;
            fanhuiHandler.sendMessage(msg2);
        } else {
            Toast.makeText(this, "取消支付 : " + resp.errCode, 0).show();
        }
        finish();
    }
}
