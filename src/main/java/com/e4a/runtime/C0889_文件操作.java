package com.e4a.runtime;

import android.content.Intent;
import android.net.Uri;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.文件操作 */
public final class C0889_文件操作 {
    static BufferedReader br;
    static BufferedWriter bw;
    static FileInputStream fin;
    static FileOutputStream fout;
    static InputStreamReader isr;
    static String line = bi_常量类.f6358b_空串;
    static OutputStreamWriter osw;

    private C0889_文件操作() {
    }

    @SimpleFunction
    /* renamed from: 修改文件名 */
    public static boolean m6776(String oldname, String newname) {
        if (newname.equals(oldname)) {
            return true;
        }
        File oldfile = new File(oldname);
        if (!oldfile.exists()) {
            return false;
        }
        File newfile = new File(newname);
        if (newfile.exists()) {
            return false;
        }
        if (oldfile.renameTo(newfile)) {
            return true;
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 删除文件 */
    public static boolean m6785(String name) {
        File file = new File(name);
        if (file.exists() && !file.isDirectory() && file.delete()) {
            return true;
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 创建目录 */
    public static boolean m6784(String path) {
        String[] dir = path.split("/");
        String dist = dir[0];
        boolean result = true;
        if (dir.length <= 0) {
            return false;
        }
        for (int i = 1; i < dir.length; i++) {
            dist = dist + "/" + dir[i];
            File mkdir = new File(dist);
            if (!mkdir.exists()) {
                result = mkdir.mkdir();
            }
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 删除目录 */
    public static boolean m6786(String path) {
        File dir = new File(path);
        if (dir.exists()) {
            return C0889_文件操作.deleteDir(dir);
        }
        return false;
    }

    private static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String file : children) {
                if (!C0889_文件操作.deleteDir(new File(dir, file))) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    @SimpleFunction
    /* renamed from: 是否为目录 */
    public static boolean m6798(String name) {
        File file = new File(name);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 是否为隐藏文件 */
    public static boolean m6799(String name) {
        File file = new File(name);
        if (file.exists()) {
            return file.isHidden();
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 文件是否存在 */
    public static boolean m6797(String name) {
        return new File(name).exists();
    }

    @SimpleFunction
    /* renamed from: 取文件编码 */
    public static String m6790(String filename) {
        File file = new File(filename);
        String charset = bi_常量类.f6358b_空串;
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
            in.mark(4);
            byte[] first3bytes = new byte[3];
            in.read(first3bytes);
            in.reset();
            if (first3bytes[0] == (byte) -17 && first3bytes[1] == (byte) -69 && first3bytes[2] == (byte) -65) {
                return "utf-8";
            }
            if (first3bytes[0] == (byte) -1 && first3bytes[1] == (byte) -2) {
                return "unicode";
            }
            if (first3bytes[0] == (byte) -2 && first3bytes[1] == (byte) -1) {
                return "utf-16be";
            }
            if (first3bytes[0] == (byte) -1 && first3bytes[1] == (byte) -1) {
                return "utf-16le";
            }
            return "GBK";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return charset;
        } catch (IOException e2) {
            e2.printStackTrace();
            return charset;
        }
    }

    @SimpleFunction
    /* renamed from: 读入文本文件 */
    public static String m6802(String filename, String charset) {
        Exception e;
        String res = bi_常量类.f6358b_空串;
        if (!new File(filename).exists()) {
            return res;
        }
        try {
            FileInputStream fin = new FileInputStream(filename);
            int length = fin.available();
            byte[] buffer = new byte[length];
            fin.read(buffer);
            String res2 = new String(buffer, 0, length, charset);
            try {
                fin.close();
                return res2;
            } catch (Exception e2) {
                e = e2;
                res = res2;
                e.printStackTrace();
                return res;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return res;
        }
    }

    @SimpleFunction
    /* renamed from: 写出文本文件 */
    public static boolean m6781_写出文本文件(String filename, String message, String charset) {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            fout.write(message.getBytes(charset));
            fout.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 读入字节文件 */
    public static byte[] m6801(String filename) {
        byte[] buffer = null;
        if (!new File(filename).exists()) {
            return null;
        }
        try {
            FileInputStream fin = new FileInputStream(filename);
            buffer = new byte[fin.available()];
            fin.read(buffer);
            fin.close();
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
            return buffer;
        }
    }

    @SimpleFunction
    /* renamed from: 写出字节文件 */
    public static boolean m6780(String filename, byte[] bytes) {
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            fout.write(bytes);
            fout.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 取文件尺寸 */
    public static long m6789(String filePath) {
        File file = new File(filePath);
        try {
            if (file.isDirectory()) {
                return C0889_文件操作.getFileSizes(file);
            }
            return C0889_文件操作.getFileSize(file);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static long getFileSize(File file) throws Exception {
        if (file.exists()) {
            return (long) new FileInputStream(file).available();
        }
        file.createNewFile();
        return 0;
    }

    private static long getFileSizes(File f) throws Exception {
        long size = 0;
        File[] flist = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size += C0889_文件操作.getFileSizes(flist[i]);
            } else {
                size += C0889_文件操作.getFileSize(flist[i]);
            }
        }
        return size;
    }

    @SimpleFunction
    /* renamed from: 读入资源文件 */
    public static String m6803_读入资源文件(String filename, String charset) {
        Exception e;
        String res = bi_常量类.f6358b_空串;
        try {
            InputStream inputstream = C0841.m6594().getAssets().open(filename);
            if (inputstream == null) {
                return bi_常量类.f6358b_空串;
            }
            int length = inputstream.available();
            byte[] buffer = new byte[length];
            inputstream.read(buffer);
            String res2 = new String(buffer, 0, length, charset);
            try {
                inputstream.close();
                res = res2;
                return res2;
            } catch (Exception e2) {
                e = e2;
                res = res2;
                e.printStackTrace();
                return bi_常量类.f6358b_空串;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return bi_常量类.f6358b_空串;
        }
    }

    @SimpleFunction
    /* renamed from: 读入资源文件2 */
    public static byte[] m68042(String filename) {
        byte[] buffer = null;
        try {
            InputStream inputstream = C0841.m6594().getAssets().open(filename);
            if (inputstream != null) {
                buffer = new byte[inputstream.available()];
                inputstream.read(buffer);
                inputstream.close();
            }
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SimpleFunction
    /* renamed from: 写出资源文件 */
    public static boolean m6782(String filename, String outFileName) {
        try {
            InputStream stream = C0841.m6594().getAssets().open(filename);
            if (stream != null && C0889_文件操作.writeStreamToFile(stream, new File(outFileName))) {
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean writeStreamToFile(InputStream stream, File file) {
        Exception e1;
        Throwable th;
        OutputStream outputStream = null;
        try {
            OutputStream output = new FileOutputStream(file);
            try {
                byte[] buffer = new byte[1024];
                while (true) {
                    int read = stream.read(buffer);
                    if (read != -1) {
                        output.write(buffer, 0, read);
                    } else {
                        output.flush();
                        try {
                            output.close();
                            stream.close();
                            outputStream = output;
                            return true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            outputStream = output;
                            return false;
                        }
                    }
                }
            } catch (Exception e2) {
                e1 = e2;
                outputStream = output;
                try {
                    e1.printStackTrace();
                    try {
                        outputStream.close();
                        stream.close();
                        return false;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        outputStream.close();
                        stream.close();
                        throw th;
                    } catch (IOException e32) {
                        e32.printStackTrace();
                        return false;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = output;
                outputStream.close();
                stream.close();
                throw th;
            }
        } catch (Exception e4) {
            e1 = e4;
            e1.printStackTrace();
            outputStream.close();
            stream.close();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 寻找文件关键词 */
    public static String m6792(String Path, String keyword) {
        String result = bi_常量类.f6358b_空串;
        for (File f : new File(Path).listFiles()) {
            if (f.getName().indexOf(keyword) >= 0) {
                result = f.getPath() + "\n" + result;
            }
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 寻找文件后缀名 */
    public static String m6793(String Path, String Extension) {
        String result = bi_常量类.f6358b_空串;
        for (File f : new File(Path).listFiles()) {
            if (f.getPath().substring(f.getPath().length() - Extension.length()).equals(Extension) && !f.isDirectory()) {
                result = f.getPath() + "\n" + result;
            }
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 复制文件 */
    public static boolean m6791(String sourcePath, String targetPath) {
        if (!new File(sourcePath).exists()) {
            return false;
        }
        int bytesum = 0;
        try {
            InputStream inStream = new FileInputStream(sourcePath);
            FileOutputStream fs = new FileOutputStream(targetPath);
            byte[] buffer = new byte[1444];
            while (true) {
                int byteread = inStream.read(buffer);
                if (byteread != -1) {
                    bytesum += byteread;
                    fs.write(buffer, 0, byteread);
                } else {
                    inStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 创建文件 */
    public static boolean m6783(String path) {
        boolean result = false;
        File f = new File(path);
        if (f.exists()) {
            return true;
        }
        try {
            return f.createNewFile();
        } catch (IOException e) {
            return result;
        }
    }

    @SimpleFunction
    /* renamed from: 打开文本文件_读 */
    public static boolean m6796_(String filename, String charset) {
        if (!new File(filename).exists()) {
            return false;
        }
        try {
            fin = new FileInputStream(filename);
            isr = new InputStreamReader(fin, charset);
            br = new BufferedReader(isr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 关闭读 */
    public static boolean m6778() {
        try {
            br.close();
            fin.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 读一行 */
    public static String m6800() {
        try {
            String readLine = br.readLine();
            line = readLine;
            if (readLine != null) {
                return line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bi_常量类.f6358b_空串;
    }

    @SimpleFunction
    /* renamed from: 打开文本文件_写 */
    public static boolean m6795_(String filename, String charset) {
        if (!new File(filename).exists()) {
            return false;
        }
        try {
            fout = new FileOutputStream(filename);
            osw = new OutputStreamWriter(fout, charset);
            bw = new BufferedWriter(osw);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 关闭写 */
    public static boolean m6777() {
        try {
            bw.close();
            fout.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 写一行 */
    public static boolean m6779(String message) {
        try {
            bw.newLine();
            bw.write(message);
            bw.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @SimpleFunction
    /* renamed from: 取子目录 */
    public static String m6787(String dir) {
        String pa = bi_常量类.f6358b_空串;
        File[] ff = new File(dir).listFiles();
        for (int i = 0; i < ff.length; i++) {
            if (ff[i].isDirectory()) {
                pa = pa + ff[i].getAbsolutePath() + "|";
            }
        }
        return pa;
    }

    @SimpleFunction
    /* renamed from: 取文件修改时间 */
    public static String m6788(String path) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(new File(path).lastModified()));
    }

    @SimpleFunction
    /* renamed from: 打开文件 */
    public static void m6794(String Path) {
        mainActivity.getContext().startActivity(C0889_文件操作.openFile(Path));
    }

    private static Intent openFile(String filePath) {
        File file = new File(filePath);
        if (file == null || !file.exists() || file.isDirectory()) {
            return null;
        }
        String end = file.getName().substring(file.getName().lastIndexOf(".") + 1, file.getName().length()).toLowerCase();
        if (end.equals("m4a") || end.equals("mp3") || end.equals("mid") || end.equals("xmf") || end.equals("ogg") || end.equals("wav")) {
            return C0889_文件操作.getAudioFileIntent(filePath);
        }
        if (end.equals("3gp") || end.equals("mp4")) {
            return C0889_文件操作.getVideoFileIntent(filePath);
        }
        if (end.equals("jpg") || end.equals("gif") || end.equals("png") || end.equals("jpeg") || end.equals("bmp")) {
            return C0889_文件操作.getImageFileIntent(filePath);
        }
        if (end.equals("apk")) {
            return C0889_文件操作.getApkFileIntent(filePath);
        }
        if (end.equals("ppt")) {
            return C0889_文件操作.getPptFileIntent(filePath);
        }
        if (end.equals("xls")) {
            return C0889_文件操作.getExcelFileIntent(filePath);
        }
        if (end.equals("doc")) {
            return C0889_文件操作.getWordFileIntent(filePath);
        }
        if (end.equals("pdf")) {
            return C0889_文件操作.getPdfFileIntent(filePath);
        }
        if (end.equals("chm")) {
            return C0889_文件操作.getChmFileIntent(filePath);
        }
        if (end.equals("txt")) {
            return C0889_文件操作.getTextFileIntent(filePath, false);
        }
        return C0889_文件操作.getAllIntent(filePath);
    }

    private static Intent getAllIntent(String param) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(param)), "*/*");
        return intent;
    }

    private static Intent getApkFileIntent(String param) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/vnd.android.package-archive");
        return intent;
    }

    private static Intent getVideoFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(67108864);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        intent.setDataAndType(Uri.fromFile(new File(param)), "video/*");
        return intent;
    }

    private static Intent getAudioFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(67108864);
        intent.putExtra("oneshot", 0);
        intent.putExtra("configchange", 0);
        intent.setDataAndType(Uri.fromFile(new File(param)), "audio/*");
        return intent;
    }

    private static Intent getHtmlFileIntent(String param) {
        Uri uri = Uri.parse(param).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(param).build();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "text/html");
        return intent;
    }

    private static Intent getImageFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "image/*");
        return intent;
    }

    private static Intent getPptFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/vnd.ms-powerpoint");
        return intent;
    }

    private static Intent getExcelFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/vnd.ms-excel");
        return intent;
    }

    private static Intent getWordFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/msword");
        return intent;
    }

    private static Intent getChmFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/x-chm");
        return intent;
    }

    private static Intent getTextFileIntent(String param, boolean paramBoolean) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        if (paramBoolean) {
            intent.setDataAndType(Uri.parse(param), "text/plain");
        } else {
            intent.setDataAndType(Uri.fromFile(new File(param)), "text/plain");
        }
        return intent;
    }

    private static Intent getPdfFileIntent(String param) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(param)), "application/pdf");
        return intent;
    }
}
