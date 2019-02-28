package com.ut.device;

import android.content.Context;
import com.ta.utdid2.p036a.C1006a;

public class UTDevice {
    public static String getUtdid(Context context) {
        return com.ta.utdid2.device.UTDevice.getUtdid(context);
    }

    public static String getAid(String str, String str2, Context context) {
        return C1006a.m7348a(context).m7350a(str, str2, getUtdid(context));
    }

    public static void getAidAsync(String str, String str2, Context context, AidCallback aidCallback) {
        C1006a.m7348a(context).m7351a(str, str2, getUtdid(context), aidCallback);
    }
}
