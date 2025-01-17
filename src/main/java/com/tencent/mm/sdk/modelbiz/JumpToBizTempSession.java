package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.p048b.C1052b;

public final class JumpToBizTempSession {
    public static final int SHOW_CHAT = 1;
    public static final int SHOW_MENU = 0;

    public static class Req extends BaseReq {
        private static final int MAX_SESSION_FROM_LENGTH = 1024;
        private static final String TAG = "MicroMsg.SDK.JumpToBizTempSession.Req";
        public String sessionFrom;
        public int showType;
        public String toUserName;

        public boolean checkArgs() {
            if (this.toUserName == null || this.toUserName.length() <= 0) {
                C1052b.m7515b(TAG, "checkArgs fail, toUserName is invalid");
                return false;
            } else if (this.sessionFrom != null && this.sessionFrom.length() <= MAX_SESSION_FROM_LENGTH) {
                return true;
            } else {
                C1052b.m7515b(TAG, "checkArgs fail, sessionFrom is invalid");
                return false;
            }
        }

        public int getType() {
            return 10;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", this.toUserName);
            bundle.putString("_wxapi_jump_to_biz_webview_req_session_from", this.sessionFrom);
            bundle.putInt("_wxapi_jump_to_biz_webview_req_show_type", this.showType);
        }
    }
}
