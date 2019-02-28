package com.e4a.runtime;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Environment;
import android.os.StatFs;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.存储卡类 */
public final class C0852_存储卡类 {
    private C0852_存储卡类() {
    }

    @SimpleFunction
    /* renamed from: 取存储卡状态 */
    public static boolean m6664() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            return true;
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 取存储卡路径 */
    public static String m6665_取存储卡路径() {
        if ("mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory().canWrite()) {
            return Environment.getExternalStorageDirectory().getPath();
        }
        return bi_常量类.f6358b_空串;
    }

    @SimpleFunction
    /* renamed from: 取存储卡总容量 */
    public static long m6663() {
        StatFs sf = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((((long) sf.getBlockCount()) * ((long) sf.getBlockSize())) / 1024) / 1024;
    }

    @SimpleFunction
    /* renamed from: 取存储卡剩余容量 */
    public static long m6662() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024;
    }

    @SimpleFunction
    /* renamed from: 取内部存储卡总容量 */
    public static long m6661() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        return ((((long) stat.getBlockCount()) * ((long) stat.getBlockSize())) / 1024) / 1024;
    }

    @SimpleFunction
    /* renamed from: 取内部存储卡剩余容量 */
    public static long m6660() {
        StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
        return ((((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize())) / 1024) / 1024;
    }

    @SimpleFunction
    /* renamed from: 取手机总内存 */
    public static long m6667() {
        long initial_memory = 0;
        try {
            BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            initial_memory = (long) Integer.valueOf(localBufferedReader.readLine().split("\\s+")[1]).intValue();
            localBufferedReader.close();
        } catch (IOException e) {
        }
        return initial_memory / 1024;
    }

    @SimpleFunction
    /* renamed from: 取手机剩余内存 */
    public static long m6666() {
        ActivityManager am = (ActivityManager) C0841.m6594().getSystemService("activity");
        MemoryInfo mi = new MemoryInfo();
        am.getMemoryInfo(mi);
        return (mi.availMem / 1024) / 1024;
    }

    @SimpleFunction
    /* renamed from: 取CPU主频 */
    public static double m6659CPU() {
        IOException e;
        FileNotFoundException e2;
        Throwable th;
        int result = 0;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            FileReader fr2 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                BufferedReader br2 = new BufferedReader(fr2);
                try {
                    result = Integer.parseInt(br2.readLine().trim());
                    if (fr2 != null) {
                        try {
                            fr2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (br2 != null) {
                        try {
                            br2.close();
                            br = br2;
                            fr = fr2;
                        } catch (IOException e32) {
                            e32.printStackTrace();
                            br = br2;
                            fr = fr2;
                        }
                    } else {
                        fr = fr2;
                    }
                } catch (FileNotFoundException e4) {
                    e2 = e4;
                    br = br2;
                    fr = fr2;
                    try {
                        e2.printStackTrace();
                        if (fr != null) {
                            try {
                                fr.close();
                            } catch (IOException e322) {
                                e322.printStackTrace();
                            }
                        }
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException e3222) {
                                e3222.printStackTrace();
                            }
                        }
                        return (double) ((result / 1000) / 1000);
                    } catch (Throwable th2) {
                        th = th2;
                        if (fr != null) {
                            try {
                                fr.close();
                            } catch (IOException e32222) {
                                e32222.printStackTrace();
                            }
                        }
                        if (br != null) {
                            try {
                                br.close();
                            } catch (IOException e322222) {
                                e322222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e322222 = e5;
                    br = br2;
                    fr = fr2;
                    e322222.printStackTrace();
                    if (fr != null) {
                        try {
                            fr.close();
                        } catch (IOException e3222222) {
                            e3222222.printStackTrace();
                        }
                    }
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e32222222) {
                            e32222222.printStackTrace();
                        }
                    }
                    return (double) ((result / 1000) / 1000);
                } catch (Throwable th3) {
                    th = th3;
                    br = br2;
                    fr = fr2;
                    if (fr != null) {
                        fr.close();
                    }
                    if (br != null) {
                        br.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e6) {
                e2 = e6;
                fr = fr2;
                e2.printStackTrace();
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
                return (double) ((result / 1000) / 1000);
            } catch (IOException e7) {
                e32222222 = e7;
                fr = fr2;
                e32222222.printStackTrace();
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
                return (double) ((result / 1000) / 1000);
            } catch (Throwable th4) {
                th = th4;
                fr = fr2;
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
            e2 = e8;
            e2.printStackTrace();
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
            return (double) ((result / 1000) / 1000);
        } catch (IOException e9) {
            e32222222 = e9;
            e32222222.printStackTrace();
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
            return (double) ((result / 1000) / 1000);
        }
        return (double) ((result / 1000) / 1000);
    }
}
