package com.amap.api.services.poisearch;

import com.amap.api.services.core.C0476s;
import com.amap.api.services.core.C0480e;
import java.io.InputStream;
import java.net.Proxy;
import p054u.aly.bi_常量类;

public abstract class PoiHandler<T, V> extends C0476s<T, V> {
    public PoiHandler(T t, Proxy proxy) {
        super(t, proxy);
    }

    protected String inputStream2String(InputStream inputStream) {
        try {
            return new String(C0480e.m4021a(inputStream), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected boolean isNullString(String str) {
        if (str == null || str.equals(bi_常量类.f6358b) || str.equals("[]")) {
            return true;
        }
        return false;
    }
}
