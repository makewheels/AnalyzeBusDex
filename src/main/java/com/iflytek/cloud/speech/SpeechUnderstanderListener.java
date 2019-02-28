package com.iflytek.cloud.speech;

public interface SpeechUnderstanderListener {
    void onBeginOfSpeech();

    void onEndOfSpeech();

    void onError(SpeechError speechError);

    void onEvent(int i, int i2, int i3, String str);

    void onResult(UnderstanderResult understanderResult);

    void onVolumeChanged(int i);
}
