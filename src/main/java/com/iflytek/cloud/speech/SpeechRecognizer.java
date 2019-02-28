package com.iflytek.cloud.speech;

import android.content.Context;
import com.iflytek.cloud.p023b.p025b.C0931d;
import com.iflytek.cloud.speech.p031a.C0967a;

public abstract class SpeechRecognizer extends C0931d {
    /* renamed from: e */
    private static SpeechRecognizer f4568e = null;

    protected SpeechRecognizer(Context context) {
        super(context);
    }

    public static synchronized SpeechRecognizer createRecognizer(Context context) {
        SpeechRecognizer speechRecognizer;
        synchronized (SpeechRecognizer.class) {
            if (f4568e == null) {
                f4568e = new C0967a(context);
            }
            speechRecognizer = f4568e;
        }
        return speechRecognizer;
    }

    public static SpeechRecognizer getRecognizer() {
        return f4568e;
    }

    public void cancel() {
        super.cancel();
    }

    /* renamed from: d */
    protected boolean mo1579d() {
        f4568e = null;
        return true;
    }

    public boolean destroy() {
        return super.destroy();
    }

    public int getDownflowBytes(boolean z) {
        return 0;
    }

    public String getParameter(String str) {
        return super.getParameter(str);
    }

    public int getUpflowBytes(boolean z) {
        return 0;
    }

    public abstract boolean isListening();

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public abstract void startListening(RecognizerListener recognizerListener);

    public abstract void stopListening();

    public abstract boolean writeAudio(byte[] bArr, int i, int i2);
}
