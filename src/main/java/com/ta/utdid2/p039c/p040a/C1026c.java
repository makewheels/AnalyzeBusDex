package com.ta.utdid2.p039c.p040a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.ta.utdid2.p037b.p038a.C1020h;
import com.ta.utdid2.p039c.p040a.C1025b.C1023a;
import java.io.File;
import java.util.Map.Entry;
import p054u.aly.bi_常量类;

/* compiled from: PersistentConfiguration */
/* renamed from: com.ta.utdid2.c.a.c */
public final class C1026c {
    /* renamed from: a */
    private String f4714a;
    /* renamed from: b */
    private String f4715b;
    /* renamed from: c */
    private boolean f4716c;
    /* renamed from: d */
    private boolean f4717d;
    /* renamed from: e */
    private boolean f4718e;
    /* renamed from: f */
    private SharedPreferences f4719f;
    /* renamed from: g */
    private C1025b f4720g;
    /* renamed from: h */
    private Editor f4721h;
    /* renamed from: i */
    private C1023a f4722i;
    /* renamed from: j */
    private Context f4723j;
    /* renamed from: k */
    private C1029d f4724k;
    /* renamed from: l */
    private boolean f4725l;

    public C1026c(Context context, String str, String str2) {
        long j;
        long a;
        long j2;
        Editor edit;
        C1023a c;
        this.f4714a = bi_常量类.f6358b_空串;
        this.f4715b = bi_常量类.f6358b_空串;
        this.f4716c = false;
        this.f4717d = false;
        this.f4718e = false;
        this.f4719f = null;
        this.f4720g = null;
        this.f4721h = null;
        this.f4722i = null;
        this.f4723j = null;
        this.f4724k = null;
        this.f4725l = false;
        this.f4716c = false;
        this.f4725l = true;
        this.f4714a = str2;
        this.f4715b = str;
        this.f4723j = context;
        if (context != null) {
            this.f4719f = context.getSharedPreferences(str2, 0);
            j = this.f4719f.getLong("t", 0);
        } else {
            j = 0;
        }
        String b = C1026c.m7407b();
        if (!C1020h.m7383a(b)) {
            if (b.equals("mounted")) {
                this.f4718e = true;
                this.f4717d = true;
            } else if (b.equals("mounted_ro")) {
                this.f4717d = true;
                this.f4718e = false;
            }
            if (!((!this.f4717d && !this.f4718e) || context == null || C1020h.m7383a(str))) {
                this.f4724k = m7406b(str);
                if (this.f4724k != null) {
                    try {
                        this.f4720g = this.f4724k.m7436a(str2);
                        a = this.f4720g.mo1699a("t");
                        try {
                            j2 = this.f4719f.getLong("t2", 0);
                        } catch (Exception e) {
                            long j3 = a;
                            a = j;
                            j = j3;
                            j2 = a;
                            if (j2 == j) {
                            }
                            a = System.currentTimeMillis();
                            if (this.f4725l) {
                            }
                            if (this.f4719f != null) {
                                edit = this.f4719f.edit();
                                edit.putLong("t2", a);
                                edit.commit();
                            }
                            if (this.f4720g == null) {
                                c = this.f4720g.mo1703c();
                                c.mo1695a("t2", a);
                                c.mo1698b();
                            }
                        }
                        try {
                            j = this.f4720g.mo1699a("t2");
                            if (j2 >= j && j2 > 0) {
                                try {
                                    C1026c.m7404a(this.f4719f, this.f4720g);
                                    this.f4720g = this.f4724k.m7436a(str2);
                                } catch (Exception e2) {
                                    a = j2;
                                    j2 = a;
                                    if (j2 == j) {
                                    }
                                    a = System.currentTimeMillis();
                                    if (this.f4725l) {
                                    }
                                    if (this.f4719f != null) {
                                        edit = this.f4719f.edit();
                                        edit.putLong("t2", a);
                                        edit.commit();
                                    }
                                    if (this.f4720g == null) {
                                        c = this.f4720g.mo1703c();
                                        c.mo1695a("t2", a);
                                        c.mo1698b();
                                    }
                                }
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.f4725l) {
                                }
                                if (this.f4719f != null) {
                                    edit = this.f4719f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.f4720g == null) {
                                    c = this.f4720g.mo1703c();
                                    c.mo1695a("t2", a);
                                    c.mo1698b();
                                }
                            } else if (j2 <= j && j > 0) {
                                C1026c.m7405a(this.f4720g, this.f4719f);
                                this.f4719f = context.getSharedPreferences(str2, 0);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.f4725l) {
                                }
                                if (this.f4719f != null) {
                                    edit = this.f4719f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.f4720g == null) {
                                    c = this.f4720g.mo1703c();
                                    c.mo1695a("t2", a);
                                    c.mo1698b();
                                }
                            } else if (j2 != 0 && j > 0) {
                                C1026c.m7405a(this.f4720g, this.f4719f);
                                this.f4719f = context.getSharedPreferences(str2, 0);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.f4725l) {
                                }
                                if (this.f4719f != null) {
                                    edit = this.f4719f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.f4720g == null) {
                                    c = this.f4720g.mo1703c();
                                    c.mo1695a("t2", a);
                                    c.mo1698b();
                                }
                            } else if (j == 0 || j2 <= 0) {
                                if (j2 == j) {
                                    C1026c.m7404a(this.f4719f, this.f4720g);
                                    this.f4720g = this.f4724k.m7436a(str2);
                                }
                                if (j2 == j || (j2 == 0 && j == 0)) {
                                    a = System.currentTimeMillis();
                                    if (this.f4725l || (this.f4725l && j2 == 0 && j == 0)) {
                                        if (this.f4719f != null) {
                                            edit = this.f4719f.edit();
                                            edit.putLong("t2", a);
                                            edit.commit();
                                        }
                                        if (this.f4720g == null) {
                                            c = this.f4720g.mo1703c();
                                            c.mo1695a("t2", a);
                                            c.mo1698b();
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else {
                                C1026c.m7404a(this.f4719f, this.f4720g);
                                this.f4720g = this.f4724k.m7436a(str2);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.f4725l) {
                                }
                                if (this.f4719f != null) {
                                    edit = this.f4719f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.f4720g == null) {
                                    c = this.f4720g.mo1703c();
                                    c.mo1695a("t2", a);
                                    c.mo1698b();
                                }
                            }
                        } catch (Exception e3) {
                            j = a;
                            a = j2;
                            j2 = a;
                            if (j2 == j) {
                            }
                            a = System.currentTimeMillis();
                            if (this.f4725l) {
                            }
                            if (this.f4719f != null) {
                                edit = this.f4719f.edit();
                                edit.putLong("t2", a);
                                edit.commit();
                            }
                            if (this.f4720g == null) {
                                c = this.f4720g.mo1703c();
                                c.mo1695a("t2", a);
                                c.mo1698b();
                            }
                        }
                    } catch (Exception e4) {
                        a = j;
                        j = 0;
                        j2 = a;
                        if (j2 == j) {
                        }
                        a = System.currentTimeMillis();
                        if (this.f4725l) {
                        }
                        if (this.f4719f != null) {
                            edit = this.f4719f.edit();
                            edit.putLong("t2", a);
                            edit.commit();
                        }
                        if (this.f4720g == null) {
                            c = this.f4720g.mo1703c();
                            c.mo1695a("t2", a);
                            c.mo1698b();
                        }
                    }
                }
            }
            j2 = j;
            j = 0;
            if (j2 == j) {
            }
            a = System.currentTimeMillis();
            if (this.f4725l) {
            }
            if (this.f4719f != null) {
                edit = this.f4719f.edit();
                edit.putLong("t2", a);
                edit.commit();
            }
            if (this.f4720g == null) {
                c = this.f4720g.mo1703c();
                c.mo1695a("t2", a);
                c.mo1698b();
            }
        }
        this.f4718e = false;
        this.f4717d = false;
        this.f4724k = m7406b(str);
        if (this.f4724k != null) {
            this.f4720g = this.f4724k.m7436a(str2);
            a = this.f4720g.mo1699a("t");
            j2 = this.f4719f.getLong("t2", 0);
            j = this.f4720g.mo1699a("t2");
            if (j2 >= j) {
            }
            if (j2 <= j) {
            }
            if (j2 != 0) {
            }
            if (j == 0) {
            }
            if (j2 == j) {
                C1026c.m7404a(this.f4719f, this.f4720g);
                this.f4720g = this.f4724k.m7436a(str2);
            }
            if (j2 == j) {
            }
            a = System.currentTimeMillis();
            if (this.f4725l) {
            }
            if (this.f4719f != null) {
                edit = this.f4719f.edit();
                edit.putLong("t2", a);
                edit.commit();
            }
            if (this.f4720g == null) {
                c = this.f4720g.mo1703c();
                c.mo1695a("t2", a);
                c.mo1698b();
            }
        }
        j2 = j;
        j = 0;
        if (j2 == j) {
        }
        a = System.currentTimeMillis();
        if (this.f4725l) {
        }
        if (this.f4719f != null) {
            edit = this.f4719f.edit();
            edit.putLong("t2", a);
            edit.commit();
        }
        try {
            if (this.f4720g == null) {
                c = this.f4720g.mo1703c();
                c.mo1695a("t2", a);
                c.mo1698b();
            }
        } catch (Exception e5) {
        }
    }

