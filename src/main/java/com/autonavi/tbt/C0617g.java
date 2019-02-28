package com.autonavi.tbt;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesUtil */
/* renamed from: com.autonavi.tbt.g */
public class C0617g {
    /* renamed from: a */
    private static AssetManager f3792a = null;
    /* renamed from: b */
    private static Resources f3793b = null;
    /* renamed from: c */
    private static Resources f3794c = null;
    /* renamed from: d */
    private static boolean f3795d = true;
    /* renamed from: e */
    private static Context f3796e;
    /* renamed from: f */
    private static String f3797f = "autonavi_Resource";
    /* renamed from: g */
    private static String f3798g = "1_1_0";
    /* renamed from: h */
    private static String f3799h = ".png";
    /* renamed from: i */
    private static String f3800i = ".jar";
    /* renamed from: j */
    private static String f3801j = (f3797f + f3798g + f3800i);
    /* renamed from: k */
    private static String f3802k = (f3797f + f3798g + f3799h);
    /* renamed from: l */
    private static String f3803l = (Environment.getExternalStorageDirectory() + "/");
    /* renamed from: m */
    private static String f3804m = (f3803l + f3801j);
    /* renamed from: n */
    private static Theme f3805n = null;
    /* renamed from: o */
    private static Theme f3806o = null;
    /* renamed from: p */
    private static Field f3807p = null;
    /* renamed from: q */
    private static Field f3808q = null;
    /* renamed from: r */
    private static Field f3809r = null;
    /* renamed from: s */
    private static Activity f3810s = null;

    /* compiled from: ResourcesUtil */
    /* renamed from: com.autonavi.tbt.g$a */
    static class C0616a implements FilenameFilter {
        C0616a() {
        }

        public boolean accept(File file, String str) {
            return str.startsWith(C0617g.f3797f) && !str.endsWith(C0617g.f3798g + C0617g.f3800i);
        }
    }

    /* renamed from: a */
    public static boolean m4849a(Context context) {
        f3796e = context;
        if (!f3795d) {
            return true;
        }
        if (!C0617g.m4853b(context)) {
            return false;
        }
        f3792a = C0617g.m4850b(f3804m);
        f3793b = C0617g.m4843a(context, f3792a);
        return true;
    }

    /* renamed from: a */
    public static Resources m4842a() {
        if (f3793b == null) {
            f3793b = f3796e.getResources();
        }
        return f3793b;
    }

    /* renamed from: a */
    private static Resources m4843a(Context context, AssetManager assetManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.setToDefaults();
        return new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
    }

    /* renamed from: b */
    private static AssetManager m4850b(String str) {
        try {
            Class cls = Class.forName("android.content.res.AssetManager");
            AssetManager assetManager = (AssetManager) cls.getConstructor((Class[]) null).newInstance((Object[]) null);
            try {
                cls.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
                return assetManager;
            } catch (Throwable th) {
                return assetManager;
            }
        } catch (Throwable th2) {
            return null;
        }
    }

