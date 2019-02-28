package com.amap.api.p015a.p016a;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AsyncTask */
/* renamed from: com.amap.api.a.a.b */
public abstract class C0181b<Params, Progress, Result> {
    /* renamed from: a */
    private static final ThreadFactory f509a = new C0182c();
    /* renamed from: b */
    public static final Executor f510b = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f513e, f509a, new DiscardOldestPolicy());
    /* renamed from: c */
    public static final Executor f511c = (C0204q.m810c() ? new C0179c() : Executors.newSingleThreadExecutor(f509a));
    /* renamed from: d */
    public static final Executor f512d = Executors.newFixedThreadPool(2, f509a);
    /* renamed from: e */
    private static final BlockingQueue<Runnable> f513e = new LinkedBlockingQueue(10);
    /* renamed from: f */
    private static final C0177b f514f = new C0177b();
    /* renamed from: g */
    private static volatile Executor f515g = f511c;
    /* renamed from: h */
    private final C0172e<Params, Result> f516h = new C01731(this);
    /* renamed from: i */
    private final FutureTask<Result> f517i = new FutureTask<Result>(this, this.f516h) {
        /* renamed from: a */
        final /* synthetic */ C0181b f497a;

        protected void done() {
            try {
                this.f497a.m631c(this.f497a.f517i.get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f497a.m631c(null);
            }
        }
    };
    /* renamed from: j */
    private volatile C0180d f518j = C0180d.PENDING;
    /* renamed from: k */
    private final AtomicBoolean f519k = new AtomicBoolean();
    /* renamed from: l */
    private final AtomicBoolean f520l = new AtomicBoolean();

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.a.a.b$e */
    private static abstract class C0172e<Params, Result> implements Callable<Result> {
        /* renamed from: b */
        Params[] f495b;

        private C0172e() {
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.a.a.b$1 */
    class C01731 extends C0172e<Params, Result> {
        /* renamed from: a */
        final /* synthetic */ C0181b f496a;

        C01731(C0181b c0181b) {
            this.f496a = c0181b;
            super();
        }

        public Result call() throws Exception {
            this.f496a.f520l.set(true);
            Process.setThreadPriority(10);
            return this.f496a.m632d(this.f496a.mo33a(this.b));
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.a.a.b$a */
    private static class C0176a<Data> {
        /* renamed from: a */
        final C0181b f499a;
        /* renamed from: b */
        final Data[] f500b;

        C0176a(C0181b c0181b, Data... dataArr) {
            this.f499a = c0181b;
            this.f500b = dataArr;
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.a.a.b$b */
    private static class C0177b extends Handler {
        private C0177b() {
        }

        public void handleMessage(Message message) {
            C0176a c0176a = (C0176a) message.obj;
            switch (message.what) {
                case 1:
                    c0176a.f499a.m633e(c0176a.f500b[0]);
                    return;
                case 2:
                    c0176a.f499a.m641b(c0176a.f500b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.a.a.b$c */
    private static class C0179c implements Executor {
        /* renamed from: a */
        final ArrayDeque<Runnable> f503a;
        /* renamed from: b */
        Runnable f504b;

        private C0179c() {
            this.f503a = new ArrayDeque();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f503a.offer(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C0179c f502b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.f502b.m625a();
                    }
                }
            });
            if (this.f504b == null) {
                m625a();
            }
        }

        /* renamed from: a */
        protected synchronized void m625a() {
            Runnable runnable = (Runnable) this.f503a.poll();
            this.f504b = runnable;
            if (runnable != null) {
                C0181b.f510b.execute(this.f504b);
            }
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.a.a.b$d */
    public enum C0180d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: a */
    protected abstract Result mo33a(Params... paramsArr);

    /* renamed from: c */
    private void m631c(Result result) {
        if (!this.f520l.get()) {
            m632d(result);
        }
    }

    /* renamed from: d */
    private Result m632d(Result result) {
        f514f.obtainMessage(1, new C0176a(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: a */
    public final C0180d m634a() {
        return this.f518j;
    }

    /* renamed from: b */
    protected void m639b() {
    }

    /* renamed from: a */
    protected void mo34a(Result result) {
    }

    /* renamed from: b */
    protected void m641b(Progress... progressArr) {
    }

    /* renamed from: b */
    protected void mo35b(Result result) {
        m643c();
    }

    /* renamed from: c */
    protected void m643c() {
    }

    /* renamed from: d */
    public final boolean m644d() {
        return this.f519k.get();
    }

    /* renamed from: a */
    public final boolean m638a(boolean z) {
        this.f519k.set(true);
        return this.f517i.cancel(z);
    }

    /* renamed from: c */
    public final C0181b<Params, Progress, Result> m642c(Params... paramsArr) {
        return m635a(f515g, (Object[]) paramsArr);
    }

    /* renamed from: a */
    public final C0181b<Params, Progress, Result> m635a(Executor executor, Params... paramsArr) {
        if (this.f518j != C0180d.PENDING) {
            switch (this.f518j) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f518j = C0180d.RUNNING;
        m639b();
        this.f516h.f495b = paramsArr;
        executor.execute(this.f517i);
        return this;
    }

    /* renamed from: e */
    private void m633e(Result result) {
        if (m644d()) {
            mo35b((Object) result);
        } else {
            mo34a((Object) result);
        }
        this.f518j = C0180d.FINISHED;
    }
}
