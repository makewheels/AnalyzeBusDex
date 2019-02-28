package com.autonavi.amap.mapcore;

import java.util.ArrayList;
import java.util.Hashtable;

public class VTMCDataCache {
    public static final int MAXSIZE = 500;
    public static final int MAX_EXPIREDTIME = 10;
    private static volatile VTMCDataCache instance;
    static Hashtable<String, C0595e> vtmcHs = new Hashtable();
    static ArrayList<String> vtmcList = new ArrayList();

    public static VTMCDataCache getInstance() {
        if (instance == null) {
            instance = new VTMCDataCache();
        }
        return instance;
    }

    public void reset() {
        vtmcHs.clear();
    }

    public C0595e GetData(String str) {
        C0595e c0595e = (C0595e) vtmcHs.get(str);
        if (c0595e == null) {
            return null;
        }
        if (((int) (System.currentTimeMillis() / 1000)) - c0595e.f3647c > 10) {
            return null;
        }
        return c0595e;
    }

    public void putData(String str, byte[] bArr) {
        C0595e c0595e = new C0595e(str, bArr);
        if (vtmcList.size() > MAXSIZE) {
            vtmcHs.remove(vtmcList.get(0));
            vtmcList.remove(0);
        }
        vtmcHs.put(str, c0595e);
        vtmcList.add(str);
    }
}
