package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.Log;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C1134a;
import com.tencent.smtt.utils.C1146j;
import com.tencent.smtt.utils.C1164z;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.sdk.w */
class C1129w {
    /* renamed from: a */
    private static final String[] f5083a = new String[]{"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.x5sdk.demo", "tbs_downloading_com.qzone"};
    /* renamed from: b */
    private Context f5084b;
    /* renamed from: c */
    private String f5085c;
    /* renamed from: d */
    private String f5086d;
    /* renamed from: e */
    private String f5087e;
    /* renamed from: f */
    private File f5088f;
    /* renamed from: g */
    private long f5089g;
    /* renamed from: h */
    private int f5090h = 30000;
    /* renamed from: i */
    private int f5091i = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
    /* renamed from: j */
    private boolean f5092j;
    /* renamed from: k */
    private int f5093k;
    /* renamed from: l */
    private int f5094l;
    /* renamed from: m */
    private boolean f5095m;
    /* renamed from: n */
    private boolean f5096n;
    /* renamed from: o */
    private HttpURLConnection f5097o;
    /* renamed from: p */
    private String f5098p;
    /* renamed from: q */
    private TbsLogReport f5099q;
    /* renamed from: r */
    private String f5100r;
    /* renamed from: s */
    private int f5101s;
    /* renamed from: t */
    private boolean f5102t;
    /* renamed from: u */
    private Handler f5103u;
    /* renamed from: v */
    private Set<String> f5104v;

    public C1129w(Context context) {
        this.f5084b = context.getApplicationContext();
        this.f5099q = TbsLogReport.m7589a(this.f5084b);
        this.f5104v = new HashSet();
        this.f5098p = "tbs_downloading_" + this.f5084b.getPackageName();
        ac.m7706a();
        this.f5088f = ac.m7722h(this.f5084b);
        if (this.f5088f == null) {
            throw new NullPointerException("TbsCorePrivateDir is null!");
        }
        m7886g();
        this.f5100r = null;
        this.f5101s = -1;
    }

