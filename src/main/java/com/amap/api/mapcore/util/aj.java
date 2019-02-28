package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DBOperation */
public class aj {
    /* renamed from: a */
    private ai f1962a;
    /* renamed from: b */
    private SQLiteDatabase f1963b;

    public aj(Context context) {
        this.f1962a = new ai(context, "logdb.db", null, 1);
    }

    /* renamed from: a */
    private SQLiteDatabase m3074a() {
        this.f1963b = this.f1962a.getReadableDatabase();
        return this.f1963b;
    }

    /* renamed from: b */
    private SQLiteDatabase m3075b() {
        this.f1963b = this.f1962a.getWritableDatabase();
        return this.f1963b;
    }

    /* renamed from: a */
    public <T> void m3077a(String str, aq<T> aqVar) {
        if (aqVar.mo592a() != null && str != null) {
            if (this.f1963b == null || this.f1963b.isReadOnly()) {
                this.f1963b = m3075b();
            }
            if (this.f1963b != null) {
                try {
                    this.f1963b.delete(aqVar.mo592a(), str, null);
                    if (this.f1963b != null) {
                        this.f1963b.close();
                        this.f1963b = null;
                    }
                } catch (Throwable th) {
                    if (this.f1963b != null) {
                        this.f1963b.close();
                        this.f1963b = null;
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public <T> void m3078b(String str, aq<T> aqVar) {
        if (aqVar != null && str != null && aqVar.mo592a() != null) {
            ContentValues b = aqVar.mo590b();
            if (b != null) {
                if (this.f1963b == null || this.f1963b.isReadOnly()) {
                    this.f1963b = m3075b();
                }
                if (this.f1963b != null) {
                    try {
                        this.f1963b.update(aqVar.mo592a(), b, str, null);
                        if (this.f1963b != null) {
                            this.f1963b.close();
                            this.f1963b = null;
                        }
                    } catch (Throwable th) {
                        if (this.f1963b != null) {
                            this.f1963b.close();
                            this.f1963b = null;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public <T> void m3076a(aq<T> aqVar) {
        if (aqVar != null) {
            ContentValues b = aqVar.mo590b();
            if (b != null && aqVar.mo592a() != null) {
                if (this.f1963b == null || this.f1963b.isReadOnly()) {
                    this.f1963b = m3075b();
                }
                if (this.f1963b != null) {
                    try {
                        this.f1963b.insert(aqVar.mo592a(), null, b);
                        if (this.f1963b != null) {
                            this.f1963b.close();
                            this.f1963b = null;
                        }
                    } catch (Throwable th) {
                        if (this.f1963b != null) {
                            this.f1963b.close();
                            this.f1963b = null;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: c */
    public <T> List<T> m3079c(String str, aq<T> aqVar) {
        List<T> arrayList = new ArrayList();
        if (this.f1963b == null) {
            this.f1963b = m3074a();
        }
        if (this.f1963b == null || aqVar.mo592a() == null || str == null) {
            return arrayList;
        }
        try {
            Cursor query = this.f1963b.query(aqVar.mo592a(), null, str, null, null, null, null);
            if (query == null) {
                this.f1963b.close();
                this.f1963b = null;
                if (this.f1963b != null) {
                    this.f1963b.close();
                    this.f1963b = null;
                }
                return arrayList;
            }
            while (query.moveToNext()) {
                arrayList.add(aqVar.mo591b(query));
            }
            query.close();
            if (this.f1963b != null) {
                this.f1963b.close();
                this.f1963b = null;
            }
            return arrayList;
        } catch (Throwable th) {
            if (this.f1963b != null) {
                this.f1963b.close();
                this.f1963b = null;
            }
        }
    }
}
