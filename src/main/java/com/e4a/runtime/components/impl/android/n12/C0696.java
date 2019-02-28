package com.e4a.runtime.components.impl.android.n12;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.Component;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n12.时钟 */
public interface C0696 extends Component {
    @SimpleProperty(initializer = "True", type = "simple.boolean")
    /* renamed from: 可用 */
    void mo924(boolean z);

    @SimpleProperty
    /* renamed from: 可用 */
    boolean mo925();

    @SimpleEvent
    /* renamed from: 周期事件 */
    void mo926();

    @SimpleProperty
    /* renamed from: 时钟周期 */
    int mo927();

    @SimpleProperty(initializer = "1000", type = "simple.integer")
    /* renamed from: 时钟周期 */
    void mo928(int i);
}
