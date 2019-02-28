package com.e4a.runtime;

import android.content.SharedPreferences.Editor;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import com.e4a.runtime.variants.StringVariant;
import com.e4a.runtime.variants.Variant;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.读写设置类 */
public final class C0898_读写设置类 {
    private static Properties properties;

    private C0898_读写设置类() {
    }

    @SimpleFunction
    /* renamed from: 读取设置 */
    public static Variant m6937_通过SP读取设置(String name) {
        try {
            String value = mainActivity.getContext().getPreferences(0).getString(name, bi_常量类.f6358b);
            if (value == null || value.equals(bi_常量类.f6358b)) {
                return StringVariant.getStringVariant(bi_常量类.f6358b);
            }
            return StringVariant.getStringVariant(value);
        } catch (Exception e) {
            return StringVariant.getStringVariant(bi_常量类.f6358b);
        }
    }

    @SimpleFunction
    /* renamed from: 保存设置 */
    public static void m6935_通过SP保存设置(String name, Variant value) {
        Editor editor = mainActivity.getContext().getPreferences(0).edit();
        editor.putString(name, value.getString());
        editor.commit();
    }

    @SimpleFunction
    /* renamed from: 读取设置文件 */
    public static String m6938(String file, String name) {
        if (properties == null) {
            properties = new Properties();
        }
        try {
            properties.load(new FileInputStream(file));
            String value = properties.getProperty(name, bi_常量类.f6358b);
            return value != null ? value : bi_常量类.f6358b;
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b;
        }
    }

    @SimpleFunction
    /* renamed from: 保存设置文件 */
    public static boolean m6936(String file, String name, String value) {
        boolean result = true;
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream(file));
            } catch (Exception e) {
                e.printStackTrace();
                result = false;
            }
        }
        properties.setProperty(name, value);
        try {
            properties.store(new FileOutputStream(file, false), bi_常量类.f6358b);
            return result;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
