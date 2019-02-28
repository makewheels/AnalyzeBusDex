package p054u.aly;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: Helper */
/* renamed from: u.aly.bv */
public class bv {
    /* renamed from: a */
    public static final String f6383a = System.getProperty("line.separator");
    /* renamed from: b */
    private static final String f6384b = "helper";

    /* renamed from: a */
    public static String m10055a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bytes);
            bytes = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(bytes[i])}));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", bi_常量类.f6358b_空串);
        }
    }

    /* renamed from: b */
    public static String m10061b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & WebView.NORMAL_MODE_ALPHA));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            bj.m10001a(f6384b, "getMD5 error", e);
            return bi_常量类.f6358b_空串;
        }
    }

    /* renamed from: a */
    public static String m10053a(File file) {
        byte[] bArr = new byte[1024];
        try {
            if (!file.isFile()) {
                return bi_常量类.f6358b_空串;
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    fileInputStream.close();
                    BigInteger bigInteger = new BigInteger(1, instance.digest());
                    return String.format("%1$032x", new Object[]{bigInteger});
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m10052a(Context context, long j) {
        String str = bi_常量类.f6358b_空串;
        if (j < 1000) {
            return ((int) j) + "B";
        }
        if (j < 1000000) {
            return new StringBuilder(String.valueOf(Math.round(((double) ((float) j)) / 1000.0d))).append("K").toString();
        }
        if (j < 1000000000) {
            return new StringBuilder(String.valueOf(new DecimalFormat("#0.0").format(((double) ((float) j)) / 1000000.0d))).append("M").toString();
        }
        return new StringBuilder(String.valueOf(new DecimalFormat("#0.00").format(((double) ((float) j)) / 1.0E9d))).append("G").toString();
    }

    /* renamed from: c */
    public static String m10064c(String str) {
        String str2 = bi_常量类.f6358b_空串;
        try {
            long longValue = Long.valueOf(str).longValue();
            if (longValue < 1024) {
                return ((int) longValue) + "B";
            }
            if (longValue < 1048576) {
                return new StringBuilder(String.valueOf(new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1024.0d))).append("K").toString();
            }
            if (longValue < 1073741824) {
                return new StringBuilder(String.valueOf(new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1048576.0d))).append("M").toString();
            }
            return new StringBuilder(String.valueOf(new DecimalFormat("#0.00").format(((double) ((float) longValue)) / 1.073741824E9d))).append("G").toString();
        } catch (NumberFormatException e) {
            return str;
        }
    }

    /* renamed from: a */
    public static void m10057a(Context context, String str) {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
    }

    /* renamed from: b */
    public static boolean m10062b(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m10066d(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: e */
    public static boolean m10067e(String str) {
        if (bv.m10066d(str)) {
            return false;
        }
        String toLowerCase = str.trim().toLowerCase(Locale.US);
        if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static String m10051a() {
        return bv.m10056a(new Date());
    }

    /* renamed from: a */
    public static String m10056a(Date date) {
        if (date == null) {
            return bi_常量类.f6358b_空串;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
    }

    /* renamed from: a */
    public static String m10054a(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[1024];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    /* renamed from: b */
    public static byte[] m10063b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public static void m10059a(File file, byte[] bArr) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } finally {
            bv.m10060a(fileOutputStream);
        }
    }

    /* renamed from: a */
    public static void m10058a(File file, String str) throws IOException {
        bv.m10059a(file, str.getBytes());
    }

    /* renamed from: c */
    public static void m10065c(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public static void m10060a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }
}