    /* renamed from: b */
    private static String m7407b() {
        String str = bi_常量类.f6358b_空串;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException e) {
        }
        return str;
    }

    /* renamed from: b */
    private C1029d m7406b(String str) {
        File file;
        if (Environment.getExternalStorageDirectory() != null) {
            file = new File(String.format("%s%s%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), File.separator, str}));
            if (!file.exists()) {
                file.mkdirs();
            }
        } else {
            file = null;
        }
        if (file == null) {
            return null;
        }
        this.f4724k = new C1029d(file.getAbsolutePath());
        return this.f4724k;
    }

    /* renamed from: a */
    private static void m7404a(SharedPreferences sharedPreferences, C1025b c1025b) {
        if (sharedPreferences != null && c1025b != null) {
            C1023a c = c1025b.mo1703c();
            if (c != null) {
                c.mo1692a();
                for (Entry entry : sharedPreferences.getAll().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        c.mo1696a(str, (String) value);
                    } else if (value instanceof Integer) {
                        c.mo1694a(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        c.mo1695a(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        c.mo1693a(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        c.mo1697a(str, ((Boolean) value).booleanValue());
                    }
                }
                c.mo1698b();
            }
        }
    }

    /* renamed from: a */
    private static void m7405a(C1025b c1025b, SharedPreferences sharedPreferences) {
        if (c1025b != null && sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.clear();
                for (Entry entry : c1025b.mo1702b().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        edit.putString(str, (String) value);
                    } else if (value instanceof Integer) {
                        edit.putInt(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) value).booleanValue());
                    }
                }
                edit.commit();
            }
        }
    }

    /* renamed from: c */
    private boolean m7408c() {
        if (this.f4720g == null) {
            return false;
        }
        boolean a = this.f4720g.mo1701a();
        if (a) {
            return a;
        }
        m7411a();
        return a;
    }

    /* renamed from: a */
    public final void m7410a(String str, String str2) {
        if (!C1020h.m7383a(str) && !str.equals("t")) {
            if (this.f4721h == null && this.f4719f != null) {
                this.f4721h = this.f4719f.edit();
            }
            if (this.f4718e && this.f4722i == null && this.f4720g != null) {
                this.f4722i = this.f4720g.mo1703c();
            }
            m7408c();
            if (this.f4721h != null) {
                this.f4721h.putString(str, str2);
            }
            if (this.f4722i != null) {
                this.f4722i.mo1696a(str, str2);
            }
        }
    }

    /* renamed from: a */
    public final boolean m7411a() {
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f4721h != null) {
            if (!(this.f4725l || this.f4719f == null)) {
                this.f4721h.putLong("t", currentTimeMillis);
            }
            if (!this.f4721h.commit()) {
                z = false;
            }
        }
        if (!(this.f4719f == null || this.f4723j == null)) {
            this.f4719f = this.f4723j.getSharedPreferences(this.f4714a, 0);
        }
        String b = C1026c.m7407b();
        if (!C1020h.m7383a(b)) {
            if (b.equals("mounted")) {
                if (this.f4720g == null) {
                    C1029d b2 = m7406b(this.f4715b);
                    if (b2 != null) {
                        this.f4720g = b2.m7436a(this.f4714a);
                        if (this.f4725l) {
                            C1026c.m7405a(this.f4720g, this.f4719f);
                        } else {
                            C1026c.m7404a(this.f4719f, this.f4720g);
                        }
                        this.f4722i = this.f4720g.mo1703c();
                    }
                } else if (!(this.f4722i == null || this.f4722i.mo1698b())) {
                    z = false;
                }
            }
            if (b.equals("mounted") || (b.equals("mounted_ro") && this.f4720g != null)) {
                try {
                    if (this.f4724k != null) {
                        this.f4720g = this.f4724k.m7436a(this.f4714a);
                    }
                } catch (Exception e) {
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public final String m7409a(String str) {
        m7408c();
        if (this.f4719f != null) {
            String string = this.f4719f.getString(str, bi_常量类.f6358b_空串);
            if (!C1020h.m7383a(string)) {
                return string;
            }
        }
        if (this.f4720g != null) {
            return this.f4720g.mo1700a(str, bi_常量类.f6358b_空串);
        }
        return bi_常量类.f6358b_空串;
    }
}
