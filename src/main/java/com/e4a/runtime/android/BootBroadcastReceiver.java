package com.e4a.runtime.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            Intent startintent = new Intent(context, StartActivity.class);
            startintent.putExtra("参数", "开机启动");
            startintent.addFlags(268435456);
            context.startActivity(startintent);
        }
    }
}
