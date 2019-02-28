package com.aps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.zip.GZIPInputStream;

public final class bc {
    /* renamed from: a */
    private RandomAccessFile f3409a;
    /* renamed from: b */
    private af f3410b;
    /* renamed from: c */
    private File f3411c = null;

    protected bc(af afVar) {
        this.f3410b = afVar;
    }

    /* renamed from: a */
    private static byte m4417a(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, bArr3.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            gZIPInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception e) {
        }
        return bArr2[0];
    }

    /* renamed from: a */
    private static int m4418a(int i, int i2, int i3) {
        int i4 = ((i3 - 1) * 1500) + i;
        while (i4 >= i2) {
            i4 -= 1500;
        }
        return i4;
    }

    /* renamed from: a */
    private int m4419a(BitSet bitSet) {
        for (int i = 0; i < bitSet.length(); i++) {
            if (bitSet.get(i)) {
                return this.f3410b.m4323a() + ((i * 1500) + 4);
            }
        }
        return 0;
    }

    /* renamed from: a */
    private ArrayList m4420a(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        while (i <= i2) {
            try {
                this.f3409a.seek((long) i);
                int readInt = this.f3409a.readInt();
                this.f3409a.readLong();
                if (readInt <= 0) {
                    readInt = Integer.MAX_VALUE;
                }
                byte[] bArr = new byte[readInt];
                this.f3409a.read(bArr);
                byte a = m4417a(bArr);
                if (a == (byte) 3 || a == (byte) 4) {
                    arrayList.add(bArr);
                    i += 1500;
                } else {
                    throw new OutOfMemoryError();
                }
            } catch (IOException e) {
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private BitSet m4421b() {
        BitSet bitSet = null;
        byte[] bArr = new byte[this.f3410b.m4323a()];
        try {
            this.f3409a.read(bArr);
            bitSet = af.m4316b(bArr);
        } catch (IOException e) {
        }
        return bitSet;
    }

    /* renamed from: a */
    protected final int m4422a() {
        int i = 0;
        synchronized (this) {
            this.f3411c = this.f3410b.m4326b();
            try {
                if (this.f3411c != null) {
                    this.f3409a = new RandomAccessFile(this.f3410b.m4326b(), "rw");
                    byte[] bArr = new byte[this.f3410b.m4323a()];
                    this.f3409a.read(bArr);
                    BitSet b = af.m4316b(bArr);
                    for (int i2 = 0; i2 < b.size(); i2++) {
                        if (b.get(i2)) {
                            i++;
                        }
                    }
                }
                if (this.f3409a != null) {
                    try {
                        this.f3409a.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (this.f3409a != null) {
                    try {
                        this.f3409a.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                if (this.f3409a != null) {
                    try {
                        this.f3409a.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (NullPointerException e6) {
                if (this.f3409a != null) {
                    try {
                        this.f3409a.close();
                    } catch (IOException e7) {
                    }
                }
            } catch (Throwable th) {
                if (this.f3409a != null) {
                    try {
                        this.f3409a.close();
                    } catch (IOException e8) {
                    }
                }
            }
            this.f3411c = null;
        }
        return i;
    }

    /* renamed from: a */
    protected final synchronized ae m4423a(int i) {
        ae aeVar = null;
        synchronized (this) {
            if (this.f3410b != null) {
                synchronized (this) {
                    this.f3411c = this.f3410b.m4326b();
                    if (this.f3411c == null) {
                    } else {
                        ae aeVar2;
                        try {
                            this.f3409a = new RandomAccessFile(this.f3411c, "rw");
                            BitSet b = m4421b();
                            if (b == null) {
                                this.f3411c.delete();
                                if (this.f3409a != null) {
                                    try {
                                        this.f3409a.close();
                                    } catch (IOException e) {
                                    }
                                }
                            } else {
                                int a = m4419a(b);
                                aeVar2 = new ae(this.f3411c, m4420a(a, m4418a(a, (int) this.f3411c.length(), i)), new int[]{((a - this.f3410b.m4323a()) - 4) / 1500, ((r2 - this.f3410b.m4323a()) - 4) / 1500});
                                if (this.f3409a != null) {
                                    try {
                                        this.f3409a.close();
                                    } catch (IOException e2) {
                                    }
                                }
                                if (aeVar2.m4308c() > 100 || aeVar2.m4308c() >= 5242880) {
                                    this.f3411c.delete();
                                    this.f3411c = null;
                                } else {
                                    aeVar = aeVar2;
                                }
                            }
                        } catch (FileNotFoundException e3) {
                            if (this.f3409a != null) {
                                try {
                                    this.f3409a.close();
                                    aeVar2 = null;
                                } catch (IOException e4) {
                                    aeVar2 = null;
                                    if (aeVar2.m4308c() > 100) {
                                    }
                                    this.f3411c.delete();
                                    this.f3411c = null;
                                    return aeVar;
                                }
                            }
                            aeVar2 = null;
                        } catch (OutOfMemoryError e5) {
                            if (this.f3409a != null) {
                                try {
                                    this.f3409a.close();
                                } catch (IOException e6) {
                                }
                            }
                            this.f3411c.delete();
                            this.f3411c = null;
                            aeVar2 = null;
                        } catch (Throwable th) {
                            if (this.f3409a != null) {
                                try {
                                    this.f3409a.close();
                                } catch (IOException e7) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return aeVar;
    }

    /* renamed from: a */
    protected final synchronized void m4424a(ae aeVar) {
        BitSet bitSet = null;
        synchronized (this) {
            synchronized (this) {
                this.f3411c = aeVar.f3314a;
                if (this.f3411c == null) {
                } else {
                    try {
                        this.f3409a = new RandomAccessFile(this.f3411c, "rw");
                        byte[] bArr = new byte[this.f3410b.m4323a()];
                        this.f3409a.read(bArr);
                        bitSet = af.m4316b(bArr);
                        if (aeVar.m4307b()) {
                            for (int i = aeVar.f3315b[0]; i <= aeVar.f3315b[1]; i++) {
                                bitSet.set(i, false);
                            }
                            this.f3409a.seek(0);
                            this.f3409a.write(af.m4313a(bitSet));
                        }
                        if (this.f3409a != null) {
                            try {
                                this.f3409a.close();
                            } catch (IOException e) {
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        if (this.f3409a != null) {
                            try {
                                this.f3409a.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (IOException e4) {
                        if (this.f3409a != null) {
                            try {
                                this.f3409a.close();
                            } catch (IOException e5) {
                            }
                        }
                    } catch (Throwable th) {
                        if (this.f3409a != null) {
                            try {
                                this.f3409a.close();
                            } catch (IOException e6) {
                            }
                        }
                    }
                    if (bitSet.isEmpty()) {
                        this.f3411c.delete();
                    }
                    this.f3411c = null;
                }
            }
        }
        return;
    }
}
