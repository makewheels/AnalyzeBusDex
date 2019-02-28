package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.C1146j;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class af extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f4958a;
    /* renamed from: b */
    final /* synthetic */ Context f4959b;
    /* renamed from: c */
    final /* synthetic */ ac f4960c;

    af(ac acVar, Context context, Context context2) {
        this.f4960c = acVar;
        this.f4958a = context;
        this.f4959b = context2;
    }

    public void run() {
        TbsLog.m7927i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread start");
        try {
            File f = this.f4960c.m7747f(this.f4958a);
            File f2 = this.f4960c.m7747f(this.f4959b);
            C1146j.m7980a(f, f2, new ag(this));
            C1146j.m7980a(f, f2, new ah(this));
            TbsLog.m7927i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp thread done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
