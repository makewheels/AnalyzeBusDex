package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.p048b.C1052b;
import java.io.File;

public class WXEmojiObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXEmojiObject";
    public byte[] emojiData;
    public String emojiPath;

    public WXEmojiObject() {
        this.emojiData = null;
        this.emojiPath = null;
    }

    public WXEmojiObject(String str) {
        this.emojiPath = str;
    }

    public WXEmojiObject(byte[] bArr) {
        this.emojiData = bArr;
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        return file.exists() ? (int) file.length() : 0;
    }

    public boolean checkArgs() {
        if ((this.emojiData == null || this.emojiData.length == 0) && (this.emojiPath == null || this.emojiPath.length() == 0)) {
            C1052b.m7515b(TAG, "checkArgs fail, both arguments is null");
            return false;
        } else if (this.emojiData != null && this.emojiData.length > CONTENT_LENGTH_LIMIT) {
            C1052b.m7515b(TAG, "checkArgs fail, emojiData is too large");
            return false;
        } else if (this.emojiPath == null || getFileSize(this.emojiPath) <= CONTENT_LENGTH_LIMIT) {
            return true;
        } else {
            C1052b.m7515b(TAG, "checkArgs fail, emojiSize is too large");
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(String str) {
        this.emojiPath = str;
    }

    public int type() {
        return 8;
    }

    public void unserialize(Bundle bundle) {
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }
}
