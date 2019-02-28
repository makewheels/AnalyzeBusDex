package p054u.aly;

/* compiled from: AccessType */
/* renamed from: u.aly.ag */
public enum ag implements cd {
    ACCESS_TYPE_UNKNOWN(0),
    ACCESS_TYPE_2G_3G(1),
    ACCESS_TYPE_WIFI(2),
    ACCESS_TYPE_ETHERNET(3);
    
    /* renamed from: e */
    private final int f5801e;

    private ag(int i) {
        this.f5801e = i;
    }

    /* renamed from: a */
    public int mo1927a() {
        return this.f5801e;
    }

    /* renamed from: a */
    public static ag m8697a(int i) {
        switch (i) {
            case 0:
                return ACCESS_TYPE_UNKNOWN;
            case 1:
                return ACCESS_TYPE_2G_3G;
            case 2:
                return ACCESS_TYPE_WIFI;
            case 3:
                return ACCESS_TYPE_ETHERNET;
            default:
                return null;
        }
    }
}
