package com.e4a.runtime.components.impl.android.n79;

import android.view.Menu;
import com.e4a.runtime.annotations.SimpleComponent;
import com.e4a.runtime.annotations.SimpleEvent;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.components.Component;

@SimpleComponent
@SimpleObject
/* renamed from: com.e4a.runtime.components.impl.android.n79.活动栏 */
public interface C0771 extends Component {
    @SimpleEvent
    /* renamed from: 下拉列表被选择 */
    void mo1268(int i);

    @SimpleFunction
    /* renamed from: 传递当前菜单 */
    void mo1269(Menu menu);

    @SimpleFunction
    /* renamed from: 删除选项卡 */
    void mo1270(int i);

    @SimpleFunction
    /* renamed from: 取副标题 */
    String mo1271();

    @SimpleFunction
    /* renamed from: 取标题 */
    String mo1272();

    @SimpleFunction
    /* renamed from: 取选中选项卡 */
    int mo1273();

    @SimpleFunction
    /* renamed from: 取选项卡数量 */
    int mo1274();

    @SimpleFunction
    /* renamed from: 取选项卡标题 */
    String mo1275(int i);

    @SimpleFunction
    /* renamed from: 取高度 */
    int mo1276();

    @SimpleEvent
    /* renamed from: 图标被单击 */
    void mo1277();

    @SimpleFunction
    /* renamed from: 显示 */
    void mo1278();

    @SimpleFunction
    /* renamed from: 显示图标 */
    void mo1279();

    @SimpleFunction
    /* renamed from: 显示标题 */
    void mo1280();

    @SimpleFunction
    /* renamed from: 显示返回图标 */
    void mo1281();

    @SimpleFunction
    /* renamed from: 显示选项卡 */
    void mo1282();

    @SimpleFunction
    /* renamed from: 添加下拉列表 */
    void mo1283(String[] strArr);

    @SimpleFunction
    /* renamed from: 添加分享菜单 */
    void mo1284(String str, String str2);

    @SimpleFunction
    /* renamed from: 添加子菜单 */
    void mo1285(int i, String str, int i2);

    @SimpleFunction
    /* renamed from: 添加菜单 */
    void mo1286(int i, String str, int i2, boolean z, boolean z2);

    @SimpleFunction
    /* renamed from: 添加选项卡 */
    void mo1287(int i, String str, int i2);

    @SimpleFunction
    /* renamed from: 清空选项卡 */
    void mo1288();

    @SimpleFunction
    /* renamed from: 置副标题 */
    void mo1289(String str);

    @SimpleFunction
    /* renamed from: 置图标 */
    void mo1290(int i);

    @SimpleFunction
    /* renamed from: 置标题 */
    void mo1291(String str);

    @SimpleFunction
    /* renamed from: 置背景图片 */
    void mo1292(int i);

    @SimpleEvent
    /* renamed from: 菜单被创建 */
    void mo1293();

    @SimpleEvent
    /* renamed from: 菜单被选择 */
    void mo1294(int i);

    @SimpleFunction
    /* renamed from: 选中选项卡 */
    void mo1295(int i);

    @SimpleEvent
    /* renamed from: 选项卡被选择 */
    void mo1296(int i);

    @SimpleFunction
    /* renamed from: 隐藏 */
    void mo1297();

    @SimpleFunction
    /* renamed from: 隐藏图标 */
    void mo1298();

    @SimpleFunction
    /* renamed from: 隐藏标题 */
    void mo1299();

    @SimpleFunction
    /* renamed from: 隐藏返回图标 */
    void mo1300();

    @SimpleFunction
    /* renamed from: 隐藏选项卡 */
    void mo1301();
}
