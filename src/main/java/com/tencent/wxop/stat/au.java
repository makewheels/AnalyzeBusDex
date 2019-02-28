package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.wxop.stat.common.C1182a;
import com.tencent.wxop.stat.common.C1186e;
import com.tencent.wxop.stat.common.C1192k;
import com.tencent.wxop.stat.common.C1198q;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.p053a.C1166e;
import com.umeng.analytics.onlineconfig.C1248a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
import p054u.aly.bi_常量类;

public class au {
    /* renamed from: h */
    private static StatLogger f5383h = C1192k.m8283b();
    /* renamed from: i */
    private static Context f5384i = null;
    /* renamed from: j */
    private static au f5385j = null;
    /* renamed from: a */
    volatile int f5386a = 0;
    /* renamed from: b */
    C1182a f5387b = null;
    /* renamed from: c */
    private bc f5388c = null;
    /* renamed from: d */
    private bc f5389d = null;
    /* renamed from: e */
    private C1186e f5390e = null;
    /* renamed from: f */
    private String f5391f = bi_常量类.f6358b_空串;
    /* renamed from: g */
    private String f5392g = bi_常量类.f6358b_空串;
    /* renamed from: k */
    private int f5393k = 0;
    /* renamed from: l */
    private ConcurrentHashMap<C1166e, String> f5394l = null;
    /* renamed from: m */
    private boolean f5395m = false;
    /* renamed from: n */
    private HashMap<String, String> f5396n = new HashMap();

    private au(Context context) {
        try {
            this.f5390e = new C1186e();
            f5384i = context.getApplicationContext();
            this.f5394l = new ConcurrentHashMap();
            this.f5391f = C1192k.m8307r(context);
            this.f5392g = "pri_" + C1192k.m8307r(context);
            this.f5388c = new bc(f5384i, this.f5391f);
            this.f5389d = new bc(f5384i, this.f5392g);
            m8211a(true);
            m8211a(false);
            m8221f();
            m8232b(f5384i);
            m8234d();
            m8225j();
        } catch (Throwable th) {
            f5383h.m8242e(th);
        }
    }

    /* renamed from: a */
    public static au m8199a(Context context) {
        if (f5385j == null) {
            synchronized (au.class) {
                if (f5385j == null) {
                    f5385j = new au(context);
                }
            }
        }
        return f5385j;
    }

