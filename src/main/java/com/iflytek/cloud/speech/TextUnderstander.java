package com.iflytek.cloud.speech;

import android.content.Context;
import android.os.Bundle;
import com.iflytek.cloud.p023b.p025b.C0931d;
import com.iflytek.cloud.p023b.p025b.C0931d.C0930a;
import com.iflytek.cloud.p023b.p027c.C0935b;
import java.io.UnsupportedEncodingException;

public class TextUnderstander extends C0931d {

    /* renamed from: com.iflytek.cloud.speech.TextUnderstander$a */
    private class C0965a implements SpeechListener {
        /* renamed from: a */
        final /* synthetic */ TextUnderstander f4580a;
        /* renamed from: b */
        private TextUnderstanderListener f4581b;

        public C0965a(TextUnderstander textUnderstander, TextUnderstanderListener textUnderstanderListener) {
            this.f4580a = textUnderstander;
            this.f4581b = textUnderstanderListener;
        }

        public void onCompleted(SpeechError speechError) {
            if (this.f4581b != null && speechError != null) {
                this.f4581b.onError(speechError);
            }
        }

        public void onData(byte[] bArr) {
            if (bArr != null) {
                try {
                    this.f4581b.onResult(new UnderstanderResult(new String(bArr, "utf-8")));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public void onEvent(int i, Bundle bundle) {
        }
    }

    public TextUnderstander(Context context) {
        super(context);
        setParameter(SpeechConstant.NLP_VERSION, "2.0");
        setParameter(SpeechConstant.RESULT_TYPE, "json");
    }

    public void cancel() {
        super.cancel();
    }

    public boolean destroy() {
        return super.destroy();
    }

    public String getParameter(String str) {
        return super.getParameter(str);
    }

    public boolean isUnderstanding() {
        return m7090c();
    }

    public boolean setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public void understandText(String str, TextUnderstanderListener textUnderstanderListener) {
        this.d = new C0935b(this.a, this.c);
        ((C0935b) this.d).m7098a(new C0930a(this, new C0965a(this, textUnderstanderListener)), str);
    }
}
