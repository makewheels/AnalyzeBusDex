package com.iflytek.cloud.speech;

import com.iflytek.cloud.resource.Resource;
import p054u.aly.bi_常量类;

public class SpeechError extends Exception {
    public static final int ERROR_INTERRUPT = 28;
    private static final long serialVersionUID = 4434424251478985596L;
    /* renamed from: a */
    private int f4566a;
    /* renamed from: b */
    private String f4567b;

    public SpeechError(int i) {
        int i2 = 11;
        this.f4566a = 0;
        this.f4567b = bi_常量类.f6358b;
        this.f4566a = i;
        if (i >= ErrorCode.ERROR_NO_NETWORK) {
            if (this.f4566a < ErrorCode.ERROR_UNKNOWN) {
                if (this.f4566a == ErrorCode.ERROR_INVALID_RESULT) {
                    i2 = 5;
                } else if (this.f4566a == ErrorCode.ERROR_NO_MATCH) {
                    i2 = 10;
                } else if (this.f4566a == ErrorCode.ERROR_AUDIO_RECORD) {
                    i2 = 9;
                } else if (this.f4566a == ErrorCode.ERROR_NO_SPPECH) {
                    i2 = 12;
                } else if (this.f4566a != ErrorCode.ERROR_SPEECH_TIMEOUT) {
                    if (this.f4566a == ErrorCode.ERROR_EMPTY_UTTERANCE) {
                        i2 = 13;
                    }
                }
            }
            i2 = 3;
        } else if (this.f4566a != ErrorCode.MSP_ERROR_NO_DATA) {
            if (ErrorCode.MSP_ERROR_INVALID_PARA == this.f4566a || ErrorCode.MSP_ERROR_INVALID_PARA_VALUE == this.f4566a || ErrorCode.MSP_ERROR_INVALID_CONFIG == this.f4566a) {
                i2 = 7;
            } else if (this.f4566a >= ErrorCode.MSP_ERROR_NET_GENERAL && this.f4566a < 10300) {
                i2 = 3;
            } else if (this.f4566a == ErrorCode.MSP_ERROR_NO_ENOUGH_BUFFER || this.f4566a == ErrorCode.MSP_ERROR_OUT_OF_MEMORY) {
                i2 = 16;
            } else if (this.f4566a == ErrorCode.MSP_ERROR_OVERFLOW) {
                i2 = 17;
            } else if (this.f4566a >= ErrorCode.MSP_ERROR_DB_GENERAL && this.f4566a <= ErrorCode.MSP_ERROR_DB_INVALID_APPID) {
                i2 = 18;
            } else if (this.f4566a >= ErrorCode.MSP_ERROR_LOGIN_SUCCESS && this.f4566a < 11100) {
                i2 = this.f4566a == ErrorCode.MSP_ERROR_LOGIN_INVALID_USER ? 23 : this.f4566a == ErrorCode.MSP_ERROR_LOGIN_INVALID_PWD ? 24 : 18;
            } else if (this.f4566a == ErrorCode.MSP_ERROR_CREATE_HANDLE) {
                i2 = 19;
            } else if (this.f4566a == ErrorCode.MSP_ERROR_INVALID_DATA) {
                i2 = 20;
            } else if (this.f4566a == ErrorCode.MSP_ERROR_REC_GRAMMAR_ERROR) {
                i2 = 21;
            } else if (this.f4566a < ErrorCode.MSP_ERROR_RES_GENERAL || this.f4566a >= ErrorCode.MSP_ERROR_TTS_GENERAL) {
                if (this.f4566a >= ErrorCode.MSP_ERROR_AUTH_NO_LICENSE && this.f4566a <= ErrorCode.MSP_ERROR_AUTH_LICENSE_TO_BE_EXPIRED) {
                    i2 = 25;
                }
                i2 = 3;
            } else {
                i2 = 22;
            }
        }
        this.f4567b = Resource.getErrorDescription(i2);
    }

    public SpeechError(int i, String str) {
        this.f4566a = 0;
        this.f4567b = bi_常量类.f6358b;
        this.f4566a = i;
        this.f4567b = str;
    }

    public SpeechError(Exception exception) {
        this.f4566a = 0;
        this.f4567b = bi_常量类.f6358b;
        this.f4566a = ErrorCode.ERROR_UNKNOWN;
        this.f4567b = exception.toString();
    }

    public int getErrorCode() {
        return this.f4566a;
    }

    public String getErrorDescription() {
        return this.f4567b;
    }

    public String getHtmlDescription(boolean z) {
        String str = this.f4567b + "...";
        if (!z) {
            return str;
        }
        return ((str + "<br>(") + Resource.getErrorTag(0) + ":") + this.f4566a + ")";
    }

    public String getPlainDescription(boolean z) {
        String str = this.f4567b;
        if (!z) {
            return str;
        }
        return ((str + ".") + "(" + Resource.getErrorTag(0) + ":") + this.f4566a + ")";
    }

    public String toString() {
        return getPlainDescription(true);
    }
}
