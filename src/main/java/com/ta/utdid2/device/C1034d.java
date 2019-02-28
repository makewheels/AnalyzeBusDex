package com.ta.utdid2.device;

import com.ta.utdid2.p037b.p038a.C1010a;
import com.ta.utdid2.p037b.p038a.C1014b;
import java.util.Random;

/* compiled from: UTUtdidHelper */
/* renamed from: com.ta.utdid2.device.d */
public final class C1034d {
    /* renamed from: b */
    private static Random f4760b = new Random();
    /* renamed from: a */
    private String f4761a;

    public C1034d() {
        this.f4761a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.f4761a = C1014b.m7372a(this.f4761a.getBytes(), 2);
    }

    /* renamed from: a */
    public final String m7468a(byte[] bArr) {
        return C1010a.m7366a(this.f4761a, C1014b.m7372a(bArr, 2));
    }

    /* renamed from: a */
    public final String m7467a(String str) {
        return C1010a.m7366a(this.f4761a, str);
    }

    /* renamed from: b */
    public final String m7469b(String str) {
        return C1010a.m7368b(this.f4761a, str);
    }
}
