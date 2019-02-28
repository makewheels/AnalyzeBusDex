package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* renamed from: com.tencent.smtt.utils.a */
public class C1134a {
    /* renamed from: a */
    private static Class<AssetManager> f5117a = AssetManager.class;
    /* renamed from: b */
    private static Method f5118b;

    static {
        try {
            f5118b = f5117a.getDeclaredMethod("addAssetPath", new Class[]{String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static int m7938a(Context context, File file) {
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            return packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    private static PackageInfo m7939a(String str, int i) {
        try {
            Class cls = Class.forName("android.content.pm.PackageParser");
            for (Class cls2 : cls.getDeclaredClasses()) {
                if (cls2.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
            }
            Class cls22 = null;
            Constructor constructor = cls.getConstructor(new Class[]{String.class});
            Method declaredMethod = cls.getDeclaredMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE});
            Method declaredMethod2 = cls.getDeclaredMethod("collectCertificates", new Class[]{cls22, Integer.TYPE});
            Method declaredMethod3 = cls.getDeclaredMethod("generatePackageInfo", new Class[]{cls22, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE});
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[]{str});
            new DisplayMetrics().setToDefaults();
            if (declaredMethod.invoke(newInstance, new Object[]{new File(str), str, new DisplayMetrics(), Integer.valueOf(0)}) == null) {
                return null;
            }
            if ((i & 64) != 0) {
                declaredMethod2.invoke(newInstance, new Object[]{r3, Integer.valueOf(0)});
            }
            return (PackageInfo) declaredMethod3.invoke(null, new Object[]{r3, null, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m7940a(Context context, File file, boolean z) {
        Signature signature;
        PackageInfo a = z ? C1134a.m7939a(file.getAbsolutePath(), 65) : context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
        if (a != null) {
            if (a.signatures == null || a.signatures.length <= 0) {
                TbsLog.m7931w("ApkUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
            } else {
                signature = a.signatures[0];
                return signature == null ? signature.toCharsString() : null;
            }
        }
        signature = null;
        if (signature == null) {
        }
    }

    /* renamed from: a */
    public static String m7941a(File file) {
        Exception e;
        Throwable th;
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        FileInputStream fileInputStream;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                bArr = instance.digest();
                int i2 = 0;
                while (i < 16) {
                    byte b = bArr[i];
                    int i3 = i2 + 1;
                    cArr2[i2] = cArr[(b >>> 4) & 15];
                    i2 = i3 + 1;
                    cArr2[i3] = cArr[b & 15];
                    i++;
                }
                String str = new String(cArr2);
                if (fileInputStream == null) {
                    return str;
                }
                try {
                    fileInputStream.close();
                    return str;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return str;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private static String m7942a(byte[] bArr) {
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

    /* renamed from: a */
    public static boolean m7943a(Context context, File file, long j, int i) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (j > 0 && j != file.length()) {
            return false;
        }
        try {
            if (i != C1134a.m7938a(context, file)) {
                return false;
            }
            return "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(C1134a.m7945b(context, file));
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    private static Certificate[] m7944a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        return jarEntry != null ? jarEntry.getCertificates() : null;
    }

    /* renamed from: b */
    public static String m7945b(Context context, File file) {
        String a = C1134a.m7940a(context, file, false);
        if (a == null) {
            a = C1134a.m7946b(file);
        }
        return a == null ? C1134a.m7940a(context, file, true) : a;
    }

    /* renamed from: b */
    private static String m7946b(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String a = C1134a.m7942a(C1134a.m7944a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                String name = jarEntry.getName();
                if (name != null) {
                    Certificate[] a2 = C1134a.m7944a(jarFile, jarEntry, bArr);
                    String a3 = a2 != null ? C1134a.m7942a(a2[0].getEncoded()) : null;
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
}
