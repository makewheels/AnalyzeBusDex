package com.amap.api.services.busline;

import com.amap.api.services.core.C0480e;

public class BusStationQuery {
    /* renamed from: a */
    private String f2885a;
    /* renamed from: b */
    private String f2886b;
    /* renamed from: c */
    private int f2887c = 10;
    /* renamed from: d */
    private int f2888d = 0;

    public BusStationQuery(String str, String str2) {
        this.f2885a = str;
        this.f2886b = str2;
        if (!m3977a()) {
            throw new IllegalArgumentException("Empty query");
        }
    }

    /* renamed from: a */
    private boolean m3977a() {
        return !C0480e.m4020a(this.f2885a);
    }

    public String getQueryString() {
        return this.f2885a;
    }

    public String getCity() {
        return this.f2886b;
    }

    public int getPageSize() {
        return this.f2887c;
    }

    public int getPageNumber() {
        return this.f2888d;
    }

    public void setQueryString(String str) {
        this.f2885a = str;
    }

    public void setCity(String str) {
        this.f2886b = str;
    }

    public void setPageSize(int i) {
        int i2 = 20;
        if (i <= 20) {
            i2 = i;
        }
        if (i2 <= 0) {
            i2 = 10;
        }
        this.f2887c = i2;
    }

    public void setPageNumber(int i) {
        this.f2888d = i;
    }

    protected BusStationQuery clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f2885a, this.f2886b);
        busStationQuery.setPageNumber(this.f2888d);
        busStationQuery.setPageSize(this.f2887c);
        return busStationQuery;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f2886b == null ? 0 : this.f2886b.hashCode()) + 31) * 31) + this.f2888d) * 31) + this.f2887c) * 31;
        if (this.f2885a != null) {
            i = this.f2885a.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BusStationQuery busStationQuery = (BusStationQuery) obj;
        if (this.f2886b == null) {
            if (busStationQuery.f2886b != null) {
                return false;
            }
        } else if (!this.f2886b.equals(busStationQuery.f2886b)) {
            return false;
        }
        if (this.f2888d != busStationQuery.f2888d) {
            return false;
        }
        if (this.f2887c != busStationQuery.f2887c) {
            return false;
        }
        if (this.f2885a == null) {
            if (busStationQuery.f2885a != null) {
                return false;
            }
            return true;
        } else if (this.f2885a.equals(busStationQuery.f2885a)) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        if (this.f2886b == null) {
            if (busStationQuery.f2886b != null) {
                return false;
            }
        } else if (!this.f2886b.equals(busStationQuery.f2886b)) {
            return false;
        }
        if (this.f2887c != busStationQuery.f2887c) {
            return false;
        }
        if (this.f2885a == null) {
            if (busStationQuery.f2885a != null) {
                return false;
            }
            return true;
        } else if (this.f2885a.equals(busStationQuery.f2885a)) {
            return true;
        } else {
            return false;
        }
    }
}
