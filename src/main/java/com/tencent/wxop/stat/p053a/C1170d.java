package com.tencent.wxop.stat.p053a;

import android.content.Context;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.C1183b;
import com.tencent.wxop.stat.common.C1198q;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

/* renamed from: com.tencent.wxop.stat.a.d */
public class C1170d extends C1166e {
    /* renamed from: a */
    private String f5302a;
    /* renamed from: m */
    private int f5303m;
    /* renamed from: n */
    private int f5304n = 100;
    /* renamed from: o */
    private Thread f5305o = null;

    public C1170d(Context context, int i, int i2, Throwable th, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        m8148a(i2, th);
    }

    public C1170d(Context context, int i, int i2, Throwable th, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        m8148a(i2, th);
        this.f5305o = thread;
    }

    public C1170d(Context context, int i, String str, int i2, int i3, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        if (str != null) {
            if (i3 <= 0) {
                i3 = StatConfig.getMaxReportEventLength();
            }
            if (str.length() <= i3) {
                this.f5302a = str;
            } else {
                this.f5302a = str.substring(0, i3);
            }
        }
        this.f5305o = thread;
        this.f5303m = i2;
    }

    /* renamed from: a */
    private void m8148a(int i, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.f5302a = stringWriter.toString();
            this.f5303m = i;
            printWriter.close();
        }
    }

    /* renamed from: a */
    public C1171f mo1911a() {
        return C1171f.ERROR;
    }

    /* renamed from: a */
    public boolean mo1912a(JSONObject jSONObject) {
        C1198q.m8331a(jSONObject, "er", this.f5302a);
        jSONObject.put("ea", this.f5303m);
        if (this.f5303m == 2 || this.f5303m == 3) {
            new C1183b(this.l).m8253a(jSONObject, this.f5305o);
        }
        return true;
    }
}
