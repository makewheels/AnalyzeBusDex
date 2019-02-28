package com.e4a.runtime.components.impl.android.n42;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.collections.C0682;
import com.e4a.runtime.components.Component;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n42.多线程 */
public interface C0743 extends Component {
    @SimpleEvent
    /* renamed from: 发送网络数据2完毕 */
    void mo11542(String str);

    @SimpleEvent
    /* renamed from: 发送网络数据3完毕 */
    void mo11553(String str);

    @SimpleEvent
    /* renamed from: 发送网络数据4完毕 */
    void mo11564(String str);

    @SimpleEvent
    /* renamed from: 发送网络数据完毕 */
    void mo1157(String str);

    @SimpleFunction
    /* renamed from: 取事件网址 */
    String mo1158();

    @SimpleFunction
    /* renamed from: 取消线程 */
    void mo1159();

    @SimpleEvent
    /* renamed from: 取网络文件完毕 */
    void mo1160(byte[] bArr);

    @SimpleEvent
    /* renamed from: 取网页源码2完毕 */
    void mo11612(String str);

    @SimpleEvent
    /* renamed from: 取网页源码完毕 */
    void mo1162(String str);

    @SimpleFunction
    /* renamed from: 启动线程 */
    void mo1163();

    @SimpleFunction
    /* renamed from: 开始发送网络数据 */
    void mo1164(String str, String str2, String str3);

    @SimpleFunction
    /* renamed from: 开始发送网络数据2 */
    void mo11652(String str, int i, String str2, String str3);

    @SimpleFunction
    /* renamed from: 开始发送网络数据3 */
    void mo11663(String str, C0682 c0682, String str2);

    @SimpleFunction
    /* renamed from: 开始发送网络数据4 */
    void mo11674(String str, String str2, String str3);

    @SimpleFunction
    /* renamed from: 开始取网络文件 */
    void mo1168(String str);

    @SimpleFunction
    /* renamed from: 开始取网页源码 */
    void mo1169(String str, String str2);

    @SimpleFunction
    /* renamed from: 开始取网页源码2 */
    void mo11702(String str, String str2);

    @SimpleEvent
    /* renamed from: 线程取消 */
    void mo1171();

    @SimpleEvent
    /* renamed from: 线程开始 */
    void mo1172();

    @SimpleEvent
    /* renamed from: 线程结束 */
    void mo1173();

    @SimpleEvent
    /* renamed from: 线程过程 */
    void mo1174();

    @SimpleEvent
    /* renamed from: 线程进度 */
    void mo1175(int i);
}
