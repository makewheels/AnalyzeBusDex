package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.p048b.C1060h;

public class JoinChatroom {

    public static class Req extends BaseReq {
        public String chatroomNickName;
        public String extMsg;
        public String groupId;

        public boolean checkArgs() {
            return !C1060h.m7530h(this.groupId);
        }

        public int getType() {
            return 15;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_group_id", this.groupId);
            bundle.putString("_wxapi_join_chatroom_chatroom_nickname", this.chatroomNickName);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
        }
    }

    public static class Resp extends BaseResp {
        public String extMsg;

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        public boolean checkArgs() {
            return true;
        }

        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.extMsg = bundle.getString("_wxapi_join_chatroom_ext_msg");
        }

        public int getType() {
            return 15;
        }

        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_join_chatroom_ext_msg", this.extMsg);
        }
    }

    private JoinChatroom() {
    }
}
