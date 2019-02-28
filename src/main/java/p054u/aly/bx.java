package p054u.aly;

/* compiled from: ShortStack */
/* renamed from: u.aly.bx */
public class bx {
    /* renamed from: a */
    private short[] f6385a;
    /* renamed from: b */
    private int f6386b = -1;

    public bx(int i) {
        this.f6385a = new short[i];
    }

    /* renamed from: a */
    public short m10085a() {
        short[] sArr = this.f6385a;
        int i = this.f6386b;
        this.f6386b = i - 1;
        return sArr[i];
    }

    /* renamed from: a */
    public void m10086a(short s) {
        if (this.f6385a.length == this.f6386b + 1) {
            m10084d();
        }
        short[] sArr = this.f6385a;
        int i = this.f6386b + 1;
        this.f6386b = i;
        sArr[i] = s;
    }

    /* renamed from: d */
    private void m10084d() {
        Object obj = new short[(this.f6385a.length * 2)];
        System.arraycopy(this.f6385a, 0, obj, 0, this.f6385a.length);
        this.f6385a = obj;
    }

    /* renamed from: b */
    public short m10087b() {
        return this.f6385a[this.f6386b];
    }

    /* renamed from: c */
    public void m10088c() {
        this.f6386b = -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<ShortStack vector:[");
        for (int i = 0; i < this.f6385a.length; i++) {
            if (i != 0) {
                stringBuilder.append(" ");
            }
            if (i == this.f6386b) {
                stringBuilder.append(">>");
            }
            stringBuilder.append(this.f6385a[i]);
            if (i == this.f6386b) {
                stringBuilder.append("<<");
            }
        }
        stringBuilder.append("]>");
        return stringBuilder.toString();
    }
}
