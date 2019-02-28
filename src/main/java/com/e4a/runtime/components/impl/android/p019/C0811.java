package com.e4a.runtime.components.impl.android.p019;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.components.Component;

@UsesPermissions(permissionNames = "android.permission.INTERNET")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.支付宝免签约支付类库.支付宝免签约支付 */
public interface C0811 extends Component {
    @SimpleFunction
    /* renamed from: 初始化 */
    void mo1454(String str);

    @SimpleFunction
    /* renamed from: 开始支付 */
    void mo1455();
}
