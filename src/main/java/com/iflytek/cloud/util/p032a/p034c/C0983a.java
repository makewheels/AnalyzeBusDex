package com.iflytek.cloud.util.p032a.p034c;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog.Calls;
import com.alipay.sdk.cons.C0110c;
import com.iflytek.cloud.p023b.p024e.C0944c;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.util.p032a.C0989e;
import com.iflytek.cloud.util.p032a.p033a.C0978a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.iflytek.cloud.util.a.c.a */
public abstract class C0983a {
    /* renamed from: a */
    protected static final String[] f4628a = new String[]{"number", C0110c.f289e, "date"};
    /* renamed from: c */
    protected static String[] f4629c;
    /* renamed from: b */
    protected Context f4630b = null;

    public C0983a(Context context) {
        this.f4630b = context;
    }

    /* renamed from: a */
    public abstract Uri mo1612a();

    /* renamed from: a */
    public HashMap<String, String> m7315a(int i) {
        Exception e;
        Throwable th;
        String str = "date DESC limit " + i;
        HashMap<String, String> hashMap = new HashMap();
        Cursor query;
        try {
            query = this.f4630b.getContentResolver().query(Calls.CONTENT_URI, f4628a, "0==0) GROUP BY (number", null, str);
            if (query == null) {
                try {
                    C0939a.m7121a("iFly_ContactManager", "queryCallLog ----------------cursor is null");
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (query.getCount() == 0) {
                C0939a.m7121a("iFly_ContactManager", "queryCallLog ----------------cursor getCount == 0");
            } else {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("number"));
                    Object string2 = query.getString(query.getColumnIndex(C0110c.f289e));
                    String string3 = query.getString(query.getColumnIndex("date"));
                    if (string2 == null) {
                        string2 = C0989e.m7340a(string);
                    }
                    hashMap.put(string3, string2);
                }
                C0939a.m7121a("iFly_ContactManager", "queryCallLog ----------------cursor getCount ==" + query.getCount());
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            try {
                e.printStackTrace();
                if (query != null) {
                    query.close();
                }
                return hashMap;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return hashMap;
    }

    /* renamed from: a */
    protected void m7316a(Context context) {
        f4629c = new String[100];
        f4629c[0] = "其他";
        f4629c[1] = "住宅";
        f4629c[2] = "手机";
        f4629c[3] = "工作";
        f4629c[4] = "工作传真";
        f4629c[5] = "住宅传真";
        f4629c[6] = "寻呼机";
        f4629c[7] = "其他";
        f4629c[9] = "SIM卡";
        for (int i = 10; i < f4629c.length; i++) {
            f4629c[i] = "自定义电话";
        }
    }

    /* renamed from: b */
    protected abstract String[] mo1613b();

    /* renamed from: c */
    protected abstract String mo1614c();

    /* renamed from: d */
    public HashMap<String, String> m7319d() {
        Exception e;
        Throwable th;
        String[] b = mo1613b();
        HashMap<String, String> hashMap = new HashMap();
        Cursor query;
        try {
            query = this.f4630b.getContentResolver().query(mo1612a(), b, null, null, mo1614c());
            if (query == null) {
                try {
                    C0939a.m7121a("iFly_ContactManager", "queryContacts------cursor is null");
                } catch (Exception e2) {
                    e = e2;
                }
            } else if (query.getCount() == 0) {
                C0939a.m7121a("iFly_ContactManager", "queryContacts------cursor getCount == 0");
            } else {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex(b[0]));
                    String string2 = query.getString(query.getColumnIndex(b[1]));
                    if (string != null) {
                        hashMap.put(string2, string);
                    }
                }
                C0939a.m7121a("iFly_ContactManager", "queryContacts_20------count = " + query.getCount());
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            try {
                e.printStackTrace();
                if (query != null) {
                    query.close();
                }
                return hashMap;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return hashMap;
    }

    /* renamed from: e */
    public List<C0978a> m7320e() {
        Exception e;
        Cursor cursor;
        Throwable th;
        List<C0978a> arrayList = new ArrayList();
        Cursor query;
        try {
            query = this.f4630b.getContentResolver().query(Uri.parse("content://icc/adn"), null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        while (query.moveToNext()) {
                            String string = query.getString(query.getColumnIndex(C0110c.f289e));
                            String string2 = query.getString(query.getColumnIndex("_id"));
                            String a = C0944c.m7135a(C0989e.m7340a(query.getString(query.getColumnIndex("number"))));
                            if (string != null) {
                                arrayList.add(new C0978a(string2, string, null, a, null, f4629c[9]));
                            }
                        }
                        C0939a.m7121a("iFly_ContactManager", "querySIM-------count = " + query.getCount());
                        if (query != null) {
                            query.close();
                        }
                        return arrayList;
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            C0939a.m7121a("iFly_ContactManager", "querySIM-------cursor getCount = 0 or cursor is null");
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* renamed from: f */
    public Uri m7321f() {
        return Calls.CONTENT_URI;
    }
}
