package p054u.aly;

import java.util.BitSet;

/* compiled from: TTupleProtocol */
/* renamed from: u.aly.de */
public final class de extends cs {

    /* compiled from: TTupleProtocol */
    /* renamed from: u.aly.de$a */
    public static class C1432a implements da {
        /* renamed from: a */
        public cy mo1942a(dm dmVar) {
            return new de(dmVar);
        }
    }

    public de(dm dmVar) {
        super(dmVar);
    }

    /* renamed from: D */
    public Class<? extends dg> mo1985D() {
        return dj.class;
    }

    /* renamed from: a */
    public void m10341a(BitSet bitSet, int i) throws cf {
        for (byte a : de.m10339b(bitSet, i)) {
            mo1945a(a);
        }
    }

    /* renamed from: b */
    public BitSet mo1986b(int i) throws cf {
        int ceil = (int) Math.ceil(((double) i) / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = mo1978u();
        }
        return de.m10338a(bArr);
    }

    /* renamed from: a */
    public static BitSet m10338a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    /* renamed from: b */
    public static byte[] m10339b(BitSet bitSet, int i) {
        byte[] bArr = new byte[((int) Math.ceil(((double) i) / 8.0d))];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) (bArr[length] | (1 << (i2 % 8)));
            }
        }
        return bArr;
    }
}
