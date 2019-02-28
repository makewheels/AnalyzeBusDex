package com.amap.api.services.busline;

import com.amap.api.services.core.C0478c;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

public final class BusLineResult {
    /* renamed from: a */
    private int f2866a;
    /* renamed from: b */
    private ArrayList<BusLineItem> f2867b;
    /* renamed from: c */
    private BusLineQuery f2868c;
    /* renamed from: d */
    private List<String> f2869d;
    /* renamed from: e */
    private List<SuggestionCity> f2870e;

    /* renamed from: a */
    static BusLineResult m3971a(C0478c c0478c, ArrayList<?> arrayList) {
        return new BusLineResult(c0478c, arrayList);
    }

    private BusLineResult(C0478c c0478c, ArrayList<?> arrayList) {
        this.f2868c = (BusLineQuery) c0478c.mo657a();
        this.f2866a = m3970a(c0478c.m3996b());
        this.f2870e = c0478c.m3998d();
        this.f2869d = c0478c.m3997c();
        this.f2867b = arrayList;
    }

    /* renamed from: a */
    private int m3970a(int i) {
        int pageSize = this.f2868c.getPageSize();
        pageSize = ((i + pageSize) - 1) / pageSize;
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public int getPageCount() {
        return this.f2866a;
    }

    public BusLineQuery getQuery() {
        return this.f2868c;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f2869d;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.f2870e;
    }

    public List<BusLineItem> getBusLines() {
        return this.f2867b;
    }
}
