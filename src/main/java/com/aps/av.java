package com.aps;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Process;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.WebView;
import com.umeng.analytics.C1233a;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.json.JSONObject;

public final class av {
    /* renamed from: a */
    private Context f3379a = null;
    /* renamed from: b */
    private boolean f3380b = true;
    /* renamed from: c */
    private int f3381c = 1270;
    /* renamed from: d */
    private int f3382d = ErrorCode.THROWABLE_LOAD_TBS;
    /* renamed from: e */
    private int f3383e = 4;
    /* renamed from: f */
    private int f3384f = 200;
    /* renamed from: g */
    private int f3385g = 1;
    /* renamed from: h */
    private int f3386h = 0;
    /* renamed from: i */
    private int f3387i = 0;
    /* renamed from: j */
    private long f3388j = 0;
    /* renamed from: k */
    private au f3389k = null;

    private av(Context context) {
        this.f3379a = context;
    }

    /* renamed from: a */
    private static int m4391a(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4) {
            i3 += (bArr[i2 + i] & WebView.NORMAL_MODE_ALPHA) << (i2 << 3);
            i2++;
        }
        return i3;
    }

    /* renamed from: a */
    protected static av m4392a(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        av avVar = new av(context);
        avVar.f3386h = 0;
        avVar.f3387i = 0;
        avVar.f3388j = ((System.currentTimeMillis() + 28800000) / C1233a.f5597m) * C1233a.f5597m;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(new File(m4395b(context) + File.separator + "data_carrier_status"));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[32];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                if (toByteArray != null && toByteArray.length >= 22) {
                    avVar.f3380b = toByteArray[0] != (byte) 0;
                    avVar.f3381c = (toByteArray[1] * 10) << 10;
                    avVar.f3382d = (toByteArray[2] * 10) << 10;
                    avVar.f3383e = toByteArray[3];
                    avVar.f3384f = toByteArray[4] * 10;
                    avVar.f3385g = toByteArray[5];
                    long b = m4394b(toByteArray, 14);
                    if (avVar.f3388j - b < C1233a.f5597m) {
                        avVar.f3388j = b;
                        avVar.f3386h = m4391a(toByteArray, 6);
                        avVar.f3387i = m4391a(toByteArray, 10);
                    }
                }
                byteArrayOutputStream.close();
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return avVar;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileInputStream2 = fileInputStream;
                th = th3;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return avVar;
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
        return avVar;
    }

    /* renamed from: a */
    private static byte[] m4393a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) ((j >> (i << 3)) & 255));
        }
        return bArr;
    }

    /* renamed from: b */
    private static long m4394b(byte[] bArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 8) {
            i3 += (bArr[i2 + 14] & WebView.NORMAL_MODE_ALPHA) << (i2 << 3);
            i2++;
        }
        return (long) i3;
    }

    /* renamed from: b */
    private static String m4395b(Context context) {
        boolean z = false;
        File file = null;
        if (Process.myUid() != 1000) {
            file = af.m4311a(context);
        }
        try {
            z = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
        }
        return ((z || !af.m4318c()) && file != null) ? file.getPath() : context.getFilesDir().getPath();
    }

    /* renamed from: c */
    private static byte[] m4396c(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >> (i2 << 3));
        }
        return bArr;
    }

    /* renamed from: g */
    private void m4397g() {
        long currentTimeMillis = System.currentTimeMillis() + 28800000;
        if (currentTimeMillis - this.f3388j > C1233a.f5597m) {
            this.f3388j = (currentTimeMillis / C1233a.f5597m) * C1233a.f5597m;
            this.f3386h = 0;
            this.f3387i = 0;
        }
    }

    /* renamed from: a */
    protected final void m4398a(int i) {
        m4397g();
        if (i < 0) {
            i = 0;
        }
        this.f3386h = i;
    }

    /* renamed from: a */
    protected final void m4399a(au auVar) {
        this.f3389k = auVar;
    }

    /* renamed from: a */
    protected final boolean m4400a() {
        m4397g();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3379a.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) ? this.f3380b : activeNetworkInfo.getType() == 1 ? this.f3380b && this.f3386h < this.f3381c : this.f3380b && this.f3387i < this.f3382d;
    }

    /* renamed from: a */
    protected final boolean m4401a(String str) {
        boolean z;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        int i = 1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("e")) {
                this.f3380b = jSONObject.getInt("e") != 0;
            }
            if (jSONObject.has("d")) {
                int i2 = jSONObject.getInt("d");
                this.f3381c = ((i2 & 127) * 10) << 10;
                this.f3382d = (((i2 & 3968) >> 7) * 10) << 10;
                this.f3383e = (520192 & i2) >> 12;
                this.f3384f = ((66584576 & i2) >> 19) * 10;
                this.f3385g = (i2 & 2080374784) >> 26;
                if (this.f3385g == 31) {
                    this.f3385g = 1500;
                }
                if (this.f3389k != null) {
                    this.f3389k.m4390a();
                }
            }
            z = jSONObject.has("u") ? jSONObject.getInt("u") != 0 : false;
        } catch (Exception e) {
            z = false;
        }
        try {
            m4397g();
            fileOutputStream = new FileOutputStream(new File(m4395b(this.f3379a) + File.separator + "data_carrier_status"));
            try {
                byte[] c = m4396c(this.f3386h);
                byte[] c2 = m4396c(this.f3387i);
                byte[] a = m4393a(this.f3388j);
                byte[] bArr = new byte[22];
                if (!this.f3380b) {
                    i = 0;
                }
                bArr[0] = (byte) i;
                bArr[1] = (byte) (this.f3381c / 10240);
                bArr[2] = (byte) (this.f3382d / 10240);
                bArr[3] = (byte) this.f3383e;
                bArr[4] = (byte) (this.f3384f / 10);
                bArr[5] = (byte) this.f3385g;
                bArr[6] = c[0];
                bArr[7] = c[1];
                bArr[8] = c[2];
                bArr[9] = c[3];
                bArr[10] = c2[0];
                bArr[11] = c2[1];
                bArr[12] = c2[2];
                bArr[13] = c2[3];
                bArr[14] = a[0];
                bArr[15] = a[1];
                bArr[16] = a[2];
                bArr[17] = a[3];
                bArr[18] = a[4];
                bArr[19] = a[5];
                bArr[20] = a[6];
                bArr[21] = a[7];
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            fileOutputStream2 = null;
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    /* renamed from: b */
    protected final int m4402b() {
        return this.f3383e;
    }

    /* renamed from: b */
    protected final void m4403b(int i) {
        m4397g();
        if (i < 0) {
            i = 0;
        }
        this.f3387i = i;
    }

    /* renamed from: c */
    protected final int m4404c() {
        return this.f3384f;
    }

    /* renamed from: d */
    protected final int m4405d() {
        return this.f3385g;
    }

    /* renamed from: e */
    protected final int m4406e() {
        m4397g();
        return this.f3386h;
    }

    /* renamed from: f */
    protected final int m4407f() {
        m4397g();
        return this.f3387i;
    }
}
