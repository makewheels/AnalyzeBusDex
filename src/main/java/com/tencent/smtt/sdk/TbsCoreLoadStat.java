package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Arrays;
import p054u.aly.bi_常量类;

public class TbsCoreLoadStat {
    /* renamed from: d */
    private static TbsCoreLoadStat f4821d = null;
    /* renamed from: a */
    private TbsSequenceQueue f4822a = null;
    /* renamed from: b */
    private boolean f4823b = false;
    /* renamed from: c */
    private final int f4824c = 3;

    public class TbsSequenceQueue {
        /* renamed from: a */
        final /* synthetic */ TbsCoreLoadStat f4815a;
        /* renamed from: b */
        private int f4816b;
        /* renamed from: c */
        private int f4817c;
        /* renamed from: d */
        private int[] f4818d;
        /* renamed from: e */
        private int f4819e;
        /* renamed from: f */
        private int f4820f;

        public TbsSequenceQueue(TbsCoreLoadStat tbsCoreLoadStat) {
            this.f4815a = tbsCoreLoadStat;
            this.f4816b = 10;
            this.f4819e = 0;
            this.f4820f = 0;
            this.f4817c = this.f4816b;
            this.f4818d = new int[this.f4817c];
        }

        public TbsSequenceQueue(TbsCoreLoadStat tbsCoreLoadStat, int i, int i2) {
            this.f4815a = tbsCoreLoadStat;
            this.f4816b = 10;
            this.f4819e = 0;
            this.f4820f = 0;
            this.f4817c = i2;
            this.f4818d = new int[this.f4817c];
            this.f4818d[0] = i;
            this.f4820f++;
        }

        public void add(int i) {
            if (this.f4820f > this.f4817c - 1) {
                throw new IndexOutOfBoundsException("sequeue is full");
            }
            int[] iArr = this.f4818d;
            int i2 = this.f4820f;
            this.f4820f = i2 + 1;
            iArr[i2] = i;
        }

        public void clear() {
            Arrays.fill(this.f4818d, 0);
            this.f4819e = 0;
            this.f4820f = 0;
        }

        public int element() {
            if (!empty()) {
                return this.f4818d[this.f4819e];
            }
            throw new IndexOutOfBoundsException("sequeue is null");
        }

        public boolean empty() {
            return this.f4820f == this.f4819e;
        }

        public int length() {
            return this.f4820f - this.f4819e;
        }

        public int remove() {
            if (empty()) {
                throw new IndexOutOfBoundsException("sequeue is null");
            }
            int i = this.f4818d[this.f4819e];
            int[] iArr = this.f4818d;
            int i2 = this.f4819e;
            this.f4819e = i2 + 1;
            iArr[i2] = 0;
            return i;
        }

        public String toString() {
            if (empty()) {
                return bi_常量类.f6358b;
            }
            int i;
            StringBuilder stringBuilder = new StringBuilder("[");
            for (i = this.f4819e; i < this.f4820f; i++) {
                stringBuilder.append(String.valueOf(this.f4818d[i]) + ",");
            }
            i = stringBuilder.length();
            return stringBuilder.delete(i - 1, i).append("]").toString();
        }
    }

    private TbsCoreLoadStat() {
    }

    /* renamed from: a */
    private File m7555a(Context context, String str) {
        ac.m7706a();
        File h = ac.m7722h(context);
        if (h == null) {
            return null;
        }
        File file = new File(h, str);
        if (file != null && file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private FileLock m7556a(Context context, FileOutputStream fileOutputStream) {
        if (fileOutputStream == null) {
            return null;
        }
        try {
            FileLock tryLock = fileOutputStream.getChannel().tryLock();
            return tryLock.isValid() ? tryLock : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m7557a(int i) {
        if (this.f4822a != null) {
            this.f4822a.add(i);
        } else {
            this.f4822a = new TbsSequenceQueue(this, i, 3);
        }
    }

    /* renamed from: a */
    private void m7558a(Context context) {
        Object obj = 1;
        FileOutputStream b = m7560b(context);
        if (b != null) {
            FileLock a = m7556a(context, b);
            if (a != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("tbs_load_stat_flag", 4);
                String tbsSequenceQueue = this.f4822a.toString();
                String string = sharedPreferences.getString(tbsSequenceQueue, bi_常量类.f6358b);
                CharSequence charSequence = String.valueOf(ac.m7706a().m7744c(context)) + ";";
                if (sharedPreferences.contains(tbsSequenceQueue) && string.contains(charSequence)) {
                    obj = null;
                }
                if (obj != null) {
                    TbsLogReport.m7589a(context).m7609b(ErrorCode.ERROR_CODE_LOAD_BASE, tbsSequenceQueue);
                    String str = string + charSequence;
                    Editor edit = sharedPreferences.edit();
                    edit.putString(tbsSequenceQueue, str);
                    edit.commit();
                }
                m7559a(a, b);
            }
        }
    }

    /* renamed from: a */
    private void m7559a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private FileOutputStream m7560b(Context context) {
        File a = m7555a(context, "tbs_report_lock.txt");
        if (a != null) {
            try {
                return new FileOutputStream(a);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m7561b(int i) {
        if (i == ErrorCode.INFO_DISABLE_X5 || i == ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_OUTER || i == ErrorCode.INFO_FORCE_SYSTEM_WEBVIEW_INNER) {
            this.f4823b = false;
        } else {
            this.f4823b = true;
        }
        if (this.f4823b && this.f4822a != null && this.f4822a.empty()) {
            this.f4823b = false;
        }
    }

    public static TbsCoreLoadStat getInstance() {
        if (f4821d == null) {
            f4821d = new TbsCoreLoadStat();
        }
        return f4821d;
    }

    /* renamed from: a */
    void m7562a() {
        if (this.f4822a != null) {
            this.f4822a.clear();
        }
        this.f4823b = false;
    }

    /* renamed from: a */
    void m7563a(Context context, int i) {
        m7564a(context, i, null);
        TbsLog.m7925e(TbsListener.tag_load_error, bi_常量类.f6358b + i);
    }

    /* renamed from: a */
    void m7564a(Context context, int i, Throwable th) {
        m7561b(i);
        if (this.f4823b) {
            m7557a(i);
            if (th != null) {
                TbsLogReport.m7589a(context).m7602a(i, th);
            }
            if (i == ErrorCode.INFO_CAN_NOT_LOAD_TBS) {
                m7558a(context);
                m7562a();
            }
        }
    }
}
