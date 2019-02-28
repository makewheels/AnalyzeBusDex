package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class VideoActivity extends Activity {
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        am.m7753a(this).m7754a(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            am.m7753a(super.getApplicationContext()).m7757a(null, bundleExtra, null);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        am.m7753a(this).m7755a(this, 4);
    }

    protected void onPause() {
        super.onPause();
        am.m7753a(this).m7755a(this, 3);
    }

    protected void onResume() {
        super.onResume();
        am.m7753a(this).m7755a(this, 2);
    }

    protected void onStop() {
        super.onStop();
        am.m7753a(this).m7755a(this, 1);
    }
}
