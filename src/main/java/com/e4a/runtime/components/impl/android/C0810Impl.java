package com.e4a.runtime.components.impl.android;

import com.e4a.runtime.components.C0809;
import com.e4a.runtime.components.impl.ComponentImpl;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.多线程操作Impl */
public class C0810Impl extends ComponentImpl implements C0809 {
    private Thread thread = new Thread(new C08081());
    /* renamed from: 参数 */
    private String f4331 = bi_常量类.f6358b;

    /* renamed from: com.e4a.runtime.components.impl.android.多线程操作Impl$1 */
    class C08081 implements Runnable {
        C08081() {
        }

        public void run() {
            C0810Impl.this.mo1451(C0810Impl.this.getParam());
        }
    }

    private String getParam() {
        return this.f4331;
    }

    public C0810Impl() {
        super(null);
    }

    /* renamed from: 线程处理过程 */
    public void mo1451(String param) {
    }

    /* renamed from: 启动线程 */
    public void mo1447(String param) {
        this.f4331 = param;
        this.thread.start();
    }

    /* renamed from: 停止线程 */
    public void mo1446() {
        try {
            this.thread.stop();
        } catch (Exception e) {
        }
    }

    /* renamed from: 暂停线程 */
    public void mo1449() {
        try {
            this.thread.wait();
        } catch (Exception e) {
        }
    }

    /* renamed from: 暂停线程2 */
    public void mo14502(int t) {
        try {
            Thread thread = this.thread;
            Thread.sleep((long) t);
        } catch (Exception e) {
        }
    }

    /* renamed from: 唤醒线程 */
    public void mo1448() {
        try {
            this.thread.interrupt();
        } catch (Exception e) {
        }
    }
}
