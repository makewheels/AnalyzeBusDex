package p054u.aly;

/* compiled from: Gender */
/* renamed from: u.aly.ap */
public enum ap implements cd {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);
    
    /* renamed from: d */
    private final int f5990d;

    private ap(int i) {
        this.f5990d = i;
    }

    /* renamed from: a */
    public int mo1927a() {
        return this.f5990d;
    }

    /* renamed from: a */
    public static ap m9077a(int i) {
        switch (i) {
            case 0:
                return MALE;
            case 1:
                return FEMALE;
            case 2:
                return UNKNOWN;
            default:
                return null;
        }
    }
}
