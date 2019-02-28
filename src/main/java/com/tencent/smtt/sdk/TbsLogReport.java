package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C1135b;
import com.tencent.smtt.utils.C1146j;
import com.tencent.smtt.utils.C1149m;
import com.tencent.smtt.utils.C1151o;
import com.tencent.smtt.utils.C1158v;
import com.tencent.smtt.utils.C1159w;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import p054u.aly.bi_常量类;

class TbsLogReport {
    /* renamed from: b */
    private static TbsLogReport f4844b;
    /* renamed from: a */
    int f4845a;
    /* renamed from: c */
    private Context f4846c;
    /* renamed from: d */
    private long f4847d;
    /* renamed from: e */
    private String f4848e;
    /* renamed from: f */
    private String f4849f;
    /* renamed from: g */
    private int f4850g;
    /* renamed from: h */
    private int f4851h;
    /* renamed from: i */
    private int f4852i;
    /* renamed from: j */
    private int f4853j;
    /* renamed from: k */
    private String f4854k;
    /* renamed from: l */
    private int f4855l;
    /* renamed from: m */
    private int f4856m;
    /* renamed from: n */
    private long f4857n;
    /* renamed from: o */
    private long f4858o;
    /* renamed from: p */
    private int f4859p;
    /* renamed from: q */
    private String f4860q;
    /* renamed from: r */
    private String f4861r;
    /* renamed from: s */
    private long f4862s;

    public enum EventType {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2);
        
        /* renamed from: a */
        int f4841a;

