package com.e4a.runtime.components.impl.android.p018ok;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.components.Component;

@UsesPermissions(permissionNames = "android.permission.INTERNET")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.ok微信支付类库.ok微信支付 */
public interface C0794ok extends Component {
    @SimpleFunction
    /* renamed from: 初始化 */
    void mo1417(String str, String str2, String str3);

    @SimpleFunction
    /* renamed from: 开始支付 */
    void mo1418(String str);

    @SimpleFunction
    /* renamed from: 当前微信支付可以支付 */
    boolean mo1419();

    @SimpleEvent
    /* renamed from: 支付失败 */
    void mo1420();

    @SimpleEvent
    /* renamed from: 支付成功 */
    void mo1421();

    @SimpleEvent
    /* renamed from: 生成预支付订单号完毕 */
    void mo1422(String str);

    @SimpleEvent
    /* renamed from: 生成预支付订单号错误 */
    void mo1423(String str);

    @SimpleFunction
    /* renamed from: 置KEY */
    void mo1424KEY(String str);

    @SimpleFunction
    /* renamed from: 获取订单 */
    void mo1425(int i, String str, String str2, String str3);
}
