package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.p048b.C1052b;

public class WXTextObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXTextObject";
    public String text;

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String str) {
        this.text = str;
    }

    public boolean checkArgs() {
        if (this.text != null && this.text.length() != 0 && this.text.length() <= LENGTH_LIMIT) {
            return true;
        }
        C1052b.m7515b(TAG, "checkArgs fail, text is invalid");
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    public int type() {
        return 1;
    }

    public void unserialize(Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }
}
