package com.tencent.wxop.stat;

import p054u.aly.bi_常量类;

public class StatGameUser implements Cloneable {
    /* renamed from: a */
    private String f5254a = bi_常量类.f6358b;
    /* renamed from: b */
    private String f5255b = bi_常量类.f6358b;
    /* renamed from: c */
    private String f5256c = bi_常量类.f6358b;

    public StatGameUser(String str, String str2, String str3) {
        this.f5255b = str;
        this.f5254a = str2;
        this.f5256c = str3;
    }

    public StatGameUser clone() {
        try {
            return (StatGameUser) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getAccount() {
        return this.f5255b;
    }

    public String getLevel() {
        return this.f5256c;
    }

    public String getWorldName() {
        return this.f5254a;
    }

    public void setAccount(String str) {
        this.f5255b = str;
    }

    public void setLevel(String str) {
        this.f5256c = str;
    }

    public void setWorldName(String str) {
        this.f5254a = str;
    }

    public String toString() {
        return "StatGameUser [worldName=" + this.f5254a + ", account=" + this.f5255b + ", level=" + this.f5256c + "]";
    }
}
