package com.amap.api.p015a;

import java.util.Random;
import p054u.aly.bi_常量类;

/* compiled from: MapServerUrl */
/* renamed from: com.amap.api.a.bd */
public class bd {
    /* renamed from: g */
    private static bd f780g;
    /* renamed from: a */
    private String f781a = "http://wprd01.is.autonavi.com";
    /* renamed from: b */
    private String f782b = "http://tm.mapabc.com";
    /* renamed from: c */
    private String f783c = "http://restapi.amap.com";
    /* renamed from: d */
    private String f784d = "http://ds.mapabc.com:8888";
    /* renamed from: e */
    private String f785e = "http://mst01.is.autonavi.com";
    /* renamed from: f */
    private String f786f = "http://tmds.mapabc.com";

    private bd() {
    }

    /* renamed from: a */
    public static synchronized bd m1300a() {
        bd bdVar;
        synchronized (bd.class) {
            if (f780g == null) {
                f780g = new bd();
            }
            bdVar = f780g;
        }
        return bdVar;
    }

    /* renamed from: b */
    public String m1301b() {
        String str = bi_常量类.f6358b_空串;
        switch (new Random(System.currentTimeMillis()).nextInt(100000) % 4) {
            case 0:
                if (C0269x.f1186g != 2) {
                    str = "http://webrd01.is.autonavi.com";
                    break;
                }
                str = "http://wprd01.is.autonavi.com";
                break;
            case 1:
                if (C0269x.f1186g != 2) {
                    str = "http://webrd02.is.autonavi.com";
                    break;
                }
                str = "http://wprd02.is.autonavi.com";
                break;
            case 2:
                if (C0269x.f1186g != 2) {
                    str = "http://webrd03.is.autonavi.com";
                    break;
                }
                str = "http://wprd03.is.autonavi.com";
                break;
            case 3:
                if (C0269x.f1186g != 2) {
                    str = "http://webrd04.is.autonavi.com";
                    break;
                }
                str = "http://wprd04.is.autonavi.com";
                break;
        }
        this.f781a = str;
        return this.f781a;
    }

    /* renamed from: c */
    public String m1302c() {
        return this.f782b;
    }

    /* renamed from: d */
    public String m1303d() {
        String str = bi_常量类.f6358b_空串;
        switch (new Random(System.currentTimeMillis()).nextInt(100000) % 4) {
            case 0:
                str = "http://mst01.is.autonavi.com";
                break;
            case 1:
                str = "http://mst02.is.autonavi.com";
                break;
            case 2:
                str = "http://mst03.is.autonavi.com";
                break;
            case 3:
                str = "http://mst04.is.autonavi.com";
                break;
        }
        this.f785e = str;
        return this.f785e;
    }
}
