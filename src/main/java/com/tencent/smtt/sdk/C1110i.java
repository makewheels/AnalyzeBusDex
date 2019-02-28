package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.alipay.sdk.cons.C0108a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* renamed from: com.tencent.smtt.sdk.i */
class C1110i {
    /* renamed from: a */
    static boolean f5034a = false;
    /* renamed from: c */
    private static C1110i f5035c = null;
    /* renamed from: f */
    private static int f5036f = 0;
    /* renamed from: g */
    private static int f5037g = 0;
    /* renamed from: h */
    private static int f5038h = 3;
    /* renamed from: j */
    private static String f5039j = null;
    /* renamed from: b */
    private ap f5040b = null;
    /* renamed from: d */
    private boolean f5041d = false;
    /* renamed from: e */
    private boolean f5042e = false;
    /* renamed from: i */
    private File f5043i = null;

    private C1110i() {
    }

    /* renamed from: a */
    public static C1110i m7845a(boolean z) {
        if (f5035c == null && z) {
            f5035c = new C1110i();
        }
        return f5035c;
    }

    /* renamed from: a */
    static void m7846a(int i) {
        f5036f = i;
    }

    /* renamed from: b */
    private void m7847b(int i) {
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(f5039j, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.f5043i, "count.prop")), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m7848b(Context context, boolean z) {
        if (!QbSdk.f4782a || z || !this.f5041d) {
            this.f5041d = false;
            if (z) {
                TbsLog.m7931w("SDKEngine", "useSystemWebView -> QbSdk.forceSysWebViewInner");
                QbSdk.m7544a();
            }
            if (f5036f != 0 && !this.f5041d) {
                TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.INFO_CAN_NOT_LOAD_TBS);
            }
        }
    }

    /* renamed from: d */
    public static int m7849d() {
        return f5036f;
    }

    /* renamed from: i */
    private static boolean m7850i() {
        return VERSION.SDK_INT >= 7;
    }

    /* renamed from: j */
    private int m7851j() {
        try {
            InputStream fileInputStream = new FileInputStream(new File(this.f5043i, "count.prop"));
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return Integer.valueOf(properties.getProperty(f5039j, C0108a.f262e)).intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public ap m7852a() {
        return QbSdk.f4782a ? null : this.f5040b;
    }

    /* renamed from: a */
    public synchronized void m7853a(Context context) {
        m7855a(context, false, false);
    }

    /* renamed from: a */
    public synchronized void m7854a(Context context, boolean z) {
        m7855a(context, z, false);
    }

    /* renamed from: a */
    public synchronized void m7855a(Context context, boolean z, boolean z2) {
        int i = 0;
        int i2 = 1;
        synchronized (this) {
            f5037g++;
            TbsCoreLoadStat.getInstance().m7562a();
            ac.m7706a().m7737a(context, f5037g == 1);
            boolean a = QbSdk.m7549a(context, z, z2);
            boolean i3 = C1110i.m7850i();
            if (!i3) {
                TbsLog.m7925e(TbsListener.tag_load_error, "320");
                QbSdk.f4786e.onCallBackErrorCode(ErrorCode.ERROR_SDKENGINE_ISCOMPATIBLE, ErrorCode.INFO_ERROR_SDKENGINE_ISCOMPATIBLE);
            }
            boolean z3 = a && i3;
            TbsLog.m7927i("SDKEngine", "init canLoadTbs=" + z3);
            if (!z3) {
                TbsLog.m7925e("SDKEngine", "init failure: can_load_x5=" + a + "; is_compatible=" + i3 + "; isTbsCoreLegaL=" + true);
            }
            if (!z3) {
                TbsLog.m7925e("SDKEngine", "useSystemWebView by !canLoadTbs");
                TbsLog.m7925e(TbsListener.tag_load_error, "324");
                QbSdk.f4786e.onCallBackErrorCode(ErrorCode.ERROR_SDKENGINE_CANLOADTBS, ErrorCode.INFO_SDKENGINE_CANLOADTBS);
                m7848b(context, false);
                ac.m7706a();
                this.f5043i = ac.m7722h(context);
                this.f5042e = true;
            } else if (!this.f5041d) {
                try {
                    File f;
                    Context applicationContext;
                    File file;
                    if (!TbsShareManager.isThirdPartyApp(context)) {
                        f = ac.m7706a().m7747f(context);
                        if (!(f5036f == 25436 || f5036f == 25437)) {
                            i2 = 0;
                        }
                        applicationContext = i2 != 0 ? context.getApplicationContext() : context;
                        if (f == null) {
                            TbsLog.m7925e("SDKEngine", "useSystemWebView by ERROR_TBSCORE_SHARE_DIR");
                            TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_TBSCORE_SHARE_DIR);
                            m7848b(context, true);
                        } else {
                            file = f;
                        }
                    } else if (TbsShareManager.m7638h(context)) {
                        file = new File(TbsShareManager.m7632b(context));
                        f = ac.m7706a().m7747f(context);
                        applicationContext = TbsShareManager.m7634d(context);
                        if (f == null) {
                            TbsLog.m7925e("SDKEngine", "useSystemWebView by ERROR_TBSCORE_DEXOPT_DIR");
                            TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_TBSCORE_DEXOPT_DIR);
                            QbSdk.f4786e.onCallBackErrorCode(ErrorCode.ERROR_TBSCORE_DEXOPT_DIR, ErrorCode.INFO_ERROR_TBSCORE_DEXOPT_DIR);
                            m7848b(context, true);
                        }
                    } else {
                        TbsLog.m7925e("SDKEngine", "useSystemWebView by ERROR_HOST_UNAVAILABLE");
                        TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.ERROR_HOST_UNAVAILABLE);
                        QbSdk.f4786e.onCallBackErrorCode(ErrorCode.ERROR_HOST_UNAVAILABLE, ErrorCode.INFO_ERROR_HOST_UNAVAILABLE);
                        m7848b(context, true);
                    }
                    String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, applicationContext, file.getAbsolutePath());
                    while (i < dexLoaderFileList.length) {
                        i++;
                    }
                    this.f5040b = new ap(context, applicationContext, file.getAbsolutePath(), f.getAbsolutePath(), dexLoaderFileList);
                    this.f5041d = true;
                } catch (Throwable th) {
                    TbsLog.m7925e("SDKEngine", "useSystemWebView by exception: " + th);
                    if (th == null) {
                        TbsCoreLoadStat.getInstance().m7563a(context, (int) ErrorCode.TEST_THROWABLE_IS_NULL);
                    } else {
                        TbsCoreLoadStat.getInstance().m7564a(context, ErrorCode.TEST_THROWABLE_ISNOT_NULL, th);
                    }
                    QbSdk.f4786e.onCallBackErrorCode(ErrorCode.THROWABLE_LOAD_TBS, ErrorCode.INFO_THROWABLE_LOAD_TBS);
                    m7848b(context, true);
                }
                ac.m7706a();
                this.f5043i = ac.m7722h(context);
                this.f5042e = true;
            }
        }
    }

    /* renamed from: a */
    void m7856a(String str) {
        f5039j = str;
    }

    /* renamed from: b */
    public ap m7857b(boolean z) {
        return z ? this.f5040b : QbSdk.f4782a ? null : this.f5040b;
    }

    /* renamed from: b */
    public boolean m7858b() {
        return QbSdk.f4782a ? false : this.f5041d;
    }

    /* renamed from: c */
    ap m7859c() {
        return this.f5040b;
    }

    /* renamed from: c */
    boolean m7860c(boolean z) {
        f5034a = z;
        return z;
    }

    /* renamed from: e */
    public String m7861e() {
        return (this.f5040b == null || QbSdk.f4782a) ? "system webview get nothing..." : this.f5040b.m7804m();
    }

    /* renamed from: f */
    boolean m7862f() {
        if (f5034a) {
            if (f5039j == null) {
                return false;
            }
            int j = m7851j();
            if (j == 0) {
                m7847b(1);
            } else if (j + 1 > f5038h) {
                return false;
            } else {
                m7847b(j + 1);
            }
        }
        return f5034a;
    }

    /* renamed from: g */
    boolean m7863g() {
        return this.f5042e;
    }

    /* renamed from: h */
    public boolean m7864h() {
        return QbSdk.useSoftWare();
    }
}
