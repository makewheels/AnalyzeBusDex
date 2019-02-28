package p054u.aly;

/* compiled from: SDKType */
/* renamed from: u.aly.bc */
public enum bc implements cd {
    ANDROID(0),
    IOS(1),
    WINDOWS_PHONE(2),
    WINDOWS_RT(3);
    
    /* renamed from: e */
    private final int f6234e;

    private bc(int i) {
        this.f6234e = i;
    }

    /* renamed from: a */
    public int mo1927a() {
        return this.f6234e;
    }

    /* renamed from: a */
    public static bc m9683a(int i) {
        switch (i) {
            case 0:
                return ANDROID;
            case 1:
                return IOS;
            case 2:
                return WINDOWS_PHONE;
            case 3:
                return WINDOWS_RT;
            default:
                return null;
        }
    }
}
