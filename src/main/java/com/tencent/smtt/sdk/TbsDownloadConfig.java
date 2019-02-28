package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;

class TbsDownloadConfig {
    /* renamed from: c */
    private static TbsDownloadConfig f4825c;
    /* renamed from: a */
    Map<String, Object> f4826a = new HashMap();
    /* renamed from: b */
    SharedPreferences f4827b;

    public interface TbsConfigKey {
        public static final String KEY_APP_METADATA = "app_metadata";
        public static final String KEY_APP_VERSIONCODE = "app_versioncode";
        public static final String KEY_APP_VERSIONCODE_FOR_SWITCH = "app_versioncode_for_switch";
        public static final String KEY_APP_VERSIONNAME = "app_versionname";
        public static final String KEY_DEVICE_CPUABI = "device_cpuabi";
        public static final String KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES = "tbs_download_failed_max_retrytimes";
        public static final String KEY_DOWNLOAD_FAILED_RETRYTIMES = "tbs_download_failed_retrytimes";
        public static final String KEY_DOWNLOAD_MAXFLOW = "tbs_download_maxflow";
        public static final String KEY_DOWNLOAD_MIN_FREE_SPACE = "tbs_download_min_free_space";
        public static final String KEY_DOWNLOAD_SINGLE_TIMEOUT = "tbs_single_timeout";
        public static final String KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES = "tbs_download_success_max_retrytimes";
        public static final String KEY_DOWNLOAD_SUCCESS_RETRYTIMES = "tbs_download_success_retrytimes";
        public static final String KEY_IS_OVERSEA = "is_oversea";
        public static final String KEY_LAST_CHECK = "last_check";
        public static final String KEY_NEEDDOWNLOAD = "tbs_needdownload";
        public static final String KEY_RESPONSECODE = "tbs_responsecode";
        public static final String KEY_RETRY_INTERVAL = "retry_interval";
        public static final String KEY_TBSAPKFILESIZE = "tbs_apkfilesize";
        public static final String KEY_TBSAPK_MD5 = "tbs_apk_md5";
        public static final String KEY_TBSDOWNLOADURL = "tbs_downloadurl";
        public static final String KEY_TBSDOWNLOAD_FLOW = "tbs_downloadflow";
        public static final String KEY_TBSDOWNLOAD_STARTTIME = "tbs_downloadstarttime";
        public static final String KEY_TBS_DOWNLOAD_V = "tbs_download_version";
    }

    private TbsDownloadConfig(Context context) {
        this.f4827b = context.getSharedPreferences("tbs_download_config", 4);
    }

    /* renamed from: a */
    public static synchronized TbsDownloadConfig m7565a(Context context) {
        TbsDownloadConfig tbsDownloadConfig;
        synchronized (TbsDownloadConfig.class) {
            if (f4825c == null) {
                f4825c = new TbsDownloadConfig(context);
            }
            tbsDownloadConfig = f4825c;
        }
        return tbsDownloadConfig;
    }

    /* renamed from: a */
    public synchronized long m7566a() {
        int i;
        i = this.f4827b.getInt(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, 0);
        if (i == 0) {
            i = 20;
        }
        return ((long) (i * 1024)) * 1024;
    }

    /* renamed from: b */
    public synchronized long m7567b() {
        return this.f4827b.getLong(TbsConfigKey.KEY_RETRY_INTERVAL, 86400);
    }

    /* renamed from: c */
    public synchronized long m7568c() {
        int i;
        i = this.f4827b.getInt(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, 0);
        if (i == 0) {
            i = 70;
        }
        return ((long) (i * 1024)) * 1024;
    }

    /* renamed from: d */
    public synchronized int m7569d() {
        int i;
        i = this.f4827b.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, 0);
        if (i == 0) {
            i = 3;
        }
        return i;
    }

    /* renamed from: e */
    public synchronized int m7570e() {
        int i;
        i = this.f4827b.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, 0);
        if (i == 0) {
            i = 100;
        }
        return i;
    }

    /* renamed from: f */
    public synchronized long m7571f() {
        long j;
        j = this.f4827b.getLong(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, 0);
        if (j == 0) {
            j = 1200000;
        }
        return j;
    }

    /* renamed from: g */
    public synchronized void m7572g() {
        Editor edit = this.f4827b.edit();
        for (String str : this.f4826a.keySet()) {
            Object obj = this.f4826a.get(str);
            if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else {
                try {
                    if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        edit.commit();
        this.f4826a.clear();
        return;
    }

    /* renamed from: h */
    public void m7573h() {
        try {
            this.f4826a.clear();
            Editor edit = this.f4827b.edit();
            edit.clear();
            edit.commit();
        } catch (Exception e) {
        }
    }
}
