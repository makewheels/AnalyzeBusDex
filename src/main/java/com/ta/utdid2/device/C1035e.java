package com.ta.utdid2.device;

import com.ta.utdid2.p037b.p038a.C1010a;
import com.ta.utdid2.p037b.p038a.C1014b;
import com.ta.utdid2.p037b.p038a.C1020h;

/* compiled from: UTUtdidHelper2 */
/* renamed from: com.ta.utdid2.device.e */
public final class C1035e {
    /* renamed from: a */
    private String f4762a;

    public C1035e() {
        this.f4762a = "XwYp8WL8bm6S4wu6yEYmLGy4RRRdJDIhxCBdk3CiNZTwGoj1bScVZEeVp9vBiiIsgwDtqZHP8QLoFM6o6MRYjW8QqyrZBI654mqoUk5SOLDyzordzOU5QhYguEJh54q3K1KqMEXpdEQJJjs1Urqjm2s4jgPfCZ4hMuIjAMRrEQluA7FeoqWMJOwghcLcPVleQ8PLzAcaKidybmwhvNAxIyKRpbZlcDjNCcUvsJYvyzEA9VUIaHkIAJ62lpA3EE3H";
        this.f4762a = C1014b.m7372a(this.f4762a.getBytes(), 0);
    }

    /* renamed from: a */
    public final String m7470a(String str) {
        return C1010a.m7368b(this.f4762a, str);
    }

    /* renamed from: b */
    public final String m7471b(String str) {
        String b = C1010a.m7368b(this.f4762a, str);
        if (C1020h.m7383a(b)) {
            return null;
        }
        try {
            return new String(C1014b.m7373a(b));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
