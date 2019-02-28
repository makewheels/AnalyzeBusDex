package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class ab extends HandlerThread {
    /* renamed from: a */
    private static ab f4948a;

    public ab(String str) {
        super(str);
    }

    /* renamed from: a */
    public static synchronized ab m7705a() {
        ab abVar;
        synchronized (ab.class) {
            if (f4948a == null) {
                f4948a = new ab("TbsHandlerThread");
                f4948a.start();
            }
            abVar = f4948a;
        }
        return abVar;
    }
}
