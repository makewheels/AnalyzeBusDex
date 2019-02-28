package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.common.C1186e;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1198q;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.wxop.stat.a */
public class C1178a {
    /* renamed from: g */
    private static C1178a f5330g = null;
    /* renamed from: a */
    private List<String> f5331a = null;
    /* renamed from: b */
    private volatile int f5332b = 2;
    /* renamed from: c */
    private volatile String f5333c = bi_常量类.f6358b;
    /* renamed from: d */
    private volatile HttpHost f5334d = null;
    /* renamed from: e */
    private C1186e f5335e = null;
    /* renamed from: f */
    private int f5336f = 0;
    /* renamed from: h */
    private Context f5337h = null;
    /* renamed from: i */
    private StatLogger f5338i = null;

    private C1178a(Context context) {
        this.f5337h = context.getApplicationContext();
        this.f5335e = new C1186e();
        C1204i.m8351a(context);
        this.f5338i = C1192k.m8283b();
        m8171l();
        m8168i();
        m8179g();
    }

    /* renamed from: a */
    public static C1178a m8165a(Context context) {
        if (f5330g == null) {
            synchronized (C1178a.class) {
                if (f5330g == null) {
                    f5330g = new C1178a(context);
                }
            }
        }
        return f5330g;
    }

    /* renamed from: b */
    private boolean m8167b(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    /* renamed from: i */
    private void m8168i() {
        this.f5331a = new ArrayList(10);
        this.f5331a.add("117.135.169.101");
        this.f5331a.add("140.207.54.125");
        this.f5331a.add("180.153.8.53");
        this.f5331a.add("120.198.203.175");
        this.f5331a.add("14.17.43.18");
        this.f5331a.add("163.177.71.186");
        this.f5331a.add("111.30.131.31");
        this.f5331a.add("123.126.121.167");
        this.f5331a.add("123.151.152.111");
        this.f5331a.add("113.142.45.79");
        this.f5331a.add("123.138.162.90");
        this.f5331a.add("103.7.30.94");
    }

    /* renamed from: j */
    private String m8169j() {
        try {
            String str = StatConstants.MTA_SERVER_HOST;
            if (!m8167b(str)) {
                return InetAddress.getByName(str).getHostAddress();
            }
        } catch (Throwable e) {
            this.f5338i.m8242e(e);
        }
        return bi_常量类.f6358b;
    }

    /* renamed from: k */
    private void m8170k() {
        String j = m8169j();
        if (StatConfig.isDebugEnable()) {
            this.f5338i.m8243i("remoteIp ip is " + j);
        }
        if (C1192k.m8287c(j)) {
            String str;
            if (this.f5331a.contains(j)) {
                str = j;
            } else {
                str = (String) this.f5331a.get(this.f5336f);
                if (StatConfig.isDebugEnable()) {
                    this.f5338i.m8245w(j + " not in ip list, change to:" + str);
                }
            }
            StatConfig.setStatReportUrl("http://" + str + ":80/mstat/report");
        }
    }

    /* renamed from: l */
    private void m8171l() {
        this.f5332b = 0;
        this.f5334d = null;
        this.f5333c = null;
    }

    /* renamed from: a */
    public HttpHost m8172a() {
        return this.f5334d;
    }

    /* renamed from: a */
    public void m8173a(String str) {
        if (StatConfig.isDebugEnable()) {
            this.f5338i.m8243i("updateIpList " + str);
        }
        try {
            if (C1192k.m8287c(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString((String) keys.next());
                        if (C1192k.m8287c(string)) {
                            for (String str2 : string.split(";")) {
                                String str22;
                                if (C1192k.m8287c(str22)) {
                                    String[] split = str22.split(":");
                                    if (split.length > 1) {
                                        str22 = split[0];
                                        if (m8167b(str22) && !this.f5331a.contains(str22)) {
                                            if (StatConfig.isDebugEnable()) {
                                                this.f5338i.m8243i("add new ip:" + str22);
                                            }
                                            this.f5331a.add(str22);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable e) {
            this.f5338i.m8242e(e);
        }
        this.f5336f = new Random().nextInt(this.f5331a.size());
    }

    /* renamed from: b */
    public String m8174b() {
        return this.f5333c;
    }

    /* renamed from: c */
    public int m8175c() {
        return this.f5332b;
    }

    /* renamed from: d */
    public void m8176d() {
        this.f5336f = (this.f5336f + 1) % this.f5331a.size();
    }

    /* renamed from: e */
    public boolean m8177e() {
        return this.f5332b == 1;
    }

    /* renamed from: f */
    public boolean m8178f() {
        return this.f5332b != 0;
    }

    /* renamed from: g */
    void m8179g() {
        if (C1198q.m8338f(this.f5337h)) {
            if (StatConfig.f5234g) {
                m8170k();
            }
            this.f5333c = C1192k.m8301l(this.f5337h);
            if (StatConfig.isDebugEnable()) {
                this.f5338i.m8243i("NETWORK name:" + this.f5333c);
            }
            if (C1192k.m8287c(this.f5333c)) {
                if ("WIFI".equalsIgnoreCase(this.f5333c)) {
                    this.f5332b = 1;
                } else {
                    this.f5332b = 2;
                }
                this.f5334d = C1192k.m8278a(this.f5337h);
            }
            if (StatServiceImpl.m8112a()) {
                StatServiceImpl.m8122d(this.f5337h);
                return;
            }
            return;
        }
        if (StatConfig.isDebugEnable()) {
            this.f5338i.m8243i("NETWORK TYPE: network is close.");
        }
        m8171l();
    }

    /* renamed from: h */
    public void m8180h() {
        this.f5337h.getApplicationContext().registerReceiver(new C1180b(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
