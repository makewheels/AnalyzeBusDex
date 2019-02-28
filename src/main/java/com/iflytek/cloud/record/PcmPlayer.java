package com.iflytek.cloud.record;

import android.content.Context;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.cloud.p023b.p024e.C0946e;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.record.C0956a.C0955a;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechError;

public class PcmPlayer {
    /* renamed from: a */
    OnAudioFocusChangeListener f4509a = new C0957b(this);
    /* renamed from: b */
    private AudioTrack f4510b = null;
    /* renamed from: c */
    private C0956a f4511c = null;
    /* renamed from: d */
    private Context f4512d = null;
    /* renamed from: e */
    private C0954b f4513e = null;
    /* renamed from: f */
    private C0953a f4514f = null;
    /* renamed from: g */
    private volatile PLAY_STATE f4515g = PLAY_STATE.INIT;
    /* renamed from: h */
    private int f4516h = 3;
    /* renamed from: i */
    private boolean f4517i = true;
    /* renamed from: j */
    private int f4518j;
    /* renamed from: k */
    private boolean f4519k = false;
    /* renamed from: l */
    private boolean f4520l = false;
    /* renamed from: m */
    private Object f4521m = new Object();
    /* renamed from: n */
    private int f4522n = 0;
    /* renamed from: o */
    private Handler f4523o = new C0958c(this, Looper.getMainLooper());

    public enum PLAY_STATE {
        INIT,
        BUFFERING,
        PLAYING,
        PAUSED,
        STOPED
    }

    /* renamed from: com.iflytek.cloud.record.PcmPlayer$a */
    public interface C0953a {
        /* renamed from: a */
        void mo1607a();

        /* renamed from: a */
        void mo1608a(int i, int i2, int i3);

        /* renamed from: a */
        void mo1609a(SpeechError speechError);

        /* renamed from: b */
        void mo1610b();

        /* renamed from: c */
        void mo1611c();
    }

    /* renamed from: com.iflytek.cloud.record.PcmPlayer$b */
    private class C0954b extends Thread {
        /* renamed from: a */
        final /* synthetic */ PcmPlayer f4508a;

        private C0954b(PcmPlayer pcmPlayer) {
            this.f4508a = pcmPlayer;
        }

