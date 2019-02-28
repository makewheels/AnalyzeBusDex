package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;

class ao extends FrameLayout implements OnErrorListener {
    /* renamed from: a */
    private Object f4973a;
    /* renamed from: b */
    private aq f4974b;
    /* renamed from: c */
    private VideoView f4975c;
    /* renamed from: d */
    private Context f4976d = null;
    /* renamed from: e */
    private String f4977e;

    public ao(Context context) {
        super(context.getApplicationContext());
        this.f4976d = context;
    }

    /* renamed from: b */
    private void m7758b(Bundle bundle, Object obj) {
        m7759a();
        boolean z = false;
        if (m7763b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.f4974b.m7810a(this.f4973a, bundle, this, obj);
        }
        if (!z) {
            if (this.f4975c != null) {
                this.f4975c.stopPlayback();
            }
            if (this.f4975c == null) {
                this.f4975c = new VideoView(getContext());
            }
            this.f4977e = bundle.getString("videoUrl");
            this.f4975c.setVideoURI(Uri.parse(this.f4977e));
            this.f4975c.setOnErrorListener(this);
            Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
            intent.addFlags(268435456);
            Context applicationContext = getContext().getApplicationContext();
            intent.setPackage(applicationContext.getPackageName());
            applicationContext.startActivity(intent);
        }
    }

    /* renamed from: a */
    void m7759a() {
        setBackgroundColor(-16777216);
        if (this.f4974b == null) {
            C1110i.m7845a(true).m7853a(getContext().getApplicationContext());
            ap a = C1110i.m7845a(true).m7852a();
            DexLoader dexLoader = null;
            if (a != null) {
                dexLoader = a.m7806o();
            }
            if (dexLoader != null && QbSdk.canLoadVideo(getContext())) {
                this.f4974b = new aq(dexLoader);
            }
        }
        if (this.f4974b != null && this.f4973a == null) {
            this.f4973a = this.f4974b.m7807a(getContext().getApplicationContext());
        }
    }

    /* renamed from: a */
    public void m7760a(Activity activity) {
        if (!m7763b() && this.f4975c != null) {
            if (this.f4975c.getParent() == null) {
                Window window = activity.getWindow();
                FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                window.addFlags(1024);
                window.addFlags(128);
                frameLayout.setBackgroundColor(-16777216);
                MediaController mediaController = new MediaController(activity);
                mediaController.setMediaPlayer(this.f4975c);
                this.f4975c.setMediaController(mediaController);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                layoutParams.gravity = 17;
                frameLayout.addView(this.f4975c, layoutParams);
            }
            if (VERSION.SDK_INT >= 8) {
                this.f4975c.start();
            }
        }
    }

    /* renamed from: a */
    void m7761a(Activity activity, int i) {
        if (!(i != 3 || m7763b() || this.f4975c == null)) {
            this.f4975c.pause();
        }
        if (i == 4) {
            this.f4976d = null;
            if (!(m7763b() || this.f4975c == null)) {
                this.f4975c.stopPlayback();
                this.f4975c = null;
            }
        }
        if (i == 2 && !m7763b()) {
            this.f4976d = activity;
            m7760a(activity);
        }
        if (m7763b()) {
            this.f4974b.m7809a(this.f4973a, activity, i);
        }
    }

    /* renamed from: a */
    void m7762a(Bundle bundle, Object obj) {
        m7758b(bundle, obj);
    }

    /* renamed from: b */
    public boolean m7763b() {
        return (this.f4974b == null || this.f4973a == null) ? false : true;
    }

    /* renamed from: c */
    public void m7764c() {
        if (m7763b()) {
            this.f4974b.m7808a(this.f4973a);
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (this.f4976d instanceof Activity) {
                Activity activity = (Activity) this.f4976d;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context = getContext();
            if (context != null) {
                Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                context = context.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(this.f4977e), "video/*");
                context.startActivity(intent);
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
