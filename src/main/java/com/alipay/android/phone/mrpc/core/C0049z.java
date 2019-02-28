package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.p003a.C0017f;
import com.alipay.android.phone.mrpc.core.p003a.C0019d;
import com.alipay.android.phone.mrpc.core.p003a.C0020e;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.alipay.android.phone.mrpc.core.z */
public final class C0049z {
    /* renamed from: a */
    private static final ThreadLocal<Object> f93a = new ThreadLocal();
    /* renamed from: b */
    private static final ThreadLocal<Map<String, Object>> f94b = new ThreadLocal();
    /* renamed from: c */
    private byte f95c = (byte) 0;
    /* renamed from: d */
    private AtomicInteger f96d;
    /* renamed from: e */
    private C0047x f97e;

    public C0049z(C0047x c0047x) {
        this.f97e = c0047x;
        this.f96d = new AtomicInteger();
    }

    /* renamed from: a */
    public final Object m126a(Method method, Object[] objArr) {
        boolean z = true;
        boolean z2 = Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
        if (z2) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        if (method.getAnnotation(ResetCookie.class) == null) {
            z = false;
        }
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        f93a.set(null);
        f94b.set(null);
        if (operationType == null) {
            throw new IllegalStateException("OperationType must be set.");
        }
        String value = operationType.value();
        int incrementAndGet = this.f96d.incrementAndGet();
        try {
            if (this.f95c == (byte) 0) {
                C0017f c0020e = new C0020e(incrementAndGet, value, objArr);
                if (f94b.get() != null) {
                    c0020e.mo13a(f94b.get());
                }
                byte[] bArr = (byte[]) new C0034j(this.f97e.m124a(), method, incrementAndGet, value, c0020e.mo14a(), z).mo20a();
                f94b.set(null);
                Object a = new C0019d(genericReturnType, bArr).mo12a();
                if (genericReturnType != Void.TYPE) {
                    f93a.set(a);
                }
            }
            return f93a.get();
        } catch (RpcException e) {
            e.setOperationType(value);
            throw e;
        }
    }
}
