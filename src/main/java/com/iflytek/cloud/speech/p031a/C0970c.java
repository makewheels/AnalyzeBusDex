package com.iflytek.cloud.speech.p031a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p025b.C0931d;
import com.iflytek.cloud.p023b.p028d.C0936a;
import com.iflytek.cloud.p023b.p028d.C0937b;
import com.iflytek.cloud.p023b.p028d.C0938c;
import com.iflytek.cloud.p030c.C0950a;
import com.iflytek.cloud.record.C0956a;
import com.iflytek.cloud.record.PcmPlayer;
import com.iflytek.cloud.record.PcmPlayer.C0953a;
import com.iflytek.cloud.record.PcmPlayer.PLAY_STATE;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechSynthesizer;
import com.iflytek.cloud.speech.SynthesizeToUriListener;
import com.iflytek.cloud.speech.SynthesizerListener;

/* renamed from: com.iflytek.cloud.speech.a.c */
public class C0970c extends SpeechSynthesizer {
    /* renamed from: f */
    private static C0970c f4599f = null;
    /* renamed from: e */
    private Context f4600e = null;
    /* renamed from: g */
    private C0969a f4601g = null;

    /* renamed from: com.iflytek.cloud.speech.a.c$a */
    public class C0969a extends C0931d {
        /* renamed from: e */
        final /* synthetic */ C0970c f4589e;
        /* renamed from: f */
        private PcmPlayer f4590f = null;
        /* renamed from: g */
        private C0956a f4591g = null;
        /* renamed from: h */
        private SynthesizerListener f4592h = null;
        /* renamed from: i */
        private SynthesizeToUriListener f4593i = null;
        /* renamed from: j */
        private int f4594j = 0;
        /* renamed from: k */
        private boolean f4595k = false;
        /* renamed from: l */
        private C0937b f4596l = new C0971d(this);
        /* renamed from: m */
        private C0953a f4597m = new C0972e(this);
        /* renamed from: n */
        private Handler f4598n = new C0973f(this, Looper.getMainLooper());

        protected C0969a(C0970c c0970c, Context context) {
            this.f4589e = c0970c;
            super(context);
        }

        /* renamed from: a */
        public void m7271a(String str, C0950a c0950a, SynthesizerListener synthesizerListener) {
            this.f4592h = synthesizerListener;
            this.f4590f = new PcmPlayer(this.a, c0950a.m7166a(SpeechConstant.STREAM_TYPE, 3), c0950a.m7173a(SpeechConstant.KEY_REQUEST_FOCUS, true));
            this.d = new C0936a(this.a, c0950a);
            this.f4591g = new C0956a(this.a, this.d.m7045s(), c0950a.m7179d(SpeechConstant.TTS_AUDIO_PATH));
            this.f4591g.m7230a(str);
            this.f4594j = c0950a.m7166a(SpeechConstant.TTS_BUFFER_TIME, 0);
            C0939a.m7120a("minPlaySec:" + this.f4594j);
            this.f4595k = false;
            ((C0936a) this.d).m7103a(str, this.f4596l);
        }

        /* renamed from: a */
        public void m7272a(String str, String str2, C0950a c0950a, SynthesizeToUriListener synthesizeToUriListener) {
            this.f4593i = synthesizeToUriListener;
            this.d = new C0936a(this.a, c0950a);
            this.f4591g = new C0956a(this.a, this.d.m7045s(), str2);
            this.f4591g.m7230a(str);
            ((C0936a) this.d).m7103a(str, new C0975h(this, new C0974g(this, Looper.getMainLooper(), str2)));
        }

        /* renamed from: a */
        public void m7273a(boolean z) {
            if (m7277h()) {
                if (this.f4592h != null && z) {
                    this.f4592h.onCompleted(new SpeechError((int) ErrorCode.ERROR_INTERRUPT));
                }
                if (this.f4593i != null && z) {
                    this.f4592h.onCompleted(new SpeechError((int) ErrorCode.ERROR_INTERRUPT));
                }
                m7279j();
            }
        }

        public boolean destroy() {
            synchronized (this.b) {
                m7279j();
            }
            return true;
        }

        /* renamed from: e */
        public PLAY_STATE m7274e() {
            return (this.f4591g == null || this.f4590f == null) ? PLAY_STATE.STOPED : this.f4590f.m7219a();
        }

        /* renamed from: f */
        public void m7275f() {
            if (this.f4591g != null && this.f4590f != null) {
                this.f4590f.m7223c();
            }
        }

        /* renamed from: g */
        public void m7276g() {
            C0939a.m7120a("Session replay");
            if (this.f4591g != null && this.f4590f != null && PLAY_STATE.STOPED == this.f4590f.m7219a()) {
                this.f4590f.m7222b(this.f4591g, this.f4597m);
            }
        }

        /* renamed from: h */
        public boolean m7277h() {
            return m7090c() ? true : (m7274e() == PLAY_STATE.STOPED || m7274e() == PLAY_STATE.INIT) ? false : true;
        }

        /* renamed from: i */
        public void m7278i() {
            if (this.f4591g != null && this.f4590f != null) {
                this.f4590f.m7224d();
            }
        }

        /* renamed from: j */
        public void m7279j() {
            this.f4592h = null;
            this.f4593i = null;
            cancel();
            if (this.f4590f != null) {
                this.f4590f.m7225e();
            }
            if (this.f4591g != null) {
                this.f4591g.m7240h();
            }
        }
    }

    private C0970c(Context context) {
        super(context);
        this.f4600e = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C0970c m7280a(Context context) {
        if (f4599f == null) {
            f4599f = new C0970c(context);
        }
        return f4599f;
    }

    /* renamed from: e */
    public static C0970c m7281e() {
        return f4599f;
    }

    public boolean destroy() {
        cancel();
        boolean z = true;
        if (this.f4601g != null) {
            z = this.f4601g.destroy();
        }
        if (z) {
            f4599f = null;
        }
        return z;
    }

    public int getDownflowBytes(boolean z) {
        return z ? C0938c.m7109d("downflow") : C0936a.f4462b;
    }

    public int getUpflowBytes(boolean z) {
        return z ? C0938c.m7109d("upflow") : C0936a.f4461a;
    }

    public boolean isSpeaking() {
        return this.f4601g != null ? this.f4601g.m7277h() : false;
    }

    public void pauseSpeaking() {
        if (this.f4601g != null) {
            this.f4601g.m7275f();
        }
    }

    public void replaySpeaking() {
        C0939a.m7120a("Player replay");
        if (this.f4601g != null) {
            this.f4601g.m7276g();
        }
    }

    public void resumeSpeaking() {
        if (this.f4601g != null) {
            this.f4601g.m7278i();
        }
    }

    public void startSpeaking(String str, SynthesizerListener synthesizerListener) {
        if (this.f4601g != null && this.f4601g.m7277h()) {
            this.f4601g.m7273a(this.c.m7173a("tts_interrupt_error", false));
        }
        this.f4601g = new C0969a(this, this.f4600e);
        this.f4601g.m7271a(str, this.c, synthesizerListener);
    }

    public void stopSpeaking() {
        if (this.f4601g != null) {
            this.f4601g.m7279j();
        }
    }

    public void synthesizeToUri(String str, String str2, SynthesizeToUriListener synthesizeToUriListener) {
        if (this.f4601g != null && this.f4601g.m7277h()) {
            this.f4601g.m7273a(this.c.m7173a("tts_interrupt_error", false));
        }
        this.f4601g = new C0969a(this, this.f4600e);
        this.f4601g.m7272a(str, str2, this.c, synthesizeToUriListener);
    }
}
