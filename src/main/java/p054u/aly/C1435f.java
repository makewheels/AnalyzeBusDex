package p054u.aly;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* compiled from: ImprintHandler */
/* renamed from: u.aly.f */
public class C1435f {
    /* renamed from: a */
    private static final String f6545a = ".imprint";
    /* renamed from: b */
    private static final byte[] f6546b = "pbl0".getBytes();
    /* renamed from: c */
    private at f6547c = null;
    /* renamed from: d */
    private Context f6548d;

    public C1435f(Context context) {
        this.f6548d = context;
    }

    /* renamed from: a */
    public String m10379a(at atVar) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : new TreeMap(atVar.m9265d()).entrySet()) {
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(((au) entry.getValue()).m9310c());
            stringBuilder.append(((au) entry.getValue()).m9314f());
            stringBuilder.append(((au) entry.getValue()).m9318j());
        }
        stringBuilder.append(atVar.f6064b);
        return bv.m10055a(stringBuilder.toString()).toLowerCase(Locale.US);
    }

    /* renamed from: c */
    private boolean m10378c(at atVar) {
        if (!atVar.m9272k().equals(m10379a(atVar))) {
            return false;
        }
        for (au auVar : atVar.m9265d().values()) {
            byte[] b = C1420c.m10096b(auVar.m9318j());
            byte[] a = m10381a(auVar);
            for (int i = 0; i < 4; i++) {
                if (b[i] != a[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public byte[] m10381a(au auVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(auVar.m9314f());
        byte[] array = allocate.array();
        byte[] bArr = f6546b;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: b */
    public void m10383b(at atVar) {
        if (atVar != null && m10378c(atVar)) {
            synchronized (this) {
                at atVar2 = this.f6547c;
                if (atVar2 != null) {
                    atVar = m10377a(atVar2, atVar);
                }
                this.f6547c = atVar;
            }
        }
    }

    /* renamed from: a */
    private at m10377a(at atVar, at atVar2) {
        if (atVar2 != null) {
            Map d = atVar.m9265d();
            for (Entry entry : atVar2.m9265d().entrySet()) {
                if (((au) entry.getValue()).m9313e()) {
                    d.put(entry.getKey(), entry.getValue());
                } else {
                    d.remove(entry.getKey());
                }
            }
            atVar.m9252a(atVar2.m9269h());
            atVar.m9253a(m10379a(atVar));
        }
        return atVar;
    }

    /* renamed from: a */
    public synchronized at m10380a() {
        return this.f6547c;
    }

    /* renamed from: b */
    public void m10382b() {
        byte[] b;
        Exception e;
        bz atVar;
        Throwable th;
        InputStream inputStream = null;
        if (new File(this.f6548d.getFilesDir(), f6545a).exists()) {
            InputStream openFileInput;
            try {
                openFileInput = this.f6548d.openFileInput(f6545a);
                try {
                    b = bv.m10063b(openFileInput);
                    bv.m10065c(openFileInput);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        bv.m10065c(openFileInput);
                        if (b == null) {
                            try {
                                atVar = new at();
                                new cc().m10132a(atVar, b);
                                this.f6547c = atVar;
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openFileInput;
                        bv.m10065c(inputStream);
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e3 = e4;
                openFileInput = inputStream;
                e3.printStackTrace();
                bv.m10065c(openFileInput);
                if (b == null) {
                    atVar = new at();
                    new cc().m10132a(atVar, b);
                    this.f6547c = atVar;
                }
            } catch (Throwable th3) {
                th = th3;
                bv.m10065c(inputStream);
                throw th;
            }
            if (b == null) {
                atVar = new at();
                new cc().m10132a(atVar, b);
                this.f6547c = atVar;
            }
        }
    }

    /* renamed from: c */
    public void m10384c() {
        if (this.f6547c != null) {
            try {
                bv.m10059a(new File(this.f6548d.getFilesDir(), f6545a), new ci().m10144a(this.f6547c));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    public boolean m10385d() {
        return new File(this.f6548d.getFilesDir(), f6545a).delete();
    }
}
