package com.iflytek.cloud.speech;

import android.content.Context;
import com.iflytek.cloud.p023b.p025b.C0931d;
import com.iflytek.cloud.speech.p031a.C0970c;

public abstract class SpeechSynthesizer extends C0931d {
    protected SpeechSynthesizer(Context context) {
        super(context);
    }

    public static SpeechSynthesizer createSynthesizer(Context context) {
        return C0970c.m7280a(context);
    }

    public static SpeechSynthesizer getSynthesizer() {
        return C0970c.m7281e();
    }

    public boolean destroy() {
        return super.destroy();
    }

    public abstract int getDownflowBytes(boolean z);

    public abstract int getUpflowBytes(boolean z);

    public abstract boolean isSpeaking();

    public abstract void pauseSpeaking();

    public abstract void replaySpeaking();

    public abstract void resumeSpeaking();

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public abstract void startSpeaking(String str, SynthesizerListener synthesizerListener);

    public abstract void stopSpeaking();

    public abstract void synthesizeToUri(String str, String str2, SynthesizeToUriListener synthesizeToUriListener);
}
