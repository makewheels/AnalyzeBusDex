package p054u.aly;

/* compiled from: TField */
/* renamed from: u.aly.ct */
public class ct {
    /* renamed from: a */
    public final String f6484a;
    /* renamed from: b */
    public final byte f6485b;
    /* renamed from: c */
    public final short f6486c;

    public ct() {
        this(bi_常量类.f6358b_空串, (byte) 0, (short) 0);
    }

    public ct(String str, byte b, short s) {
        this.f6484a = str;
        this.f6485b = b;
        this.f6486c = s;
    }

    public String toString() {
        return "<TField name:'" + this.f6484a + "' type:" + this.f6485b + " field-id:" + this.f6486c + ">";
    }

    /* renamed from: a */
    public boolean m10319a(ct ctVar) {
        return this.f6485b == ctVar.f6485b && this.f6486c == ctVar.f6486c;
    }
}
