package p054u.aly;

import p054u.aly.cs.C1429a;

/* compiled from: TProtocolUtil */
/* renamed from: u.aly.db */
public class db {
    /* renamed from: a */
    private static int f6513a = Integer.MAX_VALUE;

    /* renamed from: a */
    public static void m10334a(int i) {
        f6513a = i;
    }

    /* renamed from: a */
    public static void m10335a(cy cyVar, byte b) throws cf {
        db.m10336a(cyVar, b, f6513a);
    }

    /* renamed from: a */
    public static void m10336a(cy cyVar, byte b, int i) throws cf {
        int i2 = 0;
        if (i <= 0) {
            throw new cf("Maximum skip depth exceeded");
        }
        switch (b) {
            case (byte) 2:
                cyVar.mo1977t();
                return;
            case (byte) 3:
                cyVar.mo1978u();
                return;
            case (byte) 4:
                cyVar.mo1982y();
                return;
            case (byte) 6:
                cyVar.mo1979v();
                return;
            case (byte) 8:
                cyVar.mo1980w();
                return;
            case (byte) 10:
                cyVar.mo1981x();
                return;
            case (byte) 11:
                cyVar.mo1943A();
                return;
            case (byte) 12:
                cyVar.mo1967j();
                while (true) {
                    ct l = cyVar.mo1969l();
                    if (l.f6485b == (byte) 0) {
                        cyVar.mo1968k();
                        return;
                    } else {
                        db.m10336a(cyVar, l.f6485b, i - 1);
                        cyVar.mo1970m();
                    }
                }
            case (byte) 13:
                cv n = cyVar.mo1971n();
                while (i2 < n.f6491c) {
                    db.m10336a(cyVar, n.f6489a, i - 1);
                    db.m10336a(cyVar, n.f6490b, i - 1);
                    i2++;
                }
                cyVar.mo1972o();
                return;
            case (byte) 14:
                dc r = cyVar.mo1975r();
                while (i2 < r.f6515b) {
                    db.m10336a(cyVar, r.f6514a, i - 1);
                    i2++;
                }
                cyVar.mo1976s();
                return;
            case (byte) 15:
                cu p = cyVar.mo1973p();
                while (i2 < p.f6488b) {
                    db.m10336a(cyVar, p.f6487a, i - 1);
                    i2++;
                }
                cyVar.mo1974q();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public static da m10333a(byte[] bArr, da daVar) {
        if (bArr[0] > df.f6530n) {
            return new C1429a();
        }
        if (bArr.length <= 1 || (bArr[1] & 128) == 0) {
            return daVar;
        }
        return new C1429a();
    }
}
