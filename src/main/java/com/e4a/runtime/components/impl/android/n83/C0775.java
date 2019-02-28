package com.e4a.runtime.components.impl.android.n83;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.components.Component;

@UsesPermissions(permissionNames = "android.permission.INTERNET,android.permission.READ_PHONE_STATE,android.permission.ACCESS_NETWORK_STATE,android.permission.ACCESS_WIFI_STATE")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n83.友盟统计 */
public interface C0775 extends Component {
    @SimpleFunction
    /* renamed from: 初始化 */
    void mo1302(String str, String str2);

    @SimpleFunction
    /* renamed from: 开始统计 */
    void mo1303(String str);

    @SimpleFunction
    /* renamed from: 结束统计 */
    void mo1304(String str);

    @SimpleFunction
    /* renamed from: 统计事件 */
    void mo1305(String str);
}
