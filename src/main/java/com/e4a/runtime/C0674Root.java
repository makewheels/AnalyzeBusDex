package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.Root权限操作 */
public final class C0674Root {
    private static boolean haveRoot = false;
    private static DataInputStream inputStream;
    private static DataOutputStream outputStream;
    private static Process process;
    private static BufferedReader reader;

    @SimpleFunction
    /* renamed from: 手机是否已Root */
    public static boolean m5400Root() {
        if (haveRoot) {
            return true;
        }
        if (C0674Root.m5401("echo test") != -1) {
            haveRoot = true;
        } else {
            haveRoot = false;
        }
        return haveRoot;
    }

    @SimpleFunction
    /* renamed from: 执行命令行2 */
    public static String m54022(String cmd) {
        String str1 = bi_常量类.f6358b;
        try {
            process = Runtime.getRuntime().exec("su");
            outputStream = new DataOutputStream(process.getOutputStream());
            inputStream = new DataInputStream(process.getInputStream());
            reader = new BufferedReader(new InputStreamReader(inputStream));
            outputStream.write((cmd + "\n").getBytes());
            outputStream.flush();
            outputStream.write("exit\n".getBytes());
            outputStream.flush();
            while (true) {
                String str2 = reader.readLine();
                if (str2 == null) {
                    break;
                } else if (str1.equals(bi_常量类.f6358b)) {
                    str1 = str2;
                } else {
                    str1 = str1 + "\n" + str2;
                }
            }
            process.waitFor();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e222) {
                    e222.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e322) {
                    e322.printStackTrace();
                }
            }
        }
        return str1;
    }

    @SimpleFunction
    /* renamed from: 执行命令行5 */
    public static String m54055(String cmd) {
        String str1 = bi_常量类.f6358b;
        try {
            process = Runtime.getRuntime().exec("sh");
            outputStream = new DataOutputStream(process.getOutputStream());
            inputStream = new DataInputStream(process.getInputStream());
            reader = new BufferedReader(new InputStreamReader(inputStream));
            outputStream.write((cmd + "\n").getBytes());
            outputStream.flush();
            outputStream.write("exit\n".getBytes());
            outputStream.flush();
            while (true) {
                String str2 = reader.readLine();
                if (str2 == null) {
                    break;
                } else if (str1.equals(bi_常量类.f6358b)) {
                    str1 = str2;
                } else {
                    str1 = str1 + "\n" + str2;
                }
            }
            process.waitFor();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e32) {
                    e32.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e222) {
                    e222.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e322) {
                    e322.printStackTrace();
                }
            }
        }
        return str1;
    }

    @SimpleFunction
    /* renamed from: 执行命令行 */
    public static int m5401(String cmd) {
        int i = -1;
        try {
            Process process = Runtime.getRuntime().exec("su");
            outputStream = new DataOutputStream(process.getOutputStream());
            outputStream.writeBytes(cmd + "\n");
            outputStream.flush();
            outputStream.writeBytes("exit\n");
            outputStream.flush();
            process.waitFor();
            i = process.exitValue();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e22) {
                    e22.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e222) {
                    e222.printStackTrace();
                }
            }
        }
        return i;
    }

    @SimpleFunction
    /* renamed from: 执行命令行3 */
    public static void m54033(String cmd) {
        try {
            if (process == null || outputStream == null) {
                process = Runtime.getRuntime().exec("su");
                outputStream = new DataOutputStream(process.getOutputStream());
            }
            outputStream.write((cmd + "\n").getBytes());
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SimpleFunction
    /* renamed from: 模拟按键 */
    public static void m5406(int 键代码) {
        if (C0674Root.m5400Root()) {
            C0674Root.m54033("input keyevent " + 键代码);
        }
    }

    @SimpleFunction
    /* renamed from: 模拟输入 */
    public static void m5409(String 内容) {
        if (C0674Root.m5400Root()) {
            C0674Root.m54033("input text '" + 内容 + "'");
        }
    }

    @SimpleFunction
    /* renamed from: 模拟点击 */
    public static void m5407(int x, int y) {
        if (C0674Root.m5400Root()) {
            C0674Root.m54033("input tap " + x + " " + y);
        }
    }

    @SimpleFunction
    /* renamed from: 模拟移动 */
    public static void m5408(int x1, int y1, int x2, int y2) {
        if (C0674Root.m5400Root()) {
            C0674Root.m54033("input swipe " + x1 + " " + y1 + " " + x2 + " " + y2);
        }
    }

    @SimpleFunction
    /* renamed from: 取所有存储卡路径 */
    public static String[] m5397() {
        List paths = new ArrayList();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("mount").getInputStream()));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                } else if (!((!line.contains("fat") && !line.contains("fuse") && !line.contains("storage")) || line.contains("secure") || line.contains("asec") || line.contains("firmware") || line.contains("shell") || line.contains("obb") || line.contains("legacy") || line.contains("data"))) {
                    String[] parts = line.split(" ");
                    if (1 < parts.length) {
                        String mountPath = parts[1];
                        if (!(!mountPath.contains("/") || mountPath.contains("data") || mountPath.contains("Data"))) {
                            File mountRoot = new File(mountPath);
                            if (mountRoot.exists() && mountRoot.isDirectory() && mountRoot.canWrite()) {
                                paths.add(mountPath);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] result = new String[paths.size()];
        paths.toArray(result);
        return result;
    }

    @SimpleFunction
    /* renamed from: 截取屏幕 */
    public static void m5399(String path) {
        if (C0674Root.m5400Root()) {
            C0674Root.m54033("screencap " + path);
        }
    }

    @SimpleFunction
    /* renamed from: 强制结束进程 */
    public static boolean m5398(String packagename) {
        int 执行结果 = -1;
        if (C0674Root.m5400Root()) {
            执行结果 = C0674Root.m5401("am force-stop " + packagename);
        }
        if (执行结果 != -1) {
            return true;
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 执行命令行4 */
    public static int m54044(String 命令行) {
        try {
            Process process = Runtime.getRuntime().exec(命令行);
            process.waitFor();
            return process.exitValue();
        } catch (Throwable th) {
            return -1;
        }
    }
}
