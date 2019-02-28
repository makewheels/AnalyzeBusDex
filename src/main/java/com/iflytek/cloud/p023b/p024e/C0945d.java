package com.iflytek.cloud.p023b.p024e;

import android.content.Context;
import android.os.MemoryFile;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.b.e.d */
public class C0945d {
    /* renamed from: a */
    private static String f4490a = bi_常量类.f6358b_空串;

    /* renamed from: a */
    public static String m7138a(Context context) {
        if (!TextUtils.isEmpty(f4490a)) {
            return f4490a;
        }
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        absolutePath = absolutePath + "msclib/";
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        f4490a = absolutePath;
        return f4490a;
    }

    /* renamed from: a */
    public static void m7139a(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: a */
    public static void m7140a(ConcurrentLinkedQueue<byte[]> concurrentLinkedQueue, String str) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        try {
            C0945d.m7144c(str);
            fileOutputStream = new FileOutputStream(str);
            try {
                Iterator it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    fileOutputStream.write((byte[]) it.next());
                }
                fileOutputStream.close();
                FileOutputStream fileOutputStream2 = null;
                if (null != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    e2.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            e22.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static boolean m7141a(MemoryFile memoryFile, long j, String str) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        boolean z = false;
        if (!(memoryFile == null || TextUtils.isEmpty(str))) {
            try {
                C0945d.m7139a(str);
                C0945d.m7144c(str);
                fileOutputStream = new FileOutputStream(str);
                try {
                    byte[] bArr = new byte[1024];
                    int i = 0;
                    while (((long) i) < j) {
                        int i2 = (int) (j - ((long) i) > 1024 ? 1024 : j - ((long) i));
                        memoryFile.readBytes(bArr, i, 0, i2);
                        fileOutputStream.write(bArr, 0, i2);
                        i += i2;
                    }
                    z = true;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m7142a(byte[] bArr, String str, boolean z, int i) {
        boolean z2 = false;
        RandomAccessFile randomAccessFile = null;
        if (!z) {
            try {
                C0945d.m7139a(str);
            } catch (Exception e) {
                e = e;
                try {
                    Exception e2;
                    e2.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e3) {
                        }
                    }
                    return z2;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th2;
                }
            }
        }
        C0945d.m7144c(str);
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "rw");
        if (!z) {
            try {
                randomAccessFile2.setLength(0);
            } catch (Exception e5) {
                e2 = e5;
                randomAccessFile = randomAccessFile2;
                e2.printStackTrace();
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return z2;
            } catch (Throwable th3) {
                th2 = th3;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th2;
            }
        } else if (i < 0) {
            randomAccessFile2.seek(randomAccessFile2.length());
        } else {
            randomAccessFile2.seek((long) i);
        }
        randomAccessFile2.write(bArr);
        z2 = true;
        if (randomAccessFile2 != null) {
            try {
                randomAccessFile2.close();
            } catch (Exception e6) {
            }
        }
        return z2;
    }

    /* renamed from: b */
    public static byte[] m7143b(String str) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        byte[] bArr = null;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(str);
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        return bArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } else if (null != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e2222) {
                    e2222.printStackTrace();
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return bArr;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return bArr;
    }

    /* renamed from: c */
    public static void m7144c(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!str.endsWith("/")) {
                file = file.getParentFile();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }
}
