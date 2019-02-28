package com.e4a.runtime.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;
import com.e4a.runtime.ApplicationFunctions;
import com.e4a.runtime.Log;
import com.e4a.runtime.components.C0644;
import com.e4a.runtime.components.impl.android.C0645Impl;
import com.e4a.runtime.components.impl.android.n37.C0738Impl;
import com.e4a.runtime.components.impl.android.n79.C0771;
import com.e4a.runtime.components.impl.android.n79.C0774Impl;
import com.e4a.runtime.parameters.BooleanReferenceParameter;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class mainActivity extends Activity implements ApplicationFunctions {
    private static mainActivity INSTANCE;
    private static C0645Impl activeForm;
    private static String mainFormName;
    /* renamed from: 初始分 */
    public static int f4272 = -1;
    /* renamed from: 初始年 */
    public static int f4273 = -1;
    /* renamed from: 初始日 */
    public static int f4274 = -1;
    /* renamed from: 初始时 */
    public static int f4275 = -1;
    /* renamed from: 初始月 */
    public static int f4276 = -1;
    /* renamed from: 日期框首次响应 */
    public static boolean f4277 = true;
    /* renamed from: 时间框首次响应 */
    public static boolean f4278 = true;
    /* renamed from: 默认字体像素大小 */
    private static float f4279;
    private Map<String, C0738Impl> clientmap;
    private View contentView;
    private Map<String, C0645Impl> formmap;
    private GestureDetector gestureDetector;
    private Map<String, Object> modelmap;
    private Map<String, Object> objmap;
    private final List<OnActivityResultListener> onActivityResultListeners;
    private final List<OnDestroyListener> onDestroyListeners;
    private final List<OnNewIntentListener> onNewIntentListeners;
    private final List<OnPauseListener> onPauseListeners;
    private final List<OnResumeListener> onResumeListeners;
    private final List<OnSaveInstanceStateListener> onSaveInstanceStateListeners;
    private ViewGroup rootView;
    /* renamed from: 启动设置 */
    private Bundle f4280;
    /* renamed from: 字体自适应 */
    private boolean f4281 = true;
    /* renamed from: 当前活动栏 */
    private C0774Impl f4282;

    public interface OnResumeListener {
        void onResume();
    }

    public interface OnPauseListener {
        void onPause();
    }

    public interface OnDestroyListener {
        void onDestroy();
    }

    public interface OnNewIntentListener {
        void onNewIntent(Intent intent);
    }

    /* renamed from: com.e4a.runtime.android.mainActivity$1 */
    class C06751 extends SimpleOnGestureListener {
        C06751() {
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean z = false;
            try {
                int deltaX = (int) (e1.getRawX() - e2.getRawX());
                int deltaY = (int) (e1.getRawY() - e2.getRawY());
                try {
                    int direction = Math.abs(deltaX) > Math.abs(deltaY) ? deltaX > 0 ? 4 : 5 : deltaY > 0 ? 2 : 3;
                    if (mainActivity.activeForm != null) {
                        mainActivity.activeForm.mo850(direction);
                    }
                    return true;
                } catch (Exception e) {
                    return z;
                }
            } catch (Exception e3) {
                return z;
            }
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            try {
                int direction = Math.abs(distanceX) > Math.abs(distanceY) ? distanceX > 0.0f ? 8 : 9 : distanceY > 0.0f ? 6 : 7;
                if (mainActivity.activeForm != null) {
                    mainActivity.activeForm.mo850(direction);
                }
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (mainActivity.activeForm != null) {
                mainActivity.activeForm.mo850(0);
            }
            return true;
        }

        public boolean onDoubleTap(MotionEvent e) {
            if (mainActivity.activeForm != null) {
                mainActivity.activeForm.mo850(1);
            }
            return true;
        }
    }

    /* renamed from: com.e4a.runtime.android.mainActivity$3 */
    class C06773 implements OnCancelListener {
        C06773() {
        }

        public void onCancel(DialogInterface param) {
            mainActivity.getContext().removeDialog(0);
        }
    }

    /* renamed from: com.e4a.runtime.android.mainActivity$4 */
    class C06784 implements OnDismissListener {
        C06784() {
        }

        public void onDismiss(DialogInterface param) {
            mainActivity.getContext().removeDialog(0);
        }
    }

    /* renamed from: com.e4a.runtime.android.mainActivity$6 */
    class C06806 implements OnCancelListener {
        C06806() {
        }

        public void onCancel(DialogInterface param) {
            mainActivity.getContext().removeDialog(1);
        }
    }

    /* renamed from: com.e4a.runtime.android.mainActivity$7 */
    class C06817 implements OnDismissListener {
        C06817() {
        }

        public void onDismiss(DialogInterface param) {
            mainActivity.getContext().removeDialog(1);
        }
    }

    public interface OnActivityResultListener {
        void onActivityResult(int i, int i2, Intent intent);
    }

    public interface OnSaveInstanceStateListener {
        void onSaveInstanceState(Bundle bundle);
    }

    public native void onCreate(Bundle bundle);

    static {
        StubApp.interface11(2);
    }

    public static mainActivity getContext() {
        return INSTANCE;
    }

    public static C0645Impl getActiveForm() {
        return activeForm;
    }

    public mainActivity() {
        INSTANCE = this;
        this.onNewIntentListeners = new ArrayList();
        this.onSaveInstanceStateListeners = new ArrayList();
        this.onResumeListeners = new ArrayList();
        this.onPauseListeners = new ArrayList();
        this.onDestroyListeners = new ArrayList();
        this.onActivityResultListeners = new ArrayList();
        this.formmap = new HashMap();
        this.clientmap = new HashMap();
        this.modelmap = new HashMap();
        this.objmap = new HashMap();
    }

    public boolean onKeyDown(int keycode, KeyEvent event) {
        BooleanReferenceParameter shield = new BooleanReferenceParameter(false);
        if (activeForm != null) {
            activeForm.mo834(keycode, shield);
        }
        return shield.get();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.clear();
            if (Integer.parseInt(VERSION.SDK) >= 14) {
                setIconEnable(menu, true);
            }
            if (this.f4282 != null) {
                this.f4282.mo1269(menu);
                this.f4282.mo1293();
                return true;
            }
            List<Map<String, String>> menuItems = new ArrayList();
            if (activeForm != null) {
                menuItems = activeForm.m5159();
                if (!menuItems.isEmpty()) {
                    for (int i = 0; i < menuItems.size(); i++) {
                        MenuItem Item = menu.add((String) ((Map) menuItems.get(i)).get("caption"));
                        int icon = Integer.parseInt((String) ((Map) menuItems.get(i)).get("icon"));
                        if (icon != -1) {
                            Item.setIcon(icon);
                        }
                    }
                }
            }
            return super.onPrepareOptionsMenu(menu);
        } catch (Exception e) {
        }
    }

    public boolean onMenuOpened(int featureld, Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            if (this.f4282 != null) {
                if (item.getItemId() == 16908332) {
                    this.f4282.mo1277();
                } else {
                    this.f4282.mo1294(item.getItemId());
                }
            } else if (activeForm != null) {
                activeForm.mo849(item.getTitle().toString());
            }
        } catch (Exception e) {
        }
        return true;
    }

    private void setIconEnable(Menu menu, boolean enable) {
        try {
            Method m = Class.forName("com.android.internal.view.menu.MenuBuilder").getDeclaredMethod("setOptionalIconsVisible", new Class[]{Boolean.TYPE});
            m.setAccessible(true);
            m.invoke(menu, new Object[]{Boolean.valueOf(enable)});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getOverflowMenu() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        List<String> menuItems = new ArrayList();
        if (activeForm != null) {
            menuItems = activeForm.m5158();
            if (!menuItems.isEmpty()) {
                for (int i = 0; i < menuItems.size(); i++) {
                    menu.add(0, i, 0, (String) menuItems.get(i));
                }
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (activeForm != null) {
            activeForm.mo829(item.getTitle().toString());
        }
        return super.onContextItemSelected(item);
    }

    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.gestureDetector != null) {
            return this.gestureDetector.onTouchEvent(event);
        }
        return false;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == 1) {
            activeForm.mo828(0);
        } else if (newConfig.orientation == 2) {
            activeForm.mo828(1);
        }
        Log.Info("ActivityManager", "屏幕方向被改变");
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        for (OnNewIntentListener onNewIntentListener : this.onNewIntentListeners) {
            onNewIntentListener.onNewIntent(intent);
        }
        Log.Info("ActivityManager", "程序被启动");
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        for (OnSaveInstanceStateListener onSaveInstanceStateListener : this.onSaveInstanceStateListeners) {
            onSaveInstanceStateListener.onSaveInstanceState(outState);
        }
        Log.Info("ActivityManager", "保存启动设置");
    }

    protected void onResume() {
        super.onResume();
        for (OnResumeListener onResumeListener : this.onResumeListeners) {
            onResumeListener.onResume();
        }
        Log.Info("ActivityManager", "程序被重启");
    }

    protected void onPause() {
        super.onPause();
        for (OnPauseListener onPauseListener : this.onPauseListeners) {
            onPauseListener.onPause();
        }
        Log.Info("ActivityManager", "程序被暂停");
    }

    protected void onDestroy() {
        super.onDestroy();
        for (OnDestroyListener onDestroyListener : this.onDestroyListeners) {
            onDestroyListener.onDestroy();
        }
        Log.Info("ActivityManager", "程序被销毁");
        Process.killProcess(Process.myPid());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (OnActivityResultListener onActivityResultListener : this.onActivityResultListeners) {
            onActivityResultListener.onActivityResult(requestCode, resultCode, data);
        }
        Log.Info("ActivityManager", "收到返回结果");
    }

    public void setContent(View view) {
        if (this.contentView != null) {
            this.rootView.removeView(this.contentView);
        }
        this.contentView = view;
        this.rootView.addView(view, new LayoutParams(-1, -1));
    }

    public void removeContent(View view) {
        this.rootView.removeView(view);
    }

    public boolean isActiveForm(C0645Impl form) {
        return form == activeForm;
    }

    public void addOnNewIntentListener(OnNewIntentListener listener) {
        this.onNewIntentListeners.add(listener);
    }

    public void removeOnNewIntentListener(OnNewIntentListener listener) {
        this.onNewIntentListeners.remove(listener);
    }

    public void addOnSaveInstanceStateListener(OnSaveInstanceStateListener listener) {
        this.onSaveInstanceStateListeners.add(listener);
    }

    public void removeOnSaveInstanceStateListener(OnSaveInstanceStateListener listener) {
        this.onSaveInstanceStateListeners.remove(listener);
    }

    public void addOnResumeListener(OnResumeListener listener) {
        this.onResumeListeners.add(listener);
    }

    public void removeOnResumeListener(OnResumeListener listener) {
        this.onResumeListeners.remove(listener);
    }

    public void addOnPauseListener(OnPauseListener listener) {
        this.onPauseListeners.add(listener);
    }

    public void removeOnPauseListener(OnPauseListener listener) {
        this.onPauseListeners.remove(listener);
    }

    public void addOnDestroyListener(OnDestroyListener listener) {
        this.onDestroyListeners.add(listener);
    }

    public void removeOnDestroyListener(OnDestroyListener listener) {
        this.onDestroyListeners.remove(listener);
    }

    public void addOnActivityResultListener(OnActivityResultListener listener) {
        this.onActivityResultListeners.add(listener);
    }

    public void removeOnActivityResultListener(OnActivityResultListener listener) {
        this.onActivityResultListeners.remove(listener);
    }

    protected Dialog onCreateDialog(int id) {
        Calendar calendar = Calendar.getInstance();
        Dialog dialog = null;
        final int version = VERSION.SDK_INT;
        switch (id) {
            case 0:
                OnDateSetListener dateListener = new OnDateSetListener() {
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        if (version != 16) {
                            mainActivity.activeForm.mo835(year + "/" + (month + 1) + "/" + dayOfMonth);
                            mainActivity.getContext().removeDialog(0);
                        } else if (mainActivity.f4277) {
                            mainActivity.f4277 = false;
                        } else {
                            mainActivity.f4277 = true;
                            mainActivity.activeForm.mo835(year + "/" + (month + 1) + "/" + dayOfMonth);
                            mainActivity.getContext().removeDialog(0);
                        }
                    }
                };
                if (f4273 <= -1 || f4276 <= -1 || f4274 <= -1) {
                    dialog = new DatePickerDialog(this, dateListener, calendar.get(1), calendar.get(2), calendar.get(5));
                } else {
                    dialog = new DatePickerDialog(this, dateListener, f4273, f4276, f4274);
                }
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setOnCancelListener(new C06773());
                dialog.setOnDismissListener(new C06784());
                break;
            case 1:
                OnTimeSetListener timeListener = new OnTimeSetListener() {
                    public void onTimeSet(TimePicker timerPicker, int hourOfDay, int minute) {
                        if (version != 16) {
                            mainActivity.activeForm.mo836(hourOfDay + ":" + minute);
                            mainActivity.getContext().removeDialog(1);
                        } else if (mainActivity.f4278) {
                            mainActivity.f4278 = false;
                        } else {
                            mainActivity.f4278 = true;
                            mainActivity.activeForm.mo836(hourOfDay + ":" + minute);
                            mainActivity.getContext().removeDialog(1);
                        }
                    }
                };
                Dialog timePickerDialog;
                if (f4275 <= -1 || f4272 <= -1) {
                    timePickerDialog = new TimePickerDialog(this, timeListener, calendar.get(11), calendar.get(12), true);
                } else {
                    timePickerDialog = new TimePickerDialog(this, timeListener, f4275, f4272, true);
                }
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setOnCancelListener(new C06806());
                dialog.setOnDismissListener(new C06817());
                break;
        }
        return dialog;
    }

    /* renamed from: 读取窗口 */
    public C0645Impl mo879(String formname) {
        if (this.formmap.containsKey(formname)) {
            return (C0645Impl) this.formmap.get(formname);
        }
        return null;
    }

    /* renamed from: 保存窗口 */
    public void mo860(String formname, C0645Impl formImpl) {
        this.formmap.put(formname, formImpl);
    }

    /* renamed from: 销毁窗口 */
    public void mo883(String formname) {
        if (this.formmap.containsKey(formname)) {
            C0645Impl formImpl = (C0645Impl) this.formmap.get(formname);
            this.formmap.remove(formname);
        }
    }

    /* renamed from: 切换窗口 */
    public void mo861(C0644 form) {
        try {
            C0645Impl formImpl = (C0645Impl) form;
            setContent(formImpl.getView());
            form.mo840(form.mo839());
            activeForm = formImpl;
            View v = getCurrentFocus();
            if (v != null) {
                v.clearFocus();
            }
            activeForm.mo825();
            if (this.f4282 != null) {
                this.f4282.mo1293();
                getWindow().invalidatePanelMenu(0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: 读取客户 */
    public C0738Impl mo876(String clientname) {
        if (this.clientmap.containsKey(clientname)) {
            return (C0738Impl) this.clientmap.get(clientname);
        }
        return null;
    }

    /* renamed from: 保存客户 */
    public void mo857(String clientname, C0738Impl clientImpl) {
        this.clientmap.put(clientname, clientImpl);
    }

    /* renamed from: 读取模块 */
    public Object mo878(String modelname) {
        if (this.modelmap.containsKey(modelname)) {
            return this.modelmap.get(modelname);
        }
        return null;
    }

    /* renamed from: 保存模块 */
    public void mo859(String modelname, Object model) {
        this.modelmap.put(modelname, model);
    }

    /* renamed from: 保存对象 */
    public void mo858(String objname, Object obj) {
        this.objmap.put(objname, obj);
    }

    /* renamed from: 读取对象 */
    public Object mo877(String objname) {
        if (this.objmap.containsKey(objname)) {
            return this.objmap.get(objname);
        }
        return null;
    }

    /* renamed from: 弹出提示 */
    public void mo862(String msg) {
        Toast.makeText(getApplicationContext(), msg, 0).show();
    }

    /* renamed from: 结束程序 */
    public void mo870() {
        finish();
    }

    /* renamed from: 强制结束程序 */
    public void mo864() {
        Process.killProcess(Process.myPid());
    }

    /* renamed from: 窗口置后台 */
    public void mo868() {
        moveTaskToBack(true);
    }

    /* renamed from: 返回应用 */
    public void mo881() {
        Intent intent = new Intent(getApplicationContext(), mainActivity.class);
        intent.setFlags(335544320);
        getApplicationContext().startActivity(intent);
    }

    /* renamed from: 返回桌面 */
    public void mo882() {
        Intent i = new Intent("android.intent.action.MAIN");
        i.setFlags(268435456);
        i.addCategory("android.intent.category.HOME");
        startActivity(i);
    }

    /* renamed from: 弹出提示2 */
    public void mo8632(String imagePath, String text, int style, int loaction) {
        Context context = getContext();
        Toast toast = Toast.makeText(context, text, 1);
        if (loaction == 1) {
            toast.setGravity(17, 0, 0);
        } else {
            toast.setGravity(80, 0, 0);
        }
        ImageView img = new ImageView(context);
        m5416(img, imagePath);
        LinearLayout layout = (LinearLayout) toast.getView();
        switch (style) {
            case 1:
                layout.setOrientation(0);
                layout.setGravity(19);
                layout.addView(img, 0);
                break;
            case 2:
                layout.setOrientation(1);
                layout.setGravity(19);
                layout.addView(img, 0);
                break;
            case 3:
                layout.setOrientation(0);
                layout.setGravity(19);
                layout.addView(img);
                break;
            case 4:
                layout.setOrientation(1);
                layout.setGravity(19);
                layout.addView(img);
                break;
        }
        toast.show();
    }

    /* renamed from: 设置图像 */
    private void m5416(ImageView view, String imagePath) {
        if (imagePath.length() <= 0) {
            view.setImageDrawable(null);
            view.setAdjustViewBounds(true);
        } else if (!imagePath.startsWith("/")) {
            try {
                view.setImageDrawable(Drawable.createFromStream(getContext().getResources().getAssets().open(imagePath), imagePath));
                view.setAdjustViewBounds(true);
            } catch (IOException e) {
            }
        } else if (new File(imagePath).exists()) {
            view.setImageBitmap(BitmapFactory.decodeFile(imagePath));
            view.setAdjustViewBounds(true);
        }
    }

    /* renamed from: 是否在前台 */
    public boolean mo865() {
        if (getTopActivityName(this).equals("com.e4a.runtime.android.mainActivity")) {
            return true;
        }
        return false;
    }

    private String getTopActivityName(Context context) {
        List<RunningTaskInfo> runningTaskInfos = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTaskInfos != null) {
            return ((RunningTaskInfo) runningTaskInfos.get(0)).topActivity.getClassName();
        }
        return null;
    }

    /* renamed from: 注册弹出菜单 */
    public void mo867(View v) {
        registerForContextMenu(v);
    }

    /* renamed from: 获取全局应用 */
    public Application mo872() {
        return getApplication();
    }

    /* renamed from: 获取全局应用上下文 */
    public Context mo873() {
        return getApplicationContext();
    }

    /* renamed from: 获取上下文 */
    public Context mo871() {
        return getContext();
    }

    /* renamed from: 获取启动参数 */
    public Intent mo874() {
        return getIntent();
    }

    /* renamed from: 获取启动设置 */
    public Bundle mo875() {
        return this.f4280;
    }

    /* renamed from: 转换字体大小 */
    public float mo880(float 字体大小) {
        return (f4279 / 9.0f) * 字体大小;
    }

    /* renamed from: 是否自适应 */
    public boolean mo866() {
        return this.f4281;
    }

    /* renamed from: 绑定活动栏 */
    public void mo869(C0771 actionbar) {
        if (VERSION.SDK_INT >= 11) {
            getOverflowMenu();
            this.f4282 = (C0774Impl) actionbar;
        }
    }
}
