package com.e4a.runtime.components.impl.android.n36.download;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.e4a.runtime.collections.C0683_集合类;
import com.e4a.runtime.variants.StringVariant;

public class InfoDao {
    String TAG = "InfoDao";
    private DBOpenHelper helper = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void delete(java.lang.String r7, int r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x002b in list [B:4:0x0022]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JavaClass.getDefinitionPosition(JavaClass.java:193)
*/
        /*
        r6 = this;
        r2 = r6.TAG;
        r3 = "delete";
        android.util.Log.d(r2, r3);
        r0 = 0;
        r2 = r6.helper;	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r0 = r2.getWritableDatabase();	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r2 = "DELETE FROM info WHERE path=? AND thid=?";	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r3 = 2;	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r3 = new java.lang.Object[r3];	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r4 = 0;	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r3[r4] = r7;	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r4 = 1;	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r5 = java.lang.Integer.valueOf(r8);	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r3[r4] = r5;	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        r0.execSQL(r2, r3);	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        if (r0 == 0) goto L_0x002b;
    L_0x0022:
        r2 = r0.isOpen();
        if (r2 == 0) goto L_0x002b;
    L_0x0028:
        r0.close();
    L_0x002b:
        return;
    L_0x002c:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ SQLException -> 0x002c, all -> 0x003c }
        if (r0 == 0) goto L_0x002b;
    L_0x0032:
        r2 = r0.isOpen();
        if (r2 == 0) goto L_0x002b;
    L_0x0038:
        r0.close();
        goto L_0x002b;
    L_0x003c:
        r2 = move-exception;
        if (r0 == 0) goto L_0x0048;
    L_0x003f:
        r3 = r0.isOpen();
        if (r3 == 0) goto L_0x0048;
    L_0x0045:
        r0.close();
    L_0x0048:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e4a.runtime.components.impl.android.n36.download.InfoDao.delete(java.lang.String, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteAll(java.lang.String r8, int r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0049 in list [B:12:0x0040]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JavaClass.getDefinitionPosition(JavaClass.java:193)
*/
        /*
        r7 = this;
        r4 = r7.TAG;
        r5 = "deleteAll";
        android.util.Log.d(r4, r5);
        r1 = 0;
        r0 = 0;
        r4 = r7.helper;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r1 = r4.getWritableDatabase();	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r4 = "SELECT SUM(done) FROM info WHERE path=?";	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r5 = 1;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r5 = new java.lang.String[r5];	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r6 = 0;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r5[r6] = r8;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r0 = r1.rawQuery(r4, r5);	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r4 = r0.moveToNext();	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        if (r4 == 0) goto L_0x0033;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
    L_0x0021:
        r4 = 0;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r3 = r0.getInt(r4);	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        if (r3 != r9) goto L_0x0033;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
    L_0x0028:
        r4 = "DELETE FROM info WHERE path=? ";	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r5 = 1;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r5 = new java.lang.Object[r5];	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r6 = 0;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r5[r6] = r8;	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        r1.execSQL(r4, r5);	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
    L_0x0033:
        if (r0 == 0) goto L_0x003e;
    L_0x0035:
        r4 = r0.isClosed();
        if (r4 != 0) goto L_0x003e;
    L_0x003b:
        r0.close();
    L_0x003e:
        if (r1 == 0) goto L_0x0049;
    L_0x0040:
        r4 = r1.isOpen();
        if (r4 == 0) goto L_0x0049;
    L_0x0046:
        r1.close();
    L_0x0049:
        return;
    L_0x004a:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ SQLException -> 0x004a, all -> 0x0065 }
        if (r0 == 0) goto L_0x0059;
    L_0x0050:
        r4 = r0.isClosed();
        if (r4 != 0) goto L_0x0059;
    L_0x0056:
        r0.close();
    L_0x0059:
        if (r1 == 0) goto L_0x0049;
    L_0x005b:
        r4 = r1.isOpen();
        if (r4 == 0) goto L_0x0049;
    L_0x0061:
        r1.close();
        goto L_0x0049;
    L_0x0065:
        r4 = move-exception;
        if (r0 == 0) goto L_0x0071;
    L_0x0068:
        r5 = r0.isClosed();
        if (r5 != 0) goto L_0x0071;
    L_0x006e:
        r0.close();
    L_0x0071:
        if (r1 == 0) goto L_0x007c;
    L_0x0073:
        r5 = r1.isOpen();
        if (r5 == 0) goto L_0x007c;
    L_0x0079:
        r1.close();
    L_0x007c:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e4a.runtime.components.impl.android.n36.download.InfoDao.deleteAll(java.lang.String, int):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteAll2(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0024 in list [B:4:0x001b]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:43)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JavaClass.getDefinitionPosition(JavaClass.java:193)
*/
        /*
        r5 = this;
        r2 = r5.TAG;
        r3 = "deleteAll2";
        android.util.Log.d(r2, r3);
        r0 = 0;
        r2 = r5.helper;	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        r0 = r2.getWritableDatabase();	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        r2 = "DELETE FROM info WHERE path=?";	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        r3 = 1;	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        r3 = new java.lang.Object[r3];	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        r4 = 0;	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        r3[r4] = r6;	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        r0.execSQL(r2, r3);	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        if (r0 == 0) goto L_0x0024;
    L_0x001b:
        r2 = r0.isOpen();
        if (r2 == 0) goto L_0x0024;
    L_0x0021:
        r0.close();
    L_0x0024:
        return;
    L_0x0025:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ SQLException -> 0x0025, all -> 0x0035 }
        if (r0 == 0) goto L_0x0024;
    L_0x002b:
        r2 = r0.isOpen();
        if (r2 == 0) goto L_0x0024;
    L_0x0031:
        r0.close();
        goto L_0x0024;
    L_0x0035:
        r2 = move-exception;
        if (r0 == 0) goto L_0x0041;
    L_0x0038:
        r3 = r0.isOpen();
        if (r3 == 0) goto L_0x0041;
    L_0x003e:
        r0.close();
    L_0x0041:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.e4a.runtime.components.impl.android.n36.download.InfoDao.deleteAll2(java.lang.String):void");
    }

    public InfoDao(Context context) {
        this.helper = new DBOpenHelper(context);
    }

    public synchronized void insert(Info info) {
        Log.d(this.TAG, "insert");
        SQLiteDatabase db = null;
        try {
            db = this.helper.getWritableDatabase();
            db.execSQL("INSERT INTO info(path, thid, done) VALUES(?, ?, ?)", new Object[]{info.getPath(), info.getThid(), info.getDone()});
            if (db != null) {
                if (db.isOpen()) {
                    db.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (db != null) {
                if (db.isOpen()) {
                    db.close();
                }
            }
        } catch (Throwable th) {
            if (db != null) {
                if (db.isOpen()) {
                    db.close();
                }
            }
        }
    }

    public synchronized void update(Info info) {
        Log.d(this.TAG, "update");
        SQLiteDatabase db = null;
        try {
            db = this.helper.getWritableDatabase();
            db.execSQL("UPDATE info SET done=? WHERE path=? AND thid=?", new Object[]{info.getDone(), info.getPath(), info.getThid()});
            if (db != null) {
                if (db.isOpen()) {
                    db.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (db != null) {
                if (db.isOpen()) {
                    db.close();
                }
            }
        } catch (Throwable th) {
            if (db != null) {
                if (db.isOpen()) {
                    db.close();
                }
            }
        }
    }

    public synchronized Info query(String path, int thid) {
        Info info;
        Log.d(this.TAG, "query");
        SQLiteDatabase db = null;
        Cursor c = null;
        info = null;
        try {
            db = this.helper.getReadableDatabase();
            c = db.rawQuery("SELECT path, thid, done FROM info WHERE path=? AND thid=?", new String[]{path, String.valueOf(thid)});
            info = null;
            if (c.moveToNext()) {
                info = new Info(c.getString(0), Integer.valueOf(c.getInt(1)), Integer.valueOf(c.getInt(2)));
            }
            if (c != null) {
                if (!c.isClosed()) {
                    c.close();
                }
            }
            if (db != null && db.isOpen()) {
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (c != null) {
                if (!c.isClosed()) {
                    c.close();
                }
            }
            if (db != null && db.isOpen()) {
                db.close();
            }
        } catch (Throwable th) {
            if (c != null) {
                if (!c.isClosed()) {
                    c.close();
                }
            }
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return info;
    }

    public C0683_集合类 queryUndone() {
        Log.d(this.TAG, "queryUndone");
        SQLiteDatabase db = null;
        Cursor c = null;
        C0683_集合类 pathList = new C0683_集合类();
        try {
            db = this.helper.getReadableDatabase();
            c = db.rawQuery("SELECT DISTINCT path FROM info", null);
            while (c.moveToNext()) {
                pathList.m5454_集合add元素(StringVariant.getStringVariant(c.getString(0)));
            }
            if (!(c == null || c.isClosed())) {
                c.close();
            }
            if (db != null && db.isOpen()) {
                db.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return pathList;
        } finally {
            if (!(c == null || c.isClosed())) {
                c.close();
            }
            if (db != null && db.isOpen()) {
                db.close();
            }
        }
        return pathList;
    }
}
