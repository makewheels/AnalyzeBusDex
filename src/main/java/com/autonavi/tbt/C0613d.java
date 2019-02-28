package com.autonavi.tbt;

import android.content.Context;
import com.amap.api.navi.C0457h;

/* compiled from: TBTTask */
/* renamed from: com.autonavi.tbt.d */
public class C0613d extends C0597a {
    public C0613d(C0457h c0457h, Context context, String str, int i, String str2, int i2, int i3, byte[] bArr, int i4) {
        super(c0457h, context, str, i, str2, i2, i3, bArr, i4);
    }

    /* renamed from: a */
    public void mo737a() {
        try {
            byte[] b = m4654b();
            if (this.a != null) {
                this.a.f2746a.receiveNetData(this.e, this.f, b, b.length);
                this.a.f2746a.setNetRequestState(this.e, this.f, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (this.a != null) {
                this.a.f2746a.setNetRequestState(this.e, this.f, 2);
            }
        }
    }
}
