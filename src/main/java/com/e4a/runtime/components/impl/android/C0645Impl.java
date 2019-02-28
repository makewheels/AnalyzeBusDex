package com.e4a.runtime.components.impl.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ScrollView;
import com.e4a.runtime.Log;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.android.mainActivity.OnDestroyListener;
import com.e4a.runtime.android.mainActivity.OnNewIntentListener;
import com.e4a.runtime.android.mainActivity.OnPauseListener;
import com.e4a.runtime.android.mainActivity.OnResumeListener;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.errors.PropertyAccessError;
import com.e4a.runtime.events.EventDispatcher;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p054u.aly.bi_常量类;

/* renamed from: com.e4a.runtime.components.impl.android.窗口Impl */
public abstract class C0645Impl extends C0643Impl implements C0644, OnResumeListener, OnPauseListener, OnDestroyListener, OnNewIntentListener {
    private List<String> ContextMenuItems = new ArrayList();
    private String backgroundImage;
    private int backgroundImage2;
    private List<Map<String, String>> menuItems = new ArrayList();
    private ScrollView scroller;
    private String title;
    /* renamed from: 方式 */
    private int f3945 = 1;

    public C0645Impl() {
        super(null);
        mainActivity context = mainActivity.getContext();
        context.addOnResumeListener(this);
        context.addOnPauseListener(this);
        context.addOnDestroyListener(this);
        context.addOnNewIntentListener(this);
    }

    public void onPause() {
        mo846();
    }

    /* renamed from: 程序被暂停 */
    public void mo846() {
        EventDispatcher.dispatchEvent(this, "程序被暂停", new Object[0]);
    }

    public void onResume() {
        mo847();
    }

    /* renamed from: 程序被重启 */
    public void mo847() {
        EventDispatcher.dispatchEvent(this, "程序被重启", new Object[0]);
    }

    public void onDestroy() {
        mo848();
    }

    /* renamed from: 程序被销毁 */
    public void mo848() {
        EventDispatcher.dispatchEvent(this, "程序被销毁", new Object[0]);
    }

    public void onNewIntent(Intent intent) {
        String param1 = intent.getStringExtra("参数");
        if (param1 == null || param1.equals(bi_常量类.f6358b)) {
            mo845(intent.getDataString());
        } else {
            mo845(param1);
        }
    }

    /* renamed from: 程序被启动 */
    public void mo845(String 参数) {
        if (参数 == null || 参数.equals(bi_常量类.f6358b)) {
            EventDispatcher.dispatchEvent(this, "程序被启动", bi_常量类.f6358b);
            return;
        }
        EventDispatcher.dispatchEvent(this, "程序被启动", 参数);
    }

    /* renamed from: 屏幕方向被改变 */
    public void mo828(int 屏幕方向) {
        EventDispatcher.dispatchEvent(this, "屏幕方向被改变", Integer.valueOf(屏幕方向));
    }

    /* renamed from: 添加菜单 */
    public void mo842(String caption, int icon) {
        Map<String, String> map = new HashMap();
        map.put("caption", caption);
        map.put("icon", Integer.toString(icon));
        this.menuItems.add(map);
    }

    /* renamed from: 清空菜单 */
    public void mo844() {
        this.menuItems.clear();
    }

    /* renamed from: 获取菜单 */
    public List<Map<String, String>> m5159() {
        return this.menuItems;
    }

    /* renamed from: 添加弹出菜单 */
    public void mo841(String caption) {
        this.ContextMenuItems.add(caption);
    }

    /* renamed from: 清空弹出菜单 */
    public void mo843() {
        this.ContextMenuItems.clear();
    }

    /* renamed from: 获取弹出菜单 */
    public List<String> m5158() {
        return this.ContextMenuItems;
    }

    /* renamed from: 按下某键 */
    public void mo834(int keycode, BooleanReferenceParameter shield) {
        EventDispatcher.dispatchEvent(this, "按下某键", Integer.valueOf(keycode), shield);
    }

    /* renamed from: 菜单被选择 */
    public void mo849(String caption) {
        EventDispatcher.dispatchEvent(this, "菜单被选择", caption);
    }

    /* renamed from: 弹出菜单被选择 */
    public void mo829(String caption) {
        EventDispatcher.dispatchEvent(this, "弹出菜单被选择", caption);
    }

    /* renamed from: 触摸手势 */
    public void mo850(int direction) {
        EventDispatcher.dispatchEvent(this, "触摸手势", Integer.valueOf(direction));
    }

    /* renamed from: 切换完毕 */
    public void mo825() {
        EventDispatcher.dispatchEvent(this, "切换完毕", new Object[0]);
    }

    /* renamed from: 日期框被选择 */
    public void mo835(String date) {
        EventDispatcher.dispatchEvent(this, "日期框被选择", date);
    }

    /* renamed from: 时间框被选择 */
    public void mo836(String time) {
        EventDispatcher.dispatchEvent(this, "时间框被选择", time);
    }

    /* renamed from: 悬浮按钮被按下 */
    public void mo832() {
        EventDispatcher.dispatchEvent(this, "悬浮按钮被按下", new Object[0]);
    }

