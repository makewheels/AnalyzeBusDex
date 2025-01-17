package com.tencent.mm.sdk.diffdev;

import android.util.Log;
import com.tencent.mm.sdk.diffdev.p050a.C1064a;

public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance = null;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        Log.v(TAG, "getDiffDevOAuth, version = " + i);
        if (i > 1) {
            Log.e(TAG, "getDiffDevOAuth fail, unsupported version = " + i);
            return null;
        }
        switch (i) {
            case 1:
                if (v1Instance == null) {
                    v1Instance = new C1064a();
                }
                return v1Instance;
            default:
                return null;
        }
    }
}
