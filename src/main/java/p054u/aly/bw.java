package p054u.aly;

import com.tencent.smtt.sdk.WebView;

/* compiled from: EncodingUtils */
/* renamed from: u.aly.bw */
public class bw {
    /* renamed from: a */
    public static final void m10074a(int i, byte[] bArr) {
        bw.m10075a(i, bArr, 0);
    }

    /* renamed from: a */
    public static final void m10075a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 1] = (byte) ((i >> 16) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 2] = (byte) ((i >> 8) & WebView.NORMAL_MODE_ALPHA);
        bArr[i2 + 3] = (byte) (i & WebView.NORMAL_MODE_ALPHA);
    }

    /* renamed from: a */
    public static final int m10070a(byte[] bArr) {
        return bw.m10071a(bArr, 0);
    }

    /* renamed from: a */
    public static final int m10071a(byte[] bArr, int i) {
        return ((((bArr[i] & WebView.NORMAL_MODE_ALPHA) << 24) | ((bArr[i + 1] & WebView.NORMAL_MODE_ALPHA) << 16)) | ((bArr[i + 2] & WebView.NORMAL_MODE_ALPHA) << 8)) | (bArr[i + 3] & WebView.NORMAL_MODE_ALPHA);
    }

    /* renamed from: a */
    public static final boolean m10076a(byte b, int i) {
        return bw.m10077a((int) b, i);
    }

    /* renamed from: a */
    public static final boolean m10079a(short s, int i) {
        return bw.m10077a((int) s, i);
    }

    /* renamed from: a */
    public static final boolean m10077a(int i, int i2) {
        return ((1 << i2) & i) != 0;
    }

    /* renamed from: a */
    public static final boolean m10078a(long j, int i) {
        return ((1 << i) & j) != 0;
    }

    /* renamed from: b */
    public static final byte m10080b(byte b, int i) {
        return (byte) bw.m10081b((int) b, i);
    }

    /* renamed from: b */
    public static final short m10083b(short s, int i) {
        return (short) bw.m10081b((int) s, i);
    }

    /* renamed from: b */
    public static final int m10081b(int i, int i2) {
        return ((1 << i2) ^ -1) & i;
    }

    /* renamed from: b */
    public static final long m10082b(long j, int i) {
        return ((1 << i) ^ -1) & j;
    }

    /* renamed from: a */
    public static final byte m10068a(byte b, int i, boolean z) {
        return (byte) bw.m10069a((int) b, i, z);
    }

    /* renamed from: a */
    public static final short m10073a(short s, int i, boolean z) {
        return (short) bw.m10069a((int) s, i, z);
    }

    /* renamed from: a */
    public static final int m10069a(int i, int i2, boolean z) {
        if (z) {
            return (1 << i2) | i;
        }
        return bw.m10081b(i, i2);
    }

    /* renamed from: a */
    public static final long m10072a(long j, int i, boolean z) {
        if (z) {
            return (1 << i) | j;
        }
        return bw.m10082b(j, i);
    }
}