    /* renamed from: 悬浮按钮被弹起 */
    public void mo831() {
        EventDispatcher.dispatchEvent(this, "悬浮按钮被弹起", new Object[0]);
    }

    /* renamed from: 悬浮按钮被单击 */
    public void mo830() {
        EventDispatcher.dispatchEvent(this, "悬浮按钮被单击", new Object[0]);
    }

    /* renamed from: 悬浮按钮被长按 */
    public void mo833() {
        EventDispatcher.dispatchEvent(this, "悬浮按钮被长按", new Object[0]);
    }

    /* renamed from: 列 */
    public int mo766() {
        throw new PropertyAccessError();
    }

    /* renamed from: 列 */
    public void mo767(int newColumn) {
        Log.Warning(Log.MODULE_NAME_RTL, "attempt to set column for form component");
    }

    /* renamed from: 高度 */
    public int mo805() {
        return this.viewLayout.getLayoutManager().getHeight();
    }

    /* renamed from: 高度 */
    public void mo806(int newHeight) {
        throw new PropertyAccessError();
    }

    /* renamed from: 行 */
    public int mo800() {
        throw new PropertyAccessError();
    }

    /* renamed from: 行 */
    public void mo801(int newRow) {
        Log.Warning(Log.MODULE_NAME_RTL, "attempt to set row for form component");
    }

    /* renamed from: 可否滚动 */
    public boolean mo827() {
        return this.scroller != null;
    }

    /* renamed from: 可否滚动 */
    public void mo826(boolean scrollable) {
        mainActivity app = mainActivity.getContext();
        View view = this.viewLayout.getLayoutManager();
        if (scrollable) {
            if (this.scroller == null) {
                this.scroller = new ScrollView(app);
                if (app.isActiveForm(this)) {
                    app.setContent(this.scroller);
                }
                this.scroller.addView(view, new LayoutParams(-1, -1));
            }
        } else if (this.scroller != null) {
            this.scroller.removeView(view);
            this.scroller = null;
            if (app.isActiveForm(this)) {
                app.setContent(view);
            }
        }
    }

    /* renamed from: 标题 */
    public String mo839() {
        return this.title;
    }

    /* renamed from: 标题 */
    public void mo840(String newTitle) {
        this.title = newTitle;
        mainActivity.getContext().setTitle(this.title);
    }

    /* renamed from: 宽度 */
    public int mo779() {
        return this.viewLayout.getLayoutManager().getWidth();
    }

    /* renamed from: 宽度 */
    public void mo780(int newWidth) {
        throw new PropertyAccessError();
    }

    protected void addToContainer() {
    }

    public View getView() {
        return this.scroller != null ? this.scroller : this.viewLayout.getLayoutManager();
    }

    /* renamed from: 显示方式 */
    public int mo837() {
        return this.f3945;
    }

    /* renamed from: 显示方式 */
    public void mo838(int style) {
        this.f3945 = style;
    }

    /* renamed from: 背景图片 */
    public String mo816() {
        return this.backgroundImage;
    }

    /* renamed from: 背景图片 */
    public void mo817(String imagePath) {
        if (imagePath.length() > 0) {
            this.backgroundImage = imagePath;
            Drawable drawable = null;
            if (!imagePath.startsWith("/")) {
                try {
                    drawable = this.f3945 == 2 ? new BitmapDrawable(createRepeater(BitmapFactory.decodeStream(mainActivity.getContext().getResources().getAssets().open(imagePath)))) : Drawable.createFromStream(mainActivity.getContext().getResources().getAssets().open(imagePath), imagePath);
                } catch (IOException e) {
                }
            } else if (new File(imagePath).exists()) {
                drawable = this.f3945 == 2 ? new BitmapDrawable(createRepeater(BitmapFactory.decodeFile(imagePath))) : Drawable.createFromPath(imagePath);
            }
            View view = getView();
            view.setBackgroundDrawable(drawable);
            view.invalidate();
        }
    }

    private Bitmap createRepeater(Bitmap src) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        mainActivity.getContext().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;
        int count1 = ((src.getWidth() + width) - 1) / src.getWidth();
        int count2 = ((src.getHeight() + height) - 1) / src.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        for (int idx1 = 0; idx1 < count1; idx1++) {
            for (int idx2 = 0; idx2 < count2; idx2++) {
                canvas.drawBitmap(src, (float) (src.getWidth() * idx1), (float) (src.getHeight() * idx2), null);
            }
        }
        return bitmap;
    }

    /* renamed from: 背景图片2 */
    public int mo8182() {
        return this.backgroundImage2;
    }

    /* renamed from: 背景图片2 */
    public void mo8192(int id) {
        this.backgroundImage2 = id;
        View view = getView();
        if (this.f3945 == 2) {
            view.setBackgroundDrawable(new BitmapDrawable(createRepeater(BitmapFactory.decodeResource(mainActivity.getContext().getResources(), id))));
        } else {
            view.setBackgroundResource(id);
        }
        view.invalidate();
    }
}
