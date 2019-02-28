package com.iflytek.cloud.speech;

public interface TextUnderstanderListener {
    void onError(SpeechError speechError);

    void onResult(UnderstanderResult understanderResult);
}
