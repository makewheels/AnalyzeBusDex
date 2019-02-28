package com.autonavi.tbt;

import android.content.Context;
import com.amap.api.navi.C0457h;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: BaseTask */
/* renamed from: com.autonavi.tbt.a */
public class C0597a extends ba {
    /* renamed from: j */
    public static int f3663j = 30000;
    /* renamed from: k */
    public static int f3664k = 30000;
    /* renamed from: a */
    public C0457h f3665a;
    /* renamed from: b */
    String f3666b = null;
    /* renamed from: c */
    int f3667c = 0;
    /* renamed from: d */
    String f3668d = null;
    /* renamed from: e */
    int f3669e = 0;
    /* renamed from: f */
    int f3670f = 0;
    /* renamed from: g */
    byte[] f3671g = null;
    /* renamed from: h */
    at f3672h = null;
    /* renamed from: i */
    Context f3673i = null;

    public C0597a(C0457h c0457h, Context context, String str, int i, String str2, int i2, int i3, byte[] bArr, int i4) {
        this.f3665a = c0457h;
        this.f3666b = str;
        this.f3667c = i;
        this.f3668d = str2;
        this.f3669e = i2;
        this.f3670f = i3;
        this.f3671g = bArr;
        this.f3672h = at.m4778a(false);
        this.f3673i = context;
    }

    /* renamed from: a */
    public void mo737a() {
    }

    /* renamed from: b */
    public byte[] m4654b() {
        Map hashMap = new HashMap();
        au c0612c = new C0612c();
        c0612c.m4791a(f3663j);
        c0612c.m4794b(f3664k);
        try {
            if (this.f3667c == 0) {
                hashMap.clear();
                if (this.f3668d != null) {
                    String[] split = this.f3668d.split("\n");
                    if (split != null && split.length > 1) {
                        String[] split2 = split[0].split(":");
                        if (split2 != null && split2.length > 1) {
                            hashMap.put(split2[0], split2[1]);
                        }
                        split = split[1].split(":");
                        if (split != null && split.length > 1) {
                            hashMap.put(split[0], split[1]);
                        }
                    }
                }
                c0612c.m4818a(hashMap);
                c0612c.m4817a(this.f3666b);
                c0612c.m4792a(C0626o.m4923a(this.f3673i));
                c0612c.m4819a(new ByteArrayEntity(this.f3671g));
                return this.f3672h.m4788a(c0612c);
            }
            c0612c.m4817a(this.f3666b);
            c0612c.m4792a(C0626o.m4923a(this.f3673i));
            return this.f3672h.m4789b(c0612c);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
