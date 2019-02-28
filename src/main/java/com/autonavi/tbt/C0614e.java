package com.autonavi.tbt;

import android.content.Context;
import com.amap.api.navi.C0457h;

/* compiled from: WalkTBTTask */
/* renamed from: com.autonavi.tbt.e */
public class C0614e extends C0597a {
    /* renamed from: l */
    String f3784l = null;

    public C0614e(C0457h c0457h, Context context, String str, int i, String str2, int i2, int i3, byte[] bArr, int i4) {
        super(c0457h, context, str, i, str2, i2, i3, bArr, i4);
    }

    /* renamed from: a */
    public void mo737a() {
        try {
            byte[] b = m4654b();
            if (this.a != null) {
                this.a.f2747b.receiveNetData(this.e, this.f, b, b.length);
                this.a.f2747b.setNetRequestState(this.e, this.f, 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (this.a != null) {
                this.a.f2747b.setNetRequestState(this.e, this.f, 2);
            }
        }
    }
}
