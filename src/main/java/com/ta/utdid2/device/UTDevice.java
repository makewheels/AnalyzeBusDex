package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.p037b.p038a.C1020h;

public class UTDevice {
    public static String getUtdid(Context context) {
        C1031a a = C1032b.m7457a(context);
        return (a == null || C1020h.m7383a(a.m7456e())) ? "ffffffffffffffffffffffff" : a.m7456e();
    }
}
