package com.amap.api.services.poisearch;

import com.amap.api.services.core.C0493r;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch.Query;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import java.util.ArrayList;
import java.util.List;

public final class PoiResult {
    /* renamed from: a */
    private int f3113a;
    /* renamed from: b */
    private ArrayList<PoiItem> f3114b;
    /* renamed from: c */
    private C0493r f3115c;

    /* renamed from: a */
    static PoiResult m4147a(C0493r c0493r, ArrayList<PoiItem> arrayList) {
        return new PoiResult(c0493r, arrayList);
    }

    private PoiResult(C0493r c0493r, ArrayList<PoiItem> arrayList) {
        this.f3115c = c0493r;
        this.f3113a = m4146a(c0493r.m4112b());
        this.f3114b = arrayList;
    }

    public int getPageCount() {
        return this.f3113a;
    }

    public Query getQuery() {
        return this.f3115c.m4114c();
    }

    public SearchBound getBound() {
        return this.f3115c.m4115d();
    }

    public ArrayList<PoiItem> getPois() {
        return this.f3114b;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f3115c.m4116e();
    }

    public List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f3115c.m4117f();
    }

    /* renamed from: a */
    private int m4146a(int i) {
        int a = this.f3115c.mo657a();
        a = ((i + a) - 1) / a;
        if (a > 30) {
            return 30;
        }
        return a;
    }
}