        public void run() {
            PcmPlayer pcmPlayer;
            C0939a.m7121a("PcmPlayer", "start player");
            C0939a.m7121a("PcmPlayer", "mAudioFocus= " + this.f4508a.f4517i);
            if (this.f4508a.f4517i) {
                C0946e.m7146a(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), this.f4508a.f4509a);
            } else {
                C0946e.m7146a(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), null);
            }
            C0946e.m7146a(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), this.f4508a.f4509a);
            this.f4508a.f4511c.m7235c();
            if (!(this.f4508a.f4515g == PLAY_STATE.STOPED || this.f4508a.f4515g == PLAY_STATE.PAUSED)) {
                this.f4508a.f4515g = PLAY_STATE.PLAYING;
            }
            while (this.f4508a.f4515g != PLAY_STATE.STOPED) {
                this.f4508a.m7213g();
                if (this.f4508a.f4515g == PLAY_STATE.PLAYING || this.f4508a.f4515g == PLAY_STATE.BUFFERING) {
                    if (this.f4508a.f4511c.m7239g()) {
                        if (this.f4508a.f4515g == PLAY_STATE.BUFFERING) {
                            this.f4508a.f4515g = PLAY_STATE.PLAYING;
                            Message.obtain(this.f4508a.f4523o, 2).sendToTarget();
                        }
                        int d = this.f4508a.f4511c.m7236d();
                        C0955a e = this.f4508a.f4511c.m7237e();
                        if (e != null) {
                            this.f4508a.f4522n = e.f4527d;
                            Message.obtain(this.f4508a.f4523o, 3, d, e.f4526c).sendToTarget();
                        }
                        if (this.f4508a.f4510b.getPlayState() != 3) {
                            this.f4508a.f4510b.play();
                        }
                        this.f4508a.f4511c.m7229a(this.f4508a.f4510b, this.f4508a.f4518j);
                    } else if (this.f4508a.f4511c.m7238f()) {
                        C0939a.m7120a("play stoped");
                        this.f4508a.f4515g = PLAY_STATE.STOPED;
                        Message.obtain(this.f4508a.f4523o, 4).sendToTarget();
                        break;
                    } else {
                        try {
                            if (this.f4508a.f4515g == PLAY_STATE.PLAYING) {
                                C0939a.m7120a("play onpaused!");
                                this.f4508a.f4515g = PLAY_STATE.BUFFERING;
                                Message.obtain(this.f4508a.f4523o, 1).sendToTarget();
                            }
                            C0954b.sleep(50);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            Message.obtain(this.f4508a.f4523o, 0, new SpeechError((int) ErrorCode.ERROR_PLAY_MEDIA)).sendToTarget();
                            this.f4508a.f4515g = PLAY_STATE.STOPED;
                            if (this.f4508a.f4510b != null) {
                                this.f4508a.f4510b.release();
                                this.f4508a.f4510b = null;
                            }
                            if (this.f4508a.f4517i) {
                                C0946e.m7147b(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), this.f4508a.f4509a);
                            } else {
                                C0946e.m7147b(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), null);
                            }
                            pcmPlayer = this.f4508a;
                        } catch (Throwable th) {
                            this.f4508a.f4515g = PLAY_STATE.STOPED;
                            if (this.f4508a.f4510b != null) {
                                this.f4508a.f4510b.release();
                                this.f4508a.f4510b = null;
                            }
                            if (this.f4508a.f4517i) {
                                C0946e.m7147b(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), this.f4508a.f4509a);
                            } else {
                                C0946e.m7147b(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), null);
                            }
                            this.f4508a.f4513e = null;
                        }
                    }
                } else if (this.f4508a.f4515g == PLAY_STATE.PAUSED) {
                    if (2 != this.f4508a.f4510b.getPlayState()) {
                        this.f4508a.f4510b.pause();
                    }
                    C0954b.sleep(50);
                }
            }
            if (this.f4508a.f4510b != null) {
                this.f4508a.f4510b.stop();
            }
            this.f4508a.f4515g = PLAY_STATE.STOPED;
            if (this.f4508a.f4510b != null) {
                this.f4508a.f4510b.release();
                this.f4508a.f4510b = null;
            }
            if (this.f4508a.f4517i) {
                C0946e.m7147b(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), this.f4508a.f4509a);
            } else {
                C0946e.m7147b(this.f4508a.f4512d, Boolean.valueOf(this.f4508a.f4519k), null);
            }
            pcmPlayer = this.f4508a;
            pcmPlayer.f4513e = null;
        }
    }

    public PcmPlayer(Context context, int i, boolean z) {
        this.f4512d = context;
        this.f4516h = i;
        this.f4519k = z;
    }

    /* renamed from: a */
    private void m7204a(PLAY_STATE play_state) {
        this.f4515g = play_state;
    }

    /* renamed from: f */
    private void m7211f() throws Exception {
        C0939a.m7121a("PcmPlayer", "createAudio start");
        int a = this.f4511c.m7228a();
        this.f4518j = AudioTrack.getMinBufferSize(a, 2, 2);
        if (this.f4510b != null) {
            m7221b();
        }
        C0939a.m7121a("PcmPlayer", "createAudio || mStreamType = " + this.f4516h);
        this.f4510b = new AudioTrack(this.f4516h, a, 2, 2, this.f4518j * 2, 1);
        if (this.f4518j == -2 || this.f4518j == -1) {
            throw new Exception();
        }
        C0939a.m7121a("PcmPlayer", "createAudio end");
    }

    /* renamed from: g */
    private void m7213g() throws Exception {
        if (this.f4510b == null || this.f4510b.getStreamType() != this.f4516h) {
            C0939a.m7121a("PcmPlayer", "prepAudioPlayer || audiotrack stream type is change.");
            m7211f();
        }
    }

    /* renamed from: a */
    public PLAY_STATE m7219a() {
        return this.f4515g;
    }

    /* renamed from: a */
    public boolean m7220a(C0956a c0956a, C0953a c0953a) {
        C0939a.m7121a("PcmPlayer", "play mPlaytate= " + this.f4515g + ",mAudioFocus= " + this.f4517i);
        if (this.f4515g != PLAY_STATE.STOPED && this.f4515g != PLAY_STATE.INIT && this.f4515g != PLAY_STATE.PAUSED && this.f4513e != null) {
            return false;
        }
        this.f4511c = c0956a;
        this.f4514f = c0953a;
        this.f4513e = new C0954b();
        this.f4513e.start();
        return true;
    }

    /* renamed from: b */
    public void m7221b() {
        synchronized (this.f4521m) {
            if (this.f4510b != null) {
                if (this.f4510b.getPlayState() == 3) {
                    this.f4510b.stop();
                }
                this.f4510b.release();
                this.f4510b = null;
            }
            C0939a.m7121a("PcmPlayer", "mAudioTrack released");
        }
    }

    /* renamed from: b */
    public boolean m7222b(C0956a c0956a, C0953a c0953a) {
        m7204a(PLAY_STATE.INIT);
        return m7220a(c0956a, c0953a);
    }

    /* renamed from: c */
    public boolean m7223c() {
        if (this.f4515g == PLAY_STATE.STOPED || this.f4515g == PLAY_STATE.PAUSED) {
            return false;
        }
        this.f4515g = PLAY_STATE.PAUSED;
        return true;
    }

    /* renamed from: d */
    public boolean m7224d() {
        if (this.f4515g != PLAY_STATE.PAUSED) {
            return false;
        }
        this.f4515g = PLAY_STATE.PLAYING;
        return true;
    }

    /* renamed from: e */
    public void m7225e() {
        this.f4515g = PLAY_STATE.STOPED;
    }
}
