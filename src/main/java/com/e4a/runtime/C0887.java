package com.e4a.runtime;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.e4a.runtime.annotations.SimpleFunction;
import com.e4a.runtime.annotations.SimpleObject;
import java.io.File;
import java.io.IOException;
import p054u.aly.bi_常量类;

@SimpleObject
/* renamed from: com.e4a.runtime.数据库操作 */
public final class C0887 {
    public static SQLiteDatabase db;

    private C0887() {
    }

    @SimpleFunction
    /* renamed from: 打开数据库 */
    public static void m6760(String DBName) {
        try {
            db = C0841.m6594().openOrCreateDatabase(DBName, 0, null);
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 关闭数据库 */
    public static void m6752() {
        try {
            db.close();
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 创建数据库 */
    public static boolean m6753(String DBName) {
        boolean result = false;
        File f = new File(DBName);
        if (f.exists()) {
            return false;
        }
        try {
            return f.createNewFile();
        } catch (IOException e) {
            return result;
        }
    }

    @SimpleFunction
    /* renamed from: 创建数据表 */
    public static void m6754(String bm, String lx) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + bm + " (" + lx + ")");
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 删除数据表 */
    public static void m6755(String BM) {
        try {
            db.execSQL("DROP TABLE " + BM);
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 插入记录 */
    public static void m6761(String BM, String nr) {
        try {
            db.execSQL("INSERT INTO " + BM + " VALUES (" + nr + ")");
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 删除记录 */
    public static void m6756(String BM, String hz) {
        try {
            db.execSQL("DELETE FROM " + BM + " WHERE " + hz);
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 修改记录 */
    public static void m6751(String BM, String xz, String yn) {
        try {
            db.execSQL("UPDATE " + BM + " SET " + xz + " WHERE " + yn);
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 条件查询 */
    public static String m6765(String BM, String hz, String SeperatorItem, String SeperatorLine) {
        String tmpvalue = bi_常量类.f6358b;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + BM + " WHERE " + hz, null);
            tmpvalue = bi_常量类.f6358b;
            while (cursor.moveToNext()) {
                int columnCount = cursor.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    tmpvalue = tmpvalue + cursor.getString(i) + SeperatorItem;
                }
                tmpvalue = tmpvalue + SeperatorLine;
            }
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Exception e) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
        return tmpvalue;
    }

    @SimpleFunction
    /* renamed from: 范围查询 */
    public static String m6767(String BM, int from, int to, String SeperatorItem, String SeperatorLine) {
        String tmpvalue = bi_常量类.f6358b;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + BM + " LIMIT " + Integer.toString(from) + "," + Integer.toString(to), null);
            tmpvalue = bi_常量类.f6358b;
            while (cursor.moveToNext()) {
                int columnCount = cursor.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    tmpvalue = tmpvalue + cursor.getString(i) + SeperatorItem;
                }
                tmpvalue = tmpvalue + SeperatorLine;
            }
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Exception e) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
        return tmpvalue;
    }

    @SimpleFunction
    /* renamed from: 查询最大值 */
    public static int m6766(String BM, String ziduan) {
        int tmpvalue = 0;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT max(" + ziduan + ") FROM " + BM, null);
            cursor.moveToFirst();
            tmpvalue = cursor.getInt(0);
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Exception e) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
        return tmpvalue;
    }

    @SimpleFunction
    /* renamed from: 数据库查询 */
    public static String m6763(String SQLSen, String SeperatorItem, String SeperatorLine) {
        String tmpvalue = bi_常量类.f6358b;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery(SQLSen, null);
            tmpvalue = bi_常量类.f6358b;
            while (cursor.moveToNext()) {
                int columnCount = cursor.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    tmpvalue = tmpvalue + cursor.getString(i) + SeperatorItem;
                }
                tmpvalue = tmpvalue + SeperatorLine;
            }
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Exception e) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
        return tmpvalue;
    }

    @SimpleFunction
    /* renamed from: 数据库执行 */
    public static void m6762(String SQLSen) {
        try {
            db.execSQL(SQLSen);
        } catch (Exception e) {
        }
    }

    @SimpleFunction
    /* renamed from: 取记录数 */
    public static long m6758(String TBName) {
        long count = 0;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("select count(*)from " + TBName, null);
            cursor.moveToFirst();
            count = cursor.getLong(0);
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Exception e) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
        return count;
    }

    @SimpleFunction
    /* renamed from: 数据表是否存在 */
    public static boolean m6764(String TBName) {
        int count = 0;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='" + TBName + "'", null);
            cursor.moveToFirst();
            count = cursor.getInt(0);
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Exception e) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
        if (count > 0) {
            return true;
        }
        return false;
    }

    @SimpleFunction
    /* renamed from: 字段是否存在 */
    public static boolean m6759(String tableName, String columnName) {
        boolean result = false;
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + tableName + " LIMIT 0", null);
            result = (cursor == null || cursor.getColumnIndex(columnName) == -1) ? false : true;
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Exception e) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (!(cursor == null || cursor.isClosed())) {
                cursor.close();
            }
        }
        return result;
    }

    @SimpleFunction
    /* renamed from: 取所有数据表 */
    public static String[] m6757() {
        Cursor cursor1 = db.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table'", null);
        cursor1.moveToFirst();
        int count = cursor1.getInt(0);
        cursor1.close();
        Cursor cursor2 = db.rawQuery("select name from sqlite_master where type='table' order by name", null);
        cursor2.moveToFirst();
        String[] result = new String[count];
        int temp = 0;
        while (cursor2.moveToNext()) {
            result[temp] = cursor2.getString(0);
            temp++;
        }
        cursor2.close();
        return result;
    }
}
