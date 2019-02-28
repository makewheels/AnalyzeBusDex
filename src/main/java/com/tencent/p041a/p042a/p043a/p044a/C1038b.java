package com.tencent.p041a.p042a.p043a.p044a;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/* renamed from: com.tencent.a.a.a.a.b */
final class C1038b extends C1037f {
    C1038b(Context context) {
        super(context);
    }

    /* renamed from: a */
    protected final void mo1704a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to InternalStorage");
            C1036a.m7473d(Environment.getExternalStorageDirectory() + "/" + C1043h.m7502f("6X8Y4XdM2Vhvn0I="));
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), C1043h.m7502f("6X8Y4XdM2Vhvn0KfzcEatGnWaNU="))));
                bufferedWriter.write(C1043h.m7502f("4kU71lN96TJUomD1vOU9lgj9Tw==") + "," + str);
                bufferedWriter.write("\n");
                bufferedWriter.close();
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
    }

    /* renamed from: a */
    protected final boolean mo1705a() {
        return C1043h.m7498a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE") && Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: b */
    protected final String mo1706b() {
        String str;
        synchronized (this) {
            Log.i("MID", "read mid from InternalStorage");
            try {
                for (String str2 : C1036a.m7472a(new File(Environment.getExternalStorageDirectory(), C1043h.m7502f("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=")))) {
                    String[] split = str2.split(",");
                    if (split.length == 2 && split[0].equals(C1043h.m7502f("4kU71lN96TJUomD1vOU9lgj9Tw=="))) {
                        Log.i("MID", "read mid from InternalStorage:" + split[1]);
                        str2 = split[1];
                        break;
                    }
                }
                str2 = null;
            } catch (Throwable e) {
                Log.w("MID", e);
                str2 = null;
            }
        }
        return str2;
    }
}
