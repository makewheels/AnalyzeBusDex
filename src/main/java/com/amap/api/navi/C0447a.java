package com.amap.api.navi;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: AMapHudView */
/* renamed from: com.amap.api.navi.a */
class C0447a implements OnCheckedChangeListener {
    /* renamed from: a */
    final /* synthetic */ AMapHudView f2686a;

    C0447a(AMapHudView aMapHudView) {
        this.f2686a = aMapHudView;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        try {
            if (this.f2686a.autonaviHudMirrosImage != null) {
                if (z) {
                    this.f2686a.hudStatus = (byte) 2;
                } else {
                    this.f2686a.hudStatus = (byte) 1;
                }
                this.f2686a.postInvalidateHudMirros(z);
                this.f2686a.removeCallbacks();
                this.f2686a.disappearHudHandler.postDelayed(this.f2686a.disappearHudTitleRunnable, 2000);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
