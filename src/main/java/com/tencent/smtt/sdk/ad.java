package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;

class ad extends Handler {
    /* renamed from: a */
    final /* synthetic */ ac f4956a;

    ad(ac acVar, Looper looper) {
        this.f4956a = acVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        Object[] objArr;
        switch (message.what) {
            case 1:
                TbsLog.m7927i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
                objArr = (Object[]) message.obj;
                this.f4956a.m7715b((Context) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                break;
            case 2:
                TbsLog.m7927i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
                objArr = (Object[]) message.obj;
                this.f4956a.m7709a((Context) objArr[0], (Context) objArr[1], ((Integer) objArr[2]).intValue());
                break;
            case 3:
                TbsLog.m7927i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
                objArr = (Object[]) message.obj;
                this.f4956a.m7742b((Context) objArr[0], (Bundle) objArr[1]);
                break;
        }
        super.handleMessage(message);
    }
}
