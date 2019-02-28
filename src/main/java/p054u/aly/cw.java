package p054u.aly;

/* compiled from: TMessage */
/* renamed from: u.aly.cw */
public final class cw {
    /* renamed from: a */
    public final String f6492a;
    /* renamed from: b */
    public final byte f6493b;
    /* renamed from: c */
    public final int f6494c;

    public cw() {
        this(bi_常量类.f6358b, (byte) 0, 0);
    }

    public cw(String str, byte b, int i) {
        this.f6492a = str;
        this.f6493b = b;
        this.f6494c = i;
    }

    public String toString() {
        return "<TMessage name:'" + this.f6492a + "' type: " + this.f6493b + " seqid:" + this.f6494c + ">";
    }

    public boolean equals(Object obj) {
        if (obj instanceof cw) {
            return m10320a((cw) obj);
        }
        return false;
    }

    /* renamed from: a */
    public boolean m10320a(cw cwVar) {
        return this.f6492a.equals(cwVar.f6492a) && this.f6493b == cwVar.f6493b && this.f6494c == cwVar.f6494c;
    }
}
