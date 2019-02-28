package com.amap.api.services.core;

public class SuggestionCity {
    /* renamed from: a */
    private String f2927a;
    /* renamed from: b */
    private String f2928b;
    /* renamed from: c */
    private String f2929c;
    /* renamed from: d */
    private int f2930d;

    protected SuggestionCity() {
    }

    public SuggestionCity(String str, String str2, String str3, int i) {
        this.f2927a = str;
        this.f2928b = str2;
        this.f2929c = str3;
        this.f2930d = i;
    }

    public String getCityName() {
        return this.f2927a;
    }

    public void setCityName(String str) {
        this.f2927a = str;
    }

    public String getCityCode() {
        return this.f2928b;
    }

    public void setCityCode(String str) {
        this.f2928b = str;
    }

    public String getAdCode() {
        return this.f2929c;
    }

    public void setAdCode(String str) {
        this.f2929c = str;
    }

    public int getSuggestionNum() {
        return this.f2930d;
    }

    public void setSuggestionNum(int i) {
        this.f2930d = i;
    }
}
