package com.tencent.smtt.utils;

import android.os.Environment;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class TbsLogClient {
    /* renamed from: a */
    static TbsLogClient f5113a = null;
    /* renamed from: c */
    static File f5114c = null;
    /* renamed from: b */
    TextView f5115b;
    /* renamed from: d */
    private SimpleDateFormat f5116d = null;

    /* renamed from: com.tencent.smtt.utils.TbsLogClient$a */
    private class C1133a implements Runnable {
        /* renamed from: a */
        String f5111a = null;
        /* renamed from: b */
        final /* synthetic */ TbsLogClient f5112b;

        C1133a(TbsLogClient tbsLogClient, String str) {
            this.f5112b = tbsLogClient;
            this.f5111a = str;
        }

        public void run() {
            if (this.f5112b.f5115b != null) {
                this.f5112b.f5115b.append(this.f5111a + "\n");
            }
        }
    }

    public TbsLogClient() {
        try {
            this.f5116d = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception e) {
            this.f5116d = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
        try {
            if (f5114c != null) {
                return;
            }
            if (Environment.getExternalStorageState().equals("mounted")) {
                f5114c = new File(C1146j.f5139a, "tbslog.txt");
            } else {
                f5114c = null;
            }
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (NullPointerException e3) {
            e3.printStackTrace();
        }
    }

    public static TbsLogClient getIntance() {
        if (f5113a == null) {
            f5113a = new TbsLogClient();
        }
        return f5113a;
    }

    /* renamed from: d */
    public void m7933d(String str, String str2) {
    }

    /* renamed from: e */
    public void m7934e(String str, String str2) {
        Log.e(str, str2);
    }

    /* renamed from: i */
    public void m7935i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.f5115b = textView;
    }

    public void showLog(String str) {
        if (this.f5115b != null) {
            this.f5115b.post(new C1133a(this, str));
        }
    }

    /* renamed from: v */
    public void m7936v(String str, String str2) {
    }

    /* renamed from: w */
    public void m7937w(String str, String str2) {
    }

    public void writeLog(String str) {
        if (f5114c != null) {
            LogFileUtils.writeDataToStorage(f5114c, this.f5116d.format(Long.valueOf(System.currentTimeMillis())) + " pid=" + Process.myPid() + " " + str + "\n", true);
        }
    }
}
