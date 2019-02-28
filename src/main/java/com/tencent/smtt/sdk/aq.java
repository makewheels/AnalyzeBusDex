package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

class aq {
    /* renamed from: a */
    protected DexLoader f4985a = null;

    public aq(DexLoader dexLoader) {
        this.f4985a = dexLoader;
    }

    /* renamed from: a */
    public Object m7807a(Context context) {
        return this.f4985a.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, this.f4985a.getClassLoader());
    }

    /* renamed from: a */
    public void m7808a(Object obj) {
        this.f4985a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
    }

    /* renamed from: a */
    public void m7809a(Object obj, Activity activity, int i) {
        Object obj2 = obj;
        this.f4985a.invokeMethod(obj2, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i));
    }

    /* renamed from: a */
    public boolean m7810a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object invokeMethod;
        if (obj2 != null) {
            invokeMethod = this.f4985a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class, Object.class}, bundle, frameLayout, obj2);
        } else {
            invokeMethod = this.f4985a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        }
        return invokeMethod instanceof Boolean ? ((Boolean) invokeMethod).booleanValue() : false;
    }
}
