package org.json.alipay;

import com.e4a.runtime.components.Component;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import p054u.aly.bi_常量类;

/* renamed from: org.json.alipay.c */
public final class C1273c {
    /* renamed from: a */
    private int f5721a;
    /* renamed from: b */
    private Reader f5722b;
    /* renamed from: c */
    private char f5723c;
    /* renamed from: d */
    private boolean f5724d;

    private C1273c(Reader reader) {
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader);
        }
        this.f5722b = reader;
        this.f5724d = false;
        this.f5721a = 0;
    }

    public C1273c(String str) {
        this(new StringReader(str));
    }

    /* renamed from: a */
    private String m8507a(int i) {
        int i2 = 0;
        if (i == 0) {
            return bi_常量类.f6358b_空串;
        }
        char[] cArr = new char[i];
        if (this.f5724d) {
            this.f5724d = false;
            cArr[0] = this.f5723c;
            i2 = 1;
        }
        while (i2 < i) {
            try {
                int read = this.f5722b.read(cArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            } catch (Throwable e) {
                throw new JSONException(e);
            }
        }
        this.f5721a += i2;
        if (i2 < i) {
            throw m8508a("Substring bounds error");
        }
        this.f5723c = cArr[i - 1];
        return new String(cArr);
    }

    /* renamed from: a */
    public final JSONException m8508a(String str) {
        return new JSONException(str + toString());
    }

    /* renamed from: a */
    public final void m8509a() {
        if (this.f5724d || this.f5721a <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f5721a--;
        this.f5724d = true;
    }

    /* renamed from: b */
    public final char m8510b() {
        if (this.f5724d) {
            this.f5724d = false;
            if (this.f5723c != '\u0000') {
                this.f5721a++;
            }
            return this.f5723c;
        }
        try {
            int read = this.f5722b.read();
            if (read <= 0) {
                this.f5723c = '\u0000';
                return '\u0000';
            }
            this.f5721a++;
            this.f5723c = (char) read;
            return this.f5723c;
        } catch (Throwable e) {
            throw new JSONException(e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public final char m8511c() {
        /*
        r5 = this;
        r4 = 13;
        r3 = 10;
        r0 = 47;
    L_0x0006:
        r1 = r5.m8510b();
        if (r1 != r0) goto L_0x003c;
    L_0x000c:
        r1 = r5.m8510b();
        switch(r1) {
            case 42: goto L_0x002f;
            case 47: goto L_0x0017;
            default: goto L_0x0013;
        };
    L_0x0013:
        r5.m8509a();
    L_0x0016:
        return r0;
    L_0x0017:
        r1 = r5.m8510b();
        if (r1 == r3) goto L_0x0006;
    L_0x001d:
        if (r1 == r4) goto L_0x0006;
    L_0x001f:
        if (r1 != 0) goto L_0x0017;
    L_0x0021:
        goto L_0x0006;
    L_0x0022:
        r2 = 42;
        if (r1 != r2) goto L_0x002f;
    L_0x0026:
        r1 = r5.m8510b();
        if (r1 == r0) goto L_0x0006;
    L_0x002c:
        r5.m8509a();
    L_0x002f:
        r1 = r5.m8510b();
        if (r1 != 0) goto L_0x0022;
    L_0x0035:
        r0 = "Unclosed comment";
        r0 = r5.m8508a(r0);
        throw r0;
    L_0x003c:
        r2 = 35;
        if (r1 != r2) goto L_0x004b;
    L_0x0040:
        r1 = r5.m8510b();
        if (r1 == r3) goto L_0x0006;
    L_0x0046:
        if (r1 == r4) goto L_0x0006;
    L_0x0048:
        if (r1 != 0) goto L_0x0040;
    L_0x004a:
        goto L_0x0006;
    L_0x004b:
        if (r1 == 0) goto L_0x0051;
    L_0x004d:
        r2 = 32;
        if (r1 <= r2) goto L_0x0006;
    L_0x0051:
        r0 = r1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.c.c():char");
    }

    /* renamed from: d */
    public final Object m8512d() {
        char c = m8511c();
        switch (c) {
            case Component.KEYCODE_F /*34*/:
            case Component.KEYCODE_K /*39*/:
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    char b = m8510b();
                    switch (b) {
                        case '\u0000':
                        case '\n':
                        case '\r':
                            throw m8508a("Unterminated string");
                        case '\\':
                            b = m8510b();
                            switch (b) {
                                case 'b':
                                    stringBuffer.append('\b');
                                    break;
                                case 'f':
                                    stringBuffer.append('\f');
                                    break;
                                case ErrorCode.NONEEDTODOWN_ERROR /*110*/:
                                    stringBuffer.append('\n');
                                    break;
                                case 'r':
                                    stringBuffer.append('\r');
                                    break;
                                case 't':
                                    stringBuffer.append('\t');
                                    break;
                                case 'u':
                                    stringBuffer.append((char) Integer.parseInt(m8507a(4), 16));
                                    break;
                                case ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR /*120*/:
                                    stringBuffer.append((char) Integer.parseInt(m8507a(2), 16));
                                    break;
                                default:
                                    stringBuffer.append(b);
                                    break;
                            }
                        default:
                            if (b != c) {
                                stringBuffer.append(b);
                                break;
                            }
                            return stringBuffer.toString();
                    }
                }
            case Component.KEYCODE_L /*40*/:
            case Component.KEYCODE_MUTE /*91*/:
                m8509a();
                return new C1270a(this);
            case '{':
                m8509a();
                return new C1272b(this);
            default:
                StringBuffer stringBuffer2 = new StringBuffer();
                char c2 = c;
                while (c2 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c2) < 0) {
                    stringBuffer2.append(c2);
                    c2 = m8510b();
                }
                m8509a();
                String trim = stringBuffer2.toString().trim();
                if (trim.equals(bi_常量类.f6358b_空串)) {
                    throw m8508a("Missing value");
                } else if (trim.equalsIgnoreCase("true")) {
                    return Boolean.TRUE;
                } else {
                    if (trim.equalsIgnoreCase("false")) {
                        return Boolean.FALSE;
                    }
                    if (trim.equalsIgnoreCase("null")) {
                        return C1272b.f5719a;
                    }
                    if ((c < '0' || c > '9') && c != '.' && c != '-' && c != '+') {
                        return trim;
                    }
                    if (c == '0') {
                        if (trim.length() <= 2 || !(trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) {
                            try {
                                return new Integer(Integer.parseInt(trim, 8));
                            } catch (Exception e) {
                            }
                        } else {
                            try {
                                return new Integer(Integer.parseInt(trim.substring(2), 16));
                            } catch (Exception e2) {
                            }
                        }
                    }
                    try {
                        return new Integer(trim);
                    } catch (Exception e3) {
                        try {
                            return new Long(trim);
                        } catch (Exception e4) {
                            try {
                                return new Double(trim);
                            } catch (Exception e5) {
                                return trim;
                            }
                        }
                    }
                }
        }
    }

    public final String toString() {
        return " at character " + this.f5721a;
    }
}
