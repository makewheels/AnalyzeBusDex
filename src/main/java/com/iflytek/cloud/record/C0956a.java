package com.iflytek.cloud.record;

import android.content.Context;
import android.media.AudioTrack;
import android.os.MemoryFile;
import android.text.TextUtils;
import com.iflytek.cloud.p023b.p024e.C0945d;
import com.iflytek.cloud.p023b.p024e.p029a.C0939a;
import com.iflytek.cloud.speech.ErrorCode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import p054u.aly.bi_常量类;

/* renamed from: com.iflytek.cloud.record.a */
public class C0956a {
    /* renamed from: a */
    private int f4529a = 3145728;
    /* renamed from: b */
    private ArrayList<C0955a> f4530b = null;
    /* renamed from: c */
    private Context f4531c = null;
    /* renamed from: d */
    private int f4532d = ErrorCode.MSP_ERROR_LMOD_BASE;
    /* renamed from: e */
    private volatile int f4533e = 0;
    /* renamed from: f */
    private MemoryFile f4534f = null;
    /* renamed from: g */
    private volatile long f4535g = 0;
    /* renamed from: h */
    private volatile int f4536h = 0;
    /* renamed from: i */
    private C0955a f4537i = null;
    /* renamed from: j */
    private String f4538j = bi_常量类.f6358b;
    /* renamed from: k */
    private String f4539k = null;

    /* renamed from: com.iflytek.cloud.record.a$a */
    public class C0955a {
        /* renamed from: a */
        long f4524a;
        /* renamed from: b */
        long f4525b;
        /* renamed from: c */
        int f4526c;
        /* renamed from: d */
        int f4527d;
        /* renamed from: e */
        final /* synthetic */ C0956a f4528e;

        public C0955a(C0956a c0956a, long j, long j2, int i, int i2) {
            this.f4528e = c0956a;
            this.f4524a = j;
            this.f4525b = j2;
            this.f4526c = i;
            this.f4527d = i2;
        }
    }

    public C0956a(Context context, int i, String str) {
        this.f4531c = context;
        this.f4533e = 0;
        this.f4530b = new ArrayList();
        this.f4535g = 0;
        this.f4532d = i;
        this.f4539k = str;
    }

    /* renamed from: a */
    private void m7226a(byte[] bArr) throws IOException {
        if (bArr != null && bArr.length != 0) {
            if (this.f4534f == null) {
                this.f4538j = m7227i();
                this.f4534f = new MemoryFile(this.f4538j, this.f4529a);
                this.f4534f.allowPurging(false);
            }
            this.f4534f.writeBytes(bArr, 0, (int) this.f4535g, bArr.length);
            this.f4535g += (long) bArr.length;
        }
    }

    /* renamed from: i */
    private String m7227i() {
        return C0945d.m7138a(this.f4531c) + "tts.pcm";
    }

    /* renamed from: a */
    public int m7228a() {
        return this.f4532d;
    }

    /* renamed from: a */
    public void m7229a(AudioTrack audioTrack, int i) throws IOException {
        int i2 = this.f4535g - ((long) this.f4536h) < ((long) i) ? (int) (this.f4535g - ((long) this.f4536h)) : i;
        byte[] bArr = new byte[i2];
        this.f4534f.readBytes(bArr, this.f4536h, 0, i2);
        this.f4536h += i2;
        audioTrack.write(bArr, 0, i2);
        if (i2 < i) {
            m7233b(audioTrack, i);
        }
    }

    /* renamed from: a */
    public void m7230a(String str) {
        int i = 307200;
        if (!TextUtils.isEmpty(str)) {
            this.f4529a = (((str.length() / 5) * 4) * 32) * 1024;
            if (this.f4529a > 307200) {
                i = this.f4529a;
            }
            this.f4529a = i;
        }
    }

    /* renamed from: a */
    public void m7231a(ArrayList<byte[]> arrayList, int i, int i2, int i3) throws IOException {
        C0939a.m7120a("buffer percent = " + i + " beg=" + i2 + " end=" + i3);
        C0955a c0955a = new C0955a(this, this.f4535g, this.f4535g, i2, i3);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            m7226a((byte[]) arrayList.get(i4));
        }
        c0955a.f4525b = this.f4535g;
        this.f4533e = i;
        this.f4530b.add(c0955a);
        C0939a.m7120a("allSize = " + this.f4535g + " maxSize=" + this.f4529a);
    }

    /* renamed from: a */
    public boolean m7232a(int i) {
        return this.f4533e > 95 || ((int) (this.f4535g / 32768)) >= i / 1000;
    }

    /* renamed from: b */
    public void m7233b(AudioTrack audioTrack, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) 0;
        }
        audioTrack.write(bArr, 0, i);
    }

    /* renamed from: b */
    public boolean m7234b() {
        C0939a.m7120a("save to local: totalSize = " + this.f4535g + " maxSize=" + this.f4529a);
        return C0945d.m7141a(this.f4534f, this.f4535g, this.f4539k);
    }

    /* renamed from: c */
    public void m7235c() throws IOException {
        this.f4536h = 0;
        this.f4537i = null;
        if (this.f4530b.size() > 0) {
            this.f4537i = (C0955a) this.f4530b.get(0);
        }
    }

    /* renamed from: d */
    public int m7236d() {
        return this.f4535g <= 0 ? 0 : (int) (((long) (this.f4536h * this.f4533e)) / this.f4535g);
    }

    /* renamed from: e */
    public C0955a m7237e() {
        if (this.f4537i != null) {
            if (((long) this.f4536h) >= this.f4537i.f4524a && ((long) this.f4536h) <= this.f4537i.f4525b) {
                return this.f4537i;
            }
            Iterator it = this.f4530b.iterator();
            while (it.hasNext()) {
                this.f4537i = (C0955a) it.next();
                if (((long) this.f4536h) >= this.f4537i.f4524a && ((long) this.f4536h) <= this.f4537i.f4525b) {
                    return this.f4537i;
                }
            }
        }
        return null;
    }

    /* renamed from: f */
    public boolean m7238f() {
        return 100 == this.f4533e && ((long) this.f4536h) >= this.f4535g;
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    /* renamed from: g */
    public boolean m7239g() throws IOException {
        return ((long) this.f4536h) < this.f4535g;
    }

    /* renamed from: h */
    public void m7240h() {
        try {
            if (this.f4534f != null) {
                this.f4534f.close();
                this.f4534f = null;
            }
            File file = new File(this.f4538j);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
