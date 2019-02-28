package com.alipay.sdk.widget;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* renamed from: com.alipay.sdk.widget.d */
public final class C0154d {
    /* renamed from: a */
    private static boolean f475a = (VERSION.SDK_INT >= 11);

    /* renamed from: a */
    private static Builder m546a(Context context, String str, OnClickListener onClickListener, String str2, OnClickListener onClickListener2) {
        Builder builder = new Builder(context);
        if (f475a) {
            if (!(TextUtils.isEmpty(str2) || onClickListener2 == null)) {
                builder.setPositiveButton(str2, onClickListener2);
            }
            if (!(TextUtils.isEmpty(str) || onClickListener == null)) {
                builder.setNegativeButton(str, onClickListener);
            }
        } else {
            if (!(TextUtils.isEmpty(str) || onClickListener == null)) {
                builder.setPositiveButton(str, onClickListener);
            }
            if (!(TextUtils.isEmpty(str2) || onClickListener2 == null)) {
                builder.setNegativeButton(str2, onClickListener2);
            }
        }
        return builder;
    }

    /* renamed from: a */
    public static Dialog m547a(Context context, String str, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2) {
        Builder builder = new Builder(context);
        if (f475a) {
            if (!(TextUtils.isEmpty(str4) || onClickListener2 == null)) {
                builder.setPositiveButton(str4, onClickListener2);
            }
            if (!(TextUtils.isEmpty(str3) || onClickListener == null)) {
                builder.setNegativeButton(str3, onClickListener);
            }
        } else {
            if (!(TextUtils.isEmpty(str3) || onClickListener == null)) {
                builder.setPositiveButton(str3, onClickListener);
            }
            if (!(TextUtils.isEmpty(str4) || onClickListener2 == null)) {
                builder.setNegativeButton(str4, onClickListener2);
            }
        }
        builder.setTitle(str);
        builder.setMessage(str2);
        Dialog create = builder.create();
        create.setCanceledOnTouchOutside(false);
        create.setOnKeyListener(new C0155e());
        try {
            create.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return create;
    }
}
