package com.e4a.runtime.components.impl.android.n37;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.components.Component;

@UsesPermissions(permissionNames = "android.permission.INTERNET")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n37.客户 */
public interface C0736 extends Component {
    @SimpleFunction
    /* renamed from: 发送数据 */
    void mo1129(byte[] bArr);

    @SimpleFunction
    /* renamed from: 取连接状态 */
    boolean mo1130();

    @SimpleEvent
    /* renamed from: 收到数据 */
    void mo1131(byte[] bArr);

    @SimpleFunction
    /* renamed from: 断开连接 */
    void mo1132();

    @SimpleFunction
    /* renamed from: 置接收数据包大小 */
    void mo1133(int i);

    @SimpleEvent
    /* renamed from: 连接完毕 */
    void mo1134(boolean z);

    @SimpleEvent
    /* renamed from: 连接断开 */
    void mo1135();

    @SimpleFunction
    /* renamed from: 连接服务器 */
    void mo1136(String str, int i, int i2);
}
