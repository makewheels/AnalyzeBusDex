package com.e4a.runtime.components.impl.android.p020;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.components.Component;

@UsesPermissions(permissionNames = "android.permission.INTERNET,android.permission.ACCESS_NETWORK_STATE,android.permission.ACCESS_WIFI_STATE,android.permission.READ_PHONE_STATE,android.permission.WRITE_EXTERNAL_STORAGE")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.支付宝类库.支付宝 */
public interface C0813 extends Component {
    @SimpleFunction
    /* renamed from: 初始化 */
    void mo1456(String str, String str2, String str3, String str4);

    @SimpleFunction
    /* renamed from: 取SDK版本 */
    String mo1457SDK();

    @SimpleFunction
    /* renamed from: 开始支付 */
    void mo1458(String str, String str2, String str3, String str4);

    @SimpleEvent
    /* renamed from: 支付完毕 */
    void mo1459(int i);

    @SimpleEvent
    /* renamed from: 检查完毕 */
    void mo1460(boolean z);

    @SimpleFunction
    /* renamed from: 检查账户 */
    void mo1461();
}
