package p054u.aly;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import p054u.aly.cs.C1429a;

/* compiled from: TSerializer */
/* renamed from: u.aly.ci */
public class ci {
    /* renamed from: a */
    private final ByteArrayOutputStream f6418a;
    /* renamed from: b */
    private final dk f6419b;
    /* renamed from: c */
    private cy f6420c;

    public ci() {
        this(new C1429a());
    }

    public ci(da daVar) {
        this.f6418a = new ByteArrayOutputStream();
        this.f6419b = new dk(this.f6418a);
        this.f6420c = daVar.mo1942a(this.f6419b);
    }

    /* renamed from: a */
    public byte[] m10144a(bz bzVar) throws cf {
        this.f6418a.reset();
        bzVar.mo1924b(this.f6420c);
        return this.f6418a.toByteArray();
    }

    /* renamed from: a */
    public String m10143a(bz bzVar, String str) throws cf {
        try {
            return new String(m10144a(bzVar), str);
        } catch (UnsupportedEncodingException e) {
            throw new cf("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    /* renamed from: b */
    public String m10145b(bz bzVar) throws cf {
        return new String(m10144a(bzVar));
    }
}
