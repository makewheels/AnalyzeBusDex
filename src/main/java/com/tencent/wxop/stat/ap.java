package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p053a.C1166e;
import com.tencent.wxop.stat.p053a.C1175j;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

class ap implements Runnable {
    /* renamed from: a */
    private Context f5371a = null;
    /* renamed from: b */
    private Map<String, Integer> f5372b = null;
    /* renamed from: c */
    private StatSpecifyReportedInfo f5373c = null;

    public ap(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f5371a = context;
        this.f5373c = statSpecifyReportedInfo;
        if (map != null) {
            this.f5372b = map;
        }
    }

    /* renamed from: a */
    private NetworkMonitor m8181a(String str, int i) {
        Throwable th;
        NetworkMonitor networkMonitor = new NetworkMonitor();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            networkMonitor.setDomain(str);
            networkMonitor.setPort(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
            networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                StatServiceImpl.f5275q.m8242e(th2);
            }
        } catch (Throwable e) {
            th2 = e;
            i2 = -1;
            StatServiceImpl.f5275q.m8242e(th2);
            socket.close();
        } catch (Throwable th22) {
            StatServiceImpl.f5275q.m8242e(th22);
        }
        networkMonitor.setStatusCode(i2);
        return networkMonitor;
    }

    /* renamed from: a */
    private Map<String, Integer> m8182a() {
        Map<String, Integer> hashMap = new HashMap();
        String a = StatConfig.m8088a("__MTA_TEST_SPEED__", null);
        if (!(a == null || a.trim().length() == 0)) {
            for (String a2 : a2.split(";")) {
                String[] split = a2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Throwable e) {
                            StatServiceImpl.f5275q.m8242e(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public void run() {
        try {
            if (this.f5372b == null) {
                this.f5372b = m8182a();
            }
            if (this.f5372b == null || this.f5372b.size() == 0) {
                StatServiceImpl.f5275q.m8243i("empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f5372b.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null || str.length() == 0) {
                    StatServiceImpl.f5275q.m8245w("empty domain name.");
                } else if (((Integer) entry.getValue()) == null) {
                    StatServiceImpl.f5275q.m8245w("port is null for " + str);
                } else {
                    jSONArray.put(m8181a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).toJSONObject());
                }
            }
            if (jSONArray.length() != 0) {
                C1166e c1175j = new C1175j(this.f5371a, StatServiceImpl.m8105a(this.f5371a, false, this.f5373c), this.f5373c);
                c1175j.m8159a(jSONArray.toString());
                new aq(c1175j).m8190a();
            }
        } catch (Throwable th) {
            StatServiceImpl.f5275q.m8242e(th);
        }
    }
}
