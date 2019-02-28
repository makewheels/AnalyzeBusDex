package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.事件监听器 */
public interface C0797 extends Component {
    @SimpleEvent
    /* renamed from: 内容被改变 */
    void mo1426(int i, String str);

    @SimpleEvent
    /* renamed from: 被单击 */
    void mo1427(int i);

    @SimpleEvent
    /* renamed from: 被弹起 */
    void mo1428(int i, int i2, int i3);

    @SimpleEvent
    /* renamed from: 被按下 */
    void mo1429(int i, int i2, int i3);

    @SimpleEvent
    /* renamed from: 被移动 */
    void mo1430(int i, int i2, int i3, int i4, int i5);

    @SimpleEvent
    /* renamed from: 被长按 */
    void mo1431(int i);
}
