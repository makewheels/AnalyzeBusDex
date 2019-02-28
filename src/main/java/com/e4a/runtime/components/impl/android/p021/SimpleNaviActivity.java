package com.e4a.runtime.components.impl.android.p021;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;
import com.e4a.runtime.android.mainActivity;
import com.stub.StubApp;

/* renamed from: com.e4a.runtime.components.impl.android.高德导航类库.SimpleNaviActivity */
public class SimpleNaviActivity extends Activity implements AMapNaviViewListener {
    private AMapNaviView mAmapAMapNaviView;
    private boolean mIsEmulatorNavi = true;

    static {
        StubApp.interface11(3);
    }

    protected native void onCreate(Bundle bundle);

    private void processBundle(Bundle bundle) {
        if (bundle != null) {
            this.mIsEmulatorNavi = bundle.getBoolean("isemulator", true);
        }
    }

    private void init(Bundle bundle) {
        this.mAmapAMapNaviView.onCreate(bundle);
        this.mAmapAMapNaviView.setAMapNaviViewListener(this);
        TTSController.getInstance(this).startSpeaking();
        if (this.mIsEmulatorNavi) {
            AMapNavi.getInstance(this).setEmulatorNaviSpeed(100);
            AMapNavi.getInstance(this).startNavi(AMapNavi.EmulatorNaviMode);
            return;
        }
        AMapNavi.getInstance(this).startNavi(AMapNavi.GPSNaviMode);
    }

    public void onNaviCancel() {
        Intent intent = new Intent(this, mainActivity.class);
        intent.addFlags(131072);
        startActivity(intent);
        finish();
    }

    public void onNaviSetting() {
    }

    public void onNaviMapMode(int i) {
    }

    public void onNaviTurnClick() {
    }

    public void onNextRoadClick() {
    }

    public void onScanViewButtonClick() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            startActivity(new Intent(this, mainActivity.class));
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mAmapAMapNaviView.onSaveInstanceState(bundle);
    }

    public void onResume() {
        super.onResume();
        this.mAmapAMapNaviView.onResume();
    }

    public void onPause() {
        super.onPause();
        this.mAmapAMapNaviView.onPause();
        AMapNavi.getInstance(this).stopNavi();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mAmapAMapNaviView.onDestroy();
        TTSController.getInstance(this).stopSpeaking();
    }

    public void onLockMap(boolean z) {
    }
}
