package com.iflytek.cloud.speech;

import android.os.Bundle;

public interface SpeechListener {
    void onCompleted(SpeechError speechError);

    void onData(byte[] bArr);

    void onEvent(int i, Bundle bundle);
}
