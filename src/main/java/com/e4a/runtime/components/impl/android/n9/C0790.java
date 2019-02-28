package com.e4a.runtime.components.impl.android.n9;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.components.Component;

@UsesPermissions(permissionNames = "android.permission.CALL_PHONE,android.permission.VIBRATE,android.permission.READ_PHONE_STATE,android.permission.MODIFY_PHONE_STATE,android.permission.READ_CALL_LOG,android.permission.MODIFY_AUDIO_SETTINGS,android.permission.ACCESS_COARSE_LOCATION,android.permission.PROCESS_OUTGOING_CALLS")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n9.手机 */
public interface C0790 extends Component {
    @SimpleFunction
    /* renamed from: 关闭扬声器 */
    void mo1390();

    @SimpleFunction
    /* renamed from: 删除通话记录 */
    void mo1391(String str);

    @SimpleFunction
    /* renamed from: 发送彩信 */
    void mo1392(String str, String str2, String str3);

    @SimpleFunction
    /* renamed from: 发送邮件 */
    void mo1393(String str, String str2, String str3);

    @SimpleFunction
    /* renamed from: 发送邮件2 */
    void mo13942(String[] strArr, String str, String str2, String str3);

    @SimpleFunction
    /* renamed from: 取IMEI码 */
    String mo1395IMEI();

    @SimpleFunction
    /* renamed from: 取IMSI码 */
    String mo1396IMSI();

    @SimpleFunction
    /* renamed from: 取SIM卡状态 */
    int mo1397SIM();

    @SimpleFunction
    /* renamed from: 取当前基站信息 */
    String[] mo1398();

    @SimpleFunction
    /* renamed from: 取手机型号 */
    String mo1399();

    @SimpleFunction
    /* renamed from: 取扬声器状态 */
    boolean mo1400();

    @SimpleFunction
    /* renamed from: 取本机号码 */
    String mo1401();

    @SimpleFunction
    /* renamed from: 取相邻基站信息 */
    C0683_集合类 mo1402();

    @SimpleFunction
    /* renamed from: 取系统版本号 */
    String mo1403();

    @SimpleFunction
    /* renamed from: 取系统版本名 */
    String mo1404();

    @SimpleFunction
    /* renamed from: 取通话记录 */
    String mo1405();

    @SimpleFunction
    /* renamed from: 启动拨号界面 */
    void mo1406(String str);

    @SimpleFunction
    /* renamed from: 打开扬声器 */
    void mo1407();

    @SimpleFunction
    /* renamed from: 拨号 */
    void mo1408(String str);

    @SimpleFunction
    /* renamed from: 挂断电话 */
    void mo1409();

    @SimpleFunction
    /* renamed from: 振动 */
    void mo1410(int i);

    @SimpleFunction
    /* renamed from: 接听电话 */
    void mo1411();

    @SimpleEvent
    /* renamed from: 电池状态改变 */
    void mo1412(int i, int i2, int i3);

    @SimpleEvent
    /* renamed from: 电话打进 */
    void mo1413(String str);

    @SimpleEvent
    /* renamed from: 电话拨出 */
    void mo1414(String str);

    @SimpleEvent
    /* renamed from: 电话挂断 */
    void mo1415(String str);

    @SimpleEvent
    /* renamed from: 电话接听 */
    void mo1416(String str);
}
