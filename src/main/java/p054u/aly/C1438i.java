package p054u.aly;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: UTDIdTracker */
/* renamed from: u.aly.i */
public class C1438i extends C1274a {
    /* renamed from: a */
    private static final String f6553a = "utdid";
    /* renamed from: b */
    private static final String f6554b = "android.permission.WRITE_EXTERNAL_STORAGE";
    /* renamed from: c */
    private static final Pattern f6555c = Pattern.compile("UTDID\">([^<]+)");
    /* renamed from: d */
    private Context f6556d;

    public C1438i(Context context) {
        super("utdid");
        this.f6556d = context;
    }

    /* renamed from: f */
    public String mo1941f() {
        return m10390g();
    }

    /* renamed from: g */
    private String m10390g() {
        InputStream fileInputStream;
        File h = m10391h();
        if (h == null || !h.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(h);
            String b = m10389b(bv.m10054a(fileInputStream));
            bv.m10065c(fileInputStream);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            bv.m10065c(fileInputStream);
        }
    }

    /* renamed from: b */
    private String m10389b(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f6555c.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /* renamed from: h */
    private File m10391h() {
        if (!bi_常量类.m9972a(this.f6556d, f6554b) || !Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
        } catch (Exception e) {
            return null;
        }
    }
}
