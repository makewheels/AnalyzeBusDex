package com.e4a.runtime.components.impl.android.n73;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.e4a.runtime.android.mainActivity;
import com.e4a.runtime.components.ComponentContainer;
import com.e4a.runtime.components.impl.ComponentImpl;
import com.e4a.runtime.events.EventDispatcher;

/* renamed from: com.e4a.runtime.components.impl.android.n73.状态栏通知Impl */
public class C0770Impl extends ComponentImpl implements C0768 {
    private String FLAG = "E4Anotification";
    private BroadcastReceiver mReceiver;
    private NotificationManager notificationManager = ((NotificationManager) mainActivity.getContext().getSystemService("notification"));

    /* renamed from: com.e4a.runtime.components.impl.android.n73.状态栏通知Impl$1 */
    class C07691 extends BroadcastReceiver {
        C07691() {
        }

        public void onReceive(Context arg0, Intent arg1) {
            String actionStr = arg1.getAction();
            int ID = arg1.getIntExtra("ID", 0);
            if (actionStr.equals(C0770Impl.this.FLAG)) {
                C0770Impl.this.mo1267(ID);
            }
        }
    }

    public C0770Impl(ComponentContainer container) {
        super(container);
        m6216();
    }

    /* renamed from: 注册广播监听 */
    private void m6216() {
        this.mReceiver = new C07691();
        IntentFilter filter = new IntentFilter();
        filter.addAction(this.FLAG);
        mainActivity.getContext().registerReceiver(this.mReceiver, filter);
    }

    /* renamed from: 添加通知 */
    public void mo1265(int ID, String name, String title, String text, int iconId, boolean sound, boolean noclear) {
        Intent clickIntent = new Intent();
        clickIntent.setAction(this.FLAG);
        clickIntent.putExtra("ID", ID);
        PendingIntent contentItent = PendingIntent.getBroadcast(mainActivity.getContext(), ID, clickIntent, 134217728);
        Builder builder = new Builder(mainActivity.getContext());
        builder.setSmallIcon(iconId).setTicker(name).setWhen(System.currentTimeMillis()).setContentTitle(title).setContentText(text).setContentIntent(contentItent);
        Notification notification = builder.getNotification();
        if (noclear) {
            notification.flags |= 2;
            notification.flags |= 32;
        } else {
            notification.flags = 16;
        }
        if (sound) {
            notification.defaults = 1;
        }
        this.notificationManager.notify(ID, notification);
    }

    /* renamed from: 添加下载进度通知 */
    public void mo1264(int ID, String name, String title, int progress) {
        if (VERSION.SDK_INT >= 11) {
            int iconid;
            Intent clickIntent = new Intent();
            clickIntent.setAction(this.FLAG);
            clickIntent.putExtra("ID", ID);
            PendingIntent contentIntent = PendingIntent.getBroadcast(mainActivity.getContext(), ID, clickIntent, 134217728);
            Builder builder = new Builder(mainActivity.getContext());
            if (progress == 100) {
                iconid = 17301634;
            } else {
                iconid = 17301633;
            }
            builder.setSmallIcon(iconid).setTicker(name).setWhen(System.currentTimeMillis()).setContentTitle(title).setContentText(Integer.toString(progress) + "%").setProgress(100, progress, false).setContentIntent(contentIntent);
            this.notificationManager.notify(ID, builder.getNotification());
        }
    }

    /* renamed from: 通知被单击 */
    public void mo1267(int ID) {
        EventDispatcher.dispatchEvent(this, "通知被单击", Integer.valueOf(ID));
    }

    /* renamed from: 删除通知 */
    public void mo1263(int ID) {
        this.notificationManager.cancel(ID);
    }

    /* renamed from: 清空通知 */
    public void mo1266() {
        this.notificationManager.cancelAll();
    }
}
