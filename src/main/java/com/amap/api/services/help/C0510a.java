package com.amap.api.services.help;

import android.os.Handler;
import android.os.Message;
import java.util.List;

/* compiled from: Inputtips */
/* renamed from: com.amap.api.services.help.a */
class C0510a extends Handler {
    /* renamed from: a */
    final /* synthetic */ Inputtips f3039a;

    C0510a(Inputtips inputtips) {
        this.f3039a = inputtips;
    }

    public void handleMessage(Message message) {
        if (this.f3039a.f3035c != null) {
            List list = null;
            if (message.what == 0) {
                list = (List) message.obj;
            }
            this.f3039a.f3035c.onGetInputtips(list, message.what);
        }
    }
}
