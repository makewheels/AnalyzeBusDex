package com.e4a.runtime.components.impl.android;

import android.app.IntentService;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.alipay.sdk.cons.C0108a;
import com.e4a.runtime.SerializableInfo;
import com.e4a.runtime.components.C0801;

/* renamed from: com.e4a.runtime.components.impl.android.后台服务Impl */
public class C0802Impl extends IntentService implements C0801 {
    private WakeLock wakelock;

    /* renamed from: 创建完毕 */
    public void mo765() {
    }

    public C0802Impl() {
        super(null);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        ((PowerManager) getSystemService("power")).newWakeLock(1, "E4AMyWakelockTag").acquire();
        mo1434();
    }

    /* renamed from: 服务被创建 */
    public void mo1434() {
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.wakelock != null) {
            this.wakelock.release();
        }
        mo1435();
    }

    /* renamed from: 服务被销毁 */
    public void mo1435() {
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        String param2 = intent.getStringExtra("前台运行");
        if (param2 != null && param2.equals(C0108a.f262e)) {
            SerializableInfo seri = (SerializableInfo) intent.getSerializableExtra("状态栏通知");
            int 通知ID = seri.getId();
            String 通知名称 = seri.m5411get();
            String 通知标题 = seri.m5412get();
            String 通知信息 = seri.m5410get();
            int 图标资源 = seri.geticonId();
            boolean 播放声音 = seri.getsound();
            boolean 不可清除 = seri.getnoclear();
            Intent clickIntent = new Intent();
            clickIntent.setAction("E4Anotification");
            clickIntent.putExtra("ID", 通知ID);
            PendingIntent contentItent = PendingIntent.getBroadcast(this, 通知ID, clickIntent, 134217728);
            Builder builder = new Builder(this);
            builder.setSmallIcon(图标资源).setTicker(通知名称).setWhen(System.currentTimeMillis()).setContentTitle(通知标题).setContentText(通知信息).setContentIntent(contentItent);
            Notification notification = builder.getNotification();
            if (不可清除) {
                notification.flags |= 2;
                notification.flags |= 32;
            } else {
                notification.flags = 16;
            }
            if (播放声音) {
                notification.defaults = 1;
            }
            startForeground(通知ID, notification);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    protected void onHandleIntent(Intent intent) {
        mo1433(intent.getStringExtra("参数"));
    }

    /* renamed from: 服务处理过程 */
    public void mo1433(String param) {
    }
}
