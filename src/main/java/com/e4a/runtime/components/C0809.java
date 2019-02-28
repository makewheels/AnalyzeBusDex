package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.多线程操作 */
public interface C0809 extends Component {
    @SimpleFunction
    /* renamed from: 停止线程 */
    void mo1446();

    @SimpleFunction
    /* renamed from: 启动线程 */
    void mo1447(String str);

    @SimpleFunction
    /* renamed from: 唤醒线程 */
    void mo1448();

    @SimpleFunction
    /* renamed from: 暂停线程 */
    void mo1449();

    @SimpleFunction
    /* renamed from: 暂停线程2 */
    void mo14502(int i);

    @SimpleFunction
    /* renamed from: 线程处理过程 */
    void mo1451(String str);
}
