package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.sdk.h */
public class C1109h {
    /* renamed from: a */
    private DexLoader f5032a;
    /* renamed from: b */
    private ReaderCallback f5033b;

    public C1109h(ReaderCallback readerCallback) {
        this.f5032a = null;
        this.f5033b = null;
        this.f5032a = C1109h.m7835b();
        this.f5033b = readerCallback;
    }

    /* renamed from: a */
    public static Drawable m7832a(int i) {
        DexLoader b = C1109h.m7835b();
        if (b != null) {
            Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof Drawable) {
                return (Drawable) invokeStaticMethod;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m7833a(Context context) {
        DexLoader b = C1109h.m7835b();
        if (b != null) {
            Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
            if (invokeStaticMethod instanceof Boolean) {
                return ((Boolean) invokeStaticMethod).booleanValue();
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7834a(String str) {
        DexLoader b = C1109h.m7835b();
        if (b != null) {
            Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
            if (invokeStaticMethod instanceof Boolean) {
                return ((Boolean) invokeStaticMethod).booleanValue();
            }
        }
        return false;
    }

    /* renamed from: b */
    private static DexLoader m7835b() {
        ap c = C1110i.m7845a(true).m7859c();
        return c != null ? c.m7806o() : null;
    }

    /* renamed from: b */
    public static String m7836b(int i) {
        String str = bi_常量类.f6358b;
        DexLoader b = C1109h.m7835b();
        if (b != null) {
            Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i));
            if (invokeStaticMethod instanceof String) {
                return (String) invokeStaticMethod;
            }
        }
        return str;
    }

    /* renamed from: a */
    public Object m7837a() {
        return this.f5032a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
    }

    /* renamed from: a */
    public void m7838a(Object obj) {
        this.f5033b = null;
        if (this.f5032a == null || obj == null) {
            Log.e("ReaderWizard", "destroy:Unexpect null object!");
            return;
        }
        this.f5032a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
    }

    /* renamed from: a */
    public void m7839a(Object obj, int i, int i2) {
        if (this.f5032a == null) {
            Log.e("ReaderWizard", "onSizeChanged:Unexpect null object!");
            return;
        }
        Object[] objArr = new Object[]{new Integer(i), new Integer(i2)};
        Object obj2 = obj;
        this.f5032a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, objArr);
    }

    /* renamed from: a */
    public void m7840a(Object obj, Integer num, Object obj2, Object obj3) {
        if (this.f5032a == null) {
            Log.e("ReaderWizard", "doCommand:Unexpect null object!");
            return;
        }
        Object[] objArr = new Object[]{new Integer(num.intValue()), obj2, obj3};
        Object obj4 = obj;
        this.f5032a.invokeMethod(obj4, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, objArr);
    }

    /* renamed from: a */
    public void m7841a(Object obj, String str) {
        if (this.f5032a == null) {
            Log.e("ReaderWizard", "userStatistics:Unexpect null object!");
            return;
        }
        Object obj2 = obj;
        this.f5032a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
    }

    /* renamed from: a */
    public boolean m7842a(Object obj, Context context) {
        if (this.f5032a == null || obj == null) {
            Log.e("ReaderWizard", "initTbsReader:Unexpect null object!");
            return false;
        }
        Object obj2 = obj;
        Object invokeMethod = this.f5032a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "init", new Class[]{Context.class, DexLoader.class, Object.class}, context, this.f5032a, this);
        if (invokeMethod instanceof Boolean) {
            return ((Boolean) invokeMethod).booleanValue();
        }
        Log.e("ReaderWizard", "Unexpect return value type of call initTbsReader!");
        return false;
    }

    /* renamed from: a */
    public boolean m7843a(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        if (this.f5032a == null) {
            Log.e("ReaderWizard", "openFile:Unexpect null object!");
            return false;
        }
        Object obj2 = obj;
        Object invokeMethod = this.f5032a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
        if (invokeMethod instanceof Boolean) {
            return ((Boolean) invokeMethod).booleanValue();
        }
        Log.e("ReaderWizard", "Unexpect return value type of call openFile!");
        return false;
    }

    /* renamed from: a */
    public boolean m7844a(Object obj, Context context, String str, boolean z) {
        if (this.f5032a == null) {
            Log.e("ReaderWizard", "checkPlugin:Unexpect null object!");
            return false;
        }
        Object obj2 = obj;
        Object invokeMethod = this.f5032a.invokeMethod(obj2, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z));
        if (invokeMethod instanceof Boolean) {
            return ((Boolean) invokeMethod).booleanValue();
        }
        Log.e("ReaderWizard", "Unexpect return value type of call checkPlugin!");
        return false;
    }
}
