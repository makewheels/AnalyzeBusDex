package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.smtt.sdk.WebView;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.utils.d */
public class C1138d {
    /* renamed from: b */
    private static DexClassLoader f5124b = null;
    /* renamed from: c */
    private static C1138d f5125c = null;
    /* renamed from: a */
    public String f5126a = bi_常量类.f6358b;

    /* renamed from: com.tencent.smtt.utils.d$a */
    public interface C1137a {
        /* renamed from: a */
        void mo1906a();

        /* renamed from: a */
        void mo1907a(int i);

        /* renamed from: a */
        void mo1908a(Throwable th);
    }

    private C1138d(Context context) {
        this.f5126a = context.getDir("debugtbs", 0).getAbsolutePath() + File.separator + "plugin";
    }

    /* renamed from: a */
    public static C1138d m7960a(Context context) {
        if (f5125c == null) {
            f5125c = new C1138d(context);
        }
        return f5125c;
    }

    /* renamed from: a */
    private static String m7961a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String a = C1138d.m7962a(C1138d.m7964a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                String name = jarEntry.getName();
                if (name != null) {
                    Certificate[] a2 = C1138d.m7964a(jarFile, jarEntry, bArr);
                    String a3 = a2 != null ? C1138d.m7962a(a2[0].getEncoded()) : null;
                    if (a3 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!a3.equals(a)) {
                        return null;
                    }
                }
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m7962a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            cArr[i * 2] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            i2 = b & 15;
            cArr[(i * 2) + 1] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
        }
        return new String(cArr);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m7963a(String str, C1137a c1137a) {
        new C1143i(str, c1137a).start();
    }

    /* renamed from: a */
    private static Certificate[] m7964a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        return jarEntry != null ? jarEntry.getCertificates() : null;
    }

    /* renamed from: a */
    public void m7965a(String str, WebView webView, Context context) {
        View relativeLayout = new RelativeLayout(context);
        View textView = new TextView(context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setText("加载中，请稍后...");
        relativeLayout.addView(textView, layoutParams);
        webView.addView(relativeLayout, new FrameLayout.LayoutParams(-1, -1));
        String str2 = this.f5126a + File.separator + "DebugPlugin.tbs";
        C1146j.m7988b(new File(str2));
        C1138d.m7963a(str2, new C1139e(this, webView, context, relativeLayout, str, textView));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void m7966b(String str, WebView webView, Context context) {
        TbsLog.m7927i("debugtbs", "showPluginView -- url: " + str + "; webview: " + webView + "; context: " + context);
        String str2 = this.f5126a + File.separator + "DebugPlugin.tbs";
        String str3 = this.f5126a + File.separator + "DebugPlugin.apk";
        File file = new File(str2);
        File file2 = new File(str3);
        if (file.exists()) {
            file2.delete();
            file.renameTo(file2);
        }
        if (file2.exists()) {
            try {
                str2 = bi_常量类.f6358b;
                str2 = C1138d.m7961a(new File(str3));
                if ("308203773082025fa003020102020448bb959d300d06092a864886f70d01010b0500306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e673020170d3136303532313039353730335a180f32303731303232323039353730335a306b310b300906035504061302636e31123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e3110300e060355040a130754656e63656e74310c300a060355040b13034d4947311530130603550403130c4d696e676875204875616e6730820122300d06092a864886f70d01010105000382010f003082010a02820101008c58deabefe95f699c6322f9a75620873b490d26520c7267eb8382a91da625a5876b2bd617116eb40b371c4f88c988c1ba73052caaa9964873c94b7755c3429fca47a6677229fb2e72908d3b17df82f1ebe70447b94c1e5b0a763dad8948312180322657325306f01e423e0409ef3a59e5c0e0b9c765a2322699a2dec2d4dbe58ec15f41752516192169d9596169f5bf08eaf8aab9893240ad679e82fc92b97d2ae98b28021dc5a752f0a69437ea603c541e6753cea52dbc8e8043fe21fd5da46066c92e0714905dfad3116f35aca52b13871c57481459aa4ca255a6482ba972bd17af90d0d2c21a57ef65376bbd4ce7078e6047060640669f3867fdc69fbb750203010001a321301f301d0603551d0e0416041450fb9b6362e829797b1b29ca55e6d5e082e93ff3300d06092a864886f70d01010b050003820101004952ffbfba7c00ee9b84f44b05ec62bc2400dc769fb2e83f80395e3fbb54e44d56e16527413d144f42bf8f21fa443bc42a7a732de9d5124df906c6d728e75ca94eefc918080876bd3ce6cb5f7f2d9cc8d8e708033afc1295c7f347fb2d2098be2e4a79220e9552171d5b5f8f59cff4c6478cc41dce24cbe942305757488d37659d3265838ee54ebe44fccbd1bec93d809f950034f5ef292f20179554d22f5856c03b4d44997fcb9b3579e16a49218fce0e2e6bfe1fd4aa0ab39f548344c244c171c203baff1a730883aaf4506b6865a45c3c9aba40c6326d4152b6ce09cc058864bec1d6422e83dad9496b83fb252b4bfb30d3a6badf996099793e11f9af618d".equals(str2)) {
                    str2 = this.f5126a + File.separator + "opt";
                    file = new File(str2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (f5124b == null) {
                        f5124b = new DexClassLoader(str3, str2, null, context.getClassLoader());
                    }
                    Map hashMap = new HashMap();
                    hashMap.put("url", str);
                    hashMap.put("tbs_version", bi_常量类.f6358b + WebView.getTbsSDKVersion(context));
                    hashMap.put("tbs_core_version", bi_常量类.f6358b + WebView.getTbsCoreVersion(context));
                    Object newInstance = f5124b.loadClass("com.tencent.tbs.debug.plugin.DebugView").getConstructor(new Class[]{Context.class, Map.class}).newInstance(new Object[]{context, hashMap});
                    if (newInstance instanceof FrameLayout) {
                        FrameLayout frameLayout = (FrameLayout) newInstance;
                        webView.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                        TbsLog.m7927i("debugtbs", "show " + frameLayout + " successful in " + webView);
                        return;
                    }
                    TbsLog.m7925e("debugtbs", "get debugview failure: " + newInstance);
                    return;
                }
                TbsLog.m7925e("debugtbs", "verifyPlugin apk: " + str3 + " signature failed - sig: " + str2);
                Toast.makeText(context, "插件校验失败,请检查后重试!", 0).show();
                return;
            } catch (Exception e) {
                C1146j.m7988b(file2);
                e.printStackTrace();
                return;
            }
        }
        TbsLog.m7927i("debugtbs", "showPluginView - going to download plugin...");
        m7965a(str, webView, context);
    }
}
