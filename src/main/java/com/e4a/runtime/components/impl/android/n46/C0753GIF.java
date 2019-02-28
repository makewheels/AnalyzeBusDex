package com.e4a.runtime.components.impl.android.n46;

import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.annotations.SimpleProperty;
import com.e4a.runtime.components.VisibleComponent;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n46.GIF图片框 */
public interface C0753GIF extends VisibleComponent {
    @SimpleProperty
    /* renamed from: 图像 */
    String mo1176();

    @SimpleProperty(initializer = "\"\"", type = "simple.asset")
    /* renamed from: 图像 */
    void mo1177(String str);

    @SimpleEvent
    /* renamed from: 被单击 */
    void mo1178();

    @SimpleFunction
    /* renamed from: 载入字节图片 */
    void mo1179(byte[] bArr);
}
