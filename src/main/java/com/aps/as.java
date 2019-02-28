package com.aps;

import android.location.GpsSatellite;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import p054u.aly.bi_常量类;

public final class as implements Listener, NmeaListener {
    /* renamed from: a */
    private long f3369a = 0;
    /* renamed from: b */
    private long f3370b = 0;
    /* renamed from: c */
    private boolean f3371c = false;
    /* renamed from: d */
    private List f3372d = new ArrayList();
    /* renamed from: e */
    private String f3373e = null;
    /* renamed from: f */
    private String f3374f = null;
    /* renamed from: g */
    private String f3375g = null;
    /* renamed from: h */
    private /* synthetic */ C0588y f3376h;

    protected as(C0588y c0588y) {
        this.f3376h = c0588y;
    }

    /* renamed from: a */
    public final void m4389a(String str) {
        if (System.currentTimeMillis() - this.f3370b > 400 && this.f3371c && this.f3372d.size() > 0) {
            try {
                C0586w c0586w = new C0586w(this.f3372d, this.f3373e, null, this.f3375g);
                if (c0586w.m4588a()) {
                    this.f3376h.f3606O = C0588y.m4592a(this.f3376h, c0586w, this.f3376h.f3603L);
                    if (this.f3376h.f3606O > 0) {
                        C0588y.m4609b(this.f3376h, String.format(Locale.CHINA, "&nmea=%.1f|%.1f&g_tp=%d", new Object[]{Double.valueOf(c0586w.m4590c()), Double.valueOf(c0586w.m4589b()), Integer.valueOf(this.f3376h.f3606O)}));
                    }
                } else {
                    this.f3376h.f3606O = 0;
                }
            } catch (Exception e) {
                this.f3376h.f3606O = 0;
            }
            this.f3372d.clear();
            this.f3375g = null;
            this.f3374f = null;
            this.f3373e = null;
            this.f3371c = false;
        }
        if (str.startsWith("$GPGGA")) {
            this.f3371c = true;
            this.f3373e = str.trim();
        } else if (str.startsWith("$GPGSV")) {
            this.f3372d.add(str.trim());
        } else if (str.startsWith("$GPGSA")) {
            this.f3375g = str.trim();
        }
        this.f3370b = System.currentTimeMillis();
    }

    public final void onGpsStatusChanged(int i) {
        int i2 = 0;
        try {
            if (this.f3376h.f3615s != null) {
                switch (i) {
                    case 2:
                        this.f3376h.f3605N = 0;
                        return;
                    case 4:
                        if (C0588y.f3582a || System.currentTimeMillis() - this.f3369a >= 10000) {
                            if (this.f3376h.f3601J == null) {
                                this.f3376h.f3601J = this.f3376h.f3615s.getGpsStatus(null);
                            } else {
                                this.f3376h.f3615s.getGpsStatus(this.f3376h.f3601J);
                            }
                            this.f3376h.f3602K = 0;
                            this.f3376h.f3603L = 0;
                            this.f3376h.f3604M = new HashMap();
                            int i3 = 0;
                            int i4 = 0;
                            for (GpsSatellite gpsSatellite : this.f3376h.f3601J.getSatellites()) {
                                i3++;
                                if (gpsSatellite.usedInFix()) {
                                    i4++;
                                }
                                if (gpsSatellite.getSnr() > 0.0f) {
                                    i2++;
                                }
                                if (gpsSatellite.getSnr() >= ((float) C0588y.f3579X)) {
                                    this.f3376h.f3603L = this.f3376h.f3603L + 1;
                                }
                            }
                            if (this.f3376h.f3609m == -1 || ((i4 >= 4 && this.f3376h.f3609m < 4) || (i4 < 4 && this.f3376h.f3609m >= 4))) {
                                this.f3376h.f3609m = i4;
                                if (i4 < 4) {
                                    if (this.f3376h.f3616t != null) {
                                        this.f3376h.f3616t.m4386w();
                                    }
                                } else if (this.f3376h.f3616t != null) {
                                    this.f3376h.f3616t.m4385v();
                                }
                            }
                            this.f3376h.f3605N = i2;
                            this.f3376h.m4593a(this.f3376h.f3604M);
                            if (!C0588y.f3582a) {
                                if ((i4 > 3 || i3 > 15) && StubApp.mark(this.f3376h.f3615s, "gps") != null) {
                                    this.f3369a = System.currentTimeMillis();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Exception e) {
        }
    }

    public final void onNmeaReceived(long j, String str) {
        try {
            if (C0588y.f3582a && str != null && !str.equals(bi_常量类.f6358b_空串) && str.length() >= 9 && str.length() <= 150) {
                this.f3376h.f3597F.sendMessage(this.f3376h.f3597F.obtainMessage(1, str));
            }
        } catch (Exception e) {
        }
    }
}
