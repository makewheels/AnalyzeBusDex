package com.e4a.runtime.components.impl.android.n73;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.Component;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n73.状态栏通知 */
public interface C0768 extends Component {
    @SimpleFunction
    /* renamed from: 删除通知 */
    void mo1263(int i);

    @SimpleFunction
    /* renamed from: 添加下载进度通知 */
    void mo1264(int i, String str, String str2, int i2);

    @SimpleFunction
    /* renamed from: 添加通知 */
    void mo1265(int i, String str, String str2, String str3, int i2, boolean z, boolean z2);

    @SimpleFunction
    /* renamed from: 清空通知 */
    void mo1266();

    @SimpleEvent
    /* renamed from: 通知被单击 */
    void mo1267(int i);
}
