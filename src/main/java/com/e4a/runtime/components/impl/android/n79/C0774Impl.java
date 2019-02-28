package com.e4a.runtime.components.impl.android.n79;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.ArrayAdapter;
import android.widget.ShareActionProvider;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.n79.活动栏Impl */
public class C0774Impl extends ComponentImpl implements C0771 {
    private List<Tab> tabs;
    /* renamed from: 当前菜单 */
    private Menu f4320;
    /* renamed from: 当前菜单项目 */
    private MenuItem f4321;
    /* renamed from: 显示菜单 */
    private boolean f4322;
    /* renamed from: 正在操作选项卡 */
    private boolean f4323 = false;
    /* renamed from: 添加前选中选项卡索引 */
    private int f4324 = -1;
    /* renamed from: 父菜单 */
    private SubMenu f4325;

    /* renamed from: com.e4a.runtime.components.impl.android.n79.活动栏Impl$1 */
    class C07721 implements OnNavigationListener {
        C07721() {
        }

        public boolean onNavigationItemSelected(int itemPosition, long itemId) {
            C0774Impl.this.mo1268(itemPosition);
            return false;
        }
    }

    /* renamed from: com.e4a.runtime.components.impl.android.n79.活动栏Impl$2 */
    class C07732 implements TabListener {
        C07732() {
        }

        public void onTabSelected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
            if (C0774Impl.this.f4323) {
                C0774Impl.this.f4323 = false;
            } else if (C0774Impl.this.f4324 != paramTab.getPosition()) {
                C0774Impl.this.f4324 = paramTab.getPosition();
                C0774Impl.this.mo1296(paramTab.getPosition());
            }
        }

