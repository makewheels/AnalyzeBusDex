package com.aps;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.telephony.CellLocation;
import java.util.List;

public final class aw {
    /* renamed from: c */
    private static int f3390c = 10;
    /* renamed from: d */
    private static int f3391d = 100;
    /* renamed from: f */
    private static float f3392f = 0.5f;
    /* renamed from: a */
    protected ba f3393a = new ba(this);
    /* renamed from: b */
    protected ax f3394b = new ax(this);
    /* renamed from: e */
    private ai f3395e;

    protected aw(ai aiVar) {
        this.f3395e = aiVar;
    }

    /* renamed from: a */
    protected static void m4408a() {
    }

    /* renamed from: a */
    protected static void m4409a(int i) {
        f3390c = i;
    }

    /* renamed from: b */
    protected static void m4410b(int i) {
        f3391d = i;
    }

    /* renamed from: a */
    protected final boolean m4411a(Location location) {
        boolean z = false;
        if (this.f3395e != null) {
            List j = this.f3395e.m4373j();
            if (!(j == null || location == null)) {
                "cell.list.size: " + j.size();
                ay ayVar = null;
                if (j.size() >= 2) {
                    ay ayVar2 = new ay((CellLocation) j.get(1));
                    if (this.f3394b.f3397b == null) {
                        ayVar = ayVar2;
                        z = true;
                    } else {
                        boolean z2 = location.distanceTo(this.f3394b.f3397b) > ((float) f3391d);
                        if (!z2) {
                            int i;
                            ayVar = this.f3394b.f3396a;
                            if (ayVar2.f3402e == ayVar.f3402e && ayVar2.f3401d == ayVar.f3401d && ayVar2.f3400c == ayVar.f3400c && ayVar2.f3399b == ayVar.f3399b && ayVar2.f3398a == ayVar.f3398a) {
                                i = 1;
                            } else {
                                z2 = false;
                            }
                            z2 = i == 0;
                        }
                        "collect cell?: " + z2;
                        z = z2;
                        ayVar = ayVar2;
                    }
                }
                if (z) {
                    this.f3394b.f3396a = ayVar;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    protected final boolean m4412b(Location location) {
        int i = 0;
        if (this.f3395e == null) {
            return false;
        }
        boolean z;
        List list;
        List k = this.f3395e.m4374k();
        if (k.size() >= 2) {
            List list2 = (List) k.get(1);
            if (this.f3393a.f3407b == null) {
                z = true;
            } else if (list2 == null || list2.size() <= 0) {
                list = list2;
                z = false;
            } else {
                z = location.distanceTo(this.f3393a.f3407b) > ((float) f3390c);
                if (z) {
                    list = list2;
                } else {
                    int i2;
                    List list3 = this.f3393a.f3406a;
                    float f = f3392f;
                    if (list2 == null || list3 == null) {
                        i2 = 0;
                    } else if (list2 == null || list3 == null) {
                        i2 = 0;
                    } else {
                        int size = list2.size();
                        int size2 = list3.size();
                        float f2 = (float) (size + size2);
                        if (size == 0 && size2 == 0) {
                            i2 = 1;
                        } else if (size == 0 || size2 == 0) {
                            i2 = 0;
                        } else {
                            int i3 = 0;
                            int i4 = 0;
                            while (i3 < size) {
                                String str = ((ScanResult) list2.get(i3)).BSSID;
                                if (str != null) {
                                    for (int i5 = 0; i5 < size2; i5++) {
                                        if (str.equals(((az) list3.get(i5)).f3403a)) {
                                            i2 = i4 + 1;
                                            break;
                                        }
                                    }
                                }
                                i2 = i4;
                                i3++;
                                i4 = i2;
                            }
                            i2 = ((float) (i4 << 1)) >= f2 * f ? 1 : 0;
                        }
                    }
                    z = i2 == 0;
                }
            }
            list = list2;
        } else {
            list = null;
            z = false;
        }
        if (z) {
            this.f3393a.f3406a.clear();
            int size3 = list.size();
            while (i < size3) {
                this.f3393a.f3406a.add(new az(((ScanResult) list.get(i)).BSSID));
                i++;
            }
        }
        return z;
    }
}