    /* renamed from: b */
    private static boolean m4853b(Context context) {
        InputStream open;
        Exception e;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        C0617g.m4855c(context);
        OutputStream outputStream2 = null;
        try {
            open = context.getResources().getAssets().open(f3802k);
            try {
                File file = new File(f3804m);
                long length = file.length();
                int available = open.available();
                if (file.exists() && length == ((long) available)) {
                    open.close();
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            return true;
                        }
                    }
                    if (null == null) {
                        return true;
                    }
                    outputStream2.close();
                    return true;
                }
                C0617g.m4857e();
                outputStream2 = new FileOutputStream(new File(f3803l, f3801j));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        outputStream2.write(bArr, 0, read);
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                            return true;
                        }
                    }
                    if (outputStream2 == null) {
                        return true;
                    }
                    outputStream2.close();
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    outputStream = outputStream2;
                    inputStream = open;
                    try {
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return false;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        open = inputStream;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                                throw th;
                            }
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = outputStream2;
                    if (open != null) {
                        open.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                inputStream = open;
                e.printStackTrace();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (open != null) {
                    open.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
            e.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            open = null;
            if (open != null) {
                open.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: e */
    private static void m4857e() {
        File[] listFiles = new File(f3803l).listFiles(new C0616a());
        if (listFiles != null && listFiles.length > 0) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                i = listFiles[i].delete() ? i + 1 : i + 1;
            }
        }
    }

    /* renamed from: c */
    private static void m4855c(Context context) {
        f3803l = context.getFilesDir().getAbsolutePath();
        f3804m = f3803l + "/" + f3801j;
    }

    /* renamed from: a */
    public static View m4844a(Activity activity, int i, ViewGroup viewGroup) {
        View inflate;
        Throwable th;
        if (!f3795d) {
            return LayoutInflater.from(activity).inflate(C0617g.m4842a().getXml(i), viewGroup);
        }
        XmlResourceParser xml = C0617g.m4842a().getXml(i);
        try {
            boolean a = C0617g.m4848a(activity);
            inflate = LayoutInflater.from(activity).inflate(xml, viewGroup);
            if (a) {
                try {
                    C0617g.m4852b(activity);
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        return inflate;
                    } finally {
                        xml.close();
                    }
                }
            }
            xml.close();
            return inflate;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            inflate = null;
            th = th4;
            th.printStackTrace();
            return inflate;
        }
    }

    /* renamed from: a */
    public static boolean m4848a(Activity activity) {
        if (f3794c != null) {
            return false;
        }
        try {
            if (f3807p == null) {
                f3807p = C0617g.m4859g();
            }
            if (f3809r == null) {
                f3809r = C0617g.m4860h();
            }
            if (f3805n == null) {
                f3805n = C0617g.m4858f();
            }
            Context baseContext = activity.getBaseContext();
            f3794c = (Resources) f3809r.get(baseContext);
            f3806o = (Theme) f3807p.get(activity);
            f3809r.set(baseContext, f3793b);
            f3807p.set(activity, f3805n);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: f */
    private static Theme m4858f() {
        if (f3805n == null) {
            if (f3792a == null) {
                f3792a = C0617g.m4850b(f3804m);
            }
            if (f3793b == null) {
                f3793b = C0617g.m4843a(f3810s, f3792a);
            }
            f3805n = f3793b.newTheme();
            f3805n.applyStyle(C0617g.m4841a("com.android.internal.R.style.Theme"), true);
        }
        return f3805n;
    }

    /* renamed from: g */
    private static Field m4859g() {
        try {
            f3807p = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mTheme");
            f3807p.setAccessible(true);
        } catch (Throwable th) {
        }
        return f3807p;
    }

    /* renamed from: h */
    private static Field m4860h() {
        try {
            f3809r = Class.forName("android.app.ContextImpl").getDeclaredField("mResources");
            f3809r.setAccessible(true);
        } catch (Throwable th) {
        }
        return f3809r;
    }

    /* renamed from: a */
    public static int m4841a(String str) {
        int i = -1;
        try {
            String substring = str.substring(0, str.indexOf(".R.") + 2);
            int lastIndexOf = str.lastIndexOf(".");
            String substring2 = str.substring(lastIndexOf + 1, str.length());
            String substring3 = str.substring(0, lastIndexOf);
            i = Class.forName(substring + "$" + substring3.substring(substring3.lastIndexOf(".") + 1, substring3.length())).getDeclaredField(substring2).getInt(null);
        } catch (Throwable th) {
        }
        return i;
    }

    /* renamed from: b */
    public static void m4852b(Activity activity) {
        if (f3794c != null) {
            try {
                f3809r.set(activity.getBaseContext(), f3794c);
                f3807p.set(activity, f3806o);
            } catch (Throwable th) {
                th.printStackTrace();
            } finally {
                f3794c = null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static android.view.animation.Animation m4845a(android.content.Context r4, int r5) throws android.content.res.Resources.NotFoundException {
        /*
        r1 = new android.content.res.Resources$NotFoundException;
        r1.<init>();
        r0 = 0;
        r2 = com.autonavi.tbt.C0617g.m4842a();	 Catch:{ XmlPullParserException -> 0x0018, IOException -> 0x0024, all -> 0x0026 }
        r0 = r2.getAnimation(r5);	 Catch:{ XmlPullParserException -> 0x0018, IOException -> 0x0024, all -> 0x0026 }
        r1 = com.autonavi.tbt.C0617g.m4846a(r4, r0);	 Catch:{ XmlPullParserException -> 0x0018, IOException -> 0x0024 }
        if (r0 == 0) goto L_0x0017;
    L_0x0014:
        r0.close();
    L_0x0017:
        return r1;
    L_0x0018:
        r2 = move-exception;
        throw r1;	 Catch:{ all -> 0x001a }
    L_0x001a:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x001e:
        if (r1 == 0) goto L_0x0023;
    L_0x0020:
        r1.close();
    L_0x0023:
        throw r0;
    L_0x0024:
        r2 = move-exception;
        throw r1;	 Catch:{ all -> 0x001a }
    L_0x0026:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.tbt.g.a(android.content.Context, int):android.view.animation.Animation");
    }

    /* renamed from: a */
    private static Animation m4846a(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return C0617g.m4847a(context, xmlPullParser, null, Xml.asAttributeSet(xmlPullParser));
    }

    /* renamed from: a */
    private static Animation m4847a(Context context, XmlPullParser xmlPullParser, AnimationSet animationSet, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Animation animationSet2;
        int depth = xmlPullParser.getDepth();
        int next;
        do {
            next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
        } while (next != 2);
        String name = xmlPullParser.getName();
        if (name.equals("set")) {
            animationSet2 = new AnimationSet(context, attributeSet);
            C0617g.m4847a(context, xmlPullParser, (AnimationSet) animationSet2, attributeSet);
        } else if (name.equals("alpha")) {
            animationSet2 = new AlphaAnimation(context, attributeSet);
        } else if (name.equals("scale")) {
            animationSet2 = new ScaleAnimation(context, attributeSet);
        } else if (name.equals("rotate")) {
            animationSet2 = new RotateAnimation(context, attributeSet);
        } else if (name.equals("translate")) {
            animationSet2 = new TranslateAnimation(context, attributeSet);
        } else {
            throw new RuntimeException("Unknown animation name: " + xmlPullParser.getName());
        }
        if (animationSet != null) {
            animationSet.addAnimation(animationSet2);
        }
        return animationSet2;
    }
}
