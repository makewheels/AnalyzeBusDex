package com.amap.api.mapcore.util;

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
/* renamed from: com.amap.api.mapcore.util.f */
public abstract class C0323f<Params, Progress, Result> {
    /* renamed from: a */
    private static final ThreadFactory f1676a = new C0386g();
    /* renamed from: b */
    public static final Executor f1677b = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f1680e, f1676a, new DiscardOldestPolicy());
    /* renamed from: c */
    public static final Executor f1678c = (C0405u.m3483c() ? new C0384c() : Executors.newSingleThreadExecutor(f1676a));
    /* renamed from: d */
    public static final Executor f1679d = Executors.newFixedThreadPool(2, f1676a);
    /* renamed from: e */
    private static final BlockingQueue<Runnable> f1680e = new LinkedBlockingQueue(10);
    /* renamed from: f */
    private static final C0382b f1681f = new C0382b();
    /* renamed from: g */
    private static volatile Executor f1682g = f1678c;
    /* renamed from: h */
    private final C0377e<Params, Result> f1683h = new C03781(this);
    /* renamed from: i */
    private final FutureTask<Result> f1684i = new FutureTask<Result>(this, this.f1683h) {
        /* renamed from: a */
        final /* synthetic */ C0323f f2115a;

        protected void done() {
            try {
                this.f2115a.m2734c(this.f2115a.f1684i.get());
            } catch (Throwable e) {
                Log.w("AsyncTask", e);
            } catch (ExecutionException e2) {
                throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
            } catch (CancellationException e3) {
                this.f2115a.m2734c(null);
            }
        }
    };
    /* renamed from: j */
    private volatile C0385d f1685j = C0385d.PENDING;
    /* renamed from: k */
    private final AtomicBoolean f1686k = new AtomicBoolean();
    /* renamed from: l */
    private final AtomicBoolean f1687l = new AtomicBoolean();

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.mapcore.util.f$e */
    private static abstract class C0377e<Params, Result> implements Callable<Result> {
        /* renamed from: b */
        Params[] f2113b;

        private C0377e() {
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.mapcore.util.f$1 */
    class C03781 extends C0377e<Params, Result> {
        /* renamed from: a */
        final /* synthetic */ C0323f f2114a;

        C03781(C0323f c0323f) {
            this.f2114a = c0323f;
            super();
        }

        public Result call() throws Exception {
            this.f2114a.f1687l.set(true);
            Process.setThreadPriority(10);
            return this.f2114a.m2735d(this.f2114a.mo519a(this.b));
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.mapcore.util.f$a */
    private static class C0381a<Data> {
        /* renamed from: a */
        final C0323f f2117a;
        /* renamed from: b */
        final Data[] f2118b;

        C0381a(C0323f c0323f, Data... dataArr) {
            this.f2117a = c0323f;
            this.f2118b = dataArr;
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.mapcore.util.f$b */
    private static class C0382b extends Handler {
        private C0382b() {
        }

        public void handleMessage(Message message) {
            C0381a c0381a = (C0381a) message.obj;
            switch (message.what) {
                case 1:
                    c0381a.f2117a.m2736e(c0381a.f2118b[0]);
                    return;
                case 2:
                    c0381a.f2117a.m2744b(c0381a.f2118b);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.mapcore.util.f$c */
    private static class C0384c implements Executor {
        /* renamed from: a */
        final ArrayDeque<Runnable> f2121a;
        /* renamed from: b */
        Runnable f2122b;

        private C0384c() {
            this.f2121a = new ArrayDeque();
        }

        public synchronized void execute(final Runnable runnable) {
            this.f2121a.offer(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C0384c f2120b;

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        this.f2120b.m3325a();
                    }
                }
            });
            if (this.f2122b == null) {
                m3325a();
            }
        }

        /* renamed from: a */
        protected synchronized void m3325a() {
            Runnable runnable = (Runnable) this.f2121a.poll();
            this.f2122b = runnable;
            if (runnable != null) {
                C0323f.f1677b.execute(this.f2122b);
            }
        }
    }

    /* compiled from: AsyncTask */
    /* renamed from: com.amap.api.mapcore.util.f$d */
    public enum C0385d {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* renamed from: a */
    protected abstract Result mo519a(Params... paramsArr);

    /* renamed from: c */
    private void m2734c(Result result) {
        if (!this.f1687l.get()) {
            m2735d(result);
        }
    }

    /* renamed from: d */
    private Result m2735d(Result result) {
        f1681f.obtainMessage(1, new C0381a(this, result)).sendToTarget();
        return result;
    }

    /* renamed from: a */
    public final C0385d m2737a() {
        return this.f1685j;
    }

    /* renamed from: b */
    protected void m2742b() {
    }

    /* renamed from: a */
    protected void mo520a(Result result) {
    }

    /* renamed from: b */
    protected void m2744b(Progress... progressArr) {
    }

    /* renamed from: b */
    protected void mo614b(Result result) {
        m2746c();
    }

    /* renamed from: c */
    protected void m2746c() {
    }

    /* renamed from: d */
    public final boolean m2747d() {
        return this.f1686k.get();
    }

    /* renamed from: a */
    public final boolean m2741a(boolean z) {
        this.f1686k.set(true);
        return this.f1684i.cancel(z);
    }

    /* renamed from: c */
    public final C0323f<Params, Progress, Result> m2745c(Params... paramsArr) {
        return m2738a(f1682g, (Object[]) paramsArr);
    }

    /* renamed from: a */
    public final C0323f<Params, Progress, Result> m2738a(Executor executor, Params... paramsArr) {
        if (this.f1685j != C0385d.PENDING) {
            switch (this.f1685j) {
                case RUNNING:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case FINISHED:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f1685j = C0385d.RUNNING;
        m2742b();
        this.f1683h.f2113b = paramsArr;
        executor.execute(this.f1684i);
        return this;
    }

    /* renamed from: e */
    private void m2736e(Result result) {
        if (m2747d()) {
            mo614b((Object) result);
        } else {
            mo520a((Object) result);
        }
        this.f1685j = C0385d.FINISHED;
    }
}
