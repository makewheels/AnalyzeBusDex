package com.amap.api.p015a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.amap.api.maps2d.AMapException;
import com.amap.api.p015a.C0253m.C0252a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TileServerHandler */
/* renamed from: com.amap.api.a.bx */
class bx extends bn<ArrayList<C0252a>, ArrayList<C0252a>> {
    /* renamed from: i */
    private as f963i = null;

    /* renamed from: a */
    protected /* synthetic */ Object mo229a(InputStream inputStream) throws AMapException {
        return mo232b(inputStream);
    }

    /* renamed from: e */
    protected /* synthetic */ Object mo233e() {
        return mo234f();
    }

    public bx(ArrayList<C0252a> arrayList, Proxy proxy, String str, String str2) {
        super(arrayList, proxy, str, str2);
    }

    /* renamed from: a */
    public void m1569a(as asVar) {
        this.f963i = asVar;
    }

    /* renamed from: f */
    protected ArrayList<C0252a> mo234f() {
        ArrayList<C0252a> arrayList = new ArrayList();
        Iterator it = ((ArrayList) this.b).iterator();
        while (it.hasNext()) {
            arrayList.add(new C0252a((C0252a) it.next()));
        }
        return arrayList;
    }

    /* renamed from: b */
    protected ArrayList<C0252a> mo232b(InputStream inputStream) throws AMapException {
        ArrayList<C0252a> arrayList = null;
        if (this.b != null) {
            int size = ((ArrayList) this.b).size();
            int i = 0;
            while (i < size) {
                C0252a c0252a = (C0252a) ((ArrayList) this.b).get(i);
                if (m1567a(inputStream, c0252a) < 0) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(new C0252a(c0252a));
                }
                i++;
                arrayList = arrayList;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new AMapException("IO 操作异常 - IOException");
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    protected String mo231b() {
        return this.f963i.f645j.mo74a(((C0252a) ((ArrayList) this.b).get(0)).f1046b, ((C0252a) ((ArrayList) this.b).get(0)).f1047c, ((C0252a) ((ArrayList) this.b).get(0)).f1048d);
    }

    /* renamed from: a */
    public int m1567a(InputStream inputStream, C0252a c0252a) {
        if (c0252a == null || inputStream == null) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0252a.f1046b);
        stringBuilder.append("-");
        stringBuilder.append(c0252a.f1047c);
        stringBuilder.append("-");
        stringBuilder.append(c0252a.f1048d);
        if (this.f963i == null || this.f963i.f648m == null) {
            return -1;
        }
        int a = this.f963i.f648m.m1659a(null, inputStream, false, null, stringBuilder.toString());
        if (a < 0) {
            return -1;
        }
        m1565a(c0252a, a);
        if (this.f963i == null || !this.f963i.f642g) {
            return a;
        }
        byte[] a2 = m1566a(this.f963i.f648m.m1660a(a));
        if (this.f963i == null || this.f963i.f649n == null) {
            return a;
        }
        this.f963i.f649n.m1670a(a2, c0252a.f1046b, c0252a.f1047c, c0252a.f1048d);
        return a;
    }

    /* renamed from: a */
    private byte[] m1566a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: a */
    private void m1565a(C0252a c0252a, int i) {
        if (c0252a != null && i >= 0 && this.f963i != null && this.f963i.f650o != null) {
            bq bqVar = this.f963i.f650o;
            int size = bqVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0252a c0252a2 = (C0252a) bqVar.get(i2);
                if (c0252a2 != null && c0252a2.equals(c0252a)) {
                    c0252a2.f1051g = i;
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    protected byte[] mo230a() {
        return null;
    }
}
