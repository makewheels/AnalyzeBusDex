package com.e4a.runtime.components.impl.android.n12;

import android.os.Handler;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;

/* renamed from: com.e4a.runtime.components.impl.android.n12.时钟Impl */
public class C0697Impl extends ComponentImpl implements C0696, Runnable {
    private boolean enabled;
    private Handler handler = new Handler();
    private int interval;

    public C0697Impl(ComponentContainer container) {
        super(container);
    }

    /* renamed from: 周期事件 */
    public void mo926() {
        EventDispatcher.dispatchEvent(this, "周期事件", new Object[0]);
    }

    /* renamed from: 时钟周期 */
    public int mo927() {
        return this.interval;
    }

    /* renamed from: 时钟周期 */
    public void mo928(int newInterval) {
        this.interval = newInterval;
        if (newInterval > 0) {
            this.enabled = true;
        } else {
            this.enabled = false;
        }
        if (this.enabled) {
            this.handler.removeCallbacks(this);
            this.handler.postDelayed(this, (long) newInterval);
        }
    }

    /* renamed from: 可用 */
    public boolean mo925() {
        return this.enabled;
    }

    /* renamed from: 可用 */
    public void mo924(boolean enable) {
        if (this.enabled) {
            this.handler.removeCallbacks(this);
        }
        this.enabled = enable;
        if (enable) {
            this.handler.postDelayed(this, (long) this.interval);
        }
    }

    public void run() {
        if (this.enabled) {
            mo926();
            this.handler.postDelayed(this, (long) this.interval);
        }
    }
}