    /* renamed from: a */
    private String m8200a(List<bd> list) {
        StringBuilder stringBuilder = new StringBuilder(list.size() * 3);
        stringBuilder.append("event_id in (");
        int size = list.size();
        int i = 0;
        for (bd bdVar : list) {
            stringBuilder.append(bdVar.f5422a);
            if (i != size - 1) {
                stringBuilder.append(",");
            }
            i++;
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    /* renamed from: a */
    private synchronized void m8201a(int i, boolean z) {
        try {
            if (this.f5386a > 0 && i > 0 && !StatServiceImpl.m8112a()) {
                if (StatConfig.isDebugEnable()) {
                    f5383h.m8243i("Load " + this.f5386a + " unsent events");
                }
                List arrayList = new ArrayList(i);
                m8217b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (StatConfig.isDebugEnable()) {
                        f5383h.m8243i("Peek " + arrayList.size() + " unsent events.");
                    }
                    m8209a(arrayList, 2, z);
                    C1204i.m8353b(f5384i).m8356b(arrayList, new ba(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            f5383h.m8242e(th);
        }
    }

    /* renamed from: a */
    private void m8202a(C1166e c1166e, C1179h c1179h, boolean z) {
        long insert;
        long j;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = m8218c(z);
            sQLiteDatabase.beginTransaction();
            if (!z && this.f5386a > StatConfig.getMaxStoreEventCount()) {
                f5383h.warn("Too many events stored in db.");
                this.f5386a -= this.f5388c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
            }
            ContentValues contentValues = new ContentValues();
            String g = c1166e.m8140g();
            if (StatConfig.isDebugEnable()) {
                f5383h.m8243i("insert 1 event, content:" + g);
            }
            contentValues.put("content", C1198q.m8334b(g));
            contentValues.put("send_count", "0");
            contentValues.put("status", Integer.toString(1));
            contentValues.put("timestamp", Long.valueOf(c1166e.m8136c()));
            insert = sQLiteDatabase.insert("events", null, contentValues);
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                    j = insert;
                } catch (Throwable th) {
                    f5383h.m8242e(th);
                    j = insert;
                }
                if (j <= 0) {
                    this.f5386a++;
                    if (StatConfig.isDebugEnable()) {
                        f5383h.m8240d("directStoreEvent insert event to db, event:" + c1166e.m8140g());
                    }
                    if (c1179h != null) {
                        c1179h.mo1913a();
                    }
                }
                f5383h.error("Failed to store event:" + c1166e.m8140g());
                return;
            }
        } catch (Throwable th2) {
            f5383h.m8242e(th2);
            j = -1;
        }
        j = insert;
        if (j <= 0) {
            f5383h.error("Failed to store event:" + c1166e.m8140g());
            return;
        }
        this.f5386a++;
        if (StatConfig.isDebugEnable()) {
            f5383h.m8240d("directStoreEvent insert event to db, event:" + c1166e.m8140g());
        }
        if (c1179h != null) {
            c1179h.mo1913a();
        }
    }

    /* renamed from: a */
    private synchronized void m8209a(List<bd> list, int i, boolean z) {
        SQLiteDatabase c;
        Throwable th;
        String str = null;
        synchronized (this) {
            if (list.size() != 0) {
                int b = m8212b(z);
                try {
                    String str2;
                    c = m8218c(z);
                    if (i == 2) {
                        try {
                            str2 = "update events set status=" + i + ", send_count=send_count+1  where " + m8200a((List) list);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                f5383h.m8242e(th);
                                if (c != null) {
                                    try {
                                        c.endTransaction();
                                    } catch (Throwable th3) {
                                        f5383h.m8242e(th3);
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                if (c != null) {
                                    try {
                                        c.endTransaction();
                                    } catch (Throwable th5) {
                                        f5383h.m8242e(th5);
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                    str2 = "update events set status=" + i + " where " + m8200a((List) list);
                    if (this.f5393k % 3 == 0) {
                        str = "delete from events where send_count>" + b;
                    }
                    this.f5393k++;
                    if (StatConfig.isDebugEnable()) {
                        f5383h.m8243i("update sql:" + str2);
                    }
                    c.beginTransaction();
                    c.execSQL(str2);
                    if (str != null) {
                        f5383h.m8243i("update for delete sql:" + str);
                        c.execSQL(str);
                        m8221f();
                    }
                    c.setTransactionSuccessful();
                    if (c != null) {
                        try {
                            c.endTransaction();
                        } catch (Throwable th32) {
                            f5383h.m8242e(th32);
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    c = null;
                    if (c != null) {
                        c.endTransaction();
                    }
                    throw th32;
                }
            }
        }
    }

    /* renamed from: a */
    private synchronized void m8210a(java.util.List<com.tencent.wxop.stat.bd> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.au.a(java.util.List, boolean):void. bs: [B:26:0x00c1, B:49:0x00e9]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r1 = 0;
        monitor-enter(r8);
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r8);
        return;
    L_0x000a:
        r0 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x0032;	 Catch:{ all -> 0x00ce }
    L_0x0010:
        r0 = f5383h;	 Catch:{ all -> 0x00ce }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r3 = "Delete ";	 Catch:{ all -> 0x00ce }
        r2.<init>(r3);	 Catch:{ all -> 0x00ce }
        r3 = r9.size();	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r3 = " events, important:";	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00ce }
        r2 = r2.append(r10);	 Catch:{ all -> 0x00ce }
        r2 = r2.toString();	 Catch:{ all -> 0x00ce }
        r0.m8243i(r2);	 Catch:{ all -> 0x00ce }
    L_0x0032:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ce }
        r0 = r9.size();	 Catch:{ all -> 0x00ce }
        r0 = r0 * 3;	 Catch:{ all -> 0x00ce }
        r3.<init>(r0);	 Catch:{ all -> 0x00ce }
        r0 = "event_id in (";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r0 = 0;	 Catch:{ all -> 0x00ce }
        r4 = r9.size();	 Catch:{ all -> 0x00ce }
        r5 = r9.iterator();	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
    L_0x004c:
        r0 = r5.hasNext();	 Catch:{ all -> 0x00ce }
        if (r0 == 0) goto L_0x006a;	 Catch:{ all -> 0x00ce }
    L_0x0052:
        r0 = r5.next();	 Catch:{ all -> 0x00ce }
        r0 = (com.tencent.wxop.stat.bd) r0;	 Catch:{ all -> 0x00ce }
        r6 = r0.f5422a;	 Catch:{ all -> 0x00ce }
        r3.append(r6);	 Catch:{ all -> 0x00ce }
        r0 = r4 + -1;	 Catch:{ all -> 0x00ce }
        if (r2 == r0) goto L_0x0066;	 Catch:{ all -> 0x00ce }
    L_0x0061:
        r0 = ",";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
    L_0x0066:
        r0 = r2 + 1;	 Catch:{ all -> 0x00ce }
        r2 = r0;	 Catch:{ all -> 0x00ce }
        goto L_0x004c;	 Catch:{ all -> 0x00ce }
    L_0x006a:
        r0 = ")";	 Catch:{ all -> 0x00ce }
        r3.append(r0);	 Catch:{ all -> 0x00ce }
        r1 = r8.m8218c(r10);	 Catch:{ Throwable -> 0x00d1 }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00d1 }
        r0 = "events";	 Catch:{ Throwable -> 0x00d1 }
        r2 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r5 = 0;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r1.delete(r0, r2, r5);	 Catch:{ Throwable -> 0x00d1 }
        r2 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x00d1 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ Throwable -> 0x00d1 }
    L_0x0087:
        r2 = f5383h;	 Catch:{ Throwable -> 0x00d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d1 }
        r6 = "delete ";	 Catch:{ Throwable -> 0x00d1 }
        r5.<init>(r6);	 Catch:{ Throwable -> 0x00d1 }
        r4 = r5.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r5 = " event ";	 Catch:{ Throwable -> 0x00d1 }
        r4 = r4.append(r5);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r3 = r4.append(r3);	 Catch:{ Throwable -> 0x00d1 }
        r4 = ", success delete:";	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r4);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.append(r0);	 Catch:{ Throwable -> 0x00d1 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00d1 }
        r2.m8243i(r3);	 Catch:{ Throwable -> 0x00d1 }
    L_0x00b3:
        r2 = r8.f5386a;	 Catch:{ Throwable -> 0x00d1 }
        r0 = r2 - r0;	 Catch:{ Throwable -> 0x00d1 }
        r8.f5386a = r0;	 Catch:{ Throwable -> 0x00d1 }
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00d1 }
        r8.m8221f();	 Catch:{ Throwable -> 0x00d1 }
        if (r1 == 0) goto L_0x0008;
    L_0x00c1:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x0008;
    L_0x00c6:
        r0 = move-exception;
        r1 = f5383h;	 Catch:{ all -> 0x00ce }
        r1.m8242e(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00ce:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x00d1:
        r0 = move-exception;
        r2 = f5383h;	 Catch:{ all -> 0x00e6 }
        r2.m8242e(r0);	 Catch:{ all -> 0x00e6 }
        if (r1 == 0) goto L_0x0008;
    L_0x00d9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00de }
        goto L_0x0008;
    L_0x00de:
        r0 = move-exception;
        r1 = f5383h;	 Catch:{ all -> 0x00ce }
        r1.m8242e(r0);	 Catch:{ all -> 0x00ce }
        goto L_0x0008;
    L_0x00e6:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ec;
    L_0x00e9:
        r1.endTransaction();	 Catch:{ Throwable -> 0x00ed }
    L_0x00ec:
        throw r0;	 Catch:{ all -> 0x00ce }
    L_0x00ed:
        r1 = move-exception;	 Catch:{ all -> 0x00ce }
        r2 = f5383h;	 Catch:{ all -> 0x00ce }
        r2.m8242e(r1);	 Catch:{ all -> 0x00ce }
        goto L_0x00ec;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.au.a(java.util.List, boolean):void");
    }

    /* renamed from: a */
    private void m8211a(boolean z) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = m8218c(z);
            sQLiteDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.valueOf(1));
            int update = sQLiteDatabase.update("events", contentValues, "status=?", new String[]{Long.toString(2)});
            if (StatConfig.isDebugEnable()) {
                f5383h.m8243i("update " + update + " unsent events.");
            }
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    f5383h.m8242e(th);
                }
            }
        } catch (Throwable th2) {
            f5383h.m8242e(th2);
        }
    }

    /* renamed from: b */
    private int m8212b(boolean z) {
        return !z ? StatConfig.getMaxSendRetryCount() : StatConfig.getMaxImportantDataSendRetryCount();
    }

    /* renamed from: b */
    public static au m8213b() {
        return f5385j;
    }

    /* renamed from: b */
    private void m8214b(int i, boolean z) {
        int g = i == -1 ? !z ? m8222g() : m8223h() : i;
        if (g > 0) {
            int sendPeriodMinutes = (StatConfig.getSendPeriodMinutes() * 60) * StatConfig.getNumEventsCommitPerSec();
            if (g > sendPeriodMinutes && sendPeriodMinutes > 0) {
                g = sendPeriodMinutes;
            }
            int a = StatConfig.m8086a();
            int i2 = g / a;
            int i3 = g % a;
            if (StatConfig.isDebugEnable()) {
                f5383h.m8243i("sentStoreEventsByDb sendNumbers=" + g + ",important=" + z + ",maxSendNumPerFor1Period=" + sendPeriodMinutes + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (g = 0; g < i2; g++) {
                m8201a(a, z);
            }
            if (i3 > 0) {
                m8201a(i3, z);
            }
        }
    }

    /* renamed from: b */
    private synchronized void m8215b(C1166e c1166e, C1179h c1179h, boolean z, boolean z2) {
        if (StatConfig.getMaxStoreEventCount() > 0) {
            if (StatConfig.f5240m <= 0 || z || z2) {
                m8202a(c1166e, c1179h, z);
            } else if (StatConfig.f5240m > 0) {
                if (StatConfig.isDebugEnable()) {
                    f5383h.m8243i("cacheEventsInMemory.size():" + this.f5394l.size() + ",numEventsCachedInMemory:" + StatConfig.f5240m + ",numStoredEvents:" + this.f5386a);
                    f5383h.m8243i("cache event:" + c1166e.m8140g());
                }
                this.f5394l.put(c1166e, bi_常量类.f6358b_空串);
                if (this.f5394l.size() >= StatConfig.f5240m) {
                    m8224i();
                }
                if (c1179h != null) {
                    if (this.f5394l.size() > 0) {
                        m8224i();
                    }
                    c1179h.mo1913a();
                }
            }
        }
    }

    /* renamed from: b */
    private synchronized void m8216b(C1202f c1202f) {
        Cursor query;
        Throwable th;
        try {
            Object obj;
            long update;
            String a = c1202f.m8344a();
            String a2 = C1192k.m8277a(a);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", c1202f.f5512b.toString());
            contentValues.put("md5sum", a2);
            c1202f.f5513c = a2;
            contentValues.put("version", Integer.valueOf(c1202f.f5514d));
            query = this.f5388c.getReadableDatabase().query("config", null, null, null, null, null, null);
            do {
                try {
                    if (!query.moveToNext()) {
                        obj = null;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (query.getInt(0) != c1202f.f5511a);
            obj = 1;
            this.f5388c.getWritableDatabase().beginTransaction();
            if (1 == obj) {
                update = (long) this.f5388c.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(c1202f.f5511a)});
            } else {
                contentValues.put(C1248a.f5654a, Integer.valueOf(c1202f.f5511a));
                update = this.f5388c.getWritableDatabase().insert("config", null, contentValues);
            }
            if (update == -1) {
                f5383h.m8241e("Failed to store cfg:" + a);
            } else {
                f5383h.m8240d("Sucessed to store cfg:" + a);
            }
            this.f5388c.getWritableDatabase().setTransactionSuccessful();
            if (query != null) {
                query.close();
            }
            try {
                this.f5388c.getWritableDatabase().endTransaction();
            } catch (Exception e) {
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            this.f5388c.getWritableDatabase().endTransaction();
            throw th;
        }
        return;
    }

    /* renamed from: b */
    private void m8217b(List<bd> list, int i, boolean z) {
        Throwable th;
        Cursor cursor;
        Cursor query;
        try {
            query = m8219d(z).query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
            while (query.moveToNext()) {
                try {
                    long j = query.getLong(0);
                    String string = query.getString(1);
                    if (!StatConfig.f5234g) {
                        string = C1198q.m8329a(string);
                    }
                    int i2 = query.getInt(2);
                    int i3 = query.getInt(3);
                    bd bdVar = new bd(j, string, i2, i3);
                    if (StatConfig.isDebugEnable()) {
                        f5383h.m8243i("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + query.getLong(4));
                    }
                    list.add(bdVar);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: c */
    private SQLiteDatabase m8218c(boolean z) {
        return !z ? this.f5388c.getWritableDatabase() : this.f5389d.getWritableDatabase();
    }

    /* renamed from: d */
    private SQLiteDatabase m8219d(boolean z) {
        return !z ? this.f5388c.getReadableDatabase() : this.f5389d.getReadableDatabase();
    }

    /* renamed from: f */
    private void m8221f() {
        this.f5386a = m8222g() + m8223h();
    }

    /* renamed from: g */
    private int m8222g() {
        return (int) DatabaseUtils.queryNumEntries(this.f5388c.getReadableDatabase(), "events");
    }

    /* renamed from: h */
    private int m8223h() {
        return (int) DatabaseUtils.queryNumEntries(this.f5389d.getReadableDatabase(), "events");
    }

    /* renamed from: i */
    private void m8224i() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.tencent.wxop.stat.au.i():void. bs: [B:42:0x011b, B:53:0x0133]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r1 = 0;
        r0 = r9.f5395m;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r2 = r9.f5394l;
        monitor-enter(r2);
        r0 = r9.f5394l;	 Catch:{ all -> 0x0013 }
        r0 = r0.size();	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0016;	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;	 Catch:{ all -> 0x0013 }
    L_0x0013:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        throw r0;
    L_0x0016:
        r0 = 1;
        r9.f5395m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ all -> 0x0013 }
    L_0x001f:
        r0 = f5383h;	 Catch:{ all -> 0x0013 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r4 = "insert ";	 Catch:{ all -> 0x0013 }
        r3.<init>(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f5394l;	 Catch:{ all -> 0x0013 }
        r4 = r4.size();	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = " events ,numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = com.tencent.wxop.stat.StatConfig.f5240m;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r4 = r9.f5386a;	 Catch:{ all -> 0x0013 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0013 }
        r3 = r3.toString();	 Catch:{ all -> 0x0013 }
        r0.m8243i(r3);	 Catch:{ all -> 0x0013 }
    L_0x0051:
        r0 = r9.f5388c;	 Catch:{ Throwable -> 0x00ca }
        r1 = r0.getWritableDatabase();	 Catch:{ Throwable -> 0x00ca }
        r1.beginTransaction();	 Catch:{ Throwable -> 0x00ca }
        r0 = r9.f5394l;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x00ca }
        r3 = r0.iterator();	 Catch:{ Throwable -> 0x00ca }
    L_0x0064:
        r0 = r3.hasNext();	 Catch:{ Throwable -> 0x00ca }
        if (r0 == 0) goto L_0x0116;	 Catch:{ Throwable -> 0x00ca }
    L_0x006a:
        r0 = r3.next();	 Catch:{ Throwable -> 0x00ca }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x00ca }
        r0 = r0.getKey();	 Catch:{ Throwable -> 0x00ca }
        r0 = (com.tencent.wxop.stat.p053a.C1166e) r0;	 Catch:{ Throwable -> 0x00ca }
        r4 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00ca }
        r4.<init>();	 Catch:{ Throwable -> 0x00ca }
        r5 = r0.m8140g();	 Catch:{ Throwable -> 0x00ca }
        r6 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ Throwable -> 0x00ca }
        if (r6 == 0) goto L_0x0099;	 Catch:{ Throwable -> 0x00ca }
    L_0x0085:
        r6 = f5383h;	 Catch:{ Throwable -> 0x00ca }
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00ca }
        r8 = "insert content:";	 Catch:{ Throwable -> 0x00ca }
        r7.<init>(r8);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.append(r5);	 Catch:{ Throwable -> 0x00ca }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x00ca }
        r6.m8243i(r7);	 Catch:{ Throwable -> 0x00ca }
    L_0x0099:
        r5 = com.tencent.wxop.stat.common.C1198q.m8334b(r5);	 Catch:{ Throwable -> 0x00ca }
        r6 = "content";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r6, r5);	 Catch:{ Throwable -> 0x00ca }
        r5 = "send_count";	 Catch:{ Throwable -> 0x00ca }
        r6 = "0";	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "status";	 Catch:{ Throwable -> 0x00ca }
        r6 = 1;	 Catch:{ Throwable -> 0x00ca }
        r6 = java.lang.Integer.toString(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r6);	 Catch:{ Throwable -> 0x00ca }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x00ca }
        r6 = r0.m8136c();	 Catch:{ Throwable -> 0x00ca }
        r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x00ca }
        r4.put(r5, r0);	 Catch:{ Throwable -> 0x00ca }
        r0 = "events";	 Catch:{ Throwable -> 0x00ca }
        r5 = 0;	 Catch:{ Throwable -> 0x00ca }
        r1.insert(r0, r5, r4);	 Catch:{ Throwable -> 0x00ca }
        r3.remove();	 Catch:{ Throwable -> 0x00ca }
        goto L_0x0064;
    L_0x00ca:
        r0 = move-exception;
        r3 = f5383h;	 Catch:{ all -> 0x0130 }
        r3.m8242e(r0);	 Catch:{ all -> 0x0130 }
        if (r1 == 0) goto L_0x00d8;
    L_0x00d2:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0129 }
        r9.m8221f();	 Catch:{ Throwable -> 0x0129 }
    L_0x00d8:
        r0 = 0;
        r9.f5395m = r0;	 Catch:{ all -> 0x0013 }
        r0 = com.tencent.wxop.stat.StatConfig.isDebugEnable();	 Catch:{ all -> 0x0013 }
        if (r0 == 0) goto L_0x0113;	 Catch:{ all -> 0x0013 }
    L_0x00e1:
        r0 = f5383h;	 Catch:{ all -> 0x0013 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0013 }
        r3 = "after insert, cacheEventsInMemory.size():";	 Catch:{ all -> 0x0013 }
        r1.<init>(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f5394l;	 Catch:{ all -> 0x0013 }
        r3 = r3.size();	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numEventsCachedInMemory:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = com.tencent.wxop.stat.StatConfig.f5240m;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = ",numStoredEvents:";	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r3 = r9.f5386a;	 Catch:{ all -> 0x0013 }
        r1 = r1.append(r3);	 Catch:{ all -> 0x0013 }
        r1 = r1.toString();	 Catch:{ all -> 0x0013 }
        r0.m8243i(r1);	 Catch:{ all -> 0x0013 }
    L_0x0113:
        monitor-exit(r2);	 Catch:{ all -> 0x0013 }
        goto L_0x0005;
    L_0x0116:
        r1.setTransactionSuccessful();	 Catch:{ Throwable -> 0x00ca }
        if (r1 == 0) goto L_0x00d8;
    L_0x011b:
        r1.endTransaction();	 Catch:{ Throwable -> 0x0122 }
        r9.m8221f();	 Catch:{ Throwable -> 0x0122 }
        goto L_0x00d8;
    L_0x0122:
        r0 = move-exception;
        r1 = f5383h;	 Catch:{ all -> 0x0013 }
        r1.m8242e(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;	 Catch:{ all -> 0x0013 }
    L_0x0129:
        r0 = move-exception;	 Catch:{ all -> 0x0013 }
        r1 = f5383h;	 Catch:{ all -> 0x0013 }
        r1.m8242e(r0);	 Catch:{ all -> 0x0013 }
        goto L_0x00d8;
    L_0x0130:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0139;
    L_0x0133:
        r1.endTransaction();	 Catch:{ Throwable -> 0x013a }
        r9.m8221f();	 Catch:{ Throwable -> 0x013a }
    L_0x0139:
        throw r0;	 Catch:{ all -> 0x0013 }
    L_0x013a:
        r1 = move-exception;	 Catch:{ all -> 0x0013 }
        r3 = f5383h;	 Catch:{ all -> 0x0013 }
        r3.m8242e(r1);	 Catch:{ all -> 0x0013 }
        goto L_0x0139;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.au.i():void");
    }

    /* renamed from: j */
    private void m8225j() {
        Cursor query;
        Throwable th;
        try {
            query = this.f5388c.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    this.f5396n.put(query.getString(0), query.getString(1));
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public int m8226a() {
        return this.f5386a;
    }

    /* renamed from: a */
    void m8227a(int i) {
        this.f5390e.m8255a(new bb(this, i));
    }

    /* renamed from: a */
    void m8228a(C1166e c1166e, C1179h c1179h, boolean z, boolean z2) {
        if (this.f5390e != null) {
            this.f5390e.m8255a(new ay(this, c1166e, c1179h, z, z2));
        }
    }

    /* renamed from: a */
    void m8229a(C1202f c1202f) {
        if (c1202f != null) {
            this.f5390e.m8255a(new az(this, c1202f));
        }
    }

    /* renamed from: a */
    void m8230a(List<bd> list, int i, boolean z, boolean z2) {
        if (this.f5390e != null) {
            this.f5390e.m8255a(new av(this, list, i, z, z2));
        }
    }

    /* renamed from: a */
    void m8231a(List<bd> list, boolean z, boolean z2) {
        if (this.f5390e != null) {
            this.f5390e.m8255a(new aw(this, list, z, z2));
        }
    }

    /* renamed from: b */
    public synchronized C1182a m8232b(Context context) {
        C1182a c1182a;
        Cursor query;
        Throwable th;
        Cursor cursor;
        if (this.f5387b != null) {
            c1182a = this.f5387b;
        } else {
            try {
                this.f5388c.getWritableDatabase().beginTransaction();
                if (StatConfig.isDebugEnable()) {
                    f5383h.m8243i("try to load user info from db.");
                }
                query = this.f5388c.getReadableDatabase().query("user", null, null, null, null, null, null, null);
                Object obj = null;
                try {
                    String string;
                    String b;
                    if (query.moveToNext()) {
                        String a = C1198q.m8329a(query.getString(0));
                        int i = query.getInt(1);
                        string = query.getString(2);
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        int i2 = (i == 1 || C1192k.m8275a(query.getLong(3) * 1000).equals(C1192k.m8275a(1000 * currentTimeMillis))) ? i : 1;
                        int i3 = !string.equals(C1192k.m8303n(context)) ? i2 | 2 : i2;
                        String[] split = a.split(",");
                        obj = null;
                        if (split == null || split.length <= 0) {
                            b = C1192k.m8284b(context);
                            obj = 1;
                            a = b;
                        } else {
                            b = split[0];
                            if (b == null || b.length() < 11) {
                                string = C1198q.m8328a(context);
                                if (string == null || string.length() <= 10) {
                                    string = b;
                                } else {
                                    obj = 1;
                                }
                                b = a;
                                a = string;
                            } else {
                                String str = b;
                                b = a;
                                a = str;
                            }
                        }
                        if (split == null || split.length < 2) {
                            string = C1192k.m8286c(context);
                            if (string != null && string.length() > 0) {
                                b = a + "," + string;
                                obj = 1;
                            }
                        } else {
                            string = split[1];
                            b = a + "," + string;
                        }
                        this.f5387b = new C1182a(a, string, i3);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uid", C1198q.m8334b(b));
                        contentValues.put("user_type", Integer.valueOf(i3));
                        contentValues.put("app_ver", C1192k.m8303n(context));
                        contentValues.put("ts", Long.valueOf(currentTimeMillis));
                        if (obj != null) {
                            this.f5388c.getWritableDatabase().update("user", contentValues, "uid=?", new String[]{r9});
                        }
                        if (i3 != i) {
                            this.f5388c.getWritableDatabase().replace("user", null, contentValues);
                        }
                        obj = 1;
                    }
                    if (obj == null) {
                        string = C1192k.m8284b(context);
                        b = C1192k.m8286c(context);
                        String str2 = (b == null || b.length() <= 0) ? string : string + "," + b;
                        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                        String n = C1192k.m8303n(context);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("uid", C1198q.m8334b(str2));
                        contentValues2.put("user_type", Integer.valueOf(0));
                        contentValues2.put("app_ver", n);
                        contentValues2.put("ts", Long.valueOf(currentTimeMillis2));
                        this.f5388c.getWritableDatabase().insert("user", null, contentValues2);
                        this.f5387b = new C1182a(string, b, 0);
                    }
                    this.f5388c.getWritableDatabase().setTransactionSuccessful();
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable th2) {
                            f5383h.m8242e(th2);
                        }
                    }
                    this.f5388c.getWritableDatabase().endTransaction();
                } catch (Throwable th3) {
                    th2 = th3;
                    if (query != null) {
                        query.close();
                    }
                    this.f5388c.getWritableDatabase().endTransaction();
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                query = null;
                if (query != null) {
                    query.close();
                }
                this.f5388c.getWritableDatabase().endTransaction();
                throw th2;
            }
            c1182a = this.f5387b;
        }
        return c1182a;
    }

    /* renamed from: c */
    void m8233c() {
        if (StatConfig.isEnableStatService()) {
            try {
                this.f5390e.m8255a(new ax(this));
            } catch (Throwable th) {
                f5383h.m8242e(th);
            }
        }
    }

    /* renamed from: d */
    void m8234d() {
        Cursor query;
        Throwable th;
        try {
            query = this.f5388c.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (query.moveToNext()) {
                try {
                    int i = query.getInt(0);
                    String string = query.getString(1);
                    String string2 = query.getString(2);
                    int i2 = query.getInt(3);
                    C1202f c1202f = new C1202f(i);
                    c1202f.f5511a = i;
                    c1202f.f5512b = new JSONObject(string);
                    c1202f.f5513c = string2;
                    c1202f.f5514d = i2;
                    StatConfig.m8091a(f5384i, c1202f);
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }
}
