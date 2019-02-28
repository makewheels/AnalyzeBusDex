package com.aps;

import android.content.Context;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class af {
    /* renamed from: a */
    private Context f3318a;
    /* renamed from: b */
    private int f3319b = 0;
    /* renamed from: c */
    private int f3320c = 0;
    /* renamed from: d */
    private int f3321d = 0;

    protected af(Context context) {
        this.f3318a = context;
        m4325a(768);
    }

    /* renamed from: a */
    private static int m4309a(int i, int i2) {
        return i < i2 ? i : i2;
    }

    /* renamed from: a */
    protected static aa m4310a(Location location, ai aiVar, int i, byte b, long j) {
        aa aaVar = new aa();
        if (i <= 0 || i > 3 || aiVar == null) {
            return null;
        }
        Object obj = (i == 1 || i == 3) ? 1 : null;
        Object obj2 = (i == 2 || i == 3) ? 1 : null;
        Object bytes = aiVar.m4379p().getBytes();
        System.arraycopy(bytes, 0, aaVar.f3298c, 0, m4309a(bytes.length, aaVar.f3298c.length));
        bytes = aiVar.m4369f().getBytes();
        System.arraycopy(bytes, 0, aaVar.f3302g, 0, m4309a(bytes.length, aaVar.f3302g.length));
        bytes = aiVar.m4370g().getBytes();
        System.arraycopy(bytes, 0, aaVar.f3296a, 0, m4309a(bytes.length, aaVar.f3296a.length));
        bytes = aiVar.m4371h().getBytes();
        System.arraycopy(bytes, 0, aaVar.f3297b, 0, m4309a(bytes.length, aaVar.f3297b.length));
        aaVar.f3299d = (short) aiVar.m4380q();
        aaVar.f3300e = (short) aiVar.m4381r();
        aaVar.f3301f = (byte) aiVar.m4382s();
        bytes = aiVar.m4383t().getBytes();
        System.arraycopy(bytes, 0, aaVar.f3303h, 0, m4309a(bytes.length, aaVar.f3303h.length));
        long j2 = j / 1000;
        bytes = (location == null || !aiVar.m4368e()) ? null : 1;
        if (bytes == null) {
            return null;
        }
        int i2;
        C0587x c0587x = new C0587x();
        c0587x.f3566b = (int) j2;
        C0589z c0589z = new C0589z();
        c0589z.f3623a = (int) (location.getLongitude() * 1000000.0d);
        c0589z.f3624b = (int) (location.getLatitude() * 1000000.0d);
        c0589z.f3625c = (int) location.getAltitude();
        c0589z.f3626d = (int) location.getAccuracy();
        c0589z.f3627e = (int) location.getSpeed();
        c0589z.f3628f = (short) ((int) location.getBearing());
        if (ai.m4349b(aiVar.m4387x()) && C0588y.f3583b) {
            c0589z.f3629g = (byte) 1;
        } else {
            c0589z.f3629g = (byte) 0;
        }
        c0589z.f3630h = b;
        c0589z.f3631i = System.currentTimeMillis();
        c0589z.f3632j = aiVar.m4378o();
        c0587x.f3567c = c0589z;
        int i3 = 1;
        aaVar.f3305j.add(c0587x);
        if (!(!aiVar.m4366c() || aiVar.m4372i() || obj == null)) {
            C0587x c0587x2 = new C0587x();
            c0587x2.f3566b = (int) j2;
            C0585v c0585v = new C0585v();
            List a = aiVar.m4362a(location.getSpeed());
            if (a != null && a.size() >= 3) {
                c0585v.f3554a = (short) ((Integer) a.get(0)).intValue();
                c0585v.f3555b = ((Integer) a.get(1)).intValue();
            }
            c0585v.f3556c = aiVar.m4375l();
            List m = aiVar.m4376m();
            c0585v.f3557d = (byte) m.size();
            for (i2 = 0; i2 < m.size(); i2++) {
                ah ahVar = new ah();
                ahVar.f3329a = (short) ((NeighboringCellInfo) m.get(i2)).getLac();
                ahVar.f3330b = ((NeighboringCellInfo) m.get(i2)).getCid();
                ahVar.f3331c = (byte) ((NeighboringCellInfo) m.get(i2)).getRssi();
                c0585v.f3558e.add(ahVar);
            }
            c0587x2.f3568d = c0585v;
            i3 = 2;
            aaVar.f3305j.add(c0587x2);
        }
        i2 = i3;
        if (aiVar.m4366c() && aiVar.m4372i() && obj != null) {
            C0587x c0587x3 = new C0587x();
            c0587x3.f3566b = (int) j2;
            ag agVar = new ag();
            List b2 = aiVar.m4364b(location.getSpeed());
            if (b2 != null && b2.size() >= 6) {
                agVar.f3322a = ((Integer) b2.get(3)).intValue();
                agVar.f3323b = ((Integer) b2.get(4)).intValue();
                agVar.f3324c = (short) ((Integer) b2.get(0)).intValue();
                agVar.f3325d = (short) ((Integer) b2.get(1)).intValue();
                agVar.f3326e = ((Integer) b2.get(2)).intValue();
                agVar.f3327f = aiVar.m4375l();
            }
            c0587x3.f3569e = agVar;
            i2++;
            aaVar.f3305j.add(c0587x3);
        }
        if (aiVar.m4367d() && obj2 != null) {
            C0587x c0587x4 = new C0587x();
            ac acVar = new ac();
            List u = aiVar.m4384u();
            c0587x4.f3566b = (int) (((Long) u.get(0)).longValue() / 1000);
            acVar.f3308a = (byte) (u.size() - 1);
            for (int i4 = 1; i4 < u.size(); i4++) {
                List list = (List) u.get(i4);
                if (list != null && list.size() >= 3) {
                    ad adVar = new ad();
                    bytes = ((String) list.get(0)).getBytes();
                    System.arraycopy(bytes, 0, adVar.f3311a, 0, m4309a(bytes.length, adVar.f3311a.length));
                    adVar.f3312b = (short) ((Integer) list.get(1)).intValue();
                    bytes = ((String) list.get(2)).getBytes();
                    System.arraycopy(bytes, 0, adVar.f3313c, 0, m4309a(bytes.length, adVar.f3313c.length));
                    acVar.f3309b.add(adVar);
                }
            }
            c0587x4.f3570f = acVar;
            i2++;
            aaVar.f3305j.add(c0587x4);
        }
        aaVar.f3304i = (short) i2;
        return i2 < 2 ? null : aaVar;
    }

    /* renamed from: a */
    protected static File m4311a(Context context) {
        return new File(Environment.getExternalStorageDirectory().getPath() + ("/Android/data/" + context.getPackageName() + "/files/"));
    }

    /* renamed from: a */
    private static ArrayList m4312a(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < fileArr.length) {
            if (fileArr[i].isFile() && fileArr[i].getName().length() == 10 && TextUtils.isDigitsOnly(fileArr[i].getName())) {
                arrayList.add(fileArr[i]);
            }
            i++;
        }
        return arrayList;
    }

    /* renamed from: a */
    protected static byte[] m4313a(BitSet bitSet) {
        byte[] bArr = new byte[(bitSet.size() / 8)];
        for (int i = 0; i < bitSet.size(); i++) {
            int i2 = i / 8;
            bArr[i2] = (byte) (((bitSet.get(i) ? 1 : 0) << (7 - (i % 8))) | bArr[i2]);
        }
        return bArr;
    }

    /* renamed from: a */
    protected static byte[] m4314a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (Exception e) {
            return bArr2;
        }
    }

    /* renamed from: a */
    protected static byte[] m4315a(byte[] bArr, int i) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        int indexOf = new String(bArr).indexOf(0);
        if (indexOf <= 0) {
            i = 1;
        } else if (indexOf + 1 <= i) {
            i = indexOf + 1;
        }
        Object obj = new byte[i];
        System.arraycopy(bArr, 0, obj, 0, i);
        obj[i - 1] = null;
        return obj;
    }

    /* renamed from: b */
    protected static BitSet m4316b(byte[] bArr) {
        BitSet bitSet = new BitSet(bArr.length << 3);
        int i = 0;
        for (byte b : bArr) {
            int i2 = 7;
            while (i2 >= 0) {
                int i3 = i + 1;
                bitSet.set(i, ((b & (1 << i2)) >> i2) == 1);
                i2--;
                i = i3;
            }
        }
        return bitSet;
    }

    /* renamed from: c */
    private File m4317c(long j) {
        boolean equals;
        boolean z = false;
        if (Process.myUid() == 1000) {
            return null;
        }
        File file;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = z;
        }
        if (!m4318c() || r0) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) <= ((long) (this.f3320c / 2))) {
                return null;
            }
            File file2 = new File(m4311a(this.f3318a).getPath() + File.separator + "carrierdata");
            if (!(file2.exists() && file2.isDirectory())) {
                file2.mkdirs();
            }
            file = new File(file2.getPath() + File.separator + j);
            try {
                z = file.createNewFile();
            } catch (IOException e2) {
            }
        } else {
            file = null;
        }
        return !z ? null : file;
    }

    /* renamed from: c */
    protected static boolean m4318c() {
        if (VERSION.SDK_INT >= 9) {
            try {
                return ((Boolean) Environment.class.getMethod("isExternalStorageRemovable", null).invoke(null, null)).booleanValue();
            } catch (Exception e) {
            }
        }
        return true;
    }

    /* renamed from: d */
    private File m4319d() {
        if (Process.myUid() == 1000) {
            return null;
        }
        File file;
        boolean equals;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (!m4318c() || r0) {
            File file2 = new File(m4311a(this.f3318a).getPath() + File.separator + "carrierdata");
            if (file2.exists() && file2.isDirectory()) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    ArrayList a = m4312a(listFiles);
                    if (a.size() == 1) {
                        if (((File) a.get(0)).length() < ((long) this.f3321d)) {
                            file = (File) a.get(0);
                            return file;
                        }
                    } else if (a.size() >= 2) {
                        file = (File) a.get(0);
                        File file3 = (File) a.get(1);
                        if (file.getName().compareTo(file3.getName()) <= 0) {
                            file = file3;
                        }
                        return file;
                    }
                }
            }
        }
        file = null;
        return file;
    }

    /* renamed from: d */
    private File m4320d(long j) {
        boolean z = false;
        File file = new File(this.f3318a.getFilesDir().getPath() + File.separator + "carrierdata");
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        File file2 = new File(file.getPath() + File.separator + j);
        try {
            z = file2.createNewFile();
        } catch (IOException e) {
        }
        return z ? file2 : null;
    }

    /* renamed from: e */
    private int m4321e() {
        if (Process.myUid() == 1000) {
            return 0;
        }
        boolean equals;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (m4318c() && !r0) {
            return 0;
        }
        File file = new File(m4311a(this.f3318a).getPath() + File.separator + "carrierdata");
        if (!file.exists() || !file.isDirectory()) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return 0;
        }
        ArrayList a = m4312a(listFiles);
        return a.size() == 1 ? ((File) a.get(0)).length() <= 0 ? 10 : 1 : a.size() >= 2 ? 2 : 0;
    }

    /* renamed from: f */
    private File m4322f() {
        if (Process.myUid() == 1000) {
            return null;
        }
        File file;
        boolean equals;
        try {
            equals = "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception e) {
            equals = false;
        }
        if (!m4318c() || r0) {
            File a = m4311a(this.f3318a);
            if (a != null) {
                File file2 = new File(a.getPath() + File.separator + "carrierdata");
                if (file2.exists() && file2.isDirectory()) {
                    File[] listFiles = file2.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        ArrayList a2 = m4312a(listFiles);
                        if (a2.size() >= 2) {
                            a = (File) a2.get(0);
                            file = (File) a2.get(1);
                            if (a.getName().compareTo(file.getName()) <= 0) {
                                file = a;
                            }
                            return file;
                        }
                    }
                }
            }
        }
        file = null;
        return file;
    }

    /* renamed from: a */
    protected int m4323a() {
        return this.f3319b;
    }

    /* renamed from: a */
    protected File m4324a(long j) {
        File d = m4319d();
        if (d == null) {
            d = m4317c(j);
        }
        if (d == null) {
            File file = new File(this.f3318a.getFilesDir().getPath() + File.separator + "carrierdata");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    ArrayList a = m4312a(listFiles);
                    if (a.size() == 1) {
                        if (((File) a.get(0)).length() < ((long) this.f3321d)) {
                            d = (File) a.get(0);
                        }
                    } else if (a.size() >= 2) {
                        d = (File) a.get(0);
                        File file2 = (File) a.get(1);
                        if (d.getName().compareTo(file2.getName()) <= 0) {
                            d = file2;
                        }
                    }
                }
            }
            d = null;
        }
        return d == null ? m4320d(j) : d;
    }

    /* renamed from: a */
    protected void m4325a(int i) {
        this.f3319b = i;
        this.f3320c = (((this.f3319b << 3) * 1500) + this.f3319b) + 4;
        if (this.f3319b == 256 || this.f3319b == 768) {
            this.f3321d = this.f3320c / 100;
        } else if (this.f3319b == 8736) {
            this.f3321d = this.f3320c - 5000;
        }
    }

    /* renamed from: b */
    protected File m4326b() {
        File f = m4322f();
        if (f != null) {
            return f;
        }
        File file = new File(this.f3318a.getFilesDir().getPath() + File.separator + "carrierdata");
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return null;
        }
        ArrayList a = m4312a(listFiles);
        if (a.size() < 2) {
            return null;
        }
        File file2 = (File) a.get(0);
        f = (File) a.get(1);
        return file2.getName().compareTo(f.getName()) > 0 ? f : file2;
    }

    /* renamed from: b */
    protected boolean m4327b(long j) {
        int e = m4321e();
        if (e != 0) {
            return e == 1 ? m4317c(j) != null : e == 2;
        } else {
            File file = new File(this.f3318a.getFilesDir().getPath() + File.separator + "carrierdata");
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    ArrayList a = m4312a(listFiles);
                    if (a.size() == 1) {
                        e = ((File) a.get(0)).length() <= 0 ? 10 : 1;
                    } else if (a.size() >= 2) {
                        e = 2;
                    }
                    return e != 0 ? false : e != 1 ? m4320d(j) == null : e != 2;
                }
            }
            e = 0;
            if (e != 0) {
                if (e != 1) {
                    if (e != 2) {
                    }
                }
            }
        }
    }
}