        public void onTabUnselected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
        }

        public void onTabReselected(Tab paramTab, FragmentTransaction paramFragmentTransaction) {
        }
    }

    public C0774Impl(ComponentContainer container) {
        super(container);
        if (VERSION.SDK_INT >= 11) {
            this.tabs = new ArrayList();
        }
    }

    /* renamed from: 传递当前菜单 */
    public void mo1269(Menu menu) {
        this.f4320 = menu;
    }

    /* renamed from: 添加菜单 */
    public void mo1286(int 菜单索引, String 菜单名称, int 菜单图标, boolean 是否显示, boolean 包含子菜单) {
        if (VERSION.SDK_INT < 11 || this.f4320 == null) {
            return;
        }
        if (包含子菜单) {
            this.f4322 = 是否显示;
            this.f4325 = this.f4320.addSubMenu(0, 菜单索引, 菜单索引, 菜单名称);
            if (菜单图标 > -1) {
                this.f4325.setIcon(菜单图标);
                return;
            }
            return;
        }
        this.f4321 = this.f4320.add(0, 菜单索引, 菜单索引, 菜单名称);
        if (菜单图标 > -1) {
            this.f4321.setIcon(菜单图标);
        }
        if (是否显示) {
            this.f4321.setShowAsAction(5);
        } else {
            this.f4321.setShowAsAction(0);
        }
    }

    /* renamed from: 添加分享菜单 */
    public void mo1284(String 分享的内容, String 分享的图片路径) {
        if (VERSION.SDK_INT >= 14 && this.f4321 != null) {
            this.f4321.setActionProvider(new ShareActionProvider(mainActivity.getContext()));
            ShareActionProvider sap = (ShareActionProvider) this.f4321.getActionProvider();
            Intent intent = new Intent("android.intent.action.SEND");
            if (bi_常量类.f6358b_空串.equals(分享的图片路径)) {
                intent.setType("text/plain");
            } else {
                intent.setType("image/*");
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(分享的图片路径)));
            }
            intent.putExtra("android.intent.extra.SUBJECT", "分享到");
            intent.putExtra("android.intent.extra.TEXT", 分享的内容);
            intent.setFlags(268435456);
            sap.setShareIntent(intent);
        }
    }

    /* renamed from: 添加子菜单 */
    public void mo1285(int 菜单索引, String 菜单名称, int 菜单图标) {
        if (VERSION.SDK_INT >= 11 && this.f4325 != null) {
            MenuItem item = this.f4325.add(1, 菜单索引, 菜单索引, 菜单名称);
            if (菜单图标 > -1) {
                item.setIcon(菜单图标);
            }
            if (this.f4322) {
                this.f4325.getItem().setShowAsAction(5);
            }
        }
    }

    /* renamed from: 添加下拉列表 */
    public void mo1283(String[] 表项数据) {
        if (VERSION.SDK_INT >= 11) {
            ActionBar actionBar = mainActivity.getContext().getActionBar();
            ArrayAdapter<String> adapter = new ArrayAdapter(mainActivity.getContext(), 17367048, 表项数据);
            actionBar.setNavigationMode(1);
            actionBar.setListNavigationCallbacks(adapter, new C07721());
        }
    }

    /* renamed from: 添加选项卡 */
    public void mo1287(int 选项卡索引, String 选项卡名称, int 选项卡图标) {
        if (VERSION.SDK_INT >= 11) {
            ActionBar actionBar = mainActivity.getContext().getActionBar();
            actionBar.setNavigationMode(2);
            Tab SelectedTab = actionBar.getSelectedTab();
            if (SelectedTab != null) {
                this.f4324 = SelectedTab.getPosition();
            } else {
                this.f4324 = 0;
            }
            Tab tab = actionBar.newTab();
            tab.setText(选项卡名称);
            if (选项卡图标 > -1) {
                tab.setIcon(选项卡图标);
            }
            this.f4323 = true;
            tab.setTabListener(new C07732());
            actionBar.addTab(tab, 选项卡索引, false);
            this.tabs.add(tab);
            actionBar.selectTab((Tab) this.tabs.get(0));
            this.f4323 = false;
        }
    }

    /* renamed from: 选中选项卡 */
    public void mo1295(int 选项卡索引) {
        if (VERSION.SDK_INT >= 11 && 选项卡索引 < this.tabs.size() && 选项卡索引 >= 0) {
            mainActivity.getContext().getActionBar().selectTab((Tab) this.tabs.get(选项卡索引));
        }
    }

    /* renamed from: 取选中选项卡 */
    public int mo1273() {
        if (VERSION.SDK_INT < 11) {
            return -1;
        }
        Tab tab = mainActivity.getContext().getActionBar().getSelectedTab();
        if (tab != null) {
            return tab.getPosition();
        }
        return -1;
    }

    /* renamed from: 取选项卡标题 */
    public String mo1275(int 选项卡索引) {
        if (VERSION.SDK_INT < 11) {
            return bi_常量类.f6358b_空串;
        }
        if (选项卡索引 >= this.tabs.size() || 选项卡索引 < 0) {
            return bi_常量类.f6358b_空串;
        }
        Tab tab = mainActivity.getContext().getActionBar().getTabAt(选项卡索引);
        if (tab != null) {
            return tab.getText().toString();
        }
        return bi_常量类.f6358b_空串;
    }

    /* renamed from: 取选项卡数量 */
    public int mo1274() {
        if (VERSION.SDK_INT < 11) {
            return 0;
        }
        return mainActivity.getContext().getActionBar().getTabCount();
    }

    /* renamed from: 删除选项卡 */
    public void mo1270(int 选项卡索引) {
        if (VERSION.SDK_INT >= 11 && 选项卡索引 < this.tabs.size() && 选项卡索引 >= 0) {
            this.f4323 = true;
            mainActivity.getContext().getActionBar().removeTabAt(选项卡索引);
            this.tabs.remove(选项卡索引);
        }
    }

    /* renamed from: 清空选项卡 */
    public void mo1288() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().removeAllTabs();
            this.tabs.clear();
        }
    }

    /* renamed from: 隐藏选项卡 */
    public void mo1301() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setNavigationMode(0);
        }
    }

    /* renamed from: 显示选项卡 */
    public void mo1282() {
        if (VERSION.SDK_INT >= 11) {
            this.f4323 = true;
            mainActivity.getContext().getActionBar().setNavigationMode(2);
        }
    }

    /* renamed from: 取高度 */
    public int mo1276() {
        if (VERSION.SDK_INT < 11) {
            return 0;
        }
        return mainActivity.getContext().getActionBar().getHeight();
    }

    /* renamed from: 取标题 */
    public String mo1272() {
        if (VERSION.SDK_INT < 11) {
            return bi_常量类.f6358b_空串;
        }
        return mainActivity.getContext().getActionBar().getTitle().toString();
    }

    /* renamed from: 置标题 */
    public void mo1291(String 标题) {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setTitle(标题);
        }
    }

    /* renamed from: 取副标题 */
    public String mo1271() {
        if (VERSION.SDK_INT < 11) {
            return bi_常量类.f6358b_空串;
        }
        return mainActivity.getContext().getActionBar().getSubtitle().toString();
    }

    /* renamed from: 置副标题 */
    public void mo1289(String 副标题) {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setSubtitle(副标题);
        }
    }

    /* renamed from: 置图标 */
    public void mo1290(int 图标) {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setLogo(图标);
        }
    }

    /* renamed from: 隐藏标题 */
    public void mo1299() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    /* renamed from: 显示标题 */
    public void mo1280() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    /* renamed from: 隐藏图标 */
    public void mo1298() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setDisplayShowHomeEnabled(false);
        }
    }

    /* renamed from: 显示图标 */
    public void mo1279() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    /* renamed from: 隐藏返回图标 */
    public void mo1300() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    /* renamed from: 显示返回图标 */
    public void mo1281() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /* renamed from: 隐藏 */
    public void mo1297() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().hide();
        }
    }

    /* renamed from: 显示 */
    public void mo1278() {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().show();
        }
    }

    /* renamed from: 置背景图片 */
    public void mo1292(int id) {
        if (VERSION.SDK_INT >= 11) {
            mainActivity.getContext().getActionBar().setBackgroundDrawable(mainActivity.getContext().getBaseContext().getResources().getDrawable(id));
        }
    }

    /* renamed from: 菜单被创建 */
    public void mo1293() {
        EventDispatcher.dispatchEvent(this, "菜单被创建", new Object[0]);
    }

    /* renamed from: 菜单被选择 */
    public void mo1294(int 菜单索引) {
        EventDispatcher.dispatchEvent(this, "菜单被选择", Integer.valueOf(菜单索引));
    }

    /* renamed from: 图标被单击 */
    public void mo1277() {
        EventDispatcher.dispatchEvent(this, "图标被单击", new Object[0]);
    }

    /* renamed from: 下拉列表被选择 */
    public void mo1268(int 表项索引) {
        EventDispatcher.dispatchEvent(this, "下拉列表被选择", Integer.valueOf(表项索引));
    }

    /* renamed from: 选项卡被选择 */
    public void mo1296(int 选项卡索引) {
        EventDispatcher.dispatchEvent(this, "选项卡被选择", Integer.valueOf(选项卡索引));
    }
}
