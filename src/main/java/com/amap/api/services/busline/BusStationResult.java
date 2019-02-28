package com.amap.api.services.busline;

import com.amap.api.services.core.C0478c;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

public final class BusStationResult {
    /* renamed from: a */
    private int f2889a;
    /* renamed from: b */
    private ArrayList<BusStationItem> f2890b;
    /* renamed from: c */
    private BusStationQuery f2891c;
    /* renamed from: d */
    private List<String> f2892d;
    /* renamed from: e */
    private List<SuggestionCity> f2893e;

    /* renamed from: a */
    static BusStationResult m3979a(C0478c c0478c, ArrayList<?> arrayList) {
        return new BusStationResult(c0478c, arrayList);
    }

    private BusStationResult(C0478c c0478c, ArrayList<?> arrayList) {
        this.f2891c = (BusStationQuery) c0478c.mo657a();
        this.f2889a = m3978a(c0478c.m3996b());
        this.f2893e = c0478c.m3998d();
        this.f2892d = c0478c.m3997c();
        this.f2890b = arrayList;
    }

    /* renamed from: a */
    private int m3978a(int i) {
        int pageSize = this.f2891c.getPageSize();
        pageSize = ((i + pageSize) - 1) / pageSize;
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public int getPageCount() {
        return this.f2889a;
    }

    public BusStationQuery getQuery() {
        return this.f2891c;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f2892d;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.f2893e;
    }

    public List<BusStationItem> getBusStations() {
        return this.f2890b;
    }
}
