package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.sdk.p048b.C1052b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

public class WXImageObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    public byte[] imageData;
    public String imagePath;

    public WXImageObject(Bitmap bitmap) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        return file.exists() ? (int) file.length() : 0;
    }

    public boolean checkArgs() {
        if ((this.imageData == null || this.imageData.length == 0) && (this.imagePath == null || this.imagePath.length() == 0)) {
            C1052b.m7515b(TAG, "checkArgs fail, all arguments are null");
            return false;
        } else if (this.imageData != null && this.imageData.length > CONTENT_LENGTH_LIMIT) {
            C1052b.m7515b(TAG, "checkArgs fail, content is too large");
            return false;
        } else if (this.imagePath != null && this.imagePath.length() > PATH_LENGTH_LIMIT) {
            C1052b.m7515b(TAG, "checkArgs fail, path is invalid");
            return false;
        } else if (this.imagePath == null || getFileSize(this.imagePath) <= CONTENT_LENGTH_LIMIT) {
            return true;
        } else {
            C1052b.m7515b(TAG, "checkArgs fail, image content is too large");
            return false;
        }
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public int type() {
        return 2;
    }

    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
    }
}
