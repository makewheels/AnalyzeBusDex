package com.e4a.runtime.android;

import android.app.Activity;
import android.os.Bundle;
import com.stub.StubApp;

public class StartActivity extends Activity {
    static {
        StubApp.interface11(1);
    }

    protected native void onCreate(Bundle bundle);
}
