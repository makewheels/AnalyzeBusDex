package p054u.aly;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1233a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import p054u.aly.cr.C1428a;

/* compiled from: NetworkHelper */
/* renamed from: u.aly.r */
public class C1449r {
    /* renamed from: a */
    public static final int f6589a = 1;
    /* renamed from: b */
    public static final int f6590b = 2;
    /* renamed from: c */
    public static final int f6591c = 3;
    /* renamed from: d */
    private final int f6592d = 1;
    /* renamed from: e */
    private String f6593e;
    /* renamed from: f */
    private String f6594f = "10.0.0.172";
    /* renamed from: g */
    private int f6595g = 80;
    /* renamed from: h */
    private Context f6596h;
    /* renamed from: i */
    private C1453w f6597i;
    /* renamed from: j */
    private C1435f f6598j;

    public C1449r(Context context) {
        this.f6596h = context;
        this.f6598j = C1437h.m10388b(context);
        this.f6593e = m10455a(context);
    }

    /* renamed from: a */
    public void m10460a(C1453w c1453w) {
        this.f6597i = c1453w;
    }

    /* renamed from: a */
    public int m10459a(byte[] bArr) {
        byte[] bArr2 = null;
        for (String a : C1233a.f5590f) {
            bArr2 = m10457a(bArr, a);
            if (bArr2 != null) {
                if (this.f6597i != null) {
                    this.f6597i.m10478c();
                }
                if (bArr2 != null) {
                    return 1;
                }
                return m10458b(bArr2);
            }
            if (this.f6597i != null) {
                this.f6597i.m10479d();
            }
        }
        if (bArr2 != null) {
            return m10458b(bArr2);
        }
        return 1;
    }

    /* renamed from: a */
    private boolean m10456a() {
        if (this.f6596h.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f6596h.getPackageName()) != 0) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6596h.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: a */
    private byte[] m10457a(byte[] bArr, String str) {
        HttpUriRequest httpPost = new HttpPost(str);
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        HttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        httpPost.addHeader("X-Umeng-Sdk", this.f6593e);
        httpPost.addHeader("Msg-Type", "envelope");
        InputStream content;
        try {
            if (m10456a()) {
                defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(this.f6594f, this.f6595g));
            }
            httpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(bArr), (long) bArr.length));
            if (this.f6597i != null) {
                this.f6597i.m10480e();
            }
            HttpResponse execute = defaultHttpClient.execute(httpPost);
            if (this.f6597i != null) {
                this.f6597i.m10481f();
            }
            bj.m10000a(C1233a.f5589e, "status code : " + execute.getStatusLine().getStatusCode());
            if (execute.getStatusLine().getStatusCode() != 200) {
                return null;
            }
            bj.m10000a(C1233a.f5589e, "Sent message to " + str);
            HttpEntity entity = execute.getEntity();
            if (entity == null) {
                return null;
            }
            content = entity.getContent();
            byte[] b = bv.m10063b(content);
            bv.m10065c(content);
            return b;
        } catch (Exception e) {
            bj.m10003b(C1233a.f5589e, "ClientProtocolException,Failed to send message.", e);
            return null;
        } catch (Exception e2) {
            bj.m10003b(C1233a.f5589e, "IOException,Failed to send message.", e2);
            return null;
        } catch (Throwable th) {
            bv.m10065c(content);
        }
    }

    /* renamed from: a */
    private String m10455a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Android");
        stringBuffer.append("/");
        stringBuffer.append(C1233a.f5587c);
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(bi_常量类.m9997v(context));
            stringBuffer2.append("/");
            stringBuffer2.append(bi_常量类.m9979d(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(bv.m10055a(AnalyticsConfig.getAppkey(context)));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    private int m10458b(byte[] bArr) {
        bz bbVar = new bb();
        try {
            new cc(new C1428a()).m10132a(bbVar, bArr);
            if (bbVar.f6224a == 1) {
                this.f6598j.m10383b(bbVar.m9679j());
                this.f6598j.m10384c();
            }
            bj.m10000a(C1233a.f5589e, "send log:" + bbVar.m9675f());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bbVar.f6224a == 1) {
            return 2;
        }
        return 3;
    }
}
