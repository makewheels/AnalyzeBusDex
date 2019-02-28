package com.iflytek.cloud.speech.p031a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.C0945d;
import com.iflytek.cloud.p023b.p024e.C0946e;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.p023b.p026a.C0921a;
import com.iflytek.cloud.p023b.p026a.C0925b;
import com.iflytek.cloud.p023b.p026a.C0926c;
import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechRecognizer;

/* renamed from: com.iflytek.cloud.speech.a.a */
public class C0967a extends SpeechRecognizer {
    /* renamed from: e */
    private boolean f4587e = false;

    /* renamed from: com.iflytek.cloud.speech.a.a$a */
    private final class C0966a implements RecognizerListener {
        /* renamed from: a */
        final /* synthetic */ C0967a f4583a;
        /* renamed from: b */
        private RecognizerListener f4584b = null;
        /* renamed from: c */
        private boolean f4585c = false;
        /* renamed from: d */
        private Handler f4586d = new C0968b(this, Looper.getMainLooper());

        public C0966a(C0967a c0967a, RecognizerListener recognizerListener) {
            this.f4583a = c0967a;
            this.f4584b = recognizerListener;
        }

        /* renamed from: a */
        protected void m7256a() {
            Object d = this.f4583a.d.m7049w().m7179d("aap");
            if (!TextUtils.isEmpty(d)) {
                C0945d.m7140a(((C0925b) this.f4583a.d).m7068b(), d);
            }
            C0946e.m7147b(this.f4583a.a, Boolean.valueOf(this.f4583a.f4587e), null);
        }

        public void onBeginOfSpeech() {
            C0939a.m7120a("onBeginOfSpeech");
            this.f4586d.sendMessage(this.f4586d.obtainMessage(2, 0, 0, null));
        }

        public void onEndOfSpeech() {
            this.f4586d.sendMessage(this.f4586d.obtainMessage(3, 0, 0, null));
        }

        public void onError(SpeechError speechError) {
            m7256a();
            this.f4586d.sendMessage(this.f4586d.obtainMessage(0, speechError));
        }

        public void onEvent(int i, int i2, int i3, String str) {
            Message message = new Message();
            message.what = i;
            message.arg1 = i2;
            message.arg2 = i3;
            message.obj = str;
            this.f4586d.sendMessage(this.f4586d.obtainMessage(6, 0, 0, message));
        }

        public void onResult(RecognizerResult recognizerResult, boolean z) {
            int i = 1;
            if (z) {
                m7256a();
            }
            Handler handler = this.f4586d;
            if (!z) {
                i = 0;
            }
            this.f4586d.sendMessage(handler.obtainMessage(4, i, 0, recognizerResult));
        }

        public void onVolumeChanged(int i) {
            this.f4586d.sendMessage(this.f4586d.obtainMessage(1, i, 0, null));
        }
    }

    public C0967a(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void m7261a(String str) {
        synchronized (this.b) {
            if (this.d != null) {
                this.d.m7034a(str);
            }
        }
    }

    public void cancel() {
        C0946e.m7147b(this.a, Boolean.valueOf(this.f4587e), null);
        super.cancel();
    }

    public int getDownflowBytes(boolean z) {
        int d;
        synchronized (this.b) {
            if (z) {
                d = C0921a.m7015d("downflow");
            } else {
                d = C0925b.f4406l;
            }
        }
        return d;
    }

    public int getUpflowBytes(boolean z) {
        int d;
        synchronized (this.b) {
            if (z) {
                d = C0921a.m7015d("upflow");
            } else {
                d = C0925b.f4405k;
            }
        }
        return d;
    }

    public boolean isListening() {
        return m7090c();
    }

    public void startListening(RecognizerListener recognizerListener) {
        synchronized (this.b) {
            this.f4587e = this.c.m7173a(SpeechConstant.KEY_REQUEST_FOCUS, true);
            if (this.c.m7166a(SpeechConstant.AUDIO_SOURCE, 1) == -1) {
                this.d = new C0926c(this.a, this.c);
            } else {
                this.d = new C0925b(this.a, this.c);
            }
            C0946e.m7146a(this.a, Boolean.valueOf(this.f4587e), null);
            ((C0925b) this.d).m7061a(new C0966a(this, recognizerListener));
        }
    }

    public void stopListening() {
        synchronized (this.b) {
            if (this.d != null) {
                ((C0925b) this.d).mo1576a(true);
            }
        }
    }

    public boolean writeAudio(byte[] bArr, int i, int i2) {
        synchronized (this.b) {
            if (this.d == null) {
                C0939a.m7120a("writeAudio error, no active session.");
                return false;
            } else if (bArr == null || bArr.length <= 0) {
                C0939a.m7120a("writeAudio error,buffer is null.");
                return false;
            } else if (bArr.length < i2 + i) {
                C0939a.m7120a("writeAudio error,buffer length < length.");
                return false;
            } else if (((C0925b) this.d).mo1566a() != -1) {
                return false;
            } else {
                ((C0925b) this.d).mo1568a(bArr, i, i2);
                return true;
            }
        }
    }
}
