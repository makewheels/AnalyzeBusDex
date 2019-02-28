package com.iflytek.cloud.speech;

import android.content.Context;
import com.alipay.sdk.cons.C0108a;
import com.iflytek.cloud.speech.p031a.C0967a;

public class SpeechUnderstander {
    /* renamed from: a */
    protected static SpeechUnderstander f4571a = null;
    /* renamed from: b */
    private C0967a f4572b = null;

    /* renamed from: com.iflytek.cloud.speech.SpeechUnderstander$a */
    private class C0963a implements RecognizerListener {
        /* renamed from: a */
        final /* synthetic */ SpeechUnderstander f4569a;
        /* renamed from: b */
        private final SpeechUnderstanderListener f4570b;

        public C0963a(SpeechUnderstander speechUnderstander, SpeechUnderstanderListener speechUnderstanderListener) {
            this.f4569a = speechUnderstander;
            this.f4570b = speechUnderstanderListener;
        }

        public void onBeginOfSpeech() {
            if (this.f4570b != null) {
                this.f4570b.onBeginOfSpeech();
            }
        }

        public void onEndOfSpeech() {
            if (this.f4570b != null) {
                this.f4570b.onEndOfSpeech();
            }
        }

        public void onError(SpeechError speechError) {
            if (this.f4570b != null && speechError != null) {
                this.f4570b.onError(speechError);
            }
        }

        public void onEvent(int i, int i2, int i3, String str) {
            if (this.f4570b != null) {
                this.f4570b.onEvent(i, i2, i3, str);
            }
        }

        public void onResult(RecognizerResult recognizerResult, boolean z) {
            if (this.f4570b != null) {
                this.f4570b.onResult(new UnderstanderResult(recognizerResult.getResultString()));
            }
        }

        public void onVolumeChanged(int i) {
            if (this.f4570b != null) {
                this.f4570b.onVolumeChanged(i);
            }
        }
    }

    protected SpeechUnderstander(Context context) {
        this.f4572b = new C0967a(context);
        this.f4572b.setParameter("asr_sch", C0108a.f262e);
        this.f4572b.setParameter(SpeechConstant.NLP_VERSION, "2.0");
        this.f4572b.setParameter(SpeechConstant.RESULT_TYPE, "json");
    }

    public static synchronized SpeechUnderstander createUnderstander(Context context) {
        SpeechUnderstander speechUnderstander;
        synchronized (SpeechUnderstander.class) {
            if (f4571a == null) {
                f4571a = new SpeechUnderstander(context);
            }
            speechUnderstander = f4571a;
        }
        return speechUnderstander;
    }

    public static SpeechUnderstander getUnderstander() {
        return f4571a;
    }

    public void cancel() {
        this.f4572b.cancel();
    }

    public boolean destroy() {
        boolean destroy = this.f4572b.destroy();
        if (destroy) {
            f4571a = null;
        }
        return destroy;
    }

    public String getParameter(String str) {
        return this.f4572b.getParameter(str);
    }

    public boolean isUnderstanding() {
        return this.f4572b.isListening();
    }

    public boolean setParameter(String str, String str2) {
        return this.f4572b.setParameter(str, str2);
    }

    public void startUnderstanding(SpeechUnderstanderListener speechUnderstanderListener) {
        this.f4572b.startListening(new C0963a(this, speechUnderstanderListener));
    }

    public void stopUnderstanding() {
        this.f4572b.stopListening();
    }

    public boolean writeAudio(byte[] bArr, int i, int i2) {
        return this.f4572b.writeAudio(bArr, i, i2);
    }
}
