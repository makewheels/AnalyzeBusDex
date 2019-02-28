package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p054u.aly.bi_常量类;

/* renamed from: com.tencent.smtt.utils.j */
public class C1146j {
    /* renamed from: a */
    public static final String f5139a = C1146j.m7997d();
    /* renamed from: b */
    public static final C1144a f5140b = new C1148l();
    /* renamed from: c */
    private static final int f5141c = "lib/".length();

    /* renamed from: com.tencent.smtt.utils.j$a */
    public interface C1144a {
        /* renamed from: a */
        boolean mo1910a(File file, File file2);
    }

    /* renamed from: com.tencent.smtt.utils.j$b */
    public interface C1145b {
        /* renamed from: a */
        boolean mo1909a(InputStream inputStream, ZipEntry zipEntry, String str);
    }

    /* renamed from: a */
    public static long m7972a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return -1;
        }
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: a */
    public static long m7973a(String str) {
        long j = 0;
        try {
            StatFs statFs = new StatFs(str);
            statFs.restat(str);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            return j;
        }
    }

    /* renamed from: a */
    public static ByteArrayOutputStream m7974a(InputStream inputStream) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1146j.m7987b(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    /* renamed from: a */
    public static File m7975a() {
        try {
            return Environment.getExternalStorageDirectory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m7976a(Context context, int i) {
        if (context == null) {
            return bi_常量类.f6358b_空串;
        }
        try {
            String str = Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "tbs";
            switch (i) {
                case 1:
                    return str + File.separator + context.getApplicationInfo().packageName;
                case 2:
                    return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "backup" + File.separator + context.getApplicationInfo().packageName;
                case 3:
                    return str + File.separator + "backup" + File.separator + context.getApplicationInfo().packageName;
                case 4:
                    return str + File.separator + context.getApplicationInfo().packageName;
                default:
                    return bi_常量类.f6358b_空串;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    /* renamed from: a */
    public static void m7977a(File file, boolean z) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    C1146j.m7977a(a, z);
                }
                if (!z) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m7978a(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        C1146j.m7988b(file);
        return file.mkdirs();
    }

    /* renamed from: a */
    public static boolean m7979a(File file, File file2) {
        return C1146j.m7984a(file.getPath(), file2.getPath());
    }

    /* renamed from: a */
    public static boolean m7980a(File file, File file2, FileFilter fileFilter) {
        return C1146j.m7981a(file, file2, fileFilter, f5140b);
    }

    /* renamed from: a */
    public static boolean m7981a(File file, File file2, FileFilter fileFilter, C1144a c1144a) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return C1146j.m7991b(file, file2, fileFilter, c1144a);
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file3 : listFiles) {
            if (!C1146j.m7980a(file3, new File(file2, file3.getName()), fileFilter)) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m7983a(String str, long j, long j2, long j3) {
        Throwable th;
        FileInputStream fileInputStream;
        File file = new File(str);
        if (file.length() != j) {
            TbsLog.m7925e("FileHelper", "file size doesn't match: " + file.length() + " vs " + j);
            return true;
        }
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                CRC32 crc32 = new CRC32();
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                long value = crc32.getValue();
                TbsLog.m7927i("FileHelper", bi_常量类.f6358b_空串 + file.getName() + ": crc = " + value + ", zipCrc = " + j3);
                if (value == j3) {
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return false;
                } else if (fileInputStream2 == null) {
                    return true;
                } else {
                    fileInputStream2.close();
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    public static boolean m7984a(String str, String str2) {
        return C1146j.m7986a(str, str2, Build.CPU_ABI, VERSION.SDK_INT >= 8 ? Build.CPU_ABI2 : null, C1153q.m8019a("ro.product.cpu.upgradeabi", "armeabi"));
    }

    /* renamed from: a */
    private static boolean m7985a(String str, String str2, String str3, String str4, C1145b c1145b) {
        Throwable th;
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(str);
            Object obj = null;
            Object obj2 = null;
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                String name = zipEntry.getName();
                if (name != null && (name.startsWith("lib/") || name.startsWith("assets/"))) {
                    String substring = name.substring(name.lastIndexOf(47));
                    if (substring.endsWith(".so")) {
                        if (name.regionMatches(f5141c, str2, 0, str2.length()) && name.charAt(f5141c + str2.length()) == '/') {
                            obj = 1;
                        } else {
                            if (str3 != null) {
                                if (name.regionMatches(f5141c, str3, 0, str3.length()) && name.charAt(f5141c + str3.length()) == '/') {
                                    obj2 = 1;
                                    if (obj != null) {
                                    }
                                }
                            }
                            if (str4 != null && name.regionMatches(f5141c, str4, 0, str4.length()) && name.charAt(f5141c + str4.length()) == '/' && obj == null) {
                                if (obj2 != null) {
                                }
                            }
                        }
                    }
                    InputStream inputStream = zipFile.getInputStream(zipEntry);
                    try {
                        if (!c1145b.mo1909a(inputStream, zipEntry, substring.substring(1))) {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (zipFile == null) {
                                return false;
                            }
                            zipFile.close();
                            return false;
                        } else if (inputStream != null) {
                            inputStream.close();
                        } else {
                            continue;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                zipFile.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static boolean m7986a(String str, String str2, String str3, String str4, String str5) {
        return C1146j.m7985a(str, str3, str4, str5, new C1147k(str2));
    }

    /* renamed from: b */
    public static int m7987b(InputStream inputStream, OutputStream outputStream) {
        long a = C1146j.m7972a(inputStream, outputStream);
        return a > 2147483647L ? -1 : (int) a;
    }

    /* renamed from: b */
    public static void m7988b(File file) {
        C1146j.m7977a(file, false);
    }

    /* renamed from: b */
    public static boolean m7989b() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m7990b(File file, File file2) {
        return C1146j.m7980a(file, file2, null);
    }

    /* renamed from: b */
    private static boolean m7991b(File file, File file2, FileFilter fileFilter, C1144a c1144a) {
        FileChannel channel;
        Throwable th;
        FileChannel fileChannel = null;
        if (file == null || file2 == null) {
            return false;
        }
        if (fileFilter != null && !fileFilter.accept(file)) {
            return false;
        }
        try {
            if (file.exists() && file.isFile()) {
                if (file2.exists()) {
                    if (c1144a == null || !c1144a.mo1910a(file, file2)) {
                        C1146j.m7988b(file2);
                    } else {
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        return true;
                    }
                }
                File parentFile = file2.getParentFile();
                if (parentFile.isFile()) {
                    C1146j.m7988b(parentFile);
                }
                if (parentFile.exists() || parentFile.mkdirs()) {
                    channel = new FileInputStream(file).getChannel();
                    try {
                        FileChannel channel2 = new FileOutputStream(file2).getChannel();
                        try {
                            long size = channel.size();
                            if (channel2.transferFrom(channel, 0, size) != size) {
                                C1146j.m7988b(file2);
                                if (channel != null) {
                                    channel.close();
                                }
                                if (channel2 != null) {
                                    channel2.close();
                                }
                                return false;
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            if (channel2 != null) {
                                channel2.close();
                            }
                            return true;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            fileChannel = channel;
                            channel = channel2;
                            th = th3;
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        FileChannel fileChannel2 = fileChannel;
                        fileChannel = channel;
                        channel = fileChannel2;
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (channel != null) {
                            channel.close();
                        }
                        throw th;
                    }
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                return false;
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (fileChannel != null) {
                fileChannel.close();
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            channel = fileChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (channel != null) {
                channel.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    private static boolean m7992b(InputStream inputStream, ZipEntry zipEntry, String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable e;
        C1146j.m7978a(new File(str));
        String str3 = str + File.separator + str2;
        File file = new File(str3);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (C1146j.m7983a(str3, zipEntry.getSize(), zipEntry.getTime(), zipEntry.getCrc())) {
                    TbsLog.m7925e("FileHelper", "file is different: " + str3);
                    return false;
                }
                if (!file.setLastModified(zipEntry.getTime())) {
                    TbsLog.m7925e("FileHelper", "Couldn't set time for dst file " + file);
                }
                return true;
            } catch (IOException e2) {
                e = e2;
                try {
                    C1146j.m7988b(file);
                    throw new IOException("Couldn't write dst file " + file, e);
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            C1146j.m7988b(file);
            throw new IOException("Couldn't write dst file " + file, e);
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }

    /* renamed from: b */
    public static byte[] m7993b(InputStream inputStream) {
        return C1146j.m7974a(inputStream).toByteArray();
    }

    /* renamed from: c */
    public static File m7994c() {
        File file = new File(C1146j.m7975a().getAbsolutePath() + "/" + ".tbs");
        if (!(file == null || file.exists())) {
            file.mkdirs();
        }
        return file;
    }

    /* renamed from: c */
    public static boolean m7995c(File file) {
        return file != null && file.exists() && file.isFile() && file.length() > 0;
    }

    /* renamed from: d */
    public static FileOutputStream m7996d(File file) {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.exists() || parentFile.mkdirs())) {
                throw new IOException("File '" + file + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file);
    }

    /* renamed from: d */
    private static String m7997d() {
        try {
            return Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "tbs" + File.separator + "tbslog";
        } catch (Exception e) {
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }
}
