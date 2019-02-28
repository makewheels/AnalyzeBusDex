package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.utils.w */
public class C1159w {
    /* renamed from: c */
    private static C1159w f5168c = null;
    /* renamed from: a */
    private Context f5169a = null;
    /* renamed from: b */
    private File f5170b = null;
    /* renamed from: d */
    private String f5171d = "http://log.tbs.qq.com/ajax?c=pu&v=2&k=";
    /* renamed from: e */
    private String f5172e = "http://wup.imtt.qq.com:8080";
    /* renamed from: f */
    private String f5173f = "http://log.tbs.qq.com/ajax?c=dl&k=";
    /* renamed from: g */
    private String f5174g = "http://cfg.imtt.qq.com/tbs?v=2&mk=";
    /* renamed from: h */
    private String f5175h = "http://log.tbs.qq.com/ajax?c=ul&v=2&k=";
    /* renamed from: i */
    private String f5176i = "http://mqqad.html5.qq.com/adjs";
    /* renamed from: j */
    private String f5177j = "http://log.tbs.qq.com/ajax?c=ucfu&k=";

    @TargetApi(11)
    private C1159w(Context context) {
        TbsLog.m7931w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.f5169a = context.getApplicationContext();
        m8058g();
    }

    /* renamed from: a */
    public static synchronized C1159w m8056a() {
        C1159w c1159w;
        synchronized (C1159w.class) {
            c1159w = f5168c;
        }
        return c1159w;
    }

    /* renamed from: a */
    public static synchronized C1159w m8057a(Context context) {
        C1159w c1159w;
        synchronized (C1159w.class) {
            if (f5168c == null) {
                f5168c = new C1159w(context);
            }
            c1159w = f5168c;
        }
        return c1159w;
    }

    /* renamed from: g */
    private synchronized void m8058g() {
        try {
            File h = m8059h();
            if (h == null) {
                TbsLog.m7925e("TbsCommonConfig", "Config file is null, default values will be applied");
            } else {
                InputStream fileInputStream = new FileInputStream(h);
                Properties properties = new Properties();
                properties.load(fileInputStream);
                String property = properties.getProperty("pv_post_url", bi_常量类.f6358b);
                if (!bi_常量类.f6358b.equals(property)) {
                    this.f5171d = property;
                }
                property = properties.getProperty("wup_proxy_domain", bi_常量类.f6358b);
                if (!bi_常量类.f6358b.equals(property)) {
                    this.f5172e = property;
                }
                property = properties.getProperty("tbs_download_stat_post_url", bi_常量类.f6358b);
                if (!bi_常量类.f6358b.equals(property)) {
                    this.f5173f = property;
                }
                property = properties.getProperty("tbs_downloader_post_url", bi_常量类.f6358b);
                if (!bi_常量类.f6358b.equals(property)) {
                    this.f5174g = property;
                }
                property = properties.getProperty("tbs_log_post_url", bi_常量类.f6358b);
                if (!bi_常量类.f6358b.equals(property)) {
                    this.f5175h = property;
                }
                property = properties.getProperty("tips_url", bi_常量类.f6358b);
                if (!bi_常量类.f6358b.equals(property)) {
                    this.f5176i = property;
                }
                String property2 = properties.getProperty("tbs_cmd_post_url", bi_常量类.f6358b);
                if (!bi_常量类.f6358b.equals(property2)) {
                    this.f5177j = property2;
                }
                fileInputStream.close();
            }
        } catch (Throwable th) {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.m7925e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
        }
    }

    /* renamed from: h */
    private File m8059h() {
        Throwable th;
        Writer stringWriter;
        File file;
        try {
            if (this.f5170b == null) {
                this.f5170b = new File(C1146j.m7976a(this.f5169a, 4));
                if (this.f5170b == null || !this.f5170b.isDirectory()) {
                    return null;
                }
            }
            file = new File(this.f5170b, "tbsnet.conf");
            if (file.exists()) {
                try {
                    TbsLog.m7931w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
                    return file;
                } catch (Throwable th2) {
                    th = th2;
                    stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    TbsLog.m7925e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
                    return file;
                }
            }
            TbsLog.m7925e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            file = null;
            th = th4;
            stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            TbsLog.m7925e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            return file;
        }
    }

    /* renamed from: b */
    public String m8060b() {
        return this.f5171d;
    }

    /* renamed from: c */
    public String m8061c() {
        return this.f5173f;
    }

    /* renamed from: d */
    public String m8062d() {
        return this.f5174g;
    }

    /* renamed from: e */
    public String m8063e() {
        return this.f5175h;
    }

    /* renamed from: f */
    public String m8064f() {
        return this.f5176i;
    }
}
