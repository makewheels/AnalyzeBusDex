package com.alipay.security.mobile.module.http;

import android.content.Context;

public class UploadFactory {

    public enum Mode {
        RPC,
        RPC_WALLET,
        RPC_MPASS
    }

    public static IUpload create(Context context, Mode mode) {
        return context == null ? null : RPCUploadImpl.getInstance(context);
    }
}
