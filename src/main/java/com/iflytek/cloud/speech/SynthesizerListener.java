package com.iflytek.cloud.speech;

public interface SynthesizerListener {
    void onBufferProgress(int i, int i2, int i3, String str);

    void onCompleted(SpeechError speechError);

    void onSpeakBegin();

    void onSpeakPaused();

    void onSpeakProgress(int i, int i2, int i3);

    void onSpeakResumed();
}
