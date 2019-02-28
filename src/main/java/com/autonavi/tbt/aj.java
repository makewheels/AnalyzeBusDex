package com.autonavi.tbt;

import android.content.Context;
import android.os.Looper;
import com.autonavi.tbt.al.C0604a;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import p054u.aly.bi_常量类;

/* compiled from: LogWriter */
abstract class aj {
    /* renamed from: a */
    private C0629p f3689a;

    /* renamed from: a */
    protected abstract int mo742a();

    /* renamed from: a */
    protected abstract ao mo743a(C0638x c0638x);

    /* renamed from: a */
    protected abstract String mo744a(String str);

    /* renamed from: b */
    protected abstract String mo745b();

    aj() {
    }

    /* renamed from: a */
    static aj m4676a(int i) {
        switch (i) {
            case 0:
                return new ag();
            case 1:
                return new ah();
            case 2:
                return new af();
            default:
                return null;
        }
    }

    /* renamed from: a */
    void m4690a(Context context, Throwable th, String str, String str2) {
        List<C0629p> a = m4680a(context);
        if (a != null && a.size() != 0) {
            String a2 = m4689a(th);
            if (a2 != null && !bi_常量类.f6358b_空串.equals(a2)) {
                for (C0629p c0629p : a) {
                    if (m4692a(c0629p.m4943f(), a2)) {
                        m4691a(c0629p);
                        String c = m4685c();
                        String a3 = m4677a(context, c0629p);
                        String b = m4683b(context);
                        String b2 = m4684b(th);
                        if (b2 != null && !bi_常量类.f6358b_空串.equals(b2)) {
                            int a4 = mo742a();
                            StringBuilder stringBuilder = new StringBuilder();
                            if (str != null) {
                                stringBuilder.append("class:").append(str);
                            }
                            if (str2 != null) {
                                stringBuilder.append(" method:").append(str2).append("$").append("<br/>");
                            }
                            stringBuilder.append(a2);
                            String a5 = mo744a(a2);
                            String a6 = m4679a(b, a3, c, a4, b2, stringBuilder.toString());
                            if (a6 != null && !bi_常量类.f6358b_空串.equals(a6)) {
                                String a7 = m4678a(context, a6);
                                String b3 = mo745b();
                                synchronized (Looper.getMainLooper()) {
                                    C0638x c0638x = new C0638x(context);
                                    m4681a(c0638x, c0629p.m4938a(), a5, a4, m4682a(context, a5, b3, a7, c0638x));
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
    protected void m4691a(C0629p c0629p) {
        this.f3689a = c0629p;
    }

    /* renamed from: a */
    private List<C0629p> m4680a(Context context) {
        List<C0629p> a;
        Throwable th;
        Throwable th2;
        Throwable th3;
        List<C0629p> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    a = new aa(context).m4656a();
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
    private void m4681a(C0638x c0638x, String str, String str2, int i, boolean z) {
        C0639z c0639z = new C0639z();
        c0639z.m4979a(0);
        c0639z.m4983b(str);
        c0639z.m4980a(str2);
        c0638x.m4976a(c0639z, i);
    }

    /* renamed from: a */
    private String m4679a(String str, String str2, String str3, int i, String str4, String str5) {
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
    private String m4678a(Context context, String str) {
        String str2 = null;
        try {
            str2 = C0621k.m4878a(context, str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    /* renamed from: c */
    private String m4685c() {
        return ak.m4709a(new Date().getTime());
    }

    /* renamed from: a */
    protected String m4689a(Throwable th) {
        String str = null;
        try {
            str = ak.m4710a(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return str;
    }

    /* renamed from: b */
    private String m4684b(Throwable th) {
        return th.toString();
    }

    /* renamed from: a */
    private String m4677a(Context context, C0629p c0629p) {
        return C0621k.m4875a(context, c0629p);
    }

    /* renamed from: b */
    private String m4683b(Context context) {
        return C0619i.m4866e(context);
    }

    /* renamed from: a */
    private boolean m4682a(Context context, String str, String str2, String str3, C0638x c0638x) {
        Throwable th;
        Throwable th2;
        IOException e;
        al alVar;
        OutputStream outputStream;
        Object obj;
        al alVar2 = null;
        OutputStream outputStream2 = null;
        al alVar3 = null;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getAbsolutePath());
            stringBuilder.append(ai.f3706a);
            stringBuilder.append(str2);
            File file = new File(stringBuilder.toString());
            if (file.exists() || file.mkdirs()) {
                alVar3 = al.m4733a(file, 1, 1, 20480);
                try {
                    alVar3.m4754a(mo743a(c0638x));
                    if (alVar3.m4753a(str) != null) {
                        if (alVar2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        if (alVar3 == null || alVar3.m4755a()) {
                            return false;
                        }
                        try {
                            alVar3.close();
                            return false;
                        } catch (Throwable th4) {
                            th3 = th4;
                            th3.printStackTrace();
                            return false;
                        }
                    }
                    byte[] bytes = str3.getBytes("UTF-8");
                    C0604a b = alVar3.m4756b(str);
                    OutputStream a = b.m4714a(0);
                    try {
                        a.write(bytes);
                        b.m4715a();
                        alVar3.m4757b();
                        if (a != null) {
                            try {
                                a.close();
                            } catch (Throwable th22) {
                                th22.printStackTrace();
                            }
                        }
                        if (!(alVar3 == null || alVar3.m4755a())) {
                            try {
                                alVar3.close();
                            } catch (Throwable th222) {
                                th222.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e2) {
                        e = e2;
                        alVar = alVar3;
                        outputStream = a;
                        alVar2 = alVar;
                        try {
                            e.printStackTrace();
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Throwable th32) {
                                    th32.printStackTrace();
                                }
                            }
                            return alVar2 != null ? false : false;
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
                                alVar2.close();
                            } catch (Throwable th3222) {
                                th3222.printStackTrace();
                            }
                            throw th222;
                        }
                    } catch (Throwable th6) {
                        th222 = th6;
                        alVar = alVar3;
                        outputStream = a;
                        alVar2 = alVar;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        alVar2.close();
                        throw th222;
                    }
                } catch (IOException e3) {
                    e = e3;
                    alVar = alVar3;
                    obj = alVar2;
                    alVar2 = alVar;
                    e.printStackTrace();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (alVar2 != null) {
                    }
                } catch (Throwable th7) {
                    th222 = th7;
                    alVar = alVar3;
                    obj = alVar2;
                    alVar2 = alVar;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    alVar2.close();
                    throw th222;
                }
            }
            if (alVar2 != null) {
                try {
                    outputStream2.close();
                } catch (Throwable th32222) {
                    th32222.printStackTrace();
                }
            }
            if (alVar2 == null || alVar2.m4755a()) {
                return false;
            }
            try {
                alVar3.close();
                return false;
            } catch (Throwable th8) {
                th32222 = th8;
            }
        } catch (IOException e4) {
            e = e4;
            outputStream = alVar2;
            e.printStackTrace();
            if (outputStream != null) {
                outputStream.close();
            }
            if (alVar2 != null && !alVar2.m4755a()) {
                try {
                    alVar2.close();
                    return false;
                } catch (Throwable th9) {
                    th32222 = th9;
                    th32222.printStackTrace();
                    return false;
                }
            }
        } catch (Throwable th10) {
            th222 = th10;
            outputStream = alVar2;
            if (outputStream != null) {
                outputStream.close();
            }
            if (!(alVar2 == null || alVar2.m4755a())) {
                alVar2.close();
            }
            throw th222;
        }
    }

    /* renamed from: a */
    protected boolean m4692a(String[] strArr, String str) {
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
