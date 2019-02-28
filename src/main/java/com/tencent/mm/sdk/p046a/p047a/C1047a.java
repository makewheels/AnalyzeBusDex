package com.tencent.mm.sdk.p046a.p047a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.p048b.C1052b;
import com.tencent.mm.sdk.p048b.C1060h;

/* renamed from: com.tencent.mm.sdk.a.a.a */
public final class C1047a {

    /* renamed from: com.tencent.mm.sdk.a.a.a$a */
    public static class C1046a {
        /* renamed from: Y */
        public String f4776Y;
        /* renamed from: Z */
        public Bundle f4777Z;
        public String aa;
        public String ab;
    }

    /* renamed from: a */
    public static boolean m7505a(Context context, C1046a c1046a) {
        if (context == null) {
            C1052b.m7515b("MicroMsg.SDK.MMessage", "send fail, invalid argument");
            return false;
        } else if (C1060h.m7530h(c1046a.ab)) {
            C1052b.m7515b("MicroMsg.SDK.MMessage", "send fail, action is null");
            return false;
        } else {
            String str = null;
            if (!C1060h.m7530h(c1046a.aa)) {
                str = c1046a.aa + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(c1046a.ab);
            if (c1046a.f4777Z != null) {
                intent.putExtras(c1046a.f4777Z);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c1046a.f4776Y);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C1048b.m7506a(c1046a.f4776Y, 587268097, packageName));
            context.sendBroadcast(intent, str);
            C1052b.m7518e("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str);
            return true;
        }
    }
}
