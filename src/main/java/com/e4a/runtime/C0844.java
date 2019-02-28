package com.e4a.runtime;

import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.压缩解压 */
public final class C0844 {
    @SimpleFunction
    /* renamed from: zip压缩 */
    public static boolean m6614zip(String src, String dest) {
        IOException ex;
        Throwable th;
        ZipOutputStream out = null;
        try {
            File outFile = new File(dest);
            File fileOrDirectory = new File(src);
            ZipOutputStream out2 = new ZipOutputStream(new FileOutputStream(outFile));
            try {
                if (fileOrDirectory.isFile()) {
                    C0844.zipFileOrDirectory(out2, fileOrDirectory, bi_常量类.f6358b_空串);
                } else {
                    File[] entries = fileOrDirectory.listFiles();
                    for (File zipFileOrDirectory : entries) {
                        C0844.zipFileOrDirectory(out2, zipFileOrDirectory, bi_常量类.f6358b_空串);
                    }
                }
                if (out2 != null) {
                    try {
                        out2.close();
                        out = out2;
                        return true;
                    } catch (IOException ex2) {
                        ex2.printStackTrace();
                        out = out2;
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                ex2 = e;
                out = out2;
                try {
                    ex2.printStackTrace();
                    if (out != null) {
                        return false;
                    }
                    try {
                        out.close();
                        return false;
                    } catch (IOException ex22) {
                        ex22.printStackTrace();
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException ex222) {
                            ex222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                out = out2;
                if (out != null) {
                    out.close();
                }
                throw th;
            }
        } catch (IOException e2) {
            ex222 = e2;
            ex222.printStackTrace();
            if (out != null) {
                return false;
            }
            out.close();
            return false;
        }
    }

    private static void zipFileOrDirectory(ZipOutputStream out, File fileOrDirectory, String curPath) throws IOException {
        IOException ex;
        Throwable th;
        FileInputStream in = null;
        try {
            if (fileOrDirectory.isDirectory()) {
                File[] entries = fileOrDirectory.listFiles();
                if (entries.length <= 0) {
                    out.putNextEntry(new ZipEntry(curPath + fileOrDirectory.getName() + "/"));
                    out.closeEntry();
                } else {
                    for (File zipFileOrDirectory : entries) {
                        C0844.zipFileOrDirectory(out, zipFileOrDirectory, curPath + fileOrDirectory.getName() + "/");
                    }
                }
            } else {
                byte[] buffer = new byte[4096];
                FileInputStream in2 = new FileInputStream(fileOrDirectory);
                try {
                    out.putNextEntry(new ZipEntry(curPath + fileOrDirectory.getName()));
                    while (true) {
                        int bytes_read = in2.read(buffer);
                        if (bytes_read == -1) {
                            break;
                        }
                        out.write(buffer, 0, bytes_read);
                    }
                    out.closeEntry();
                    in = in2;
                } catch (IOException e) {
                    ex = e;
                    in = in2;
                    try {
                        ex.printStackTrace();
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException ex2) {
                                ex2.printStackTrace();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (in != null) {
                            try {
                                in.close();
                            } catch (IOException ex22) {
                                ex22.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    in = in2;
                    if (in != null) {
                        in.close();
                    }
                    throw th;
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex222) {
                    ex222.printStackTrace();
                }
            }
        } catch (IOException e2) {
            ex222 = e2;
            ex222.printStackTrace();
            if (in != null) {
                in.close();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @com.e4a.runtime.annotations.SimpleFunction
    /* renamed from: zip解压 */
    public static boolean m6615zip(java.lang.String r21, java.lang.String r22) {
        /*
        r10 = 0;
        r17 = 0;
        r18 = new java.util.zip.ZipFile;	 Catch:{ IOException -> 0x01a0 }
        r0 = r18;
        r1 = r21;
        r0.<init>(r1);	 Catch:{ IOException -> 0x01a0 }
        r6 = r18.entries();	 Catch:{ IOException -> 0x016f, all -> 0x019c }
        r16 = 0;
        r4 = new java.io.File;	 Catch:{ IOException -> 0x016f, all -> 0x019c }
        r0 = r22;
        r4.<init>(r0);	 Catch:{ IOException -> 0x016f, all -> 0x019c }
        r4.mkdirs();	 Catch:{ IOException -> 0x016f, all -> 0x019c }
    L_0x001c:
        r19 = r6.hasMoreElements();	 Catch:{ IOException -> 0x016f, all -> 0x019c }
        if (r19 == 0) goto L_0x0182;
    L_0x0022:
        r16 = r6.nextElement();	 Catch:{ IOException -> 0x016f, all -> 0x019c }
        r16 = (java.util.zip.ZipEntry) r16;	 Catch:{ IOException -> 0x016f, all -> 0x019c }
        r7 = r16.getName();	 Catch:{ IOException -> 0x016f, all -> 0x019c }
        r11 = 0;
        r14 = 0;
        r19 = r16.isDirectory();	 Catch:{ IOException -> 0x01a5 }
        if (r19 == 0) goto L_0x007e;
    L_0x0034:
        r13 = r16.getName();	 Catch:{ IOException -> 0x01a5 }
        r19 = 0;
        r20 = r13.length();	 Catch:{ IOException -> 0x01a5 }
        r20 = r20 + -1;
        r0 = r19;
        r1 = r20;
        r13 = r13.substring(r0, r1);	 Catch:{ IOException -> 0x01a5 }
        r9 = new java.io.File;	 Catch:{ IOException -> 0x01a5 }
        r19 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01a5 }
        r19.<init>();	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r1 = r22;
        r19 = r0.append(r1);	 Catch:{ IOException -> 0x01a5 }
        r20 = java.io.File.separator;	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.append(r20);	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r19 = r0.append(r13);	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.toString();	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r9.<init>(r0);	 Catch:{ IOException -> 0x01a5 }
        r9.mkdirs();	 Catch:{ IOException -> 0x01a5 }
        r10 = 1;
    L_0x0070:
        if (r11 == 0) goto L_0x0075;
    L_0x0072:
        r11.close();	 Catch:{ IOException -> 0x015c, all -> 0x019c }
    L_0x0075:
        if (r14 == 0) goto L_0x001c;
    L_0x0077:
        r14.close();	 Catch:{ IOException -> 0x007b, all -> 0x019c }
        goto L_0x001c;
    L_0x007b:
        r8 = move-exception;
        r10 = 0;
        goto L_0x001c;
    L_0x007e:
        r19 = "\\";
        r0 = r19;
        r12 = r7.lastIndexOf(r0);	 Catch:{ IOException -> 0x01a5 }
        r19 = -1;
        r0 = r19;
        if (r12 == r0) goto L_0x00b9;
    L_0x008c:
        r5 = new java.io.File;	 Catch:{ IOException -> 0x01a5 }
        r19 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01a5 }
        r19.<init>();	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r1 = r22;
        r19 = r0.append(r1);	 Catch:{ IOException -> 0x01a5 }
        r20 = java.io.File.separator;	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.append(r20);	 Catch:{ IOException -> 0x01a5 }
        r20 = 0;
        r0 = r20;
        r20 = r7.substring(r0, r12);	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.append(r20);	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.toString();	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r5.<init>(r0);	 Catch:{ IOException -> 0x01a5 }
        r5.mkdirs();	 Catch:{ IOException -> 0x01a5 }
    L_0x00b9:
        r19 = "/";
        r0 = r19;
        r12 = r7.lastIndexOf(r0);	 Catch:{ IOException -> 0x01a5 }
        r19 = -1;
        r0 = r19;
        if (r12 == r0) goto L_0x00f4;
    L_0x00c7:
        r5 = new java.io.File;	 Catch:{ IOException -> 0x01a5 }
        r19 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01a5 }
        r19.<init>();	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r1 = r22;
        r19 = r0.append(r1);	 Catch:{ IOException -> 0x01a5 }
        r20 = java.io.File.separator;	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.append(r20);	 Catch:{ IOException -> 0x01a5 }
        r20 = 0;
        r0 = r20;
        r20 = r7.substring(r0, r12);	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.append(r20);	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.toString();	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r5.<init>(r0);	 Catch:{ IOException -> 0x01a5 }
        r5.mkdirs();	 Catch:{ IOException -> 0x01a5 }
    L_0x00f4:
        r9 = new java.io.File;	 Catch:{ IOException -> 0x01a5 }
        r19 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x01a5 }
        r19.<init>();	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r1 = r22;
        r19 = r0.append(r1);	 Catch:{ IOException -> 0x01a5 }
        r20 = java.io.File.separator;	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.append(r20);	 Catch:{ IOException -> 0x01a5 }
        r20 = r16.getName();	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.append(r20);	 Catch:{ IOException -> 0x01a5 }
        r19 = r19.toString();	 Catch:{ IOException -> 0x01a5 }
        r0 = r19;
        r9.<init>(r0);	 Catch:{ IOException -> 0x01a5 }
        r0 = r18;
        r1 = r16;
        r11 = r0.getInputStream(r1);	 Catch:{ IOException -> 0x01a5 }
        r15 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x01a5 }
        r15.<init>(r9);	 Catch:{ IOException -> 0x01a5 }
        r19 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = r19;
        r2 = new byte[r0];	 Catch:{ IOException -> 0x013f, all -> 0x01a2 }
    L_0x012d:
        r3 = r11.read(r2);	 Catch:{ IOException -> 0x013f, all -> 0x01a2 }
        r19 = -1;
        r0 = r19;
        if (r3 == r0) goto L_0x0155;
    L_0x0137:
        r19 = 0;
        r0 = r19;
        r15.write(r2, r0, r3);	 Catch:{ IOException -> 0x013f, all -> 0x01a2 }
        goto L_0x012d;
    L_0x013f:
        r8 = move-exception;
        r14 = r15;
    L_0x0141:
        r8.printStackTrace();	 Catch:{ all -> 0x0163 }
        r10 = 0;
        if (r11 == 0) goto L_0x014a;
    L_0x0147:
        r11.close();	 Catch:{ IOException -> 0x0160, all -> 0x019c }
    L_0x014a:
        if (r14 == 0) goto L_0x001c;
    L_0x014c:
        r14.close();	 Catch:{ IOException -> 0x0151, all -> 0x019c }
        goto L_0x001c;
    L_0x0151:
        r8 = move-exception;
        r10 = 0;
        goto L_0x001c;
    L_0x0155:
        r15.flush();	 Catch:{ IOException -> 0x013f, all -> 0x01a2 }
        r10 = 1;
        r14 = r15;
        goto L_0x0070;
    L_0x015c:
        r8 = move-exception;
        r10 = 0;
        goto L_0x0075;
    L_0x0160:
        r8 = move-exception;
        r10 = 0;
        goto L_0x014a;
    L_0x0163:
        r19 = move-exception;
    L_0x0164:
        if (r11 == 0) goto L_0x0169;
    L_0x0166:
        r11.close();	 Catch:{ IOException -> 0x017c, all -> 0x019c }
    L_0x0169:
        if (r14 == 0) goto L_0x016e;
    L_0x016b:
        r14.close();	 Catch:{ IOException -> 0x017f, all -> 0x019c }
    L_0x016e:
        throw r19;	 Catch:{ IOException -> 0x016f, all -> 0x019c }
    L_0x016f:
        r8 = move-exception;
        r17 = r18;
    L_0x0172:
        r8.printStackTrace();	 Catch:{ all -> 0x0192 }
        r10 = 0;
        if (r17 == 0) goto L_0x017b;
    L_0x0178:
        r17.close();	 Catch:{ IOException -> 0x018f }
    L_0x017b:
        return r10;
    L_0x017c:
        r8 = move-exception;
        r10 = 0;
        goto L_0x0169;
    L_0x017f:
        r8 = move-exception;
        r10 = 0;
        goto L_0x016e;
    L_0x0182:
        if (r18 == 0) goto L_0x01a7;
    L_0x0184:
        r18.close();	 Catch:{ IOException -> 0x018a }
        r17 = r18;
        goto L_0x017b;
    L_0x018a:
        r8 = move-exception;
        r10 = 0;
        r17 = r18;
        goto L_0x017b;
    L_0x018f:
        r8 = move-exception;
        r10 = 0;
        goto L_0x017b;
    L_0x0192:
        r19 = move-exception;
    L_0x0193:
        if (r17 == 0) goto L_0x0198;
    L_0x0195:
        r17.close();	 Catch:{ IOException -> 0x0199 }
    L_0x0198:
        throw r19;
    L_0x0199:
        r8 = move-exception;
        r10 = 0;
        goto L_0x0198;
    L_0x019c:
        r19 = move-exception;
        r17 = r18;
        goto L_0x0193;
    L_0x01a0:
        r8 = move-exception;
        goto L_0x0172;
    L_0x01a2:
        r19 = move-exception;
        r14 = r15;
        goto L_0x0164;
    L_0x01a5:
        r8 = move-exception;
        goto L_0x0141;
    L_0x01a7:
        r17 = r18;
        goto L_0x017b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e4a.runtime.压缩解压.zip解压(java.lang.String, java.lang.String):boolean");
    }
}
