package com.amap.api.services.busline;

import com.amap.api.services.core.C0480e;

public class BusLineQuery {
    /* renamed from: a */
    private String f2861a;
    /* renamed from: b */
    private String f2862b;
    /* renamed from: c */
    private int f2863c = 10;
    /* renamed from: d */
    private int f2864d = 0;
    /* renamed from: e */
    private SearchType f2865e;

    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f2861a = str;
        this.f2865e = searchType;
        this.f2862b = str2;
        if (!m3969a()) {
            throw new IllegalArgumentException("Empty query");
        }
    }

    /* renamed from: a */
    private boolean m3969a() {
        return !C0480e.m4020a(this.f2861a);
    }

    public SearchType getCategory() {
        return this.f2865e;
    }

    public String getQueryString() {
        return this.f2861a;
    }

    public void setQueryString(String str) {
        this.f2861a = str;
    }

    public String getCity() {
        return this.f2862b;
    }

    public void setCity(String str) {
        this.f2862b = str;
    }

    public int getPageSize() {
        return this.f2863c;
    }

    public void setPageSize(int i) {
        this.f2863c = i;
    }

    public int getPageNumber() {
        return this.f2864d;
    }

    public void setPageNumber(int i) {
        this.f2864d = i;
    }

    public void setCategory(SearchType searchType) {
        this.f2865e = searchType;
    }

    protected BusLineQuery clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f2861a, this.f2865e, this.f2862b);
        busLineQuery.setPageNumber(this.f2864d);
        busLineQuery.setPageSize(this.f2863c);
        return busLineQuery;
    }

    protected boolean weakEquals(BusLineQuery busLineQuery) {
        if (busLineQuery.getQueryString().equals(this.f2861a) && busLineQuery.getCity().equals(this.f2862b) && busLineQuery.getPageSize() == this.f2863c && busLineQuery.getCategory().compareTo(this.f2865e) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f2862b == null ? 0 : this.f2862b.hashCode()) + (((this.f2865e == null ? 0 : this.f2865e.hashCode()) + 31) * 31)) * 31) + this.f2864d) * 31) + this.f2863c) * 31;
        if (this.f2861a != null) {
            i = this.f2861a.hashCode();
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
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.f2865e != busLineQuery.f2865e) {
            return false;
        }
        if (this.f2862b == null) {
            if (busLineQuery.f2862b != null) {
                return false;
            }
        } else if (!this.f2862b.equals(busLineQuery.f2862b)) {
            return false;
        }
        if (this.f2864d != busLineQuery.f2864d) {
            return false;
        }
        if (this.f2863c != busLineQuery.f2863c) {
            return false;
        }
        if (this.f2861a == null) {
            if (busLineQuery.f2861a != null) {
                return false;
            }
            return true;
        } else if (this.f2861a.equals(busLineQuery.f2861a)) {
            return true;
        } else {
            return false;
        }
    }
}
