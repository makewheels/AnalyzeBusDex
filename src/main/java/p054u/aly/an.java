package p054u.aly;

/* compiled from: ErrorSource */
/* renamed from: u.aly.an */
public enum an implements cd {
    LEGIT(1),
    ALIEN(2);
    
    /* renamed from: c */
    private final int f5976c;

    private an(int i) {
        this.f5976c = i;
    }

    /* renamed from: a */
    public int mo1927a() {
        return this.f5976c;
    }

    /* renamed from: a */
    public static an m9058a(int i) {
        switch (i) {
            case 1:
                return LEGIT;
            case 2:
                return ALIEN;
            default:
                return null;
        }
    }
}
