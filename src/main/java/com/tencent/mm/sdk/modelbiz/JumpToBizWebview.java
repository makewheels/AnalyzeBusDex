package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.p048b.C1052b;

public final class JumpToBizWebview {

    public static class Req extends BaseReq {
        private static final int EXT_MSG_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizWebview.Req";
        public String extMsg;
        public int scene = 1;
        public String toUserName;
        public int webType;

        public boolean checkArgs() {
            if (this.toUserName == null || this.toUserName.length() <= 0) {
                C1052b.m7515b(TAG, "checkArgs fail, toUserName is invalid");
                return false;
            } else if (this.extMsg == null || this.extMsg.length() <= EXT_MSG_LENGTH) {
                return true;
            } else {
                C1052b.m7515b(TAG, "ext msg is not null, while the length exceed 1024 bytes");
                return false;
            }
        }

        public int getType() {
            return 8;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", this.extMsg);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", this.webType);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", this.scene);
        }
    }
}
