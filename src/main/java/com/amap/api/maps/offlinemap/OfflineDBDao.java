package com.amap.api.maps.offlinemap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class OfflineDBDao {
    /* renamed from: a */
    private static OfflineDBDao f2409a = null;
    /* renamed from: b */
    private C0426e f2410b = null;

    private OfflineDBDao(Context context) {
        this.f2410b = C0426e.m3676a(context);
    }

    public static OfflineDBDao getInstance(Context context) {
        if (f2409a == null) {
            f2409a = new OfflineDBDao(context);
        }
        return f2409a;
    }

    /* renamed from: a */
    synchronized ArrayList<C0436o> m3592a() {
        ArrayList<C0436o> arrayList;
        SQLiteDatabase sQLiteDatabase;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th;
        arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase3 = null;
        Cursor query;
        try {
            sQLiteDatabase3 = this.f2410b.getWritableDatabase();
            try {
                query = sQLiteDatabase3.query("update_item", new String[]{"title", "url", "mAdcode", "fileName", "version", "lLocalLength", "lRemoteLength", "localPath", "mIndex", "isProvince", "mCompleteCode", "mCityCode", "mState"}, null, null, null, null, null);
                while (query.moveToNext()) {
                    try {
                        C0436o c0436o = new C0436o();
                        String string = query.getString(query.getColumnIndex("title"));
                        String string2 = query.getString(query.getColumnIndex("url"));
                        String string3 = query.getString(query.getColumnIndex("mAdcode"));
                        String string4 = query.getString(query.getColumnIndex("fileName"));
                        String string5 = query.getString(query.getColumnIndex("version"));
                        long j = query.getLong(query.getColumnIndex("lLocalLength"));
                        long j2 = query.getLong(query.getColumnIndex("lRemoteLength"));
                        String string6 = query.getString(query.getColumnIndex("localPath"));
                        int i = query.getInt(query.getColumnIndex("mIndex"));
                        boolean z = query.getInt(query.getColumnIndex("isProvince")) == 1;
                        int i2 = query.getInt(query.getColumnIndex("mCompleteCode"));
                        String string7 = query.getString(query.getColumnIndex("mCityCode"));
                        int i3 = query.getInt(query.getColumnIndex("mState"));
                        c0436o.m3723a(string);
                        c0436o.m3734e(string2);
                        c0436o.m3732d(string3);
                        c0436o.m3730c(string4);
                        c0436o.m3728b(string5);
                        c0436o.m3722a(j);
                        c0436o.m3727b(j2);
                        c0436o.m3738g(string6);
                        c0436o.m3721a(i);
                        c0436o.m3724a(z);
                        c0436o.m3726b(i2);
                        c0436o.m3740h(string7);
                        c0436o.f2504a = i3;
                        arrayList.add(c0436o);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        sQLiteDatabase2 = sQLiteDatabase3;
                        th = th3;
                    }
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (sQLiteDatabase3 != null) {
                    try {
                        sQLiteDatabase3.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Throwable th4) {
                sQLiteDatabase2 = sQLiteDatabase3;
                th = th4;
                query = null;
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (sQLiteDatabase2 != null) {
                    try {
                        sQLiteDatabase2.close();
                    } catch (Exception e32) {
                        e32.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th42) {
            sQLiteDatabase2 = sQLiteDatabase3;
            th = th42;
            query = null;
            if (query != null) {
                query.close();
            }
            if (sQLiteDatabase2 != null) {
                sQLiteDatabase2.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* renamed from: a */
    synchronized void m3593a(C0436o c0436o) {
        SQLiteDatabase writableDatabase;
        SQLException e;
        String[] split;
        Throwable th;
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (this) {
            String k;
            ContentValues contentValues;
            if (m3595a(c0436o.m3733e())) {
                m3597b(c0436o);
            } else {
                try {
                    writableDatabase = this.f2410b.getWritableDatabase();
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("title", c0436o.m3725b());
                        contentValues2.put("url", c0436o.m3735f());
                        contentValues2.put("mAdcode", c0436o.m3733e());
                        contentValues2.put("fileName", c0436o.m3731d());
                        contentValues2.put("version", c0436o.m3729c());
                        contentValues2.put("lLocalLength", Long.valueOf(c0436o.m3741i()));
                        contentValues2.put("lRemoteLength", Long.valueOf(c0436o.m3743j()));
                        contentValues2.put("localPath", c0436o.m3745l());
                        contentValues2.put("mIndex", Integer.valueOf(c0436o.m3739h()));
                        contentValues2.put("isProvince", Integer.valueOf(c0436o.m3746m() ? 1 : 0));
                        contentValues2.put("mCompleteCode", Integer.valueOf(c0436o.m3747n()));
                        contentValues2.put("mCityCode", c0436o.m3748o());
                        contentValues2.put("mState", Integer.valueOf(c0436o.f2504a));
                        writableDatabase.insert("update_item", null, contentValues2);
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (SQLException e3) {
                        e = e3;
                        try {
                            e.printStackTrace();
                            if (writableDatabase != null) {
                                try {
                                    writableDatabase.close();
                                } catch (Exception e22) {
                                    e22.printStackTrace();
                                }
                            }
                            k = c0436o.m3744k();
                            if (m3598b(c0436o.m3733e())) {
                                m3591j(c0436o.m3733e());
                            }
                            try {
                                split = k.split(";");
                                sQLiteDatabase = this.f2410b.getWritableDatabase();
                                sQLiteDatabase.beginTransaction();
                                for (String str : split) {
                                    contentValues = new ContentValues();
                                    contentValues.put("mAdcode", c0436o.m3733e());
                                    contentValues.put("file", str);
                                    sQLiteDatabase.insert("update_item_file", null, contentValues);
                                }
                                sQLiteDatabase.setTransactionSuccessful();
                                try {
                                    sQLiteDatabase.endTransaction();
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                } catch (Exception e222) {
                                    e222.printStackTrace();
                                }
                            } catch (SQLException e4) {
                                e4.printStackTrace();
                                try {
                                    sQLiteDatabase.endTransaction();
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                } catch (Exception e2222) {
                                    e2222.printStackTrace();
                                }
                            } catch (Throwable th2) {
                                try {
                                    sQLiteDatabase.endTransaction();
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (writableDatabase != null) {
                                try {
                                    writableDatabase.close();
                                } catch (Exception e52) {
                                    e52.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (SQLException e6) {
                    e4 = e6;
                    writableDatabase = null;
                    e4.printStackTrace();
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    k = c0436o.m3744k();
                    if (m3598b(c0436o.m3733e())) {
                        m3591j(c0436o.m3733e());
                    }
                    split = k.split(";");
                    sQLiteDatabase = this.f2410b.getWritableDatabase();
                    sQLiteDatabase.beginTransaction();
                    for (String str2 : split) {
                        contentValues = new ContentValues();
                        contentValues.put("mAdcode", c0436o.m3733e());
                        contentValues.put("file", str2);
                        sQLiteDatabase.insert("update_item_file", null, contentValues);
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    writableDatabase = null;
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    throw th;
                }
            }
            k = c0436o.m3744k();
            if (k != null && k.length() > 0) {
                if (m3598b(c0436o.m3733e())) {
                    m3591j(c0436o.m3733e());
                }
                split = k.split(";");
                sQLiteDatabase = this.f2410b.getWritableDatabase();
                sQLiteDatabase.beginTransaction();
                for (String str22 : split) {
                    contentValues = new ContentValues();
                    contentValues.put("mAdcode", c0436o.m3733e());
                    contentValues.put("file", str22);
                    sQLiteDatabase.insert("update_item_file", null, contentValues);
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
            }
        }
    }

    /* renamed from: a */
    synchronized boolean m3595a(String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Exception exception;
        boolean z;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th2;
        Cursor cursor2 = null;
        synchronized (this) {
            try {
                Cursor query;
                SQLiteDatabase writableDatabase = this.f2410b.getWritableDatabase();
                try {
                    query = writableDatabase.query("update_item", new String[]{"title"}, "mAdcode = ?", new String[]{str}, null, null, null);
                } catch (Exception e) {
                    Exception exception2 = e;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    exception = exception2;
                    try {
                        exception.printStackTrace();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception exception3) {
                                exception3.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.close();
                            } catch (Exception exception32) {
                                exception32.printStackTrace();
                            }
                        }
                        z = false;
                        return z;
                    } catch (Throwable th3) {
                        th = th3;
                        Cursor cursor3 = cursor;
                        sQLiteDatabase2 = sQLiteDatabase;
                        cursor2 = cursor3;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase2 != null) {
                            try {
                                sQLiteDatabase2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
                try {
                    if (query.moveToFirst()) {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e32) {
                                e32.printStackTrace();
                            }
                        }
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.close();
                            } catch (Exception exception322) {
                                exception322.printStackTrace();
                            }
                        }
                        z = true;
                    } else {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e322) {
                                e322.printStackTrace();
                            }
                        }
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.close();
                            } catch (Exception exception3222) {
                                exception3222.printStackTrace();
                            }
                        }
                        z = false;
                    }
                } catch (Exception e3222) {
                    sQLiteDatabase = writableDatabase;
                    exception3222 = e3222;
                    cursor = query;
                    exception3222.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    z = false;
                    return z;
                } catch (Throwable th42) {
                    cursor2 = query;
                    th2 = th42;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                exception3222 = e4;
                cursor = null;
                exception3222.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                z = false;
                return z;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase2 = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                throw th;
            }
        }
        return z;
    }

    /* renamed from: b */
    synchronized boolean m3598b(String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Exception exception;
        boolean z;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th2;
        Cursor cursor2 = null;
        synchronized (this) {
            try {
                Cursor query;
                SQLiteDatabase writableDatabase = this.f2410b.getWritableDatabase();
                try {
                    query = writableDatabase.query("update_item_file", new String[]{"file"}, "mAdcode = ?", new String[]{str}, null, null, null);
                } catch (Exception e) {
                    Exception exception2 = e;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    exception = exception2;
                    try {
                        exception.printStackTrace();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception exception3) {
                                exception3.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.close();
                            } catch (Exception exception32) {
                                exception32.printStackTrace();
                            }
                        }
                        z = false;
                        return z;
                    } catch (Throwable th3) {
                        th = th3;
                        Cursor cursor3 = cursor;
                        sQLiteDatabase2 = sQLiteDatabase;
                        cursor2 = cursor3;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase2 != null) {
                            try {
                                sQLiteDatabase2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
                try {
                    if (query.moveToFirst()) {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e32) {
                                e32.printStackTrace();
                            }
                        }
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.close();
                            } catch (Exception exception322) {
                                exception322.printStackTrace();
                            }
                        }
                        z = true;
                    } else {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e322) {
                                e322.printStackTrace();
                            }
                        }
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.close();
                            } catch (Exception exception3222) {
                                exception3222.printStackTrace();
                            }
                        }
                        z = false;
                    }
                } catch (Exception e3222) {
                    sQLiteDatabase = writableDatabase;
                    exception3222 = e3222;
                    cursor = query;
                    exception3222.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    z = false;
                    return z;
                } catch (Throwable th42) {
                    cursor2 = query;
                    th2 = th42;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                exception3222 = e4;
                cursor = null;
                exception3222.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                z = false;
                return z;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase2 = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                throw th;
            }
        }
        return z;
    }

    /* renamed from: b */
    synchronized void m3597b(C0436o c0436o) {
        int i = 1;
        synchronized (this) {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = this.f2410b.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", c0436o.m3725b());
                contentValues.put("fileName", c0436o.m3731d());
                contentValues.put("version", c0436o.m3729c());
                contentValues.put("lLocalLength", Long.valueOf(c0436o.m3741i()));
                contentValues.put("lRemoteLength", Long.valueOf(c0436o.m3743j()));
                contentValues.put("localPath", c0436o.m3745l());
                contentValues.put("mIndex", Integer.valueOf(c0436o.m3739h()));
                String str = "isProvince";
                if (!c0436o.m3746m()) {
                    i = 0;
                }
                contentValues.put(str, Integer.valueOf(i));
                contentValues.put("mCompleteCode", Integer.valueOf(c0436o.m3747n()));
                contentValues.put("mCityCode", c0436o.m3748o());
                contentValues.put("mState", Integer.valueOf(c0436o.f2504a));
                sQLiteDatabase.update("update_item", contentValues, "mAdcode = ?", new String[]{c0436o.m3733e()});
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: c */
    synchronized List<String> m3599c(String str) {
        List<String> arrayList;
        Throwable th;
        Cursor cursor = null;
        synchronized (this) {
            SQLiteDatabase writableDatabase;
            try {
                arrayList = new ArrayList();
                String format = String.format("select file from update_item_file where mAdcode = '%s'", new Object[]{str});
                writableDatabase = this.f2410b.getWritableDatabase();
                try {
                    cursor = writableDatabase.rawQuery(format, null);
                    while (cursor.moveToNext()) {
                        arrayList.add(cursor.getString(cursor.getColumnIndex("file")));
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.close();
                        } catch (Exception e222) {
                            e222.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                Object obj = cursor;
                if (cursor != null) {
                    cursor.close();
                }
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
                throw th;
            }
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    synchronized java.util.List<java.lang.String> m3600d(java.lang.String r6) {
        /*
        r5 = this;
        r2 = 0;
        monitor-enter(r5);
        r0 = new java.util.ArrayList;	 Catch:{ Exception -> 0x007d, all -> 0x0064 }
        r0.<init>();	 Catch:{ Exception -> 0x007d, all -> 0x0064 }
        r1 = "select file from update_item_file where mAdcode = '%s' and file in (select  file from  'update_item_file' group by  file having count(file) = 1)";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0082, all -> 0x0064 }
        r4 = 0;
        r3[r4] = r6;	 Catch:{ Exception -> 0x0082, all -> 0x0064 }
        r1 = java.lang.String.format(r1, r3);	 Catch:{ Exception -> 0x0082, all -> 0x0064 }
        r3 = r5.f2410b;	 Catch:{ Exception -> 0x0082, all -> 0x0064 }
        r3 = r3.getWritableDatabase();	 Catch:{ Exception -> 0x0082, all -> 0x0064 }
        r4 = 0;
        r2 = r3.rawQuery(r1, r4);	 Catch:{ Exception -> 0x0032 }
    L_0x001e:
        r1 = r2.moveToNext();	 Catch:{ Exception -> 0x0032 }
        if (r1 == 0) goto L_0x0042;
    L_0x0024:
        r1 = "file";
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x0032 }
        r1 = r2.getString(r1);	 Catch:{ Exception -> 0x0032 }
        r0.add(r1);	 Catch:{ Exception -> 0x0032 }
        goto L_0x001e;
    L_0x0032:
        r1 = move-exception;
    L_0x0033:
        r1.printStackTrace();	 Catch:{ all -> 0x007b }
        if (r2 == 0) goto L_0x003b;
    L_0x0038:
        r2.close();	 Catch:{ Exception -> 0x005a }
    L_0x003b:
        if (r3 == 0) goto L_0x0040;
    L_0x003d:
        r3.close();	 Catch:{ Exception -> 0x005f }
    L_0x0040:
        monitor-exit(r5);
        return r0;
    L_0x0042:
        if (r2 == 0) goto L_0x0047;
    L_0x0044:
        r2.close();	 Catch:{ Exception -> 0x0055 }
    L_0x0047:
        if (r3 == 0) goto L_0x0040;
    L_0x0049:
        r3.close();	 Catch:{ Exception -> 0x004d }
        goto L_0x0040;
    L_0x004d:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0052 }
        goto L_0x0040;
    L_0x0052:
        r0 = move-exception;
        monitor-exit(r5);
        throw r0;
    L_0x0055:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0052 }
        goto L_0x0047;
    L_0x005a:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0052 }
        goto L_0x003b;
    L_0x005f:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0052 }
        goto L_0x0040;
    L_0x0064:
        r0 = move-exception;
        r3 = r2;
    L_0x0066:
        if (r2 == 0) goto L_0x006b;
    L_0x0068:
        r2.close();	 Catch:{ Exception -> 0x0071 }
    L_0x006b:
        if (r3 == 0) goto L_0x0070;
    L_0x006d:
        r3.close();	 Catch:{ Exception -> 0x0076 }
    L_0x0070:
        throw r0;	 Catch:{ all -> 0x0052 }
    L_0x0071:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0052 }
        goto L_0x006b;
    L_0x0076:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0052 }
        goto L_0x0070;
    L_0x007b:
        r0 = move-exception;
        goto L_0x0066;
    L_0x007d:
        r0 = move-exception;
        r1 = r0;
        r3 = r2;
        r0 = r2;
        goto L_0x0033;
    L_0x0082:
        r1 = move-exception;
        r3 = r2;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.offlinemap.OfflineDBDao.d(java.lang.String):java.util.List<java.lang.String>");
    }

    public synchronized void clear() {
        SQLiteDatabase sQLiteDatabase = null;
        synchronized (this) {
            try {
                sQLiteDatabase = this.f2410b.getWritableDatabase();
                sQLiteDatabase.delete("update_item", null, null);
                sQLiteDatabase.delete("update_item_file", null, null);
                sQLiteDatabase.delete("update_item_download_info", null, null);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: e */
    synchronized void m3601e(String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f2410b.getWritableDatabase();
            sQLiteDatabase.delete("update_item", "mAdcode = ?", new String[]{str});
            sQLiteDatabase.delete("update_item_file", "mAdcode = ?", new String[]{str});
            sQLiteDatabase.delete("update_item_download_info", "mAdcode = ?", new String[]{str});
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: j */
    private synchronized void m3591j(String str) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f2410b.getWritableDatabase();
            sQLiteDatabase.delete("update_item_file", "mAdcode = ?", new String[]{str});
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e2) {
            e2.printStackTrace();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    synchronized void m3594a(String str, int i, long j, long[] jArr, long[] jArr2) {
        if (m3602f(str)) {
            m3590a(str, jArr, jArr2);
        } else {
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = this.f2410b.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("mAdcode", str);
                contentValues.put("fileLength", Long.valueOf(j));
                contentValues.put("splitter", Integer.valueOf(i));
                for (int i2 = 0; i2 < jArr.length; i2++) {
                    contentValues.put("nStartPos" + i2, Long.valueOf(jArr[i2]));
                    contentValues.put("nEndPos" + i2, Long.valueOf(jArr2[i2]));
                }
                sQLiteDatabase.insert("update_item_download_info", "mAdcode", contentValues);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e22) {
                        e22.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m3590a(String str, long[] jArr, long[] jArr2) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.f2410b.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < jArr.length; i++) {
                contentValues.put("nStartPos" + i, Long.valueOf(jArr[i]));
                contentValues.put("nEndPos" + i, Long.valueOf(jArr2[i]));
            }
            sQLiteDatabase.update("update_item_download_info", contentValues, "mAdcode = ?", new String[]{str});
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e22) {
                    e22.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* renamed from: f */
    synchronized boolean m3602f(String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Exception exception;
        boolean z;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th2;
        Cursor cursor2 = null;
        synchronized (this) {
            try {
                Cursor query;
                SQLiteDatabase writableDatabase = this.f2410b.getWritableDatabase();
                try {
                    query = writableDatabase.query("update_item_download_info", new String[]{"_id"}, "mAdcode = ?", new String[]{str}, null, null, null);
                } catch (Exception e) {
                    Exception exception2 = e;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    exception = exception2;
                    try {
                        exception.printStackTrace();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception exception3) {
                                exception3.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.close();
                            } catch (Exception exception32) {
                                exception32.printStackTrace();
                            }
                        }
                        z = false;
                        return z;
                    } catch (Throwable th3) {
                        th = th3;
                        Cursor cursor3 = cursor;
                        sQLiteDatabase2 = sQLiteDatabase;
                        cursor2 = cursor3;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase2 != null) {
                            try {
                                sQLiteDatabase2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
                try {
                    if (query.moveToFirst()) {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e32) {
                                e32.printStackTrace();
                            }
                        }
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.close();
                            } catch (Exception exception322) {
                                exception322.printStackTrace();
                            }
                        }
                        z = true;
                    } else {
                        if (query != null) {
                            try {
                                query.close();
                            } catch (Exception e322) {
                                e322.printStackTrace();
                            }
                        }
                        if (writableDatabase != null) {
                            try {
                                writableDatabase.close();
                            } catch (Exception exception3222) {
                                exception3222.printStackTrace();
                            }
                        }
                        z = false;
                    }
                } catch (Exception e3222) {
                    sQLiteDatabase = writableDatabase;
                    exception3222 = e3222;
                    cursor = query;
                    exception3222.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    z = false;
                    return z;
                } catch (Throwable th42) {
                    cursor2 = query;
                    th2 = th42;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                exception3222 = e4;
                cursor = null;
                exception3222.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                z = false;
                return z;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase2 = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                throw th;
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    synchronized long[] m3596a(java.lang.String r14, int r15) {
        /*
        r13 = this;
        r9 = 0;
        r8 = 0;
        monitor-enter(r13);
        r0 = r13.f2410b;	 Catch:{ Exception -> 0x00ac, all -> 0x00c7 }
        r0 = r0.getWritableDatabase();	 Catch:{ Exception -> 0x00ac, all -> 0x00c7 }
        r1 = "update_item_download_info";
        r2 = 2;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r3 = 0;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r4.<init>();	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r5 = "nStartPos";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r4 = r4.append(r15);	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r3 = 1;
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r4.<init>();	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r5 = "nEndPos";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r4 = r4.append(r15);	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r2[r3] = r4;	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r3 = "mAdcode = ?";
        r4 = 1;
        r4 = new java.lang.String[r4];	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r5 = 0;
        r4[r5] = r14;	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x00ee, all -> 0x00de }
        r1 = r2.moveToFirst();	 Catch:{ Exception -> 0x00f5, all -> 0x00e3 }
        if (r1 == 0) goto L_0x0102;
    L_0x0050:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f5, all -> 0x00e3 }
        r1.<init>();	 Catch:{ Exception -> 0x00f5, all -> 0x00e3 }
        r3 = "nStartPos";
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x00f5, all -> 0x00e3 }
        r1 = r1.append(r15);	 Catch:{ Exception -> 0x00f5, all -> 0x00e3 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00f5, all -> 0x00e3 }
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x00f5, all -> 0x00e3 }
        r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x00f5, all -> 0x00e3 }
        r3 = (long) r1;
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00fb, all -> 0x00e3 }
        r1.<init>();	 Catch:{ Exception -> 0x00fb, all -> 0x00e3 }
        r5 = "nEndPos";
        r1 = r1.append(r5);	 Catch:{ Exception -> 0x00fb, all -> 0x00e3 }
        r1 = r1.append(r15);	 Catch:{ Exception -> 0x00fb, all -> 0x00e3 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00fb, all -> 0x00e3 }
        r1 = r2.getColumnIndex(r1);	 Catch:{ Exception -> 0x00fb, all -> 0x00e3 }
        r1 = r2.getInt(r1);	 Catch:{ Exception -> 0x00fb, all -> 0x00e3 }
        r9 = (long) r1;
    L_0x0088:
        if (r2 == 0) goto L_0x008d;
    L_0x008a:
        r2.close();	 Catch:{ Exception -> 0x009e }
    L_0x008d:
        if (r0 == 0) goto L_0x0092;
    L_0x008f:
        r0.close();	 Catch:{ Exception -> 0x00a6 }
    L_0x0092:
        r2 = r3;
    L_0x0093:
        r0 = 2;
        r0 = new long[r0];	 Catch:{ all -> 0x00a3 }
        r1 = 0;
        r0[r1] = r2;	 Catch:{ all -> 0x00a3 }
        r1 = 1;
        r0[r1] = r9;	 Catch:{ all -> 0x00a3 }
        monitor-exit(r13);
        return r0;
    L_0x009e:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x008d;
    L_0x00a3:
        r0 = move-exception;
        monitor-exit(r13);
        throw r0;
    L_0x00a6:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        r2 = r3;
        goto L_0x0093;
    L_0x00ac:
        r0 = move-exception;
        r1 = r8;
        r2 = r9;
    L_0x00af:
        r0.printStackTrace();	 Catch:{ all -> 0x00e9 }
        if (r1 == 0) goto L_0x00b7;
    L_0x00b4:
        r1.close();	 Catch:{ Exception -> 0x00c2 }
    L_0x00b7:
        if (r8 == 0) goto L_0x0093;
    L_0x00b9:
        r8.close();	 Catch:{ Exception -> 0x00bd }
        goto L_0x0093;
    L_0x00bd:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x0093;
    L_0x00c2:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x00b7;
    L_0x00c7:
        r0 = move-exception;
        r1 = r8;
    L_0x00c9:
        if (r8 == 0) goto L_0x00ce;
    L_0x00cb:
        r8.close();	 Catch:{ Exception -> 0x00d4 }
    L_0x00ce:
        if (r1 == 0) goto L_0x00d3;
    L_0x00d0:
        r1.close();	 Catch:{ Exception -> 0x00d9 }
    L_0x00d3:
        throw r0;	 Catch:{ all -> 0x00a3 }
    L_0x00d4:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x00ce;
    L_0x00d9:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x00a3 }
        goto L_0x00d3;
    L_0x00de:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x00c9;
    L_0x00e3:
        r1 = move-exception;
        r8 = r2;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x00c9;
    L_0x00e9:
        r0 = move-exception;
        r11 = r1;
        r1 = r8;
        r8 = r11;
        goto L_0x00c9;
    L_0x00ee:
        r1 = move-exception;
        r2 = r9;
        r11 = r8;
        r8 = r0;
        r0 = r1;
        r1 = r11;
        goto L_0x00af;
    L_0x00f5:
        r1 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r2;
        r2 = r9;
        goto L_0x00af;
    L_0x00fb:
        r1 = move-exception;
        r8 = r0;
        r0 = r1;
        r1 = r2;
        r11 = r3;
        r2 = r11;
        goto L_0x00af;
    L_0x0102:
        r3 = r9;
        goto L_0x0088;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.offlinemap.OfflineDBDao.a(java.lang.String, int):long[]");
    }

    /* renamed from: g */
    synchronized int m3603g(String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Exception exception;
        int i;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th2;
        int i2;
        Cursor cursor2 = null;
        synchronized (this) {
            try {
                Cursor query;
                SQLiteDatabase writableDatabase = this.f2410b.getWritableDatabase();
                try {
                    query = writableDatabase.query("update_item_download_info", new String[]{"fileLength"}, "mAdcode = ?", new String[]{str}, null, null, null);
                } catch (Exception e) {
                    Exception exception2 = e;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    exception = exception2;
                    try {
                        exception.printStackTrace();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception exception3) {
                                exception3.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.close();
                            } catch (Exception exception32) {
                                exception32.printStackTrace();
                                i = 0;
                            }
                        }
                        i = 0;
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        Cursor cursor3 = cursor;
                        sQLiteDatabase2 = sQLiteDatabase;
                        cursor2 = cursor3;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase2 != null) {
                            try {
                                sQLiteDatabase2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
                try {
                    if (query.moveToFirst()) {
                        i2 = query.getInt(query.getColumnIndex("fileLength"));
                    } else {
                        i2 = 0;
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.close();
                        } catch (Exception exception322) {
                            exception322.printStackTrace();
                            i = i2;
                        }
                    }
                    i = i2;
                } catch (Exception e32) {
                    sQLiteDatabase = writableDatabase;
                    exception322 = e32;
                    cursor = query;
                    exception322.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    i = 0;
                    return i;
                } catch (Throwable th42) {
                    cursor2 = query;
                    th2 = th42;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                exception322 = e4;
                cursor = null;
                exception322.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i = 0;
                return i;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase2 = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                throw th;
            }
        }
        return i;
    }

    /* renamed from: h */
    synchronized int m3604h(String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Exception exception;
        int i;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2;
        Throwable th2;
        int i2;
        Cursor cursor2 = null;
        synchronized (this) {
            try {
                Cursor query;
                SQLiteDatabase writableDatabase = this.f2410b.getWritableDatabase();
                try {
                    query = writableDatabase.query("update_item_download_info", new String[]{"splitter"}, "mAdcode = ?", new String[]{str}, null, null, null);
                } catch (Exception e) {
                    Exception exception2 = e;
                    cursor = null;
                    sQLiteDatabase = writableDatabase;
                    exception = exception2;
                    try {
                        exception.printStackTrace();
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception exception3) {
                                exception3.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase != null) {
                            try {
                                sQLiteDatabase.close();
                            } catch (Exception exception32) {
                                exception32.printStackTrace();
                                i = 0;
                            }
                        }
                        i = 0;
                        return i;
                    } catch (Throwable th3) {
                        th = th3;
                        Cursor cursor3 = cursor;
                        sQLiteDatabase2 = sQLiteDatabase;
                        cursor2 = cursor3;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (sQLiteDatabase2 != null) {
                            try {
                                sQLiteDatabase2.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
                try {
                    if (query.moveToFirst()) {
                        i2 = query.getInt(query.getColumnIndex("splitter"));
                    } else {
                        i2 = 0;
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.close();
                        } catch (Exception exception322) {
                            exception322.printStackTrace();
                            i = i2;
                        }
                    }
                    i = i2;
                } catch (Exception e32) {
                    sQLiteDatabase = writableDatabase;
                    exception322 = e32;
                    cursor = query;
                    exception322.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    i = 0;
                    return i;
                } catch (Throwable th42) {
                    cursor2 = query;
                    th2 = th42;
                    sQLiteDatabase2 = writableDatabase;
                    th = th2;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                exception322 = e4;
                cursor = null;
                exception322.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                i = 0;
                return i;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabase2 = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                throw th;
            }
        }
        return i;
    }

    /* renamed from: i */
    synchronized String m3605i(String str) {
        Exception e;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        Object obj;
        String str2;
        Throwable th;
        Cursor cursor2 = null;
        synchronized (this) {
            if (m3595a(str)) {
                String str3;
                try {
                    SQLiteDatabase writableDatabase = this.f2410b.getWritableDatabase();
                    try {
                        Cursor query = writableDatabase.query("update_item", new String[]{"version"}, "mAdcode = ?", new String[]{str}, null, null, null);
                        try {
                            String string;
                            if (query.moveToFirst()) {
                                string = query.getString(query.getColumnIndex("version"));
                            } else {
                                string = null;
                            }
                            if (query != null) {
                                try {
                                    query.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (writableDatabase != null) {
                                try {
                                    writableDatabase.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    str3 = string;
                                }
                            }
                            str3 = string;
                        } catch (Exception e4) {
                            Exception exception = e4;
                            cursor = query;
                            sQLiteDatabase = writableDatabase;
                            e3 = exception;
                            try {
                                e3.printStackTrace();
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e32) {
                                        e32.printStackTrace();
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.close();
                                    } catch (Exception e322) {
                                        e322.printStackTrace();
                                        obj = null;
                                    }
                                }
                                obj = null;
                                str2 = str3;
                                return str2;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e42) {
                                        e42.printStackTrace();
                                    }
                                }
                                if (sQLiteDatabase != null) {
                                    try {
                                        sQLiteDatabase.close();
                                    } catch (Exception e422) {
                                        e422.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            cursor2 = query;
                            sQLiteDatabase = writableDatabase;
                            th = th3;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    } catch (Exception e4222) {
                        sQLiteDatabase = writableDatabase;
                        e322 = e4222;
                        cursor = null;
                        e322.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        obj = null;
                        str2 = str3;
                        return str2;
                    } catch (Throwable th32) {
                        sQLiteDatabase = writableDatabase;
                        th = th32;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.close();
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e322 = e5;
                    cursor = null;
                    sQLiteDatabase = null;
                    e322.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    obj = null;
                    str2 = str3;
                    return str2;
                } catch (Throwable th4) {
                    th = th4;
                    sQLiteDatabase = null;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
                str2 = str3;
            }
        }
        return str2;
    }
}
