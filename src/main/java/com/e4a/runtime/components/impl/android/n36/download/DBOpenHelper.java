package com.e4a.runtime.components.impl.android.n36.download;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(Context context) {
        super(context, "download.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE info(path VARCHAR(1024), thid INTEGER, done INTEGER, PRIMARY KEY(path, thid))");
            if (!db.isOpen() || db != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (db.isOpen() && db != null) {
            }
        } catch (Throwable th) {
            if (db.isOpen() && db == null) {
            }
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
