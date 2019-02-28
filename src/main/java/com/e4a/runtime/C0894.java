package com.e4a.runtime;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.View;
import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.系统相关类 */
public final class C0894 {
    /* renamed from: 屏幕宽度 */
    private static int f4336 = 0;
    /* renamed from: 屏幕密度 */
    private static int f4337 = 0;
    /* renamed from: 屏幕高度 */
    private static int f4338 = 0;
    /* renamed from: 状态栏高度 */
    private static int f4339 = 0;

    private C0894() {
    }

    @SimpleFunction
    /* renamed from: 取绝对像素 */
    public static int m6887(int dp) {
        return (int) ((((float) dp) * mainActivity.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @SimpleFunction
    /* renamed from: 取绝度像素 */
    public static int m6888(int dp) {
        return (int) ((((float) dp) * mainActivity.getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @SimpleFunction
    /* renamed from: 取屏幕宽度 */
    public static int m6882() {
        if (f4336 != 0) {
            return f4336;
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        mainActivity.getContext().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    @SimpleFunction
    /* renamed from: 取屏幕高度 */
    public static int m6884() {
        if (f4338 != 0) {
            return f4338;
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        mainActivity.getContext().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    @SimpleFunction
    /* renamed from: 取屏幕密度 */
    public static double m6883() {
        if (f4337 != 0) {
            return (double) f4337;
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        mainActivity.getContext().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return (double) displaymetrics.density;
    }

    @SimpleFunction
    /* renamed from: 取状态栏高度 */
    public static int m6885() {
        if (f4339 != 0) {
            return f4339;
        }
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            return C0841.m6594().getResources().getDimensionPixelSize(Integer.parseInt(c.getField("status_bar_height").get(c.newInstance()).toString()));
        } catch (Exception e1) {
            e1.printStackTrace();
            return 0;
        }
    }

    @SimpleFunction
    /* renamed from: 创建快捷方式 */
    public static void m6877(String appname, int iconId) {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcut.putExtra("android.intent.extra.shortcut.NAME", appname);
        shortcut.putExtra("duplicate", false);
        Intent shortcutIntent = new Intent("android.intent.action.MAIN");
        shortcutIntent.setClassName(mainActivity.getContext(), mainActivity.getContext().getClass().getName());
        shortcut.putExtra("android.intent.extra.shortcut.INTENT", shortcutIntent);
        shortcut.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(mainActivity.getContext(), iconId));
        mainActivity.getContext().sendBroadcast(shortcut);
    }

    @SimpleFunction
    /* renamed from: 创建快捷方式2 */
    public static void m68782(String name, int iconId, String url) {
        Intent intentAddShortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intentAddShortcut.putExtra("android.intent.extra.shortcut.NAME", name);
        intentAddShortcut.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(mainActivity.getContext(), iconId));
        Intent intentLauncher = new Intent();
        intentLauncher.setData(Uri.parse(url));
        intentAddShortcut.putExtra("android.intent.extra.shortcut.INTENT", intentLauncher);
        mainActivity.getContext().sendBroadcast(intentAddShortcut);
    }

    @SimpleFunction
    /* renamed from: 是否已创建快捷方式 */
    public static boolean m6897(String appname) {
        ContentResolver cr = C0841.m6594().getContentResolver();
        String AUTHORITY = "com.android.launcher.settings";
        Cursor c = cr.query(Uri.parse("content://com.android.launcher.settings/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{appname}, null);
        if (c != null && c.getCount() > 0) {
            return true;
        }
        String AUTHORITY2 = "com.android.launcher2.settings";
        ContentResolver contentResolver = cr;
        Cursor c2 = contentResolver.query(Uri.parse("content://com.android.launcher2.settings/favorites?notify=true"), new String[]{"title", "iconResource"}, "title=?", new String[]{appname}, null);
        if (c2 == null || c2.getCount() <= 0) {
            return false;
        }
        return true;
    }

    @SimpleFunction
    /* renamed from: 取进程列表 */
    public static String m6891() {
        String result = bi_常量类.f6358b;
        ActivityManager mActivityManager = (ActivityManager) C0841.m6594().getSystemService("activity");
        for (RunningServiceInfo rsi : mActivityManager.getRunningServices(Integer.MAX_VALUE)) {
            String pkgName = rsi.service.getPackageName();
            int pid = rsi.pid;
            String processName = rsi.process;
            int memSize = mActivityManager.getProcessMemoryInfo(new int[]{pid})[0].dalvikPrivateDirty;
            if (result.equals(bi_常量类.f6358b)) {
                result = Integer.toString(pid) + "-" + processName + "-" + Integer.toString(memSize);
            } else {
                result = result + "\n" + Integer.toString(pid) + "-" + processName + "-" + Integer.toString(memSize);
            }
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 延时 */
    public static void m6896(int time) {
        try {
            Log.Info("ActivityManager", "当前线程名称：" + Thread.currentThread().getName());
            Thread.currentThread();
            Thread.sleep((long) time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SimpleFunction
    /* renamed from: 置剪贴板文本 */
    public static void m6900(String text) {
        ((ClipboardManager) C0841.m6594().getSystemService("clipboard")).setText(text);
    }

    @SimpleFunction
    /* renamed from: 取剪贴板文本 */
    public static String m6881() {
        ClipboardManager clipboard = (ClipboardManager) C0841.m6594().getSystemService("clipboard");
        if (clipboard.hasText()) {
            return clipboard.getText().toString();
        }
        return bi_常量类.f6358b;
    }

    @SimpleFunction
    /* renamed from: 隐藏状态栏 */
    public static void m6902() {
        mainActivity.getContext().getWindow().clearFlags(2048);
        mainActivity.getContext().getWindow().setFlags(1024, 1024);
    }

    @SimpleFunction
    /* renamed from: 显示状态栏 */
    public static void m6898() {
        mainActivity.getContext().getWindow().clearFlags(1024);
        mainActivity.getContext().getWindow().setFlags(2048, 2048);
    }

    @SimpleFunction
    /* renamed from: 置屏幕方向 */
    public static void m6901(int t) {
        mainActivity.getContext().setRequestedOrientation(t);
    }

    @SimpleFunction
    /* renamed from: 优化内存 */
    public static void m6875() {
        System.gc();
    }

    @SimpleFunction
    /* renamed from: 屏幕截图 */
    public static void m6894(String path) {
        C0894.savePic(C0894.takeScreenShot(mainActivity.getContext()), path);
    }

    @SimpleFunction
    /* renamed from: 屏幕截图2 */
    public static void m68952(String path, int a, int c, int i, int d) {
        C0894.savePic(C0894.takeScreenShot2(mainActivity.getContext(), a, c, i, d), path);
    }

    private static Bitmap takeScreenShot(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, activity.getWindowManager().getDefaultDisplay().getWidth(), activity.getWindowManager().getDefaultDisplay().getHeight() - statusBarHeight);
        view.destroyDrawingCache();
        return b;
    }

    private static Bitmap takeScreenShot2(Activity activity, int a, int c, int i, int d) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap b1 = view.getDrawingCache();
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();
        Bitmap b = Bitmap.createBitmap(b1, a, c, i, d);
        view.destroyDrawingCache();
        return b;
    }

    private static void savePic(Bitmap b, String strFileName) {
        FileNotFoundException e;
        IOException e2;
        try {
            FileOutputStream fileOutputStream;
            FileOutputStream fos = new FileOutputStream(strFileName);
            if (fos != null) {
                try {
                    b.compress(CompressFormat.PNG, 90, fos);
                    fos.flush();
                    fos.close();
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = fos;
                    e.printStackTrace();
                } catch (IOException e4) {
                    e2 = e4;
                    fileOutputStream = fos;
                    e2.printStackTrace();
                }
            }
            fileOutputStream = fos;
        } catch (FileNotFoundException e5) {
            e = e5;
            e.printStackTrace();
        } catch (IOException e6) {
            e2 = e6;
            e2.printStackTrace();
        }
    }

    @SimpleFunction
    /* renamed from: 取系统版本号 */
    public static int m6886() {
        return VERSION.SDK_INT;
    }

    @SimpleFunction
    /* renamed from: 取资源索引 */
    public static int m6890(String 资源名称, String 资源类型) {
        return C0841.m6594().getResources().getIdentifier(资源名称, 资源类型, C0841.m6594().getPackageName());
    }

    @SimpleFunction
    /* renamed from: 生成GUID */
    public static String m6899GUID() {
        return UUID.randomUUID().toString();
    }

    @SimpleFunction
    /* renamed from: 发送广播 */
    public static void m6879(String name, int ID, String content) {
        Intent BroadcastIntent = new Intent();
        BroadcastIntent.setAction(name);
        BroadcastIntent.putExtra("ID", ID);
        BroadcastIntent.putExtra("content", content);
        C0841.m6594().sendBroadcast(BroadcastIntent);
    }

    @SimpleFunction
    /* renamed from: 发送广播2 */
    public static void m68802(String name, int ID, byte[] content) {
        Intent BroadcastIntent = new Intent();
        BroadcastIntent.setAction(name);
        BroadcastIntent.putExtra("ID", ID);
        BroadcastIntent.putExtra("content", content);
        C0841.m6594().sendBroadcast(BroadcastIntent);
    }

    /* renamed from: 取自身包名 */
    private static String m6889() {
        return C0841.m6594().getPackageName();
    }

    @SimpleFunction
    /* renamed from: 启动服务 */
    public static void m6892(String param) {
        Intent ServiceIntent = new Intent(C0894.m6889() + ".后台服务操作");
        ServiceIntent.putExtra("参数", param);
        ServiceIntent.putExtra("前台运行", "0");
        C0841.m6594().startService(ServiceIntent);
    }

    @SimpleFunction
    /* renamed from: 启动服务2 */
    public static void m68932(String 参数, int 通知ID, String 通知名称, String 通知标题, String 通知信息, int 图标资源, boolean 播放声音, boolean 不可清除) {
        Intent ServiceIntent = new Intent(C0894.m6889() + ".后台服务操作");
        ServiceIntent.putExtra("参数", 参数);
        ServiceIntent.putExtra("前台运行", C0108a.f262e);
        ServiceIntent.putExtra("状态栏通知", new SerializableInfo(通知ID, 通知名称, 通知标题, 通知信息, 图标资源, 播放声音, 不可清除));
        C0841.m6594().startService(ServiceIntent);
    }

    @SimpleFunction
    /* renamed from: 停止服务 */
    public static void m6876() {
        C0841.m6594().stopService(new Intent(C0894.m6889() + ".后台服务操作"));
    }
}
