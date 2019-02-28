package com.iflytek.cloud.record;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;

/* renamed from: com.iflytek.cloud.record.b */
final class C0957b implements OnAudioFocusChangeListener {
    /* renamed from: a */
    final /* synthetic */ PcmPlayer f4540a;

    C0957b(PcmPlayer pcmPlayer) {
        this.f4540a = pcmPlayer;
    }

    public void onAudioFocusChange(int i) {
        if (i == -2 || i == -3 || i == -1) {
            C0939a.m7121a("PcmPlayer", "pause start");
            if (this.f4540a.m7223c()) {
                C0939a.m7121a("PcmPlayer", "pause success");
                this.f4540a.f4520l = true;
                if (this.f4540a.f4514f != null) {
                    this.f4540a.f4514f.mo1607a();
                }
            }
        } else if (i == 1) {
            C0939a.m7121a("PcmPlayer", "resume start");
            if (this.f4540a.f4520l) {
                this.f4540a.f4520l = false;
                if (this.f4540a.m7224d()) {
                    C0939a.m7121a("PcmPlayer", "resume success");
                    if (this.f4540a.f4514f != null) {
                        this.f4540a.f4514f.mo1610b();
                    }
                }
            }
        }
    }
}
