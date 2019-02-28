package com.e4a.runtime;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.应用相关类 */
public final class C0881 {
    private C0881() {
    }

    @SimpleFunction
    /* renamed from: 安装应用 */
    public static void m6735(String apkPath) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(apkPath)), "application/vnd.android.package-archive");
        mainActivity.getContext().startActivity(intent);
    }

    @SimpleFunction
    /* renamed from: 卸载应用 */
    public static void m6718(String packageName) {
        mainActivity.getContext().startActivity(new Intent("android.intent.action.DELETE", Uri.parse("package:" + packageName)));
    }

    @SimpleFunction
    /* renamed from: 启动应用 */
    public static void m6734(String packageName) {
        Intent intent = mainActivity.getContext().getPackageManager().getLaunchIntentForPackage(packageName);
        intent.setFlags(335544320);
        mainActivity.getContext().startActivity(intent);
    }

    @SimpleFunction
    /* renamed from: 取apk应用图标 */
    public static byte[] m6721apk(String apkPath) {
        PackageManager pm = mainActivity.getContext().getPackageManager();
        PackageInfo pkgInfo = pm.getPackageArchiveInfo(apkPath, 1);
        if (pkgInfo == null) {
            return new byte[0];
        }
        ApplicationInfo appInfo = pkgInfo.applicationInfo;
        appInfo.sourceDir = apkPath;
        appInfo.publicSourceDir = apkPath;
        return C0881.Bitmap2Bytes(C0881.drawableToBitmap(pm.getApplicationIcon(appInfo)));
    }

    @SimpleFunction
    /* renamed from: 取apk应用名称 */
    public static String m6720apk(String apkPath) {
        PackageManager pm = mainActivity.getContext().getPackageManager();
        PackageInfo pkgInfo = pm.getPackageArchiveInfo(apkPath, 1);
        if (pkgInfo == null) {
            return bi_常量类.f6358b;
        }
        ApplicationInfo appInfo = pkgInfo.applicationInfo;
        appInfo.sourceDir = apkPath;
        appInfo.publicSourceDir = apkPath;
        return pm.getApplicationLabel(appInfo).toString();
    }

    @SimpleFunction
    /* renamed from: 取apk应用包名 */
    public static String m6719apk(String apkPath) {
        PackageInfo pkgInfo = mainActivity.getContext().getPackageManager().getPackageArchiveInfo(apkPath, 1);
        if (pkgInfo == null) {
            return bi_常量类.f6358b;
        }
        ApplicationInfo appInfo = pkgInfo.applicationInfo;
        appInfo.sourceDir = apkPath;
        appInfo.publicSourceDir = apkPath;
        return appInfo.packageName;
    }

    @SimpleFunction
    /* renamed from: 取apk应用版本 */
    public static String m6722apk(String apkPath) {
        PackageInfo pkgInfo = mainActivity.getContext().getPackageManager().getPackageArchiveInfo(apkPath, 1);
        if (pkgInfo == null) {
            return bi_常量类.f6358b;
        }
        ApplicationInfo appInfo = pkgInfo.applicationInfo;
        appInfo.sourceDir = apkPath;
        appInfo.publicSourceDir = apkPath;
        return pkgInfo.versionName;
    }

    @SimpleFunction
    /* renamed from: 取apk应用版本序号 */
    public static int m6723apk(String apkPath) {
        PackageInfo pkgInfo = mainActivity.getContext().getPackageManager().getPackageArchiveInfo(apkPath, 1);
        if (pkgInfo == null) {
            return 0;
        }
        ApplicationInfo appInfo = pkgInfo.applicationInfo;
        appInfo.sourceDir = apkPath;
        appInfo.publicSourceDir = apkPath;
        return pkgInfo.versionCode;
    }

    @SimpleFunction
    /* renamed from: 取应用图标 */
    public static byte[] m6725(String packagename) {
        try {
            PackageManager pm = mainActivity.getContext().getPackageManager();
            return C0881.Bitmap2Bytes(C0881.drawableToBitmap(pm.getApplicationInfo(packagename, 0).loadIcon(pm)));
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] Bitmap2Bytes(Bitmap paramBitmap) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramBitmap.compress(CompressFormat.PNG, 100, localByteArrayOutputStream);
        return localByteArrayOutputStream.toByteArray();
    }

    private static Bitmap drawableToBitmap(Drawable paramDrawable) {
        int i = paramDrawable.getIntrinsicWidth();
        int j = paramDrawable.getIntrinsicHeight();
        Bitmap localBitmap = Bitmap.createBitmap(i, j, paramDrawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, i, j);
        paramDrawable.draw(localCanvas);
        return localBitmap;
    }

    @SimpleFunction
    /* renamed from: 取应用版本 */
    public static String m6728(String packagename) {
        try {
            return mainActivity.getContext().getPackageManager().getPackageInfo(packagename, 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "0";
        }
    }

    @SimpleFunction
    /* renamed from: 取应用版本序号 */
    public static int m6729(String packagename) {
        int i = 0;
        try {
            return mainActivity.getContext().getPackageManager().getPackageInfo(packagename, 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return i;
        }
    }

    @SimpleFunction
    /* renamed from: 取应用名称 */
    public static String m6724(String packagename) {
        try {
            PackageManager pm = mainActivity.getContext().getPackageManager();
            return pm.getApplicationInfo(packagename, 0).loadLabel(pm).toString();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 取应用权限 */
    public static String[] m6727(String packagename) {
        try {
            return mainActivity.getContext().getPackageManager().getPackageInfo(packagename, 4096).requestedPermissions;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    @SimpleFunction
    /* renamed from: 取应用签名 */
    public static String m6730(String packagename) {
        try {
            return mainActivity.getContext().getPackageManager().getPackageInfo(packagename, 64).signatures[0].toCharsString();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 取应用安装路径 */
    public static String m6726(String packagename) {
        try {
            return mainActivity.getContext().getPackageManager().getApplicationInfo(packagename, 0).sourceDir;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 取所有应用包名 */
    public static String[] m6731() {
        List packageInfos = mainActivity.getContext().getPackageManager().getInstalledPackages(0);
        String[] packagenames = new String[packageInfos.size()];
        for (int i = 0; i < packageInfos.size(); i++) {
            packagenames[i] = ((PackageInfo) packageInfos.get(i)).packageName;
        }
        return packagenames;
    }

    @SimpleFunction
    /* renamed from: 取普通应用包名 */
    public static String[] m6732() {
        List packageInfos = mainActivity.getContext().getPackageManager().getInstalledPackages(0);
        List<String> list = new ArrayList();
        for (int i = 0; i < packageInfos.size(); i++) {
            PackageInfo pInfo = (PackageInfo) packageInfos.get(i);
            if ((pInfo.applicationInfo.flags & 1) == 0) {
                list.add(pInfo.packageName);
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    @SimpleFunction
    /* renamed from: 取系统应用包名 */
    public static String[] m6733() {
        List packageInfos = mainActivity.getContext().getPackageManager().getInstalledPackages(0);
        List<String> list = new ArrayList();
        for (int i = 0; i < packageInfos.size(); i++) {
            PackageInfo pInfo = (PackageInfo) packageInfos.get(i);
            if ((pInfo.applicationInfo.flags & 1) != 0) {
                list.add(pInfo.packageName);
            }
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    @SimpleFunction
    /* renamed from: 调用快播 */
    public static void m6736(String path, long time) {
        Intent playIntent = new Intent("QvodPlayer.VIDEO_PLAY_ACTION");
        playIntent.setDataAndType(Uri.parse(path), "video/*");
        playIntent.putExtra("play_position", time);
        mainActivity.getContext().startActivity(playIntent);
    }

    @SimpleFunction
    /* renamed from: 一键分享 */
    public static void m6717(String text, String imagepath) {
        Intent intent = new Intent("android.intent.action.SEND");
        if (bi_常量类.f6358b.equals(imagepath)) {
            intent.setType("text/plain");
        } else {
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(imagepath)));
        }
        intent.putExtra("android.intent.extra.SUBJECT", "分享到");
        intent.putExtra("android.intent.extra.TEXT", text);
        intent.setFlags(268435456);
        mainActivity.getContext().startActivity(Intent.createChooser(intent, "分享到"));
    }
}