        private EventType(int i) {
            this.f4841a = i;
        }
    }

    public static class ZipHelper {
        /* renamed from: a */
        private final String f4842a;
        /* renamed from: b */
        private final String f4843b;

        public ZipHelper(String str, String str2) {
            this.f4842a = str;
            this.f4843b = str2;
        }

        /* renamed from: a */
        private static void m7588a(File file) {
            Exception e;
            Throwable th;
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
                if (randomAccessFile != null) {
                    try {
                        int parseInt = Integer.parseInt("00001000", 2);
                        randomAccessFile.seek(7);
                        int read = randomAccessFile.read();
                        if ((read & parseInt) > 0) {
                            randomAccessFile.seek(7);
                            randomAccessFile.write(((parseInt ^ -1) & WebView.NORMAL_MODE_ALPHA) & read);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            e.printStackTrace();
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e32) {
                        e32.printStackTrace();
                    }
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile = null;
                e.printStackTrace();
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        }

        public void Zip() {
            ZipOutputStream zipOutputStream;
            FileInputStream fileInputStream;
            BufferedInputStream bufferedInputStream;
            Exception e;
            FileInputStream fileInputStream2;
            Throwable th;
            FileOutputStream fileOutputStream;
            ZipOutputStream zipOutputStream2 = null;
            FileOutputStream fileOutputStream2;
            try {
                fileOutputStream2 = new FileOutputStream(this.f4843b);
                try {
                    zipOutputStream = new ZipOutputStream(new BufferedOutputStream(fileOutputStream2));
                    try {
                        byte[] bArr = new byte[2048];
                        String str = this.f4842a;
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                bufferedInputStream = new BufferedInputStream(fileInputStream, 2048);
                            } catch (Exception e2) {
                                e = e2;
                                bufferedInputStream = null;
                                fileInputStream2 = fileInputStream;
                                try {
                                    e.printStackTrace();
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream2 != null) {
                                        try {
                                            fileInputStream2.close();
                                        } catch (IOException e32) {
                                            e32.printStackTrace();
                                        }
                                    }
                                    m7588a(new File(this.f4843b));
                                    if (zipOutputStream != null) {
                                        try {
                                            zipOutputStream.close();
                                        } catch (IOException e322) {
                                            e322.printStackTrace();
                                        }
                                    }
                                    if (fileOutputStream2 == null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e3222) {
                                            e3222.printStackTrace();
                                            return;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    if (bufferedInputStream != null) {
                                        try {
                                            bufferedInputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e42) {
                                            e42.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedInputStream = null;
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                            try {
                                zipOutputStream.putNextEntry(new ZipEntry(str.substring(str.lastIndexOf("/") + 1)));
                                while (true) {
                                    int read = bufferedInputStream.read(bArr, 0, 2048);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                }
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e32222) {
                                        e32222.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e322222) {
                                        e322222.printStackTrace();
                                    }
                                }
                            } catch (Exception e5) {
                                e = e5;
                                fileInputStream2 = fileInputStream;
                                e.printStackTrace();
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream2 != null) {
                                    fileInputStream2.close();
                                }
                                m7588a(new File(this.f4843b));
                                if (zipOutputStream != null) {
                                    zipOutputStream.close();
                                }
                                if (fileOutputStream2 == null) {
                                    fileOutputStream2.close();
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            bufferedInputStream = null;
                            e.printStackTrace();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            m7588a(new File(this.f4843b));
                            if (zipOutputStream != null) {
                                zipOutputStream.close();
                            }
                            if (fileOutputStream2 == null) {
                                fileOutputStream2.close();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedInputStream = null;
                            fileInputStream = null;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                        m7588a(new File(this.f4843b));
                        if (zipOutputStream != null) {
                            zipOutputStream.close();
                        }
                        if (fileOutputStream2 == null) {
                            fileOutputStream2.close();
                        }
                    } catch (Exception e7) {
                        e = e7;
                        zipOutputStream2 = zipOutputStream;
                        fileOutputStream = fileOutputStream2;
                        try {
                            e.printStackTrace();
                            if (zipOutputStream2 != null) {
                                try {
                                    zipOutputStream2.close();
                                } catch (IOException e3222222) {
                                    e3222222.printStackTrace();
                                }
                            }
                            if (fileOutputStream == null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e32222222) {
                                    e32222222.printStackTrace();
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            zipOutputStream = zipOutputStream2;
                            fileOutputStream2 = fileOutputStream;
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e422) {
                                    e422.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e4222) {
                                    e4222.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        if (zipOutputStream != null) {
                            zipOutputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (zipOutputStream2 != null) {
                        zipOutputStream2.close();
                    }
                    if (fileOutputStream == null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th8) {
                    th = th8;
                    zipOutputStream = null;
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
                e.printStackTrace();
                if (zipOutputStream2 != null) {
                    zipOutputStream2.close();
                }
                if (fileOutputStream == null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th9) {
                th = th9;
                zipOutputStream = null;
                fileOutputStream2 = null;
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        }
    }

    private TbsLogReport(Context context) {
        this.f4846c = context.getApplicationContext();
        m7592e();
    }

    /* renamed from: a */
    public static synchronized TbsLogReport m7589a(Context context) {
        TbsLogReport tbsLogReport;
        synchronized (TbsLogReport.class) {
            if (f4844b == null) {
                f4844b = new TbsLogReport(context);
            }
            tbsLogReport = f4844b;
        }
        return tbsLogReport;
    }

    /* renamed from: e */
    private String m7591e(long j) {
        String str = null;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
        }
        return str;
    }

    /* renamed from: e */
    private void m7592e() {
        this.f4847d = 0;
        this.f4848e = null;
        this.f4849f = null;
        this.f4850g = 0;
        this.f4851h = 0;
        this.f4852i = 0;
        this.f4853j = 2;
        this.f4854k = "unknown";
        this.f4855l = 0;
        this.f4856m = 2;
        this.f4857n = 0;
        this.f4858o = 0;
        this.f4859p = 1;
        this.f4845a = 0;
        this.f4860q = null;
        this.f4861r = null;
        this.f4862s = 0;
    }

    /* renamed from: f */
    private String m7593f(long j) {
        return j + "|";
    }

    /* renamed from: f */
    private String m7594f(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = bi_常量类.f6358b_空串;
        }
        return stringBuilder.append(str).append("|").toString();
    }

    /* renamed from: f */
    private JSONArray m7595f() {
        String string = m7597h().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            return new JSONArray(string);
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    /* renamed from: g */
    private void m7596g() {
        Editor edit = m7597h().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    /* renamed from: h */
    private SharedPreferences m7597h() {
        return this.f4846c.getSharedPreferences("tbs_download_stat", 4);
    }

    /* renamed from: i */
    private String m7598i(int i) {
        return i + "|";
    }

    /* renamed from: a */
    public void m7599a() {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (Apn.getApnType(this.f4846c) == 3) {
            String tbsLogFilePath = TbsLog.getTbsLogFilePath();
            if (tbsLogFilePath != null) {
                String b = C1151o.m8008a().m8011b();
                String c = C1135b.m7952c(this.f4846c);
                String f = C1135b.m7955f(this.f4846c);
                byte[] bytes = c.getBytes();
                byte[] bytes2 = f.getBytes();
                try {
                    bytes = C1151o.m8008a().m8010a(bytes);
                    bytes2 = C1151o.m8008a().m8010a(bytes2);
                } catch (Exception e2) {
                }
                String b2 = C1151o.m8009b(bytes);
                String str = C1159w.m8057a(this.f4846c).m8063e() + b2 + "&aid=" + C1151o.m8009b(bytes2);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Charset", "UTF-8");
                hashMap.put("QUA2", C1158v.m8046a(this.f4846c));
                File file;
                ByteArrayOutputStream byteArrayOutputStream2;
                try {
                    File file2 = new File(C1146j.f5139a);
                    new ZipHelper(tbsLogFilePath, C1146j.f5139a + "/tbslog_temp.zip").Zip();
                    file = new File(C1146j.f5139a, "tbslog_temp.zip");
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            bytes2 = new byte[8192];
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                            while (true) {
                                try {
                                    int read = fileInputStream.read(bytes2);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bytes2, 0, read);
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            }
                            byteArrayOutputStream2.flush();
                            bytes2 = C1151o.m8008a().m8010a(byteArrayOutputStream2.toByteArray());
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Exception e5) {
                                }
                            }
                            if (file != null) {
                                file.delete();
                            }
                        } catch (Exception e6) {
                            e = e6;
                            byteArrayOutputStream2 = null;
                            try {
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e7) {
                                    }
                                }
                                if (byteArrayOutputStream2 != null) {
                                    try {
                                        byteArrayOutputStream2.close();
                                    } catch (Exception e8) {
                                    }
                                }
                                if (file != null) {
                                    bytes2 = null;
                                } else {
                                    file.delete();
                                    bytes2 = null;
                                }
                                C1149m.m8000a(str + "&ek=" + b, hashMap, bytes2, new aj(this), false);
                            } catch (Throwable th2) {
                                th = th2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e9) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception e10) {
                                    }
                                }
                                if (file != null) {
                                    file.delete();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (file != null) {
                                file.delete();
                            }
                            throw th;
                        }
                    } catch (Exception e11) {
                        e = e11;
                        byteArrayOutputStream2 = null;
                        fileInputStream = null;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != null) {
                            file.delete();
                            bytes2 = null;
                        } else {
                            bytes2 = null;
                        }
                        C1149m.m8000a(str + "&ek=" + b, hashMap, bytes2, new aj(this), false);
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                } catch (Exception e12) {
                    e = e12;
                    byteArrayOutputStream2 = null;
                    file = null;
                    fileInputStream = null;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (file != null) {
                        file.delete();
                        bytes2 = null;
                    } else {
                        bytes2 = null;
                    }
                    C1149m.m8000a(str + "&ek=" + b, hashMap, bytes2, new aj(this), false);
                } catch (Throwable th5) {
                    th = th5;
                    file = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (file != null) {
                        file.delete();
                    }
                    throw th;
                }
                C1149m.m8000a(str + "&ek=" + b, hashMap, bytes2, new aj(this), false);
            }
        }
    }

    /* renamed from: a */
    public void m7600a(int i) {
        this.f4850g = i;
    }

    /* renamed from: a */
    public void m7601a(int i, String str) {
        if (!(i == 200 || i == ErrorCode.COPY_INSTALL_SUCCESS || i == ErrorCode.INCRUPDATE_INSTALL_SUCCESS)) {
            TbsLog.m7928i(TbsDownloader.LOGTAG, "error occured in installation, errorCode:" + i, true);
        }
        m7624h(i);
        m7603a(System.currentTimeMillis());
        m7621e(str);
        QbSdk.f4786e.onInstallFinish(i);
        m7604a(EventType.TYPE_INSTALL);
    }

    /* renamed from: a */
    public void m7602a(int i, Throwable th) {
        if (th == null) {
            this.f4861r = "NULL";
        } else if (TbsShareManager.isThirdPartyApp(this.f4846c) || i == ErrorCode.THROWABLE_LOAD_TBS || i == ErrorCode.TEST_THROWABLE_ISNOT_NULL || i == ErrorCode.TEST_THROWABLE_IS_NULL || i == ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT) {
            String str = "msg: " + th.getMessage() + "; err: " + th + "; cause: " + Log.getStackTraceString(th.getCause());
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.f4861r = str;
        } else {
            m7606a(th);
        }
        m7609b(i, this.f4861r);
    }

    /* renamed from: a */
    public void m7603a(long j) {
        this.f4847d = j;
    }

    /* renamed from: a */
    public void m7604a(EventType eventType) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m7598i(eventType.f4841a));
        stringBuilder.append(m7594f(C1135b.m7952c(this.f4846c)));
        stringBuilder.append(m7594f(C1158v.m8046a(this.f4846c)));
        stringBuilder.append(m7598i(ac.m7706a().m7746e(this.f4846c)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        stringBuilder.append(m7594f(str));
        str = this.f4846c.getPackageName();
        stringBuilder.append(m7594f(str));
        if ("com.tencent.mm".equals(str)) {
            stringBuilder.append(m7594f(C1135b.m7949a(this.f4846c, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
        } else {
            stringBuilder.append(m7598i(C1135b.m7951b(this.f4846c)));
        }
        stringBuilder.append(m7594f(m7591e(this.f4847d)));
        stringBuilder.append(m7594f(this.f4848e));
        stringBuilder.append(m7594f(this.f4849f));
        stringBuilder.append(m7598i(this.f4850g));
        stringBuilder.append(m7598i(this.f4851h));
        stringBuilder.append(m7598i(this.f4852i));
        stringBuilder.append(m7598i(this.f4853j));
        stringBuilder.append(m7594f(this.f4854k));
        stringBuilder.append(m7598i(this.f4855l));
        stringBuilder.append(m7598i(this.f4856m));
        stringBuilder.append(m7593f(this.f4862s));
        stringBuilder.append(m7593f(this.f4857n));
        stringBuilder.append(m7593f(this.f4858o));
        stringBuilder.append(m7598i(this.f4859p));
        stringBuilder.append(m7598i(this.f4845a));
        stringBuilder.append(m7594f(this.f4860q));
        stringBuilder.append(m7594f(this.f4861r));
        stringBuilder.append(m7598i(TbsDownloadConfig.m7565a(this.f4846c).f4827b.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)));
        stringBuilder.append(C1135b.m7955f(this.f4846c));
        SharedPreferences h = m7597h();
        JSONArray f = m7595f();
        f.put(stringBuilder.toString());
        Editor edit = h.edit();
        edit.putString("tbs_download_upload", f.toString());
        edit.commit();
        m7592e();
        new Thread(new ai(this)).start();
    }

    /* renamed from: a */
    public void m7605a(String str) {
        if (this.f4848e == null) {
            this.f4848e = str;
        } else {
            this.f4848e += ";" + str;
        }
    }

    /* renamed from: a */
    public void m7606a(Throwable th) {
        if (th == null) {
            this.f4861r = bi_常量类.f6358b_空串;
            return;
        }
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.length() > 1024) {
            stackTraceString = stackTraceString.substring(0, 1024);
        }
        this.f4861r = stackTraceString;
    }

    /* renamed from: b */
    public void m7607b() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] Run in UIThread, Report delay");
            return;
        }
        synchronized (this) {
            TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat]");
            JSONArray f = m7595f();
            if (f == null || f.length() == 0) {
                TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] no data");
                return;
            }
            TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + f);
            try {
                TbsLog.m7927i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] response:" + C1149m.m8001a(C1159w.m8057a(this.f4846c).m8061c(), f.toString().getBytes("utf-8"), new ak(this), true));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    public void m7608b(int i) {
        this.f4851h = i;
    }

    /* renamed from: b */
    public void m7609b(int i, String str) {
        m7624h(i);
        m7603a(System.currentTimeMillis());
        m7621e(str);
        m7604a(EventType.TYPE_LOAD);
    }

    /* renamed from: b */
    public void m7610b(long j) {
        this.f4857n = j;
    }

    /* renamed from: b */
    public void m7611b(String str) {
        this.f4849f = str;
    }

    /* renamed from: c */
    public int m7612c() {
        return this.f4856m;
    }

    /* renamed from: c */
    public void m7613c(int i) {
        this.f4852i = i;
    }

    /* renamed from: c */
    public void m7614c(long j) {
        this.f4858o += j;
    }

    /* renamed from: c */
    public void m7615c(String str) {
        this.f4854k = str;
    }

    /* renamed from: d */
    public void m7616d() {
        try {
            m7592e();
            Editor edit = m7597h().edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
    }

    /* renamed from: d */
    public void m7617d(int i) {
        this.f4853j = i;
    }

    /* renamed from: d */
    public void m7618d(long j) {
        this.f4862s += j;
    }

    /* renamed from: d */
    public void m7619d(String str) {
        m7624h(ErrorCode.VERIFY_ERROR);
        this.f4860q = str;
    }

    /* renamed from: e */
    public void m7620e(int i) {
        this.f4855l = i;
    }

    /* renamed from: e */
    public void m7621e(String str) {
        if (str != null) {
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            this.f4861r = str;
        }
    }

    /* renamed from: f */
    public void m7622f(int i) {
        this.f4856m = i;
    }

    /* renamed from: g */
    public void m7623g(int i) {
        this.f4859p = i;
    }

    /* renamed from: h */
    public void m7624h(int i) {
        if (!(i == 100 || i == ErrorCode.NONEEDTODOWN_ERROR || i == ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR || i == ErrorCode.NETWORK_NOT_WIFI_ERROR || i >= ErrorCode.INFO_CODE_BASE)) {
            TbsLog.m7928i(TbsDownloader.LOGTAG, "error occured, errorCode:" + i, true);
        }
        if (i == ErrorCode.NETWORK_NOT_WIFI_ERROR) {
            TbsLog.m7928i(TbsDownloader.LOGTAG, "you are not in wifi, downloading stoped", true);
        }
        this.f4845a = i;
    }
}
