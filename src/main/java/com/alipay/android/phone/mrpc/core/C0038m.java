package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: com.alipay.android.phone.mrpc.core.m */
final class C0038m extends FutureTask<C0042u> {
    /* renamed from: a */
    final /* synthetic */ C0044q f51a;
    /* renamed from: b */
    final /* synthetic */ C0037l f52b;

    C0038m(C0037l c0037l, Callable callable, C0044q c0044q) {
        this.f52b = c0037l;
        this.f51a = c0044q;
        super(callable);
    }

    protected final void done() {
        C0040t a = this.f51a.m121a();
        if (a.m87f() == null) {
            super.done();
            return;
        }
        try {
            get();
            if (isCancelled() || a.m89h()) {
                a.m88g();
                if (!isCancelled() || !isDone()) {
                    cancel(false);
                }
            }
        } catch (InterruptedException e) {
            new StringBuilder().append(e);
        } catch (ExecutionException e2) {
            if (e2.getCause() == null || !(e2.getCause() instanceof HttpException)) {
                new StringBuilder().append(e2);
                return;
            }
            HttpException httpException = (HttpException) e2.getCause();
            httpException.getCode();
            httpException.getMsg();
        } catch (CancellationException e3) {
            a.m88g();
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("An error occured while executing http request", th);
        }
    }
}
