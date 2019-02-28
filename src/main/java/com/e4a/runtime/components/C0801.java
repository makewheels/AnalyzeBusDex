package com.e4a.runtime.components;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.后台服务 */
public interface C0801 extends Component {
    @SimpleFunction
    /* renamed from: 服务处理过程 */
    void mo1433(String str);

    @SimpleFunction
    /* renamed from: 服务被创建 */
    void mo1434();

    @SimpleFunction
    /* renamed from: 服务被销毁 */
    void mo1435();
}
