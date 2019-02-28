package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import p054u.aly.bi_常量类;

/* renamed from: com.alipay.android.phone.mrpc.core.j */
public final class C0034j extends C0022a {
    /* renamed from: g */
    private C0030g f36g;

    public C0034j(C0030g c0030g, Method method, int i, String str, byte[] bArr, boolean z) {
        super(method, i, str, bArr, "application/x-www-form-urlencoded", z);
        this.f36g = c0030g;
    }

    /* renamed from: a */
    public final Object mo20a() {
        Throwable e;
        C0040t c0041o = new C0041o(this.f36g.mo16a());
        c0041o.m95a(this.b);
        c0041o.m91a(this.e);
        c0041o.m94a(this.f);
        c0041o.m92a("id", String.valueOf(this.d));
        c0041o.m92a("operationType", this.c);
        c0041o.m92a("gzip", String.valueOf(this.f36g.mo19d()));
        c0041o.m93a(new BasicHeader("uuid", UUID.randomUUID().toString()));
        List<Header> b = this.f36g.mo18c().m47b();
        if (!(b == null || b.isEmpty())) {
            for (Header a : b) {
                c0041o.m93a(a);
            }
        }
        new StringBuilder("threadid = ").append(Thread.currentThread().getId()).append("; ").append(c0041o.toString());
        try {
            C0042u c0042u = (C0042u) this.f36g.mo17b().mo21a(c0041o).get();
            if (c0042u != null) {
                return c0042u.m102b();
            }
            throw new RpcException(Integer.valueOf(9), "response is null");
        } catch (Throwable e2) {
            throw new RpcException(Integer.valueOf(13), bi_常量类.f6358b, e2);
        } catch (Throwable e22) {
            Throwable th = e22;
            e22 = th.getCause();
            if (e22 == null || !(e22 instanceof HttpException)) {
                throw new RpcException(Integer.valueOf(9), bi_常量类.f6358b, th);
            }
            HttpException httpException = (HttpException) e22;
            int code = httpException.getCode();
            switch (code) {
                case 1:
                    code = 2;
                    break;
                case 2:
                    code = 3;
                    break;
                case 3:
                    code = 4;
                    break;
                case 4:
                    code = 5;
                    break;
                case 5:
                    code = 6;
                    break;
                case 6:
                    code = 7;
                    break;
                case 7:
                    code = 8;
                    break;
                case 8:
                    code = 15;
                    break;
                case 9:
                    code = 16;
                    break;
            }
            throw new RpcException(Integer.valueOf(code), httpException.getMsg());
        } catch (Throwable e222) {
            throw new RpcException(Integer.valueOf(13), bi_常量类.f6358b, e222);
        }
    }
}
