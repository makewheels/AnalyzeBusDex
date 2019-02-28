package com.autonavi.tbt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DBOperation */
/* renamed from: com.autonavi.tbt.v */
public class C0636v {
    /* renamed from: a */
    private C0635u f3871a;
    /* renamed from: b */
    private SQLiteDatabase f3872b;

    public C0636v(Context context) {
        this.f3871a = new C0635u(context, "logdb.db", null, 1);
    }

    /* renamed from: a */
    private SQLiteDatabase m4965a() {
        this.f3872b = this.f3871a.getReadableDatabase();
        return this.f3872b;
    }

    /* renamed from: b */
    private SQLiteDatabase m4966b() {
        this.f3872b = this.f3871a.getWritableDatabase();
        return this.f3872b;
    }

    /* renamed from: a */
    public <T> void m4968a(String str, ac<T> acVar) {
        if (acVar.mo738a() != null && str != null) {
            if (this.f3872b == null || this.f3872b.isReadOnly()) {
                this.f3872b = m4966b();
            }
            if (this.f3872b != null) {
                try {
                    this.f3872b.delete(acVar.mo738a(), str, null);
                    if (this.f3872b != null) {
                        this.f3872b.close();
                        this.f3872b = null;
                    }
                } catch (Throwable th) {
                    if (this.f3872b != null) {
                        this.f3872b.close();
                        this.f3872b = null;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public <T> void m4969b(String str, ac<T> acVar) {
        if (acVar != null && str != null && acVar.mo738a() != null) {
            ContentValues b = acVar.mo739b();
            if (b != null) {
                if (this.f3872b == null || this.f3872b.isReadOnly()) {
                    this.f3872b = m4966b();
                }
                if (this.f3872b != null) {
                    try {
                        this.f3872b.update(acVar.mo738a(), b, str, null);
                        if (this.f3872b != null) {
                            this.f3872b.close();
                            this.f3872b = null;
                        }
                    } catch (Throwable th) {
                        if (this.f3872b != null) {
                            this.f3872b.close();
                            this.f3872b = null;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public <T> void m4967a(ac<T> acVar) {
        if (acVar != null) {
            ContentValues b = acVar.mo739b();
            if (b != null && acVar.mo738a() != null) {
                if (this.f3872b == null || this.f3872b.isReadOnly()) {
                    this.f3872b = m4966b();
                }
                if (this.f3872b != null) {
                    try {
                        this.f3872b.insert(acVar.mo738a(), null, b);
                        if (this.f3872b != null) {
                            this.f3872b.close();
                            this.f3872b = null;
                        }
                    } catch (Throwable th) {
                        if (this.f3872b != null) {
                            this.f3872b.close();
                            this.f3872b = null;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public <T> List<T> m4970c(String str, ac<T> acVar) {
        Throwable th;
        List<T> arrayList = new ArrayList();
        if (this.f3872b == null) {
            this.f3872b = m4965a();
        }
        if (this.f3872b == null || acVar.mo738a() == null || str == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = this.f3872b.query(acVar.mo738a(), null, str, null, null, null, null);
            if (query == null) {
                try {
                    this.f3872b.close();
                    this.f3872b = null;
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            ae.m4671a(th2, "DataBase", "searchListData");
                            th2.printStackTrace();
                        }
                    }
                    try {
                        if (this.f3872b != null) {
                            this.f3872b.close();
                            this.f3872b = null;
                        }
                    } catch (Throwable th22) {
                        ae.m4671a(th22, "DataBase", "searchListData");
                        th22.printStackTrace();
                    }
                    return arrayList;
                } catch (Throwable th3) {
                    th22 = th3;
                }
            } else {
                while (query.moveToNext()) {
                    arrayList.add(acVar.mo740b(query));
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Throwable th222) {
                        ae.m4671a(th222, "DataBase", "searchListData");
                        th222.printStackTrace();
                    }
                }
                try {
                    if (this.f3872b != null) {
                        this.f3872b.close();
                        this.f3872b = null;
                    }
                } catch (Throwable th4) {
                    th222 = th4;
                    ae.m4671a(th222, "DataBase", "searchListData");
                    th222.printStackTrace();
                    return arrayList;
                }
                return arrayList;
            }
        } catch (Throwable th5) {
            th222 = th5;
            query = null;
            if (query != null) {
                query.close();
            }
            if (this.f3872b != null) {
                this.f3872b.close();
                this.f3872b = null;
            }
            throw th222;
        }
    }
}
