package com.iflytek.cloud.record;

import android.media.AudioRecord;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.speech.ErrorCode;
import com.iflytek.cloud.speech.SpeechError;

/* renamed from: com.iflytek.cloud.record.d */
public class C0959d extends Thread {
    /* renamed from: a */
    private final short f4542a = (short) 16;
    /* renamed from: b */
    private byte[] f4543b = null;
    /* renamed from: c */
    private AudioRecord f4544c = null;
    /* renamed from: d */
    private C0924a f4545d = null;
    /* renamed from: e */
    private C0924a f4546e = null;
    /* renamed from: f */
    private volatile boolean f4547f = false;
    /* renamed from: g */
    private int f4548g = ErrorCode.MSP_ERROR_LMOD_BASE;
    /* renamed from: h */
    private int f4549h = 40;
    /* renamed from: i */
    private int f4550i = 40;
    /* renamed from: j */
    private int f4551j;

    /* renamed from: com.iflytek.cloud.record.d$a */
    public interface C0924a {
        /* renamed from: a */
        void mo1567a(SpeechError speechError);

        /* renamed from: a */
        void mo1568a(byte[] bArr, int i, int i2);

        /* renamed from: c */
        void mo1570c(boolean z);

        /* renamed from: o */
        void mo1575o();
    }

    public C0959d(int i, int i2, int i3) {
        this.f4551j = i3;
        this.f4548g = i;
        this.f4549h = i2;
        if (this.f4549h < 40 || this.f4549h > 100) {
            this.f4549h = 40;
        }
        this.f4550i = 10;
    }

    /* renamed from: b */
    private int m7241b() throws SpeechError {
        if (this.f4544c == null || this.f4545d == null) {
            return 0;
        }
        int read = this.f4544c.read(this.f4543b, 0, this.f4543b.length);
        if (read <= 0 || this.f4545d == null) {
            return read;
        }
        this.f4545d.mo1568a(this.f4543b, 0, read);
        return read;
    }

    /* renamed from: c */
    private void m7242c() {
        if (this.f4544c != null) {
            C0939a.m7120a("release record begin");
            this.f4544c.release();
            this.f4544c = null;
            if (this.f4546e != null) {
                this.f4546e.mo1575o();
                this.f4546e = null;
            }
            C0939a.m7120a("release record over");
        }
    }

    /* renamed from: a */
    public void m7243a() {
        this.f4547f = true;
        if (this.f4546e == null) {
            this.f4546e = this.f4545d;
        }
        this.f4545d = null;
    }

    /* renamed from: a */
    public void m7244a(C0924a c0924a) throws SpeechError {
        this.f4545d = c0924a;
        setPriority(10);
        start();
    }

    /* renamed from: a */
    public void m7245a(short s, int i, int i2) throws SpeechError {
        if (this.f4544c != null) {
            m7242c();
        }
        int i3 = (i * i2) / 1000;
        int i4 = (((i3 * 4) * 16) * s) / 8;
        int i5 = s == (short) 1 ? 2 : 3;
        int minBufferSize = AudioRecord.getMinBufferSize(i, i5, 2);
        if (i4 < minBufferSize) {
            i4 = minBufferSize;
        }
        this.f4544c = new AudioRecord(this.f4551j, i, i5, 2, i4);
        this.f4543b = new byte[(((i3 * s) * 16) / 8)];
        C0939a.m7120a("\nSampleRate:" + i + "\nChannel:" + i5 + "\nFormat:" + 2 + "\nFramePeriod:" + i3 + "\nBufferSize:" + i4 + "\nMinBufferSize:" + minBufferSize + "\nActualBufferSize:" + this.f4543b.length + "\n");
        if (this.f4544c.getState() != 1) {
            C0939a.m7120a("create AudioRecord error");
            throw new SpeechError((int) ErrorCode.ERROR_AUDIO_RECORD);
        }
    }

    protected void finalize() throws Throwable {
        m7242c();
        super.finalize();
    }

    public void run() {
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                break;
            } catch (Exception e) {
                i2++;
                if (i2 < 4) {
                    C0959d.sleep(40);
                } else {
                    throw new SpeechError((int) ErrorCode.ERROR_AUDIO_RECORD);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (this.f4545d != null) {
                    this.f4545d.mo1567a(new SpeechError((int) ErrorCode.ERROR_AUDIO_RECORD));
                }
            }
        }
        if (!this.f4547f) {
            m7245a((short) 1, this.f4548g, this.f4549h);
        }
        if (this.f4544c.getState() == 3) {
            throw new SpeechError((int) ErrorCode.ERROR_AUDIO_RECORD);
        }
        if (!this.f4547f) {
            this.f4544c.startRecording();
        }
        if (this.f4545d != null) {
            this.f4545d.mo1570c(true);
        }
        while (!this.f4547f) {
            m7241b();
            if (this.f4544c.getRecordingState() != 3) {
                i++;
                if (i > 4) {
                    throw new SpeechError((int) ErrorCode.ERROR_AUDIO_RECORD);
                }
            }
            C0959d.sleep((long) this.f4550i);
        }
        m7242c();
    }
}
