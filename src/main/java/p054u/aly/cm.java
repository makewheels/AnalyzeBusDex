package p054u.aly;

import java.io.Serializable;

/* compiled from: FieldValueMetaData */
/* renamed from: u.aly.cm */
public class cm implements Serializable {
    /* renamed from: a */
    private final boolean f6421a;
    /* renamed from: b */
    public final byte f6422b;
    /* renamed from: c */
    private final String f6423c;
    /* renamed from: d */
    private final boolean f6424d;

    public cm(byte b, boolean z) {
        this.f6422b = b;
        this.f6421a = false;
        this.f6423c = null;
        this.f6424d = z;
    }

    public cm(byte b) {
        this(b, false);
    }

    public cm(byte b, String str) {
        this.f6422b = b;
        this.f6421a = true;
        this.f6423c = str;
        this.f6424d = false;
    }

    /* renamed from: a */
    public boolean m10158a() {
        return this.f6421a;
    }

    /* renamed from: b */
    public String m10159b() {
        return this.f6423c;
    }

    /* renamed from: c */
    public boolean m10160c() {
        return this.f6422b == (byte) 12;
    }

    /* renamed from: d */
    public boolean m10161d() {
        return this.f6422b == df.f6529m || this.f6422b == df.f6527k || this.f6422b == df.f6528l;
    }

    /* renamed from: e */
    public boolean m10162e() {
        return this.f6424d;
    }
}
