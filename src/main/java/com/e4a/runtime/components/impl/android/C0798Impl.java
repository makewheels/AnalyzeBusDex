package com.e4a.runtime.components.impl.android;

import com.e4a.runtime.components.C0797;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;

/* renamed from: com.e4a.runtime.components.impl.android.事件监听器Impl */
public class C0798Impl extends ComponentImpl implements C0797 {
    public C0798Impl(ComponentContainer container) {
        super(container);
    }

    /* renamed from: 被单击 */
    public void mo1427(int id) {
        EventDispatcher.dispatchEvent(this, "被单击", Integer.valueOf(id));
    }

    /* renamed from: 被长按 */
    public void mo1431(int id) {
        EventDispatcher.dispatchEvent(this, "被长按", Integer.valueOf(id));
    }

    /* renamed from: 被按下 */
    public void mo1429(int id, int x, int y) {
        EventDispatcher.dispatchEvent(this, "被按下", Integer.valueOf(id), Integer.valueOf(x), Integer.valueOf(y));
    }

    /* renamed from: 被弹起 */
    public void mo1428(int id, int x, int y) {
        EventDispatcher.dispatchEvent(this, "被弹起", Integer.valueOf(id), Integer.valueOf(x), Integer.valueOf(y));
    }

    /* renamed from: 被移动 */
    public void mo1430(int id, int x1, int y1, int x2, int y2) {
        EventDispatcher.dispatchEvent(this, "被移动", Integer.valueOf(id), Integer.valueOf(x1), Integer.valueOf(y1), Integer.valueOf(x2), Integer.valueOf(y2));
    }

    /* renamed from: 内容被改变 */
    public void mo1426(int id, String 新内容) {
        EventDispatcher.dispatchEvent(this, "内容被改变", Integer.valueOf(id), 新内容);
    }
}
