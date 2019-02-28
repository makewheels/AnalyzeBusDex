package com.iflytek.cloud.speech;

public interface SynthesizeToUriListener {
    void onBufferProgress(int i);

    void onSynthesizeCompleted(String str, SpeechError speechError);
}
