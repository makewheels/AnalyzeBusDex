package com.ta.utdid2.p037b.p038a;

import java.io.UnsupportedEncodingException;

/* compiled from: Base64 */
/* renamed from: com.ta.utdid2.b.a.b */
public class C1014b {
    /* renamed from: a */
    static final /* synthetic */ boolean f4698a = (!C1014b.class.desiredAssertionStatus());

    /* compiled from: Base64 */
    /* renamed from: com.ta.utdid2.b.a.b$a */
    static abstract class C1011a {
        /* renamed from: a */
        public byte[] f4681a;
        /* renamed from: b */
        public int f4682b;

        C1011a() {
        }
    }

    /* compiled from: Base64 */
    /* renamed from: com.ta.utdid2.b.a.b$b */
    static class C1012b extends C1011a {
        /* renamed from: c */
        private static final int[] f4683c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: d */
        private static final int[] f4684d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        /* renamed from: e */
        private int f4685e = 0;
        /* renamed from: f */
        private int f4686f = 0;
        /* renamed from: g */
        private final int[] f4687g = f4683c;

        public C1012b(byte[] bArr) {
            this.a = bArr;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean m7370a(byte[] r14, int r15) {
            /*
            r13 = this;
            r12 = -2;
            r11 = -1;
            r10 = 6;
            r3 = 0;
            r0 = r13.f4685e;
            if (r0 != r10) goto L_0x000a;
        L_0x0008:
            r0 = r3;
        L_0x0009:
            return r0;
        L_0x000a:
            r6 = r15 + 0;
            r0 = r13.f4685e;
            r1 = r13.f4686f;
            r7 = r13.a;
            r8 = r13.f4687g;
            r4 = r0;
            r2 = r3;
            r0 = r3;
        L_0x0017:
            if (r2 >= r6) goto L_0x00fa;
        L_0x0019:
            if (r4 != 0) goto L_0x0060;
        L_0x001b:
            r5 = r2 + 4;
            if (r5 > r6) goto L_0x005e;
        L_0x001f:
            r1 = r14[r2];
            r1 = r1 & 255;
            r1 = r8[r1];
            r1 = r1 << 18;
            r5 = r2 + 1;
            r5 = r14[r5];
            r5 = r5 & 255;
            r5 = r8[r5];
            r5 = r5 << 12;
            r1 = r1 | r5;
            r5 = r2 + 2;
            r5 = r14[r5];
            r5 = r5 & 255;
            r5 = r8[r5];
            r5 = r5 << 6;
            r1 = r1 | r5;
            r5 = r2 + 3;
            r5 = r14[r5];
            r5 = r5 & 255;
            r5 = r8[r5];
            r1 = r1 | r5;
            if (r1 < 0) goto L_0x005e;
        L_0x0048:
            r5 = r0 + 2;
            r9 = (byte) r1;
            r7[r5] = r9;
            r5 = r0 + 1;
            r9 = r1 >> 8;
            r9 = (byte) r9;
            r7[r5] = r9;
            r5 = r1 >> 16;
            r5 = (byte) r5;
            r7[r0] = r5;
            r0 = r0 + 3;
            r2 = r2 + 4;
            goto L_0x001b;
        L_0x005e:
            if (r2 >= r6) goto L_0x00fa;
        L_0x0060:
            r5 = r2 + 1;
            r2 = r14[r2];
            r2 = r2 & 255;
            r2 = r8[r2];
            switch(r4) {
                case 0: goto L_0x006d;
                case 1: goto L_0x007b;
                case 2: goto L_0x008c;
                case 3: goto L_0x00ac;
                case 4: goto L_0x00e4;
                case 5: goto L_0x00f3;
                default: goto L_0x006b;
            };
        L_0x006b:
            r2 = r5;
            goto L_0x0017;
        L_0x006d:
            if (r2 < 0) goto L_0x0075;
        L_0x006f:
            r1 = r4 + 1;
            r4 = r1;
            r1 = r2;
            r2 = r5;
            goto L_0x0017;
        L_0x0075:
            if (r2 == r11) goto L_0x006b;
        L_0x0077:
            r13.f4685e = r10;
            r0 = r3;
            goto L_0x0009;
        L_0x007b:
            if (r2 < 0) goto L_0x0085;
        L_0x007d:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r4 + 1;
            r4 = r2;
            r2 = r5;
            goto L_0x0017;
        L_0x0085:
            if (r2 == r11) goto L_0x006b;
        L_0x0087:
            r13.f4685e = r10;
            r0 = r3;
            goto L_0x0009;
        L_0x008c:
            if (r2 < 0) goto L_0x0096;
        L_0x008e:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r4 + 1;
            r4 = r2;
            r2 = r5;
            goto L_0x0017;
        L_0x0096:
            if (r2 != r12) goto L_0x00a5;
        L_0x0098:
            r2 = r0 + 1;
            r4 = r1 >> 4;
            r4 = (byte) r4;
            r7[r0] = r4;
            r0 = 4;
            r4 = r0;
            r0 = r2;
            r2 = r5;
            goto L_0x0017;
        L_0x00a5:
            if (r2 == r11) goto L_0x006b;
        L_0x00a7:
            r13.f4685e = r10;
            r0 = r3;
            goto L_0x0009;
        L_0x00ac:
            if (r2 < 0) goto L_0x00c8;
        L_0x00ae:
            r1 = r1 << 6;
            r1 = r1 | r2;
            r2 = r0 + 2;
            r4 = (byte) r1;
            r7[r2] = r4;
            r2 = r0 + 1;
            r4 = r1 >> 8;
            r4 = (byte) r4;
            r7[r2] = r4;
            r2 = r1 >> 16;
            r2 = (byte) r2;
            r7[r0] = r2;
            r0 = r0 + 3;
            r4 = r3;
            r2 = r5;
            goto L_0x0017;
        L_0x00c8:
            if (r2 != r12) goto L_0x00dd;
        L_0x00ca:
            r2 = r0 + 1;
            r4 = r1 >> 2;
            r4 = (byte) r4;
            r7[r2] = r4;
            r2 = r1 >> 10;
            r2 = (byte) r2;
            r7[r0] = r2;
            r0 = r0 + 2;
            r2 = 5;
            r4 = r2;
            r2 = r5;
            goto L_0x0017;
        L_0x00dd:
            if (r2 == r11) goto L_0x006b;
        L_0x00df:
            r13.f4685e = r10;
            r0 = r3;
            goto L_0x0009;
        L_0x00e4:
            if (r2 != r12) goto L_0x00ec;
        L_0x00e6:
            r2 = r4 + 1;
            r4 = r2;
            r2 = r5;
            goto L_0x0017;
        L_0x00ec:
            if (r2 == r11) goto L_0x006b;
        L_0x00ee:
            r13.f4685e = r10;
            r0 = r3;
            goto L_0x0009;
        L_0x00f3:
            if (r2 == r11) goto L_0x006b;
        L_0x00f5:
            r13.f4685e = r10;
            r0 = r3;
            goto L_0x0009;
        L_0x00fa:
            r2 = r1;
            switch(r4) {
                case 0: goto L_0x00fe;
                case 1: goto L_0x0105;
                case 2: goto L_0x010a;
                case 3: goto L_0x0113;
                case 4: goto L_0x0122;
                default: goto L_0x00fe;
            };
        L_0x00fe:
            r13.f4685e = r4;
            r13.b = r0;
            r0 = 1;
            goto L_0x0009;
        L_0x0105:
            r13.f4685e = r10;
            r0 = r3;
            goto L_0x0009;
        L_0x010a:
            r1 = r0 + 1;
            r2 = r2 >> 4;
            r2 = (byte) r2;
            r7[r0] = r2;
            r0 = r1;
            goto L_0x00fe;
        L_0x0113:
            r1 = r0 + 1;
            r3 = r2 >> 10;
            r3 = (byte) r3;
            r7[r0] = r3;
            r0 = r1 + 1;
            r2 = r2 >> 2;
            r2 = (byte) r2;
            r7[r1] = r2;
            goto L_0x00fe;
        L_0x0122:
            r13.f4685e = r10;
            r0 = r3;
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.b.b.a(byte[], int):boolean");
        }
    }

    /* compiled from: Base64 */
    /* renamed from: com.ta.utdid2.b.a.b$c */
    static class C1013c extends C1011a {
        /* renamed from: g */
        static final /* synthetic */ boolean f4688g;
        /* renamed from: h */
        private static final byte[] f4689h = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
        /* renamed from: i */
        private static final byte[] f4690i = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
        /* renamed from: c */
        int f4691c;
        /* renamed from: d */
        public final boolean f4692d;
        /* renamed from: e */
        public final boolean f4693e;
        /* renamed from: f */
        public final boolean f4694f;
        /* renamed from: j */
        private final byte[] f4695j;
        /* renamed from: k */
        private int f4696k;
        /* renamed from: l */
        private final byte[] f4697l;

        static {
            boolean z;
            if (C1014b.class.desiredAssertionStatus()) {
                z = false;
            } else {
                z = true;
            }
            f4688g = z;
        }

        public C1013c(int i) {
            boolean z;
            boolean z2 = true;
            this.a = null;
            this.f4692d = (i & 1) == 0;
            if ((i & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.f4693e = z;
            if ((i & 4) == 0) {
                z2 = false;
            }
            this.f4694f = z2;
            this.f4697l = (i & 8) == 0 ? f4689h : f4690i;
            this.f4695j = new byte[2];
            this.f4691c = 0;
            this.f4696k = this.f4693e ? 19 : -1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean m7371a(byte[] r14, int r15) {
            /*
            r13 = this;
            r6 = 2;
            r12 = 13;
            r11 = 10;
            r2 = 1;
            r3 = 0;
            r7 = r13.f4697l;
            r8 = r13.a;
            r4 = r13.f4696k;
            r9 = r15 + 0;
            r0 = -1;
            r1 = r13.f4691c;
            switch(r1) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x00a8;
                case 2: goto L_0x00c4;
                default: goto L_0x0015;
            };
        L_0x0015:
            r5 = r0;
            r1 = r3;
        L_0x0017:
            r0 = -1;
            if (r5 == r0) goto L_0x01f2;
        L_0x001a:
            r0 = r5 >> 18;
            r0 = r0 & 63;
            r0 = r7[r0];
            r8[r3] = r0;
            r0 = r5 >> 12;
            r0 = r0 & 63;
            r0 = r7[r0];
            r8[r2] = r0;
            r0 = r5 >> 6;
            r0 = r0 & 63;
            r0 = r7[r0];
            r8[r6] = r0;
            r6 = 3;
            r0 = 4;
            r5 = r5 & 63;
            r5 = r7[r5];
            r8[r6] = r5;
            r4 = r4 + -1;
            if (r4 != 0) goto L_0x01ee;
        L_0x003e:
            r4 = r13.f4694f;
            if (r4 == 0) goto L_0x0046;
        L_0x0042:
            r4 = 4;
            r0 = 5;
            r8[r4] = r12;
        L_0x0046:
            r5 = r0 + 1;
            r8[r0] = r11;
            r0 = 19;
            r6 = r0;
        L_0x004d:
            r0 = r1 + 3;
            if (r0 > r9) goto L_0x00e2;
        L_0x0051:
            r0 = r14[r1];
            r0 = r0 & 255;
            r0 = r0 << 16;
            r4 = r1 + 1;
            r4 = r14[r4];
            r4 = r4 & 255;
            r4 = r4 << 8;
            r0 = r0 | r4;
            r4 = r1 + 2;
            r4 = r14[r4];
            r4 = r4 & 255;
            r0 = r0 | r4;
            r4 = r0 >> 18;
            r4 = r4 & 63;
            r4 = r7[r4];
            r8[r5] = r4;
            r4 = r5 + 1;
            r10 = r0 >> 12;
            r10 = r10 & 63;
            r10 = r7[r10];
            r8[r4] = r10;
            r4 = r5 + 2;
            r10 = r0 >> 6;
            r10 = r10 & 63;
            r10 = r7[r10];
            r8[r4] = r10;
            r4 = r5 + 3;
            r0 = r0 & 63;
            r0 = r7[r0];
            r8[r4] = r0;
            r4 = r1 + 3;
            r1 = r5 + 4;
            r0 = r6 + -1;
            if (r0 != 0) goto L_0x01e9;
        L_0x0093:
            r0 = r13.f4694f;
            if (r0 == 0) goto L_0x01e6;
        L_0x0097:
            r0 = r1 + 1;
            r8[r1] = r12;
        L_0x009b:
            r5 = r0 + 1;
            r8[r0] = r11;
            r0 = 19;
            r1 = r4;
            r6 = r0;
            goto L_0x004d;
        L_0x00a4:
            r5 = r0;
            r1 = r3;
            goto L_0x0017;
        L_0x00a8:
            if (r6 > r9) goto L_0x0015;
        L_0x00aa:
            r0 = r13.f4695j;
            r0 = r0[r3];
            r0 = r0 & 255;
            r0 = r0 << 16;
            r1 = r14[r3];
            r1 = r1 & 255;
            r1 = r1 << 8;
            r0 = r0 | r1;
            r1 = r14[r2];
            r1 = r1 & 255;
            r0 = r0 | r1;
            r13.f4691c = r3;
            r5 = r0;
            r1 = r6;
            goto L_0x0017;
        L_0x00c4:
            if (r9 <= 0) goto L_0x0015;
        L_0x00c6:
            r0 = r13.f4695j;
            r0 = r0[r3];
            r0 = r0 & 255;
            r0 = r0 << 16;
            r1 = r13.f4695j;
            r1 = r1[r2];
            r1 = r1 & 255;
            r1 = r1 << 8;
            r0 = r0 | r1;
            r1 = r14[r3];
            r1 = r1 & 255;
            r0 = r0 | r1;
            r13.f4691c = r3;
            r5 = r0;
            r1 = r2;
            goto L_0x0017;
        L_0x00e2:
            r0 = r13.f4691c;
            r0 = r1 - r0;
            r4 = r9 + -1;
            if (r0 != r4) goto L_0x0148;
        L_0x00ea:
            r0 = r13.f4691c;
            if (r0 <= 0) goto L_0x0141;
        L_0x00ee:
            r0 = r13.f4695j;
            r0 = r0[r3];
            r3 = r1;
            r1 = r2;
        L_0x00f4:
            r0 = r0 & 255;
            r4 = r0 << 4;
            r0 = r13.f4691c;
            r0 = r0 - r1;
            r13.f4691c = r0;
            r1 = r5 + 1;
            r0 = r4 >> 6;
            r0 = r0 & 63;
            r0 = r7[r0];
            r8[r5] = r0;
            r0 = r1 + 1;
            r4 = r4 & 63;
            r4 = r7[r4];
            r8[r1] = r4;
            r1 = r13.f4692d;
            if (r1 == 0) goto L_0x011f;
        L_0x0113:
            r1 = r0 + 1;
            r4 = 61;
            r8[r0] = r4;
            r0 = r1 + 1;
            r4 = 61;
            r8[r1] = r4;
        L_0x011f:
            r1 = r13.f4693e;
            if (r1 == 0) goto L_0x0131;
        L_0x0123:
            r1 = r13.f4694f;
            if (r1 == 0) goto L_0x012c;
        L_0x0127:
            r1 = r0 + 1;
            r8[r0] = r12;
            r0 = r1;
        L_0x012c:
            r1 = r0 + 1;
            r8[r0] = r11;
            r0 = r1;
        L_0x0131:
            r1 = r3;
            r5 = r0;
        L_0x0133:
            r0 = f4688g;
            if (r0 != 0) goto L_0x01d1;
        L_0x0137:
            r0 = r13.f4691c;
            if (r0 == 0) goto L_0x01d1;
        L_0x013b:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0141:
            r4 = r1 + 1;
            r0 = r14[r1];
            r1 = r3;
            r3 = r4;
            goto L_0x00f4;
        L_0x0148:
            r0 = r13.f4691c;
            r0 = r1 - r0;
            r4 = r9 + -2;
            if (r0 != r4) goto L_0x01b9;
        L_0x0150:
            r0 = r13.f4691c;
            if (r0 <= r2) goto L_0x01ad;
        L_0x0154:
            r0 = r13.f4695j;
            r0 = r0[r3];
            r3 = r2;
        L_0x0159:
            r0 = r0 & 255;
            r10 = r0 << 10;
            r0 = r13.f4691c;
            if (r0 <= 0) goto L_0x01b3;
        L_0x0161:
            r0 = r13.f4695j;
            r4 = r3 + 1;
            r0 = r0[r3];
            r3 = r4;
        L_0x0168:
            r0 = r0 & 255;
            r0 = r0 << 2;
            r0 = r0 | r10;
            r4 = r13.f4691c;
            r3 = r4 - r3;
            r13.f4691c = r3;
            r3 = r5 + 1;
            r4 = r0 >> 12;
            r4 = r4 & 63;
            r4 = r7[r4];
            r8[r5] = r4;
            r4 = r3 + 1;
            r5 = r0 >> 6;
            r5 = r5 & 63;
            r5 = r7[r5];
            r8[r3] = r5;
            r3 = r4 + 1;
            r0 = r0 & 63;
            r0 = r7[r0];
            r8[r4] = r0;
            r0 = r13.f4692d;
            if (r0 == 0) goto L_0x01e4;
        L_0x0193:
            r0 = r3 + 1;
            r4 = 61;
            r8[r3] = r4;
        L_0x0199:
            r3 = r13.f4693e;
            if (r3 == 0) goto L_0x01ab;
        L_0x019d:
            r3 = r13.f4694f;
            if (r3 == 0) goto L_0x01a6;
        L_0x01a1:
            r3 = r0 + 1;
            r8[r0] = r12;
            r0 = r3;
        L_0x01a6:
            r3 = r0 + 1;
            r8[r0] = r11;
            r0 = r3;
        L_0x01ab:
            r5 = r0;
            goto L_0x0133;
        L_0x01ad:
            r4 = r1 + 1;
            r0 = r14[r1];
            r1 = r4;
            goto L_0x0159;
        L_0x01b3:
            r4 = r1 + 1;
            r0 = r14[r1];
            r1 = r4;
            goto L_0x0168;
        L_0x01b9:
            r0 = r13.f4693e;
            if (r0 == 0) goto L_0x0133;
        L_0x01bd:
            if (r5 <= 0) goto L_0x0133;
        L_0x01bf:
            r0 = 19;
            if (r6 == r0) goto L_0x0133;
        L_0x01c3:
            r0 = r13.f4694f;
            if (r0 == 0) goto L_0x01e2;
        L_0x01c7:
            r0 = r5 + 1;
            r8[r5] = r12;
        L_0x01cb:
            r5 = r0 + 1;
            r8[r0] = r11;
            goto L_0x0133;
        L_0x01d1:
            r0 = f4688g;
            if (r0 != 0) goto L_0x01dd;
        L_0x01d5:
            if (r1 == r9) goto L_0x01dd;
        L_0x01d7:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x01dd:
            r13.b = r5;
            r13.f4696k = r6;
            return r2;
        L_0x01e2:
            r0 = r5;
            goto L_0x01cb;
        L_0x01e4:
            r0 = r3;
            goto L_0x0199;
        L_0x01e6:
            r0 = r1;
            goto L_0x009b;
        L_0x01e9:
            r6 = r0;
            r5 = r1;
            r1 = r4;
            goto L_0x004d;
        L_0x01ee:
            r6 = r4;
            r5 = r0;
            goto L_0x004d;
        L_0x01f2:
            r6 = r4;
            r5 = r3;
            goto L_0x004d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.b.c.a(byte[], int):boolean");
        }
    }

    /* renamed from: a */
    public static byte[] m7373a(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        C1012b c1012b = new C1012b(new byte[((length * 3) / 4)]);
        if (!c1012b.m7370a(bytes, length)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (c1012b.b == c1012b.a.length) {
            return c1012b.a;
        } else {
            bytes = new byte[c1012b.b];
            System.arraycopy(c1012b.a, 0, bytes, 0, c1012b.b);
            return bytes;
        }
    }

    /* renamed from: a */
    public static String m7372a(byte[] bArr, int i) {
        try {
            int i2;
            int length = bArr.length;
            C1013c c1013c = new C1013c(i);
            int i3 = (length / 3) * 4;
            if (!c1013c.f4692d) {
                switch (length % 3) {
                    case 0:
                        break;
                    case 1:
                        i3 += 2;
                        break;
                    case 2:
                        i3 += 3;
                        break;
                    default:
                        break;
                }
            } else if (length % 3 > 0) {
                i3 += 4;
            }
            if (!c1013c.f4693e || length <= 0) {
                i2 = i3;
            } else {
                i2 = ((c1013c.f4694f ? 2 : 1) * (((length - 1) / 57) + 1)) + i3;
            }
            c1013c.a = new byte[i2];
            c1013c.m7371a(bArr, length);
            if (f4698a || c1013c.b == i2) {
                return new String(c1013c.a, "US-ASCII");
            }
            throw new AssertionError();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    private C1014b() {
    }
}
