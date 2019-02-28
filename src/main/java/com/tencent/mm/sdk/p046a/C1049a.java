package com.tencent.mm.sdk.p046a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.p046a.p047a.C1048b;
import com.tencent.mm.sdk.p048b.C1052b;
import com.tencent.mm.sdk.p048b.C1060h;

/* renamed from: com.tencent.mm.sdk.a.a */
public final class C1049a {

    /* renamed from: com.tencent.mm.sdk.a.a$a */
    public static class C1047a {
        /* renamed from: W */
        public String f4772W;
        /* renamed from: X */
        public String f4773X;
        /* renamed from: Y */
        public String f4774Y;
        /* renamed from: Z */
        public Bundle f4775Z;
        public int flags = -1;

        public final String toString() {
            return "targetPkgName:" + this.f4772W + ", targetClassName:" + this.f4773X + ", content:" + this.f4774Y + ", flags:" + this.flags + ", bundle:" + this.f4775Z;
        }
    }

    /* renamed from: a */
    public static boolean m7507a(Context context, C1047a c1047a) {
        if (context == null) {
            C1052b.m7515b("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (C1060h.m7530h(c1047a.f4772W)) {
            C1052b.m7515b("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + c1047a.f4772W);
            return false;
        } else {
            if (C1060h.m7530h(c1047a.f4773X)) {
                c1047a.f4773X = c1047a.f4772W + ".wxapi.WXEntryActivity";
            }
            C1052b.m7518e("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + c1047a.f4772W + ", targetClassName = " + c1047a.f4773X);
            Intent intent = new Intent();
            intent.setClassName(c1047a.f4772W, c1047a.f4773X);
            if (c1047a.f4775Z != null) {
                intent.putExtras(c1047a.f4775Z);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 587268097);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, c1047a.f4774Y);
            intent.putExtra(ConstantsAPI.CHECK_SUM, C1048b.m7506a(c1047a.f4774Y, 587268097, packageName));
            if (c1047a.flags == -1) {
                intent.addFlags(268435456).addFlags(134217728);
            } else {
                intent.setFlags(c1047a.flags);
            }
            try {
                context.startActivity(intent);
                C1052b.m7518e("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
                return true;
            } catch (Exception e) {
                C1052b.m7514a("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
                return false;
            }
        }
    }
}
