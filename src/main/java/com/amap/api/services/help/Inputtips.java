package com.amap.api.services.help;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.C0479d;
import com.amap.api.services.core.C0480e;
import com.amap.api.services.core.C0486k;
import com.amap.api.services.core.C0487l;
import java.util.List;
import p054u.aly.bi_常量类;

public final class Inputtips {
    /* renamed from: a */
    Handler f3033a = new C0510a(this);
    /* renamed from: b */
    private Context f3034b;
    /* renamed from: c */
    private InputtipsListener f3035c;

    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) {
        C0479d.m3999a(context);
        this.f3034b = context.getApplicationContext();
        this.f3035c = inputtipsListener;
    }

    public void requestInputtips(final String str, final String str2) throws AMapException {
        if (str == null || str.equals(bi_常量类.f6358b)) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        new Thread(this) {
            /* renamed from: c */
            final /* synthetic */ Inputtips f3032c;

            public void run() {
                C0486k c0486k = new C0486k(new C0487l(str, str2), C0480e.m4018a(this.f3032c.f3034b));
                Message message = new Message();
                try {
                    message.obj = (List) c0486k.getData();
                    message.what = 0;
                } catch (AMapException e) {
                    message.what = e.getErrorCode();
                } finally {
                    this.f3032c.f3033a.sendMessage(message);
                }
            }
        }.start();
    }
}
