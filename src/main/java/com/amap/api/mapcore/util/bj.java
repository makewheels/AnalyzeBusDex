package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import com.amap.api.mapcore.util.bl.C0368a;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import p054u.aly.bi_常量类;

/* compiled from: LogWriter */
abstract class bj {
    /* renamed from: a */
    private ad f2016a;

    /* renamed from: a */
    protected abstract int mo600a();

    /* renamed from: a */
    protected abstract bo mo601a(al alVar);

    /* renamed from: a */
    protected abstract String mo602a(String str);

    /* renamed from: a */
    protected abstract String mo603a(List<ad> list);

    /* renamed from: b */
    protected abstract String mo604b();

    bj() {
    }

    /* renamed from: a */
    static bj m3171a(int i) {
        switch (i) {
            case 0:
                return new bd();
            case 1:
                return new bf();
            case 2:
                return new bb();
            default:
                return null;
        }
    }

    /* renamed from: a */
    void m3187a(Context context, Throwable th, String str, String str2) {
        List<ad> b = m3178b(context);
        if (b != null && b.size() != 0) {
            String a = m3184a(th);
            if (a != null && !bi_常量类.f6358b.equals(a)) {
                for (ad adVar : b) {
                    if (m3189a(adVar.m3038f(), a)) {
                        m3188a(adVar);
                        String c = m3179c();
                        String a2 = m3172a(context, adVar);
                        String c2 = m3180c(context);
                        String b2 = m3177b(th);
                        if (b2 != null && !bi_常量类.f6358b.equals(b2)) {
                            int a3 = mo600a();
                            StringBuilder stringBuilder = new StringBuilder();
                            if (str != null) {
                                stringBuilder.append("class:").append(str);
                            }
                            if (str2 != null) {
                                stringBuilder.append(" method:").append(str2).append("$").append("<br/>");
                            }
                            stringBuilder.append(a);
                            String a4 = mo602a(a);
                            String a5 = m3174a(c2, a2, c, a3, b2, stringBuilder.toString());
                            if (a5 != null && !bi_常量类.f6358b.equals(a5)) {
                                String a6 = m3173a(context, a5);
                                String b3 = mo604b();
                                synchronized (Looper.getMainLooper()) {
                                    al alVar = new al(context);
                                    m3175a(alVar, adVar.m3033a(), a4, a3, m3176a(context, a4, b3, a6, alVar));
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    void m3186a(Context context) {
        List b = m3178b(context);
        if (b != null && b.size() != 0) {
            String a = mo603a(b);
            if (a != null && !bi_常量类.f6358b.equals(a)) {
                String c = m3179c();
                String a2 = m3172a(context, this.f2016a);
                int a3 = mo600a();
                String a4 = m3174a(m3180c(context), a2, c, a3, "ANR", a);
                if (a4 != null && !bi_常量类.f6358b.equals(a4)) {
                    String a5 = mo602a(a);
                    String a6 = m3173a(context, a4);
                    String b2 = mo604b();
                    synchronized (Looper.getMainLooper()) {
                        al alVar = new al(context);
                        m3175a(alVar, this.f2016a.m3033a(), a5, a3, m3176a(context, a5, b2, a6, alVar));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected void m3188a(ad adVar) {
        this.f2016a = adVar;
    }

    /* renamed from: b */
    private List<ad> m3178b(Context context) {
        List<ad> a;
        Throwable th;
        Throwable th2;
        Throwable th3;
        List<ad> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    a = new ao(context).m3099a();
                    try {
                    } catch (Throwable th22) {
                        th = th22;
                        list = a;
                        th3 = th;
                        try {
                            throw th3;
                        } catch (Throwable th32) {
                            th = th32;
                            a = list;
                            th22 = th;
                        }
                    }
                } catch (Throwable th4) {
                    th32 = th4;
                    throw th32;
                }
            }
        } catch (Throwable th322) {
            th = th322;
            a = null;
            th22 = th;
            th22.printStackTrace();
            return a;
        }
    }

    /* renamed from: a */
    private void m3175a(al alVar, String str, String str2, int i, boolean z) {
        an anVar = new an();
        anVar.m3091a(0);
        anVar.m3095b(str);
        anVar.m3092a(str2);
        alVar.m3088b(anVar, i);
    }

    /* renamed from: a */
    private String m3174a(String str, String str2, String str3, int i, String str4, String str5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str2).append(",").append("\"timestamp\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str5);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private String m3173a(Context context, String str) {
        String str2 = null;
        try {
            str2 = C0409y.m3507a(context, str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    /* renamed from: c */
    private String m3179c() {
        return bk.m3224a(new Date().getTime());
    }

    /* renamed from: a */
    protected String m3184a(Throwable th) {
        String str = null;
        try {
            str = bk.m3225a(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return str;
    }

    /* renamed from: b */
    private String m3177b(Throwable th) {
        return th.toString();
    }

    /* renamed from: a */
    private String m3172a(Context context, ad adVar) {
        return C0409y.m3504a(context, adVar);
    }

    /* renamed from: c */
    private String m3180c(Context context) {
        return C0407w.m3494e(context);
    }

    /* renamed from: a */
    private boolean m3176a(Context context, String str, String str2, String str3, al alVar) {
        Throwable th;
        Throwable th2;
        IOException e;
        bl blVar;
        OutputStream outputStream;
        Object obj;
        bl blVar2 = null;
        OutputStream outputStream2 = null;
        bl blVar3 = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(bg.f2036a);
            stringBuilder.append(str2);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                blVar3 = bl.m3249a(file, 1, 1, 20480);
                try {
                    blVar3.m3270a(mo601a(alVar));
                    if (blVar3.m3269a(str) != null) {
                        if (blVar2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        if (blVar3 == null || blVar3.m3271a()) {
                            return false;
                        }
                        try {
                            blVar3.close();
                            return false;
                        } catch (Throwable th4) {
                            th3 = th4;
                            th3.printStackTrace();
                            return false;
                        }
                    }
                    byte[] bytes = str3.getBytes("UTF-8");
                    C0368a b = blVar3.m3272b(str);
                    OutputStream a = b.m3229a(0);
                    try {
                        a.write(bytes);
                        b.m3230a();
                        blVar3.m3273b();
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable th22) {
                                th22.printStackTrace();
                            }
                        }
                        if (!(blVar3 == null || blVar3.m3271a())) {
                            try {
                                blVar3.close();
                            } catch (Throwable th222) {
                                th222.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e2) {
                        e = e2;
                        blVar = blVar3;
                        outputStream = a;
                        blVar2 = blVar;
                        try {
                            e.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th32) {
                                    th32.printStackTrace();
                                }
                            }
                            return blVar2 != null ? false : false;
                        } catch (Throwable th5) {
                            th222 = th5;
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th322) {
                                    th322.printStackTrace();
                                }
                            }
                            try {
                                blVar2.close();
                            } catch (Throwable th3222) {
                                th3222.printStackTrace();
                            }
                            throw th222;
                        }
                    } catch (Throwable th6) {
                        th222 = th6;
                        blVar = blVar3;
                        outputStream = a;
                        blVar2 = blVar;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        blVar2.close();
                        throw th222;
                    }
                } catch (IOException e3) {
                    e = e3;
                    blVar = blVar3;
                    obj = blVar2;
                    blVar2 = blVar;
                    e.printStackTrace();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (blVar2 != null) {
                    }
                } catch (Throwable th7) {
                    th222 = th7;
                    blVar = blVar3;
                    obj = blVar2;
                    blVar2 = blVar;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    blVar2.close();
                    throw th222;
                }
            }
            if (blVar2 != null) {
                try {
                    outputStream2.close();
                } catch (Throwable th32222) {
                    th32222.printStackTrace();
                }
            }
            if (blVar2 == null || blVar2.m3271a()) {
                return false;
            }
            try {
                blVar3.close();
                return false;
            } catch (Throwable th8) {
                th32222 = th8;
            }
        } catch (IOException e4) {
            e = e4;
            outputStream = blVar2;
            e.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            if (blVar2 != null && !blVar2.m3271a()) {
                try {
                    blVar2.close();
                    return false;
                } catch (Throwable th9) {
                    th32222 = th9;
                    th32222.printStackTrace();
                    return false;
                }
            }
        } catch (Throwable th10) {
            th222 = th10;
            outputStream = blVar2;
            if (outputStream != null) {
                outputStream.close();
            }
            if (!(blVar2 == null || blVar2.m3271a())) {
                blVar2.close();
            }
            throw th222;
        }
    }

    /* renamed from: a */
    protected boolean m3189a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String indexOf : strArr) {
                if (str.indexOf(indexOf) != -1) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
