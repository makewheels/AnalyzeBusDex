package com.aps;

import java.util.List;
import p054u.aly.bi_常量类;

/* renamed from: com.aps.w */
public final class C0586w {
    /* renamed from: a */
    private boolean f3560a = false;
    /* renamed from: b */
    private String f3561b = bi_常量类.f6358b;
    /* renamed from: c */
    private boolean f3562c = false;
    /* renamed from: d */
    private double f3563d = 0.0d;
    /* renamed from: e */
    private double f3564e = 0.0d;

    protected C0586w(List list, String str, String str2, String str3) {
        this.f3561b = str3;
        m4587d();
    }

    /* renamed from: d */
    private void m4587d() {
        int i;
        boolean z;
        String substring;
        String[] split;
        int i2 = 0;
        String str = this.f3561b;
        if (str != null && str.length() > 8) {
            int i3 = 0;
            for (i = 1; i < str.length() - 3; i++) {
                i3 ^= str.charAt(i);
            }
            if (Integer.toHexString(i3).equalsIgnoreCase(str.substring(str.length() - 2, str.length()))) {
                z = true;
                if (z) {
                    substring = this.f3561b.substring(0, this.f3561b.length() - 3);
                    i = 0;
                    while (i2 < substring.length()) {
                        if (substring.charAt(i2) == ',') {
                            i++;
                        }
                        i2++;
                    }
                    split = substring.split(",", i + 1);
                    if (split.length < 6) {
                        if (!(split[2].equals(bi_常量类.f6358b) || split[split.length - 3].equals(bi_常量类.f6358b) || split[split.length - 2].equals(bi_常量类.f6358b) || split[split.length - 1].equals(bi_常量类.f6358b))) {
                            Integer.valueOf(split[2]).intValue();
                            this.f3563d = Double.valueOf(split[split.length - 3]).doubleValue();
                            this.f3564e = Double.valueOf(split[split.length - 2]).doubleValue();
                            this.f3562c = true;
                        }
                    } else {
                        return;
                    }
                }
                this.f3560a = this.f3562c;
            }
        }
        z = false;
        if (z) {
            substring = this.f3561b.substring(0, this.f3561b.length() - 3);
            i = 0;
            while (i2 < substring.length()) {
                if (substring.charAt(i2) == ',') {
                    i++;
                }
                i2++;
            }
            split = substring.split(",", i + 1);
            if (split.length < 6) {
                Integer.valueOf(split[2]).intValue();
                this.f3563d = Double.valueOf(split[split.length - 3]).doubleValue();
                this.f3564e = Double.valueOf(split[split.length - 2]).doubleValue();
                this.f3562c = true;
            } else {
                return;
            }
        }
        this.f3560a = this.f3562c;
    }

    /* renamed from: a */
    protected final boolean m4588a() {
        return this.f3560a;
    }

    /* renamed from: b */
    protected final double m4589b() {
        return this.f3563d;
    }

    /* renamed from: c */
    protected final double m4590c() {
        return this.f3564e;
    }
}