    /* renamed from: a */
    private long m7872a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f5099q.m7614c(currentTimeMillis - j);
        this.f5099q.m7618d(j2);
        return currentTimeMillis;
    }

    @TargetApi(8)
    /* renamed from: a */
    static File m7873a(Context context) {
        try {
            File file = VERSION.SDK_INT >= 8 ? new File(C1146j.m7976a(context, 3)) : null;
            if (file == null || file.exists() || file.isDirectory()) {
                return file;
            }
            file.mkdirs();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLog.m7925e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private String m7874a(Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        return stackTraceString.length() > 1024 ? stackTraceString.substring(0, 1024) : stackTraceString;
    }

    /* renamed from: a */
    private String m7875a(URL url) {
        String str = bi_常量类.f6358b_空串;
        try {
            str = InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e2) {
            e2.printStackTrace();
        }
        return str;
    }

    /* renamed from: a */
    private void m7876a(int i, String str, boolean z) {
        if (z || this.f5093k > 5) {
            this.f5099q.m7624h(i);
            this.f5099q.m7621e(str);
        }
    }

    /* renamed from: a */
    private void m7877a(long j) {
        if (j <= 0) {
            try {
                j = m7894o();
            } catch (Exception e) {
            }
        }
        Thread.sleep(j);
        this.f5093k++;
    }

    /* renamed from: a */
    private void m7878a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m7879a(File file, Context context) {
        if (file != null && file.exists()) {
            try {
                File a = C1129w.m7873a(context);
                if (a != null) {
                    File file2 = new File(a, TbsDownloader.getOverSea(context) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                    file2.delete();
                    C1146j.m7990b(file, file2);
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    private void m7880a(String str) {
        this.f5097o = (HttpURLConnection) new URL(str).openConnection();
        this.f5097o.setRequestProperty("User-Agent", TbsDownloader.m7575a(this.f5084b));
        this.f5097o.setRequestProperty("Accept-Encoding", "identity");
        this.f5097o.setRequestMethod("GET");
        this.f5097o.setInstanceFollowRedirects(false);
        this.f5097o.setConnectTimeout(this.f5091i);
        this.f5097o.setReadTimeout(this.f5090h);
    }

    /* renamed from: a */
    private void m7881a(boolean z) {
        C1164z.m8083a(this.f5084b);
        QbSdk.f4786e.onDownloadFinish(z ? 100 : ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR);
        TbsDownloadConfig a = TbsDownloadConfig.m7565a(this.f5084b);
        a.f4826a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(false));
        a.m7572g();
        int i = a.f4827b.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
        if (i == 3 || i > 10000) {
            File a2 = C1129w.m7873a(this.f5084b);
            if (a2 != null) {
                File file = new File(a2, TbsDownloader.getOverSea(this.f5084b) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                int a3 = C1134a.m7938a(this.f5084b, file);
                File file2 = new File(this.f5088f, "x5.tbs");
                String absolutePath = file2.exists() ? file2.getAbsolutePath() : null;
                int i2 = a.f4827b.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                Bundle bundle = new Bundle();
                bundle.putInt("operation", i);
                bundle.putInt("old_core_ver", a3);
                bundle.putInt("new_core_ver", i2);
                bundle.putString("old_apk_location", file.getAbsolutePath());
                bundle.putString("new_apk_location", absolutePath);
                bundle.putString("diff_file_location", absolutePath);
                ac.m7706a().m7742b(this.f5084b, bundle);
                return;
            }
            m7903f();
            a.f4826a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
            a.m7572g();
            return;
        }
        ac.m7706a().m7736a(this.f5084b, new File(this.f5088f, "x5.tbs").getAbsolutePath(), a.f4827b.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
        C1129w.m7879a(new File(this.f5088f, "x5.tbs"), this.f5084b);
    }

    /* renamed from: a */
    private boolean m7883a(boolean z, boolean z2) {
        long j = 0;
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z);
        File file = new File(this.f5088f, !z ? "x5.tbs" : "x5.tbs.temp");
        if (!file.exists()) {
            return false;
        }
        String string = TbsDownloadConfig.m7565a(this.f5084b).f4827b.getString(TbsConfigKey.KEY_TBSAPK_MD5, null);
        String a = C1134a.m7941a(file);
        if (string == null || !string.equals(a)) {
            TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " md5 failed");
            if (!z) {
                return false;
            }
            this.f5099q.m7619d("fileMd5 not match");
            return false;
        }
        boolean renameTo;
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + a + ") successful!");
        if (z) {
            long j2;
            long j3 = TbsDownloadConfig.m7565a(this.f5084b).f4827b.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
            if (file == null || !file.exists()) {
                j2 = 0;
            } else if (j3 > 0) {
                j2 = file.length();
                if (j3 == j2) {
                    j = j2;
                }
            }
            TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " filelength failed");
            this.f5099q.m7619d("fileLength:" + j2 + ",contentLength:" + j3);
            return false;
        }
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j + ") successful!");
        int i = -1;
        if (z2) {
            i = C1134a.m7938a(this.f5084b, file);
            int i2 = TbsDownloadConfig.m7565a(this.f5084b).f4827b.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            if (i2 != i) {
                TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " versionCode failed");
                if (!z) {
                    return false;
                }
                this.f5099q.m7619d("fileVersion:" + i + ",configVersion:" + i2);
                return false;
            }
        }
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
        if (z2) {
            string = C1134a.m7945b(this.f5084b, file);
            if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(string)) {
                TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z + " signature failed");
                if (!z) {
                    return false;
                }
                this.f5099q.m7619d("signature:" + (string == null ? "null" : Integer.valueOf(string.length())));
                return false;
            }
        }
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
        if (z) {
            Throwable th;
            try {
                renameTo = file.renameTo(new File(this.f5088f, "x5.tbs"));
                th = null;
            } catch (Throwable e) {
                th = e;
                renameTo = false;
            }
            if (!renameTo) {
                m7876a(ErrorCode.FILE_RENAME_ERROR, m7874a(th), true);
                return false;
            }
        }
        renameTo = false;
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + renameTo + ") successful!");
        return true;
    }

    /* renamed from: b */
    public static void m7884b(Context context) {
        try {
            ac.m7706a();
            File h = ac.m7722h(context);
            new File(h, "x5.tbs").delete();
            new File(h, "x5.tbs.temp").delete();
            h = C1129w.m7873a(context);
            if (h != null) {
                new File(h, "x5.tbs.org").delete();
                new File(h, "x5.oversea.tbs.org").delete();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    private boolean m7885b(boolean z) {
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=" + z);
        File file = z ? new File(this.f5088f, "x5.tbs") : new File(this.f5088f, "x5.tbs.temp");
        return (file == null || !file.exists()) ? true : file.delete();
    }

    /* renamed from: g */
    private void m7886g() {
        this.f5093k = 0;
        this.f5094l = 0;
        this.f5089g = -1;
        this.f5087e = null;
        this.f5092j = false;
        this.f5095m = false;
        this.f5096n = false;
        this.f5102t = false;
    }

    /* renamed from: h */
    private void m7887h() {
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        if (this.f5097o != null) {
            if (!this.f5095m) {
                this.f5099q.m7611b(m7875a(this.f5097o.getURL()));
            }
            try {
                this.f5097o.disconnect();
            } catch (Exception e) {
            }
            try {
                System.putString(this.f5084b.getContentResolver(), this.f5098p, TbsDownloadConfig.m7565a(this.f5084b).f4827b.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + "|" + 0);
            } catch (Exception e2) {
            }
            this.f5097o = null;
        }
        int i = this.f5099q.f4845a;
        if (this.f5095m || !this.f5102t) {
            TbsDownloader.f4828a = false;
            return;
        }
        this.f5099q.m7603a(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.f5084b);
        int apnType = Apn.getApnType(this.f5084b);
        this.f5099q.m7615c(apnInfo);
        this.f5099q.m7620e(apnType);
        if (!(apnType == this.f5101s && apnInfo.equals(this.f5100r))) {
            this.f5099q.m7623g(0);
        }
        if ((this.f5099q.f4845a == 0 || this.f5099q.f4845a == ErrorCode.UNKNOWN_ERROR) && this.f5099q.m7612c() == 0) {
            if (!Apn.isNetworkAvailable(this.f5084b)) {
                m7876a(101, null, true);
            } else if (!m7893n()) {
                m7876a(101, null, true);
            }
        }
        this.f5099q.m7604a(EventType.TYPE_DOWNLOAD);
        if (i != 100) {
            QbSdk.f4786e.onDownloadFinish(i);
        }
    }

    /* renamed from: i */
    private boolean m7888i() {
        try {
            File file = new File(this.f5088f, "x5.tbs");
            File a = C1129w.m7873a(this.f5084b);
            if (a != null) {
                File file2 = new File(a, TbsDownloader.getOverSea(this.f5084b) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                file.delete();
                C1146j.m7990b(file2, file);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TbsLog.m7925e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e.getMessage());
            return false;
        }
    }

    /* renamed from: j */
    private boolean m7889j() {
        return C1134a.m7943a(this.f5084b, new File(C1146j.m7976a(this.f5084b, 3), TbsDownloader.getOverSea(this.f5084b) ? "x5.oversea.tbs.org" : "x5.tbs.org"), 0, TbsDownloadConfig.m7565a(this.f5084b).f4827b.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
    }

    /* renamed from: k */
    private void m7890k() {
        try {
            File file = new File(C1146j.m7976a(this.f5084b, 3), TbsDownloader.getOverSea(this.f5084b) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file != null && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: l */
    private boolean m7891l() {
        File file = new File(this.f5088f, "x5.tbs.temp");
        return file != null && file.exists();
    }

    /* renamed from: m */
    private long m7892m() {
        File file = new File(this.f5088f, "x5.tbs.temp");
        return (file == null || !file.exists()) ? 0 : file.length();
    }

    /* renamed from: n */
    private boolean m7893n() {
        Closeable inputStream;
        Closeable inputStreamReader;
        Throwable th;
        Closeable closeable;
        Throwable th2;
        boolean z = false;
        Closeable closeable2 = null;
        try {
            inputStream = Runtime.getRuntime().exec("ping " + "www.qq.com").getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
            } catch (Throwable th3) {
                th2 = th3;
                inputStreamReader = null;
                m7878a(inputStream);
                m7878a(inputStreamReader);
                m7878a(closeable2);
                throw th2;
            }
            try {
                closeable = new BufferedReader(inputStreamReader);
                int i = 0;
                do {
                    try {
                        String readLine = closeable.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.contains("TTL") || readLine.contains("ttl")) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        closeable2 = closeable;
                    }
                } while (i < 5);
                m7878a(inputStream);
                m7878a(inputStreamReader);
                m7878a(closeable);
            } catch (Throwable th5) {
                th2 = th5;
                m7878a(inputStream);
                m7878a(inputStreamReader);
                m7878a(closeable2);
                throw th2;
            }
        } catch (Throwable th6) {
            th2 = th6;
            inputStreamReader = null;
            inputStream = null;
            m7878a(inputStream);
            m7878a(inputStreamReader);
            m7878a(closeable2);
            throw th2;
        }
        return z;
    }

    /* renamed from: o */
    private long m7894o() {
        long j = 20000;
        switch (this.f5093k) {
            case 1:
            case 2:
                return 20000 * ((long) this.f5093k);
            case 3:
            case 4:
                j = 20000 * 5;
                break;
        }
        return j * 10;
    }

    /* renamed from: p */
    private boolean m7895p() {
        CharSequence charSequence;
        Object obj;
        HttpURLConnection httpURLConnection;
        Throwable th;
        HttpURLConnection httpURLConnection2 = null;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = Apn.getApnType(this.f5084b) == 3;
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] isWifi=" + z3);
        if (z3) {
            String wifiSSID = Apn.getWifiSSID(this.f5084b);
            TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] localBSSID=" + wifiSSID);
            try {
                HttpURLConnection httpURLConnection3 = (HttpURLConnection) new URL("http://pms.mb.qq.com/rsp204").openConnection();
                try {
                    httpURLConnection3.setInstanceFollowRedirects(false);
                    httpURLConnection3.setConnectTimeout(10000);
                    httpURLConnection3.setReadTimeout(10000);
                    httpURLConnection3.setUseCaches(false);
                    httpURLConnection3.getInputStream();
                    int responseCode = httpURLConnection3.getResponseCode();
                    TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDwonloader.detectWifiNetworkAvailable] responseCode=" + responseCode);
                    if (responseCode != ErrorCode.APK_INVALID) {
                        z = false;
                    }
                    if (httpURLConnection3 != null) {
                        try {
                            httpURLConnection3.disconnect();
                            charSequence = wifiSSID;
                            z2 = z;
                        } catch (Exception e) {
                            obj = wifiSSID;
                            z2 = z;
                        }
                    } else {
                        obj = wifiSSID;
                        z2 = z;
                    }
                } catch (Throwable th2) {
                    httpURLConnection2 = httpURLConnection3;
                    th = th2;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
        if (!(z2 || TextUtils.isEmpty(charSequence) || this.f5104v.contains(charSequence))) {
            this.f5104v.add(charSequence);
            m7896q();
            this.f5103u.sendMessageDelayed(this.f5103u.obtainMessage(150, charSequence), 120000);
        }
        if (z2 && this.f5104v.contains(charSequence)) {
            this.f5104v.remove(charSequence);
        }
        return z2;
    }

    /* renamed from: q */
    private void m7896q() {
        if (this.f5103u == null) {
            this.f5103u = new C1130x(this, ab.m7705a().getLooper());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public void m7897a() {
        /*
        r28 = this;
        r3 = com.tencent.smtt.sdk.ac.m7706a();
        r0 = r28;
        r4 = r0.f5084b;
        r3 = r3.m7743b(r4);
        if (r3 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r28;
        r3 = r0.f5084b;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);
        r3 = r3.f4827b;
        r4 = "tbs_responsecode";
        r5 = 0;
        r3 = r3.getInt(r4, r5);
        r4 = 1;
        if (r3 == r4) goto L_0x0026;
    L_0x0023:
        r4 = 2;
        if (r3 != r4) goto L_0x003e;
    L_0x0026:
        r3 = 1;
        r19 = r3;
    L_0x0029:
        if (r19 == 0) goto L_0x0045;
    L_0x002b:
        r3 = r28.m7889j();
        if (r3 == 0) goto L_0x0042;
    L_0x0031:
        r3 = r28.m7888i();
        if (r3 == 0) goto L_0x0045;
    L_0x0037:
        r3 = 0;
        r0 = r28;
        r0.m7881a(r3);
        goto L_0x000e;
    L_0x003e:
        r3 = 0;
        r19 = r3;
        goto L_0x0029;
    L_0x0042:
        r28.m7890k();
    L_0x0045:
        r3 = 0;
        r0 = r28;
        r1 = r19;
        r3 = r0.m7883a(r3, r1);
        if (r3 == 0) goto L_0x0057;
    L_0x0050:
        r3 = 0;
        r0 = r28;
        r0.m7881a(r3);
        goto L_0x000e;
    L_0x0057:
        r3 = 1;
        r0 = r28;
        r3 = r0.m7885b(r3);
        if (r3 != 0) goto L_0x0071;
    L_0x0060:
        r3 = 1;
        r0 = r28;
        r3 = r0.m7885b(r3);
        if (r3 != 0) goto L_0x0071;
    L_0x0069:
        r3 = "TbsDownload";
        r4 = "[TbsApkDownloader] delete file failed!";
        com.tencent.smtt.utils.TbsLog.m7925e(r3, r4);
        goto L_0x000e;
    L_0x0071:
        r0 = r28;
        r3 = r0.f5084b;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);
        r3 = r3.f4827b;
        r4 = "tbs_downloadurl";
        r5 = 0;
        r3 = r3.getString(r4, r5);
        r0 = r28;
        r0.f5085c = r3;
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "[TbsApkDownloader.startDownload] mDownloadUrl=";
        r4 = r4.append(r5);
        r0 = r28;
        r5 = r0.f5085c;
        r4 = r4.append(r5);
        r5 = " mLocation=";
        r4 = r4.append(r5);
        r0 = r28;
        r5 = r0.f5087e;
        r4 = r4.append(r5);
        r5 = " mCanceled=";
        r4 = r4.append(r5);
        r0 = r28;
        r5 = r0.f5095m;
        r4 = r4.append(r5);
        r5 = " mHttpRequest=";
        r4 = r4.append(r5);
        r0 = r28;
        r5 = r0.f5097o;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.tencent.smtt.utils.TbsLog.m7927i(r3, r4);
        r0 = r28;
        r3 = r0.f5085c;
        if (r3 != 0) goto L_0x00e1;
    L_0x00d2:
        r0 = r28;
        r3 = r0.f5087e;
        if (r3 != 0) goto L_0x00e1;
    L_0x00d8:
        r3 = com.tencent.smtt.sdk.QbSdk.f4786e;
        r4 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r3.onDownloadFinish(r4);
        goto L_0x000e;
    L_0x00e1:
        r0 = r28;
        r3 = r0.f5097o;
        if (r3 == 0) goto L_0x00f6;
    L_0x00e7:
        r0 = r28;
        r3 = r0.f5095m;
        if (r3 != 0) goto L_0x00f6;
    L_0x00ed:
        r3 = com.tencent.smtt.sdk.QbSdk.f4786e;
        r4 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r3.onDownloadFinish(r4);
        goto L_0x000e;
    L_0x00f6:
        r0 = r28;
        r3 = r0.f5104v;
        r0 = r28;
        r4 = r0.f5084b;
        r4 = com.tencent.smtt.utils.Apn.getWifiSSID(r4);
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x0118;
    L_0x0108:
        r3 = "TbsDownload";
        r4 = "[TbsApkDownloader.startDownload] WIFI Unavailable";
        com.tencent.smtt.utils.TbsLog.m7927i(r3, r4);
        r3 = com.tencent.smtt.sdk.QbSdk.f4786e;
        r4 = 110; // 0x6e float:1.54E-43 double:5.43E-322;
        r3.onDownloadFinish(r4);
        goto L_0x000e;
    L_0x0118:
        r28.m7886g();
        r3 = "TbsDownload";
        r4 = "STEP 1/2 begin downloading...";
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);
        r0 = r28;
        r3 = r0.f5084b;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);
        r20 = r3.m7566a();
        r11 = 0;
    L_0x0130:
        r0 = r28;
        r3 = r0.f5093k;
        r4 = 5;
        if (r3 <= r4) goto L_0x01a9;
    L_0x0137:
        r3 = r11;
    L_0x0138:
        r0 = r28;
        r4 = r0.f5095m;
        if (r4 != 0) goto L_0x01a4;
    L_0x013e:
        r0 = r28;
        r4 = r0.f5096n;
        if (r4 == 0) goto L_0x0177;
    L_0x0144:
        if (r3 != 0) goto L_0x014f;
    L_0x0146:
        r3 = 1;
        r0 = r28;
        r1 = r19;
        r3 = r0.m7883a(r3, r1);
    L_0x014f:
        r0 = r28;
        r5 = r0.f5099q;
        if (r3 == 0) goto L_0x09f8;
    L_0x0155:
        r4 = 1;
    L_0x0156:
        r5.m7617d(r4);
        if (r19 != 0) goto L_0x09fe;
    L_0x015b:
        r0 = r28;
        r5 = r0.f5099q;
        if (r3 == 0) goto L_0x09fb;
    L_0x0161:
        r4 = 1;
    L_0x0162:
        r5.m7608b(r4);
    L_0x0165:
        if (r3 == 0) goto L_0x0a08;
    L_0x0167:
        r4 = 1;
        r0 = r28;
        r0.m7881a(r4);
        r4 = 100;
        r5 = "success";
        r6 = 1;
        r0 = r28;
        r0.m7876a(r4, r5, r6);
    L_0x0177:
        r0 = r28;
        r4 = r0.f5084b;
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r4);
        if (r3 == 0) goto L_0x0a10;
    L_0x0181:
        r5 = r4.f4827b;
        r6 = "tbs_download_success_retrytimes";
        r7 = 0;
        r5 = r5.getInt(r6, r7);
        r6 = r4.f4826a;
        r7 = "tbs_download_success_retrytimes";
        r5 = r5 + 1;
        r5 = java.lang.Integer.valueOf(r5);
        r6.put(r7, r5);
    L_0x0197:
        r4.m7572g();
        r0 = r28;
        r4 = r0.f5099q;
        if (r3 == 0) goto L_0x0a36;
    L_0x01a0:
        r3 = 1;
    L_0x01a1:
        r4.m7622f(r3);
    L_0x01a4:
        r28.m7887h();
        goto L_0x000e;
    L_0x01a9:
        r0 = r28;
        r3 = r0.f5094l;
        r4 = 8;
        if (r3 <= r4) goto L_0x01b3;
    L_0x01b1:
        r3 = r11;
        goto L_0x0138;
    L_0x01b3:
        r15 = java.lang.System.currentTimeMillis();
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.f4827b;	 Catch:{ Throwable -> 0x0455 }
        r4 = "tbs_downloadstarttime";
        r5 = 0;
        r3 = r3.getLong(r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r3 = r15 - r3;
        r5 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 <= 0) goto L_0x021d;
    L_0x01d2:
        r3 = "TbsDownload";
        r4 = "[TbsApkDownloader.startDownload] OVER DOWNLOAD_PERIOD";
        com.tencent.smtt.utils.TbsLog.m7927i(r3, r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.f4826a;	 Catch:{ Throwable -> 0x0455 }
        r4 = "tbs_downloadstarttime";
        r5 = java.lang.Long.valueOf(r15);	 Catch:{ Throwable -> 0x0455 }
        r3.put(r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.f4826a;	 Catch:{ Throwable -> 0x0455 }
        r4 = "tbs_downloadflow";
        r5 = 0;
        r5 = java.lang.Long.valueOf(r5);	 Catch:{ Throwable -> 0x0455 }
        r3.put(r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);	 Catch:{ Throwable -> 0x0455 }
        r3.m7572g();	 Catch:{ Throwable -> 0x0455 }
    L_0x020c:
        r3 = r28.m7900c();	 Catch:{ Throwable -> 0x0455 }
        if (r3 != 0) goto L_0x0256;
    L_0x0212:
        r3 = "TbsDownload";
        r4 = "DownloadBegin FreeSpace too small";
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r3 = r11;
        goto L_0x0138;
    L_0x021d:
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.f4827b;	 Catch:{ Throwable -> 0x0455 }
        r4 = "tbs_downloadflow";
        r5 = 0;
        r3 = r3.getLong(r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r6.<init>();	 Catch:{ Throwable -> 0x0455 }
        r7 = "[TbsApkDownloader.startDownload] downloadFlow=";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r6 = r6.append(r3);	 Catch:{ Throwable -> 0x0455 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0455 }
        com.tencent.smtt.utils.TbsLog.m7927i(r5, r6);	 Catch:{ Throwable -> 0x0455 }
        r3 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1));
        if (r3 < 0) goto L_0x020c;
    L_0x024b:
        r3 = "TbsDownload";
        r4 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r3 = r11;
        goto L_0x0138;
    L_0x0256:
        r3 = r28.m7899b();	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x025f;
    L_0x025c:
        r3 = r11;
        goto L_0x0138;
    L_0x025f:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r3.<init>();	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r4 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r4);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.f4827b;	 Catch:{ Throwable -> 0x0455 }
        r5 = "tbs_download_version";
        r6 = 0;
        r4 = r4.getInt(r5, r6);	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0455 }
        r4 = "|";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r15;
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r4 = r0.f5084b;	 Catch:{ Exception -> 0x044f }
        r4 = r4.getContentResolver();	 Catch:{ Exception -> 0x044f }
        r0 = r28;
        r5 = r0.f5098p;	 Catch:{ Exception -> 0x044f }
        android.provider.Settings.System.putString(r4, r5, r3);	 Catch:{ Exception -> 0x044f }
    L_0x0297:
        r3 = 1;
        r0 = r28;
        r0.f5102t = r3;	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5087e;	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x0477;
    L_0x02a2:
        r0 = r28;
        r3 = r0.f5087e;	 Catch:{ Throwable -> 0x0455 }
    L_0x02a6:
        r0 = r28;
        r4 = r0.f5086d;	 Catch:{ Throwable -> 0x0455 }
        r4 = r3.equals(r4);	 Catch:{ Throwable -> 0x0455 }
        if (r4 != 0) goto L_0x02b7;
    L_0x02b0:
        r0 = r28;
        r4 = r0.f5099q;	 Catch:{ Throwable -> 0x0455 }
        r4.m7605a(r3);	 Catch:{ Throwable -> 0x0455 }
    L_0x02b7:
        r0 = r28;
        r0.f5086d = r3;	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7880a(r3);	 Catch:{ Throwable -> 0x0455 }
        r7 = 0;
        r0 = r28;
        r3 = r0.f5092j;	 Catch:{ Throwable -> 0x0455 }
        if (r3 != 0) goto L_0x0329;
    L_0x02c8:
        r7 = r28.m7892m();	 Catch:{ Throwable -> 0x0455 }
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r4.<init>();	 Catch:{ Throwable -> 0x0455 }
        r5 = "[TbsApkDownloader.startDownload] range=";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0455 }
        com.tencent.smtt.utils.TbsLog.m7927i(r3, r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r5 = 0;
        r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r3 > 0) goto L_0x047d;
    L_0x02ee:
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r4.<init>();	 Catch:{ Throwable -> 0x0455 }
        r5 = "STEP 1/2 begin downloading...current";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0455 }
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ Throwable -> 0x0455 }
        r4 = "Range";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r5.<init>();	 Catch:{ Throwable -> 0x0455 }
        r6 = "bytes=";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x0455 }
        r5 = r5.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r6 = "-";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x0455 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0455 }
        r3.setRequestProperty(r4, r5);	 Catch:{ Throwable -> 0x0455 }
    L_0x0329:
        r0 = r28;
        r4 = r0.f5099q;	 Catch:{ Throwable -> 0x0455 }
        r5 = 0;
        r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));
        if (r3 != 0) goto L_0x04d0;
    L_0x0333:
        r3 = 0;
    L_0x0334:
        r4.m7613c(r3);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.utils.Apn.getApnType(r3);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r4 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r4 = com.tencent.smtt.utils.Apn.getApnInfo(r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r5 = r0.f5100r;	 Catch:{ Throwable -> 0x0455 }
        if (r5 != 0) goto L_0x04d3;
    L_0x034d:
        r0 = r28;
        r5 = r0.f5101s;	 Catch:{ Throwable -> 0x0455 }
        r6 = -1;
        if (r5 != r6) goto L_0x04d3;
    L_0x0354:
        r0 = r28;
        r0.f5100r = r4;	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.f5101s = r3;	 Catch:{ Throwable -> 0x0455 }
    L_0x035c:
        r0 = r28;
        r3 = r0.f5093k;	 Catch:{ Throwable -> 0x0455 }
        r4 = 1;
        if (r3 < r4) goto L_0x0370;
    L_0x0363:
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ Throwable -> 0x0455 }
        r4 = "Referer";
        r0 = r28;
        r5 = r0.f5085c;	 Catch:{ Throwable -> 0x0455 }
        r3.addRequestProperty(r4, r5);	 Catch:{ Throwable -> 0x0455 }
    L_0x0370:
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ Throwable -> 0x0455 }
        r5 = r3.getResponseCode();	 Catch:{ Throwable -> 0x0455 }
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r4.<init>();	 Catch:{ Throwable -> 0x0455 }
        r6 = "[TbsApkDownloader.startDownload] responseCode=";
        r4 = r4.append(r6);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0455 }
        com.tencent.smtt.utils.TbsLog.m7927i(r3, r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5099q;	 Catch:{ Throwable -> 0x0455 }
        r3.m7600a(r5);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r3);	 Catch:{ Throwable -> 0x0455 }
        if (r3 != 0) goto L_0x03d2;
    L_0x03a1:
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.utils.Apn.getApnType(r3);	 Catch:{ Throwable -> 0x0455 }
        r4 = 3;
        if (r3 == r4) goto L_0x03b2;
    L_0x03ac:
        r3 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x03bc;
    L_0x03b2:
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.utils.Apn.getApnType(r3);	 Catch:{ Throwable -> 0x0455 }
        if (r3 != 0) goto L_0x03d2;
    L_0x03bc:
        r28.m7902e();	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.QbSdk.f4786e;	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x03ca;
    L_0x03c3:
        r3 = com.tencent.smtt.sdk.QbSdk.f4786e;	 Catch:{ Throwable -> 0x0455 }
        r4 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r3.onDownloadFinish(r4);	 Catch:{ Throwable -> 0x0455 }
    L_0x03ca:
        r3 = "TbsDownload";
        r4 = "Download is canceled due to NOT_WIFI error!";
        r6 = 0;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r6);	 Catch:{ Throwable -> 0x0455 }
    L_0x03d2:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r3.<init>();	 Catch:{ Throwable -> 0x0455 }
        r4 = com.tencent.smtt.sdk.WebView.TBS_DEBUG_INSTALL_ONLINE;	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r4 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.getPackageName();	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0455 }
        r22 = r3.toString();	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.QbSdk.mTbsDebugInstallOnline;	 Catch:{ Throwable -> 0x0455 }
        if (r3 != 0) goto L_0x0446;
    L_0x03f1:
        r4 = 0;
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ SecurityException -> 0x04f5 }
        r3 = r3.getContentResolver();	 Catch:{ SecurityException -> 0x04f5 }
        r0 = r22;
        r3 = android.provider.Settings.System.getString(r3, r0);	 Catch:{ SecurityException -> 0x04f5 }
    L_0x0400:
        if (r3 == 0) goto L_0x0446;
    L_0x0402:
        r4 = "true";
        r3 = r3.equals(r4);	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x0446;
    L_0x040a:
        r3 = "TbsDownload";
        r4 = "tbs_debug_install_online #1";
        com.tencent.smtt.utils.TbsLog.m7931w(r3, r4);	 Catch:{ Throwable -> 0x0455 }
        r3 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        java.lang.Thread.sleep(r3);	 Catch:{ Exception -> 0x0a39 }
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ SecurityException -> 0x0509 }
        r3 = r3.getContentResolver();	 Catch:{ SecurityException -> 0x0509 }
        r0 = r22;
        r3 = android.provider.Settings.System.getString(r3, r0);	 Catch:{ SecurityException -> 0x0509 }
        if (r3 == 0) goto L_0x04fc;
    L_0x0427:
        r4 = "true";
        r3 = r3.equals(r4);	 Catch:{ SecurityException -> 0x0509 }
        if (r3 == 0) goto L_0x04fc;
    L_0x042f:
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ SecurityException -> 0x0509 }
        r3 = r3.getContentResolver();	 Catch:{ SecurityException -> 0x0509 }
        r4 = "false";
        r0 = r22;
        android.provider.Settings.System.putString(r3, r0, r4);	 Catch:{ SecurityException -> 0x0509 }
        r3 = "TbsDownload";
        r4 = "Downloading... Exceptions occurred for TbsDebugInstallOnline!";
        r6 = 1;
        com.tencent.smtt.utils.TbsLog.m7932w(r3, r4, r6);	 Catch:{ SecurityException -> 0x0509 }
    L_0x0446:
        r0 = r28;
        r3 = r0.f5095m;	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x050f;
    L_0x044c:
        r3 = r11;
        goto L_0x0138;
    L_0x044f:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ Throwable -> 0x0455 }
        goto L_0x0297;
    L_0x0455:
        r3 = move-exception;
        r3.printStackTrace();
        r4 = 0;
        r0 = r28;
        r0.m7877a(r4);
        r4 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r0 = r28;
        r3 = r0.m7874a(r3);
        r5 = 0;
        r0 = r28;
        r0.m7876a(r4, r3, r5);
        r0 = r28;
        r3 = r0.f5095m;
        if (r3 == 0) goto L_0x0130;
    L_0x0474:
        r3 = r11;
        goto L_0x0138;
    L_0x0477:
        r0 = r28;
        r3 = r0.f5085c;	 Catch:{ Throwable -> 0x0455 }
        goto L_0x02a6;
    L_0x047d:
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r4.<init>();	 Catch:{ Throwable -> 0x0455 }
        r5 = "#1 STEP 1/2 begin downloading...current/total=";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r5 = "/";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r5 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0455 }
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ Throwable -> 0x0455 }
        r4 = "Range";
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r5.<init>();	 Catch:{ Throwable -> 0x0455 }
        r6 = "bytes=";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x0455 }
        r5 = r5.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r6 = "-";
        r5 = r5.append(r6);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r9 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r5 = r5.append(r9);	 Catch:{ Throwable -> 0x0455 }
        r5 = r5.toString();	 Catch:{ Throwable -> 0x0455 }
        r3.setRequestProperty(r4, r5);	 Catch:{ Throwable -> 0x0455 }
        goto L_0x0329;
    L_0x04d0:
        r3 = 1;
        goto L_0x0334;
    L_0x04d3:
        r0 = r28;
        r5 = r0.f5101s;	 Catch:{ Throwable -> 0x0455 }
        if (r3 != r5) goto L_0x04e3;
    L_0x04d9:
        r0 = r28;
        r5 = r0.f5100r;	 Catch:{ Throwable -> 0x0455 }
        r5 = r4.equals(r5);	 Catch:{ Throwable -> 0x0455 }
        if (r5 != 0) goto L_0x035c;
    L_0x04e3:
        r0 = r28;
        r5 = r0.f5099q;	 Catch:{ Throwable -> 0x0455 }
        r6 = 0;
        r5.m7623g(r6);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.f5100r = r4;	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.f5101s = r3;	 Catch:{ Throwable -> 0x0455 }
        goto L_0x035c;
    L_0x04f5:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ Throwable -> 0x0455 }
        r3 = r4;
        goto L_0x0400;
    L_0x04fc:
        r28.m7902e();	 Catch:{ SecurityException -> 0x0509 }
        r3 = "TbsDownload";
        r4 = "Downloading...Canceled by TbsDebug!";
        r6 = 1;
        com.tencent.smtt.utils.TbsLog.m7932w(r3, r4, r6);	 Catch:{ SecurityException -> 0x0509 }
        goto L_0x0446;
    L_0x0509:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ Throwable -> 0x0455 }
        goto L_0x0446;
    L_0x050f:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r5 == r3) goto L_0x0517;
    L_0x0513:
        r3 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r5 != r3) goto L_0x0924;
    L_0x0517:
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.getContentLength();	 Catch:{ Throwable -> 0x0455 }
        r3 = (long) r3;	 Catch:{ Throwable -> 0x0455 }
        r3 = r3 + r7;
        r0 = r28;
        r0.f5089g = r3;	 Catch:{ Throwable -> 0x0455 }
        r3 = "TbsDownload";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r4.<init>();	 Catch:{ Throwable -> 0x0455 }
        r5 = "[TbsApkDownloader.startDownload] mContentLength=";
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r5 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x0455 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0455 }
        com.tencent.smtt.utils.TbsLog.m7927i(r3, r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5099q;	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r4 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r3.m7610b(r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r3);	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.f4827b;	 Catch:{ Throwable -> 0x0455 }
        r4 = "tbs_apkfilesize";
        r5 = 0;
        r3 = r3.getLong(r4, r5);	 Catch:{ Throwable -> 0x0455 }
        r5 = 0;
        r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r5 == 0) goto L_0x05e0;
    L_0x0564:
        r0 = r28;
        r5 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x05e0;
    L_0x056c:
        r5 = "TbsDownload";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r6.<init>();	 Catch:{ Throwable -> 0x0455 }
        r7 = "DownloadBegin tbsApkFileSize=";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r6 = r6.append(r3);	 Catch:{ Throwable -> 0x0455 }
        r7 = "  but contentLength=";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r7 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0455 }
        r7 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r5, r6, r7);	 Catch:{ Throwable -> 0x0455 }
        r5 = r28.m7895p();	 Catch:{ Throwable -> 0x0455 }
        if (r5 != 0) goto L_0x05a9;
    L_0x0599:
        r5 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ Throwable -> 0x0455 }
        if (r5 == 0) goto L_0x05d5;
    L_0x059f:
        r0 = r28;
        r5 = r0.f5084b;	 Catch:{ Throwable -> 0x0455 }
        r5 = com.tencent.smtt.utils.Apn.isNetworkAvailable(r5);	 Catch:{ Throwable -> 0x0455 }
        if (r5 == 0) goto L_0x05d5;
    L_0x05a9:
        r5 = 113; // 0x71 float:1.58E-43 double:5.6E-322;
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0455 }
        r6.<init>();	 Catch:{ Throwable -> 0x0455 }
        r7 = "tbsApkFileSize=";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0455 }
        r3 = r6.append(r3);	 Catch:{ Throwable -> 0x0455 }
        r4 = "  but contentLength=";
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r6 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.append(r6);	 Catch:{ Throwable -> 0x0455 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0455 }
        r4 = 1;
        r0 = r28;
        r0.m7876a(r5, r3, r4);	 Catch:{ Throwable -> 0x0455 }
    L_0x05d2:
        r3 = r11;
        goto L_0x0138;
    L_0x05d5:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r4 = "WifiNetworkUnAvailable";
        r5 = 1;
        r0 = r28;
        r0.m7876a(r3, r4, r5);	 Catch:{ Throwable -> 0x0455 }
        goto L_0x05d2;
    L_0x05e0:
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ IOException -> 0x0a4e, all -> 0x0a3f }
        r13 = r3.getInputStream();	 Catch:{ IOException -> 0x0a4e, all -> 0x0a3f }
        if (r13 == 0) goto L_0x0a5a;
    L_0x05ed:
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        r3 = r3.getContentEncoding();	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        if (r3 == 0) goto L_0x069a;
    L_0x05f7:
        r5 = "gzip";
        r5 = r3.contains(r5);	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        if (r5 == 0) goto L_0x069a;
    L_0x05ff:
        r12 = new java.util.zip.GZIPInputStream;	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        r12.<init>(r13);	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
    L_0x0604:
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = new byte[r3];	 Catch:{ IOException -> 0x0a51, all -> 0x0a4a }
        r23 = r0;
        r14 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0a51, all -> 0x0a4a }
        r3 = new java.io.File;	 Catch:{ IOException -> 0x0a51, all -> 0x0a4a }
        r0 = r28;
        r4 = r0.f5088f;	 Catch:{ IOException -> 0x0a51, all -> 0x0a4a }
        r5 = "x5.tbs.temp";
        r3.<init>(r4, r5);	 Catch:{ IOException -> 0x0a51, all -> 0x0a4a }
        r4 = 1;
        r14.<init>(r3, r4);	 Catch:{ IOException -> 0x0a51, all -> 0x0a4a }
        r9 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r3 = r7;
        r26 = r7;
        r7 = r15;
        r15 = r26;
    L_0x0625:
        r5 = com.tencent.smtt.sdk.QbSdk.mTbsDebugInstallOnline;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r5 != 0) goto L_0x067a;
    L_0x0629:
        r6 = 0;
        r0 = r28;
        r5 = r0.f5084b;	 Catch:{ SecurityException -> 0x06f1 }
        r5 = r5.getContentResolver();	 Catch:{ SecurityException -> 0x06f1 }
        r0 = r22;
        r6 = android.provider.Settings.System.getString(r5, r0);	 Catch:{ SecurityException -> 0x06f1 }
    L_0x0638:
        if (r6 == 0) goto L_0x067a;
    L_0x063a:
        r5 = "true";
        r5 = r6.equals(r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r5 == 0) goto L_0x067a;
    L_0x0642:
        r17 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        java.lang.Thread.sleep(r17);	 Catch:{ Exception -> 0x0a3c }
        r0 = r28;
        r5 = r0.f5084b;	 Catch:{ SecurityException -> 0x06fc }
        r5 = r5.getContentResolver();	 Catch:{ SecurityException -> 0x06fc }
        r0 = r22;
        r5 = android.provider.Settings.System.getString(r5, r0);	 Catch:{ SecurityException -> 0x06fc }
    L_0x0656:
        if (r5 == 0) goto L_0x071a;
    L_0x0658:
        r6 = "true";
        r5 = r5.equals(r6);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r5 == 0) goto L_0x071a;
    L_0x0660:
        r0 = r28;
        r5 = r0.f5084b;	 Catch:{ SecurityException -> 0x0703 }
        r5 = r5.getContentResolver();	 Catch:{ SecurityException -> 0x0703 }
        r6 = "false";
        r0 = r22;
        android.provider.Settings.System.putString(r5, r0, r6);	 Catch:{ SecurityException -> 0x0703 }
        r5 = "TbsDownload";
        r6 = "STEP 1/2 begin downloading... Exceptions occurred for TbsDebugInstallOnline!";
        r17 = 1;
        r0 = r17;
        com.tencent.smtt.utils.TbsLog.m7932w(r5, r6, r0);	 Catch:{ SecurityException -> 0x0703 }
    L_0x067a:
        r0 = r28;
        r5 = r0.f5095m;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r5 == 0) goto L_0x072a;
    L_0x0680:
        r3 = "TbsDownload";
        r4 = "STEP 1/2 begin downloading...Canceled!";
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
    L_0x0688:
        r0 = r28;
        r0.m7878a(r14);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r12);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r13);	 Catch:{ Throwable -> 0x0455 }
        r3 = r11;
        goto L_0x0138;
    L_0x069a:
        if (r3 == 0) goto L_0x06ee;
    L_0x069c:
        r5 = "deflate";
        r3 = r3.contains(r5);	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        if (r3 == 0) goto L_0x06ee;
    L_0x06a4:
        r12 = new java.util.zip.InflaterInputStream;	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        r3 = new java.util.zip.Inflater;	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        r5 = 1;
        r3.<init>(r5);	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        r12.<init>(r13, r3);	 Catch:{ IOException -> 0x06b1, all -> 0x0a45 }
        goto L_0x0604;
    L_0x06b1:
        r3 = move-exception;
        r5 = r13;
    L_0x06b3:
        r3.printStackTrace();	 Catch:{ all -> 0x091e }
        r7 = r3 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x091e }
        if (r7 != 0) goto L_0x06be;
    L_0x06ba:
        r7 = r3 instanceof java.net.SocketException;	 Catch:{ all -> 0x091e }
        if (r7 == 0) goto L_0x088e;
    L_0x06be:
        r7 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r0 = r28;
        r0.f5090h = r7;	 Catch:{ all -> 0x091e }
        r0 = r28;
        r7 = r0.f5093k;	 Catch:{ all -> 0x091e }
        r7 = r7 + 1;
        r0 = r28;
        r0.f5093k = r7;	 Catch:{ all -> 0x091e }
        r7 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r0 = r28;
        r3 = r0.m7874a(r3);	 Catch:{ all -> 0x091e }
        r8 = 0;
        r0 = r28;
        r0.m7876a(r7, r3, r8);	 Catch:{ all -> 0x091e }
        r0 = r28;
        r0.m7878a(r6);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r5);	 Catch:{ Throwable -> 0x0455 }
        goto L_0x0130;
    L_0x06ee:
        r12 = r13;
        goto L_0x0604;
    L_0x06f1:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        goto L_0x0638;
    L_0x06f7:
        r3 = move-exception;
        r4 = r12;
        r5 = r13;
        r6 = r14;
        goto L_0x06b3;
    L_0x06fc:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = r6;
        goto L_0x0656;
    L_0x0703:
        r5 = move-exception;
        r5.printStackTrace();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        goto L_0x067a;
    L_0x0709:
        r3 = move-exception;
    L_0x070a:
        r0 = r28;
        r0.m7878a(r14);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r12);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r13);	 Catch:{ Throwable -> 0x0455 }
        throw r3;	 Catch:{ Throwable -> 0x0455 }
    L_0x071a:
        r28.m7902e();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = "TbsDownload";
        r6 = "STEP 1/2 begin downloading...Canceled by TbsDebug!";
        r17 = 1;
        r0 = r17;
        com.tencent.smtt.utils.TbsLog.m7932w(r5, r6, r0);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        goto L_0x067a;
    L_0x072a:
        r5 = 0;
        r6 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0 = r23;
        r5 = r12.read(r0, r5, r6);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r5 > 0) goto L_0x073c;
    L_0x0735:
        r3 = 1;
        r0 = r28;
        r0.f5096n = r3;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        goto L_0x0688;
    L_0x073c:
        r6 = 0;
        r0 = r23;
        r14.write(r0, r6, r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r14.flush();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = r28;
        r6 = r0.f5084b;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r6 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r6);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r6 = r6.f4827b;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r17 = "tbs_downloadflow";
        r24 = 0;
        r0 = r17;
        r1 = r24;
        r17 = r6.getLong(r0, r1);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = (long) r5;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r24 = r0;
        r17 = r17 + r24;
        r0 = r28;
        r6 = r0.f5084b;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r6 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r6);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r6 = r6.f4826a;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r24 = "tbs_downloadflow";
        r25 = java.lang.Long.valueOf(r17);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = r24;
        r1 = r25;
        r6.put(r0, r1);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = r28;
        r6 = r0.f5084b;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r6 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r6);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r6.m7572g();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r6 = (r17 > r20 ? 1 : (r17 == r20 ? 0 : -1));
        if (r6 < 0) goto L_0x0799;
    L_0x0786:
        r3 = "TbsDownload";
        r4 = "STEP 1/2 begin downloading...failed because you exceeded max flow!";
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r3 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r4 = 0;
        r5 = 1;
        r0 = r28;
        r0.m7876a(r3, r4, r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        goto L_0x0688;
    L_0x0799:
        r6 = r28.m7900c();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r6 != 0) goto L_0x07e6;
    L_0x079f:
        r3 = "TbsDownload";
        r4 = "DownloadEnd FreeSpace too small ";
        r5 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r3 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r4.<init>();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = "freespace=";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = r28;
        r5 = r0.f5088f;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = r5.getAbsolutePath();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = com.tencent.smtt.utils.C1146j.m7973a(r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = ",and minFreeSpace=";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = r28;
        r5 = r0.f5084b;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = r5.m7568c();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = 1;
        r0 = r28;
        r0.m7876a(r3, r4, r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        goto L_0x0688;
    L_0x07e6:
        r0 = (long) r5;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r17 = r0;
        r0 = r28;
        r1 = r17;
        r17 = r0.m7872a(r7, r1);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = (long) r5;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r5 = r5 + r15;
        r15 = r7 - r9;
        r24 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r15 = (r15 > r24 ? 1 : (r15 == r24 ? 0 : -1));
        if (r15 <= 0) goto L_0x0a56;
    L_0x07ff:
        r9 = "TbsDownload";
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r10.<init>();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r15 = "#2 STEP 1/2 begin downloading...current/total=";
        r10 = r10.append(r15);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r10 = r10.append(r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r15 = "/";
        r10 = r10.append(r15);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = r28;
        r15 = r0.f5089g;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = r15;
        r10 = r10.append(r0);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r10 = r10.toString();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r15 = 1;
        com.tencent.smtt.utils.TbsLog.m7928i(r9, r10, r15);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r9 = com.tencent.smtt.sdk.QbSdk.f4786e;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r9 == 0) goto L_0x083b;
    L_0x082b:
        r9 = (double) r5;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r0 = r28;
        r15 = r0.f5089g;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r15 = (double) r15;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r9 = r9 / r15;
        r15 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r9 = r9 * r15;
        r9 = (int) r9;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r10 = com.tencent.smtt.sdk.QbSdk.f4786e;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r10.onDownloadProgress(r9);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
    L_0x083b:
        r9 = r5 - r3;
        r15 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r9 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1));
        if (r9 <= 0) goto L_0x0882;
    L_0x0844:
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r3 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r3);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r3 != 0) goto L_0x0881;
    L_0x084e:
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r3 = com.tencent.smtt.utils.Apn.getApnType(r3);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r4 = 3;
        if (r3 == r4) goto L_0x085f;
    L_0x0859:
        r3 = com.tencent.smtt.sdk.QbSdk.getDownloadWithoutWifi();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r3 == 0) goto L_0x0869;
    L_0x085f:
        r0 = r28;
        r3 = r0.f5084b;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r3 = com.tencent.smtt.utils.Apn.getApnType(r3);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r3 != 0) goto L_0x0881;
    L_0x0869:
        r28.m7902e();	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r3 = com.tencent.smtt.sdk.QbSdk.f4786e;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        if (r3 == 0) goto L_0x0877;
    L_0x0870:
        r3 = com.tencent.smtt.sdk.QbSdk.f4786e;	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        r4 = 111; // 0x6f float:1.56E-43 double:5.5E-322;
        r3.onDownloadFinish(r4);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
    L_0x0877:
        r3 = "TbsDownload";
        r4 = "Download is paused due to NOT_WIFI error!";
        r5 = 0;
        com.tencent.smtt.utils.TbsLog.m7928i(r3, r4, r5);	 Catch:{ IOException -> 0x06f7, all -> 0x0709 }
        goto L_0x0688;
    L_0x0881:
        r3 = r5;
    L_0x0882:
        r26 = r7;
        r7 = r3;
        r3 = r26;
    L_0x0887:
        r9 = r3;
        r15 = r5;
        r3 = r7;
        r7 = r17;
        goto L_0x0625;
    L_0x088e:
        r7 = r28.m7900c();	 Catch:{ all -> 0x091e }
        if (r7 != 0) goto L_0x08e3;
    L_0x0894:
        r3 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x091e }
        r7.<init>();	 Catch:{ all -> 0x091e }
        r8 = "freespace=";
        r7 = r7.append(r8);	 Catch:{ all -> 0x091e }
        r0 = r28;
        r8 = r0.f5088f;	 Catch:{ all -> 0x091e }
        r8 = r8.getAbsolutePath();	 Catch:{ all -> 0x091e }
        r8 = com.tencent.smtt.utils.C1146j.m7973a(r8);	 Catch:{ all -> 0x091e }
        r7 = r7.append(r8);	 Catch:{ all -> 0x091e }
        r8 = ",and minFreeSpace=";
        r7 = r7.append(r8);	 Catch:{ all -> 0x091e }
        r0 = r28;
        r8 = r0.f5084b;	 Catch:{ all -> 0x091e }
        r8 = com.tencent.smtt.sdk.TbsDownloadConfig.m7565a(r8);	 Catch:{ all -> 0x091e }
        r8 = r8.m7568c();	 Catch:{ all -> 0x091e }
        r7 = r7.append(r8);	 Catch:{ all -> 0x091e }
        r7 = r7.toString();	 Catch:{ all -> 0x091e }
        r8 = 1;
        r0 = r28;
        r0.m7876a(r3, r7, r8);	 Catch:{ all -> 0x091e }
        r0 = r28;
        r0.m7878a(r6);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r5);	 Catch:{ Throwable -> 0x0455 }
        r3 = r11;
        goto L_0x0138;
    L_0x08e3:
        r7 = 0;
        r0 = r28;
        r0.m7877a(r7);	 Catch:{ all -> 0x091e }
        r7 = r28.m7891l();	 Catch:{ all -> 0x091e }
        if (r7 != 0) goto L_0x090f;
    L_0x08f0:
        r7 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r0 = r28;
        r3 = r0.m7874a(r3);	 Catch:{ all -> 0x091e }
        r8 = 0;
        r0 = r28;
        r0.m7876a(r7, r3, r8);	 Catch:{ all -> 0x091e }
    L_0x08fe:
        r0 = r28;
        r0.m7878a(r6);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r4);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7878a(r5);	 Catch:{ Throwable -> 0x0455 }
        goto L_0x0130;
    L_0x090f:
        r7 = 104; // 0x68 float:1.46E-43 double:5.14E-322;
        r0 = r28;
        r3 = r0.m7874a(r3);	 Catch:{ all -> 0x091e }
        r8 = 0;
        r0 = r28;
        r0.m7876a(r7, r3, r8);	 Catch:{ all -> 0x091e }
        goto L_0x08fe;
    L_0x091e:
        r3 = move-exception;
        r12 = r4;
        r13 = r5;
        r14 = r6;
        goto L_0x070a;
    L_0x0924:
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r5 < r3) goto L_0x094f;
    L_0x0928:
        r3 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r5 > r3) goto L_0x094f;
    L_0x092c:
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ Throwable -> 0x0455 }
        r4 = "Location";
        r3 = r3.getHeaderField(r4);	 Catch:{ Throwable -> 0x0455 }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0455 }
        if (r4 != 0) goto L_0x094c;
    L_0x093c:
        r0 = r28;
        r0.f5087e = r3;	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5094l;	 Catch:{ Throwable -> 0x0455 }
        r3 = r3 + 1;
        r0 = r28;
        r0.f5094l = r3;	 Catch:{ Throwable -> 0x0455 }
        goto L_0x0130;
    L_0x094c:
        r3 = r11;
        goto L_0x0138;
    L_0x094f:
        r3 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        r4 = 0;
        r6 = 0;
        r0 = r28;
        r0.m7876a(r3, r4, r6);	 Catch:{ Throwable -> 0x0455 }
        r3 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r5 != r3) goto L_0x0973;
    L_0x095c:
        r3 = 1;
        r0 = r28;
        r1 = r19;
        r3 = r0.m7883a(r3, r1);	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x096a;
    L_0x0967:
        r3 = 1;
        goto L_0x0138;
    L_0x096a:
        r3 = 0;
        r0 = r28;
        r0.m7885b(r3);	 Catch:{ Throwable -> 0x0455 }
        r3 = r11;
        goto L_0x0138;
    L_0x0973:
        r3 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r5 == r3) goto L_0x097b;
    L_0x0977:
        r3 = 406; // 0x196 float:5.69E-43 double:2.006E-321;
        if (r5 != r3) goto L_0x0988;
    L_0x097b:
        r0 = r28;
        r3 = r0.f5089g;	 Catch:{ Throwable -> 0x0455 }
        r6 = -1;
        r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r3 != 0) goto L_0x0988;
    L_0x0985:
        r3 = r11;
        goto L_0x0138;
    L_0x0988:
        r3 = 202; // 0xca float:2.83E-43 double:1.0E-321;
        if (r5 == r3) goto L_0x0130;
    L_0x098c:
        r0 = r28;
        r3 = r0.f5093k;	 Catch:{ Throwable -> 0x0455 }
        r4 = 5;
        if (r3 >= r4) goto L_0x09b3;
    L_0x0993:
        r3 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
        if (r5 != r3) goto L_0x09b3;
    L_0x0997:
        r0 = r28;
        r3 = r0.f5097o;	 Catch:{ Throwable -> 0x0455 }
        r4 = "Retry-After";
        r3 = r3.getHeaderField(r4);	 Catch:{ Throwable -> 0x0455 }
        r3 = java.lang.Long.parseLong(r3);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r0.m7877a(r3);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5095m;	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x0130;
    L_0x09b0:
        r3 = r11;
        goto L_0x0138;
    L_0x09b3:
        r0 = r28;
        r3 = r0.f5093k;	 Catch:{ Throwable -> 0x0455 }
        r4 = 5;
        if (r3 >= r4) goto L_0x09da;
    L_0x09ba:
        r3 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r5 == r3) goto L_0x09ca;
    L_0x09be:
        r3 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        if (r5 == r3) goto L_0x09ca;
    L_0x09c2:
        r3 = 502; // 0x1f6 float:7.03E-43 double:2.48E-321;
        if (r5 == r3) goto L_0x09ca;
    L_0x09c6:
        r3 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r5 != r3) goto L_0x09da;
    L_0x09ca:
        r3 = 0;
        r0 = r28;
        r0.m7877a(r3);	 Catch:{ Throwable -> 0x0455 }
        r0 = r28;
        r3 = r0.f5095m;	 Catch:{ Throwable -> 0x0455 }
        if (r3 == 0) goto L_0x0130;
    L_0x09d7:
        r3 = r11;
        goto L_0x0138;
    L_0x09da:
        r3 = r28.m7892m();	 Catch:{ Throwable -> 0x0455 }
        r6 = 0;
        r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r3 > 0) goto L_0x09f5;
    L_0x09e4:
        r0 = r28;
        r3 = r0.f5092j;	 Catch:{ Throwable -> 0x0455 }
        if (r3 != 0) goto L_0x09f5;
    L_0x09ea:
        r3 = 410; // 0x19a float:5.75E-43 double:2.026E-321;
        if (r5 == r3) goto L_0x09f5;
    L_0x09ee:
        r3 = 1;
        r0 = r28;
        r0.f5092j = r3;	 Catch:{ Throwable -> 0x0455 }
        goto L_0x0130;
    L_0x09f5:
        r3 = r11;
        goto L_0x0138;
    L_0x09f8:
        r4 = 0;
        goto L_0x0156;
    L_0x09fb:
        r4 = 2;
        goto L_0x0162;
    L_0x09fe:
        r0 = r28;
        r4 = r0.f5099q;
        r5 = 0;
        r4.m7608b(r5);
        goto L_0x0165;
    L_0x0a08:
        r4 = 0;
        r0 = r28;
        r0.m7885b(r4);
        goto L_0x0177;
    L_0x0a10:
        r5 = r4.f4827b;
        r6 = "tbs_download_failed_retrytimes";
        r7 = 0;
        r5 = r5.getInt(r6, r7);
        r6 = r4.f4826a;
        r7 = "tbs_download_failed_retrytimes";
        r5 = r5 + 1;
        r8 = java.lang.Integer.valueOf(r5);
        r6.put(r7, r8);
        r6 = r4.m7570e();
        if (r5 != r6) goto L_0x0197;
    L_0x0a2c:
        r0 = r28;
        r5 = r0.f5099q;
        r6 = 2;
        r5.m7613c(r6);
        goto L_0x0197;
    L_0x0a36:
        r3 = 0;
        goto L_0x01a1;
    L_0x0a39:
        r3 = move-exception;
        goto L_0x0130;
    L_0x0a3c:
        r5 = move-exception;
        goto L_0x0625;
    L_0x0a3f:
        r3 = move-exception;
        r12 = r4;
        r13 = r5;
        r14 = r6;
        goto L_0x070a;
    L_0x0a45:
        r3 = move-exception;
        r12 = r4;
        r14 = r6;
        goto L_0x070a;
    L_0x0a4a:
        r3 = move-exception;
        r14 = r6;
        goto L_0x070a;
    L_0x0a4e:
        r3 = move-exception;
        goto L_0x06b3;
    L_0x0a51:
        r3 = move-exception;
        r4 = r12;
        r5 = r13;
        goto L_0x06b3;
    L_0x0a56:
        r7 = r3;
        r3 = r9;
        goto L_0x0887;
    L_0x0a5a:
        r12 = r4;
        r14 = r6;
        goto L_0x0688;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.w.a():void");
    }

    /* renamed from: a */
    public void m7898a(int i) {
        try {
            File file = new File(this.f5088f, "x5.tbs");
            int a = C1134a.m7938a(this.f5084b, file);
            if (-1 == a || (i > 0 && i == a)) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public boolean m7899b() {
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        int i = TbsDownloadConfig.m7565a(this.f5084b).f4827b.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        for (String str : f5083a) {
            String str2;
            if (!str2.equals(this.f5098p)) {
                try {
                    str2 = System.getString(this.f5084b.getContentResolver(), str2);
                } catch (SecurityException e) {
                    e.printStackTrace();
                    str2 = null;
                }
                if (str2 != null) {
                    try {
                        String[] split = str2.split("\\|");
                        String str3 = split[0];
                        long parseLong = Long.parseLong(split[1]);
                        if (str3 != null && str3.equals(String.valueOf(i)) && parseLong > 0 && currentTimeMillis - parseLong < TbsDownloadConfig.m7565a(this.f5084b).m7571f()) {
                            break;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else {
                    continue;
                }
            }
        }
        z = false;
        TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloader.hasSameTbsDownloading] result=" + z);
        return z;
    }

    /* renamed from: c */
    public boolean m7900c() {
        long a = C1146j.m7973a(this.f5088f.getAbsolutePath());
        boolean z = a >= TbsDownloadConfig.m7565a(this.f5084b).m7568c();
        if (!z) {
            TbsLog.m7925e(TbsDownloader.LOGTAG, "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + a);
        }
        return z;
    }

    /* renamed from: d */
    public int m7901d() {
        File a = C1129w.m7873a(this.f5084b);
        if (a == null) {
            return 0;
        }
        return C1134a.m7938a(this.f5084b, new File(a, TbsDownloader.getOverSea(this.f5084b) ? "x5.oversea.tbs.org" : "x5.tbs.org"));
    }

    /* renamed from: e */
    public void m7902e() {
        this.f5095m = true;
    }

    /* renamed from: f */
    public void m7903f() {
        m7902e();
        m7885b(false);
        m7885b(true);
    }
}
