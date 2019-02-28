package com.e4a.runtime.components.impl.android.n36;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.UsesPermissions;
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.components.Component;

@UsesPermissions(permissionNames = "android.permission.WRITE_EXTERNAL_STORAGE,android.permission.MOUNT_UNMOUNT_FILESYSTEMS,android.permission.INTERNET")
@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n36.下载器 */
public interface C0733 extends Component {
    @SimpleEvent
    /* renamed from: 下载完毕 */
    void mo1122(int i, boolean z);

    @SimpleFunction
    /* renamed from: 取未完成记录 */
    C0683_集合类 mo1123();

    @SimpleFunction
    /* renamed from: 取消下载 */
    void mo1124(int i);

    @SimpleFunction
    /* renamed from: 开始下载 */
    int mo1125(String str, String str2);

    @SimpleFunction
    /* renamed from: 暂停下载 */
    void mo1126(int i);

    @SimpleFunction
    /* renamed from: 继续下载 */
    void mo1127(int i);

    @SimpleEvent
    /* renamed from: 进度改变 */
    void mo1128(int i, int i2, int i3, int i4);
}
