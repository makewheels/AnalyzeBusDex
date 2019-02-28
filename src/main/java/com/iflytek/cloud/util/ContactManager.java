package com.iflytek.cloud.util;

import android.content.Context;
import com.iflytek.cloud.util.p032a.C0986b;

public abstract class ContactManager {

    public interface ContactListener {
        void onContactQueryFinish(String str, boolean z);
    }

    protected ContactManager() {
    }

    public static ContactManager createManager(Context context, ContactListener contactListener) {
        return C0986b.m7330a(context, contactListener);
    }

    public static ContactManager getManager() {
        return C0986b.m7329a();
    }

    public abstract void asyncQueryAllContactsName();

    public abstract String queryAllContactsName();
}
